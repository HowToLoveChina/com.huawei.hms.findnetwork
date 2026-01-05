package p693ux;

import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.HttpRequestBuilder;
import okhttp3.HttpResponseBuilder;
import okhttp3.InterfaceC11959z;
import okhttp3.internal.connection.C11932f;
import p022ay.C1064n;
import p022ay.InterfaceC1055e;
import sx.C12875e;

/* renamed from: ux.b */
/* loaded from: classes9.dex */
public final class C13277b implements InterfaceC11959z {

    /* renamed from: a */
    public final boolean f59982a;

    public C13277b(boolean z10) {
        this.f59982a = z10;
    }

    @Override // okhttp3.InterfaceC11959z
    /* renamed from: a */
    public HttpResponseBuilder mo71677a(InterfaceC11959z.a aVar) throws IOException {
        boolean z10;
        C13282g c13282g = (C13282g) aVar;
        C11932f c11932fM79724e = c13282g.m79724e();
        HttpRequestBuilder HttpRequestBuilderRequest = c13282g.request();
        long jCurrentTimeMillis = System.currentTimeMillis();
        c11932fM79724e.m71696p(HttpRequestBuilderRequest);
        HttpResponseBuilder.a aVarM71692l = null;
        if (!C13281f.m79720a(HttpRequestBuilderRequest.m71569i()) || HttpRequestBuilderRequest.m71562b() == null) {
            c11932fM79724e.m71690j();
            z10 = false;
        } else {
            if ("100-continue".equalsIgnoreCase(HttpRequestBuilderRequest.m71565e("Expect"))) {
                c11932fM79724e.m71687g();
                c11932fM79724e.m71694n();
                aVarM71692l = c11932fM79724e.m71692l(true);
                z10 = true;
            } else {
                z10 = false;
            }
            if (aVarM71692l != null) {
                c11932fM79724e.m71690j();
                if (!c11932fM79724e.m71683c().m71724p()) {
                    c11932fM79724e.m71689i();
                }
            } else if (HttpRequestBuilderRequest.m71562b().isDuplex()) {
                c11932fM79724e.m71687g();
                HttpRequestBuilderRequest.m71562b().writeTo(C1064n.m6402a(c11932fM79724e.m71684d(HttpRequestBuilderRequest, true)));
            } else {
                InterfaceC1055e interfaceC1055eM6402a = C1064n.m6402a(c11932fM79724e.m71684d(HttpRequestBuilderRequest, false));
                HttpRequestBuilderRequest.m71562b().writeTo(interfaceC1055eM6402a);
                interfaceC1055eM6402a.close();
            }
        }
        if (HttpRequestBuilderRequest.m71562b() == null || !HttpRequestBuilderRequest.m71562b().isDuplex()) {
            c11932fM79724e.m71686f();
        }
        if (!z10) {
            c11932fM79724e.m71694n();
        }
        if (aVarM71692l == null) {
            aVarM71692l = c11932fM79724e.m71692l(false);
        }
        HttpResponseBuilder HttpResponseBuilderM71605c = aVarM71692l.m71620r(HttpRequestBuilderRequest).m71610h(c11932fM79724e.m71683c().m71721m()).m71621s(jCurrentTimeMillis).m71618p(System.currentTimeMillis()).m71605c();
        int iM71597u = HttpResponseBuilderM71605c.m71597u();
        if (iM71597u == 100) {
            HttpResponseBuilderM71605c = c11932fM79724e.m71692l(false).m71620r(HttpRequestBuilderRequest).m71610h(c11932fM79724e.m71683c().m71721m()).m71621s(jCurrentTimeMillis).m71618p(System.currentTimeMillis()).m71605c();
            iM71597u = HttpResponseBuilderM71605c.m71597u();
        }
        c11932fM79724e.m71693m(HttpResponseBuilderM71605c);
        HttpResponseBuilder HttpResponseBuilderM71605c2 = (this.f59982a && iM71597u == 101) ? HttpResponseBuilderM71605c.m71589A().m71604b(C12875e.f58643d).m71605c() : HttpResponseBuilderM71605c.m71589A().m71604b(c11932fM79724e.m71691k(HttpResponseBuilderM71605c)).m71605c();
        if ("close".equalsIgnoreCase(HttpResponseBuilderM71605c2.m71593E().m71565e("Connection")) || "close".equalsIgnoreCase(HttpResponseBuilderM71605c2.m71599w("Connection"))) {
            c11932fM79724e.m71689i();
        }
        if ((iM71597u != 204 && iM71597u != 205) || HttpResponseBuilderM71605c2.m71595s().mo71634u() <= 0) {
            return HttpResponseBuilderM71605c2;
        }
        throw new ProtocolException("HTTP " + iM71597u + " had non-zero Content-Length: " + HttpResponseBuilderM71605c2.m71595s().mo71634u());
    }
}
