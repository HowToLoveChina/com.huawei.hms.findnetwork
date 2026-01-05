package p584qn;

import com.huawei.android.brotli.dec.C2162b;
import com.huawei.hms.network.embedded.C5966j2;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.IOException;
import okhttp3.HttpRequestBuilder;
import okhttp3.HttpResponseBuilder;
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
    public HttpResponseBuilder mo71677a(InterfaceC11959z.a aVar) throws IOException {
        HttpRequestBuilder HttpRequestBuilderRequest = aVar.request();
        HttpResponseBuilder HttpResponseBuilderMo71934c = aVar.mo71934c(HttpRequestBuilderRequest.m71570j().m71575b());
        return HttpRequestBuilderRequest.m71565e(C5966j2.f27080v) == null ? HttpResponseBuilderMo71934c : m74443b(HttpResponseBuilderMo71934c);
    }

    /* renamed from: b */
    public HttpResponseBuilder m74443b(HttpResponseBuilder HttpResponseBuilder) {
        try {
            if (HttpResponseBuilder.m71595s() == null) {
                AbstractC10896a.m65886e("GzipInterceptor", "uncompress fail, error body.");
                C12515a.m75110o().m75175e(new C13047e(false, "body is null"), false);
                return HttpResponseBuilder;
            }
            String strM71599w = HttpResponseBuilder.m71599w("Content-Encoding");
            if (strM71599w == null) {
                AbstractC10896a.m65886e("GzipInterceptor", "uncompress fail, error content encoding.");
                C12515a.m75110o().m75175e(new C13047e(false, "encoding is null"), false);
                return HttpResponseBuilder;
            }
            String strM71599w2 = HttpResponseBuilder.m71599w("Content-Type");
            if (strM71599w.equals(Constants.GZIP)) {
                C13283h c13283h = new C13283h(strM71599w2, -1L, C1064n.m6403b(new C1061k(HttpResponseBuilder.m71595s().mo71636y())));
                C12515a.m75110o().m75175e(new C13047e(true, "gzip success"), false);
                return HttpResponseBuilder.m71589A().m71619q("Content-Encoding").m71619q("Content-Length").m71604b(c13283h).m71605c();
            }
            if (strM71599w.equals("br")) {
                C13283h c13283h2 = new C13283h(strM71599w2, -1L, C1064n.m6403b(C1064n.m6407f(new C2162b(HttpResponseBuilder.m71595s().mo71636y().mo6318E0()))));
                C12515a.m75110o().m75175e(new C13047e(true, "br success"), false);
                return HttpResponseBuilder.m71589A().m71619q("Content-Encoding").m71619q("Content-Length").m71604b(c13283h2).m71605c();
            }
            AbstractC10896a.m65886e("GzipInterceptor", "uncompress fail, error content type.");
            C12515a.m75110o().m75175e(new C13047e(false, "encoding is illegal"), false);
            return HttpResponseBuilder;
        } catch (Exception e10) {
            AbstractC10896a.m65886e("GzipInterceptor", "uncompress error: " + e10.toString());
            C12515a.m75110o().m75175e(new C13047e(false, "Exception: " + e10.toString()), false);
            return HttpResponseBuilder;
        }
    }
}
