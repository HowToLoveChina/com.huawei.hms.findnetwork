package com.huawei.hms.hwid;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.constant.AuthInternalPickerConstant;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.hms.support.api.entity.common.CommonNaming;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import org.json.JSONException;
import org.json.JSONObject;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.hwid.aj */
/* loaded from: classes8.dex */
public class C5593aj extends HuaweiApi<Api.ApiOptions.NoOptions> {
    public C5593aj(Activity activity, Api<Api.ApiOptions.NoOptions> api, Api.ApiOptions.NoOptions noOptions, AbstractClientBuilder abstractClientBuilder) {
        super(activity, api, noOptions, abstractClientBuilder);
    }

    /* renamed from: b */
    private C5589af m32873b() {
        return new C5589af(getContext().getPackageName());
    }

    /* renamed from: a */
    public Task<Void> m32874a() throws JSONException {
        String strM32866a = m32873b().m32866a();
        if (!TextUtils.isEmpty(strM32866a)) {
            return doWrite(new C5594ak(CommonNaming.startSmsRetriever, strM32866a, HiAnalyticsClient.reportEntry(getContext(), CommonNaming.startSmsRetriever, AuthInternalPickerConstant.HMS_SDK_VERSION)));
        }
        C8941i c8941i = new C8941i();
        c8941i.m56657c(new ApiException(new Status(2020, CommonConstant.RETCODE.SMS_PARAM_ERROR)));
        return c8941i.m56656b();
    }

    @Override // com.huawei.hms.common.HuaweiApi
    public int getApiLevel() {
        return 1;
    }

    public C5593aj(Context context, Api<Api.ApiOptions.NoOptions> api, Api.ApiOptions.NoOptions noOptions, AbstractClientBuilder abstractClientBuilder) {
        super(context, api, noOptions, abstractClientBuilder);
    }

    /* renamed from: a */
    public Task<Void> m32875a(String str) throws JSONException {
        C5602as.m32910b("ReadSmsService", "startConsent enter", true);
        if (str != null && str.length() > 120) {
            C8941i c8941i = new C8941i();
            c8941i.m56657c(new ApiException(new Status(2020, CommonConstant.RETCODE.SMS_PARAM_ERROR)));
            return c8941i.m56656b();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("packageName", getContext().getPackageName());
            jSONObject.put("phoneNumber", str);
        } catch (JSONException unused) {
            C5602as.m32912d("ReadSmsService", "toJson failed", true);
        }
        if (TextUtils.isEmpty(jSONObject.toString())) {
            C8941i c8941i2 = new C8941i();
            c8941i2.m56657c(new ApiException(new Status(2020, CommonConstant.RETCODE.SMS_PARAM_ERROR)));
            return c8941i2.m56656b();
        }
        return doWrite(new C5595al(CommonNaming.startConsent, jSONObject.toString(), HiAnalyticsClient.reportEntry(getContext(), CommonNaming.startConsent, AuthInternalPickerConstant.HMS_SDK_VERSION)));
    }
}
