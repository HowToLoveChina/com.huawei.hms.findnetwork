package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.hianalytics.InitReport;
import com.huawei.hms.network.embedded.C5939h1;
import com.huawei.hms.network.httpclient.Interceptor;
import com.huawei.hms.network.httpclient.Response;
import com.huawei.hms.network.httpclient.ResponseBody;
import com.huawei.hms.network.httpclient.websocket.WebSocket;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import java.io.IOException;

/* renamed from: com.huawei.hms.network.embedded.w0 */
/* loaded from: classes8.dex */
public class C6133w0 extends Interceptor {

    /* renamed from: b */
    public static final String f28826b = "CallServerInterceptor";

    /* renamed from: a */
    public WebSocket f28827a;

    public C6133w0(WebSocket webSocket) {
        this.f28827a = webSocket;
    }

    /* renamed from: a */
    private C5939h1.d m35713a(C5939h1.d dVar) {
        for (String str : dVar.getHeaders().keySet()) {
            if (str != null && StringUtils.toLowerCase(str).equals(FeedbackWebConstants.USER_AGENT)) {
                return dVar;
            }
        }
        return new C5939h1.d(dVar.newBuilder().addHeader("User-Agent", C5965j1.getUserAgent(ContextHolder.getAppContext())).build());
    }

    @Override // com.huawei.hms.network.httpclient.Interceptor
    public Response<ResponseBody> intercept(Interceptor.Chain chain) throws IOException {
        if (!(chain instanceof C5939h1.b)) {
            throw new ClassCastException("the classType has error!,please use SafeApi.SafeChain");
        }
        C5939h1.b bVar = (C5939h1.b) chain;
        AbstractC6174z2 rCEventListener = bVar.getRCEventListener();
        C5939h1.d dVarM35713a = m35713a(bVar.request());
        C5939h1.d dVarTraceRequestNetworkKitOutEvent = C5929g4.getInstance().traceRequestNetworkKitOutEvent(dVarM35713a);
        rCEventListener.rcNetworkInterceptorReqEnd(dVarM35713a);
        if (!InitReport.isHasConnectNet()) {
            InitReport.enableConnectNet();
            NetworkUtil.updateCurrentNetworkType();
        }
        C5939h1.f<ResponseBody> fVarExecute = bVar.getRequestTask().execute(dVarTraceRequestNetworkKitOutEvent, this.f28827a);
        rCEventListener.rcNetworkInterceptorResStart();
        C5929g4.getInstance().traceResponseNetworkKitInEvent(rCEventListener);
        return fVarExecute;
    }
}
