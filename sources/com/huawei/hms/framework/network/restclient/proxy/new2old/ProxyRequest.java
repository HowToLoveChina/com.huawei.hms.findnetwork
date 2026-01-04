package com.huawei.hms.framework.network.restclient.proxy.new2old;

import com.huawei.hms.framework.common.CheckParamUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.restclient.Headers;
import com.huawei.hms.framework.network.restclient.config.NetworkConfig;
import com.huawei.hms.framework.network.restclient.hwhttp.Request;
import com.huawei.hms.framework.network.restclient.hwhttp.RequestBody;
import com.huawei.hms.network.httpclient.HttpClient;
import com.huawei.hms.network.httpclient.Request;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class ProxyRequest {
    private static final String TAG = "ProxyRequest";

    private static String parseRequestConfig(Request request) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            if (request.getRecordParamMap() != null) {
                jSONObject.put("core_metrics_data", new JSONObject(request.getRecordParamMap()));
            }
            jSONObject.put("core_call_timeout", request.getCallTimeout());
            jSONObject.put("core_connect_timeout", request.getConnectTimeout());
            jSONObject.put("core_concurrent_connect_delay", request.getConnectionAttemptDelay());
            jSONObject.put("core_ping_interval", request.getPingInterval());
            jSONObject.put("core_read_timeout", request.getReadTimeout());
            jSONObject.put("core_write_timeout", request.getWriteTimeout());
            jSONObject.put("core_retry_time", request.getRetryTimeOnConnectionFailure());
            jSONObject.put("core_enable_concurrent_connect", request.getConcurrentConnectEnabled());
            jSONObject.put("core_connect_empty_body", request.isOnlyConnect());
            return jSONObject.toString();
        } catch (JSONException unused) {
            Logger.m32145w(TAG, "JSONException error");
            return null;
        }
    }

    public static com.huawei.hms.network.httpclient.Request request2New(HttpClient httpClient, Request request) {
        CheckParamUtils.checkNotNull(request, "ProxyRequest request2New request = null");
        Request.Builder builderNewRequest = httpClient.newRequest();
        builderNewRequest.method(request.getMethod()).url(request.getUrl().getUrl());
        Headers headers = request.getHeaders();
        for (int i10 = 0; i10 < headers.size(); i10++) {
            builderNewRequest.addHeader(headers.name(i10), headers.value(i10));
        }
        RequestBody body = request.getBody();
        if (body != null) {
            builderNewRequest.requestBody(ProxyRequestBody.requestBody2New(body));
        }
        if (request.isClientConfigurationModified()) {
            builderNewRequest.options(parseRequestConfig(request));
        }
        return builderNewRequest.build();
    }

    public static com.huawei.hms.framework.network.restclient.hwhttp.Request request2Old(com.huawei.hms.network.httpclient.Request request) {
        CheckParamUtils.checkNotNull(request, "ProxyRequest request2Old request = null");
        Request.Builder builderMethod = new Request.Builder().url(request.getUrl()).method(request.getMethod());
        for (Map.Entry<String, List<String>> entry : request.getHeaders().entrySet()) {
            String key = entry.getKey();
            Iterator<String> it = entry.getValue().iterator();
            while (it.hasNext()) {
                builderMethod.addHeader(key, it.next());
            }
        }
        com.huawei.hms.network.httpclient.RequestBody body = request.getBody();
        if (body != null) {
            builderMethod.requestBody(ProxyRequestBody.requestBody2Old(body));
        }
        NetworkConfig networkConfig = new NetworkConfig(request.getOptions());
        builderMethod.writeTimeout(networkConfig.getWriteTimeout()).readTimeout(networkConfig.getReadTimeout()).connectTimeout(networkConfig.getConnectTimeout()).callTimeout(networkConfig.getCallTimeout()).pingInterval(networkConfig.getPingInterval()).retryTimeOnConnectionFailure(networkConfig.getRetryTimeOnConnectionFailure()).connectionAttemptDelay(networkConfig.getConnectionAttemptDelay()).onlyConnect(networkConfig.enableConnectEmptyBody()).concurrentConnectEnabled(Boolean.valueOf(networkConfig.enableConcurrentConnect())).recordParamMap(networkConfig.getMap("core_metrics_data"));
        return builderMethod.build();
    }
}
