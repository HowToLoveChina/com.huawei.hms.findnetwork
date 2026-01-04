package com.huawei.android.hicloud.syncdrive.cloudsync.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import ni.C11707b;

/* loaded from: classes3.dex */
public class RecordsList extends C11707b {

    @InterfaceC4648p
    private String nextCursor;

    @InterfaceC4648p
    private List<Record> records;

    public String getNextCursor() {
        return this.nextCursor;
    }

    public List<Record> getRecords() {
        return this.records;
    }

    public void setNextCursor(String str) {
        this.nextCursor = str;
    }

    public void setRecords(List<Record> list) {
        this.records = list;
    }
}
