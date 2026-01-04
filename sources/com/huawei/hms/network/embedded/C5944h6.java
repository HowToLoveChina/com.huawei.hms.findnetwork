package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.CheckParamUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.embedded.C5891d6;
import com.huawei.hms.network.embedded.C5983k6;
import com.huawei.hms.network.httpclient.HttpClient;
import com.huawei.hms.network.httpclient.RequestBody;
import com.huawei.hms.network.httpclient.ResponseBody;
import com.huawei.hms.network.httpclient.Submit;
import com.huawei.hms.network.inner.api.PolicyNetworkService;
import com.huawei.hms.network.restclient.Converter;
import com.huawei.hms.network.restclient.RestClient;
import com.huawei.hms.network.restclient.SubmitAdapter;
import com.huawei.hms.network.restclient.internal.IRestClientBuilder;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.network.embedded.h6 */
/* loaded from: classes8.dex */
public class C5944h6 extends RestClient {

    /* renamed from: i */
    public static final String f26936i = "RealRestClient";

    /* renamed from: a */
    public final C5888d3 f26937a;

    /* renamed from: b */
    public final List<Converter.Factory> f26938b;

    /* renamed from: c */
    public final List<SubmitAdapter.Factory> f26939c;

    /* renamed from: d */
    public final Executor f26940d;

    /* renamed from: e */
    public final boolean f26941e;

    /* renamed from: f */
    public Submit.Factory f26942f;

    /* renamed from: g */
    public final boolean f26943g;

    /* renamed from: h */
    public final Map<Method, C5983k6<?, ?>> f26944h;

    /* renamed from: com.huawei.hms.network.embedded.h6$a */
    public class a implements InvocationHandler {

        /* renamed from: a */
        public final /* synthetic */ Class f26945a;

