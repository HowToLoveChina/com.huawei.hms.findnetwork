package com.huawei.hms.network.httpclient.util;

import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.NetworkKit;
import com.huawei.hms.network.httpclient.Callback;
import com.huawei.hms.network.httpclient.HttpClient;
import com.huawei.hms.network.httpclient.Response;
import com.huawei.hms.network.httpclient.Submit;
import com.huawei.hms.network.inner.DomainManager;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class PreConnectManager {
    public static final long CONNECT_INTERNAL = 10000;
    public static final long CONNECT_SUCCESS_INTERNAL = 180000;
    public static final String HTTPS_PRE = "https://";
    public static final String HTTP_METHOD_GET = "GET";
    public static final String TAG = "PreConnectManager";
    public volatile HttpClient httpClient;
    public Map<String, Long[]> preConnectInfos;

    public static class ConnectCallBack extends Callback {
        @Override // com.huawei.hms.network.httpclient.Callback
        public void onFailure(Submit submit, Throwable th2) {
            if (submit.getRequestFinishedInfo() == null) {
                Logger.m32145w(PreConnectManager.TAG, "RequestFinishedInfo is null");
                return;
            }
            PreConnectManager.getInstance().updatePreConInfo("https://" + submit.getRequestFinishedInfo().getHost(), -1L);
        }

        @Override // com.huawei.hms.network.httpclient.Callback
        public void onResponse(Submit submit, Response response) throws IOException {
            response.close();
            if (submit.getRequestFinishedInfo() == null) {
                Logger.m32145w(PreConnectManager.TAG, "RequestFinishedInfo is null");
                return;
            }
            PreConnectManager.getInstance().updatePreConInfo("https://" + submit.getRequestFinishedInfo().getHost(), 1L);
        }
    }

    public static class LazyHolder {
        public static final PreConnectManager INSTANCE = new PreConnectManager();
    }

    public PreConnectManager() {
        this.preConnectInfos = new ConcurrentHashMap();
    }

    public static PreConnectManager getInstance() {
        return LazyHolder.INSTANCE;
    }

    private boolean ifCanConnect(String str) {
        String str2;
        if (!this.preConnectInfos.containsKey(str)) {
            return true;
        }
        Long[] lArr = this.preConnectInfos.get(str);
        if (lArr[0].longValue() == 1 && System.currentTimeMillis() - lArr[1].longValue() <= CONNECT_SUCCESS_INTERNAL) {
            str2 = "this still a live connect, no need to new preconnect";
        } else {
            if (lArr[0].longValue() == 1 || System.currentTimeMillis() - lArr[1].longValue() > 10000) {
                return true;
            }
            str2 = "has preconnect within 10 seconds, try so frequently";
        }
        Logger.m32136d(TAG, str2);
        return false;
    }

    public void updatePreConInfo(String str, Long l10) {
        this.preConnectInfos.put(str, new Long[]{l10, Long.valueOf(System.currentTimeMillis())});
    }

    public void clearInfo() {
        this.preConnectInfos.clear();
    }

    public void connect(HttpClient httpClient, String str, Callback callback) throws JSONException {
        if (callback == null) {
            Logger.m32145w(TAG, "callback is null connect no effect");
            return;
        }
        if (!ifCanConnect(str)) {
            Logger.m32136d(TAG, "return without do connect action");
            return;
        }
        updatePreConInfo(str, 0L);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject = new JSONObject().put("inner_connect_empty_body", true);
        } catch (JSONException e10) {
            Logger.m32146w(TAG, "recordMap fail to put:", e10);
        }
        httpClient.newSubmit(httpClient.newRequest().url(str).method("GET").options(jSONObject.toString()).build()).enqueue(callback);
    }

    public HttpClient getHttpClient() {
        if (this.httpClient == null) {
            synchronized (PreConnectManager.class) {
                try {
                    if (this.httpClient == null) {
                        NetworkKit.init(ContextHolder.getAppContext(), null);
                        this.httpClient = new HttpClient.Builder().retryTimeOnConnectionFailure(0).build();
                    }
                } finally {
                }
            }
        }
        return this.httpClient;
    }

    public /* synthetic */ PreConnectManager(C62601 c62601) {
        this();
    }

    public void connect(String str, Callback callback) throws JSONException {
        if (DomainManager.getInstance().isExcludePrefetch(str)) {
            Logger.m32143v(TAG, "exclude prefetch");
            return;
        }
        connect(getHttpClient(), "https://" + str, callback);
    }
}
