package com.huawei.hms.ads.consent.bean.network;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import java.util.ArrayList;
import java.util.List;

@DataKeep
/* loaded from: classes8.dex */
public class ConfirmResultReq {
    private List<ApiStatisticsReq> caches = new ArrayList();

    @OuterVisible
    public List<ApiStatisticsReq> getCaches() {
        return this.caches;
    }

    @OuterVisible
    public void setCaches(List<ApiStatisticsReq> list) {
        this.caches = list;
    }
}
