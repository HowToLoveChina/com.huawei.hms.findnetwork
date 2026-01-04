package com.huawei.hms.network.embedded;

import com.huawei.hms.network.httpclient.Request;
import com.huawei.hms.network.httpclient.websocket.WebSocket;
import com.huawei.hms.network.httpclient.websocket.WebSocketListener;

/* renamed from: com.huawei.hms.network.embedded.j4 */
/* loaded from: classes8.dex */
public class C5968j4 extends WebSocket {

    /* renamed from: a */
    public WebSocket f27113a;

    /* renamed from: b */
    public Request f27114b;

    /* renamed from: c */
    public WebSocketListener f27115c;

    public C5968j4(Request request, WebSocketListener webSocketListener) {
        this.f27114b = request;
        this.f27115c = webSocketListener;
    }

    @Override // com.huawei.hms.network.httpclient.websocket.WebSocket
    public void cancel() {
        WebSocket webSocket = this.f27113a;
        if (webSocket != null) {
            webSocket.cancel();
        }
    }

    @Override // com.huawei.hms.network.httpclient.websocket.WebSocket
    public boolean close(int i10, String str) {
        WebSocket webSocket = this.f27113a;
        if (webSocket == null) {
            return false;
        }
        return webSocket.close(i10, str);
    }

    @Override // com.huawei.hms.network.httpclient.websocket.WebSocket
    public boolean enableDynamicPing(int i10) {
        WebSocket webSocket = this.f27113a;
        if (webSocket != null) {
            return webSocket.enableDynamicPing(i10);
        }
        return false;
    }

    public Request getRequest() {
        return this.f27114b;
    }

    public WebSocketListener getWebSocketListener() {
        return this.f27115c;
    }

    @Override // com.huawei.hms.network.httpclient.websocket.WebSocket
    public long queueSize() {
        WebSocket webSocket = this.f27113a;
        if (webSocket == null) {
            return 0L;
        }
        return webSocket.queueSize();
    }

    @Override // com.huawei.hms.network.httpclient.websocket.WebSocket
    public Request request() {
        WebSocket webSocket = this.f27113a;
        if (webSocket == null) {
            return null;
        }
        return webSocket.request();
    }

    @Override // com.huawei.hms.network.httpclient.websocket.WebSocket
    public void resetPingInterval(long j10) {
        WebSocket webSocket = this.f27113a;
        if (webSocket != null) {
            webSocket.resetPingInterval(j10);
        }
    }

    public void resetPingIntervalOnReadPong(long j10) {
        WebSocket webSocket = this.f27113a;
        if (webSocket == null || !(webSocket instanceof C5954i3)) {
            return;
        }
        ((C5954i3) webSocket).resetPingIntervalOnReadPong(j10);
    }

    @Override // com.huawei.hms.network.httpclient.websocket.WebSocket
    public boolean send(String str) {
        WebSocket webSocket = this.f27113a;
        if (webSocket == null) {
            return false;
        }
        return webSocket.send(str);
    }

    public void setProxy(WebSocket webSocket) {
        this.f27113a = webSocket;
    }

    @Override // com.huawei.hms.network.httpclient.websocket.WebSocket
    public boolean send(byte[] bArr) {
        WebSocket webSocket = this.f27113a;
        if (webSocket == null) {
            return false;
        }
        return webSocket.send(bArr);
    }
}
