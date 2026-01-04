package com.huawei.hms.findnetwork.sdk;

import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.wear.FidRequestBean;
import com.huawei.hms.findnetwork.comm.request.bean.wear.ResultResponse;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.comm.util.JsonUtils;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import com.huawei.hms.support.api.client.Status;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.t1 */
/* loaded from: classes8.dex */
public class C5401t1 extends BaseTaskApiCall<HmsClient, FidRequestBean, FindNetworkResult<String>> {

    /* renamed from: com.huawei.hms.findnetwork.sdk.t1$b */
    public static class b extends TypeToken<FindNetworkResult<ResultResponse>> {
        public b() {
        }
    }

    public C5401t1(FidRequestBean fidRequestBean) {
        super("findnetwork.wear_unPair", fidRequestBean);
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<FindNetworkResult<String>> c8941i) {
        if (TextUtils.isEmpty(str)) {
            HmsFindSDKLog.m32127i("WearUnPairApiCall", "body null");
            c8941i.m56657c(new ApiException(new Status(-1, "body null")));
            return;
        }
        FindNetworkResult findNetworkResult = (FindNetworkResult) JsonUtils.json2Object(str, new b().getType());
        if (findNetworkResult == null) {
            HmsFindSDKLog.m32127i("WearUnPairApiCall", "body parse error");
            c8941i.m56657c(new ApiException(new Status(-1, "body parse error")));
            return;
        }
        if (findNetworkResult.getRespCode() == 0) {
            FindNetworkResult<String> findNetworkResult2 = new FindNetworkResult<>();
            findNetworkResult2.setRespCode(findNetworkResult.getRespCode());
            findNetworkResult2.setSrcTransId(findNetworkResult.getSrcTransId());
            if (findNetworkResult.getData() != null) {
                findNetworkResult2.setData(((ResultResponse) findNetworkResult.getData()).getResult());
            }
            c8941i.m56658d(findNetworkResult2);
            return;
        }
        HmsFindSDKLog.m32127i("WearUnPairApiCall", "result error " + findNetworkResult.getRespCode() + " " + findNetworkResult.getDescription());
        c8941i.m56657c(new ApiException(new Status(findNetworkResult.getRespCode(), findNetworkResult.getDescription())));
    }
}
