package com.huawei.hicloud.service;

import fk.C9721b;
import java.io.File;
import p015ak.C0213f;
import tm.C13040c;

/* renamed from: com.huawei.hicloud.service.r */
/* loaded from: classes.dex */
public class C5024r extends AbstractC5012g {
    public C5024r(String str) {
        super(str);
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public int getBuiltInVersion() {
        return 1;
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getConfigFilePath() {
        return C0213f.m1377a().getFilesDir() + File.separator + "HiCloudParamMeta.json";
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public long getConfigVersion() throws C9721b {
        return getCfgVersion("HiCloudParamMeta");
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getFileName() {
        return "HiCloudParamMeta.json";
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getGeneralConfigVersionAddress() throws C9721b {
        return C13040c.m78609F().m78611B() + "/configserver/v2/hicloud/configs/changes?key=HiCloudParamMeta";
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public boolean getLatestConfig() throws C9721b {
        return getLatestConfig("HiCloudParamMeta");
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getLatestConfigAddress() throws C9721b {
        return C13040c.m78609F().m78611B() + "/configserver/v2/hicloud/configs/batch";
    }
}
