package com.huawei.updatesdk.service.appmgr.bean;

import android.text.TextUtils;
import com.huawei.updatesdk.p177a.p186b.p189c.p190c.AbstractC8799b;

/* renamed from: com.huawei.updatesdk.service.appmgr.bean.c */
/* loaded from: classes9.dex */
public class C8844c extends AbstractC8799b {

    @SDKNetTransmission
    private String appName;

    @SDKNetTransmission
    private String downUrl;

    @SDKNetTransmission
    private long fileSize;

    @SDKNetTransmission
    private String pkgName;

    @SDKNetTransmission
    private String sha256;

    @SDKNetTransmission
    private long versionCode;

    @SDKNetTransmission
    private String versionName;

    /* renamed from: a */
    public String m56368a() {
        return this.appName;
    }

    /* renamed from: b */
    public String m56369b() {
        return this.downUrl;
    }

    /* renamed from: c */
    public long m56370c() {
        return this.fileSize;
    }

    /* renamed from: d */
    public String m56371d() {
        return this.pkgName;
    }

    /* renamed from: e */
    public String m56372e() {
        return this.sha256;
    }

    /* renamed from: f */
    public boolean m56373f() {
        return (TextUtils.isEmpty(this.sha256) || TextUtils.isEmpty(this.downUrl) || this.fileSize <= 0) ? false : true;
    }
}
