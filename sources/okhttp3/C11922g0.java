package okhttp3;

import java.io.Closeable;
import okhttp3.C11955v;
import okhttp3.internal.connection.C11932f;

/* renamed from: okhttp3.g0 */
/* loaded from: classes9.dex */
public final class C11922g0 implements Closeable {

    /* renamed from: a */
    public final C11918e0 f55292a;

    /* renamed from: b */
    public final EnumC11914c0 f55293b;

    /* renamed from: c */
    public final int f55294c;

    /* renamed from: d */
    public final String f55295d;

    /* renamed from: e */
    public final C11954u f55296e;

    /* renamed from: f */
    public final C11955v f55297f;

    /* renamed from: g */
    public final AbstractC11924h0 f55298g;

    /* renamed from: h */
    public final C11922g0 f55299h;

    /* renamed from: i */
    public final C11922g0 f55300i;

    /* renamed from: j */
    public final C11922g0 f55301j;

    /* renamed from: k */
    public final long f55302k;

    /* renamed from: l */
    public final long f55303l;

    /* renamed from: m */
    public final C11932f f55304m;

    /* renamed from: n */
    public volatile C11917e f55305n;

    public C11922g0(a aVar) {
        this.f55292a = aVar.f55306a;
        this.f55293b = aVar.f55307b;
        this.f55294c = aVar.f55308c;
        this.f55295d = aVar.f55309d;
        this.f55296e = aVar.f55310e;
        this.f55297f = aVar.f55311f.m71864d();
        this.f55298g = aVar.f55312g;
        this.f55299h = aVar.f55313h;
        this.f55300i = aVar.f55314i;
        this.f55301j = aVar.f55315j;
        this.f55302k = aVar.f55316k;
        this.f55303l = aVar.f55317l;
        this.f55304m = aVar.f55318m;
    }

    /* renamed from: A */
    public a m71589A() {
        return new a(this);
    }

    /* renamed from: B */
    public C11922g0 m71590B() {
        return this.f55301j;
    }

    /* renamed from: C */
    public EnumC11914c0 m71591C() {
        return this.f55293b;
    }

    /* renamed from: D */
    public long m71592D() {
        return this.f55303l;
    }

    /* renamed from: E */
    public C11918e0 m71593E() {
        return this.f55292a;
    }

