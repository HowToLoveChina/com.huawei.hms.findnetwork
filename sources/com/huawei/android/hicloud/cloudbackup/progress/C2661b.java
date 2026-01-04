package com.huawei.android.hicloud.cloudbackup.progress;

import com.huawei.hicloud.cloudbackup.model.CloudRestoreItem;
import java.util.function.Predicate;

/* renamed from: com.huawei.android.hicloud.cloudbackup.progress.b */
/* loaded from: classes2.dex */
public final /* synthetic */ class C2661b implements Predicate {
    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return ((CloudRestoreItem) obj).isCompatible();
    }
}
