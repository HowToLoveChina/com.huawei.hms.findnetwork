package com.huawei.hms.support.api.tss.callback;

import android.content.Context;
import com.huawei.hms.support.api.entity.tss.SupportMkResp;
import org.json.JSONException;

/* renamed from: com.huawei.hms.support.api.tss.callback.c0 */
/* loaded from: classes8.dex */
public class C6409c0 extends AbstractC6435y<SupportMkResp> {
    public C6409c0(Context context, String str, String str2, boolean z10) {
        super(context, str, str2, z10);
    }

    @Override // com.huawei.hms.support.api.tss.callback.AbstractC6435y
    /* renamed from: b */
    public SupportMkResp mo36804b(String str) throws JSONException {
        return new SupportMkResp(str);
    }
}
