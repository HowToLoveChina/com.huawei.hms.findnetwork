package com.huawei.openalliance.p169ad.inter;

import com.huawei.openalliance.p169ad.annotations.OuterVisible;

@OuterVisible
/* loaded from: classes2.dex */
public interface IAdContentResponseParser {
    void processAdResponse(String str);

    void processAdResponse(String str, AdParseConfig adParseConfig);

    void processAdResponse(String str, boolean z10);

    void startCache(int i10);

    void stopCache();
}
