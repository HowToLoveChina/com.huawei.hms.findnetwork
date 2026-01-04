package com.huawei.appgallery.coreservice.api;

import java.io.Serializable;
import p257eh.C9490l;

/* loaded from: classes4.dex */
public class ConnectConfig implements Cloneable, Serializable {

    /* renamed from: a */
    public String f20966a;

    /* renamed from: b */
    public String f20967b;

    /* renamed from: c */
    public String f20968c;

    /* renamed from: d */
    public String f20969d;

    /* renamed from: e */
    public String f20970e;

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public ConnectConfig m85644clone() {
        try {
            return (ConnectConfig) super.clone();
        } catch (CloneNotSupportedException e10) {
            C9490l.m59351c("ConnectConfig", "ConnectConfig Clone error:" + e10.getMessage());
            return null;
        }
    }

    public String getAppFingerprintSignature() {
        return this.f20970e;
    }

    public String getAppSignCertchain() {
        return this.f20969d;
    }

    public String getConnectAppPkg() {
        return this.f20967b;
    }

    public String getConnectServiceAction() {
        return this.f20966a;
    }

    public String getInstallAppName() {
        return this.f20968c;
    }

    public void setAppFingerprintSignature(String str) {
        this.f20970e = str;
    }

    public void setAppSignCertchain(String str) {
        this.f20969d = str;
    }

    public void setConnectAppPkg(String str) {
        this.f20967b = str;
    }

    public void setConnectServiceAction(String str) {
        this.f20966a = str;
    }

    public void setInstallAppName(String str) {
        this.f20968c = str;
    }
}
