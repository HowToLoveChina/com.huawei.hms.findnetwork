package com.huawei.android.hicloud.album.service.p075vo;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class ShareFileUpdatedResult implements Parcelable {
    public static final Parcelable.Creator<ShareFileUpdatedResult> CREATOR = new Parcelable.Creator<ShareFileUpdatedResult>() { // from class: com.huawei.android.hicloud.album.service.vo.ShareFileUpdatedResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareFileUpdatedResult createFromParcel(Parcel parcel) {
            return new ShareFileUpdatedResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareFileUpdatedResult[] newArray(int i10) {
            return new ShareFileUpdatedResult[i10];
        }
    };
    private String albumId;
    private int code;
    private String errMsg;
    private String hash;
    private String ownerId;

    public ShareFileUpdatedResult(String str) {
        this.code = 0;
        this.hash = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAlbumId() {
        return this.albumId;
    }

    public int getCode() {
        return this.code;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public String getHash() {
        return this.hash;
    }

    public void setAlbumId(String str) {
        this.albumId = str;
    }

    public void setCode(int i10) {
        this.code = i10;
    }

    public void setErrMsg(String str) {
        this.errMsg = str;
    }

    public void setHash(String str) {
        this.hash = str;
    }

    public String toString() {
        return "ShareFileUpdatedResult{hash='" + this.hash + "', albumId='" + this.albumId + "', ownerId='" + this.ownerId + "', code=" + this.code + ", errMsg='" + this.errMsg + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.hash);
        parcel.writeString(this.albumId);
        parcel.writeString(this.ownerId);
        parcel.writeInt(this.code);
        parcel.writeString(this.errMsg);
    }

    public ShareFileUpdatedResult(String str, String str2, String str3) {
        this.code = 0;
        this.hash = str;
        this.albumId = str2;
        this.ownerId = str3;
    }

    public ShareFileUpdatedResult(String str, String str2, String str3, int i10, String str4) {
        this.hash = str;
        this.albumId = str2;
        this.ownerId = str3;
        this.code = i10;
        this.errMsg = str4;
    }

    public ShareFileUpdatedResult(Parcel parcel) {
        this.code = 0;
        this.hash = parcel.readString();
        this.albumId = parcel.readString();
        this.ownerId = parcel.readString();
        this.code = parcel.readInt();
        this.errMsg = parcel.readString();
    }
}
