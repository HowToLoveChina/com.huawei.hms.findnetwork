package com.huawei.hms.support.api.safetydetect.p860default;

import android.content.Context;
import com.huawei.hms.support.api.entity.safetydetect.MaliciousAppsListResp;
import org.json.JSONException;

/* renamed from: com.huawei.hms.support.api.safetydetect.default.h */
/* loaded from: classes8.dex */
public class C6367h extends AbstractC6354a<MaliciousAppsListResp> {
    public C6367h(Context context, String str, String str2, boolean z10) {
        super(context, str, str2, z10);
    }

    @Override // com.huawei.hms.support.api.safetydetect.p860default.AbstractC6354a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public MaliciousAppsListResp mo36723a(String str, int i10, String str2) throws C6378s {
        try {
            MaliciousAppsListResp maliciousAppsListResp = new MaliciousAppsListResp(str);
            maliciousAppsListResp.setRtnCode(i10);
            maliciousAppsListResp.setErrorReason(str2);
            return maliciousAppsListResp;
        } catch (JSONException e10) {
            throw new C6378s(e10.getLocalizedMessage());
        }
    }
}
