package com.huawei.hicloud.request.cbs.bean;

/* loaded from: classes6.dex */
public class CBSRecoverSmsAndCallReq extends CBSBaseReq {
    private String devId;
    private int deviceType;
    private int maxNo;
    private int msgId;
    private Long time;
    private String type;

    public CBSRecoverSmsAndCallReq() {
    }

    public String getDevId() {
        return this.devId;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public int getMaxNo() {
        return this.maxNo;
    }

    public int getMsgId() {
        return this.msgId;
    }

    public Long getTime() {
        return this.time;
    }

    public String getType() {
        return this.type;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setDeviceType(int i10) {
        this.deviceType = i10;
    }

    public void setMaxNo(int i10) {
        this.maxNo = i10;
    }

    public void setMsgId(int i10) {
        this.msgId = i10;
    }

    public void setTime(Long l10) {
        this.time = l10;
    }

    public void setType(String str) {
        this.type = str;
    }

    public CBSRecoverSmsAndCallReq(String str, int i10, Long l10, String str2, int i11, int i12, int i13, String str3) {
        super(i13, str3);
        this.devId = str;
        this.deviceType = i10;
        this.time = l10;
        this.type = str2;
        this.msgId = i12;
        setMaxNo(i11);
    }
}
