package com.huawei.android.hicloud.cloudbackup.process.util;

import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import java.util.function.Predicate;

/* renamed from: com.huawei.android.hicloud.cloudbackup.process.util.f */
/* loaded from: classes2.dex */
public final /* synthetic */ class C2629f implements Predicate {
    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return ((BackupOptionItem) obj).getBackupSwitch();
    }
}