        public a(Class cls) {
            this.f26945a = cls;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            C5983k6 c5983k6M34346a = C5944h6.this.m34346a(method, this.f26945a);
            return c5983k6M34346a.m34566a(new C5957i6(C5944h6.this.f26942f, c5983k6M34346a, objArr));
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.h6$b */
    public static final class b extends IRestClientBuilder {

        /* renamed from: a */
        public final List<Converter.Factory> f26947a;

        /* renamed from: b */
        public final List<SubmitAdapter.Factory> f26948b;

        /* renamed from: c */
        public Submit.Factory f26949c;

        /* renamed from: d */
        public C5888d3 f26950d;

        /* renamed from: e */
        public Executor f26951e;

        /* renamed from: f */
        public boolean f26952f;

        /* renamed from: g */
        public boolean f26953g;

        public b() {
            this.f26947a = new ArrayList();
            this.f26948b = new ArrayList();
            this.f26953g = true;
        }

        /* renamed from: a */
        private SubmitAdapter.Factory m34355a(Executor executor) {
            return executor != null ? new C5918f6(executor) : C5905e6.f26689a;
        }

        @Override // com.huawei.hms.network.restclient.internal.IRestClientBuilder
        public b addConverterFactory(Converter.Factory factory) {
            this.f26947a.add((Converter.Factory) CheckParamUtils.checkNotNull(factory, "factory == null"));
            return this;
        }

        @Override // com.huawei.hms.network.restclient.internal.IRestClientBuilder
        public b addSubmitAdapterFactory(SubmitAdapter.Factory factory) {
            this.f26948b.add((SubmitAdapter.Factory) CheckParamUtils.checkNotNull(factory, "factory == null"));
            return this;
        }

        public b baseUrl(C5888d3 c5888d3) {
            CheckParamUtils.checkNotNull(c5888d3, "baseUrl == null");
            this.f26950d = c5888d3;
            return this;
        }

        @Override // com.huawei.hms.network.restclient.internal.IRestClientBuilder
        public RestClient build() {
            if (this.f26950d == null) {
                Logger.m32145w(C5944h6.f26936i, "may be you need a baseUrl");
            }
            Executor executor = this.f26951e;
            ArrayList arrayList = new ArrayList(this.f26948b);
            arrayList.add(m34355a(executor));
            ArrayList arrayList2 = new ArrayList(this.f26947a.size() + 2);
            arrayList2.add(new C5891d6());
            if (this.f26953g) {
                arrayList2.add(new C5996l6());
            }
            arrayList2.addAll(this.f26947a);
            Logger.m32136d(C5944h6.f26936i, "build time = " + C5965j1.getBuildTime());
            return new C5944h6(this.f26950d, Collections.unmodifiableList(arrayList2), Collections.unmodifiableList(arrayList), executor, this.f26953g, this.f26952f, this.f26949c, null);
        }

        @Override // com.huawei.hms.network.restclient.internal.IRestClientBuilder
        public b callbackExecutor(Executor executor) {
            this.f26951e = (Executor) CheckParamUtils.checkNotNull(executor, "executor == null");
            return this;
        }

        @Override // com.huawei.hms.network.restclient.internal.IRestClientBuilder
        public IRestClientBuilder disableDefaultToStringConverterFactory() {
            this.f26953g = false;
            return this;
        }

        @Override // com.huawei.hms.network.restclient.internal.IRestClientBuilder
        public b httpClient(HttpClient httpClient) {
            CheckParamUtils.checkNotNull(httpClient, "client == null");
            return submitFactory((Submit.Factory) httpClient);
        }

        @Override // com.huawei.hms.network.restclient.internal.IRestClientBuilder
        public b submitFactory(Submit.Factory factory) {
            this.f26949c = (Submit.Factory) CheckParamUtils.checkNotNull(factory, "factory == null");
            return this;
        }

        @Override // com.huawei.hms.network.restclient.internal.IRestClientBuilder
        public b validateEagerly(boolean z10) {
            this.f26952f = z10;
            return this;
        }

        public b(C5944h6 c5944h6) {
            ArrayList arrayList = new ArrayList();
            this.f26947a = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.f26948b = arrayList2;
            this.f26953g = true;
            this.f26950d = c5944h6.f26937a;
            arrayList.addAll(c5944h6.f26938b);
            boolean z10 = c5944h6.f26943g;
            this.f26953g = z10;
            if (z10) {
                arrayList.remove(1);
            }
            arrayList.remove(0);
            arrayList2.addAll(c5944h6.f26939c);
            arrayList2.remove(arrayList2.size() - 1);
            this.f26951e = c5944h6.f26940d;
            this.f26952f = c5944h6.f26941e;
            this.f26949c = c5944h6.f26942f;
        }

        @Override // com.huawei.hms.network.restclient.internal.IRestClientBuilder
        public b baseUrl(String str) {
            this.f26950d = new C5888d3(str);
            return this;
        }
    }

    public C5944h6(C5888d3 c5888d3, List<Converter.Factory> list, List<SubmitAdapter.Factory> list2, Executor executor, boolean z10, boolean z11, Submit.Factory factory) throws JSONException {
        this.f26944h = new ConcurrentHashMap();
        this.f26937a = c5888d3;
        this.f26938b = list;
        this.f26939c = list2;
        this.f26940d = executor;
        this.f26941e = z11;
        this.f26943g = z10;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PolicyNetworkService.ProfileConstants.SCENE_TYPE_OPTION_KEY, PolicyNetworkService.ProfileConstants.RESTFUL);
        } catch (JSONException e10) {
            Logger.m32145w(f26936i, "Init httpclient occurs JSONException " + e10.getMessage());
        }
        this.f26942f = factory;
        if (factory == null) {
            this.f26942f = new HttpClient.Builder().options(jSONObject.toString()).build();
        }
    }

