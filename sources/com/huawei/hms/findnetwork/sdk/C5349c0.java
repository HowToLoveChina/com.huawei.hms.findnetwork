package com.huawei.hms.findnetwork.sdk;

import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.wear.PairRequestBean;
import com.huawei.hms.findnetwork.comm.request.bean.wear.PhoneResponseMessage;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.comm.util.JsonUtils;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import com.huawei.hms.support.api.client.Status;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.c0 */
/* loaded from: classes8.dex */
public class C5349c0 extends BaseTaskApiCall<HmsClient, PairRequestBean, FindNetworkResult<PhoneResponseMessage>> {

    /* renamed from: com.huawei.hms.findnetwork.sdk.c0$b */
    public static class b extends TypeToken<FindNetworkResult<PhoneResponseMessage>> {
        public b() {
        }
    }

    public C5349c0(PairRequestBean pairRequestBean) {
        super("findnetwork.wear_processPairRequestMsg", pairRequestBean);
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<FindNetworkResult<PhoneResponseMessage>> c8941i) {
        ApiException apiException;
        HmsFindSDKLog.m32127i("ProcessPairRequestApiCall", "handleBusiness ProcessPairRequestApiCall");
        if (TextUtils.isEmpty(str)) {
            HmsFindSDKLog.m32127i("ProcessPairRequestApiCall", "body null");
            apiException = new ApiException(new Status(-1, "body null"));
        } else {
            FindNetworkResult<PhoneResponseMessage> findNetworkResult = (FindNetworkResult) JsonUtils.json2Object(str, new b().getType());
            if (findNetworkResult == null) {
                HmsFindSDKLog.m32127i("ProcessPairRequestApiCall", "body parse error");
                apiException = new ApiException(new Status(-1, "body parse error"));
            } else {
                if (findNetworkResult.getRespCode() == 0) {
                    c8941i.m56658d(findNetworkResult);
                    return;
                }
                HmsFindSDKLog.m32127i("ProcessPairRequestApiCall", "result error " + findNetworkResult.getRespCode() + " " + findNetworkResult.getDescription());
                apiException = new ApiException(new Status(findNetworkResult.getRespCode(), findNetworkResult.getDescription()));
            }
        }
        c8941i.m56657c(apiException);
    }
}
