package com.huawei.android.hicloud.drive.clouddisk.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import ni.C11707b;

/* loaded from: classes3.dex */
public class BatchFilesRequest extends C11707b {

    @InterfaceC4648p
    private List<FileUpdate> batchReq;

    public List<FileUpdate> getBatchReq() {
        return this.batchReq;
    }

    public void setBatchReq(List<FileUpdate> list) {
        this.batchReq = list;
    }
}
