package p693ux;

import com.huawei.hms.network.embedded.C5966j2;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import java.io.IOException;
import java.util.List;
import okhttp3.AbstractC11920f0;
import okhttp3.MimeClass;
import okhttp3.HttpRequestBuilder;
import okhttp3.HttpResponseBuilder;
import okhttp3.C11947n;
import okhttp3.InterfaceC11948o;
import okhttp3.InterfaceC11959z;
import p022ay.C1061k;
import p022ay.C1064n;
import sx.C12875e;
import sx.C12876f;

/* renamed from: ux.a */
/* loaded from: classes9.dex */
public final class C13276a implements InterfaceC11959z {

    /* renamed from: a */
    public final InterfaceC11948o f59981a;

    public C13276a(InterfaceC11948o interfaceC11948o) {
        this.f59981a = interfaceC11948o;
    }

    @Override // okhttp3.InterfaceC11959z
    /* renamed from: a */
    public HttpResponseBuilder mo71677a(InterfaceC11959z.a aVar) throws IOException {
        HttpRequestBuilder HttpRequestBuilderRequest = aVar.request();
        HttpRequestBuilder.a aVarM71570j = HttpRequestBuilderRequest.m71570j();
        AbstractC11920f0 abstractC11920f0M71562b = HttpRequestBuilderRequest.m71562b();
        if (abstractC11920f0M71562b != null) {
            MimeClass MimeClassContentType = abstractC11920f0M71562b.contentType();
            if (MimeClassContentType != null) {
                aVarM71570j.m71578e("Content-Type", MimeClassContentType.toString());
            }
            long jContentLength = abstractC11920f0M71562b.contentLength();
            if (jContentLength != -1) {
                aVarM71570j.m71578e("Content-Length", Long.toString(jContentLength));
                aVarM71570j.m71583j("Transfer-Encoding");
            } else {
                aVarM71570j.m71578e("Transfer-Encoding", "chunked");
                aVarM71570j.m71583j("Content-Length");
            }
        }
        boolean z10 = false;
        if (HttpRequestBuilderRequest.m71565e(FeedbackWebConstants.HOST) == null) {
            aVarM71570j.m71578e(FeedbackWebConstants.HOST, C12875e.m77262s(HttpRequestBuilderRequest.m71573m(), false));
        }
        if (HttpRequestBuilderRequest.m71565e("Connection") == null) {
            aVarM71570j.m71578e("Connection", "Keep-Alive");
        }
        if (HttpRequestBuilderRequest.m71565e(C5966j2.f27080v) == null && HttpRequestBuilderRequest.m71565e("Range") == null) {
            aVarM71570j.m71578e(C5966j2.f27080v, Constants.GZIP);
            z10 = true;
        }
        List<C11947n> listMo71823b = this.f59981a.mo71823b(HttpRequestBuilderRequest.m71573m());
        if (!listMo71823b.isEmpty()) {
            aVarM71570j.m71578e("Cookie", m79700b(listMo71823b));
        }
        if (HttpRequestBuilderRequest.m71565e("User-Agent") == null) {
            aVarM71570j.m71578e("User-Agent", C12876f.m77270a());
        }
        HttpResponseBuilder HttpResponseBuilderMo71934c = aVar.mo71934c(aVarM71570j.m71575b());
        C13280e.m79716e(this.f59981a, HttpRequestBuilderRequest.m71573m(), HttpResponseBuilderMo71934c.m71601y());
        HttpResponseBuilder.a aVarM71620r = HttpResponseBuilderMo71934c.m71589A().m71620r(HttpRequestBuilderRequest);
        if (z10 && Constants.GZIP.equalsIgnoreCase(HttpResponseBuilderMo71934c.m71599w("Content-Encoding")) && C13280e.m79714c(HttpResponseBuilderMo71934c)) {
            C1061k c1061k = new C1061k(HttpResponseBuilderMo71934c.m71595s().mo71636y());
            aVarM71620r.m71612j(HttpResponseBuilderMo71934c.m71601y().m71856g().m71865e("Content-Encoding").m71865e("Content-Length").m71864d());
            aVarM71620r.m71604b(new C13283h(HttpResponseBuilderMo71934c.m71599w("Content-Type"), -1L, C1064n.m6403b(c1061k)));
        }
        return aVarM71620r.m71605c();
    }

    /* renamed from: b */
    public final String m79700b(List<C11947n> list) {
        StringBuilder sb2 = new StringBuilder();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (i10 > 0) {
                sb2.append("; ");
            }
            C11947n c11947n = list.get(i10);
            sb2.append(c11947n.m71819c());
            sb2.append('=');
            sb2.append(c11947n.m71821k());
        }
        return sb2.toString();
    }
}
