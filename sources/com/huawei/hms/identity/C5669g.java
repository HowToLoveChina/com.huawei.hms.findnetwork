package com.huawei.hms.identity;

import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ResolvableApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.identity.entity.GetUserAddressResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.support.log.HMSLog;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.identity.g */
/* loaded from: classes8.dex */
public class C5669g extends TaskApiCall<C5664b, GetUserAddressResult> {

    /* renamed from: a */
    private static final String f25481a = "GetUserAddressTaskApiCall";

    /* renamed from: b */
    private static final int f25482b = 2;

    public C5669g(String str, String str2, String str3) {
        super(str, str2, str3);
        setApiLevel(2);
    }

    /* renamed from: a */
    private Status m33032a(ResponseErrorCode responseErrorCode) {
        if (responseErrorCode.getParcelable() instanceof PendingIntent) {
            return new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason(), (PendingIntent) responseErrorCode.getParcelable());
        }
        if (!(responseErrorCode.getParcelable() instanceof Intent)) {
            return new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason());
        }
        return new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason(), (Intent) responseErrorCode.getParcelable());
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return HuaweiApiAvailability.HMS_VERSION_CODE_KIT_UPDATE;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a */
    public void doExecute(C5664b c5664b, ResponseErrorCode responseErrorCode, String str, C8941i<GetUserAddressResult> c8941i) {
        HiAnalyticsClient.reportExit(c5664b.getContext(), getUri(), getTransactionId(), responseErrorCode.getStatusCode(), responseErrorCode.getErrorCode());
        if (TextUtils.isEmpty(str)) {
            HMSLog.m36988i(f25481a, "The body is empty.");
            c8941i.m56657c(new AddressApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
            return;
        }
        if (responseErrorCode.getErrorCode() != 0) {
            HMSLog.m36988i(f25481a, "onResult, returnCode:" + responseErrorCode.getErrorCode());
            c8941i.m56657c(responseErrorCode.hasResolution() ? new ResolvableApiException(responseErrorCode) : new AddressApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
            return;
        }
        HMSLog.m36988i(f25481a, "onResult, success");
        GetUserAddressResult getUserAddressResult = new GetUserAddressResult();
        getUserAddressResult.m33030a(responseErrorCode.getErrorCode());
        getUserAddressResult.m33031a(responseErrorCode.getErrorReason());
        getUserAddressResult.setStatus(m33032a(responseErrorCode));
        c8941i.m56658d(getUserAddressResult);
    }
}
