package com.huawei.hms.framework.network.restclient.config;

import com.huawei.hms.framework.common.Logger;

/* loaded from: classes8.dex */
public class NetworkConfig extends BaseConfig {
    private static final String TAG = "NetworkConfig";

    public NetworkConfig(String str) {
        super(str);
    }

    public boolean disableWeakNetworkRetry() {
        return getBoolean("core_disable_weaknetwork_retry", true);
    }

    public boolean enableConcurrentConnect() {
        return getBoolean("core_enable_concurrent_connect", true);
    }

    public boolean enableConnectEmptyBody() {
        return getBoolean("core_connect_empty_body", false);
    }

    public boolean enablePlaintextUrlPath() {
        return getBoolean("core_enable_plaintext_url_path", false);
    }

    public int getCallTimeout() {
        int i10 = getInt("core_call_timeout", 0);
        if (i10 <= 20) {
            return 0;
        }
        return i10;
    }

    public int getConnectTimeout() {
        int i10 = getInt("core_connect_timeout", 10000);
        if (i10 >= 1000) {
            return i10;
        }
        Logger.m32147w("NetworkConfig", "restclient use composite concurrency policy to create connect, so connect timeout must larger than %d ms, no effect", 1000);
        return 10000;
    }

    public int getConnectionAttemptDelay() {
        int i10 = getInt("core_concurrent_connect_delay", 500);
        if (i10 >= 100 && i10 <= 2000) {
            return i10;
        }
        Logger.m32147w("NetworkConfig", "connectionAttemptDelay %d ms is out of range ( %d ms ~ %d ms), no effect", Integer.valueOf(i10), 100, 2000);
        return 500;
    }

    public int getPingInterval() {
        int i10 = getInt("core_ping_interval", 0);
        if (i10 < 0) {
            return 0;
        }
        return i10;
    }

    public int getReadTimeout() {
        int i10 = getInt("core_read_timeout", 10000);
        if (i10 <= 0) {
            return 10000;
        }
        return i10;
    }

    public int getRetryTimeOnConnectionFailure() {
        int i10 = getInt("core_retry_time", 1);
        if (i10 < 0) {
            return 1;
        }
        return i10;
    }

    public int getWriteTimeout() {
        int i10 = getInt("core_write_timeout", 10000);
        if (i10 <= 0) {
            return 10000;
        }
        return i10;
    }
}
