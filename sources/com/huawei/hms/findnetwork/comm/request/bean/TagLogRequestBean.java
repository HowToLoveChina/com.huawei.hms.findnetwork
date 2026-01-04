package com.huawei.hms.findnetwork.comm.request.bean;

/* loaded from: classes8.dex */
public class TagLogRequestBean extends BaseRequestBean {
    private byte[] ciphertext;
    private String mDescription;
    private int mRespCode;

    public byte[] getCiphertext() {
        byte[] bArr = this.ciphertext;
        return bArr == null ? new byte[0] : (byte[]) bArr.clone();
    }

    public String getDescription() {
        return this.mDescription;
    }

    public int getRespCode() {
        return this.mRespCode;
    }

    public void setCiphertext(byte[] bArr) {
        this.ciphertext = (byte[]) bArr.clone();
    }

    public void setDescription(String str) {
        this.mDescription = str;
    }

    public void setRespCode(int i10) {
        this.mRespCode = i10;
    }
}
