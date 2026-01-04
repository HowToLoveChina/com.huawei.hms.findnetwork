package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.base.common.Headers;
import com.huawei.hms.network.embedded.C5913f1;
import com.huawei.hms.network.embedded.C5939h1;
import com.huawei.hms.network.embedded.C6107u0;
import com.huawei.hms.network.httpclient.ResponseBody;
import com.huawei.hms.network.httpclient.websocket.WebSocket;
import com.huawei.hms.network.httpclient.websocket.WebSocketListener;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/* renamed from: com.huawei.hms.network.embedded.p3 */
/* loaded from: classes8.dex */
public class C6045p3 extends AbstractC5851a8 {

    /* renamed from: n */
    public static final String f27678n = "WebSocketListenerAdapter";

    /* renamed from: o */
    public static final String f27679o = "connect_failed";

    /* renamed from: p */
    public static final String f27680p = "connect_closed";

    /* renamed from: q */
    public static final String f27681q = "WebSocket_PredictorModel";

    /* renamed from: a */
    public WebSocketListener f27682a;

    /* renamed from: b */
    public WebSocket f27683b;

    /* renamed from: d */
    public volatile C5939h1.f<ResponseBody> f27685d;

    /* renamed from: e */
    public Throwable f27686e;

    /* renamed from: f */
    public C5939h1.d f27687f;

    /* renamed from: g */
    public C5993l3 f27688g;

    /* renamed from: h */
    public C6058q3 f27689h;

    /* renamed from: i */
    public C6071r3 f27690i;

    /* renamed from: j */
    public int f27691j;

    /* renamed from: k */
    public LinkedList<Long> f27692k;

    /* renamed from: l */
    public int f27693l;

    /* renamed from: c */
    public CountDownLatch f27684c = new CountDownLatch(1);

    /* renamed from: m */
    public final ExecutorService f27694m = ExecutorsUtils.newSingleThreadExecutor(f27681q);

