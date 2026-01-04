package com.huawei.hicloud.notification.syncconfig;

import com.huawei.hicloud.bean.DriveConfigService;
import com.huawei.hicloud.bean.SyncConfigService;
import java.util.List;

/* loaded from: classes6.dex */
public interface IStructureNumFinished {
    void onDriveConfigTaskFinished(List<DriveConfigService> list);

    void onNormalTaskFinished(String str);

    void onSyncConfigTaskFinished(List<SyncConfigService> list);
}
