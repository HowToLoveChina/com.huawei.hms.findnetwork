package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes6.dex */
public class AppCreate extends C11707b {

    @InterfaceC4648p
    private Integer apkType;

    @InterfaceC4648p
    private Long appTotalSize;

    @InterfaceC4648p
    private String backupAppName;

    @InterfaceC4648p
    private String backupDeviceId;

    @InterfaceC4648p
    private String backupRecordId;

    @InterfaceC4648p
    private String backupVersion;

    @InterfaceC4648p
    private C4644l createTime;

    @InterfaceC4648p
    private Integer fileCount;

    @InterfaceC4648p
    private String iconFileName;

    @InterfaceC4648p
    private String packageFileName;

    @InterfaceC4648p
    private String packageVersion;

    @InterfaceC4648p
    private Map<String, String> properties;

    @InterfaceC4648p
    private Integer runtimeType;

    @InterfaceC4648p
    private String splitApkType;

    @InterfaceC4648p
    private String splitApkVersion;

    public Integer getApkType() {
        return this.apkType;
    }

    public Long getAppTotalSize() {
        return this.appTotalSize;
    }

    public String getBackupAppName() {
        return this.backupAppName;
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

    public C4644l getCreateTime() {
        return this.createTime;
    }

    public Integer getFileCount() {
        return this.fileCount;
    }

    public String getIconFileName() {
        return this.iconFileName;
    }

    public String getPackageFileName() {
        return this.packageFileName;
    }

    public String getPackageVersion() {
        return this.packageVersion;
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public Integer getRuntimeType() {
        return this.runtimeType;
    }

    public String getSplitApkType() {
        return this.splitApkType;
    }

    public AppCreate setApkType(Integer num) {
        this.apkType = num;
        return this;
    }

    public AppCreate setAppTotalSize(Long l10) {
        this.appTotalSize = l10;
        return this;
    }

    public AppCreate setBackupAppName(String str) {
        this.backupAppName = str;
        return this;
    }

    public AppCreate setBackupDeviceId(String str) {
        this.backupDeviceId = str;
        return this;
    }

    public AppCreate setBackupRecordId(String str) {
        this.backupRecordId = str;
        return this;
    }

    public AppCreate setBackupVersion(String str) {
        this.backupVersion = str;
        return this;
    }

    public AppCreate setCreateTime(C4644l c4644l) {
        this.createTime = c4644l;
        return this;
    }

    public AppCreate setFileCount(Integer num) {
        this.fileCount = num;
        return this;
    }

    public AppCreate setIconFileName(String str) {
        this.iconFileName = str;
        return this;
    }

    public AppCreate setPackageFileName(String str) {
        this.packageFileName = str;
        return this;
    }

    public AppCreate setPackageVersion(String str) {
        this.packageVersion = str;
        return this;
    }

    public AppCreate setProperties(Map<String, String> map) {
        this.properties = map;
        return this;
    }

    public AppCreate setRuntimeType(Integer num) {
        this.runtimeType = num;
        return this;
    }

    public void setSplitApkType(String str) {
        this.splitApkType = str;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public AppCreate set(String str, Object obj) {
        return (AppCreate) super.set(str, obj);
    }
}
