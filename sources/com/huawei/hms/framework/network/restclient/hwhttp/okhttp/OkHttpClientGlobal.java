package com.huawei.hms.framework.network.restclient.hwhttp.okhttp;

import com.huawei.hms.framework.network.restclient.hwhttp.HttpClientGlobalInstance;
import java.util.concurrent.TimeUnit;

/* loaded from: classes8.dex */
public class OkHttpClientGlobal {
    private static final int DEFAULT_CONNECTION_KEEPALIVE_DURATION = 5;
    private static final int DEFAULT_CONNECTION_SIZE = 8;
    private static final TimeUnit DEFAULT_CONNECTION_TIMEUNIT = TimeUnit.MINUTES;
    private static final int MAX_HTTP2_REQUEST_PER_HOST = 32;
    private static final int MAX_REQUEST_SIZE = 200;
    private static OkHttpClientGlobal instance;
    private long connectionKeepAliveDuration;
    private TimeUnit connectionTimeUnit;
    private int maxIdleConnections;

    private OkHttpClientGlobal() {
        this(8, 5L, DEFAULT_CONNECTION_TIMEUNIT);
    }

    public static synchronized OkHttpClientGlobal getInstance() {
        try {
            if (instance == null) {
                instance = new OkHttpClientGlobal();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return instance;
    }

    public static synchronized void init(int i10, long j10, TimeUnit timeUnit) {
        if (instance == null) {
            instance = new OkHttpClientGlobal(i10, j10, timeUnit);
            HttpClientGlobalInstance.getInstance().initConnectionPool(i10, j10, timeUnit);
        }
    }

    public synchronized void evictAll() {
        HttpClientGlobalInstance.getInstance().evictAll();
    }

    public long getConnectionKeepAliveDuration() {
        return this.connectionKeepAliveDuration;
    }

    public TimeUnit getConnectionTimeUnit() {
        return this.connectionTimeUnit;
    }

    public int getMaxIdleConnections() {
        return this.maxIdleConnections;
    }

    private OkHttpClientGlobal(int i10, long j10, TimeUnit timeUnit) {
        this.maxIdleConnections = i10;
        this.connectionKeepAliveDuration = j10;
        this.connectionTimeUnit = timeUnit;
    }
}
