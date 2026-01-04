package com.huawei.hms.network.httpclient.websocket;

import com.huawei.hms.network.httpclient.Response;
import com.huawei.hms.network.httpclient.ResponseBody;

/* loaded from: classes8.dex */
public abstract class WebSocketListener {
    public void onClosed(WebSocket webSocket, int i10, String str) {
    }

    public void onClosing(WebSocket webSocket, int i10, String str) {
    }

    public void onFailure(WebSocket webSocket, Throwable th2, Response<ResponseBody> response) {
    }

    public void onMessage(WebSocket webSocket, String str) {
    }

    public void onOpen(WebSocket webSocket, Response<ResponseBody> response) {
    }

    public void onMessage(WebSocket webSocket, byte[] bArr) {
    }
}
