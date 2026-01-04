package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes6.dex */
public class RevisionFinish extends C11707b {

    @InterfaceC4648p
    private C4644l updateTime;

    public C4644l getUpdateTime() {
        return this.updateTime;
    }

    public RevisionFinish setUpdateTime(C4644l c4644l) {
        this.updateTime = c4644l;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public RevisionFinish set(String str, Object obj) {
        return (RevisionFinish) super.set(str, obj);
    }
}
