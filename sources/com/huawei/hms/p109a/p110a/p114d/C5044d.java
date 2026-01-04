package com.huawei.hms.p109a.p110a.p114d;

import android.text.TextUtils;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.common.utils.PickerHiAnalyticsUtil;
import com.huawei.hms.p109a.p110a.p112b.C5038a;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.common.PickerCommonNaming;
import com.huawei.hms.support.api.hwid.AccountPickerSignOutResult;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import org.json.JSONException;
import p208cq.C8941i;
import p640sq.C12836o;

/* renamed from: com.huawei.hms.a.a.d.d */
/* loaded from: classes8.dex */
public class C5044d extends TaskApiCall<C5038a, Void> {
    public C5044d(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(C5038a c5038a, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) {
        m30096a(responseErrorCode, str);
        int errorCode = responseErrorCode.getErrorCode();
        C12836o.m77097b("[ACCOUNTSDK]AccountPickerSignOutTaskApiCall", "ResponseErrorCode:" + errorCode, true);
        if (TextUtils.isEmpty(str)) {
            C12836o.m77097b("[ACCOUNTSDK]AccountPickerSignOutTaskApiCall", "signOut body is null.", true);
            c8941i.m56657c(new ApiException(new Status(errorCode, responseErrorCode.getErrorReason())));
            m30095a(c5038a, errorCode);
            return;
        }
        C12836o.m77097b("[ACCOUNTSDK]AccountPickerSignOutTaskApiCall", "signOut body is not null.", true);
        try {
            AccountPickerSignOutResult accountPickerSignOutResultFromJson = new AccountPickerSignOutResult().fromJson(str);
            errorCode = accountPickerSignOutResultFromJson.getStatus().getStatusCode();
            if (accountPickerSignOutResultFromJson.isSuccess()) {
                c8941i.m56658d(null);
                m30095a(c5038a, 0);
            } else {
                c8941i.m56657c(new ApiException(new Status(errorCode, responseErrorCode.getErrorReason())));
                m30095a(c5038a, errorCode);
            }
        } catch (JSONException e10) {
            C12836o.m77099d("[ACCOUNTSDK]AccountPickerSignOutTaskApiCall", "JSONException：" + e10.getClass().getSimpleName(), true);
            c8941i.m56657c(new ApiException(new Status(2015, "JSON parse exception.")));
            m30095a(c5038a, errorCode);
        }
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 9;
    }

    /* renamed from: a */
    private void m30096a(ResponseErrorCode responseErrorCode, String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("headerErrorCode:" + responseErrorCode.getErrorCode());
        C12836o.m77097b("[ACCOUNTSDK]AccountPickerSignOutTaskApiCall", sb2.toString(), true);
    }

    /* renamed from: a */
    private void m30095a(C5038a c5038a, int i10) {
        if (c5038a != null) {
            HiAnalyticsClient.reportExit(c5038a.getContext(), PickerCommonNaming.AccountPickerSignout, getTransactionId(), PickerHiAnalyticsUtil.getHiAnalyticsStatus(i10), i10);
        }
    }
}
