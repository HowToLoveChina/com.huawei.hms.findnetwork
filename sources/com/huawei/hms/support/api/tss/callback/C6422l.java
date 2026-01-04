package com.huawei.hms.support.api.tss.callback;

import android.content.Context;
import com.huawei.hms.support.api.entity.tss.GetCertificationKeyResp;
import org.json.JSONException;

/* renamed from: com.huawei.hms.support.api.tss.callback.l */
/* loaded from: classes8.dex */
public class C6422l extends AbstractC6404a<GetCertificationKeyResp> {
    public C6422l(Context context, String str, String str2, boolean z10) {
        super(context, str, str2, z10);
    }

    @Override // com.huawei.hms.support.api.tss.callback.AbstractC6404a
    /* renamed from: a */
    public GetCertificationKeyResp mo36802a(String str) throws JSONException {
        return new GetCertificationKeyResp(str);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 1;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 50000000;
    }
}
