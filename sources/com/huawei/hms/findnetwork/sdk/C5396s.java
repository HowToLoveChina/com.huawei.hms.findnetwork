package com.huawei.hms.findnetwork.sdk;

import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.BaseRequestBean;
import com.huawei.hms.findnetwork.comm.request.bean.TagLogRequestBean;
import com.huawei.hms.findnetwork.comm.request.callback.GrabTagLogListener;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.comm.util.JsonUtils;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.s */
/* loaded from: classes8.dex */
public class C5396s extends BaseTaskApiCall<HmsClient, BaseRequestBean, FindNetworkResult> {

    /* renamed from: a */
    public GrabTagLogListener f24850a;

    public C5396s(BaseRequestBean baseRequestBean, GrabTagLogListener grabTagLogListener) {
        super("findnetwork.grab_tag_log", baseRequestBean);
        this.f24850a = grabTagLogListener;
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<FindNetworkResult> c8941i) {
        if (responseErrorCode.getErrorCode() != 0) {
            this.f24850a.onGrabFail(responseErrorCode.getErrorCode(), responseErrorCode.getResolution());
            return;
        }
        TagLogRequestBean tagLogRequestBean = (TagLogRequestBean) JsonUtils.json2Object(str, TagLogRequestBean.class);
        int respCode = tagLogRequestBean.getRespCode();
        if (respCode == 0) {
            this.f24850a.onStartGrab();
            return;
        }
        if (respCode == 907201152) {
            this.f24850a.onGrabing(tagLogRequestBean.getCiphertext());
            return;
        }
        GrabTagLogListener grabTagLogListener = this.f24850a;
        if (respCode != 907201153) {
            grabTagLogListener.onGrabFail(tagLogRequestBean.getRespCode(), tagLogRequestBean.getDescription());
        } else {
            grabTagLogListener.onFinished();
        }
    }
}
