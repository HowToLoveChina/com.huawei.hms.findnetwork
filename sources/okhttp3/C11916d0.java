package okhttp3;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.internal.connection.C11934h;
import okhttp3.internal.connection.C11941o;
import p693ux.C13282g;
import p693ux.C13285j;
import p791xx.C13893h;
import sx.AbstractRunnableC12872b;

/* renamed from: okhttp3.d0 */
/* loaded from: classes9.dex */
public final class C11916d0 implements InterfaceC11919f {

    /* renamed from: a */
    public final C11912b0 f55237a;

    /* renamed from: b */
    public C11941o f55238b;

    /* renamed from: c */
    public final C11918e0 f55239c;

    /* renamed from: d */
    public final boolean f55240d;

    /* renamed from: e */
    public boolean f55241e;

    /* renamed from: okhttp3.d0$a */
    public final class a extends AbstractRunnableC12872b {

        /* renamed from: b */
        public final InterfaceC11921g f55242b;

        /* renamed from: c */
        public boolean f55243c;

        /* renamed from: d */
        public volatile AtomicInteger f55244d;

        public a(InterfaceC11921g interfaceC11921g) {
            super("OkHttp %s", C11916d0.this.m71534i());
            this.f55243c = false;
            this.f55244d = new AtomicInteger(0);
            this.f55242b = interfaceC11921g;
        }

        @Override // sx.AbstractRunnableC12872b
        /* renamed from: l */
        public void mo71536l() {
            C11916d0.this.f55238b.timeoutEnter();
            boolean z10 = false;
            try {
                try {
                    try {
                        this.f55242b.onResponse(C11916d0.this, this.f55243c ? C11916d0.this.m71531d() : C11916d0.this.m71533f());
                    } catch (IOException e10) {
                        e = e10;
                        z10 = true;
                        if (z10) {
                            C13893h.m83291l().mo83257s(4, "Callback failure for " + C11916d0.this.m71535j(), e);
                        } else {
                            this.f55242b.onFailure(C11916d0.this, e);
                        }
                        C11916d0.this.f55237a.m71482m().mo71831g(this);
                    } catch (Throwable th2) {
                        th = th2;
                        z10 = true;
                        C11916d0.this.cancel();
                        if (!z10) {
                            IOException iOException = new IOException("canceled due to " + th);
                            iOException.addSuppressed(th);
                            this.f55242b.onFailure(C11916d0.this, iOException);
                        }
                        throw th;
                    }
                } catch (IOException e11) {
                    e = e11;
                } catch (Throwable th3) {
                    th = th3;
                }
                C11916d0.this.f55237a.m71482m().mo71831g(this);
            } catch (Throwable th4) {
                C11916d0.this.f55237a.m71482m().mo71831g(this);
                throw th4;
            }
        }

        /* renamed from: m */
        public AtomicInteger m71537m() {
            return this.f55244d;
        }

        /* renamed from: n */
        public C11912b0 m71538n() {
            return C11916d0.this.f55237a;
        }

