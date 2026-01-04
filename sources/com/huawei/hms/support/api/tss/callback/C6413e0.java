package com.huawei.hms.support.api.tss.callback;

import android.content.Context;
import com.huawei.hms.support.api.entity.tss.TransformEncryptDataResp;
import org.json.JSONException;

/* renamed from: com.huawei.hms.support.api.tss.callback.e0 */
/* loaded from: classes8.dex */
public class C6413e0 extends AbstractC6404a<TransformEncryptDataResp> {
    public C6413e0(Context context, String str, String str2, boolean z10) {
        super(context, str, str2, z10);
    }

    @Override // com.huawei.hms.support.api.tss.callback.AbstractC6404a
    /* renamed from: a */
    public TransformEncryptDataResp mo36802a(String str) throws JSONException {
        return new TransformEncryptDataResp(str);
    }
}
