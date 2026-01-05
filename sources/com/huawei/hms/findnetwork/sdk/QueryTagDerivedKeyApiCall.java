package com.huawei.hms.findnetwork.sdk;

import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.QueryTagDerivedKeyBean;
import com.huawei.hms.findnetwork.comm.request.bean.TagDerivedKey;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.comm.util.JsonUtils;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import com.huawei.hms.support.api.client.Status;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.m0 */
/* loaded from: classes8.dex */
public class QueryTagDerivedKeyApiCall extends BaseTaskApiCall<HmsClient, QueryTagDerivedKeyBean, FindNetworkResult<TagDerivedKey>> {

    /* renamed from: com.huawei.hms.findnetwork.sdk.m0$a */
    public static class a extends TypeToken<FindNetworkResult<TagDerivedKey>> {
    }

    public QueryTagDerivedKeyApiCall(QueryTagDerivedKeyBean queryTagDerivedKeyBean) {
        super("findnetwork.query_tag_derived_Key", queryTagDerivedKeyBean);
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<FindNetworkResult<TagDerivedKey>> c8941i) {
        ApiException apiException;
        if (TextUtils.isEmpty(str)) {
            HmsFindSDKLog.m32127i("QueryTagDerivedKeyApiCall", "body isEmpty");
            apiException = new ApiException(new Status(-1, "body isEmpty"));
        } else {
            HmsFindSDKLog.m32127i("QueryTagDerivedKeyApiCall", "start to call query tag derived key");
            FindNetworkResult<TagDerivedKey> findNetworkResult = (FindNetworkResult) JsonUtils.json2Object(str, new a().getType());
            if (findNetworkResult != null) {
                HmsFindSDKLog.m32127i("QueryTagDerivedKeyApiCall", "success to call query tag derived key. fncResult=" + findNetworkResult.getRespCode());
                if (findNetworkResult.getRespCode() == 0) {
                    c8941i.m56658d(findNetworkResult);
                    return;
                } else {
                    c8941i.m56657c(new ApiException(new Status(findNetworkResult.getRespCode(), findNetworkResult.getDescription())));
                    return;
                }
            }
            HmsFindSDKLog.m32127i("QueryTagDerivedKeyApiCall", "body parse error");
            apiException = new ApiException(new Status(-1, "body parse error"));
        }
        c8941i.m56657c(apiException);
    }
}
