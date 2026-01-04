package com.huawei.hms.findnetwork.sdk;

import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.SnRequestBean;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.k */
/* loaded from: classes8.dex */
public class C5372k extends BaseTaskApiCall<HmsClient, SnRequestBean, Void> {
    public C5372k(SnRequestBean snRequestBean) {
        super("findnetwork.tag_updateLongConnectionParams", snRequestBean);
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) {
        HmsFindSDKLog.m32127i("DisconnectTagApiCall", "DisconnectTagApiCall handleBusiness");
        FindNetworkResult findNetworkResult = new FindNetworkResult();
        findNetworkResult.setData(str);
        HmsFindSDKLog.m32127i("DisconnectTagApiCall", "result.getRespCode() == " + findNetworkResult.getRespCode());
        c8941i.m56658d(null);
    }
}
