package com.huawei.hms.findnetwork.sdk;

import android.text.TextUtils;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.SnRequestBean;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import p208cq.C8941i;
import p379j.InterfaceC10635a;

/* renamed from: com.huawei.hms.findnetwork.sdk.e1 */
/* loaded from: classes8.dex */
public class C5356e1 extends BaseTaskApiCall<HmsClient, SnRequestBean, Void> {

    /* renamed from: a */
    public final InterfaceC10635a<ResponseErrorCode, Void> f24778a;

    /* renamed from: b */
    public final InterfaceC10635a<String, Void> f24779b;

    public C5356e1(SnRequestBean snRequestBean, InterfaceC10635a<ResponseErrorCode, Void> interfaceC10635a, InterfaceC10635a<String, Void> interfaceC10635a2) {
        super("findnetwork.start_navigate", snRequestBean);
        this.f24778a = interfaceC10635a;
        this.f24779b = interfaceC10635a2;
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) {
        String str2;
        HmsFindSDKLog.m32127i("StartNavigateApiCall", "StartNavigateApiCall handleBusiness");
        if (this.f24778a == null) {
            HmsFindSDKLog.m32126e("StartNavigateApiCall", "startNavigateApiCall handler is null");
            return;
        }
        if (responseErrorCode == null) {
            str2 = "response is null ";
        } else {
            str2 = "response.getStatusCode: " + responseErrorCode.getStatusCode() + ", response.getErrorReason(): " + responseErrorCode.getErrorReason();
        }
        HmsFindSDKLog.m32127i("StartNavigateApiCall", str2);
        if (responseErrorCode.getStatusCode() == 907201007) {
            HmsFindSDKLog.m32127i("StartNavigateApiCall", "refresh: " + str);
            if (!TextUtils.isEmpty(str)) {
                this.f24779b.apply(str);
            }
        } else {
            this.f24778a.apply(responseErrorCode);
        }
        c8941i.m56658d(null);
    }
}
