package com.huawei.hms.network.embedded;

import com.huawei.hms.network.inner.api.NetworkService;
import com.huawei.hms.network.inner.api.PolicyNetworkService;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: com.huawei.hms.network.embedded.k */
/* loaded from: classes8.dex */
public class C5976k {

    /* renamed from: a */
    public static final String f27152a = "networkkit_";

    /* renamed from: b */
    public static final String f27153b = "core_configversion";

    /* renamed from: c */
    public static final String f27154c = "core_unitransenable";

    /* renamed from: d */
    public static final String f27155d = "dynamic_load";

    /* renamed from: e */
    public static final String f27156e = "core_switch_profile_v2";

    /* renamed from: f */
    public static final String f27157f = "1.0.0.100";

    /* renamed from: g */
    public static final String f27158g = "enable";

    /* renamed from: h */
    public static final Map<String, Object> f27159h = new HashMap();

    /* renamed from: i */
    public static final C5976k f27160i = new C5976k();

    /* renamed from: com.huawei.hms.network.embedded.k$a */
    public static final class a {

        /* renamed from: a */
        public static final String f27161a = "bbrv1";

        /* renamed from: b */
        public static final String f27162b = "pcc";
    }

    /* renamed from: com.huawei.hms.network.embedded.k$b */
    public static final class b {

        /* renamed from: a */
        public static final boolean f27163a = true;

        /* renamed from: b */
        public static final boolean f27164b = false;

        /* renamed from: c */
        public static final int f27165c = 600;

        /* renamed from: d */
        public static final boolean f27166d = true;

        /* renamed from: e */
        public static final long f27167e = 0;

        /* renamed from: f */
        public static final boolean f27168f = false;

        /* renamed from: g */
        public static final boolean f27169g = false;

        /* renamed from: h */
        public static final int f27170h = 8;

        /* renamed from: i */
        public static final int f27171i = 5;

        /* renamed from: j */
        public static final int f27172j = -1;

        /* renamed from: k */
        public static final boolean f27173k = false;

        /* renamed from: l */
        public static final long f27174l = 604800;

        /* renamed from: m */
        public static final long f27175m = 86400;

        /* renamed from: n */
        public static final String f27176n = "com.huawei.music,com.android.mediacenter";
    }

    /* renamed from: com.huawei.hms.network.embedded.k$c */
    public static final class c {

        /* renamed from: a */
        public static final String f27177a = "huawei_module_quic_pro";

        /* renamed from: b */
        public static final boolean f27178b = false;

        /* renamed from: c */
        public static final boolean f27179c = false;

        /* renamed from: d */
        public static final boolean f27180d = false;

        /* renamed from: e */
        public static final boolean f27181e = false;

        /* renamed from: f */
        public static final String f27182f = "bbrv1";

        /* renamed from: g */
        public static final String f27183g = "none";

        /* renamed from: h */
        public static final boolean f27184h = false;

        /* renamed from: i */
        public static final int f27185i = 0;

        /* renamed from: j */
        public static final int f27186j = 1;

        /* renamed from: k */
        public static final int f27187k = -1;

        /* renamed from: l */
        public static final int f27188l = 0;

        /* renamed from: m */
        public static final int f27189m = 1296000;

        /* renamed from: n */
        public static final int f27190n = 10;

        /* renamed from: o */
        public static final int f27191o = 2;
    }

    /* renamed from: com.huawei.hms.network.embedded.k$d */
    public static final class d {

        /* renamed from: a */
        public static final int f27192a = 10000;

        /* renamed from: b */
        public static final int f27193b = 10000;

        /* renamed from: c */
        public static final int f27194c = 1;

        /* renamed from: d */
        public static final int f27195d = 0;

        /* renamed from: e */
        public static final int f27196e = 0;

        /* renamed from: f */
        public static final int f27197f = 10000;

        /* renamed from: g */
        public static final int f27198g = 500;

        /* renamed from: h */
        public static final boolean f27199h = true;

        /* renamed from: i */
        public static final boolean f27200i = false;

        /* renamed from: j */
        public static final boolean f27201j = true;

        /* renamed from: k */
        public static final boolean f27202k = false;

        /* renamed from: l */
        public static final boolean f27203l = false;

        /* renamed from: m */
        public static final int f27204m = 0;

        /* renamed from: n */
        public static final int f27205n = 0;

        /* renamed from: o */
        public static final int f27206o = 0;

        /* renamed from: p */
        public static final boolean f27207p = false;

        /* renamed from: q */
        public static final boolean f27208q = true;

        /* renamed from: r */
        public static final int f27209r = 0;
    }

