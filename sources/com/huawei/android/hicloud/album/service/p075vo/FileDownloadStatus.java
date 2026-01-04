package com.huawei.android.hicloud.album.service.p075vo;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class FileDownloadStatus extends FileData {
    public static final Parcelable.Creator<FileDownloadStatus> CREATOR = new Parcelable.Creator<FileDownloadStatus>() { // from class: com.huawei.android.hicloud.album.service.vo.FileDownloadStatus.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileDownloadStatus createFromParcel(Parcel parcel) {
            return new FileDownloadStatus(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileDownloadStatus[] newArray(int i10) {
            return new FileDownloadStatus[i10];
        }
    };

    private void readFromParcel(Parcel parcel) {
        this.addTime = parcel.readLong();
        this.finishTime = parcel.readLong();
        this.fileStatus = parcel.readInt();
        this.sizeProgress = parcel.readLong();
        this.ext1 = parcel.readString();
        this.ext2 = parcel.readString();
        this.ext3 = parcel.readString();
    }

    @Override // com.huawei.android.hicloud.album.service.p075vo.FileData, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.huawei.android.hicloud.album.service.p075vo.FileData
    public String toString() {
        return "FileDownloadStatus{addTime=" + this.addTime + ", finishTime=" + this.finishTime + ", fileStatus=" + this.fileStatus + ", sizeProgress=" + this.sizeProgress + ", ext1='" + this.ext1 + "', ext2='" + this.ext2 + "', ext3='" + this.ext3 + "'}";
    }

    @Override // com.huawei.android.hicloud.album.service.p075vo.FileData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeLong(this.addTime);
        parcel.writeLong(this.finishTime);
        parcel.writeInt(this.fileStatus);
        parcel.writeLong(this.sizeProgress);
        parcel.writeString(this.ext1);
        parcel.writeString(this.ext2);
        parcel.writeString(this.ext3);
    }

    public FileDownloadStatus() {
    }

    private FileDownloadStatus(Parcel parcel) {
        super(parcel);
        readFromParcel(parcel);
    }
}
