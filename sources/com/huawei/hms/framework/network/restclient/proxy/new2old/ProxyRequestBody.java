package com.huawei.hms.framework.network.restclient.proxy.new2old;

import com.huawei.hms.framework.common.CheckParamUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.httpclient.RequestBody;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes8.dex */
public class ProxyRequestBody {
    private static final String TAG = "ProxyRequestBody";

    public static RequestBody requestBody2New(final com.huawei.hms.framework.network.restclient.hwhttp.RequestBody requestBody) {
        CheckParamUtils.checkNotNull(requestBody, "RequestBody2New body == null");
        return new RequestBody() { // from class: com.huawei.hms.framework.network.restclient.proxy.new2old.ProxyRequestBody.2
            @Override // com.huawei.hms.network.httpclient.RequestBody
            public long contentLength() throws IOException {
                if (requestBody.contentLength() == 0) {
                    return -1L;
                }
                return requestBody.contentLength();
            }

            @Override // com.huawei.hms.network.httpclient.RequestBody
            public String contentType() {
                return requestBody.contentType();
            }

            @Override // com.huawei.hms.network.httpclient.RequestBody
            public void writeTo(OutputStream outputStream) throws IOException {
                if (requestBody.body() == null || requestBody.body().length == 0) {
                    requestBody.writeTo(outputStream);
                } else {
                    outputStream.write(requestBody.body());
                }
            }
        };
    }

    public static com.huawei.hms.framework.network.restclient.hwhttp.RequestBody requestBody2Old(final RequestBody requestBody) {
        CheckParamUtils.checkNotNull(requestBody, "RequestBody2Old body == null");
        return new com.huawei.hms.framework.network.restclient.hwhttp.RequestBody() { // from class: com.huawei.hms.framework.network.restclient.proxy.new2old.ProxyRequestBody.1
            @Override // com.huawei.hms.framework.network.restclient.hwhttp.RequestBody
            public byte[] body() {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    writeTo(byteArrayOutputStream);
                    return byteArrayOutputStream.toByteArray();
                } catch (IOException unused) {
                    Logger.m32145w(ProxyRequestBody.TAG, "ProxyRequestBody requestBody2Old body error");
                    return new byte[0];
                }
            }

            @Override // com.huawei.hms.framework.network.restclient.hwhttp.RequestBody
            public long contentLength() throws IOException {
                if (requestBody.contentLength() == -1) {
                    return 0L;
                }
                return requestBody.contentLength();
            }

            @Override // com.huawei.hms.framework.network.restclient.hwhttp.RequestBody
            public String contentType() {
                return requestBody.contentType();
            }

            @Override // com.huawei.hms.framework.network.restclient.hwhttp.RequestBody
            public void writeTo(OutputStream outputStream) throws IOException {
                requestBody.writeTo(outputStream);
            }
        };
    }
}
