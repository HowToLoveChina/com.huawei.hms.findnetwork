package com.huawei.hms.network.embedded;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.huawei.hms.network.embedded.s7 */
/* loaded from: classes8.dex */
public final class C6088s7 implements InterfaceC6100t6 {

    /* renamed from: a */
    public final C6062q7 f28205a;

    /* renamed from: b */
    public C5894d9 f28206b;

    /* renamed from: c */
    public final C6101t7 f28207c;

    /* renamed from: d */
    public final boolean f28208d;

    /* renamed from: e */
    public boolean f28209e;

    /* renamed from: com.huawei.hms.network.embedded.s7$a */
    public final class a extends AbstractRunnableC5893d8 {

        /* renamed from: f */
        public static final /* synthetic */ boolean f28210f = true;

        /* renamed from: b */
        public final InterfaceC6113u6 f28211b;

        /* renamed from: c */
        public boolean f28212c;

        /* renamed from: d */
        public volatile AtomicInteger f28213d;

        public a(InterfaceC6113u6 interfaceC6113u6) {
            super("OkHttp %s", C6088s7.this.m35282c());
            this.f28212c = false;
            this.f28213d = new AtomicInteger(0);
            this.f28211b = interfaceC6113u6;
        }

        /* renamed from: a */
        public void m35284a(a aVar) {
            this.f28213d = aVar.f28213d;
        }

        @Override // com.huawei.hms.network.embedded.AbstractRunnableC5893d8
        /* renamed from: b */
        public void mo34106b() {
            C6088s7.this.f28206b.timeoutEnter();
            boolean z10 = false;
            try {
                try {
                    try {
                        this.f28211b.onResponse(C6088s7.this, this.f28212c ? C6088s7.this.m35280a() : C6088s7.this.m35281b());
                    } catch (IOException e10) {
                        e = e10;
                        z10 = true;
                        if (z10) {
                            C6013ma.m34863f().mo34331a(4, "Callback failure for " + C6088s7.this.m35283d(), e);
                        } else {
                            this.f28211b.onFailure(C6088s7.this, e);
                        }
                        C6088s7.this.f28205a.m35086j().mo34127b(this);
                    } catch (Throwable th2) {
                        th = th2;
                        z10 = true;
                        C6088s7.this.cancel();
                        if (!z10) {
                            IOException iOException = new IOException("canceled due to " + th);
                            iOException.addSuppressed(th);
                            this.f28211b.onFailure(C6088s7.this, iOException);
                        }
                        throw th;
                    }
                } catch (IOException e11) {
                    e = e11;
                } catch (Throwable th3) {
                    th = th3;
                }
                C6088s7.this.f28205a.m35086j().mo34127b(this);
            } catch (Throwable th4) {
                C6088s7.this.f28205a.m35086j().mo34127b(this);
                throw th4;
            }
        }

        /* renamed from: c */
        public AtomicInteger m35286c() {
            return this.f28213d;
        }

        /* renamed from: d */
        public C6062q7 m35287d() {
            return C6088s7.this.f28205a;
        }

        /* renamed from: e */
        public boolean m35288e() {
            return this.f28212c;
        }

        /* renamed from: f */
        public C6088s7 m35289f() {
            return C6088s7.this;
        }

        /* renamed from: g */
        public String m35290g() {
            return C6088s7.this.f28207c.m35423k().m34797h();
        }

        /* renamed from: h */
        public C6101t7 m35291h() {
            return C6088s7.this.f28207c;
        }

        /* renamed from: i */
        public void m35292i() {
            this.f28212c = true;
        }

