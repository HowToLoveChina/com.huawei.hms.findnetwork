package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.restclient.hwhttp.ClientConfiguration;
import com.huawei.hms.network.base.common.Headers;
import com.huawei.hms.network.base.util.TypeUtils;
import com.huawei.hms.network.embedded.AbstractC5931g6;
import com.huawei.hms.network.httpclient.Request;
import com.huawei.hms.network.httpclient.RequestBody;
import com.huawei.hms.network.httpclient.ResponseBody;
import com.huawei.hms.network.httpclient.Submit;
import com.huawei.hms.network.restclient.Converter;
import com.huawei.hms.network.restclient.SubmitAdapter;
import com.huawei.hms.network.restclient.anno.NetworkParameters;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.huawei.hms.network.embedded.k6 */
/* loaded from: classes8.dex */
public final class C5983k6<R, T> {

    /* renamed from: o */
    public static final String f27245o = "SubmitMethod";

    /* renamed from: a */
    public final SubmitAdapter<R, T> f27246a;

    /* renamed from: b */
    public final Converter<ResponseBody, R> f27247b;

    /* renamed from: c */
    public final String f27248c;

    /* renamed from: d */
    public final String f27249d;

    /* renamed from: e */
    public final Headers f27250e;

    /* renamed from: f */
    public final String f27251f;

    /* renamed from: g */
    public final boolean f27252g;

    /* renamed from: h */
    public final boolean f27253h;

    /* renamed from: i */
    public final AbstractC5931g6<?>[] f27254i;

    /* renamed from: j */
    public final C5888d3 f27255j;

    /* renamed from: k */
    public boolean f27256k;

    /* renamed from: m */
    public static final Pattern f27243m = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");

    /* renamed from: l */
    public static final String f27242l = "[a-zA-Z][a-zA-Z0-9_-]*";

    /* renamed from: n */
    public static final Pattern f27244n = Pattern.compile(f27242l);

    /* renamed from: com.huawei.hms.network.embedded.k6$b */
    public static final class b<R, T> {

        /* renamed from: a */
        public final C5944h6 f27257a;

        /* renamed from: b */
        public final Method f27258b;

        /* renamed from: c */
        public final Annotation[] f27259c;

        /* renamed from: d */
        public final Annotation[][] f27260d;

        /* renamed from: e */
        public final Type[] f27261e;

        /* renamed from: f */
        public Type f27262f;

        /* renamed from: g */
        public boolean f27263g;

        /* renamed from: h */
        public boolean f27264h;

        /* renamed from: i */
        public boolean f27265i;

        /* renamed from: j */
        public boolean f27266j;

        /* renamed from: k */
        public boolean f27267k;

        /* renamed from: l */
        public String f27268l;

        /* renamed from: m */
        public boolean f27269m;

        /* renamed from: n */
        public boolean f27270n;

        /* renamed from: o */
        public String f27271o;

        /* renamed from: p */
        public Headers f27272p;

        /* renamed from: q */
        public String f27273q;

        /* renamed from: r */
        public Set<String> f27274r;

        /* renamed from: s */
        public AbstractC5931g6<?>[] f27275s;

        /* renamed from: t */
        public Converter<ResponseBody, R> f27276t;

        /* renamed from: u */
        public SubmitAdapter<R, T> f27277u;

        /* renamed from: v */
        public Annotation[] f27278v;

        /* renamed from: w */
        public boolean f27279w;

        public b(C5944h6 c5944h6, Method method, Class cls) {
            this.f27257a = c5944h6;
            this.f27258b = method;
            this.f27259c = method.getAnnotations();
            this.f27261e = method.getGenericParameterTypes();
            this.f27260d = method.getParameterAnnotations();
            this.f27278v = cls.getAnnotations();
        }

