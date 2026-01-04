package com.huawei.openalliance.p169ad.inter.data;

import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import java.util.Map;

@OuterVisible
/* loaded from: classes2.dex */
public interface IPreCheckInfo {
    String getContentId();

    Map<String, String> getExt();

    int getPreCheckResult();

    String getSlotId();

    boolean isStrategyFiltered();
}
