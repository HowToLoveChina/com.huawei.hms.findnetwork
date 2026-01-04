package com.huawei.hms.network.embedded;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.PLSharedPreferences;
import com.huawei.hms.framework.common.Utils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.network.embedded.AbstractC6081s0;
import com.huawei.hms.network.inner.DomainManager;
import com.huawei.hms.network.inner.api.NetworkService;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

/* renamed from: com.huawei.hms.network.embedded.t */
/* loaded from: classes8.dex */
public class C6093t {

    /* renamed from: A */
    public static final int f28253A = 5;

    /* renamed from: B */
    public static final int f28254B = 3;

    /* renamed from: C */
    public static final String f28255C = "airoute_conf";

    /* renamed from: D */
    public static final String f28256D = "launch_used_domain";

    /* renamed from: E */
    public static final long f28257E = 300000;

    /* renamed from: F */
    public static final long f28258F = 120000;

    /* renamed from: G */
    public static volatile C6093t f28259G = null;

    /* renamed from: H */
    public static final int f28260H = 0;

    /* renamed from: I */
    public static final int f28261I = 1;

    /* renamed from: J */
    public static final int f28262J = 4;

    /* renamed from: K */
    public static final int f28263K = 16;

    /* renamed from: y */
    public static final String f28264y = "DNManager";

    /* renamed from: z */
    public static final String f28265z = "DnsManager";

    /* renamed from: b */
    public String[] f28267b;

    /* renamed from: i */
    public AbstractC6081s0.c f28274i;

    /* renamed from: j */
    public Context f28275j;

    /* renamed from: k */
    public InterfaceC5990l0 f28276k;

    /* renamed from: l */
    public C6016n0 f28277l;

    /* renamed from: a */
    public final LinkedHashSet<String> f28266a = new LinkedHashSet<>(5);

    /* renamed from: c */
    public final PLSharedPreferences f28268c = new PLSharedPreferences(ContextHolder.getAppContext(), f28255C);

    /* renamed from: d */
    public volatile boolean f28269d = false;

    /* renamed from: e */
    public boolean f28270e = false;

    /* renamed from: f */
    public volatile boolean f28271f = false;

    /* renamed from: g */
    public final Object f28272g = new Object();

    /* renamed from: h */
    public final Object f28273h = new Object();

    /* renamed from: m */
    public boolean f28278m = true;

    /* renamed from: n */
    public boolean f28279n = false;

    /* renamed from: o */
    public long f28280o = 1300;

    /* renamed from: q */
    public final ConcurrentHashMap<String, C6145x> f28282q = new ConcurrentHashMap<>();

    /* renamed from: r */
    public final ConcurrentHashMap<String, i> f28283r = new ConcurrentHashMap<>();

    /* renamed from: s */
    public final ExecutorService f28284s = ExecutorsUtils.newSingleThreadExecutor(f28265z);

    /* renamed from: t */
    public final ThreadLocal<Integer> f28285t = new a();

    /* renamed from: u */
    public final ThreadLocal<Long> f28286u = new b();

    /* renamed from: v */
    public final ThreadLocal<Integer> f28287v = new c();

    /* renamed from: w */
    public final ThreadLocal<Long> f28288w = new d();

    /* renamed from: x */
    public final ThreadLocal<Integer> f28289x = new e();

    /* renamed from: p */
    public NetworkService f28281p = C6007m4.m34758c().m34763b("ai");

    /* renamed from: com.huawei.hms.network.embedded.t$a */
    public class a extends ThreadLocal<Integer> {
        public a() {
        }

