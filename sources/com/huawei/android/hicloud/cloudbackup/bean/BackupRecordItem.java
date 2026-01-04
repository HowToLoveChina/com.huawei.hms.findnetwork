package com.huawei.android.hicloud.cloudbackup.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class BackupRecordItem implements Comparable<BackupRecordItem>, Parcelable {
    public static final Parcelable.Creator<BackupRecordItem> CREATOR = new Parcelable.Creator<BackupRecordItem>() { // from class: com.huawei.android.hicloud.cloudbackup.bean.BackupRecordItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BackupRecordItem createFromParcel(Parcel parcel) {
            BackupRecordItem backupRecordItem = new BackupRecordItem();
            backupRecordItem.setBackupId(parcel.readString());
            backupRecordItem.setDeviceId(parcel.readString());
            backupRecordItem.setCurrent(parcel.readByte() != 0);
            backupRecordItem.setDeviceName(parcel.readString());
            backupRecordItem.setTerminalType(parcel.readString());
            backupRecordItem.setDeviceType(parcel.readInt());
            backupRecordItem.setLastbackupTime(parcel.readLong());
            backupRecordItem.setSize(parcel.readLong());
            backupRecordItem.setDevDisplayName(parcel.readString());
            backupRecordItem.setNewBackup(parcel.readByte() != 0);
            return backupRecordItem;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BackupRecordItem[] newArray(int i10) {
            return new BackupRecordItem[i10];
        }
    };
    private String backupId;
    private String devDisplayName;
    private String deviceId;
    private String deviceName;
    private int deviceType;
    private boolean isCurrent;
    private boolean isNewBackup;
    private long lastbackupTime;
    private long size;
    private String terminalType;

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
        BackupRecordItem backupRecordItem = (BackupRecordItem) obj;
        if (this.lastbackupTime != backupRecordItem.lastbackupTime) {
            return false;
        }
        String str = this.backupId;
        if (str == null) {
            if (backupRecordItem.backupId != null) {
                return false;
            }
        } else if (!str.equals(backupRecordItem.backupId)) {
            return false;
        }
        return true;
    }

    public String getBackupId() {
        return this.backupId;
    }

    public String getDevDisplayName() {
        return this.devDisplayName;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public long getLastbackupTime() {
        return this.lastbackupTime;
    }

    public long getSize() {
        return this.size;
    }

    public String getTerminalType() {
        return this.terminalType;
    }

    public int hashCode() {
        String str = this.backupId;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j10 = this.lastbackupTime;
        return ((iHashCode + 31) * 31) + ((int) (j10 ^ (j10 >>> 32)));
    }

    public boolean isCurrent() {
        return this.isCurrent;
    }

    public boolean isNewBackup() {
        return this.isNewBackup;
    }

    public void setBackupId(String str) {
        this.backupId = str;
    }

    public void setCurrent(boolean z10) {
        this.isCurrent = z10;
    }

    public void setDevDisplayName(String str) {
        this.devDisplayName = str;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setDeviceType(int i10) {
        this.deviceType = i10;
    }

    public void setLastbackupTime(long j10) {
        this.lastbackupTime = j10;
    }

    public void setNewBackup(boolean z10) {
        this.isNewBackup = z10;
    }

    public void setSize(long j10) {
        this.size = j10;
    }

    public void setTerminalType(String str) {
        this.terminalType = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.backupId);
        parcel.writeString(this.deviceId);
        parcel.writeByte(this.isCurrent ? (byte) 1 : (byte) 0);
        parcel.writeString(this.deviceName);
        parcel.writeString(this.terminalType);
        parcel.writeInt(this.deviceType);
        parcel.writeLong(this.lastbackupTime);
        parcel.writeLong(this.size);
        parcel.writeString(this.devDisplayName);
        parcel.writeByte(this.isNewBackup ? (byte) 1 : (byte) 0);
    }

    @Override // java.lang.Comparable
    public int compareTo(BackupRecordItem backupRecordItem) {
        long j10 = this.lastbackupTime;
        long j11 = backupRecordItem.lastbackupTime;
        if (j10 < j11) {
            return 1;
        }
        return j10 > j11 ? -1 : 0;
    }
}
