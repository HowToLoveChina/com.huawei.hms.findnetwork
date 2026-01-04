package com.huawei.hms.network.embedded;

import android.text.TextUtils;
import com.huawei.hms.framework.common.CheckParamUtils;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.network.base.common.Headers;
import com.huawei.hms.network.base.common.MediaType;
import com.huawei.hms.network.embedded.C5913f1;
import com.huawei.hms.network.embedded.C5939h1;
import com.huawei.hms.network.embedded.C6107u0;
import com.huawei.hms.network.httpclient.Request;
import com.huawei.hms.network.httpclient.RequestFinishedInfo;
import com.huawei.hms.network.httpclient.websocket.WebSocket;
import com.huawei.hms.network.inner.api.PolicyNetworkService;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import org.chromium.net.BidirectionalStream;
import org.chromium.net.CronetEngine;
import org.chromium.net.CronetException;
import org.chromium.net.ExperimentalBidirectionalStream;
import org.chromium.net.ExperimentalCronetEngine;
import org.chromium.net.ExperimentalUrlRequest;
import org.chromium.net.UploadDataProvider;
import org.chromium.net.UrlRequest;
import org.chromium.net.UrlResponseInfo;

/* renamed from: com.huawei.hms.network.embedded.j2 */
/* loaded from: classes8.dex */
public class C5966j2 implements InterfaceC5886d1 {

    /* renamed from: A */
    public static final String f27075A = "received_packet_estimated_bandwidth_bps";

    /* renamed from: B */
    public static final int f27076B = 50;

    /* renamed from: s */
    public static final String f27077s = "j2";

    /* renamed from: t */
    public static final String f27078t = "Content-Length";

    /* renamed from: u */
    public static final String f27079u = "Content-Encoding";

    /* renamed from: v */
    public static final String f27080v = "Accept-Encoding";

    /* renamed from: w */
    public static final String f27081w = "content-length";

    /* renamed from: x */
    public static final int f27082x = 5;

    /* renamed from: y */
    public static final int f27083y = 16384;

    /* renamed from: z */
    public static final long f27084z = 10;

    /* renamed from: a */
    public final CronetEngine f27085a;

    /* renamed from: c */
    public final C5979k2 f27087c;

    /* renamed from: d */
    public UrlRequest f27088d;

    /* renamed from: f */
    public UrlResponseInfo f27090f;

    /* renamed from: g */
    public IOException f27091g;

    /* renamed from: h */
    public boolean f27092h;

    /* renamed from: i */
    public boolean f27093i;

    /* renamed from: j */
    public C5939h1.d f27094j;

    /* renamed from: k */
    public boolean f27095k;

    /* renamed from: l */
    public volatile boolean f27096l;

    /* renamed from: n */
    public boolean f27098n;

    /* renamed from: o */
    public AbstractC6174z2 f27099o;

    /* renamed from: p */
    public ExperimentalBidirectionalStream f27100p;

    /* renamed from: q */
    public CountDownLatch f27101q = new CountDownLatch(1);

    /* renamed from: r */
    public volatile int f27102r = 0;

    /* renamed from: b */
    public final ExecutorC5992l2 f27086b = new ExecutorC5992l2();

    /* renamed from: e */
    public C5914f2 f27089e = new C5914f2(this);

    /* renamed from: m */
    public RequestFinishedInfo f27097m = new C5953i2();

    /* renamed from: com.huawei.hms.network.embedded.j2$b */
    public class b extends BidirectionalStream.Callback {

        /* renamed from: a */
        public LinkedBlockingQueue<Object> f27103a;

        public b() {
        }

        @Override // org.chromium.net.BidirectionalStream.Callback
        public void onCanceled(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo) {
            C5966j2.this.f27090f = urlResponseInfo;
            C5966j2.this.m34463a(new IOException("disconnect() called"));
        }

        @Override // org.chromium.net.BidirectionalStream.Callback
        public void onFailed(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, CronetException cronetException) {
            if (cronetException == null) {
                throw new IllegalStateException("Exception cannot be null in onFailed.");
            }
            C5966j2.this.f27090f = urlResponseInfo;
            ((C5953i2) C5966j2.this.f27097m).setException(cronetException);
            C5966j2.this.m34463a(cronetException);
        }

