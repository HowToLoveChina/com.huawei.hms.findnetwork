package com.huawei.wisesecurity.ucs.credential.outer;

import java.util.Map;

/* loaded from: classes9.dex */
public class NetworkRequest {
    private String body;
    private Map<String, String> headers;
    private String url;

    public NetworkRequest(String str, Map<String, String> map) {
        this.url = str;
        this.headers = map;
    }

    public String getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public String getUrl() {
        return this.url;
    }

    public void setBody(String str) {
        this.body = str;
    }

    public void setHeaders(Map<String, String> map) {
        this.headers = map;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public NetworkRequest(String str, Map<String, String> map, String str2) {
        this.url = str;
        this.headers = map;
        this.body = str2;
    }
}
