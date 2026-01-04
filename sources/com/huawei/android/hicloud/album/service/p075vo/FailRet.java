package com.huawei.android.hicloud.album.service.p075vo;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class FailRet implements Parcelable {
    public static final Parcelable.Creator<FailRet> CREATOR = new Parcelable.Creator<FailRet>() { // from class: com.huawei.android.hicloud.album.service.vo.FailRet.1
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
    private int errCode;
    private String errMsg;
    private String uniqueId;

    public FailRet() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public String getUniqueId() {
        return this.uniqueId;
    }

    public void setErrCode(int i10) {
        this.errCode = i10;
    }

    public void setErrMsg(String str) {
        this.errMsg = str;
    }

    public void setUniqueId(String str) {
        this.uniqueId = str;
    }

    public String toString() {
        return "FailRet{errCode=" + this.errCode + ", errMsg='" + this.errMsg + "', uniqueId='" + this.uniqueId + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.errCode);
        parcel.writeString(this.errMsg);
        parcel.writeString(this.uniqueId);
    }

    public FailRet(Parcel parcel) {
        this.errCode = parcel.readInt();
        this.errMsg = parcel.readString();
        this.uniqueId = parcel.readString();
    }
}
