package com.huawei.hms.findnetwork.comm.request.bean.wear;

import com.huawei.hms.findnetwork.comm.request.bean.BaseRequestBean;
import java.util.List;

/* loaded from: classes8.dex */
public class FidBatchRequestBean extends BaseRequestBean {
    private String additional;
    private List<String> fids;

    public String getAdditional() {
        return this.additional;
    }

    public List<String> getFids() {
        return this.fids;
    }

    public void setAdditional(String str) {
        this.additional = str;
    }

    public void setFids(List<String> list) {
        this.fids = list;
    }
}