        @Override // org.chromium.net.BidirectionalStream.Callback
        public void onReadCompleted(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer, boolean z10) {
            C5966j2.this.f27090f = urlResponseInfo;
            C5966j2.this.f27093i = true;
            C5966j2.this.f27086b.quit();
        }

        @Override // org.chromium.net.BidirectionalStream.Callback
        public void onResponseHeadersReceived(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo) {
            ((C5953i2) C5966j2.this.f27097m).getMetrics().setProtocol(urlResponseInfo.getNegotiatedProtocol());
            C5966j2.this.f27090f = urlResponseInfo;
            C5966j2.this.f27093i = true;
            try {
                bidirectionalStream.read(ByteBuffer.allocateDirect(16384));
            } catch (RuntimeException unused) {
                Logger.m32145w(C5966j2.f27077s, "Unexpected read attempt");
            }
            C5966j2.this.f27101q.countDown();
        }

        @Override // org.chromium.net.BidirectionalStream.Callback
        public void onStreamReady(BidirectionalStream bidirectionalStream) {
            this.f27103a = new LinkedBlockingQueue<>(5);
            if (C5966j2.this.f27094j.getBody() != null) {
                try {
                    C5966j2.this.f27094j.getBody().writeTo(new C5859b2(C5966j2.this.f27100p, C5966j2.this.f27094j.getBody(), this.f27103a));
                } catch (IOException unused) {
                    Logger.m32145w(C5966j2.f27077s, "data stream writing exception");
                }
            }
            bidirectionalStream.flush();
        }

        @Override // org.chromium.net.BidirectionalStream.Callback
        public void onSucceeded(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo) {
            C5966j2.this.f27090f = urlResponseInfo;
            C5966j2.this.m34463a((IOException) null);
        }

        @Override // org.chromium.net.BidirectionalStream.Callback
        public void onWriteCompleted(BidirectionalStream bidirectionalStream, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer, boolean z10) {
            try {
                C5966j2.this.f27090f = urlResponseInfo;
                this.f27103a.poll();
            } catch (IllegalArgumentException unused) {
                Logger.m32145w(C5966j2.f27077s, "queue extraction exception");
            }
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.j2$c */
    public class c extends UrlRequest.Callback {
        public c() {
        }

        @Override // org.chromium.net.UrlRequest.Callback
        public void onCanceled(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            Logger.m32143v(C5966j2.f27077s, "onCanceled:");
            C5966j2.this.f27090f = urlResponseInfo;
            C5966j2.this.m34468a(urlResponseInfo);
            C5966j2.this.m34463a(new IOException("disconnect() called"));
        }

        @Override // org.chromium.net.UrlRequest.Callback
        public void onFailed(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, CronetException cronetException) {
            if (cronetException == null) {
                throw new IllegalStateException("Exception cannot be null in onFailed.");
            }
            C5966j2.this.f27090f = urlResponseInfo;
            C5966j2.this.m34468a(urlResponseInfo);
            ((C5953i2) C5966j2.this.f27097m).setException(cronetException);
            C5966j2.this.m34463a(cronetException);
        }

        @Override // org.chromium.net.UrlRequest.Callback
        public void onReadCompleted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
            C5966j2.this.f27090f = urlResponseInfo;
            C5966j2.this.f27086b.quit();
        }

        @Override // org.chromium.net.UrlRequest.Callback
        public void onRedirectReceived(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
            Logger.m32144v(C5966j2.f27077s, "onRedirectReceived newLocationUrl: %s", str);
            C5966j2.this.f27092h = true;
            try {
                boolean zEquals = new URL(str).getProtocol().equals(C5966j2.this.m34483f());
                if (C5966j2.this.f27087c.getPolicyExecutor() == null || StringUtils.stringToBoolean(C5966j2.this.f27087c.getPolicyExecutor().getValue("", PolicyNetworkService.ClientConstants.FOLLOW_REDIRECTS), true)) {
                    if (zEquals) {
                        C5966j2.this.f27088d.followRedirect();
                        return;
                    }
                }
            } catch (MalformedURLException e10) {
                Logger.m32143v(C5966j2.f27077s, "onRedirectReceived occur exception:" + e10.getClass().getSimpleName());
            }
            C5966j2.this.f27090f = urlResponseInfo;
            C5966j2.this.f27088d.cancel();
            C5966j2.this.m34463a((IOException) null);
        }

        @Override // org.chromium.net.UrlRequest.Callback
        public void onResponseStarted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            ((C5953i2) C5966j2.this.f27097m).getMetrics().setProtocol(urlResponseInfo.getNegotiatedProtocol());
            C5966j2.this.f27090f = urlResponseInfo;
            C5966j2.this.f27093i = true;
            C5966j2.this.f27086b.quit();
        }

