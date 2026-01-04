package com.huawei.hms.support.api.safetydetect.p860default;

import android.content.Context;
import com.huawei.hms.support.api.entity.safetydetect.VerifyAppsCheckEnabledResp;
import org.json.JSONException;

/* renamed from: com.huawei.hms.support.api.safetydetect.default.f0 */
/* loaded from: classes8.dex */
public class C6365f0 extends AbstractC6354a<VerifyAppsCheckEnabledResp> {
    public C6365f0(Context context, String str, String str2, boolean z10) {
        super(context, str, str2, z10);
    }

    @Override // com.huawei.hms.support.api.safetydetect.p860default.AbstractC6354a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public VerifyAppsCheckEnabledResp mo36723a(String str, int i10, String str2) throws C6378s {
        try {
            VerifyAppsCheckEnabledResp verifyAppsCheckEnabledResp = new VerifyAppsCheckEnabledResp(str);
            verifyAppsCheckEnabledResp.setRtnCode(i10);
            verifyAppsCheckEnabledResp.setErrorReason(str2);
            return verifyAppsCheckEnabledResp;
        } catch (JSONException e10) {
            throw new C6378s(e10.getLocalizedMessage());
        }
    }
}
