package com.huawei.wisesecurity.ucs_credential;

import android.content.Context;
import aw.C1029b;
import com.huawei.hms.network.NetworkKit;
import com.huawei.hms.network.httpclient.HttpClient;
import com.huawei.hms.network.httpclient.Response;
import com.huawei.hms.network.restclient.RestClient;
import com.huawei.secure.android.common.ssl.SecureX509TrustManager;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkCapability;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkRequest;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import mv.C11532e;
import p239dw.C9320b;
import p239dw.C9344n;
import p239dw.C9346o;
import p239dw.InterfaceC9350r;
import p373iu.C10618f;
import p857zv.C14389c;

/* renamed from: com.huawei.wisesecurity.ucs_credential.i0 */
/* loaded from: classes9.dex */
public class C8916i0 implements NetworkCapability {

    /* renamed from: a */
    public InterfaceC9350r f45395a;

    /* renamed from: b */
    public Context f45396b;

    public C8916i0(Context context) {
        this.f45396b = context;
    }

    /* renamed from: a */
    public final String m56623a(Response<String> response) {
        if (response.isSuccessful()) {
            return response.getBody();
        }
        try {
            return new String(response.getErrorBody().bytes(), StandardCharsets.UTF_8);
        } catch (IOException e10) {
            StringBuilder sbM58651a = C9320b.m58651a("getErrorBody fail : ");
            sbM58651a.append(e10.getMessage());
            C1029b.m6231b("RemoteRestClient", sbM58651a.toString(), new Object[0]);
            return "";
        }
    }

    @Override // com.huawei.wisesecurity.ucs.credential.outer.NetworkCapability
    public NetworkResponse get(NetworkRequest networkRequest) throws IOException {
        NetworkResponse networkResponse = new NetworkResponse();
        Response<String> responseExecute = this.f45395a.m58705a(networkRequest.getUrl(), networkRequest.getHeaders()).execute();
        networkResponse.setCode(responseExecute.getCode());
        networkResponse.setHeaders(responseExecute.getHeaders());
        networkResponse.setBody(m56623a(responseExecute));
        return networkResponse;
    }

    @Override // com.huawei.wisesecurity.ucs.credential.outer.NetworkCapability
    public void initConfig(int i10, int i11) throws C14389c {
        Context context = this.f45396b;
        try {
            NetworkKit.init(context, new C9346o(this));
            this.f45395a = (InterfaceC9350r) new RestClient.Builder().httpClient(new HttpClient.Builder().connectTimeout(i10).callTimeout(i10).sslSocketFactory((SSLSocketFactory) C10618f.m65076c(context, C11532e.m68821a()), (X509TrustManager) new SecureX509TrustManager(context)).retryTimeOnConnectionFailure(i11).build()).build().create(InterfaceC9350r.class);
        } catch (Exception e10) {
            StringBuilder sbM58651a = C9320b.m58651a("RemoteRestClient init failed, ");
            sbM58651a.append(e10.getMessage());
            String string = sbM58651a.toString();
            throw C9344n.m58700a("RemoteRestClient", string, new Object[0], 2001L, string);
        }
    }

    @Override // com.huawei.wisesecurity.ucs.credential.outer.NetworkCapability
    public NetworkResponse post(NetworkRequest networkRequest) throws IOException {
        NetworkResponse networkResponse = new NetworkResponse();
        Response<String> responseExecute = this.f45395a.m58706a(networkRequest.getUrl(), networkRequest.getHeaders(), networkRequest.getBody()).execute();
        networkResponse.setCode(responseExecute.getCode());
        networkResponse.setHeaders(responseExecute.getHeaders());
        networkResponse.setBody(m56623a(responseExecute));
        return networkResponse;
    }
}
