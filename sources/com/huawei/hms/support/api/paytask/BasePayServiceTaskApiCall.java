package com.huawei.hms.support.api.paytask;

import android.app.PendingIntent;
import android.content.Intent;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.ResolvableApiException;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.support.log.HMSLog;
import p208cq.C8941i;

/* loaded from: classes8.dex */
public abstract class BasePayServiceTaskApiCall<U extends HmsClient, V> extends TaskApiCall<U, V> {
    protected static final int MIN_APK_VERSION_FOR_SIGNALGORITHM = 60000300;
    protected static final int MIN_PAY_API_LEVEL_FOR_SIGNALGORITHM = 4;

    /* renamed from: a */
    private boolean f29843a;

    public BasePayServiceTaskApiCall(String str, String str2) {
        super(str, str2);
        this.f29843a = false;
    }

    public void dealException(C8941i c8941i, ResponseErrorCode responseErrorCode) {
        String str = "call " + getUri() + ", ";
        HMSLog.m36986e("BasePayServiceTaskApiCall", str + "dealException, returnCode: " + responseErrorCode.getErrorCode());
        if (responseErrorCode.getErrorCode() != 1212 && responseErrorCode.getErrorCode() != 907135003) {
            c8941i.m56657c(new ApiException(getStatus(responseErrorCode)));
            return;
        }
        HMSLog.m36986e("BasePayServiceTaskApiCall", str + "dealException, upgrade required");
        c8941i.m56657c(new ResolvableApiException(responseErrorCode));
    }

    public abstract void dealSuccess(C8941i<V> c8941i, ResponseErrorCode responseErrorCode, String str);

    public Status getStatus(ResponseErrorCode responseErrorCode) {
        String str = "call " + getUri() + ", ";
        if (responseErrorCode.getParcelable() instanceof Intent) {
            HMSLog.m36988i("BasePayServiceTaskApiCall", str + "getStatus, getParcelable is instanceof Intent");
            return new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason(), (Intent) responseErrorCode.getParcelable());
        }
        if (!(responseErrorCode.getParcelable() instanceof PendingIntent)) {
            HMSLog.m36988i("BasePayServiceTaskApiCall", str + "getStatus, no parcelable");
            return new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason());
        }
        HMSLog.m36988i("BasePayServiceTaskApiCall", str + "getStatus, getParcelable is instanceof PendingIntent");
        return new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason(), (PendingIntent) responseErrorCode.getParcelable());
    }

    public BasePayServiceTaskApiCall(String str, String str2, String str3) {
        super(str, str2, str3);
        this.f29843a = true;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public void doExecute(U u10, ResponseErrorCode responseErrorCode, String str, C8941i<V> c8941i) {
        if (responseErrorCode == null) {
            HMSLog.m36986e("BasePayServiceTaskApiCall", "header is null");
            c8941i.m56657c(new ApiException(new Status(1)));
            return;
        }
        if (this.f29843a) {
            HMSLog.m36988i("BasePayServiceTaskApiCall", "reportExit");
            HiAnalyticsClient.reportExit(u10.getContext(), getUri(), getTransactionId(), responseErrorCode.getStatusCode(), responseErrorCode.getErrorCode(), 61606301);
        }
        if (c8941i == null) {
            HMSLog.m36986e("BasePayServiceTaskApiCall", "taskCompletionSource is null");
        } else if (responseErrorCode.getErrorCode() == 0) {
            dealSuccess(c8941i, responseErrorCode, str);
        } else {
            dealException(c8941i, responseErrorCode);
        }
    }
}
