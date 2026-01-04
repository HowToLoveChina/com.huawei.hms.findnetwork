package com.baidu.location.p065a;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.baidu.location.a.c */
/* loaded from: classes.dex */
public class C1531c {

    /* renamed from: h */
    private static String[] f6602h = new String[0];

    /* renamed from: i */
    private static HostnameVerifier f6603i = new HostnameVerifier() { // from class: com.baidu.location.a.c.2
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return !Arrays.asList(C1531c.f6602h).contains(str);
        }
    };

    /* renamed from: a */
    HttpURLConnection f6604a;

    /* renamed from: b */
    private String f6605b = null;

    /* renamed from: c */
    private String f6606c = null;

    /* renamed from: d */
    private int f6607d = 5000;

    /* renamed from: e */
    private int f6608e = 5000;

    /* renamed from: f */
    private String f6609f;

    /* renamed from: g */
    private b f6610g;

    /* renamed from: com.baidu.location.a.c$a */
    public enum a {
        NO_ERROR,
        NETWORK_ERROR,
        INNER_ERROR,
        REQUEST_ERROR,
        SERVER_ERROR
    }

    /* renamed from: com.baidu.location.a.c$b */
    public static abstract class b {
        /* renamed from: a */
        public abstract void mo8700a(a aVar);

        /* renamed from: a */
        public abstract void mo8701a(String str);
    }

    public C1531c(String str, b bVar) {
        this.f6609f = str;
        this.f6610g = bVar;
    }

    /* renamed from: b */
    private SSLSocketFactory m8696b() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sSLContext;
        X509TrustManager x509TrustManager = new X509TrustManager() { // from class: com.baidu.location.a.c.1
            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            }

            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };
        try {
            sSLContext = SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e10) {
            e10.printStackTrace();
            sSLContext = null;
        }
        try {
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, new SecureRandom());
        } catch (KeyManagementException e11) {
            e11.printStackTrace();
        }
        return sSLContext.getSocketFactory();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v26, types: [java.io.OutputStreamWriter, java.io.Writer] */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v14, types: [int] */
    /* JADX WARN: Type inference failed for: r6v34 */
    /* JADX WARN: Type inference failed for: r6v35 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.net.HttpURLConnection, java.net.URLConnection] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* renamed from: a */
    public String m8697a(String str, String str2) throws ProtocolException {
        String str3;
        boolean z10;
        ?? r62;
        ?? r02;
        InputStream inputStream;
        BufferedReader bufferedReader;
        InputStream inputStream2;
        InputStream inputStream3;
        InputStream inputStream4;
        b bVar;
        a aVar;
        this.f6605b = str;
        boolean zStartsWith = str.startsWith("https://");
        boolean zEquals = this.f6609f.equals("POST");
        HttpURLConnection httpURLConnectionM8693a = m8693a(zEquals, zStartsWith);
        this.f6604a = httpURLConnectionM8693a;
        if (httpURLConnectionM8693a == null) {
            C1534f.m8725c("getURLConnection return null");
            bVar = this.f6610g;
            aVar = a.INNER_ERROR;
        } else if ((zEquals || !TextUtils.isEmpty(this.f6605b)) && !(zEquals && (TextUtils.isEmpty(this.f6605b) || TextUtils.isEmpty(str2)))) {
            try {
                try {
                    if (zEquals) {
                        ?? outputStreamWriter = new OutputStreamWriter(this.f6604a.getOutputStream());
                        outputStreamWriter.write(str2);
                        outputStreamWriter.flush();
                        outputStreamWriter.close();
                        z10 = outputStreamWriter;
                        str3 = str2;
                    } else {
                        ?? r63 = this.f6604a;
                        r63.connect();
                        z10 = zEquals;
                        str3 = r63;
                    }
                    try {
                        try {
                            ?? responseCode = this.f6604a.getResponseCode();
                            C1534f.m8725c("execute(), responseCode:" + responseCode);
                            try {
                                if (200 == responseCode) {
                                    InputStream inputStream5 = this.f6604a.getInputStream();
                                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream5, Constants.UTF_8));
                                    try {
                                        StringBuffer stringBuffer = new StringBuffer();
                                        while (true) {
                                            String line = bufferedReader.readLine();
                                            if (line == null) {
                                                break;
                                            }
                                            stringBuffer.append(line);
                                            stringBuffer.append("\n");
                                        }
                                        this.f6606c = stringBuffer.toString();
                                        inputStream4 = inputStream5;
                                    } catch (MalformedURLException e10) {
                                        e = e10;
                                        inputStream2 = inputStream5;
                                        C1534f.m8725c("execute(),MalformedURLException, read timeout");
                                        m8694a(e);
                                        this.f6610g.mo8700a(a.INNER_ERROR);
                                        if (inputStream2 != null && bufferedReader != null) {
                                            bufferedReader.close();
                                            inputStream2.close();
                                        }
                                        HttpURLConnection httpURLConnection = this.f6604a;
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        return null;
                                    } catch (IOException e11) {
                                        e = e11;
                                        inputStream = inputStream5;
                                        C1534f.m8725c("execute(),IOException");
                                        m8694a(e);
                                        this.f6610g.mo8700a(a.INNER_ERROR);
                                        if (inputStream != null && bufferedReader != null) {
                                            bufferedReader.close();
                                            inputStream.close();
                                        }
                                        HttpURLConnection httpURLConnection2 = this.f6604a;
                                        if (httpURLConnection2 != null) {
                                            httpURLConnection2.disconnect();
                                        }
                                        return null;
                                    }
                                } else {
                                    a aVar2 = a.NO_ERROR;
                                    a aVar3 = responseCode >= 500 ? a.SERVER_ERROR : responseCode >= 400 ? a.REQUEST_ERROR : a.INNER_ERROR;
                                    if (C1534f.f6655a) {
                                        InputStream errorStream = this.f6604a.getErrorStream();
                                        inputStream3 = errorStream;
                                        if (errorStream != null) {
                                            C1534f.m8725c("execute(), exception: " + errorStream.toString());
                                            inputStream3 = errorStream;
                                        }
                                    } else {
                                        C1534f.m8725c("execute(), exception: Get response from server failed, http response code=" + responseCode + ", error=" + aVar3);
                                        inputStream3 = null;
                                    }
                                    this.f6610g.mo8700a(aVar3);
                                    bufferedReader = null;
                                    inputStream4 = inputStream3;
                                }
                                if (inputStream4 != null && bufferedReader != null) {
                                    bufferedReader.close();
                                    inputStream4.close();
                                }
                                HttpURLConnection httpURLConnection3 = this.f6604a;
                                if (httpURLConnection3 != null) {
                                    httpURLConnection3.disconnect();
                                }
                                return this.f6606c;
                            } catch (MalformedURLException e12) {
                                e = e12;
                                bufferedReader = null;
                                inputStream2 = responseCode;
                            } catch (IOException e13) {
                                e = e13;
                                bufferedReader = null;
                                inputStream = responseCode;
                            } catch (Throwable th2) {
                                th = th2;
                                r02 = 0;
                                r62 = responseCode;
                                if (r62 != 0 && r02 != 0) {
                                    r02.close();
                                    r62.close();
                                }
                                throw th;
                            }
                        } catch (MalformedURLException e14) {
                            e = e14;
                            inputStream2 = null;
                            bufferedReader = null;
                        } catch (IOException e15) {
                            e = e15;
                            inputStream = null;
                            bufferedReader = null;
                        } catch (Throwable th3) {
                            th = th3;
                            r62 = 0;
                            r02 = 0;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        r02 = z10;
                        r62 = str3;
                    }
                } catch (MalformedURLException e16) {
                    C1534f.m8725c("execute(),MalformedURLException, connection timeout");
                    m8694a(e16);
                    this.f6610g.mo8700a(a.INNER_ERROR);
                    HttpURLConnection httpURLConnection4 = this.f6604a;
                    if (httpURLConnection4 != null) {
                        httpURLConnection4.disconnect();
                    }
                    return null;
                } catch (IOException e17) {
                    C1534f.m8725c("execute(),IOException");
                    m8694a(e17);
                    this.f6610g.mo8700a(a.INNER_ERROR);
                    HttpURLConnection httpURLConnection5 = this.f6604a;
                    if (httpURLConnection5 != null) {
                        httpURLConnection5.disconnect();
                    }
                    return null;
                }
            } finally {
                HttpURLConnection httpURLConnection6 = this.f6604a;
                if (httpURLConnection6 != null) {
                    httpURLConnection6.disconnect();
                }
            }
        } else {
            C1534f.m8725c("execute() urlstr or paramstrl is empty.");
            bVar = this.f6610g;
            aVar = a.REQUEST_ERROR;
        }
        bVar.mo8700a(aVar);
        return null;
    }

    /* renamed from: a */
    private HttpURLConnection m8693a(boolean z10, boolean z11) throws ProtocolException {
        HttpURLConnection httpURLConnection;
        try {
            URL url = new URL(this.f6605b);
            if (z11) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
                httpsURLConnection.setSSLSocketFactory(m8696b());
                httpsURLConnection.setHostnameVerifier(f6603i);
                httpURLConnection = httpsURLConnection;
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            if (z10) {
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
            } else {
                httpURLConnection.setDoOutput(false);
            }
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod(this.f6609f);
            httpURLConnection.setConnectTimeout(this.f6607d);
            httpURLConnection.setReadTimeout(this.f6608e);
            return httpURLConnection;
        } catch (IOException e10) {
            if (C1534f.f6655a) {
                e10.printStackTrace();
                return null;
            }
            C1534f.m8725c(e10.getMessage());
            return null;
        }
    }

    /* renamed from: b */
    public void m8699b(int i10) {
        this.f6607d = i10;
    }

    /* renamed from: a */
    public void m8698a(int i10) {
        this.f6608e = i10;
    }

    /* renamed from: a */
    private static void m8694a(Exception exc) {
        if (C1534f.f6655a) {
            exc.printStackTrace();
        } else {
            C1534f.m8725c(exc.getMessage());
        }
    }
}
