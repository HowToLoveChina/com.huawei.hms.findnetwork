package com.huawei.hms.drive;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.hms.drive.t */
/* loaded from: classes8.dex */
public class C5298t {

    /* renamed from: d */
    private int f24559d;

    /* renamed from: a */
    private String f24556a = "A";

    /* renamed from: b */
    private List<a> f24557b = new ArrayList();

    /* renamed from: c */
    private long f24558c = System.currentTimeMillis();

    /* renamed from: e */
    private int f24560e = -1;

    /* renamed from: com.huawei.hms.drive.t$a */
    public static class a {

        /* renamed from: a */
        private String f24561a;

        /* renamed from: b */
        private String f24562b;

        /* renamed from: c */
        private long f24563c;

        /* renamed from: com.huawei.hms.drive.t$a$a, reason: collision with other inner class name */
        public static final class C14437a {

            /* renamed from: a */
            private String f24564a;

            /* renamed from: b */
            private String f24565b;

            /* renamed from: c */
            private long f24566c = 2147483647L;

            /* renamed from: a */
            public C14437a m31813a(long j10) {
                this.f24566c = j10;
                return this;
            }

            /* renamed from: b */
            public C14437a m31816b(String str) {
                this.f24565b = str;
                return this;
            }

            /* renamed from: a */
            public C14437a m31814a(String str) {
                this.f24564a = str;
                return this;
            }

            /* renamed from: a */
            public a m31815a() {
                return new a(this);
            }
        }

        private a(C14437a c14437a) {
            this.f24561a = c14437a.f24564a;
            this.f24562b = c14437a.f24565b;
            this.f24563c = c14437a.f24566c;
        }

        /* renamed from: a */
        public String m31807a() {
            return this.f24561a;
        }

        /* renamed from: b */
        public String m31808b() {
            return this.f24562b;
        }

        /* renamed from: c */
        public long m31809c() {
            return this.f24563c;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Address{type='");
            sb2.append(this.f24561a);
            sb2.append('\'');
            sb2.append(", value is null='");
            sb2.append(this.f24562b == null);
            sb2.append('\'');
            sb2.append(", ttl=");
            sb2.append(this.f24563c);
            sb2.append('}');
            return sb2.toString();
        }
    }

    /* renamed from: a */
    public String m31798a() {
        return this.f24556a;
    }

    /* renamed from: b */
    public List<a> m31803b() {
        return this.f24557b;
    }

    /* renamed from: c */
    public long m31804c() {
        return this.f24558c;
    }

    /* renamed from: d */
    public boolean m31805d() {
        return this.f24557b.isEmpty();
    }

    /* renamed from: e */
    public int m31806e() {
        long jAbs = Math.abs(System.currentTimeMillis() - this.f24558c);
        if (jAbs < 600000) {
            return 0;
        }
        return jAbs < 86400000 ? 1 : 2;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("DnsResult{type='");
        sb2.append(this.f24556a);
        sb2.append('\'');
        sb2.append(m31805d() ? ", addressList isEmpty" : ", addressList is not Empty");
        sb2.append(", createTime=");
        sb2.append(this.f24558c);
        sb2.append(", source=");
        sb2.append(this.f24559d);
        sb2.append(", cache=");
        sb2.append(this.f24560e);
        sb2.append('}');
        return sb2.toString();
    }

    /* renamed from: a */
    public void m31799a(int i10) {
        this.f24560e = i10;
    }

    /* renamed from: a */
    public void m31800a(long j10) {
        this.f24558c = j10;
    }

    /* renamed from: a */
    public void m31801a(String str) {
        this.f24556a = str;
    }

    /* renamed from: a */
    public void m31802a(List<a> list) {
        if (list == null) {
            this.f24557b = new ArrayList();
        } else {
            this.f24557b = list;
        }
    }
}
