package com.huawei.hms.network.embedded;

import com.huawei.hms.network.base.common.RequestBodyProviders;
import com.huawei.hms.network.httpclient.RequestBody;
import com.huawei.hms.network.httpclient.ResponseBody;
import com.huawei.hms.network.restclient.Converter;
import com.huawei.hms.network.restclient.RestClient;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* renamed from: com.huawei.hms.network.embedded.l6 */
/* loaded from: classes8.dex */
public class C5996l6 extends Converter.Factory {

    /* renamed from: a */
    public static final String f27382a = "text/plain; charset=UTF-8";

    /* renamed from: com.huawei.hms.network.embedded.l6$a */
    public class a extends Converter<ResponseBody, String> {
        public a() {
        }

        @Override // com.huawei.hms.network.restclient.Converter
        public String convert(ResponseBody responseBody) throws IOException {
            return new String(responseBody.bytes(), Constants.UTF_8);
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.l6$b */
    public class b extends Converter<String, RequestBody> {
        public b() {
        }

        @Override // com.huawei.hms.network.restclient.Converter
        public RequestBody convert(String str) throws IOException {
            return RequestBodyProviders.create("text/plain; charset=UTF-8", str.getBytes(Constants.UTF_8));
        }
    }

    @Override // com.huawei.hms.network.restclient.Converter.Factory
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, RestClient restClient) {
        if (String.class.equals(type)) {
            return new b();
        }
        return null;
    }

    @Override // com.huawei.hms.network.restclient.Converter.Factory
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, RestClient restClient) {
        if (String.class.equals(type)) {
            return new a();
        }
        return null;
    }
}