        @Override // java.lang.ThreadLocal
        public Integer initialValue() {
            return -1;
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.t$b */
    public class b extends ThreadLocal<Long> {
        public b() {
        }

        @Override // java.lang.ThreadLocal
        public Long initialValue() {
            return Long.valueOf(C6132w.m35707a());
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.t$c */
    public class c extends ThreadLocal<Integer> {
        public c() {
        }

        @Override // java.lang.ThreadLocal
        public Integer initialValue() {
            return -1;
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.t$d */
    public class d extends ThreadLocal<Long> {
        public d() {
        }

        @Override // java.lang.ThreadLocal
        public Long initialValue() {
            return Long.valueOf(Utils.getCurrentTime(true));
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.t$e */
    public class e extends ThreadLocal<Integer> {
        public e() {
        }

        @Override // java.lang.ThreadLocal
        public Integer initialValue() {
            return 0;
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.t$f */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (C6003m0 c6003m0 : C6093t.this.f28277l.m34877a(new ArrayList(Arrays.asList(C6093t.this.m35332n())))) {
                if (!TextUtils.isEmpty(c6003m0.m34747c())) {
                    C5843a0.m33736a(c6003m0.m34747c(), c6003m0);
                }
            }
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.t$g */
    public class g implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f28296a;

        /* renamed from: b */
        public final /* synthetic */ List f28297b;

        public g(String str, List list) {
            this.f28296a = str;
            this.f28297b = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (C6093t.this.m35328l(this.f28296a)) {
                    return;
                }
                C6003m0 c6003m0M33733a = C5843a0.m33733a(this.f28296a);
                if (c6003m0M33733a == null) {
                    Logger.m32143v(C6093t.f28264y, "the domainResult is empty from cache,and return");
                    return;
                }
                List<InetAddress> listM35821a = C6158y.m35821a(c6003m0M33733a.m34749d());
                if (listM35821a.size() != 0 && this.f28297b.size() != 0) {
                    if (this.f28297b.contains(listM35821a.get(0))) {
                        Logger.m32143v(C6093t.f28264y, "the ip from local and the ip from dnkeeper is same,and return");
                        return;
                    }
                    int iCompareIp = C6093t.this.f28281p != null ? C6093t.this.f28281p.compareIp(listM35821a.get(0), (InetAddress) this.f28297b.get(0)) : -1;
                    C6145x c6145x = (C6145x) C6093t.this.f28282q.get(this.f28296a);
                    if (iCompareIp == 1) {
                        c6145x.m35763a(2);
                        Logger.m32142i(C6093t.f28264y, "after checking the threshold, the dns_type: %d need to change, and the host is %s", Integer.valueOf(c6145x.m35767d()), this.f28296a);
                        return;
                    } else {
                        c6145x.m35764a(Utils.getCurrentTime(true));
                        Logger.m32142i(C6093t.f28264y, "after checking the threshold, the dns_type: %d will use the origin status,the host is %s", Integer.valueOf(c6145x.m35767d()), this.f28296a);
                        return;
                    }
                }
                Logger.m32143v(C6093t.f28264y, "the address or list is empty,and return");
            } catch (ConcurrentModificationException unused) {
                Logger.m32141i(C6093t.f28264y, "dns and dnkeeper has exception with racing,and you need not care it");
            } catch (Throwable unused2) {
                Logger.m32143v(C6093t.f28264y, "dns and dnkeeper has throwable with racing,and you need not care it");
            }
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.t$h */
    public class h implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f28299a;

        public h(String str) {
            this.f28299a = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:40:0x002e  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x005e  */
        /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r5 = this;
                java.lang.String r0 = "DNManager"
                com.huawei.hms.network.embedded.t r1 = com.huawei.hms.network.embedded.C6093t.this
                java.lang.String r2 = r5.f28299a
                boolean r1 = com.huawei.hms.network.embedded.C6093t.m35316a(r1, r2)
                if (r1 == 0) goto Ld
                return
            Ld:
                com.huawei.hms.network.embedded.p4 r1 = com.huawei.hms.network.embedded.AbstractC6046p4.m34963f()     // Catch: java.net.UnknownHostException -> L1e java.lang.Throwable -> L20
                java.lang.String r2 = r5.f28299a     // Catch: java.net.UnknownHostException -> L1e java.lang.Throwable -> L20
                java.lang.String r3 = "LocalDns"
                java.util.List r3 = com.huawei.hms.network.embedded.C6158y.m35820a(r2, r3)     // Catch: java.net.UnknownHostException -> L1e java.lang.Throwable -> L20
                com.huawei.hms.network.embedded.n5 r0 = r1.mo34965a(r2, r3)     // Catch: java.net.UnknownHostException -> L1e java.lang.Throwable -> L20
                goto L2c
            L1e:
                r1 = move-exception
                goto L26
            L20:
                java.lang.String r1 = "Connect detect with error "
                com.huawei.hms.framework.common.Logger.m32145w(r0, r1)
                goto L2b
            L26:
                java.lang.String r2 = "Connect detect with UnknownHostException "
                com.huawei.hms.framework.common.Logger.m32146w(r0, r2, r1)
            L2b:
                r0 = 0
            L2c:
                if (r0 == 0) goto L52
                boolean r1 = r0.m34895h()
                if (r1 == 0) goto L52
                long r1 = r0.m34889b()
                com.huawei.hms.network.embedded.t r3 = com.huawei.hms.network.embedded.C6093t.this
                long r3 = com.huawei.hms.network.embedded.C6093t.m35323e(r3)
                int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r1 >= 0) goto L52
                com.huawei.hms.network.embedded.t r1 = com.huawei.hms.network.embedded.C6093t.this
                int r1 = r1.m35365i()
                r2 = 1
                if (r1 != r2) goto L52
                com.huawei.hms.network.embedded.t r1 = com.huawei.hms.network.embedded.C6093t.this
                java.lang.String r2 = r5.f28299a
                com.huawei.hms.network.embedded.C6093t.m35320b(r1, r2)
            L52:
                com.huawei.hms.network.embedded.t r5 = com.huawei.hms.network.embedded.C6093t.this
                long r1 = com.huawei.hms.network.embedded.C6093t.m35323e(r5)
                com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData r5 = com.huawei.hms.network.embedded.C6158y.m35817a(r0, r1)
                if (r5 == 0) goto L67
                com.huawei.hms.framework.common.hianalytics.HianalyticsHelper r0 = com.huawei.hms.framework.common.hianalytics.HianalyticsHelper.getInstance()
                java.lang.String r1 = "dns_request"
                r0.executeReportHa(r5, r1)
            L67:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.C6093t.h.run():void");
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.t$i */
    public static class i {

        /* renamed from: a */
        public String f28301a;

        /* renamed from: b */
        public int f28302b = 0;

        /* renamed from: a */
        public int m35369a() {
            return this.f28302b;
        }

        /* renamed from: b */
        public String m35372b() {
            return this.f28301a;
        }

        /* renamed from: a */
        public void m35370a(int i10) {
            this.f28302b = i10;
        }

        /* renamed from: a */
        public void m35371a(String str) {
            this.f28301a = str;
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.t$j */
    public class j implements Runnable {
        public j(Context context) {
        }

        @Override // java.lang.Runnable
        public void run() {
            C5994l4.m34650b().m34652a(new C6106u());
            if (C6132w.m35710b() == 0) {
                C5843a0.m33741d();
            }
            for (String str : C6093t.this.m35332n()) {
                Logger.m32143v(C6093t.f28264y, "init dnsLazyUpdate domain: " + str);
                C5925g0.m34278a(str, "dns_init", 2);
            }
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.t$k */
    public @interface k {

        /* renamed from: a */
        public static final String f28304a = "dns_init";

        /* renamed from: b */
        public static final String f28305b = "dns_prefecth";

        /* renamed from: c */
        public static final String f28306c = "dns_lazy_update";

        /* renamed from: d */
        public static final String f28307d = "dns_sync_query";

        /* renamed from: e */
        public static final String f28308e = "dns_network_change";

        /* renamed from: f */
        public static final String f28309f = "dns_file_load";
    }

    /* renamed from: com.huawei.hms.network.embedded.t$l */
    public @interface l {

        /* renamed from: g */
        public static final int f28310g = 0;

        /* renamed from: h */
        public static final int f28311h = 1;

        /* renamed from: i */
        public static final int f28312i = 2;

        /* renamed from: j */
        public static final int f28313j = 3;
    }

    /* renamed from: k */
    private void m35327k(String str) {
        try {
            C6068r0.m35165a().m35168a(new h(str));
        } catch (RejectedExecutionException e10) {
            Logger.m32146w(f28264y, "Execute connectTast reject ", e10);
        }
    }

    /* renamed from: m */
    public static C6093t m35329m() {
        if (f28259G == null) {
            synchronized (C6093t.class) {
                try {
                    if (f28259G == null) {
                        f28259G = new C6093t();
                    }
                } finally {
                }
            }
        }
        return f28259G;
    }

    /* renamed from: n */
    private boolean m35331n(String str) {
        C6145x c6145x = this.f28282q.get(str);
        if (c6145x == null) {
            return false;
        }
        long jM35768e = c6145x.m35768e();
        long jAbs = Math.abs(Utils.getCurrentTime(true) - c6145x.m35766c());
        if (jM35768e > 3 && jAbs > 120000) {
            return true;
        }
        Logger.m32144v(f28264y, "domain = %s ,times = %d, and failure interval = %d", str, Long.valueOf(jM35768e), Long.valueOf(jAbs));
        return false;
    }

    /* renamed from: a */
    public String m35333a(@l int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? C6132w.f28814j : C6132w.f28817m : C6132w.f28815k : C6132w.f28816l;
    }

    /* renamed from: b */
    public Context m35344b() {
        return this.f28275j;
    }

    /* renamed from: c */
    public InterfaceC5990l0 m35349c() {
        return this.f28276k;
    }

    /* renamed from: d */
    public AbstractC6081s0.c m35353d() {
        if (this.f28274i == null) {
            this.f28274i = AbstractC6081s0.m35243a(AbstractC6081s0.f28147a);
        }
        return this.f28274i;
    }

    /* renamed from: f */
    public int m35359f() {
        return this.f28285t.get().intValue();
    }

    /* renamed from: g */
    public int m35362g() {
        return this.f28287v.get().intValue();
    }

    /* renamed from: h */
    public long m35364h() {
        return this.f28286u.get().longValue();
    }

    /* renamed from: i */
    public int m35365i() {
        return this.f28289x.get().intValue();
    }

    /* renamed from: j */
    public ThreadLocal<Long> m35366j() {
        return this.f28288w;
    }

    /* renamed from: l */
    public void m35368l() {
        this.f28288w.set(Long.valueOf(Utils.getCurrentTime(true)));
    }

    /* renamed from: a */
    private List<InetAddress> m35313a(List<InetAddress> list) {
        ArrayList arrayList = new ArrayList();
        if (list.isEmpty()) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            InetAddress inetAddress = list.get(i10);
            if (inetAddress.getAddress().length == 16) {
                arrayList3.add(inetAddress);
            } else if (inetAddress.getAddress().length == 4) {
                arrayList2.add(inetAddress);
            } else {
                Logger.m32145w(f28264y, "checkIpList is not IPv6 or IPv4");
            }
        }
        if (arrayList2.size() != 0 || arrayList3.size() != 0) {
            return m35319b(arrayList2, arrayList3);
        }
        Logger.m32145w(f28264y, "checkIpList IPv6 and IPv4 are not available");
        return list;
    }

    /* renamed from: h */
    private void m35324h(String str) {
        C6145x c6145x = this.f28282q.get(str);
        if (c6145x == null || c6145x.m35767d() != 2) {
            return;
        }
        c6145x.m35762a();
    }

    /* renamed from: i */
    public static void m35325i(String str) {
        if (TextUtils.isEmpty(str)) {
            Logger.m32145w(f28264y, "dnsPrefetch, domain is empty");
        } else {
            C5925g0.m34278a(str, k.f28305b, 2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0039  */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m35326j(java.lang.String r7) {
        /*
            r6 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 == 0) goto L7
            return
        L7:
            com.huawei.hms.network.embedded.x r0 = r6.m35357e(r7)
            if (r0 != 0) goto L12
            com.huawei.hms.network.embedded.x r0 = new com.huawei.hms.network.embedded.x
            r0.<init>()
        L12:
            int r1 = r6.m35365i()
            r2 = 3
            r3 = 1
            r4 = 2
            if (r1 == r3) goto L44
            if (r1 == r4) goto L3b
            if (r1 == r2) goto L20
            goto L39
        L20:
            com.huawei.hms.network.embedded.n0 r2 = r6.m35356e()
            if (r2 == 0) goto L39
            com.huawei.hms.network.embedded.n0 r2 = r6.m35356e()
            com.huawei.hms.network.embedded.o0 r2 = r2.m34878b()
            java.lang.String r2 = r2.m34912b()
            boolean r2 = r7.equals(r2)
            if (r2 != 0) goto L39
            goto L3b
        L39:
            r2 = r4
            goto L4a
        L3b:
            long r4 = com.huawei.hms.framework.common.Utils.getCurrentTime(r3)
            r0.m35764a(r4)
            r2 = r3
            goto L4a
        L44:
            boolean r3 = r6.m35367k()
            if (r3 == 0) goto L39
        L4a:
            r6.m35361f(r2)
            r0.m35763a(r2)
            r6.m35341a(r7, r0)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r7)
            java.lang.String r7 = " %s switch to: %s"
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            java.lang.String r1 = r6.m35333a(r1)
            int r0 = r0.m35767d()
            java.lang.String r6 = r6.m35333a(r0)
            java.lang.Object[] r6 = new java.lang.Object[]{r1, r6}
            java.lang.String r0 = "DNManager"
            com.huawei.hms.framework.common.Logger.m32142i(r0, r7, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.C6093t.m35326j(java.lang.String):void");
    }

    /* renamed from: l */
    public boolean m35328l(String str) {
        String str2;
        C6145x c6145x = this.f28282q.get(str);
        if (c6145x == null) {
            str2 = "the dnsInfo is empty from map,and return";
        } else {
            if (Math.abs(Utils.getCurrentTime(true) - c6145x.m35765b()) >= 300000) {
                Logger.m32143v(f28264y, "the dns change time is not in hibit period");
                return false;
            }
            str2 = "the dns change time is less than 5 min, and return";
        }
        Logger.m32145w(f28264y, str2);
        return true;
    }

    /* renamed from: m */
    private void m35330m(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f28273h) {
            try {
                if (this.f28266a.size() < 5 && !C6029o0.m34910e().m34912b().equalsIgnoreCase(str)) {
                    this.f28266a.add(str);
                    this.f28268c.edit().putString(f28256D, ContainerUtils.toString(new LinkedList(this.f28266a))).apply();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: n */
    public String[] m35332n() {
        if (this.f28267b == null) {
            this.f28267b = this.f28268c.getString(f28256D, "").split("&");
        }
        String[] strArr = this.f28267b;
        return (strArr.length == 1 && TextUtils.isEmpty(strArr[0])) ? new String[0] : (String[]) this.f28267b.clone();
    }

    /* renamed from: d */
    public String m35354d(String str) {
        return m35333a(m35360f(str));
    }

    /* renamed from: e */
    public C6016n0 m35356e() {
        return this.f28277l;
    }

    @l
    /* renamed from: f */
    public int m35360f(String str) {
        C6145x c6145xM35357e = m35357e(str);
        if (c6145xM35357e == null) {
            return 2;
        }
        return c6145xM35357e.m35767d();
    }

    /* renamed from: g */
    public void m35363g(String str) {
        m35368l();
        m35361f(m35360f(str));
        if (DomainManager.getInstance().isExcludePrefetch(str)) {
            Logger.m32143v(f28264y, "exclude save sp");
        } else {
            m35330m(str);
        }
    }

    /* renamed from: k */
    public boolean m35367k() {
        return this.f28270e;
    }

    /* renamed from: a */
    private List<InetAddress> m35314a(List<InetAddress> list, List<InetAddress> list2) {
        int iMax = Math.max(list.size(), list2.size());
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < iMax; i10++) {
            if (i10 < list.size()) {
                arrayList.add(list.get(i10));
            }
            if (i10 < list2.size()) {
                arrayList.add(list2.get(i10));
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public i m35345b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f28283r.get(str);
    }

    /* renamed from: c */
    public List<InetAddress> m35350c(String str) throws UnknownHostException {
        if (TextUtils.isEmpty(str)) {
            return new ArrayList();
        }
        int iM35365i = m35365i();
        if (iM35365i == 0) {
            iM35365i = m35360f(str);
        }
        C6003m0 c6003m0M33733a = iM35365i != 1 ? C5843a0.m33733a(str) : null;
        if (C6158y.m35829b(c6003m0M33733a)) {
            Logger.m32143v(f28264y, "cache is empty, sync query host: " + str);
            c6003m0M33733a = C5925g0.m34276a(str, iM35365i);
        }
        Logger.m32141i(f28264y, str + " resolve source:" + m35333a(iM35365i) + ",result:" + c6003m0M33733a);
        if (!C6158y.m35829b(c6003m0M33733a)) {
            List<String> listM34749d = c6003m0M33733a.m34749d();
            Logger.m32144v(f28264y, "Compound ips of %s:" + listM34749d, str);
            m35315a(listM34749d, str);
            List<InetAddress> listM35821a = C6158y.m35821a(listM34749d);
            if (!listM35821a.isEmpty()) {
                m35347b(c6003m0M33733a.m34753h());
                m35358e(c6003m0M33733a.m34750e());
                m35355d(c6003m0M33733a.m34736a());
                m35361f(c6003m0M33733a.m34751f());
                if (iM35365i == 1 && !m35367k()) {
                    ArrayList arrayList = new ArrayList(listM35821a);
                    if (this.f28279n) {
                        Logger.m32143v(f28264y, "Begin do siteConnect");
                        m35327k(str);
                    } else {
                        C6068r0.m35165a().m35168a(new g(str, arrayList));
                    }
                }
                try {
                    return m35313a(listM35821a);
                } catch (ConcurrentModificationException e10) {
                    e = e10;
                    Logger.m32147w(f28264y, "the ai module has exception: %s ,and skip it", e.getClass().getName());
                    HianalyticsHelper.getInstance().reportException(e, CrashHianalyticsData.EVENT_ID_CRASH);
                    return listM35821a;
                } catch (Throwable th2) {
                    e = th2;
                    Logger.m32147w(f28264y, "the ai module has throwable: %s ,and skip it", e.getClass().getName());
                    HianalyticsHelper.getInstance().reportException(e, CrashHianalyticsData.EVENT_ID_CRASH);
                    return listM35821a;
                }
            }
        }
        return C6158y.m35826b(str);
    }

    /* renamed from: e */
    public C6145x m35357e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C6145x c6145x = this.f28282q.get(str);
        if (c6145x == null) {
            c6145x = new C6145x();
            c6145x.m35763a(m35367k() ? 3 : 2);
            C6145x c6145xPutIfAbsent = this.f28282q.putIfAbsent(str, c6145x);
            if (c6145xPutIfAbsent != null) {
                return c6145xPutIfAbsent;
            }
        }
        return c6145x;
    }

    /* renamed from: f */
    public void m35361f(int i10) {
        this.f28289x.set(Integer.valueOf(i10));
    }

    /* renamed from: b */
    private List<InetAddress> m35319b(List<InetAddress> list, List<InetAddress> list2) {
        List<InetAddress> list3;
        List<InetAddress> list4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(list);
        arrayList.add(list2);
        List<List<InetAddress>> arrayList2 = new ArrayList<>();
        NetworkService networkService = this.f28281p;
        if (networkService != null) {
            arrayList2 = networkService.ipListsSort(arrayList);
        } else {
            arrayList2.addAll(arrayList);
        }
        if (this.f28278m) {
            list3 = arrayList2.get(1);
            list4 = arrayList2.get(0);
        } else {
            list3 = arrayList2.get(0);
            list4 = arrayList2.get(1);
        }
        return m35314a(list3, list4);
    }

    /* renamed from: a */
    public void m35334a() {
        Logger.m32143v(f28264y, "Clear the related datas");
        SharedPreferences.Editor editorEdit = this.f28268c.edit();
        if (editorEdit != null) {
            editorEdit.clear().commit();
            this.f28267b = null;
            C5843a0.m33738b();
            Logger.m32143v(f28264y, "Clear the related datas successfully");
        }
    }

    /* renamed from: c */
    public void m35351c(int i10) {
        InterfaceC5990l0 interfaceC5990l0 = this.f28276k;
        if (interfaceC5990l0 != null) {
            interfaceC5990l0.mo34637a(i10);
        }
    }

    /* renamed from: d */
    public void m35355d(int i10) {
        this.f28285t.set(Integer.valueOf(i10));
    }

    /* renamed from: e */
    public void m35358e(int i10) {
        this.f28287v.set(Integer.valueOf(i10));
    }

    /* renamed from: a */
    public void m35335a(long j10) {
        if (j10 > 0) {
            this.f28280o = j10;
        }
    }

    /* renamed from: b */
    public void m35346b(int i10) {
        int i11 = i10 * 1000;
        if (i11 < 60000 || i11 >= 86400000) {
            Logger.m32145w(f28264y, "the ttl parameter invalid, set to default:600000");
            i11 = 600000;
        }
        C6132w.m35709a(i11);
        Logger.m32143v(f28264y, "setDnsTtl:" + i10);
    }

    /* renamed from: c */
    public void m35352c(boolean z10) {
        this.f28279n = z10;
    }

    /* renamed from: a */
    public void m35336a(Context context, InterfaceC5990l0 interfaceC5990l0) {
        if (context == null) {
            Logger.m32138e(f28264y, "invalid parameter");
            return;
        }
        this.f28275j = context.getApplicationContext();
        if (interfaceC5990l0 != null) {
            Logger.m32143v(f28264y, "enter DnsUtil.doRespone" + interfaceC5990l0);
            this.f28276k = interfaceC5990l0;
        }
        if (this.f28269d) {
            return;
        }
        synchronized (C6093t.class) {
            try {
                if (!this.f28269d) {
                    this.f28269d = true;
                    this.f28284s.execute(new j(context));
                }
            } finally {
            }
        }
    }

    /* renamed from: b */
    public void m35347b(long j10) {
        this.f28286u.set(Long.valueOf(j10));
    }

    /* renamed from: a */
    public void m35337a(AbstractC6081s0.c cVar) {
        if (cVar == null) {
            return;
        }
        this.f28274i = cVar;
    }

    /* renamed from: a */
    public void m35338a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f28283r.remove(str);
        m35324h(str);
    }

    /* renamed from: b */
    public void m35348b(boolean z10) {
        this.f28278m = z10;
    }

    /* renamed from: a */
    public void m35339a(String str, int i10) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        C6145x c6145x = this.f28282q.get(str);
        if (c6145x == null) {
            c6145x = new C6145x();
        }
        c6145x.m35763a(i10);
        this.f28282q.put(str, c6145x);
    }

    /* renamed from: a */
    public void m35340a(String str, i iVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f28283r.put(str, iVar);
    }

    /* renamed from: a */
    public void m35341a(String str, C6145x c6145x) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f28282q.put(str, c6145x);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public <T> void m35342a(String str, T t10) {
        Logger.m32143v(f28264y, "enter DnsUtil.doResponse");
        if (TextUtils.isEmpty(str) || t10 == 0) {
            Logger.m32145w(f28264y, "invalid parameter");
            return;
        }
        int iM35898a = t10 instanceof IOException ? C6171z.m35898a((IOException) t10) : t10 instanceof Integer ? C6171z.m35897a(((Integer) t10).intValue()) : 0;
        int iM35365i = m35365i();
        if (m35349c() != null && iM35898a != 0) {
            long currentTime = Utils.getCurrentTime(true);
            if (iM35365i == 2 && AbstractC6046p4.m34963f().mo34973b(this.f28288w.get().longValue(), currentTime) && !m35331n(str)) {
                this.f28288w.set(Long.valueOf(currentTime));
                Logger.m32141i(f28264y, "network has changed,and dns_type needn't change");
            } else {
                m35326j(str);
            }
        }
        if (iM35898a == 0) {
            m35338a(str);
            return;
        }
        if (m35349c() != null) {
            if (iM35365i == 1) {
                m35349c().mo34638a(str);
            }
            i iVarM35345b = m35345b(str);
            if (iVarM35345b != null) {
                iVarM35345b.m35370a(iM35898a);
            }
        }
    }

    /* renamed from: a */
    private void m35315a(List<String> list, String str) {
        if (list == null || list.size() <= 0) {
            return;
        }
        i iVar = new i();
        iVar.m35371a(list.get(0));
        m35340a(str, iVar);
    }

    /* renamed from: a */
    public void m35343a(boolean z10) {
        if (!z10) {
            this.f28270e = false;
            return;
        }
        if (!this.f28269d) {
            Logger.m32145w(f28264y, "RestClient or DNManager must init first");
            return;
        }
        if (!this.f28271f) {
            synchronized (this.f28272g) {
                try {
                    if (!this.f28271f) {
                        this.f28271f = true;
                        if (this.f28277l == null) {
                            this.f28277l = new C6016n0();
                        }
                        if (TextUtils.isEmpty(this.f28277l.m34876a())) {
                            Logger.m32145w(f28264y, "HttpDns baseUrl is null");
                            return;
                        }
                        this.f28284s.execute(new f());
                    }
                } finally {
                }
            }
        }
        this.f28270e = true;
    }
}