        /* renamed from: a */
        private Headers m34567a(String[] strArr) {
            Headers headers = this.f27272p;
            Headers.Builder builder = headers == null ? new Headers.Builder() : headers.newBuilder();
            for (String str : strArr) {
                int iIndexOf = str.indexOf(58);
                if (iIndexOf == 0 || iIndexOf == -1 || iIndexOf == str.length() - 1) {
                    throw m34573a("@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
                String strSubstring = str.substring(0, iIndexOf);
                String strTrim = str.substring(iIndexOf + 1).trim();
                if ("Content-Type".equalsIgnoreCase(strSubstring)) {
                    this.f27273q = strTrim;
                } else {
                    builder.add(strSubstring, strTrim);
                }
            }
            return builder.build();
        }

        /* renamed from: b */
        private AbstractC5931g6<?> m34581b(int i10, Type type) {
            if (type == String.class) {
                return new AbstractC5931g6.i();
            }
            throw m34572a(i10, "@NetworkParameters must be of type String.");
        }

        /* renamed from: c */
        private AbstractC5931g6<?> m34587c(int i10, Type type) {
            if (this.f27267k) {
                throw m34572a(i10, "Multiple @Url method annotations found.");
            }
            if (this.f27265i) {
                throw m34572a(i10, "@Path parameters may not be used with @Url.");
            }
            if (this.f27266j) {
                throw m34572a(i10, "A @Url parameter must not come after a @Query");
            }
            if (this.f27271o != null) {
                throw m34572a(i10, "@Url cannot be used with " + this.f27268l);
            }
            this.f27267k = true;
            if (type == String.class || type == URI.class || ((type instanceof Class) && "android.net.Uri".equals(((Class) type).getName()))) {
                return new AbstractC5931g6.n();
            }
            throw m34572a(i10, "@Url must be String, java.net.URI, or android.net.Uri type.");
        }

        /* renamed from: d */
        private AbstractC5931g6<?> m34591d(int i10, Type type, Annotation[] annotationArr) {
            AbstractC5931g6<?> abstractC5931g6 = null;
            for (Annotation annotation : annotationArr) {
                AbstractC5931g6<?> abstractC5931g6M34589c = m34589c(i10, type, annotationArr, annotation);
                if (abstractC5931g6M34589c != null) {
                    if (abstractC5931g6 != null) {
                        throw m34572a(i10, "Multiple RestClient annotations found, only one allowed.");
                    }
                    abstractC5931g6 = abstractC5931g6M34589c;
                }
            }
            if (abstractC5931g6 != null) {
                return abstractC5931g6;
            }
            throw m34572a(i10, "No RestClient annotation found.");
        }

        /* renamed from: e */
        private AbstractC5931g6<?> m34594e(int i10, Type type, Annotation[] annotationArr) {
            Class<?> rawType = TypeUtils.getRawType(type);
            if (!Map.class.isAssignableFrom(rawType)) {
                throw m34572a(i10, "@RecordMap parameter type must be Map.");
            }
            Type supertype = TypeUtils.getSupertype(type, rawType, Map.class);
            if (!(supertype instanceof ParameterizedType)) {
                throw m34572a(i10, "Map must include generic types (e.g., Map<String, String>)");
            }
            ParameterizedType parameterizedType = (ParameterizedType) supertype;
            Type parameterUpperBound = TypeUtils.getParameterUpperBound(0, parameterizedType);
            if (String.class == parameterUpperBound) {
                return new AbstractC5931g6.m(this.f27257a.stringConverter(TypeUtils.getParameterUpperBound(1, parameterizedType), annotationArr));
            }
            throw m34572a(i10, "@RecordMap keys must be of type String: " + parameterUpperBound);
        }

        /* renamed from: f */
        private AbstractC5931g6<?> m34596f(int i10, Type type, Annotation[] annotationArr, Annotation annotation) {
            Class<?> rawType = TypeUtils.getRawType(type);
            if (!Map.class.isAssignableFrom(rawType)) {
                throw m34572a(i10, "@QueryMap parameter type must be Map.");
            }
            Type supertype = TypeUtils.getSupertype(type, rawType, Map.class);
            if (!(supertype instanceof ParameterizedType)) {
                throw m34572a(i10, "Map must include generic types (e.g., Map<String, String>)");
            }
            ParameterizedType parameterizedType = (ParameterizedType) supertype;
            Type parameterUpperBound = TypeUtils.getParameterUpperBound(0, parameterizedType);
            if (String.class == parameterUpperBound) {
                return new AbstractC5931g6.k(this.f27257a.stringConverter(TypeUtils.getParameterUpperBound(1, parameterizedType), annotationArr), m34579a(annotation));
            }
            throw m34572a(i10, "@QueryMap keys must be of type String: " + parameterUpperBound);
        }

        public C5983k6 build() {
            SubmitAdapter<R, T> submitAdapterM34571a = m34571a(this.f27258b);
            this.f27277u = submitAdapterM34571a;
            this.f27262f = submitAdapterM34571a.responseType();
            this.f27276t = m34584b();
            for (Annotation annotation : this.f27278v) {
                m34590c(annotation);
            }
            for (Annotation annotation2 : this.f27259c) {
                m34593d(annotation2);
            }
            if (this.f27268l == null) {
                throw m34573a("HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
            if (!this.f27269m && this.f27270n) {
                throw m34573a("FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
            }
            int length = this.f27260d.length;
            this.f27275s = new AbstractC5931g6[length];
            for (int i10 = 0; i10 < length; i10++) {
                Type type = this.f27261e[i10];
                if (TypeUtils.hasUnresolvableType(type)) {
                    throw m34572a(i10, "Parameter type must not include a type variable or wildcard: " + type);
                }
                Annotation[] annotationArr = this.f27260d[i10];
                if (annotationArr == null) {
                    throw m34572a(i10, "No RestClient annotation found.");
                }
                this.f27275s[i10] = m34591d(i10, type, annotationArr);
            }
            m34576a();
            return new C5983k6(this);
        }

        /* renamed from: a */
        private AbstractC5931g6<?> m34568a(int i10, Type type) {
            if (type == ClientConfiguration.class) {
                return new AbstractC5931g6.d();
            }
            throw m34572a(i10, "@ClientConfig must be com.huawei.hms.framework.network.rest.hwhttp.ClientConfiguration .");
        }

        /* renamed from: b */
        private AbstractC5931g6<?> m34582b(int i10, Type type, Annotation[] annotationArr) {
            if (!this.f27270n) {
                throw m34572a(i10, "@FieldMap parameters can only be used with form encoding.");
            }
            Class<?> rawType = TypeUtils.getRawType(type);
            if (!Map.class.isAssignableFrom(rawType)) {
                throw m34572a(i10, "@FieldMap parameter type must be Map.");
            }
            Type supertype = TypeUtils.getSupertype(type, rawType, Map.class);
            if (!(supertype instanceof ParameterizedType)) {
                throw m34572a(i10, "Map must include generic types (e.g., Map<String, String>)");
            }
            ParameterizedType parameterizedType = (ParameterizedType) supertype;
            Type parameterUpperBound = TypeUtils.getParameterUpperBound(0, parameterizedType);
            if (String.class == parameterUpperBound) {
                Converter<T, String> converterStringConverter = this.f27257a.stringConverter(TypeUtils.getParameterUpperBound(1, parameterizedType), annotationArr);
                this.f27263g = true;
                return new AbstractC5931g6.e(converterStringConverter);
            }
            throw m34572a(i10, "@FieldMap keys must be of type String: " + parameterUpperBound);
        }

        /* renamed from: c */
        private AbstractC5931g6<?> m34588c(int i10, Type type, Annotation[] annotationArr) {
            Class<?> rawType = TypeUtils.getRawType(type);
            if (!Map.class.isAssignableFrom(rawType)) {
                throw m34572a(i10, "@HeaderMap parameter type must be Map.");
            }
            Type supertype = TypeUtils.getSupertype(type, rawType, Map.class);
            if (!(supertype instanceof ParameterizedType)) {
                throw m34572a(i10, "Map must include generic types (e.g., Map<String, String>)");
            }
            ParameterizedType parameterizedType = (ParameterizedType) supertype;
            Type parameterUpperBound = TypeUtils.getParameterUpperBound(0, parameterizedType);
            if (String.class == parameterUpperBound) {
                return new AbstractC5931g6.h(this.f27257a.stringConverter(TypeUtils.getParameterUpperBound(1, parameterizedType), annotationArr));
            }
            throw m34572a(i10, "@HeaderMap keys must be of type String: " + parameterUpperBound);
        }

        /* renamed from: d */
        private AbstractC5931g6<?> m34592d(int i10, Type type, Annotation[] annotationArr, Annotation annotation) {
            if (this.f27266j) {
                throw m34572a(i10, "A @Path parameter must not come after a @Query.");
            }
            if (this.f27267k) {
                throw m34572a(i10, "@Path parameters may not be used with @Url.");
            }
            if (this.f27271o != null) {
                this.f27265i = true;
                String str = (String) m34585b(annotation);
                m34586b(i10, str);
                return new AbstractC5931g6.j(str, this.f27257a.stringConverter(type, annotationArr));
            }
            throw m34572a(i10, "@Path can only be used with relative url on @" + this.f27268l);
        }

        /* renamed from: e */
        private AbstractC5931g6<?> m34595e(int i10, Type type, Annotation[] annotationArr, Annotation annotation) {
            String str = (String) m34585b(annotation);
            boolean zM34579a = m34579a(annotation);
            Class<?> rawType = TypeUtils.getRawType(type);
            this.f27266j = true;
            if (!Iterable.class.isAssignableFrom(rawType)) {
                if (!rawType.isArray()) {
                    return new AbstractC5931g6.l(str, this.f27257a.stringConverter(type, annotationArr), zM34579a);
                }
                return new AbstractC5931g6.l(str, this.f27257a.stringConverter(TypeUtils.boxIfPrimitive(rawType.getComponentType()), annotationArr), zM34579a).m34303a();
            }
            if (type instanceof ParameterizedType) {
                return new AbstractC5931g6.l(str, this.f27257a.stringConverter(TypeUtils.getParameterUpperBound(0, (ParameterizedType) type), annotationArr), zM34579a).m34305b();
            }
            throw m34572a(i10, rawType.getSimpleName() + " must include generic type (e.g., " + rawType.getSimpleName() + "<String>)");
        }

        /* renamed from: a */
        private AbstractC5931g6<?> m34569a(int i10, Type type, Annotation[] annotationArr) {
            if (this.f27270n) {
                throw m34572a(i10, "@Body parameters cannot be used with form or multi-part encoding.");
            }
            if (this.f27264h) {
                throw m34572a(i10, "Multiple @Body method annotations found.");
            }
            try {
                Converter<T, RequestBody> converterRequestBodyConverter = this.f27257a.requestBodyConverter(type, annotationArr, this.f27259c);
                this.f27264h = true;
                return new AbstractC5931g6.c(converterRequestBodyConverter);
            } catch (RuntimeException e10) {
                throw m34574a(e10, i10, "Unable to create @Body converter for " + type);
            }
        }

        /* renamed from: b */
        private AbstractC5931g6<?> m34583b(int i10, Type type, Annotation[] annotationArr, Annotation annotation) {
            String str = (String) m34585b(annotation);
            Class<?> rawType = TypeUtils.getRawType(type);
            if (!Iterable.class.isAssignableFrom(rawType)) {
                if (!rawType.isArray()) {
                    return new AbstractC5931g6.g(str, this.f27257a.stringConverter(type, annotationArr));
                }
                return new AbstractC5931g6.g(str, this.f27257a.stringConverter(TypeUtils.boxIfPrimitive(rawType.getComponentType()), annotationArr)).m34303a();
            }
            if (type instanceof ParameterizedType) {
                return new AbstractC5931g6.g(str, this.f27257a.stringConverter(TypeUtils.getParameterUpperBound(0, (ParameterizedType) type), annotationArr)).m34305b();
            }
            throw m34572a(i10, rawType.getSimpleName() + " must include generic type (e.g., " + rawType.getSimpleName() + "<String>)");
        }

        /* renamed from: c */
        private AbstractC5931g6<?> m34589c(int i10, Type type, Annotation[] annotationArr, Annotation annotation) {
            if (m34580a(annotation, "Url")) {
                return m34587c(i10, type);
            }
            if (m34580a(annotation, "Path")) {
                return m34592d(i10, type, annotationArr, annotation);
            }
            if (m34580a(annotation, "Query")) {
                return m34595e(i10, type, annotationArr, annotation);
            }
            if (m34580a(annotation, "QueryMap")) {
                return m34596f(i10, type, annotationArr, annotation);
            }
            if (m34580a(annotation, "Header")) {
                return m34583b(i10, type, annotationArr, annotation);
            }
            if (m34580a(annotation, "HeaderMap")) {
                return m34588c(i10, type, annotationArr);
            }
            if (m34580a(annotation, "Field")) {
                return m34570a(i10, type, annotationArr, annotation);
            }
            if (m34580a(annotation, "FieldMap")) {
                return m34582b(i10, type, annotationArr);
            }
            if (m34580a(annotation, "Body")) {
                return m34569a(i10, type, annotationArr);
            }
            if (m34580a(annotation, "ClientConfig")) {
                return m34568a(i10, type);
            }
            if (annotation instanceof NetworkParameters) {
                return m34581b(i10, type);
            }
            if (m34580a(annotation, "RecordMap")) {
                return m34594e(i10, type, annotationArr);
            }
            return null;
        }

        /* renamed from: d */
        private void m34593d(Annotation annotation) {
            String str = "GET";
            if (!m34580a(annotation, "GET")) {
                str = "DELETE";
                if (!m34580a(annotation, "DELETE")) {
                    String str2 = "PUT";
                    if (!m34580a(annotation, "PUT")) {
                        str2 = "POST";
                        if (!m34580a(annotation, "POST")) {
                            if (m34580a(annotation, "HEAD")) {
                                m34577a("HEAD", (String) m34585b(annotation), false);
                                if (!Void.class.equals(this.f27262f)) {
                                    throw m34573a("HEAD method must use Void as response type.", new Object[0]);
                                }
                                return;
                            } else {
                                if (m34580a(annotation, "Headers")) {
                                    String[] strArr = (String[]) m34585b(annotation);
                                    if (strArr.length == 0) {
                                        throw m34573a("@Headers annotation is empty.", new Object[0]);
                                    }
                                    this.f27272p = m34567a(strArr);
                                    return;
                                }
                                if (m34580a(annotation, "FormUrlEncoded")) {
                                    this.f27270n = true;
                                    return;
                                } else {
                                    if (m34580a(annotation, "OnlyConnect")) {
                                        this.f27279w = true;
                                        return;
                                    }
                                    return;
                                }
                            }
                        }
                    }
                    m34577a(str2, (String) m34585b(annotation), true);
                    return;
                }
            }
            m34577a(str, (String) m34585b(annotation), false);
        }

        /* renamed from: a */
        private AbstractC5931g6<?> m34570a(int i10, Type type, Annotation[] annotationArr, Annotation annotation) {
            if (!this.f27270n) {
                throw m34572a(i10, "@Field parameters can only be used with form encoding.");
            }
            String str = (String) m34585b(annotation);
            this.f27263g = true;
            Class<?> rawType = TypeUtils.getRawType(type);
            if (!Iterable.class.isAssignableFrom(rawType)) {
                if (!rawType.isArray()) {
                    return new AbstractC5931g6.f(str, this.f27257a.stringConverter(type, annotationArr));
                }
                return new AbstractC5931g6.f(str, this.f27257a.stringConverter(TypeUtils.boxIfPrimitive(rawType.getComponentType()), annotationArr)).m34303a();
            }
            if (type instanceof ParameterizedType) {
                return new AbstractC5931g6.f(str, this.f27257a.stringConverter(TypeUtils.getParameterUpperBound(0, (ParameterizedType) type), annotationArr)).m34305b();
            }
            throw m34572a(i10, rawType.getSimpleName() + " must include generic type (e.g., " + rawType.getSimpleName() + "<String>)");
        }

        /* renamed from: b */
        private Converter<ResponseBody, R> m34584b() {
            try {
                return this.f27257a.responseBodyConverter(this.f27262f, this.f27259c);
            } catch (RuntimeException e10) {
                throw this.m34575a(e10, "Unable to create converter for " + this.f27262f, new Object[0]);
            }
        }

        /* renamed from: c */
        private void m34590c(Annotation annotation) {
            if (m34580a(annotation, "Headers")) {
                String[] strArr = (String[]) m34585b(annotation);
                if (strArr.length == 0) {
                    throw m34573a("@Headers annotation is empty.", new Object[0]);
                }
                this.f27272p = m34567a(strArr);
            }
        }

        /* renamed from: a */
        private SubmitAdapter<R, T> m34571a(Method method) {
            Type genericReturnType = method.getGenericReturnType();
            if (TypeUtils.hasUnresolvableType(genericReturnType)) {
                throw m34573a("Method return type must not include a type variable or wildcard: " + genericReturnType, new Object[0]);
            }
            if (genericReturnType == Void.TYPE) {
                throw m34573a("Service methods cannot return void.", new Object[0]);
            }
            try {
                return (SubmitAdapter<R, T>) this.f27257a.submitAdapter(genericReturnType, this.f27259c);
            } catch (RuntimeException e10) {
                throw this.m34575a(e10, "Unable to create submit adapter for " + genericReturnType, new Object[0]);
            }
        }

        /* renamed from: b */
        private Object m34585b(Annotation annotation) {
            String str;
            try {
                return annotation.annotationType().getMethod("value", new Class[0]).invoke(annotation, new Object[0]);
            } catch (IllegalAccessException unused) {
                str = "IllegalAccessException";
                Logger.m32145w(C5983k6.f27245o, str);
                throw new IllegalStateException("get annotation value error:" + annotation.getClass().getSimpleName());
            } catch (NoSuchMethodException unused2) {
                str = "NoSuchMethodException";
                Logger.m32145w(C5983k6.f27245o, str);
                throw new IllegalStateException("get annotation value error:" + annotation.getClass().getSimpleName());
            } catch (InvocationTargetException unused3) {
                str = "InvocationTargetException";
                Logger.m32145w(C5983k6.f27245o, str);
                throw new IllegalStateException("get annotation value error:" + annotation.getClass().getSimpleName());
            }
        }

        /* renamed from: a */
        private RuntimeException m34572a(int i10, String str) {
            return m34573a(str + " (parameter #" + (i10 + 1) + ")", new Object[0]);
        }

        /* renamed from: b */
        private void m34586b(int i10, String str) {
            if (!C5983k6.f27244n.matcher(str).matches()) {
                throw m34572a(i10, StringUtils.format("@Path parameter name must match %s. Found: %s", C5983k6.f27243m.pattern(), str));
            }
            if (!this.f27274r.contains(str)) {
                throw m34572a(i10, StringUtils.format("URL \"%s\" does not contain \"{%s}\".", this.f27271o, str));
            }
        }

        /* renamed from: a */
        private RuntimeException m34573a(String str, Object... objArr) {
            return m34575a((Throwable) null, str, objArr);
        }

        /* renamed from: a */
        private RuntimeException m34574a(Throwable th2, int i10, String str) {
            return m34575a(th2, str + " (parameter #" + (i10 + 1) + ")", new Object[0]);
        }

        /* renamed from: a */
        private RuntimeException m34575a(Throwable th2, String str, Object... objArr) {
            return new IllegalArgumentException(StringUtils.format(str, objArr) + "    for method: " + this.f27258b.getDeclaringClass().getSimpleName() + "." + this.f27258b.getName(), th2);
        }

        /* renamed from: a */
        private void m34576a() {
            if (this.f27271o == null && !this.f27267k) {
                throw m34573a("Missing either @%s URL or @Url parameter.", this.f27268l);
            }
            boolean z10 = this.f27270n;
            if (!z10 && !this.f27269m && this.f27264h) {
                throw m34573a("Non-body HTTP method cannot contain @Body.", new Object[0]);
            }
            if (z10 && !this.f27263g) {
                throw m34573a("Form-encoded method must contain at least one @Field.", new Object[0]);
            }
        }

        /* renamed from: a */
        private void m34577a(String str, String str2, boolean z10) {
            String str3 = this.f27268l;
            if (str3 != null) {
                throw m34573a("Only one HTTP method is allowed. Found: %s and %s.", str3, str);
            }
            this.f27268l = str;
            this.f27269m = z10;
            if (str2.isEmpty()) {
                return;
            }
            int iIndexOf = str2.indexOf(63);
            if (iIndexOf != -1 && iIndexOf < str2.length() - 1) {
                String strSubstring = str2.substring(iIndexOf + 1);
                if (C5983k6.f27243m.matcher(strSubstring).find()) {
                    throw m34573a("URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", strSubstring);
                }
            }
            this.f27271o = str2;
            this.f27274r = C5983k6.m34562b(str2);
        }

        /* renamed from: a */
        private boolean m34579a(Annotation annotation) {
            String str;
            try {
                return ((Boolean) annotation.annotationType().getMethod("encoded", new Class[0]).invoke(annotation, new Object[0])).booleanValue();
            } catch (IllegalAccessException unused) {
                str = "IllegalAccessException";
                Logger.m32145w(C5983k6.f27245o, str);
                return false;
            } catch (NoSuchMethodException unused2) {
                str = "NoSuchMethodException";
                Logger.m32145w(C5983k6.f27245o, str);
                return false;
            } catch (InvocationTargetException unused3) {
                str = "InvocationTargetException";
                Logger.m32145w(C5983k6.f27245o, str);
                return false;
            }
        }

        /* renamed from: a */
        private boolean m34580a(Annotation annotation, String str) {
            return annotation.annotationType().getSimpleName().equals(str);
        }
    }

    public C5983k6(b<R, T> bVar) {
        this.f27246a = bVar.f27277u;
        this.f27255j = bVar.f27257a.getBaseUrl();
        this.f27247b = bVar.f27276t;
        this.f27248c = bVar.f27268l;
        this.f27249d = bVar.f27271o;
        this.f27250e = bVar.f27272p;
        this.f27251f = bVar.f27273q;
        this.f27252g = bVar.f27269m;
        this.f27253h = bVar.f27270n;
        this.f27254i = bVar.f27275s;
        this.f27256k = bVar.f27279w;
    }

    /* renamed from: b */
    public static Set<String> m34562b(String str) {
        Matcher matcher = f27243m.matcher(str);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (matcher.find()) {
            linkedHashSet.add(matcher.group(1));
        }
        return linkedHashSet;
    }

    /* renamed from: a */
    public Request m34564a(Submit.Factory factory, Object... objArr) throws IOException {
        C5970j6 c5970j6 = new C5970j6(factory, this.f27248c, this.f27255j, this.f27249d, this.f27250e, this.f27251f, this.f27252g, this.f27253h, this.f27256k);
        AbstractC5931g6<?>[] abstractC5931g6Arr = this.f27254i;
        int length = objArr != null ? objArr.length : 0;
        if (abstractC5931g6Arr == null) {
            throw new IllegalArgumentException("parameterHandlers is null");
        }
        if (length == abstractC5931g6Arr.length) {
            for (int i10 = 0; i10 < length; i10++) {
                abstractC5931g6Arr[i10].mo34304a(c5970j6, objArr[i10]);
            }
            return c5970j6.m34507a();
        }
        throw new IllegalArgumentException("Argument count (" + length + ") doesn't match expected count (" + abstractC5931g6Arr.length + ")");
    }

    /* renamed from: a */
    public R m34565a(ResponseBody responseBody) throws IOException {
        return this.f27247b.convert(responseBody);
    }

    /* renamed from: a */
    public T m34566a(Submit<R> submit) {
        return this.f27246a.adapt2(submit);
    }
}
