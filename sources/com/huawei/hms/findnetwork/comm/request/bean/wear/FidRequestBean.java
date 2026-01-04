package com.huawei.hms.findnetwork.comm.request.bean.wear;

import com.huawei.hms.findnetwork.comm.request.bean.BaseRequestBean;

/* loaded from: classes8.dex */
public class FidRequestBean extends BaseRequestBean {
    private String additional;
    private String fid;

    public String getAdditional() {
        return this.additional;
    }

    public String getFid() {
        return this.fid;
    }

    public void setAdditional(String str) {
        this.additional = str;
    }

    public void setFid(String str) {
        this.fid = str;
    }
}
