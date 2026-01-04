package com.huawei.hms.hwid;

import android.app.PendingIntent;
import android.text.TextUtils;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.ResolvableApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.account.AccountNaming;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.hwid.j */
/* loaded from: classes8.dex */
public class C5612j extends TaskApiCall<C5604c, Void> {
    public C5612j(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(C5604c c5604c, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) {
        C5602as.m32910b("AccountLogoutTaskApiCall", "AccountLogoutTaskApiCall doExecute", true);
        if (responseErrorCode == null) {
            C5602as.m32910b("AccountLogoutTaskApiCall", "response is null.", true);
            c8941i.m56657c(new ApiException(new Status(2003, "response is null.")));
            return;
        }
        m32942a(responseErrorCode);
        if (responseErrorCode.getErrorCode() == 0) {
            if (TextUtils.isEmpty(str)) {
                c8941i.m56657c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
                m32943a(c5604c, responseErrorCode);
                return;
            } else {
                c8941i.m56658d(null);
                m32943a(c5604c, responseErrorCode);
                return;
            }
        }
        if (CommonCode.Resolution.HAS_RESOLUTION.equals(responseErrorCode.getResolution())) {
            C5602as.m32910b("AccountLogoutTaskApiCall", "hms apk version is low or is not exist.", true);
            c8941i.m56657c(new ResolvableApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason(), (PendingIntent) responseErrorCode.getParcelable())));
        } else {
            C5602as.m32910b("AccountLogoutTaskApiCall", "AccountLogoutTaskApiCall callback.", true);
            if (responseErrorCode.getErrorCode() != 2031) {
                c8941i.m56657c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
            }
        }
        c8941i.m56658d(null);
        m32943a(c5604c, responseErrorCode);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 16;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 60000000;
    }

    /* renamed from: a */
    private void m32943a(C5604c c5604c, ResponseErrorCode responseErrorCode) {
        if (c5604c == null || responseErrorCode == null) {
            return;
        }
        HiAnalyticsClient.reportExit(c5604c.getContext(), AccountNaming.logout, getTransactionId(), C5601ar.m32908a(responseErrorCode.getErrorCode()), responseErrorCode.getErrorCode());
    }

    /* renamed from: a */
    private void m32942a(ResponseErrorCode responseErrorCode) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("headerErrorCode:" + responseErrorCode.getErrorCode());
        C5602as.m32910b("AccountLogoutTaskApiCall", sb2.toString(), true);
    }
}
