package com.huawei.hms.network.httpclient.websocket;

import com.huawei.hms.network.httpclient.Request;

/* loaded from: classes8.dex */
public abstract class WebSocket {
    public abstract void cancel();

    public abstract boolean close(int i10, String str);

    public abstract boolean enableDynamicPing(int i10);

    public abstract long queueSize();

    public abstract Request request();

    @Deprecated
    public abstract void resetPingInterval(long j10);

    public abstract boolean send(String str);

    public abstract boolean send(byte[] bArr);
}
