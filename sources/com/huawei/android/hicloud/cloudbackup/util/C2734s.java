package com.huawei.android.hicloud.cloudbackup.util;

import com.huawei.android.hicloud.cloudbackup.bean.BackupMemberPrivilege;
import java.util.function.ToIntFunction;

/* renamed from: com.huawei.android.hicloud.cloudbackup.util.s */
/* loaded from: classes2.dex */
public final /* synthetic */ class C2734s implements ToIntFunction {
    @Override // java.util.function.ToIntFunction
    public final int applyAsInt(Object obj) {
        return ((BackupMemberPrivilege.AutoBackupFrequency) obj).getIndex();
    }
}
