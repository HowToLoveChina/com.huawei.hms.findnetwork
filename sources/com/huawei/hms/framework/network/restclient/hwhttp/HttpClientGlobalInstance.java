package com.huawei.hms.framework.network.restclient.hwhttp;

import android.content.Context;
import com.huawei.hms.framework.common.ExtLogger;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.restclient.config.DefaultNetworkConfig;
import com.huawei.hms.framework.network.restclient.hwhttp.HttpClient;
import com.huawei.hms.framework.network.restclient.hwhttp.Request;
import com.huawei.hms.network.NetworkKit;
import com.huawei.hms.network.api.advance.AdvanceNetworkKit;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
/* loaded from: classes8.dex */
public class HttpClientGlobalInstance {
    private static final String TAG = "HttpClientGlobalInstance";
    private static HttpClientGlobalInstance instance = new HttpClientGlobalInstance();
    private HttpClient httpClient;
    private boolean isInit = false;
    private String netSdkType;

    private HttpClientGlobalInstance() {
    }

    public static HttpClientGlobalInstance getInstance() {
        return instance;
    }

    public void addQuicHint(String str) {
        NetworkKit.getInstance().addQuicHint(false, str);
    }

    public boolean checkConnectivity(String str) {
        return AdvanceNetworkKit.getInstance().checkConnectivity();
    }

    public void connect(String str, int i10, Callback callback) {
        connect(getHttpClient(), str, i10, callback);
    }

    public void enableDetect(boolean z10) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DefaultNetworkConfig.ENABLE_DETECT_WITH_HTTP, z10);
            NetworkKit.getInstance().setOptions(jSONObject.toString());
        } catch (JSONException unused) {
            Logger.m32145w(TAG, "HttpClientGlobalInstance detectEnable catch a JSONException");
        }
    }

    @Deprecated
    public HttpClientGlobalInstance enableHAFullReport() {
        Logger.m32145w(TAG, "This deprecated method setting is invalid.");
        return this;
    }

    @Deprecated
    public void enableNetDiag(boolean z10) {
        Logger.m32145w(TAG, "This deprecated method setting is invalid.");
    }

    public void enablePrivacyPolicy(boolean z10) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("core_enable_privacy_policy", z10);
            NetworkKit.getInstance().setOptions(jSONObject.toString());
        } catch (JSONException unused) {
            Logger.m32145w(TAG, "HttpClientGlobalInstance enablePrivacyPolicy catch a JSONException");
        }
    }

    public void evictAll() {
        NetworkKit.getInstance().evictAllConnections();
    }

    public synchronized HttpClient getHttpClient() {
        try {
            if (!this.isInit) {
                return null;
            }
            if (this.httpClient == null) {
                this.httpClient = new HttpClient.Builder().isReportable(true).enableQuic(false).build();
            }
            return this.httpClient;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Deprecated
    public String getNetSdkType() {
        return this.netSdkType;
    }

    public HttpClientGlobalInstance init(Context context) {
        if (!this.isInit) {
            synchronized (this) {
                Logger.m32145w(TAG, "com.huawei.hms:network-restclient and com.huawei.hms:network-restclient-anno will not receive new requirements in the future. The maintenance deadline is December 31, 2021. You are advised to switch services You are advised to switch services to com.huawei.hms:network-embedded before this time point");
                NetworkKit.init(context, null);
                this.isInit = true;
            }
        }
        return this;
    }

    public HttpClientGlobalInstance initConnectionPool(int i10, long j10, TimeUnit timeUnit) {
        if (i10 > 0 && j10 > 0) {
            NetworkKit.getInstance().initConnectionPool(i10, j10, timeUnit);
        }
        return this;
    }

    public void setExtLogger(ExtLogger extLogger, boolean z10) {
        AdvanceNetworkKit.getInstance().setWrapperLogger(new WrapExtLogger(extLogger), z10);
    }

    public HttpClientGlobalInstance setHaTag(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("core_ha_tag", str);
            NetworkKit.getInstance().setOptions(jSONObject.toString());
        } catch (JSONException unused) {
            Logger.m32145w(TAG, "HttpClientGlobalInstance setHaTag catch a JSONException");
        }
        return this;
    }

    @Deprecated
    public void setNetSDKType(String str) {
        this.netSdkType = str;
    }

    public void addQuicHint(List<String> list) {
        if (list == null) {
            return;
        }
        NetworkKit.getInstance().addQuicHint(false, (String[]) list.toArray(new String[0]));
    }

    public void connect(HttpClient httpClient, String str, int i10, Callback callback) {
        if (callback == null) {
            Logger.m32145w(TAG, "callback is null connect no effect");
            return;
        }
        Request requestBuild = new Request.Builder().url(str).method("GET").onlyConnect(true).build();
        for (int i11 = 0; i11 < i10; i11++) {
            httpClient.newSubmit(requestBuild).enqueue(callback);
        }
    }

    public void addQuicHint(String str, boolean z10) {
        NetworkKit.getInstance().addQuicHint(z10, str);
    }

    public void addQuicHint(List<String> list, boolean z10) {
        if (list == null) {
            return;
        }
        NetworkKit.getInstance().addQuicHint(z10, (String[]) list.toArray(new String[0]));
    }
}
