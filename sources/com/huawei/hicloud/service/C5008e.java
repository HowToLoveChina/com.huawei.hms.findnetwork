package com.huawei.hicloud.service;

import cn.C1461a;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.hicloud.bean.FeatureGray;
import com.huawei.hicloud.bean.FeatureSwitchRsp;
import com.huawei.hicloud.bean.GraySwitch;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import p016an.C0313a;
import p292fn.C9733f;
import p372ip.C10586d;
import p399jk.AbstractC10896a;
import p429kk.C11058a;
import p429kk.C11060c;
import p459lp.C11326d;
import p527on.C11976a;
import p709vj.C13452e;
import p710vk.C13457a;
import tm.C13040c;

/* renamed from: com.huawei.hicloud.service.e */
/* loaded from: classes.dex */
public class C5008e extends AbstractC5012g {

    /* renamed from: a */
    public static final Gson f22861a = new Gson();

    public C5008e(String str) {
        super(str);
    }

    /* renamed from: f */
    public static void m30038f() {
        int iM60763v = C9733f.m60705z().m60763v("interimBackupDisableThermalControl");
        AbstractC10896a.m65885d("FeatureSwitchConfigService", "update interim backup thermal control switch:" + iM60763v);
        C11326d.m68055q(new FeatureGray("interimBackupDisableThermalControl", iM60763v));
    }

    /* renamed from: a */
    public final void m30039a(List<GraySwitch> list, boolean z10) {
        if (list == null) {
            C1461a.m8358e("FeatureSwitchConfigService", "cloud null");
            return;
        }
        if (!z10 && !C9733f.m60705z().m60723R()) {
            C1461a.m8359i("FeatureSwitchConfigService", "cmpAndSaveGraySwitch clearFeatureSwitchDb ");
            C9733f.m60705z().m60747i();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        new C0313a().m1901d(arrayList);
    }

    /* renamed from: b */
    public FeatureSwitchRsp m30040b(String str, C11060c c11060c) throws C9721b {
        try {
            return (FeatureSwitchRsp) f22861a.fromJson((String) C11976a.m72086g(str, new C13457a("", this.traceId), c11060c), FeatureSwitchRsp.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(5004, "json err " + e10.getMessage());
        }
    }

    /* renamed from: c */
    public final C11060c m30041c() {
        if (this.traceId == null) {
            this.traceId = C11058a.m66627b("07010");
        }
        return C11058a.m66626a(this.traceId, "getChangedCfgListEx", C13452e.m80781L().m80971t0());
    }

    /* renamed from: d */
    public boolean m30042d() {
        return m30043e(false);
    }

    /* renamed from: e */
    public boolean m30043e(boolean z10) {
        C1461a.m8359i("FeatureSwitchConfigService", "getSwitchConfig isAgainUpdate" + z10);
        try {
            C11060c c11060cM30041c = m30041c();
            String generalConfigVersionAddress = getGeneralConfigVersionAddress();
            C1461a.m8357d("FeatureSwitchConfigService", "getSwitchConfig, url is " + generalConfigVersionAddress);
            new C10586d().call();
            m30039a(m30040b(generalConfigVersionAddress, c11060cM30041c).getGraySwitchs(), z10);
            C9733f.m60705z().m60752k0();
            m30038f();
            return true;
        } catch (C9721b e10) {
            C1461a.m8358e("FeatureSwitchConfigService", "getSwitchConfig err: " + e10.getMessage());
            return false;
        }
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public <T> T fromJson(String str, Class<T> cls) throws C9721b {
        try {
            return (T) f22861a.fromJson(str, (Class) cls);
        } catch (JsonSyntaxException unused) {
            throw new C9721b(5004, "json err " + str);
        }
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public int getBuiltInVersion() {
        return 1;
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getConfigFilePath() {
        return null;
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public long getConfigVersion() throws C9721b {
        return 0L;
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getFileName() {
        return null;
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getGeneralConfigVersionAddress() throws C9721b {
        return C13040c.m78609F().m78611B() + "/configserver/v1/hicloud/configs/grays/functions";
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public boolean getLatestConfig() throws C9721b {
        return false;
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getLatestConfigAddress() throws C9721b {
        return null;
    }
}
