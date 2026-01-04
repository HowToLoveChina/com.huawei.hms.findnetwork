package com.huawei.hms.findnetwork.sdk;

import com.google.gson.reflect.TypeToken;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.SnRequestBean;
import com.huawei.hms.findnetwork.comm.request.bean.TagStatus;
import com.huawei.hms.findnetwork.comm.request.callback.FindNetworkCallback;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.comm.util.JsonUtils;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.e */
/* loaded from: classes8.dex */
public class C5354e extends BaseTaskApiCall<HmsClient, SnRequestBean, Void> {

    /* renamed from: a */
    public final FindNetworkCallback<TagStatus> f24777a;

    /* renamed from: com.huawei.hms.findnetwork.sdk.e$b */
    public static class b extends TypeToken<FindNetworkResult<TagStatus>> {
        public b() {
        }
    }

    public C5354e(SnRequestBean snRequestBean, FindNetworkCallback<TagStatus> findNetworkCallback) {
        super("findnetwork.query_tag_derived_status", snRequestBean);
        this.f24777a = findNetworkCallback;
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) {
        FindNetworkCallback<TagStatus> findNetworkCallback;
        HmsFindSDKLog.m32127i("CheckTagStatusApiCall", "handleBusiness checkTagStatus.");
        FindNetworkResult<TagStatus> findNetworkResult = (FindNetworkResult) JsonUtils.json2Object(str, new b().getType());
        if (this.f24777a == null) {
            HmsFindSDKLog.m32127i("CheckTagStatusApiCall", "callback == null");
            return;
        }
        if (findNetworkResult != null) {
            int respCode = findNetworkResult.getRespCode();
            findNetworkCallback = this.f24777a;
            if (respCode == 0) {
                findNetworkCallback.onSuccess(findNetworkResult);
                return;
            }
        } else {
            findNetworkResult = new FindNetworkResult<>();
            findNetworkResult.setRespCode(responseErrorCode.getErrorCode());
            findNetworkResult.setDescription(responseErrorCode.getErrorReason());
            findNetworkCallback = this.f24777a;
        }
        findNetworkCallback.onFail(findNetworkResult);
    }
}
