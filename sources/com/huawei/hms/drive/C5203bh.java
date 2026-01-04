package com.huawei.hms.drive;

import com.huawei.hms.drive.C5190aw;
import java.io.Closeable;

/* renamed from: com.huawei.hms.drive.bh */
/* loaded from: classes8.dex */
public final class C5203bh implements Closeable {

    /* renamed from: a */
    final C5201bf f23943a;

    /* renamed from: b */
    final EnumC5199bd f23944b;

    /* renamed from: c */
    final int f23945c;

    /* renamed from: d */
    final String f23946d;

    /* renamed from: e */
    final C5189av f23947e;

    /* renamed from: f */
    final C5190aw f23948f;

    /* renamed from: g */
    final AbstractC5204bi f23949g;

    /* renamed from: h */
    final C5203bh f23950h;

    /* renamed from: i */
    final C5203bh f23951i;

    /* renamed from: j */
    final C5203bh f23952j;

    /* renamed from: k */
    final long f23953k;

    /* renamed from: l */
    final long f23954l;

    /* renamed from: m */
    final C5224ca f23955m;

    /* renamed from: n */
    private volatile C5176ai f23956n;

    /* renamed from: com.huawei.hms.drive.bh$a */
    public static class a {

        /* renamed from: a */
        C5201bf f23957a;

        /* renamed from: b */
        EnumC5199bd f23958b;

        /* renamed from: c */
        int f23959c;

        /* renamed from: d */
        String f23960d;

        /* renamed from: e */
        C5189av f23961e;

        /* renamed from: f */
        C5190aw.a f23962f;

        /* renamed from: g */
        AbstractC5204bi f23963g;

        /* renamed from: h */
        C5203bh f23964h;

        /* renamed from: i */
        C5203bh f23965i;

        /* renamed from: j */
        C5203bh f23966j;

        /* renamed from: k */
        long f23967k;

        /* renamed from: l */
        long f23968l;

        /* renamed from: m */
        C5224ca f23969m;

        public a() {
            this.f23959c = -1;
            this.f23962f = new C5190aw.a();
        }

