package com.huawei.android.hicloud.cloudbackup.process.util;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import nu.C11754g;

/* loaded from: classes2.dex */
public interface ICycleChecker extends Comparable<ICycleChecker> {
    static ICycleChecker get(final Predicate<ICycleChecker> predicate) {
        return (ICycleChecker) C11754g.m70076k(ICycleChecker.class).sorted().filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.util.q
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ICycleChecker.lambda$get$1(predicate, (ICycleChecker) obj);
            }
        }).filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.process.util.r
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((ICycleChecker) obj).isValid();
            }
        }).findFirst().orElse(new OriginCycleChecker());
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ Boolean lambda$get$0(ICycleChecker iCycleChecker, Predicate predicate) {
        return Boolean.valueOf(predicate.test(iCycleChecker));
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$get$1(Predicate predicate, final ICycleChecker iCycleChecker) {
        return ((Boolean) Optional.ofNullable(predicate).map(new Function() { // from class: com.huawei.android.hicloud.cloudbackup.process.util.p
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ICycleChecker.lambda$get$0(this.f11751a, (Predicate) obj);
            }
        }).orElse(Boolean.TRUE)).booleanValue();
    }

    long getTargetBackupTime();

    String getType();

    boolean isCycleSatisfy();

    boolean isCycleSatisfy(long j10);

    boolean isSameCycle(long j10, long j11);

    boolean isValid();

    @Override // java.lang.Comparable
    default int compareTo(ICycleChecker iCycleChecker) {
        return getType().compareTo(iCycleChecker.getType());
    }
}
