package com.huawei.hms.network.embedded;

import com.huawei.android.hicloud.drive.clouddisk.expand.RequestMethod;
import com.huawei.hms.network.embedded.C5971j7;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.hms.network.embedded.t7 */
/* loaded from: classes8.dex */
public final class C6101t7 {

    /* renamed from: a */
    public final C6010m7 f28395a;

    /* renamed from: b */
    public final String f28396b;

    /* renamed from: c */
    public final C5971j7 f28397c;

    /* renamed from: d */
    public final AbstractC6114u7 f28398d;

    /* renamed from: e */
    public final Map<Class<?>, Object> f28399e;

    /* renamed from: f */
    public volatile C6087s6 f28400f;

    /* renamed from: g */
    public final boolean f28401g;

    /* renamed from: h */
    public final ArrayList<InetAddress> f28402h;

    /* renamed from: com.huawei.hms.network.embedded.t7$a */
    public static class a {

        /* renamed from: a */
        public C6010m7 f28403a;

        /* renamed from: b */
        public String f28404b;

        /* renamed from: c */
        public C5971j7.a f28405c;

        /* renamed from: d */
        public AbstractC6114u7 f28406d;

        /* renamed from: e */
        public Map<Class<?>, Object> f28407e;

        /* renamed from: f */
        public boolean f28408f;

        /* renamed from: g */
        public ArrayList<InetAddress> f28409g;

        public a() {
            this.f28407e = Collections.emptyMap();
            this.f28408f = false;
            this.f28409g = new ArrayList<>();
            this.f28404b = "GET";
            this.f28405c = new C5971j7.a();
        }

        /* renamed from: a */
        public a m35424a(C5971j7 c5971j7) {
            this.f28405c = c5971j7.m34525c();
            return this;
        }

        /* renamed from: b */
        public a m35437b() {
            return m35427a(C5920f8.f26773e);
        }

        /* renamed from: c */
        public a m35441c() {
            return m35431a("GET", (AbstractC6114u7) null);
        }

        /* renamed from: d */
        public a m35444d() {
            return m35431a("HEAD", (AbstractC6114u7) null);
        }

        public a(C6101t7 c6101t7) {
            this.f28407e = Collections.emptyMap();
            this.f28408f = false;
            this.f28409g = new ArrayList<>();
            this.f28403a = c6101t7.f28395a;
            this.f28404b = c6101t7.f28396b;
            this.f28406d = c6101t7.f28398d;
            this.f28407e = c6101t7.f28399e.isEmpty() ? Collections.emptyMap() : new LinkedHashMap<>(c6101t7.f28399e);
            this.f28405c = c6101t7.f28397c.m34525c();
            this.f28408f = c6101t7.f28401g;
            this.f28409g = c6101t7.f28402h;
        }

        /* renamed from: a */
        public a m35425a(C6010m7 c6010m7) {
            if (c6010m7 == null) {
                throw new NullPointerException("url == null");
            }
            this.f28403a = c6010m7;
            return this;
        }

        /* renamed from: b */
        public a m35438b(AbstractC6114u7 abstractC6114u7) {
            return m35431a(RequestMethod.PATCH, abstractC6114u7);
        }

        /* renamed from: c */
        public a m35442c(AbstractC6114u7 abstractC6114u7) {
            return m35431a("POST", abstractC6114u7);
        }

        /* renamed from: d */
        public a m35445d(AbstractC6114u7 abstractC6114u7) {
            return m35431a("PUT", abstractC6114u7);
        }

        /* renamed from: a */
        public a m35426a(C6087s6 c6087s6) {
            String string = c6087s6.toString();
            return string.isEmpty() ? m35439b("Cache-Control") : m35440b("Cache-Control", string);
        }

        /* renamed from: b */
        public a m35439b(String str) {
            this.f28405c.m34542d(str);
            return this;
        }

        /* renamed from: c */
        public a m35443c(String str) {
            StringBuilder sb2;
            int i10;
            if (str == null) {
                throw new NullPointerException("url == null");
            }
            if (!str.regionMatches(true, 0, "ws:", 0, 3)) {
                if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                    sb2 = new StringBuilder();
                    sb2.append("https:");
                    i10 = 4;
                }
                return m35425a(C6010m7.m34781f(str));
            }
            sb2 = new StringBuilder();
            sb2.append("http:");
            i10 = 3;
            sb2.append(str.substring(i10));
            str = sb2.toString();
            return m35425a(C6010m7.m34781f(str));
        }

        /* renamed from: a */
        public a m35427a(AbstractC6114u7 abstractC6114u7) {
            return m35431a("DELETE", abstractC6114u7);
        }

        /* renamed from: b */
        public a m35440b(String str, String str2) {
            this.f28405c.m34543d(str, str2);
            return this;
        }

