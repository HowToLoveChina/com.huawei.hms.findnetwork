package okhttp3.internal.connection;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import okhttp3.AbstractC11953t;
import okhttp3.C11911b;
import okhttp3.C11912b0;
import okhttp3.C11918e0;
import okhttp3.C11926i0;
import okhttp3.C11958y;
import okhttp3.InterfaceC11919f;
import okhttp3.InterfaceC11959z;
import okhttp3.internal.connection.C11940n;
import p693ux.InterfaceC13278c;
import sx.C12875e;

/* renamed from: okhttp3.internal.connection.g */
/* loaded from: classes9.dex */
public final class C11933g {

    /* renamed from: a */
    public final C11941o f55395a;

    /* renamed from: b */
    public final C11911b f55396b;

    /* renamed from: c */
    public final C11937k f55397c;

    /* renamed from: d */
    public final InterfaceC11919f f55398d;

    /* renamed from: e */
    public final AbstractC11953t f55399e;

    /* renamed from: f */
    public C11940n.a f55400f;

    /* renamed from: g */
    public C11940n.a f55401g;

    /* renamed from: h */
    public final C11940n f55402h;

    /* renamed from: i */
    public C11935i f55403i;

    /* renamed from: j */
    public boolean f55404j;

    /* renamed from: k */
    public C11926i0 f55405k;

    /* renamed from: l */
    public int f55406l;

    public C11933g(C11941o c11941o, C11937k c11937k, C11911b c11911b, InterfaceC11919f interfaceC11919f, AbstractC11953t abstractC11953t) {
        this.f55395a = c11941o;
        this.f55397c = c11937k;
        this.f55396b = c11911b;
        this.f55398d = interfaceC11919f;
        this.f55399e = abstractC11953t;
        this.f55402h = new C11940n(c11911b, c11937k.routeDatabase, interfaceC11919f, abstractC11953t).m71764g(c11941o.getRequest());
        this.f55406l = 0;
    }

    /* renamed from: a */
    public C11935i m71699a() {
        return this.f55403i;
    }

    /* renamed from: b */
    public InterfaceC13278c m71700b(C11912b0 c11912b0, InterfaceC11959z.a aVar, boolean z10) {
        try {
            C11935i c11935iM71702d = m71702d(aVar.mo71935d(), aVar.mo71932a(), aVar.mo71933b(), c11912b0.m71463B(), c11912b0.m71487r(), c11912b0.m71469H(), z10);
            if (c11935iM71702d.m71724p() && c11935iM71702d.f55419m == 0) {
                C11958y c11958yM71573m = this.f55395a.getRequest().m71573m();
                c11912b0.m71473a(c11958yM71573m.m71904l(), c11958yM71573m.m71909w(), c11958yM71573m.m71896B());
            }
            return c11935iM71702d.m71725q(c11912b0, aVar);
        } catch (IOException e10) {
            this.m71708j();
            throw new C11939m(e10);
        } catch (C11939m e11) {
            this.m71708j();
            throw e11;
        }
    }

