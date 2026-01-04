package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import ni.C11707b;

/* loaded from: classes6.dex */
public class IdTransferRequest extends C11707b {

    @InterfaceC4648p
    List cloudPathList;

    public List getCloudPathList() {
        return this.cloudPathList;
    }

    public void setCloudPathList(List list) {
        this.cloudPathList = list;
    }
}
