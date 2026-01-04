package com.huawei.hicloud.notification.manager;

import com.huawei.hicloud.service.AbstractC5012g;
import fk.C9721b;
import java.io.File;
import p015ak.C0213f;
import tm.C13040c;

/* loaded from: classes6.dex */
public class DataUpperLimitNoticeService extends AbstractC5012g {
    public DataUpperLimitNoticeService(String str) {
        super(str);
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public int getBuiltInVersion() {
        return 1;
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getConfigFilePath() {
        return C0213f.m1377a().getFilesDir() + File.separator + "HiCloudDataUpperLimitNotice.json";
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public long getConfigVersion() throws C9721b {
        return getCfgVersion("HiCloudDataUpperLimitNotice");
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getFileName() {
        return "HiCloudDataUpperLimitNotice.json";
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getGeneralConfigVersionAddress() throws C9721b {
        return C13040c.m78609F().m78611B() + "/configserver/v2/hicloud/configs/changes?key=HiCloudDataUpperLimitNotice";
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public boolean getLatestConfig() throws C9721b {
        return getLatestConfig("HiCloudDataUpperLimitNotice");
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getLatestConfigAddress() throws C9721b {
        return C13040c.m78609F().m78611B() + "/configserver/v2/hicloud/configs/batch";
    }
}
