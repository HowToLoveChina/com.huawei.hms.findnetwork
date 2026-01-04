package com.huawei.android.hicloud.cloudbackup.process;

import com.huawei.hicloud.notification.data.BackupSpaceNotEnoughNeedData;
import p015ak.C0213f;

/* loaded from: classes2.dex */
public class SpaceNotEnoughNotifyOlder implements IBackupNotEnoughNotify {
    @Override // com.huawei.android.hicloud.cloudbackup.process.IBackupNotEnoughNotify
    public boolean checkValid() {
        return true;
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.IBackupNotEnoughNotify
    public NotEnoughNotifyPriority getPriority() {
        return NotEnoughNotifyPriority.BEFORE_V5;
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.IBackupNotEnoughNotify
    public void sendSpaceNotEnough(boolean z10, BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData) {
        new UserSpaceUtil(C0213f.m1377a()).sendSpaceNotEnoughBeforeV5(z10, backupSpaceNotEnoughNeedData);
    }
}
