package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.hms.network.embedded.r0 */
/* loaded from: classes8.dex */
public class C6068r0 {

    /* renamed from: f */
    public static final String f27961f = "TaskManager";

    /* renamed from: g */
    public static final String f27962g = "lookupPool";

    /* renamed from: h */
    public static final String f27963h = "lazyPool";

    /* renamed from: i */
    public static volatile C6068r0 f27964i = null;

    /* renamed from: j */
    public static final int f27965j = 10;

    /* renamed from: a */
    public ExecutorService f27966a;

    /* renamed from: b */
    public ExecutorService f27967b;

    /* renamed from: c */
    public final Object f27968c = new Object();

    /* renamed from: d */
    public ConcurrentHashMap<String, Future> f27969d = new ConcurrentHashMap<>();

    /* renamed from: e */
    public ConcurrentHashMap<String, Future> f27970e = new ConcurrentHashMap<>();

    /* renamed from: com.huawei.hms.network.embedded.r0$a */
    public static class a implements Callable {

        /* renamed from: a */
        public final String f27971a;

        /* renamed from: b */
        public final InterfaceC5938h0 f27972b;

        public a(String str, InterfaceC5938h0 interfaceC5938h0) {
            this.f27971a = str;
            this.f27972b = interfaceC5938h0;
        }

        @Override // java.util.concurrent.Callable
        public List<InetAddress> call() {
            return C6158y.m35821a(this.f27972b.lookup(this.f27971a).m34749d());
        }
    }

    public C6068r0() {
        Logger.m32141i(f27961f, "DNS ThreadPool init!");
        this.f27966a = ExecutorsUtils.newFixedThreadPool(10, f27963h);
        this.f27967b = ExecutorsUtils.newCachedThreadPool(f27962g);
    }

    /* renamed from: a */
    public C6003m0 m35166a(String str) throws UnknownHostException {
        C6003m0 c6003m0M35169b = m35169b(str);
        if (!C6158y.m35829b(c6003m0M35169b)) {
            return c6003m0M35169b;
        }
        Logger.m32145w(f27961f, "dns failed from DnsCallable, domain is :" + str);
        throw new UnknownHostException("Broken system behaviour for dns lookup of " + str);
    }

