package com.huawei.hms.drive;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.huawei.hms.drive.be */
/* loaded from: classes8.dex */
final class C5200be implements InterfaceC5177aj {

    /* renamed from: a */
    final C5198bc f23910a;

    /* renamed from: b */
    final C5201bf f23911b;

    /* renamed from: c */
    final boolean f23912c;

    /* renamed from: d */
    private C5232ci f23913d;

    /* renamed from: e */
    private boolean f23914e;

    /* renamed from: com.huawei.hms.drive.be$a */
    public final class a extends AbstractRunnableC5208bm {

        /* renamed from: a */
        static final /* synthetic */ boolean f23915a = true;

        /* renamed from: b */
        final /* synthetic */ C5200be f23916b;

        /* renamed from: d */
        private final InterfaceC5178ak f23917d;

        /* renamed from: e */
        private boolean f23918e;

        /* renamed from: f */
        private volatile AtomicInteger f23919f;

        /* renamed from: a */
        public AtomicInteger m31100a() {
            return this.f23919f;
        }

        /* renamed from: b */
        public String m31102b() {
            return this.f23916b.f23911b.m31107a().m30970f();
        }

        /* renamed from: c */
        public C5201bf m31103c() {
            return this.f23916b.f23911b;
        }

        /* renamed from: d */
        public C5198bc m31104d() {
            return this.f23916b.f23910a;
        }

        /* renamed from: e */
        public boolean m31105e() {
            return this.f23918e;
        }

        @Override // com.huawei.hms.drive.AbstractRunnableC5208bm
        /* renamed from: f */
        public void mo31106f() {
            this.f23916b.f23913d.m31381a();
            boolean z10 = false;
            try {
                try {
                    try {
                        this.f23917d.onResponse(this.f23916b, this.f23918e ? this.f23916b.m31099h() : this.f23916b.m31098g());
                    } catch (IOException e10) {
                        e = e10;
                        z10 = true;
                        if (z10) {
                            C5269dr.m31692e().mo31656a(4, "Callback failure for " + this.f23916b.m31096e(), e);
                        } else {
                            this.f23917d.onFailure(this.f23916b, e);
                        }
                        this.f23916b.f23910a.m31067v().mo30800a(this);
                    } catch (Throwable th2) {
                        th = th2;
                        z10 = true;
                        this.f23916b.mo30837b();
                        if (!z10) {
                            IOException iOException = new IOException("canceled due to " + th);
                            iOException.addSuppressed(th);
                            this.f23917d.onFailure(this.f23916b, iOException);
                        }
                        throw th;
                    }
                } catch (IOException e11) {
                    e = e11;
                } catch (Throwable th3) {
                    th = th3;
                }
                this.f23916b.f23910a.m31067v().mo30800a(this);
            } catch (Throwable th4) {
                this.f23916b.f23910a.m31067v().mo30800a(this);
                throw th4;
            }
        }

