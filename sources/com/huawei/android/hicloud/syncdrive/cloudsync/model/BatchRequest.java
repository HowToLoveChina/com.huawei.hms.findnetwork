package com.huawei.android.hicloud.syncdrive.cloudsync.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.hicloud.base.drive.model.SingleRequest;
import java.util.List;
import ni.C11707b;

/* loaded from: classes3.dex */
public class BatchRequest<T> extends C11707b {

    @InterfaceC4648p
    private List<SingleRequest<T>> batchReq;

    @InterfaceC4648p
    private String database;

    @InterfaceC4648p
    private String kinds;

    public List<SingleRequest<T>> getBatchReq() {
        return this.batchReq;
    }

    public String getDatabase() {
        return this.database;
    }

    public String getKinds() {
        return this.kinds;
    }

    public void setBatchReq(List<SingleRequest<T>> list) {
        this.batchReq = list;
    }

    public void setDatabase(String str) {
        this.database = str;
    }

    public void setKinds(String str) {
        this.kinds = str;
    }
}
