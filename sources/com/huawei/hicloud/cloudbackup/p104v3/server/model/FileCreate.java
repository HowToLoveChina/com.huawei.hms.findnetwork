package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes6.dex */
public class FileCreate extends C11707b {

    @InterfaceC4648p
    private String appPackageName;

    @InterfaceC4648p
    private String backupDeviceId;

    @InterfaceC4648p
    private String backupVersion;

    @InterfaceC4648p
    private Cipher cipher;

    @InterfaceC4648p
    private Long compressedSize;

    @InterfaceC4648p
    private C4644l createTime;

    @InterfaceC4648p
    private String divideSha256;

    @InterfaceC4648p
    private Integer divideType;

    @InterfaceC4648p
    private String encoding;

    @InterfaceC4648p
    private Long fileSize;

    @InterfaceC4648p
    private int frequency;

    @InterfaceC4648p
    private String hash;

    @InterfaceC4648p
    private int incType;

    @InterfaceC4648p
    private String localPath;

    @InterfaceC4648p
    private String mimeType;

    @InterfaceC4648p
    private Map<String, String> properties;

    @InterfaceC4648p
    private String sha256;

    @InterfaceC4648p
    private String splitApkType;

    public String getAppPackageName() {
        return this.appPackageName;
    }

    public String getBackupDeviceId() {
        return this.backupDeviceId;
    }

    public String getBackupVersion() {
        return this.backupVersion;
    }

    public Cipher getCipher() {
        return this.cipher;
    }

    public Long getCompressedSize() {
        return this.compressedSize;
    }

    public C4644l getCreateTime() {
        return this.createTime;
    }

    public String getDivideSha256() {
        return this.divideSha256;
    }

    public Integer getDivideType() {
        return this.divideType;
    }

    public String getEncoding() {
        return this.encoding;
    }

    public Long getFileSize() {
        return this.fileSize;
    }

    public int getFrequency() {
        return this.frequency;
    }

    public String getHash() {
        return this.hash;
    }

    public int getIncType() {
        return this.incType;
    }

    public String getLocalPath() {
        return this.localPath;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public String getSha256() {
        return this.sha256;
    }

    public String getSplitApkType() {
        return this.splitApkType;
    }

    public FileCreate setAppPackageName(String str) {
        this.appPackageName = str;
        return this;
    }

    public FileCreate setBackupDeviceId(String str) {
        this.backupDeviceId = str;
        return this;
    }

    public FileCreate setBackupVersion(String str) {
        this.backupVersion = str;
        return this;
    }

    public void setCipher(Cipher cipher) {
        this.cipher = cipher;
    }

    public void setCompressedSize(Long l10) {
        this.compressedSize = l10;
    }

    public FileCreate setCreateTime(C4644l c4644l) {
        this.createTime = c4644l;
        return this;
    }

    public void setDivideSha256(String str) {
        this.divideSha256 = str;
    }

    public void setDivideType(Integer num) {
        this.divideType = num;
    }

    public void setEncoding(String str) {
        this.encoding = str;
    }

    public FileCreate setFileSize(Long l10) {
        this.fileSize = l10;
        return this;
    }

    public FileCreate setFrequency(int i10) {
        this.frequency = i10;
        return this;
    }

    public FileCreate setHash(String str) {
        this.hash = str;
        return this;
    }

    public FileCreate setIncType(int i10) {
        this.incType = i10;
        return this;
    }

    public FileCreate setLocalPath(String str) {
        this.localPath = str;
        return this;
    }

    public FileCreate setMimeType(String str) {
        this.mimeType = str;
        return this;
    }

    public FileCreate setProperties(Map<String, String> map) {
        this.properties = map;
        return this;
    }

    public FileCreate setSha256(String str) {
        this.sha256 = str;
        return this;
    }

    public FileCreate setSplitApkType(String str) {
        this.splitApkType = str;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public FileCreate set(String str, Object obj) {
        return (FileCreate) super.set(str, obj);
    }
}
