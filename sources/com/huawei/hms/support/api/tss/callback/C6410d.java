package com.huawei.hms.support.api.tss.callback;

import android.content.Context;
import com.huawei.hms.support.api.entity.tss.DecryptDataResp;
import org.json.JSONException;

/* renamed from: com.huawei.hms.support.api.tss.callback.d */
/* loaded from: classes8.dex */
public class C6410d extends AbstractC6404a<DecryptDataResp> {
    public C6410d(Context context, String str, String str2, boolean z10) {
        super(context, str, str2, z10);
    }

    @Override // com.huawei.hms.support.api.tss.callback.AbstractC6404a
    /* renamed from: a */
    public DecryptDataResp mo36802a(String str) throws JSONException {
        return new DecryptDataResp(str);
    }
}
