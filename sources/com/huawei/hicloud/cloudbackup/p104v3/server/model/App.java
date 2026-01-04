package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes6.dex */
public class App extends C11707b {

    @InterfaceC4648p
    private Integer apkDataStatus;

    @InterfaceC4648p
    private Integer apkType;

    @InterfaceC4648p
    private String app;

    @InterfaceC4648p
    private Long appTotalSize;

    @InterfaceC4648p
    private List<Attachment> attachments;

    @InterfaceC4648p
    private Long attachmentsSize;

    @InterfaceC4648p
    private String backupAppName;

    @InterfaceC4648p
    private String backupAppNameHash;

    @InterfaceC4648p
    private Integer backupAppStatus;

    @InterfaceC4648p
    private String backupDeviceId;

    @InterfaceC4648p
    private String backupRecordId;

    @InterfaceC4648p
    private String backupVersion;

    @InterfaceC4648p
    private int bmAppDataType;

    @InterfaceC4648p
    private String collection;

    @InterfaceC4648p
    private C4644l createTime;

    @InterfaceC4648p
    private String device;

    @InterfaceC4648p
    private C4644l endTime;

    @InterfaceC4648p
    private Integer fileCount;

    @InterfaceC4648p
    private Integer iconDataStatus;

    @InterfaceC4648p
    private String iconFileName;

    /* renamed from: id */
    @InterfaceC4648p
    private String f22582id;

    @InterfaceC4648p
    private C4644l lifeEndTime;

    @InterfaceC4648p
    private String oriBackupAppName;

    @InterfaceC4648p
    private String owner;

    @InterfaceC4648p
    private String packageFileName;

    @InterfaceC4648p
    private String packageVersion;

    @InterfaceC4648p
    private Map<String, String> properties;

    @InterfaceC4648p
    private Boolean reuseFileCheck;

    @InterfaceC4648p
    private Integer runtimeType;

    @InterfaceC4648p
    private String source;

    @InterfaceC4648p
    private String splitApkType;

    @InterfaceC4648p
    private String splitApkVersion;

    @InterfaceC4648p
    private C4644l updateTime;

    @InterfaceC4648p
    private Integer version;

    public Integer getApkDataStatus() {
        return this.apkDataStatus;
    }

    public Integer getApkType() {
        return this.apkType;
    }

    public String getApp() {
        return this.app;
    }

    public String getAppIdByAppInfo() {
        return getBackupAppName();
    }

    public Long getAppTotalSize() {
        return this.appTotalSize;
    }

    public List<Attachment> getAttachments() {
        List<Attachment> list = this.attachments;
        return list == null ? new ArrayList() : list;
    }

    public Long getAttachmentsSize() {
        return this.attachmentsSize;
    }

    public String getBackupAppName() {
        return this.backupAppName;
    }

    public String getBackupAppNameHash() {
        return this.backupAppNameHash;
    }

    public Integer getBackupAppStatus() {
        return this.backupAppStatus;
    }

    public String getBackupDeviceId() {
        return this.backupDeviceId;
    }

    public String getBackupRecordId() {
        return this.backupRecordId;
    }

    public String getBackupVersion() {
        return this.backupVersion;
    }

    public int getBmAppDataType() {
        return this.bmAppDataType;
    }

    public String getCollection() {
        return this.collection;
    }

    public C4644l getCreateTime() {
        return this.createTime;
    }

    public String getDevice() {
        return this.device;
    }

    public C4644l getEndTime() {
        return this.endTime;
    }

    public Integer getFileCount() {
        return this.fileCount;
    }

    public Integer getIconDataStatus() {
        return this.iconDataStatus;
    }

    public String getIconFileName() {
        return this.iconFileName;
    }

    public String getId() {
        return this.f22582id;
    }

    public C4644l getLifeEndTime() {
        return this.lifeEndTime;
    }

    public String getOriBackupAppName() {
        return this.oriBackupAppName;
    }

    public String getOwner() {
        return this.owner;
    }

