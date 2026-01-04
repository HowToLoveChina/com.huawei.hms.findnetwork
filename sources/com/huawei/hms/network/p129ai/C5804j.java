package com.huawei.hms.network.p129ai;

import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.network.conf.api.ConfigAPI;
import com.huawei.hms.network.httpclient.okhttp.OkHttpClientGlobal;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.huawei.hms.network.ai.j */
/* loaded from: classes8.dex */
public class C5804j {

    /* renamed from: a */
    public static final String f25904a = "ReportDataUtils";

    /* renamed from: b */
    public static final String f25905b = "ai";

    /* renamed from: c */
    public static final String f25906c = "connect_pool_size";

    /* renamed from: d */
    public static final String f25907d = "request_accuracy";

    /* renamed from: e */
    public static final String f25908e = "dns_accuracy";

    /* renamed from: f */
    public static final String f25909f = "connect_count";

    /* renamed from: g */
    public static final String f25910g = "dns_count";

    /* renamed from: h */
    public static final String f25911h = "model_type";

    /* renamed from: i */
    public static final String f25912i = "config_version";

    /* renamed from: j */
    public static final String f25913j = "core_configversion";

    /* renamed from: k */
    public static final String f25914k = "real_request_accuracy";

    /* renamed from: l */
    public static final String f25915l = "domain_accuracy";

    /* renamed from: m */
    public static final String f25916m = "sorted_ip";

    /* renamed from: n */
    public static final String f25917n = "dif_connect_time";

    /* renamed from: o */
    public static final String f25918o = "prediction_result";

    /* renamed from: p */
    public static final String f25919p = "prediction_time";

    /* renamed from: com.huawei.hms.network.ai.j$a */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Map f25920a;

        public a(Map map) {
            this.f25920a = map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("sdk_type", "UxPP");
            linkedHashMap.put(HianalyticsBaseData.SDK_NAME, "networkkit");
            linkedHashMap.put("sdk_version", "8.0.1.309");
            linkedHashMap.put(C5804j.f25906c, String.valueOf(OkHttpClientGlobal.getInstance().getMaxIdleConnections()));
            linkedHashMap.put("config_version", String.valueOf(ConfigAPI.getValue("core_configversion")));
            for (Map.Entry entry : this.f25920a.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
            HianalyticsHelper.getInstance().onEvent(linkedHashMap, "ai");
            Logger.m32144v(C5804j.f25904a, "%s", linkedHashMap);
        }
    }

    /* renamed from: a */
    public static void m33379a(Map<String, String> map) {
        if (HianalyticsHelper.getInstance().isEnableReport(ContextHolder.getAppContext())) {
            if (map == null) {
                Logger.m32141i(f25904a, "the accuracy data has error! reportInfo = null");
            } else {
                HianalyticsHelper.getInstance().getReportExecutor().execute(new a(map));
            }
        }
    }
}
