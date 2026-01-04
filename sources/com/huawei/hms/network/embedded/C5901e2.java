package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.embedded.C5953i2;
import java.util.Collection;
import java.util.concurrent.Executor;
import org.chromium.net.RequestFinishedInfo;
import org.chromium.net.UrlResponseInfo;

/* renamed from: com.huawei.hms.network.embedded.e2 */
/* loaded from: classes8.dex */
public class C5901e2 extends RequestFinishedInfo.Listener {

    /* renamed from: a */
    public static final String f26673a = "CronetEventListener";

    /* renamed from: b */
    public static final long f26674b = 0;

    /* renamed from: c */
    public static final String f26675c = "unknown";

    public C5901e2(Executor executor) {
        super(executor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* renamed from: a */
    private C5966j2 m34109a(RequestFinishedInfo requestFinishedInfo) {
        Collection<Object> annotations = requestFinishedInfo.getAnnotations();
        C5966j2 c5966j2 = (annotations == null || annotations.isEmpty()) ? null : annotations.toArray()[0];
        if (!(c5966j2 instanceof C5966j2)) {
            return null;
        }
        Logger.m32143v(f26673a, "call getAnnotations return CronetRequestTask instance");
        return c5966j2;
    }

    @Override // org.chromium.net.RequestFinishedInfo.Listener
    public void onRequestFinished(RequestFinishedInfo requestFinishedInfo) {
        Logger.m32143v(f26673a, "onRequestFinished");
        if (requestFinishedInfo == null) {
            Logger.m32138e(f26673a, "requestInfo == null at onRequestFinished");
            return;
        }
        try {
            C5966j2 c5966j2M34109a = m34109a(requestFinishedInfo);
            if (c5966j2M34109a == null) {
                Logger.m32138e(f26673a, "fail to get CronetRequestTask from getAnnotations");
                return;
            }
            C5953i2 c5953i2 = (C5953i2) c5966j2M34109a.getRequestFinishedInfo();
            if (c5953i2 == null) {
                Logger.m32145w(f26673a, "requestFinishedInfo == null at onRequestFinished");
            } else {
                m34112a(requestFinishedInfo, c5953i2, c5966j2M34109a.getResponseInfo());
                c5966j2M34109a.m34494a();
            }
        } catch (Throwable th2) {
            Logger.m32138e(f26673a, "onRequestFinished occur exception, exception name:" + th2.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private void m34110a(RequestFinishedInfo.Metrics metrics, AbstractC6122v2 abstractC6122v2) {
        if (metrics == null || abstractC6122v2 == null) {
            Logger.m32138e(f26673a, "invalid parameters");
            return;
        }
        abstractC6122v2.setCallStartTime(metrics.getRequestStart() == null ? 0L : metrics.getRequestStart().getTime());
        abstractC6122v2.setCallEndTime(metrics.getRequestEnd() == null ? 0L : metrics.getRequestEnd().getTime());
        abstractC6122v2.setDnsStartTime(metrics.getDnsStart() == null ? 0L : metrics.getDnsStart().getTime());
        abstractC6122v2.setDnsEndTime(metrics.getDnsEnd() == null ? 0L : metrics.getDnsEnd().getTime());
        abstractC6122v2.setConnectStartTime(metrics.getConnectStart() == null ? 0L : metrics.getConnectStart().getTime());
        abstractC6122v2.setConnectEndTime(metrics.getConnectEnd() == null ? 0L : metrics.getConnectEnd().getTime());
        abstractC6122v2.setSecureConnectStartTime(metrics.getSslStart() == null ? 0L : metrics.getSslStart().getTime());
        abstractC6122v2.setSecureConnectEndTime(metrics.getSslEnd() == null ? 0L : metrics.getSslEnd().getTime());
        abstractC6122v2.setRequestHeadersStartTime(metrics.getSendingStart() == null ? 0L : metrics.getSendingStart().getTime());
        abstractC6122v2.setRequestHeadersEndTime(metrics.getSendingEnd() == null ? 0L : metrics.getSendingEnd().getTime());
        abstractC6122v2.setResponseHeadersStartTime(metrics.getResponseStart() == null ? 0L : metrics.getResponseStart().getTime());
        abstractC6122v2.setResponseBodyEndTime(metrics.getRequestEnd() == null ? 0L : metrics.getRequestEnd().getTime());
        if (abstractC6122v2 instanceof C5953i2.a) {
            C5953i2.a aVar = (C5953i2.a) abstractC6122v2;
            aVar.setTtfb(metrics.getTtfbMs() == null ? 0L : metrics.getTtfbMs().longValue());
            aVar.setTotalTime(metrics.getTotalTimeMs() != null ? metrics.getTotalTimeMs().longValue() : 0L);
        }
    }

    /* renamed from: a */
    private void m34111a(RequestFinishedInfo.Metrics metrics, RequestFinishedInfo requestFinishedInfo, C6109u2 c6109u2) {
        if (metrics == null || requestFinishedInfo == null || c6109u2 == null) {
            Logger.m32138e(f26673a, "invalid parameters");
            return;
        }
        c6109u2.setRequestByteCount(metrics.getSentByteCount() == null ? 0L : metrics.getSentByteCount().longValue());
        c6109u2.setResponseByteCount(metrics.getReceivedByteCount() != null ? metrics.getReceivedByteCount().longValue() : 0L);
        c6109u2.setProtocol(requestFinishedInfo.getResponseInfo() == null ? "unknown" : requestFinishedInfo.getResponseInfo().getNegotiatedProtocol());
    }

    /* renamed from: a */
    private void m34112a(RequestFinishedInfo requestFinishedInfo, C5953i2 c5953i2, UrlResponseInfo urlResponseInfo) {
        if (requestFinishedInfo == null || c5953i2 == null || urlResponseInfo == null) {
            Logger.m32138e(f26673a, "invalid parameters");
            return;
        }
        c5953i2.setUrl(requestFinishedInfo.getUrl());
        c5953i2.setException(requestFinishedInfo.getException());
        m34110a(requestFinishedInfo.getMetrics(), c5953i2.getMetricsTime());
        m34111a(requestFinishedInfo.getMetrics(), requestFinishedInfo, c5953i2.getMetrics());
    }
}