        /* renamed from: a */
        public <T> a m35428a(Class<? super T> cls, T t10) {
            if (cls == null) {
                throw new NullPointerException("type == null");
            }
            if (t10 == null) {
                this.f28407e.remove(cls);
            } else {
                if (this.f28407e.isEmpty()) {
                    this.f28407e = new LinkedHashMap();
                }
                this.f28407e.put(cls, cls.cast(t10));
            }
            return this;
        }

        /* renamed from: a */
        public a m35429a(Object obj) {
            return m35428a((Class<? super Class>) Object.class, (Class) obj);
        }

        /* renamed from: a */
        public a m35430a(String str) throws UnknownHostException {
            if (str == null) {
                throw new IllegalArgumentException("IP address is null");
            }
            try {
                for (InetAddress inetAddress : InetAddress.getAllByName(str)) {
                    this.f28409g.add(inetAddress);
                }
                return this;
            } catch (NullPointerException e10) {
                UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + str);
                unknownHostException.initCause(e10);
                throw unknownHostException;
            }
        }

        /* renamed from: a */
        public a m35431a(String str, AbstractC6114u7 abstractC6114u7) {
            if (str == null) {
                throw new NullPointerException("method == null");
            }
            if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            }
            if (abstractC6114u7 != null && !C5973j9.m34546b(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            }
            if (abstractC6114u7 != null || !C5973j9.m34549e(str)) {
                this.f28404b = str;
                this.f28406d = abstractC6114u7;
                return this;
            }
            throw new IllegalArgumentException("method " + str + " must have a request body.");
        }

        /* renamed from: a */
        public a m35432a(String str, String str2) {
            this.f28405c.m34532a(str, str2);
            return this;
        }

        /* renamed from: a */
        public a m35433a(URL url) {
            if (url != null) {
                return m35425a(C6010m7.m34781f(url.toString()));
            }
            throw new NullPointerException("url == null");
        }

        /* renamed from: a */
        public a m35434a(ArrayList<String> arrayList) throws UnknownHostException {
            if (arrayList == null) {
                throw new IllegalArgumentException("additionalIpAddresses is null");
            }
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                m35430a(it.next());
            }
            return this;
        }

        /* renamed from: a */
        public a m35435a(boolean z10) {
            this.f28408f = z10;
            return this;
        }

        /* renamed from: a */
        public C6101t7 m35436a() {
            if (this.f28403a != null) {
                return new C6101t7(this);
            }
            throw new IllegalStateException("url == null");
        }
    }

    public C6101t7(a aVar) {
        this.f28395a = aVar.f28403a;
        this.f28396b = aVar.f28404b;
        this.f28397c = aVar.f28405c.m34535a();
        this.f28398d = aVar.f28406d;
        this.f28399e = C5920f8.m34244a(aVar.f28407e);
        this.f28401g = aVar.f28408f;
        this.f28402h = aVar.f28409g;
    }

    /* renamed from: a */
    public <T> T m35410a(Class<? extends T> cls) {
        return cls.cast(this.f28399e.get(cls));
    }

    /* renamed from: b */
    public AbstractC6114u7 m35413b() {
        return this.f28398d;
    }

    /* renamed from: c */
    public C6087s6 m35415c() {
        C6087s6 c6087s6 = this.f28400f;
        if (c6087s6 != null) {
            return c6087s6;
        }
        C6087s6 c6087s6M35255a = C6087s6.m35255a(this.f28397c);
        this.f28400f = c6087s6M35255a;
        return c6087s6M35255a;
    }

    /* renamed from: d */
    public boolean m35416d() {
        return this.f28401g;
    }

    /* renamed from: e */
    public C5971j7 m35417e() {
        return this.f28397c;
    }

    /* renamed from: f */
    public boolean m35418f() {
        return m35411a("Http2ConnectionIndex") != null;
    }

    /* renamed from: g */
    public boolean m35419g() {
        return this.f28395a.m34798i();
    }

    /* renamed from: h */
    public String m35420h() {
        return this.f28396b;
    }

    /* renamed from: i */
    public a m35421i() {
        return new a(this);
    }

    /* renamed from: j */
    public Object m35422j() {
        return m35410a(Object.class);
    }

    /* renamed from: k */
    public C6010m7 m35423k() {
        return this.f28395a;
    }

    public String toString() {
        return "Request{method=" + this.f28396b + ", url=" + this.f28395a + ", tags=" + this.f28399e + '}';
    }

    /* renamed from: a */
    public String m35411a(String str) {
        return this.f28397c.m34521a(str);
    }

    /* renamed from: b */
    public List<String> m35414b(String str) {
        return this.f28397c.m34528d(str);
    }

    /* renamed from: a */
    public ArrayList<InetAddress> m35412a() {
        return this.f28402h;
    }
}
