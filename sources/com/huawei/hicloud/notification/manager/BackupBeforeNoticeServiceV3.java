package com.huawei.hicloud.notification.manager;

import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.service.AbstractC5012g;
import fk.C9721b;
import java.io.File;
import p015ak.C0213f;
import tm.C13040c;

/* loaded from: classes6.dex */
public class BackupBeforeNoticeServiceV3 extends AbstractC5012g {
    public BackupBeforeNoticeServiceV3(String str) {
        super(str);
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public int getBuiltInVersion() {
        return 1;
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getConfigFilePath() {
        return C0213f.m1377a().getFilesDir() + File.separator + "HiCloudBackupBeforeNotice.json";
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public long getConfigVersion() throws C9721b {
        return getCfgVersion(NotifyConstants.CLOUD_BACKUP_BEFORE_NOTICE);
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getFileName() {
        return "HiCloudBackupBeforeNotice.json";
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getGeneralConfigVersionAddress() throws C9721b {
        return C13040c.m78609F().m78611B() + "/configserver/v2/hicloud/configs/changes?key=" + NotifyConstants.CLOUD_BACKUP_BEFORE_NOTICE;
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public boolean getLatestConfig() throws C9721b {
        return getLatestConfig(NotifyConstants.CLOUD_BACKUP_BEFORE_NOTICE);
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getLatestConfigAddress() throws C9721b {
        return C13040c.m78609F().m78611B() + "/configserver/v2/hicloud/configs/batch";
    }
}
