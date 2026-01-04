package com.huawei.hicloud.cloudbackup.p104v3.omconfig.model;

import java.util.List;

/* loaded from: classes6.dex */
public class MigrateSyncSwitchData {
    private final int dataVersion;
    private final int frameworkType;
    private List<SyncSwitchStatusSingleFrame> syncSwitch;
    private final String uidSha256;

    public MigrateSyncSwitchData(String str, int i10, int i11, List<SyncSwitchStatusSingleFrame> list) {
        this.uidSha256 = str;
        this.frameworkType = i10;
        this.dataVersion = i11;
        this.syncSwitch = list;
    }

    public List<SyncSwitchStatusSingleFrame> getSyncSwitch() {
        return this.syncSwitch;
    }
}