        @Override // org.chromium.net.UrlRequest.Callback
        public void onSucceeded(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            Logger.m32143v(C5966j2.f27077s, "onSucceeded:");
            C5966j2.this.f27090f = urlResponseInfo;
            C5966j2.this.m34468a(urlResponseInfo);
            C5966j2.this.m34463a((IOException) null);
        }
    }

    public C5966j2(CronetEngine cronetEngine, C5979k2 c5979k2) {
        this.f27085a = cronetEngine;
        this.f27087c = c5979k2;
    }

    /* renamed from: a */
    private long m34457a(HashMap<String, List<String>> map) {
        if (m34492a(map, f27081w, -1L) > 2147483647L) {
            return -1L;
        }
        return (int) r5;
    }

    /* renamed from: d */
    private Map<String, List<String>> m34478d() {
        return this.f27090f.getAllHeaders();
    }

    /* renamed from: e */
    private String m34480e() {
        return m34493a("content-type");
    }

    /* renamed from: g */
    private int m34484g() {
        return this.f27094j.getNetConfig().getReadTimeout();
    }

    /* renamed from: i */
    private C5939h1.f m34488i() throws IOException {
        m34487h();
        int httpStatusCode = this.f27090f.getHttpStatusCode();
        HashMap<String, List<String>> map = new HashMap<>();
        map.putAll(this.f27090f.getAllHeaders());
        if (m34475b(map, "Content-Encoding")) {
            m34475b(map, "Content-Length");
        }
        if (this.f27096l) {
            disconnect();
            throw C6094t0.m35373a("Canceled");
        }
        C5913f1.b bVar = new C5913f1.b();
        String strM34480e = m34480e();
        MediaType mediaType = strM34480e != null ? MediaType.parse(strM34480e) : null;
        bVar.inputStream(httpStatusCode >= 400 ? getErrorStream() : getInputStream()).contentLength(m34457a(map)).contentType(strM34480e).charSet(mediaType != null ? mediaType.charset() : null);
        C5913f1 c5913f1Build = bVar.build();
        String url = this.f27090f.getUrl() != null ? this.f27090f.getUrl() : this.f27094j.getUrl();
        C6107u0.b bVar2 = new C6107u0.b();
        bVar2.body(new C5939h1.g(c5913f1Build)).code(httpStatusCode).message(this.f27090f.getHttpStatusText()).url(url).headers(map);
        if (!this.f27096l) {
            return new C5939h1.f(bVar2.build());
        }
        disconnect();
        throw C6094t0.m35373a("Canceled");
    }

    /* renamed from: j */
    private void m34489j() {
        if (this.f27094j.getBody() == null || !this.f27094j.getBody().isDuplex()) {
            if (this.f27088d.isDone()) {
                return;
            } else {
                this.f27088d.cancel();
            }
        } else if (this.f27100p.isDone()) {
            return;
        } else {
            this.f27100p.cancel();
        }
        try {
            this.f27086b.loop(50);
        } catch (Exception e10) {
            Logger.m32145w(f27077s, "disconnect loop failed " + e10.getMessage());
        }
    }

