package com.huawei.hms.support.api.tss.callback;

import android.content.Context;
import com.huawei.hms.support.api.entity.tss.GenerateKeyResp;
import org.json.JSONException;

/* renamed from: com.huawei.hms.support.api.tss.callback.j */
/* loaded from: classes8.dex */
public class C6420j extends AbstractC6435y<GenerateKeyResp> {
    public C6420j(Context context, String str, String str2, boolean z10) {
        super(context, str, str2, z10);
    }

    @Override // com.huawei.hms.support.api.tss.callback.AbstractC6435y
    /* renamed from: b */
    public GenerateKeyResp mo36804b(String str) throws JSONException {
        return new GenerateKeyResp(str);
    }
}
