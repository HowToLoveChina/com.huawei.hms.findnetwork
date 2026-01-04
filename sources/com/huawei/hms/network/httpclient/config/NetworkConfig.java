package com.huawei.hms.network.httpclient.config;

import com.huawei.hms.network.embedded.C5898e;
import com.huawei.hms.network.inner.api.PolicyNetworkService;

/* loaded from: classes8.dex */
public class NetworkConfig extends C5898e {

    /* renamed from: b */
    public static final String f29527b = "NetworkConfig";

    public NetworkConfig(String str) {
        super(str);
    }

    public boolean disableWeakNetworkRetry() {
        return getBoolean("core_disable_weaknetwork_retry");
    }

    public boolean enableConcurrentConnect() {
        return getBoolean("core_enable_concurrent_connect");
    }

    public boolean enableConnectEmptyBody() {
        return getBoolean("core_connect_empty_body");
    }

    public int enableDynamicPing() {
        return getInt(PolicyNetworkService.RequestConstants.ENABLE_DYNAMIC_PING);
    }

    public boolean enableInnerConnectEmptyBody() {
        return getBoolean(PolicyNetworkService.RequestConstants.INNER_CONNECT_EMPTY_BODY);
    }

    public boolean enablePlaintextUrlPath() {
        return getBoolean("core_enable_plaintext_url_path");
    }

    public boolean enableSiteDetect() {
        return getBoolean("core_enable_site_detect");
    }

    public boolean enableTrafficControlWith429() {
        return getBoolean(PolicyNetworkService.RequestConstants.ENABLE_TRAFFIC_CONTROL_WITH_429);
    }

    public int getCallTimeout() {
        return getInt("core_call_timeout");
    }

    public int getConcurrentConnectDelay() {
        return getInt("core_concurrent_connect_delay");
    }

    public int getConnectTimeout() {
        return getInt("core_connect_timeout");
    }

    public int getMaxRequestDiscreteTime() {
        return getInt(PolicyNetworkService.RequestConstants.MAX_REQUEST_DISCRETE_TIME);
    }

    public int getMaxRetryWaitingTime() {
        return getInt(PolicyNetworkService.RequestConstants.MAX_RETRY_WAITING_TIME);
    }

    public int getMetricPolicy() {
        return getInt(PolicyNetworkService.RequestConstants.METRIC_POLICY);
    }

    public int getPingInterval() {
        return getInt("core_ping_interval");
    }

    public int getReadTimeout() {
        return getInt("core_read_timeout");
    }

    public int getRetryAfterTime() {
        return 8000;
    }

    public int getRetryTimeOnConnectionFailure() {
        return getInt("core_retry_time");
    }

    public int getWriteTimeout() {
        return getInt("core_write_timeout");
    }
}
