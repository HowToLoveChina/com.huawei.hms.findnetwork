package com.huawei.hms.findnetwork.comm.request.bean.wear;

import com.huawei.hms.findnetwork.comm.request.bean.BaseRequestBean;

/* loaded from: classes8.dex */
public class PairResponseBean extends BaseRequestBean {
    private String msg;
    private String srcTranId;

    public String getMsg() {
        return this.msg;
    }

    @Override // com.huawei.hms.findnetwork.comm.request.bean.BaseRequestBean
    public String getSrcTranId() {
        return this.srcTranId;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    @Override // com.huawei.hms.findnetwork.comm.request.bean.BaseRequestBean
    public void setSrcTranId(String str) {
        this.srcTranId = str;
    }
}
