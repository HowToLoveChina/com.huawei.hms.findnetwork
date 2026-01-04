package com.huawei.android.hicloud.cloudbackup.p076db.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hicloud.router.data.AppInfo;

/* loaded from: classes2.dex */
public class Albums implements Parcelable {
    public static final int ALBUM_ALL_INSIDE = 0;
    public static final int ALBUM_ALL_OUTSIDE = 1;
    public static final int ALBUM_EXTERNAL_OUTSIDE = 3;
    public static final int ALBUM_SD_OUTSIDE = 2;
    public static final Parcelable.Creator<Albums> CREATOR = new Parcelable.Creator<Albums>() { // from class: com.huawei.android.hicloud.cloudbackup.db.bean.Albums.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Albums createFromParcel(Parcel parcel) {
            return new Albums(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Albums[] newArray(int i10) {
            return new Albums[i10];
        }
    };
    public static final String OUTSIDE_FILE_NAME = ".outside";
    public static final int TYPE_ALBUM_BACKUP = 1;
    public static final int TYPE_ALBUM_BACKUP_NEVER = 2;
    private String albumId;
    private String albumName;
    private int albumType;
    private String displayName;
    private int outside;
    private String relativePath;
    private int switchStatus;
    private int tempId;

    private <T> T commonSetFunction(T t10) {
        if (t10 == null) {
            return null;
        }
        return t10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAlbumId() {
        return (String) commonSetFunction(this.albumId);
    }

    public String getAlbumName() {
        return this.albumName;
    }

    public int getAlbumType() {
        return this.albumType;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public int getOutside() {
        return this.outside;
    }

    public String getRelativePath() {
        return (String) commonSetFunction(this.relativePath);
    }

    public int getSwitchStatus() {
        return this.switchStatus;
    }

    public int getTempId() {
        return this.tempId;
    }

    public boolean isAlbumBackup() {
        return this.switchStatus == 1;
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

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setOutside(int i10) {
        this.outside = ((Integer) commonSetFunction(Integer.valueOf(i10))).intValue();
    }

    public void setRelativePath(String str) {
        this.relativePath = str;
    }

    public void setSwitchStatus(int i10) {
        this.switchStatus = ((Integer) commonSetFunction(Integer.valueOf(i10))).intValue();
    }

    public void setTempId(int i10) {
        this.tempId = i10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("albumName=");
        sb2.append(this.albumName);
        sb2.append(", relativePath=");
        sb2.append(this.relativePath);
        sb2.append(", albumId=");
        sb2.append(this.albumId);
        sb2.append(", displayName=");
        sb2.append(this.displayName);
        sb2.append(", tempId=");
        sb2.append(this.tempId);
        sb2.append(", albumType=");
        sb2.append(this.albumType);
        sb2.append(", status=");
        sb2.append(this.switchStatus);
        sb2.append(", outside=");
        sb2.append(this.outside);
        sb2.append("]");
        return sb2.toString();
    }

    public void updateAlbumsInfo(AppInfo appInfo) {
        this.albumId = appInfo.getAlbumId();
        this.tempId = appInfo.getTempId();
        this.albumName = appInfo.getAlbumName();
        this.albumType = appInfo.getAlbumType();
        this.displayName = appInfo.getDisplayName();
        this.relativePath = appInfo.getRelativePath();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.albumId);
        parcel.writeInt(this.tempId);
        parcel.writeString(this.albumName);
        parcel.writeInt(this.albumType);
        parcel.writeString(this.displayName);
        parcel.writeString(this.relativePath);
        parcel.writeInt(this.switchStatus);
        parcel.writeInt(this.outside);
    }

    public Albums() {
        this.outside = 0;
    }

    public void setSwitchStatus(boolean z10) {
        if (z10) {
            this.switchStatus = 1;
        } else {
            this.switchStatus = 2;
        }
    }

    public Albums(AppInfo appInfo) {
        this.outside = 0;
        this.albumId = appInfo.getAlbumId();
        this.tempId = appInfo.getTempId();
        this.albumName = appInfo.getAlbumName();
        this.albumType = appInfo.getAlbumType();
        this.displayName = appInfo.getDisplayName();
        this.relativePath = appInfo.getRelativePath();
        this.switchStatus = 2;
    }

    private Albums(Parcel parcel) {
        this.outside = 0;
        this.albumId = parcel.readString();
        this.tempId = parcel.readInt();
        this.albumName = parcel.readString();
        this.albumType = parcel.readInt();
        this.displayName = parcel.readString();
        this.relativePath = parcel.readString();
        this.switchStatus = parcel.readInt();
        this.outside = parcel.readInt();
    }
}
