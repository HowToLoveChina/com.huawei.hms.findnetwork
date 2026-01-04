package com.huawei.appgallery.marketinstallerservice.api;

/* loaded from: classes4.dex */
public class BaseResultParam {

    /* renamed from: a */
    public int f21001a = 0;

    /* renamed from: b */
    public int f21002b = 0;

    /* renamed from: c */
    public int f21003c = 0;

    /* renamed from: d */
    public int f21004d = 0;

    public int getReason() {
        return this.f21002b;
    }

    public int getResponseCode() {
        return this.f21003c;
    }

    public int getResult() {
        return this.f21001a;
    }

    public int getRtnCode() {
        return this.f21004d;
    }

    public void setReason(int i10) {
        this.f21002b = i10;
    }

    public void setResponseCode(int i10) {
        this.f21003c = i10;
    }

    public void setResult(int i10) {
        this.f21001a = i10;
    }

    public void setRtnCode(int i10) {
        this.f21004d = i10;
    }
}
