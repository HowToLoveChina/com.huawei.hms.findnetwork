package com.huawei.hicloud.cloudbackup.p104v3.omconfig.model;

import java.util.List;

/* loaded from: classes6.dex */
public class SyncSwitchStatusSingleFrame {
    private final String bundleName;
    private final int status;
    private List<SyncSwitchStatusSingleFrame> subSwitch;
    private final String syncType;

    public SyncSwitchStatusSingleFrame(String str, int i10, String str2, List<SyncSwitchStatusSingleFrame> list) {
        this.syncType = str;
        this.status = i10;
        this.bundleName = str2;
        this.subSwitch = list;
    }

    public String getBundleName() {
        return this.bundleName;
    }

    public int getStatus() {
        return this.status;
    }

    public String getSyncType() {
        return this.syncType;
    }

    public String toString() {
        return "bundleName: " + this.bundleName + "syncType: " + this.syncType + ", status: " + this.status;
    }
}
