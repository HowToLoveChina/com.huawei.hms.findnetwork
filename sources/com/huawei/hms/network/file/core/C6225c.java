package com.huawei.hms.network.file.core;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.network.NetworkKit;
import com.huawei.hms.network.embedded.C5976k;
import com.huawei.hms.network.embedded.C6018n2;
import com.huawei.hms.network.file.api.GlobalRequestConfig;
import com.huawei.hms.network.file.api.RequestManager;
import com.huawei.hms.network.file.core.util.FLogger;
import com.huawei.hms.network.file.core.util.Utils;
import com.huawei.hms.network.file.p130a.C6192h;
import com.huawei.hms.network.httpclient.HttpClient;
import com.huawei.hms.network.inner.api.PolicyNetworkService;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.network.file.core.c */
/* loaded from: classes8.dex */
public class C6225c {

    /* renamed from: a */
    private String f29383a;

    /* renamed from: b */
    boolean f29384b;

    /* renamed from: c */
    private volatile HttpClient f29385c;

    /* renamed from: d */
    HttpClient f29386d;

    /* renamed from: e */
    HttpClient f29387e;

    /* renamed from: f */
    HttpClient f29388f;

    /* renamed from: g */
    HttpClient f29389g;

    /* renamed from: h */
    private volatile GlobalRequestConfig f29390h;

    /* renamed from: i */
    private final Object f29391i = new Object();

    public C6225c(Context context, GlobalRequestConfig globalRequestConfig, String str) {
        this.f29384b = false;
        this.f29390h = globalRequestConfig;
        this.f29383a = str;
        this.f29384b = m36190c(globalRequestConfig);
        RequestManager.init(context);
    }

    /* renamed from: g */
    private String m36191g() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(C6018n2.CONGESTION_CONTROL_TYPE, C5976k.a.f27162b);
            jSONObject.put("enable_multipath", true);
        } catch (JSONException unused) {
            FLogger.m36355w("HttpClientManager", "create option fail", new Object[0]);
        }
        return jSONObject.toString();
    }

    /* renamed from: h */
    public static HttpClient m36192h() {
        return new HttpClient.Builder().build();
    }

    /* renamed from: i */
    private boolean m36193i() {
        String valueFromOptions = this.f29390h != null ? Utils.getValueFromOptions("scene", this.f29390h.getOptions()) : "";
        FLogger.m36354v("HttpClientManager", "global request config scene is " + valueFromOptions);
        FLogger.m36354v("HttpClientManager", "download manager tag is " + this.f29383a);
        if (TextUtils.isEmpty(valueFromOptions) && TextUtils.isEmpty(this.f29383a)) {
            return false;
        }
        String strM36178a = C6224b.m36178a("file_manager|filemanager_pcc_switch");
        FLogger.m36354v("HttpClientManager", "PCC remote tag is " + strM36178a);
        if (TextUtils.isEmpty(strM36178a)) {
            FLogger.m36353i("HttpClientManager", "PCC remote config is empty", new Object[0]);
            return false;
        }
        String[] strArrSplit = strM36178a.split(",");
        if (strArrSplit == null) {
            return false;
        }
        for (String str : strArrSplit) {
            if (valueFromOptions.equals(str) || this.f29383a.equals(str)) {
                FLogger.m36353i("HttpClientManager", "enable pcc, tag is " + this.f29383a, new Object[0]);
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public HttpClient m36194a() {
        return this.f29385c;
    }

    /* renamed from: b */
    public HttpClient m36195b() {
        return this.f29386d;
    }

    /* renamed from: c */
    public HttpClient m36196c() {
        return this.f29387e;
    }

    /* renamed from: d */
    public HttpClient m36197d() {
        return this.f29388f;
    }

    /* renamed from: e */
    public HttpClient m36198e() {
        return this.f29389g;
    }

    /* renamed from: f */
    public void m36199f() {
        if (this.f29385c != null) {
            return;
        }
        synchronized (this.f29391i) {
            try {
                this.f29385c = m36189b(this.f29390h);
                if (C6192h.m36048f().m36051a()) {
                    FLogger.m36354v("HttpClientManager", "hasH1Policy, create h1HttpClient");
                    this.f29386d = this.f29385c.newBuilder().enableQuic(false).options(m36188a(PolicyNetworkService.ClientConstants.SUPPORT_PROTOCOLS, "http/1.1")).build();
                }
                if (C6192h.m36048f().m36053b()) {
                    FLogger.m36354v("HttpClientManager", "hasH2Policy, create h2HttpClient");
                    this.f29387e = this.f29385c.newBuilder().enableQuic(false).build();
                }
                if (this.f29384b && C6192h.m36048f().m36055d() && m36193i()) {
                    FLogger.m36354v("HttpClientManager", "hasH3PCCPolicy, create h3PCCHttpClient");
                    this.f29388f = this.f29385c.newBuilder().options(m36188a(C6018n2.CONGESTION_CONTROL_TYPE, C5976k.a.f27162b)).build();
                }
                if (this.f29384b && C6192h.m36048f().m36054c() && m36193i()) {
                    FLogger.m36354v("HttpClientManager", "hasH3PCCMultipathPolicy, create h3PCCMultipathHttpClient");
                    this.f29389g = this.f29385c.newBuilder().options(m36191g()).build();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    private HttpClient m36187a(GlobalRequestConfig globalRequestConfig) {
        HttpClient httpClient = globalRequestConfig.getHttpClient();
        if (httpClient != null) {
            return httpClient;
        }
        HttpClient.Builder builder = new HttpClient.Builder();
        builder.options(m36188a(PolicyNetworkService.ProfileConstants.SCENE_TYPE_OPTION_KEY, PolicyNetworkService.ProfileConstants.FILE_MANAGER));
        if (globalRequestConfig.getHostnameVerifier() != null) {
            builder.hostnameVerifier(globalRequestConfig.getHostnameVerifier());
        }
        if (globalRequestConfig.getSslSocketFactory() != null && globalRequestConfig.getTrustManager() != null) {
            builder.sslSocketFactory(globalRequestConfig.getSslSocketFactory(), globalRequestConfig.getTrustManager());
        }
        if (this.f29384b) {
            builder.enableQuic(true);
        }
        if (!Utils.isBlank(globalRequestConfig.getOptions())) {
            builder.options(globalRequestConfig.getOptions());
        }
        return builder.build();
    }

    /* renamed from: b */
    private HttpClient m36189b(GlobalRequestConfig globalRequestConfig) {
        FLogger.m36353i("HttpClientManager", "init initDefaultHttpclient", new Object[0]);
        if (this.f29384b) {
            FLogger.m36354v("HttpClientManager", "enable quic");
            NetworkKit.getInstance().addQuicHint(true, (String[]) globalRequestConfig.getQuicHints().toArray(new String[globalRequestConfig.getQuicHints().size()]));
        }
        return globalRequestConfig == null ? m36192h() : m36187a(globalRequestConfig);
    }

    /* renamed from: c */
    private boolean m36190c(GlobalRequestConfig globalRequestConfig) {
        return (globalRequestConfig == null || Utils.isEmpty(globalRequestConfig.getQuicHints())) ? false : true;
    }

    /* renamed from: a */
    private String m36188a(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str, str2);
        } catch (JSONException unused) {
            FLogger.m36355w("HttpClientManager", "create option fail, key is " + str, new Object[0]);
        }
        return jSONObject.toString();
    }
}
