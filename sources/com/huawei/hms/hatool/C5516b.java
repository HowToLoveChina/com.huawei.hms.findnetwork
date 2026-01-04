package com.huawei.hms.hatool;

import android.content.Context;

/* renamed from: com.huawei.hms.hatool.b */
/* loaded from: classes8.dex */
public class C5516b {

    /* renamed from: a */
    C5566s0 f25144a;

    /* renamed from: b */
    C5566s0 f25145b;

    /* renamed from: c */
    Context f25146c;

    /* renamed from: d */
    String f25147d;

    public C5516b(Context context) {
        if (context != null) {
            this.f25146c = context.getApplicationContext();
        }
        this.f25144a = new C5566s0();
        this.f25145b = new C5566s0();
    }

    /* renamed from: a */
    public C5516b m32441a(int i10, String str) {
        C5566s0 c5566s0;
        C5571v.m32786a("hmsSdk", "Builder.setCollectURL(int type,String collectURL) is execute.TYPE : " + i10);
        if (!C5560p1.m32697b(str)) {
            str = "";
        }
        if (i10 == 0) {
            c5566s0 = this.f25144a;
        } else {
            if (i10 != 1) {
                C5571v.m32797f("hmsSdk", "Builder.setCollectURL(int type,String collectURL): invalid type!");
                return this;
            }
            c5566s0 = this.f25145b;
        }
        c5566s0.m32747b(str);
        return this;
    }

    @Deprecated
    /* renamed from: b */
    public C5516b m32445b(boolean z10) {
        C5571v.m32786a("hmsSdk", "Builder.setEnableSN(boolean isReportSN) is execute.");
        this.f25144a.m32764j().m32588b(z10);
        this.f25145b.m32764j().m32588b(z10);
        return this;
    }

    @Deprecated
    /* renamed from: c */
    public C5516b m32446c(boolean z10) {
        C5571v.m32786a("hmsSdk", "Builder.setEnableUDID(boolean isReportUDID) is execute.");
        this.f25144a.m32764j().m32590c(z10);
        this.f25145b.m32764j().m32590c(z10);
        return this;
    }

    /* renamed from: a */
    public C5516b m32442a(String str) {
        C5571v.m32786a("hmsSdk", "Builder.setAppID is execute");
        this.f25147d = str;
        return this;
    }

    @Deprecated
    /* renamed from: a */
    public C5516b m32443a(boolean z10) {
        C5571v.m32786a("hmsSdk", "Builder.setEnableImei(boolean isReportAndroidImei) is execute.");
        this.f25144a.m32764j().m32586a(z10);
        this.f25145b.m32764j().m32586a(z10);
        return this;
    }

    /* renamed from: a */
    public void m32444a() {
        if (this.f25146c == null) {
            C5571v.m32789b("hmsSdk", "analyticsConf create(): context is null,create failed!");
            return;
        }
        C5571v.m32786a("hmsSdk", "Builder.create() is execute.");
        C5580z0 c5580z0 = new C5580z0("_hms_config_tag");
        c5580z0.m32846b(new C5566s0(this.f25144a));
        c5580z0.m32844a(new C5566s0(this.f25145b));
        C5549m.m32633a().m32635a(this.f25146c);
        C5532g0.m32514a().m32517a(this.f25146c);
        C5561q.m32698c().m32699a(c5580z0);
        C5549m.m32633a().m32636a(this.f25147d);
    }
}
