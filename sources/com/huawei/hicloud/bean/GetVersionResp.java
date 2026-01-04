package com.huawei.hicloud.bean;

/* loaded from: classes6.dex */
public class GetVersionResp extends GeneralConfigBaseResp {
    private Snapshot[] changes;

    public Snapshot[] getChanges() {
        return this.changes;
    }

    public void setChanges(Snapshot[] snapshotArr) {
        this.changes = snapshotArr;
    }
}