    /* renamed from: b */
    public C6003m0 m35169b(String str) {
        Future futurePutIfAbsent;
        C6003m0 c6003m0;
        ExecutorService executorService;
        synchronized (this.f27968c) {
            try {
                Future futureSubmit = this.f27969d.get(str);
                if (futureSubmit != null || (futurePutIfAbsent = this.f27969d.putIfAbsent(str, (futureSubmit = (executorService = this.f27967b).submit(new CallableC5951i0(str, executorService))))) == null) {
                    futurePutIfAbsent = futureSubmit;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        try {
            c6003m0 = (C6003m0) futurePutIfAbsent.get(C6158y.m35816a(), TimeUnit.MILLISECONDS);
        } catch (Exception e10) {
            Logger.m32146w(f27961f, "query failed DNS_TIMEOUT", e10);
            c6003m0 = null;
        }
        this.f27969d.remove(str);
        return c6003m0;
    }

    /* renamed from: a */
    public static C6068r0 m35165a() {
        if (f27964i == null) {
            synchronized (C6068r0.class) {
                try {
                    if (f27964i == null) {
                        f27964i = new C6068r0();
                    }
                } finally {
                }
            }
        }
        return f27964i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0031 A[PHI: r2
  0x0031: PHI (r2v3 java.util.concurrent.Future) = (r2v2 java.util.concurrent.Future), (r2v8 java.util.concurrent.Future) binds: [B:5:0x0010, B:7:0x002c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.util.List] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<java.net.InetAddress> m35167a(java.lang.String r6, com.huawei.hms.network.embedded.InterfaceC5938h0 r7) throws java.net.UnknownHostException {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.Object r1 = r5.f27968c
            monitor-enter(r1)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.concurrent.Future> r2 = r5.f27970e     // Catch: java.lang.Throwable -> L2f
            java.lang.Object r2 = r2.get(r6)     // Catch: java.lang.Throwable -> L2f
            java.util.concurrent.Future r2 = (java.util.concurrent.Future) r2     // Catch: java.lang.Throwable -> L2f
            if (r2 != 0) goto L31
            java.lang.String r2 = "TaskManager"
            java.lang.String r3 = "future == null"
            com.huawei.hms.framework.common.Logger.m32141i(r2, r3)     // Catch: java.lang.Throwable -> L2f
            java.util.concurrent.ExecutorService r2 = r5.f27967b     // Catch: java.lang.Throwable -> L2f
            com.huawei.hms.network.embedded.r0$a r3 = new com.huawei.hms.network.embedded.r0$a     // Catch: java.lang.Throwable -> L2f
            r3.<init>(r6, r7)     // Catch: java.lang.Throwable -> L2f
            java.util.concurrent.Future r2 = r2.submit(r3)     // Catch: java.lang.Throwable -> L2f
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.concurrent.Future> r7 = r5.f27970e     // Catch: java.lang.Throwable -> L2f
            java.lang.Object r7 = r7.putIfAbsent(r6, r2)     // Catch: java.lang.Throwable -> L2f
            java.util.concurrent.Future r7 = (java.util.concurrent.Future) r7     // Catch: java.lang.Throwable -> L2f
            if (r7 == 0) goto L31
            goto L32
        L2f:
            r5 = move-exception
            goto L9b
        L31:
            r7 = r2
        L32:
            java.lang.String r2 = "TaskManager"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2f
            r3.<init>()     // Catch: java.lang.Throwable -> L2f
            java.lang.String r4 = "localDnslookup future = "
            r3.append(r4)     // Catch: java.lang.Throwable -> L2f
            r3.append(r7)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L2f
            com.huawei.hms.framework.common.Logger.m32143v(r2, r3)     // Catch: java.lang.Throwable -> L2f
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L2f
            int r1 = com.huawei.hms.network.embedded.C6158y.m35816a()     // Catch: java.lang.Exception -> L58
            long r1 = (long) r1     // Catch: java.lang.Exception -> L58
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Exception -> L58
            java.lang.Object r7 = r7.get(r1, r3)     // Catch: java.lang.Exception -> L58
            java.util.List r7 = (java.util.List) r7     // Catch: java.lang.Exception -> L58
            r0 = r7
            goto L60
        L58:
            r7 = move-exception
            java.lang.String r1 = "TaskManager"
            java.lang.String r2 = "query failed CANCEL_TIMEOUT"
            com.huawei.hms.framework.common.Logger.m32146w(r1, r2, r7)
        L60:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.concurrent.Future> r5 = r5.f27970e
            r5.remove(r6)
            if (r0 == 0) goto L6e
            boolean r5 = r0.isEmpty()
            if (r5 != 0) goto L6e
            return r0
        L6e:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "dns failed from local, domain is :"
            r5.append(r7)
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.String r7 = "TaskManager"
            com.huawei.hms.framework.common.Logger.m32145w(r7, r5)
            java.net.UnknownHostException r5 = new java.net.UnknownHostException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "dns failed from local, domain is :"
            r7.append(r0)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r5.<init>(r6)
            throw r5
        L9b:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L2f
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.C6068r0.m35167a(java.lang.String, com.huawei.hms.network.embedded.h0):java.util.List");
    }

    /* renamed from: a */
    public void m35168a(Runnable runnable) {
        String str;
        try {
            this.f27966a.execute(runnable);
        } catch (RejectedExecutionException unused) {
            str = "the runnable task cannot be accepted for execution";
            Logger.m32143v(f27961f, str);
        } catch (Throwable unused2) {
            str = "the runnable task cannot be accepted for throwable";
            Logger.m32143v(f27961f, str);
        }
    }
}
