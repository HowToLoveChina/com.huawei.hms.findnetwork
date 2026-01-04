package com.huawei.hicloud.request.cbs.bean;

/* loaded from: classes6.dex */
public class CBSDeviceRecordsReq extends CBSBaseReq {
    private String version;

    public CBSDeviceRecordsReq(String str) {
        this.cmd = 51;
        this.info = "QueryDeviceOperationsReq";
        this.version = str;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
