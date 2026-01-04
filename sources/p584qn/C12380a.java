package p584qn;

import com.huawei.android.brotli.dec.C2162b;
import com.huawei.hms.network.embedded.C5966j2;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.IOException;
import okhttp3.C11918e0;
import okhttp3.C11922g0;
import okhttp3.InterfaceC11959z;
import p022ay.C1061k;
import p022ay.C1064n;
import p399jk.AbstractC10896a;
import p616rk.C12515a;
import p693ux.C13283h;
import tn.C13047e;

/* renamed from: qn.a */
/* loaded from: classes6.dex */
public class C12380a implements InterfaceC11959z {
    @Override // okhttp3.InterfaceC11959z
    /* renamed from: a */
    public C11922g0 mo71677a(InterfaceC11959z.a aVar) throws IOException {
        C11918e0 c11918e0Request = aVar.request();
        C11922g0 c11922g0Mo71934c = aVar.mo71934c(c11918e0Request.m71570j().m71575b());
        return c11918e0Request.m71565e(C5966j2.f27080v) == null ? c11922g0Mo71934c : m74443b(c11922g0Mo71934c);
    }

    /* renamed from: b */
    public C11922g0 m74443b(C11922g0 c11922g0) {
        try {
            if (c11922g0.m71595s() == null) {
                AbstractC10896a.m65886e("GzipInterceptor", "uncompress fail, error body.");
                C12515a.m75110o().m75175e(new C13047e(false, "body is null"), false);
                return c11922g0;
            }
            String strM71599w = c11922g0.m71599w("Content-Encoding");
            if (strM71599w == null) {
                AbstractC10896a.m65886e("GzipInterceptor", "uncompress fail, error content encoding.");
                C12515a.m75110o().m75175e(new C13047e(false, "encoding is null"), false);
                return c11922g0;
            }
            String strM71599w2 = c11922g0.m71599w("Content-Type");
            if (strM71599w.equals(Constants.GZIP)) {
                C13283h c13283h = new C13283h(strM71599w2, -1L, C1064n.m6403b(new C1061k(c11922g0.m71595s().mo71636y())));
                C12515a.m75110o().m75175e(new C13047e(true, "gzip success"), false);
                return c11922g0.m71589A().m71619q("Content-Encoding").m71619q("Content-Length").m71604b(c13283h).m71605c();
            }
            if (strM71599w.equals("br")) {
                C13283h c13283h2 = new C13283h(strM71599w2, -1L, C1064n.m6403b(C1064n.m6407f(new C2162b(c11922g0.m71595s().mo71636y().mo6318E0()))));
                C12515a.m75110o().m75175e(new C13047e(true, "br success"), false);
                return c11922g0.m71589A().m71619q("Content-Encoding").m71619q("Content-Length").m71604b(c13283h2).m71605c();
            }
            AbstractC10896a.m65886e("GzipInterceptor", "uncompress fail, error content type.");
            C12515a.m75110o().m75175e(new C13047e(false, "encoding is illegal"), false);
            return c11922g0;
        } catch (Exception e10) {
            AbstractC10896a.m65886e("GzipInterceptor", "uncompress error: " + e10.toString());
            C12515a.m75110o().m75175e(new C13047e(false, "Exception: " + e10.toString()), false);
            return c11922g0;
        }
    }
}
