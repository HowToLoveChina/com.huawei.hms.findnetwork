package com.huawei.hms.network.embedded;

import com.huawei.hms.network.embedded.C5880c9;
import com.huawei.hms.network.embedded.InterfaceC6023n7;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: com.huawei.hms.network.embedded.d9 */
/* loaded from: classes8.dex */
public final class C5894d9 {

    /* renamed from: q */
    public static final /* synthetic */ boolean f26649q = true;

    /* renamed from: a */
    public final C6062q7 f26650a;

    /* renamed from: b */
    public final C6180z8 f26651b;

    /* renamed from: c */
    public final InterfaceC6100t6 f26652c;

    /* renamed from: d */
    public final AbstractC5932g7 f26653d;

    /* renamed from: e */
    public final C6182za f26654e;

    /* renamed from: f */
    public Object f26655f;

    /* renamed from: g */
    public C6101t7 f26656g;

    /* renamed from: h */
    public C6141w8 f26657h;

    /* renamed from: i */
    public C6167y8 f26658i;

    /* renamed from: j */
    public C6128v8 f26659j;

    /* renamed from: k */
    public boolean f26660k;

    /* renamed from: l */
    public boolean f26661l;

    /* renamed from: m */
    public boolean f26662m;

    /* renamed from: n */
    public boolean f26663n;

    /* renamed from: o */
    public boolean f26664o;

    /* renamed from: p */
    public final int f26665p;

    /* renamed from: com.huawei.hms.network.embedded.d9$a */
    public class a extends C6182za {
        public a() {
        }

