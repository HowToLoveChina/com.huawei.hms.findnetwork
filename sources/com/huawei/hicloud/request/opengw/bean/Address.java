package com.huawei.hicloud.request.opengw.bean;

import java.util.Map;

/* loaded from: classes6.dex */
public class Address {
    private String bucket;
    private Map<String, String> headers;
    private String method;
    private String state;
    private String url;

    public String getBucket() {
        return this.bucket;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public String getMethod() {
        return this.method;
    }

    public String getState() {
        return this.state;
    }

    public String getUrl() {
        return this.url;
    }

    public void setBucket(String str) {
        this.bucket = str;
    }

    public void setHeaders(Map<String, String> map) {
        this.headers = map;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
