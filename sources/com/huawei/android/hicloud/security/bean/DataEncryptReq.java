package com.huawei.android.hicloud.security.bean;

/* loaded from: classes3.dex */
public class DataEncryptReq {
    private String dek;
    private String srcData;
    private String srcExtensionData;
    private String traceID;
    private int type;

    public String getDek() {
        return this.dek;
    }

    public String getSrcData() {
        return this.srcData;
    }

    public String getSrcExtensionData() {
        return this.srcExtensionData;
    }

    public String getTraceID() {
        return this.traceID;
    }

    public int getType() {
        return this.type;
    }

    public void setDek(String str) {
        this.dek = str;
    }

    public void setSrcData(String str) {
        this.srcData = str;
    }

    public void setSrcExtensionData(String str) {
        this.srcExtensionData = str;
    }

    public void setTraceID(String str) {
        this.traceID = str;
    }

    public void setType(int i10) {
        this.type = i10;
    }
}
