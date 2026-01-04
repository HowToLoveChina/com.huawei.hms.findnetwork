package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class H5WMPayUrlAttr {
    private String activityCode;
    private String inviteCode;
    private String salChannel;
    private String srcChannel;
    private String tranUrlFail;
    private String tranUrlSuccess;

    public H5WMPayUrlAttr(String str, String str2, String str3, String str4, String str5, String str6) {
        this.srcChannel = str;
        this.salChannel = str2;
        this.activityCode = str3;
        this.tranUrlSuccess = str4;
        this.tranUrlFail = str5;
        this.inviteCode = str6;
    }

    public String getActivityCode() {
        return this.activityCode;
    }

    public String getInviteCode() {
        return this.inviteCode;
    }

    public String getSalChannel() {
        return this.salChannel;
    }

    public String getSrcChannel() {
        return this.srcChannel;
    }

    public String getTranUrlFail() {
        return this.tranUrlFail;
    }

    public String getTranUrlSuccess() {
        return this.tranUrlSuccess;
    }

    public void setActivityCode(String str) {
        this.activityCode = str;
    }

    public void setInviteCode(String str) {
        this.inviteCode = str;
    }

    public void setSalChannel(String str) {
        this.salChannel = str;
    }

    public void setSrcChannel(String str) {
        this.srcChannel = str;
    }

    public void setTranUrlFail(String str) {
        this.tranUrlFail = str;
    }

    public void setTranUrlSuccess(String str) {
        this.tranUrlSuccess = str;
    }
}
