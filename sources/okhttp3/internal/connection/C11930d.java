package okhttp3.internal.connection;

import java.io.IOException;
import okhttp3.C11912b0;
import okhttp3.HttpRequestBuilder;
import okhttp3.HttpResponseBuilder;
import okhttp3.InterfaceC11959z;
import p693ux.C13282g;

/* renamed from: okhttp3.internal.connection.d */
/* loaded from: classes9.dex */
public final class C11930d implements InterfaceC11959z {

    /* renamed from: a */
    public final C11912b0 f55374a;

    public C11930d(C11912b0 c11912b0) {
        this.f55374a = c11912b0;
    }

    @Override // okhttp3.InterfaceC11959z
    /* renamed from: a */
    public HttpResponseBuilder mo71677a(InterfaceC11959z.a aVar) throws IOException {
        C13282g c13282g = (C13282g) aVar;
        HttpRequestBuilder HttpRequestBuilderRequest = c13282g.request();
        C11941o c11941oM79726g = c13282g.m79726g();
        return c13282g.m79725f(HttpRequestBuilderRequest, c11941oM79726g, c11941oM79726g.newExchange(aVar, !HttpRequestBuilderRequest.m71569i().equals("GET")));
    }
}
