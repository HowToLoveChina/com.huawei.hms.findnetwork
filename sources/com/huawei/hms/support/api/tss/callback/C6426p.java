package com.huawei.hms.support.api.tss.callback;

import android.content.Context;
import com.huawei.hms.support.api.entity.tss.GetKeyInfoResp;
import org.json.JSONException;

/* renamed from: com.huawei.hms.support.api.tss.callback.p */
/* loaded from: classes8.dex */
public class C6426p extends AbstractC6435y<GetKeyInfoResp> {
    public C6426p(Context context, String str, String str2, boolean z10) {
        super(context, str, str2, z10);
    }

    @Override // com.huawei.hms.support.api.tss.callback.AbstractC6435y
    /* renamed from: b */
    public GetKeyInfoResp mo36804b(String str) throws JSONException {
        return new GetKeyInfoResp(str);
    }
}
