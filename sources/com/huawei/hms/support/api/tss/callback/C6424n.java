package com.huawei.hms.support.api.tss.callback;

import android.content.Context;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.entity.tss.GetDeviceIdResp;
import org.json.JSONException;

/* renamed from: com.huawei.hms.support.api.tss.callback.n */
/* loaded from: classes8.dex */
public class C6424n extends AbstractC6404a<GetDeviceIdResp> {
    public C6424n(Context context, String str, String str2, boolean z10) {
        super(context, str, str2, z10);
    }

    @Override // com.huawei.hms.support.api.tss.callback.AbstractC6404a
    /* renamed from: a */
    public GetDeviceIdResp mo36802a(String str) throws JSONException {
        return new GetDeviceIdResp(str);
    }

    @Override // com.huawei.hms.support.api.tss.callback.AbstractC6404a
    /* renamed from: a */
    public boolean mo36803a(ResponseErrorCode responseErrorCode) {
        return responseErrorCode.getStatusCode() == 0 && (responseErrorCode.getErrorCode() == 0 || responseErrorCode.getErrorCode() == 201029);
    }
}
