package com.huawei.hms.network.httpclient.internal;

import com.huawei.hms.network.httpclient.HttpClient;
import com.huawei.hms.network.httpclient.Interceptor;
import java.net.Proxy;
import java.net.ProxySelector;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes8.dex */
public abstract class IHttpClientBuilder {
    public abstract IHttpClientBuilder addInterceptor(Interceptor interceptor);

    public abstract IHttpClientBuilder addNetworkInterceptor(Interceptor interceptor);

    public abstract HttpClient build();

    public abstract IHttpClientBuilder cache(String str, long j10);

    public abstract IHttpClientBuilder callTimeout(int i10);

    public abstract IHttpClientBuilder connectTimeout(int i10);

    public abstract IHttpClientBuilder enableQuic(boolean z10);

    public abstract IHttpClientBuilder hostnameVerifier(HostnameVerifier hostnameVerifier);

    public abstract IHttpClientBuilder options(String str);

    public abstract IHttpClientBuilder pingInterval(int i10);

    public abstract IHttpClientBuilder proxy(Proxy proxy);

    public abstract IHttpClientBuilder proxySelector(ProxySelector proxySelector);

    public abstract IHttpClientBuilder readTimeout(int i10);

    public abstract IHttpClientBuilder retryTimeOnConnectionFailure(int i10);

    public abstract IHttpClientBuilder sslSocketFactory(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager);

    public abstract IHttpClientBuilder writeTimeout(int i10);
}
