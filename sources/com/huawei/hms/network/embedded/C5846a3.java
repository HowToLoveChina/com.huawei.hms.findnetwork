package com.huawei.hms.network.embedded;

import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.framework.common.hianalytics.InitReport;
import com.huawei.hms.network.inner.api.NetworkReceiver;
import java.util.LinkedHashMap;

/* renamed from: com.huawei.hms.network.embedded.a3 */
/* loaded from: classes8.dex */
public class C5846a3 {
    public static final String APP_NAME = "app_name";
    public static final String EVENT_ID = "sysevent";
    public static final String EVENT_TYPE = "sysevent_type";
    public static final String EVENT_VALUE = "sysevent_value";
    public static final String NETSWITCH_EVENT = "netswitch";

    /* renamed from: a */
    public static final String f26333a = "SysEventData";

    /* renamed from: com.huawei.hms.network.embedded.a3$a */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Long f26334a;

        /* renamed from: b */
        public final /* synthetic */ String f26335b;

        /* renamed from: c */
        public final /* synthetic */ String f26336c;

        public a(Long l10, String str, String str2) {
            this.f26334a = l10;
            this.f26335b = str;
            this.f26336c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            C5846a3.m33779b(this.f26334a, this.f26335b, this.f26336c);
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.a3$b */
    public static class b implements NetworkReceiver {

        /* renamed from: a */
        public final NetworkInfo f26337a = NetworkUtil.getNetworkInfo(ContextHolder.getAppContext());

        @Override // com.huawei.hms.network.inner.api.NetworkReceiver
        public void onReceiveMsg(Context context, Intent intent) {
            NetworkInfo networkInfo = NetworkUtil.getNetworkInfo(context);
            if (networkInfo == null) {
                Logger.m32143v(C5846a3.f26333a, "Get NetworkInfo failed");
            } else {
                Logger.m32144v(C5846a3.f26333a, "networkInfo: %s", networkInfo);
                C5846a3.reportNetSwitch(this.f26337a, networkInfo);
            }
        }
    }

    /* renamed from: b */
    public static void m33779b(Long l10, String str, String str2) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("sdk_type", "UxPP");
        linkedHashMap.put(HianalyticsBaseData.SDK_NAME, "networkkit");
        linkedHashMap.put("sdk_version", "8.0.1.309");
        linkedHashMap.put("time", l10 + "");
        linkedHashMap.put(EVENT_TYPE, str);
        linkedHashMap.put(EVENT_VALUE, str2);
        linkedHashMap.put(APP_NAME, ContextHolder.getAppContext() != null ? ContextHolder.getAppContext().getPackageName() : "null context");
        HianalyticsHelper.getInstance().onEvent(linkedHashMap, EVENT_ID);
        Logger.m32144v(f26333a, "%s", linkedHashMap);
    }

    public static void init() {
        C5994l4.m34650b().m34652a(new b());
    }

    public static void reportNetSwitch(NetworkInfo networkInfo, NetworkInfo networkInfo2) {
        if (NetworkUtil.isConnectTypeChange(networkInfo, networkInfo2)) {
            reportSysEvent(Long.valueOf(System.currentTimeMillis()), NETSWITCH_EVENT, NetworkUtil.getPrimaryNetworkType(networkInfo) + "-" + NetworkUtil.getPrimaryNetworkType(networkInfo2));
        }
    }

    public static void reportSysEvent(Long l10, String str, String str2) {
        if (HianalyticsHelper.getInstance().isEnableReport(ContextHolder.getAppContext())) {
            InitReport.reportWhenInit(new a(l10, str, str2));
        }
    }
}
