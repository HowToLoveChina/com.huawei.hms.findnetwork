package com.huawei.hms.findnetwork.sdk;

import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.BaseRequestBean;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.u */
/* loaded from: classes8.dex */
public class C5402u extends BaseTaskApiCall<HmsClient, BaseRequestBean, Void> {
    public C5402u() {
        this("", null);
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) {
    }

    public C5402u(String str, BaseRequestBean baseRequestBean) {
        super(str, baseRequestBean);
    }
}
