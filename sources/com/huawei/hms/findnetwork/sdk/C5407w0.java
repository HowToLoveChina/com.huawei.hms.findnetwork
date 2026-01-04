package com.huawei.hms.findnetwork.sdk;

import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.SetPublicKeysRequestBean;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.w0 */
/* loaded from: classes8.dex */
public class C5407w0 extends BaseTaskApiCall<HmsClient, SetPublicKeysRequestBean, Void> {
    public C5407w0(SetPublicKeysRequestBean setPublicKeysRequestBean) {
        super("findnetwork.setPublicKeys", setPublicKeysRequestBean);
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) {
        c8941i.m56658d(null);
    }
}
