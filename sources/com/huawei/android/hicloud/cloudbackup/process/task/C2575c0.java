package com.huawei.android.hicloud.cloudbackup.process.task;

import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import java.util.function.Function;

/* renamed from: com.huawei.android.hicloud.cloudbackup.process.task.c0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class C2575c0 implements Function {
    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((BackupOptionItem) obj).getAppId();
    }
}