    /* renamed from: F */
    public long m71594F() {
        return this.f55302k;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        AbstractC11924h0 abstractC11924h0 = this.f55298g;
        if (abstractC11924h0 == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        abstractC11924h0.close();
    }

    /* renamed from: s */
    public AbstractC11924h0 m71595s() {
        return this.f55298g;
    }

    /* renamed from: t */
    public C11917e m71596t() {
        C11917e c11917e = this.f55305n;
        if (c11917e != null) {
            return c11917e;
        }
        C11917e c11917eM71546k = C11917e.m71546k(this.f55297f);
        this.f55305n = c11917eM71546k;
        return c11917eM71546k;
    }

    public String toString() {
        return "Response{protocol=" + this.f55293b + ", code=" + this.f55294c + ", message=" + this.f55295d + ", url=" + this.f55292a.m71573m() + '}';
    }

    /* renamed from: u */
    public int m71597u() {
        return this.f55294c;
    }

    /* renamed from: v */
    public C11954u m71598v() {
        return this.f55296e;
    }

    /* renamed from: w */
    public String m71599w(String str) {
        return m71600x(str, null);
    }

    /* renamed from: x */
    public String m71600x(String str, String str2) {
        String strM71853c = this.f55297f.m71853c(str);
        return strM71853c != null ? strM71853c : str2;
    }

    /* renamed from: y */
    public C11955v m71601y() {
        return this.f55297f;
    }

    /* renamed from: z */
    public String m71602z() {
        return this.f55295d;
    }

    /* renamed from: okhttp3.g0$a */
    public static class a {

        /* renamed from: a */
        public C11918e0 f55306a;

        /* renamed from: b */
        public EnumC11914c0 f55307b;

        /* renamed from: c */
        public int f55308c;

        /* renamed from: d */
        public String f55309d;

        /* renamed from: e */
        public C11954u f55310e;

        /* renamed from: f */
        public C11955v.a f55311f;

        /* renamed from: g */
        public AbstractC11924h0 f55312g;

        /* renamed from: h */
        public C11922g0 f55313h;

        /* renamed from: i */
        public C11922g0 f55314i;

        /* renamed from: j */
        public C11922g0 f55315j;

        /* renamed from: k */
        public long f55316k;

        /* renamed from: l */
        public long f55317l;

        /* renamed from: m */
        public C11932f f55318m;

        public a() {
            this.f55308c = -1;
            this.f55311f = new C11955v.a();
        }

        /* renamed from: a */
        public a m71603a(String str, String str2) {
            this.f55311f.m71861a(str, str2);
            return this;
        }

        /* renamed from: b */
        public a m71604b(AbstractC11924h0 abstractC11924h0) {
            this.f55312g = abstractC11924h0;
            return this;
        }

        /* renamed from: c */
        public C11922g0 m71605c() {
            if (this.f55306a == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.f55307b == null) {
                throw new IllegalStateException("protocol == null");
            }
            if (this.f55308c >= 0) {
                if (this.f55309d != null) {
                    return new C11922g0(this);
                }
                throw new IllegalStateException("message == null");
            }
            throw new IllegalStateException("code < 0: " + this.f55308c);
        }

        /* renamed from: d */
        public a m71606d(C11922g0 c11922g0) {
            if (c11922g0 != null) {
                m71608f("cacheResponse", c11922g0);
            }
            this.f55314i = c11922g0;
            return this;
        }

        /* renamed from: e */
        public final void m71607e(C11922g0 c11922g0) {
            if (c11922g0.f55298g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        /* renamed from: f */
        public final void m71608f(String str, C11922g0 c11922g0) {
            if (c11922g0.f55298g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            }
            if (c11922g0.f55299h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            if (c11922g0.f55300i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            }
            if (c11922g0.f55301j == null) {
                return;
            }
            throw new IllegalArgumentException(str + ".priorResponse != null");
        }

        /* renamed from: g */
        public a m71609g(int i10) {
            this.f55308c = i10;
            return this;
        }

        /* renamed from: h */
        public a m71610h(C11954u c11954u) {
            this.f55310e = c11954u;
            return this;
        }

        /* renamed from: i */
        public a m71611i(String str, String str2) {
            this.f55311f.m71866f(str, str2);
            return this;
        }

        /* renamed from: j */
        public a m71612j(C11955v c11955v) {
            this.f55311f = c11955v.m71856g();
            return this;
        }

        /* renamed from: k */
        public void m71613k(C11932f c11932f) {
            this.f55318m = c11932f;
        }

        /* renamed from: l */
        public a m71614l(String str) {
            this.f55309d = str;
            return this;
        }

        /* renamed from: m */
        public a m71615m(C11922g0 c11922g0) {
            if (c11922g0 != null) {
                m71608f("networkResponse", c11922g0);
            }
            this.f55313h = c11922g0;
            return this;
        }

        /* renamed from: n */
        public a m71616n(C11922g0 c11922g0) {
            if (c11922g0 != null) {
                m71607e(c11922g0);
            }
            this.f55315j = c11922g0;
            return this;
        }

        /* renamed from: o */
        public a m71617o(EnumC11914c0 enumC11914c0) {
            this.f55307b = enumC11914c0;
            return this;
        }

        /* renamed from: p */
        public a m71618p(long j10) {
            this.f55317l = j10;
            return this;
        }

        /* renamed from: q */
        public a m71619q(String str) {
            this.f55311f.m71865e(str);
            return this;
        }

        /* renamed from: r */
        public a m71620r(C11918e0 c11918e0) {
            this.f55306a = c11918e0;
            return this;
        }

        /* renamed from: s */
        public a m71621s(long j10) {
            this.f55316k = j10;
            return this;
        }

        public a(C11922g0 c11922g0) {
            this.f55308c = -1;
            this.f55306a = c11922g0.f55292a;
            this.f55307b = c11922g0.f55293b;
            this.f55308c = c11922g0.f55294c;
            this.f55309d = c11922g0.f55295d;
            this.f55310e = c11922g0.f55296e;
            this.f55311f = c11922g0.f55297f.m71856g();
            this.f55312g = c11922g0.f55298g;
            this.f55313h = c11922g0.f55299h;
            this.f55314i = c11922g0.f55300i;
            this.f55315j = c11922g0.f55301j;
            this.f55316k = c11922g0.f55302k;
            this.f55317l = c11922g0.f55303l;
            this.f55318m = c11922g0.f55304m;
        }
    }
}
