package com.huawei.hms.network.embedded;

import com.huawei.hms.network.embedded.C5880c9;
import com.huawei.hms.network.embedded.InterfaceC6023n7;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

/* renamed from: com.huawei.hms.network.embedded.w8 */
/* loaded from: classes8.dex */
public final class C6141w8 {

    /* renamed from: m */
    public static final /* synthetic */ boolean f28854m = true;

    /* renamed from: a */
    public final C5894d9 f28855a;

    /* renamed from: b */
    public final C6048p6 f28856b;

    /* renamed from: c */
    public final C6180z8 f28857c;

    /* renamed from: d */
    public final InterfaceC6100t6 f28858d;

    /* renamed from: e */
    public final AbstractC5932g7 f28859e;

    /* renamed from: f */
    public C5880c9.a f28860f;

    /* renamed from: g */
    public C5880c9.a f28861g;

    /* renamed from: h */
    public final C5880c9 f28862h;

    /* renamed from: i */
    public C6167y8 f28863i;

    /* renamed from: j */
    public boolean f28864j;

    /* renamed from: k */
    public C6153x7 f28865k;

    /* renamed from: l */
    public int f28866l;

    public C6141w8(C5894d9 c5894d9, C6180z8 c6180z8, C6048p6 c6048p6, InterfaceC6100t6 interfaceC6100t6, AbstractC5932g7 abstractC5932g7) {
        this.f28855a = c5894d9;
        this.f28857c = c6180z8;
        this.f28856b = c6048p6;
        this.f28858d = interfaceC6100t6;
        this.f28859e = abstractC5932g7;
        this.f28862h = new C5880c9(c6048p6, c6180z8.routeDatabase, interfaceC6100t6, abstractC5932g7).m34057a(c5894d9.getRequest());
        this.f28866l = 0;
    }

    /* renamed from: f */
    private boolean m35742f() {
        C6167y8 c6167y8 = this.f28855a.f26658i;
        return c6167y8 != null && c6167y8.f29162l == 0 && C5920f8.m34252a(c6167y8.mo35837b().m35787a().m34990l(), this.f28856b.m34990l());
    }

    /* renamed from: a */
    public InterfaceC5934g9 m35743a(C6062q7 c6062q7, InterfaceC6023n7.a aVar, boolean z10) {
        try {
            C6167y8 c6167y8M35741a = m35741a(aVar.mo34627d(), aVar.mo34625c(), aVar.mo34623b(), c6062q7.m35097u(), c6062q7.m35091o(), c6062q7.m35068A(), z10);
            if (c6167y8M35741a.m35863g() && c6167y8M35741a.f29163m == 0) {
                C6010m7 c6010m7M35423k = this.f28855a.getRequest().m35423k();
                c6062q7.m35075a(c6010m7M35423k.m34797h(), c6010m7M35423k.m34803n(), c6010m7M35423k.m34808s());
            }
            return c6167y8M35741a.m35852a(c6062q7, aVar);
        } catch (C5866b9 e10) {
            this.m35749e();
            throw e10;
        } catch (IOException e11) {
            this.m35749e();
            throw new C5866b9(e11);
        }
    }

    /* renamed from: b */
    public C5880c9.a m35746b() {
        return this.f28860f;
    }

    /* renamed from: c */
    public boolean m35747c() {
        synchronized (this.f28857c) {
            try {
                boolean z10 = true;
                if (this.f28865k != null) {
                    return true;
                }
                if (m35742f()) {
                    this.f28865k = this.f28855a.f26658i.mo35837b();
                    return true;
                }
                C5880c9.a aVar = this.f28860f;
                if ((aVar == null || !aVar.m34070f()) && !this.f28862h.m34058a()) {
                    z10 = false;
                }
                return z10;
            } finally {
            }
        }
    }

    /* renamed from: d */
    public boolean m35748d() {
        boolean z10;
        synchronized (this.f28857c) {
            z10 = this.f28864j;
        }
        return z10;
    }

