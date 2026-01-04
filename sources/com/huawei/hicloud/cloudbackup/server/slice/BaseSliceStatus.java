package com.huawei.hicloud.cloudbackup.server.slice;

import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class BaseSliceStatus {
    private String body;
    private Map<String, List<String>> headers;
    private int status;

    public String getBody() {
        return this.body;
    }

    public Map<String, List<String>> getHeaders() {
        return this.headers;
    }

    public int getStatus() {
        return this.status;
    }

    public BaseSliceStatus setBody(String str) {
        this.body = str;
        return this;
    }

    public BaseSliceStatus setHeaders(Map<String, List<String>> map) {
        this.headers = map;
        return this;
    }

    public BaseSliceStatus setStatus(int i10) {
        this.status = i10;
        return this;
    }
}