    /* renamed from: k */
    private void m34490k() throws IOException {
        if (this.f27098n) {
            return;
        }
        ExperimentalBidirectionalStream.Builder builderNewBidirectionalStreamBuilder = ((ExperimentalCronetEngine) this.f27085a).newBidirectionalStreamBuilder(this.f27094j.getUrl() == null ? "" : this.f27094j.getUrl(), new b(), this.f27086b);
        String method = this.f27094j.getMethod();
        builderNewBidirectionalStreamBuilder.addRequestAnnotation(this);
        m34465a(builderNewBidirectionalStreamBuilder, Headers.m33636of(this.f27094j.getHeaders()));
        if (this.f27094j.getBody() != null && method.equals("GET")) {
            method = "POST";
        }
        builderNewBidirectionalStreamBuilder.setHttpMethod(method);
        ExperimentalBidirectionalStream experimentalBidirectionalStreamBuild = builderNewBidirectionalStreamBuilder.build();
        this.f27100p = experimentalBidirectionalStreamBuild;
        experimentalBidirectionalStreamBuild.start();
        this.f27098n = true;
    }

    /* renamed from: l */
    private void m34491l() throws IOException {
        if (this.f27098n) {
            return;
        }
        Map<String, List<String>> headers = this.f27094j.getHeaders();
        m34475b(headers, f27080v);
        ExperimentalUrlRequest.Builder builder = (ExperimentalUrlRequest.Builder) this.f27085a.newUrlRequestBuilder(this.f27094j.getUrl() == null ? "" : this.f27094j.getUrl(), new c(), this.f27086b);
        builder.addRequestAnnotation(this);
        String method = this.f27094j.getMethod();
        m34466a(builder, Headers.m33636of(headers));
        if (this.f27094j.getBody() != null) {
            if (method.equals("GET")) {
                method = "POST";
            }
            if (TextUtils.isEmpty(m34472b("Content-Length"))) {
                m34467a(builder, "Content-Length", this.f27094j.getBody().contentLength() + "");
            }
            Logger.m32141i(f27077s, "using cronet to request" + this.f27094j.getBody().contentLength());
            C6175z3 c6175z3 = new C6175z3(this.f27094j, this.f27086b);
            builder.setUploadDataProvider((UploadDataProvider) c6175z3, (Executor) this.f27086b);
            m34467a(builder, "Content-Type", this.f27094j.getBody().contentType());
            if (TextUtils.isEmpty(m34472b("Content-Length"))) {
                m34467a(builder, "Content-Length", "" + c6175z3.getLength());
            }
        }
        builder.setHttpMethod(method);
        if (!this.f27087c.isEnableConnectionMigrated()) {
            builder.disableConnectionMigration();
        }
        ExperimentalUrlRequest experimentalUrlRequestBuild = builder.build();
        this.f27088d = experimentalUrlRequestBuild;
        experimentalUrlRequestBuild.start();
        this.f27098n = true;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5886d1
    public void cancel() {
        this.f27096l = true;
        disconnect();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5886d1
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public InterfaceC5886d1 m85657clone() {
        return new C5966j2(this.f27085a, this.f27087c);
    }

    public void disconnect() {
        if (this.f27098n) {
            m34489j();
        }
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5886d1
    public C5939h1.f execute(C5939h1.d dVar, WebSocket webSocket) throws IOException {
        String str = f27077s;
        Logger.m32141i(str, "the request has used the cronet!");
        if (webSocket != null) {
            Logger.m32145w(str, "cronet can't use websocket");
            throw C6094t0.m35379d("cronet can't use websocket");
        }
        CheckParamUtils.checkNotNull(dVar, "request == null");
        synchronized (this) {
            if (this.f27095k) {
                throw new IllegalStateException("Already executed");
            }
            this.f27095k = true;
        }
        if (this.f27096l) {
            throw C6094t0.m35373a("Canceled");
        }
        if (HianalyticsHelper.getInstance().isQuicEnableReport(ContextHolder.getAppContext()) && C5929g4.getInstance().addQuicTrace()) {
            Request.Builder builderNewBuilder = dVar.newBuilder();
            C5929g4.getInstance().addUUIDWithoutDash(builderNewBuilder, dVar.getHeaders());
            this.f27094j = new C5939h1.d(builderNewBuilder.build());
        } else {
            this.f27094j = dVar;
        }
        m34460a(dVar);
        if (!this.f27096l) {
            return m34488i();
        }
        disconnect();
        throw C6094t0.m35373a("Canceled");
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5886d1
    public C5902e3 getConnectionInfo() {
        return null;
    }

    public InputStream getErrorStream() {
        try {
            m34487h();
            if (this.f27090f.getHttpStatusCode() >= 400) {
                return this.f27089e;
            }
        } catch (IOException unused) {
        }
        return null;
    }

    public InputStream getInputStream() throws IOException {
        m34487h();
        return this.f27089e;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5886d1
    public RequestFinishedInfo getRequestFinishedInfo() {
        return this.f27097m;
    }

    public UrlResponseInfo getResponseInfo() {
        return this.f27090f;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5886d1
    public boolean isCanceled() {
        return this.f27096l;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5886d1
    public synchronized boolean isExecuted() {
        return this.f27095k;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5886d1
    public C5939h1.d request() {
        return this.f27094j;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5886d1
    public void setRcEventListener(AbstractC6174z2 abstractC6174z2) {
        this.f27099o = abstractC6174z2;
    }

    public void setReadStatus(int i10) {
        this.f27102r = i10;
    }

    /* renamed from: c */
    private void m34477c() throws IOException {
        if (!this.f27093i) {
            throw new IllegalStateException("No response.");
        }
        IOException iOException = this.f27091g;
        if (iOException != null) {
            throw iOException;
        }
        if (this.f27090f == null) {
            throw new NullPointerException("Response info is null when there is no exception.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public String m34483f() {
        try {
            return new URL(this.f27094j.getUrl()).getProtocol();
        } catch (MalformedURLException e10) {
            Logger.m32144v(f27077s, "getProtocol failed, Exception:%s", e10.getClass().getSimpleName());
            return "";
        }
    }

    /* renamed from: h */
    private void m34487h() throws IOException {
        if (!this.f27093i) {
            m34460a(this.f27094j);
            this.f27086b.loop(m34484g());
        }
        m34477c();
    }

    /* renamed from: a */
    public long m34492a(HashMap<String, List<String>> map, String str, long j10) {
        String strM34459a = m34459a(map, str);
        if (!TextUtils.isEmpty(strM34459a)) {
            try {
                return Long.parseLong(strM34459a);
            } catch (NumberFormatException e10) {
                Logger.m32147w(f27077s, "getHeaderFieldLong failed, Exception:%s", e10.getClass().getSimpleName());
                return j10;
            }
        }
        Logger.m32145w(f27077s, "getHeaderFieldLong value null,name is " + str);
        return j10;
    }

    /* renamed from: b */
    private String m34472b(String str) {
        return Headers.m33636of(this.f27094j.getHeaders()).get(str);
    }

    /* renamed from: a */
    public final String m34493a(String str) {
        try {
            m34487h();
            return m34459a(m34478d(), str);
        } catch (IOException unused) {
            return null;
        }
    }

    /* renamed from: a */
    private String m34459a(Map<String, List<String>> map, String str) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        for (String str2 : map.keySet()) {
            if (str.equalsIgnoreCase(str2)) {
                List<String> list = map.get(str2);
                if (list == null || list.isEmpty()) {
                    return null;
                }
                return list.get(list.size() - 1);
            }
        }
        return null;
    }

    /* renamed from: b */
    private boolean m34475b(Map<String, List<String>> map, String str) {
        boolean z10 = false;
        if (str == null) {
            return false;
        }
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (str.equalsIgnoreCase(it.next())) {
                it.remove();
                z10 = true;
            }
        }
        return z10;
    }

    /* renamed from: a */
    public void m34494a() {
        String str = f27077s;
        Logger.m32143v(str, "onRequestFinish");
        if (this.f27099o != null) {
            Logger.m32143v(str, "callback rcEventListener#callFinishAtNetLib");
            this.f27099o.callFinishAtNetLib(this.f27102r);
        }
    }

    /* renamed from: a */
    private void m34460a(C5939h1.d dVar) throws IOException {
        if (dVar.getBody() == null || !dVar.getBody().isDuplex()) {
            m34491l();
        } else {
            m34490k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m34463a(IOException iOException) {
        this.f27091g = iOException;
        C5914f2 c5914f2 = this.f27089e;
        if (c5914f2 != null) {
            c5914f2.m34211a(iOException);
        }
        this.f27093i = true;
        this.f27086b.quit();
    }

    /* renamed from: a */
    public void m34495a(ByteBuffer byteBuffer) throws IOException {
        if (this.f27094j.getBody() == null || !this.f27094j.getBody().isDuplex()) {
            this.f27088d.read(byteBuffer);
        } else {
            try {
                if (!this.f27101q.await(10L, TimeUnit.SECONDS)) {
                    throw new IOException("Duplex read body timeout");
                }
                this.f27100p.read(byteBuffer);
            } catch (InterruptedException e10) {
                Logger.m32139e(f27077s, "getMoreData await error", e10);
            } catch (RuntimeException unused) {
                Logger.m32138e(f27077s, "Duplex getMoreData error");
            }
        }
        this.f27086b.loop(m34484g());
    }

    /* renamed from: a */
    private void m34464a(Map<String, String> map) {
        String str = map.get(f27075A);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            C5991l1.getInstance().onBandwidthMessageReceived(str, this.f27094j.getUrl());
        } catch (Exception unused) {
            Logger.m32145w(f27077s, "the receivedPacketEstimatedBandwidthBps has exception");
        }
    }

    /* renamed from: a */
    private void m34465a(ExperimentalBidirectionalStream.Builder builder, Headers headers) {
        if (builder == null || headers == null) {
            return;
        }
        boolean z10 = false;
        for (int i10 = 0; i10 < headers.size(); i10++) {
            String strName = headers.name(i10);
            builder.addHeader(strName, headers.value(i10));
            if (!z10 && StringUtils.toLowerCase(strName).equals(FeedbackWebConstants.USER_AGENT)) {
                z10 = true;
            }
        }
        if (z10) {
            return;
        }
        builder.addHeader("User-Agent", C5965j1.getUserAgent(ContextHolder.getAppContext()));
    }

    /* renamed from: a */
    private void m34466a(UrlRequest.Builder builder, Headers headers) {
        if (builder == null || headers == null) {
            return;
        }
        boolean z10 = false;
        for (int i10 = 0; i10 < headers.size(); i10++) {
            String strName = headers.name(i10);
            builder.addHeader(strName, headers.value(i10));
            if (!z10 && StringUtils.toLowerCase(strName).equals(FeedbackWebConstants.USER_AGENT)) {
                z10 = true;
            }
        }
        if (z10) {
            return;
        }
        builder.addHeader("User-Agent", C5965j1.getUserAgent(ContextHolder.getAppContext()));
    }

    /* renamed from: a */
    private void m34467a(UrlRequest.Builder builder, String str, String str2) {
        if (str2 == null) {
            return;
        }
        builder.addHeader(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m34468a(UrlResponseInfo urlResponseInfo) {
        LinkedHashMap<String, String> quicStatsMap;
        if (urlResponseInfo == null || (quicStatsMap = C6018n2.getQuicStatsMap(urlResponseInfo)) == null || quicStatsMap.isEmpty()) {
            return;
        }
        m34464a((Map<String, String>) quicStatsMap);
        C6109u2 metrics = ((C5953i2) this.f27097m).getMetrics();
        String str = quicStatsMap.get(C6018n2.CONGESTION_CONTROL_TYPE);
        if (!TextUtils.isEmpty(str)) {
            metrics.setCongestionControlType(str);
        }
        String str2 = quicStatsMap.get(C6018n2.MULTIPATH_ALGORITHM);
        if (!TextUtils.isEmpty(str2)) {
            metrics.setMultipathAlgorithm(StringUtils.stringToInteger(str2, 0));
        }
        String str3 = quicStatsMap.get("server_ip");
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        metrics.setConnectIps(Arrays.asList(str3));
        metrics.setSuccessIp(str3);
    }
}
