package com.huawei.hms.findnetwork.sdk;

import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.BaseRequestBean;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.h */
/* loaded from: classes8.dex */
public class C5363h extends BaseTaskApiCall<HmsClient, BaseRequestBean, FindNetworkResult> {
    public C5363h(BaseRequestBean baseRequestBean) {
        super("findnetwork.disable", baseRequestBean);
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<FindNetworkResult> c8941i) {
        FindNetworkResult findNetworkResult = new FindNetworkResult();
        findNetworkResult.setDescription(responseErrorCode.getErrorReason());
        findNetworkResult.setRespCode(responseErrorCode.getErrorCode());
        findNetworkResult.setData(str);
        c8941i.m56658d(findNetworkResult);
    }
}
