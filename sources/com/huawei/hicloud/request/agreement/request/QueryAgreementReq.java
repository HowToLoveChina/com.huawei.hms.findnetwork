package com.huawei.hicloud.request.agreement.request;

import com.google.gson.Gson;
import com.huawei.hicloud.request.basic.bean.AgrInfo;
import java.util.List;

/* loaded from: classes6.dex */
public class QueryAgreementReq {
    private List<AgrInfo> agrInfo;

    public QueryAgreementReq(List<AgrInfo> list) {
        this.agrInfo = list;
    }

    public List<AgrInfo> getAgrInfo() {
        return this.agrInfo;
    }

    public void setAgrInfo(List<AgrInfo> list) {
        this.agrInfo = list;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
