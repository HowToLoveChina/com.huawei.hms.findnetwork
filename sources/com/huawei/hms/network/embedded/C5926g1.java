package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.network.embedded.C5939h1;
import com.huawei.hms.network.embedded.InterfaceC5886d1;
import com.huawei.hms.network.httpclient.Interceptor;
import com.huawei.hms.network.httpclient.Request;
import com.huawei.hms.network.httpclient.Response;
import com.huawei.hms.network.httpclient.ResponseBody;
import com.huawei.hms.network.httpclient.util.PreConnectManager;
import com.huawei.hms.network.inner.api.DnsNetworkService;
import com.huawei.hms.network.inner.api.NetworkKitInnerImpl;
import com.huawei.hms.network.inner.api.NetworkService;
import com.huawei.hms.network.inner.api.RequestContext;
import java.io.IOException;
import org.json.JSONException;

/* renamed from: com.huawei.hms.network.embedded.g1 */
/* loaded from: classes8.dex */
public class C5926g1 extends Interceptor {

    /* renamed from: h */
    public static final String f26790h = "RetryInterceptor";

    /* renamed from: i */
    public static final int f26791i = 429;

    /* renamed from: a */
    public int f26792a = 0;

    /* renamed from: b */
    public long f26793b = 0;

    /* renamed from: c */
    public volatile boolean f26794c;

    /* renamed from: d */
    public InterfaceC5886d1 f26795d;

    /* renamed from: e */
    public final C5844a1 f26796e;

    /* renamed from: f */
    public final C6123v3 f26797f;

    /* renamed from: g */
    public final DnsNetworkService f26798g;

    public C5926g1(RequestContext requestContext, C5844a1 c5844a1) {
        this.f26797f = (C6123v3) requestContext;
        this.f26796e = c5844a1;
        NetworkService service = NetworkKitInnerImpl.getInstance().getService("dns");
        if (!(service instanceof DnsNetworkService)) {
            throw new IllegalStateException("DNS service is not available");
        }
        this.f26798g = (DnsNetworkService) service;
    }

    /* renamed from: a */
    private void m34280a(C6123v3 c6123v3, Request request, String str) {
        c6123v3.setRequest(request);
        c6123v3.setChannel(str);
        c6123v3.setResponse(null);
        c6123v3.setThrowable(null);
        c6123v3.setRequestFinishedInfo(null);
    }

    /* renamed from: b */
    private void m34285b(Request request) {
        this.f26797f.setThrowable(null);
        this.f26797f.setResponse(null);
    }

    public void cancel() {
        this.f26794c = true;
        InterfaceC5886d1 interfaceC5886d1 = this.f26795d;
        if (interfaceC5886d1 != null) {
            interfaceC5886d1.cancel();
        }
    }

    public InterfaceC5886d1 getRequestTask() {
        return this.f26795d;
    }

    @Override // com.huawei.hms.network.httpclient.Interceptor
    public Response intercept(Interceptor.Chain chain) throws JSONException, IOException {
        Response<ResponseBody> responseProceed;
        C5939h1.d dVar;
        if (!(chain instanceof C5939h1.b)) {
            throw new ClassCastException("the classType has error!,please use SafeApi.SafeChain");
        }
        C5939h1.b bVar = (C5939h1.b) chain;
        AbstractC6174z2 rCEventListener = bVar.getRCEventListener();
        rCEventListener.cpApplicationInterceptorReqEnd();
        Request request = chain.request();
        this.f26797f.setRequest(request);
        this.f26798g.beginEachRequest(this.f26797f);
        while (!isCanceled()) {
            InterfaceC5886d1.a factory = this.f26796e.getFactory(request);
            this.f26795d = factory.newTask();
            m34280a(this.f26797f, request, factory.getChannel());
            try {
                if (this.f26792a == 0) {
                    this.f26793b = C5952i1.requestDiscreteControl(request);
                }
                Logger.m32143v(f26790h, "waitingTime: " + this.f26793b);
                rCEventListener.retryInterceptorStart(request, this.f26795d, this.f26793b);
                m34285b(request);
                responseProceed = bVar.proceed(this.f26797f, this.f26795d);
                m34282a(responseProceed);
                rCEventListener.retryInterceptorEnd(responseProceed, this.f26796e);
                dVar = (C5939h1.d) request;
            } catch (IOException e10) {
                rCEventListener.retryInterceptorFailed(e10);
                m34283a(e10);
                if (!m34284a(request, this.f26796e)) {
                    Logger.m32145w(f26790h, "intercept IOException end");
                    m34281a(request);
                    rCEventListener.cpApplicationInterceptorResStart();
                    throw e10;
                }
                Logger.m32146w(f26790h, "intercept IOException, retry " + this.f26792a + ", code = " + C5955i4.getErrorCodeFromException(e10), e10);
                this.f26793b = C5952i1.enableRetryIntervalBackoff(request, this.f26792a);
                this.f26792a = this.f26792a + 1;
            }
            if (!m34284a(request, this.f26796e) || !dVar.getNetConfig().enableTrafficControlWith429() || responseProceed.getCode() != 429) {
                rCEventListener.cpApplicationInterceptorResStart();
                return responseProceed;
            }
            this.f26793b = C5952i1.enableTrafficControlWith429(request, responseProceed);
            this.f26792a++;
        }
        throw C6094t0.m35373a("Canceled");
    }

    public boolean isCanceled() {
        InterfaceC5886d1 interfaceC5886d1;
        return this.f26794c || ((interfaceC5886d1 = this.f26795d) != null && interfaceC5886d1.isCanceled());
    }

    /* renamed from: a */
    private void m34281a(Request request) throws JSONException {
        InterfaceC5886d1 interfaceC5886d1 = this.f26795d;
        if (!(interfaceC5886d1 instanceof C5966j2) || interfaceC5886d1.isCanceled()) {
            return;
        }
        Logger.m32141i(f26790h, "Cronet request fail, fallback okhttp");
        C5888d3 c5888d3 = new C5888d3(request.getUrl());
        C5927g2.getInstance().updateQuicHints(c5888d3.getHost(), c5888d3.getPort(), false);
        PreConnectManager.getInstance().connect(c5888d3.getHost(), new PreConnectManager.ConnectCallBack());
    }

    /* renamed from: a */
    private void m34282a(Response<ResponseBody> response) {
        this.f26797f.setResponse(response);
        this.f26798g.endEachRequest(this.f26797f);
    }

    /* renamed from: a */
    private void m34283a(IOException iOException) {
        this.f26797f.setThrowable(iOException);
        this.f26797f.setCancel(isCanceled());
        this.f26798g.endEachRequest(this.f26797f);
    }

    /* renamed from: a */
    private boolean m34284a(Request request, C5844a1 c5844a1) {
        if (!(request instanceof C5939h1.d)) {
            return false;
        }
        C5939h1.d dVar = (C5939h1.d) request;
        if (dVar.getNetConfig().getRetryTimeOnConnectionFailure() <= 0 || this.f26792a >= dVar.getNetConfig().getRetryTimeOnConnectionFailure()) {
            return false;
        }
        return c5844a1.disableWeakNetworkRetry() || NetworkUtil.getCurrentNetworkType() != -1;
    }
}
