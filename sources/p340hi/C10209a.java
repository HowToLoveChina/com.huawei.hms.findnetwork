package p340hi;

import com.huawei.cloud.base.http.C4612o;
import com.huawei.cloud.base.http.InterfaceC4608k;
import com.huawei.cloud.base.http.InterfaceC4614q;
import com.huawei.cloud.base.http.InterfaceC4620w;
import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.C4650r;
import com.huawei.cloud.base.util.InterfaceC4640h;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: hi.a */
/* loaded from: classes.dex */
public class C10209a implements InterfaceC4608k, InterfaceC4614q, InterfaceC4620w {

    /* renamed from: g */
    public static final C4650r f49525g = C4650r.m28485f("DriveCredential");

    /* renamed from: a */
    public final Lock f49526a;

    /* renamed from: b */
    public final b f49527b;

    /* renamed from: c */
    public final InterfaceC4640h f49528c;

    /* renamed from: d */
    public String f49529d;

    /* renamed from: e */
    public String f49530e;

    /* renamed from: f */
    public Long f49531f;

    /* renamed from: hi.a$b */
    public interface b {
        /* renamed from: a */
        String mo7274a() throws IOException;
    }

    /* renamed from: hi.a$c */
    public static class c {

        /* renamed from: a */
        public final b f49532a;

        /* renamed from: b */
        public String f49533b;

        public c(String str, b bVar) {
            this.f49533b = (String) C4627a0.m28391d(str);
            this.f49532a = (b) C4627a0.m28391d(bVar);
        }

        /* renamed from: b */
        public C10209a m63363b() {
            return new C10209a(this);
        }
    }

    @Override // com.huawei.cloud.base.http.InterfaceC4614q
    /* renamed from: a */
    public void mo28303a(C4612o c4612o) {
        c4612o.m28261B(this);
        c4612o.m28267H(this);
        c4612o.m28260A(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0047  */
    @Override // com.huawei.cloud.base.http.InterfaceC4620w
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean mo28334b(com.huawei.cloud.base.http.C4612o r4, com.huawei.cloud.base.http.C4615r r5, boolean r6) {
        /*
            r3 = this;
            com.huawei.cloud.base.http.l r6 = r4.m28277i()
            java.util.List r6 = r6.m28233r()
            r0 = 0
            if (r6 == 0) goto L70
            java.util.Iterator r6 = r6.iterator()
        Lf:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L70
            java.lang.Object r1 = r6.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "Bearer "
            boolean r1 = r1.startsWith(r2)
            if (r1 == 0) goto Lf
            int r5 = r5.m28311h()
            r6 = 401(0x191, float:5.62E-43)
            if (r5 != r6) goto L70
            java.util.concurrent.locks.Lock r5 = r3.f49526a     // Catch: java.io.IOException -> L4e
            r5.lock()     // Catch: java.io.IOException -> L4e
            java.lang.String r5 = r3.f49530e     // Catch: java.lang.Throwable -> L45
            java.lang.String r4 = r3.m63356f(r4)     // Catch: java.lang.Throwable -> L45
            boolean r4 = com.huawei.cloud.base.util.C4658z.m28496a(r5, r4)     // Catch: java.lang.Throwable -> L45
            if (r4 == 0) goto L47
            boolean r4 = r3.m63359i()     // Catch: java.lang.Throwable -> L45
            if (r4 == 0) goto L43
            goto L47
        L43:
            r4 = r0
            goto L48
        L45:
            r4 = move-exception
            goto L50
        L47:
            r4 = 1
        L48:
            java.util.concurrent.locks.Lock r3 = r3.f49526a     // Catch: java.io.IOException -> L4e
            r3.unlock()     // Catch: java.io.IOException -> L4e
            return r4
        L4e:
            r3 = move-exception
            goto L56
        L50:
            java.util.concurrent.locks.Lock r3 = r3.f49526a     // Catch: java.io.IOException -> L4e
            r3.unlock()     // Catch: java.io.IOException -> L4e
            throw r4     // Catch: java.io.IOException -> L4e
        L56:
            com.huawei.cloud.base.util.r r4 = p340hi.C10209a.f49525g
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "unable to refresh token: "
            r5.append(r6)
            java.lang.String r3 = r3.getMessage()
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            r4.m28489d(r3)
        L70:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p340hi.C10209a.mo28334b(com.huawei.cloud.base.http.o, com.huawei.cloud.base.http.r, boolean):boolean");
    }

    @Override // com.huawei.cloud.base.http.InterfaceC4608k
    /* renamed from: c */
    public void mo28207c(C4612o c4612o) throws IOException {
        this.f49526a.lock();
        try {
            Long lM63357g = m63357g();
            if (this.f49530e == null || (lM63357g != null && lM63357g.longValue() <= 60)) {
                m63359i();
                if (this.f49530e == null) {
                    this.f49526a.unlock();
                    return;
                }
            }
            c4612o.m28277i().set("unionID", this.f49529d);
            c4612o.m28277i().m28216G("Bearer " + this.f49530e);
            this.f49526a.unlock();
        } catch (Throwable th2) {
            this.f49526a.unlock();
            throw th2;
        }
    }

    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C10209a clone() {
        return new C10209a(this.f49529d, this.f49527b).m63360j(this.f49530e).m63361k(this.f49531f);
    }

    /* renamed from: e */
    public final String m63355e() {
        this.f49526a.lock();
        try {
            return this.f49530e;
        } finally {
            this.f49526a.unlock();
        }
    }

    /* renamed from: f */
    public final String m63356f(C4612o c4612o) {
        List<String> listM28233r = c4612o.m28277i().m28233r();
        if (listM28233r == null) {
            return null;
        }
        for (String str : listM28233r) {
            if (str.startsWith("Bearer ")) {
                return str.substring(7);
            }
        }
        return null;
    }

    /* renamed from: g */
    public final Long m63357g() {
        this.f49526a.lock();
        try {
            Long l10 = this.f49531f;
            if (l10 != null) {
                return Long.valueOf((l10.longValue() - this.f49528c.mo28435a()) / 1000);
            }
            this.f49526a.unlock();
            return null;
        } finally {
            this.f49526a.unlock();
        }
    }

    /* renamed from: h */
    public String m63358h() {
        return this.f49529d;
    }

    /* renamed from: i */
    public boolean m63359i() throws IOException {
        boolean z10;
        this.f49526a.lock();
        try {
            String strMo7274a = this.f49527b.mo7274a();
            if (strMo7274a == null || strMo7274a.isEmpty()) {
                z10 = false;
            } else {
                this.f49530e = strMo7274a;
                z10 = true;
            }
            return z10;
        } finally {
            this.f49526a.unlock();
        }
    }

    /* renamed from: j */
    public C10209a m63360j(String str) {
        this.f49526a.lock();
        try {
            this.f49530e = str;
            return this;
        } finally {
            this.f49526a.unlock();
        }
    }

    /* renamed from: k */
    public final C10209a m63361k(Long l10) {
        this.f49526a.lock();
        try {
            this.f49531f = l10;
            return this;
        } finally {
            this.f49526a.unlock();
        }
    }

    public C10209a(String str, b bVar) {
        this(new c(str, bVar));
    }

    public C10209a(c cVar) {
        this.f49526a = new ReentrantLock();
        this.f49528c = InterfaceC4640h.f21285a;
        this.f49527b = cVar.f49532a;
        this.f49529d = cVar.f49533b;
    }
}
