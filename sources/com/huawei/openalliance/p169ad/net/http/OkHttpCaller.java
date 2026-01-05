package com.huawei.openalliance.p169ad.net.http;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.network.embedded.C5966j2;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.net.http.C7503f;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.utils.C7800ct;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.C11912b0;
import okhttp3.HttpRequestBuilder;
import okhttp3.HttpResponseBuilder;
import okhttp3.C11945l;
import okhttp3.EnumC11914c0;

@OuterVisible
/* loaded from: classes2.dex */
class OkHttpCaller extends AbstractC7499b {

    /* renamed from: b */
    private static C11912b0 f34788b;

    /* renamed from: c */
    private static C11912b0 f34789c;

    /* renamed from: d */
    private static C11912b0 f34790d;

    /* renamed from: e */
    private static InterfaceC7506i f34791e;

    /* renamed from: f */
    private static final byte[] f34792f = new byte[0];

    public OkHttpCaller(Context context) {
        super(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 19, insn: 0x03a6: INVOKE (r19 I:java.io.Closeable) STATIC call: com.huawei.openalliance.ad.utils.cy.a(java.io.Closeable):void A[MD:(java.io.Closeable):void (m)], block:B:177:0x03a3 */
    /* JADX WARN: Not initialized variable reg: 21, insn: 0x03a3: INVOKE (r21 I:java.io.Closeable) STATIC call: com.huawei.openalliance.ad.utils.cy.a(java.io.Closeable):void A[MD:(java.io.Closeable):void (m)], block:B:177:0x03a3 */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0344 A[Catch: all -> 0x034c, TryCatch #21 {all -> 0x034c, blocks: (B:158:0x0322, B:160:0x0344, B:161:0x0348, B:166:0x0359, B:168:0x037a, B:169:0x0381, B:171:0x0387, B:172:0x0390, B:174:0x039d), top: B:187:0x0063 }] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x037a A[Catch: all -> 0x034c, TryCatch #21 {all -> 0x034c, blocks: (B:158:0x0322, B:160:0x0344, B:161:0x0348, B:166:0x0359, B:168:0x037a, B:169:0x0381, B:171:0x0387, B:172:0x0390, B:174:0x039d), top: B:187:0x0063 }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0387 A[Catch: all -> 0x034c, TryCatch #21 {all -> 0x034c, blocks: (B:158:0x0322, B:160:0x0344, B:161:0x0348, B:166:0x0359, B:168:0x037a, B:169:0x0381, B:171:0x0387, B:172:0x0390, B:174:0x039d), top: B:187:0x0063 }] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x039d A[Catch: all -> 0x034c, TRY_LEAVE, TryCatch #21 {all -> 0x034c, blocks: (B:158:0x0322, B:160:0x0344, B:161:0x0348, B:166:0x0359, B:168:0x037a, B:169:0x0381, B:171:0x0387, B:172:0x0390, B:174:0x039d), top: B:187:0x0063 }] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.io.Closeable, java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v30 */
    /* JADX WARN: Type inference failed for: r6v31 */
    /* JADX WARN: Type inference failed for: r6v4, types: [boolean] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.openalliance.p169ad.net.http.Response m45970a(com.huawei.openalliance.p169ad.net.http.C7502e r28, com.huawei.openalliance.p169ad.net.http.C7498a r29, boolean r30) {
        /*
            Method dump skipped, instructions count: 947
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.net.http.OkHttpCaller.m45970a(com.huawei.openalliance.ad.net.http.e, com.huawei.openalliance.ad.net.http.a, boolean):com.huawei.openalliance.ad.net.http.Response");
    }

    @Override // com.huawei.openalliance.p169ad.net.http.InterfaceC7505h
    /* renamed from: b */
    public Response mo45976b(C7502e c7502e, C7498a c7498a) {
        Response responseM45970a = m45970a(c7502e, c7498a, false);
        AbstractC7185ho.m43820b("OkHttpCaller", "dnserror:" + responseM45970a.m45999e());
        if (!responseM45970a.m45999e() || m45974a(c7502e.f34836h, c7498a.m46017b())) {
            return responseM45970a;
        }
        String strM45995d = responseM45970a.m45995d();
        Response responseM45970a2 = m45970a(c7502e, c7498a, true);
        responseM45970a2.m45993c(1);
        responseM45970a2.m45984a(strM45995d);
        if (responseM45970a2.m45999e()) {
            C7800ct.m48114a().m48123d(Uri.parse(c7498a.m46016a() ? c7498a.m46017b() : new C7503f.a().m46072a(c7502e.f34836h, c7498a.m46018c()).m46073a(c7498a.f34801i).m46074a().m46071c()).getHost());
        }
        return responseM45970a2;
    }

    /* renamed from: a */
    private static C11912b0 m45971a(C7502e c7502e, boolean z10) {
        C11912b0 c11912b0;
        synchronized (f34792f) {
            try {
                if (f34788b == null || f34790d == null || f34789c == null || f34791e == null) {
                    C11912b0.c cVarM71508e = new C11912b0.c().m71508e(new C11945l(8, 10L, TimeUnit.MINUTES));
                    long j10 = c7502e.f34831c;
                    TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                    C11912b0.c cVarM71507d = cVarM71508e.m71519p(j10, timeUnit).m71507d(c7502e.f34830b, timeUnit);
                    EnumC11914c0 enumC11914c0 = EnumC11914c0.HTTP_2;
                    C11912b0.c cVarM71517n = cVarM71507d.m71517n(Collections.unmodifiableList(Arrays.asList(enumC11914c0, EnumC11914c0.HTTP_1_1)));
                    InterfaceC7506i interfaceC7506iM45962a = HttpCallerFactory.m45962a();
                    f34791e = interfaceC7506iM45962a;
                    interfaceC7506iM45962a.mo46053a(cVarM71517n);
                    HttpsConfig.m45967a(cVarM71517n, false, c7502e.f34837i);
                    try {
                        cVarM71517n.m71510g(cVarM71517n.m71509f(enumC11914c0));
                    } catch (Throwable th2) {
                        AbstractC7185ho.m43823c("OkHttpCaller", "create dispatcher error, " + th2.getClass().getSimpleName());
                    }
                    f34788b = cVarM71517n.m71505b();
                    f34789c = cVarM71517n.m71511h(new C7509l(c7502e.f34836h, true)).m71505b();
                    C11912b0.c cVarM71494y = f34788b.m71494y();
                    HttpsConfig.m45967a(cVarM71494y, true, false);
                    f34790d = cVarM71494y.m71505b();
                }
                c11912b0 = z10 ? f34789c : c7502e.f34835g ? f34790d : f34788b;
            } catch (Throwable th3) {
                throw th3;
            }
        }
        return c11912b0;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m45972a(com.huawei.openalliance.p169ad.net.http.C7498a r4, okhttp3.HttpRequestBuilder.a r5) {
        /*
            r3 = this;
            boolean r0 = r4.f34803k
            if (r0 == 0) goto Lb
            java.lang.String r0 = "Content-Encoding"
            java.lang.String r1 = "gzip"
            r5.addHeader(r0, r1)
        Lb:
            boolean r3 = r3.m46045a(r4)
            java.lang.String r0 = "OkHttpCaller"
            java.lang.String r1 = "Content-Type"
            if (r3 == 0) goto L23
            java.lang.String r3 = "content type stream."
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43817a(r0, r3)
            r5.m71583j(r1)
            java.lang.String r3 = "application/octet-stream"
        L1f:
            r5.addHeader(r1, r3)
            goto L33
        L23:
            java.lang.String r3 = r4.f34799g
            if (r3 == 0) goto L33
            java.lang.String r2 = "content type: %s"
            java.lang.Object[] r3 = new java.lang.Object[]{r3}
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43818a(r0, r2, r3)
            java.lang.String r3 = r4.f34799g
            goto L1f
        L33:
            byte[] r3 = r4.f34802j
            if (r3 == 0) goto L41
            int r3 = r3.length
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "Content-Length"
            r5.addHeader(r4, r3)
        L41:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.net.http.OkHttpCaller.m45972a(com.huawei.openalliance.ad.net.http.a, okhttp3.e0$a):void");
    }

    /* renamed from: a */
    private void m45973a(HttpRequestBuilder.a aVar, C7498a c7498a) {
        aVar.addHeader(C5966j2.f27080v, Constants.GZIP);
        if (m46045a(c7498a)) {
            aVar.addHeader("hw-request-type", m46046b(c7498a));
        }
        if (c7498a.f34800h == 1) {
            String strM48247k = AbstractC7807d.m48247k(this.f34826a);
            if (!TextUtils.isEmpty(strM48247k)) {
                aVar.m71583j("User-Agent").addHeader("User-Agent", strM48247k);
            }
        }
        C7500c c7500c = c7498a.f34798f;
        if (c7500c != null) {
            for (Map.Entry<String, String> entry : c7500c.m46049a().entrySet()) {
                aVar.addHeader(entry.getKey(), entry.getValue());
            }
        }
    }

    /* renamed from: a */
    private boolean m45974a(Context context, String str) {
        return "dnkeeperServer".equalsIgnoreCase(str) || (str != null && str.equalsIgnoreCase(context.getString(C6849R.string.hiad_dnkeeperServer)));
    }

    /* renamed from: a */
    private boolean m45975a(HttpResponseBuilder HttpResponseBuilder) {
        return Constants.GZIP.equalsIgnoreCase(HttpResponseBuilder.m71599w("Content-Encoding"));
    }
}
