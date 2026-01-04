package com.huawei.android.hicloud.syncdrive.cloudsync.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import ni.C11707b;

/* loaded from: classes3.dex */
public class BatchRecordsRequest extends C11707b {

    @InterfaceC4648p
    private List<Record> records;

    public List<Record> getRecords() {
        return this.records;
    }

    public void setRecords(List<Record> list) {
        this.records = list;
    }
}
