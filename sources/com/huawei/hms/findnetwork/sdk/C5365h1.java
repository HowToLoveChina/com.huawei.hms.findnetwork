package com.huawei.hms.findnetwork.sdk;

import android.text.TextUtils;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.callback.FindNetworkSoundCallback;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.SoundRequestBean;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkConfigResult;
import com.huawei.hms.findnetwork.comm.util.JsonUtils;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.h1 */
/* loaded from: classes8.dex */
public class C5365h1 extends BaseTaskApiCall<HmsClient, SoundRequestBean, Void> {

    /* renamed from: a */
    public final FindNetworkSoundCallback f24784a;

    public C5365h1(SoundRequestBean soundRequestBean, FindNetworkSoundCallback findNetworkSoundCallback) {
        super("findnetwork.tag_start_sound", soundRequestBean);
        this.f24784a = findNetworkSoundCallback;
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) {
        FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult = (FindNetworkConfigResult) JsonUtils.json2Object(str, new C5411y0().getType());
        if (this.f24784a == null) {
            HmsFindSDKLog.m32127i("StartSoundApiCall", "callback == null");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            HmsFindSDKLog.m32127i("StartSoundApiCall", "body null");
            this.f24784a.onFail(getConfigResult(-1, "body null"));
            return;
        }
        if (findNetworkConfigResult == null) {
            HmsFindSDKLog.m32127i("StartSoundApiCall", "body parse error");
            this.f24784a.onFail(getConfigResult(-1, "body parse error"));
            return;
        }
        int respCode = findNetworkConfigResult.getRespCode();
        if (respCode == 0) {
            this.f24784a.onSuccess(findNetworkConfigResult);
            return;
        }
        if (respCode == 907201134) {
            this.f24784a.onFinished(findNetworkConfigResult);
            return;
        }
        FindNetworkSoundCallback findNetworkSoundCallback = this.f24784a;
        if (respCode != 907201165) {
            findNetworkSoundCallback.onFail(findNetworkConfigResult);
        } else {
            findNetworkSoundCallback.onUpdate(findNetworkConfigResult);
        }
    }
}
