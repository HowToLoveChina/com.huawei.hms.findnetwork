package com.huawei.hms.network.embedded;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.network.base.common.Headers;
import com.huawei.hms.network.base.common.MediaType;
import com.huawei.hms.network.embedded.C5913f1;
import com.huawei.hms.network.embedded.C5939h1;
import com.huawei.hms.network.embedded.C6107u0;
import com.huawei.hms.network.httpclient.RequestFinishedInfo;
import com.huawei.hms.network.httpclient.Response;
import com.huawei.hms.network.httpclient.ResponseBody;
import com.huawei.hms.network.httpclient.websocket.WebSocket;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* renamed from: com.huawei.hms.network.embedded.e4 */
/* loaded from: classes8.dex */
public class C5903e4 implements InterfaceC5886d1 {

    /* renamed from: g */
    public static final String f26679g = "URLConnectionRequestTask";

    /* renamed from: a */
    public C5916f4 f26680a;

    /* renamed from: b */
    public C5939h1.d f26681b;

    /* renamed from: c */
    public HttpURLConnection f26682c;

    /* renamed from: d */
    public C5875c4 f26683d = new C5875c4();

    /* renamed from: e */
    public volatile boolean f26684e;

    /* renamed from: f */
    public boolean f26685f;

    public C5903e4(C5916f4 c5916f4) {
        this.f26680a = c5916f4;
    }

