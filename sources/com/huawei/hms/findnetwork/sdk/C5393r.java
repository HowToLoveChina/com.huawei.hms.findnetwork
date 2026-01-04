package com.huawei.hms.findnetwork.sdk;

import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.BaseRequestBean;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.comm.util.JsonUtils;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.r */
/* loaded from: classes8.dex */
public class C5393r extends BaseTaskApiCall<HmsClient, BaseRequestBean, FindNetworkResult> {
    public C5393r(BaseRequestBean baseRequestBean) {
        super("findnetwork.getTrustTag", baseRequestBean);
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<FindNetworkResult> c8941i) {
        c8941i.m56658d((FindNetworkResult) JsonUtils.json2Object(str, FindNetworkResult.class));
    }
}
