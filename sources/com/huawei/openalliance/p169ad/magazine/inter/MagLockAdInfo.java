package com.huawei.openalliance.p169ad.magazine.inter;

import com.huawei.openalliance.p169ad.C7204hy;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import java.util.List;

@OuterVisible
/* loaded from: classes2.dex */
public interface MagLockAdInfo {

    @OuterVisible
    public static final class Builder {
        @OuterVisible
        public final MagLockAdInfo build() {
            return new C7204hy();
        }
    }

    List<MagLockAd> getMultiAds();

    int getRetCode();

    void setMultiAds(List<MagLockAd> list);

    void setRetCode(int i10);
}
