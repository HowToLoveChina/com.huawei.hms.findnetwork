package com.huawei.hicloud.request.basic.bean;

/* loaded from: classes6.dex */
public class BasicDeviceRegisterReq extends BasicBaseReq {
    private String pushToken;
    private int signVersion;

    public BasicDeviceRegisterReq(String str) {
        super("UserDeviceRegisterReq");
        this.pushToken = str;
    }

    public String getPushToken() {
        return this.pushToken;
    }

    public int getSignVersion() {
        return this.signVersion;
    }

    public void setPushToken(String str) {
        this.pushToken = str;
    }

    public void setSignVersion(int i10) {
        this.signVersion = i10;
    }
}
