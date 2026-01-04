package com.huawei.openalliance.p169ad.magazine.inter.listener;

import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.magazine.inter.MagLockAdInfo;

@OuterVisible
/* loaded from: classes2.dex */
public interface MagLockListener {
    void onAdFailed(int i10);

    void onAdSuccess(MagLockAdInfo magLockAdInfo);

    void onNoSupport();
}
