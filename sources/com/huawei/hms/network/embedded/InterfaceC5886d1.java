package com.huawei.hms.network.embedded;

import com.huawei.hms.network.embedded.C5939h1;
import com.huawei.hms.network.httpclient.RequestFinishedInfo;
import com.huawei.hms.network.httpclient.ResponseBody;
import com.huawei.hms.network.httpclient.websocket.WebSocket;
import java.io.IOException;

/* renamed from: com.huawei.hms.network.embedded.d1 */
/* loaded from: classes8.dex */
public interface InterfaceC5886d1 {

    /* renamed from: com.huawei.hms.network.embedded.d1$a */
    public interface a {
        String getChannel();

        boolean isAvailable();

        InterfaceC5886d1 newTask();
    }

    void cancel();

    InterfaceC5886d1 clone();

    C5939h1.f<ResponseBody> execute(C5939h1.d dVar, WebSocket webSocket) throws IOException;

    C5902e3 getConnectionInfo();

    RequestFinishedInfo getRequestFinishedInfo();

    boolean isCanceled();

    boolean isExecuted();

    C5939h1.d request();

    void setRcEventListener(AbstractC6174z2 abstractC6174z2);
}
