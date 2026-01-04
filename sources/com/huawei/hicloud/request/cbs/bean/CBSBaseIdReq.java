package com.huawei.hicloud.request.cbs.bean;

/* loaded from: classes6.dex */
public class CBSBaseIdReq extends CBSBaseReq {
    private String deviceId;
    private int deviceType;

    public CBSBaseIdReq(int i10, String str) {
        this.cmd = i10;
        this.info = str;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setDeviceType(int i10) {
        this.deviceType = i10;
    }
}
