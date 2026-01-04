package com.huawei.hicloud.notification.manager;

import com.huawei.hicloud.notification.p106db.bean.ForceUpgradeConfiguration;
import java.util.Objects;
import java.util.function.Predicate;

/* renamed from: com.huawei.hicloud.notification.manager.a */
/* loaded from: classes6.dex */
public final /* synthetic */ class C4949a implements Predicate {
    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return Objects.nonNull((ForceUpgradeConfiguration) obj);
    }
}
