package com.huawei.hms.findnetwork.comm.request.bean.wear;

import com.huawei.hms.findnetwork.comm.request.bean.BaseRequestBean;

/* loaded from: classes8.dex */
public class ShareDeviceRequestBean extends BaseRequestBean {
    private String fid;
    private String publicKey;
    private String srcTranId;

    public String getFid() {
        return this.fid;
    }

    public String getPublicKey() {
        return this.publicKey;
    }

    @Override // com.huawei.hms.findnetwork.comm.request.bean.BaseRequestBean
    public String getSrcTranId() {
        return this.srcTranId;
    }

    public void setFid(String str) {
        this.fid = str;
    }

    public void setPublicKey(String str) {
        this.publicKey = str;
    }

    @Override // com.huawei.hms.findnetwork.comm.request.bean.BaseRequestBean
    public void setSrcTranId(String str) {
        this.srcTranId = str;
    }
}
