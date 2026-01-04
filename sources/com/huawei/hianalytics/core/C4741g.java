package com.huawei.hianalytics.core;

import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.core.transport.net.Response;
import com.huawei.hianalytics.core.transport.net.TransportHandler;
import com.huawei.hms.network.base.common.RequestBodyProviders;
import com.huawei.hms.network.embedded.C6158y;
import com.huawei.hms.network.httpclient.HttpClient;
import com.huawei.hms.network.httpclient.Request;
import com.huawei.hms.network.httpclient.ResponseBody;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hianalytics.core.g */
/* loaded from: classes5.dex */
public class C4741g extends TransportHandler {

    /* renamed from: d */
    public int f21685d;

    /* renamed from: e */
    public final boolean f21686e;

    public C4741g(String str, Map<String, String> map, byte[] bArr, int i10, boolean z10) {
        super(str, map, bArr);
        this.f21685d = i10;
        this.f21686e = z10;
    }

    @Override // com.huawei.hianalytics.core.transport.net.TransportHandler
    /* renamed from: a */
    public Response mo28797a() {
        return m28803a("GET");
    }

    @Override // com.huawei.hianalytics.core.transport.net.TransportHandler
    /* renamed from: b */
    public Response mo28802b() {
        return m28803a("POST");
    }

    /* renamed from: a */
    public final void m28804a(com.huawei.hms.network.httpclient.Response<ResponseBody> response) {
        if (response == null) {
            return;
        }
        try {
            response.close();
        } catch (IOException unused) {
            HiLog.m28808e("NetworkKitHandler", "NetworkKit IOException");
        }
    }

    /* renamed from: a */
    public final Response m28803a(String str) throws JSONException {
        HttpClient.Builder timeout = new HttpClient.Builder().readTimeout(C6158y.f29108c);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("metric_policy", this.f21685d);
        } catch (Exception unused) {
            HiLog.m28812w("NetworkKitHandler", "fail to build custom option");
        }
        HttpClient httpClientBuild = timeout.options(jSONObject.toString()).writeTimeout(C6158y.f29108c).connectTimeout(C6158y.f29108c).retryTimeOnConnectionFailure(0).build();
        Request.Builder builderMethod = httpClientBuild.newRequest().url(this.f21695a).method(str);
        Map<String, String> map = this.f21696b;
        if (map != null) {
            for (String str2 : map.keySet()) {
                builderMethod.addHeader(str2, this.f21696b.get(str2));
            }
        }
        if (!"GET".equals(str)) {
            builderMethod.addHeader("Conntent-Length", String.valueOf(this.f21697c.length));
            builderMethod.requestBody(RequestBodyProviders.create("application/json; charset=UTF-8", this.f21697c));
        }
        if (this.f21686e) {
            HiLog.m28807d("NetworkKitHandler", "enable http shortLink");
            builderMethod.addHeader("Connection", "close");
        }
        try {
            try {
                com.huawei.hms.network.httpclient.Response<ResponseBody> responseExecute = httpClientBuild.newSubmit(builderMethod.build()).execute();
                if (responseExecute.getBody() == null) {
                    Response response = new Response(responseExecute.getCode(), "");
                    m28804a(responseExecute);
                    return response;
                }
                Response response2 = new Response(responseExecute.getCode(), new String(responseExecute.getBody().bytes(), StandardCharsets.UTF_8));
                m28804a(responseExecute);
                return response2;
            } catch (IOException e10) {
                Response response3 = new Response(Response.Code.UNKNOWN_ERROR, e10.getMessage());
                m28804a((com.huawei.hms.network.httpclient.Response<ResponseBody>) null);
                return response3;
            }
        } catch (Throwable th2) {
            m28804a((com.huawei.hms.network.httpclient.Response<ResponseBody>) null);
            throw th2;
        }
    }
}