        /* renamed from: a */
        public void m31101a(ExecutorService executorService) {
            if (!f23915a && Thread.holdsLock(this.f23916b.f23910a.m31067v())) {
                throw new AssertionError();
            }
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e10) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e10);
                    this.f23916b.f23913d.m31380a(interruptedIOException);
                    this.f23917d.onFailure(this.f23916b, interruptedIOException);
                    this.f23916b.f23910a.m31067v().mo30800a(this);
                }
            } catch (Throwable th2) {
                this.f23916b.f23910a.m31067v().mo30800a(this);
                throw th2;
            }
        }
    }

    private C5200be(C5198bc c5198bc, C5201bf c5201bf, boolean z10) {
        this.f23910a = c5198bc;
        this.f23911b = c5201bf;
        this.f23912c = z10;
    }

    @Override // com.huawei.hms.drive.InterfaceC5177aj
    /* renamed from: b */
    public void mo30837b() throws IOException {
        this.f23913d.m31390h();
    }

    /* renamed from: c */
    public boolean m31094c() {
        return this.f23913d.m31391i();
    }

    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C5200be clone() {
        return m31092a(this.f23910a, this.f23911b, this.f23912c);
    }

    /* renamed from: e */
    public String m31096e() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(m31094c() ? "canceled " : "");
        sb2.append(this.f23912c ? "web socket" : "call");
        sb2.append(" to ");
        sb2.append(m31097f());
        return sb2.toString();
    }

    /* renamed from: f */
    public String m31097f() {
        return this.f23911b.m31107a().m30977m();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00a6  */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.hms.drive.C5203bh m31098g() throws java.lang.Throwable {
        /*
            r12 = this;
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            com.huawei.hms.drive.bc r0 = r12.f23910a
            java.util.List r0 = r0.m31071z()
            r1.addAll(r0)
            com.huawei.hms.drive.cs r0 = new com.huawei.hms.drive.cs
            com.huawei.hms.drive.bc r2 = r12.f23910a
            r0.<init>(r2)
            r1.add(r0)
            com.huawei.hms.drive.cj r0 = new com.huawei.hms.drive.cj
            com.huawei.hms.drive.bc r2 = r12.f23910a
            com.huawei.hms.drive.ar r2 = r2.m31053h()
            r0.<init>(r2)
            r1.add(r0)
            com.huawei.hms.drive.bq r0 = new com.huawei.hms.drive.bq
            com.huawei.hms.drive.bc r2 = r12.f23910a
            com.huawei.hms.drive.bu r2 = r2.m31054i()
            r0.<init>(r2)
            r1.add(r0)
            com.huawei.hms.drive.by r0 = new com.huawei.hms.drive.by
            com.huawei.hms.drive.bc r2 = r12.f23910a
            r0.<init>(r2)
            r1.add(r0)
            boolean r0 = r12.f23912c
            if (r0 != 0) goto L4b
            com.huawei.hms.drive.bc r0 = r12.f23910a
            java.util.List r0 = r0.m31041A()
            r1.addAll(r0)
        L4b:
            com.huawei.hms.drive.ck r0 = new com.huawei.hms.drive.ck
            boolean r2 = r12.f23912c
            r0.<init>(r2)
            r1.add(r0)
            com.huawei.hms.drive.cp r10 = new com.huawei.hms.drive.cp
            com.huawei.hms.drive.ci r2 = r12.f23913d
            com.huawei.hms.drive.bf r5 = r12.f23911b
            com.huawei.hms.drive.bc r0 = r12.f23910a
            int r7 = r0.m31046b()
            com.huawei.hms.drive.bc r0 = r12.f23910a
            int r8 = r0.m31048c()
            com.huawei.hms.drive.bc r0 = r12.f23910a
            int r9 = r0.m31049d()
            r3 = 0
            r4 = 0
            r0 = r10
            r6 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r0 = 0
            r1 = 0
            com.huawei.hms.drive.bf r2 = r12.f23911b     // Catch: java.lang.Throwable -> L95 java.io.IOException -> L97
            com.huawei.hms.drive.bh r2 = r10.mo31032a(r2)     // Catch: java.lang.Throwable -> L95 java.io.IOException -> L97
            com.huawei.hms.drive.ci r3 = r12.f23913d     // Catch: java.lang.Throwable -> L95 java.io.IOException -> L97
            boolean r3 = r3.m31391i()     // Catch: java.lang.Throwable -> L95 java.io.IOException -> L97
            if (r3 != 0) goto L8a
            com.huawei.hms.drive.ci r12 = r12.f23913d
            r12.m31380a(r0)
            return r2
        L8a:
            com.huawei.hms.drive.C5210bo.m31191a(r2)     // Catch: java.lang.Throwable -> L95 java.io.IOException -> L97
            java.io.IOException r2 = new java.io.IOException     // Catch: java.lang.Throwable -> L95 java.io.IOException -> L97
            java.lang.String r3 = "Canceled"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L95 java.io.IOException -> L97
            throw r2     // Catch: java.lang.Throwable -> L95 java.io.IOException -> L97
        L95:
            r2 = move-exception
            goto La4
        L97:
            r1 = move-exception
            r2 = 1
            com.huawei.hms.drive.ci r3 = r12.f23913d     // Catch: java.lang.Throwable -> La0
            java.io.IOException r1 = r3.m31380a(r1)     // Catch: java.lang.Throwable -> La0
            throw r1     // Catch: java.lang.Throwable -> La0
        La0:
            r1 = move-exception
            r11 = r2
            r2 = r1
            r1 = r11
        La4:
            if (r1 != 0) goto Lab
            com.huawei.hms.drive.ci r12 = r12.f23913d
            r12.m31380a(r0)
        Lab:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.drive.C5200be.m31098g():com.huawei.hms.drive.bh");
    }

    /* renamed from: h */
    public C5203bh m31099h() throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C5242cs(this.f23910a));
        arrayList.add(new C5226cc(this.f23910a));
        return new C5239cp(arrayList, this.f23913d, null, 0, this.f23911b, this, this.f23910a.m31046b(), this.f23910a.m31048c(), this.f23910a.m31049d()).mo31032a(this.f23911b);
    }

    /* renamed from: a */
    public static C5200be m31092a(C5198bc c5198bc, C5201bf c5201bf, boolean z10) {
        C5200be c5200be = new C5200be(c5198bc, c5201bf, z10);
        c5200be.f23913d = new C5232ci(c5198bc, c5200be);
        return c5200be;
    }

    @Override // com.huawei.hms.drive.InterfaceC5177aj
    /* renamed from: a */
    public C5203bh mo30836a() throws IOException {
        synchronized (this) {
            if (!this.f23914e) {
                this.f23914e = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        this.f23913d.m31381a();
        this.f23913d.m31385c();
        try {
            this.f23910a.m31067v().mo30801a(this);
            return m31098g();
        } finally {
            this.f23910a.m31067v().mo30803b(this);
        }
    }
}
