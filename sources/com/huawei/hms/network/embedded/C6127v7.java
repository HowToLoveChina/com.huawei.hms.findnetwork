package com.huawei.hms.network.embedded;

import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.network.embedded.C5971j7;
import java.io.Closeable;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* renamed from: com.huawei.hms.network.embedded.v7 */
/* loaded from: classes8.dex */
public final class C6127v7 implements Closeable {

    /* renamed from: a */
    public final C6101t7 f28655a;

    /* renamed from: b */
    public final EnumC6075r7 f28656b;

    /* renamed from: c */
    public final int f28657c;

    /* renamed from: d */
    public final String f28658d;

    /* renamed from: e */
    public final C5958i7 f28659e;

    /* renamed from: f */
    public final C5971j7 f28660f;

    /* renamed from: g */
    public final AbstractC6140w7 f28661g;

    /* renamed from: h */
    public final C6127v7 f28662h;

    /* renamed from: i */
    public final C6127v7 f28663i;

    /* renamed from: j */
    public final C6127v7 f28664j;

    /* renamed from: k */
    public final long f28665k;

    /* renamed from: l */
    public final long f28666l;

    /* renamed from: m */
    public final C6128v8 f28667m;

    /* renamed from: n */
    public volatile C6087s6 f28668n;

    /* renamed from: com.huawei.hms.network.embedded.v7$a */
    public static class a {

        /* renamed from: a */
        public C6101t7 f28669a;

        /* renamed from: b */
        public EnumC6075r7 f28670b;

        /* renamed from: c */
        public int f28671c;

        /* renamed from: d */
        public String f28672d;

        /* renamed from: e */
        public C5958i7 f28673e;

        /* renamed from: f */
        public C5971j7.a f28674f;

        /* renamed from: g */
        public AbstractC6140w7 f28675g;

        /* renamed from: h */
        public C6127v7 f28676h;

        /* renamed from: i */
        public C6127v7 f28677i;

        /* renamed from: j */
        public C6127v7 f28678j;

        /* renamed from: k */
        public long f28679k;

        /* renamed from: l */
        public long f28680l;

        /* renamed from: m */
        public C6128v8 f28681m;

        public a() {
            this.f28671c = -1;
            this.f28674f = new C5971j7.a();
        }

