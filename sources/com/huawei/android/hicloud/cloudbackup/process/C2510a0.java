package com.huawei.android.hicloud.cloudbackup.process;

import com.huawei.android.hicloud.cloudbackup.manager.CloudBackupTaskManager;
import com.huawei.android.hicloud.cloudbackup.process.util.ProgressCallback;

/* renamed from: com.huawei.android.hicloud.cloudbackup.process.a0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class C2510a0 implements CloudBackupTaskManager.Await {

    /* renamed from: a */
    public final /* synthetic */ ProgressCallback f11685a;

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupTaskManager.Await
    public final boolean isAbort() {
        return this.f11685a.onStop();
    }
}