    /* renamed from: com.huawei.hms.network.embedded.k$e */
    public static final class e {

        /* renamed from: a */
        public static final int f27210a = 2;

        /* renamed from: b */
        public static final int f27211b = 2097152;

        /* renamed from: c */
        public static final boolean f27212c = false;

        /* renamed from: d */
        public static final int f27213d = 0;
    }

    /* renamed from: com.huawei.hms.network.embedded.k$f */
    public static final class f {

        /* renamed from: a */
        public static final String f27214a = "serial";

        /* renamed from: b */
        public static final String f27215b = "none";
    }

    /* renamed from: com.huawei.hms.network.embedded.k$g */
    public static final class g {

        /* renamed from: a */
        public static final String f27216a = "abtest_dyfrag_groupid";

        /* renamed from: b */
        public static final String f27217b = "filemanager_slice_threshold";

        /* renamed from: c */
        public static final String f27218c = "filemanager_slice_num";

        /* renamed from: d */
        public static final String f27219d = "filemanager_auto_slice";

        /* renamed from: e */
        public static final String f27220e = "filemanager_executor_num";

        /* renamed from: f */
        public static final String f27221f = "filemanager_protocol_policy";

        /* renamed from: g */
        public static final String f27222g = "filemanager_pcc_switch";
    }

    /* renamed from: com.huawei.hms.network.embedded.k$h */
    public static final class h {

        /* renamed from: a */
        public static final long f27223a = 120000;

        /* renamed from: b */
        public static final long f27224b = 1000;

        /* renamed from: c */
        public static final long f27225c = 60000;

        /* renamed from: d */
        public static final long f27226d = 1000;
    }

    /* renamed from: com.huawei.hms.network.embedded.k$i */
    public static final class i {

        /* renamed from: a */
        public static final String f27227a = "netdiag_enable_report_qoe";

        /* renamed from: b */
        public static final String f27228b = "netdiag_qoe_report_suppress_time";

        /* renamed from: c */
        public static final String f27229c = "netdiag_qoe_call_suppress_time";
    }

    public C5976k() {
        m34557c();
    }

    /* renamed from: b */
    public static C5976k m34556b() {
        return f27160i;
    }

