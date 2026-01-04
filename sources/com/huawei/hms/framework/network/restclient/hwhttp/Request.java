package com.huawei.hms.framework.network.restclient.hwhttp;

import com.huawei.hms.framework.network.restclient.Headers;
import com.huawei.hms.framework.network.restclient.hianalytics.RequestFinishedInfo;
import com.huawei.hms.framework.network.restclient.hwhttp.ClientConfiguration;
import com.huawei.hms.framework.network.restclient.hwhttp.url.HttpUrl;
import java.util.Collections;
import java.util.Map;

@Deprecated
/* loaded from: classes8.dex */
public class Request {
    public static final String HTTP_METHOD_GET = "GET";
    private ClientConfiguration clientConfiguration;
    private boolean clientConfigurationModified;
    private boolean concurrentConnectEnabled;
    private Headers headers;
    private String method;
    private boolean onlyConnect;
    private final Map<String, String> recordParamMap;
    private RequestBody requestBody;
    private RequestExtraInfo requestExtraInfo;
    private RequestFinishedInfo requestFinishedInfo;
    private HttpUrl url;

    @Deprecated
    public static final class Builder {
        private boolean onlyConnect;
        private Map<String, String> recordParamMap;
        private RequestBody requestBody;
        private HttpUrl url;
        private ClientConfiguration.Builder clientConfigurationBuilder = new ClientConfiguration.Builder();
        private boolean clientConfigurationModified = false;
        private boolean concurrentConnectEnabled = true;
        private String method = "GET";
        private Headers.Builder headers = new Headers.Builder();
        private RequestExtraInfo requestExtraInfo = new RequestExtraInfo();

        public Builder addHeader(String str, String str2) {
            this.headers.add(str, str2);
            return this;
        }

        public Request build() {
            return new Request(this);
        }

        public Builder callTimeout(int i10) {
            this.clientConfigurationModified = true;
            this.clientConfigurationBuilder.callTimeout(i10);
            return this;
        }

        public Builder clientConfiguration(ClientConfiguration clientConfiguration) {
            this.clientConfigurationModified = true;
            this.clientConfigurationBuilder = clientConfiguration.newBuilder();
            return this;
        }

        public Builder clientConfigurationModified(boolean z10) {
            this.clientConfigurationModified = z10;
            return this;
        }

        public Builder concurrentConnectEnabled(Boolean bool) {
            this.concurrentConnectEnabled = bool.booleanValue();
            return this;
        }

        public Builder connectTimeout(int i10) {
            this.clientConfigurationModified = true;
            this.clientConfigurationBuilder.connectTimeout(i10);
            return this;
        }

        public Builder connectionAttemptDelay(int i10) {
            this.clientConfigurationModified = true;
            this.clientConfigurationBuilder.connectionAttemptDelay(i10);
            return this;
        }

        public Builder headers(Headers.Builder builder) {
            this.headers = builder;
            return this;
        }

        public Builder method(String str) {
            this.method = str;
            return this;
        }

        public Builder onlyConnect(boolean z10) {
            this.onlyConnect = z10;
            return this;
        }

        public Builder pingInterval(int i10) {
            this.clientConfigurationModified = true;
            this.clientConfigurationBuilder.pingInterval(i10);
            return this;
        }

        public Builder readTimeout(int i10) {
            this.clientConfigurationModified = true;
            this.clientConfigurationBuilder.readTimeout(i10);
            return this;
        }

        public Builder recordParamMap(Map<String, String> map) {
            if (map != null) {
                this.recordParamMap = Collections.unmodifiableMap(map);
            }
            return this;
        }

        public Builder removeHeader(String str) {
            this.headers.removeAll(str);
            return this;
        }

        public Builder requestBody(RequestBody requestBody) {
            this.requestBody = requestBody;
            return this;
        }

        public Builder retryTimeOnConnectionFailure(int i10) {
            this.clientConfigurationModified = true;
            this.clientConfigurationBuilder.retryTimeOnConnectionFailure(i10);
            return this;
        }

        public Builder url(HttpUrl httpUrl) {
            this.url = httpUrl;
            return this;
        }

        public Builder writeTimeout(int i10) {
            this.clientConfigurationModified = true;
            this.clientConfigurationBuilder.writeTimeout(i10);
            return this;
        }

        public Builder url(String str) {
            this.url = new HttpUrl(str);
            return this;
        }
    }

    public /* synthetic */ Request(Builder builder, C54941 c54941) {
        this(builder);
    }

    public RequestBody getBody() {
        return this.requestBody;
    }

    public int getCallTimeout() {
        return this.clientConfiguration.getCallTimeout();
    }

    public ClientConfiguration getClientConfiguration() {
        return this.clientConfiguration;
    }

    public boolean getConcurrentConnectEnabled() {
        return this.concurrentConnectEnabled;
    }

    public int getConnectTimeout() {
        return this.clientConfiguration.getConnectTimeout();
    }

    public int getConnectionAttemptDelay() {
        return this.clientConfiguration.getConnectionAttemptDelay();
    }

    public Headers getHeaders() {
        return this.headers;
    }

    public String getMethod() {
        return this.method;
    }

    public int getPingInterval() {
        return this.clientConfiguration.getPingInterval();
    }

    public int getReadTimeout() {
        return this.clientConfiguration.getReadTimeout();
    }

    public Map<String, String> getRecordParamMap() {
        return this.recordParamMap;
    }

    public RequestExtraInfo getRequestExtraInfo() {
        return this.requestExtraInfo;
    }

    public RequestFinishedInfo getRequestFinishedInfo() {
        return this.requestFinishedInfo;
    }

    public int getRetryTimeOnConnectionFailure() {
        return this.clientConfiguration.getRetryTimeOnConnectionFailure();
    }

    public HttpUrl getUrl() {
        return this.url;
    }

    public int getWriteTimeout() {
        return this.clientConfiguration.getWriteTimeout();
    }

    public boolean isClientConfigurationModified() {
        return this.clientConfigurationModified;
    }

    public boolean isOnlyConnect() {
        return this.onlyConnect;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.method = this.method;
        builder.url = this.url;
        builder.headers = this.headers.newBuilder();
        builder.requestBody = this.requestBody;
        builder.concurrentConnectEnabled = this.concurrentConnectEnabled;
        builder.onlyConnect = this.onlyConnect;
        builder.clientConfigurationBuilder = this.clientConfiguration.newBuilder();
        builder.clientConfigurationModified = this.clientConfigurationModified;
        builder.recordParamMap = this.recordParamMap;
        builder.requestExtraInfo = this.requestExtraInfo;
        return builder;
    }

    public void release() {
    }

    public void setRequestFinishedInfo(RequestFinishedInfo requestFinishedInfo) {
        this.requestExtraInfo.setRequestFinishedInfo(requestFinishedInfo);
        this.requestFinishedInfo = requestFinishedInfo;
    }

    public String toString() {
        return super.toString();
    }

    private Request(Builder builder) {
        this.method = builder.method;
        this.url = builder.url;
        this.headers = builder.headers.build();
        this.requestBody = builder.requestBody;
        this.concurrentConnectEnabled = builder.concurrentConnectEnabled;
        this.onlyConnect = builder.onlyConnect;
        this.clientConfiguration = builder.clientConfigurationBuilder.build();
        this.clientConfigurationModified = builder.clientConfigurationModified;
        this.recordParamMap = builder.recordParamMap;
        this.requestExtraInfo = builder.requestExtraInfo;
    }
}
