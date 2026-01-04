package com.huawei.hms.network.httpclient;

import com.huawei.hms.network.NetworkKitProvider;
import com.huawei.hms.network.httpclient.Request;
import com.huawei.hms.network.httpclient.Submit;
import com.huawei.hms.network.httpclient.internal.IHttpClientBuilder;
import com.huawei.hms.network.httpclient.websocket.WebSocket;
import com.huawei.hms.network.httpclient.websocket.WebSocketListener;
import java.net.Proxy;
import java.net.ProxySelector;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes8.dex */
public abstract class HttpClient extends Submit.Factory {

    public static final class Builder extends IHttpClientBuilder {
        IHttpClientBuilder delegateBuilder = NetworkKitProvider.getEnableProvider().createHttpClientBuilder();

        @Override // com.huawei.hms.network.httpclient.internal.IHttpClientBuilder
        public Builder addInterceptor(Interceptor interceptor) {
            this.delegateBuilder.addInterceptor(interceptor);
            return this;
        }

        @Override // com.huawei.hms.network.httpclient.internal.IHttpClientBuilder
        public Builder addNetworkInterceptor(Interceptor interceptor) {
            this.delegateBuilder.addNetworkInterceptor(interceptor);
            return this;
        }

        @Override // com.huawei.hms.network.httpclient.internal.IHttpClientBuilder
        public HttpClient build() {
            return this.delegateBuilder.build();
        }

        @Override // com.huawei.hms.network.httpclient.internal.IHttpClientBuilder
        public Builder cache(String str, long j10) {
            this.delegateBuilder.cache(str, j10);
            return this;
        }

        @Override // com.huawei.hms.network.httpclient.internal.IHttpClientBuilder
        public Builder callTimeout(int i10) {
            this.delegateBuilder.callTimeout(i10);
            return this;
        }

        @Override // com.huawei.hms.network.httpclient.internal.IHttpClientBuilder
        public Builder connectTimeout(int i10) {
            this.delegateBuilder.connectTimeout(i10);
            return this;
        }

        @Override // com.huawei.hms.network.httpclient.internal.IHttpClientBuilder
        public Builder enableQuic(boolean z10) {
            this.delegateBuilder.enableQuic(z10);
            return this;
        }

        @Override // com.huawei.hms.network.httpclient.internal.IHttpClientBuilder
        public Builder hostnameVerifier(HostnameVerifier hostnameVerifier) {
            this.delegateBuilder.hostnameVerifier(hostnameVerifier);
            return this;
        }

        @Override // com.huawei.hms.network.httpclient.internal.IHttpClientBuilder
        public Builder options(String str) {
            this.delegateBuilder.options(str);
            return this;
        }

        @Override // com.huawei.hms.network.httpclient.internal.IHttpClientBuilder
        public Builder pingInterval(int i10) {
            this.delegateBuilder.pingInterval(i10);
            return this;
        }

        @Override // com.huawei.hms.network.httpclient.internal.IHttpClientBuilder
        public Builder proxy(Proxy proxy) {
            this.delegateBuilder.proxy(proxy);
            return this;
        }

        @Override // com.huawei.hms.network.httpclient.internal.IHttpClientBuilder
        public Builder proxySelector(ProxySelector proxySelector) {
            this.delegateBuilder.proxySelector(proxySelector);
            return this;
        }

        @Override // com.huawei.hms.network.httpclient.internal.IHttpClientBuilder
        public Builder readTimeout(int i10) {
            this.delegateBuilder.readTimeout(i10);
            return this;
        }

        @Override // com.huawei.hms.network.httpclient.internal.IHttpClientBuilder
        public Builder retryTimeOnConnectionFailure(int i10) {
            this.delegateBuilder.retryTimeOnConnectionFailure(i10);
            return this;
        }

        @Override // com.huawei.hms.network.httpclient.internal.IHttpClientBuilder
        public Builder sslSocketFactory(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            this.delegateBuilder.sslSocketFactory(sSLSocketFactory, x509TrustManager);
            return this;
        }

        @Override // com.huawei.hms.network.httpclient.internal.IHttpClientBuilder
        public Builder writeTimeout(int i10) {
            this.delegateBuilder.writeTimeout(i10);
            return this;
        }
    }

    public abstract IHttpClientBuilder newBuilder();

    public abstract Request.Builder newRequest();

    @Override // com.huawei.hms.network.httpclient.Submit.Factory
    public abstract Submit<ResponseBody> newSubmit(Request request);

    public abstract WebSocket newWebSocket(Request request, WebSocketListener webSocketListener);
}