    /* renamed from: c */
    public final C11935i m71701c(int i10, int i11, int i12, int i13, int i14, boolean z10) throws Throwable {
        C11935i c11935i;
        Socket socketM71731w;
        Socket socketReleaseConnectionNoEvents;
        C11935i c11935i2;
        boolean z11;
        C11926i0 c11926i0M71773g;
        boolean z12;
        List<C11926i0> listM71770d;
        C11940n.a aVar;
        C11940n.a aVarM71720l;
        synchronized (this.f55397c) {
            try {
                if (this.f55395a.isCanceled()) {
                    throw new IOException("Canceled");
                }
                this.f55404j = false;
                C11941o c11941o = this.f55395a;
                c11935i = c11941o.f55461i;
                socketM71731w = null;
                socketReleaseConnectionNoEvents = (c11935i == null || !c11935i.f55417k) ? null : c11941o.releaseConnectionNoEvents();
                C11941o c11941o2 = this.f55395a;
                c11935i2 = c11941o2.f55461i;
                if (c11935i2 != null) {
                    c11935i = null;
                } else {
                    c11935i2 = null;
                }
                if (c11935i2 != null) {
                    z11 = false;
                    c11926i0M71773g = null;
                } else if (this.f55397c.m71751q(this.f55396b, c11941o2, null, false)) {
                    c11935i2 = this.f55395a.f55461i;
                    c11926i0M71773g = null;
                    z11 = true;
                } else {
                    c11926i0M71773g = this.f55405k;
                    if (c11926i0M71773g != null) {
                        this.f55405k = null;
                        C11940n.a aVar2 = this.f55401g;
                        if (aVar2 != null) {
                            this.f55400f = aVar2;
                        }
                    } else {
                        if (m71707i()) {
                            c11926i0M71773g = this.f55395a.f55461i.mo71709a();
                        }
                        z11 = false;
                        c11926i0M71773g = null;
                    }
                    z11 = false;
                }
            } finally {
            }
        }
        C12875e.m77251h(socketReleaseConnectionNoEvents);
        if (c11935i != null) {
            this.f55399e.connectionReleased(this.f55398d, c11935i);
        }
        if (z11) {
            this.f55399e.connectionAcquired(this.f55398d, c11935i2);
        }
        if (c11935i2 != null && (aVarM71720l = this.f55395a.f55461i.m71720l()) != null) {
            this.f55401g = aVarM71720l;
            return c11935i2;
        }
        if (c11926i0M71773g != null || ((aVar = this.f55400f) != null && aVar.m71772f())) {
            z12 = false;
        } else {
            this.f55400f = this.f55402h.m71761d();
            z12 = true;
        }
        synchronized (this.f55397c) {
            try {
                if (this.f55395a.isCanceled()) {
                    throw new IOException("Canceled");
                }
                if (z12) {
                    listM71770d = this.f55400f.m71770d();
                    if (this.f55397c.m71751q(this.f55396b, this.f55395a, listM71770d, false)) {
                        c11935i2 = this.f55395a.f55461i;
                        z11 = true;
                    }
                } else {
                    listM71770d = null;
                }
                if (!z11) {
                    if (c11926i0M71773g == null) {
                        c11926i0M71773g = this.f55400f.m71773g();
                    }
                    c11935i2 = new C11935i(this.f55397c, c11926i0M71773g);
                    c11935i2.m71730v(this.f55400f);
                    if (this.f55400f.m71767a()) {
                        c11935i2.m71727s(this.f55400f.m71768b(), this.f55406l, i14);
                    }
                    this.f55403i = c11935i2;
                }
            } finally {
            }
        }
        if (z11) {
            this.f55399e.connectionAcquired(this.f55398d, c11935i2);
            return c11935i2;
        }
        c11935i2.m71713e(i10, i11, i12, i13, i14, z10, this.f55398d, this.f55399e);
        this.f55400f.m71769c(c11935i2.mo71709a());
        synchronized (this.f55397c) {
            try {
                this.f55403i = null;
                if (this.f55397c.m71751q(this.f55396b, this.f55395a, listM71770d, true)) {
                    c11935i2.f55417k = true;
                    socketM71731w = c11935i2.m71731w();
                    c11935i2 = this.f55395a.f55461i;
                    this.f55405k = c11926i0M71773g;
                } else {
                    this.f55397c.m71749o(c11935i2);
                    this.f55395a.acquireConnectionNoEvents(c11935i2);
                }
            } finally {
            }
        }
        C12875e.m77251h(socketM71731w);
        this.f55399e.connectionAcquired(this.f55398d, c11935i2);
        return c11935i2;
    }

