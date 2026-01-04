package com.huawei.hms.support.api.tss.callback;

import android.content.Context;
import com.huawei.hms.support.api.entity.tss.VerifySignatureResp;
import org.json.JSONException;

/* renamed from: com.huawei.hms.support.api.tss.callback.g0 */
/* loaded from: classes8.dex */
public class C6417g0 extends AbstractC6404a<VerifySignatureResp> {
    public C6417g0(Context context, String str, String str2, boolean z10) {
        super(context, str, str2, z10);
    }

    @Override // com.huawei.hms.support.api.tss.callback.AbstractC6404a
    /* renamed from: a */
    public VerifySignatureResp mo36802a(String str) throws JSONException {
        return new VerifySignatureResp(str);
    }
}
