package com.huawei.hicloud.request.agreement.request;

import com.google.gson.Gson;
import java.util.List;

/* loaded from: classes6.dex */
public class SignAgreementReq extends BaseReq {
    private List<SignInfo> signInfo;

    public SignAgreementReq(List<SignInfo> list) {
        this.signInfo = list;
    }

    public List<SignInfo> getSignInfo() {
        return this.signInfo;
    }

    public void setSignInfo(List<SignInfo> list) {
        this.signInfo = list;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
