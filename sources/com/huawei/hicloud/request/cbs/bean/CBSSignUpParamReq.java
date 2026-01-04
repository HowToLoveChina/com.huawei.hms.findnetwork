package com.huawei.hicloud.request.cbs.bean;

/* loaded from: classes6.dex */
public class CBSSignUpParamReq extends CBSBaseReq {
    private String param;

    public CBSSignUpParamReq(String str) {
        this.cmd = 43;
        this.info = "SignUpParamReq";
        this.param = str;
    }

    public String getParam() {
        return this.param;
    }

    public void setParam(String str) {
        this.param = str;
    }
}
