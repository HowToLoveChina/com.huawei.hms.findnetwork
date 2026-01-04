package com.huawei.hms.findnetwork.sdk;

import android.text.TextUtils;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.QueryTagDerivedRequestBean;
import com.huawei.hms.findnetwork.comm.request.bean.TagDerivedKey;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.comm.util.JsonUtils;
import com.huawei.hms.findnetwork.sdk.C5379m0;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import com.huawei.hms.support.api.client.Status;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.f0 */
/* loaded from: classes8.dex */
public class C5358f0 extends BaseTaskApiCall<HmsClient, QueryTagDerivedRequestBean, FindNetworkResult<TagDerivedKey>> {
    public C5358f0(QueryTagDerivedRequestBean queryTagDerivedRequestBean) {
        super("findnetwork.queryDevicePublicKey", queryTagDerivedRequestBean);
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<FindNetworkResult<TagDerivedKey>> c8941i) {
        ApiException apiException;
        if (TextUtils.isEmpty(str)) {
            HmsFindSDKLog.m32127i("QueryDevicePublicKeyApiCall", "body null");
            apiException = new ApiException(new Status(-1, "body null"));
        } else {
            HmsFindSDKLog.m32127i("QueryDevicePublicKeyApiCall", "start to call query tag derived key");
            FindNetworkResult<TagDerivedKey> findNetworkResult = (FindNetworkResult) JsonUtils.json2Object(str, new C5379m0.a().getType());
            if (findNetworkResult != null) {
                HmsFindSDKLog.m32127i("QueryDevicePublicKeyApiCall", "success to call query tag derived key. fncResult=" + findNetworkResult.getRespCode());
                if (findNetworkResult.getRespCode() == 0) {
                    c8941i.m56658d(findNetworkResult);
                    return;
                } else {
                    c8941i.m56657c(new ApiException(new Status(findNetworkResult.getRespCode(), findNetworkResult.getDescription())));
                    return;
                }
            }
            HmsFindSDKLog.m32127i("QueryDevicePublicKeyApiCall", "body parse error");
            apiException = new ApiException(new Status(-1, "body parse error"));
        }
        c8941i.m56657c(apiException);
    }
}
