package com.huawei.hms.findnetwork.sdk;

import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.BaseRequestBean;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.r1 */
/* loaded from: classes8.dex */
public class C5395r1 extends BaseTaskApiCall<HmsClient, BaseRequestBean, Void> {
    public C5395r1(BaseRequestBean baseRequestBean) {
        super("findnetwork.user_operation", baseRequestBean);
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) {
        HmsFindSDKLog.m32127i("UserOperationApiCall", "handleBusiness: " + responseErrorCode.getErrorCode());
        c8941i.m56658d(null);
    }
}
