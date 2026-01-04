package com.huawei.hms.hwid;

import android.content.Context;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.constant.AuthInternalPickerConstant;
import com.huawei.hms.support.api.entity.core.CoreNaming;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.utils.Util;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hwid.w */
/* loaded from: classes8.dex */
public class C5625w extends HuaweiApi<a> {

    /* renamed from: a */
    private static final Api<a> f25367a = new Api<>(HuaweiApiAvailability.HMS_API_NAME_GAME);

    /* renamed from: c */
    private static final a f25368c = new a();

    /* renamed from: b */
    private Context f25369b;

    /* renamed from: com.huawei.hms.hwid.w$a */
    public static class a implements Api.ApiOptions.Optional {
    }

    public C5625w(Context context) {
        super(context, f25367a, f25368c, new C5624v());
        this.f25369b = context;
    }

    /* renamed from: a */
    public void m32960a() throws JSONException {
        C5602as.m32910b("SignInNoticeClientImpl", "request Jos Notice.", true);
        String strReportEntry = HiAnalyticsClient.reportEntry(getContext(), CoreNaming.GETNOTICE, AuthInternalPickerConstant.HMS_SDK_VERSION);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("noticeType", 1);
            jSONObject.put("hmsSdkVersionName", "6.12.0.300");
            jSONObject.put("cpId", Util.getCpId(this.f25369b));
            doWrite(new C5588ae(CoreNaming.GETNOTICE, jSONObject.toString(), strReportEntry));
        } catch (JSONException unused) {
            C5602as.m32911c("SignInNoticeClientImpl", "createParams Notice request meet JSONException.", true);
        }
    }

    @Override // com.huawei.hms.common.HuaweiApi
    public int getApiLevel() {
        return 1;
    }
}
