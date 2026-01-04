package com.huawei.hms.support.api.tss.callback;

import android.content.Context;
import com.huawei.hms.support.api.entity.tss.EncryptDataResp;
import org.json.JSONException;

/* renamed from: com.huawei.hms.support.api.tss.callback.h */
/* loaded from: classes8.dex */
public class C6418h extends AbstractC6404a<EncryptDataResp> {
    public C6418h(Context context, String str, String str2, boolean z10) {
        super(context, str, str2, z10);
    }

    @Override // com.huawei.hms.support.api.tss.callback.AbstractC6404a
    /* renamed from: a */
    public EncryptDataResp mo36802a(String str) throws JSONException {
        return new EncryptDataResp(str);
    }
}
