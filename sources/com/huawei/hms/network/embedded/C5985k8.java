package com.huawei.hms.network.embedded;

import com.huawei.hms.network.embedded.C5971j7;
import com.huawei.hms.network.embedded.C6069r1;
import com.huawei.hms.network.embedded.C6127v7;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.hms.network.embedded.k8 */
/* loaded from: classes8.dex */
public final class C5985k8 {

    /* renamed from: a */
    public final C6101t7 f27298a;

    /* renamed from: b */
    public final C6127v7 f27299b;

    /* renamed from: com.huawei.hms.network.embedded.k8$a */
    public static class a {

        /* renamed from: a */
        public final long f27300a;

        /* renamed from: b */
        public final C6101t7 f27301b;

        /* renamed from: c */
        public final C6127v7 f27302c;

        /* renamed from: d */
        public Date f27303d;

        /* renamed from: e */
        public String f27304e;

        /* renamed from: f */
        public Date f27305f;

        /* renamed from: g */
        public String f27306g;

        /* renamed from: h */
        public Date f27307h;

        /* renamed from: i */
        public long f27308i;

        /* renamed from: j */
        public long f27309j;

        /* renamed from: k */
        public String f27310k;

        /* renamed from: l */
        public int f27311l;

        public a(long j10, C6101t7 c6101t7, C6127v7 c6127v7) {
            this.f27311l = -1;
            this.f27300a = j10;
            this.f27301b = c6101t7;
            this.f27302c = c6127v7;
            if (c6127v7 != null) {
                this.f27308i = c6127v7.m35579I();
                this.f27309j = c6127v7.m35577G();
                C5971j7 c5971j7M35591y = c6127v7.m35591y();
                int iM34527d = c5971j7M35591y.m34527d();
                for (int i10 = 0; i10 < iM34527d; i10++) {
                    String strM34520a = c5971j7M35591y.m34520a(i10);
                    String strM34522b = c5971j7M35591y.m34522b(i10);
                    if ("Date".equalsIgnoreCase(strM34520a)) {
                        this.f27303d = C5947h9.m34366a(strM34522b);
                        this.f27304e = strM34522b;
                    } else if ("Expires".equalsIgnoreCase(strM34520a)) {
                        this.f27307h = C5947h9.m34366a(strM34522b);
                    } else if ("Last-Modified".equalsIgnoreCase(strM34520a)) {
                        this.f27305f = C5947h9.m34366a(strM34522b);
                        this.f27306g = strM34522b;
                    } else if ("ETag".equalsIgnoreCase(strM34520a)) {
                        this.f27310k = strM34522b;
                    } else if ("Age".equalsIgnoreCase(strM34520a)) {
                        this.f27311l = C5960i9.m34400a(strM34522b, -1);
                    }
                }
            }
        }

        /* renamed from: b */
        private long m34614b() {
            Date date = this.f27303d;
            long jMax = date != null ? Math.max(0L, this.f27309j - date.getTime()) : 0L;
            int i10 = this.f27311l;
            if (i10 != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(i10));
            }
            long j10 = this.f27309j;
            return jMax + (j10 - this.f27308i) + (this.f27300a - j10);
        }

