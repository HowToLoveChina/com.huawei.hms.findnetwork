package com.huawei.android.hicloud.cloudbackup.process;

import com.huawei.hicloud.notification.data.BackupSpaceNotEnoughNeedData;
import java.util.Optional;
import java.util.function.Predicate;
import nu.C11754g;

/* loaded from: classes2.dex */
public interface IBackupNotEnoughNotify extends Comparable<IBackupNotEnoughNotify> {
    static Optional<IBackupNotEnoughNotify> get() {
        return C11754g.m70076k(IBackupNotEnoughNotify.class).sorted().filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.q0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((IBackupNotEnoughNotify) obj).checkValid();
            }
        }).findFirst();
    }

    boolean checkValid();

    NotEnoughNotifyPriority getPriority();

    void sendSpaceNotEnough(boolean z10, BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData);

    @Override // java.lang.Comparable
    default int compareTo(IBackupNotEnoughNotify iBackupNotEnoughNotify) {
        return getPriority().compareTo(iBackupNotEnoughNotify.getPriority());
    }
}
