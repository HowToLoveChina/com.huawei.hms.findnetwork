package com.huawei.hms.support.api.tss.callback;

import android.content.Context;
import com.huawei.hms.support.api.entity.tss.EcdhForKdResp;
import org.json.JSONException;

/* renamed from: com.huawei.hms.support.api.tss.callback.f */
/* loaded from: classes8.dex */
public class C6414f extends AbstractC6435y<EcdhForKdResp> {
    public C6414f(Context context, String str, String str2, boolean z10) {
        super(context, str, str2, z10);
    }

    @Override // com.huawei.hms.support.api.tss.callback.AbstractC6435y
    /* renamed from: b */
    public EcdhForKdResp mo36804b(String str) throws JSONException {
        return new EcdhForKdResp(str);
    }
}
