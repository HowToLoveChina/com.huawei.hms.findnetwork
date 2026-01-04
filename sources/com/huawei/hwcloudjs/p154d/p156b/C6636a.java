package com.huawei.hwcloudjs.p154d.p156b;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.network.embedded.C6142w9;
import com.huawei.hwcloudjs.p154d.p156b.p157a.AbstractC6638b;
import com.huawei.hwcloudjs.p154d.p156b.p157a.AbstractC6639c;
import com.huawei.hwcloudjs.p164f.C6659d;
import com.huawei.hwcloudjs.p164f.C6663h;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import javax.net.ssl.HttpsURLConnection;

/* renamed from: com.huawei.hwcloudjs.d.b.a */
/* loaded from: classes8.dex */
public final class C6636a {

    /* renamed from: a */
    public static final String f30839a = "POST";

    /* renamed from: b */
    private static final String f30840b = "BaseRequest";

    /* renamed from: c */
    public static final int f30841c = 1;

    /* renamed from: d */
    public static final int f30842d = 2;

    /* renamed from: e */
    public static final int f30843e = 3;

    /* renamed from: f */
    public static final int f30844f = 10;

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public <T extends AbstractC6639c> T m37809a(AbstractC6638b<T> abstractC6638b, Context context) throws Throwable {
        Closeable closeable;
        Closeable closeable2;
        String string;
        InputStream inputStream;
        Closeable closeable3;
        InputStream inputStream2;
        HttpURLConnection httpURLConnectionM37808a;
        Closeable closeable4;
        String strMo37815d = abstractC6638b.mo37815d();
        C6659d.m37882c(f30840b, "doRequest begin", true);
        C6659d.m37882c(f30840b, "doRequest urlStr:" + strMo37815d, false);
        T t10 = (T) abstractC6638b.mo37814c();
        InputStream inputStream3 = null;
        try {
            httpURLConnectionM37808a = m37808a(strMo37815d, abstractC6638b.mo37813f(), abstractC6638b.mo37812b(), context);
        } catch (IOException unused) {
            closeable2 = null;
        } catch (RuntimeException e10) {
            e = e10;
            closeable = null;
        } catch (Throwable th2) {
            th = th2;
            closeable = null;
        }
        if (httpURLConnectionM37808a == null) {
            t10.mo37821b(10);
            C6663h.m37901a(null);
            C6663h.m37901a(null);
            return t10;
        }
        httpURLConnectionM37808a.connect();
        String strMo37811a = abstractC6638b.mo37811a();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("genBody:");
        sb2.append(strMo37811a);
        C6659d.m37882c(f30840b, sb2.toString(), false);
        if (TextUtils.isEmpty(strMo37811a)) {
            closeable4 = null;
        } else {
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnectionM37808a.getOutputStream());
            try {
                dataOutputStream.write(strMo37811a.getBytes(Constants.UTF_8));
                dataOutputStream.flush();
                closeable4 = dataOutputStream;
            } catch (IOException unused2) {
                closeable2 = null;
                inputStream3 = dataOutputStream;
                try {
                    t10.mo37821b(3);
                    inputStream = inputStream3;
                    closeable3 = closeable2;
                    string = "geturl failed IOException";
                    inputStream2 = inputStream;
                } catch (Throwable th3) {
                    closeable = closeable2;
                    th = th3;
                    C6663h.m37901a(closeable);
                    C6663h.m37901a(inputStream3);
                    throw th;
                }
                try {
                    C6659d.m37881b(f30840b, string, true);
                    C6663h.m37901a(closeable3);
                    C6663h.m37901a(inputStream2);
                    return t10;
                } catch (Throwable th4) {
                    th = th4;
                    Closeable closeable5 = closeable3;
                    inputStream3 = inputStream2;
                    closeable = closeable5;
                    C6663h.m37901a(closeable);
                    C6663h.m37901a(inputStream3);
                    throw th;
                }
            } catch (RuntimeException e11) {
                e = e11;
                closeable = null;
                inputStream3 = dataOutputStream;
                try {
                    t10.mo37821b(10);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("doRequest RuntimeException:");
                    sb3.append(e.getClass().getSimpleName());
                    string = sb3.toString();
                    inputStream = inputStream3;
                    closeable3 = closeable;
                    inputStream2 = inputStream;
                    C6659d.m37881b(f30840b, string, true);
                    C6663h.m37901a(closeable3);
                    C6663h.m37901a(inputStream2);
                    return t10;
                } catch (Throwable th5) {
                    th = th5;
                    C6663h.m37901a(closeable);
                    C6663h.m37901a(inputStream3);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                closeable = null;
                inputStream3 = dataOutputStream;
                C6663h.m37901a(closeable);
                C6663h.m37901a(inputStream3);
                throw th;
            }
        }
        int responseCode = httpURLConnectionM37808a.getResponseCode();
        if (responseCode == 200) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("urlConnection getResponseCode:");
            sb4.append(responseCode);
            C6659d.m37882c(f30840b, sb4.toString(), false);
            inputStream3 = httpURLConnectionM37808a.getInputStream();
            String strM37806a = m37806a(inputStream3);
            t10.mo37821b(1);
            t10.mo37817a(responseCode);
            HashMap map = new HashMap();
            String[] strArrMo37819a = t10.mo37819a();
            if (strArrMo37819a.length > 0) {
                for (String str : strArrMo37819a) {
                    map.put(str, httpURLConnectionM37808a.getHeaderField(str));
                }
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("readStream res:");
            sb5.append(strM37806a);
            C6659d.m37882c(f30840b, sb5.toString(), false);
            t10.mo37818a(strM37806a, map);
        } else {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("geturl failed");
            sb6.append(responseCode);
            C6659d.m37881b(f30840b, sb6.toString(), true);
            t10.mo37821b(2);
            t10.mo37817a(responseCode);
        }
        C6663h.m37901a(inputStream3);
        C6663h.m37901a(closeable4);
        return t10;
    }

