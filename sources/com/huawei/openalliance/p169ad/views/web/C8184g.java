package com.huawei.openalliance.p169ad.views.web;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import com.huawei.hms.network.embedded.C5927g2;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

/* renamed from: com.huawei.openalliance.ad.views.web.g */
/* loaded from: classes2.dex */
public class C8184g extends Thread {

    /* renamed from: a */
    private SSLSocketFactory f38368a;

    /* renamed from: b */
    private HostnameVerifier f38369b;

    /* renamed from: c */
    private org.apache.http.conn.ssl.SSLSocketFactory f38370c;

    /* renamed from: d */
    private X509HostnameVerifier f38371d;

    /* renamed from: e */
    private SslErrorHandler f38372e;

    /* renamed from: f */
    private String f38373f;

    /* renamed from: g */
    private a f38374g;

    /* renamed from: h */
    private Context f38375h;

    /* renamed from: com.huawei.openalliance.ad.views.web.g$a */
    public interface a {
        /* renamed from: a */
        void mo50687a(Context context, String str);

        /* renamed from: b */
        void mo50688b(Context context, String str);
    }

    /* renamed from: a */
    private void m50697a() {
        AbstractC7185ho.m43820b("WebViewSSLCheckThread", "callbackCancel: ");
        if (this.f38372e != null) {
            AbstractC7185ho.m43820b("WebViewSSLCheckThread", "callbackCancel 2: ");
            this.f38372e.cancel();
        }
        a aVar = this.f38374g;
        if (aVar != null) {
            aVar.mo50688b(this.f38375h, this.f38373f);
        }
    }

    /* renamed from: b */
    private void m50701b() {
        AbstractC7185ho.m43820b("WebViewSSLCheckThread", "callbackProceed: ");
        SslErrorHandler sslErrorHandler = this.f38372e;
        if (sslErrorHandler != null) {
            sslErrorHandler.proceed();
        }
        a aVar = this.f38374g;
        if (aVar != null) {
            aVar.mo50687a(this.f38375h, this.f38373f);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [javax.net.ssl.HostnameVerifier] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r1v22, types: [org.apache.http.client.HttpClient, org.apache.http.impl.client.DefaultHttpClient] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws Throwable {
        HttpsURLConnection httpsURLConnection;
        InputStream inputStream;
        super.run();
        HttpsURLConnection httpsURLConnection2 = null;
        Reader reader = null;
        Reader reader2 = null;
        if (this.f38370c != null && this.f38371d != null) {
            if (this.f38372e != null) {
                try {
                    if (!TextUtils.isEmpty(this.f38373f)) {
                        try {
                            this.f38370c.setHostnameVerifier(this.f38371d);
                            BasicHttpParams basicHttpParams = new BasicHttpParams();
                            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
                            HttpConnectionParams.setSoTimeout(basicHttpParams, 10000);
                            SchemeRegistry schemeRegistry = new SchemeRegistry();
                            schemeRegistry.register(new Scheme("https", this.f38370c, C5927g2.f26808n));
                            schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
                            ?? defaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
                            HttpGet httpGet = new HttpGet();
                            httpGet.setURI(new URI(this.f38373f));
                            AbstractC7185ho.m43820b("WebViewSSLCheckThread", "status code is : " + defaultHttpClient.execute(httpGet).getStatusLine().getStatusCode());
                            m50700a((Reader) null);
                            m50701b();
                            return;
                        } catch (IOException e10) {
                            AbstractC7185ho.m43818a("WebViewSSLCheckThread", "apache IOException  exception : %s", e10.getMessage());
                            AbstractC7185ho.m43823c("WebViewSSLCheckThread", "apache IOException  exception : " + e10.getClass().getSimpleName());
                            m50697a();
                            return;
                        } catch (Throwable th2) {
                            AbstractC7185ho.m43818a("WebViewSSLCheckThread", "apache run: exception : %s", th2.getMessage());
                            AbstractC7185ho.m43823c("WebViewSSLCheckThread", "apache run: exception : " + th2.getClass().getSimpleName());
                            m50697a();
                            return;
                        }
                    }
                } finally {
                    m50700a((Reader) null);
                }
            }
            AbstractC7185ho.m43826d("WebViewSSLCheckThread", "sslErrorHandler or url is null");
            m50697a();
            return;
        }
        if (this.f38368a != null) {
            ?? r02 = this.f38369b;
            try {
                if (r02 != 0) {
                    try {
                        URLConnection uRLConnectionOpenConnection = new URL(this.f38373f).openConnection();
                        if (uRLConnectionOpenConnection instanceof HttpsURLConnection) {
                            httpsURLConnection = (HttpsURLConnection) uRLConnectionOpenConnection;
                            try {
                                httpsURLConnection.setSSLSocketFactory(this.f38368a);
                                httpsURLConnection.setHostnameVerifier(this.f38369b);
                                httpsURLConnection.setRequestMethod("GET");
                                httpsURLConnection.setConnectTimeout(10000);
                                httpsURLConnection.setReadTimeout(20000);
                                httpsURLConnection.getResponseCode();
                                httpsURLConnection2 = httpsURLConnection;
                                inputStream = httpsURLConnection.getInputStream();
                            } catch (IOException e11) {
                                e = e11;
                                AbstractC7185ho.m43818a("WebViewSSLCheckThread", "IOException : %s", e.getMessage());
                                AbstractC7185ho.m43823c("WebViewSSLCheckThread", "IOException : " + e.getClass().getSimpleName());
                                m50697a();
                                if (httpsURLConnection != null) {
                                    httpsURLConnection.disconnect();
                                }
                                m50699a((InputStream) null);
                                return;
                            } catch (Exception e12) {
                                e = e12;
                                AbstractC7185ho.m43818a("WebViewSSLCheckThread", "exception : %s", e.getMessage());
                                AbstractC7185ho.m43823c("WebViewSSLCheckThread", "exception : " + e.getClass().getSimpleName());
                                m50697a();
                                if (httpsURLConnection != null) {
                                    httpsURLConnection.disconnect();
                                }
                                m50699a((InputStream) null);
                                return;
                            }
                        } else {
                            inputStream = null;
                        }
                        if (httpsURLConnection2 != null) {
                            httpsURLConnection2.disconnect();
                        }
                        m50699a(inputStream);
                        m50701b();
                        return;
                    } catch (IOException e13) {
                        e = e13;
                        httpsURLConnection = null;
                    } catch (Exception e14) {
                        e = e14;
                        httpsURLConnection = null;
                    } catch (Throwable th3) {
                        th = th3;
                        r02 = 0;
                        if (r02 != 0) {
                            r02.disconnect();
                        }
                        m50699a((InputStream) null);
                        throw th;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
        m50697a();
    }

    /* renamed from: a */
    private void m50698a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                AbstractC7185ho.m43826d("WebViewSSLCheckThread", "closeSecure IOException");
            }
        }
    }

    /* renamed from: a */
    private void m50699a(InputStream inputStream) throws IOException {
        m50698a((Closeable) inputStream);
    }

    /* renamed from: a */
    private void m50700a(Reader reader) throws IOException {
        m50698a((Closeable) reader);
    }
}
