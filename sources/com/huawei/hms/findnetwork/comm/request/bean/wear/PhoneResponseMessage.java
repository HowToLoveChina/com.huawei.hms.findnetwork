package com.huawei.hms.findnetwork.comm.request.bean.wear;

/* loaded from: classes8.dex */
public class PhoneResponseMessage implements WearResponse {
    private String fid;
    private String message;
    private String phonePubKey;

    public String getFid() {
        return this.fid;
    }

    public String getMessage() {
        return this.message;
    }

    public String getPhonePubKey() {
        return this.phonePubKey;
    }

    public void setFid(String str) {
        this.fid = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setPhonePubKey(String str) {
        this.phonePubKey = str;
    }
}
