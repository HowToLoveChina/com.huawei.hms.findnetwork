package com.huawei.hms.drive;

import com.huawei.hms.drive.C5231ch;
import com.huawei.hms.drive.InterfaceC5196ba;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

/* renamed from: com.huawei.hms.drive.cb */
/* loaded from: classes8.dex */
final class C5225cb {

    /* renamed from: b */
    static final /* synthetic */ boolean f24119b = true;

    /* renamed from: a */
    public final C5173af f24120a;

    /* renamed from: c */
    private final C5232ci f24121c;

    /* renamed from: d */
    private final C5228ce f24122d;

    /* renamed from: e */
    private final InterfaceC5177aj f24123e;

    /* renamed from: f */
    private final AbstractC5188au f24124f;

    /* renamed from: g */
    private C5231ch.a f24125g;

    /* renamed from: h */
    private C5231ch.a f24126h;

    /* renamed from: i */
    private final C5231ch f24127i;

    /* renamed from: j */
    private C5227cd f24128j;

    /* renamed from: k */
    private boolean f24129k;

    /* renamed from: l */
    private C5205bj f24130l;

    /* renamed from: m */
    private int f24131m;

    public C5225cb(C5232ci c5232ci, C5228ce c5228ce, C5173af c5173af, InterfaceC5177aj interfaceC5177aj, AbstractC5188au abstractC5188au) {
        this.f24121c = c5232ci;
        this.f24122d = c5228ce;
        this.f24120a = c5173af;
        this.f24123e = interfaceC5177aj;
        this.f24124f = abstractC5188au;
        this.f24127i = new C5231ch(c5173af, c5228ce.f24159a, interfaceC5177aj, abstractC5188au).m31360a(c5232ci.m31392j());
        this.f24131m = 0;
    }

    /* renamed from: f */
    private boolean m31299f() {
        C5227cd c5227cd = this.f24121c.f24189a;
        return c5227cd != null && c5227cd.f24136c == 0 && C5210bo.m31195a(c5227cd.m31327c().m31162a().m30808b(), this.f24120a.m30808b());
    }

    /* renamed from: a */
    public InterfaceC5235cl m31301a(C5198bc c5198bc, InterfaceC5196ba.a aVar, boolean z10) {
        try {
            C5227cd c5227cdM31298a = m31298a(aVar.mo31033b(), aVar.mo31034c(), aVar.mo31035d(), c5198bc.m31050e(), c5198bc.m31065t(), c5198bc.m31066u(), z10);
            if (c5227cdM31298a.m31331g() && c5227cdM31298a.f24137d == 0) {
                C5193az c5193azM31107a = this.f24121c.m31392j().m31107a();
                c5198bc.m31045a(c5193azM31107a.m30970f(), c5193azM31107a.m30971g(), c5193azM31107a.m30964b());
            }
            return c5227cdM31298a.m31315a(c5198bc, aVar);
        } catch (C5230cg e10) {
            this.m31303b();
            throw e10;
        } catch (IOException e11) {
            this.m31303b();
            throw new C5230cg(e11);
        }
    }

    /* renamed from: b */
    public void m31303b() {
        if (!f24119b && Thread.holdsLock(this.f24122d)) {
            throw new AssertionError();
        }
        synchronized (this.f24122d) {
            this.f24129k = true;
        }
    }

    /* renamed from: c */
    public boolean m31304c() {
        boolean z10;
        synchronized (this.f24122d) {
            z10 = this.f24129k;
        }
        return z10;
    }

    /* renamed from: d */
    public boolean m31305d() {
        synchronized (this.f24122d) {
            try {
                boolean z10 = true;
                if (this.f24130l != null) {
                    return true;
                }
                if (m31299f()) {
                    this.f24130l = this.f24121c.f24189a.m31327c();
                    return true;
                }
                C5231ch.a aVar = this.f24125g;
                if ((aVar == null || !aVar.m31367a()) && !this.f24127i.m31361a()) {
                    z10 = false;
                }
                return z10;
            } finally {
            }
        }
    }

