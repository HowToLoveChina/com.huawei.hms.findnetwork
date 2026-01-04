package com.huawei.android.hicloud.album.service.p075vo;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class CloudAlbumVersion implements Parcelable {
    public static final Parcelable.Creator<CloudAlbumVersion> CREATOR = new Parcelable.Creator<CloudAlbumVersion>() { // from class: com.huawei.android.hicloud.album.service.vo.CloudAlbumVersion.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CloudAlbumVersion createFromParcel(Parcel parcel) {
            return new CloudAlbumVersion(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CloudAlbumVersion[] newArray(int i10) {
            return new CloudAlbumVersion[i10];
        }
    };
    private String albumListVersion;
    private String albumVersion;
    private String clearVersion;
    private boolean isDataMigrated;
    private long latestVersion;

    public static String getBundleKey() {
        return "CloudAlbumVersion";
    }

    private void readFromParcel(Parcel parcel) {
        this.albumListVersion = parcel.readString();
        this.albumVersion = parcel.readString();
        this.latestVersion = parcel.readLong();
        this.clearVersion = parcel.readString();
        if (Version.isSupportClearVersionV2()) {
            this.isDataMigrated = parcel.readBoolean();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAlbumListVersion() {
        return this.albumListVersion;
    }

    public String getAlbumVersion() {
        return this.albumVersion;
    }

    public String getClearVersion() {
        return this.clearVersion;
    }

    public long getLatestVersion() {
        return this.latestVersion;
    }

    public boolean isDataMigrated() {
        return this.isDataMigrated;
    }

    public void setAlbumListVersion(String str) {
        this.albumListVersion = str;
    }

    public void setAlbumVersion(String str) {
        this.albumVersion = str;
    }

    public void setClearVersion(String str) {
        this.clearVersion = str;
    }

    public void setDataMigrated(boolean z10) {
        this.isDataMigrated = z10;
    }

    public void setLatestVersion(long j10) {
        this.latestVersion = j10;
    }

    public String toString() {
        return "CloudAlbumVersion{albumVersion='" + this.albumVersion + "', albumListVersion='" + this.albumListVersion + "', latestVersion='" + this.latestVersion + "', clearVersion='" + this.clearVersion + "', isDataMigrated='" + this.isDataMigrated + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.albumListVersion);
        parcel.writeString(this.albumVersion);
        parcel.writeLong(this.latestVersion);
        parcel.writeString(this.clearVersion);
        if (Version.isSupportClearVersionV2()) {
            parcel.writeBoolean(this.isDataMigrated);
        }
    }

    public CloudAlbumVersion() {
        this.isDataMigrated = false;
    }

    public CloudAlbumVersion(String str, String str2, long j10, String str3) {
        this.isDataMigrated = false;
        this.albumListVersion = str2;
        this.albumVersion = str;
        this.latestVersion = j10;
        this.clearVersion = str3;
    }

    private CloudAlbumVersion(Parcel parcel) {
        this.isDataMigrated = false;
        readFromParcel(parcel);
    }
}
