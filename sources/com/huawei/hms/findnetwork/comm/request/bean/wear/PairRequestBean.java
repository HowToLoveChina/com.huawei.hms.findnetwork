package com.huawei.hms.findnetwork.comm.request.bean.wear;

import com.huawei.hms.findnetwork.comm.request.bean.BaseRequestBean;

/* loaded from: classes8.dex */
public class PairRequestBean extends BaseRequestBean {
    private String srcTranId = "";
    private String msg = "";
    private String version = "";

    public String getMsg() {
        return this.msg;
    }

    @Override // com.huawei.hms.findnetwork.comm.request.bean.BaseRequestBean
    public String getSrcTranId() {
        return this.srcTranId;
    }

    public String getVersion() {
        return this.version;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    @Override // com.huawei.hms.findnetwork.comm.request.bean.BaseRequestBean
    public void setSrcTranId(String str) {
        this.srcTranId = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
