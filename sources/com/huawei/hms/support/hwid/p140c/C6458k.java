package com.huawei.hms.support.hwid.p140c;

import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.api.UserRecoverableException;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.hwid.common.p146e.C6477g;
import com.huawei.hms.support.hwid.result.SignInByQrCodeResult;
import org.json.JSONException;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.support.hwid.c.k */
/* loaded from: classes8.dex */
public class C6458k extends AbstractC6449b<Void> {
    public C6458k(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    @Override // com.huawei.hms.support.hwid.p140c.AbstractC6449b
    /* renamed from: a */
    public boolean mo36830a() {
        return false;
    }

    @Override // com.huawei.hms.support.hwid.p140c.AbstractC6449b, com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 5;
    }

    @Override // com.huawei.hms.support.hwid.p140c.AbstractC6449b, com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 50000300;
    }

    @Override // com.huawei.hms.support.hwid.p140c.AbstractC6449b
    /* renamed from: a */
    public void mo36828a(ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) {
        if (responseErrorCode.getParcelable() != null && (responseErrorCode.getParcelable() instanceof Intent)) {
            C6477g.m36903a(((AbstractC6449b) this).f30000a, " need second verify.");
            c8941i.m56657c(new UserRecoverableException("User login need second verify", (Intent) responseErrorCode.getParcelable()));
            return;
        }
        if (TextUtils.isEmpty(str)) {
            C6477g.m36905b(((AbstractC6449b) this).f30000a, "body is empty.");
            c8941i.m56657c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
            return;
        }
        try {
            SignInByQrCodeResult signInByQrCodeResultFromJson = new SignInByQrCodeResult().fromJson(str);
            if (signInByQrCodeResultFromJson.isSuccess()) {
                c8941i.m56658d(null);
            } else {
                C6477g.m36903a(((AbstractC6449b) this).f30000a, "request is error.");
                c8941i.m56657c(new ApiException(signInByQrCodeResultFromJson.getStatus()));
            }
        } catch (JSONException e10) {
            C6477g.m36905b(((AbstractC6449b) this).f30000a, "JSONException：" + e10.getClass().getSimpleName());
            c8941i.m56657c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
        }
    }
}
