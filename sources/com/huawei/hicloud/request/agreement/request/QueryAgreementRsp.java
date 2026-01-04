package com.huawei.hicloud.request.agreement.request;

import java.util.ArrayList;

/* loaded from: classes6.dex */
public class QueryAgreementRsp extends BaseRsp {
    private ArrayList<SignInfo> signInfo;

    public ArrayList<SignInfo> getSignInfo() {
        return this.signInfo;
    }

    public void setSignInfo(ArrayList<SignInfo> arrayList) {
        this.signInfo = arrayList;
    }
}
