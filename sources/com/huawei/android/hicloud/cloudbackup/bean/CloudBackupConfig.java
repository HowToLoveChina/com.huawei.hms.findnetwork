package com.huawei.android.hicloud.cloudbackup.bean;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class CloudBackupConfig {
    private BackupConfig backupConfig;
    private List<RestoreConfig> restoreConfig;
    private List<RestoreSequence> restoreSequence;
    private List<RestoreSequence> restoreThreadSeq;
    private int switch3rdApp;
    private int switch3rdDefault;

    public BackupConfig getCloudBackup() {
        return this.backupConfig;
    }

    public List<RestoreConfig> getRestoreConfig() {
        return this.restoreConfig;
    }

    public List<RestoreSequence> getRestoreSequence() {
        List<RestoreSequence> list = this.restoreSequence;
        return list == null ? new ArrayList() : list;
    }

    public List<RestoreSequence> getRestoreThreadSeq() {
        List<RestoreSequence> list = this.restoreThreadSeq;
        return list == null ? new ArrayList() : list;
    }

    public int getSwitch3rdApp() {
        return this.switch3rdApp;
    }

    public int getSwitch3rdDefault() {
        return this.switch3rdDefault;
    }

    public void setCloudBackup(BackupConfig backupConfig) {
        this.backupConfig = backupConfig;
    }

    public void setRestoreConfig(List<RestoreConfig> list) {
        this.restoreConfig = list;
    }

    public void setRestoreSequence(List<RestoreSequence> list) {
        this.restoreSequence = list;
    }

    public void setRestoreThreadSeq(List<RestoreSequence> list) {
        this.restoreThreadSeq = list;
    }

    public void setSwitch3rdApp(int i10) {
        this.switch3rdApp = i10;
    }

    public void setSwitch3rdDefault(int i10) {
        this.switch3rdDefault = i10;
    }

    public String toString() {
        return "CloudBackupConfig{switch3rdApp=" + this.switch3rdApp + ", switch3rdDefault=" + this.switch3rdDefault + ", backupConfig=" + this.backupConfig + ", restoreConfig=" + this.restoreConfig + ", restoreSequence=" + this.restoreSequence + ", restoreThreadSeq=" + this.restoreThreadSeq + '}';
    }
}
