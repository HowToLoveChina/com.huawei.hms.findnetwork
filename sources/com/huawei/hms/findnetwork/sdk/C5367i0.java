package com.huawei.hms.findnetwork.sdk;

import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.BaseRequestBean;
import com.huawei.hms.findnetwork.comm.request.bean.LocationRecordBean;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.comm.util.JsonUtils;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import com.huawei.hms.support.api.client.Status;
import java.util.List;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.i0 */
/* loaded from: classes8.dex */
public class C5367i0 extends BaseTaskApiCall<HmsClient, BaseRequestBean, FindNetworkResult<List<LocationRecordBean>>> {

    /* renamed from: com.huawei.hms.findnetwork.sdk.i0$b */
    public static class b extends TypeToken<FindNetworkResult<List<LocationRecordBean>>> {
        public b() {
        }
    }

    public C5367i0(BaseRequestBean baseRequestBean) {
        super("findnetwork.queryLocationRecord", baseRequestBean);
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<FindNetworkResult<List<LocationRecordBean>>> c8941i) {
        ApiException apiException;
        if (TextUtils.isEmpty(str)) {
            HmsFindSDKLog.m32127i("QueryLocationRecordApiCall", "body null");
            apiException = new ApiException(new Status(-1, "body null"));
        } else {
            FindNetworkResult<List<LocationRecordBean>> findNetworkResult = (FindNetworkResult) JsonUtils.json2Object(str, new b().getType());
            if (findNetworkResult != null) {
                HmsFindSDKLog.m32127i("QueryLocationRecordApiCall", "success to call query location record. fncResult=" + findNetworkResult.getRespCode());
                if (findNetworkResult.getRespCode() == 0) {
                    c8941i.m56658d(findNetworkResult);
                    return;
                } else {
                    c8941i.m56657c(new ApiException(new Status(findNetworkResult.getRespCode(), findNetworkResult.getDescription())));
                    return;
                }
            }
            HmsFindSDKLog.m32127i("QueryLocationRecordApiCall", "body parse error");
            apiException = new ApiException(new Status(-1, "body parse error"));
        }
        c8941i.m56657c(apiException);
    }
}
