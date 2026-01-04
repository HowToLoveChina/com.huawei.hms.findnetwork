package com.huawei.hicloud.bean;

/* loaded from: classes6.dex */
public class BaseModuleConfig {
    protected boolean isSyncEnable = true;
    protected boolean isBackupEnable = true;
    protected boolean isPhoneFinderEnable = true;
    protected boolean isAlbumEnable = true;
    protected boolean isDbankEnable = true;

    public boolean isAlbumEnable() {
        return this.isAlbumEnable;
    }

    public boolean isBackupEnable() {
        return this.isBackupEnable;
    }

    public boolean isDbankEnable() {
        return this.isDbankEnable;
    }

    public boolean isPhoneFinderEnable() {
        return this.isPhoneFinderEnable;
    }

    public boolean isSyncEnable() {
        return this.isSyncEnable;
    }

    public void setAlbumEnable(boolean z10) {
        this.isAlbumEnable = z10;
    }

    public void setBackupEnable(boolean z10) {
        this.isBackupEnable = z10;
    }

    public void setDbankEnable(boolean z10) {
        this.isDbankEnable = z10;
    }

    public void setPhoneFinderEnable(boolean z10) {
        this.isPhoneFinderEnable = z10;
    }

    public void setSyncEnable(boolean z10) {
        this.isSyncEnable = z10;
    }
}
