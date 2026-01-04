package com.huawei.android.hicloud.cloudbackup.bean;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class PathMapping {
    private List<AppVer> appVer;
    private BackupAndroidLevel backup;
    private List<Path> paths;
    private RestoreAndroidLevel restore;

    public List<AppVer> getAppVer() {
        List<AppVer> list = this.appVer;
        return list == null ? new ArrayList() : list;
    }

    public BackupAndroidLevel getBackup() {
        return this.backup;
    }

    public List<Path> getPaths() {
        return this.paths;
    }

    public RestoreAndroidLevel getRestore() {
        return this.restore;
    }

    public void setAppVer(List<AppVer> list) {
        this.appVer = list;
    }

    public void setBackup(BackupAndroidLevel backupAndroidLevel) {
        this.backup = backupAndroidLevel;
    }

    public void setPaths(List<Path> list) {
        this.paths = list;
    }

    public void setRestore(RestoreAndroidLevel restoreAndroidLevel) {
        this.restore = restoreAndroidLevel;
    }
}