    /* renamed from: e */
    public void m35749e() {
        if (!f28854m && Thread.holdsLock(this.f28857c)) {
            throw new AssertionError();
        }
        synchronized (this.f28857c) {
            this.f28864j = true;
        }
    }

    public C6141w8(C5894d9 c5894d9, C6180z8 c6180z8, C6048p6 c6048p6, InterfaceC6100t6 interfaceC6100t6, AbstractC5932g7 abstractC5932g7, int i10) {
        this(c5894d9, c6180z8, c6048p6, interfaceC6100t6, abstractC5932g7);
        this.f28866l = i10;
    }

    /* renamed from: a */
    public C6167y8 m35744a() {
        if (f28854m || Thread.holdsLock(this.f28857c)) {
            return this.f28863i;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    private C6167y8 m35740a(int i10, int i11, int i12, int i13, int i14, boolean z10) throws Throwable {
        C6167y8 c6167y8;
        Socket socketMo35838c;
        Socket socketReleaseConnectionNoEvents;
        C6167y8 c6167y82;
        boolean z11;
        C6153x7 c6153x7M34071g;
        boolean z12;
        List<C6153x7> listM34068d;
        C5880c9.a aVar;
        C5880c9.a aVarM35862f;
        synchronized (this.f28857c) {
            try {
                if (this.f28855a.isCanceled()) {
                    throw new IOException("Canceled");
                }
                this.f28864j = false;
                C5894d9 c5894d9 = this.f28855a;
                c6167y8 = c5894d9.f26658i;
                socketMo35838c = null;
                socketReleaseConnectionNoEvents = (c6167y8 == null || !c6167y8.f29161k) ? null : c5894d9.releaseConnectionNoEvents();
                C5894d9 c5894d92 = this.f28855a;
                c6167y82 = c5894d92.f26658i;
                if (c6167y82 != null) {
                    c6167y8 = null;
                } else {
                    c6167y82 = null;
                }
                if (c6167y82 != null) {
                    z11 = false;
                    c6153x7M34071g = null;
                } else if (this.f28857c.m35930a(this.f28856b, c5894d92, null, false)) {
                    c6167y82 = this.f28855a.f26658i;
                    c6153x7M34071g = null;
                    z11 = true;
                } else {
                    c6153x7M34071g = this.f28865k;
                    if (c6153x7M34071g != null) {
                        this.f28865k = null;
                        C5880c9.a aVar2 = this.f28861g;
                        if (aVar2 != null) {
                            this.f28860f = aVar2;
                        }
                    } else {
                        if (m35742f()) {
                            c6153x7M34071g = this.f28855a.f26658i.mo35837b();
                        }
                        z11 = false;
                        c6153x7M34071g = null;
                    }
                    z11 = false;
                }
            } finally {
            }
        }
        C5920f8.m34251a(socketReleaseConnectionNoEvents);
        if (c6167y8 != null) {
            this.f28859e.connectionReleased(this.f28858d, c6167y8);
        }
        if (z11) {
            this.f28859e.connectionAcquired(this.f28858d, c6167y82);
        }
        if (c6167y82 == null || (aVarM35862f = this.f28855a.f26658i.m35862f()) == null) {
            if (c6153x7M34071g != null || ((aVar = this.f28860f) != null && aVar.m34070f())) {
                z12 = false;
            } else {
                this.f28860f = this.f28862h.m34059b();
                z12 = true;
            }
            synchronized (this.f28857c) {
                try {
                    if (this.f28855a.isCanceled()) {
                        throw new IOException("Canceled");
                    }
                    if (z12) {
                        listM34068d = this.f28860f.m34068d();
                        if (this.f28857c.m35930a(this.f28856b, this.f28855a, listM34068d, false)) {
                            c6167y82 = this.f28855a.f26658i;
                            z11 = true;
                        }
                    } else {
                        listM34068d = null;
                    }
                    if (!z11) {
                        if (c6153x7M34071g == null) {
                            c6153x7M34071g = this.f28860f.m34071g();
                        }
                        c6167y82 = new C6167y8(this.f28857c, c6153x7M34071g);
                        c6167y82.m35855a(this.f28860f);
                        if (this.f28860f.m34064a()) {
                            c6167y82.m35857a(this.f28860f.m34065b(), this.f28866l, i14);
                        }
                        this.f28863i = c6167y82;
                    }
                } finally {
                }
            }
            if (!z11) {
                c6167y82.m35854a(i10, i11, i12, i13, i14, z10, this.f28858d, this.f28859e);
                this.f28860f.m34061a(c6167y82.mo35837b());
                synchronized (this.f28857c) {
                    try {
                        this.f28863i = null;
                        if (this.f28857c.m35930a(this.f28856b, this.f28855a, listM34068d, true)) {
                            c6167y82.f29161k = true;
                            socketMo35838c = c6167y82.mo35838c();
                            c6167y82 = this.f28855a.f26658i;
                            this.f28865k = c6153x7M34071g;
                        } else {
                            this.f28857c.m35936c(c6167y82);
                            this.f28855a.acquireConnectionNoEvents(c6167y82);
                        }
                    } finally {
                    }
                }
                C5920f8.m34251a(socketMo35838c);
            }
            this.f28859e.connectionAcquired(this.f28858d, c6167y82);
            return c6167y82;
        }
        this.f28861g = aVarM35862f;
        return c6167y82;
    }

    /* renamed from: a */
    private C6167y8 m35741a(int i10, int i11, int i12, int i13, int i14, boolean z10, boolean z11) throws Throwable {
        while (true) {
            C6167y8 c6167y8M35740a = m35740a(i10, i11, i12, i13, i14, z10);
            synchronized (this.f28857c) {
                try {
                    if (c6167y8M35740a.f29163m == 0 && !c6167y8M35740a.m35863g()) {
                        return c6167y8M35740a;
                    }
                    if (c6167y8M35740a.m35860a(z11)) {
                        return c6167y8M35740a;
                    }
                    c6167y8M35740a.m35864h();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* renamed from: a */
    public void m35745a(C6062q7 c6062q7, C6101t7 c6101t7) throws IOException {
        C6167y8 c6167y8;
        C5880c9.a aVar;
        int iM35081e = c6062q7.m35081e();
        int iM35102z = c6062q7.m35102z();
        int iM35071D = c6062q7.m35071D();
        int iM35097u = c6062q7.m35097u();
        int iM35091o = c6062q7.m35091o();
        boolean zM35068A = c6062q7.m35068A();
        if (!c6101t7.m35418f()) {
            throw new IllegalArgumentException("a normal Request without http2ConnectionIndex");
        }
        if (Integer.parseInt(c6101t7.m35411a("Http2ConnectionIndex")) > this.f28857c.m35924a(this.f28856b)) {
            if (this.f28865k == null && ((aVar = this.f28860f) == null || !aVar.m34070f())) {
                this.f28860f = this.f28862h.m34059b();
            }
            synchronized (this.f28857c) {
                try {
                    C6153x7 c6153x7M34071g = this.f28860f.m34071g();
                    this.f28865k = c6153x7M34071g;
                    c6167y8 = new C6167y8(this.f28857c, c6153x7M34071g);
                    if (this.f28860f.m34064a()) {
                        c6167y8.m35857a(this.f28860f.m34065b(), this.f28866l, iM35091o);
                        c6167y8.m35855a(this.f28860f);
                    }
                } finally {
                }
            }
            c6167y8.m35854a(iM35081e, iM35102z, iM35071D, iM35097u, iM35091o, zM35068A, this.f28858d, this.f28859e);
            this.f28860f.m34061a(c6167y8.mo35837b());
            c6167y8.f29174x = System.nanoTime();
            synchronized (this.f28857c) {
                this.f28857c.m35936c(c6167y8);
            }
        }
    }
}
