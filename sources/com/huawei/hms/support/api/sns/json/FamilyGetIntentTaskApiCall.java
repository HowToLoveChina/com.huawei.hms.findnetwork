package com.huawei.hms.support.api.sns.json;

import android.content.Intent;
import android.os.Parcelable;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.ResolvableApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.sns.json.SnsOutIntent;
import p208cq.C8941i;

/* loaded from: classes8.dex */
public class FamilyGetIntentTaskApiCall extends TaskApiCall<SnsHmsClient, SnsOutIntent> {

    /* renamed from: a */
    private final FamilyClientImpl f29914a;

    /* renamed from: b */
    private final String f29915b;

    public FamilyGetIntentTaskApiCall(String str, String str2, String str3, FamilyClientImpl familyClientImpl) {
        super(str, str2, str3);
        this.f29914a = familyClientImpl;
        this.f29915b = str;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 5;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public void doExecute(SnsHmsClient snsHmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<SnsOutIntent> c8941i) {
        String transactionId = getTransactionId();
        int statusCode = responseErrorCode.getStatusCode();
        int errorCode = responseErrorCode.getErrorCode();
        String errorReason = responseErrorCode.getErrorReason();
        this.f29914a.biReportExit(this.f29915b, transactionId, statusCode, errorCode);
        SnsOutIntent snsOutIntent = new SnsOutIntent(str);
        if (responseErrorCode.getErrorCode() == 0) {
            Parcelable parcelable = responseErrorCode.getParcelable();
            if (parcelable instanceof Intent) {
                snsOutIntent.setIntent((Intent) parcelable);
            }
            c8941i.m56658d(snsOutIntent);
            return;
        }
        if (responseErrorCode.hasResolution()) {
            c8941i.m56657c(new ResolvableApiException(responseErrorCode));
        } else {
            c8941i.m56657c(new ApiException(new Status(responseErrorCode.getErrorCode(), errorReason)));
        }
    }
}
