package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.base.common.Headers;
import com.huawei.hms.network.embedded.C5913f1;
import com.huawei.hms.network.embedded.C5939h1;
import com.huawei.hms.network.embedded.C5971j7;
import com.huawei.hms.network.embedded.C6062q7;
import com.huawei.hms.network.embedded.C6101t7;
import com.huawei.hms.network.embedded.C6107u0;
import com.huawei.hms.network.httpclient.RequestFinishedInfo;
import com.huawei.hms.network.httpclient.ResponseBody;
import com.huawei.hms.network.httpclient.websocket.WebSocket;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.hms.network.embedded.j3 */
/* loaded from: classes8.dex */
public class C5967j3 implements InterfaceC5886d1 {

    /* renamed from: g */
    public static final String f27106g = "OkReqTsk";

    /* renamed from: a */
    public C6062q7 f27107a;

    /* renamed from: b */
    public InterfaceC6100t6 f27108b;

    /* renamed from: c */
    public C5939h1.d f27109c;

    /* renamed from: d */
    public boolean f27110d;

    /* renamed from: e */
    public volatile boolean f27111e;

    /* renamed from: f */
    public AbstractC6174z2 f27112f;

    public C5967j3(C6062q7 c6062q7) {
        this.f27107a = c6062q7;
    }

    /* renamed from: a */
    private C5939h1.f<ResponseBody> m34496a(C6127v7 c6127v7) {
        AbstractC6140w7 abstractC6140w7M35585s = c6127v7.m35585s();
        String strM34521a = c6127v7.m35591y().m34521a("Content-Type");
        C5913f1 c5913f1Build = null;
        C6036o7 c6036o7M34923b = strM34521a != null ? C6036o7.m34923b(strM34521a) : null;
        if (abstractC6140w7M35585s != null) {
            C5913f1.b bVarCharSet = new C5913f1.b().inputStream(abstractC6140w7M35585s.m35736s()).contentLength(abstractC6140w7M35585s.mo34710v()).charSet(c6036o7M34923b != null ? c6036o7M34923b.m34924a() : null);
            if (strM34521a == null) {
                strM34521a = "";
            }
            c5913f1Build = bVarCharSet.contentType(strM34521a).build();
        }
        C6107u0.b bVar = new C6107u0.b();
        if (c5913f1Build != null) {
            bVar.body(new C5939h1.g(c5913f1Build));
        }
        bVar.headers(m34498a(c6127v7.m35591y())).code(c6127v7.m35589w()).message(c6127v7.m35572B()).url(c6127v7.m35578H().m35423k().toString());
        return new C5939h1.f<>(bVar.build());
    }

    /* renamed from: b */
    private C6062q7.c m34499b(C5939h1.d dVar) {
        C6062q7.c cVarM35096t = this.f27107a.m35096t();
        long connectTimeout = dVar.getNetConfig().getConnectTimeout();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return cVarM35096t.m35126b(connectTimeout, timeUnit).m35139e(dVar.getNetConfig().getReadTimeout(), timeUnit).m35137d(dVar.getNetConfig().getPingInterval(), timeUnit).m35141f(dVar.getNetConfig().getWriteTimeout(), timeUnit).m35133c(dVar.getNetConfig().getConcurrentConnectDelay(), timeUnit);
    }

