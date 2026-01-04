package com.huawei.android.hicloud.drive.cloudphoto.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.hicloud.base.drive.model.SingleRequest;
import java.util.List;
import ni.C11707b;

/* loaded from: classes3.dex */
public class BatchRequest<T> extends C11707b {

    @InterfaceC4648p
    private List<SingleRequest<T>> batchReq;

    public List<SingleRequest<T>> getBatchReq() {
        return this.batchReq;
    }

    public void setBatchReq(List<SingleRequest<T>> list) {
        this.batchReq = list;
    }
}
