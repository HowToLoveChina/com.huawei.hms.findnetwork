package com.huawei.hms.support.api.sns.json;

import android.text.TextUtils;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.sns.internal.AddFriendResp;
import com.huawei.hms.support.api.sns.json.SnsClient;
import com.huawei.hms.utils.JsonUtil;
import p208cq.C8941i;

/* loaded from: classes8.dex */
public class SnsAddFriendApiCall extends TaskApiCall<SnsHmsClient, AddFriendResp> {

    /* renamed from: a */
    SnsClient.Callback f29918a;

    /* renamed from: b */
    private String f29919b;

    /* renamed from: c */
    private SnsClientImpl f29920c;

    public SnsAddFriendApiCall(String str, String str2) {
        super(str, str2);
    }

    public SnsAddFriendApiCall(String str, String str2, SnsClient.Callback callback, SnsClientImpl snsClientImpl) {
        super(str, str2);
        this.f29918a = callback;
        this.f29920c = snsClientImpl;
        this.f29919b = str;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public void doExecute(SnsHmsClient snsHmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<AddFriendResp> c8941i) throws IllegalArgumentException {
        this.f29920c.biReportExit(this.f29919b, getTransactionId(), responseErrorCode.getStatusCode(), responseErrorCode.getErrorCode());
        if (responseErrorCode.getErrorCode() == 0) {
            if (!TextUtils.isEmpty(str)) {
                IMessageEntity iMessageEntityJsonToEntity = JsonUtil.jsonToEntity(str, new AddFriendResp());
                if (iMessageEntityJsonToEntity instanceof AddFriendResp) {
                    c8941i.m56658d((AddFriendResp) iMessageEntityJsonToEntity);
                }
            }
            SnsClient.Callback callback = this.f29918a;
            if (callback != null) {
                callback.notify(str);
                return;
            }
            return;
        }
        c8941i.m56657c(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
        SnsClient.Callback callback2 = this.f29918a;
        if (callback2 != null) {
            callback2.notify("error " + responseErrorCode.getErrorReason());
        }
    }
}
