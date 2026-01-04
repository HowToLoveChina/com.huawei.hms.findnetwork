package com.huawei.android.hicloud.album.service.p075vo;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class FileUpdatedResult implements Parcelable {
    public static final Parcelable.Creator<FileUpdatedResult> CREATOR = new Parcelable.Creator<FileUpdatedResult>() { // from class: com.huawei.android.hicloud.album.service.vo.FileUpdatedResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileUpdatedResult createFromParcel(Parcel parcel) {
            return new FileUpdatedResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileUpdatedResult[] newArray(int i10) {
            return new FileUpdatedResult[i10];
        }
    };
    private String albumId;
    private String albumName;
    private int errCode;
    private String errMsg;
    private String fileName;
    private String localId;
    private String localRealPath;
    private String lpath;
    private String recycletime;
    private String sdsctime;
    private String sdsmtime;
    private long timeStamp;
    private String uniqueId;

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

    public String getFileName() {
        return this.fileName;
    }

    public String getLocalId() {
        return this.localId;
    }

    public String getLocalRealPath() {
        return this.localRealPath;
    }

    public String getLpath() {
        return this.lpath;
    }

    public String getRecycletime() {
        return this.recycletime;
    }

    public String getSdsctime() {
        return this.sdsctime;
    }

    public String getSdsmtime() {
        return this.sdsmtime;
    }

    public long getTimestamp() {
        return this.timeStamp;
    }

    public String getUniqueId() {
        return this.uniqueId;
    }

    public void readFromParcel(Parcel parcel) {
        this.fileName = parcel.readString();
        this.uniqueId = parcel.readString();
        this.errCode = parcel.readInt();
        this.errMsg = parcel.readString();
        this.sdsctime = parcel.readString();
        if (Version.getAidlVersion() >= 1) {
            this.albumId = parcel.readString();
            this.albumName = parcel.readString();
            this.lpath = parcel.readString();
        }
        if (Version.isSupportCopy()) {
            this.localId = parcel.readString();
            this.recycletime = parcel.readString();
            this.sdsmtime = parcel.readString();
        }
        if (Version.isSupportTimeStamp()) {
            this.timeStamp = parcel.readLong();
        }
        if (Version.isAlbumUpdatedSupportExistAlbumId()) {
            this.localRealPath = parcel.readString();
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

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setLocalId(String str) {
        this.localId = str;
    }

    public void setLocalRealPath(String str) {
        this.localRealPath = str;
    }

    public void setLpath(String str) {
        this.lpath = str;
    }

    public void setRecycletime(String str) {
        this.recycletime = str;
    }

    public void setSdsctime(String str) {
        this.sdsctime = str;
    }

    public void setSdsmtime(String str) {
        this.sdsmtime = str;
    }

    public void setTimestamp(long j10) {
        this.timeStamp = j10;
    }

    public void setUniqueId(String str) {
        this.uniqueId = str;
    }

    public String toString() {
        return "FileUpdatedResult{fileName='" + this.fileName + "', uniqueId='" + this.uniqueId + "', albumId='" + this.albumId + "', albumName='" + this.albumName + "', lpath='" + this.lpath + "', localId='" + this.localId + "', errCode=" + this.errCode + ", errMsg='" + this.errMsg + "', sdsctime='" + this.sdsctime + "', sdsmtime='" + this.sdsmtime + "', recycletime='" + this.recycletime + "', timeStamp='" + this.timeStamp + "', localRealPath='" + this.localRealPath + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.fileName);
        parcel.writeString(this.uniqueId);
        parcel.writeInt(this.errCode);
        parcel.writeString(this.errMsg);
        parcel.writeString(this.sdsctime);
        if (Version.getAidlVersion() >= 1) {
            parcel.writeString(this.albumId);
            parcel.writeString(this.albumName);
            parcel.writeString(this.lpath);
        }
        if (Version.isSupportCopy()) {
            parcel.writeString(this.localId);
            parcel.writeString(this.recycletime);
            parcel.writeString(this.sdsmtime);
        }
        if (Version.isSupportTimeStamp()) {
            parcel.writeLong(this.timeStamp);
        }
        if (Version.isAlbumUpdatedSupportExistAlbumId()) {
            parcel.writeString(this.localRealPath);
        }
    }

    public FileUpdatedResult(String str, int i10, String str2) {
        this.uniqueId = str;
        this.errCode = i10;
        this.errMsg = str2;
    }

    public FileUpdatedResult(String str, String str2, int i10, String str3) {
        this.localId = str;
        this.uniqueId = str2;
        this.errCode = i10;
        this.errMsg = str3;
    }

    public FileUpdatedResult(String str, String str2, String str3, String str4, String str5) {
        this.errCode = 0;
        this.fileName = str;
        this.uniqueId = str2;
        this.albumId = str3;
        this.albumName = str4;
        this.lpath = str5;
    }

    public FileUpdatedResult(String str, String str2, String str3, String str4, String str5, boolean z10) {
        this.errCode = 0;
        this.fileName = str;
        this.uniqueId = str2;
        this.localId = str3;
        this.recycletime = str4;
        this.sdsmtime = str5;
    }

    public FileUpdatedResult(String str) {
        this.errCode = 0;
        this.uniqueId = str;
    }

    public FileUpdatedResult() {
        this.errCode = 0;
    }

    private FileUpdatedResult(Parcel parcel) {
        this.errCode = 0;
        readFromParcel(parcel);
    }
}
