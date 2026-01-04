package com.huawei.android.hicloud.drive.cloudphoto.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes3.dex */
public class EndpointUrl extends C11707b {
    private String bucket;

    @InterfaceC4648p
    private Map<String, String> headers;
    private boolean isAccelerated = false;

    @InterfaceC4648p
    private String method;

    @InterfaceC4648p
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

    public String getUrl() {
        return this.url;
    }

    public boolean isAccelerated() {
        return this.isAccelerated;
    }

    public void setAccelerated(boolean z10) {
        this.isAccelerated = z10;
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

    public void setUrl(String str) {
        this.url = str;
    }
}
