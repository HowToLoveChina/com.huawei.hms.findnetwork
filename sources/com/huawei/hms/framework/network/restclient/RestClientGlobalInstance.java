package com.huawei.hms.framework.network.restclient;

import android.content.Context;
import com.huawei.hms.framework.common.ExtLogger;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.restclient.RestClient;
import com.huawei.hms.framework.network.restclient.hwhttp.Callback;
import com.huawei.hms.framework.network.restclient.hwhttp.HttpClientGlobalInstance;
import com.huawei.hms.framework.network.restclient.proxy.new2old.ProxyResponse;
import com.huawei.hms.network.NetworkKit;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
/* loaded from: classes8.dex */
public class RestClientGlobalInstance {
    private static final String TAG = "RestClientGlobalInstance";
    private static RestClientGlobalInstance instance = new RestClientGlobalInstance();
    private RestClient restClient;

    private RestClientGlobalInstance() {
    }

    public static RestClientGlobalInstance getInstance() {
        return instance;
    }

    public void addQuicHint(String str) {
        NetworkKit.getInstance().addQuicHint(false, str);
    }

    public boolean checkConnectivity(String str) {
        return HttpClientGlobalInstance.getInstance().checkConnectivity(str);
    }

    public void connect(String str, int i10, ResultCallback<Void> resultCallback) {
        connect(getRestClient(), str, i10, resultCallback);
    }

    @Deprecated
    public RestClientGlobalInstance enableHAFullReport() {
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

    public synchronized RestClient getRestClient() {
        try {
            if (this.restClient == null) {
                this.restClient = new RestClient.Builder().httpClient(HttpClientGlobalInstance.getInstance().getHttpClient()).addConverterFactory(new ToStringConverterFactory()).build();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.restClient;
    }

    public RestClientGlobalInstance init(Context context) {
        HttpClientGlobalInstance.getInstance().init(context);
        return this;
    }

    public RestClientGlobalInstance initConnectionPool(int i10, long j10, TimeUnit timeUnit) {
        if (i10 > 0 && j10 > 0) {
            NetworkKit.getInstance().initConnectionPool(i10, j10, timeUnit);
        }
        return this;
    }

    public void setExtLogger(ExtLogger extLogger, boolean z10) {
        HttpClientGlobalInstance.getInstance().setExtLogger(extLogger, z10);
    }

    public RestClientGlobalInstance setHaTag(String str) throws JSONException {
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
    public RestClientGlobalInstance setNetSDKType(String str) {
        HttpClientGlobalInstance.getInstance().setNetSDKType(str);
        return this;
    }

    public void addQuicHint(List<String> list) {
        if (list == null) {
            return;
        }
        NetworkKit.getInstance().addQuicHint(false, (String[]) list.toArray(new String[0]));
    }

    public void connect(RestClient restClient, String str, int i10, final ResultCallback<Void> resultCallback) {
        if (resultCallback == null) {
            Logger.m32145w(TAG, "callback is null");
        }
        if (restClient == null || restClient.getHttpClient() == null) {
            Logger.m32145w(TAG, "restClient is null or restClient.getHttpClient() is null");
        } else {
            HttpClientGlobalInstance.getInstance().connect(restClient.getHttpClient(), str, i10, new Callback() { // from class: com.huawei.hms.framework.network.restclient.RestClientGlobalInstance.1
                @Override // com.huawei.hms.framework.network.restclient.hwhttp.Callback
                public void onFailure(com.huawei.hms.framework.network.restclient.hwhttp.Submit submit, Throwable th2) {
                    ResultCallback resultCallback2 = resultCallback;
                    if (resultCallback2 == null) {
                        return;
                    }
                    resultCallback2.onFailure(th2);
                }

                @Override // com.huawei.hms.framework.network.restclient.hwhttp.Callback
                public void onResponse(com.huawei.hms.framework.network.restclient.hwhttp.Submit submit, com.huawei.hms.framework.network.restclient.hwhttp.Response response) throws IOException {
                    try {
                        if (resultCallback == null) {
                            return;
                        }
                        resultCallback.onResponse(new Response(ProxyResponse.response2New(response)));
                    } finally {
                        response.close();
                    }
                }
            });
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
