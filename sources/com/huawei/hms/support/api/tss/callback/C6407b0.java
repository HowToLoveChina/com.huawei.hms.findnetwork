package com.huawei.hms.support.api.tss.callback;

import android.content.Context;
import com.huawei.hms.support.api.entity.tss.SupportKmsResp;
import org.json.JSONException;

/* renamed from: com.huawei.hms.support.api.tss.callback.b0 */
/* loaded from: classes8.dex */
public class C6407b0 extends AbstractC6435y<SupportKmsResp> {
    public C6407b0(Context context, String str, String str2, boolean z10) {
        super(context, str, str2, z10);
    }

    @Override // com.huawei.hms.support.api.tss.callback.AbstractC6435y
    /* renamed from: b */
    public SupportKmsResp mo36804b(String str) throws JSONException {
        return new SupportKmsResp(str);
    }
}