    /* renamed from: com.huawei.hms.network.embedded.p3$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuilder sb2;
            int i10;
            if (C6045p3.this.f27691j <= 0) {
                sb2 = new StringBuilder();
                sb2.append("canot predictor model ,pingInterval is:");
                i10 = C6045p3.this.f27691j;
            } else {
                if (C6045p3.this.f27693l == 1 || C6045p3.this.f27693l == 2) {
                    boolean zPredictorModel = C6045p3.this.f27690i != null ? C6045p3.this.f27690i.predictorModel() : false;
                    sb2 = new StringBuilder();
                    sb2.append("webSocket ping model predictor:");
                    sb2.append(zPredictorModel);
                    Logger.m32141i(C6045p3.f27678n, sb2.toString());
                }
                sb2 = new StringBuilder();
                sb2.append("canot predictor model ,actionType is:");
                i10 = C6045p3.this.f27693l;
            }
            sb2.append(i10);
            Logger.m32141i(C6045p3.f27678n, sb2.toString());
        }
    }

    public C6045p3(WebSocket webSocket, WebSocketListener webSocketListener, C5939h1.d dVar) {
        this.f27682a = webSocketListener;
        this.f27683b = webSocket;
        this.f27687f = dVar;
        this.f27691j = dVar.getNetConfig().getPingInterval();
        m34958a();
    }

    public boolean enableDynamicPing(int i10) {
        String str;
        if (this.f27691j <= 0) {
            str = "canot predictor model ,pingInterval is:" + this.f27691j;
        } else {
            C6071r3 c6071r3 = this.f27690i;
            actionType = c6071r3 != null ? c6071r3.setActionType(i10) : false;
            str = "enable dynamic ping model predictor:" + actionType;
        }
        Logger.m32141i(f27678n, str);
        return actionType;
    }

    public CountDownLatch getCountDownLatch() {
        return this.f27684c;
    }

    public C5939h1.f<ResponseBody> getResponse() throws InterruptedException, IOException {
        try {
            this.f27684c.await();
        } catch (InterruptedException e10) {
            Logger.m32146w(f27678n, "InterruptedException ", e10);
        }
        if (this.f27685d == null) {
            Throwable th2 = this.f27686e;
            if (th2 instanceof IOException) {
                throw ((IOException) th2);
            }
        }
        return this.f27685d == null ? new C5939h1.f<>(new C6107u0.b().build()) : this.f27685d;
    }

    @Override // com.huawei.hms.network.embedded.AbstractC5851a8
    public void onClosed(InterfaceC6179z7 interfaceC6179z7, int i10, String str) {
        m34959a(interfaceC6179z7);
        this.f27688g.getMetricsRealTime().setRequestBodyEndTime();
        this.f27688g.getMetricsTime().setRequestBodyEndTime();
        this.f27689h.reportData(Integer.valueOf(i10), f27680p);
        this.f27682a.onClosed(this.f27683b, i10, str);
        Logger.m32143v(f27678n, "Closed " + str);
        CountDownLatch countDownLatch = this.f27684c;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    @Override // com.huawei.hms.network.embedded.AbstractC5851a8
    public void onClosing(InterfaceC6179z7 interfaceC6179z7, int i10, String str) {
        this.f27682a.onClosing(this.f27683b, i10, str);
    }

    @Override // com.huawei.hms.network.embedded.AbstractC5851a8
    public void onFailure(InterfaceC6179z7 interfaceC6179z7, Throwable th2, C6127v7 c6127v7) {
        this.f27686e = th2;
        m34959a(interfaceC6179z7);
        this.f27688g.getMetricsRealTime().setRequestBodyEndTime();
        this.f27688g.getMetricsTime().setRequestBodyEndTime();
        this.f27688g.getMetricsTime().setCallEndTime();
        this.f27688g.getMetricsRealTime().setCallEndTime();
        if (th2 instanceof Exception) {
            Exception exc = (Exception) th2;
            this.f27688g.setException(exc);
            this.f27689h.reportData(exc, f27679o);
        } else {
            Exception exc2 = new Exception(th2);
            this.f27688g.setException(exc2);
            this.f27689h.reportData(exc2, f27679o);
        }
        this.f27685d = c6127v7 == null ? null : m34956a(c6127v7);
        this.f27682a.onFailure(this.f27683b, th2, this.f27685d);
        CountDownLatch countDownLatch = this.f27684c;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
        if (this.f27693l == 0 || this.f27692k.size() <= 0) {
            return;
        }
        try {
            this.f27690i.setPingResult(false, this.f27691j, this.f27692k);
        } catch (Throwable unused) {
            Logger.m32145w(f27678n, "PingResult error on onFailure");
        }
    }

    @Override // com.huawei.hms.network.embedded.AbstractC5851a8
    public void onMessage(InterfaceC6179z7 interfaceC6179z7, C5910eb c5910eb) {
        this.f27682a.onMessage(this.f27683b, c5910eb.mo34195m());
        this.f27690i.counting(2);
    }

    @Override // com.huawei.hms.network.embedded.AbstractC5851a8
    public void onOpen(InterfaceC6179z7 interfaceC6179z7, C6127v7 c6127v7) {
        m34959a(interfaceC6179z7);
        this.f27688g.getMetricsTime().setCallEndTime();
        this.f27688g.getMetricsRealTime().setCallEndTime();
        this.f27689h.setOnOpenTime(System.currentTimeMillis());
        this.f27690i.setOnOpenTime(System.currentTimeMillis());
        this.f27685d = m34956a(c6127v7);
        this.f27682a.onOpen(this.f27683b, this.f27685d);
        CountDownLatch countDownLatch = this.f27684c;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    @Override // com.huawei.hms.network.embedded.AbstractC5851a8
    public void onReadPong(long j10, LinkedList<Long> linkedList) {
        super.onReadPong(j10, linkedList);
        if (this.f27693l == 0 || !this.f27690i.aiPingEnable()) {
            return;
        }
        this.f27692k.clear();
        this.f27692k.addAll(linkedList);
        try {
            int pingResult = this.f27690i.setPingResult(true, this.f27691j, linkedList);
            if (pingResult != 0) {
                ((C5968j4) this.f27683b).resetPingIntervalOnReadPong(pingResult);
            } else {
                Logger.m32136d(f27678n, "PingResult ping is:" + pingResult);
            }
        } catch (Throwable unused) {
            Logger.m32145w(f27678n, "PingResult error on onReadPong");
        }
    }

    public void onSend() {
        this.f27690i.counting(1);
    }

    public void predictorModel() {
        this.f27694m.execute(new a());
    }

    /* renamed from: a */
    private C5939h1.f<ResponseBody> m34956a(C6127v7 c6127v7) {
        AbstractC6140w7 abstractC6140w7M35585s = c6127v7.m35585s();
        String strM34521a = c6127v7.m35591y().m34521a("Content-Type");
        C5913f1 c5913f1Build = null;
        C6036o7 c6036o7M34923b = strM34521a != null ? C6036o7.m34923b(strM34521a) : null;
        if (abstractC6140w7M35585s != null) {
            c5913f1Build = new C5913f1.b().inputStream(abstractC6140w7M35585s.m35736s()).contentLength(abstractC6140w7M35585s.mo34710v()).charSet(c6036o7M34923b != null ? c6036o7M34923b.m34924a() : null).contentType(c6036o7M34923b != null ? c6036o7M34923b.m34927c() : "").build();
        }
        C6107u0.b bVar = new C6107u0.b();
        if (c5913f1Build != null) {
            bVar.body(new C5939h1.g(c5913f1Build));
        }
        bVar.headers(m34957a(c6127v7.m35591y())).code(c6127v7.m35589w()).message(c6127v7.m35572B()).url(c6127v7.m35578H().m35423k().toString());
        return new C5939h1.f<>(bVar.build());
    }

