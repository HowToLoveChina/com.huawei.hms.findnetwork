package com.huawei.hms.framework.network.restclient;

import com.huawei.hms.network.base.util.TypeUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@Deprecated
/* loaded from: classes8.dex */
public interface SubmitAdapter<R, T> {

    @Deprecated
    public static abstract class Factory {
        public static Type getParameterUpperBound(int i10, ParameterizedType parameterizedType) {
            return TypeUtils.getParameterUpperBound(i10, parameterizedType);
        }

        public static Class<?> getRawType(Type type) {
            return TypeUtils.getRawType(type);
        }

        public abstract SubmitAdapter<?, ?> get(Type type, Annotation[] annotationArr, RestClient restClient);
    }

    T adapt(Submit<R> submit);

    Type responseType();
}
