package com.huawei.hianalytics.framework;

import android.text.TextUtils;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.core.storage.Event;
import com.huawei.hianalytics.core.storage.IStorageHandler;
import com.huawei.hianalytics.core.transport.TransportHandlerFactory;
import com.huawei.hianalytics.framework.config.ICollectorConfig;
import com.huawei.hianalytics.framework.config.IMandatoryParameters;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import gu.C10048b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.hianalytics.framework.f */
/* loaded from: classes5.dex */
public class RunnableC4759f implements Runnable {

    /* renamed from: a */
    public final byte[] f21766a;

    /* renamed from: b */
    public final String f21767b;

    /* renamed from: c */
    public final String f21768c;

    /* renamed from: d */
    public final String f21769d;

    /* renamed from: e */
    public final List<Event> f21770e;

    /* renamed from: f */
    public boolean f21771f;

    public RunnableC4759f(byte[] bArr, String str, String str2, String str3, List<Event> list) {
        this.f21767b = str;
        this.f21769d = str2;
        this.f21766a = bArr;
        this.f21768c = str3;
        this.f21770e = list;
    }

    /* renamed from: a */
    public final String m28856a(IMandatoryParameters iMandatoryParameters) {
        String debugModeUrl = iMandatoryParameters.getDebugModeUrl();
        if (TextUtils.isEmpty(debugModeUrl) || ".none.".equals(debugModeUrl)) {
            HiLog.m28810si("DebugReportTask", "debug mode url is empty");
            return debugModeUrl;
        }
        String str = this.f21769d;
        str.hashCode();
        return (!str.equals("maint") ? "{url}/common/hmshioperqrt" : "{url}/common/hmshimaintqrt").replace("{url}", debugModeUrl);
    }

    @Override // java.lang.Runnable
    public void run() {
        List<Event> list;
        byte[] bArr = this.f21766a;
        if (bArr == null || bArr.length == 0) {
            HiLog.m28811sw("DebugReportTask", "body is empty, tag: " + this.f21767b + ", type: " + this.f21769d);
            return;
        }
        String str = this.f21768c;
        C4757d c4757d = C4757d.f21744e;
        IMandatoryParameters iMandatoryParameters = c4757d.f21745a;
        if (TextUtils.isEmpty(m28856a(iMandatoryParameters)) || ".none.".equals(m28856a(iMandatoryParameters))) {
            HiLog.m28811sw("DebugReportTask", "no address, tag: " + this.f21767b + ", type: " + this.f21769d);
            return;
        }
        String strM28856a = m28856a(iMandatoryParameters);
        ICollectorConfig iCollectorConfigM28847a = c4757d.m28847a(this.f21767b);
        ICollectorConfig iCollectorConfigM28847a2 = c4757d.m28847a(this.f21767b);
        String appVer = c4757d.f21745a.getAppVer();
        String model = c4757d.f21745a.getModel();
        HashMap map = new HashMap();
        map.put("x-hasdk-debug", FaqConstants.DISABLE_HA_REPORT);
        map.put("App-Id", iCollectorConfigM28847a2.getAppId());
        map.put("App-Ver", appVer);
        map.put("Sdk-Name", "hianalytics");
        map.put("Sdk-Ver", "3.2.13.500");
        map.put("Device-Type", model);
        map.put("servicetag", this.f21767b);
        HiLog.m28809i("DebugReportTask", "debug send event, reqId : " + str + ", tag: " + this.f21767b + ", type: " + this.f21769d);
        map.put("Request-Id", str);
        Map<String, String> httpHeader = iCollectorConfigM28847a.getHttpHeader(this.f21769d);
        if (httpHeader != null) {
            map.putAll(httpHeader);
        }
        ICollectorConfig iCollectorConfigM28847a3 = c4757d.m28847a(this.f21767b);
        int httpCode = TransportHandlerFactory.create(strM28856a, map, bArr, iCollectorConfigM28847a3 == null ? 1 : iCollectorConfigM28847a3.getMetricPolicy(this.f21769d)).execute().getHttpCode();
        try {
            if (httpCode == 200) {
                if (!this.f21771f) {
                    IStorageHandler iStorageHandlerM28844c = C4755b.m28844c(this.f21767b);
                    if (iStorageHandlerM28844c != null && (list = this.f21770e) != null && list.size() > 0) {
                        iStorageHandlerM28844c.deleteEvents(this.f21770e);
                        IMandatoryParameters iMandatoryParameters2 = c4757d.f21745a;
                        if (iMandatoryParameters2.isFlashKey() && iStorageHandlerM28844c.readEventsAllSize() == 0) {
                            iMandatoryParameters2.refreshKey(C10048b.m62473e(16), 1);
                            iStorageHandlerM28844c.deleteCommonHeaderExAll();
                        }
                    }
                    C4755b.m28833a(this.f21767b).m28855b(this.f21769d);
                }
            } else if (!this.f21771f) {
                C4755b.m28833a(this.f21767b).m28854a(this.f21769d);
            }
            HiLog.m28810si("DebugReportTask", "send debug event tag: " + this.f21769d + ", tag: " + this.f21767b + ", resultCode: " + httpCode + ", reqID: " + str);
        } catch (Throwable th2) {
            HiLog.m28810si("DebugReportTask", "send debug event tag: " + this.f21769d + ", tag: " + this.f21767b + ", resultCode: " + httpCode + ", reqID: " + str);
            throw th2;
        }
    }
}