        /* renamed from: d */
        private void m31140d(C5203bh c5203bh) {
            if (c5203bh.f23949g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        /* renamed from: a */
        public a m31146a(C5201bf c5201bf) {
            this.f23957a = c5201bf;
            return this;
        }

        /* renamed from: b */
        public a m31155b(String str, String str2) {
            this.f23962f.m30929a(str, str2);
            return this;
        }

        /* renamed from: c */
        public a m31156c(C5203bh c5203bh) {
            if (c5203bh != null) {
                m31140d(c5203bh);
            }
            this.f23966j = c5203bh;
            return this;
        }

        /* renamed from: a */
        public a m31145a(EnumC5199bd enumC5199bd) {
            this.f23958b = enumC5199bd;
            return this;
        }

        /* renamed from: b */
        public a m31154b(C5203bh c5203bh) {
            if (c5203bh != null) {
                m31139a("cacheResponse", c5203bh);
            }
            this.f23965i = c5203bh;
            return this;
        }

        /* renamed from: a */
        public a m31141a(int i10) {
            this.f23959c = i10;
            return this;
        }

        public a(C5203bh c5203bh) {
            this.f23959c = -1;
            this.f23957a = c5203bh.f23943a;
            this.f23958b = c5203bh.f23944b;
            this.f23959c = c5203bh.f23945c;
            this.f23960d = c5203bh.f23946d;
            this.f23961e = c5203bh.f23947e;
            this.f23962f = c5203bh.f23948f.m30924b();
            this.f23963g = c5203bh.f23949g;
            this.f23964h = c5203bh.f23950h;
            this.f23965i = c5203bh.f23951i;
            this.f23966j = c5203bh.f23952j;
            this.f23967k = c5203bh.f23953k;
            this.f23968l = c5203bh.f23954l;
            this.f23969m = c5203bh.f23955m;
        }

        /* renamed from: a */
        public a m31149a(String str) {
            this.f23960d = str;
            return this;
        }

        /* renamed from: b */
        public a m31153b(long j10) {
            this.f23968l = j10;
            return this;
        }

        /* renamed from: a */
        public a m31143a(C5189av c5189av) {
            this.f23961e = c5189av;
            return this;
        }

        /* renamed from: a */
        public a m31150a(String str, String str2) {
            this.f23962f.m30933c(str, str2);
            return this;
        }

        /* renamed from: a */
        public a m31144a(C5190aw c5190aw) {
            this.f23962f = c5190aw.m30924b();
            return this;
        }

        /* renamed from: a */
        public a m31148a(AbstractC5204bi abstractC5204bi) {
            this.f23963g = abstractC5204bi;
            return this;
        }

        /* renamed from: a */
        public a m31147a(C5203bh c5203bh) {
            if (c5203bh != null) {
                m31139a("networkResponse", c5203bh);
            }
            this.f23964h = c5203bh;
            return this;
        }

        /* renamed from: a */
        private void m31139a(String str, C5203bh c5203bh) {
            if (c5203bh.f23949g == null) {
                if (c5203bh.f23950h == null) {
                    if (c5203bh.f23951i == null) {
                        if (c5203bh.f23952j == null) {
                            return;
                        }
                        throw new IllegalArgumentException(str + ".priorResponse != null");
                    }
                    throw new IllegalArgumentException(str + ".cacheResponse != null");
                }
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            throw new IllegalArgumentException(str + ".body != null");
        }

        /* renamed from: a */
        public a m31142a(long j10) {
            this.f23967k = j10;
            return this;
        }

        /* renamed from: a */
        public void m31152a(C5224ca c5224ca) {
            this.f23969m = c5224ca;
        }

        /* renamed from: a */
        public C5203bh m31151a() {
            if (this.f23957a != null) {
                if (this.f23958b != null) {
                    if (this.f23959c >= 0) {
                        if (this.f23960d != null) {
                            return new C5203bh(this);
                        }
                        throw new IllegalStateException("message == null");
                    }
                    throw new IllegalStateException("code < 0: " + this.f23959c);
                }
                throw new IllegalStateException("protocol == null");
            }
            throw new IllegalStateException("request == null");
        }
    }

    public C5203bh(a aVar) {
        this.f23943a = aVar.f23957a;
        this.f23944b = aVar.f23958b;
        this.f23945c = aVar.f23959c;
        this.f23946d = aVar.f23960d;
        this.f23947e = aVar.f23961e;
        this.f23948f = aVar.f23962f.m30930a();
        this.f23949g = aVar.f23963g;
        this.f23950h = aVar.f23964h;
        this.f23951i = aVar.f23965i;
        this.f23952j = aVar.f23966j;
        this.f23953k = aVar.f23967k;
        this.f23954l = aVar.f23968l;
        this.f23955m = aVar.f23969m;
    }

    /* renamed from: a */
    public C5201bf m31126a() {
        return this.f23943a;
    }

    /* renamed from: b */
    public int m31129b() {
        return this.f23945c;
    }

    /* renamed from: c */
    public String m31130c() {
        return this.f23946d;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        AbstractC5204bi abstractC5204bi = this.f23949g;
        if (abstractC5204bi == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        abstractC5204bi.close();
    }

    /* renamed from: d */
    public C5189av m31131d() {
        return this.f23947e;
    }

    /* renamed from: e */
    public C5190aw m31132e() {
        return this.f23948f;
    }

    /* renamed from: f */
    public AbstractC5204bi m31133f() {
        return this.f23949g;
    }

    /* renamed from: g */
    public a m31134g() {
        return new a(this);
    }

    /* renamed from: h */
    public C5203bh m31135h() {
        return this.f23952j;
    }

    /* renamed from: i */
    public C5176ai m31136i() {
        C5176ai c5176ai = this.f23956n;
        if (c5176ai != null) {
            return c5176ai;
        }
        C5176ai c5176aiM30821a = C5176ai.m30821a(this.f23948f);
        this.f23956n = c5176aiM30821a;
        return c5176aiM30821a;
    }

    /* renamed from: j */
    public long m31137j() {
        return this.f23953k;
    }

    /* renamed from: k */
    public long m31138k() {
        return this.f23954l;
    }

    public String toString() {
        return "Response{protocol=" + this.f23944b + ", code=" + this.f23945c + ", message=" + this.f23946d + ", url=" + this.f23943a.m31107a() + '}';
    }

    /* renamed from: a */
    public String m31127a(String str) {
        return m31128a(str, null);
    }

    /* renamed from: a */
    public String m31128a(String str, String str2) {
        String strM30923a = this.f23948f.m30923a(str);
        return strM30923a != null ? strM30923a : str2;
    }
}
