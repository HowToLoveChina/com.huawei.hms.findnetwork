package com.huawei.hms.network.embedded;

import android.text.TextUtils;
import com.huawei.hms.framework.common.CheckParamUtils;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.network.embedded.AbstractC6174z2;
import com.huawei.hms.network.embedded.C5872c1;
import com.huawei.hms.network.embedded.C5939h1;
import com.huawei.hms.network.embedded.C6096t2;
import com.huawei.hms.network.embedded.InterfaceC5886d1;
import com.huawei.hms.network.httpclient.Callback;
import com.huawei.hms.network.httpclient.HttpClient;
import com.huawei.hms.network.httpclient.Interceptor;
import com.huawei.hms.network.httpclient.Request;
import com.huawei.hms.network.httpclient.Response;
import com.huawei.hms.network.httpclient.ResponseBody;
import com.huawei.hms.network.httpclient.Submit;
import com.huawei.hms.network.httpclient.config.NetworkConfig;
import com.huawei.hms.network.httpclient.excutor.PolicyExecutor;
import com.huawei.hms.network.httpclient.internal.IHttpClientBuilder;
import com.huawei.hms.network.httpclient.websocket.WebSocket;
import com.huawei.hms.network.httpclient.websocket.WebSocketListener;
import com.huawei.hms.network.inner.api.PolicyNetworkService;
import com.huawei.secure.android.common.ssl.SecureX509TrustManager;
import gu.C10048b;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.json.JSONException;
import org.json.JSONObject;
import p373iu.C10618f;
import p406ju.C10929a;

/* renamed from: com.huawei.hms.network.embedded.a1 */
/* loaded from: classes8.dex */
public class C5844a1 extends HttpClient {

    /* renamed from: p */
    public static final String f26299p = "RealHttpClient";

    /* renamed from: q */
    public static final int f26300q = 101;

    /* renamed from: r */
    public static volatile X509TrustManager f26301r;

    /* renamed from: s */
    public static volatile HostnameVerifier f26302s;

    /* renamed from: a */
    public final List<Interceptor> f26303a;

    /* renamed from: b */
    public final List<Interceptor> f26304b;

    /* renamed from: c */
    public InterfaceC5886d1.a f26305c;

    /* renamed from: d */
    public volatile InterfaceC5886d1.a f26306d;

    /* renamed from: e */
    public volatile X509TrustManager f26307e;

    /* renamed from: f */
    public volatile SSLSocketFactory f26308f;

    /* renamed from: g */
    public volatile HostnameVerifier f26309g;

    /* renamed from: h */
    public AbstractC6174z2.c f26310h;

    /* renamed from: i */
    public boolean f26311i;

    /* renamed from: j */
    public InterfaceC6031o2 f26312j;

    /* renamed from: k */
    public Proxy f26313k;

    /* renamed from: l */
    public ProxySelector f26314l;

    /* renamed from: m */
    public C6017n1 f26315m;

    /* renamed from: n */
    public boolean f26316n;

    /* renamed from: o */
    public final PolicyExecutor f26317o;

    /* renamed from: com.huawei.hms.network.embedded.a1$b */
    public static final class b extends IHttpClientBuilder {

        /* renamed from: a */
        public final List<Interceptor> f26318a;

        /* renamed from: b */
        public final List<Interceptor> f26319b;

        /* renamed from: c */
        public X509TrustManager f26320c;

        /* renamed from: d */
        public SSLSocketFactory f26321d;

        /* renamed from: e */
        public HostnameVerifier f26322e;

        /* renamed from: f */
        public boolean f26323f;

        /* renamed from: g */
        public boolean f26324g;

        /* renamed from: h */
        public Proxy f26325h;

        /* renamed from: i */
        public ProxySelector f26326i;

        /* renamed from: j */
        public C6017n1 f26327j;

        /* renamed from: k */
        public final PolicyExecutor f26328k;

        public b() {
            this.f26318a = new ArrayList();
            this.f26319b = new ArrayList();
            this.f26324g = true;
            this.f26328k = new PolicyExecutor();
        }

        @Override // com.huawei.hms.network.httpclient.internal.IHttpClientBuilder
        public b addInterceptor(Interceptor interceptor) {
            if (interceptor == null) {
                throw new IllegalArgumentException("interceptor == null");
            }
            this.f26318a.add(new C5939h1.c(interceptor));
            return this;
        }

