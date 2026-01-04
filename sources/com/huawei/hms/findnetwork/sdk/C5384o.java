package com.huawei.hms.findnetwork.sdk;

import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.GetAntiStalkingRecordRequestBean;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.comm.util.JsonUtils;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.o */
/* loaded from: classes8.dex */
public class C5384o extends BaseTaskApiCall<HmsClient, GetAntiStalkingRecordRequestBean, FindNetworkResult> {
    public C5384o(GetAntiStalkingRecordRequestBean getAntiStalkingRecordRequestBean) {
        super("findnetwork.getAntiStalkingRecord", getAntiStalkingRecordRequestBean);
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<FindNetworkResult> c8941i) {
        c8941i.m56658d((FindNetworkResult) JsonUtils.json2Object(str, FindNetworkResult.class));
    }
}
