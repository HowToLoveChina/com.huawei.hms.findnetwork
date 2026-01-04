package com.tencent.p204mm.opensdk.openapi;

import com.tencent.p204mm.opensdk.modelbase.BaseReq;
import com.tencent.p204mm.opensdk.modelbase.BaseResp;

/* loaded from: classes9.dex */
public interface IWXAPIEventHandler {
    void onReq(BaseReq baseReq);

    void onResp(BaseResp baseResp);
}
