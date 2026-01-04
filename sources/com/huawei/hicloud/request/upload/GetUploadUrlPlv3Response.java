package com.huawei.hicloud.request.upload;

import java.util.HashMap;

/* loaded from: classes6.dex */
public class GetUploadUrlPlv3Response {
    private int code;
    private HashMap<String, String> headers;
    private String info;
    private String method;
    private String url;

    public int getCode() {
        return this.code;
    }

    public HashMap<String, String> getHeaders() {
        HashMap<String, String> map = this.headers;
        return map == null ? new HashMap<>() : map;
    }

    public String getInfo() {
        return this.info;
    }

    public String getMethod() {
        return this.method;
    }

    public String getUrl() {
        return this.url;
    }

    public void setCode(int i10) {
        this.code = i10;
    }

    public void setHeaders(HashMap<String, String> map) {
        this.headers = map;
    }

    public void setInfo(String str) {
        this.info = str;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
