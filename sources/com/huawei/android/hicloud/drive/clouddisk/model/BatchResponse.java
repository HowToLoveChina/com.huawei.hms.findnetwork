package com.huawei.android.hicloud.drive.clouddisk.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import ni.C11707b;

/* loaded from: classes3.dex */
public class BatchResponse extends C11707b {

    @InterfaceC4648p
    private List<SingleResponse> batchRes;

    public List<SingleResponse> getBatchRes() {
        return this.batchRes;
    }

    public void setBatchRes(List<SingleResponse> list) {
        this.batchRes = list;
    }
}
