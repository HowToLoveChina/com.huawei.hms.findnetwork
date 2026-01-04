package com.huawei.hms.p109a.p110a.p114d;

import android.text.TextUtils;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.common.utils.PickerHiAnalyticsUtil;
import com.huawei.hms.p109a.p110a.p112b.C5038a;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.common.PickerCommonNaming;
import com.huawei.hms.support.api.hwid.RevokeAccessPickerResult;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.support.picker.common.AccountPickerUtil;
import p208cq.C8941i;
import p640sq.C12836o;

/* renamed from: com.huawei.hms.a.a.d.a */
/* loaded from: classes8.dex */
public class C5041a extends TaskApiCall<C5038a, Void> {
    public C5041a(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(C5038a c5038a, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) {
        m30087a(responseErrorCode, str);
        C12836o.m77097b("[ACCOUNTSDK]AccountPickerAuthorizationTaskApiCall", "ResponseErrorCode:" + responseErrorCode.getErrorCode(), true);
        AccountPickerUtil.clearSignInAccountCache();
        if (TextUtils.isEmpty(str)) {
            C12836o.m77097b("[ACCOUNTSDK]AccountPickerAuthorizationTaskApiCall", "cancel authorization body is null.", true);
            int errorCode = responseErrorCode.getErrorCode();
            c8941i.m56657c(new ApiException(new Status(errorCode, responseErrorCode.getErrorReason())));
            m30086a(c5038a, errorCode);
            return;
        }
        if ("{}".equals(str)) {
            C12836o.m77097b("[ACCOUNTSDK]AccountPickerAuthorizationTaskApiCall", "CancelAuthorization complete, body is null", true);
            c8941i.m56657c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
            return;
        }
        C12836o.m77097b("[ACCOUNTSDK]AccountPickerAuthorizationTaskApiCall", "cancel authorization body is not null.", true);
        RevokeAccessPickerResult beanFromJsonStr = new RevokeAccessPickerResult().getBeanFromJsonStr(str);
        if (beanFromJsonStr.getErrorCode() == null) {
            c8941i.m56658d(null);
            m30086a(c5038a, 0);
        } else {
            int iIntValue = beanFromJsonStr.getErrorCode().intValue();
            c8941i.m56657c(new ApiException(new Status(iIntValue, beanFromJsonStr.getErrorMsg())));
            m30086a(c5038a, iIntValue);
        }
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 9;
    }

    /* renamed from: a */
    private void m30087a(ResponseErrorCode responseErrorCode, String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("headerErrorCode:" + responseErrorCode.getErrorCode());
        C12836o.m77097b("[ACCOUNTSDK]AccountPickerAuthorizationTaskApiCall", sb2.toString(), true);
    }

    /* renamed from: a */
    private void m30086a(C5038a c5038a, int i10) {
        if (c5038a != null) {
            HiAnalyticsClient.reportExit(c5038a.getContext(), PickerCommonNaming.AccountPickerRevokeAccess, getTransactionId(), PickerHiAnalyticsUtil.getHiAnalyticsStatus(i10), i10);
        }
    }
}
