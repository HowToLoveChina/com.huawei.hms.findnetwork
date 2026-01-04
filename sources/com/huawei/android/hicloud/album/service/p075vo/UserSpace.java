package com.huawei.android.hicloud.album.service.p075vo;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class UserSpace implements Parcelable {
    public static final Parcelable.Creator<UserSpace> CREATOR = new Parcelable.Creator<UserSpace>() { // from class: com.huawei.android.hicloud.album.service.vo.UserSpace.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserSpace createFromParcel(Parcel parcel) {
            return new UserSpace(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserSpace[] newArray(int i10) {
            return new UserSpace[i10];
        }
    };
    public static final long DEFAULT_SPACE_SIZE = -1;
    private long cloudPhotoSize;
    private long recyclePhotoSize;
    private long totalSpaceSize;
    private long useSpaceSize;

    private void readFromParcel(Parcel parcel) {
        this.useSpaceSize = parcel.readLong();
        this.totalSpaceSize = parcel.readLong();
        this.cloudPhotoSize = parcel.readLong();
        this.recyclePhotoSize = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getCloudPhotoSize() {
        return this.cloudPhotoSize;
    }

    public long getRecyclePhotoSize() {
        return this.recyclePhotoSize;
    }

    public long getTotalSpaceSize() {
        return this.totalSpaceSize;
    }

    public long getUseSpaceSize() {
        return this.useSpaceSize;
    }

    public void setCloudPhotoSize(long j10) {
        this.cloudPhotoSize = j10;
    }

    public void setRecyclePhotoSize(long j10) {
        this.recyclePhotoSize = j10;
    }

    public void setTotalSpaceSize(long j10) {
        this.totalSpaceSize = j10;
    }

    public void setUseSpaceSize(long j10) {
        this.useSpaceSize = j10;
    }

    public String toString() {
        return "UserSpace{useSpaceSize=" + this.useSpaceSize + ", totalSpaceSize=" + this.totalSpaceSize + ", cloudPhotoSize=" + this.cloudPhotoSize + ", recyclePhotoSize=" + this.recyclePhotoSize + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.useSpaceSize);
        parcel.writeLong(this.totalSpaceSize);
        parcel.writeLong(this.cloudPhotoSize);
        parcel.writeLong(this.recyclePhotoSize);
    }

    private UserSpace(Parcel parcel) {
        this.useSpaceSize = -1L;
        this.totalSpaceSize = -1L;
        this.cloudPhotoSize = -1L;
        this.recyclePhotoSize = -1L;
        readFromParcel(parcel);
    }

    public UserSpace() {
        this.useSpaceSize = -1L;
        this.totalSpaceSize = -1L;
        this.cloudPhotoSize = -1L;
        this.recyclePhotoSize = -1L;
    }

    public UserSpace(long j10, long j11, long j12, long j13) {
        this.useSpaceSize = j10;
        this.totalSpaceSize = j11;
        this.cloudPhotoSize = j12;
        this.recyclePhotoSize = j13;
    }
}
