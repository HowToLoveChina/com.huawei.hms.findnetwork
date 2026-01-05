package p712vm;

import com.huawei.secure.android.common.ssl.SecureX509TrustManager;
import gu.C10048b;
import java.io.IOException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import okhttp3.C11912b0;
import okhttp3.HttpRequestBuilder;
import okhttp3.HttpResponseBuilder;
import okhttp3.C11945l;
import okhttp3.C11949p;
import p015ak.C0213f;
import p373iu.C10617e;
import p373iu.C10618f;
import p399jk.AbstractC10896a;
import p581qk.AbstractC12367d;
import p616rk.C12515a;

/* renamed from: vm.a */
/* loaded from: classes6.dex */
public class C13468a {

    /* renamed from: c */
    public static final C13468a f60654c = new C13468a();

    /* renamed from: d */
    public static List<b> f60655d = new ArrayList();

    /* renamed from: a */
    public boolean f60656a = false;

    /* renamed from: b */
    public String f60657b;

    /* renamed from: vm.a$c */
    public static class c {

        /* renamed from: a */
        public static final List<String> f60660a = new ArrayList();

        /* renamed from: a */
        public static boolean m81107a() {
            List<String> list = f60660a;
            synchronized (list) {
                try {
                    if (!list.isEmpty()) {
                        return false;
                    }
                    list.add("Ping-Lock");
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        /* renamed from: b */
        public static void m81108b() {
            List<String> list = f60660a;
            synchronized (list) {
                list.clear();
                list.notifyAll();
            }
        }

        /* renamed from: c */
        public static void m81109c() {
            while (true) {
                List<String> list = f60660a;
                synchronized (list) {
                    if (list.isEmpty()) {
                        return;
                    }
                    try {
                        list.wait(400L);
                    } catch (InterruptedException e10) {
                        AbstractC10896a.m65885d("Lock", "lock interrupted " + e10);
                    }
                }
            }
        }
    }

    /* renamed from: vm.a$d */
    public static class d {

        /* renamed from: a */
        public static C11912b0 f60661a;

        /* renamed from: a */
        public static C11912b0 m81110a() {
            C11912b0 c11912b0;
            synchronized (d.class) {
                if (f60661a == null) {
                    C11912b0.c cVar = new C11912b0.c();
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    cVar.m71507d(10L, timeUnit);
                    cVar.m71519p(10L, timeUnit);
                    cVar.m71522s(10L, timeUnit);
                    try {
                        cVar.m71521r(C10618f.m65076c(C0213f.m1377a(), C10048b.m62471c()), new SecureX509TrustManager(C0213f.m1377a()));
                        cVar.m71515l(C10617e.f51042j);
                    } catch (IOException | IllegalAccessException | GeneralSecurityException unused) {
                        AbstractC10896a.m65888w("Ping", "Use Default Dispatcher OkHttpClient");
                    }
                    cVar.m71508e(new C11945l(8, 5L, TimeUnit.MINUTES));
                    C11949p c11949p = new C11949p();
                    c11949p.m71838o(64);
                    cVar.m71510g(c11949p);
                    f60661a = cVar.m71505b();
                    c11912b0 = f60661a;
                } else {
                    c11912b0 = f60661a;
                }
            }
            return c11912b0;
        }
    }

    /* renamed from: vm.a$e */
    public static class e extends AbstractC12367d {

        /* renamed from: a */
        public String f60662a;

        /* renamed from: b */
        public b f60663b = new b();

        /* renamed from: c */
        public CountDownLatch f60664c;

        public e(String str, CountDownLatch countDownLatch) {
            this.f60662a = str;
            this.f60664c = countDownLatch;
            C13468a.f60655d.add(this.f60663b);
        }

        /* JADX WARN: Removed duplicated region for block: B:56:0x0028  */
        /* renamed from: c */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.String m81111c(java.lang.String r4) {
            /*
                r3 = this;
                java.lang.String r3 = ""
                int r0 = r4.hashCode()     // Catch: fk.C9721b -> L1c
                r1 = 79220(0x13574, float:1.11011E-40)
                r2 = 1
                if (r0 == r1) goto L1e
                r1 = 62970894(0x3c0dc0e, float:1.1335268E-36)
                if (r0 == r1) goto L12
                goto L28
            L12:
                java.lang.String r0 = "BASIC"
                boolean r4 = r4.equals(r0)     // Catch: fk.C9721b -> L1c
                if (r4 == 0) goto L28
                r4 = 0
                goto L29
            L1c:
                r4 = move-exception
                goto L7d
            L1e:
                java.lang.String r0 = "PIM"
                boolean r4 = r4.equals(r0)     // Catch: fk.C9721b -> L1c
                if (r4 == 0) goto L28
                r4 = r2
                goto L29
            L28:
                r4 = -1
            L29:
                if (r4 == 0) goto L51
                if (r4 == r2) goto L2f
                r4 = r3
                goto L72
            L2f:
                tm.c r4 = tm.C13040c.m78609F()     // Catch: fk.C9721b -> L1c
                java.lang.String r4 = r4.m78671x()     // Catch: fk.C9721b -> L1c
                if (r4 == 0) goto L72
                boolean r0 = r4.isEmpty()     // Catch: fk.C9721b -> L1c
                if (r0 != 0) goto L72
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: fk.C9721b -> L1c
                r0.<init>()     // Catch: fk.C9721b -> L1c
                r0.append(r4)     // Catch: fk.C9721b -> L1c
                java.lang.String r4 = "/pimds/status.html"
                r0.append(r4)     // Catch: fk.C9721b -> L1c
                java.lang.String r4 = r0.toString()     // Catch: fk.C9721b -> L1c
                goto L72
            L51:
                tm.c r4 = tm.C13040c.m78609F()     // Catch: fk.C9721b -> L1c
                java.lang.String r4 = r4.m78662o()     // Catch: fk.C9721b -> L1c
                if (r4 == 0) goto L72
                boolean r0 = r4.isEmpty()     // Catch: fk.C9721b -> L1c
                if (r0 != 0) goto L72
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: fk.C9721b -> L1c
                r0.<init>()     // Catch: fk.C9721b -> L1c
                r0.append(r4)     // Catch: fk.C9721b -> L1c
                java.lang.String r4 = "/basic/status.html"
                r0.append(r4)     // Catch: fk.C9721b -> L1c
                java.lang.String r4 = r0.toString()     // Catch: fk.C9721b -> L1c
            L72:
                if (r4 == 0) goto L7c
                boolean r0 = r4.isEmpty()     // Catch: fk.C9721b -> L1c
                if (r0 == 0) goto L7b
                goto L7c
            L7b:
                return r4
            L7c:
                return r3
            L7d:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "get ping domain error. "
                r0.append(r1)
                java.lang.String r4 = r4.getMessage()
                r0.append(r4)
                java.lang.String r4 = r0.toString()
                java.lang.String r0 = "Ping"
                p399jk.AbstractC10896a.m65886e(r0, r4)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: p712vm.C13468a.e.m81111c(java.lang.String):java.lang.String");
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strM81111c = "";
            HttpResponseBuilder HttpResponseBuilderExecute = null;
            try {
                try {
                    AbstractC10896a.m65885d("Ping", "network check, target = " + this.f60662a);
                    strM81111c = m81111c(this.f60662a);
                } catch (IOException unused) {
                    AbstractC10896a.m65885d("Ping", "network unreachable, url = " + strM81111c + " startTime:" + String.valueOf(jCurrentTimeMillis) + " totalTime:" + String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                    this.f60663b.m81106d();
                    if (HttpResponseBuilderExecute != null) {
                    }
                }
                if (strM81111c.isEmpty()) {
                    this.f60664c.countDown();
                    return;
                }
                URL url = new URL(strM81111c);
                this.f60663b.m81103a(this.f60662a);
                HttpResponseBuilderExecute = d.m81110a().m71495z(new HttpRequestBuilder.a().m71587n(url).m71575b()).execute();
                AbstractC10896a.m65885d("Ping", "network reachable, url = " + strM81111c + ", response code = " + HttpResponseBuilderExecute.m71597u() + " startTime:" + String.valueOf(jCurrentTimeMillis) + " totalTime:" + String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                this.f60663b.m81105c();
                HttpResponseBuilderExecute.close();
                this.f60664c.countDown();
            } catch (Throwable th2) {
                if (HttpResponseBuilderExecute != null) {
                    HttpResponseBuilderExecute.close();
                }
                this.f60664c.countDown();
                throw th2;
            }
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public boolean syncLock() {
            return false;
        }
    }

    /* renamed from: c */
    public static C13468a m81100c() {
        return f60654c;
    }

    /* renamed from: b */
    public boolean m81101b() {
        try {
            if (c.m81107a()) {
                CountDownLatch countDownLatch = new CountDownLatch(1);
                if (new SecureRandom().nextInt(2) == 0) {
                    C12515a.m75110o().m75172d(new e("BASIC", countDownLatch));
                } else {
                    C12515a.m75110o().m75172d(new e("PIM", countDownLatch));
                }
                m81102d(countDownLatch);
            } else {
                c.m81109c();
            }
            c.m81108b();
            return this.f60656a;
        } catch (Throwable th2) {
            c.m81108b();
            throw th2;
        }
    }

    /* renamed from: d */
    public final void m81102d(CountDownLatch countDownLatch) {
        try {
            if (!countDownLatch.await(10L, TimeUnit.SECONDS)) {
                AbstractC10896a.m65885d("Ping", "waitResult await false");
            }
        } catch (InterruptedException e10) {
            AbstractC10896a.m65885d("Ping", "InterruptedException" + e10.getMessage());
        }
        StringBuilder sb2 = new StringBuilder("[");
        boolean z10 = false;
        for (b bVar : f60655d) {
            sb2.append(bVar.toString());
            sb2.append(",");
            if (bVar.m81104b()) {
                z10 = true;
            }
        }
        sb2.deleteCharAt(sb2.length() - 1);
        sb2.append("]");
        this.f60657b = sb2.toString();
        this.f60656a = z10;
        f60655d.clear();
    }

    public String toString() {
        return this.f60657b;
    }

    /* renamed from: vm.a$b */
    public static class b {

        /* renamed from: a */
        public boolean f60658a;

        /* renamed from: b */
        public String f60659b;

        public b() {
            this.f60658a = false;
            this.f60659b = "";
        }

        /* renamed from: a */
        public void m81103a(String str) {
            this.f60659b = str;
        }

        /* renamed from: b */
        public boolean m81104b() {
            return this.f60658a;
        }

        /* renamed from: c */
        public void m81105c() {
            this.f60658a = true;
        }

        /* renamed from: d */
        public void m81106d() {
            this.f60658a = false;
        }

        public String toString() {
            return this.f60659b + ":" + this.f60658a;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }
}