    /* renamed from: e */
    public C5231ch.a m31306e() {
        return this.f24125g;
    }

    public C5225cb(C5232ci c5232ci, C5228ce c5228ce, C5173af c5173af, InterfaceC5177aj interfaceC5177aj, AbstractC5188au abstractC5188au, int i10) {
        this(c5232ci, c5228ce, c5173af, interfaceC5177aj, abstractC5188au);
        this.f24131m = i10;
    }

    /* renamed from: a */
    private C5227cd m31298a(int i10, int i11, int i12, int i13, int i14, boolean z10, boolean z11) throws Throwable {
        while (true) {
            C5227cd c5227cdM31297a = m31297a(i10, i11, i12, i13, i14, z10);
            synchronized (this.f24122d) {
                try {
                    if (c5227cdM31297a.f24137d == 0 && !c5227cdM31297a.m31331g()) {
                        return c5227cdM31297a;
                    }
                    if (c5227cdM31297a.m31325a(z11)) {
                        return c5227cdM31297a;
                    }
                    c5227cdM31297a.m31316a();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* renamed from: a */
    private C5227cd m31297a(int i10, int i11, int i12, int i13, int i14, boolean z10) throws Throwable {
        C5227cd c5227cd;
        Socket socketM31329e;
        Socket socketM31386d;
        C5227cd c5227cd2;
        boolean z11;
        C5205bj c5205bjM31368b;
        boolean z12;
        List<C5205bj> listM31370c;
        C5231ch.a aVar;
        C5231ch.a aVarM31326b;
        synchronized (this.f24122d) {
            try {
                if (!this.f24121c.m31391i()) {
                    this.f24129k = false;
                    C5232ci c5232ci = this.f24121c;
                    c5227cd = c5232ci.f24189a;
                    socketM31329e = null;
                    socketM31386d = (c5227cd == null || !c5227cd.f24135b) ? null : c5232ci.m31386d();
                    C5232ci c5232ci2 = this.f24121c;
                    c5227cd2 = c5232ci2.f24189a;
                    if (c5227cd2 != null) {
                        c5227cd = null;
                    } else {
                        c5227cd2 = null;
                    }
                    if (c5227cd2 != null) {
                        z11 = false;
                        c5205bjM31368b = null;
                    } else if (this.f24122d.m31345a(this.f24120a, c5232ci2, null, false)) {
                        c5227cd2 = this.f24121c.f24189a;
                        c5205bjM31368b = null;
                        z11 = true;
                    } else {
                        c5205bjM31368b = this.f24130l;
                        if (c5205bjM31368b != null) {
                            this.f24130l = null;
                            C5231ch.a aVar2 = this.f24126h;
                            if (aVar2 != null) {
                                this.f24125g = aVar2;
                            }
                        } else {
                            if (m31299f()) {
                                c5205bjM31368b = this.f24121c.f24189a.m31327c();
                            }
                            z11 = false;
                            c5205bjM31368b = null;
                        }
                        z11 = false;
                    }
                } else {
                    throw new IOException("Canceled");
                }
            } finally {
            }
        }
        C5210bo.m31193a(socketM31386d);
        if (c5227cd != null) {
            this.f24124f.m30905b(this.f24123e, c5227cd);
        }
        if (z11) {
            this.f24124f.m30893a(this.f24123e, c5227cd2);
        }
        if (c5227cd2 != null && (aVarM31326b = this.f24121c.f24189a.m31326b()) != null) {
            this.f24126h = aVarM31326b;
            return c5227cd2;
        }
        if (c5205bjM31368b != null || ((aVar = this.f24125g) != null && aVar.m31367a())) {
            z12 = false;
        } else {
            this.f24125g = this.f24127i.m31362b();
            z12 = true;
        }
        synchronized (this.f24122d) {
            try {
                if (this.f24121c.m31391i()) {
                    throw new IOException("Canceled");
                }
                if (z12) {
                    listM31370c = this.f24125g.m31370c();
                    if (this.f24122d.m31345a(this.f24120a, this.f24121c, listM31370c, false)) {
                        c5227cd2 = this.f24121c.f24189a;
                        z11 = true;
                    }
                } else {
                    listM31370c = null;
                }
                if (!z11) {
                    if (c5205bjM31368b == null) {
                        c5205bjM31368b = this.f24125g.m31368b();
                    }
                    c5227cd2 = new C5227cd(this.f24122d, c5205bjM31368b);
                    c5227cd2.m31318a(this.f24125g);
                    if (this.f24125g.m31371d()) {
                        c5227cd2.m31322a(this.f24125g.m31372e(), this.f24131m, i14);
                    }
                    this.f24128j = c5227cd2;
                }
            } finally {
            }
        }
        if (z11) {
            this.f24124f.m30893a(this.f24123e, c5227cd2);
            return c5227cd2;
        }
        c5227cd2.m31317a(i10, i11, i12, i13, i14, z10, this.f24123e, this.f24124f);
        this.f24125g.m31364a(c5227cd2.m31327c());
        synchronized (this.f24122d) {
            try {
                this.f24128j = null;
                if (this.f24122d.m31345a(this.f24120a, this.f24121c, listM31370c, true)) {
                    c5227cd2.f24135b = true;
                    socketM31329e = c5227cd2.m31329e();
                    c5227cd2 = this.f24121c.f24189a;
                    this.f24130l = c5205bjM31368b;
                } else {
                    this.f24122d.m31346b(c5227cd2);
                    this.f24121c.m31383a(c5227cd2);
                }
            } finally {
            }
        }
        C5210bo.m31193a(socketM31329e);
        this.f24124f.m30893a(this.f24123e, c5227cd2);
        return c5227cd2;
    }

    /* renamed from: a */
    public void m31302a(C5198bc c5198bc, C5201bf c5201bf) throws IOException {
        C5227cd c5227cd;
        C5231ch.a aVar;
        int iM31046b = c5198bc.m31046b();
        int iM31048c = c5198bc.m31048c();
        int iM31049d = c5198bc.m31049d();
        int iM31050e = c5198bc.m31050e();
        int iM31065t = c5198bc.m31065t();
        boolean zM31066u = c5198bc.m31066u();
        if (c5201bf.m31117j()) {
            if (Integer.parseInt(c5201bf.m31108a("Http2ConnectionIndex")) > this.f24122d.m31339a(this.f24120a)) {
                if (this.f24130l == null && ((aVar = this.f24125g) == null || !aVar.m31367a())) {
                    this.f24125g = this.f24127i.m31362b();
                }
                synchronized (this.f24122d) {
                    try {
                        C5205bj c5205bjM31368b = this.f24125g.m31368b();
                        this.f24130l = c5205bjM31368b;
                        c5227cd = new C5227cd(this.f24122d, c5205bjM31368b);
                        if (this.f24125g.m31371d()) {
                            c5227cd.m31322a(this.f24125g.m31372e(), this.f24131m, iM31065t);
                            c5227cd.m31318a(this.f24125g);
                        }
                    } finally {
                    }
                }
                c5227cd.m31317a(iM31046b, iM31048c, iM31049d, iM31050e, iM31065t, zM31066u, this.f24123e, this.f24124f);
                this.f24125g.m31364a(c5227cd.m31327c());
                c5227cd.f24144k = System.nanoTime();
                synchronized (this.f24122d) {
                    this.f24122d.m31346b(c5227cd);
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("a normal Request without http2ConnectionIndex");
    }

    /* renamed from: a */
    public C5227cd m31300a() {
        if (f24119b || Thread.holdsLock(this.f24122d)) {
            return this.f24128j;
        }
        throw new AssertionError();
    }
}
