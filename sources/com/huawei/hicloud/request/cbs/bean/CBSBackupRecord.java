package com.huawei.hicloud.request.cbs.bean;

import android.text.TextUtils;
import java.util.List;

/* loaded from: classes6.dex */
public class CBSBackupRecord {
    public static final String CURRENT_API_VERSION = "V2";
    private List<CBSAppInfo> appIdInfos;
    private String backupDeviceId;
    private String backupId;
    private Integer bakCategory;
    private int bmDataType;
    private boolean canBeReserveForever;
    private CBSDevice device;
    private long endTime;
    private int expiratoryInDays;
    private String extend;
    private String gradeCode;
    private boolean isRefurbishment;
    private Integer occupySpaceType;
    private String snapshot;
    private long startTime;
    private int status;
    private Long totalSize;
    private String version;

    public List<CBSAppInfo> getAppIdInfos() {
        return this.appIdInfos;
    }

    public String getBackupDeviceId() {
        return this.backupDeviceId;
    }

    public String getBackupId() {
        return this.backupId;
    }

    public Integer getBakCategory() {
        return this.bakCategory;
    }

    public int getBmDataType() {
        return this.bmDataType;
    }

    public CBSDevice getDevice() {
        return this.device;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public int getExpiratoryInDays() {
        return this.expiratoryInDays;
    }

    public String getExtend() {
        return this.extend;
    }

    public String getGradeCode() {
        return this.gradeCode;
    }

    public long getLastNotifyTime() {
        return getEndTime();
    }

    public Integer getOccupySpaceType() {
        return this.occupySpaceType;
    }

    public String getSnapshot() {
        return this.snapshot;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public int getStatus() {
        return this.status;
    }

    public Long getTotalSize() {
        return this.totalSize;
    }

    public String getVersion() {
        return this.version;
    }

    public boolean isCanBeReserveForever() {
        return this.canBeReserveForever;
    }

    public boolean isRefurbishment() {
        return this.isRefurbishment;
    }

    public boolean isSupportSnapshot() {
        return "V2".equalsIgnoreCase(this.version) || !TextUtils.isEmpty(this.snapshot);
    }

    public void setAppIdInfos(List<CBSAppInfo> list) {
        this.appIdInfos = list;
    }

    public void setBackupDeviceId(String str) {
        this.backupDeviceId = str;
    }

    public void setBackupId(String str) {
        this.backupId = str;
    }

    public void setBakCategory(Integer num) {
        this.bakCategory = num;
    }

    public void setBmDataType(int i10) {
        this.bmDataType = i10;
    }

    public void setCanBeReserveForever(boolean z10) {
        this.canBeReserveForever = z10;
    }

    public void setDevice(CBSDevice cBSDevice) {
        this.device = cBSDevice;
    }

    public void setEndTime(long j10) {
        this.endTime = j10;
    }

    public void setExpiratoryInDays(int i10) {
        this.expiratoryInDays = i10;
    }

    public void setExtend(String str) {
        this.extend = str;
    }

    public void setGradeCode(String str) {
        this.gradeCode = str;
    }

    public void setOccupySpaceType(Integer num) {
        this.occupySpaceType = num;
    }

    public void setRefurbishment(boolean z10) {
        this.isRefurbishment = z10;
    }

    public void setSnapshot(String str) {
        this.snapshot = str;
    }

    public void setStartTime(long j10) {
        this.startTime = j10;
    }

    public void setStatus(int i10) {
        this.status = i10;
    }

    public void setTotalSize(Long l10) {
        this.totalSize = l10;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String[] splitExtend(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? new String[0] : str.split(str2);
    }
}
