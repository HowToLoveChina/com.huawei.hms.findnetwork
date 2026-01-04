package com.huawei.android.backup.service.logic;

import com.huawei.android.backup.service.model.BackupFileModuleInfo;
import p279f6.C9659b;

/* renamed from: com.huawei.android.backup.service.logic.c */
/* loaded from: classes.dex */
public abstract class AbstractC2127c extends BackupObject {
    @Override // com.huawei.android.backup.service.logic.BackupObject
    public BackupFileModuleInfo buildBackupFileModuleInfo() {
        return new C9659b();
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public int getModuleType() {
        return 1;
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public BackupFileModuleInfo buildBackupFileModuleInfo(Class<? extends BackupObject> cls) {
        return new C9659b(cls);
    }
}
