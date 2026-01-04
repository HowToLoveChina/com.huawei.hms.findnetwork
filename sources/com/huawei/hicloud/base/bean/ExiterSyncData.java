package com.huawei.hicloud.base.bean;

/* loaded from: classes6.dex */
public class ExiterSyncData {
    private boolean retainState = true;
    private String syncType;

    public String getSyncType() {
        return this.syncType;
    }

    public boolean isRetainState() {
        return this.retainState;
    }

    public void setRetainState(boolean z10) {
        this.retainState = z10;
    }

    public void setSyncType(String str) {
        this.syncType = str;
    }
}
