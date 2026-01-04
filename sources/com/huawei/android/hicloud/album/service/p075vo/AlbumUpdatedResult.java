package com.huawei.android.hicloud.album.service.p075vo;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class AlbumUpdatedResult implements Parcelable {
    public static final Parcelable.Creator<AlbumUpdatedResult> CREATOR = new Parcelable.Creator<AlbumUpdatedResult>() { // from class: com.huawei.android.hicloud.album.service.vo.AlbumUpdatedResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AlbumUpdatedResult createFromParcel(Parcel parcel) {
            return new AlbumUpdatedResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AlbumUpdatedResult[] newArray(int i10) {
            return new AlbumUpdatedResult[i10];
        }
    };
    private String albumId;
    private String albumName;
    private int errCode;
    private String errMsg;
    private String existAlbumId;
    private long timeStamp;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAlbumId() {
        return this.albumId;
    }

    public String getAlbumName() {
        return this.albumName;
    }

    public int getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public String getExistAlbumId() {
        return this.existAlbumId;
    }

    public long getTimestamp() {
        return this.timeStamp;
    }

    public boolean isSuccess() {
        return this.errCode == 0;
    }

    public void readFromParcel(Parcel parcel) {
        this.albumId = parcel.readString();
        this.albumName = parcel.readString();
        this.errCode = parcel.readInt();
        this.errMsg = parcel.readString();
        if (Version.isSupportTimeStamp()) {
            this.timeStamp = parcel.readLong();
        }
        if (Version.isAlbumUpdatedSupportExistAlbumId()) {
            this.existAlbumId = parcel.readString();
        }
    }

    public void setAlbumId(String str) {
        this.albumId = str;
    }

    public void setAlbumName(String str) {
        this.albumName = str;
    }

    public void setErrCode(int i10) {
        this.errCode = i10;
    }

    public void setErrMsg(String str) {
        this.errMsg = str;
    }

    public void setExistAlbumId(String str) {
        this.existAlbumId = str;
    }

    public void setTimestamp(long j10) {
        this.timeStamp = j10;
    }

    public String toString() {
        return "AlbumUpdatedResult{albumName='" + this.albumName + "', albumId='" + this.albumId + "', timeStamp='" + this.timeStamp + "', errCode=" + this.errCode + ", errMsg='" + this.errMsg + "', existAlbumId='" + this.existAlbumId + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.albumId);
        parcel.writeString(this.albumName);
        parcel.writeInt(this.errCode);
        parcel.writeString(this.errMsg);
        if (Version.isSupportTimeStamp()) {
            parcel.writeLong(this.timeStamp);
        }
        if (Version.isAlbumUpdatedSupportExistAlbumId()) {
            parcel.writeString(this.existAlbumId);
        }
    }

    public AlbumUpdatedResult(String str, String str2, int i10, String str3) {
        this.albumName = str;
        this.albumId = str2;
        this.errCode = i10;
        this.errMsg = str3;
    }

    public AlbumUpdatedResult() {
    }

    private AlbumUpdatedResult(Parcel parcel) {
        readFromParcel(parcel);
    }
}
