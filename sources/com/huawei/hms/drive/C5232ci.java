package com.huawei.hms.drive;

import com.huawei.hms.drive.C5231ch;
import com.huawei.hms.drive.InterfaceC5196ba;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import p022ay.C1053c;

/* renamed from: com.huawei.hms.drive.ci */
/* loaded from: classes8.dex */
public final class C5232ci {

    /* renamed from: b */
    static final /* synthetic */ boolean f24188b = true;

    /* renamed from: a */
    public C5227cd f24189a;

    /* renamed from: c */
    private final C5198bc f24190c;

    /* renamed from: d */
    private final C5228ce f24191d;

    /* renamed from: e */
    private final InterfaceC5177aj f24192e;

    /* renamed from: f */
    private final AbstractC5188au f24193f;

    /* renamed from: g */
    private final C1053c f24194g;

    /* renamed from: h */
    private Object f24195h;

    /* renamed from: i */
    private C5201bf f24196i;

    /* renamed from: j */
    private C5225cb f24197j;

    /* renamed from: k */
    private C5224ca f24198k;

    /* renamed from: l */
    private boolean f24199l;

    /* renamed from: m */
    private boolean f24200m;

    /* renamed from: n */
    private boolean f24201n;

    /* renamed from: o */
    private boolean f24202o;

    /* renamed from: p */
    private boolean f24203p;

    /* renamed from: q */
    private final int f24204q;

    /* renamed from: com.huawei.hms.drive.ci$1 */
    public class AnonymousClass1 extends C1053c {
        public AnonymousClass1() {
        }

        @Override // p022ay.C1053c
        public void timedOut() throws IOException {
            C5232ci.this.m31390h();
        }
    }

    /* renamed from: com.huawei.hms.drive.ci$a */
    public static final class a extends WeakReference<C5232ci> {

        /* renamed from: a */
        final Object f24206a;

        public a(C5232ci c5232ci, Object obj) {
            super(c5232ci);
            this.f24206a = obj;
        }
    }

    public C5232ci(C5198bc c5198bc, InterfaceC5177aj interfaceC5177aj) {
        AnonymousClass1 anonymousClass1 = new C1053c() { // from class: com.huawei.hms.drive.ci.1
            public AnonymousClass1() {
            }

            @Override // p022ay.C1053c
            public void timedOut() throws IOException {
                C5232ci.this.m31390h();
            }
        };
        this.f24194g = anonymousClass1;
        this.f24190c = c5198bc;
        this.f24191d = AbstractC5207bl.f23983a.mo31074a(c5198bc.m31062q());
        this.f24192e = interfaceC5177aj;
        this.f24193f = c5198bc.m31042B().create(interfaceC5177aj);
        anonymousClass1.timeout(c5198bc.m31043a(), TimeUnit.MILLISECONDS);
        this.f24204q = c5198bc.m31070y();
    }

    /* renamed from: a */
    public void m31381a() {
        this.f24194g.enter();
    }

    /* renamed from: b */
    public void m31384b() {
        if (this.f24202o) {
            throw new IllegalStateException();
        }
        this.f24202o = true;
        this.f24194g.exit();
    }

    /* renamed from: c */
    public void m31385c() {
        this.f24195h = C5269dr.m31692e().mo31655a("response.body().close()");
        this.f24193f.m30891a(this.f24192e);
    }

