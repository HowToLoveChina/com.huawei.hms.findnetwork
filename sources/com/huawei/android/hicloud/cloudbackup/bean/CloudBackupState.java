package com.huawei.android.hicloud.cloudbackup.bean;

import android.text.TextUtils;
import java.util.Objects;
import p015ak.C0241z;

/* loaded from: classes2.dex */
public class CloudBackupState {
    private int count;
    private int current;
    private String currentMoudle;
    private String displayModule;

    /* renamed from: id */
    private int f11655id;
    private long lastSuccessTime;
    private int moduleProgress;
    private long nextStartTime;
    private long prepareSize;
    private float progress;
    private int returnCode;
    private long startTime;
    private int uid;
    private long updateTime;
    private String version;
    private long waitBackupSize;
    private Integer state = null;
    private String spacialStatus = String.valueOf(0);
    private int isNextShow = 0;
    private String deviceName = "";
    private String statusInPrepare = "";

    public CloudBackupState copy() {
        CloudBackupState cloudBackupState = new CloudBackupState();
        cloudBackupState.setId(this.f11655id);
        cloudBackupState.setState(this.state.intValue());
        cloudBackupState.setLastSuccessTime(this.lastSuccessTime);
        cloudBackupState.setNextStartTime(this.nextStartTime);
        cloudBackupState.setProgress(this.progress);
        String str = this.currentMoudle;
        cloudBackupState.setCurrentMoudle(str != null ? new String(str) : null);
        String str2 = this.displayModule;
        cloudBackupState.setDisplayModule(str2 != null ? new String(str2) : null);
        cloudBackupState.setReturnCode(this.returnCode);
        String str3 = this.version;
        cloudBackupState.setVersion(str3 != null ? new String(str3) : null);
        cloudBackupState.setWaitBackupSize(this.waitBackupSize);
        cloudBackupState.setPrepareSize(this.prepareSize);
        cloudBackupState.setModuleProgress(this.moduleProgress);
        cloudBackupState.setCurrent(this.current);
        cloudBackupState.setCount(this.count);
        cloudBackupState.setStartTime(this.startTime);
        cloudBackupState.setUpdateTime(this.updateTime);
        cloudBackupState.setUid(this.uid);
        String str4 = this.spacialStatus;
        cloudBackupState.setSpacialStatus(str4 != null ? new String(str4) : null);
        cloudBackupState.setIsNextShow(this.isNextShow);
        String str5 = this.deviceName;
        cloudBackupState.setDeviceName(str5 != null ? new String(str5) : null);
        String str6 = this.statusInPrepare;
        cloudBackupState.setStatusInPrepare(str6 != null ? new String(str6) : null);
        return cloudBackupState;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CloudBackupState)) {
            return false;
        }
        CloudBackupState cloudBackupState = (CloudBackupState) obj;
        if (this.f11655id == cloudBackupState.f11655id && this.lastSuccessTime == cloudBackupState.lastSuccessTime && this.nextStartTime == cloudBackupState.nextStartTime && Float.compare(cloudBackupState.progress, this.progress) == 0 && this.returnCode == cloudBackupState.returnCode && this.waitBackupSize == cloudBackupState.waitBackupSize && this.prepareSize == cloudBackupState.prepareSize && this.moduleProgress == cloudBackupState.moduleProgress && this.current == cloudBackupState.current && this.count == cloudBackupState.count && this.startTime == cloudBackupState.startTime && this.updateTime == cloudBackupState.updateTime && this.uid == cloudBackupState.uid && this.isNextShow == cloudBackupState.isNextShow && Objects.equals(this.state, cloudBackupState.state) && Objects.equals(this.currentMoudle, cloudBackupState.currentMoudle) && Objects.equals(this.displayModule, cloudBackupState.displayModule) && Objects.equals(this.version, cloudBackupState.version) && Objects.equals(this.deviceName, cloudBackupState.deviceName) && Objects.equals(this.statusInPrepare, cloudBackupState.statusInPrepare)) {
            return Objects.equals(this.spacialStatus, cloudBackupState.spacialStatus);
        }
        return false;
    }

    public int getCount() {
        return this.count;
    }

    public int getCurrent() {
        return this.current;
    }

    public String getCurrentMoudle() {
        return this.currentMoudle;
    }

    public String getDeviceName() {
        return TextUtils.isEmpty(this.deviceName) ? "" : this.deviceName;
    }

    public String getDisplayModule() {
        return TextUtils.isEmpty(this.displayModule) ? "" : this.displayModule;
    }

    public int getId() {
        return this.f11655id;
    }

    public int getIntProgress() {
        return (int) this.progress;
    }

    public int getIsNextShow() {
        return this.isNextShow;
    }

    public long getLastSuccessTime() {
        return this.lastSuccessTime;
    }

    public int getModuleProgress() {
        return this.moduleProgress;
    }

    public long getNextStartTime() {
        return this.nextStartTime;
    }

    public long getPrepareSize() {
        return this.prepareSize;
    }

    public float getProgress() {
        return this.progress;
    }

    public int getReturnCode() {
        return this.returnCode;
    }

    public String getSpacialStatus() {
        return this.spacialStatus;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public Integer getState() {
        return this.state;
    }

    public String getStatusInPrepare() {
        return this.statusInPrepare;
    }

    public int getUid() {
        return this.uid;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public String getVersion() {
        return this.version;
    }

    public long getWaitBackupSize() {
        return this.waitBackupSize;
    }

    public int hashCode() {
        int i10 = this.f11655id * 31;
        Integer num = this.state;
        int iHashCode = num != null ? num.hashCode() : 0;
        long j10 = this.lastSuccessTime;
        int i11 = (((i10 + iHashCode) * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        long j11 = this.nextStartTime;
        int i12 = (i11 + ((int) (j11 ^ (j11 >>> 32)))) * 31;
        float f10 = this.progress;
        int iFloatToIntBits = (i12 + (f10 != 0.0f ? Float.floatToIntBits(f10) : 0)) * 31;
        String str = this.currentMoudle;
        int iHashCode2 = (iFloatToIntBits + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.displayModule;
        int iHashCode3 = (((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.returnCode) * 31;
        String str3 = this.version;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        long j12 = this.waitBackupSize;
        int i13 = (iHashCode4 + ((int) (j12 ^ (j12 >>> 32)))) * 31;
        long j13 = this.prepareSize;
        int i14 = (((((((i13 + ((int) (j13 ^ (j13 >>> 32)))) * 31) + this.moduleProgress) * 31) + this.current) * 31) + this.count) * 31;
        long j14 = this.startTime;
        int i15 = (i14 + ((int) (j14 ^ (j14 >>> 32)))) * 31;
        long j15 = this.updateTime;
        int i16 = (((i15 + ((int) (j15 ^ (j15 >>> 32)))) * 31) + this.uid) * 31;
        String str4 = this.spacialStatus;
        int iHashCode5 = (((i16 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.isNextShow) * 31;
        String str5 = this.deviceName;
        int iHashCode6 = (iHashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.statusInPrepare;
        return iHashCode6 + (str6 != null ? str6.hashCode() : 0);
    }

    public boolean isCloudSpaceNotEnoughDismiss() {
        return 4096 == (C0241z.m1685c(this.spacialStatus) & 4096);
    }

    public boolean isLocalSpaceNotEnoughChange() {
        return 256 == (C0241z.m1685c(this.spacialStatus) & 256);
    }

    public boolean isOverDayErrTipDismiss() {
        return 16 == (C0241z.m1685c(this.spacialStatus) & 16);
    }

    public void setCount(int i10) {
        this.count = i10;
    }

    public void setCurrent(int i10) {
        this.current = i10;
    }

    public void setCurrentMoudle(String str) {
        this.currentMoudle = str;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setDisplayModule(String str) {
        this.displayModule = str;
    }

    public void setFlag(int i10) {
        this.spacialStatus = String.valueOf(i10 | C0241z.m1685c(this.spacialStatus));
    }

    public void setId(int i10) {
        this.f11655id = i10;
    }

    public void setIsNextShow(int i10) {
        this.isNextShow = i10;
    }

    public void setLastSuccessTime(long j10) {
        this.lastSuccessTime = j10;
    }

    public void setModuleProgress(int i10) {
        this.moduleProgress = i10;
    }

    public void setNextStartTime(long j10) {
        this.nextStartTime = j10;
    }

    public void setPrepareSize(long j10) {
        this.prepareSize = j10;
    }

    public void setProgress(float f10) {
        this.progress = f10;
    }

    public void setReturnCode(int i10) {
        this.returnCode = i10;
    }

    public void setSpacialStatus(String str) {
        this.spacialStatus = str;
    }

    public void setStartTime(long j10) {
        this.startTime = j10;
    }

    public void setState(int i10) {
        this.state = Integer.valueOf(i10);
    }

    public void setStatusInPrepare(String str) {
        this.statusInPrepare = str;
    }

    public void setUid(int i10) {
        this.uid = i10;
    }

    public void setUpdateTime(long j10) {
        this.updateTime = j10;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public void setWaitBackupSize(long j10) {
        this.waitBackupSize = j10;
    }

    public String toString() {
        return "CloudBackupState{id=" + this.f11655id + ", state=" + this.state + ", lastSuccessTime=" + this.lastSuccessTime + ", nextStartTime=" + this.nextStartTime + ", progress=" + this.progress + ", currentMoudle='" + this.currentMoudle + "', displayModule='" + this.displayModule + ", returnCode=" + this.returnCode + ", version='" + this.version + "', waitBackupSize=" + this.waitBackupSize + ", prepareSize=" + this.prepareSize + ", moduleProgress=" + this.moduleProgress + ", updateTime=" + this.updateTime + ", spacialStatus=" + this.spacialStatus + ", startTime=" + this.startTime + ", current=" + this.current + ", count=" + this.count + ", deviceName=" + this.deviceName + ", uid=" + this.uid + '}';
    }
}
