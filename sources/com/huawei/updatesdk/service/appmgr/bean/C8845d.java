package com.huawei.updatesdk.service.appmgr.bean;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.huawei.updatesdk.p177a.p178a.p183d.C8783e;
import com.huawei.updatesdk.p177a.p178a.p183d.p184i.C8788b;
import com.huawei.updatesdk.p177a.p178a.p183d.p184i.C8789c;
import com.huawei.updatesdk.p177a.p186b.p187a.C8793a;
import com.huawei.updatesdk.p177a.p186b.p189c.p190c.AbstractC8799b;
import com.huawei.updatesdk.p191b.p195b.C8807a;
import com.huawei.updatesdk.p191b.p195b.C8809c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.huawei.updatesdk.service.appmgr.bean.d */
/* loaded from: classes9.dex */
public class C8845d extends C8809c {
    public static final String APIMETHOD = "client.updateCheck";
    public static final int DEFAULT_UPGRADE_RESULT = 0;
    public static final int FULL_UPGRADE_RESULT = 1;
    public static final int INSTALL_CHECK_DEFAULT = 0;
    private String agVersion_;

    @SDKNetTransmission
    private String cno;
    private C8788b deviceSpecParams_;
    private int getSafeGame_;
    private int gmsSupport_;

    @SDKNetTransmission
    private int hardwareType;

    @SDKNetTransmission
    private String harmonyDeviceType;
    private int installCheck_;
    private int isFullUpgrade_;

    @SDKNetTransmission
    private int isUpdateSdk;

    @SDKNetTransmission
    private String locale;
    private int mapleVer_;
    private String packageName_;

    @SDKNetTransmission
    private int pcEmulator;
    private a pkgInfo_;
    private String serviceCountry_;

    @SDKNetTransmission
    private int serviceType;
    private int supportMaple_;
    private int versionCode_;
    private String version_;

    /* renamed from: com.huawei.updatesdk.service.appmgr.bean.d$a */
    public static class a extends AbstractC8799b {
        private List<Param> params_;

        /* renamed from: a */
        public void m56388a(List<Param> list) {
            this.params_ = list;
        }
    }

    public C8845d() {
        this.serviceType = 0;
        this.isUpdateSdk = 1;
        this.installCheck_ = 0;
        this.isFullUpgrade_ = 0;
        this.getSafeGame_ = 1;
        this.supportMaple_ = 0;
        Context contextM56133a = C8793a.m56132c().m56133a();
        m56169a(APIMETHOD);
        m56171b("1.2");
        this.locale = C8789c.m56114k();
        m56387h(C8789c.m56107g(contextM56133a));
        m56385g(C8789c.m56104f(contextM56133a));
        m56375a(C8789c.m56113j(contextM56133a) ? 1 : 0);
        m56384f(C8793a.m56132c().m56133a().getPackageName());
        m56386g(C8807a.m56209d().m56210a());
        m56383f(C8789c.m56105f().m56119a());
        m56378c(C8789c.m56105f().m56121b());
        this.deviceSpecParams_ = new C8788b.b(contextM56133a).m56084a(true).m56085a();
        this.hardwareType = C8789c.m56102e();
        this.harmonyDeviceType = C8783e.m56050b();
        m56379d(C8789c.m56105f().m56122c());
    }

    /* renamed from: a */
    public static C8845d m56374a(List<PackageInfo> list) {
        C8845d c8845d = new C8845d();
        a aVar = new a();
        c8845d.m56376a(aVar);
        ArrayList arrayList = new ArrayList();
        aVar.m56388a(arrayList);
        Iterator<PackageInfo> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new Param(it.next()));
        }
        return c8845d;
    }

    /* renamed from: b */
    public void m56377b(int i10) {
        this.installCheck_ = i10;
    }

    /* renamed from: c */
    public void m56378c(int i10) {
        this.mapleVer_ = i10;
    }

    /* renamed from: d */
    public void m56379d(int i10) {
        this.pcEmulator = i10;
    }

    /* renamed from: e */
    public void m56381e(int i10) {
        this.serviceType = i10;
    }

    /* renamed from: f */
    public void m56383f(int i10) {
        this.supportMaple_ = i10;
    }

    /* renamed from: g */
    public void m56385g(int i10) {
        this.versionCode_ = i10;
    }

    /* renamed from: h */
    public void m56387h(String str) {
        this.version_ = str;
    }

    public C8845d(List<Param> list) {
        this();
        a aVar = new a();
        aVar.m56388a(list);
        m56376a(aVar);
    }

    /* renamed from: a */
    public void m56375a(int i10) {
        this.gmsSupport_ = i10;
    }

    /* renamed from: d */
    public void m56380d(String str) {
        this.agVersion_ = str;
    }

    /* renamed from: e */
    public void m56382e(String str) {
        this.cno = str;
    }

    /* renamed from: f */
    public void m56384f(String str) {
        this.packageName_ = str;
    }

    /* renamed from: g */
    public void m56386g(String str) {
        this.serviceCountry_ = str;
    }

    /* renamed from: a */
    public void m56376a(a aVar) {
        this.pkgInfo_ = aVar;
    }
}
