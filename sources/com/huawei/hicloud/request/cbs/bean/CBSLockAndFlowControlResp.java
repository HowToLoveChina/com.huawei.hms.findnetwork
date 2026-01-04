package com.huawei.hicloud.request.cbs.bean;

/* loaded from: classes6.dex */
public class CBSLockAndFlowControlResp extends CBSBaseResp {
    private long lockInterval;

    public long getLockInterval() {
        return this.lockInterval;
    }

    public void setLockInterval(int i10) {
        this.lockInterval = i10;
    }

    @Override // com.huawei.hicloud.request.cbs.bean.CBSBaseResp
    public String toString() {
        return "CBSLockAndFlowControlResp{lockInterval=" + this.lockInterval + ", result=" + this.result + ", info='" + this.info + "'}";
    }
}
