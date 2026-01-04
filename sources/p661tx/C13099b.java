package p661tx;

import com.huawei.hms.network.embedded.C6069r1;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import okhttp3.C11917e;
import okhttp3.C11918e0;
import okhttp3.C11922g0;
import okhttp3.C11955v;
import p693ux.C13279d;
import p693ux.C13280e;
import sx.AbstractC12871a;

/* renamed from: tx.b */
/* loaded from: classes9.dex */
public final class C13099b {

    /* renamed from: a */
    public final C11918e0 f59489a;

    /* renamed from: b */
    public final C11922g0 f59490b;

    /* renamed from: tx.b$a */
    public static class a {

        /* renamed from: a */
        public final long f59491a;

        /* renamed from: b */
        public final C11918e0 f59492b;

        /* renamed from: c */
        public final C11922g0 f59493c;

        /* renamed from: d */
        public Date f59494d;

        /* renamed from: e */
        public String f59495e;

        /* renamed from: f */
        public Date f59496f;

        /* renamed from: g */
        public String f59497g;

        /* renamed from: h */
        public Date f59498h;

        /* renamed from: i */
        public long f59499i;

        /* renamed from: j */
        public long f59500j;

        /* renamed from: k */
        public String f59501k;

        /* renamed from: l */
        public int f59502l;

        public a(long j10, C11918e0 c11918e0, C11922g0 c11922g0) {
            this.f59502l = -1;
            this.f59491a = j10;
            this.f59492b = c11918e0;
            this.f59493c = c11922g0;
            if (c11922g0 != null) {
                this.f59499i = c11922g0.m71594F();
                this.f59500j = c11922g0.m71592D();
                C11955v c11955vM71601y = c11922g0.m71601y();
                int iM71857j = c11955vM71601y.m71857j();
                for (int i10 = 0; i10 < iM71857j; i10++) {
                    String strM71854e = c11955vM71601y.m71854e(i10);
                    String strM71859l = c11955vM71601y.m71859l(i10);
                    if ("Date".equalsIgnoreCase(strM71854e)) {
                        this.f59494d = C13279d.m79710b(strM71859l);
                        this.f59495e = strM71859l;
                    } else if ("Expires".equalsIgnoreCase(strM71854e)) {
                        this.f59498h = C13279d.m79710b(strM71859l);
                    } else if ("Last-Modified".equalsIgnoreCase(strM71854e)) {
                        this.f59496f = C13279d.m79710b(strM71859l);
                        this.f59497g = strM71859l;
                    } else if ("ETag".equalsIgnoreCase(strM71854e)) {
                        this.f59501k = strM71859l;
                    } else if ("Age".equalsIgnoreCase(strM71854e)) {
                        this.f59502l = C13280e.m79715d(strM71859l, -1);
                    }
                }
            }
        }

        /* renamed from: e */
        public static boolean m78856e(C11918e0 c11918e0) {
            return (c11918e0.m71565e(C6069r1.b.f27986o) == null && c11918e0.m71565e(C6069r1.b.f27985n) == null) ? false : true;
        }

        /* renamed from: a */
        public final long m78857a() {
            Date date = this.f59494d;
            long jMax = date != null ? Math.max(0L, this.f59500j - date.getTime()) : 0L;
            int i10 = this.f59502l;
            if (i10 != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(i10));
            }
            long j10 = this.f59500j;
            return jMax + (j10 - this.f59499i) + (this.f59491a - j10);
        }

