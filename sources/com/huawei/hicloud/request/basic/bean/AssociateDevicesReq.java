package com.huawei.hicloud.request.basic.bean;

/* loaded from: classes6.dex */
public class AssociateDevicesReq extends BasicBaseReq {
    private String version;

    public AssociateDevicesReq(String str) {
        super("GetLastOperationRecord");
        this.version = str;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