    /* renamed from: a */
    private String m37806a(InputStream inputStream) throws IOException {
        StringBuilder sb2;
        C6659d.m37882c(f30840b, "readStream begin", true);
        C6659d.m37882c(f30840b, "readStream inStream:" + inputStream, false);
        String string = "";
        if (inputStream == null) {
            C6659d.m37881b(f30840b, "readStream inStream is null", true);
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                try {
                    int i10 = inputStream.read(bArr);
                    if (i10 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i10);
                } catch (IOException e10) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("readStream IOException:");
                    sb3.append(e10.getClass().getSimpleName());
                    C6659d.m37881b(f30840b, sb3.toString(), true);
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e11) {
                        e = e11;
                        sb2 = new StringBuilder();
                        sb2.append("outStream IOException:");
                        sb2.append(e.getClass().getSimpleName());
                        C6659d.m37881b(f30840b, sb2.toString(), true);
                        C6659d.m37882c(f30840b, "readStream response:" + string, false);
                        return string;
                    }
                }
            } catch (Throwable th2) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e12) {
                    C6659d.m37881b(f30840b, "outStream IOException:" + e12.getClass().getSimpleName(), true);
                }
                throw th2;
            }
        }
        string = byteArrayOutputStream.toString(Constants.UTF_8);
        try {
            byteArrayOutputStream.close();
        } catch (IOException e13) {
            e = e13;
            sb2 = new StringBuilder();
            sb2.append("outStream IOException:");
            sb2.append(e.getClass().getSimpleName());
            C6659d.m37881b(f30840b, sb2.toString(), true);
            C6659d.m37882c(f30840b, "readStream response:" + string, false);
            return string;
        }
        C6659d.m37882c(f30840b, "readStream response:" + string, false);
        return string;
    }

    /* renamed from: a */
    private HttpURLConnection m37807a(String str, Context context) throws IOException {
        String str2;
        HttpsURLConnection httpsURLConnection = null;
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getUrlConnection urlString:");
            sb2.append(str);
            C6659d.m37882c(f30840b, sb2.toString(), false);
            URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
            if (str.startsWith("http://")) {
                if (uRLConnectionOpenConnection instanceof HttpURLConnection) {
                    return (HttpURLConnection) uRLConnectionOpenConnection;
                }
                C6659d.m37881b(f30840b, "getURLConnection url.openConnection() is error", true);
                return null;
            }
            if (uRLConnectionOpenConnection instanceof HttpsURLConnection) {
                HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) uRLConnectionOpenConnection;
                try {
                    C6641c.m37824a(httpsURLConnection2, context);
                    return httpsURLConnection2;
                } catch (MalformedURLException unused) {
                    httpsURLConnection = httpsURLConnection2;
                    str2 = "getUrlConnection MalformedURLException";
                    C6659d.m37881b(f30840b, str2, true);
                    return httpsURLConnection;
                } catch (IOException unused2) {
                    httpsURLConnection = httpsURLConnection2;
                    str2 = "getUrlConnection IOException";
                    C6659d.m37881b(f30840b, str2, true);
                    return httpsURLConnection;
                }
            }
            C6659d.m37881b(f30840b, "getURLConnection url.openConnection() is error", true);
            return null;
        } catch (MalformedURLException unused3) {
        } catch (IOException unused4) {
        }
    }

    /* renamed from: a */
    private HttpURLConnection m37808a(String str, String str2, String str3, Context context) throws ProtocolException {
        HttpURLConnection httpURLConnectionM37807a;
        try {
            httpURLConnectionM37807a = m37807a(str, context);
            try {
            } catch (IOException unused) {
                C6659d.m37881b(f30840b, "getURLConnection IOException", true);
                return httpURLConnectionM37807a;
            }
        } catch (IOException unused2) {
            httpURLConnectionM37807a = null;
        }
        if (httpURLConnectionM37807a == null) {
            C6659d.m37882c(f30840b, "urlConnection is null", true);
            return httpURLConnectionM37807a;
        }
        httpURLConnectionM37807a.setRequestMethod(str2);
        httpURLConnectionM37807a.setDoInput(true);
        if (str2.equalsIgnoreCase("POST")) {
            httpURLConnectionM37807a.setDoOutput(true);
        }
        httpURLConnectionM37807a.setUseCaches(false);
        httpURLConnectionM37807a.setConnectTimeout(60000);
        httpURLConnectionM37807a.setReadTimeout(60000);
        httpURLConnectionM37807a.setRequestProperty("Connection", C6142w9.f28869j);
        httpURLConnectionM37807a.setRequestProperty("Charset", Constants.UTF_8);
        if (str3 != null) {
            httpURLConnectionM37807a.setRequestProperty("Content-Type", str3);
        }
        return httpURLConnectionM37807a;
    }
}
