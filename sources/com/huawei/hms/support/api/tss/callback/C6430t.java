package com.huawei.hms.support.api.tss.callback;

import android.content.Context;
import com.huawei.hms.support.api.entity.tss.GetTaVersionResp;
import org.json.JSONException;

/* renamed from: com.huawei.hms.support.api.tss.callback.t */
/* loaded from: classes8.dex */
public class C6430t extends AbstractC6404a<GetTaVersionResp> {
    public C6430t(Context context, String str, String str2, boolean z10) {
        super(context, str, str2, z10);
    }

    @Override // com.huawei.hms.support.api.tss.callback.AbstractC6404a
    /* renamed from: a */
    public GetTaVersionResp mo36802a(String str) throws JSONException {
        return new GetTaVersionResp(str);
    }
}
