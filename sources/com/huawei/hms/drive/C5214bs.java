package com.huawei.hms.drive;

import com.huawei.hms.drive.C5190aw;
import com.huawei.hms.drive.C5203bh;
import com.huawei.hms.network.embedded.C6069r1;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.hms.drive.bs */
/* loaded from: classes8.dex */
public final class C5214bs {

    /* renamed from: a */
    public final C5201bf f24006a;

    /* renamed from: b */
    public final C5203bh f24007b;

    public C5214bs(C5201bf c5201bf, C5203bh c5203bh) {
        this.f24006a = c5201bf;
        this.f24007b = c5203bh;
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x0056, code lost:
    
        if (r3.m31136i().m30826d() == false) goto L75;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m31219a(com.huawei.hms.drive.C5203bh r3, com.huawei.hms.drive.C5201bf r4) {
        /*
            int r0 = r3.m31129b()
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
            java.lang.String r0 = r3.m31127a(r0)
            if (r0 != 0) goto L5a
            com.huawei.hms.drive.ai r0 = r3.m31136i()
            int r0 = r0.m30825c()
            r1 = -1
            if (r0 != r1) goto L5a
            com.huawei.hms.drive.ai r0 = r3.m31136i()
            boolean r0 = r0.m30827e()
            if (r0 != 0) goto L5a
            com.huawei.hms.drive.ai r0 = r3.m31136i()
            boolean r0 = r0.m30826d()
            if (r0 == 0) goto L59
            goto L5a
        L59:
            return r2
        L5a:
            com.huawei.hms.drive.ai r3 = r3.m31136i()
            boolean r3 = r3.m30824b()
            if (r3 != 0) goto L6f
            com.huawei.hms.drive.ai r3 = r4.m31115h()
            boolean r3 = r3.m30824b()
            if (r3 != 0) goto L6f
            r2 = 1
        L6f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.drive.C5214bs.m31219a(com.huawei.hms.drive.bh, com.huawei.hms.drive.bf):boolean");
    }

    /* renamed from: com.huawei.hms.drive.bs$a */
    public static class a {

        /* renamed from: a */
        final long f24008a;

        /* renamed from: b */
        final C5201bf f24009b;

        /* renamed from: c */
        final C5203bh f24010c;

        /* renamed from: d */
        private Date f24011d;

        /* renamed from: e */
        private String f24012e;

        /* renamed from: f */
        private Date f24013f;

        /* renamed from: g */
        private String f24014g;

        /* renamed from: h */
        private Date f24015h;

        /* renamed from: i */
        private long f24016i;

        /* renamed from: j */
        private long f24017j;

        /* renamed from: k */
        private String f24018k;

        /* renamed from: l */
        private int f24019l;

        public a(long j10, C5201bf c5201bf, C5203bh c5203bh) {
            this.f24019l = -1;
            this.f24008a = j10;
            this.f24009b = c5201bf;
            this.f24010c = c5203bh;
            if (c5203bh != null) {
                this.f24016i = c5203bh.m31137j();
                this.f24017j = c5203bh.m31138k();
                C5190aw c5190awM31132e = c5203bh.m31132e();
                int iM30921a = c5190awM31132e.m30921a();
                for (int i10 = 0; i10 < iM30921a; i10++) {
                    String strM30922a = c5190awM31132e.m30922a(i10);
                    String strM30925b = c5190awM31132e.m30925b(i10);
                    if ("Date".equalsIgnoreCase(strM30922a)) {
                        this.f24011d = C5236cm.m31406a(strM30925b);
                        this.f24012e = strM30925b;
                    } else if ("Expires".equalsIgnoreCase(strM30922a)) {
                        this.f24015h = C5236cm.m31406a(strM30925b);
                    } else if ("Last-Modified".equalsIgnoreCase(strM30922a)) {
                        this.f24013f = C5236cm.m31406a(strM30925b);
                        this.f24014g = strM30925b;
                    } else if ("ETag".equalsIgnoreCase(strM30922a)) {
                        this.f24018k = strM30925b;
                    } else if ("Age".equalsIgnoreCase(strM30922a)) {
                        this.f24019l = C5237cn.m31414b(strM30925b, -1);
                    }
                }
            }
        }

        /* renamed from: b */
        private C5214bs m31221b() {
            String str;
            if (this.f24010c == null) {
                return new C5214bs(this.f24009b, null);
            }
            if ((!this.f24009b.m31116i() || this.f24010c.m31131d() != null) && C5214bs.m31219a(this.f24010c, this.f24009b)) {
                C5176ai c5176aiM31115h = this.f24009b.m31115h();
                if (c5176aiM31115h.m30823a() || m31220a(this.f24009b)) {
                    return new C5214bs(this.f24009b, null);
                }
                C5176ai c5176aiM31136i = this.f24010c.m31136i();
                long jM31223d = m31223d();
                long jM31222c = m31222c();
                if (c5176aiM31115h.m30825c() != -1) {
                    jM31222c = Math.min(jM31222c, TimeUnit.SECONDS.toMillis(c5176aiM31115h.m30825c()));
                }
                long millis = 0;
                long millis2 = c5176aiM31115h.m30830h() != -1 ? TimeUnit.SECONDS.toMillis(c5176aiM31115h.m30830h()) : 0L;
                if (!c5176aiM31136i.m30828f() && c5176aiM31115h.m30829g() != -1) {
                    millis = TimeUnit.SECONDS.toMillis(c5176aiM31115h.m30829g());
                }
                if (!c5176aiM31136i.m30823a()) {
                    long j10 = millis2 + jM31223d;
                    if (j10 < millis + jM31222c) {
                        C5203bh.a aVarM31134g = this.f24010c.m31134g();
                        if (j10 >= jM31222c) {
                            aVarM31134g.m31155b("Warning", "110 HttpURLConnection \"Response is stale\"");
                        }
                        if (jM31223d > 86400000 && m31224e()) {
                            aVarM31134g.m31155b("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                        }
                        return new C5214bs(null, aVarM31134g.m31151a());
                    }
                }
                String str2 = this.f24018k;
                if (str2 != null) {
                    str = C6069r1.b.f27985n;
                } else {
                    if (this.f24013f != null) {
                        str2 = this.f24014g;
                    } else {
                        if (this.f24011d == null) {
                            return new C5214bs(this.f24009b, null);
                        }
                        str2 = this.f24012e;
                    }
                    str = C6069r1.b.f27986o;
                }
                C5190aw.a aVarM30924b = this.f24009b.m31110c().m30924b();
                AbstractC5207bl.f23983a.mo31077a(aVarM30924b, str, str2);
                return new C5214bs(this.f24009b.m31114g().m31118a(aVarM30924b.m30930a()).m31123a(), this.f24010c);
            }
            return new C5214bs(this.f24009b, null);
        }

        /* renamed from: c */
        private long m31222c() {
            if (this.f24010c.m31136i().m30825c() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.m30825c());
            }
            if (this.f24015h != null) {
                Date date = this.f24011d;
                long time = this.f24015h.getTime() - (date != null ? date.getTime() : this.f24017j);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.f24013f == null || this.f24010c.m31126a().m31107a().m30975k() != null) {
                return 0L;
            }
            Date date2 = this.f24011d;
            long time2 = (date2 != null ? date2.getTime() : this.f24016i) - this.f24013f.getTime();
            if (time2 > 0) {
                return time2 / 10;
            }
            return 0L;
        }

        /* renamed from: d */
        private long m31223d() {
            Date date = this.f24011d;
            long jMax = date != null ? Math.max(0L, this.f24017j - date.getTime()) : 0L;
            int i10 = this.f24019l;
            if (i10 != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(i10));
            }
            long j10 = this.f24017j;
            return jMax + (j10 - this.f24016i) + (this.f24008a - j10);
        }

        /* renamed from: e */
        private boolean m31224e() {
            return this.f24010c.m31136i().m30825c() == -1 && this.f24015h == null;
        }

        /* renamed from: a */
        public C5214bs m31225a() {
            C5214bs c5214bsM31221b = m31221b();
            return (c5214bsM31221b.f24006a == null || !this.f24009b.m31115h().m30831i()) ? c5214bsM31221b : new C5214bs(null, null);
        }

        /* renamed from: a */
        private static boolean m31220a(C5201bf c5201bf) {
            return (c5201bf.m31108a(C6069r1.b.f27986o) == null && c5201bf.m31108a(C6069r1.b.f27985n) == null) ? false : true;
        }
    }
}