        @Override // com.huawei.hms.network.httpclient.internal.IHttpClientBuilder
        public b addNetworkInterceptor(Interceptor interceptor) {
            if (interceptor == null) {
                throw new IllegalArgumentException("interceptor == null");
            }
            this.f26319b.add(new C5939h1.c(interceptor));
            return this;
        }

        @Override // com.huawei.hms.network.httpclient.internal.IHttpClientBuilder
        public HttpClient build() {
            return new C5844a1(this);
        }

        @Override // com.huawei.hms.network.httpclient.internal.IHttpClientBuilder
        public b cache(String str, long j10) {
            this.f26327j = new C6017n1(str, j10);
            return this;
        }

        @Override // com.huawei.hms.network.httpclient.internal.IHttpClientBuilder
        public b callTimeout(int i10) throws JSONException {
            this.f26328k.setValue("core_call_timeout", Integer.valueOf(i10));
            return this;
        }

        @Override // com.huawei.hms.network.httpclient.internal.IHttpClientBuilder
        public b connectTimeout(int i10) throws JSONException {
            this.f26328k.setValue("core_connect_timeout", Integer.valueOf(i10));
            return this;
        }

        @Override // com.huawei.hms.network.httpclient.internal.IHttpClientBuilder
        public b enableQuic(boolean z10) {
            this.f26323f = z10;
            return this;
        }

        @Override // com.huawei.hms.network.httpclient.internal.IHttpClientBuilder
        public b hostnameVerifier(HostnameVerifier hostnameVerifier) {
            CheckParamUtils.checkNotNull(hostnameVerifier, "hostnameVerifier == null");
            this.f26322e = hostnameVerifier;
            return this;
        }

        @Override // com.huawei.hms.network.httpclient.internal.IHttpClientBuilder
        public b options(String str) {
            if (str == null) {
                Logger.m32145w(C5844a1.f26299p, "RealHttpclient options == null");
                return this;
            }
            this.f26328k.setOptions(str);
            return this;
        }

        @Override // com.huawei.hms.network.httpclient.internal.IHttpClientBuilder
        public b pingInterval(int i10) throws JSONException {
            this.f26328k.setValue("core_ping_interval", Integer.valueOf(i10));
            return this;
        }

        @Override // com.huawei.hms.network.httpclient.internal.IHttpClientBuilder
        public b proxy(Proxy proxy) {
            this.f26325h = proxy;
            return this;
        }

        @Override // com.huawei.hms.network.httpclient.internal.IHttpClientBuilder
        public b proxySelector(ProxySelector proxySelector) {
            if (proxySelector == null) {
                Logger.m32145w(C5844a1.f26299p, "proxySelector == null");
                return this;
            }
            this.f26326i = proxySelector;
            return this;
        }

        @Override // com.huawei.hms.network.httpclient.internal.IHttpClientBuilder
        public b readTimeout(int i10) throws JSONException {
            this.f26328k.setValue("core_read_timeout", Integer.valueOf(i10));
            return this;
        }

        @Override // com.huawei.hms.network.httpclient.internal.IHttpClientBuilder
        public b retryTimeOnConnectionFailure(int i10) throws JSONException {
            this.f26328k.setValue("core_retry_time", Integer.valueOf(i10));
            return this;
        }

        @Override // com.huawei.hms.network.httpclient.internal.IHttpClientBuilder
        public b sslSocketFactory(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            CheckParamUtils.checkNotNull(sSLSocketFactory, "sslSocketFactory == null");
            CheckParamUtils.checkNotNull(x509TrustManager, "trustManager == null");
            this.f26321d = sSLSocketFactory;
            this.f26320c = x509TrustManager;
            return this;
        }

        @Override // com.huawei.hms.network.httpclient.internal.IHttpClientBuilder
        public b writeTimeout(int i10) throws JSONException {
            this.f26328k.setValue("core_write_timeout", Integer.valueOf(i10));
            return this;
        }

