package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.network.embedded.C5939h1;
import com.huawei.hms.network.httpclient.Interceptor;
import com.huawei.hms.network.httpclient.RequestFinishedInfo;
import com.huawei.hms.network.httpclient.Response;
import com.huawei.hms.network.httpclient.ResponseBody;
import com.huawei.hms.network.httpclient.Submit;
import com.huawei.hms.network.httpclient.websocket.WebSocket;
import com.huawei.hms.network.inner.api.InterceptorNetworkService;
import com.huawei.hms.network.inner.api.NetworkKitInnerImpl;
import com.huawei.hms.network.inner.api.NetworkService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.hms.network.embedded.p2 */
/* loaded from: classes8.dex */
public class C6044p2 {

    /* renamed from: h */
    public static final String f27669h = "InterceptorExecutor";

    /* renamed from: a */
    public final C5844a1 f27670a;

    /* renamed from: b */
    public final C5926g1 f27671b;

    /* renamed from: c */
    public final WebSocket f27672c;

    /* renamed from: d */
    public final AbstractC6174z2 f27673d;

    /* renamed from: e */
    public C5939h1.d f27674e;

    /* renamed from: f */
    public final C6136w3 f27675f;

    /* renamed from: g */
    public RequestFinishedInfo f27676g;
    public C6123v3 requestContext = new C6123v3();

    /* renamed from: com.huawei.hms.network.embedded.p2$a */
    public class a extends C6136w3 {
        public a() {
        }

        @Override // com.huawei.hms.network.embedded.C6136w3
        public void timedOut() {
            C6044p2.this.f27673d.cancel();
            C6044p2.this.f27671b.cancel();
        }
    }

    public C6044p2(Submit<ResponseBody> submit, C5844a1 c5844a1, C5939h1.d dVar, WebSocket webSocket) {
        this.f27670a = c5844a1;
        this.f27674e = dVar;
        this.f27672c = webSocket;
        this.f27673d = webSocket == null ? c5844a1.getEventListenerFactory().create(submit) : AbstractC6174z2.NONE;
        this.f27673d.acquireClient(c5844a1);
        this.f27671b = new C5926g1(this.requestContext, c5844a1);
        a aVar = new a();
        this.f27675f = aVar;
        aVar.timeout(dVar.getNetConfig().getCallTimeout(), TimeUnit.MILLISECONDS);
    }

    public void cancel() {
        this.f27673d.cancel();
        this.f27671b.cancel();
    }

