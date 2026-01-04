package com.huawei.hms.framework.network.restclient.hwhttp;

import com.huawei.hms.framework.common.CheckParamUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.cache.Cache;
import com.huawei.hms.framework.network.restclient.hianalytics.RCEventListener;
import com.huawei.hms.framework.network.restclient.hwhttp.ClientConfiguration;
import com.huawei.hms.framework.network.restclient.hwhttp.Submit;
import com.huawei.hms.framework.network.restclient.hwhttp.dns.dnresolver.dnkeeper.DNKeeper;
import com.huawei.hms.framework.network.restclient.proxy.new2old.DynamicResponseSubmit;
import com.huawei.hms.framework.network.restclient.proxy.new2old.ProxyRequest;
import com.huawei.hms.framework.network.restclient.proxy.new2old.ProxyWebSocketListener;
import com.huawei.hms.framework.network.restclient.proxy.old2new.ProxyInterceptor;
import com.huawei.hms.framework.network.restclient.proxy.old2new.ProxyWebSocket;
import com.huawei.hms.framework.network.restclient.websocket.WebSocket;
import com.huawei.hms.framework.network.restclient.websocket.WebSocketListener;
import com.huawei.hms.network.httpclient.HttpClient;
import com.huawei.hms.network.httpclient.internal.IHttpClientBuilder;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
/* loaded from: classes8.dex */
public class HttpClient implements Submit.Factory {
    private static final String TAG = "HttpClient";
    private Cache cache;
    private ClientConfiguration configuration;
    private HostnameVerifier hostnameVerifier;
    private List<Interceptor> interceptors;
    private List<Interceptor> networkInterceptors;
    private final com.huawei.hms.network.httpclient.HttpClient proxyHttpClient;
    private boolean quicEnabled;
    private SSLSocketFactory sslSocketFactory;
    private X509TrustManager trustManager;

    public /* synthetic */ HttpClient(Builder builder, com.huawei.hms.network.httpclient.HttpClient httpClient, C54931 c54931) {
        this(builder, httpClient);
    }

    public Cache getCache() {
        return this.cache;
    }

    public ClientConfiguration getClientConfiguration() {
        return this.configuration;
    }

