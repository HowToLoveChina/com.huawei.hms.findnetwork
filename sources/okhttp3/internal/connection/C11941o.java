package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.AbstractC11953t;
import okhttp3.C11911b;
import okhttp3.C11912b0;
import okhttp3.C11918e0;
import okhttp3.C11923h;
import okhttp3.C11958y;
import okhttp3.InterfaceC11919f;
import okhttp3.InterfaceC11959z;
import okhttp3.internal.connection.C11940n;
import p022ay.C1050a0;
import p022ay.C1053c;
import p791xx.C13893h;
import sx.AbstractC12871a;
import sx.C12875e;

/* renamed from: okhttp3.internal.connection.o */
/* loaded from: classes9.dex */
public final class C11941o {

    /* renamed from: a */
    public final C11912b0 f55453a;

    /* renamed from: b */
    public final C11937k f55454b;

    /* renamed from: c */
    public final InterfaceC11919f f55455c;

    /* renamed from: d */
    public final AbstractC11953t f55456d;

    /* renamed from: e */
    public final C1053c f55457e;

    /* renamed from: f */
    public Object f55458f;

    /* renamed from: g */
    public C11918e0 f55459g;

    /* renamed from: h */
    public C11933g f55460h;

    /* renamed from: i */
    public C11935i f55461i;

    /* renamed from: j */
    public C11932f f55462j;

    /* renamed from: k */
    public boolean f55463k;

    /* renamed from: l */
    public boolean f55464l;

    /* renamed from: m */
    public boolean f55465m;

    /* renamed from: n */
    public boolean f55466n;

    /* renamed from: o */
    public boolean f55467o;

    /* renamed from: p */
    public final int f55468p;

    /* renamed from: okhttp3.internal.connection.o$a */
    public class a extends C1053c {
        public a() {
        }

        @Override // p022ay.C1053c
        public void timedOut() throws IOException {
            C11941o.this.cancel();
        }
    }

    /* renamed from: okhttp3.internal.connection.o$b */
    public static final class b extends WeakReference<C11941o> {

        /* renamed from: a */
        public final Object f55470a;

        public b(C11941o c11941o, Object obj) {
            super(c11941o);
            this.f55470a = obj;
        }
    }

    public C11941o(C11912b0 c11912b0, InterfaceC11919f interfaceC11919f) {
        a aVar = new a();
        this.f55457e = aVar;
        this.f55453a = c11912b0;
        this.f55454b = AbstractC12871a.f58633a.mo71503h(c11912b0.m71479j());
        this.f55455c = interfaceC11919f;
        this.f55456d = c11912b0.m71484o().mo71841a(interfaceC11919f);
        aVar.timeout(c11912b0.m71475d(), TimeUnit.MILLISECONDS);
        this.f55468p = c11912b0.m71478i();
    }

    private C11911b createAddress(C11958y c11958y) {
        SSLSocketFactory sSLSocketFactoryM71471K;
        HostnameVerifier hostnameVerifierM71488s;
        C11923h c11923hM71476f;
        if (c11958y.m71905m()) {
            sSLSocketFactoryM71471K = this.f55453a.m71471K();
            hostnameVerifierM71488s = this.f55453a.m71488s();
            c11923hM71476f = this.f55453a.m71476f();
        } else {
            sSLSocketFactoryM71471K = null;
            hostnameVerifierM71488s = null;
            c11923hM71476f = null;
        }
        return new C11911b(c11958y.m71904l(), c11958y.m71909w(), this.f55453a.m71483n(), this.f55453a.m71470J(), sSLSocketFactoryM71471K, hostnameVerifierM71488s, c11923hM71476f, this.f55453a.m71466E(), this.f55453a.m71465D(), this.f55453a.m71464C(), this.f55453a.m71480k(), this.f55453a.m71467F());
    }

