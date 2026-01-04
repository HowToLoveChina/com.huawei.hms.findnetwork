package com.huawei.hms.support.api.tss.callback;

import android.content.Context;
import com.huawei.hms.support.api.entity.tss.EnrollCertResp;
import org.json.JSONException;

/* renamed from: com.huawei.hms.support.api.tss.callback.i */
/* loaded from: classes8.dex */
public class C6419i extends AbstractC6404a<EnrollCertResp> {
    public C6419i(Context context, String str, String str2, boolean z10) {
        super(context, str, str2, z10);
    }

    @Override // com.huawei.hms.support.api.tss.callback.AbstractC6404a
    /* renamed from: a */
    public EnrollCertResp mo36802a(String str) throws JSONException {
        return new EnrollCertResp(str);
    }
}
