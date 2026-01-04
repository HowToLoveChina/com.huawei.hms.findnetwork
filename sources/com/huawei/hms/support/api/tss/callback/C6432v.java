package com.huawei.hms.support.api.tss.callback;

import android.content.Context;
import com.huawei.hms.support.api.entity.tss.KeyDerivationResp;
import org.json.JSONException;

/* renamed from: com.huawei.hms.support.api.tss.callback.v */
/* loaded from: classes8.dex */
public class C6432v extends AbstractC6435y<KeyDerivationResp> {
    public C6432v(Context context, String str, String str2, boolean z10) {
        super(context, str, str2, z10);
    }

    @Override // com.huawei.hms.support.api.tss.callback.AbstractC6435y
    /* renamed from: b */
    public KeyDerivationResp mo36804b(String str) throws JSONException {
        return new KeyDerivationResp(str);
    }
}
