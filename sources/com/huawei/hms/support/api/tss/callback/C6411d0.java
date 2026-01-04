package com.huawei.hms.support.api.tss.callback;

import android.content.Context;
import com.huawei.hms.support.api.entity.tss.SysIntegrityResp;
import org.json.JSONException;

/* renamed from: com.huawei.hms.support.api.tss.callback.d0 */
/* loaded from: classes8.dex */
public class C6411d0 extends AbstractC6404a<SysIntegrityResp> {
    public C6411d0(Context context, String str, String str2, boolean z10) {
        super(context, str, str2, z10);
    }

    @Override // com.huawei.hms.support.api.tss.callback.AbstractC6404a
    /* renamed from: a */
    public SysIntegrityResp mo36802a(String str) throws JSONException {
        return new SysIntegrityResp(str);
    }
}
