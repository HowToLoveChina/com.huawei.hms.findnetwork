package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import android.text.TextUtils;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import ni.C11707b;

/* loaded from: classes6.dex */
public class Bak extends C11707b implements Comparable<Bak> {

    @InterfaceC4648p
    private String app;

    @InterfaceC4648p
    private String appsUnbacked;

    @InterfaceC4648p
    private long attachmentsSize;

    @InterfaceC4648p
    private String backupDeviceId;

    @InterfaceC4648p
    private Integer backupStatus;

    @InterfaceC4648p
    private String backupVersion;

    @InterfaceC4648p
    private Integer bakCategory;

    @InterfaceC4648p
    private Integer bmDataType;

    @InterfaceC4648p
    private boolean canbeReserveForever;

    @InterfaceC4648p
    private String collection;

    @InterfaceC4648p
    private Integer destroyType;

    @InterfaceC4648p
    private String device;

    @InterfaceC4648p
    private C4644l endTime;

    @InterfaceC4648p
    private C4644l expirationTime;

    @InterfaceC4648p
    private int expiratoryInDays;

    @InterfaceC4648p
    private String gradeCode;

    /* renamed from: id */
    @InterfaceC4648p
    private String f22585id;

    @InterfaceC4648p
    private int incType = 1;

    @InterfaceC4648p
    private boolean isRefurbishment;

    @InterfaceC4648p
    private Integer occupySpaceType;

    @InterfaceC4648p
    private String owner;

    @InterfaceC4648p
    private Map<String, String> properties;

    @InterfaceC4648p
    private String source;

    @InterfaceC4648p
    private C4644l startTime;

    @InterfaceC4648p
    private long totalSize;

    @InterfaceC4648p
    private String unSuccessRecoverSummary;

    @InterfaceC4648p
    private String unSuccessSummary;

    @InterfaceC4648p
    private C4644l updateTime;

    @InterfaceC4648p
    private Integer version;

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && super.equals(obj)) {
            return Objects.equals(this.f22585id, ((Bak) obj).f22585id);
        }
        return false;
    }

    public String getApp() {
        return this.app;
    }

    public String getAppsUnbacked() {
        return this.appsUnbacked;
    }

    public long getAttachmentsSize() {
        return this.attachmentsSize;
    }

    public String getBackupDeviceId() {
        return this.backupDeviceId;
    }

    public Integer getBackupStatus() {
        return this.backupStatus;
    }

    public String getBackupVersion() {
        return this.backupVersion;
    }

    public Integer getBakCategory() {
        return this.bakCategory;
    }

    public Integer getBmDataType() {
        Integer num = this.bmDataType;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public String getCollection() {
        return this.collection;
    }

    public Integer getDestroyType() {
        return this.destroyType;
    }

    public String getDevice() {
        return this.device;
    }

    public C4644l getEndTime() {
        return this.endTime;
    }

    public C4644l getExpirationTime() {
        return this.expirationTime;
    }

    public int getExpiratoryInDays() {
        return this.expiratoryInDays;
    }

    public int getExpiratoryInDaysForClient() {
        int i10 = this.expiratoryInDays;
        return i10 == 0 ? i10 + 1 : i10;
    }

    public String getGradeCode() {
        return this.gradeCode;
    }

    public String getId() {
        return this.f22585id;
    }

    public int getIncType() {
        return this.incType;
    }

    public Integer getOccupySpaceType() {
        return this.occupySpaceType;
    }

    public String getOwner() {
        return this.owner;
    }

    public Map<String, String> getProperties() {
        Map<String, String> map = this.properties;
        return map == null ? new HashMap() : map;
    }

    public String getSource() {
        return this.source;
    }

    public C4644l getStartTime() {
        return this.startTime;
    }

    public long getTotalSize() {
        return this.totalSize;
    }

    public String getUnSuccessRecoverSummary() {
        return this.unSuccessRecoverSummary;
    }

    public String getUnSuccessSummary() {
        return this.unSuccessSummary;
    }

    public C4644l getUpdateTime() {
        return this.updateTime;
    }

    public Integer getVersion() {
        return this.version;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), this.f22585id);
    }

    public boolean isCanbeReserveForever() {
        return this.canbeReserveForever;
    }

    public boolean isNotOccupySpace() {
        return Objects.equals(this.occupySpaceType, 0);
    }

    public boolean isRefurbishment() {
        return this.isRefurbishment;
    }

    public boolean isTempBackup() {
        return TextUtils.equals(String.valueOf(this.bakCategory), "3");
    }

    public Bak setApp(String str) {
        this.app = str;
        return this;
    }

    public Bak setAppsUnbacked(String str) {
        this.appsUnbacked = str;
        return this;
    }

    public void setAttachmentsSize(long j10) {
        this.attachmentsSize = j10;
    }

    public Bak setBackupDeviceId(String str) {
        this.backupDeviceId = str;
        return this;
    }

    public Bak setBackupStatus(Integer num) {
        this.backupStatus = num;
        return this;
    }

    public Bak setBackupVersion(String str) {
        this.backupVersion = str;
        return this;
    }

    public void setBakCategory(Integer num) {
        this.bakCategory = num;
    }

    public void setBmDataType(Integer num) {
        this.bmDataType = num;
    }

    public void setCanbeReserveForever(boolean z10) {
        this.canbeReserveForever = z10;
    }

    public Bak setCollection(String str) {
        this.collection = str;
        return this;
    }

    public Bak setDestroyType(Integer num) {
        this.destroyType = num;
        return this;
    }

    public Bak setDevice(String str) {
        this.device = str;
        return this;
    }

    public Bak setEndTime(C4644l c4644l) {
        this.endTime = c4644l;
        return this;
    }

    public void setExpirationTime(C4644l c4644l) {
        this.expirationTime = c4644l;
    }

    public void setExpiratoryInDays(int i10) {
        this.expiratoryInDays = i10;
    }

    public void setGradeCode(String str) {
        this.gradeCode = str;
    }

    public Bak setId(String str) {
        this.f22585id = str;
        return this;
    }

    public Bak setIncType(int i10) {
        this.incType = i10;
        return this;
    }

    public void setOccupySpaceType(Integer num) {
        this.occupySpaceType = num;
    }

    public Bak setOwner(String str) {
        this.owner = str;
        return this;
    }

    public Bak setProperties(Map<String, String> map) {
        this.properties = map;
        return this;
    }

    public void setRefurbishment(boolean z10) {
        this.isRefurbishment = z10;
    }

    public Bak setSource(String str) {
        this.source = str;
        return this;
    }

    public Bak setStartTime(C4644l c4644l) {
        this.startTime = c4644l;
        return this;
    }

    public void setTotalSize(long j10) {
        this.totalSize = j10;
    }

    public Bak setUnSuccessRecoverSummary(String str) {
        this.unSuccessRecoverSummary = str;
        return this;
    }

    public Bak setUnSuccessSummary(String str) {
        this.unSuccessSummary = str;
        return this;
    }

    public Bak setUpdateTime(C4644l c4644l) {
        this.updateTime = c4644l;
        return this;
    }

    public Bak setVersion(Integer num) {
        this.version = num;
        return this;
    }

    @Override // java.lang.Comparable
    public int compareTo(Bak bak) {
        C4644l endTime = bak.getEndTime();
        C4644l endTime2 = getEndTime();
        return Long.compare(endTime == null ? 0L : endTime.m28458c(), endTime2 != null ? endTime2.m28458c() : 0L);
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public Bak set(String str, Object obj) {
        return (Bak) super.set(str, obj);
    }
}
