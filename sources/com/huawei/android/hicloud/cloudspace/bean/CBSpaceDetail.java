package com.huawei.android.hicloud.cloudspace.bean;

import com.huawei.hicloud.router.data.ExtraDeviceInfo;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class CBSpaceDetail implements Comparable<CBSpaceDetail> {
    private String backupDeviceId;
    private String bakId;
    private String devDisplayName;
    private String deviceCategory;
    private String deviceId;
    private String deviceName;
    private int deviceType;
    private ArrayList<ExtraDeviceInfo> extraDeviceInfos;
    private boolean hasRefurbish;
    private boolean isCurrent;
    private boolean isOnlyRefurbish;
    private boolean isTempBackup;
    private long lastbackupTime;
    private boolean onlyHarmonyNext;
    private long size;
    private String terminalType;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CBSpaceDetail cBSpaceDetail = (CBSpaceDetail) obj;
        String str = this.deviceId;
        if (str == null) {
            if (cBSpaceDetail.deviceId != null) {
                return false;
            }
        } else if (!str.equals(cBSpaceDetail.deviceId)) {
            return false;
        }
        String str2 = this.backupDeviceId;
        if (str2 == null) {
            if (cBSpaceDetail.backupDeviceId != null) {
                return false;
            }
        } else if (!str2.equals(cBSpaceDetail.backupDeviceId)) {
            return false;
        }
        return this.isCurrent == cBSpaceDetail.isCurrent && this.isTempBackup == cBSpaceDetail.isTempBackup;
    }

    public String getBackupDeviceId() {
        return this.backupDeviceId;
    }

    public String getBakId() {
        return this.bakId;
    }

    public String getDevDisplayName() {
        return this.devDisplayName;
    }

    public String getDeviceCategory() {
        return this.deviceCategory;
    }

    public String getDeviceID() {
        return this.deviceId;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public ArrayList<ExtraDeviceInfo> getExtraDeviceInfos() {
        return this.extraDeviceInfos;
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
        String str = this.deviceId;
        int iHashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.deviceName;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        int i10 = this.isCurrent ? 1231 : 1237;
        long j10 = this.lastbackupTime;
        long j11 = this.size;
        return ((((iHashCode2 + i10) * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31) + ((int) (j11 ^ (j11 >>> 32)));
    }

    public boolean isCurrent() {
        return this.isCurrent;
    }

    public boolean isHasRefurbish() {
        return this.hasRefurbish;
    }

    public boolean isOnlyHarmonyNext() {
        return this.onlyHarmonyNext;
    }

    public boolean isOnlyRefurbish() {
        return this.isOnlyRefurbish;
    }

    public boolean isTempBackup() {
        return this.isTempBackup;
    }

    public void setBackupDeviceId(String str) {
        this.backupDeviceId = str;
    }

    public void setBakId(String str) {
        this.bakId = str;
    }

    public void setCurrent(boolean z10) {
        this.isCurrent = z10;
    }

    public void setDevDisplayName(String str) {
        this.devDisplayName = str;
    }

    public void setDeviceCategory(String str) {
        this.deviceCategory = str;
    }

    public void setDeviceID(String str) {
        this.deviceId = str;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setDeviceType(int i10) {
        this.deviceType = i10;
    }

    public void setExtraDeviceInfos(ArrayList<ExtraDeviceInfo> arrayList) {
        this.extraDeviceInfos = arrayList;
    }

    public void setHasRefurbish(boolean z10) {
        this.hasRefurbish = z10;
    }

    public void setLastbackupTime(long j10) {
        this.lastbackupTime = j10;
    }

    public void setOnlyHarmonyNext(boolean z10) {
        this.onlyHarmonyNext = z10;
    }

    public void setOnlyRefurbish(boolean z10) {
        this.isOnlyRefurbish = z10;
    }

    public void setSize(long j10) {
        this.size = j10;
    }

    public void setTempBackup(boolean z10) {
        this.isTempBackup = z10;
    }

    public void setTerminalType(String str) {
        this.terminalType = str;
    }

    @Override // java.lang.Comparable
    public int compareTo(CBSpaceDetail cBSpaceDetail) {
        long j10 = this.lastbackupTime;
        if (j10 == 0 && cBSpaceDetail.lastbackupTime == 0) {
            if (getSize() - cBSpaceDetail.getSize() > 0) {
                return -1;
            }
            return getSize() - cBSpaceDetail.getSize() < 0 ? 1 : 0;
        }
        long j11 = cBSpaceDetail.lastbackupTime;
        if (j10 > j11) {
            return -1;
        }
        return j10 < j11 ? 1 : 0;
    }
}
