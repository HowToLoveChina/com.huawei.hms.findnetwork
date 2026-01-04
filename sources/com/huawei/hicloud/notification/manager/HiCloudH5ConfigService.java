package com.huawei.hicloud.notification.manager;

import com.huawei.hicloud.service.AbstractC5012g;
import fk.C9721b;
import java.io.File;
import p015ak.C0213f;
import tm.C13040c;

/* loaded from: classes6.dex */
public class HiCloudH5ConfigService extends AbstractC5012g {
    public HiCloudH5ConfigService(String str) {
        super(str);
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public int getBuiltInVersion() {
        return 4;
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getConfigFilePath() {
        return C0213f.m1378b().getFilesDir() + File.separator + "HiCloudH5Incentive.json";
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public long getConfigVersion() throws C9721b {
        return getCfgVersion("HiCloudActivesH5");
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getFileName() {
        return "HiCloudH5Incentive.json";
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getGeneralConfigVersionAddress() throws C9721b {
        return C13040c.m78609F().m78611B() + "/configserver/v2/hicloud/configs/changes?key=HiCloudActivesH5";
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public boolean getLatestConfig() throws C9721b {
        return getLatestConfig("HiCloudActivesH5");
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getLatestConfigAddress() throws C9721b {
        return C13040c.m78609F().m78611B() + "/configserver/v2/hicloud/configs/batch";
    }
}