    /* renamed from: c */
    private C6062q7 m34500c(C5939h1.d dVar) {
        int pingInterval = dVar.getNetConfig().getPingInterval();
        Logger.m32136d(f27106g, "enableDynamicPing:" + dVar.getNetConfig().enableDynamicPing());
        if (dVar.getNetConfig().enableDynamicPing() == 2) {
            pingInterval = 120000;
        }
        return m34499b(dVar).m35137d(pingInterval, TimeUnit.MILLISECONDS).m35109a(C6032o3.getWebSocketEventFactory()).m35125a();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5886d1
    public void cancel() {
        this.f27111e = true;
        InterfaceC6100t6 interfaceC6100t6 = this.f27108b;
        if (interfaceC6100t6 != null) {
            interfaceC6100t6.cancel();
        }
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5886d1
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public InterfaceC5886d1 m85658clone() {
        return new C5967j3(this.f27107a);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5886d1
    public C5939h1.f<ResponseBody> execute(C5939h1.d dVar, WebSocket webSocket) throws IOException {
        C5847a4 c5847a4;
        synchronized (this) {
            if (this.f27110d) {
                throw new IllegalStateException("Already executed.");
            }
            this.f27110d = true;
        }
        if (this.f27111e && webSocket == null) {
            throw C6094t0.m35373a("Canceled");
        }
        this.f27109c = dVar;
        C6101t7.a aVar = new C6101t7.a();
        String method = dVar.getMethod();
        if (dVar.getBody() != null) {
            if ("GET".equals(method)) {
                method = "POST";
            } else if (!C5973j9.m34546b(method)) {
                throw new ProtocolException(method + " does not support writing");
            }
            c5847a4 = new C5847a4(dVar.getBody());
        } else {
            c5847a4 = null;
        }
        Headers headersM33636of = Headers.m33636of(dVar.getHeaders());
        int size = headersM33636of.size();
        C5971j7.a aVar2 = new C5971j7.a();
        for (int i10 = 0; i10 < size; i10++) {
            aVar2.m34532a(headersM33636of.name(i10), headersM33636of.value(i10));
        }
        aVar.m35443c(dVar.getUrl()).m35431a(method, c5847a4).m35424a(aVar2.m34535a()).m35435a(dVar.getNetConfig().enableConcurrentConnect());
        C6062q7 c6062q7M34497a = m34497a(dVar);
        if (dVar.getNetConfig().enableSiteDetect()) {
            Logger.m32141i(f27106g, "the request has used the okhttp! SiteDetect");
            this.f27108b = new C6019n3(c6062q7M34497a, aVar.m35429a(dVar.getTag()).m35436a());
        } else if (dVar.getNetConfig().enableConnectEmptyBody() || dVar.getNetConfig().enableInnerConnectEmptyBody()) {
            Logger.m32141i(f27106g, "the request has used the okhttp! OnlyConnectCall");
            this.f27108b = new C6006m3(c6062q7M34497a, aVar.m35436a());
        } else {
            if (webSocket != null) {
                Logger.m32141i(f27106g, "the request has used the okhttp! WebSocket");
                if (!(webSocket instanceof C5939h1.i)) {
                    throw new ClassCastException("websocket can not cast to SafeApi.SafeWebSocket");
                }
                WebSocket webSocket2 = ((C5939h1.i) webSocket).getWebSocket();
                if (!(webSocket2 instanceof C5968j4)) {
                    throw new ClassCastException("websocket can not cast to WebSocketImpl");
                }
                C5968j4 c5968j4 = (C5968j4) webSocket2;
                C5954i3 c5954i3 = new C5954i3(aVar, dVar, c5968j4, m34500c(dVar));
                c5954i3.connect();
                c5968j4.setProxy(c5954i3);
                c5954i3.getWebSocketListenerAdapter().predictorModel();
                return c5954i3.getWebSocketListenerAdapter().getResponse();
            }
            Logger.m32141i(f27106g, "the request has used the okhttp! ");
            this.f27108b = c6062q7M34497a.mo35073a(aVar.m35436a());
            C5928g3 listener = C5928g3.getFactory().getListener(this.f27108b);
            if (listener != null) {
                listener.setRCEventListener(this.f27112f);
            }
        }
        if (this.f27111e) {
            throw C6094t0.m35373a("Canceled");
        }
        return m34496a(this.f27108b.execute());
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5886d1
    public C5902e3 getConnectionInfo() {
        C5928g3 listener = C5928g3.getFactory().getListener(this.f27108b);
        if (listener != null) {
            return listener.getConnectionInfo();
        }
        return null;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5886d1
    public synchronized RequestFinishedInfo getRequestFinishedInfo() {
        C5928g3 listener = C5928g3.getFactory().getListener(this.f27108b);
        if (listener == null) {
            return null;
        }
        return listener.getRequestFinishedInfo();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5886d1
    public boolean isCanceled() {
        InterfaceC6100t6 interfaceC6100t6;
        return this.f27111e || ((interfaceC6100t6 = this.f27108b) != null && interfaceC6100t6.isCanceled());
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5886d1
    public synchronized boolean isExecuted() {
        return this.f27110d;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5886d1
    public C5939h1.d request() {
        return this.f27109c;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5886d1
    public void setRcEventListener(AbstractC6174z2 abstractC6174z2) {
        this.f27112f = abstractC6174z2;
    }

    /* renamed from: a */
    private C6062q7 m34497a(C5939h1.d dVar) {
        return m34499b(dVar).m35125a();
    }

    /* renamed from: a */
    private Map<String, List<String>> m34498a(C5971j7 c5971j7) {
        Headers.Builder builder = new Headers.Builder();
        int iM34527d = c5971j7.m34527d();
        for (int i10 = 0; i10 < iM34527d; i10++) {
            builder.addLenient(c5971j7.m34520a(i10), c5971j7.m34522b(i10));
        }
        return builder.build().toMultimap();
    }
}
