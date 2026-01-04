package com.huawei.hms.framework.network.restclient.websocket;

import com.huawei.hms.framework.network.restclient.hwhttp.Request;
import com.huawei.hms.framework.network.restclient.hwhttp.trans.ByteString;

@Deprecated
/* loaded from: classes8.dex */
public interface WebSocket {
    void cancel();

    boolean close(int i10, String str);

    long queueSize();

    Request request();

    boolean send(ByteString byteString);

    boolean send(String str);
}
