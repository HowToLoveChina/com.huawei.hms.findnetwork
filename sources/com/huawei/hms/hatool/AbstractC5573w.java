package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.huawei.hms.network.embedded.C6158y;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;

/* renamed from: com.huawei.hms.hatool.w */
/* loaded from: classes8.dex */
public abstract class AbstractC5573w {

    /* renamed from: com.huawei.hms.hatool.w$a */
    public static class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    /* renamed from: a */
    public static C5553n0 m32799a(String str, byte[] bArr, Map<String, String> map) {
        return m32800a(str, bArr, map, "POST");
    }

    /* renamed from: b */
    private static String m32803b(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = null;
        try {
            try {
                inputStream = httpURLConnection.getInputStream();
                return C5545k1.m32608a(inputStream);
            } catch (IOException unused) {
                C5571v.m32797f("hmsSdk", "When Response Content From Connection inputStream operation exception! " + httpURLConnection.getResponseCode());
                C5545k1.m32609a((Closeable) inputStream);
                return "";
            }
        } finally {
            C5545k1.m32609a((Closeable) inputStream);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:164:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0151  */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.util.Map, java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v18, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v19, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v20, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v21, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v22, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v23, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v24, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v27 */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v29 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v30 */
    /* JADX WARN: Type inference failed for: r8v31 */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v33, types: [java.io.Closeable, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v11, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v12, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v13, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v14, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v15, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v16, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v17, types: [java.io.BufferedOutputStream, java.io.Closeable, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.io.Closeable] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.huawei.hms.hatool.C5553n0 m32800a(java.lang.String r6, byte[] r7, java.util.Map<java.lang.String, java.lang.String> r8, java.lang.String r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 341
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hatool.AbstractC5573w.m32800a(java.lang.String, byte[], java.util.Map, java.lang.String):com.huawei.hms.hatool.n0");
    }

    /* renamed from: a */
    private static HttpURLConnection m32801a(String str, int i10, Map<String, String> map, String str2) throws ProtocolException, a, IllegalArgumentException {
        if (TextUtils.isEmpty(str)) {
            C5571v.m32789b("hmsSdk", "CreateConnection: invalid urlPath.");
            return null;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        m32802a(httpURLConnection);
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setConnectTimeout(C6158y.f29108c);
        httpURLConnection.setReadTimeout(C6158y.f29108c);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(i10));
        httpURLConnection.setRequestProperty("Connection", "close");
        if (map != null && map.size() >= 1) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key != null && !TextUtils.isEmpty(key)) {
                    httpURLConnection.setRequestProperty(key, entry.getValue());
                }
            }
        }
        return httpURLConnection;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0032  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void m32802a(java.net.HttpURLConnection r2) throws com.huawei.hms.hatool.AbstractC5573w.a, java.lang.IllegalArgumentException {
        /*
            java.lang.String r0 = "hmsSdk"
            boolean r1 = r2 instanceof javax.net.ssl.HttpsURLConnection
            if (r1 == 0) goto L3a
            javax.net.ssl.HttpsURLConnection r2 = (javax.net.ssl.HttpsURLConnection) r2
            android.content.Context r1 = com.huawei.hms.hatool.AbstractC5562q0.m32718i()     // Catch: java.lang.IllegalAccessException -> L11 java.io.IOException -> L17 java.security.GeneralSecurityException -> L1a java.security.KeyStoreException -> L1d java.security.NoSuchAlgorithmException -> L20
            iu.e r0 = p373iu.C10617e.m65071b(r1)     // Catch: java.lang.IllegalAccessException -> L11 java.io.IOException -> L17 java.security.GeneralSecurityException -> L1a java.security.KeyStoreException -> L1d java.security.NoSuchAlgorithmException -> L20
            goto L24
        L11:
            java.lang.String r1 = "getSocketFactory(): Illegal Access Exception "
        L13:
            com.huawei.hms.hatool.C5571v.m32797f(r0, r1)
            goto L23
        L17:
            java.lang.String r1 = "getSocketFactory(): IO Exception!"
            goto L13
        L1a:
            java.lang.String r1 = "getSocketFactory(): General Security Exception"
            goto L13
        L1d:
            java.lang.String r1 = "getSocketFactory(): Key Store exception"
            goto L13
        L20:
            java.lang.String r1 = "getSocketFactory(): Algorithm Exception!"
            goto L13
        L23:
            r0 = 0
        L24:
            if (r0 == 0) goto L32
            r2.setSSLSocketFactory(r0)
            ju.a r0 = new ju.a
            r0.<init>()
            r2.setHostnameVerifier(r0)
            goto L3a
        L32:
            com.huawei.hms.hatool.w$a r2 = new com.huawei.hms.hatool.w$a
            java.lang.String r0 = "No ssl socket factory set"
            r2.<init>(r0)
            throw r2
        L3a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hatool.AbstractC5573w.m32802a(java.net.HttpURLConnection):void");
    }
}
