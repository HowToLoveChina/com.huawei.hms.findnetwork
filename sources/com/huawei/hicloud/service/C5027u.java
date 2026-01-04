package com.huawei.hicloud.service;

import android.content.Context;
import fk.C9721b;
import java.io.File;
import p015ak.C0213f;
import tm.C13040c;

/* renamed from: com.huawei.hicloud.service.u */
/* loaded from: classes.dex */
public class C5027u extends AbstractC5012g {
    public C5027u(String str) {
        super(str);
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public int getBuiltInVersion() {
        return 1;
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
        sb2.append("HiCloudSceneBuyBanner.json");
        return sb2.toString();
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public long getConfigVersion() throws C9721b {
        return getCfgVersion("HiCloudSceneBuyBanner");
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getFileName() {
        return "HiCloudSceneBuyBanner.json";
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getGeneralConfigVersionAddress() throws C9721b {
        return C13040c.m78609F().m78611B() + "/configserver/v2/hicloud/configs/changes?key=HiCloudSceneBuyBanner";
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public boolean getLatestConfig() throws C9721b {
        return getLatestConfig("HiCloudSceneBuyBanner");
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getLatestConfigAddress() throws C9721b {
        return C13040c.m78609F().m78611B() + "/configserver/v2/hicloud/configs/batch";
    }
}
