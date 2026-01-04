package com.huawei.android.hicloud.album.service.p075vo;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class FileDownloadProgress implements Parcelable {
    public static final Parcelable.Creator<FileDownloadProgress> CREATOR = new Parcelable.Creator<FileDownloadProgress>() { // from class: com.huawei.android.hicloud.album.service.vo.FileDownloadProgress.1
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
    private String fileId;
    private long fileLoadSizeByte;
    private long fileSizeByte;
    private String localRealPath;
    private long progress;
    private int resolutionType;
    private int state;
    private String uniqueId;

    private void calcProgress() {
        long j10 = this.fileSizeByte;
        if (j10 <= 0) {
            this.progress = 0L;
        } else {
            this.progress = (this.fileLoadSizeByte * 100) / j10;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getFileId() {
        return this.fileId;
    }

    public long getFileLoadSizeByte() {
        return this.fileLoadSizeByte;
    }

    public long getFileSizeByte() {
        return this.fileSizeByte;
    }

    public String getLocalRealPath() {
        return this.localRealPath;
    }

    public long getProgress() {
        return this.progress;
    }

    public int getResolutionType() {
        return this.resolutionType;
    }

    public int getState() {
        return this.state;
    }

    public String getUniqueId() {
        return this.uniqueId;
    }

    public final void readFromParcel(Parcel parcel) {
        this.fileSizeByte = parcel.readLong();
        this.fileLoadSizeByte = parcel.readLong();
        this.progress = parcel.readLong();
        this.fileId = parcel.readString();
        this.resolutionType = parcel.readInt();
        this.uniqueId = parcel.readString();
        this.state = parcel.readInt();
        this.localRealPath = parcel.readString();
    }

    public void setFileId(String str) {
        this.fileId = str;
    }

    public void setFileLoadSizeByte(long j10) {
        this.fileLoadSizeByte = j10;
        calcProgress();
    }

    public void setFileSizeByte(long j10) {
        this.fileSizeByte = j10;
        calcProgress();
    }

    public void setLocalRealPath(String str) {
        this.localRealPath = str;
    }

    public void setProgress(long j10) {
        this.progress = j10;
    }

    public void setResolutionType(int i10) {
        this.resolutionType = i10;
    }

    public void setState(int i10) {
        this.state = i10;
    }

    public void setUniqueId(String str) {
        this.uniqueId = str;
    }

    public String toString() {
        return "FileDownloadProgress{fileSizeByte=" + this.fileSizeByte + ", fileLoadSizeByte=" + this.fileLoadSizeByte + ", progress=" + this.progress + ", fileId='" + this.fileId + "', uniqueId='" + this.uniqueId + "', resolutionType=" + this.resolutionType + ", state=" + this.state + ", localRealPath=" + this.localRealPath + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.fileSizeByte);
        parcel.writeLong(this.fileLoadSizeByte);
        parcel.writeLong(this.progress);
        parcel.writeString(this.fileId);
        parcel.writeInt(this.resolutionType);
        parcel.writeString(this.uniqueId);
        parcel.writeInt(this.state);
        parcel.writeString(this.localRealPath);
    }

    public FileDownloadProgress() {
        this.fileSizeByte = 0L;
        this.fileLoadSizeByte = 0L;
        this.progress = 0L;
        this.resolutionType = 0;
    }

    public FileDownloadProgress(long j10, long j11) {
        this.progress = 0L;
        this.resolutionType = 0;
        this.fileSizeByte = j10;
        this.fileLoadSizeByte = j11;
        calcProgress();
    }

    private FileDownloadProgress(Parcel parcel) {
        this.fileSizeByte = 0L;
        this.fileLoadSizeByte = 0L;
        this.progress = 0L;
        this.resolutionType = 0;
        readFromParcel(parcel);
    }
}
