package com.huawei.hms.framework.network.restclient.proxy.new2old;

import com.huawei.hms.framework.network.restclient.hwhttp.ResponseBody;
import com.huawei.hms.framework.network.restclient.proxy.new2old.ResponseBodyImp;
import com.huawei.hms.network.httpclient.ResponseBody;

/* loaded from: classes8.dex */
public class ProxyResponseBody {
    public static ResponseBody response2New(com.huawei.hms.framework.network.restclient.hwhttp.ResponseBody responseBody) {
        ResponseBodyImp.Builder builder = new ResponseBodyImp.Builder();
        builder.contentType(responseBody.getContentType()).contentLength(responseBody.getContentLength());
        if (responseBody.getInputStream() != null) {
            builder.inputStream(responseBody.getInputStream()).charSet(responseBody.getCharSet());
        }
        return builder.build();
    }

    public static com.huawei.hms.framework.network.restclient.hwhttp.ResponseBody response2Old(ResponseBody responseBody) {
        ResponseBody.Builder builder = new ResponseBody.Builder();
        builder.contentType(responseBody.getContentType()).contentLength(responseBody.getContentLength());
        if (responseBody.getInputStream() != null) {
            builder.inputStream(responseBody.getInputStream());
        }
        com.huawei.hms.framework.network.restclient.hwhttp.ResponseBody responseBodyBuild = builder.build();
        responseBodyBuild.setReader(responseBody.charStream());
        return responseBodyBuild;
    }
}
