package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.network.base.common.Headers;
import com.huawei.hms.network.embedded.C5939h1;
import com.huawei.hms.network.httpclient.Interceptor;
import com.huawei.hms.network.httpclient.Request;
import com.huawei.hms.network.httpclient.RequestFinishedInfo;
import com.huawei.hms.network.httpclient.Response;
import com.huawei.hms.network.httpclient.ResponseBody;
import com.huawei.hms.network.httpclient.util.PreConnectManager;

/* renamed from: com.huawei.hms.network.embedded.t3 */
/* loaded from: classes8.dex */
public class C6097t3 extends Interceptor {

    /* renamed from: a */
    public static final String f28384a = "RouteInterceptor";

    /* renamed from: b */
    public static final String f28385b = "alt-svc";

    /* renamed from: c */
    public static final String f28386c = ";";

    /* renamed from: d */
    public static final String f28387d = "=";

    /* renamed from: e */
    public static final String f28388e = ",";

    /* renamed from: a */
    private int m35406a(String str, String str2) {
        Logger.m32144v(f28384a, "the quicFiled is %s-%s", str, str2);
        if (str != null && !str2.isEmpty()) {
            String[] strArrSplit = str.split(";");
            for (int i10 = 0; i10 < strArrSplit.length; i10++) {
                if (strArrSplit[i10].contains(",")) {
                    for (String str3 : strArrSplit[i10].split(",")) {
                        String[] strArrSplit2 = str3.split("=");
                        if (strArrSplit2.length == 2 && str2.equals(strArrSplit2[0].trim())) {
                            return m35407a(strArrSplit2);
                        }
                    }
                } else {
                    String[] strArrSplit3 = strArrSplit[i10].split("=");
                    if (strArrSplit3.length == 2 && str2.equals(strArrSplit3[0].trim())) {
                        return m35407a(strArrSplit3);
                    }
                }
            }
        }
        return 0;
    }

    @Override // com.huawei.hms.network.httpclient.Interceptor
    public Response<ResponseBody> intercept(Interceptor.Chain chain) throws Throwable {
        RequestFinishedInfo requestFinishedInfo;
        if (!(chain instanceof C5939h1.b)) {
            throw new ClassCastException("the classType has error!,please use SafeApi.SafeChain");
        }
        C5939h1.b bVar = (C5939h1.b) chain;
        InterfaceC5886d1 requestTask = bVar.getRequestTask();
        Request requestM35252a = C6084s3.getInstance().m35252a((C5939h1.d) chain.request());
        C5888d3 c5888d3 = new C5888d3(requestM35252a.getUrl());
        String host = c5888d3.getHost();
        int port = c5888d3.getPort();
        AbstractC6174z2 rCEventListener = bVar.getRCEventListener();
        rCEventListener.cpNetworkInterceptorReqStart();
        RequestFinishedInfo requestFinishedInfo2 = null;
        requestFinishedInfo2 = null;
        try {
            try {
                Response<ResponseBody> responseProceed = chain.proceed(requestM35252a);
                if (requestTask != null) {
                    requestFinishedInfo = requestTask.getRequestFinishedInfo();
                    if (requestFinishedInfo != null) {
                        try {
                            Logger.m32144v(f28384a, "the net lib is %s", requestFinishedInfo.getNetworkSdkType());
                            Logger.m32144v(f28384a, "the protocol is %s", requestFinishedInfo.getMetrics().getProtocol());
                        } catch (Exception e10) {
                            e = e10;
                            requestFinishedInfo2 = requestFinishedInfo;
                            if ((requestTask instanceof C5966j2) && !requestTask.isCanceled() && requestTask.getRequestFinishedInfo().getException() == null) {
                                ((C5953i2) requestTask.getRequestFinishedInfo()).setException(e);
                            }
                            throw e;
                        } catch (Throwable th2) {
                            th = th2;
                            requestFinishedInfo2 = requestFinishedInfo;
                            if (requestFinishedInfo2 != null) {
                                RequestFinishedInfo.MetricsTime metricsRealTime = requestFinishedInfo2.getMetricsRealTime();
                                long secureConnectStartTime = metricsRealTime.getSecureConnectStartTime() - metricsRealTime.getConnectStartTime();
                                if (secureConnectStartTime <= 0) {
                                    secureConnectStartTime = metricsRealTime.getConnectEndTime() - metricsRealTime.getConnectStartTime();
                                }
                                C6084s3.getInstance().m35253a(secureConnectStartTime, host);
                            }
                            throw th;
                        }
                    }
                } else {
                    requestFinishedInfo = null;
                }
                Headers headersM33636of = responseProceed != null ? Headers.m33636of(responseProceed.getHeaders()) : null;
                C5844a1 realHttpclient = ((C5939h1.b) chain).getRealHttpclient();
                if (headersM33636of != null && realHttpclient != null && realHttpclient.isHttpClientEnableQuic()) {
                    String str = headersM33636of.get(f28385b);
                    String altSvcType = C5927g2.getInstance().getAltSvcType();
                    if (str != null && str.contains(altSvcType) && (requestTask instanceof C5967j3)) {
                        Logger.m32141i(f28384a, "has alt-svc, try to use quic");
                        port = m35406a(str, altSvcType);
                        Logger.m32144v(f28384a, "the port is %s", Integer.valueOf(port));
                        C5927g2.getInstance().updateQuicHints(host, port, true);
                    }
                    if (str == null && (requestTask instanceof C5966j2)) {
                        String host2 = NetworkUtil.getHost(responseProceed.getUrl());
                        Logger.m32141i(f28384a, "hasn't alt-svc, disable quic");
                        Logger.m32144v(f28384a, "Disable quic %s %d", host2, Integer.valueOf(port));
                        C5927g2.getInstance().updateQuicHints(host2, port, false);
                        PreConnectManager.getInstance().connect(host, new PreConnectManager.ConnectCallBack());
                    }
                }
                if (requestFinishedInfo != null) {
                    RequestFinishedInfo.MetricsTime metricsRealTime2 = requestFinishedInfo.getMetricsRealTime();
                    long secureConnectStartTime2 = metricsRealTime2.getSecureConnectStartTime() - metricsRealTime2.getConnectStartTime();
                    if (secureConnectStartTime2 <= 0) {
                        secureConnectStartTime2 = metricsRealTime2.getConnectEndTime() - metricsRealTime2.getConnectStartTime();
                    }
                    C6084s3.getInstance().m35253a(secureConnectStartTime2, host);
                }
                rCEventListener.cpNetworkInterceptorResEnd();
                return responseProceed;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e11) {
            e = e11;
        }
    }

    /* renamed from: a */
    private int m35407a(String[] strArr) {
        String strReplace = StringUtils.replace(StringUtils.replace(strArr[1].trim(), "\"", ""), ":", "");
        if (strReplace.length() <= 0) {
            return 0;
        }
        Logger.m32144v(f28384a, "the temport is %s", strReplace);
        return StringUtils.stringToInteger(strReplace, 0);
    }
}
