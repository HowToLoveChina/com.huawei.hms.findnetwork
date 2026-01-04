package com.huawei.android.hicloud.cloudbackup.bean;

import java.util.Objects;

/* loaded from: classes2.dex */
public class AppBackupSwitchListApp {
    private int index;
    private String packageName;
    private String parent;
    private int type;

    public boolean equals(Object obj) {
        String str = this.packageName;
        if (str == null || !(obj instanceof AppBackupSwitchListApp)) {
            return false;
        }
        AppBackupSwitchListApp appBackupSwitchListApp = (AppBackupSwitchListApp) obj;
        return str.equals(appBackupSwitchListApp.getPackageName()) && this.type == appBackupSwitchListApp.getType();
    }

    public int getIndex() {
        return this.index;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getParent() {
        return this.parent;
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        return Objects.hash(this.packageName, Integer.valueOf(this.type));
    }

    public void setIndex(int i10) {
        this.index = i10;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setParent(String str) {
        this.parent = str;
    }

    public void setType(int i10) {
        this.type = i10;
    }
}
