package com.huawei.hms.support.api.tss.callback;

import android.content.Context;
import com.huawei.hms.support.api.entity.tss.HasKeyResp;
import org.json.JSONException;

/* renamed from: com.huawei.hms.support.api.tss.callback.u */
/* loaded from: classes8.dex */
public class C6431u extends AbstractC6435y<HasKeyResp> {
    public C6431u(Context context, String str, String str2, boolean z10) {
        super(context, str, str2, z10);
    }

    @Override // com.huawei.hms.support.api.tss.callback.AbstractC6435y
    /* renamed from: b */
    public HasKeyResp mo36804b(String str) throws JSONException {
        return new HasKeyResp(str);
    }
}
