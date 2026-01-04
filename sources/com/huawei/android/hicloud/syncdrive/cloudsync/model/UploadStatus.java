package com.huawei.android.hicloud.syncdrive.cloudsync.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes3.dex */
public class UploadStatus extends C11707b {
    private String body;

    @InterfaceC4648p
    private Map<String, String> headers;
    private Integer status;

    public String getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatus() {
        return this.status;
    }

    public UploadStatus setBody(String str) {
        this.body = str;
        return this;
    }

    public UploadStatus setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public UploadStatus setStatus(Integer num) {
        this.status = num;
        return this;
    }
}