    @Override // com.huawei.hms.network.restclient.RestClient
    public <T> T create(Class<T> cls) throws SecurityException {
        if (!cls.isInterface()) {
            throw new IllegalArgumentException("API declarations must be interfaces.");
        }
        if (cls.getInterfaces().length > 0) {
            throw new IllegalArgumentException("API interfaces must not extend other interfaces.");
        }
        if (this.f26941e) {
            m34348a((Class<?>) cls);
        }
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(cls));
    }

    public C5888d3 getBaseUrl() {
        return this.f26937a;
    }

    public Executor getCallbackExecutor() {
        return this.f26940d;
    }

    public List<Converter.Factory> getConverterFactories() {
        return this.f26938b;
    }

    public HttpClient getHttpClient() {
        Submit.Factory factory = this.f26942f;
        if (factory instanceof HttpClient) {
            return (HttpClient) factory;
        }
        Logger.m32145w(f26936i, "the httpclient hasn't be set,and return the default httpclient!");
        return new HttpClient.Builder().build();
    }

    public List<SubmitAdapter.Factory> getSubmitAdapterFactories() {
        return this.f26939c;
    }

    public Submit.Factory getSubmitFactory() {
        return this.f26942f;
    }

    @Override // com.huawei.hms.network.restclient.RestClient
    public IRestClientBuilder newBuilder() {
        return new b(this);
    }

    public <T> Converter<T, RequestBody> nextRequestBodyConverter(Converter.Factory factory, Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        CheckParamUtils.checkNotNull(type, "type == null");
        CheckParamUtils.checkNotNull(annotationArr, "parameterAnnotations == null");
        CheckParamUtils.checkNotNull(annotationArr2, "methodAnnotations == null");
        int size = this.f26938b.size();
        for (int iIndexOf = this.f26938b.indexOf(factory) + 1; iIndexOf < size; iIndexOf++) {
            Converter<T, RequestBody> converter = (Converter<T, RequestBody>) this.f26938b.get(iIndexOf).requestBodyConverter(type, annotationArr, annotationArr2, this);
            if (converter != null) {
                return converter;
            }
        }
        throw new IllegalArgumentException("Could not locate RequestBody converter for " + type);
    }

    public <T> Converter<ResponseBody, T> nextResponseBodyConverter(Converter.Factory factory, Type type, Annotation[] annotationArr) {
        CheckParamUtils.checkNotNull(type, "type == null");
        CheckParamUtils.checkNotNull(annotationArr, "annotations == null");
        int size = this.f26938b.size();
        for (int iIndexOf = this.f26938b.indexOf(factory) + 1; iIndexOf < size; iIndexOf++) {
            Converter<ResponseBody, T> converter = (Converter<ResponseBody, T>) this.f26938b.get(iIndexOf).responseBodyConverter(type, annotationArr, this);
            if (converter != null) {
                return converter;
            }
        }
        throw new IllegalArgumentException("Could not locate ResponseBody converter for " + type);
    }

    public SubmitAdapter<?, ?> nextSubmitAdapter(SubmitAdapter.Factory factory, Type type, Annotation[] annotationArr) {
        CheckParamUtils.checkNotNull(type, "returnType == null");
        CheckParamUtils.checkNotNull(annotationArr, "annotations == null");
        int size = this.f26939c.size();
        for (int iIndexOf = this.f26939c.indexOf(factory) + 1; iIndexOf < size; iIndexOf++) {
            SubmitAdapter<?, ?> submitAdapter = this.f26939c.get(iIndexOf).get(type, annotationArr, this);
            if (submitAdapter != null) {
                return submitAdapter;
            }
        }
        throw new IllegalArgumentException("Could not locate submit adapter for " + type);
    }

    public <T> Converter<T, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        return nextRequestBodyConverter(null, type, annotationArr, annotationArr2);
    }

    public <T> Converter<ResponseBody, T> responseBodyConverter(Type type, Annotation[] annotationArr) {
        return nextResponseBodyConverter(null, type, annotationArr);
    }

    public <T> Converter<T, String> stringConverter(Type type, Annotation[] annotationArr) {
        CheckParamUtils.checkNotNull(annotationArr, "annotations == null");
        CheckParamUtils.checkNotNull(type, "type == null");
        int size = this.f26938b.size();
        for (int i10 = 0; i10 < size; i10++) {
            Converter<T, String> converter = (Converter<T, String>) this.f26938b.get(i10).stringConverter(type, annotationArr, this);
            if (converter != null) {
                return converter;
            }
        }
        return C5891d6.c.f26646a;
    }

    public SubmitAdapter<?, ?> submitAdapter(Type type, Annotation[] annotationArr) {
        return nextSubmitAdapter(null, type, annotationArr);
    }

    public /* synthetic */ C5944h6(C5888d3 c5888d3, List list, List list2, Executor executor, boolean z10, boolean z11, Submit.Factory factory, a aVar) {
        this(c5888d3, list, list2, executor, z10, z11, factory);
    }

    /* renamed from: a */
    public C5983k6<?, ?> m34346a(Method method, Class cls) {
        C5983k6 c5983k6Build;
        C5983k6<?, ?> c5983k6 = this.f26944h.get(method);
        if (c5983k6 != null) {
            return c5983k6;
        }
        synchronized (this.f26944h) {
            try {
                c5983k6Build = this.f26944h.get(method);
                if (c5983k6Build == null) {
                    c5983k6Build = new C5983k6.b(this, method, cls).build();
                    this.f26944h.put(method, c5983k6Build);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c5983k6Build;
    }

    /* renamed from: a */
    private void m34348a(Class<?> cls) throws SecurityException {
        for (Method method : cls.getDeclaredMethods()) {
            m34346a(method, cls);
        }
    }
}