    /* renamed from: d */
    public Socket m31386d() {
        if (!f24188b && !Thread.holdsLock(this.f24191d)) {
            throw new AssertionError();
        }
        int size = this.f24189a.f24139f.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                i10 = -1;
                break;
            }
            if (this.f24189a.f24139f.get(i10).get() == this) {
                break;
            }
            i10++;
        }
        if (i10 == -1) {
            throw new IllegalStateException();
        }
        C5227cd c5227cd = this.f24189a;
        c5227cd.f24139f.remove(i10);
        this.f24189a = null;
        if (c5227cd.f24139f.isEmpty()) {
            c5227cd.f24140g = System.nanoTime();
            if (this.f24191d.m31347c(c5227cd)) {
                return c5227cd.m31329e();
            }
        }
        return null;
    }

    /* renamed from: e */
    public void m31387e() {
        synchronized (this.f24191d) {
            try {
                if (this.f24203p) {
                    throw new IllegalStateException();
                }
                this.f24198k = null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: f */
    public boolean m31388f() {
        return this.f24197j.m31304c() && this.f24197j.m31305d();
    }

    /* renamed from: g */
    public boolean m31389g() {
        boolean z10;
        synchronized (this.f24191d) {
            z10 = this.f24198k != null;
        }
        return z10;
    }

    /* renamed from: h */
    public void m31390h() throws IOException {
        C5224ca c5224ca;
        C5227cd c5227cdM31300a;
        synchronized (this.f24191d) {
            try {
                this.f24201n = true;
                c5224ca = this.f24198k;
                C5225cb c5225cb = this.f24197j;
                c5227cdM31300a = (c5225cb == null || c5225cb.m31300a() == null) ? this.f24189a : this.f24197j.m31300a();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (c5224ca != null) {
            c5224ca.m31292g();
        } else if (c5227cdM31300a != null) {
            c5227cdM31300a.m31328d();
        }
    }

    /* renamed from: i */
    public boolean m31391i() {
        boolean z10;
        synchronized (this.f24191d) {
            z10 = this.f24201n;
        }
        return z10;
    }

    /* renamed from: j */
    public C5201bf m31392j() {
        return this.f24196i;
    }

    /* renamed from: k */
    public C5225cb m31393k() {
        return this.f24197j;
    }

    /* renamed from: l */
    public C5231ch.a m31394l() {
        return this.f24197j.m31306e();
    }

    /* renamed from: a */
    public void m31382a(C5201bf c5201bf) throws IOException {
        C5201bf c5201bf2 = this.f24196i;
        if (c5201bf2 != null) {
            if (C5210bo.m31195a(c5201bf2.m31107a(), c5201bf.m31107a()) && this.f24197j.m31305d()) {
                return;
            }
            if (this.f24198k != null) {
                throw new IllegalStateException();
            }
            if (this.f24197j != null) {
                m31376a((IOException) null, true);
                this.f24197j = null;
            }
        }
        this.f24196i = c5201bf;
        C5225cb c5225cb = new C5225cb(this, this.f24191d, m31375a(c5201bf.m31107a()), this.f24192e, this.f24193f, this.f24204q);
        this.f24197j = c5225cb;
        c5225cb.f24120a.m30806a(c5201bf.m31108a("host"));
    }

    /* renamed from: b */
    private IOException m31377b(IOException iOException) {
        if (this.f24202o || !this.f24194g.exit()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* renamed from: a */
    private C5173af m31375a(C5193az c5193az) {
        SSLSocketFactory sSLSocketFactoryM31057l;
        HostnameVerifier hostnameVerifierM31058m;
        C5179al c5179alM31059n;
        if (c5193az.m30966c()) {
            sSLSocketFactoryM31057l = this.f24190c.m31057l();
            hostnameVerifierM31058m = this.f24190c.m31058m();
            c5179alM31059n = this.f24190c.m31059n();
        } else {
            sSLSocketFactoryM31057l = null;
            hostnameVerifierM31058m = null;
            c5179alM31059n = null;
        }
        return new C5173af(c5193az.m30970f(), c5193az.m30971g(), this.f24190c.m31055j(), this.f24190c.m31056k(), sSLSocketFactoryM31057l, hostnameVerifierM31058m, c5179alM31059n, this.f24190c.m31061p(), this.f24190c.m31051f(), this.f24190c.m31068w(), this.f24190c.m31069x(), this.f24190c.m31052g());
    }

    /* renamed from: a */
    public C5224ca m31378a(InterfaceC5196ba.a aVar, boolean z10) {
        synchronized (this.f24191d) {
            if (!this.f24203p) {
                if (this.f24198k != null) {
                    throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()");
                }
            } else {
                throw new IllegalStateException("released");
            }
        }
        C5224ca c5224ca = new C5224ca(this, this.f24192e, this.f24193f, this.f24197j, this.f24197j.m31301a(this.f24190c, aVar, z10));
        synchronized (this.f24191d) {
            this.f24198k = c5224ca;
            this.f24199l = false;
            this.f24200m = false;
        }
        return c5224ca;
    }

    /* renamed from: a */
    public void m31383a(C5227cd c5227cd) {
        if (!f24188b && !Thread.holdsLock(this.f24191d)) {
            throw new AssertionError();
        }
        if (this.f24189a == null) {
            this.f24189a = c5227cd;
            c5227cd.f24139f.add(new a(this, this.f24195h));
            return;
        }
        throw new IllegalStateException();
    }

    /* renamed from: a */
    public IOException m31379a(C5224ca c5224ca, boolean z10, boolean z11, IOException iOException) {
        boolean z12;
        synchronized (this.f24191d) {
            try {
                C5224ca c5224ca2 = this.f24198k;
                if (c5224ca != c5224ca2) {
                    return iOException;
                }
                boolean z13 = true;
                if (z10) {
                    z12 = !this.f24199l;
                    this.f24199l = true;
                } else {
                    z12 = false;
                }
                if (z11) {
                    if (!this.f24200m) {
                        z12 = true;
                    }
                    this.f24200m = true;
                }
                if (this.f24199l && this.f24200m && z12) {
                    c5224ca2.m31281a().f24137d++;
                    this.f24198k = null;
                } else {
                    z13 = false;
                }
                return z13 ? m31376a(iOException, false) : iOException;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public IOException m31380a(IOException iOException) {
        synchronized (this.f24191d) {
            this.f24203p = true;
        }
        return m31376a(iOException, false);
    }

    /* renamed from: a */
    private IOException m31376a(IOException iOException, boolean z10) throws IOException {
        C5227cd c5227cd;
        Socket socketM31386d;
        boolean z11;
        synchronized (this.f24191d) {
            if (z10) {
                try {
                    if (this.f24198k != null) {
                        throw new IllegalStateException("cannot release connection while it is in use");
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            c5227cd = this.f24189a;
            socketM31386d = (c5227cd != null && this.f24198k == null && (z10 || this.f24203p)) ? m31386d() : null;
            if (this.f24189a != null) {
                c5227cd = null;
            }
            z11 = this.f24203p && this.f24198k == null;
        }
        C5210bo.m31193a(socketM31386d);
        if (c5227cd != null) {
            this.f24193f.m30905b(this.f24192e, c5227cd);
        }
        if (z11) {
            boolean z12 = iOException != null;
            iOException = m31377b(iOException);
            if (z12) {
                this.f24193f.m30908c(this.f24192e, iOException);
            } else {
                this.f24193f.m30912g(this.f24192e);
            }
        }
        return iOException;
    }
}