        public b(C5844a1 c5844a1) {
            ArrayList arrayList = new ArrayList();
            this.f26318a = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.f26319b = arrayList2;
            this.f26324g = true;
            PolicyExecutor policyExecutor = new PolicyExecutor();
            this.f26328k = policyExecutor;
            arrayList.addAll(c5844a1.f26303a);
            arrayList2.addAll(c5844a1.f26304b);
            this.f26320c = c5844a1.f26307e;
            this.f26321d = c5844a1.f26308f;
            this.f26322e = c5844a1.f26309g;
            this.f26323f = c5844a1.f26311i;
            this.f26327j = c5844a1.f26315m;
            this.f26324g = c5844a1.f26316n;
            this.f26325h = c5844a1.f26313k;
            this.f26326i = c5844a1.f26314l;
            policyExecutor.setOptions(c5844a1.f26317o.getProcessPolicyNetworkServiceParams());
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.a1$c */
    public static class c extends Callback {
        public c() {
        }

        @Override // com.huawei.hms.network.httpclient.Callback
        public void onFailure(Submit submit, Throwable th2) {
            Logger.m32145w(C5844a1.f26299p, "websocket request fail");
        }

        @Override // com.huawei.hms.network.httpclient.Callback
        public void onResponse(Submit submit, Response response) throws IOException {
            if (response == null || response.getCode() != 101) {
                Logger.m32145w(C5844a1.f26299p, "websocket response exception");
            } else {
                Logger.m32141i(C5844a1.f26299p, "websocket response ok");
            }
        }
    }

    public C5844a1(b bVar) throws JSONException {
        ArrayList arrayList = new ArrayList();
        this.f26303a = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.f26304b = arrayList2;
        this.f26316n = true;
        PolicyExecutor policyExecutor = bVar.f26328k;
        this.f26317o = policyExecutor;
        this.f26307e = bVar.f26320c;
        this.f26308f = bVar.f26321d;
        this.f26309g = bVar.f26322e;
        this.f26311i = bVar.f26323f;
        arrayList.addAll(bVar.f26318a);
        arrayList2.addAll(bVar.f26319b);
        if (this.f26310h == null) {
            this.f26310h = new C6096t2.b(policyExecutor.getBoolean("", "core_enable_plaintext_url_path"));
        }
        if (this.f26312j == null) {
            InterfaceC6031o2 interfaceC6031o2 = InterfaceC6031o2.DEFAULT;
            this.f26312j = interfaceC6031o2;
            interfaceC6031o2.setDnstime(policyExecutor.getInt("", "core_connect_timeout"));
        }
        if (this.f26311i) {
            if (C5927g2.getInstance().isSupportCronet()) {
                C5927g2.getInstance().loadQuicConf();
                C5927g2.getInstance().lazyInitHmsQuicLoader(false);
            } else {
                Logger.m32141i(f26299p, "system don't support cronet, so diable quic!!!");
                this.f26311i = false;
            }
        }
        this.f26313k = bVar.f26325h;
        this.f26314l = bVar.f26326i;
        this.f26315m = bVar.f26327j;
        this.f26316n = bVar.f26324g;
        if (this.f26307e == null || this.f26308f == null || this.f26309g == null) {
            m33756d();
        }
        this.f26305c = m33749b();
    }

    /* renamed from: a */
    private C5939h1.d m33743a(Request request, String str, String str2) throws JSONException {
        NetworkConfig networkConfig = new NetworkConfig(request.getOptions());
        Logger.m32143v(f26299p, "requestOptions: " + request.getOptions());
        Logger.m32143v(f26299p, "clientOptions: " + str);
        m33766a(networkConfig);
        Logger.m32143v(f26299p, "requestOptions: " + networkConfig.toString());
        networkConfig.appendOption(str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PolicyNetworkService.ProfileConstants.SCENE_TYPE, str2);
        } catch (JSONException unused) {
            Logger.m32145w(f26299p, "appendSceneType error " + str2);
        }
        networkConfig.appendOption(jSONObject.toString());
        Logger.m32143v(f26299p, "newRequestOptions: " + networkConfig.toString());
        return new C5939h1.d(request.newBuilder().options(networkConfig.toString()).build());
    }

    /* renamed from: b */
    private InterfaceC5886d1.a m33749b() {
        InterfaceC5886d1.a aVarM33753c = m33753c();
        return aVarM33753c == null ? new C5916f4(this) : aVarM33753c;
    }

    /* renamed from: c */
    private InterfaceC5886d1.a m33753c() {
        try {
            C6062q7.m35066E();
            Logger.m32143v(f26299p, "OkHttpClient create success");
            return new C5980k3(this);
        } catch (NoClassDefFoundError | NoSuchMethodError e10) {
            Logger.m32146w(f26299p, "is this type you want?", e10);
            return null;
        }
    }

