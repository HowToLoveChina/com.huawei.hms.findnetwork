package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* loaded from: classes6.dex */
public class ThinAppStatus implements Comparable<ThinAppStatus>, Parcelable {
    public static final Parcelable.Creator<ThinAppStatus> CREATOR = new Parcelable.Creator<ThinAppStatus>() { // from class: com.huawei.hicloud.cloudbackup.v3.server.model.ThinAppStatus.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ThinAppStatus createFromParcel(Parcel parcel) {
            ThinAppStatus thinAppStatus = new ThinAppStatus();
            thinAppStatus.setAppId(parcel.readString());
            thinAppStatus.setAppName(parcel.readString());
            thinAppStatus.setBackupAppName(parcel.readString());
            thinAppStatus.setAction(parcel.readInt());
            thinAppStatus.setType(parcel.readInt());
            thinAppStatus.setIconSize(parcel.readLong());
            thinAppStatus.setApkSize(parcel.readLong());
            thinAppStatus.setAppDelTotalSize(parcel.readLong());
            return thinAppStatus;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ThinAppStatus[] newArray(int i10) {
            return new ThinAppStatus[i10];
        }
    };
    private int action;
    private long apkSize;
    private long appDelTotalSize;
    private String appId;
    private String appName;
    private String backupAppName;
    private long iconSize;
    private int type;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.backupAppName, ((ThinAppStatus) obj).backupAppName);
    }

    public int getAction() {
        return this.action;
    }

    public long getApkSize() {
        return this.apkSize;
    }

    public long getAppDelTotalSize() {
        return this.appDelTotalSize;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getBackupAppName() {
        return this.backupAppName;
    }

    public long getIconSize() {
        return this.iconSize;
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        return Objects.hash(this.backupAppName);
    }

    public ThinAppStatus setAction(int i10) {
        this.action = i10;
        return this;
    }

    public ThinAppStatus setApkSize(long j10) {
        this.apkSize = j10;
        return this;
    }

    public ThinAppStatus setAppDelTotalSize(long j10) {
        this.appDelTotalSize = j10;
        return this;
    }

    public ThinAppStatus setAppId(String str) {
        this.appId = str;
        return this;
    }

    public ThinAppStatus setAppName(String str) {
        this.appName = str;
        return this;
    }

    public ThinAppStatus setBackupAppName(String str) {
        this.backupAppName = str;
        return this;
    }

    public ThinAppStatus setIconSize(long j10) {
        this.iconSize = j10;
        return this;
    }

    public ThinAppStatus setType(int i10) {
        this.type = i10;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.appId);
        parcel.writeString(this.appName);
        parcel.writeString(this.backupAppName);
        parcel.writeInt(this.action);
        parcel.writeInt(this.type);
        parcel.writeLong(this.iconSize);
        parcel.writeLong(this.apkSize);
        parcel.writeLong(this.appDelTotalSize);
    }

    @Override // java.lang.Comparable
    public int compareTo(ThinAppStatus thinAppStatus) {
        return this.appDelTotalSize - thinAppStatus.getAppDelTotalSize() > 0 ? 1 : -1;
    }
}
