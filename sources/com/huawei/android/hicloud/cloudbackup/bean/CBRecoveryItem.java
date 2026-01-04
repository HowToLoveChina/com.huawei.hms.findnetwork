package com.huawei.android.hicloud.cloudbackup.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.android.hicloud.cbs.bean.CBRecoveryItemBase;
import com.huawei.android.hicloud.cloudbackup.model.RestoreItem;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class CBRecoveryItem implements Comparable<CBRecoveryItem>, Parcelable, CBRecoveryItemBase {
    public static final Parcelable.Creator<CBRecoveryItem> CREATOR = new Parcelable.Creator<CBRecoveryItem>() { // from class: com.huawei.android.hicloud.cloudbackup.bean.CBRecoveryItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CBRecoveryItem createFromParcel(Parcel parcel) {
            CBRecoveryItem cBRecoveryItem = new CBRecoveryItem();
            cBRecoveryItem.deviceName = parcel.readString();
            cBRecoveryItem.deviceType = parcel.readInt();
            cBRecoveryItem.index = parcel.readInt();
            cBRecoveryItem.deviceCategory = parcel.readString();
            cBRecoveryItem.terminalType = parcel.readString();
            cBRecoveryItem.deviceId = parcel.readString();
            cBRecoveryItem.backupId = parcel.readString();
            cBRecoveryItem.size = parcel.readLong();
            cBRecoveryItem.endTime = parcel.readLong();
            cBRecoveryItem.startTime = parcel.readLong();
            cBRecoveryItem.devDisplayName = parcel.readString();
            cBRecoveryItem.isCurrent = parcel.readByte() != 0;
            cBRecoveryItem.itemList = new ArrayList();
            parcel.readList(cBRecoveryItem.itemList, getClass().getClassLoader());
            return cBRecoveryItem;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CBRecoveryItem[] newArray(int i10) {
            return new CBRecoveryItem[i10];
        }
    };
    private String backupDeviceId;
    private String backupId;
    private String devDisplayName;
    private String deviceCategory;
    private String deviceId;
    private String deviceName;
    private int deviceType;
    private long endTime;
    private int index;
    private boolean isCurrent;
    private List<RestoreItem> itemList;
    private String recordDeviceId;
    private long size;
    private long startTime;
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
        CBRecoveryItem cBRecoveryItem = (CBRecoveryItem) obj;
        String str = this.backupId;
        if (str == null) {
            if (cBRecoveryItem.backupId != null) {
                return false;
            }
        } else if (!str.equals(cBRecoveryItem.backupId)) {
            return false;
        }
        return this.endTime == cBRecoveryItem.endTime;
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

    public int getIndex() {
        return this.index;
    }

    public List<RestoreItem> getItemList() {
        return this.itemList;
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

    public int hashCode() {
        String str = this.backupId;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j10 = this.endTime;
        return ((iHashCode + 31) * 31) + ((int) (j10 ^ (j10 >>> 32)));
    }

    @Override // com.huawei.android.hicloud.cbs.bean.CBRecoveryItemBase
    public boolean isCurrent() {
        return this.isCurrent;
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

    public void setIndex(int i10) {
        this.index = i10;
    }

    public void setItemList(List<RestoreItem> list) {
        this.itemList = list;
    }

    public void setRecordDeviceId(String str) {
        this.recordDeviceId = str;
    }

    @Override // com.huawei.android.hicloud.cbs.bean.CBRecoveryItemBase
    public void setSize(long j10) {
        this.size = j10;
    }

    public void setStartTime(long j10) {
        this.startTime = j10;
    }

    @Override // com.huawei.android.hicloud.cbs.bean.CBRecoveryItemBase
    public void setTerminalType(String str) {
        this.terminalType = str;
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
    }

    @Override // java.lang.Comparable
    public int compareTo(CBRecoveryItem cBRecoveryItem) {
        return Long.compare(cBRecoveryItem.endTime, this.endTime);
    }
}
