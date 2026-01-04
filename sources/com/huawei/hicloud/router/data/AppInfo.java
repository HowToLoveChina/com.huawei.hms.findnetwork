package com.huawei.hicloud.router.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class AppInfo implements Parcelable, Cloneable {
    public static final Parcelable.Creator<AppInfo> CREATOR = new Parcelable.Creator<AppInfo>() { // from class: com.huawei.hicloud.router.data.AppInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppInfo createFromParcel(Parcel parcel) {
            return new AppInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppInfo[] newArray(int i10) {
            return new AppInfo[i10];
        }
    };
    private String albumId;
    private String albumName;
    private int albumType;
    private String coverPath;
    private String displayName;
    private int order;
    private String relativePath;
    private int switchStatus;
    private int tempId;

    private void readFromParcel(Parcel parcel) {
        this.albumId = parcel.readString();
        this.albumName = parcel.readString();
        this.order = parcel.readInt();
    }

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

    public int getAlbumType() {
        return this.albumType;
    }

    public String getCoverPath() {
        return this.coverPath;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public int getOrder() {
        return this.order;
    }

    public String getRelativePath() {
        return this.relativePath;
    }

    public int getSwitchStatus() {
        return this.switchStatus;
    }

    public int getTempId() {
        return this.tempId;
    }

    public void setAlbumId(String str) {
        this.albumId = str;
    }

    public void setAlbumName(String str) {
        this.albumName = str;
    }

    public void setAlbumType(int i10) {
        this.albumType = i10;
    }

    public void setCoverPath(String str) {
        this.coverPath = str;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setOrder(int i10) {
        this.order = i10;
    }

    public void setRelativePath(String str) {
        this.relativePath = str;
    }

    public void setSwitchStatus(int i10) {
        this.switchStatus = i10;
    }

    public void setTempId(int i10) {
        this.tempId = i10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append(", relativePath=");
        sb2.append(this.relativePath);
        sb2.append(", albumId=");
        sb2.append(this.albumId);
        sb2.append(", displayName=");
        sb2.append(this.displayName);
        sb2.append(", tempType=");
        sb2.append(this.tempId);
        sb2.append(", uploadType=");
        sb2.append(this.albumType);
        sb2.append(", order=");
        sb2.append(this.order);
        sb2.append(", status=");
        sb2.append(this.switchStatus);
        sb2.append("]");
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.albumId);
        parcel.writeString(this.albumName);
        parcel.writeInt(this.order);
    }

    public AppInfo() {
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public AppInfo m85648clone() throws CloneNotSupportedException {
        return (AppInfo) super.clone();
    }

    private AppInfo(Parcel parcel) {
        readFromParcel(parcel);
    }
}
