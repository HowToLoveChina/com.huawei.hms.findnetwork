package com.huawei.hms.framework.network.restclient;

import com.huawei.hms.framework.network.restclient.Converter;
import com.huawei.hms.framework.network.restclient.hwhttp.RequestBody;
import com.huawei.hms.framework.network.restclient.hwhttp.ResponseBody;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Deprecated
/* loaded from: classes8.dex */
public class ToStringConverterFactory extends Converter.Factory {
    private static final String MEDIA_TYPE = "text/plain; charset=UTF-8";

    @Override // com.huawei.hms.framework.network.restclient.Converter.Factory
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, RestClient restClient) {
        if (String.class.equals(type)) {
            return new Converter<String, RequestBody>() { // from class: com.huawei.hms.framework.network.restclient.ToStringConverterFactory.2
                @Override // com.huawei.hms.framework.network.restclient.Converter
                public RequestBody convert(String str) throws IOException {
                    return RequestBody.create("text/plain; charset=UTF-8", str.getBytes(Constants.UTF_8));
                }
            };
        }
        return null;
    }

    @Override // com.huawei.hms.framework.network.restclient.Converter.Factory
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, RestClient restClient) {
        if (String.class.equals(type)) {
            return new Converter<ResponseBody, String>() { // from class: com.huawei.hms.framework.network.restclient.ToStringConverterFactory.1
                @Override // com.huawei.hms.framework.network.restclient.Converter
                public String convert(ResponseBody responseBody) throws IOException {
                    return new String(responseBody.bytes(), Constants.UTF_8);
                }
            };
        }
        return null;
    }
}
