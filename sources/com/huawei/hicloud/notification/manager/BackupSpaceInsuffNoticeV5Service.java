package com.huawei.hicloud.notification.manager;

import com.huawei.hicloud.service.AbstractC5012g;
import fk.C9721b;
import java.io.File;
import p015ak.C0213f;
import tm.C13040c;

/* loaded from: classes6.dex */
public class BackupSpaceInsuffNoticeV5Service extends AbstractC5012g {
    private static final String TAG = "BackupSpaceInsuffNoticeV5Service";

    public BackupSpaceInsuffNoticeV5Service(String str) {
        super(str);
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public int getBuiltInVersion() {
        return 2;
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getConfigFilePath() {
        return C0213f.m1377a().getFilesDir() + File.separator + getFileName();
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public long getConfigVersion() throws C9721b {
        return getCfgVersion("HiCloudBackupSpaceInsuffNoticeV5");
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getFileName() {
        return "HiCloudBackupSpaceInsuffNoticeV5.json";
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getGeneralConfigVersionAddress() throws C9721b {
        return C13040c.m78609F().m78611B() + "/configserver/v2/hicloud/configs/changes?key=HiCloudBackupSpaceInsuffNoticeV5";
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public boolean getLatestConfig() throws C9721b {
        return getLatestConfig("HiCloudBackupSpaceInsuffNoticeV5");
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getLatestConfigAddress() throws C9721b {
        return C13040c.m78609F().m78611B() + "/configserver/v2/hicloud/configs/batch";
    }
}
