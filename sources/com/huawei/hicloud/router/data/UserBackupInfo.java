package com.huawei.hicloud.router.data;

import android.text.TextUtils;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import ni.C11707b;

/* loaded from: classes.dex */
public class UserBackupInfo extends C11707b {

    @InterfaceC4648p
    private boolean hasRefurbish;

    @InterfaceC4648p
    private boolean isOnlyRefurbish;

    @InterfaceC4648p
    private int retCode;

    @InterfaceC4648p
    long size;

    @InterfaceC4648p
    List<UserDeviceInfo> userBackupInfos;

    public static class UserDeviceInfo extends C11707b {

        @InterfaceC4648p
        private String backupDeviceId;

        @InterfaceC4648p
        private String bakId;

        @InterfaceC4648p
        private String devDisplayName;

        @InterfaceC4648p
        private String deviceCategory;

        @InterfaceC4648p
        private String deviceId;

        @InterfaceC4648p
        private String deviceName;

        @InterfaceC4648p
        private int deviceType;

        @InterfaceC4648p
        private ArrayList<ExtraDeviceInfo> extraDeviceInfos;

        @InterfaceC4648p
        private String gradeCode;

        @InterfaceC4648p
        private boolean hasOnlyRefurbishAndBackingUp;

        @InterfaceC4648p
        private boolean hasRefurbish;

        @InterfaceC4648p
        private boolean isCurrent;

        @InterfaceC4648p
        private boolean isOnlyRefurbish;

        @InterfaceC4648p
        private boolean isTempBackUp;

        @InterfaceC4648p
        private long lastbackupTime;

        @InterfaceC4648p
        private Integer occupySpaceType;

        @InterfaceC4648p
        private boolean onlyHarmonyNext;

        @InterfaceC4648p
        private long size;

        @InterfaceC4648p
        private boolean sizeQueryByCBS;

        @InterfaceC4648p
        private String terminalType;

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            UserDeviceInfo userDeviceInfo = (UserDeviceInfo) obj;
            return Objects.equals(this.deviceId, userDeviceInfo.deviceId) && Objects.equals(this.backupDeviceId, userDeviceInfo.backupDeviceId) && this.isCurrent == userDeviceInfo.isCurrent;
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
            return TextUtils.isEmpty(this.deviceName) ? "" : this.deviceName;
        }

        public int getDeviceType() {
            return this.deviceType;
        }

        public ArrayList<ExtraDeviceInfo> getExtraDeviceInfos() {
            return this.extraDeviceInfos;
        }

        public String getGradeCode() {
            return this.gradeCode;
        }

        public long getLastbackupTime() {
            return this.lastbackupTime;
        }

        public Integer getOccupySpaceType() {
            return this.occupySpaceType;
        }

        public long getSize() {
            return this.size;
        }

        public String getTerminalType() {
            return C4633d0.m28404a(this.terminalType) ? "" : this.terminalType;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return Objects.hash(Integer.valueOf(super.hashCode()), this.deviceName, this.deviceId, Long.valueOf(this.size), Long.valueOf(this.lastbackupTime), Boolean.valueOf(this.isCurrent), Integer.valueOf(this.deviceType), this.devDisplayName, this.deviceCategory, this.backupDeviceId);
        }

        public boolean isCurrent() {
            return this.isCurrent;
        }

        public boolean isHasOnlyRefurbishAndBackingUp() {
            return this.hasOnlyRefurbishAndBackingUp;
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

        public boolean isSizeQueryByCBS() {
            return this.sizeQueryByCBS;
        }

        public boolean isTempBackUp() {
            return this.isTempBackUp;
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

        public void setGradeCode(String str) {
            this.gradeCode = str;
        }

        public void setHasOnlyRefurbishAndBackingUp(boolean z10) {
            this.hasOnlyRefurbishAndBackingUp = z10;
        }

        public void setHasRefurbish(boolean z10) {
            this.hasRefurbish = z10;
        }

        public void setLastbackupTime(long j10) {
            this.lastbackupTime = j10;
        }

        public void setOccupySpaceType(Integer num) {
            this.occupySpaceType = num;
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

        public void setSizeQueryByCBS(boolean z10) {
            this.sizeQueryByCBS = z10;
        }

        public void setTempBackUp(boolean z10) {
            this.isTempBackUp = z10;
        }

        public void setTerminalType(String str) {
            this.terminalType = str;
        }
    }

    public int getRetCode() {
        return this.retCode;
    }

    public long getSize() {
        return this.size;
    }

    public List<UserDeviceInfo> getUserBackupInfos() {
        return this.userBackupInfos;
    }

    public void setRetCode(int i10) {
        this.retCode = i10;
    }

    public void setSize(long j10) {
        this.size = j10;
    }

    public void setUserBackupInfos(List<UserDeviceInfo> list) {
        this.userBackupInfos = list;
    }
}
