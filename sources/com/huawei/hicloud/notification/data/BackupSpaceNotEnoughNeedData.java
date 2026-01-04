package com.huawei.hicloud.notification.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes6.dex */
public class BackupSpaceNotEnoughNeedData implements Parcelable {
    public static final Parcelable.Creator<BackupSpaceNotEnoughNeedData> CREATOR = new Parcelable.Creator<BackupSpaceNotEnoughNeedData>() { // from class: com.huawei.hicloud.notification.data.BackupSpaceNotEnoughNeedData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BackupSpaceNotEnoughNeedData createFromParcel(Parcel parcel) {
            return new BackupSpaceNotEnoughNeedData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BackupSpaceNotEnoughNeedData[] newArray(int i10) {
            return new BackupSpaceNotEnoughNeedData[i10];
        }
    };
    private long backupNeedSpace;
    private long galleryNum;
    private boolean isFamilyShareMember;
    private long notUsedSpace;
    private long totalNeedSpace;
    private long totalSpace;
    private long usedSpace;

    public BackupSpaceNotEnoughNeedData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getBackupNeedSpace() {
        return this.backupNeedSpace;
    }

    public long getGalleryNum() {
        return this.galleryNum;
    }

    public long getNotUsedSpace() {
        return this.notUsedSpace;
    }

    public long getTotalNeedSpace() {
        return this.totalNeedSpace;
    }

    public long getTotalSpace() {
        return this.totalSpace;
    }

    public long getUsedSpace() {
        return this.usedSpace;
    }

    public boolean isFamilyShareMember() {
        return this.isFamilyShareMember;
    }

    public void setBackupNeedSpace(long j10) {
        this.backupNeedSpace = j10;
    }

    public void setFamilyShareMember(boolean z10) {
        this.isFamilyShareMember = z10;
    }

    public void setGalleryNum(long j10) {
        this.galleryNum = j10;
    }

    public void setNotUsedSpace(long j10) {
        this.notUsedSpace = j10;
    }

    public void setTotalNeedSpace(long j10) {
        this.totalNeedSpace = j10;
    }

    public void setTotalSpace(long j10) {
        this.totalSpace = j10;
    }

    public void setUsedSpace(long j10) {
        this.usedSpace = j10;
    }

    public String toString() {
        return "BackupSpaceNotEnoughNeedData{totalNeedSpace=" + this.totalNeedSpace + ", backupNeedSpace=" + this.backupNeedSpace + ", notUsedSpace=" + this.notUsedSpace + ", totalSpace=" + this.totalSpace + ", usedSpace=" + this.usedSpace + ", galleryNum=" + this.galleryNum + ", isFamilyShareMember=" + this.isFamilyShareMember + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.totalNeedSpace);
        parcel.writeLong(this.backupNeedSpace);
        parcel.writeLong(this.notUsedSpace);
        parcel.writeLong(this.totalSpace);
        parcel.writeLong(this.usedSpace);
        parcel.writeLong(this.galleryNum);
        parcel.writeByte(this.isFamilyShareMember ? (byte) 1 : (byte) 0);
    }

    public BackupSpaceNotEnoughNeedData(Parcel parcel) {
        this.totalNeedSpace = parcel.readLong();
        this.backupNeedSpace = parcel.readLong();
        this.notUsedSpace = parcel.readLong();
        this.totalSpace = parcel.readLong();
        this.usedSpace = parcel.readLong();
        this.galleryNum = parcel.readLong();
        this.isFamilyShareMember = parcel.readByte() != 0;
    }
}
