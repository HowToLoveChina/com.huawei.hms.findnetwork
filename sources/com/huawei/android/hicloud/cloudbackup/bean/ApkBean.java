package com.huawei.android.hicloud.cloudbackup.bean;

/* loaded from: classes2.dex */
public class ApkBean {
    private static final int SUPPORT_RECOVERY = 1;
    private String backupUri;
    private long[] excludeVerCodes;
    private long hiDiskVerCode;
    private long minVerCode;
    private String name;
    private int support;
    private String verRegx;

    public String getBackupUri() {
        return this.backupUri;
    }

    public long[] getExcludeVerCodes() {
        return this.excludeVerCodes;
    }

    public long getHiDiskVerCode() {
        return this.hiDiskVerCode;
    }

    public long getMinVerCode() {
        return this.minVerCode;
    }

    public String getName() {
        return this.name;
    }

    public int getSupport() {
        return this.support;
    }

    public String getVerRegx() {
        return this.verRegx;
    }

    public boolean isSupport() {
        return this.support == 1;
    }

    public void setBackupUri(String str) {
        this.backupUri = str;
    }

    public void setExcludeVerCodes(long[] jArr) {
        this.excludeVerCodes = jArr;
    }

    public void setHiDiskVerCode(long j10) {
        this.hiDiskVerCode = j10;
    }

    public void setMinVerCode(long j10) {
        this.minVerCode = j10;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSupport(int i10) {
        this.support = i10;
    }

    public void setVerRegx(String str) {
        this.verRegx = str;
    }

    public String toString() {
        return "ApkBean{name='" + this.name + "', support=" + this.support + ", backupUri='" + this.backupUri + "', minVerCode='" + this.minVerCode + "', hiDiskVerCode='" + this.hiDiskVerCode + "'}";
    }
}
