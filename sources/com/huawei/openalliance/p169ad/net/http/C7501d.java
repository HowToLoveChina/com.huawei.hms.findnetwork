package com.huawei.openalliance.p169ad.net.http;

import com.huawei.hms.network.embedded.C5928g3;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.beans.inner.HttpConnection;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.C7765bl;
import java.util.WeakHashMap;
import okhttp3.AbstractC11953t;
import okhttp3.C11912b0;
import okhttp3.HttpRequestBuilder;
import okhttp3.InterfaceC11919f;
import okhttp3.InterfaceC11944k;

/* renamed from: com.huawei.openalliance.ad.net.http.d */
/* loaded from: classes2.dex */
public class C7501d extends AbstractC11953t implements InterfaceC7506i {

    /* renamed from: a */
    private WeakHashMap<HttpRequestBuilder, HttpConnection> f34828a;

    @Override // com.huawei.openalliance.p169ad.net.http.InterfaceC7506i
    /* renamed from: a */
    public HttpConnection mo46052a(HttpRequestBuilder HttpRequestBuilder) {
        HttpConnection httpConnection = (C7765bl.m47802a(this.f34828a) || HttpRequestBuilder == null || !this.f34828a.containsKey(HttpRequestBuilder)) ? null : this.f34828a.get(HttpRequestBuilder);
        return httpConnection == null ? new HttpConnection() : httpConnection;
    }

    @Override // okhttp3.AbstractC11953t
    public void connectionAcquired(InterfaceC11919f interfaceC11919f, InterfaceC11944k interfaceC11944k) {
        super.connectionAcquired(interfaceC11919f, interfaceC11944k);
        if (interfaceC11944k == null) {
            return;
        }
        HttpConnection httpConnection = new HttpConnection(interfaceC11944k);
        AbstractC7185ho.m43820b(C5928g3.f26831h, "address:" + AbstractC7806cz.m48174f(httpConnection.m39402a()));
        HttpRequestBuilder HttpRequestBuilderRequest = interfaceC11919f.request();
        if (HttpRequestBuilderRequest == null) {
            return;
        }
        if (this.f34828a == null) {
            this.f34828a = new WeakHashMap<>();
        }
        AbstractC7185ho.m43821b(C5928g3.f26831h, "size: %s", Integer.valueOf(this.f34828a.size()));
        this.f34828a.put(HttpRequestBuilderRequest, httpConnection);
    }

    @Override // com.huawei.openalliance.p169ad.net.http.InterfaceC7506i
    /* renamed from: a */
    public C11912b0.c mo46053a(C11912b0.c cVar) {
        if (cVar == null) {
            return null;
        }
        return cVar.m71512i(this);
    }
}
