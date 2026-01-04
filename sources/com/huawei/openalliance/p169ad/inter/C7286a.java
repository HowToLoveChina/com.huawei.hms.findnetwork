package com.huawei.openalliance.p169ad.inter;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.huawei.hms.ads.inner.IECCallback;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.constant.Constants;

/* renamed from: com.huawei.openalliance.ad.inter.a */
/* loaded from: classes2.dex */
public class C7286a {

    /* renamed from: a */
    private static final byte[] f33520a = new byte[0];

    /* renamed from: b */
    private static C7286a f33521b;

    /* renamed from: c */
    private IECCallback f33522c;

    /* renamed from: d */
    private String f33523d;

    private C7286a() {
    }

    /* renamed from: a */
    public static C7286a m44210a() {
        C7286a c7286a;
        synchronized (f33520a) {
            try {
                if (f33521b == null) {
                    f33521b = new C7286a();
                }
                c7286a = f33521b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7286a;
    }

    /* renamed from: b */
    private Uri m44212b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Uri.parse(str);
        } catch (Throwable th2) {
            AbstractC7185ho.m43820b("ECATManager", "getUri exception " + th2.getClass().getSimpleName());
            return null;
        }
    }

    /* renamed from: c */
    public String m44218c() {
        return this.f33523d;
    }

    /* renamed from: c */
    private String m44213c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Uri.decode(str);
        } catch (Throwable th2) {
            AbstractC7185ho.m43820b("ECATManager", "decodeUrl exception " + th2.getClass().getSimpleName());
            return null;
        }
    }

    /* renamed from: a */
    public void m44214a(IECCallback iECCallback) {
        this.f33522c = iECCallback;
    }

    /* renamed from: b */
    public String m44217b() {
        IECCallback iECCallback = this.f33522c;
        if (iECCallback != null) {
            return iECCallback.getAccessToken();
        }
        AbstractC7185ho.m43820b("ECATManager", "accessTokenProvider is null, return");
        return null;
    }

    /* renamed from: a */
    public void m44215a(String str) {
        this.f33523d = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034 A[PHI: r2
  0x0034: PHI (r2v2 android.net.Uri) = (r2v1 android.net.Uri), (r2v6 android.net.Uri) binds: [B:11:0x001c, B:13:0x002f] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m44216a(android.content.Context r6, java.lang.String r7) {
        /*
            r5 = this;
            r0 = 0
            java.lang.String r1 = "ECATManager"
            if (r6 != 0) goto Lb
            java.lang.String r5 = "context is null."
        L7:
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43820b(r1, r5)
            return r0
        Lb:
            boolean r2 = android.text.TextUtils.isEmpty(r7)
            if (r2 == 0) goto L14
            java.lang.String r5 = "url is null."
            goto L7
        L14:
            android.net.Uri r2 = r5.m44212b(r7)
            boolean r3 = r5.m44211a(r2)
            if (r3 != 0) goto L34
            java.lang.String r2 = "url invalid."
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43820b(r1, r2)
            java.lang.String r7 = r5.m44213c(r7)
            android.net.Uri r2 = r5.m44212b(r7)
            boolean r7 = r5.m44211a(r2)
            if (r7 != 0) goto L34
            java.lang.String r5 = "decode url invalid."
            goto L7
        L34:
            java.lang.String r7 = com.huawei.openalliance.p169ad.utils.C7830i.m48433d(r6)
            boolean r3 = android.text.TextUtils.isEmpty(r7)
            if (r3 == 0) goto L41
            java.lang.String r5 = "not install hms."
            goto L7
        L41:
            android.content.Intent r3 = new android.content.Intent     // Catch: java.lang.Throwable -> L55
            java.lang.String r4 = "android.intent.action.VIEW"
            r3.<init>(r4, r2)     // Catch: java.lang.Throwable -> L55
            r3.setPackage(r7)     // Catch: java.lang.Throwable -> L55
            boolean r7 = r6 instanceof android.app.Activity     // Catch: java.lang.Throwable -> L55
            if (r7 != 0) goto L57
            r7 = 268435456(0x10000000, float:2.524355E-29)
            r3.addFlags(r7)     // Catch: java.lang.Throwable -> L55
            goto L57
        L55:
            r5 = move-exception
            goto L70
        L57:
            android.os.Bundle r7 = new android.os.Bundle     // Catch: java.lang.Throwable -> L55
            r7.<init>()     // Catch: java.lang.Throwable -> L55
            java.lang.String r2 = "openFromSDK"
            r4 = 1
            r7.putBoolean(r2, r4)     // Catch: java.lang.Throwable -> L55
            java.lang.String r2 = "accessToken"
            java.lang.String r5 = r5.f33523d     // Catch: java.lang.Throwable -> L55
            r7.putString(r2, r5)     // Catch: java.lang.Throwable -> L55
            r3.putExtras(r7)     // Catch: java.lang.Throwable -> L55
            r6.startActivity(r3)     // Catch: java.lang.Throwable -> L55
            return r4
        L70:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "openLandingPage exception "
            r6.append(r7)
            java.lang.Class r5 = r5.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            goto L7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.inter.C7286a.m44216a(android.content.Context, java.lang.String):boolean");
    }

    /* renamed from: a */
    private boolean m44211a(Uri uri) {
        String str;
        if (uri == null) {
            str = "uri is null.";
        } else if (URLUtil.isNetworkUrl(uri.toString())) {
            str = "uri is http or https url.";
        } else {
            try {
                String host = uri.getHost();
                if (TextUtils.equals("hwpps", uri.getScheme())) {
                    return TextUtils.equals(Constants.SCHEME_HOST, host);
                }
                return false;
            } catch (Throwable th2) {
                str = "isUriValid exception " + th2.getClass().getSimpleName();
            }
        }
        AbstractC7185ho.m43820b("ECATManager", str);
        return false;
    }
}
