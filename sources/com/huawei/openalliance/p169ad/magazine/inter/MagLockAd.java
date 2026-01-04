package com.huawei.openalliance.p169ad.magazine.inter;

import com.huawei.openalliance.p169ad.C7203hx;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import java.util.List;

@OuterVisible
/* loaded from: classes2.dex */
public interface MagLockAd {

    @OuterVisible
    public static final class Builder {
        @OuterVisible
        public final MagLockAd build() {
            return new C7203hx();
        }
    }

    List<MagLockAdContent> getAdList();

    int getRetCode();

    String getSlotId();

    void setAdList(List<MagLockAdContent> list);

    void setRetCode(int i10);

    void setSlotId(String str);
}
