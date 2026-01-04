package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.beans.server.AppDataCollectionReq;
import com.huawei.openalliance.p169ad.beans.server.AppDataCollectionRsp;
import com.huawei.openalliance.p169ad.net.http.Response;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.jv */
/* loaded from: classes8.dex */
public interface InterfaceC7348jv {
    @InterfaceC7365kl(m45451a = "appDataServer")
    @InterfaceC7360kg
    /* renamed from: a */
    Response<AppDataCollectionRsp> m45422a(@InterfaceC7356kc boolean z10, @InterfaceC7352jz AppDataCollectionReq appDataCollectionReq, @InterfaceC7358ke Map<String, String> map);
}
