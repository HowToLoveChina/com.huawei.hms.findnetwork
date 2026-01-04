package com.huawei.hms.support.api.sns.json;

import android.content.Intent;
import android.os.Parcelable;
import com.huawei.android.backup.service.logic.C2126b;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.ResolvableApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.sns.json.SnsOutIntent;
import com.huawei.hms.support.api.sns.json.SnsClient;
import p208cq.C8941i;

/* loaded from: classes8.dex */
public class SnsTaskApiCall extends TaskApiCall<SnsHmsClient, SnsOutIntent> {

    /* renamed from: a */
    SnsClient.Callback f29954a;

    /* renamed from: b */
    private SnsClientImpl f29955b;

    /* renamed from: c */
    private String f29956c;

    public SnsTaskApiCall(String str, String str2) {
        super(str, str2);
    }

    public SnsTaskApiCall(String str, String str2, SnsClient.Callback callback, SnsClientImpl snsClientImpl) {
        super(str, str2);
        this.f29954a = callback;
        this.f29955b = snsClientImpl;
        this.f29956c = str;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public void doExecute(SnsHmsClient snsHmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<SnsOutIntent> c8941i) {
        SnsOutIntent snsOutIntent = new SnsOutIntent(str);
        String transactionId = getTransactionId();
        int statusCode = responseErrorCode.getStatusCode();
        int errorCode = responseErrorCode.getErrorCode();
        String errorReason = responseErrorCode.getErrorReason();
        this.f29955b.biReportExit(this.f29956c, transactionId, statusCode, errorCode);
        if (responseErrorCode.getErrorCode() != 0) {
            if (responseErrorCode.hasResolution()) {
                c8941i.m56657c(new ResolvableApiException(responseErrorCode));
                return;
            }
            c8941i.m56657c(new ApiException(new Status(responseErrorCode.getErrorCode(), errorReason)));
            SnsClient.Callback callback = this.f29954a;
            if (callback != null) {
                callback.notify("error " + errorReason);
                return;
            }
            return;
        }
        Parcelable parcelable = responseErrorCode.getParcelable();
        if (parcelable instanceof Intent) {
            Intent intent = (Intent) parcelable;
            str = str + C2126b.MODULE_INFO_URI + intent.toUri(0);
            snsOutIntent.setIntent(intent);
        }
        c8941i.m56658d(snsOutIntent);
        SnsClient.Callback callback2 = this.f29954a;
        if (callback2 != null) {
            callback2.notify(str);
        }
    }
}