    private IOException maybeReleaseConnection(IOException iOException, boolean z10) throws IOException {
        C11935i c11935i;
        Socket socketReleaseConnectionNoEvents;
        boolean z11;
        synchronized (this.f55454b) {
            if (z10) {
                try {
                    if (this.f55462j != null) {
                        throw new IllegalStateException("cannot release connection while it is in use");
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            c11935i = this.f55461i;
            socketReleaseConnectionNoEvents = (c11935i != null && this.f55462j == null && (z10 || this.f55467o)) ? releaseConnectionNoEvents() : null;
            if (this.f55461i != null) {
                c11935i = null;
            }
            z11 = this.f55467o && this.f55462j == null;
        }
        C12875e.m77251h(socketReleaseConnectionNoEvents);
        if (c11935i != null) {
            this.f55456d.connectionReleased(this.f55455c, c11935i);
        }
        if (z11) {
            boolean z12 = iOException != null;
            iOException = timeoutExit(iOException);
            if (z12) {
                this.f55456d.callFailed(this.f55455c, iOException);
            } else {
                this.f55456d.callEnd(this.f55455c);
            }
        }
        return iOException;
    }

    private IOException timeoutExit(IOException iOException) {
        if (this.f55466n || !this.f55457e.exit()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public void acquireConnectionNoEvents(C11935i c11935i) {
        if (this.f55461i != null) {
            throw new IllegalStateException();
        }
        this.f55461i = c11935i;
        c11935i.f55422p.add(new b(this, this.f55458f));
    }

    public void callStart() {
        this.f55458f = C13893h.m83291l().mo83255o("response.body().close()");
        this.f55456d.callStart(this.f55455c);
    }

    public boolean canRetry() {
        return this.f55460h.m71705g() && this.f55460h.m71704f();
    }

    public void cancel() throws IOException {
        C11932f c11932f;
        C11935i c11935iM71699a;
        synchronized (this.f55454b) {
            try {
                this.f55465m = true;
                c11932f = this.f55462j;
                C11933g c11933g = this.f55460h;
                c11935iM71699a = (c11933g == null || c11933g.m71699a() == null) ? this.f55461i : this.f55460h.m71699a();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (c11932f != null) {
            c11932f.m71682b();
        } else if (c11935iM71699a != null) {
            c11935iM71699a.m71712d();
        }
    }

    public void exchangeDoneDueToException() {
        synchronized (this.f55454b) {
            try {
                if (this.f55467o) {
                    throw new IllegalStateException();
                }
                this.f55462j = null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public IOException exchangeMessageDone(C11932f c11932f, boolean z10, boolean z11, IOException iOException) {
        boolean z12;
        synchronized (this.f55454b) {
            try {
                C11932f c11932f2 = this.f55462j;
                if (c11932f != c11932f2) {
                    return iOException;
                }
                boolean z13 = true;
                if (z10) {
                    z12 = !this.f55463k;
                    this.f55463k = true;
                } else {
                    z12 = false;
                }
                if (z11) {
                    if (!this.f55464l) {
                        z12 = true;
                    }
                    this.f55464l = true;
                }
                if (this.f55463k && this.f55464l && z12) {
                    c11932f2.m71683c().f55419m++;
                    this.f55462j = null;
                } else {
                    z13 = false;
                }
                return z13 ? maybeReleaseConnection(iOException, false) : iOException;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public C11933g getExchangeFinder() {
        return this.f55460h;
    }

    public C11918e0 getRequest() {
        return this.f55459g;
    }

    public C11940n.a getSelection() {
        return this.f55460h.m71703e();
    }

    public boolean hasExchange() {
        boolean z10;
        synchronized (this.f55454b) {
            z10 = this.f55462j != null;
        }
        return z10;
    }

    public boolean isCanceled() {
        boolean z10;
        synchronized (this.f55454b) {
            z10 = this.f55465m;
        }
        return z10;
    }

    public C11932f newExchange(InterfaceC11959z.a aVar, boolean z10) {
        synchronized (this.f55454b) {
            if (this.f55467o) {
                throw new IllegalStateException("released");
            }
            if (this.f55462j != null) {
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()");
            }
        }
        C11932f c11932f = new C11932f(this, this.f55455c, this.f55456d, this.f55460h, this.f55460h.m71700b(this.f55453a, aVar, z10));
        synchronized (this.f55454b) {
            this.f55462j = c11932f;
            this.f55463k = false;
            this.f55464l = false;
        }
        return c11932f;
    }

    public IOException noMoreExchanges(IOException iOException) {
        synchronized (this.f55454b) {
            this.f55467o = true;
        }
        return maybeReleaseConnection(iOException, false);
    }

    public void prepareToConnect(C11918e0 c11918e0) throws IOException {
        C11918e0 c11918e02 = this.f55459g;
        if (c11918e02 != null) {
            if (C12875e.m77235F(c11918e02.m71573m(), c11918e0.m71573m()) && this.f55460h.m71704f()) {
                return;
            }
            if (this.f55462j != null) {
                throw new IllegalStateException();
            }
            if (this.f55460h != null) {
                maybeReleaseConnection(null, true);
                this.f55460h = null;
            }
        }
        this.f55459g = c11918e0;
        C11933g c11933g = new C11933g(this, this.f55454b, createAddress(c11918e0.m71573m()), this.f55455c, this.f55456d, this.f55468p);
        this.f55460h = c11933g;
        c11933g.f55396b.m71458k(c11918e0.m71565e("host"));
    }

    public Socket releaseConnectionNoEvents() {
        int size = this.f55461i.f55422p.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                i10 = -1;
                break;
            }
            if (this.f55461i.f55422p.get(i10).get() == this) {
                break;
            }
            i10++;
        }
        if (i10 == -1) {
            throw new IllegalStateException();
        }
        C11935i c11935i = this.f55461i;
        c11935i.f55422p.remove(i10);
        this.f55461i = null;
        if (c11935i.f55422p.isEmpty()) {
            c11935i.f55423q = System.nanoTime();
            if (this.f55454b.m71740f(c11935i)) {
                return c11935i.m71731w();
            }
        }
        return null;
    }

    public C1050a0 timeout() {
        return this.f55457e;
    }

    public void timeoutEarlyExit() {
        if (this.f55466n) {
            throw new IllegalStateException();
        }
        this.f55466n = true;
        this.f55457e.exit();
    }

    public void timeoutEnter() {
        this.f55457e.enter();
    }
}
