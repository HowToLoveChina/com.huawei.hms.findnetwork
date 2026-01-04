package com.huawei.hms.network.embedded;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.base.common.Headers;
import com.huawei.hms.network.embedded.C5939h1;
import com.huawei.hms.network.httpclient.Request;
import com.huawei.hms.network.httpclient.RequestBody;
import com.huawei.hms.network.httpclient.config.NetworkConfig;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.hms.network.embedded.c1 */
/* loaded from: classes8.dex */
public class C5872c1 extends Request {

    /* renamed from: g */
    public static final String f26548g = "RequestImpl";

    /* renamed from: a */
    public String f26549a;

    /* renamed from: b */
    public C5888d3 f26550b;

    /* renamed from: c */
    public Headers f26551c;

    /* renamed from: d */
    public C5939h1.e f26552d;

    /* renamed from: e */
    public NetworkConfig f26553e;

    /* renamed from: f */
    public Object f26554f;

    /* renamed from: com.huawei.hms.network.embedded.c1$b */
    public static final class b extends Request.Builder {

        /* renamed from: b */
        public C5888d3 f26556b;

        /* renamed from: d */
        public C5939h1.e f26558d;

        /* renamed from: f */
        public Object f26560f;

        /* renamed from: a */
        public String f26555a = "GET";

        /* renamed from: c */
        public Headers.Builder f26557c = new Headers.Builder();

        /* renamed from: e */
        public NetworkConfig f26559e = new NetworkConfig(null);

        @Override // com.huawei.hms.network.httpclient.Request.Builder
        public b addHeader(String str, String str2) {
            this.f26557c.add(str, str2);
            return this;
        }

        @Override // com.huawei.hms.network.httpclient.Request.Builder
        public Request build() {
            return new C5939h1.d(new C5872c1(this));
        }

        public b headers(Headers.Builder builder) {
            this.f26557c = builder;
            return this;
        }

        @Override // com.huawei.hms.network.httpclient.Request.Builder
        public b method(String str) {
            this.f26555a = str;
            return this;
        }

        @Override // com.huawei.hms.network.httpclient.Request.Builder
        public b options(String str) {
            if (TextUtils.isEmpty(str)) {
                Logger.m32145w(C5872c1.f26548g, "Request Builder options == null");
                return this;
            }
            this.f26559e.setOption(str);
            return this;
        }

        @Override // com.huawei.hms.network.httpclient.Request.Builder
        public b removeHeader(String str) {
            this.f26557c.removeAll(str);
            return this;
        }

        @Override // com.huawei.hms.network.httpclient.Request.Builder
        public b requestBody(RequestBody requestBody) {
            if (requestBody == null || (requestBody instanceof C5939h1.e)) {
                this.f26558d = (C5939h1.e) requestBody;
            } else {
                this.f26558d = new C5939h1.e(requestBody);
            }
            return this;
        }

        @Override // com.huawei.hms.network.httpclient.Request.Builder
        public b tag(Object obj) {
            this.f26560f = obj;
            return this;
        }

        public b url(C5888d3 c5888d3) {
            this.f26556b = c5888d3;
            return this;
        }

        @Override // com.huawei.hms.network.httpclient.Request.Builder
        public b url(String str) {
            this.f26556b = new C5888d3(str);
            return this;
        }
    }

    public C5872c1(b bVar) {
        this.f26549a = bVar.f26555a;
        this.f26550b = bVar.f26556b;
        this.f26551c = bVar.f26557c.build();
        this.f26552d = bVar.f26558d;
        this.f26553e = bVar.f26559e;
        this.f26554f = bVar.f26560f;
    }

    @Override // com.huawei.hms.network.httpclient.Request
    public RequestBody getBody() {
        return this.f26552d;
    }

    @Override // com.huawei.hms.network.httpclient.Request
    public Map<String, List<String>> getHeaders() {
        return this.f26551c.toMultimap();
    }

    public C5888d3 getHttpUrl() {
        return this.f26550b;
    }

    @Override // com.huawei.hms.network.httpclient.Request
    public String getMethod() {
        return this.f26549a;
    }

    @Override // com.huawei.hms.network.httpclient.Request
    public String getOptions() {
        return this.f26553e.toString();
    }

    @Override // com.huawei.hms.network.httpclient.Request
    public Object getTag() {
        return this.f26554f;
    }

    @Override // com.huawei.hms.network.httpclient.Request
    public String getUrl() {
        return this.f26550b.getUrl();
    }

    @Override // com.huawei.hms.network.httpclient.Request
    public b newBuilder() {
        b bVar = new b();
        bVar.f26555a = this.f26549a;
        bVar.f26556b = this.f26550b;
        bVar.f26557c = this.f26551c.newBuilder();
        bVar.f26558d = this.f26552d;
        bVar.f26559e = new NetworkConfig(this.f26553e.configObj.toString());
        bVar.f26560f = this.f26554f;
        return bVar;
    }

    public String toString() {
        return super.toString();
    }

    public /* synthetic */ C5872c1(b bVar, a aVar) {
        this(bVar);
    }
}
