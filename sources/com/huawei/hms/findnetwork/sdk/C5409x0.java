package com.huawei.hms.findnetwork.sdk;

import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.SetTrustTagRequestBean;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.x0 */
/* loaded from: classes8.dex */
public class C5409x0 extends BaseTaskApiCall<HmsClient, SetTrustTagRequestBean, Void> {
    public C5409x0(SetTrustTagRequestBean setTrustTagRequestBean) {
        super("findnetwork.setTrustTag", setTrustTagRequestBean);
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) {
        c8941i.m56658d(null);
    }
}