    /* renamed from: d */
    public final C11935i m71702d(int i10, int i11, int i12, int i13, int i14, boolean z10, boolean z11) throws Throwable {
        while (true) {
            C11935i c11935iM71701c = m71701c(i10, i11, i12, i13, i14, z10);
            synchronized (this.f55397c) {
                try {
                    if (c11935iM71701c.f55419m == 0 && !c11935iM71701c.m71724p()) {
                        return c11935iM71701c;
                    }
                    if (c11935iM71701c.m71723o(z11)) {
                        return c11935iM71701c;
                    }
                    c11935iM71701c.m71726r();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* renamed from: e */
    public C11940n.a m71703e() {
        return this.f55400f;
    }

    /* renamed from: f */
    public boolean m71704f() {
        synchronized (this.f55397c) {
            try {
                boolean z10 = true;
                if (this.f55405k != null) {
                    return true;
                }
                if (m71707i()) {
                    this.f55405k = this.f55395a.f55461i.mo71709a();
                    return true;
                }
                C11940n.a aVar = this.f55400f;
                if ((aVar == null || !aVar.m71772f()) && !this.f55402h.m71759b()) {
                    z10 = false;
                }
                return z10;
            } finally {
            }
        }
    }

    /* renamed from: g */
    public boolean m71705g() {
        boolean z10;
        synchronized (this.f55397c) {
            z10 = this.f55404j;
        }
        return z10;
    }

    /* renamed from: h */
    public void m71706h(C11912b0 c11912b0, C11918e0 c11918e0) throws IOException {
        C11935i c11935i;
        C11940n.a aVar;
        int iM71477g = c11912b0.m71477g();
        int iM71468G = c11912b0.m71468G();
        int iM71472L = c11912b0.m71472L();
        int iM71463B = c11912b0.m71463B();
        int iM71487r = c11912b0.m71487r();
        boolean zM71469H = c11912b0.m71469H();
        if (!c11918e0.m71567g()) {
            throw new IllegalArgumentException("a normal Request without http2ConnectionIndex");
        }
        if (Integer.parseInt(c11918e0.m71565e("Http2ConnectionIndex")) > this.f55397c.m71744j(this.f55396b)) {
            if (this.f55405k == null && ((aVar = this.f55400f) == null || !aVar.m71772f())) {
                this.f55400f = this.f55402h.m71761d();
            }
            synchronized (this.f55397c) {
                try {
                    C11926i0 c11926i0M71773g = this.f55400f.m71773g();
                    this.f55405k = c11926i0M71773g;
                    c11935i = new C11935i(this.f55397c, c11926i0M71773g);
                    if (this.f55400f.m71767a()) {
                        c11935i.m71727s(this.f55400f.m71768b(), this.f55406l, iM71487r);
                        c11935i.m71730v(this.f55400f);
                    }
                } finally {
                }
            }
            c11935i.m71713e(iM71477g, iM71468G, iM71472L, iM71463B, iM71487r, zM71469H, this.f55398d, this.f55399e);
            this.f55400f.m71769c(c11935i.mo71709a());
            c11935i.f55430x = System.nanoTime();
            synchronized (this.f55397c) {
                this.f55397c.m71749o(c11935i);
            }
        }
    }

    /* renamed from: i */
    public final boolean m71707i() {
        C11935i c11935i = this.f55395a.f55461i;
        return c11935i != null && c11935i.f55418l == 0 && C12875e.m77235F(c11935i.mo71709a().m71638a().m71461n(), this.f55396b.m71461n());
    }

    /* renamed from: j */
    public void m71708j() {
        synchronized (this.f55397c) {
            this.f55404j = true;
        }
    }

    public C11933g(C11941o c11941o, C11937k c11937k, C11911b c11911b, InterfaceC11919f interfaceC11919f, AbstractC11953t abstractC11953t, int i10) {
        this(c11941o, c11937k, c11911b, interfaceC11919f, abstractC11953t);
        this.f55406l = i10;
    }
}
