package com.huawei.hicloud.base.bean;

import com.google.gson.Gson;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes6.dex */
public class QueryDevConfAgreementRsp implements Serializable {
    private static final long serialVersionUID = 8507848326049851916L;
    private List<AgreementInfo> agrInfo;

    public QueryDevConfAgreementRsp(List<AgreementInfo> list) {
        this.agrInfo = list;
    }

    public List<AgreementInfo> getAgrInfo() {
        return this.agrInfo;
    }

    public void setAgrInfo(List<AgreementInfo> list) {
        this.agrInfo = list;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
