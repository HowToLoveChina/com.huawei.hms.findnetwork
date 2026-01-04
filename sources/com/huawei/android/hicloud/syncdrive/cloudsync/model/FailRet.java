package com.huawei.android.hicloud.syncdrive.cloudsync.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class FailRet implements Parcelable {
    public static final Parcelable.Creator<FailRet> CREATOR = new Parcelable.Creator<FailRet>() { // from class: com.huawei.android.hicloud.syncdrive.cloudsync.model.FailRet.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FailRet createFromParcel(Parcel parcel) {
            return new FailRet(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FailRet[] newArray(int i10) {
            return new FailRet[i10];
        }
    };
    private String assetId;
    private int errCode;
    private String errMsg;
    private String luid;
    private String recordId;
    private String usage;

    public FailRet() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAssetId() {
        return this.assetId;
    }

    public int getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public String getLuid() {
        return this.luid;
    }

    public String getRecordId() {
        return this.recordId;
    }

    public String getUsage() {
        return this.usage;
    }

    public void setAssetId(String str) {
        this.assetId = str;
    }

    public void setErrCode(int i10) {
        this.errCode = i10;
    }

    public void setErrMsg(String str) {
        this.errMsg = str;
    }

    public void setLuid(String str) {
        this.luid = str;
    }

    public void setRecordId(String str) {
        this.recordId = str;
    }

    public void setUsage(String str) {
        this.usage = str;
    }

    public String toString() {
        return "FailRet{errCode=" + this.errCode + ", errMsg='" + this.errMsg + "', recordId='" + this.recordId + "', luid='" + this.luid + "', assetId='" + this.assetId + "', usage='" + this.usage + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.errCode);
        parcel.writeString(this.errMsg);
        parcel.writeString(this.recordId);
        parcel.writeString(this.luid);
        parcel.writeString(this.assetId);
        parcel.writeString(this.usage);
    }

    public FailRet(Parcel parcel) {
        this.errCode = parcel.readInt();
        this.errMsg = parcel.readString();
        this.recordId = parcel.readString();
        this.luid = parcel.readString();
        this.assetId = parcel.readString();
        this.usage = parcel.readString();
    }
}
