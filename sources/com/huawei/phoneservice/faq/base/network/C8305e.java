package com.huawei.phoneservice.faq.base.network;

import com.huawei.hms.network.httpclient.Interceptor;
import com.huawei.hms.network.httpclient.Request;
import com.huawei.hms.network.httpclient.RequestBody;
import com.huawei.hms.network.httpclient.Response;
import com.huawei.hms.network.httpclient.ResponseBody;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import p692uw.C13267j;

/* renamed from: com.huawei.phoneservice.faq.base.network.e */
/* loaded from: classes4.dex */
public final class C8305e extends Interceptor {

    /* renamed from: m */
    public String f38664m = "Xcallback";

    /* renamed from: n */
    public final Charset f38665n = Charset.forName(Constants.UTF_8);

    /* renamed from: o */
    public a f38666o = a.NONE;

    /* renamed from: com.huawei.phoneservice.faq.base.network.e$a */
    public enum a {
        NONE,
        HEADERS,
        BODY
    }

    /* renamed from: a */
    public final C8305e m51790a(a aVar) {
        C13267j.m79677e(aVar, FaqConstants.FAQ_LEVEL);
        this.f38666o = aVar;
        return this;
    }

    /* renamed from: b */
    public final void m51792b(Request request, Response<ResponseBody> response, long j10) throws Throwable {
        StringBuilder sb2 = new StringBuilder("Response");
        sb2.append(" ");
        sb2.append(request.getMethod());
        sb2.append(" ");
        sb2.append(j10);
        sb2.append("ms");
        sb2.append(" ");
        sb2.append(response.getUrl());
        sb2.append(" ");
        C13267j.m79676d(sb2, "StringBuilder(\"Response\"…response.url).append(\" \")");
        FaqLogger.m51837d(this.f38664m, sb2.toString(), new Object[0]);
    }

    @Override // com.huawei.hms.network.httpclient.Interceptor
    public Response<ResponseBody> intercept(Interceptor.Chain chain) throws Throwable {
        a aVar = this.f38666o;
        C13267j.m79674b(chain);
        Request request = chain.request();
        C13267j.m79676d(request, "chain!!.request()");
        if (aVar == a.NONE) {
            Response<ResponseBody> responseProceed = chain.proceed(chain.request());
            C13267j.m79676d(responseProceed, "chain.proceed(chain.request())");
            return responseProceed;
        }
        m51791a(request);
        long jNanoTime = System.nanoTime();
        Response<ResponseBody> responseProceed2 = chain.proceed(request);
        C13267j.m79676d(responseProceed2, "chain.proceed(request)");
        m51792b(request, responseProceed2, TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime));
        return responseProceed2;
    }

    /* renamed from: a */
    public final void m51791a(Request request) throws Throwable {
        a aVar = this.f38666o;
        boolean z10 = aVar == a.BODY || aVar == a.HEADERS;
        RequestBody body = request.getBody();
        StringBuilder sb2 = new StringBuilder("Request");
        sb2.append(" ");
        sb2.append(request.getMethod());
        sb2.append(" ");
        sb2.append(request.getUrl());
        C13267j.m79676d(sb2, "StringBuilder(\"Request\")…     .append(request.url)");
        if (z10) {
            Map<String, List<String>> headers = request.getHeaders();
            C13267j.m79676d(headers, "request.headers");
            StringBuilder sb3 = new StringBuilder();
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                sb3.append(entry.getKey() + ' ' + entry.getValue());
                sb3.append(" ");
            }
            FaqLogger.m51837d(this.f38664m, sb3.toString(), new Object[0]);
        }
        sb2.append(" ");
        sb2.append(body != null ? body.toString() : null);
        FaqLogger.m51837d(this.f38664m, sb2.toString(), new Object[0]);
    }
}
