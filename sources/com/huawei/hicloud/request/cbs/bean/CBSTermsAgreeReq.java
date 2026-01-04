package com.huawei.hicloud.request.cbs.bean;

import java.util.Map;

/* loaded from: classes6.dex */
public class CBSTermsAgreeReq extends CBSBaseReq {
    private Map<String, String> agrType;
    private String country;
    private String service = "Cloud";

    public CBSTermsAgreeReq() {
        this.cmd = 52;
        this.info = "TermsAgreeReq";
    }

    public Map<String, String> getAgrType() {
        return this.agrType;
    }

    public String getCountry() {
        return this.country;
    }

    public String getService() {
        return this.service;
    }

    public void setAgrType(Map<String, String> map) {
        this.agrType = map;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setService(String str) {
        this.service = str;
    }
}
