package com.huawei.updatesdk.p177a.p178a.p179b;

import android.content.Context;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.updatesdk.p177a.p178a.p180c.p181a.p182a.C8777a;
import com.huawei.updatesdk.p177a.p178a.p183d.AbstractC8782d;
import com.huawei.updatesdk.p177a.p178a.p183d.C8780b;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import p373iu.C10618f;
import p406ju.C10929a;

/* renamed from: com.huawei.updatesdk.a.a.b.b */
/* loaded from: classes9.dex */
public class C8776b {

    /* renamed from: a */
    private HttpURLConnection f45067a = null;

    /* renamed from: com.huawei.updatesdk.a.a.b.b$a */
    public static class a {

        /* renamed from: a */
        private String f45068a;

        /* renamed from: b */
        private int f45069b;

        /* renamed from: c */
        private String f45070c;

        /* renamed from: a */
        public int m56023a() {
            return this.f45069b;
        }

        /* renamed from: b */
        public String m56024b() {
            return this.f45068a;
        }

        /* renamed from: c */
        public String m56025c() {
            return this.f45070c;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public a m56018a(String str, String str2, String str3, String str4, Context context) throws Throwable {
        Throwable th2;
        BufferedInputStream bufferedInputStream;
        DataOutputStream dataOutputStream;
        a aVar = new a();
        BufferedInputStream bufferedInputStream2 = null;
        try {
            HttpURLConnection httpURLConnectionM56015a = m56015a(str, context);
            this.f45067a = httpURLConnectionM56015a;
            httpURLConnectionM56015a.setDoInput(true);
            this.f45067a.setDoOutput(true);
            this.f45067a.setUseCaches(false);
            this.f45067a.setConnectTimeout(5000);
            this.f45067a.setReadTimeout(10000);
            this.f45067a.setRequestMethod("POST");
            this.f45067a.setRequestProperty("Content-Type", "application/x-gzip");
            this.f45067a.setRequestProperty("Content-Encoding", Constants.GZIP);
            this.f45067a.setRequestProperty("Connection", "Keep-Alive");
            this.f45067a.setRequestProperty("User-Agent", str4);
            dataOutputStream = new DataOutputStream(this.f45067a.getOutputStream());
        } catch (Throwable th3) {
            th2 = th3;
            bufferedInputStream = null;
        }
        try {
            dataOutputStream.write(m56017a(str2.getBytes(str3)));
            dataOutputStream.flush();
            m56016a(aVar, this.f45067a);
            int responseCode = this.f45067a.getResponseCode();
            aVar.f45069b = responseCode;
            bufferedInputStream2 = responseCode == 200 ? new BufferedInputStream(this.f45067a.getInputStream()) : new BufferedInputStream(this.f45067a.getErrorStream());
            C8780b c8780b = new C8780b();
            byte[] bArrM56014a = C8775a.m56011b().m56014a();
            while (true) {
                int i10 = bufferedInputStream2.read(bArrM56014a);
                if (i10 == -1) {
                    break;
                }
                c8780b.m56036a(bArrM56014a, i10);
            }
            C8775a.m56011b().m56013a(bArrM56014a);
            aVar.f45068a = c8780b.m56035a();
            HttpURLConnection httpURLConnection = this.f45067a;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            AbstractC8782d.m56039a(dataOutputStream);
            AbstractC8782d.m56039a(bufferedInputStream2);
            return aVar;
        } catch (Throwable th4) {
            th2 = th4;
            BufferedInputStream bufferedInputStream3 = bufferedInputStream2;
            bufferedInputStream2 = dataOutputStream;
            bufferedInputStream = bufferedInputStream3;
            HttpURLConnection httpURLConnection2 = this.f45067a;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            AbstractC8782d.m56039a(bufferedInputStream2);
            AbstractC8782d.m56039a(bufferedInputStream);
            throw th2;
        }
    }

    /* renamed from: a */
    public static HttpURLConnection m56015a(String str, Context context) {
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
        httpsURLConnection.setSSLSocketFactory(C10618f.m65075b(context));
        httpsURLConnection.setHostnameVerifier(new C10929a());
        return httpsURLConnection;
    }

    /* renamed from: a */
    public void m56019a() {
        HttpURLConnection httpURLConnection = this.f45067a;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    /* renamed from: a */
    private void m56016a(a aVar, HttpURLConnection httpURLConnection) {
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        if (headerFields == null) {
            C8777a.m56030d("HttpsUtil", "headers is null.");
            return;
        }
        List<String> list = headerFields.get("x-traceId");
        if (list == null || list.isEmpty()) {
            C8777a.m56030d("HttpsUtil", "no x-traceId.");
        } else {
            aVar.f45070c = list.get(0);
        }
    }

    /* renamed from: a */
    private byte[] m56017a(byte[] bArr) throws Throwable {
        DataOutputStream dataOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                dataOutputStream = new DataOutputStream(new GZIPOutputStream(byteArrayOutputStream, bArr.length));
                try {
                    dataOutputStream.write(bArr, 0, bArr.length);
                    dataOutputStream.flush();
                } catch (IOException e10) {
                    e = e10;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    try {
                        C8777a.m56027a("HttpsUtil", "gzip error!", e);
                        byteArrayOutputStream = byteArrayOutputStream2;
                        AbstractC8782d.m56039a(dataOutputStream);
                        AbstractC8782d.m56039a(byteArrayOutputStream);
                        return byteArrayOutputStream.toByteArray();
                    } catch (Throwable th2) {
                        th = th2;
                        AbstractC8782d.m56039a(dataOutputStream);
                        AbstractC8782d.m56039a(byteArrayOutputStream2);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    AbstractC8782d.m56039a(dataOutputStream);
                    AbstractC8782d.m56039a(byteArrayOutputStream2);
                    throw th;
                }
            } catch (IOException e11) {
                e = e11;
                dataOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                dataOutputStream = null;
            }
        } catch (IOException e12) {
            e = e12;
            dataOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            dataOutputStream = null;
        }
        AbstractC8782d.m56039a(dataOutputStream);
        AbstractC8782d.m56039a(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
