package com.huawei.hms.framework.network.restclient.dnkeeper;

import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.network.NetworkKit;

/* renamed from: com.huawei.hms.framework.network.restclient.dnkeeper.e */
/* loaded from: classes8.dex */
public class C5484e extends HianalyticsBaseData {

    /* renamed from: a */
    private static final String f25098a = "DNKeeperHianalyticsData";

    /* renamed from: b */
    private static volatile boolean f25099b = false;

    /* renamed from: c */
    public static final String f25100c = "sdk_version";

    /* renamed from: d */
    public static final String f25101d = "dns_request";

    /* renamed from: e */
    public static final String f25102e = "dns_subtype";

    /* renamed from: f */
    public static final String f25103f = "dnkeeper";

    /* renamed from: g */
    public static final String f25104g = "request_domain";

    /* renamed from: h */
    public static final String f25105h = "dnkeeper_time";

    /* renamed from: i */
    public static final String f25106i = "dns_server_ips";

    /* renamed from: j */
    public static final String f25107j = "trace_id";

    /* renamed from: k */
    public static final String f25108k = "trigger_type";

    /* renamed from: l */
    public static final String f25109l = "dns_sync_query";

    /* renamed from: m */
    public static final String f25110m = "dns_init";

    /* renamed from: n */
    public static final String f25111n = "dns_lazy_update";

    /* renamed from: o */
    public static final String f25112o = "error_code";

    /* renamed from: p */
    public static final int f25113p = 10020000;

    /* renamed from: q */
    public static final int f25114q = 10020001;

    /* renamed from: r */
    public static final String f25115r = "protocol_impl";

    public C5484e() {
        put("sdk_version", "8.0.1.305");
        put("dns_subtype", "dnkeeper");
    }

    /* renamed from: a */
    public static void m32387a() {
        synchronized (C5484e.class) {
            if (!f25099b) {
                try {
                    String option = NetworkKit.getInstance().getOption("core_ha_tag");
                    if (!option.isEmpty()) {
                        HianalyticsHelper.getInstance().setHaTag(option);
                    }
                } catch (NoSuchMethodError unused) {
                    Logger.m32145w(f25098a, "sdk version is too low,ha tag cannot be found");
                }
                f25099b = true;
            }
        }
    }
}