    @Override // com.huawei.hms.network.embedded.AbstractC5851a8
    public void onMessage(InterfaceC6179z7 interfaceC6179z7, String str) {
        this.f27682a.onMessage(this.f27683b, str);
        this.f27690i.counting(2);
    }

    /* renamed from: a */
    private Map<String, List<String>> m34957a(C5971j7 c5971j7) {
        Headers.Builder builder = new Headers.Builder();
        int iM34527d = c5971j7.m34527d();
        for (int i10 = 0; i10 < iM34527d; i10++) {
            builder.add(c5971j7.m34520a(i10), c5971j7.m34522b(i10));
        }
        return builder.build().toMultimap();
    }

    /* renamed from: a */
    private void m34958a() {
        this.f27689h = new C6058q3(this.f27688g, this.f27687f);
        String str = this.f27687f.getNetConfig().getMap("core_metrics_data").get("trace_id");
        int iEnableDynamicPing = this.f27687f.getNetConfig().enableDynamicPing();
        this.f27693l = iEnableDynamicPing;
        C6071r3 c6071r3 = new C6071r3(iEnableDynamicPing, this.f27691j, str);
        this.f27690i = c6071r3;
        this.f27689h.setPingIntervalManager(c6071r3);
        this.f27692k = new LinkedList<>();
        Logger.m32136d(f27678n, "init actionType is:" + this.f27693l);
    }

    /* renamed from: a */
    private void m34959a(InterfaceC6179z7 interfaceC6179z7) {
        if (interfaceC6179z7 instanceof C6117ua) {
            C6117ua c6117ua = (C6117ua) interfaceC6179z7;
            this.f27689h.setPingPongDelayList(c6117ua.m35539d());
            C5928g3 listener = C6032o3.getWebSocketEventFactory().getListener(c6117ua.m35537c());
            if (listener == null || !(listener instanceof C6032o3)) {
                return;
            }
            C5993l3 webSocketRequestFinishedInfo = ((C6032o3) listener).getWebSocketRequestFinishedInfo();
            this.f27688g = webSocketRequestFinishedInfo;
            if (webSocketRequestFinishedInfo == null) {
                Logger.m32141i(f27678n, "webSocketRequestFinishedInfo is null");
                this.f27688g = new C5993l3();
            }
            this.f27688g.getMetricsTime().setPingInterval(this.f27687f.getNetConfig().getPingInterval());
            this.f27689h.setRequestFinishedInfo(this.f27688g);
            this.f27690i.setRequestFinishedInfo(this.f27688g);
        }
    }
}
