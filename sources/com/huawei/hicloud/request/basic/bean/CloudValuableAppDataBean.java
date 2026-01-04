package com.huawei.hicloud.request.basic.bean;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes6.dex */
public class CloudValuableAppDataBean implements Serializable {
    private static final long serialVersionUID = -2187857678746764528L;
    private int appCount;
    private List<AppInfo> appListTop;
    private int backupBaseNum;
    private int backupFullNum;
    private int syncBaseNum;
    private int syncFullNum;

    public static class AppInfo {
        private String appId;
        private String icon;
        private String packageName;

        public String getAppId() {
            return this.appId;
        }

        public String getIcon() {
            return this.icon;
        }

        public String getPackageName() {
            return this.packageName;
        }

        public void setAppId(String str) {
            this.appId = str;
        }

        public void setIcon(String str) {
            this.icon = str;
        }

        public void setPackageName(String str) {
            this.packageName = str;
        }
    }

    public int getAppCount() {
        return this.appCount;
    }

    public List<AppInfo> getAppListTop() {
        return this.appListTop;
    }

    public int getBackupBaseNum() {
        return this.backupBaseNum;
    }

    public int getBackupFullNum() {
        return this.backupFullNum;
    }

    public int getSyncBaseNum() {
        return this.syncBaseNum;
    }

    public int getSyncFullNum() {
        return this.syncFullNum;
    }

    public void setAppCount(int i10) {
        this.appCount = i10;
    }

    public void setAppListTop(List<AppInfo> list) {
        this.appListTop = list;
    }

    public void setBackupBaseNum(int i10) {
        this.backupBaseNum = i10;
    }

    public void setBackupFullNum(int i10) {
        this.backupFullNum = i10;
    }

    public void setSyncBaseNum(int i10) {
        this.syncBaseNum = i10;
    }

    public void setSyncFullNum(int i10) {
        this.syncFullNum = i10;
    }
}
