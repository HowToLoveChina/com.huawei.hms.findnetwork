package com.huawei.hicloud.service;

import android.content.Context;
import android.text.TextUtils;
import cn.C1461a;
import fk.C9721b;
import java.io.File;
import p015ak.C0213f;
import p709vj.C13452e;
import tm.C13040c;

/* renamed from: com.huawei.hicloud.service.b */
/* loaded from: classes.dex */
public class C5002b extends AbstractC5012g {

    /* renamed from: a */
    public String f22859a;

    public C5002b(String str) {
        super(str);
    }

    /* renamed from: a */
    public void m30029a() {
        if (getBuiltInVersion() == 4) {
            Context contextM1377a = C0213f.m1377a();
            if (contextM1377a == null) {
                C1461a.m8358e("BannerConfigService", "deleteOldBannerConfig context is null.");
                return;
            }
            File file = new File(contextM1377a.getFilesDir() + "/HiCloudBannerConfig.json");
            if (file.exists() && file.delete()) {
                C1461a.m8359i("BannerConfigService", "deleteOldBannerConfig success.");
            }
        }
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public int getBuiltInVersion() {
        return 4;
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getConfigFilePath() {
        return C0213f.m1377a().getFilesDir() + File.separator + "UpgradeHiCloudBannerConfig.json";
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public long getConfigVersion() throws C9721b {
        return getCfgVersion("HiCloudSpaceBannerConfigV2");
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getFileName() {
        return "UpgradeHiCloudBannerConfig.json";
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getGeneralConfigVersionAddress() throws C9721b {
        return C13040c.m78609F().m78611B() + "/configserver/v2/hicloud/configs/changes?key=HiCloudSpaceBannerConfigV2";
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public boolean getLatestConfig() throws C9721b {
        return getLatestConfig("HiCloudSpaceBannerConfigV2");
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getLatestConfigAddress() throws C9721b {
        return C13040c.m78609F().m78611B() + "/configserver/v2/hicloud/configs/batch";
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getServiceCountry() {
        return !TextUtils.isEmpty(this.f22859a) ? this.f22859a : C13452e.m80781L().m80942m();
    }
}
