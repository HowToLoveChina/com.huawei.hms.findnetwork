package com.huawei.openalliance.p169ad.p171db.bean;

import com.huawei.openalliance.p169ad.annotations.DataKeep;

@DataKeep
/* loaded from: classes2.dex */
public class SdkCfgSha256Record extends C7013a {
    public static final String PKGNAME = "pkgName";
    public static final String SHA256 = "sha256";
    String pkgName;
    String sha256;

    /* renamed from: a */
    public String m41816a() {
        return this.pkgName;
    }

    /* renamed from: b */
    public String m41818b() {
        return this.sha256;
    }

    /* renamed from: a */
    public void m41817a(String str) {
        this.pkgName = str;
    }

    /* renamed from: b */
    public void m41819b(String str) {
        this.sha256 = str;
    }
}