    public int getConnectTimeout() {
        return this.configuration.getConnectTimeout();
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public List<Interceptor> getInterceptors() {
        return this.interceptors;
    }

    public List<Interceptor> getNetworkInterceptors() {
        return this.networkInterceptors;
    }

    public int getPingInterval() {
        return this.configuration.getPingInterval();
    }

    public com.huawei.hms.network.httpclient.HttpClient getProxyHttpClient() {
        return this.proxyHttpClient;
    }

    public int getReadTimeout() {
        return this.configuration.getReadTimeout();
    }

    public int getRetryTimeOnConnectionFailure() {
        return this.configuration.getRetryTimeOnConnectionFailure();
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    public X509TrustManager getTrustManager() {
        return this.trustManager;
    }

    public int getWriteTimeout() {
        return this.configuration.getWriteTimeout();
    }

    public Builder newBuilder() {
        return new Builder(this.proxyHttpClient.newBuilder());
    }

    @Override // com.huawei.hms.framework.network.restclient.hwhttp.Submit.Factory
    public Submit newSubmit(Request request) {
        DynamicResponseSubmit dynamicResponseSubmit = new DynamicResponseSubmit();
        com.huawei.hms.network.httpclient.HttpClient httpClient = this.proxyHttpClient;
        dynamicResponseSubmit.setSubmit(httpClient.newSubmit(ProxyRequest.request2New(httpClient, request)));
        return dynamicResponseSubmit;
    }

    public WebSocket newWebSocket(Request request, WebSocketListener webSocketListener) {
        com.huawei.hms.network.httpclient.HttpClient httpClient = this.proxyHttpClient;
        return new ProxyWebSocket(httpClient.newWebSocket(ProxyRequest.request2New(httpClient, request), new ProxyWebSocketListener(webSocketListener)));
    }

    public boolean quicEnabled() {
        return this.quicEnabled;
    }

    @Deprecated
    public static final class Builder {
        private Cache cache;
        private ClientConfiguration.Builder configBuilder;
        private HostnameVerifier hostnameVerifier;
        private List<Interceptor> interceptors;
        private List<Interceptor> networkInterceptors;
        private JSONObject options;
        private IHttpClientBuilder proxyBuilder;
        private List<ProxyInterceptor> proxyInterceptors;
        private boolean quicEnabled;
        private SSLSocketFactory sslSocketFactory;
        private X509TrustManager trustManager;

        public Builder() {
            this.interceptors = new ArrayList();
            this.networkInterceptors = new ArrayList();
            this.proxyInterceptors = new ArrayList();
            this.configBuilder = new ClientConfiguration.Builder();
            this.options = new JSONObject();
            this.proxyBuilder = new HttpClient.Builder();
        }

        private void parseRequestConfig(ClientConfiguration clientConfiguration) throws JSONException {
            try {
                this.options.put("core_call_timeout", clientConfiguration.getCallTimeout());
                this.options.put("core_connect_timeout", clientConfiguration.getConnectTimeout());
                this.options.put("core_concurrent_connect_delay", clientConfiguration.getConnectionAttemptDelay());
                this.options.put("core_ping_interval", clientConfiguration.getPingInterval());
                this.options.put("core_read_timeout", clientConfiguration.getReadTimeout());
                this.options.put("core_write_timeout", clientConfiguration.getWriteTimeout());
                this.options.put("core_retry_time", clientConfiguration.getRetryTimeOnConnectionFailure());
            } catch (JSONException unused) {
                Logger.m32145w(HttpClient.TAG, "JSONException error");
            }
        }

        public Builder addInterceptor(Interceptor interceptor) {
            if (interceptor == null) {
                throw new IllegalArgumentException("interceptor == null");
            }
            this.interceptors.add(interceptor);
            ProxyInterceptor proxyInterceptor = new ProxyInterceptor(interceptor);
            this.proxyInterceptors.add(proxyInterceptor);
            this.proxyBuilder.addInterceptor(proxyInterceptor);
            return this;
        }

        public Builder addNetworkInterceptor(com.huawei.hms.network.httpclient.Interceptor interceptor) {
            if (interceptor == null) {
                throw new IllegalArgumentException("interceptor == null");
            }
            this.proxyBuilder.addNetworkInterceptor(interceptor);
            return this;
        }

        public HttpClient build() {
            JSONObject jSONObject = this.options;
            if (jSONObject != null) {
                this.proxyBuilder.options(jSONObject.toString());
            }
            com.huawei.hms.network.httpclient.HttpClient httpClientBuild = this.proxyBuilder.build();
            Iterator<ProxyInterceptor> it = this.proxyInterceptors.iterator();
            while (it.hasNext()) {
                it.next().setHttpClient(httpClientBuild);
            }
            return new HttpClient(this, httpClientBuild);
        }

        public Builder cache(Cache cache) {
            if (cache != null) {
                this.proxyBuilder.cache(cache.getDirectory(), cache.getMaxSize());
                this.cache = cache;
            } else {
                Logger.m32145w(HttpClient.TAG, "cache is null or android sdk version less than 23");
            }
            return this;
        }

        public Builder callTimeout(int i10) {
            this.configBuilder.callTimeout(i10);
            this.proxyBuilder.callTimeout(i10);
            return this;
        }

        public Builder clientConfiguration(ClientConfiguration.Builder builder) throws JSONException {
            CheckParamUtils.checkNotNull(builder, "clientConfiguration == null");
            this.configBuilder = builder;
            parseRequestConfig(builder.build());
            return this;
        }

        public Builder connectTimeout(int i10) {
            this.configBuilder.connectTimeout(i10);
            this.proxyBuilder.connectTimeout(i10);
            return this;
        }

        @Deprecated
        public Builder dnKeeper(DNKeeper dNKeeper) {
            Logger.m32145w(HttpClient.TAG, "This deprecated method setting is invalid");
            return this;
        }

        public Builder enableQuic(boolean z10) {
            this.quicEnabled = z10;
            this.proxyBuilder.enableQuic(z10);
            return this;
        }

        @Deprecated
        public Builder eventListenerFactory(RCEventListener.Factory factory) {
            Logger.m32145w(HttpClient.TAG, "This deprecated method setting is invalid");
            return this;
        }

        public Builder hostnameVerifier(HostnameVerifier hostnameVerifier) {
            CheckParamUtils.checkNotNull(hostnameVerifier, "hostnameVerifier == null");
            this.hostnameVerifier = hostnameVerifier;
            this.proxyBuilder.hostnameVerifier(hostnameVerifier);
            return this;
        }

        public Builder isReportable(boolean z10) throws JSONException {
            try {
                this.options.put("core_enable_plaintext_url_path", z10);
            } catch (JSONException unused) {
                Logger.m32145w(HttpClient.TAG, "httpclient isReportable catch a JSONException");
            }
            return this;
        }

        public Builder pingInterval(int i10) {
            this.configBuilder.pingInterval(i10);
            this.proxyBuilder.pingInterval(i10);
            return this;
        }

        public Builder proxy(Proxy proxy) {
            this.proxyBuilder.proxy(proxy);
            return this;
        }

        public Builder readTimeout(int i10) {
            this.configBuilder.readTimeout(i10);
            this.proxyBuilder.readTimeout(i10);
            return this;
        }

        public Builder retryTimeOnConnectionFailure(int i10) {
            this.configBuilder.retryTimeOnConnectionFailure(i10);
            this.proxyBuilder.retryTimeOnConnectionFailure(i10);
            return this;
        }

        public Builder sslSocketFactory(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            CheckParamUtils.checkNotNull(sSLSocketFactory, "sslSocketFactory == null");
            CheckParamUtils.checkNotNull(x509TrustManager, "trustManager == null");
            this.sslSocketFactory = sSLSocketFactory;
            this.trustManager = x509TrustManager;
            this.proxyBuilder.sslSocketFactory(sSLSocketFactory, x509TrustManager);
            return this;
        }

        public Builder weakNetworkRetryEnable(boolean z10) throws JSONException {
            try {
                this.options.put("core_disable_weaknetwork_retry", z10);
            } catch (JSONException unused) {
                Logger.m32145w(HttpClient.TAG, "httpclient weakNetworkRetryEnable catch a JSONException");
            }
            return this;
        }

        public Builder writeTimeout(int i10) {
            this.configBuilder.writeTimeout(i10);
            this.proxyBuilder.writeTimeout(i10);
            return this;
        }

        public Builder addNetworkInterceptor(Interceptor interceptor) {
            if (interceptor != null) {
                this.networkInterceptors.add(interceptor);
                ProxyInterceptor proxyInterceptor = new ProxyInterceptor(interceptor);
                this.proxyInterceptors.add(proxyInterceptor);
                this.proxyBuilder.addNetworkInterceptor(proxyInterceptor);
                return this;
            }
            throw new IllegalArgumentException("interceptor == null");
        }

        public Builder addInterceptor(com.huawei.hms.network.httpclient.Interceptor interceptor) {
            if (interceptor != null) {
                this.proxyBuilder.addInterceptor(interceptor);
                return this;
            }
            throw new IllegalArgumentException("interceptor == null");
        }

        public Builder(IHttpClientBuilder iHttpClientBuilder) {
            this.interceptors = new ArrayList();
            this.networkInterceptors = new ArrayList();
            this.proxyInterceptors = new ArrayList();
            this.configBuilder = new ClientConfiguration.Builder();
            this.options = new JSONObject();
            this.proxyBuilder = iHttpClientBuilder;
        }
    }

    private HttpClient(Builder builder, com.huawei.hms.network.httpclient.HttpClient httpClient) {
        this.interceptors = builder.interceptors;
        this.networkInterceptors = builder.networkInterceptors;
        this.configuration = builder.configBuilder.build();
        this.sslSocketFactory = builder.sslSocketFactory;
        this.trustManager = builder.trustManager;
        this.hostnameVerifier = builder.hostnameVerifier;
        this.quicEnabled = builder.quicEnabled;
        this.cache = builder.cache;
        this.proxyHttpClient = httpClient;
    }
}
