package com.huawei.hms.network.restclient;

import com.huawei.hms.network.httpclient.RequestBody;
import com.huawei.hms.network.httpclient.ResponseBody;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* loaded from: classes8.dex */
public abstract class Converter<F, T> {

    public static abstract class Factory {
        public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, RestClient restClient) {
            return null;
        }

        public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, RestClient restClient) {
            return null;
        }

        public Converter<?, String> stringConverter(Type type, Annotation[] annotationArr, RestClient restClient) {
            return null;
        }
    }

    public abstract T convert(F f10) throws IOException;
}
