package com.huawei.hms.findnetwork.sdk;

import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.DisConnectLocation;
import com.huawei.hms.findnetwork.comm.request.bean.SnRequestBean;
import com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.comm.util.JsonUtils;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.g0 */
/* loaded from: classes8.dex */
public class C5361g0 extends BaseTaskApiCall<HmsClient, SnRequestBean, FindNetworkResult<DisConnectLocation>> {

    /* renamed from: a */
    public final FindNetworkCallback<DisConnectLocation> f24782a;

    /* renamed from: com.huawei.hms.findnetwork.sdk.g0$b */
    public static class b extends TypeToken<FindNetworkResult<DisConnectLocation>> {
        public b() {
        }
    }

    public C5361g0(SnRequestBean snRequestBean, FindNetworkCallback<DisConnectLocation> findNetworkCallback) {
        super("findnetwork.queryDisconnectLocation", snRequestBean);
        this.f24782a = findNetworkCallback;
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<FindNetworkResult<DisConnectLocation>> c8941i) {
        HmsFindSDKLog.m32127i("QueryDisconnectLocationApiCall", "handleBusiness");
        FindNetworkResult<DisConnectLocation> findNetworkResult = new FindNetworkResult<>();
        HmsFindSDKLog.m32127i("QueryDisconnectLocationApiCall", "RespCode: " + findNetworkResult.getRespCode());
        if (responseErrorCode.getStatusCode() != 0) {
            findNetworkResult.setDescription(responseErrorCode.getErrorReason());
            findNetworkResult.setRespCode(responseErrorCode.getErrorCode());
            this.f24782a.onFail(findNetworkResult);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            HmsFindSDKLog.m32126e("QueryDisconnectLocationApiCall", "body null");
            findNetworkResult.setDescription("body null");
            findNetworkResult.setRespCode(-1);
            this.f24782a.onFail(findNetworkResult);
            return;
        }
        FindNetworkResult<DisConnectLocation> findNetworkResult2 = (FindNetworkResult) JsonUtils.json2Object(str, new b().getType());
        if (findNetworkResult2 == null) {
            HmsFindSDKLog.m32126e("QueryDisconnectLocationApiCall", "body parse error");
            findNetworkResult.setDescription("body parse error");
            findNetworkResult.setRespCode(-1);
            this.f24782a.onFail(findNetworkResult);
            return;
        }
        if (findNetworkResult2.getData() != null) {
            this.f24782a.onSuccess(findNetworkResult2);
            return;
        }
        HmsFindSDKLog.m32126e("QueryDisconnectLocationApiCall", "data is null");
        findNetworkResult.setDescription("data is null");
        findNetworkResult.setRespCode(-1);
        this.f24782a.onFail(findNetworkResult);
    }
}
