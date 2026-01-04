package com.huawei.hms.support.hwid.service;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.constant.AuthInternalPickerConstant;
import com.huawei.hms.hwid.C5585ab;
import com.huawei.hms.hwid.C5586ac;
import com.huawei.hms.hwid.C5587ad;
import com.huawei.hms.hwid.C5602as;
import com.huawei.hms.hwid.C5624v;
import com.huawei.hms.hwid.C5626x;
import com.huawei.hms.hwid.C5628z;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.common.CommonNaming;
import com.huawei.hms.support.api.entity.hwid.HuaweiIdSignInRequest;
import com.huawei.hms.support.api.entity.hwid.SignOutReq;
import com.huawei.hms.support.api.hwid.HuaweiIdGetTokenOptions;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParams;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import org.json.JSONException;
import org.json.JSONObject;
import p208cq.C8941i;

/* loaded from: classes8.dex */
public class HuaweiIdAuthServiceImpl extends HuaweiApi<HuaweiIdAuthParams> implements HuaweiIdAuthService {
    private static final Api<HuaweiIdAuthParams> HUAWEI_ID_AUTH_API = new Api<>(HuaweiApiAvailability.HMS_API_NAME_ID);
    protected static final String TAG = "[HUAWEIIDSDK]HuaweiIdAuthService";
    private String mAccountName;
    private boolean mFromRequestToken;

    public HuaweiIdAuthServiceImpl(Activity activity, HuaweiIdAuthParams huaweiIdAuthParams, int i10) {
        super(activity, HUAWEI_ID_AUTH_API, huaweiIdAuthParams, (AbstractClientBuilder) new C5624v(), i10);
    }

    private HuaweiIdAuthParams setSignInParams(String str) {
        HuaweiIdAuthParams option = getOption();
        try {
            new JSONObject(str);
            try {
                HuaweiIdAuthParams huaweiIdAuthParamsM85660clone = option.m85660clone();
                huaweiIdAuthParamsM85660clone.setSignInParams(str);
                return huaweiIdAuthParamsM85660clone;
            } catch (CloneNotSupportedException unused) {
                C5602as.m32912d(TAG, "CloneNotSupportedException", true);
                return option;
            }
        } catch (JSONException unused2) {
            C5602as.m32912d(TAG, "JSONException", true);
            return option;
        }
    }

    @Override // com.huawei.hms.support.feature.service.AuthService
    public Task<Void> cancelAuthorization() {
        C5602as.m32910b(TAG, "cancelAuthorization", true);
        HuaweiIdSignInRequest huaweiIdSignInRequest = new HuaweiIdSignInRequest();
        huaweiIdSignInRequest.setHuaweiIdAuthParams(getOption());
        try {
            return doWrite(new C5628z("hwid.revokeAccess", huaweiIdSignInRequest.toJson(), HiAnalyticsClient.reportEntry(getContext(), "hwid.revokeAccess", AuthInternalPickerConstant.HMS_SDK_VERSION)));
        } catch (JSONException unused) {
            C5602as.m32912d(TAG, "JSONException, errorcode is:2015", true);
            C8941i c8941i = new C8941i();
            c8941i.m56657c(new ApiException(new Status(2015)));
            return c8941i.m56656b();
        }
    }

    @Override // com.huawei.hms.common.HuaweiApi
    public int getApiLevel() {
        return 1;
    }

    @Override // com.huawei.hms.support.feature.service.AuthService
    public Intent getSignInIntent() {
        return getSignInIntent("");
    }

    @Override // com.huawei.hms.support.feature.service.AuthService
    public Task<Void> signOut() {
        C5602as.m32910b(TAG, "signOut", true);
        C5626x.m32964a();
        SignOutReq signOutReq = new SignOutReq();
        return doWrite(new C5587ad("hwid.signout", signOutReq.toJson(), HiAnalyticsClient.reportEntry(getContext(), "hwid.signout", AuthInternalPickerConstant.HMS_SDK_VERSION)));
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAuthService
    public Task<AuthHuaweiId> silentSignIn() {
        return silentSignIn("");
    }

    public HuaweiIdAuthServiceImpl(Context context, HuaweiIdAuthParams huaweiIdAuthParams, int i10) {
        super(context, HUAWEI_ID_AUTH_API, huaweiIdAuthParams, new C5624v(), i10);
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAuthService
    public Intent getSignInIntent(String str) {
        C5602as.m32910b(TAG, "getSignInIntent", true);
        return C5626x.m32961a(getContext(), setSignInParams(str), getSubAppID());
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAuthService
    public Task<AuthHuaweiId> silentSignIn(String str) {
        C5602as.m32910b(TAG, "silentSignIn", true);
        HuaweiIdSignInRequest huaweiIdSignInRequest = new HuaweiIdSignInRequest();
        huaweiIdSignInRequest.setHuaweiIdAuthParams(setSignInParams(str));
        boolean z10 = this.mFromRequestToken;
        if (z10) {
            huaweiIdSignInRequest.setHuaweiIdGetTokenOptions(new HuaweiIdGetTokenOptions(this.mAccountName, z10));
        }
        try {
            String json = huaweiIdSignInRequest.toJson();
            String strReportEntry = HiAnalyticsClient.reportEntry(getContext(), CommonNaming.silentSignIn, AuthInternalPickerConstant.HMS_SDK_VERSION);
            return this.mFromRequestToken ? doWrite(new C5585ab(CommonNaming.silentSignIn, json, strReportEntry)) : doWrite(new C5586ac(CommonNaming.silentSignIn, json, strReportEntry));
        } catch (JSONException unused) {
            C5602as.m32912d(TAG, "JSONException, errorcode is:2015", true);
            C8941i c8941i = new C8941i();
            c8941i.m56657c(new ApiException(new Status(2015)));
            return c8941i.m56656b();
        }
    }

    public HuaweiIdAuthServiceImpl(Context context, HuaweiIdAuthParams huaweiIdAuthParams, String str, int i10) {
        super(context, HUAWEI_ID_AUTH_API, huaweiIdAuthParams, new C5624v(), i10);
        this.mAccountName = str;
        this.mFromRequestToken = true;
    }

    public HuaweiIdAuthServiceImpl(Activity activity, HuaweiIdAuthParams huaweiIdAuthParams, String str, int i10) {
        super(activity, HUAWEI_ID_AUTH_API, huaweiIdAuthParams, (AbstractClientBuilder) new C5624v(), i10);
        this.mAccountName = str;
        this.mFromRequestToken = true;
    }
}
