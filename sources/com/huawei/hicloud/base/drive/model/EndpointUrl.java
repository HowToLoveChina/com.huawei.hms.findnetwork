package com.huawei.hicloud.base.drive.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes6.dex */
public class EndpointUrl extends C11707b {

    @InterfaceC4648p
    private Map<String, String> headers;

    @InterfaceC4648p
    private String method;

    @InterfaceC4648p
    private String url;

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public String getMethod() {
        return this.method;
    }

    public String getUrl() {
        return this.url;
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
