package com.huawei.android.hicloud.sync.service.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class FileDownloadProgress implements Parcelable {
    public static final Parcelable.Creator<FileDownloadProgress> CREATOR = new Parcelable.Creator<FileDownloadProgress>() { // from class: com.huawei.android.hicloud.sync.service.aidl.FileDownloadProgress.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileDownloadProgress createFromParcel(Parcel parcel) {
            return new FileDownloadProgress(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileDownloadProgress[] newArray(int i10) {
            return new FileDownloadProgress[i10];
        }
    };
    private long alreadyLoadSize;
    private String dataType;
    private long fileSize;
    private String guid;

    /* renamed from: id */
    private String f12982id;
    private String name;
    private long progress;
    private String syncType;

    public FileDownloadProgress(Parcel parcel) {
        readFromParcel(parcel);
    }

    private void readFromParcel(Parcel parcel) {
        this.syncType = parcel.readString();
        this.dataType = parcel.readString();
        this.f12982id = parcel.readString();
        this.guid = parcel.readString();
        this.name = parcel.readString();
        this.progress = parcel.readLong();
        this.fileSize = parcel.readLong();
        this.alreadyLoadSize = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getAlreadyLoadSize() {
        return this.alreadyLoadSize;
    }

    public String getDataType() {
        return this.dataType;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String getGuid() {
        return this.guid;
    }

    public String getId() {
        return this.f12982id;
    }

    public String getName() {
        return this.name;
    }

    public long getProgress() {
        return this.progress;
    }

    public String getSyncType() {
        return this.syncType;
    }

    public void setAlreadyLoadSize(long j10) {
        this.alreadyLoadSize = j10;
    }

    public void setDataType(String str) {
        this.dataType = str;
    }

    public void setFileSize(long j10) {
        this.fileSize = j10;
    }

    public void setGuid(String str) {
        this.guid = str;
    }

    public void setId(String str) {
        this.f12982id = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setProgress(long j10) {
        this.progress = j10;
    }

    public void setSyncType(String str) {
        this.syncType = str;
    }

    public String toString() {
        return "[dataType='" + this.dataType + "', id='" + this.f12982id + "', guid='" + this.guid + "', name='" + this.name + "', progress=" + this.progress + ", total=" + this.fileSize + ", increase=" + this.alreadyLoadSize + ']';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.syncType);
        parcel.writeString(this.dataType);
        parcel.writeString(this.f12982id);
        parcel.writeString(this.guid);
        parcel.writeString(this.name);
        parcel.writeLong(this.progress);
        parcel.writeLong(this.fileSize);
        parcel.writeLong(this.alreadyLoadSize);
    }

    public FileDownloadProgress() {
    }
}
