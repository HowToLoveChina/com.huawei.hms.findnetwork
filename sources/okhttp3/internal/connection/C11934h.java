package okhttp3.internal.connection;

import java.io.IOException;
import okhttp3.C11912b0;
import okhttp3.HttpRequestBuilder;
import okhttp3.HttpResponseBuilder;
import okhttp3.EnumC11914c0;
import okhttp3.InterfaceC11959z;
import p693ux.C13282g;
import p693ux.C13283h;

/* renamed from: okhttp3.internal.connection.h */
/* loaded from: classes9.dex */
public final class C11934h implements InterfaceC11959z {

    /* renamed from: a */
    public final C11912b0 f55407a;

    public C11934h(C11912b0 c11912b0) {
        this.f55407a = c11912b0;
    }

    @Override // okhttp3.InterfaceC11959z
    /* renamed from: a */
    public HttpResponseBuilder mo71677a(InterfaceC11959z.a aVar) throws IOException {
        C13282g c13282g = (C13282g) aVar;
        HttpRequestBuilder HttpRequestBuilderRequest = c13282g.request();
        c13282g.m79726g().prepareToConnect(HttpRequestBuilderRequest);
        c13282g.m79726g().getExchangeFinder().m71706h(this.f55407a, HttpRequestBuilderRequest);
        return new HttpResponseBuilder.a().m71617o(EnumC11914c0.HTTP_2).m71614l("").m71604b(new C13283h("", 1L, null)).m71609g(200).m71620r(HttpRequestBuilderRequest).m71605c();
    }
}
