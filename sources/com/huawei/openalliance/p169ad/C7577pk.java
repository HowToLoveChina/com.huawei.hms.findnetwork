package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.beans.server.AdContentRsp;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import com.huawei.openalliance.p169ad.inter.data.IPlacementAd;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.pk */
/* loaded from: classes8.dex */
public class C7577pk extends AbstractC7548op {
    public C7577pk(Context context, InterfaceC7622qx interfaceC7622qx) {
        super(context, interfaceC7622qx);
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7548op
    /* renamed from: b */
    public void mo46373b(AdContentRsp adContentRsp) {
        if (adContentRsp == null) {
            this.f35107c.mo44171a(ErrorCode.ERROR_CODE_OTHER);
            AbstractC7185ho.m43823c("PlacementPreloadProcessor", "response is null");
            return;
        }
        Map<String, List<IPlacementAd>> mapM46372b = m46372b(adContentRsp.m40842f());
        boolean zIsEmpty = mapM46372b.isEmpty();
        InterfaceC7622qx interfaceC7622qx = this.f35107c;
        if (zIsEmpty) {
            interfaceC7622qx.mo44171a(800);
        } else {
            interfaceC7622qx.mo44172a(null, mapM46372b);
        }
    }
}
