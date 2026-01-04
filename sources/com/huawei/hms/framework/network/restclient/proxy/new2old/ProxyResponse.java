package com.huawei.hms.framework.network.restclient.proxy.new2old;

import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.restclient.Headers;
import com.huawei.hms.framework.network.restclient.hwhttp.Response;
import com.huawei.hms.framework.network.restclient.proxy.new2old.ResponseImp;
import com.huawei.hms.network.httpclient.Response;
import com.huawei.hms.network.httpclient.ResponseBody;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes8.dex */
public class ProxyResponse {
    private static final String TAG = "ProxyResponse";

    public static <T> Response<T> response2New(com.huawei.hms.framework.network.restclient.hwhttp.Response response) {
        if (response == null) {
            return null;
        }
        ResponseImp.Builder builder = new ResponseImp.Builder();
        builder.code(response.getCode()).message(response.getMessage());
        if (response.getUrl() != null) {
            builder.url(response.getUrl().toString());
        }
        if (response.getHeaders() != null) {
            builder.headers(response.getHeaders().toMultimap());
        }
        builder.body((ResponseImp.Builder) ProxyResponseBody.response2New(response.getBody()));
        return builder.build();
    }

    public static com.huawei.hms.framework.network.restclient.hwhttp.Response response2Old(Response<ResponseBody> response) {
        if (response == null) {
            return null;
        }
        Response.Builder builderMessage = new Response.Builder().code(response.getCode()).message(response.getMessage());
        if (response.getHeaders() != null) {
            builderMessage.headers(Headers.m32364of(Headers.toArray(response.getHeaders())));
        }
        try {
            builderMessage.url(new URL(response.getUrl()));
        } catch (MalformedURLException unused) {
            Logger.m32145w(TAG, "MalformedURLException");
        }
        ResponseBody body = response.getBody() != null ? response.getBody() : response.getErrorBody();
        if (body != null) {
            builderMessage.body(ProxyResponseBody.response2Old(new ResponseBodyImp(body)));
        }
        return builderMessage.build();
    }
}
