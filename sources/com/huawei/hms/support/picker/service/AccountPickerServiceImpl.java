package com.huawei.hms.support.picker.service;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.constant.AuthInternalPickerConstant;
import com.huawei.hms.common.utils.PickerHiAnalyticsUtil;
import com.huawei.hms.p109a.p110a.p112b.C5039b;
import com.huawei.hms.p109a.p110a.p114d.C5041a;
import com.huawei.hms.p109a.p110a.p114d.C5042b;
import com.huawei.hms.p109a.p110a.p114d.C5043c;
import com.huawei.hms.p109a.p110a.p114d.C5044d;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.common.CommonPickerConstant;
import com.huawei.hms.support.api.entity.common.PickerCommonNaming;
import com.huawei.hms.support.api.entity.hwid.AccountPickerSignInRequest;
import com.huawei.hms.support.api.entity.hwid.AccountPickerSignOutReq;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.support.picker.common.AccountPickerUtil;
import com.huawei.hms.support.picker.request.AccountPickerParams;
import iq.C10593g;
import org.json.JSONException;
import org.json.JSONObject;
import p208cq.C8941i;
import p640sq.C12832k;
import p640sq.C12836o;

/* loaded from: classes8.dex */
public class AccountPickerServiceImpl extends HuaweiApi<AccountPickerParams> implements AccountPickerService {
    private static final Api<AccountPickerParams> HUAWEI_ID_AUTH_API = new Api<>(HuaweiApiAvailability.HMS_API_NAME_ID);
    protected static final String TAG = "[HUAWEIIDSDK]AccountPickerServiceImpl";
    private AccountPickerParams accountPickerParams;
    private int mKitSdkVersion;
    private int mPickerType;
    private String transId;

    public AccountPickerServiceImpl(Activity activity, AccountPickerParams accountPickerParams, int i10) {
        super(activity, HUAWEI_ID_AUTH_API, accountPickerParams, (AbstractClientBuilder) new C5039b(), i10);
        this.transId = null;
        this.mPickerType = Integer.MIN_VALUE;
        this.accountPickerParams = accountPickerParams;
        this.mKitSdkVersion = i10;
    }

    private Task<Void> cancelAuthorizationFailure(int i10, String str, String str2) {
        C12836o.m77097b(TAG, "cancelAuthorizationFailure start. statusCode is " + i10, true);
        HiAnalyticsClient.reportExit(getContext(), PickerCommonNaming.AccountPickerRevokeAccess, str2, PickerHiAnalyticsUtil.getHiAnalyticsStatus(i10), i10);
        C8941i c8941i = new C8941i();
        c8941i.m56657c(new ApiException(new Status(i10, str)));
        return c8941i.m56656b();
    }

    private Task<Void> signOutFailure(int i10, String str, String str2) {
        C12836o.m77097b(TAG, "signOutFailure start. statusCode is " + i10, true);
        HiAnalyticsClient.reportExit(getContext(), PickerCommonNaming.AccountPickerSignout, str2, PickerHiAnalyticsUtil.getHiAnalyticsStatus(i10), i10);
        C8941i c8941i = new C8941i();
        c8941i.m56657c(new ApiException(new Status(i10, str)));
        return c8941i.m56656b();
    }

