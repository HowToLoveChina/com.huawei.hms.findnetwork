package com.huawei.hms.findnetwork.sdk;

import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.SetDevicePublicKeysRequestBean;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.u0 */
/* loaded from: classes8.dex */
public class C5403u0 extends BaseTaskApiCall<HmsClient, SetDevicePublicKeysRequestBean, Void> {
    public C5403u0(SetDevicePublicKeysRequestBean setDevicePublicKeysRequestBean) {
        super("findnetwork.setDevicePublicKeys", setDevicePublicKeysRequestBean);
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) {
        c8941i.m56658d(null);
    }
}