    /* renamed from: a */
    private Response<ResponseBody> m34113a(C5875c4 c5875c4, HttpURLConnection httpURLConnection) throws IOException {
        int responseCode = httpURLConnection.getResponseCode();
        if (this.f26684e) {
            httpURLConnection.disconnect();
            throw C6094t0.m35373a("Canceled");
        }
        c5875c4.m34036e();
        C6107u0.b bVar = new C6107u0.b();
        Map<String, List<String>> mapM34116a = m34116a(httpURLConnection.getHeaderFields());
        c5875c4.m34030a(mapM34116a);
        c5875c4.m34035d();
        C5913f1.b bVar2 = new C5913f1.b();
        String contentType = httpURLConnection.getContentType();
        MediaType mediaType = contentType != null ? MediaType.parse(contentType) : null;
        bVar2.inputStream(responseCode >= 400 ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream()).contentLength(httpURLConnection.getContentLength()).contentType(contentType).charSet(mediaType != null ? mediaType.charset() : null);
        C5913f1 c5913f1Build = bVar2.build();
        c5875c4.m34032b(c5913f1Build.getContentLength());
        bVar.body(new C5939h1.g(c5913f1Build)).code(responseCode).message(httpURLConnection.getResponseMessage()).url(this.f26681b != null ? httpURLConnection.getURL() == null ? this.f26681b.getUrl() : httpURLConnection.getURL().toString() : null).headers(mapM34116a);
        if (!this.f26684e) {
            return bVar.build();
        }
        httpURLConnection.disconnect();
        throw C6094t0.m35373a("Canceled");
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5886d1
    public void cancel() {
        this.f26684e = true;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5886d1
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public InterfaceC5886d1 m85654clone() {
        return new C5903e4(this.f26680a);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5886d1
    public C5939h1.f<ResponseBody> execute(C5939h1.d dVar, WebSocket webSocket) throws Exception {
        Logger.m32141i(f26679g, "the request has used the URLConnection!");
        if (webSocket != null) {
            Logger.m32145w(f26679g, "URLConnection can't use websocket");
            throw C6094t0.m35379d("URLConnection can't use websocket");
        }
        this.f26683d.m34028a(dVar.getUrl());
        try {
            synchronized (this) {
                if (this.f26685f) {
                    throw new IllegalStateException("Already executed.");
                }
                this.f26685f = true;
            }
            if (this.f26684e) {
                throw C6094t0.m35373a("Canceled");
            }
            this.f26681b = dVar;
            this.f26682c = m34114a(this.f26683d, dVar);
            if (this.f26684e) {
                this.f26682c.disconnect();
                throw C6094t0.m35373a("Canceled");
            }
            C5939h1.f<ResponseBody> fVar = new C5939h1.f<>(m34113a(this.f26683d, this.f26682c));
            this.f26683d.m34026a(fVar);
            return fVar;
        } catch (Exception e10) {
            this.f26683d.m34027a(e10);
            throw e10;
        }
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5886d1
    public C5902e3 getConnectionInfo() {
        return null;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5886d1
    public RequestFinishedInfo getRequestFinishedInfo() {
        return this.f26683d.getRequestFinishedInfo();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5886d1
    public boolean isCanceled() {
        return this.f26684e;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5886d1
    public synchronized boolean isExecuted() {
        return this.f26685f;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5886d1
    public C5939h1.d request() {
        return this.f26681b;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5886d1
    public void setRcEventListener(AbstractC6174z2 abstractC6174z2) {
    }

    /* renamed from: a */
    private HttpURLConnection m34114a(C5875c4 c5875c4, C5939h1.d dVar) throws IOException {
        URL url = new URL(dVar.getUrl());
        c5875c4.m34033b(url.getHost());
        HttpURLConnection httpURLConnectionM34115a = m34115a(url);
        c5875c4.m34029a(url.getHost(), "", "", this);
        c5875c4.m34034c();
        m34117a(httpURLConnectionM34115a, Headers.m33636of(dVar.getHeaders()));
        httpURLConnectionM34115a.setConnectTimeout(dVar.getNetConfig().getConnectTimeout());
        httpURLConnectionM34115a.setReadTimeout(dVar.getNetConfig().getReadTimeout());
        httpURLConnectionM34115a.setDoInput(true);
        httpURLConnectionM34115a.setRequestMethod(dVar.getMethod());
        c5875c4.m34031b();
        if (dVar.getBody() != null) {
            c5875c4.m34024a();
            httpURLConnectionM34115a.setDoOutput(true);
            httpURLConnectionM34115a.setRequestProperty("Content-Type", dVar.getBody().contentType());
            OutputStream outputStream = null;
            try {
                if (dVar.getBody().contentLength() != -1) {
                    httpURLConnectionM34115a.setFixedLengthStreamingMode((int) dVar.getBody().contentLength());
                }
                Logger.m32141i(f26679g, "maybe you should override the RequestBody's contentLength() ");
                outputStream = httpURLConnectionM34115a.getOutputStream();
                dVar.getBody().writeTo(outputStream);
                outputStream.flush();
                IoUtils.closeSecure(outputStream);
            } catch (Throwable th2) {
                IoUtils.closeSecure(outputStream);
                throw th2;
            }
        }
        return httpURLConnectionM34115a;
    }

    /* renamed from: a */
    private HttpURLConnection m34115a(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) (this.f26680a.getProxy() != null ? url.openConnection(this.f26680a.getProxy()) : url.openConnection());
        if (!(httpURLConnection instanceof HttpsURLConnection)) {
            return httpURLConnection;
        }
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
        httpsURLConnection.setSSLSocketFactory(this.f26680a.getSslSocketFactory());
        httpsURLConnection.setHostnameVerifier(this.f26680a.getHostnameVerifier());
        return httpsURLConnection;
    }

    /* renamed from: a */
    private Map<String, List<String>> m34116a(Map<String, List<String>> map) {
        HashMap map2 = new HashMap();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            map2.put(TextUtils.isEmpty(entry.getKey()) ? "null" : entry.getKey(), entry.getValue());
        }
        return map2;
    }

    /* renamed from: a */
    private void m34117a(HttpURLConnection httpURLConnection, Headers headers) {
        if (httpURLConnection == null || headers == null) {
            return;
        }
        boolean z10 = false;
        for (int i10 = 0; i10 < headers.size(); i10++) {
            String strName = headers.name(i10);
            httpURLConnection.addRequestProperty(strName, headers.value(i10));
            if (!z10 && StringUtils.toLowerCase(strName).equals(FeedbackWebConstants.USER_AGENT)) {
                z10 = true;
            }
        }
        if (z10) {
            return;
        }
        httpURLConnection.addRequestProperty("User-Agent", C5965j1.getUserAgent(ContextHolder.getAppContext()));
    }
}