    /* renamed from: c */
    private void m34557c() {
        Iterator<String> it = C5963j.f27055x.iterator();
        while (it.hasNext()) {
            f27159h.put(it.next(), "");
        }
        Map<String, Object> map = f27159h;
        Boolean bool = Boolean.TRUE;
        map.put("core_switch_ai", bool);
        map.put("core_switch_netdiag", bool);
        Boolean bool2 = Boolean.FALSE;
        map.put(NetworkService.Constants.REMOTE_SCENE_SWITCH, bool2);
        map.put(NetworkService.Constants.AI_IPSORT_SWITCH, bool2);
        map.put(NetworkService.Constants.AI_CONNECTTIMEOUT_SWITCH, bool2);
        map.put(NetworkService.Constants.AI_CONNECTTIMEOUT_THRESHOLD, "");
        map.put("ai_ping_enable", bool2);
        map.put("ai_ping_minthreshold", "");
        map.put("ai_ping_nat", "");
        map.put("core_switch_dns", bool);
        map.put(f27156e, bool2);
        map.put(f27154c, bool2);
        map.put("core_configversion", f27157f);
        map.put(f27155d, f27158g);
        map.put(PolicyNetworkService.GlobalConstants.ENABLE_DETECT_WITH_HTTP, bool);
        map.put(PolicyNetworkService.GlobalConstants.ENABLE_HTTPDNS, bool2);
        map.put(PolicyNetworkService.GlobalConstants.DNS_RESULT_TTL, 600);
        map.put("core_enable_ipv6_preferred", bool);
        map.put("core_enable_site_detect", bool2);
        map.put(PolicyNetworkService.GlobalConstants.SITE_DETECT_THRESHOLD, 0L);
        map.put("core_ha_tag", "");
        map.put(PolicyNetworkService.GlobalConstants.CONNECT_POOL_SIZE, 8);
        map.put(PolicyNetworkService.GlobalConstants.CONNECT_KEEP_ALIVE_DURATION, 5);
        map.put("core_enable_privacy_policy", bool2);
        map.put(PolicyNetworkService.GlobalConstants.CONFIG_EXPIRED_TIME, Long.valueOf(b.f27174l));
        map.put(PolicyNetworkService.GlobalConstants.AB_EXPIRED_TIME, Long.valueOf(b.f27175m));
        map.put(PolicyNetworkService.GlobalConstants.AB_ALLOWED_LIST, b.f27176n);
        map.put(PolicyNetworkService.GlobalConstants.INDEPENDENT_CONFIGS, "");
        map.put(PolicyNetworkService.GlobalConstants.PROFILE_CONFIGS, "");
        map.put("core_disable_weaknetwork_retry", bool);
        map.put("core_enable_plaintext_url_path", bool2);
        map.put(PolicyNetworkService.ClientConstants.FOLLOW_REDIRECTS, bool);
        map.put(PolicyNetworkService.ClientConstants.FOLLOW_SSL_REDIRECTS, bool);
        map.put(PolicyNetworkService.ClientConstants.SUPPORT_PROTOCOLS, Arrays.asList("h2", "http/1.1"));
        map.put(PolicyNetworkService.ClientConstants.TRAFFIC_CLASS, 0);
        map.put(PolicyNetworkService.ClientConstants.QUIC_ENABLE_GSO, bool2);
        map.put(PolicyNetworkService.ClientConstants.QUIC_ENABLE_BANDWIDTH, bool);
        map.put(PolicyNetworkService.ClientConstants.SMALLPKT_FEC, bool2);
        map.put(PolicyNetworkService.ClientConstants.SMALLPKT_FEC_INITIALLEVEL, 0);
        map.put(PolicyNetworkService.ClientConstants.ENABLE_MULTIPATH, bool2);
        map.put(PolicyNetworkService.ClientConstants.MULTIPATH_TYPE, 1);
        map.put(PolicyNetworkService.ClientConstants.TLS_ZERO_RTT, bool2);
        map.put(PolicyNetworkService.ClientConstants.REDUNDANT_ACK, bool2);
        map.put(PolicyNetworkService.ClientConstants.CONGESTION_CONTROL_TYPE, "bbrv1");
        map.put(PolicyNetworkService.ClientConstants.PRIORITY_CONTROL_TYPE, "none");
        map.put(PolicyNetworkService.ClientConstants.WAIT_FOR_NEW_NETWORK_TIME_MS, -1);
        map.put(PolicyNetworkService.ClientConstants.HWHTTP_ENABLE_CONNECTION_MIGRATION, bool2);
        map.put(PolicyNetworkService.GlobalConstants.REPORT_RATE, -1);
        map.put(PolicyNetworkService.GlobalConstants.QUIC_REPORT_RATE, -1);
        map.put(PolicyNetworkService.ClientConstants.SERVER_CONFIG_PERSIST_DELAY, 0);
        map.put(PolicyNetworkService.ClientConstants.COMMIT_FILE_DELAY, 10);
        map.put(PolicyNetworkService.ClientConstants.TLS13_SESSION_TIMEOUT, 1296000);
        map.put(PolicyNetworkService.ClientConstants.QUIC_BROKEN_MDOE, 2);
        map.put("core_call_timeout", 0);
        map.put("core_connect_timeout", 10000);
        map.put("core_write_timeout", 10000);
        map.put("core_read_timeout", 10000);
        map.put("core_retry_time", 1);
        map.put("core_concurrent_connect_delay", 500);
        map.put("core_ping_interval", 0);
        map.put("core_enable_concurrent_connect", bool);
        map.put("core_connect_empty_body", bool2);
        map.put(PolicyNetworkService.RequestConstants.ENABLE_TRAFFIC_CONTROL_WITH_429, bool2);
        map.put(PolicyNetworkService.RequestConstants.MAX_REQUEST_DISCRETE_TIME, 0);
        map.put(PolicyNetworkService.RequestConstants.MAX_RETRY_WAITING_TIME, 0);
        map.put(g.f27216a, "");
        map.put(g.f27217b, Integer.valueOf(e.f27211b));
        map.put(g.f27218c, 2);
        map.put(g.f27219d, bool2);
        map.put(g.f27220e, 0);
        map.put(g.f27221f, "");
        map.put(g.f27222g, "");
        map.put(i.f27227a, bool2);
        map.put(i.f27228b, 120000L);
        map.put(i.f27229c, 1000L);
        map.put(PolicyNetworkService.QuicConstants.QUICHINT, "");
        map.put(PolicyNetworkService.QuicConstants.MODULE_NAME, "huawei_module_quic_pro");
        map.put(PolicyNetworkService.ClientConstants.QUIC_CONNECTION_OPTIONS, "");
        map.put("core_enable_alllink_delay_analysis", bool2);
        map.put(PolicyNetworkService.RequestConstants.METRIC_POLICY, 0);
    }

    /* renamed from: a */
    public Object m34558a(String str) {
        return f27159h.get(str);
    }

    /* renamed from: a */
    public Set<String> m34559a() {
        return f27159h.keySet();
    }
}