        /* renamed from: o */
        public void m71539o(ExecutorService executorService) {
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e10) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e10);
                    C11916d0.this.f55238b.noMoreExchanges(interruptedIOException);
                    this.f55242b.onFailure(C11916d0.this, interruptedIOException);
                    C11916d0.this.f55237a.m71482m().mo71831g(this);
                }
            } catch (Throwable th2) {
                C11916d0.this.f55237a.m71482m().mo71831g(this);
                throw th2;
            }
        }

        /* renamed from: p */
        public boolean m71540p() {
            return this.f55243c;
        }

        /* renamed from: q */
        public C11916d0 m71541q() {
            return C11916d0.this;
        }

        /* renamed from: r */
        public String m71542r() {
            return C11916d0.this.f55239c.m71573m().m71904l();
        }

        /* renamed from: s */
        public C11918e0 m71543s() {
            return C11916d0.this.f55239c;
        }

        /* renamed from: t */
        public void m71544t(a aVar) {
            this.f55244d = aVar.f55244d;
        }

        /* renamed from: u */
        public void m71545u() {
            this.f55243c = true;
        }
    }

    public C11916d0(C11912b0 c11912b0, C11918e0 c11918e0, boolean z10) {
        this.f55237a = c11912b0;
        this.f55239c = c11918e0;
        this.f55240d = z10;
    }

    /* renamed from: g */
    public static C11916d0 m71529g(C11912b0 c11912b0, C11918e0 c11918e0, boolean z10) {
        C11916d0 c11916d0 = new C11916d0(c11912b0, c11918e0, z10);
        c11916d0.f55238b = new C11941o(c11912b0, c11916d0);
        return c11916d0;
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C11916d0 clone() {
        return m71529g(this.f55237a, this.f55239c, this.f55240d);
    }

    @Override // okhttp3.InterfaceC11919f
    public void cancel() throws IOException {
        this.f55238b.cancel();
    }

    /* renamed from: d */
    public C11922g0 m71531d() throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C13285j(this.f55237a));
        arrayList.add(new C11934h(this.f55237a));
        return new C13282g(arrayList, this.f55238b, null, 0, this.f55239c, this, this.f55237a.m71477g(), this.f55237a.m71468G(), this.f55237a.m71472L()).mo71934c(this.f55239c);
    }

    @Override // okhttp3.InterfaceC11919f
    /* renamed from: e */
    public void mo71532e(InterfaceC11921g interfaceC11921g) {
        synchronized (this) {
            if (this.f55241e) {
                throw new IllegalStateException("Already Executed");
            }
            this.f55241e = true;
        }
        this.f55238b.callStart();
        this.f55237a.m71482m().mo71827b(new a(interfaceC11921g));
    }

    @Override // okhttp3.InterfaceC11919f
    public C11922g0 execute() throws IOException {
        synchronized (this) {
            if (this.f55241e) {
                throw new IllegalStateException("Already Executed");
            }
            this.f55241e = true;
        }
        this.f55238b.timeoutEnter();
        this.f55238b.callStart();
        try {
            this.f55237a.m71482m().m71828c(this);
            return m71533f();
        } finally {
            this.f55237a.m71482m().mo71832h(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00a5  */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public okhttp3.C11922g0 m71533f() throws java.lang.Throwable {
        /*
            r13 = this;
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            okhttp3.b0 r0 = r13.f55237a
            java.util.List r0 = r0.m71490u()
            r1.addAll(r0)
            ux.j r0 = new ux.j
            okhttp3.b0 r2 = r13.f55237a
            r0.<init>(r2)
            r1.add(r0)
            ux.a r0 = new ux.a
            okhttp3.b0 r2 = r13.f55237a
            okhttp3.o r2 = r2.m71481l()
            r0.<init>(r2)
            r1.add(r0)
            tx.a r0 = new tx.a
            okhttp3.b0 r2 = r13.f55237a
            r2.m71491v()
            r10 = 0
            r0.<init>(r10)
            r1.add(r0)
            okhttp3.internal.connection.d r0 = new okhttp3.internal.connection.d
            okhttp3.b0 r2 = r13.f55237a
            r0.<init>(r2)
            r1.add(r0)
            boolean r0 = r13.f55240d
            if (r0 != 0) goto L4b
            okhttp3.b0 r0 = r13.f55237a
            java.util.List r0 = r0.m71493x()
            r1.addAll(r0)
        L4b:
            ux.b r0 = new ux.b
            boolean r2 = r13.f55240d
            r0.<init>(r2)
            r1.add(r0)
            ux.g r11 = new ux.g
            okhttp3.internal.connection.o r2 = r13.f55238b
            okhttp3.e0 r5 = r13.f55239c
            okhttp3.b0 r0 = r13.f55237a
            int r7 = r0.m71477g()
            okhttp3.b0 r0 = r13.f55237a
            int r8 = r0.m71468G()
            okhttp3.b0 r0 = r13.f55237a
            int r9 = r0.m71472L()
            r3 = 0
            r4 = 0
            r0 = r11
            r6 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r0 = 0
            okhttp3.e0 r1 = r13.f55239c     // Catch: java.lang.Throwable -> L94 java.io.IOException -> L96
            okhttp3.g0 r1 = r11.mo71934c(r1)     // Catch: java.lang.Throwable -> L94 java.io.IOException -> L96
            okhttp3.internal.connection.o r2 = r13.f55238b     // Catch: java.lang.Throwable -> L94 java.io.IOException -> L96
            boolean r2 = r2.isCanceled()     // Catch: java.lang.Throwable -> L94 java.io.IOException -> L96
            if (r2 != 0) goto L89
            okhttp3.internal.connection.o r13 = r13.f55238b
            r13.noMoreExchanges(r10)
            return r1
        L89:
            sx.C12875e.m77250g(r1)     // Catch: java.lang.Throwable -> L94 java.io.IOException -> L96
            java.io.IOException r1 = new java.io.IOException     // Catch: java.lang.Throwable -> L94 java.io.IOException -> L96
            java.lang.String r2 = "Canceled"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L94 java.io.IOException -> L96
            throw r1     // Catch: java.lang.Throwable -> L94 java.io.IOException -> L96
        L94:
            r1 = move-exception
            goto La3
        L96:
            r0 = move-exception
            r1 = 1
            okhttp3.internal.connection.o r2 = r13.f55238b     // Catch: java.lang.Throwable -> L9f
            java.io.IOException r0 = r2.noMoreExchanges(r0)     // Catch: java.lang.Throwable -> L9f
            throw r0     // Catch: java.lang.Throwable -> L9f
        L9f:
            r0 = move-exception
            r12 = r1
            r1 = r0
            r0 = r12
        La3:
            if (r0 != 0) goto Laa
            okhttp3.internal.connection.o r13 = r13.f55238b
            r13.noMoreExchanges(r10)
        Laa:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.C11916d0.m71533f():okhttp3.g0");
    }

    /* renamed from: i */
    public String m71534i() {
        return this.f55239c.m71573m().m71911z();
    }

    public boolean isCanceled() {
        return this.f55238b.isCanceled();
    }

    /* renamed from: j */
    public String m71535j() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(isCanceled() ? "canceled " : "");
        sb2.append(this.f55240d ? "web socket" : "call");
        sb2.append(" to ");
        sb2.append(m71534i());
        return sb2.toString();
    }

    @Override // okhttp3.InterfaceC11919f
    public C11918e0 request() {
        return this.f55239c;
    }
}
