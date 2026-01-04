package com.huawei.hms.findnetwork.sdk;

import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.DecryptLocationCipherBean;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.g */
/* loaded from: classes8.dex */
public class C5360g extends BaseTaskApiCall<HmsClient, DecryptLocationCipherBean, FindNetworkResult<String>> {
    public C5360g(DecryptLocationCipherBean decryptLocationCipherBean) {
        super("findnetwork.decrypt_location_chiper", decryptLocationCipherBean);
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<FindNetworkResult<String>> c8941i) {
        FindNetworkResult<String> findNetworkResult = new FindNetworkResult<>();
        findNetworkResult.setData(str);
        findNetworkResult.setDescription(responseErrorCode.getErrorReason());
        findNetworkResult.setRespCode(responseErrorCode.getErrorCode());
        c8941i.m56658d(findNetworkResult);
    }
}
