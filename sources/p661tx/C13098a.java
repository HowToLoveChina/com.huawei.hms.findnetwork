package p661tx;

import java.io.IOException;
import okhttp3.C11918e0;
import okhttp3.C11922g0;
import okhttp3.C11955v;
import okhttp3.EnumC11914c0;
import okhttp3.InterfaceC11959z;
import p661tx.C13099b;
import sx.AbstractC12871a;
import sx.C12875e;

/* renamed from: tx.a */
/* loaded from: classes9.dex */
public final class C13098a implements InterfaceC11959z {
    public C13098a(InterfaceC13100c interfaceC13100c) {
    }

    /* renamed from: b */
    public static C11955v m78851b(C11955v c11955v, C11955v c11955v2) {
        C11955v.a aVar = new C11955v.a();
        int iM71857j = c11955v.m71857j();
        for (int i10 = 0; i10 < iM71857j; i10++) {
            String strM71854e = c11955v.m71854e(i10);
            String strM71859l = c11955v.m71859l(i10);
            if ((!"Warning".equalsIgnoreCase(strM71854e) || !strM71859l.startsWith("1")) && (m78852c(strM71854e) || !m78853d(strM71854e) || c11955v2.m71853c(strM71854e) == null)) {
                AbstractC12871a.f58633a.mo71497b(aVar, strM71854e, strM71859l);
            }
        }
        int iM71857j2 = c11955v2.m71857j();
        for (int i11 = 0; i11 < iM71857j2; i11++) {
            String strM71854e2 = c11955v2.m71854e(i11);
            if (!m78852c(strM71854e2) && m78853d(strM71854e2)) {
                AbstractC12871a.f58633a.mo71497b(aVar, strM71854e2, c11955v2.m71859l(i11));
            }
        }
        return aVar.m71864d();
    }

    /* renamed from: c */
    public static boolean m78852c(String str) {
        return "Content-Length".equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
    }

    /* renamed from: d */
    public static boolean m78853d(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    /* renamed from: e */
    public static C11922g0 m78854e(C11922g0 c11922g0) {
        return (c11922g0 == null || c11922g0.m71595s() == null) ? c11922g0 : c11922g0.m71589A().m71604b(null).m71605c();
    }

    @Override // okhttp3.InterfaceC11959z
    /* renamed from: a */
    public C11922g0 mo71677a(InterfaceC11959z.a aVar) throws IOException {
        C13099b c13099bM78859c = new C13099b.a(System.currentTimeMillis(), aVar.request(), null).m78859c();
        C11918e0 c11918e0 = c13099bM78859c.f59489a;
        C11922g0 c11922g0 = c13099bM78859c.f59490b;
        if (c11918e0 == null && c11922g0 == null) {
            return new C11922g0.a().m71620r(aVar.request()).m71617o(EnumC11914c0.HTTP_1_1).m71609g(504).m71614l("Unsatisfiable Request (only-if-cached)").m71604b(C12875e.f58643d).m71621s(-1L).m71618p(System.currentTimeMillis()).m71605c();
        }
        if (c11918e0 == null) {
            return c11922g0.m71589A().m71606d(m78854e(c11922g0)).m71605c();
        }
        C11922g0 c11922g0Mo71934c = aVar.mo71934c(c11918e0);
        if (c11922g0 != null) {
            if (c11922g0Mo71934c.m71597u() == 304) {
                c11922g0.m71589A().m71612j(m78851b(c11922g0.m71601y(), c11922g0Mo71934c.m71601y())).m71621s(c11922g0Mo71934c.m71594F()).m71618p(c11922g0Mo71934c.m71592D()).m71606d(m78854e(c11922g0)).m71615m(m78854e(c11922g0Mo71934c)).m71605c();
                c11922g0Mo71934c.m71595s().close();
                throw null;
            }
            C12875e.m77250g(c11922g0.m71595s());
        }
        return c11922g0Mo71934c.m71589A().m71606d(m78854e(c11922g0)).m71615m(m78854e(c11922g0Mo71934c)).m71605c();
    }
}