        /* renamed from: c */
        private long m34615c() {
            if (this.f27302c.m35586t().m35260d() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.m35260d());
            }
            if (this.f27307h != null) {
                Date date = this.f27303d;
                long time = this.f27307h.getTime() - (date != null ? date.getTime() : this.f27309j);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.f27305f == null || this.f27302c.m35578H().m35423k().m34804o() != null) {
                return 0L;
            }
            Date date2 = this.f27303d;
            long time2 = (date2 != null ? date2.getTime() : this.f27308i) - this.f27305f.getTime();
            if (time2 > 0) {
                return time2 / 10;
            }
            return 0L;
        }

        /* renamed from: d */
        private C5985k8 m34616d() {
            String str;
            if (this.f27302c == null) {
                return new C5985k8(this.f27301b, null);
            }
            if ((!this.f27301b.m35419g() || this.f27302c.m35590x() != null) && C5985k8.m34612a(this.f27302c, this.f27301b)) {
                C6087s6 c6087s6M35415c = this.f27301b.m35415c();
                if (c6087s6M35415c.m35264h() || m34613a(this.f27301b)) {
                    return new C5985k8(this.f27301b, null);
                }
                C6087s6 c6087s6M35586t = this.f27302c.m35586t();
                long jM34614b = m34614b();
                long jM34615c = m34615c();
                if (c6087s6M35415c.m35260d() != -1) {
                    jM34615c = Math.min(jM34615c, TimeUnit.SECONDS.toMillis(c6087s6M35415c.m35260d()));
                }
                long millis = 0;
                long millis2 = c6087s6M35415c.m35262f() != -1 ? TimeUnit.SECONDS.toMillis(c6087s6M35415c.m35262f()) : 0L;
                if (!c6087s6M35586t.m35263g() && c6087s6M35415c.m35261e() != -1) {
                    millis = TimeUnit.SECONDS.toMillis(c6087s6M35415c.m35261e());
                }
                if (!c6087s6M35586t.m35264h()) {
                    long j10 = millis2 + jM34614b;
                    if (j10 < millis + jM34615c) {
                        C6127v7.a aVarM35574D = this.f27302c.m35574D();
                        if (j10 >= jM34615c) {
                            aVarM35574D.m35604a("Warning", "110 HttpURLConnection \"Response is stale\"");
                        }
                        if (jM34614b > 86400000 && m34617e()) {
                            aVarM35574D.m35604a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                        }
                        return new C5985k8(null, aVarM35574D.m35605a());
                    }
                }
                String str2 = this.f27310k;
                if (str2 != null) {
                    str = C6069r1.b.f27985n;
                } else {
                    if (this.f27305f != null) {
                        str2 = this.f27306g;
                    } else {
                        if (this.f27303d == null) {
                            return new C5985k8(this.f27301b, null);
                        }
                        str2 = this.f27304e;
                    }
                    str = C6069r1.b.f27986o;
                }
                C5971j7.a aVarM34525c = this.f27301b.m35417e().m34525c();
                AbstractC5879c8.f26567a.mo34048a(aVarM34525c, str, str2);
                return new C5985k8(this.f27301b.m35421i().m35424a(aVarM34525c.m34535a()).m35436a(), this.f27302c);
            }
            return new C5985k8(this.f27301b, null);
        }

        /* renamed from: e */
        private boolean m34617e() {
            return this.f27302c.m35586t().m35260d() == -1 && this.f27307h == null;
        }

        /* renamed from: a */
        public C5985k8 m34618a() {
            C5985k8 c5985k8M34616d = m34616d();
            return (c5985k8M34616d.f27298a == null || !this.f27301b.m35415c().m35267k()) ? c5985k8M34616d : new C5985k8(null, null);
        }

        /* renamed from: a */
        public static boolean m34613a(C6101t7 c6101t7) {
            return (c6101t7.m35411a(C6069r1.b.f27986o) == null && c6101t7.m35411a(C6069r1.b.f27985n) == null) ? false : true;
        }
    }

    public C5985k8(C6101t7 c6101t7, C6127v7 c6127v7) {
        this.f27298a = c6101t7;
        this.f27299b = c6127v7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (r3.m35586t().m35258b() == false) goto L33;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m34612a(com.huawei.hms.network.embedded.C6127v7 r3, com.huawei.hms.network.embedded.C6101t7 r4) {
        /*
            int r0 = r3.m35589w()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L5a
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L5a
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L5a
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L5a
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L5a
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L5a
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L31
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L5a
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L5a
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L5a
            switch(r0) {
                case 300: goto L5a;
                case 301: goto L5a;
                case 302: goto L31;
                default: goto L30;
            }
        L30:
            goto L59
        L31:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.m35582b(r0)
            if (r0 != 0) goto L5a
            com.huawei.hms.network.embedded.s6 r0 = r3.m35586t()
            int r0 = r0.m35260d()
            r1 = -1
            if (r0 != r1) goto L5a
            com.huawei.hms.network.embedded.s6 r0 = r3.m35586t()
            boolean r0 = r0.m35259c()
            if (r0 != 0) goto L5a
            com.huawei.hms.network.embedded.s6 r0 = r3.m35586t()
            boolean r0 = r0.m35258b()
            if (r0 == 0) goto L59
            goto L5a
        L59:
            return r2
        L5a:
            com.huawei.hms.network.embedded.s6 r3 = r3.m35586t()
            boolean r3 = r3.m35265i()
            if (r3 != 0) goto L6f
            com.huawei.hms.network.embedded.s6 r3 = r4.m35415c()
            boolean r3 = r3.m35265i()
            if (r3 != 0) goto L6f
            r2 = 1
        L6f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.C5985k8.m34612a(com.huawei.hms.network.embedded.v7, com.huawei.hms.network.embedded.t7):boolean");
    }
}
