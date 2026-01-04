package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* renamed from: com.huawei.hms.network.embedded.y */
/* loaded from: classes8.dex */
public class C6158y {

    /* renamed from: a */
    public static final String f29106a = "DnsUtil";

    /* renamed from: b */
    public static final int f29107b = 10000;

    /* renamed from: c */
    public static final int f29108c = 15000;

    /* renamed from: d */
    public static int f29109d = 10000;

    /* renamed from: e */
    public static final int f29110e = 4;

    /* renamed from: f */
    public static final int f29111f = 16;

    /* renamed from: g */
    public static ExecutorService f29112g = ExecutorsUtils.newCachedThreadPool("Dns_executor");

    /* renamed from: com.huawei.hms.network.embedded.y$a */
    public static class a extends HianalyticsBaseData {
        public a(C6021n5 c6021n5, long j10) {
            put("sdk_version", "8.0.1.309");
            put("dns_subtype", b.f29119g);
            put("trigger_type", b.f29120h);
            put("request_domain", c6021n5.m34891d());
            put("error_code", c6021n5.m34895h() ? 10020000L : 10020001L);
            put("protocol_impl", b.f29122j);
            put("tcpconn_time", c6021n5.m34893f() - c6021n5.m34888a());
            put("ssl_time", c6021n5.m34894g());
            put("connect_time", c6021n5.m34889b());
            put(b.f29127o, j10);
            put("server_ip", c6021n5.m34892e());
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.y$b */
    public static class b {

        /* renamed from: a */
        public static final String f29113a = "trigger_type";

        /* renamed from: b */
        public static final String f29114b = "request_domain";

        /* renamed from: c */
        public static final String f29115c = "error_code";

        /* renamed from: d */
        public static final int f29116d = 10020000;

        /* renamed from: e */
        public static final int f29117e = 10020001;

        /* renamed from: f */
        public static final String f29118f = "dns_subtype";

        /* renamed from: g */
        public static final String f29119g = "site_detect";

        /* renamed from: h */
        public static final String f29120h = "dns_change";

        /* renamed from: i */
        public static final String f29121i = "protocol_impl";

        /* renamed from: j */
        public static final String f29122j = "okhttp";

        /* renamed from: k */
        public static final String f29123k = "tcpconn_time";

        /* renamed from: l */
        public static final String f29124l = "ssl_time";

        /* renamed from: m */
        public static final String f29125m = "connect_time";

        /* renamed from: n */
        public static final String f29126n = "dns_request";

        /* renamed from: o */
        public static final String f29127o = "site_detect_threshold";

        /* renamed from: p */
        public static final String f29128p = "server_ip";
    }

    /* renamed from: a */
    public static int m35816a() {
        return f29109d;
    }

    /* renamed from: b */
    public static List<InetAddress> m35826b(String str) throws UnknownHostException {
        return C6068r0.m35165a().m35167a(str, InterfaceC5938h0.f26897b);
    }

    /* renamed from: c */
    public static void m35830c(C6003m0 c6003m0) {
        List<InetAddress> listM35821a;
        if (m35829b(c6003m0) || (listM35821a = m35821a(c6003m0.m34749d())) == null || listM35821a.size() <= 0) {
            return;
        }
        boolean z10 = false;
        boolean z11 = false;
        for (InetAddress inetAddress : listM35821a) {
            if (inetAddress.getAddress().length == 4) {
                z10 = true;
            } else if (inetAddress.getAddress().length == 16) {
                z11 = true;
            }
        }
        m35823a(c6003m0, z10, z11);
    }

    /* renamed from: a */
    public static HianalyticsBaseData m35817a(C6021n5 c6021n5, long j10) {
        if (c6021n5 != null) {
            return new a(c6021n5, j10);
        }
        Logger.m32145w(f29106a, "Site detect metrics is null");
        return null;
    }

    /* renamed from: b */
    public static ExecutorService m35827b() {
        return f29112g;
    }

    /* renamed from: a */
    public static C6003m0 m35818a(InetAddress[] inetAddressArr) {
        boolean z10;
        C6003m0 c6003m0 = new C6003m0();
        boolean z11 = false;
        if (inetAddressArr == null || inetAddressArr.length <= 0) {
            z10 = false;
        } else {
            boolean z12 = false;
            z10 = false;
            for (InetAddress inetAddress : inetAddressArr) {
                if (inetAddress.getAddress().length == 4) {
                    z12 = true;
                } else if (inetAddress.getAddress().length == 16) {
                    z10 = true;
                }
                c6003m0.m34739a(inetAddress.getHostAddress());
            }
            z11 = z12;
        }
        m35823a(c6003m0, z11, z10);
        return c6003m0;
    }

    /* renamed from: b */
    public static <T> void m35828b(List<T> list) {
        if (list == null) {
            return;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(list.size());
        linkedHashSet.addAll(list);
        list.clear();
        list.addAll(linkedHashSet);
    }

    /* renamed from: a */
    public static List<String> m35819a(C6003m0 c6003m0) {
        List<String> listM34749d = c6003m0.m34749d();
        m35828b(listM34749d);
        return listM34749d;
    }

    /* renamed from: b */
    public static boolean m35829b(C6003m0 c6003m0) {
        return c6003m0 == null || c6003m0.m34755j();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0015  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<java.net.InetAddress> m35820a(java.lang.String r5, java.lang.String r6) throws java.net.UnknownHostException {
        /*
            com.huawei.hms.network.embedded.t r0 = com.huawei.hms.network.embedded.C6093t.m35329m()
            r1 = 0
            r0.m35355d(r1)
            r6.hashCode()
            int r0 = r6.hashCode()
            r2 = 2
            r3 = 1
            r4 = -1
            switch(r0) {
                case -1387696287: goto L2d;
                case 1001410588: goto L22;
                case 1965413854: goto L17;
                default: goto L15;
            }
        L15:
            r1 = r4
            goto L36
        L17:
            java.lang.String r0 = "LocalDns"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L20
            goto L15
        L20:
            r1 = r2
            goto L36
        L22:
            java.lang.String r0 = "DNKeeper"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L2b
            goto L15
        L2b:
            r1 = r3
            goto L36
        L2d:
            java.lang.String r0 = "HttpDns"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L36
            goto L15
        L36:
            switch(r1) {
                case 0: goto L5e;
                case 1: goto L50;
                case 2: goto L3e;
                default: goto L39;
            }
        L39:
            java.util.List r5 = java.util.Collections.emptyList()
            return r5
        L3e:
            com.huawei.hms.network.embedded.t r6 = com.huawei.hms.network.embedded.C6093t.m35329m()
            r6.m35361f(r2)
            com.huawei.hms.network.embedded.r0 r6 = com.huawei.hms.network.embedded.C6068r0.m35165a()
            com.huawei.hms.network.embedded.h0 r0 = com.huawei.hms.network.embedded.InterfaceC5938h0.f26897b
        L4b:
            java.util.List r5 = r6.m35167a(r5, r0)
            return r5
        L50:
            com.huawei.hms.network.embedded.t r6 = com.huawei.hms.network.embedded.C6093t.m35329m()
            r6.m35361f(r3)
            com.huawei.hms.network.embedded.r0 r6 = com.huawei.hms.network.embedded.C6068r0.m35165a()
            com.huawei.hms.network.embedded.h0 r0 = com.huawei.hms.network.embedded.InterfaceC5938h0.f26898c
            goto L4b
        L5e:
            com.huawei.hms.network.embedded.t r6 = com.huawei.hms.network.embedded.C6093t.m35329m()
            r0 = 3
            r6.m35361f(r0)
            com.huawei.hms.network.embedded.r0 r6 = com.huawei.hms.network.embedded.C6068r0.m35165a()
            com.huawei.hms.network.embedded.h0 r0 = com.huawei.hms.network.embedded.InterfaceC5938h0.f26899d
            goto L4b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.C6158y.m35820a(java.lang.String, java.lang.String):java.util.List");
    }

    /* renamed from: a */
    public static List<InetAddress> m35821a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (String str : list) {
            try {
                arrayList.add(InetAddress.getByName(str));
            } catch (UnknownHostException unused) {
                Logger.m32145w(f29106a, "convertAddress failed, ip:" + str);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static void m35822a(int i10) {
        if (i10 <= 0 || i10 > 15000) {
            return;
        }
        f29109d = i10;
    }

    /* renamed from: a */
    public static void m35823a(C6003m0 c6003m0, boolean z10, boolean z11) {
        String str;
        if (c6003m0 == null) {
            Logger.m32145w(f29106a, "dnsResult is null.");
            return;
        }
        if (z10 && z11) {
            str = "ALL";
        } else if (z10) {
            str = "A";
        } else {
            if (!z11) {
                Logger.m32145w(f29106a, "invalid ip type");
                return;
            }
            str = "AAAA";
        }
        c6003m0.m34748c(str);
    }

    /* renamed from: a */
    public static boolean m35824a(String str) {
        try {
            return InetAddress.getByName(str) instanceof Inet4Address;
        } catch (SecurityException | UnknownHostException e10) {
            Logger.m32136d(f29106a, "isIPv4 failed,exception message is:" + e10.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m35825a(InetAddress inetAddress) {
        return inetAddress instanceof Inet4Address;
    }
}
