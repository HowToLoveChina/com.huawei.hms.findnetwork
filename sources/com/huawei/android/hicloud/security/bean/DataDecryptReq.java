package com.huawei.android.hicloud.security.bean;

/* loaded from: classes3.dex */
public class DataDecryptReq {
    private String destData;
    private String destExtensionData;
    private String edek;
    private String srcData;
    private String srcExtensionData;
    private String traceID;
    private int type;

    public String getDestData() {
        return this.destData;
    }

    public String getDestExtensionData() {
        return this.destExtensionData;
    }

    public String getEdek() {
        return this.edek;
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

    public void setDestData(String str) {
        this.destData = str;
    }

    public void setDestExtensionData(String str) {
        this.destExtensionData = str;
    }

    public void setEdek(String str) {
        this.edek = str;
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
