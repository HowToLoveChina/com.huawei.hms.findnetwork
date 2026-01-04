package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.base.util.TypeUtils;
import com.huawei.hms.network.httpclient.RequestBody;
import com.huawei.hms.network.httpclient.ResponseBody;
import com.huawei.hms.network.restclient.Converter;
import com.huawei.hms.network.restclient.RestClient;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* renamed from: com.huawei.hms.network.embedded.d6 */
/* loaded from: classes8.dex */
public final class C5891d6 extends Converter.Factory {

    /* renamed from: a */
    public static final String f26643a = "BuiltInConverters";

    /* renamed from: com.huawei.hms.network.embedded.d6$a */
    public static final class a extends Converter<RequestBody, RequestBody> {

        /* renamed from: a */
        public static final a f26644a = new a();

        @Override // com.huawei.hms.network.restclient.Converter
        public RequestBody convert(RequestBody requestBody) {
            return requestBody;
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.d6$b */
    public static final class b extends Converter<ResponseBody, ResponseBody> {

        /* renamed from: a */
        public static final b f26645a = new b();

        @Override // com.huawei.hms.network.restclient.Converter
        public ResponseBody convert(ResponseBody responseBody) {
            return responseBody;
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.d6$c */
    public static final class c extends Converter<Object, String> {

        /* renamed from: a */
        public static final c f26646a = new c();

        @Override // com.huawei.hms.network.restclient.Converter
        public String convert(Object obj) {
            return obj.toString();
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.d6$d */
    public static final class d extends Converter<ResponseBody, Void> {

        /* renamed from: a */
        public static final d f26647a = new d();

        @Override // com.huawei.hms.network.restclient.Converter
        public Void convert(ResponseBody responseBody) {
            try {
                responseBody.close();
                return null;
            } catch (IOException unused) {
                Logger.m32141i(C5891d6.f26643a, "VoidResponseBodyConverter iOException");
                return null;
            }
        }
    }

    @Override // com.huawei.hms.network.restclient.Converter.Factory
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, RestClient restClient) {
        if (RequestBody.class.isAssignableFrom(TypeUtils.getRawType(type))) {
            return a.f26644a;
        }
        return null;
    }

    @Override // com.huawei.hms.network.restclient.Converter.Factory
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, RestClient restClient) {
        if (type == ResponseBody.class) {
            return b.f26645a;
        }
        if (type == Void.class) {
            return d.f26647a;
        }
        return null;
    }
}
