package com.tencent.p204mm.opensdk.modelbase;

import android.os.Bundle;
import com.tencent.p204mm.opensdk.utils.C8928a;

/* loaded from: classes9.dex */
public abstract class BaseReq {
    public String openId;
    public String transaction;

    public abstract boolean checkArgs();

    public void fromBundle(Bundle bundle) {
        this.transaction = C8928a.m56644b(bundle, "_wxapi_basereq_transaction");
        this.openId = C8928a.m56644b(bundle, "_wxapi_basereq_openid");
    }

    public abstract int getType();

    public void toBundle(Bundle bundle) {
        bundle.putInt("_wxapi_command_type", getType());
        bundle.putString("_wxapi_basereq_transaction", this.transaction);
        bundle.putString("_wxapi_basereq_openid", this.openId);
    }
}
