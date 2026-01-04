package com.huawei.android.hicloud.album.service.p075vo;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class SimplifyInfo implements Parcelable {
    public static final Parcelable.Creator<SimplifyInfo> CREATOR = new Parcelable.Creator<SimplifyInfo>() { // from class: com.huawei.android.hicloud.album.service.vo.SimplifyInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SimplifyInfo createFromParcel(Parcel parcel) {
            return new SimplifyInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SimplifyInfo[] newArray(int i10) {
            return new SimplifyInfo[i10];
        }
    };
    private String albumId;
    private long createTime;
    private String sdsmtime;
    private String uniqueId;

    public SimplifyInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAlbumId() {
        return this.albumId;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getSdsmtime() {
        return this.sdsmtime;
    }

    public String getUniqueId() {
        return this.uniqueId;
    }

    public void setAlbumId(String str) {
        this.albumId = str;
    }

    public void setCreateTime(long j10) {
        this.createTime = j10;
    }

    public void setSdsmtime(String str) {
        this.sdsmtime = str;
    }

    public void setUniqueId(String str) {
        this.uniqueId = str;
    }

    public String toString() {
        return "SimplifyInfo{albumId='" + this.albumId + "', uniqueId='" + this.uniqueId + "', sdsmtime='" + this.sdsmtime + "', createTime=" + this.createTime + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.albumId);
        parcel.writeString(this.uniqueId);
        parcel.writeString(this.sdsmtime);
        parcel.writeLong(this.createTime);
    }

    public SimplifyInfo(Parcel parcel) {
        this.albumId = parcel.readString();
        this.uniqueId = parcel.readString();
        this.sdsmtime = parcel.readString();
        this.createTime = parcel.readLong();
    }
}
