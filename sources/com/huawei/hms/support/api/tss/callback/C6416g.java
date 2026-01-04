package com.huawei.hms.support.api.tss.callback;

import android.content.Context;
import com.huawei.hms.support.api.entity.tss.EcdhResp;
import org.json.JSONException;

/* renamed from: com.huawei.hms.support.api.tss.callback.g */
/* loaded from: classes8.dex */
public class C6416g extends AbstractC6435y<EcdhResp> {
    public C6416g(Context context, String str, String str2, boolean z10) {
        super(context, str, str2, z10);
    }

    @Override // com.huawei.hms.support.api.tss.callback.AbstractC6435y
    /* renamed from: b */
    public EcdhResp mo36804b(String str) throws JSONException {
        return new EcdhResp(str);
    }
}
