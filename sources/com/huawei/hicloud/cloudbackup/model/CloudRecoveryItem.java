package com.huawei.hicloud.cloudbackup.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.android.hicloud.cbs.bean.CBRecoveryItemBase;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class CloudRecoveryItem implements Comparable<CloudRecoveryItem>, Parcelable, CBRecoveryItemBase {
    public static final Parcelable.Creator<CloudRecoveryItem> CREATOR = new C4863a();
    private static final int INCOMPATIBILITY = 0;
    private String backupDeviceId;
    private String backupId;
    private int backupRecordLabel;
    private int bmDataType;
    private String devDisplayName;
    private String deviceCategory;
    private String deviceId;
    private String deviceName;
    private int deviceType;
    private long endTime;
    private int index;
    private boolean isBackupCompleted;
    private boolean isCurrent;
    private boolean isNewBmRecord;
    private boolean isRefurbishment;
    private boolean isTempBackup;
    private List<CloudRestoreItem> itemList;
    private int moduleCompatibility;
    private int occupySpaceType;
    private String recordDeviceId;
    private long size;
    private long startTime;
    private String terminalType;
    private String version;
    private boolean isRomCompatible = true;
    private int expiratoryInDays = 0;

    /* renamed from: com.huawei.hicloud.cloudbackup.model.CloudRecoveryItem$a */
    public class C4863a implements Parcelable.Creator<CloudRecoveryItem> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CloudRecoveryItem createFromParcel(Parcel parcel) {
            CloudRecoveryItem cloudRecoveryItem = new CloudRecoveryItem();
            cloudRecoveryItem.deviceName = parcel.readString();
            cloudRecoveryItem.deviceType = parcel.readInt();
            cloudRecoveryItem.index = parcel.readInt();
            cloudRecoveryItem.deviceCategory = parcel.readString();
            cloudRecoveryItem.terminalType = parcel.readString();
            cloudRecoveryItem.deviceId = parcel.readString();
            cloudRecoveryItem.backupId = parcel.readString();
            cloudRecoveryItem.size = parcel.readLong();
            cloudRecoveryItem.endTime = parcel.readLong();
            cloudRecoveryItem.startTime = parcel.readLong();
            cloudRecoveryItem.devDisplayName = parcel.readString();
            cloudRecoveryItem.isCurrent = parcel.readByte() != 0;
            cloudRecoveryItem.itemList = new ArrayList();
            parcel.readList(cloudRecoveryItem.itemList, getClass().getClassLoader());
            cloudRecoveryItem.isRomCompatible = parcel.readBoolean();
            cloudRecoveryItem.isRefurbishment = parcel.readByte() != 0;
            cloudRecoveryItem.isBackupCompleted = parcel.readBoolean();
            cloudRecoveryItem.backupRecordLabel = parcel.readInt();
            cloudRecoveryItem.isNewBmRecord = parcel.readByte() != 0;
            cloudRecoveryItem.isTempBackup = parcel.readByte() != 0;
            cloudRecoveryItem.occupySpaceType = parcel.readInt();
            cloudRecoveryItem.expiratoryInDays = parcel.readInt();
            cloudRecoveryItem.moduleCompatibility = parcel.readInt();
            cloudRecoveryItem.bmDataType = parcel.readInt();
            return cloudRecoveryItem;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CloudRecoveryItem[] newArray(int i10) {
            return new CloudRecoveryItem[i10];
        }
    }

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
        CloudRecoveryItem cloudRecoveryItem = (CloudRecoveryItem) obj;
        String str = this.backupId;
        if (str == null) {
            if (cloudRecoveryItem.backupId != null) {
                return false;
            }
        } else if (!str.equals(cloudRecoveryItem.backupId)) {
            return false;
        }
        return this.endTime == cloudRecoveryItem.endTime;
    }

    public String getBackupDeviceId() {
        return this.backupDeviceId;
    }

    @Override // com.huawei.android.hicloud.cbs.bean.CBRecoveryItemBase
    public long getBackupEndTime() {
        return this.endTime;
    }

    @Override // com.huawei.android.hicloud.cbs.bean.CBRecoveryItemBase
    public String getBackupId() {
        return this.backupId;
    }

    public int getBackupRecordLabel() {
        return this.backupRecordLabel;
    }

    public int getBmDataType() {
        return this.bmDataType;
    }

    @Override // com.huawei.android.hicloud.cbs.bean.CBRecoveryItemBase
    public String getDevDisplayName() {
        return this.devDisplayName;
    }

    public String getDeviceCategory() {
        return this.deviceCategory;
    }

    @Override // com.huawei.android.hicloud.cbs.bean.CBRecoveryItemBase
    public String getDeviceIdd() {
        return this.deviceId;
    }

    @Override // com.huawei.android.hicloud.cbs.bean.CBRecoveryItemBase
    public String getDeviceName() {
        return this.deviceName;
    }

    @Override // com.huawei.android.hicloud.cbs.bean.CBRecoveryItemBase
    public int getDeviceType() {
        return this.deviceType;
    }

    public int getExpiratoryInDays() {
        return this.expiratoryInDays;
    }

    public int getIndex() {
        return this.index;
    }

    public List<CloudRestoreItem> getItemList() {
        return this.itemList;
    }

    public int getModuleCompatibility() {
        return this.moduleCompatibility;
    }

    public int getOccupySpaceType() {
        return this.occupySpaceType;
    }

    public String getRecordDeviceId() {
        return this.recordDeviceId;
    }

    @Override // com.huawei.android.hicloud.cbs.bean.CBRecoveryItemBase
    public long getSize() {
        return this.size;
    }

    public long getStartTime() {
        return this.startTime;
    }

    @Override // com.huawei.android.hicloud.cbs.bean.CBRecoveryItemBase
    public String getTerminalType() {
        return this.terminalType;
    }

    public String getVersion() {
        return this.version;
    }

    public int hashCode() {
        String str = this.backupId;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j10 = this.endTime;
        return ((iHashCode + 31) * 31) + ((int) (j10 ^ (j10 >>> 32)));
    }

    public boolean isBackupCompleted() {
        return this.isBackupCompleted;
    }

    @Override // com.huawei.android.hicloud.cbs.bean.CBRecoveryItemBase
    public boolean isCurrent() {
        return this.isCurrent;
    }

    public boolean isIncompatible() {
        return this.moduleCompatibility == 0;
    }

    public boolean isNewBmRecord() {
        return this.isNewBmRecord;
    }

    public boolean isRefurbishment() {
        return this.isRefurbishment;
    }

    public boolean isRomCompatible() {
        return this.isRomCompatible;
    }

    public boolean isTempBackup() {
        return this.isTempBackup;
    }

    public void setBackupCompleted(boolean z10) {
        this.isBackupCompleted = z10;
    }

    public void setBackupDeviceId(String str) {
        this.backupDeviceId = str;
    }

    @Override // com.huawei.android.hicloud.cbs.bean.CBRecoveryItemBase
    public void setBackupEndTime(long j10) {
        this.endTime = j10;
    }

    @Override // com.huawei.android.hicloud.cbs.bean.CBRecoveryItemBase
    public void setBackupId(String str) {
        this.backupId = str;
    }

    public void setBackupRecordLabel(int i10) {
        this.backupRecordLabel = i10;
    }

    public void setBmDataType(int i10) {
        this.bmDataType = i10;
    }

    @Override // com.huawei.android.hicloud.cbs.bean.CBRecoveryItemBase
    public void setCurrent(boolean z10) {
        this.isCurrent = z10;
    }

    @Override // com.huawei.android.hicloud.cbs.bean.CBRecoveryItemBase
    public void setDevDisplayName(String str) {
        this.devDisplayName = str;
    }

    public void setDeviceCategory(String str) {
        this.deviceCategory = str;
    }

    @Override // com.huawei.android.hicloud.cbs.bean.CBRecoveryItemBase
    public void setDeviceIdd(String str) {
        this.deviceId = str;
    }

    @Override // com.huawei.android.hicloud.cbs.bean.CBRecoveryItemBase
    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    @Override // com.huawei.android.hicloud.cbs.bean.CBRecoveryItemBase
    public void setDeviceType(int i10) {
        this.deviceType = i10;
    }

    public void setExpiratoryInDays(int i10) {
        this.expiratoryInDays = i10;
    }

    public void setIndex(int i10) {
        this.index = i10;
    }

    public void setItemList(List<CloudRestoreItem> list) {
        this.itemList = list;
    }

    public void setModuleCompatibility(int i10) {
        this.moduleCompatibility = i10;
    }

    public void setNewBmRecord(boolean z10) {
        this.isNewBmRecord = z10;
    }

    public void setOccupySpaceType(int i10) {
        this.occupySpaceType = i10;
    }

    public void setRecordDeviceId(String str) {
        this.recordDeviceId = str;
    }

    public void setRefurbishment(boolean z10) {
        this.isRefurbishment = z10;
    }

    public void setRomCompatible(boolean z10) {
        this.isRomCompatible = z10;
    }

    @Override // com.huawei.android.hicloud.cbs.bean.CBRecoveryItemBase
    public void setSize(long j10) {
        this.size = j10;
    }

    public void setStartTime(long j10) {
        this.startTime = j10;
    }

    public void setTempBackup(boolean z10) {
        this.isTempBackup = z10;
    }

    @Override // com.huawei.android.hicloud.cbs.bean.CBRecoveryItemBase
    public void setTerminalType(String str) {
        this.terminalType = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.deviceName);
        parcel.writeInt(this.deviceType);
        parcel.writeInt(this.index);
        parcel.writeString(this.deviceCategory);
        parcel.writeString(this.terminalType);
        parcel.writeString(this.deviceId);
        parcel.writeString(this.backupId);
        parcel.writeLong(this.size);
        parcel.writeLong(this.endTime);
        parcel.writeLong(this.startTime);
        parcel.writeString(this.devDisplayName);
        parcel.writeByte(this.isCurrent ? (byte) 1 : (byte) 0);
        parcel.writeList(this.itemList);
        parcel.writeBoolean(this.isRomCompatible);
        parcel.writeByte(this.isRefurbishment ? (byte) 1 : (byte) 0);
        parcel.writeBoolean(this.isBackupCompleted);
        parcel.writeInt(this.backupRecordLabel);
        parcel.writeByte(this.isNewBmRecord ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isTempBackup ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.occupySpaceType);
        parcel.writeInt(this.expiratoryInDays);
        parcel.writeInt(this.moduleCompatibility);
        parcel.writeInt(this.bmDataType);
    }

    @Override // java.lang.Comparable
    public int compareTo(CloudRecoveryItem cloudRecoveryItem) {
        boolean z10 = cloudRecoveryItem.isBackupCompleted;
        if (!z10 && this.isBackupCompleted) {
            return Long.compare(cloudRecoveryItem.startTime, this.endTime);
        }
        boolean z11 = this.isBackupCompleted;
        if (!z11 && z10) {
            return Long.compare(cloudRecoveryItem.endTime, this.startTime);
        }
        if (!z11 && !z10) {
            return Long.compare(cloudRecoveryItem.startTime, this.startTime);
        }
        if (z11 && z10) {
            return Long.compare(cloudRecoveryItem.endTime, this.endTime);
        }
        return 0;
    }
}
