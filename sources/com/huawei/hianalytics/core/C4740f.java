package com.huawei.hianalytics.core;

import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.core.transport.net.Response;
import com.huawei.hianalytics.core.transport.net.TransportHandler;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Map;

/* renamed from: com.huawei.hianalytics.core.f */
/* loaded from: classes5.dex */
public class C4740f extends TransportHandler {

    /* renamed from: com.huawei.hianalytics.core.f$a */
    public static class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    public C4740f(String str, Map<String, String> map, byte[] bArr) {
        super(str, map, bArr);
    }

    @Override // com.huawei.hianalytics.core.transport.net.TransportHandler
    /* renamed from: a */
    public Response mo28797a() {
        return m28798a("GET");
    }

    @Override // com.huawei.hianalytics.core.transport.net.TransportHandler
    /* renamed from: b */
    public Response mo28802b() {
        return m28798a("POST");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0083  */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.huawei.hianalytics.core.f, com.huawei.hianalytics.core.transport.net.TransportHandler] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r7v13, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.huawei.hianalytics.core.transport.net.Response m28798a(java.lang.String r7) throws java.lang.Throwable {
        /*
            r6 = this;
            r0 = 0
            java.lang.String r1 = r6.f21695a     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L60
            java.net.HttpURLConnection r1 = r6.m28800a(r1, r7)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L60
            java.lang.String r2 = "GET"
            boolean r7 = r2.equals(r7)     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2f
            if (r7 != 0) goto L32
            java.io.OutputStream r7 = r1.getOutputStream()     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2f
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L29
            r2.<init>(r7)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L29
            byte[] r0 = r6.f21697c     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L24
            r2.write(r0)     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L24
            r2.flush()     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L24
            r0 = r2
            goto L33
        L22:
            r0 = move-exception
            goto L54
        L24:
            r0 = move-exception
            goto L58
        L26:
            r2 = move-exception
            goto L7b
        L29:
            r2 = move-exception
            goto L63
        L2b:
            r2 = move-exception
            r7 = r0
            goto L7b
        L2f:
            r2 = move-exception
            r7 = r0
            goto L63
        L32:
            r7 = r0
        L33:
            int r2 = r1.getResponseCode()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4f
            java.lang.String r3 = r6.m28799a(r1)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4f
            com.huawei.hianalytics.core.transport.net.Response r4 = new com.huawei.hianalytics.core.transport.net.Response     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4f
            r4.<init>(r2, r3)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4f
            r6.m28801a(r0)
            r6.m28801a(r7)
            r1.disconnect()
            return r4
        L4a:
            r2 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
            goto L54
        L4f:
            r2 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
            goto L58
        L54:
            r5 = r2
            r2 = r0
            r0 = r5
            goto L7b
        L58:
            r5 = r2
            r2 = r0
            r0 = r5
            goto L63
        L5c:
            r2 = move-exception
            r7 = r0
            r1 = r7
            goto L7b
        L60:
            r2 = move-exception
            r7 = r0
            r1 = r7
        L63:
            com.huawei.hianalytics.core.transport.Utils.handlerException(r2)     // Catch: java.lang.Throwable -> L26
            r6.m28801a(r0)
            r6.m28801a(r7)
            if (r1 == 0) goto L71
            r1.disconnect()
        L71:
            com.huawei.hianalytics.core.transport.net.Response r6 = new com.huawei.hianalytics.core.transport.net.Response
            r7 = -108(0xffffffffffffff94, float:NaN)
            java.lang.String r0 = ""
            r6.<init>(r7, r0)
            return r6
        L7b:
            r6.m28801a(r0)
            r6.m28801a(r7)
            if (r1 == 0) goto L86
            r1.disconnect()
        L86:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hianalytics.core.C4740f.m28798a(java.lang.String):com.huawei.hianalytics.core.transport.net.Response");
    }

    /* renamed from: a */
    public final String m28799a(HttpURLConnection httpURLConnection) throws Throwable {
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th2;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (IOException unused) {
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (IOException unused2) {
        } catch (Throwable th4) {
            th = th4;
            m28801a(byteArrayOutputStream2);
            m28801a(inputStream);
            throw th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i10 = inputStream.read(bArr);
                if (i10 == -1) {
                    String string = byteArrayOutputStream.toString(Constants.UTF_8);
                    m28801a(byteArrayOutputStream);
                    m28801a(inputStream);
                    return string;
                }
                byteArrayOutputStream.write(bArr, 0, i10);
            }
        } catch (IOException unused3) {
            byteArrayOutputStream2 = byteArrayOutputStream;
            try {
                HiLog.m28808e("HttpTransportHandler", HiLog.ErrorCode.NE004);
                m28801a(byteArrayOutputStream2);
                m28801a(inputStream);
                return "";
            } catch (Throwable th5) {
                byteArrayOutputStream = byteArrayOutputStream2;
                th2 = th5;
                ByteArrayOutputStream byteArrayOutputStream3 = byteArrayOutputStream;
                th = th2;
                byteArrayOutputStream2 = byteArrayOutputStream3;
                m28801a(byteArrayOutputStream2);
                m28801a(inputStream);
                throw th;
            }
        } catch (Throwable th6) {
            th2 = th6;
            ByteArrayOutputStream byteArrayOutputStream32 = byteArrayOutputStream;
            th = th2;
            byteArrayOutputStream2 = byteArrayOutputStream32;
            m28801a(byteArrayOutputStream2);
            m28801a(inputStream);
            throw th;
        }
    }

    /* renamed from: a */
    public final void m28801a(Closeable closeable) throws IOException {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
            HiLog.m28812w("HttpTransportHandler", "closeQuietly(): Exception when closing the closeable!");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.net.HttpURLConnection m28800a(java.lang.String r5, java.lang.String r6) throws java.net.ProtocolException, com.huawei.hianalytics.core.C4740f.a, java.lang.IllegalArgumentException {
        /*
            r4 = this;
            java.lang.String r0 = "HttpTransportHandler"
            java.net.URL r1 = new java.net.URL
            r1.<init>(r5)
            java.net.URLConnection r5 = r1.openConnection()
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5
            boolean r1 = r5 instanceof javax.net.ssl.HttpsURLConnection
            if (r1 == 0) goto L44
            r1 = r5
            javax.net.ssl.HttpsURLConnection r1 = (javax.net.ssl.HttpsURLConnection) r1
            android.content.Context r2 = com.huawei.hianalytics.core.common.EnvUtils.getAppContext()     // Catch: java.io.IOException -> L21 java.security.GeneralSecurityException -> L27 java.security.KeyStoreException -> L2a java.security.NoSuchAlgorithmException -> L2d
            java.security.SecureRandom r3 = gu.C10048b.m62471c()     // Catch: java.io.IOException -> L21 java.security.GeneralSecurityException -> L27 java.security.KeyStoreException -> L2a java.security.NoSuchAlgorithmException -> L2d
            iu.a r0 = p373iu.C10613a.m65057b(r2, r3)     // Catch: java.io.IOException -> L21 java.security.GeneralSecurityException -> L27 java.security.KeyStoreException -> L2a java.security.NoSuchAlgorithmException -> L2d
            goto L31
        L21:
            java.lang.String r2 = "getSocketFactory(): IO Exception!"
        L23:
            com.huawei.hianalytics.core.log.HiLog.m28808e(r0, r2)
            goto L30
        L27:
            java.lang.String r2 = "getSocketFactory(): General Security Exception"
            goto L23
        L2a:
            java.lang.String r2 = "getSocketFactory(): Key Store exception"
            goto L23
        L2d:
            java.lang.String r2 = "getSocketFactory(): Algorithm Exception!"
            goto L23
        L30:
            r0 = 0
        L31:
            if (r0 == 0) goto L3c
            r1.setSSLSocketFactory(r0)
            org.apache.http.conn.ssl.X509HostnameVerifier r0 = p373iu.C10617e.f51042j
            r1.setHostnameVerifier(r0)
            goto L44
        L3c:
            com.huawei.hianalytics.core.f$a r4 = new com.huawei.hianalytics.core.f$a
            java.lang.String r5 = "No ssl socket factory set"
            r4.<init>(r5)
            throw r4
        L44:
            r5.setRequestMethod(r6)
            r0 = 15000(0x3a98, float:2.102E-41)
            r5.setConnectTimeout(r0)
            r5.setReadTimeout(r0)
            java.lang.String r0 = "GET"
            boolean r6 = r0.equals(r6)
            if (r6 != 0) goto L67
            r6 = 1
            r5.setDoOutput(r6)
            byte[] r6 = r4.f21697c
            int r6 = r6.length
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.String r0 = "Conntent-Length"
            r5.setRequestProperty(r0, r6)
        L67:
            java.lang.String r6 = "Content-Type"
            java.lang.String r0 = "application/json; charset=UTF-8"
            r5.setRequestProperty(r6, r0)
            java.lang.String r6 = "Connection"
            java.lang.String r0 = "close"
            r5.setRequestProperty(r6, r0)
            java.util.Map<java.lang.String, java.lang.String> r6 = r4.f21696b
            if (r6 == 0) goto Lbd
            int r6 = r6.size()
            if (r6 <= 0) goto Lbd
            java.util.Map<java.lang.String, java.lang.String> r4 = r4.f21696b
            java.util.Set r4 = r4.entrySet()
            java.util.Iterator r4 = r4.iterator()
        L89:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto Lbd
            java.lang.Object r6 = r4.next()
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            java.lang.Object r0 = r6.getKey()
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L89
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto La4
            goto L89
        La4:
            java.lang.Object r1 = r6.getValue()
            if (r1 != 0) goto Lad
            java.lang.String r6 = ""
            goto Lb3
        Lad:
            java.lang.Object r6 = r6.getValue()
            java.lang.String r6 = (java.lang.String) r6
        Lb3:
            java.lang.String r1 = "UTF-8"
            java.lang.String r6 = java.net.URLEncoder.encode(r6, r1)
            r5.setRequestProperty(r0, r6)
            goto L89
        Lbd:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hianalytics.core.C4740f.m28800a(java.lang.String, java.lang.String):java.net.HttpURLConnection");
    }
}
