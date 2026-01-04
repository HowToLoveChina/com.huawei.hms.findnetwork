package com.huawei.android.hicloud.drive.clouddisk.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes3.dex */
public class ObjectStorageAddress extends C11707b {

    @InterfaceC4648p
    private Map<String, String> headers;

    @InterfaceC4648p
    private String method;

    @InterfaceC4648p
    private String objectBucketId;

    @InterfaceC4648p
    private String recordCursor;

    @InterfaceC4648p
    private Integer state;

    @InterfaceC4648p
    private String url;

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public String getMethod() {
        return this.method;
    }

    public String getObjectBucketId() {
        return this.objectBucketId;
    }

    public String getRecordCursor() {
        return this.recordCursor;
    }

    public Integer getState() {
        return this.state;
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

    public void setObjectBucketId(String str) {
        this.objectBucketId = str;
    }

    public void setRecordCursor(String str) {
        this.recordCursor = str;
    }

    public void setState(Integer num) {
        this.state = num;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
