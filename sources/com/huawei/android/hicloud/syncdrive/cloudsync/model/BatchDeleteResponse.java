package com.huawei.android.hicloud.syncdrive.cloudsync.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import ni.C11707b;

/* loaded from: classes3.dex */
public class BatchDeleteResponse extends C11707b {

    @InterfaceC4648p
    private List<FailRecord> failedRecords;

    @InterfaceC4648p
    private List<String> ids;

    public List<FailRecord> getFailedRecords() {
        return this.failedRecords;
    }

    public List<String> getIds() {
        return this.ids;
    }

    public void setFailedRecords(List<FailRecord> list) {
        this.failedRecords = list;
    }

    public void setIds(List<String> list) {
        this.ids = list;
    }
}