        /* renamed from: d */
        private void m35594d(C6127v7 c6127v7) {
            if (c6127v7.f28661g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        /* renamed from: a */
        public a m35595a(int i10) {
            this.f28671c = i10;
            return this;
        }

        /* renamed from: b */
        public a m35607b(long j10) {
            this.f28679k = j10;
            return this;
        }

        /* renamed from: c */
        public a m35611c(C6127v7 c6127v7) {
            if (c6127v7 != null) {
                m35594d(c6127v7);
            }
            this.f28678j = c6127v7;
            return this;
        }

        public a(C6127v7 c6127v7) {
            this.f28671c = -1;
            this.f28669a = c6127v7.f28655a;
            this.f28670b = c6127v7.f28656b;
            this.f28671c = c6127v7.f28657c;
            this.f28672d = c6127v7.f28658d;
            this.f28673e = c6127v7.f28659e;
            this.f28674f = c6127v7.f28660f.m34525c();
            this.f28675g = c6127v7.f28661g;
            this.f28676h = c6127v7.f28662h;
            this.f28677i = c6127v7.f28663i;
            this.f28678j = c6127v7.f28664j;
            this.f28679k = c6127v7.f28665k;
            this.f28680l = c6127v7.f28666l;
            this.f28681m = c6127v7.f28667m;
        }

        /* renamed from: a */
        public a m35596a(long j10) {
            this.f28680l = j10;
            return this;
        }

        /* renamed from: b */
        public a m35608b(C6127v7 c6127v7) {
            if (c6127v7 != null) {
                m35593a("networkResponse", c6127v7);
            }
            this.f28676h = c6127v7;
            return this;
        }

        /* renamed from: a */
        public a m35597a(C5958i7 c5958i7) {
            this.f28673e = c5958i7;
            return this;
        }

        /* renamed from: b */
        public a m35609b(String str) {
            this.f28674f.m34542d(str);
            return this;
        }

        /* renamed from: a */
        public a m35598a(C5971j7 c5971j7) {
            this.f28674f = c5971j7.m34525c();
            return this;
        }

        /* renamed from: b */
        public a m35610b(String str, String str2) {
            this.f28674f.m34543d(str, str2);
            return this;
        }

        /* renamed from: a */
        public a m35599a(EnumC6075r7 enumC6075r7) {
            this.f28670b = enumC6075r7;
            return this;
        }

        /* renamed from: a */
        public a m35600a(C6101t7 c6101t7) {
            this.f28669a = c6101t7;
            return this;
        }

        /* renamed from: a */
        public a m35601a(C6127v7 c6127v7) {
            if (c6127v7 != null) {
                m35593a("cacheResponse", c6127v7);
            }
            this.f28677i = c6127v7;
            return this;
        }

        /* renamed from: a */
        public a m35602a(AbstractC6140w7 abstractC6140w7) {
            this.f28675g = abstractC6140w7;
            return this;
        }

        /* renamed from: a */
        public a m35603a(String str) {
            this.f28672d = str;
            return this;
        }

        /* renamed from: a */
        public a m35604a(String str, String str2) {
            this.f28674f.m34532a(str, str2);
            return this;
        }

        /* renamed from: a */
        public C6127v7 m35605a() {
            if (this.f28669a == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.f28670b == null) {
                throw new IllegalStateException("protocol == null");
            }
            if (this.f28671c >= 0) {
                if (this.f28672d != null) {
                    return new C6127v7(this);
                }
                throw new IllegalStateException("message == null");
            }
            throw new IllegalStateException("code < 0: " + this.f28671c);
        }

        /* renamed from: a */
        public void m35606a(C6128v8 c6128v8) {
            this.f28681m = c6128v8;
        }

        /* renamed from: a */
        private void m35593a(String str, C6127v7 c6127v7) {
            if (c6127v7.f28661g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            }
            if (c6127v7.f28662h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            if (c6127v7.f28663i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            }
            if (c6127v7.f28664j == null) {
                return;
            }
            throw new IllegalArgumentException(str + ".priorResponse != null");
        }
    }

    public C6127v7(a aVar) {
        this.f28655a = aVar.f28669a;
        this.f28656b = aVar.f28670b;
        this.f28657c = aVar.f28671c;
        this.f28658d = aVar.f28672d;
        this.f28659e = aVar.f28673e;
        this.f28660f = aVar.f28674f.m34535a();
        this.f28661g = aVar.f28675g;
        this.f28662h = aVar.f28676h;
        this.f28663i = aVar.f28677i;
        this.f28664j = aVar.f28678j;
        this.f28665k = aVar.f28679k;
        this.f28666l = aVar.f28680l;
        this.f28667m = aVar.f28681m;
    }

    /* renamed from: A */
    public boolean m35571A() {
        int i10 = this.f28657c;
        return i10 >= 200 && i10 < 300;
    }

    /* renamed from: B */
    public String m35572B() {
        return this.f28658d;
    }

    /* renamed from: C */
    public C6127v7 m35573C() {
        return this.f28662h;
    }

    /* renamed from: D */
    public a m35574D() {
        return new a(this);
    }

    /* renamed from: E */
    public C6127v7 m35575E() {
        return this.f28664j;
    }

    /* renamed from: F */
    public EnumC6075r7 m35576F() {
        return this.f28656b;
    }

    /* renamed from: G */
    public long m35577G() {
        return this.f28666l;
    }

    /* renamed from: H */
    public C6101t7 m35578H() {
        return this.f28655a;
    }

    /* renamed from: I */
    public long m35579I() {
        return this.f28665k;
    }

    /* renamed from: J */
    public C5971j7 m35580J() throws IOException {
        C6128v8 c6128v8 = this.f28667m;
        if (c6128v8 != null) {
            return c6128v8.m35630l();
        }
        throw new IllegalStateException("trailers not available");
    }

    /* renamed from: a */
    public String m35581a(String str, String str2) {
        String strM34521a = this.f28660f.m34521a(str);
        return strM34521a != null ? strM34521a : str2;
    }

    /* renamed from: b */
    public String m35582b(String str) {
        return m35581a(str, null);
    }

    /* renamed from: c */
    public List<String> m35583c(String str) {
        return this.f28660f.m34528d(str);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        AbstractC6140w7 abstractC6140w7 = this.f28661g;
        if (abstractC6140w7 == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        abstractC6140w7.close();
    }

    /* renamed from: j */
    public AbstractC6140w7 m35584j(long j10) throws IOException {
        InterfaceC5896db interfaceC5896dbPeek = this.f28661g.mo34712x().peek();
        C5868bb c5868bb = new C5868bb();
        interfaceC5896dbPeek.mo33969h(j10);
        c5868bb.write(interfaceC5896dbPeek, Math.min(j10, interfaceC5896dbPeek.mo33966g().m33913B()));
        return AbstractC6140w7.m35731a(this.f28661g.mo34711w(), c5868bb.m33913B(), c5868bb);
    }

    /* renamed from: s */
    public AbstractC6140w7 m35585s() {
        return this.f28661g;
    }

    /* renamed from: t */
    public C6087s6 m35586t() {
        C6087s6 c6087s6 = this.f28668n;
        if (c6087s6 != null) {
            return c6087s6;
        }
        C6087s6 c6087s6M35255a = C6087s6.m35255a(this.f28660f);
        this.f28668n = c6087s6M35255a;
        return c6087s6M35255a;
    }

    public String toString() {
        return "Response{protocol=" + this.f28656b + ", code=" + this.f28657c + ", message=" + this.f28658d + ", url=" + this.f28655a.m35423k() + '}';
    }

    /* renamed from: u */
    public C6127v7 m35587u() {
        return this.f28663i;
    }

    /* renamed from: v */
    public List<C6139w6> m35588v() {
        String str;
        int i10 = this.f28657c;
        if (i10 == 401) {
            str = "WWW-Authenticate";
        } else {
            if (i10 != 407) {
                return Collections.emptyList();
            }
            str = "Proxy-Authenticate";
        }
        return C5960i9.m34408a(m35591y(), str);
    }

    /* renamed from: w */
    public int m35589w() {
        return this.f28657c;
    }

    /* renamed from: x */
    public C5958i7 m35590x() {
        return this.f28659e;
    }

    /* renamed from: y */
    public C5971j7 m35591y() {
        return this.f28660f;
    }

    /* renamed from: z */
    public boolean m35592z() {
        int i10 = this.f28657c;
        if (i10 == 307 || i10 == 308) {
            return true;
        }
        switch (i10) {
            case 300:
            case LocationRequest.PRIORITY_MAG_POSITION /* 301 */:
            case 302:
            case 303:
                return true;
            default:
                return false;
        }
    }
}
