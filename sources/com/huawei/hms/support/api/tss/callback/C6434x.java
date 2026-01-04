package com.huawei.hms.support.api.tss.callback;

import android.content.Context;
import com.huawei.hms.support.api.entity.tss.KeyImportResp;
import org.json.JSONException;

/* renamed from: com.huawei.hms.support.api.tss.callback.x */
/* loaded from: classes8.dex */
public class C6434x extends AbstractC6435y<KeyImportResp> {
    public C6434x(Context context, String str, String str2, boolean z10) {
        super(context, str, str2, z10);
    }

    @Override // com.huawei.hms.support.api.tss.callback.AbstractC6435y
    /* renamed from: b */
    public KeyImportResp mo36804b(String str) throws JSONException {
        return new KeyImportResp(str);
    }
}
