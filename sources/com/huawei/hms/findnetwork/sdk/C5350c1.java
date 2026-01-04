package com.huawei.hms.findnetwork.sdk;

import android.text.TextUtils;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.BaseRequestBean;
import com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkScanResult;
import com.huawei.hms.findnetwork.comm.util.JsonUtils;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.c1 */
/* loaded from: classes8.dex */
public class C5350c1 extends BaseTaskApiCall<HmsClient, BaseRequestBean, Void> {

    /* renamed from: a */
    public final FindNetworkCallback<FindNetworkScanResult> f24775a;

    public C5350c1(FindNetworkCallback<FindNetworkScanResult> findNetworkCallback, BaseRequestBean baseRequestBean) {
        super("findnetwork.startFastScan", baseRequestBean);
        this.f24775a = findNetworkCallback;
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) {
        if (this.f24775a == null) {
            return;
        }
        int errorCode = responseErrorCode.getErrorCode();
        FindNetworkResult<FindNetworkScanResult> findNetworkResult = new FindNetworkResult<>();
        findNetworkResult.setRespCode(errorCode);
        findNetworkResult.setDescription(responseErrorCode.getErrorReason());
        if (errorCode != 0) {
            this.f24775a.onFail(findNetworkResult);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.f24775a.onSuccess(findNetworkResult);
            return;
        }
        FindNetworkScanResult findNetworkScanResult = (FindNetworkScanResult) JsonUtils.json2Object(str, FindNetworkScanResult.class);
        if (findNetworkScanResult != null) {
            findNetworkResult.setData(findNetworkScanResult);
            this.f24775a.onUpdate(findNetworkResult);
        }
    }
}
