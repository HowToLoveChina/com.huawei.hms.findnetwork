package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.embedded.C5939h1;
import com.huawei.hms.network.embedded.C6101t7;
import com.huawei.hms.network.httpclient.Request;
import com.huawei.hms.network.httpclient.websocket.WebSocket;
import java.util.Random;

/* renamed from: com.huawei.hms.network.embedded.i3 */
/* loaded from: classes8.dex */
public class C5954i3 extends WebSocket implements InterfaceC5981k4 {

    /* renamed from: e */
    public static final String f27004e = "OkHttpWebSocketProxy";

    /* renamed from: a */
    public C6117ua f27005a;

    /* renamed from: b */
    public Request f27006b;

    /* renamed from: c */
    public C6062q7 f27007c;

    /* renamed from: d */
    public C6045p3 f27008d;

    public C5954i3(C6101t7.a aVar, C5939h1.d dVar, WebSocket webSocket, C6062q7 c6062q7) {
        if (!(webSocket instanceof C5968j4)) {
            throw new ClassCastException("websocket can not cast to WebSocketImpl");
        }
        this.f27008d = new C6045p3(webSocket, ((C5968j4) webSocket).getWebSocketListener(), dVar);
        this.f27005a = new C6117ua(aVar.m35436a(), this.f27008d, new Random(), c6062q7.m35097u());
        this.f27006b = dVar;
        this.f27007c = c6062q7;
    }

    @Override // com.huawei.hms.network.httpclient.websocket.WebSocket
    public void cancel() {
        this.f27005a.cancel();
    }

    @Override // com.huawei.hms.network.httpclient.websocket.WebSocket
    public boolean close(int i10, String str) {
        return this.f27005a.mo35531a(i10, str);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5981k4
    public void connect() {
        this.f27005a.m35525a(this.f27007c);
    }

    @Override // com.huawei.hms.network.httpclient.websocket.WebSocket
    public boolean enableDynamicPing(int i10) {
        return this.f27008d.enableDynamicPing(i10);
    }

    public C6045p3 getWebSocketListenerAdapter() {
        return this.f27008d;
    }

    @Override // com.huawei.hms.network.httpclient.websocket.WebSocket
    public long queueSize() {
        return this.f27005a.mo35521a();
    }

    @Override // com.huawei.hms.network.httpclient.websocket.WebSocket
    public Request request() {
        return this.f27006b;
    }

    @Override // com.huawei.hms.network.httpclient.websocket.WebSocket
    public void resetPingInterval(long j10) {
        Request request = this.f27006b;
        if (request != null) {
            int iEnableDynamicPing = ((C5939h1.d) request).getNetConfig().enableDynamicPing();
            if (iEnableDynamicPing != 0) {
                Logger.m32145w(f27004e, "Cannot reset pinginterval,dynamicPing is enable " + iEnableDynamicPing);
                return;
            }
            this.f27005a.m35523a(j10);
            Logger.m32143v(f27004e, "resetPingInterval " + j10);
        }
    }

    public void resetPingIntervalOnReadPong(long j10) {
        this.f27005a.m35523a(j10);
        Logger.m32143v(f27004e, "resetPingIntervalOnReadPong " + j10);
    }

    @Override // com.huawei.hms.network.httpclient.websocket.WebSocket
    public boolean send(String str) {
        return this.f27005a.mo35536b(str);
    }

    @Override // com.huawei.hms.network.httpclient.websocket.WebSocket
    public boolean send(byte[] bArr) {
        C5910eb c5910ebM34158e = C5910eb.m34158e(bArr);
        this.f27008d.onSend();
        return this.f27005a.mo35535b(c5910ebM34158e);
    }
}