    /* renamed from: e */
    private HostnameVerifier m33757e() {
        if (f26302s == null) {
            synchronized (HttpClient.class) {
                try {
                    if (f26302s == null) {
                        f26302s = new C10929a();
                    }
                } finally {
                }
            }
        }
        return f26302s;
    }

    /* renamed from: f */
    private void m33759f() {
        String str;
        String str2;
        try {
            try {
                if (f26301r == null) {
                    synchronized (HttpClient.class) {
                        try {
                            if (f26301r == null) {
                                f26301r = new SecureX509TrustManager(ContextHolder.getResourceContext());
                            }
                        } finally {
                        }
                    }
                }
                this.f26307e = f26301r;
                this.f26308f = C10618f.m65076c(ContextHolder.getResourceContext(), C10048b.m62471c());
            } catch (Throwable th2) {
                e = th2;
                HianalyticsHelper.getInstance().reportException(e, CrashHianalyticsData.EVENT_ID_CRASH);
                str = f26299p;
                str2 = "aegis has unexcept error";
                Logger.m32146w(str, str2, e);
            }
        } catch (IOException | IllegalAccessException | KeyManagementException | KeyStoreException | NoSuchAlgorithmException | CertificateException e10) {
            e = e10;
            str = f26299p;
            str2 = "catch exception when create sslSocketFactory";
            Logger.m32146w(str, str2, e);
        }
    }

    public static void reloadQuic() {
        Logger.m32141i(f26299p, "reloadQuic");
        C5927g2.getInstance().lazyInitHmsQuicLoader(true);
    }

    public boolean disableWeakNetworkRetry() {
        return this.f26317o.getBoolean("", "core_disable_weaknetwork_retry");
    }

    public C6017n1 getCache() {
        return this.f26315m;
    }

    public InterfaceC6031o2 getDns() {
        return this.f26312j;
    }

    public AbstractC6174z2.c getEventListenerFactory() {
        return this.f26310h;
    }

    public InterfaceC5886d1.a getFactory(Request request) {
        if (m33752b(request)) {
            if (this.f26306d != null) {
                return this.f26306d;
            }
            this.f26306d = m33744a();
            if (this.f26306d.isAvailable()) {
                return this.f26306d;
            }
        }
        return this.f26305c;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.f26309g;
    }

    public List<Interceptor> getInterceptors() {
        return Collections.unmodifiableList(this.f26303a);
    }

    public List<Interceptor> getNetworkInterceptors() {
        return Collections.unmodifiableList(this.f26304b);
    }

    public String getNi() {
        return this.f26317o.getValue("", PolicyNetworkService.ClientConstants.NI_NAME);
    }

    public PolicyExecutor getPolicyExecutor() {
        return this.f26317o;
    }

    public Proxy getProxy() {
        return this.f26313k;
    }

    public ProxySelector getProxySelector() {
        return this.f26314l;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.f26308f;
    }

    public X509TrustManager getTrustManager() {
        return this.f26307e;
    }

    public boolean isHttpClientEnableQuic() {
        return this.f26311i;
    }

    @Override // com.huawei.hms.network.httpclient.HttpClient
    public IHttpClientBuilder newBuilder() {
        return new b(this);
    }

    @Override // com.huawei.hms.network.httpclient.HttpClient
    public Request.Builder newRequest() {
        return new C5872c1.b();
    }

    @Override // com.huawei.hms.network.httpclient.HttpClient, com.huawei.hms.network.httpclient.Submit.Factory
    public Submit<ResponseBody> newSubmit(Request request) {
        CheckParamUtils.checkNotNull(request, "request == null");
        C5888d3 c5888d3 = new C5888d3(request.getUrl());
        String strM33745a = m33745a(c5888d3.getHost());
        return new C5939h1.h(new C6120v0(this, m33743a(request, this.f26317o.getRequestPramas(false, request, strM33745a, c5888d3.getHost()), strM33745a), null));
    }

    @Override // com.huawei.hms.network.httpclient.HttpClient
    public WebSocket newWebSocket(Request request, WebSocketListener webSocketListener) throws JSONException {
        C5888d3 c5888d3 = new C5888d3(request.getUrl());
        String strM33745a = m33745a(c5888d3.getHost());
        C5939h1.d dVarM33743a = m33743a(request, this.f26317o.getRequestPramas(true, request, strM33745a, c5888d3.getHost()), strM33745a);
        C5968j4 c5968j4 = new C5968j4(dVarM33743a, new C5939h1.j(webSocketListener));
        m33747a(dVarM33743a, new C5939h1.i(c5968j4));
        return c5968j4;
    }

