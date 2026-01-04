package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes6.dex */
public class File extends C11707b {

    @InterfaceC4648p
    private String app;

    @InterfaceC4648p
    private String appPackageName;

    @InterfaceC4648p
    private List<Attachment> attachments;

    @InterfaceC4648p
    private String backupDeviceId;

    @InterfaceC4648p
    private String cloudPath;

    @InterfaceC4648p
    private int divideSha256;

    @InterfaceC4648p
    private Integer divideType;

    @InterfaceC4648p
    private Long fileSize;

    @InterfaceC4648p
    private Integer fileStatus;

    /* renamed from: id */
    @InterfaceC4648p
    private String f22593id;

    @InterfaceC4648p
    private Boolean isMdr;

    @InterfaceC4648p
    private String localPath;

    @InterfaceC4648p
    private Map<String, String> properties;

    @InterfaceC4648p
    private String sha256;

    @InterfaceC4648p
    private String source;

    @InterfaceC4648p
    private String splitApkType;

    public String getApp() {
        String str = this.app;
        return str == null ? "" : str;
    }

    public String getAppPackageName() {
        String str = this.appPackageName;
        return str == null ? "" : str;
    }

    public List<Attachment> getAttachments() {
        List<Attachment> list = this.attachments;
        return list == null ? new ArrayList() : list;
    }

    public String getBackupDeviceId() {
        String str = this.backupDeviceId;
        return str == null ? "" : str;
    }

    public String getCloudPath() {
        String str = this.cloudPath;
        return str == null ? "" : str;
    }

    public int getDivideSha256() {
        return this.divideSha256;
    }

    public Integer getDivideType() {
        return this.divideType;
    }

    public Long getFileSize() {
        Long l10 = this.fileSize;
        if (l10 == null) {
            return 0L;
        }
        return l10;
    }

    public int getFileStatus() {
        Integer num = this.fileStatus;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String getId() {
        String str = this.f22593id;
        return str == null ? "" : str;
    }

    public String getLocalPath() {
        String str = this.localPath;
        return str == null ? "" : str;
    }

    public Map<String, String> getProperties() {
        Map<String, String> map = this.properties;
        return map == null ? new HashMap() : map;
    }

    public String getSha256() {
        String str = this.sha256;
        return str == null ? "" : str;
    }

    public String getSource() {
        String str = this.source;
        return str == null ? "" : str;
    }

    public String getSplitApkType() {
        String str = this.splitApkType;
        return str == null ? "" : str;
    }

    public boolean isMdr() {
        Boolean bool = this.isMdr;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public File setApp(String str) {
        this.app = str;
        return this;
    }

    public File setAppPackageName(String str) {
        this.appPackageName = str;
        return this;
    }

    public File setAttachments(List<Attachment> list) {
        this.attachments = list;
        return this;
    }

    public File setBackupDeviceId(String str) {
        this.backupDeviceId = str;
        return this;
    }

    public void setCloudPath(String str) {
        this.cloudPath = str;
    }

    public void setDivideSha256(int i10) {
        this.divideSha256 = i10;
    }

    public void setDivideType(Integer num) {
        this.divideType = num;
    }

    public File setFileSize(Long l10) {
        this.fileSize = l10;
        return this;
    }

    public void setFileStatus(int i10) {
        this.fileStatus = Integer.valueOf(i10);
    }

    public File setId(String str) {
        this.f22593id = str;
        return this;
    }

    public File setLocalPath(String str) {
        this.localPath = str;
        return this;
    }

    public File setMdr(boolean z10) {
        this.isMdr = Boolean.valueOf(z10);
        return this;
    }

    public File setProperties(Map<String, String> map) {
        this.properties = map;
        return this;
    }

    public File setSha256(String str) {
        this.sha256 = str;
        return this;
    }

    public File setSource(String str) {
        this.source = str;
        return this;
    }

    public void setSplitApkType(String str) {
        this.splitApkType = str;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public File set(String str, Object obj) {
        return (File) super.set(str, obj);
    }
}
