package com.huawei.hms.iap.entity;

/* loaded from: classes8.dex */
public class PurchaseResultInfo {

    /* renamed from: a */
    private int f25429a;

    /* renamed from: b */
    private String f25430b;

    /* renamed from: c */
    private String f25431c;

    /* renamed from: d */
    private String f25432d;

    /* renamed from: e */
    private String f25433e;

    public String getErrMsg() {
        return this.f25432d;
    }

    public String getInAppDataSignature() {
        return this.f25431c;
    }

    public String getInAppPurchaseData() {
        return this.f25430b;
    }

    public int getReturnCode() {
        return this.f25429a;
    }

    public String getSignatureAlgorithm() {
        return this.f25433e;
    }

    public void setErrMsg(String str) {
        this.f25432d = str;
    }

    public void setInAppDataSignature(String str) {
        this.f25431c = str;
    }

    public void setInAppPurchaseData(String str) {
        this.f25430b = str;
    }

    public void setReturnCode(int i10) {
        this.f25429a = i10;
    }

    public void setSignatureAlgorithm(String str) {
        this.f25433e = str;
    }
}
