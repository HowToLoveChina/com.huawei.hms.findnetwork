package com.huawei.fastengine.fastview.startfastappengine.bean;

import java.io.Serializable;

/* loaded from: classes5.dex */
public class Options implements Serializable {
    private static final long serialVersionUID = 7408849401004329761L;
    private String actionbarLockCustomize = "default";
    private boolean actionbarLockStatus = false;
    private int loadingPolicy = 0;

    public String getActionbarLockCustomize() {
        return this.actionbarLockCustomize;
    }

    public int getLoadingPolicy() {
        return this.loadingPolicy;
    }

    public boolean isActionbarLockStatus() {
        return this.actionbarLockStatus;
    }

    public void setActionbarLockCustomize(String str) {
        this.actionbarLockCustomize = str;
    }

    public void setActionbarLockStatus(boolean z10) {
        this.actionbarLockStatus = z10;
    }

    public void setLoadingPolicy(int i10) {
        this.loadingPolicy = i10;
    }
}
