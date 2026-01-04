package com.huawei.android.hicloud.cloudbackup.process.task;

import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import java.util.function.ToLongFunction;

/* renamed from: com.huawei.android.hicloud.cloudbackup.process.task.y */
/* loaded from: classes2.dex */
public final /* synthetic */ class C2612y implements ToLongFunction {
    @Override // java.util.function.ToLongFunction
    public final long applyAsLong(Object obj) {
        return ((BackupOptionItem) obj).getDataBytes();
    }
}
