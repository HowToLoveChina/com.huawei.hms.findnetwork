package com.huawei.hms.framework.network.restclient.hianalytics;

import com.huawei.hms.framework.network.restclient.hwhttp.Response;
import com.huawei.hms.framework.network.restclient.proxy.new2old.ProxyResponse;
import com.huawei.hms.network.httpclient.RequestFinishedInfo;
import java.util.List;

@Deprecated
/* loaded from: classes8.dex */
public class RequestFinishedInfo {
    private final com.huawei.hms.network.httpclient.RequestFinishedInfo requestFinishedInfo;

    @Deprecated
    public static class Metrics {
        private final RequestFinishedInfo.Metrics metrics;

        public List<String> getConnectIps() {
            return this.metrics.getConnectIps();
        }

        public int getConnectRetryTime() {
            return this.metrics.getConnectRetryTime();
        }

        public int getDnsCache() {
            return this.metrics.getDnsCache();
        }

        public String getDnsType() {
            return this.metrics.getDnsType();
        }

        public String getProtocol() {
            return this.metrics.getProtocol();
        }

        public long getRequestByteCount() {
            return this.metrics.getRequestByteCount();
        }

        public long getResponseByteCount() {
            return this.metrics.getResponseByteCount();
        }

        public String getSuccessIp() {
            return this.metrics.getSuccessIp();
        }

        private Metrics(RequestFinishedInfo.Metrics metrics) {
            this.metrics = metrics;
        }
    }

    @Deprecated
    public static class MetricsTime {
        private final RequestFinishedInfo.MetricsTime metricsTime;

        public long getCallEndTime() {
            return this.metricsTime.getCallEndTime();
        }

        public long getCallStartTime() {
            return this.metricsTime.getCallStartTime();
        }

        public long getConnectEndTime() {
            return this.metricsTime.getConnectEndTime();
        }

        public long getConnectStartTime() {
            return this.metricsTime.getConnectStartTime();
        }

        public long getConnectionAcquiredTime() {
            return this.metricsTime.getConnectionAcquiredTime();
        }

        public long getConnectionReleasedTime() {
            return this.metricsTime.getConnectionReleasedTime();
        }

        public long getDnsEndTime() {
            return this.metricsTime.getDnsEndTime();
        }

        public long getDnsStartTime() {
            return this.metricsTime.getDnsStartTime();
        }

        public long getRequestBodyEndTime() {
            return this.metricsTime.getRequestBodyEndTime();
        }

        public long getRequestBodyStartTime() {
            return this.metricsTime.getRequestBodyStartTime();
        }

        public long getRequestHeadersEndTime() {
            return this.metricsTime.getRequestHeadersEndTime();
        }

        public long getRequestHeadersStartTime() {
            return this.metricsTime.getRequestHeadersStartTime();
        }

        public long getResponseBodyEndTime() {
            return this.metricsTime.getResponseBodyEndTime();
        }

        public long getResponseBodyStartTime() {
            return this.metricsTime.getResponseBodyStartTime();
        }

        public long getResponseHeadersEndTime() {
            return this.metricsTime.getResponseHeadersEndTime();
        }

        public long getResponseHeadersStartTime() {
            return this.metricsTime.getResponseHeadersStartTime();
        }

        public long getSecureConnectEndTime() {
            return this.metricsTime.getSecureConnectEndTime();
        }

        public long getSecureConnectStartTime() {
            return this.metricsTime.getSecureConnectStartTime();
        }

        public long getTotalTime() {
            return this.metricsTime.getTotalTime();
        }

        public long getTtfb() {
            return this.metricsTime.getTtfb();
        }

        private MetricsTime(RequestFinishedInfo.MetricsTime metricsTime) {
            this.metricsTime = metricsTime;
        }
    }

    public RequestFinishedInfo(com.huawei.hms.network.httpclient.RequestFinishedInfo requestFinishedInfo) {
        this.requestFinishedInfo = requestFinishedInfo;
    }

    public Exception getException() {
        return this.requestFinishedInfo.getException();
    }

    public String getHost() {
        return this.requestFinishedInfo.getHost();
    }

    public Metrics getMetrics() {
        return new Metrics(this.requestFinishedInfo.getMetrics());
    }

    public MetricsTime getMetricsRealTime() {
        return new MetricsTime(this.requestFinishedInfo.getMetricsRealTime());
    }

    public MetricsTime getMetricsTime() {
        return new MetricsTime(this.requestFinishedInfo.getMetricsTime());
    }

    public String getNetworkSdkType() {
        return this.requestFinishedInfo.getNetworkSdkType();
    }

    public long getPingInterval() {
        return this.requestFinishedInfo.getPingInterval();
    }

    public Response getResponse() {
        return ProxyResponse.response2Old(this.requestFinishedInfo.getResponse());
    }

    public String getUrl() {
        return this.requestFinishedInfo.getUrl();
    }
}