        /* renamed from: b */
        public final long m78858b() {
            if (this.f59493c.m71596t().m71550d() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.m71550d());
            }
            if (this.f59498h != null) {
                Date date = this.f59494d;
                long time = this.f59498h.getTime() - (date != null ? date.getTime() : this.f59500j);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.f59496f == null || this.f59493c.m71593E().m71573m().m71910x() != null) {
                return 0L;
            }
            Date date2 = this.f59494d;
            long time2 = (date2 != null ? date2.getTime() : this.f59499i) - this.f59496f.getTime();
            if (time2 > 0) {
                return time2 / 10;
            }
            return 0L;
        }

        /* renamed from: c */
        public C13099b m78859c() {
            C13099b c13099bM78860d = m78860d();
            return (c13099bM78860d.f59489a == null || !this.f59492b.m71563c().m71556j()) ? c13099bM78860d : new C13099b(null, null);
        }

        /* renamed from: d */
        public final C13099b m78860d() {
            String str;
            if (this.f59493c == null) {
                return new C13099b(this.f59492b, null);
            }
            if ((!this.f59492b.m71568h() || this.f59493c.m71598v() != null) && C13099b.m78855a(this.f59493c, this.f59492b)) {
                C11917e c11917eM71563c = this.f59492b.m71563c();
                if (c11917eM71563c.m71554h() || m78856e(this.f59492b)) {
                    return new C13099b(this.f59492b, null);
                }
                C11917e c11917eM71596t = this.f59493c.m71596t();
                long jM78857a = m78857a();
                long jM78858b = m78858b();
                if (c11917eM71563c.m71550d() != -1) {
                    jM78858b = Math.min(jM78858b, TimeUnit.SECONDS.toMillis(c11917eM71563c.m71550d()));
                }
                long millis = 0;
                long millis2 = c11917eM71563c.m71552f() != -1 ? TimeUnit.SECONDS.toMillis(c11917eM71563c.m71552f()) : 0L;
                if (!c11917eM71596t.m71553g() && c11917eM71563c.m71551e() != -1) {
                    millis = TimeUnit.SECONDS.toMillis(c11917eM71563c.m71551e());
                }
                if (!c11917eM71596t.m71554h()) {
                    long j10 = millis2 + jM78857a;
                    if (j10 < millis + jM78858b) {
                        C11922g0.a aVarM71589A = this.f59493c.m71589A();
                        if (j10 >= jM78858b) {
                            aVarM71589A.m71603a("Warning", "110 HttpURLConnection \"Response is stale\"");
                        }
                        if (jM78857a > 86400000 && m78861f()) {
                            aVarM71589A.m71603a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                        }
                        return new C13099b(null, aVarM71589A.m71605c());
                    }
                }
                String str2 = this.f59501k;
                if (str2 != null) {
                    str = C6069r1.b.f27985n;
                } else {
                    if (this.f59496f != null) {
                        str2 = this.f59497g;
                    } else {
                        if (this.f59494d == null) {
                            return new C13099b(this.f59492b, null);
                        }
                        str2 = this.f59495e;
                    }
                    str = C6069r1.b.f27986o;
                }
                C11955v.a aVarM71856g = this.f59492b.m71566f().m71856g();
                AbstractC12871a.f58633a.mo71497b(aVarM71856g, str, str2);
                return new C13099b(this.f59492b.m71570j().m71579f(aVarM71856g.m71864d()).m71575b(), this.f59493c);
            }
            return new C13099b(this.f59492b, null);
        }

        /* renamed from: f */
        public final boolean m78861f() {
            return this.f59493c.m71596t().m71550d() == -1 && this.f59498h == null;
        }
    }

    public C13099b(C11918e0 c11918e0, C11922g0 c11922g0) {
        this.f59489a = c11918e0;
        this.f59490b = c11922g0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (r3.m71596t().m71548b() == false) goto L33;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m78855a(okhttp3.C11922g0 r3, okhttp3.C11918e0 r4) {
        /*
            int r0 = r3.m71597u()
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
            java.lang.String r0 = r3.m71599w(r0)
            if (r0 != 0) goto L5a
            okhttp3.e r0 = r3.m71596t()
            int r0 = r0.m71550d()
            r1 = -1
            if (r0 != r1) goto L5a
            okhttp3.e r0 = r3.m71596t()
            boolean r0 = r0.m71549c()
            if (r0 != 0) goto L5a
            okhttp3.e r0 = r3.m71596t()
            boolean r0 = r0.m71548b()
            if (r0 == 0) goto L59
            goto L5a
        L59:
            return r2
        L5a:
            okhttp3.e r3 = r3.m71596t()
            boolean r3 = r3.m71555i()
            if (r3 != 0) goto L6f
            okhttp3.e r3 = r4.m71563c()
            boolean r3 = r3.m71555i()
            if (r3 != 0) goto L6f
            r2 = 1
        L6f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p661tx.C13099b.m78855a(okhttp3.g0, okhttp3.e0):boolean");
    }
}
