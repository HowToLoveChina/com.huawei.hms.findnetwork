package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.network.NetworkKit;

/* renamed from: com.huawei.hms.network.embedded.p0 */
/* loaded from: classes8.dex */
public class C6042p0 extends HianalyticsBaseData {

    /* renamed from: a */
    public static final String f27639a = "HttpDnsHianalyticsData";

    /* renamed from: b */
    public static volatile boolean f27640b = false;

    /* renamed from: c */
    public static final String f27641c = "sdk_version";

    /* renamed from: d */
    public static final String f27642d = "httpdns";

    /* renamed from: e */
    public static final String f27643e = "trace_id";

    /* renamed from: f */
    public static final String f27644f = "trigger_type";

    /* renamed from: g */
    public static final String f27645g = "dns_sync_query";

    /* renamed from: h */
    public static final String f27646h = "dns_network_change";

    /* renamed from: i */
    public static final String f27647i = "dns_init";

    /* renamed from: j */
    public static final String f27648j = "dns_server_name";

    /* renamed from: k */
    public static final String f27649k = "localdns_value";

    /* renamed from: l */
    public static final String f27650l = "httpdns_value";

    /* renamed from: m */
    public static final String f27651m = "network_type";

    /* renamed from: n */
    public static final String f27652n = "httpdns_time";

    /* renamed from: o */
    public static final String f27653o = "localdns_time";

    /* renamed from: p */
    public static final String f27654p = "dns_server_ips";

    public C6042p0() {
        put("sdk_version", "8.0.1.309");
        put("dns_subtype", f27642d);
    }

    /* renamed from: a */
    public static void m34949a() {
        synchronized (C6042p0.class) {
            if (!f27640b) {
                try {
                    String option = NetworkKit.getInstance().getOption("core_ha_tag");
                    if (!option.isEmpty()) {
                        HianalyticsHelper.getInstance().setHaTag(option);
                    }
                } catch (NoSuchMethodError unused) {
                    Logger.m32145w(f27639a, "sdk version is too low,ha tag cannot be found");
                }
                f27640b = true;
            }
        }
    }
}
