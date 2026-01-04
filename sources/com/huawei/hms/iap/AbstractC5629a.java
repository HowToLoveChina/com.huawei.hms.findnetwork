package com.huawei.hms.iap;

import android.app.PendingIntent;
import android.content.Intent;
import com.huawei.hms.common.ResolvableApiException;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.iap.util.C5660b;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.support.log.HMSLog;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.iap.a */
/* loaded from: classes8.dex */
public abstract class AbstractC5629a<U extends HmsClient, V> extends TaskApiCall<U, V> {
    public AbstractC5629a(String str, String str2, String str3) {
        this(str, str2, null, str3);
    }

    /* renamed from: b */
    private int m32973b() {
        if (m32975d()) {
            return 10;
        }
        return super.getApiLevel();
    }

    /* renamed from: c */
    private int m32974c() {
        if (m32975d()) {
            return 60900000;
        }
        return super.getMinApkVersion();
    }

    /* renamed from: d */
    private boolean m32975d() {
        return C5660b.m33023b(getRequestJson(), "isConsignment");
    }

    /* renamed from: a */
    public int mo32976a() {
        return 0;
    }

    /* renamed from: a */
    public abstract void mo32981a(C8941i<V> c8941i, ResponseErrorCode responseErrorCode, String str);

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return Math.max(m32974c(), mo32976a());
    }

    public AbstractC5629a(String str, String str2, String str3, String str4) {
        super(str, C5660b.m33021a(str2, str3), str4);
        setApiLevel(m32973b());
    }

    /* renamed from: a */
    public Status m32977a(ResponseErrorCode responseErrorCode) {
        String str = "call " + getUri() + ", ";
        if (responseErrorCode.getParcelable() instanceof Intent) {
            HMSLog.m36988i("BaseIapServiceTaskApiCall", str + "getStatus, getParcelable is instanceof Intent");
            return new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason(), (Intent) responseErrorCode.getParcelable());
        }
        if (!(responseErrorCode.getParcelable() instanceof PendingIntent)) {
            HMSLog.m36988i("BaseIapServiceTaskApiCall", str + "getStatus, no parcelable");
            return new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason());
        }
        HMSLog.m36988i("BaseIapServiceTaskApiCall", str + "getStatus, getParcelable is instanceof PendingIntent");
        return new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason(), (PendingIntent) responseErrorCode.getParcelable());
    }

    /* renamed from: a */
    public void m32978a(int i10) {
        setApiLevel(Math.max(i10, getApiLevel()));
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(U u10, ResponseErrorCode responseErrorCode, String str, C8941i<V> c8941i) {
        if (responseErrorCode == null) {
            HMSLog.m36986e("BaseIapServiceTaskApiCall", "header is null");
            c8941i.m56657c(new IapApiException(new Status(1)));
            return;
        }
        HiAnalyticsClient.reportExit(u10.getContext(), getUri(), getTransactionId(), responseErrorCode.getStatusCode(), responseErrorCode.getErrorCode(), 61606301);
        if (c8941i == null) {
            HMSLog.m36986e("BaseIapServiceTaskApiCall", "taskCompletionSource is null");
        } else if (responseErrorCode.getErrorCode() == 0) {
            mo32981a(c8941i, responseErrorCode, str);
        } else {
            m32980a(c8941i, responseErrorCode);
        }
    }

    /* renamed from: a */
    public void m32980a(C8941i c8941i, ResponseErrorCode responseErrorCode) {
        HMSLog.m36986e("BaseIapServiceTaskApiCall", ("call " + getUri() + ", ") + "dealException, returnCode: " + responseErrorCode.getErrorCode());
        if (responseErrorCode.getErrorCode() == 1212 || responseErrorCode.getErrorCode() == 907135003) {
            c8941i.m56657c(new ResolvableApiException(responseErrorCode));
        } else {
            c8941i.m56657c(new IapApiException(m32977a(responseErrorCode)));
        }
    }
}
