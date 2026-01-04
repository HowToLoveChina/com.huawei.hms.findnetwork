package com.huawei.hms.support.api.tss.callback;

import android.content.Context;
import com.huawei.hms.support.api.entity.tss.RemoveKeyResp;
import org.json.JSONException;

/* renamed from: com.huawei.hms.support.api.tss.callback.z */
/* loaded from: classes8.dex */
public class C6436z extends AbstractC6435y<RemoveKeyResp> {
    public C6436z(Context context, String str, String str2, boolean z10) {
        super(context, str, str2, z10);
    }

    @Override // com.huawei.hms.support.api.tss.callback.AbstractC6435y
    /* renamed from: b */
    public RemoveKeyResp mo36804b(String str) throws JSONException {
        return new RemoveKeyResp(str);
    }
}
