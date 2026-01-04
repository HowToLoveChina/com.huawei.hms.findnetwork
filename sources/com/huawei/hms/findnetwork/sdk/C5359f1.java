package com.huawei.hms.findnetwork.sdk;

import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.NearLinkNaviStatus;
import com.huawei.hms.findnetwork.comm.request.bean.NearLinkNavigationResult;
import com.huawei.hms.findnetwork.comm.request.bean.SnRequestBean;
import com.huawei.hms.findnetwork.comm.util.JsonUtils;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.f1 */
/* loaded from: classes8.dex */
public class C5359f1 extends BaseTaskApiCall<HmsClient, SnRequestBean, Void> {

    /* renamed from: a */
    public a f24781a;

    /* renamed from: com.huawei.hms.findnetwork.sdk.f1$a */
    public interface a {
        /* renamed from: a */
        void mo31977a();

        /* renamed from: a */
        void mo31978a(int i10, String str);

        /* renamed from: a */
        void mo31979a(NearLinkNavigationResult nearLinkNavigationResult);

        /* renamed from: b */
        void mo31980b();
    }

    public C5359f1(SnRequestBean snRequestBean, a aVar) {
        super("findnetwork.startNearLinkNavigation", snRequestBean);
        this.f24781a = aVar;
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) {
        if (responseErrorCode == null) {
            HmsFindSDKLog.m32128w("StartNearLinkNavigationApiCall", "handleBusiness ignore, param invalid.");
            return;
        }
        int statusCode = responseErrorCode.getStatusCode();
        int errorCode = responseErrorCode.getErrorCode();
        if (errorCode != 0) {
            this.f24781a.mo31978a(errorCode, responseErrorCode.getErrorReason());
            return;
        }
        if (statusCode == NearLinkNaviStatus.REQUEST_AR_POSE.getType()) {
            this.f24781a.mo31977a();
        } else if (statusCode != NearLinkNaviStatus.ON_RANGE_RESULT.getType()) {
            this.f24781a.mo31980b();
        } else {
            HmsFindSDKLog.m32127i("StartNearLinkNavigationApiCall", "handleBusiness onRangingResult.");
            this.f24781a.mo31979a((NearLinkNavigationResult) JsonUtils.json2Object(str, NearLinkNavigationResult.class));
        }
    }
}
