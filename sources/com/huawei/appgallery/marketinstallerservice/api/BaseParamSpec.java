package com.huawei.appgallery.marketinstallerservice.api;

/* loaded from: classes4.dex */
public class BaseParamSpec {

    /* renamed from: a */
    public String f20997a = null;

    /* renamed from: b */
    public String f20998b = null;

    /* renamed from: c */
    public String f20999c = null;

    /* renamed from: d */
    public boolean f21000d = false;

    public String getMarketPkg() {
        return this.f20999c;
    }

    public String getServerUrl() {
        return this.f20997a;
    }

    public String getSubsystem() {
        return this.f20998b;
    }

    public boolean isUpdate() {
        return this.f21000d;
    }

    public void setMarketPkg(String str) {
        this.f20999c = str;
    }

    public void setServerUrl(String str) {
        this.f20997a = str;
    }

    public void setSubsystem(String str) {
        this.f20998b = str;
    }

    public void setUpdate(boolean z10) {
        this.f21000d = z10;
    }
}
