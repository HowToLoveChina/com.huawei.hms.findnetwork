package okhttp3;

import java.net.InetAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import okhttp3.C11955v;
import p693ux.C13281f;
import sx.C12875e;

/* renamed from: okhttp3.e0 */
/* loaded from: classes9.dex */
public final class C11918e0 {

    /* renamed from: a */
    public final C11958y f55269a;

    /* renamed from: b */
    public final String f55270b;

    /* renamed from: c */
    public final C11955v f55271c;

    /* renamed from: d */
    public final AbstractC11920f0 f55272d;

    /* renamed from: e */
    public final Map<Class<?>, Object> f55273e;

    /* renamed from: f */
    public volatile C11917e f55274f;

    /* renamed from: g */
    public final boolean f55275g;

    /* renamed from: h */
    public final ArrayList<InetAddress> f55276h;

    public C11918e0(a aVar) {
        this.f55269a = aVar.f55277a;
        this.f55270b = aVar.f55278b;
        this.f55271c = aVar.f55279c.m71864d();
        this.f55272d = aVar.f55280d;
        this.f55273e = C12875e.m77265v(aVar.f55281e);
        this.f55275g = aVar.f55282f;
        this.f55276h = aVar.f55283g;
    }

    /* renamed from: a */
    public ArrayList<InetAddress> m71561a() {
        return this.f55276h;
    }

    /* renamed from: b */
    public AbstractC11920f0 m71562b() {
        return this.f55272d;
    }

    /* renamed from: c */
    public C11917e m71563c() {
        C11917e c11917e = this.f55274f;
        if (c11917e != null) {
            return c11917e;
        }
        C11917e c11917eM71546k = C11917e.m71546k(this.f55271c);
        this.f55274f = c11917eM71546k;
        return c11917eM71546k;
    }

    /* renamed from: d */
    public boolean m71564d() {
        return this.f55275g;
    }

    /* renamed from: e */
    public String m71565e(String str) {
        return this.f55271c.m71853c(str);
    }

    /* renamed from: f */
    public C11955v m71566f() {
        return this.f55271c;
    }

    /* renamed from: g */
    public boolean m71567g() {
        return m71565e("Http2ConnectionIndex") != null;
    }

    /* renamed from: h */
    public boolean m71568h() {
        return this.f55269a.m71905m();
    }

    /* renamed from: i */
    public String m71569i() {
        return this.f55270b;
    }

    /* renamed from: j */
    public a m71570j() {
        return new a(this);
    }

    /* renamed from: k */
    public Object m71571k() {
        return m71572l(Object.class);
    }

    /* renamed from: l */
    public <T> T m71572l(Class<? extends T> cls) {
        return cls.cast(this.f55273e.get(cls));
    }

    /* renamed from: m */
    public C11958y m71573m() {
        return this.f55269a;
    }

    public String toString() {
        return "Request{method=" + this.f55270b + ", url=" + this.f55269a + ", tags=" + this.f55273e + '}';
    }

    /* renamed from: okhttp3.e0$a */
    public static class a {

        /* renamed from: a */
        public C11958y f55277a;

        /* renamed from: b */
        public String f55278b;

        /* renamed from: c */
        public C11955v.a f55279c;

        /* renamed from: d */
        public AbstractC11920f0 f55280d;

        /* renamed from: e */
        public Map<Class<?>, Object> f55281e;

        /* renamed from: f */
        public boolean f55282f;

        /* renamed from: g */
        public ArrayList<InetAddress> f55283g;

        public a() {
            this.f55281e = Collections.emptyMap();
            this.f55282f = false;
            this.f55283g = new ArrayList<>();
            this.f55278b = "GET";
            this.f55279c = new C11955v.a();
        }

        /* renamed from: a */
        public a m71574a(String str, String str2) {
            this.f55279c.m71861a(str, str2);
            return this;
        }

        /* renamed from: b */
        public C11918e0 m71575b() {
            if (this.f55277a != null) {
                return new C11918e0(this);
            }
            throw new IllegalStateException("url == null");
        }

        /* renamed from: c */
        public a m71576c(C11917e c11917e) {
            String string = c11917e.toString();
            return string.isEmpty() ? m71583j("Cache-Control") : m71578e("Cache-Control", string);
        }

        /* renamed from: d */
        public a m71577d(AbstractC11920f0 abstractC11920f0) {
            return m71580g("DELETE", abstractC11920f0);
        }

        /* renamed from: e */
        public a m71578e(String str, String str2) {
            this.f55279c.m71866f(str, str2);
            return this;
        }

        /* renamed from: f */
        public a m71579f(C11955v c11955v) {
            this.f55279c = c11955v.m71856g();
            return this;
        }

        /* renamed from: g */
        public a m71580g(String str, AbstractC11920f0 abstractC11920f0) {
            if (str == null) {
                throw new NullPointerException("method == null");
            }
            if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            }
            if (abstractC11920f0 != null && !C13281f.m79720a(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            }
            if (abstractC11920f0 != null || !C13281f.m79723d(str)) {
                this.f55278b = str;
                this.f55280d = abstractC11920f0;
                return this;
            }
            throw new IllegalArgumentException("method " + str + " must have a request body.");
        }

        /* renamed from: h */
        public a m71581h(AbstractC11920f0 abstractC11920f0) {
            return m71580g("POST", abstractC11920f0);
        }

        /* renamed from: i */
        public a m71582i(AbstractC11920f0 abstractC11920f0) {
            return m71580g("PUT", abstractC11920f0);
        }

        /* renamed from: j */
        public a m71583j(String str) {
            this.f55279c.m71865e(str);
            return this;
        }

        /* renamed from: k */
        public <T> a m71584k(Class<? super T> cls, T t10) {
            if (cls == null) {
                throw new NullPointerException("type == null");
            }
            if (t10 == null) {
                this.f55281e.remove(cls);
            } else {
                if (this.f55281e.isEmpty()) {
                    this.f55281e = new LinkedHashMap();
                }
                this.f55281e.put(cls, cls.cast(t10));
            }
            return this;
        }

        /* renamed from: l */
        public a m71585l(Object obj) {
            return m71584k(Object.class, obj);
        }

        /* renamed from: m */
        public a m71586m(String str) {
            if (str == null) {
                throw new NullPointerException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = "https:" + str.substring(4);
            }
            return m71588o(C11958y.m71887k(str));
        }

        /* renamed from: n */
        public a m71587n(URL url) {
            if (url != null) {
                return m71588o(C11958y.m71887k(url.toString()));
            }
            throw new NullPointerException("url == null");
        }

        /* renamed from: o */
        public a m71588o(C11958y c11958y) {
            if (c11958y == null) {
                throw new NullPointerException("url == null");
            }
            this.f55277a = c11958y;
            return this;
        }

        public a(C11918e0 c11918e0) {
            Map<Class<?>, Object> linkedHashMap;
            this.f55281e = Collections.emptyMap();
            this.f55282f = false;
            this.f55283g = new ArrayList<>();
            this.f55277a = c11918e0.f55269a;
            this.f55278b = c11918e0.f55270b;
            this.f55280d = c11918e0.f55272d;
            if (c11918e0.f55273e.isEmpty()) {
                linkedHashMap = Collections.emptyMap();
            } else {
                linkedHashMap = new LinkedHashMap<>(c11918e0.f55273e);
            }
            this.f55281e = linkedHashMap;
            this.f55279c = c11918e0.f55271c.m71856g();
            this.f55282f = c11918e0.f55275g;
            this.f55283g = c11918e0.f55276h;
        }
    }
}
