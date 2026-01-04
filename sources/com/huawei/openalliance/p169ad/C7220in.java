package com.huawei.openalliance.p169ad;

import android.text.TextUtils;
import com.huawei.hms.network.base.common.RequestBodyProviders;
import com.huawei.hms.network.httpclient.Callback;
import com.huawei.hms.network.httpclient.HttpClient;
import com.huawei.hms.network.httpclient.Request;
import com.huawei.hms.network.httpclient.Response;
import com.huawei.hms.network.httpclient.ResponseBody;
import com.huawei.hms.network.httpclient.Submit;
import com.huawei.openalliance.p169ad.InterfaceC7320iu;

/* renamed from: com.huawei.openalliance.ad.in */
/* loaded from: classes8.dex */
public class C7220in implements InterfaceC7320iu {

    /* renamed from: a */
    private HttpClient f33217a;

    public C7220in(int i10, int i11, int i12) {
        HttpClient.Builder timeout = new HttpClient.Builder().callTimeout(i10).connectTimeout(i11).readTimeout(i12);
        if (C7210id.m43917a() != null && C7210id.m43918b() != null) {
            timeout.sslSocketFactory(C7210id.m43917a(), C7210id.m43918b());
        }
        this.f33217a = timeout.build();
    }

    /* renamed from: a */
    private Request m43949a(C7321iv c7321iv, String str) {
        C7319it c7319itM45102b = c7321iv.m45102b();
        Request.Builder builderNewRequest = this.f33217a.newRequest();
        builderNewRequest.url(c7321iv.m45101a()).method(str);
        if (c7319itM45102b != null) {
            for (String str2 : c7319itM45102b.m45098a()) {
                String strM45099a = c7319itM45102b.m45099a(str2);
                if (!TextUtils.isEmpty(strM45099a)) {
                    builderNewRequest.addHeader(str2, strM45099a);
                }
            }
        }
        if ("POST".equalsIgnoreCase(str)) {
            builderNewRequest.requestBody(RequestBodyProviders.create(c7321iv.m45103c()));
        }
        return builderNewRequest.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public C7322iw m43950a(Response response) {
        C7319it c7319it = new C7319it();
        if (response.getHeaders() != null) {
            for (String str : response.getHeaders().keySet()) {
                c7319it.m45100a(str, response.getHeaders().get(str).toString());
            }
        }
        return new C7322iw(c7319it, response.getCode(), new C7318is(response.getBody() == null ? null : ((ResponseBody) response.getBody()).getInputStream()), response.getMessage());
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7320iu
    /* renamed from: a */
    public void mo43952a(C7321iv c7321iv, final InterfaceC7320iu.a aVar) {
        this.f33217a.newSubmit(m43949a(c7321iv, "GET")).enqueue(new Callback() { // from class: com.huawei.openalliance.ad.in.1
            @Override // com.huawei.hms.network.httpclient.Callback
            public void onFailure(Submit submit, Throwable th2) {
                AbstractC7185ho.m43827d("NetworkKitHttpClient", "onFailure: %s", th2.getClass().getSimpleName());
                InterfaceC7320iu.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.mo45056a(th2);
                }
            }

            @Override // com.huawei.hms.network.httpclient.Callback
            public void onResponse(Submit submit, Response response) {
                InterfaceC7320iu.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.mo45055a(C7220in.this.m43950a(response));
                }
            }
        });
    }
}
