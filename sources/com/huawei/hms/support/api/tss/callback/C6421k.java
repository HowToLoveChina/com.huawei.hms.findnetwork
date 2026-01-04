package com.huawei.hms.support.api.tss.callback;

import android.content.Context;
import com.huawei.hms.support.api.entity.tss.GetAttestCertChainResp;
import org.json.JSONException;

/* renamed from: com.huawei.hms.support.api.tss.callback.k */
/* loaded from: classes8.dex */
public class C6421k extends AbstractC6404a<GetAttestCertChainResp> {
    public C6421k(Context context, String str, String str2, boolean z10) {
        super(context, str, str2, z10);
    }

    @Override // com.huawei.hms.support.api.tss.callback.AbstractC6404a
    /* renamed from: a */
    public GetAttestCertChainResp mo36802a(String str) throws JSONException {
        return new GetAttestCertChainResp(str);
    }
}
