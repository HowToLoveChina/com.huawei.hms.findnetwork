package com.huawei.hicloud.request.cbs.bean;

import java.util.Map;

/* loaded from: classes6.dex */
public class CBSAppResp extends CBSBaseResp {
    private String bucketId;
    private Map<String, String> headers;
    private String method;
    private String url;

    public String getAPPBucketId() {
        return this.bucketId;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public String getMethod() {
        return this.method;
    }

    public String getUrl() {
        return this.url;
    }

    public void setAPPBucketId(String str) {
        this.bucketId = str;
    }

    public void setHeaders(Map<String, String> map) {
        this.headers = map;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
