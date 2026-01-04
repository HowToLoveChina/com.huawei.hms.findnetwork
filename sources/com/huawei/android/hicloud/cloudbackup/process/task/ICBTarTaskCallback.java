package com.huawei.android.hicloud.cloudbackup.process.task;

import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import fk.C9721b;

/* loaded from: classes2.dex */
public interface ICBTarTaskCallback extends ICBTaskCallback {
    void onOriginFileFail(SnapshotBackupMeta snapshotBackupMeta) throws C9721b;
}
