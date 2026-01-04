package mr;

import android.text.TextUtils;
import as.C1016d;
import es.C9549n;
import nr.C11744a;
import p235ds.C9302c;
import p443l4.AbstractC11229a;
import p531or.C11991a;

/* renamed from: mr.a */
/* loaded from: classes8.dex */
public class C11506a {

    /* renamed from: d */
    public static final byte[] f53411d = new byte[0];

    /* renamed from: e */
    public static volatile C11506a f53412e;

    /* renamed from: a */
    public final C9549n f53413a = new C9549n("AGCInfo");

    /* renamed from: b */
    public volatile C11507b f53414b;

    /* renamed from: c */
    public C11744a f53415c;

    /* renamed from: e */
    public static C11506a m68682e() {
        if (f53412e == null) {
            synchronized (f53411d) {
                try {
                    if (f53412e == null) {
                        f53412e = new C11506a();
                    }
                } finally {
                }
            }
        }
        return f53412e;
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x011e A[ORIG_RETURN, RETURN] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final mr.C11507b m68683a() {
        /*
            Method dump skipped, instructions count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: mr.C11506a.m68683a():mr.b");
    }

    /* renamed from: b */
    public synchronized boolean m68684b() {
        return m68682e().m68685c() != null;
    }

    /* renamed from: c */
    public synchronized C11507b m68685c() {
        if (this.f53414b != null && System.currentTimeMillis() <= this.f53414b.m68690b()) {
            C1016d.m6186f("AGCManager", "use cache agcInfo");
            return this.f53414b;
        }
        this.f53414b = m68683a();
        if (this.f53414b != null) {
            C1016d.m6186f("AGCManager", "use agcInfo from online");
            return this.f53414b;
        }
        long jM59623a = this.f53413a.m59623a("ExpireTime");
        String strM59624b = this.f53413a.m59624b("Token");
        if (System.currentTimeMillis() > jM59623a || TextUtils.isEmpty(strM59624b)) {
            return null;
        }
        C1016d.m6186f("AGCManager", "use agcInfo from sp");
        C9302c c9302c = new C9302c(3);
        this.f53414b = new C11507b();
        this.f53414b.m68692d(c9302c.mo38472a(strM59624b, "AGC_INFO"));
        this.f53414b.m68691c(jM59623a);
        return this.f53414b;
    }

    /* renamed from: d */
    public String m68686d() {
        try {
            AbstractC11229a abstractC11229aM67436d = AbstractC11229a.m67436d(C11991a.m72145a());
            return TextUtils.isEmpty(abstractC11229aM67436d.mo66356b("client/app_id")) ? "" : abstractC11229aM67436d.mo66356b("client/app_id");
        } catch (Exception unused) {
            C1016d.m6183c("AGCManager", "get agc appId by exception");
            return "";
        }
    }

    /* renamed from: f */
    public synchronized void m68687f() {
        this.f53414b = null;
    }

    /* renamed from: g */
    public synchronized void m68688g(C11507b c11507b) {
        this.f53414b = c11507b;
        this.f53413a.m59627e("Token", new C9302c(3).mo38473b(c11507b.m68689a(), "AGC_INFO"));
        this.f53413a.m59626d("ExpireTime", c11507b.m68690b());
    }
}
