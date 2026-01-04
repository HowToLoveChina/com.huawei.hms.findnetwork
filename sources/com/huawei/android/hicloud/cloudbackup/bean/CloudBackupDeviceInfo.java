package com.huawei.android.hicloud.cloudbackup.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hicloud.cloudbackup.model.CloudRecoveryItem;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class CloudBackupDeviceInfo implements Parcelable, Cloneable {
    public static final Parcelable.Creator<CloudBackupDeviceInfo> CREATOR = new Parcelable.Creator<CloudBackupDeviceInfo>() { // from class: com.huawei.android.hicloud.cloudbackup.bean.CloudBackupDeviceInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CloudBackupDeviceInfo createFromParcel(Parcel parcel) {
            CloudBackupDeviceInfo cloudBackupDeviceInfo = new CloudBackupDeviceInfo();
            cloudBackupDeviceInfo.deviceType = parcel.readInt();
            cloudBackupDeviceInfo.deviceCategory = parcel.readString();
            cloudBackupDeviceInfo.devDisplayName = parcel.readString();
            cloudBackupDeviceInfo.deviceId = parcel.readString();
            cloudBackupDeviceInfo.backupDeviceId = parcel.readString();
            cloudBackupDeviceInfo.deviceBackupSpace = parcel.readLong();
            cloudBackupDeviceInfo.isCurrent = parcel.readBoolean();
            cloudBackupDeviceInfo.recoveryItems = parcel.createTypedArrayList(CloudRecoveryItem.CREATOR);
            cloudBackupDeviceInfo.terminalType = parcel.readString();
            return cloudBackupDeviceInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CloudBackupDeviceInfo[] newArray(int i10) {
            return new CloudBackupDeviceInfo[i10];
        }
    };
    private String backupDeviceId;
    private String devDisplayName;
    private long deviceBackupSpace;
    private String deviceCategory;
    private String deviceId;
    private int deviceType;
    private boolean isCurrent;
    private boolean isTempBackup;
    private long lastBackupTime;
    List<CloudRecoveryItem> recoveryItems;
    private String terminalType;

    public CloudBackupDeviceInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBackupDeviceId() {
        return this.backupDeviceId;
    }

    public String getDevDisplayName() {
        return this.devDisplayName;
    }

    public long getDeviceBackupSpace() {
        return this.deviceBackupSpace;
    }

    public String getDeviceCategory() {
        return this.deviceCategory;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public long getLastBackupTime() {
        return this.lastBackupTime;
    }

    public List<CloudRecoveryItem> getRecoveryItems() {
        return this.recoveryItems;
    }

    public String getTerminalType() {
        return this.terminalType;
    }

    public boolean isCurrent() {
        return this.isCurrent;
    }

    public boolean isTempBackup() {
        return this.isTempBackup;
    }

    public void setBackupDeviceId(String str) {
        this.backupDeviceId = str;
    }

    public void setCurrent(boolean z10) {
        this.isCurrent = z10;
    }

    public void setDevDisplayName(String str) {
        this.devDisplayName = str;
    }

    public void setDeviceBackupSpace(long j10) {
        this.deviceBackupSpace = j10;
    }

    public void setDeviceCategory(String str) {
        this.deviceCategory = str;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setDeviceType(int i10) {
        this.deviceType = i10;
    }

    public void setLastBackupTime(long j10) {
        this.lastBackupTime = j10;
    }

    public void setRecoveryItems(List<CloudRecoveryItem> list) {
        this.recoveryItems = list;
    }

    public void setTempBackup(boolean z10) {
        this.isTempBackup = z10;
    }

    public void setTerminalType(String str) {
        this.terminalType = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.deviceType);
        parcel.writeString(this.deviceCategory);
        parcel.writeString(this.devDisplayName);
        parcel.writeString(this.deviceId);
        parcel.writeString(this.backupDeviceId);
        parcel.writeLong(this.deviceBackupSpace);
        parcel.writeBoolean(this.isCurrent);
        parcel.writeTypedList(this.recoveryItems);
        parcel.writeString(this.terminalType);
    }

    public CloudBackupDeviceInfo(CloudBackupDeviceInfo cloudBackupDeviceInfo) {
        this.deviceType = cloudBackupDeviceInfo.deviceType;
        this.deviceCategory = cloudBackupDeviceInfo.deviceCategory;
        this.devDisplayName = cloudBackupDeviceInfo.devDisplayName;
        this.deviceId = cloudBackupDeviceInfo.deviceId;
        this.backupDeviceId = cloudBackupDeviceInfo.backupDeviceId;
        this.deviceBackupSpace = cloudBackupDeviceInfo.deviceBackupSpace;
        this.isCurrent = cloudBackupDeviceInfo.isCurrent;
        this.lastBackupTime = cloudBackupDeviceInfo.lastBackupTime;
        this.recoveryItems = cloudBackupDeviceInfo.recoveryItems;
        this.isTempBackup = cloudBackupDeviceInfo.isTempBackup;
        this.terminalType = cloudBackupDeviceInfo.terminalType;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public CloudBackupDeviceInfo m85643clone() {
        try {
            CloudBackupDeviceInfo cloudBackupDeviceInfo = (CloudBackupDeviceInfo) super.clone();
            cloudBackupDeviceInfo.recoveryItems = new ArrayList(this.recoveryItems);
            return cloudBackupDeviceInfo;
        } catch (CloneNotSupportedException unused) {
            return new CloudBackupDeviceInfo();
        }
    }
}