    @Override // com.huawei.hms.support.picker.service.AccountPickerService
    public Task<Void> cancelAuthorization(String str) throws JSONException {
        try {
            C12836o.m77097b(TAG, "cancelAuthorization", true);
            if (TextUtils.isEmpty(str)) {
                C12836o.m77099d(TAG, "input accessToken is null", true);
                return cancelAuthorizationFailure(2003, AuthInternalPickerConstant.PARAM_ERROR, this.transId);
            }
            AccountPickerSignInRequest accountPickerSignInRequest = new AccountPickerSignInRequest();
            JSONObject jSONObject = new JSONObject(this.accountPickerParams.getSignInParams());
            jSONObject.put("accessToken", str);
            this.accountPickerParams.setSignInParams(jSONObject.toString());
            String strOptString = jSONObject.optString(CommonPickerConstant.RequestParams.KEY_GRS_APP_NAME);
            accountPickerSignInRequest.setAccountPickerParams(getOption());
            String json = accountPickerSignInRequest.toJson();
            Context context = getContext();
            this.transId = HiAnalyticsClient.reportEntry(context, PickerCommonNaming.AccountPickerRevokeAccess, AuthInternalPickerConstant.HMS_SDK_VERSION);
            AvailableAdapter availableAdapter = new AvailableAdapter(AuthInternalPickerConstant.HMS_APK_VERSION_MIN);
            C12836o.m77097b(TAG, "check HMS service begin.", true);
            int iIsHuaweiMobileServicesAvailable = availableAdapter.isHuaweiMobileServicesAvailable(context);
            C12836o.m77097b(TAG, "cancelAuthorization isHuaweiMobileServicesAvailableCode:" + iIsHuaweiMobileServicesAvailable, true);
            if (iIsHuaweiMobileServicesAvailable != 1 && iIsHuaweiMobileServicesAvailable != 21 && iIsHuaweiMobileServicesAvailable != 3) {
                if (iIsHuaweiMobileServicesAvailable != 0 && iIsHuaweiMobileServicesAvailable != 2) {
                    return cancelAuthorizationFailure(2015, AuthInternalPickerConstant.UNKOWN_ERROR, this.transId);
                }
                C12836o.m77097b(TAG, "it has HMS service.", true);
                return doWrite(new C5041a("hwid.revokeAccess", json, this.transId));
            }
            C12836o.m77097b(TAG, "it has not HMS service.", true);
            C12832k.m77083b(context, false);
            C5042b c5042b = new C5042b(context, this.transId);
            AccountLiteSdkServiceImpl.revoke(context, strOptString, str, c5042b);
            return c5042b.m30090a().m56656b();
        } catch (C10593g e10) {
            C12836o.m77099d(TAG, "ParmaInvalidException:" + e10.getClass().getSimpleName(), true);
            return cancelAuthorizationFailure(2015, e10.getMessage(), this.transId);
        } catch (JSONException e11) {
            C12836o.m77099d(TAG, "JSONException:" + e11.getClass().getSimpleName(), true);
            return cancelAuthorizationFailure(2015, e11.getMessage(), this.transId);
        }
    }

    @Override // com.huawei.hms.common.HuaweiApi
    public int getApiLevel() {
        return 9;
    }

    @Override // com.huawei.hms.support.picker.service.AccountPickerService
    public Intent signIn() {
        boolean z10 = true;
        C12836o.m77097b(TAG, "accountPicker signIn", true);
        if (this.mPickerType == Integer.MIN_VALUE) {
            C12836o.m77097b(TAG, "pickerType is null", true);
            this.transId = HiAnalyticsClient.reportEntry(getContext(), PickerCommonNaming.signinIntent, AuthInternalPickerConstant.HMS_SDK_VERSION);
            z10 = false;
        } else {
            C12836o.m77097b(TAG, "pickerType is " + this.mPickerType, true);
            this.transId = HiAnalyticsClient.reportEntry(getContext(), PickerCommonNaming.signinAccountPickerType, AuthInternalPickerConstant.HMS_SDK_VERSION);
        }
        return AccountPickerUtil.getSignInIntent(getContext(), this.accountPickerParams, getSubAppID(), this.transId, this.mPickerType, z10);
    }

