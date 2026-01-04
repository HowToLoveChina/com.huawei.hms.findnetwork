package com.huawei.hms.support.api.tss.callback;

import android.content.Context;
import com.huawei.hms.support.api.entity.tss.KeyExportResp;
import org.json.JSONException;

/* renamed from: com.huawei.hms.support.api.tss.callback.w */
/* loaded from: classes8.dex */
public class C6433w extends AbstractC6435y<KeyExportResp> {
    public C6433w(Context context, String str, String str2, boolean z10) {
        super(context, str, str2, z10);
    }

    @Override // com.huawei.hms.support.api.tss.callback.AbstractC6435y
    /* renamed from: b */
    public KeyExportResp mo36804b(String str) throws JSONException {
        return new KeyExportResp(str);
    }
}