        /* renamed from: a */
        public void m35285a(ExecutorService executorService) {
            if (!f28210f && Thread.holdsLock(C6088s7.this.f28205a.m35086j())) {
                throw new AssertionError();
            }
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e10) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e10);
                    C6088s7.this.f28206b.noMoreExchanges(interruptedIOException);
                    this.f28211b.onFailure(C6088s7.this, interruptedIOException);
                    C6088s7.this.f28205a.m35086j().mo34127b(this);
                }
            } catch (Throwable th2) {
                C6088s7.this.f28205a.m35086j().mo34127b(this);
                throw th2;
            }
        }
    }

    public C6088s7(C6062q7 c6062q7, C6101t7 c6101t7, boolean z10) {
        this.f28205a = c6062q7;
        this.f28207c = c6101t7;
        this.f28208d = z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00a5  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.hms.network.embedded.C6127v7 m35281b() throws java.lang.Throwable {
        /*
            r11 = this;
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            com.huawei.hms.network.embedded.q7 r0 = r11.f28205a
            java.util.List r0 = r0.m35093q()
            r1.addAll(r0)
            com.huawei.hms.network.embedded.n9 r0 = new com.huawei.hms.network.embedded.n9
            com.huawei.hms.network.embedded.q7 r2 = r11.f28205a
            r0.<init>(r2)
            r1.add(r0)
            com.huawei.hms.network.embedded.e9 r0 = new com.huawei.hms.network.embedded.e9
            com.huawei.hms.network.embedded.q7 r2 = r11.f28205a
            com.huawei.hms.network.embedded.c7 r2 = r2.m35085i()
            r0.<init>(r2)
            r1.add(r0)
            com.huawei.hms.network.embedded.i8 r0 = new com.huawei.hms.network.embedded.i8
            com.huawei.hms.network.embedded.q7 r2 = r11.f28205a
            com.huawei.hms.network.embedded.n8 r2 = r2.m35094r()
            r0.<init>(r2)
            r1.add(r0)
            com.huawei.hms.network.embedded.t8 r0 = new com.huawei.hms.network.embedded.t8
            com.huawei.hms.network.embedded.q7 r2 = r11.f28205a
            r0.<init>(r2)
            r1.add(r0)
            boolean r0 = r11.f28208d
            if (r0 != 0) goto L4b
            com.huawei.hms.network.embedded.q7 r0 = r11.f28205a
            java.util.List r0 = r0.m35095s()
            r1.addAll(r0)
        L4b:
            com.huawei.hms.network.embedded.f9 r0 = new com.huawei.hms.network.embedded.f9
            boolean r2 = r11.f28208d
            r0.<init>(r2)
            r1.add(r0)
            com.huawei.hms.network.embedded.k9 r10 = new com.huawei.hms.network.embedded.k9
            com.huawei.hms.network.embedded.d9 r2 = r11.f28206b
            com.huawei.hms.network.embedded.t7 r5 = r11.f28207c
            com.huawei.hms.network.embedded.q7 r0 = r11.f28205a
            int r7 = r0.m35081e()
            com.huawei.hms.network.embedded.q7 r0 = r11.f28205a
            int r8 = r0.m35102z()
            com.huawei.hms.network.embedded.q7 r0 = r11.f28205a
            int r9 = r0.m35071D()
            r3 = 0
            r4 = 0
            r0 = r10
            r6 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r0 = 0
            com.huawei.hms.network.embedded.t7 r1 = r11.f28207c     // Catch: java.lang.Throwable -> L94 java.io.IOException -> L96
            com.huawei.hms.network.embedded.v7 r1 = r10.mo34620a(r1)     // Catch: java.lang.Throwable -> L94 java.io.IOException -> L96
            com.huawei.hms.network.embedded.d9 r2 = r11.f28206b     // Catch: java.lang.Throwable -> L94 java.io.IOException -> L96
            boolean r2 = r2.isCanceled()     // Catch: java.lang.Throwable -> L94 java.io.IOException -> L96
            if (r2 != 0) goto L89
            com.huawei.hms.network.embedded.d9 r11 = r11.f28206b
            r11.noMoreExchanges(r0)
            return r1
        L89:
            com.huawei.hms.network.embedded.C5920f8.m34248a(r1)     // Catch: java.lang.Throwable -> L94 java.io.IOException -> L96
            java.io.IOException r1 = new java.io.IOException     // Catch: java.lang.Throwable -> L94 java.io.IOException -> L96
            java.lang.String r2 = "Canceled"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L94 java.io.IOException -> L96
            throw r1     // Catch: java.lang.Throwable -> L94 java.io.IOException -> L96
        L94:
            r1 = move-exception
            goto L98
        L96:
            r1 = move-exception
            goto L9a
        L98:
            r2 = 0
            goto La3
        L9a:
            com.huawei.hms.network.embedded.d9 r2 = r11.f28206b     // Catch: java.lang.Throwable -> La1
            java.io.IOException r1 = r2.noMoreExchanges(r1)     // Catch: java.lang.Throwable -> La1
            throw r1     // Catch: java.lang.Throwable -> La1
        La1:
            r1 = move-exception
            r2 = 1
        La3:
            if (r2 != 0) goto Laa
            com.huawei.hms.network.embedded.d9 r11 = r11.f28206b
            r11.noMoreExchanges(r0)
        Laa:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.C6088s7.m35281b():com.huawei.hms.network.embedded.v7");
    }

    /* renamed from: c */
    public String m35282c() {
        return this.f28207c.m35423k().m34807r();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6100t6
    public void cancel() {
        this.f28206b.cancel();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6100t6
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public C6088s7 m85659clone() {
        return m35279a(this.f28205a, this.f28207c, this.f28208d);
    }

    /* renamed from: d */
    public String m35283d() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(isCanceled() ? "canceled " : "");
        sb2.append(this.f28208d ? "web socket" : "call");
        sb2.append(" to ");
        sb2.append(m35282c());
        return sb2.toString();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6100t6
    public void enqueue(InterfaceC6113u6 interfaceC6113u6) {
        synchronized (this) {
            if (this.f28209e) {
                throw new IllegalStateException("Already Executed");
            }
            this.f28209e = true;
        }
        this.f28206b.callStart();
        this.f28205a.m35086j().mo34124a(new a(interfaceC6113u6));
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6100t6
    public C6127v7 execute() throws IOException {
        synchronized (this) {
            if (this.f28209e) {
                throw new IllegalStateException("Already Executed");
            }
            this.f28209e = true;
        }
        this.f28206b.timeoutEnter();
        this.f28206b.callStart();
        try {
            this.f28205a.m35086j().mo34125a(this);
            return m35281b();
        } finally {
            this.f28205a.m35086j().mo34128b(this);
        }
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6100t6
    public boolean isCanceled() {
        return this.f28206b.isCanceled();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6100t6
    public synchronized boolean isExecuted() {
        return this.f28209e;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6100t6
    public C6101t7 request() {
        return this.f28207c;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6100t6
    public C5855ac timeout() {
        return this.f28206b.timeout();
    }

    /* renamed from: a */
    public static C6088s7 m35279a(C6062q7 c6062q7, C6101t7 c6101t7, boolean z10) {
        C6088s7 c6088s7 = new C6088s7(c6062q7, c6101t7, z10);
        c6088s7.f28206b = new C5894d9(c6062q7, c6088s7);
        return c6088s7;
    }

    /* renamed from: a */
    public C6127v7 m35280a() throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C6025n9(this.f28205a));
        arrayList.add(new C6154x8(this.f28205a));
        return new C5986k9(arrayList, this.f28206b, null, 0, this.f28207c, this, this.f28205a.m35081e(), this.f28205a.m35102z(), this.f28205a.m35071D()).mo34620a(this.f28207c);
    }
}
