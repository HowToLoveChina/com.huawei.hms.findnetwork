package com.huawei.hms.findnetwork.comm.request.bean.wear;

import com.huawei.hms.findnetwork.comm.request.bean.BaseRequestBean;

/* loaded from: classes8.dex */
public class BindDeviceRequestBean extends BaseRequestBean {
    private String fid;
    private String secondaryPublicKey;
    private String srcTranId;

    public String getFid() {
        return this.fid;
    }

    public String getSecondaryPublicKey() {
        return this.secondaryPublicKey;
    }

    @Override // com.huawei.hms.findnetwork.comm.request.bean.BaseRequestBean
    public String getSrcTranId() {
        return this.srcTranId;
    }

    public void setFid(String str) {
        this.fid = str;
    }

    public void setSecondaryPublicKey(String str) {
        this.secondaryPublicKey = str;
    }

    @Override // com.huawei.hms.findnetwork.comm.request.bean.BaseRequestBean
    public void setSrcTranId(String str) {
        this.srcTranId = str;
    }
}
