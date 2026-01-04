package com.huawei.hicloud.notification;

import com.huawei.hicloud.notification.bean.NotifyNeedData;
import com.huawei.hicloud.notification.p106db.bean.SpaceNotification;

/* loaded from: classes6.dex */
public interface ICloudBackupNotifyProxy {
    NotifyNeedData buildAlbumSpaceNeedData(SpaceNotification spaceNotification, String str, long j10);

    boolean isAlbumOn();

    boolean isBackupClearsConditionAllow();

    boolean isHasActivityEntry(int i10);

    boolean isHasCampaignActivityData(int i10);

    boolean showNotify(boolean z10, long j10);
}
