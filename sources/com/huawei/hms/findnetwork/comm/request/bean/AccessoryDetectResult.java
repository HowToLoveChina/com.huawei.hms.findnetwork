package com.huawei.hms.findnetwork.comm.request.bean;

/* loaded from: classes8.dex */
public class AccessoryDetectResult {
    private int mBroadcastType;
    private String mFid;
    private boolean mIsOwner;
    private String mMac;
    private int mPij;
    private String mProductId;
    private String mPublicKey;
    private int mRssi;

    public AccessoryDetectResult() {
    }

    public AccessoryDetectResult(String str, String str2, int i10, String str3, int i11, int i12, boolean z10) {
        this.mFid = str;
        this.mMac = str2;
        this.mBroadcastType = i10;
        this.mPublicKey = str3;
        this.mPij = i11;
        this.mRssi = i12;
        this.mIsOwner = z10;
    }

    public int getBroadcastType() {
        return this.mBroadcastType;
    }

    public String getFid() {
        return this.mFid;
    }

    public String getMac() {
        return this.mMac;
    }

    public int getPij() {
        return this.mPij;
    }

    public String getProductId() {
        return this.mProductId;
    }

    public String getPublicKey() {
        return this.mPublicKey;
    }

    public int getRssi() {
        return this.mRssi;
    }

    public boolean isOwner() {
        return this.mIsOwner;
    }

    public void setBroadcastType(int i10) {
        this.mBroadcastType = i10;
    }

    public void setFid(String str) {
        this.mFid = str;
    }

    public void setMac(String str) {
        this.mMac = str;
    }

    public void setOwner(boolean z10) {
        this.mIsOwner = z10;
    }

    public void setPij(int i10) {
        this.mPij = i10;
    }

    public void setProductId(String str) {
        this.mProductId = str;
    }

    public void setPublicKey(String str) {
        this.mPublicKey = str;
    }

    public void setRssi(int i10) {
        this.mRssi = i10;
    }
}