    public String getPackageFileName() {
        return this.packageFileName;
    }

    public String getPackageVersion() {
        return this.packageVersion;
    }

    public Map<String, String> getProperties() {
        Map<String, String> map = this.properties;
        return map == null ? new HashMap() : map;
    }

    public Integer getRuntimeType() {
        Integer num = this.runtimeType;
        if (num == null) {
            return 0;
        }
        return num;
    }

    public String getSource() {
        return this.source;
    }

    public String getSplitApkType() {
        return this.splitApkType;
    }

    public String getSplitApkVersion() {
        return this.splitApkVersion;
    }

    public C4644l getUpdateTime() {
        return this.updateTime;
    }

    public Integer getVersion() {
        return this.version;
    }

    public boolean isReuseFileCheck() {
        return Boolean.TRUE.equals(this.reuseFileCheck);
    }

    public App setApkDataStatus(Integer num) {
        this.apkDataStatus = num;
        return this;
    }

    public App setApkType(Integer num) {
        this.apkType = num;
        return this;
    }

    public App setApp(String str) {
        this.app = str;
        return this;
    }

    public App setAppTotalSize(Long l10) {
        this.appTotalSize = l10;
        return this;
    }

    public App setAttachments(List<Attachment> list) {
        this.attachments = list;
        return this;
    }

    public void setAttachmentsSize(Long l10) {
        this.attachmentsSize = l10;
    }

    public App setBackupAppName(String str) {
        this.backupAppName = str;
        return this;
    }

    public App setBackupAppNameHash(String str) {
        this.backupAppNameHash = str;
        return this;
    }

    public App setBackupAppStatus(Integer num) {
        this.backupAppStatus = num;
        return this;
    }

    public App setBackupDeviceId(String str) {
        this.backupDeviceId = str;
        return this;
    }

    public App setBackupRecordId(String str) {
        this.backupRecordId = str;
        return this;
    }

    public App setBackupVersion(String str) {
        this.backupVersion = str;
        return this;
    }

    public void setBmAppDataType(int i10) {
        this.bmAppDataType = i10;
    }

    public App setCollection(String str) {
        this.collection = str;
        return this;
    }

    public App setCreateTime(C4644l c4644l) {
        this.createTime = c4644l;
        return this;
    }

    public App setDevice(String str) {
        this.device = str;
        return this;
    }

    public App setEndTime(C4644l c4644l) {
        this.endTime = c4644l;
        return this;
    }

    public App setFileCount(Integer num) {
        this.fileCount = num;
        return this;
    }

    public App setIconDataStatus(Integer num) {
        this.iconDataStatus = num;
        return this;
    }

    public App setIconFileName(String str) {
        this.iconFileName = str;
        return this;
    }

    public App setId(String str) {
        this.f22582id = str;
        return this;
    }

    public App setLifeEndTime(C4644l c4644l) {
        this.lifeEndTime = c4644l;
        return this;
    }

    public void setOriBackupAppName(String str) {
        this.oriBackupAppName = str;
    }

    public App setOwner(String str) {
        this.owner = str;
        return this;
    }

    public App setPackageFileName(String str) {
        this.packageFileName = str;
        return this;
    }

    public App setPackageVersion(String str) {
        this.packageVersion = str;
        return this;
    }

    public App setProperties(Map<String, String> map) {
        this.properties = map;
        return this;
    }

    public App setRuntimeType(Integer num) {
        this.runtimeType = num;
        return this;
    }

    public App setSource(String str) {
        this.source = str;
        return this;
    }

    public void setSplitApkType(String str) {
        this.splitApkType = str;
    }

    public void setSplitApkVersion(String str) {
        this.splitApkVersion = str;
    }

    public App setUpdateTime(C4644l c4644l) {
        this.updateTime = c4644l;
        return this;
    }

    public App setVersion(Integer num) {
        this.version = num;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public App set(String str, Object obj) {
        return (App) super.set(str, obj);
    }
}
