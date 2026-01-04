package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.network.base.common.Headers;
import com.huawei.hms.network.embedded.C5939h1;
import com.huawei.hms.network.httpclient.Response;
import com.huawei.hms.network.httpclient.ResponseBody;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.hms.network.embedded.u0 */
/* loaded from: classes8.dex */
public class C6107u0<T> extends Response<T> {

    /* renamed from: g */
    public static final int f28443g = 100;

    /* renamed from: a */
    public T f28444a;

    /* renamed from: b */
    public C5939h1.g f28445b;

    /* renamed from: c */
    public Map<String, List<String>> f28446c;

    /* renamed from: d */
    public int f28447d;

    /* renamed from: e */
    public String f28448e;

    /* renamed from: f */
    public String f28449f;

    /* renamed from: com.huawei.hms.network.embedded.u0$b */
    public static class b<T> {

        /* renamed from: a */
        public T f28450a;

        /* renamed from: b */
        public C5939h1.g f28451b;

        /* renamed from: c */
        public Map<String, List<String>> f28452c;

        /* renamed from: d */
        public int f28453d;

        /* renamed from: e */
        public String f28454e;

        /* renamed from: f */
        public String f28455f;

        public b() {
        }

        public b(C6107u0<T> c6107u0) {
            this.f28450a = (T) c6107u0.f28444a;
            this.f28452c = c6107u0.f28446c;
            this.f28453d = c6107u0.f28447d;
            this.f28454e = c6107u0.f28448e;
            this.f28455f = c6107u0.f28449f;
            this.f28451b = c6107u0.f28445b;
        }

        public b body(T t10) {
            this.f28450a = t10;
            return this;
        }

        public C6107u0<T> build() {
            return new C6107u0<>(this);
        }

        public b code(int i10) {
            this.f28453d = i10;
            return this;
        }

        public b errorBody(ResponseBody responseBody) {
            if (responseBody == null || (responseBody instanceof C5939h1.g)) {
                this.f28451b = (C5939h1.g) responseBody;
            } else {
                this.f28451b = new C5939h1.g(responseBody);
            }
            return this;
        }

        public b headers(Map<String, List<String>> map) {
            this.f28452c = map;
            return this;
        }

        public b message(String str) {
            this.f28454e = str;
            return this;
        }

        public b url(String str) {
            this.f28455f = str;
            return this;
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.u0$c */
    public static class c<T> extends Response.Builder<T> {

        /* renamed from: a */
        public T f28456a;

        /* renamed from: b */
        public C5939h1.g f28457b;

        /* renamed from: c */
        public Map<String, List<String>> f28458c;

        /* renamed from: d */
        public int f28459d;

        /* renamed from: e */
        public String f28460e;

        /* renamed from: f */
        public String f28461f;

        public c() {
        }

        @Override // com.huawei.hms.network.httpclient.Response.Builder
        public Response.Builder body(T t10) {
            this.f28456a = t10;
            return this;
        }

        @Override // com.huawei.hms.network.httpclient.Response.Builder
        public Response<T> build() {
            return new C6107u0(this);
        }

        @Override // com.huawei.hms.network.httpclient.Response.Builder
        public Response.Builder code(int i10) {
            this.f28459d = i10;
            return this;
        }

        @Override // com.huawei.hms.network.httpclient.Response.Builder
        public Response.Builder errorBody(ResponseBody responseBody) {
            if (responseBody == null || (responseBody instanceof C5939h1.g)) {
                this.f28457b = (C5939h1.g) responseBody;
            } else {
                this.f28457b = new C5939h1.g(responseBody);
            }
            return this;
        }

        @Override // com.huawei.hms.network.httpclient.Response.Builder
        public Response.Builder headers(Map<String, List<String>> map) {
            this.f28458c = map;
            return this;
        }

        @Override // com.huawei.hms.network.httpclient.Response.Builder
        public Response.Builder message(String str) {
            this.f28460e = str;
            return this;
        }

        @Override // com.huawei.hms.network.httpclient.Response.Builder
        public Response.Builder url(String str) {
            this.f28461f = str;
            return this;
        }

        public c(C6107u0<T> c6107u0) {
            this.f28456a = (T) c6107u0.f28444a;
            this.f28458c = c6107u0.f28446c;
            this.f28459d = c6107u0.f28447d;
            this.f28460e = c6107u0.f28448e;
            this.f28461f = c6107u0.f28449f;
            this.f28457b = c6107u0.f28445b;
        }
    }

    public C6107u0(b<T> bVar) {
        this.f28444a = (T) bVar.f28450a;
        this.f28445b = bVar.f28451b;
        this.f28446c = bVar.f28452c;
        this.f28447d = bVar.f28453d;
        this.f28448e = bVar.f28454e;
        this.f28449f = bVar.f28455f;
        m35481s();
    }

    public static boolean hasBody(Response<ResponseBody> response) {
        int code = response.getCode();
        if ((code < 100 || code >= 200) && code != 204 && code != 304) {
            return true;
        }
        Headers headersM33636of = Headers.m33636of(response.getHeaders());
        String str = headersM33636of.get("Content-Length");
        return !(str.isEmpty() || StringUtils.stringToLong(str, -1L) == -1) || "chunked".equalsIgnoreCase(headersM33636of.get("Transfer-Encoding"));
    }

    /* renamed from: s */
    private void m35481s() {
        if (this.f28445b == null && (this.f28444a instanceof C5939h1.g) && !isSuccessful()) {
            this.f28445b = (C5939h1.g) this.f28444a;
            this.f28444a = null;
        }
    }

    @Override // com.huawei.hms.network.httpclient.Response, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        T t10 = this.f28444a;
        if (t10 instanceof Closeable) {
            ((Closeable) t10).close();
            this.f28444a = null;
        }
        C5939h1.g gVar = this.f28445b;
        if (gVar != null) {
            gVar.close();
            this.f28445b = null;
        }
    }

    @Override // com.huawei.hms.network.httpclient.Response
    public Response.Builder createBuilder() {
        return new c(this);
    }

    @Override // com.huawei.hms.network.httpclient.Response
    public T getBody() {
        return this.f28444a;
    }

    @Override // com.huawei.hms.network.httpclient.Response
    public int getCode() {
        return this.f28447d;
    }

    @Override // com.huawei.hms.network.httpclient.Response
    public ResponseBody getErrorBody() {
        return this.f28445b;
    }

    @Override // com.huawei.hms.network.httpclient.Response
    public Map<String, List<String>> getHeaders() {
        return this.f28446c;
    }

    @Override // com.huawei.hms.network.httpclient.Response
    public String getMessage() {
        return this.f28448e;
    }

    @Override // com.huawei.hms.network.httpclient.Response
    public String getUrl() {
        return this.f28449f;
    }

    public b newBuilder() {
        return new b(this);
    }

    public /* synthetic */ C6107u0(b bVar, a aVar) {
        this(bVar);
    }

    public C6107u0(c<T> cVar) {
        this.f28444a = (T) cVar.f28456a;
        this.f28445b = cVar.f28457b;
        this.f28446c = cVar.f28458c;
        this.f28447d = cVar.f28459d;
        this.f28448e = cVar.f28460e;
        this.f28449f = cVar.f28461f;
        m35481s();
    }

    public /* synthetic */ C6107u0(c cVar, a aVar) {
        this(cVar);
    }
}
