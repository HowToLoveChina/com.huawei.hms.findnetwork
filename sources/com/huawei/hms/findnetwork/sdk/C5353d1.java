package com.huawei.hms.findnetwork.sdk;

import com.google.gson.reflect.TypeToken;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.callback.PairingCallback;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.BaseRequestBean;
import com.huawei.hms.findnetwork.comm.request.bean.PairingResultBean;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkConfigResult;
import com.huawei.hms.findnetwork.comm.util.JsonUtils;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.d1 */
/* loaded from: classes8.dex */
public class C5353d1 extends BaseTaskApiCall<HmsClient, BaseRequestBean, FindNetworkConfigResult<PairingResultBean>> {

    /* renamed from: a */
    public final PairingCallback f24776a;

    /* renamed from: com.huawei.hms.findnetwork.sdk.d1$b */
    public static class b extends TypeToken<FindNetworkConfigResult<PairingResultBean>> {
        public b() {
        }
    }

    public C5353d1(BaseRequestBean baseRequestBean, PairingCallback pairingCallback) {
        super("findnetwork.start_findnetwork_config", baseRequestBean);
        this.f24776a = pairingCallback;
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<FindNetworkConfigResult<PairingResultBean>> c8941i) {
        FindNetworkConfigResult<PairingResultBean> findNetworkConfigResult = (FindNetworkConfigResult) JsonUtils.json2Object(str, new b().getType());
        if (findNetworkConfigResult != null) {
            int respCode = findNetworkConfigResult.getRespCode();
            PairingCallback pairingCallback = this.f24776a;
            if (respCode == 0) {
                pairingCallback.onPairingSuccess(findNetworkConfigResult);
            } else {
                pairingCallback.onPairingFail(findNetworkConfigResult);
            }
            c8941i.m56658d(findNetworkConfigResult);
        }
    }
}
