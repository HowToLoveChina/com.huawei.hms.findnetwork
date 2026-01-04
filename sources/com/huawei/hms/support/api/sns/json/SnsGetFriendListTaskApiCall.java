package com.huawei.hms.support.api.sns.json;

import android.text.TextUtils;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.ResolvableApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.sns.internal.GetFriendListResp;
import com.huawei.hms.support.api.sns.json.SnsClient;
import com.huawei.hms.utils.JsonUtil;
import p208cq.C8941i;

/* loaded from: classes8.dex */
public class SnsGetFriendListTaskApiCall extends TaskApiCall<SnsHmsClient, GetFriendListResp> {

    /* renamed from: a */
    SnsClient.Callback f29927a;

    /* renamed from: b */
    private String f29928b;

    /* renamed from: c */
    private SnsClientImpl f29929c;

    public SnsGetFriendListTaskApiCall(String str, String str2) {
        super(str, str2);
        this.f29928b = str;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public void doExecute(SnsHmsClient snsHmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<GetFriendListResp> c8941i) {
        this.f29929c.biReportExit(this.f29928b, getTransactionId(), responseErrorCode.getStatusCode(), responseErrorCode.getErrorCode());
        if (responseErrorCode.getErrorCode() == 0) {
            if (!TextUtils.isEmpty(str)) {
                c8941i.m56658d((GetFriendListResp) JsonUtil.jsonToEntity(str, new GetFriendListResp()));
            }
            SnsClient.Callback callback = this.f29927a;
            if (callback != null) {
                callback.notify(str);
                return;
            }
            return;
        }
        if (responseErrorCode.hasResolution()) {
            c8941i.m56657c(new ResolvableApiException(responseErrorCode));
            return;
        }
        c8941i.m56657c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
        SnsClient.Callback callback2 = this.f29927a;
        if (callback2 != null) {
            callback2.notify("error " + responseErrorCode.getErrorReason());
        }
    }

    public SnsGetFriendListTaskApiCall(String str, String str2, SnsClient.Callback callback, SnsClientImpl snsClientImpl) {
        super(str, str2);
        this.f29927a = callback;
        this.f29929c = snsClientImpl;
        this.f29928b = str;
    }
}
