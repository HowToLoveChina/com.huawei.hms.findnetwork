package com.huawei.hicloud.service;

import android.content.Context;
import fk.C9721b;
import java.io.File;
import p015ak.C0213f;
import tm.C13040c;

/* renamed from: com.huawei.hicloud.service.k */
/* loaded from: classes.dex */
public class C5017k extends AbstractC5012g {
    public C5017k(String str) {
        super(str);
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public int getBuiltInVersion() {
        return 8;
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getConfigFilePath() {
        Context contextM1378b = C0213f.m1378b();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(contextM1378b.getFilesDir());
        String str = File.separator;
        sb2.append(str);
        sb2.append("recommend_card_config");
        sb2.append(str);
        sb2.append("HiCloudBrandHomePageBanner.json");
        return sb2.toString();
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public long getConfigVersion() throws C9721b {
        return getCfgVersion("HiCloudBrandHomePageBanner");
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getFileName() {
        return "HiCloudBrandHomePageBanner.json";
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getGeneralConfigVersionAddress() throws C9721b {
        return C13040c.m78609F().m78611B() + "/configserver/v2/hicloud/configs/changes?key=HiCloudBrandHomePageBanner";
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public boolean getLatestConfig() throws C9721b {
        return getLatestConfig("HiCloudBrandHomePageBanner");
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getLatestConfigAddress() throws C9721b {
        return C13040c.m78609F().m78611B() + "/configserver/v2/hicloud/configs/batch";
    }
}
