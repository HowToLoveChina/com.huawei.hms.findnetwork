package okhttp3;

import java.io.Closeable;
import okhttp3.C11955v;
import okhttp3.internal.connection.C11932f;

/* renamed from: okhttp3.g0 */
/* loaded from: classes9.dex */
public final class HttpResponseBuilder implements Closeable {

    /* renamed from: a */
    public final HttpRequestBuilder f55292a;

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
    public final HttpResponseBuilder f55299h;

    /* renamed from: i */
    public final HttpResponseBuilder f55300i;

    /* renamed from: j */
    public final HttpResponseBuilder f55301j;

    /* renamed from: k */
    public final long f55302k;

    /* renamed from: l */
    public final long f55303l;

    /* renamed from: m */
    public final C11932f f55304m;

    /* renamed from: n */
    public volatile C11917e f55305n;

    public HttpResponseBuilder(a aVar) {
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
    public HttpResponseBuilder m71590B() {
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
    public HttpRequestBuilder m71593E() {
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
        public HttpRequestBuilder f55306a;

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
        public HttpResponseBuilder f55313h;

        /* renamed from: i */
        public HttpResponseBuilder f55314i;

        /* renamed from: j */
        public HttpResponseBuilder f55315j;

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
        public HttpResponseBuilder m71605c() {
            if (this.f55306a == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.f55307b == null) {
                throw new IllegalStateException("protocol == null");
            }
            if (this.f55308c >= 0) {
                if (this.f55309d != null) {
                    return new HttpResponseBuilder(this);
                }
                throw new IllegalStateException("message == null");
            }
            throw new IllegalStateException("code < 0: " + this.f55308c);
        }

        /* renamed from: d */
        public a m71606d(HttpResponseBuilder HttpResponseBuilder) {
            if (HttpResponseBuilder != null) {
                m71608f("cacheResponse", HttpResponseBuilder);
            }
            this.f55314i = HttpResponseBuilder;
            return this;
        }

        /* renamed from: e */
        public final void m71607e(HttpResponseBuilder HttpResponseBuilder) {
            if (HttpResponseBuilder.f55298g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        /* renamed from: f */
        public final void m71608f(String str, HttpResponseBuilder HttpResponseBuilder) {
            if (HttpResponseBuilder.f55298g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            }
            if (HttpResponseBuilder.f55299h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            if (HttpResponseBuilder.f55300i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            }
            if (HttpResponseBuilder.f55301j == null) {
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
        public a m71615m(HttpResponseBuilder HttpResponseBuilder) {
            if (HttpResponseBuilder != null) {
                m71608f("networkResponse", HttpResponseBuilder);
            }
            this.f55313h = HttpResponseBuilder;
            return this;
        }

        /* renamed from: n */
        public a m71616n(HttpResponseBuilder HttpResponseBuilder) {
            if (HttpResponseBuilder != null) {
                m71607e(HttpResponseBuilder);
            }
            this.f55315j = HttpResponseBuilder;
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
        public a m71620r(HttpRequestBuilder HttpRequestBuilder) {
            this.f55306a = HttpRequestBuilder;
            return this;
        }

        /* renamed from: s */
        public a m71621s(long j10) {
            this.f55316k = j10;
            return this;
        }

        public a(HttpResponseBuilder HttpResponseBuilder) {
            this.f55308c = -1;
            this.f55306a = HttpResponseBuilder.f55292a;
            this.f55307b = HttpResponseBuilder.f55293b;
            this.f55308c = HttpResponseBuilder.f55294c;
            this.f55309d = HttpResponseBuilder.f55295d;
            this.f55310e = HttpResponseBuilder.f55296e;
            this.f55311f = HttpResponseBuilder.f55297f.m71856g();
            this.f55312g = HttpResponseBuilder.f55298g;
            this.f55313h = HttpResponseBuilder.f55299h;
            this.f55314i = HttpResponseBuilder.f55300i;
            this.f55315j = HttpResponseBuilder.f55301j;
            this.f55316k = HttpResponseBuilder.f55302k;
            this.f55317l = HttpResponseBuilder.f55303l;
            this.f55318m = HttpResponseBuilder.f55304m;
        }
    }
}