    /* renamed from: a */
    private synchronized C5979k2 m33744a() {
        return new C5979k2(new C6173z1(ContextHolder.getResourceContext()), this.f26317o);
    }

    /* renamed from: b */
    private Submit<ResponseBody> m33750b(C5939h1.d dVar, WebSocket webSocket) {
        return new C5939h1.h(new C6120v0(this, dVar, webSocket));
    }

    /* renamed from: d */
    private void m33756d() {
        if (this.f26307e == null || this.f26308f == null) {
            m33759f();
        }
        if (this.f26309g == null) {
            this.f26309g = m33757e();
        }
    }

    /* renamed from: a */
    private String m33745a(String str) {
        String value = this.f26317o.getValue(str, PolicyNetworkService.ProfileConstants.SCENE_TYPE);
        return (!TextUtils.equals(value, PolicyNetworkService.ProfileConstants.RESTFUL) && TextUtils.equals(value, PolicyNetworkService.ProfileConstants.FILE_MANAGER)) ? PolicyNetworkService.ProfileConstants.FILE_MANAGER : PolicyNetworkService.ProfileConstants.RESTFUL;
    }

    /* renamed from: b */
    private boolean m33752b(Request request) {
        String str;
        if (!isHttpClientEnableQuic()) {
            str = "httpclient not enable quic, not use quic";
        } else if (!C5927g2.getInstance().isAvailable()) {
            str = "load quic apk fail, not use quic";
        } else if (this.f26306d != null && !this.f26306d.isAvailable()) {
            str = "create cronet engine fail, not use quic";
        } else {
            if (m33748a(request)) {
                return true;
            }
            str = "domain not enable quic, not use quic";
        }
        Logger.m32143v(f26299p, str);
        return false;
    }

    /* renamed from: a */
    private void m33747a(C5939h1.d dVar, WebSocket webSocket) {
        m33750b(dVar, webSocket).enqueue(new c());
    }

    /* renamed from: a */
    public void m33766a(NetworkConfig networkConfig) throws JSONException {
        String str = networkConfig.get("core_connect_timeout");
        String str2 = networkConfig.get("core_concurrent_connect_delay");
        String userConfigValue = this.f26317o.getUserConfigValue("core_connect_timeout");
        String userConfigValue2 = this.f26317o.getUserConfigValue("core_concurrent_connect_delay");
        Logger.m32143v(f26299p, "request: ConnectTimeout:" + str + ", ConcurrentConnectDelay:" + str2 + "httpclient: ConnectTimeout:" + userConfigValue + ", ConcurrentConnectDelay:" + userConfigValue2);
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(userConfigValue) && TextUtils.isEmpty(userConfigValue2)) {
            return;
        }
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(userConfigValue)) || (TextUtils.isEmpty(str2) && TextUtils.isEmpty(userConfigValue2))) {
            if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(userConfigValue)) {
                networkConfig.setValue("core_concurrent_connect_delay", C5976k.m34556b().m34558a("core_concurrent_connect_delay"));
                return;
            } else {
                if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(userConfigValue2)) {
                    return;
                }
                networkConfig.setValue("core_connect_timeout", C5976k.m34556b().m34558a("core_connect_timeout"));
                return;
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = userConfigValue;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = userConfigValue2;
        }
        if (StringUtils.stringToInteger(str2, -1) >= StringUtils.stringToInteger(str, -1)) {
            Logger.m32145w(f26299p, "Concurrent Connect Delay " + str2 + " ms is bigger than Connect Timeout " + str + " ms, please check. This request will use the default value.");
            networkConfig.setValue("core_connect_timeout", C5976k.m34556b().m34558a("core_connect_timeout"));
            networkConfig.setValue("core_concurrent_connect_delay", C5976k.m34556b().m34558a("core_concurrent_connect_delay"));
        }
    }

    /* renamed from: a */
    private boolean m33748a(Request request) {
        C5888d3 c5888d3 = new C5888d3(request.getUrl());
        return C5927g2.getInstance().isEnableQuic(c5888d3.getHost(), c5888d3.getPort()).booleanValue();
    }
}
