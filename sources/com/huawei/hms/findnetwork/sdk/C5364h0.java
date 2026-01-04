package com.huawei.hms.findnetwork.sdk;

import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.BaseRequestBean;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkStatusResult;
import com.huawei.hms.findnetwork.comm.util.JsonUtils;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.h0 */
/* loaded from: classes8.dex */
public class C5364h0 extends BaseTaskApiCall<HmsClient, BaseRequestBean, FindNetworkStatusResult> {
    public C5364h0(BaseRequestBean baseRequestBean) {
        super("findnetwork.queryFindNetworkStatus", baseRequestBean);
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<FindNetworkStatusResult> c8941i) {
        FindNetworkStatusResult findNetworkStatusResult = (FindNetworkStatusResult) JsonUtils.json2Object(str, FindNetworkStatusResult.class);
        if (findNetworkStatusResult == null) {
            findNetworkStatusResult = new FindNetworkStatusResult(-1);
        }
        c8941i.m56658d(findNetworkStatusResult);
    }
}
