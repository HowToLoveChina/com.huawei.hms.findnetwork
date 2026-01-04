package com.huawei.hms.support.api.safetydetect.p860default;

import android.content.Context;
import com.huawei.hms.support.api.entity.safetydetect.SysIntegrityResp;
import org.json.JSONException;

/* renamed from: com.huawei.hms.support.api.safetydetect.default.y */
/* loaded from: classes8.dex */
public class C6384y extends AbstractC6354a<SysIntegrityResp> {
    public C6384y(Context context, String str, String str2, boolean z10) {
        super(context, str, str2, z10);
    }

    @Override // com.huawei.hms.support.api.safetydetect.p860default.AbstractC6354a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public SysIntegrityResp mo36723a(String str, int i10, String str2) throws C6378s {
        try {
            SysIntegrityResp sysIntegrityResp = new SysIntegrityResp(str);
            sysIntegrityResp.setRtnCode(i10);
            sysIntegrityResp.setErrorReason(str2);
            return sysIntegrityResp;
        } catch (JSONException e10) {
            throw new C6378s(e10.getLocalizedMessage());
        }
    }
}
