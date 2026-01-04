package com.huawei.hms.support.api.safetydetect.p860default;

import android.content.Context;
import com.huawei.hms.support.api.entity.safetydetect.WifiDetectResponse;
import org.json.JSONException;

/* renamed from: com.huawei.hms.support.api.safetydetect.default.j */
/* loaded from: classes8.dex */
public class C6369j extends AbstractC6354a<WifiDetectResponse> {
    public C6369j(Context context, String str, String str2, boolean z10) {
        super(context, str, str2, z10);
    }

    @Override // com.huawei.hms.support.api.safetydetect.p860default.AbstractC6354a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public WifiDetectResponse mo36723a(String str, int i10, String str2) throws C6378s {
        try {
            WifiDetectResponse wifiDetectResponse = new WifiDetectResponse(str);
            wifiDetectResponse.setRtnCode(i10);
            wifiDetectResponse.setErrorReason(str2);
            return wifiDetectResponse;
        } catch (JSONException e10) {
            throw new C6378s(e10.getLocalizedMessage());
        }
    }
}
