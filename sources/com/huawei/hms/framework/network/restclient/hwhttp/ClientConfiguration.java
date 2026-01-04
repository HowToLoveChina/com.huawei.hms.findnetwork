package com.huawei.hms.framework.network.restclient.hwhttp;

import com.huawei.hms.framework.common.Logger;

/* loaded from: classes8.dex */
public class ClientConfiguration {
    public static final int CALL_TIMEOUT = 0;
    public static final int CONNECTION_ATTEMPT_DELAY_MAX = 2000;
    public static final int CONNECTION_ATTEMPT_DELAY_MIN = 100;
    public static final int CONNECT_TIMEOUT = 10000;
    public static final int INTERVAL = 500;
    public static final int MIN_CALL_TIMEOUT = 20;
    public static final int MIN_CONNECT_TIMEOUT = 1000;
    public static final int PING_TIME = 0;
    public static final int READ_TIMEOUT = 10000;
    public static final int RETRY_TIME = 1;
    private static final String TAG = "ClientConfiguration";
    public static final int WRITE_TIMEOUT = 10000;
    private int callTimeout;
    private int connectTimeout;
    private int connectionAttemptDelay;
    private int pingInterval;
    private int readTimeout;
    private int retryTimeOnConnectionFailure;
    private int writeTimeout;

    public static final class Builder {
        private int connectTimeout = 10000;
        private int readTimeout = 10000;
        private int retryTimeOnConnectionFailure = 1;
        private int callTimeout = 0;
        private int pingInterval = 0;
        private int writeTimeout = 10000;
        private int connectionAttemptDelay = 500;

        public ClientConfiguration build() {
            return new ClientConfiguration(this);
        }

        public Builder callTimeout(int i10) {
            if (i10 > 20 || i10 == 0) {
                this.callTimeout = i10;
            } else {
                Logger.m32147w(ClientConfiguration.TAG, "callTimeout must be greater than %d, no effect", 20);
            }
            return this;
        }

        public Builder connectTimeout(int i10) {
            if (i10 < 1000) {
                Logger.m32147w(ClientConfiguration.TAG, "restclient use composite concurrency policy to create connect, so connect timeout must larger than %d ms, no effect", 1000);
            } else if (i10 <= this.connectionAttemptDelay) {
                Logger.m32147w(ClientConfiguration.TAG, "connectTimeout %d ms is less than or equal to connectionAttemptDelay %d ms, no effect", Integer.valueOf(i10), Integer.valueOf(this.connectionAttemptDelay));
            } else {
                this.connectTimeout = i10;
            }
            return this;
        }

        public Builder connectionAttemptDelay(int i10) {
            if (i10 < 100 || i10 > 2000) {
                Logger.m32147w(ClientConfiguration.TAG, "connectionAttemptDelay %d ms is out of range ( %d ms ~ %d ms), no effect", Integer.valueOf(i10), 100, 2000);
            } else if (i10 >= this.connectTimeout) {
                Logger.m32147w(ClientConfiguration.TAG, "connectionAttemptDelay %d ms is greater than or equal to connectTimeout %d ms, no effect", Integer.valueOf(i10), Integer.valueOf(this.connectTimeout));
            } else {
                this.connectionAttemptDelay = i10;
            }
            return this;
        }

        public Builder copyBuilder() {
            return new Builder().connectTimeout(this.connectTimeout).retryTimeOnConnectionFailure(this.retryTimeOnConnectionFailure).readTimeout(this.readTimeout).callTimeout(this.callTimeout).pingInterval(this.pingInterval).writeTimeout(this.writeTimeout).connectionAttemptDelay(this.connectionAttemptDelay);
        }

        public Builder pingInterval(int i10) {
            if (i10 < 0) {
                Logger.m32145w(ClientConfiguration.TAG, "pingTimeout must not less than 0, no effect");
            } else {
                this.pingInterval = i10;
            }
            return this;
        }

        public Builder readTimeout(int i10) {
            if (i10 <= 0) {
                Logger.m32145w(ClientConfiguration.TAG, "readTimeout must be greater than 0, no effect");
            } else {
                this.readTimeout = i10;
            }
            return this;
        }

        public Builder retryTimeOnConnectionFailure(int i10) {
            if (i10 < 0) {
                Logger.m32145w(ClientConfiguration.TAG, "retryTimeOnConnectionFailure must be greater than or equal to 0, no effect");
            } else {
                this.retryTimeOnConnectionFailure = i10;
            }
            return this;
        }

        public Builder writeTimeout(int i10) {
            if (i10 <= 0) {
                Logger.m32145w(ClientConfiguration.TAG, "writeTimeout must be greater than 0, no effect");
            } else {
                this.writeTimeout = i10;
            }
            return this;
        }
    }

    public int getCallTimeout() {
        return this.callTimeout;
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public int getConnectionAttemptDelay() {
        return this.connectionAttemptDelay;
    }

    public int getPingInterval() {
        return this.pingInterval;
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public int getRetryTimeOnConnectionFailure() {
        return this.retryTimeOnConnectionFailure;
    }

    public int getWriteTimeout() {
        return this.writeTimeout;
    }

    public Builder newBuilder() {
        return new Builder().connectTimeout(this.connectTimeout).retryTimeOnConnectionFailure(this.retryTimeOnConnectionFailure).readTimeout(this.readTimeout).callTimeout(this.callTimeout).pingInterval(this.pingInterval).writeTimeout(this.writeTimeout).connectionAttemptDelay(this.connectionAttemptDelay);
    }

    private ClientConfiguration(Builder builder) {
        this.connectTimeout = builder.connectTimeout;
        this.readTimeout = builder.readTimeout;
        this.retryTimeOnConnectionFailure = builder.retryTimeOnConnectionFailure;
        this.callTimeout = builder.callTimeout;
        this.pingInterval = builder.pingInterval;
        this.writeTimeout = builder.writeTimeout;
        this.connectionAttemptDelay = builder.connectionAttemptDelay;
    }
}
