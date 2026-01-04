package com.huawei.hms.support.hwid.p140c;

import android.text.TextUtils;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.hwid.common.p146e.C6477g;
import com.huawei.hms.support.hwid.result.SignInQrInfo;
import com.huawei.hms.support.hwid.result.StartQrLoginResult;
import org.json.JSONException;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.support.hwid.c.m */
/* loaded from: classes8.dex */
public class C6460m extends AbstractC6449b<SignInQrInfo> {

    /* renamed from: b */
    private boolean f30003b;

    public C6460m(String str, String str2, String str3) {
        super(str, str2, str3);
        this.f30003b = false;
    }

    @Override // com.huawei.hms.support.hwid.p140c.AbstractC6449b
    /* renamed from: a */
    public boolean mo36830a() {
        return false;
    }

    /* renamed from: b */
    public boolean m36832b() {
        return this.f30003b;
    }

    @Override // com.huawei.hms.support.hwid.p140c.AbstractC6449b, com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return m36832b() ? 17 : 16;
    }

    @Override // com.huawei.hms.support.hwid.p140c.AbstractC6449b, com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return m36832b() ? 60600300 : 60100300;
    }

    @Override // com.huawei.hms.support.hwid.p140c.AbstractC6449b
    /* renamed from: a */
    public void mo36828a(ResponseErrorCode responseErrorCode, String str, C8941i<SignInQrInfo> c8941i) {
        if (TextUtils.isEmpty(str)) {
            C6477g.m36905b(((AbstractC6449b) this).f30000a, "body is empty.");
            c8941i.m56657c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
            return;
        }
        try {
            StartQrLoginResult startQrLoginResultFromJson = new StartQrLoginResult().fromJson(str);
            if (startQrLoginResultFromJson.isSuccess()) {
                c8941i.m56658d(startQrLoginResultFromJson.getSignInQrInfo());
            } else {
                C6477g.m36903a(((AbstractC6449b) this).f30000a, "request is error.");
                c8941i.m56657c(new ApiException(startQrLoginResultFromJson.getStatus()));
            }
        } catch (JSONException e10) {
            C6477g.m36903a(((AbstractC6449b) this).f30000a, "JSONException：" + e10.getClass().getSimpleName());
            c8941i.m56657c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
        }
    }

    /* renamed from: a */
    public void m36831a(boolean z10) {
        this.f30003b = z10;
    }
}
