package com.huawei.hms.findnetwork.sdk;

import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.BaseRequestBean;
import com.huawei.hms.findnetwork.comm.request.bean.SnRequestBean;
import com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.comm.util.JsonUtils;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import com.huawei.hms.support.api.client.Status;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.q1 */
/* loaded from: classes8.dex */
public class C5392q1 extends BaseTaskApiCall<HmsClient, BaseRequestBean, FindNetworkResult<Void>> {

    /* renamed from: a */
    public final FindNetworkCallback f24849a;

    /* renamed from: com.huawei.hms.findnetwork.sdk.q1$b */
    public static class b extends TypeToken<FindNetworkResult<Boolean>> {
        public b() {
        }
    }

    public C5392q1(SnRequestBean snRequestBean, FindNetworkCallback findNetworkCallback) {
        super("findnetwork.tag_unpair", snRequestBean);
        this.f24849a = findNetworkCallback;
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<FindNetworkResult<Void>> c8941i) {
        ApiException apiException;
        HmsFindSDKLog.m32127i("UnPairApiCall", "handleBusiness");
        if (TextUtils.isEmpty(str)) {
            HmsFindSDKLog.m32127i("UnPairApiCall", "body null");
            apiException = new ApiException(new Status(-1, "body null"));
        } else {
            FindNetworkResult<Void> findNetworkResult = (FindNetworkResult) JsonUtils.json2Object(str, new b().getType());
            if (findNetworkResult != null) {
                int respCode = findNetworkResult.getRespCode();
                FindNetworkCallback findNetworkCallback = this.f24849a;
                if (respCode == 0) {
                    findNetworkCallback.onSuccess(findNetworkResult);
                } else {
                    findNetworkCallback.onFail(findNetworkResult);
                }
                c8941i.m56658d(findNetworkResult);
                return;
            }
            HmsFindSDKLog.m32127i("UnPairApiCall", "body parse error");
            apiException = new ApiException(new Status(-1, "body parse error"));
        }
        c8941i.m56657c(apiException);
    }
}
