package com.huawei.hms.network.file.api;

import android.text.TextUtils;
import com.huawei.hms.network.file.api.RequestConfig;
import com.huawei.hms.network.file.core.util.Utils;
import com.huawei.hms.network.httpclient.HttpClient;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes8.dex */
public final class GlobalRequestConfig extends RequestConfig {
    private static final long serialVersionUID = 3404424470299275251L;
    private final transient HostnameVerifier hostnameVerifier;
    private final transient HttpClient httpClient;
    private boolean oldInterfaceFlag;
    private String options;
    private final List<String> quicHints;
    private final transient SSLSocketFactory sslSocketFactory;
    private final int threadPoolSize;
    private final transient X509TrustManager trustManager;

    public static final class Builder extends RequestConfig.Builder<Builder> {
        private HostnameVerifier hostnameVerifier;
        private HttpClient httpClient;
        private boolean oldInterfaceFlag;
        private String options;
        private List<String> quicHints;
        private SSLSocketFactory sslSocketFactory;
        private int threadPoolSize;
        private X509TrustManager trustManager;

        public Builder() {
            this.threadPoolSize = -100;
            this.quicHints = new ArrayList();
        }

        @Override // com.huawei.hms.network.file.api.RequestConfig.Builder
        public GlobalRequestConfig build() {
            return new GlobalRequestConfig(this);
        }

        public Builder hostnameVerifier(HostnameVerifier hostnameVerifier) {
            this.hostnameVerifier = hostnameVerifier;
            return this;
        }

        @Deprecated
        public Builder httpClient(HttpClient httpClient) {
            this.httpClient = httpClient;
            return this;
        }

        @Deprecated
        public Builder oldInterfaceFlag(boolean z10) {
            this.oldInterfaceFlag = z10;
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.huawei.hms.network.file.api.RequestConfig.Builder
        public Builder options(String str) {
            this.options = str;
            return this;
        }

        public Builder quicHints(List<String> list) {
            if (!Utils.isEmpty(list)) {
                this.quicHints.addAll(list);
            }
            return this;
        }

        public Builder sslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            this.sslSocketFactory = sSLSocketFactory;
            return this;
        }

        public Builder threadPoolSize(int i10) {
            this.threadPoolSize = Utils.getCheckRangeResult("threadPoolSize", i10, true, true);
            return this;
        }

        public Builder trustManager(X509TrustManager x509TrustManager) {
            this.trustManager = x509TrustManager;
            return this;
        }

        public Builder(GlobalRequestConfig globalRequestConfig) {
            super(globalRequestConfig);
            this.threadPoolSize = globalRequestConfig.threadPoolSize;
            this.sslSocketFactory = globalRequestConfig.sslSocketFactory;
            this.hostnameVerifier = globalRequestConfig.hostnameVerifier;
            this.trustManager = globalRequestConfig.trustManager;
            this.httpClient = globalRequestConfig.httpClient;
            this.oldInterfaceFlag = globalRequestConfig.oldInterfaceFlag;
            this.quicHints = new ArrayList();
            if (!Utils.isEmpty(globalRequestConfig.quicHints)) {
                this.quicHints.addAll(globalRequestConfig.quicHints);
            }
            this.options = globalRequestConfig.options;
        }
    }

    public GlobalRequestConfig(Builder builder) {
        super(builder);
        this.threadPoolSize = builder.threadPoolSize;
        this.sslSocketFactory = builder.sslSocketFactory;
        this.hostnameVerifier = builder.hostnameVerifier;
        this.trustManager = builder.trustManager;
        this.quicHints = builder.quicHints;
        this.httpClient = builder.httpClient;
        this.oldInterfaceFlag = builder.oldInterfaceFlag;
        this.options = builder.options;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
    }

    public GlobalRequestConfig genMergedRequestConfig(RequestConfig requestConfig) {
        Builder builder = new Builder(this);
        if (requestConfig.getCallTimeoutMillis() != -100) {
            builder.callTimeoutMillis(requestConfig.getCallTimeoutMillis());
        }
        if (requestConfig.getConnectTimeoutMillis() != -100) {
            builder.connectTimeoutMillis(requestConfig.getConnectTimeoutMillis());
        }
        if (requestConfig.getPingIntervalMillis() != -100) {
            builder.pingIntervalMillis(requestConfig.getPingIntervalMillis());
        }
        if (requestConfig.getReadTimeoutMillis() != -100) {
            builder.readTimeoutMillis(requestConfig.getReadTimeoutMillis());
        }
        if (requestConfig.getRetryTimes() != -100) {
            builder.retryTimes(requestConfig.getRetryTimes());
        }
        if (requestConfig.getWriteTimeoutMillis() != -100) {
            builder.writeTimeoutMillis(requestConfig.getWriteTimeoutMillis());
        }
        if (!TextUtils.isEmpty(requestConfig.getOptions())) {
            builder.options(requestConfig.getOptions());
        }
        return builder.build();
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    @Deprecated
    public HttpClient getHttpClient() {
        return this.httpClient;
    }

    @Deprecated
    public boolean getOldInterfaceFlag() {
        return this.oldInterfaceFlag;
    }

    @Override // com.huawei.hms.network.file.api.RequestConfig
    public String getOptions() {
        return this.options;
    }

    public List<String> getQuicHints() {
        return this.quicHints;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    public int getThreadPoolSize() {
        return this.threadPoolSize;
    }

    public X509TrustManager getTrustManager() {
        return this.trustManager;
    }
}
