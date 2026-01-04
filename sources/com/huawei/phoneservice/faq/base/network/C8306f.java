package com.huawei.phoneservice.faq.base.network;

import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.restclient.Headers;
import com.huawei.hms.framework.network.restclient.hwhttp.Interceptor;
import com.huawei.hms.framework.network.restclient.hwhttp.Request;
import com.huawei.hms.framework.network.restclient.hwhttp.RequestBody;
import com.huawei.hms.framework.network.restclient.hwhttp.Response;
import com.huawei.hms.framework.network.restclient.hwhttp.ResponseBody;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;
import p692uw.C13267j;

/* renamed from: com.huawei.phoneservice.faq.base.network.f */
/* loaded from: classes4.dex */
public final class C8306f implements Interceptor {

    /* renamed from: a */
    public String f38671a = "Xcallback";

    /* renamed from: b */
    public final Charset f38672b = Charset.forName(Constants.UTF_8);

    /* renamed from: c */
    public a f38673c = a.NONE;

    /* renamed from: com.huawei.phoneservice.faq.base.network.f$a */
    public enum a {
        NONE,
        HEADERS,
        BODY
    }

    /* renamed from: a */
    public final Response m51794a(Request request, Response response, long j10) throws Throwable {
        Response.Builder builderNewBuilder = response.newBuilder();
        C13267j.m79676d(builderNewBuilder, "response.newBuilder()");
        Response responseBuild = builderNewBuilder.build();
        C13267j.m79676d(responseBuild, "builder.build()");
        ResponseBody body = responseBuild.getBody();
        C13267j.m79676d(body, "clone.body");
        byte[] bArrBytes = body.bytes();
        a aVar = this.f38673c;
        if (aVar == a.BODY || aVar == a.HEADERS) {
            Headers headers = responseBuild.getHeaders();
            C13267j.m79676d(headers, "clone.headers");
            int size = headers.size();
            StringBuilder sb2 = new StringBuilder();
            for (int i10 = 0; i10 < size; i10++) {
                sb2.append(headers.name(i10) + ':' + headers.value(i10));
                sb2.append(" ");
            }
            sb2.append(responseBuild.getUrl());
            FaqLogger.m51841e(this.f38671a, sb2.toString(), new Object[0]);
        }
        StringBuilder sb3 = new StringBuilder("Response");
        sb3.append(" ");
        sb3.append(request.getMethod());
        sb3.append(" ");
        sb3.append(j10);
        sb3.append("ms");
        sb3.append(" ");
        sb3.append(response.getUrl());
        sb3.append(" ");
        sb3.append("response params :");
        sb3.append(StringUtils.byte2Str(bArrBytes));
        C13267j.m79676d(sb3, "StringBuilder(\"Response\"…te2Str(responseBodyByte))");
        FaqLogger.m51841e(this.f38671a, sb3.toString(), new Object[0]);
        return m51795b(response, bArrBytes);
    }

    /* renamed from: b */
    public final Response m51795b(Response response, byte[] bArr) {
        C13267j.m79677e(response, "originalResponse");
        ResponseBody body = response.getBody();
        ResponseBody responseBodyBuild = new ResponseBody.Builder().contentLength(body.getContentLength()).contentType(body.getContentType()).inputStream(new ByteArrayInputStream(bArr)).charSet(this.f38672b).build();
        C13267j.m79676d(responseBodyBuild, "Builder()\n              …\n                .build()");
        Response responseBuild = new Response.Builder().body(responseBodyBuild).code(response.getCode()).headers(response.getHeaders()).message(response.getMessage()).build();
        C13267j.m79676d(responseBuild, "Builder().body(newBody)\n…\n                .build()");
        return responseBuild;
    }

    /* renamed from: c */
    public final C8306f m51796c(a aVar) {
        C13267j.m79677e(aVar, FaqConstants.FAQ_LEVEL);
        this.f38673c = aVar;
        return this;
    }

    /* renamed from: d */
    public final void m51797d(Request request) throws Throwable {
        a aVar = this.f38673c;
        boolean z10 = aVar == a.BODY || aVar == a.HEADERS;
        RequestBody body = request.getBody();
        StringBuilder sb2 = new StringBuilder("Request");
        sb2.append(" ");
        sb2.append(request.getMethod());
        sb2.append(" ");
        sb2.append(request.getUrl().getUrl());
        C13267j.m79676d(sb2, "StringBuilder(\"Request\")…end(request.url.getUrl())");
        if (z10) {
            Headers headers = request.getHeaders();
            C13267j.m79676d(headers, "request.headers");
            int size = headers.size();
            StringBuilder sb3 = new StringBuilder();
            for (int i10 = 0; i10 < size; i10++) {
                sb3.append(headers.name(i10) + ' ' + headers.value(i10));
                sb3.append(" ");
            }
            FaqLogger.m51841e(this.f38671a, sb3.toString(), new Object[0]);
        }
        sb2.append(" ");
        sb2.append(StringUtils.byte2Str(body != null ? body.body() : null));
        FaqLogger.m51841e(this.f38671a, sb2.toString(), new Object[0]);
    }

    @Override // com.huawei.hms.framework.network.restclient.hwhttp.Interceptor
    public Response intercept(Interceptor.Chain chain) throws Throwable {
        a aVar = this.f38673c;
        C13267j.m79674b(chain);
        Request request = chain.request();
        C13267j.m79676d(request, "chain!!.request()");
        if (aVar == a.NONE) {
            Response responseProceed = chain.proceed(chain.request());
            C13267j.m79676d(responseProceed, "chain.proceed(chain.request())");
            return responseProceed;
        }
        m51797d(request);
        long jNanoTime = System.nanoTime();
        Response responseProceed2 = chain.proceed(request);
        C13267j.m79676d(responseProceed2, "chain.proceed(request)");
        return m51794a(request, responseProceed2, TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime));
    }
}
