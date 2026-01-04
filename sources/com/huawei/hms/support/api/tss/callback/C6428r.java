package com.huawei.hms.support.api.tss.callback;

import android.content.Context;
import com.huawei.hms.support.api.entity.tss.GetPublicKeyResp;
import org.json.JSONException;

/* renamed from: com.huawei.hms.support.api.tss.callback.r */
/* loaded from: classes8.dex */
public class C6428r extends AbstractC6435y<GetPublicKeyResp> {
    public C6428r(Context context, String str, String str2, boolean z10) {
        super(context, str, str2, z10);
    }

    @Override // com.huawei.hms.support.api.tss.callback.AbstractC6435y
    /* renamed from: b */
    public GetPublicKeyResp mo36804b(String str) throws JSONException {
        return new GetPublicKeyResp(str);
    }
}
