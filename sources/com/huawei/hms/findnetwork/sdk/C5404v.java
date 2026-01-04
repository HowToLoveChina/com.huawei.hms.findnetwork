package com.huawei.hms.findnetwork.sdk;

import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.BaseRequestBean;
import com.huawei.hms.findnetwork.comm.request.bean.wear.PairInitResponse;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.comm.util.JsonUtils;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import com.huawei.hms.support.api.client.Status;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.v */
/* loaded from: classes8.dex */
public class C5404v extends BaseTaskApiCall<HmsClient, BaseRequestBean, FindNetworkResult<String>> {

    /* renamed from: com.huawei.hms.findnetwork.sdk.v$b */
    public static class b extends TypeToken<FindNetworkResult<PairInitResponse>> {
        public b() {
        }
    }

    public C5404v(BaseRequestBean baseRequestBean) {
        super("findnetwork.wear_initPairSession", baseRequestBean);
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<FindNetworkResult<String>> c8941i) {
        ApiException apiException;
        HmsFindSDKLog.m32127i("InitPairSessionApiCall", "handleBusiness InitPairSessionApiCall");
        if (TextUtils.isEmpty(str)) {
            HmsFindSDKLog.m32127i("InitPairSessionApiCall", "body null");
            apiException = new ApiException(new Status(-1, "body null"));
        } else {
            FindNetworkResult findNetworkResult = (FindNetworkResult) JsonUtils.json2Object(str, new b().getType());
            if (findNetworkResult == null) {
                HmsFindSDKLog.m32127i("InitPairSessionApiCall", "body parse error");
                apiException = new ApiException(new Status(-1, "body parse error"));
            } else {
                if (findNetworkResult.getRespCode() == 0) {
                    FindNetworkResult<String> findNetworkResult2 = new FindNetworkResult<>();
                    findNetworkResult2.setRespCode(findNetworkResult.getRespCode());
                    findNetworkResult2.setSrcTransId(findNetworkResult.getSrcTransId());
                    if (findNetworkResult.getData() != null) {
                        findNetworkResult2.setData(((PairInitResponse) findNetworkResult.getData()).getNonce());
                    }
                    c8941i.m56658d(findNetworkResult2);
                    return;
                }
                HmsFindSDKLog.m32127i("InitPairSessionApiCall", "result error " + findNetworkResult.getRespCode() + " " + findNetworkResult.getDescription());
                apiException = new ApiException(new Status(findNetworkResult.getRespCode(), findNetworkResult.getDescription()));
            }
        }
        c8941i.m56657c(apiException);
    }
}
