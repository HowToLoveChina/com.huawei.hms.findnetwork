package com.huawei.hicloud.service;

import android.content.Intent;
import cn.C1461a;
import fk.C9721b;
import java.io.File;
import p015ak.C0213f;
import p664u0.C13108a;
import tm.C13040c;

/* renamed from: com.huawei.hicloud.service.z */
/* loaded from: classes.dex */
public class C5032z extends AbstractC5012g {
    public C5032z(String str) {
        super(str);
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public int getBuiltInVersion() {
        return 3;
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getConfigFilePath() {
        return C0213f.m1378b().getFilesDir() + File.separator + "HiCloudSpacePositionMgr.json";
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public long getConfigVersion() throws C9721b {
        return getCfgVersion("HiCloudSpacePositionMgr");
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getFileName() {
        return "HiCloudSpacePositionMgr.json";
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getGeneralConfigVersionAddress() throws C9721b {
        return C13040c.m78609F().m78611B() + "/configserver/v2/hicloud/configs/changes?key=HiCloudSpacePositionMgr";
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public boolean getLatestConfig() throws C9721b {
        boolean latestConfig = getLatestConfig("HiCloudSpacePositionMgr");
        C1461a.m8357d("HiCloudSpacePositionMgrService", "getLatestConfig is success: " + latestConfig);
        if (latestConfig) {
            C13108a.m78878b(C0213f.m1377a()).m78881d(new Intent("com.huawei.hicloud.intent.action.HICLOUD_SPACE_POSITION_MGR_REFRESH_FINISH_ACTION"));
            C1461a.m8357d("HiCloudSpacePositionMgrService", "send Broadcast");
        }
        return latestConfig;
    }

    @Override // com.huawei.hicloud.service.AbstractC5012g
    public String getLatestConfigAddress() throws C9721b {
        return C13040c.m78609F().m78611B() + "/configserver/v2/hicloud/configs/batch";
    }
}