        @Override // com.huawei.hms.network.embedded.C6182za
        public void timedOut() {
            C5894d9.this.cancel();
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.d9$b */
    public static final class b extends WeakReference<C5894d9> {

        /* renamed from: a */
        public final Object f26667a;

        public b(C5894d9 c5894d9, Object obj) {
            super(c5894d9);
            this.f26667a = obj;
        }
    }

    public C5894d9(C6062q7 c6062q7, InterfaceC6100t6 interfaceC6100t6) {
        a aVar = new a();
        this.f26654e = aVar;
        this.f26650a = c6062q7;
        this.f26651b = AbstractC5879c8.f26567a.mo34045a(c6062q7.m35083g());
        this.f26652c = interfaceC6100t6;
        this.f26653d = c6062q7.m35088l().create(interfaceC6100t6);
        aVar.timeout(c6062q7.m35078c(), TimeUnit.MILLISECONDS);
        this.f26665p = c6062q7.m35082f();
    }

    private C6048p6 createAddress(C6010m7 c6010m7) {
        SSLSocketFactory sSLSocketFactoryM35070C;
        HostnameVerifier hostnameVerifierM35092p;
        C6126v6 c6126v6M35080d;
        if (c6010m7.m34798i()) {
            sSLSocketFactoryM35070C = this.f26650a.m35070C();
            hostnameVerifierM35092p = this.f26650a.m35092p();
            c6126v6M35080d = this.f26650a.m35080d();
        } else {
            sSLSocketFactoryM35070C = null;
            hostnameVerifierM35092p = null;
            c6126v6M35080d = null;
        }
        return new C6048p6(c6010m7.m34797h(), c6010m7.m34803n(), this.f26650a.m35087k(), this.f26650a.m35069B(), sSLSocketFactoryM35070C, hostnameVerifierM35092p, c6126v6M35080d, this.f26650a.m35100x(), this.f26650a.m35099w(), this.f26650a.m35098v(), this.f26650a.m35084h(), this.f26650a.m35101y());
    }

    private IOException maybeReleaseConnection(IOException iOException, boolean z10) throws IOException {
        C6167y8 c6167y8;
        Socket socketReleaseConnectionNoEvents;
        boolean z11;
        synchronized (this.f26651b) {
            if (z10) {
                try {
                    if (this.f26659j != null) {
                        throw new IllegalStateException("cannot release connection while it is in use");
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            c6167y8 = this.f26658i;
            socketReleaseConnectionNoEvents = (c6167y8 != null && this.f26659j == null && (z10 || this.f26664o)) ? releaseConnectionNoEvents() : null;
            if (this.f26658i != null) {
                c6167y8 = null;
            }
            z11 = this.f26664o && this.f26659j == null;
        }
        C5920f8.m34251a(socketReleaseConnectionNoEvents);
        if (c6167y8 != null) {
            this.f26653d.connectionReleased(this.f26652c, c6167y8);
        }
        if (z11) {
            boolean z12 = iOException != null;
            iOException = timeoutExit(iOException);
            AbstractC5932g7 abstractC5932g7 = this.f26653d;
            InterfaceC6100t6 interfaceC6100t6 = this.f26652c;
            if (z12) {
                abstractC5932g7.callFailed(interfaceC6100t6, iOException);
            } else {
                abstractC5932g7.callEnd(interfaceC6100t6);
            }
        }
        return iOException;
    }

    private IOException timeoutExit(IOException iOException) {
        if (this.f26663n || !this.f26654e.m35961g()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public void acquireConnectionNoEvents(C6167y8 c6167y8) {
        if (!f26649q && !Thread.holdsLock(this.f26651b)) {
            throw new AssertionError();
        }
        if (this.f26658i != null) {
            throw new IllegalStateException();
        }
        this.f26658i = c6167y8;
        c6167y8.f29166p.add(new b(this, this.f26655f));
    }

    public void callStart() {
        this.f26655f = C6013ma.m34863f().mo34330a("response.body().close()");
        this.f26653d.callStart(this.f26652c);
    }

    public boolean canRetry() {
        return this.f26657h.m35748d() && this.f26657h.m35747c();
    }

    public void cancel() {
        C6128v8 c6128v8;
        C6167y8 c6167y8M35744a;
        synchronized (this.f26651b) {
            try {
                this.f26662m = true;
                c6128v8 = this.f26659j;
                C6141w8 c6141w8 = this.f26657h;
                c6167y8M35744a = (c6141w8 == null || c6141w8.m35744a() == null) ? this.f26658i : this.f26657h.m35744a();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (c6128v8 != null) {
            c6128v8.m35616a();
        } else if (c6167y8M35744a != null) {
            c6167y8M35744a.m35861e();
        }
    }

    public void exchangeDoneDueToException() {
        synchronized (this.f26651b) {
            try {
                C6128v8 c6128v8 = this.f26659j;
                if (c6128v8 != null) {
                    c6128v8.m35621c();
                }
                if (this.f26664o) {
                    throw new IllegalStateException();
                }
                this.f26659j = null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public IOException exchangeMessageDone(C6128v8 c6128v8, boolean z10, boolean z11, IOException iOException) {
        boolean z12;
        synchronized (this.f26651b) {
            try {
                C6128v8 c6128v82 = this.f26659j;
                if (c6128v8 != c6128v82) {
                    return iOException;
                }
                boolean z13 = true;
                if (z10) {
                    z12 = !this.f26660k;
                    this.f26660k = true;
                } else {
                    z12 = false;
                }
                if (z11) {
                    if (!this.f26661l) {
                        z12 = true;
                    }
                    this.f26661l = true;
                }
                if (this.f26660k && this.f26661l && z12) {
                    c6128v82.m35619b().f29163m++;
                    this.f26659j = null;
                } else {
                    z13 = false;
                }
                return z13 ? maybeReleaseConnection(iOException, false) : iOException;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public C6141w8 getExchangeFinder() {
        return this.f26657h;
    }

    public C6101t7 getRequest() {
        return this.f26656g;
    }

    public C5880c9.a getSelection() {
        return this.f26657h.m35746b();
    }

    public boolean hasExchange() {
        boolean z10;
        synchronized (this.f26651b) {
            z10 = this.f26659j != null;
        }
        return z10;
    }

    public boolean isCanceled() {
        boolean z10;
        synchronized (this.f26651b) {
            z10 = this.f26662m;
        }
        return z10;
    }

    public C6128v8 newExchange(InterfaceC6023n7.a aVar, boolean z10) {
        synchronized (this.f26651b) {
            if (this.f26664o) {
                throw new IllegalStateException("released");
            }
            if (this.f26659j != null) {
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()");
            }
        }
        C6128v8 c6128v8 = new C6128v8(this, this.f26652c, this.f26653d, this.f26657h, this.f26657h.m35743a(this.f26650a, aVar, z10));
        synchronized (this.f26651b) {
            this.f26659j = c6128v8;
            this.f26660k = false;
            this.f26661l = false;
        }
        return c6128v8;
    }

    public IOException noMoreExchanges(IOException iOException) {
        synchronized (this.f26651b) {
            this.f26664o = true;
        }
        return maybeReleaseConnection(iOException, false);
    }

    public void prepareToConnect(C6101t7 c6101t7) throws IOException {
        C6101t7 c6101t72 = this.f26656g;
        if (c6101t72 != null) {
            if (C5920f8.m34252a(c6101t72.m35423k(), c6101t7.m35423k()) && this.f26657h.m35747c()) {
                return;
            }
            if (this.f26659j != null) {
                throw new IllegalStateException();
            }
            if (this.f26657h != null) {
                maybeReleaseConnection(null, true);
                this.f26657h = null;
            }
        }
        this.f26656g = c6101t7;
        C6141w8 c6141w8 = new C6141w8(this, this.f26651b, createAddress(c6101t7.m35423k()), this.f26652c, this.f26653d, this.f26665p);
        this.f26657h = c6141w8;
        c6141w8.f28856b.m34978a(c6101t7.m35411a("host"));
    }

    public Socket releaseConnectionNoEvents() {
        if (!f26649q && !Thread.holdsLock(this.f26651b)) {
            throw new AssertionError();
        }
        int size = this.f26658i.f29166p.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                i10 = -1;
                break;
            }
            if (this.f26658i.f29166p.get(i10).get() == this) {
                break;
            }
            i10++;
        }
        if (i10 == -1) {
            throw new IllegalStateException();
        }
        C6167y8 c6167y8 = this.f26658i;
        c6167y8.f29166p.remove(i10);
        this.f26658i = null;
        if (c6167y8.f29166p.isEmpty()) {
            c6167y8.f29167q = System.nanoTime();
            if (this.f26651b.m35933b(c6167y8)) {
                return c6167y8.mo35838c();
            }
        }
        return null;
    }

    public C5855ac timeout() {
        return this.f26654e;
    }

    public void timeoutEarlyExit() {
        if (this.f26663n) {
            throw new IllegalStateException();
        }
        this.f26663n = true;
        this.f26654e.m35961g();
    }

    public void timeoutEnter() {
        this.f26654e.m35960f();
    }
}
