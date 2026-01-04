package com.huawei.hms.drive;

import com.huawei.hms.drive.C5190aw;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.huawei.hms.drive.bf */
/* loaded from: classes8.dex */
public final class C5201bf {

    /* renamed from: a */
    final C5193az f23920a;

    /* renamed from: b */
    final String f23921b;

    /* renamed from: c */
    final C5190aw f23922c;

    /* renamed from: d */
    final AbstractC5202bg f23923d;

    /* renamed from: e */
    final Map<Class<?>, Object> f23924e;

    /* renamed from: f */
    final boolean f23925f;

    /* renamed from: g */
    final ArrayList<InetAddress> f23926g;

    /* renamed from: h */
    private volatile C5176ai f23927h;

    /* renamed from: com.huawei.hms.drive.bf$a */
    public static class a {

        /* renamed from: a */
        C5193az f23928a;

        /* renamed from: b */
        String f23929b;

        /* renamed from: c */
        C5190aw.a f23930c;

        /* renamed from: d */
        AbstractC5202bg f23931d;

        /* renamed from: e */
        Map<Class<?>, Object> f23932e;

        /* renamed from: f */
        boolean f23933f;

        /* renamed from: g */
        ArrayList<InetAddress> f23934g;

        public a() {
            this.f23932e = Collections.emptyMap();
            this.f23933f = false;
            this.f23934g = new ArrayList<>();
            this.f23929b = "GET";
            this.f23930c = new C5190aw.a();
        }

        /* renamed from: a */
        public a m31119a(C5193az c5193az) {
            if (c5193az == null) {
                throw new NullPointerException("url == null");
            }
            this.f23928a = c5193az;
            return this;
        }

        /* renamed from: b */
        public a m31125b(String str, String str2) {
            this.f23930c.m30929a(str, str2);
            return this;
        }

        /* renamed from: b */
        public a m31124b(String str) {
            this.f23930c.m30931b(str);
            return this;
        }

        /* renamed from: a */
        public a m31120a(String str) {
            if (str != null) {
                if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                    str = "http:" + str.substring(3);
                } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                    str = "https:" + str.substring(4);
                }
                return m31119a(C5193az.m30962e(str));
            }
            throw new NullPointerException("url == null");
        }

        public a(C5201bf c5201bf) {
            Map<Class<?>, Object> linkedHashMap;
            this.f23932e = Collections.emptyMap();
            this.f23933f = false;
            this.f23934g = new ArrayList<>();
            this.f23928a = c5201bf.f23920a;
            this.f23929b = c5201bf.f23921b;
            this.f23931d = c5201bf.f23923d;
            if (c5201bf.f23924e.isEmpty()) {
                linkedHashMap = Collections.emptyMap();
            } else {
                linkedHashMap = new LinkedHashMap<>(c5201bf.f23924e);
            }
            this.f23932e = linkedHashMap;
            this.f23930c = c5201bf.f23922c.m30924b();
            this.f23933f = c5201bf.f23925f;
            this.f23934g = c5201bf.f23926g;
        }

        /* renamed from: a */
        public a m31122a(String str, String str2) {
            this.f23930c.m30933c(str, str2);
            return this;
        }

        /* renamed from: a */
        public a m31118a(C5190aw c5190aw) {
            this.f23930c = c5190aw.m30924b();
            return this;
        }

        /* renamed from: a */
        public a m31121a(String str, AbstractC5202bg abstractC5202bg) {
            if (str != null) {
                if (str.length() == 0) {
                    throw new IllegalArgumentException("method.length() == 0");
                }
                if (abstractC5202bg != null && !C5238co.m31418c(str)) {
                    throw new IllegalArgumentException("method " + str + " must not have a request body.");
                }
                if (abstractC5202bg == null && C5238co.m31417b(str)) {
                    throw new IllegalArgumentException("method " + str + " must have a request body.");
                }
                this.f23929b = str;
                this.f23931d = abstractC5202bg;
                return this;
            }
            throw new NullPointerException("method == null");
        }

        /* renamed from: a */
        public C5201bf m31123a() {
            if (this.f23928a != null) {
                return new C5201bf(this);
            }
            throw new IllegalStateException("url == null");
        }
    }

    public C5201bf(a aVar) {
        this.f23920a = aVar.f23928a;
        this.f23921b = aVar.f23929b;
        this.f23922c = aVar.f23930c.m30930a();
        this.f23923d = aVar.f23931d;
        this.f23924e = C5210bo.m31187a(aVar.f23932e);
        this.f23925f = aVar.f23933f;
        this.f23926g = aVar.f23934g;
    }

    /* renamed from: a */
    public C5193az m31107a() {
        return this.f23920a;
    }

    /* renamed from: b */
    public String m31109b() {
        return this.f23921b;
    }

    /* renamed from: c */
    public C5190aw m31110c() {
        return this.f23922c;
    }

    /* renamed from: d */
    public AbstractC5202bg m31111d() {
        return this.f23923d;
    }

    /* renamed from: e */
    public boolean m31112e() {
        return this.f23925f;
    }

    /* renamed from: f */
    public ArrayList<InetAddress> m31113f() {
        return this.f23926g;
    }

    /* renamed from: g */
    public a m31114g() {
        return new a(this);
    }

    /* renamed from: h */
    public C5176ai m31115h() {
        C5176ai c5176ai = this.f23927h;
        if (c5176ai != null) {
            return c5176ai;
        }
        C5176ai c5176aiM30821a = C5176ai.m30821a(this.f23922c);
        this.f23927h = c5176aiM30821a;
        return c5176aiM30821a;
    }

    /* renamed from: i */
    public boolean m31116i() {
        return this.f23920a.m30966c();
    }

    /* renamed from: j */
    public boolean m31117j() {
        return m31108a("Http2ConnectionIndex") != null;
    }

    public String toString() {
        return "Request{method=" + this.f23921b + ", url=" + this.f23920a + ", tags=" + this.f23924e + '}';
    }

    /* renamed from: a */
    public String m31108a(String str) {
        return this.f23922c.m30923a(str);
    }
}
