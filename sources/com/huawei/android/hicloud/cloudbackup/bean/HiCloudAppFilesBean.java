package com.huawei.android.hicloud.cloudbackup.bean;

import java.util.List;

/* loaded from: classes2.dex */
public class HiCloudAppFilesBean {
    private List<AppInfoList> appInfoList;
    private CloudBackupConfig cloudBackupConfig;
    private String data;
    private String date;

    /* renamed from: id */
    private String f11657id;
    private Language language;
    private long version;

    public List<AppInfoList> getAppInfoList() {
        return this.appInfoList;
    }

    public CloudBackupConfig getCloudBackupConfig() {
        return this.cloudBackupConfig;
    }

    public String getData() {
        String str = this.data;
        return str == null ? "" : str;
    }

    public String getDate() {
        return this.date;
    }

    public String getId() {
        return this.f11657id;
    }

    public Language getLanguage() {
        return this.language;
    }

    public long getVersion() {
        return this.version;
    }

    public void setAppInfoList(List<AppInfoList> list) {
        this.appInfoList = list;
    }

    public void setCloudBackupConfig(CloudBackupConfig cloudBackupConfig) {
        this.cloudBackupConfig = cloudBackupConfig;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setId(String str) {
        this.f11657id = str;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public void setVersion(long j10) {
        this.version = j10;
    }

    public String toString() {
        return "HiCloudAppFilesBean{id='" + this.f11657id + "', date='" + this.date + "', version=" + this.version + ", cloudBackupConfig=" + this.cloudBackupConfig + ", appInfoList=" + this.appInfoList + ", data='" + this.data + "'}";
    }
}