    @Override // com.huawei.hms.support.picker.service.AccountPickerService
    public Intent signInByMcp() {
        boolean z10 = true;
        C12836o.m77097b(TAG, "picker signInByMcp.", true);
        Context context = getContext();
        if (this.mPickerType == Integer.MIN_VALUE) {
            C12836o.m77097b(TAG, "pickerType is null", true);
            this.transId = HiAnalyticsClient.reportEntry(context, PickerCommonNaming.signinIntent, AuthInternalPickerConstant.HMS_SDK_VERSION);
            z10 = false;
        } else {
            C12836o.m77097b(TAG, "pickerType is " + this.mPickerType, true);
            this.transId = HiAnalyticsClient.reportEntry(context, PickerCommonNaming.signinAccountPickerType, AuthInternalPickerConstant.HMS_SDK_VERSION);
        }
        return AccountPickerUtil.getSignInByMcpIntent(context, this.accountPickerParams, getSubAppID(), this.transId, this.mPickerType, z10);
    }

    @Override // com.huawei.hms.support.picker.service.AccountPickerService
    public Task<Void> signOut() throws JSONException {
        C12836o.m77097b(TAG, "signOut", true);
        AccountPickerUtil.clearSignInAccountCache();
        AccountPickerSignOutReq accountPickerSignOutReq = new AccountPickerSignOutReq();
        Context context = getContext();
        this.transId = HiAnalyticsClient.reportEntry(context, PickerCommonNaming.AccountPickerSignout, AuthInternalPickerConstant.HMS_SDK_VERSION);
        int iIsHuaweiMobileServicesAvailable = new AvailableAdapter(AuthInternalPickerConstant.HMS_APK_VERSION_MIN).isHuaweiMobileServicesAvailable(context);
        C12836o.m77097b(TAG, "signOut isHuaweiMobileServicesAvailableCode:" + iIsHuaweiMobileServicesAvailable, true);
        C5043c c5043c = new C5043c(context, this.transId);
        C12836o.m77097b(TAG, "check HMS service begin.", true);
        try {
            if (iIsHuaweiMobileServicesAvailable == 1 || iIsHuaweiMobileServicesAvailable == 21 || iIsHuaweiMobileServicesAvailable == 3) {
                C12836o.m77097b(TAG, "it has not HMS service.", true);
                C12832k.m77083b(context, false);
                AccountLiteSdkServiceImpl.h5SignOut(context, c5043c);
                return c5043c.m30093a().m56656b();
            }
            if (iIsHuaweiMobileServicesAvailable != 0 && iIsHuaweiMobileServicesAvailable != 2) {
                return signOutFailure(2015, AuthInternalPickerConstant.UNKOWN_ERROR, this.transId);
            }
            AccountLiteSdkServiceImpl.h5SignOut(context, c5043c);
            return doWrite(new C5044d("hwid.signout", accountPickerSignOutReq.toJson(), this.transId));
        } catch (C10593g e10) {
            C12836o.m77099d(TAG, "ParmaInvalidException:" + e10.getClass().getSimpleName(), true);
            return signOutFailure(2003, AuthInternalPickerConstant.PARAM_ERROR, this.transId);
        }
    }

    public AccountPickerServiceImpl(Context context, AccountPickerParams accountPickerParams, int i10) {
        super(context, HUAWEI_ID_AUTH_API, accountPickerParams, new C5039b(), i10);
        this.transId = null;
        this.mPickerType = Integer.MIN_VALUE;
        this.mKitSdkVersion = i10;
        this.accountPickerParams = accountPickerParams;
    }

    public AccountPickerServiceImpl(Activity activity, AccountPickerParams accountPickerParams, int i10, int i11) {
        super(activity, HUAWEI_ID_AUTH_API, accountPickerParams, (AbstractClientBuilder) new C5039b(), i10);
        this.transId = null;
        this.accountPickerParams = accountPickerParams;
        this.mKitSdkVersion = i10;
        this.mPickerType = i11;
    }

    public AccountPickerServiceImpl(Context context, AccountPickerParams accountPickerParams, int i10, int i11) {
        super(context, HUAWEI_ID_AUTH_API, accountPickerParams, new C5039b(), i10);
        this.transId = null;
        this.accountPickerParams = accountPickerParams;
        this.mKitSdkVersion = i10;
        this.mPickerType = i11;
    }
}
