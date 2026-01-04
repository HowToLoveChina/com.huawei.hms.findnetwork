package com.huawei.android.hicloud.cloudbackup.bean;

import java.util.List;

/* loaded from: classes2.dex */
public class AppBackupSwitchList {
    private List<AppBackupSwitchListApp> apps;
    private List<String> gradeCode;

    public List<AppBackupSwitchListApp> getApps() {
        return this.apps;
    }

    public List<String> getGradeCode() {
        return this.gradeCode;
    }

    public void setApps(List<AppBackupSwitchListApp> list) {
        this.apps = list;
    }

    public void setGradeCode(List<String> list) {
        this.gradeCode = list;
    }
}