    public Response<ResponseBody> execute() throws IOException {
        int callTimeout = this.f27674e.getNetConfig().getCallTimeout();
        int connectTimeout = this.f27674e.getNetConfig().getConnectTimeout();
        int readTimeout = this.f27674e.getNetConfig().getReadTimeout();
        int writeTimeout = this.f27674e.getNetConfig().getWriteTimeout();
        if (callTimeout != 0 && (callTimeout <= connectTimeout + readTimeout || callTimeout <= connectTimeout + writeTimeout)) {
            Logger.m32138e(f27669h, "callTimeout should be bigger than connectTimeout + readTimeout/writeTimeout. [callTimeout : " + callTimeout + ", connectTimeout : " + connectTimeout + ", readTimeout : " + readTimeout + ", writeTimeout : " + writeTimeout + "].");
        }
        this.f27673d.callStart();
        this.f27674e = C5929g4.getInstance().traceRequestNetworkKitInEvent(request());
        this.f27675f.enter();
        String channel = this.f27670a.getFactory(this.f27674e).getChannel();
        this.requestContext.setChannel(channel);
        this.requestContext.setRequest(request());
        this.f27670a.getPolicyExecutor().beginRequest(this.requestContext);
        if ((this.f27670a.getTrustManager() == null || this.f27670a.getSslSocketFactory() == null) && !"type_cronet".equals(channel)) {
            throw C6094t0.m35379d("The trustManager or sslSocketFactory of httpClient is null");
        }
        this.f27673d.acquireRequestStart();
        this.f27673d.acquireRequestEnd(request());
        this.requestContext.setConnectTimeout(this.f27674e.getNetConfig().getConnectTimeout());
        ArrayList arrayList = new ArrayList(this.f27670a.getInterceptors());
        this.f27673d.recordCpApplicationInterceptorNums(arrayList.size());
        ArrayList arrayList2 = new ArrayList(this.f27670a.getNetworkInterceptors());
        this.f27673d.recordCpNetworkInterceptorNums(arrayList2.size());
        for (NetworkService networkService : NetworkKitInnerImpl.getInstance().getAll()) {
            if (networkService instanceof InterceptorNetworkService) {
                InterceptorNetworkService interceptorNetworkService = (InterceptorNetworkService) networkService;
                boolean zIsNetworkInterceptor = interceptorNetworkService.isNetworkInterceptor();
                Interceptor interceptor = interceptorNetworkService.getInterceptor();
                if (zIsNetworkInterceptor) {
                    arrayList2.add(interceptor);
                } else {
                    arrayList.add(interceptor);
                }
            }
        }
        arrayList.add(this.f27671b);
        if (this.f27672c == null) {
            arrayList.add(new C6069r1(this.f27670a.getCache()));
            arrayList.add(new C6097t3());
        }
        arrayList.addAll(arrayList2);
        arrayList.add(new C6133w0(this.f27672c));
        try {
            Response<ResponseBody> responseProceed = new C5939h1.b(new C5858b1(this.f27670a, this.requestContext, arrayList, this.f27673d, 0, null)).proceed(request());
            m34952a((C6044p2) responseProceed);
            this.requestContext.setResponse(responseProceed);
            this.f27670a.getPolicyExecutor().endRequest(this.requestContext);
            this.f27673d.callEnd(responseProceed);
            this.f27675f.exit();
            Logger.m32141i(f27669h, "response code:" + responseProceed.getCode());
            return responseProceed;
        } catch (Throwable th2) {
            IOException iOExceptionM34951a = m34951a(th2);
            m34952a((C6044p2) iOExceptionM34951a);
            this.requestContext.setThrowable(iOExceptionM34951a);
            this.f27670a.getPolicyExecutor().endRequest(this.requestContext);
            this.f27673d.callFailed(iOExceptionM34951a);
            Logger.m32146w(f27669h, "request fail:", iOExceptionM34951a);
            throw iOExceptionM34951a;
        }
    }

    public C5844a1 getClient() {
        return this.f27670a;
    }

    public RequestFinishedInfo getFinishedInfo() {
        return this.f27676g;
    }

    public WebSocket getWebSocket() {
        return this.f27672c;
    }

    public boolean isCanceled() {
        return this.f27671b.isCanceled();
    }

    public C5939h1.d request() {
        return this.f27674e;
    }

    /* renamed from: a */
    public IOException m34954a(IOException iOException) {
        return !this.f27675f.exit() ? iOException : C6094t0.m35378c("Timeout", iOException);
    }

    /* renamed from: a */
    private IOException m34951a(Throwable th2) {
        if (th2 instanceof IOException) {
            return m34954a((IOException) th2);
        }
        IOException iOExceptionM35376b = C6094t0.m35376b(th2.getMessage(), th2);
        this.f27675f.exit();
        HianalyticsHelper.getInstance().reportException(th2, CrashHianalyticsData.EVENT_ID_CRASH);
        return iOExceptionM35376b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private <T> void m34952a(T t10) {
        if (this.f27671b.getRequestTask() == null) {
            this.f27676g = null;
        } else {
            RequestFinishedInfo requestFinishedInfo = this.f27671b.getRequestTask().getRequestFinishedInfo();
            this.f27676g = requestFinishedInfo;
            if (requestFinishedInfo instanceof AbstractC6070r2) {
                if (t10 instanceof Response) {
                    ((AbstractC6070r2) requestFinishedInfo).setResponse((Response) t10);
                } else if (t10 instanceof Exception) {
                    ((AbstractC6070r2) requestFinishedInfo).setException((Exception) t10);
                }
                ((AbstractC6070r2) this.f27676g).setNetMsgId(C5929g4.getInstance().getNetMsgIdFromRequest(this.f27674e));
            }
        }
        this.requestContext.setRequestFinishedInfo(this.f27676g);
    }
}
