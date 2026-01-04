package com.huawei.openalliance.p169ad.net.http;

import android.content.Context;
import android.util.Log;
import com.huawei.hms.network.embedded.C6132w;
import com.huawei.hms.network.httpclient.HttpClient;
import com.huawei.hms.network.httpclient.RequestFinishedInfo;
import com.huawei.hms.network.httpclient.Response;
import com.huawei.hms.network.httpclient.ResponseBody;
import com.huawei.hms.network.httpclient.Submit;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6984ca;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.utils.C7775bv;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.net.http.k */
/* loaded from: classes2.dex */
public class C7508k extends AbstractC7499b {

    /* renamed from: b */
    private static HttpClient f34868b;

    /* renamed from: c */
    private static HttpClient f34869c;

    /* renamed from: d */
    private static final byte[] f34870d = new byte[0];

    public C7508k(Context context) {
        super(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m46081a(com.huawei.hms.network.httpclient.Request.Builder r5, com.huawei.openalliance.p169ad.net.http.C7498a r6, boolean r7) {
        /*
            r4 = this;
            java.lang.String r0 = "Accept-Encoding"
            java.lang.String r1 = "gzip"
            r5.addHeader(r0, r1)
            boolean r0 = r4.m46045a(r6)
            if (r0 == 0) goto L16
            java.lang.String r0 = "hw-request-type"
            java.lang.String r2 = r4.m46046b(r6)
            r5.addHeader(r0, r2)
        L16:
            int r0 = r6.f34800h
            r2 = 1
            if (r0 != r2) goto L30
            android.content.Context r0 = r4.f34826a
            java.lang.String r0 = com.huawei.openalliance.p169ad.utils.AbstractC7807d.m48247k(r0)
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L30
            java.lang.String r2 = "User-Agent"
            com.huawei.hms.network.httpclient.Request$Builder r3 = r5.removeHeader(r2)
            r3.addHeader(r2, r0)
        L30:
            com.huawei.openalliance.ad.net.http.c r0 = r6.f34798f
            if (r0 == 0) goto L5c
            java.util.Map r0 = r0.m46049a()
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L40:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L5c
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r2 = r2.getValue()
            java.lang.String r2 = (java.lang.String) r2
            r5.addHeader(r3, r2)
            goto L40
        L5c:
            if (r7 == 0) goto L9d
            boolean r7 = r6.f34803k
            if (r7 == 0) goto L67
            java.lang.String r7 = "Content-Encoding"
            r5.addHeader(r7, r1)
        L67:
            boolean r4 = r4.m46045a(r6)
            java.lang.String r7 = "NetworkKitCaller"
            java.lang.String r0 = "Content-Type"
            if (r4 == 0) goto L7f
            java.lang.String r4 = "content type stream."
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43817a(r7, r4)
            r5.removeHeader(r0)
            java.lang.String r4 = "application/octet-stream"
        L7b:
            r5.addHeader(r0, r4)
            goto L8f
        L7f:
            java.lang.String r4 = r6.f34799g
            if (r4 == 0) goto L8f
            java.lang.String r1 = "content type: %s"
            java.lang.Object[] r4 = new java.lang.Object[]{r4}
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43818a(r7, r1, r4)
            java.lang.String r4 = r6.f34799g
            goto L7b
        L8f:
            byte[] r4 = r6.f34802j
            if (r4 == 0) goto L9d
            int r4 = r4.length
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r6 = "Content-Length"
            r5.addHeader(r6, r4)
        L9d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.net.http.C7508k.m46081a(com.huawei.hms.network.httpclient.Request$Builder, com.huawei.openalliance.ad.net.http.a, boolean):void");
    }

    /* renamed from: b */
    private HttpClient m46083b(C7502e c7502e) {
        synchronized (f34870d) {
            try {
                if (f34868b == null || f34869c == null) {
                    HttpClient.Builder builderEnableQuic = C7775bv.m47824a(this.f34826a, c7502e.f34838j).readTimeout(c7502e.f34831c).connectTimeout(c7502e.f34830b).enableQuic(c7502e.f34838j);
                    HttpsConfig.m45963a(builderEnableQuic, false, c7502e.f34837i);
                    f34868b = builderEnableQuic.build();
                    HttpClient.Builder builderEnableQuic2 = C7775bv.m47824a(this.f34826a, c7502e.f34838j).readTimeout(c7502e.f34831c).connectTimeout(c7502e.f34830b).enableQuic(c7502e.f34838j);
                    HttpsConfig.m45963a(builderEnableQuic2, true, false);
                    f34869c = builderEnableQuic2.build();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7502e.f34835g ? f34869c : f34868b;
    }

    /* renamed from: a */
    public void m46084a(Submit submit) {
        RequestFinishedInfo requestFinishedInfo;
        RequestFinishedInfo.Metrics metrics;
        if (submit == null || (requestFinishedInfo = submit.getRequestFinishedInfo()) == null || (metrics = requestFinishedInfo.getMetrics()) == null) {
            return;
        }
        AbstractC7185ho.m43821b("NetworkKitCaller", "DnsType: %s", metrics.getDnsType());
        if (C6132w.f28816l.equalsIgnoreCase(metrics.getDnsType()) || "HTTPDNS".equalsIgnoreCase(metrics.getDnsType())) {
            AbstractC7185ho.m43820b("NetworkKitCaller", "grs forceExpire");
            C6984ca.m41165a(this.f34826a).mo41219b();
        }
    }

    /* JADX WARN: Not initialized variable reg: 21, insn: 0x02c5: INVOKE (r21 I:java.io.Closeable) STATIC call: com.huawei.openalliance.ad.utils.cy.a(java.io.Closeable):void A[MD:(java.io.Closeable):void (m)], block:B:125:0x02c2 */
    /* JADX WARN: Removed duplicated region for block: B:105:0x025c A[Catch: all -> 0x0264, TryCatch #1 {all -> 0x0264, blocks: (B:103:0x023c, B:105:0x025c, B:106:0x0260, B:113:0x0271, B:115:0x0296, B:116:0x029d, B:118:0x02a3, B:119:0x02ac, B:120:0x02b0, B:122:0x02bc), top: B:127:0x00a5 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0296 A[Catch: all -> 0x0264, TryCatch #1 {all -> 0x0264, blocks: (B:103:0x023c, B:105:0x025c, B:106:0x0260, B:113:0x0271, B:115:0x0296, B:116:0x029d, B:118:0x02a3, B:119:0x02ac, B:120:0x02b0, B:122:0x02bc), top: B:127:0x00a5 }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02a3 A[Catch: all -> 0x0264, TryCatch #1 {all -> 0x0264, blocks: (B:103:0x023c, B:105:0x025c, B:106:0x0260, B:113:0x0271, B:115:0x0296, B:116:0x029d, B:118:0x02a3, B:119:0x02ac, B:120:0x02b0, B:122:0x02bc), top: B:127:0x00a5 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02bc A[Catch: all -> 0x0264, TRY_LEAVE, TryCatch #1 {all -> 0x0264, blocks: (B:103:0x023c, B:105:0x025c, B:106:0x0260, B:113:0x0271, B:115:0x0296, B:116:0x029d, B:118:0x02a3, B:119:0x02ac, B:120:0x02b0, B:122:0x02bc), top: B:127:0x00a5 }] */
    @Override // com.huawei.openalliance.p169ad.net.http.InterfaceC7505h
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.openalliance.p169ad.net.http.Response mo45976b(com.huawei.openalliance.p169ad.net.http.C7502e r25, com.huawei.openalliance.p169ad.net.http.C7498a r26) {
        /*
            Method dump skipped, instructions count: 716
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.net.http.C7508k.mo45976b(com.huawei.openalliance.ad.net.http.e, com.huawei.openalliance.ad.net.http.a):com.huawei.openalliance.ad.net.http.Response");
    }

    /* renamed from: a */
    public void m46085a(C7502e c7502e) {
        Log.i("NetworkKitCaller", "preCreateHttpClient.");
        try {
            m46083b(c7502e);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("NetworkKitCaller", "preCreateHttpClient error: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private boolean m46082a(Response<ResponseBody> response) {
        Map<String, List<String>> headers = response.getHeaders();
        if (headers == null || headers.size() <= 0) {
            return false;
        }
        List<String> list = headers.get("Content-Encoding");
        if (list == null) {
            list = headers.get("Content-Encoding".toLowerCase(Locale.ENGLISH));
        }
        if (list == null) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (Constants.GZIP.equalsIgnoreCase(it.next())) {
                return true;
            }
        }
        return false;
    }
}
