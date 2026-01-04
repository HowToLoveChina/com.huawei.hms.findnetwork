package com.huawei.hms.support.account.service;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.constant.AuthInternalPickerConstant;
import com.huawei.hms.hwid.C5598ao;
import com.huawei.hms.hwid.C5602as;
import com.huawei.hms.hwid.C5605d;
import com.huawei.hms.hwid.C5607f;
import com.huawei.hms.hwid.C5609h;
import com.huawei.hms.hwid.C5610i;
import com.huawei.hms.hwid.C5612j;
import com.huawei.hms.hwid.C5614l;
import com.huawei.hms.hwid.C5615m;
import com.huawei.hms.hwid.C5616n;
import com.huawei.hms.hwid.C5617o;
import com.huawei.hms.hwid.C5618p;
import com.huawei.hms.support.account.request.AccountAuthParams;
import com.huawei.hms.support.account.result.AccountIcon;
import com.huawei.hms.support.account.result.AssistTokenResult;
import com.huawei.hms.support.account.result.AuthAccount;
import com.huawei.hms.support.api.account.AccountGetTokenOptions;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.account.AccountLogoutRequest;
import com.huawei.hms.support.api.entity.account.AccountNaming;
import com.huawei.hms.support.api.entity.account.AccountSignInRequest;
import com.huawei.hms.support.api.entity.account.AccountSignOutReq;
import com.huawei.hms.support.api.entity.account.AccountStartAssistLoginRequest;
import com.huawei.hms.support.api.entity.account.GetAssistTokenRequest;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import p208cq.C8941i;

/* loaded from: classes8.dex */
public class AccountAuthServiceImpl extends HuaweiApi<AccountAuthParams> implements AccountAuthService {
    private static final Api<AccountAuthParams> ACCOUNT_AUTH_API = new Api<>("AuthAccount.API");
    private static final Long ONE_WEEK_MILLISECOND = 604800000L;
    protected static final String TAG = "[ACCOUNT]AccountAuthServiceImpl";
    private String mAccountName;
    private boolean mFromRequestToken;

    public AccountAuthServiceImpl(Activity activity, AccountAuthParams accountAuthParams, int i10) {
        super(activity, ACCOUNT_AUTH_API, accountAuthParams, (AbstractClientBuilder) new C5605d(), i10);
    }

    private boolean checkIdTokenSignAlg(AccountAuthParams accountAuthParams) throws JSONException {
        C5602as.m32910b(TAG, "checkIdTokenSignAlg", true);
        if (accountAuthParams == null) {
            C5602as.m32912d(TAG, "accountAuthParams is null", true);
            return false;
        }
        try {
            int i10 = new JSONObject(accountAuthParams.getSignInParams()).getInt("idTokenSignAlg");
            return i10 == 1 || i10 == 2;
        } catch (JSONException e10) {
            C5602as.m32912d(TAG, "JSONException:" + e10.getClass().getSimpleName(), true);
            return false;
        }
    }

    private Task<AssistTokenResult> doWriteGetAssistToken(GetAssistTokenRequest getAssistTokenRequest) {
        try {
            return doWrite(new C5618p(AccountNaming.getAssistToken, getAssistTokenRequest.toJson(), HiAnalyticsClient.reportEntry(getContext(), AccountNaming.getAssistToken, AuthInternalPickerConstant.HMS_SDK_VERSION)));
        } catch (JSONException unused) {
            C5602as.m32912d(TAG, "JSONException， errorcode is:2015", true);
            C8941i c8941i = new C8941i();
            c8941i.m56657c(new ApiException(new Status(2015)));
            return c8941i.m56656b();
        }
    }

    private Bitmap stringToBitmap(String str) {
        try {
            byte[] bArrDecode = Base64.decode(str, 0);
            return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
        } catch (Exception e10) {
            C5602as.m32912d(TAG, "stringToBitmap Exception is " + e10.getClass().getSimpleName(), true);
            return null;
        } catch (OutOfMemoryError unused) {
            C5602as.m32912d(TAG, "out of memory error ", true);
            return null;
        }
    }

    @Override // com.huawei.hms.support.feature.service.AuthService
    public Task<Void> cancelAuthorization() {
        C5602as.m32910b(TAG, "cancelAuthorization", true);
        AccountSignInRequest accountSignInRequest = new AccountSignInRequest();
        accountSignInRequest.setAccountAuthParams(getOption());
        try {
            return doWrite(new C5609h(AccountNaming.revokeAccessAccount, accountSignInRequest.toJson(), HiAnalyticsClient.reportEntry(getContext(), AccountNaming.revokeAccessAccount, AuthInternalPickerConstant.HMS_SDK_VERSION)));
        } catch (JSONException unused) {
            C5602as.m32912d(TAG, "JSONException, errorcode is:2015", true);
            C8941i c8941i = new C8941i();
            c8941i.m56657c(new ApiException(new Status(2015)));
            return c8941i.m56656b();
        }
    }

    @Override // com.huawei.hms.common.HuaweiApi
    public int getApiLevel() {
        List<PermissionInfo> permissionInfos;
        AccountAuthParams option = getOption();
        if (option != null && (permissionInfos = option.getPermissionInfos()) != null && permissionInfos.size() != 0) {
            Iterator<PermissionInfo> it = permissionInfos.iterator();
            while (it.hasNext()) {
                String permission = it.next().getPermission();
                if (permission != null && permission.equals(CommonConstant.LocalPermission.CARRIER_ID)) {
                    C5602as.m32910b(TAG, "permissioninfos contain carrierId and silentSignIn setApiLevel is 13", true);
                    return 13;
                }
            }
        }
        return 1;
    }

    @Override // com.huawei.hms.support.account.service.AccountAuthService
    public Task<AssistTokenResult> getAssistToken(GetAssistTokenRequest getAssistTokenRequest) {
        C5602as.m32910b(TAG, "getAssistToken", true);
        return doWriteGetAssistToken(getAssistTokenRequest);
    }

    @Override // com.huawei.hms.support.account.service.AccountAuthService
    public Task<AccountIcon> getChannel() {
        C5602as.m32910b(TAG, "getChannel", true);
        AccountSignInRequest accountSignInRequest = new AccountSignInRequest();
        accountSignInRequest.setAccountAuthParams(getOption());
        Context context = getContext();
        SharedPreferences sharedPreferences = context.getSharedPreferences("ACCOUNT_CHANNEL_CACHE", 0);
        String string = sharedPreferences.getString("icon", "");
        String string2 = sharedPreferences.getString("desc", "");
        long j10 = sharedPreferences.getLong("cache_time", 0L);
        long jM32895a = C5598ao.m32895a();
        if (j10 == 0 || TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || jM32895a - j10 >= ONE_WEEK_MILLISECOND.longValue()) {
            try {
                return doWrite(new C5610i(AccountNaming.getChannelAccount, accountSignInRequest.toJson(), HiAnalyticsClient.reportEntry(getContext(), AccountNaming.getChannelAccount, AuthInternalPickerConstant.HMS_SDK_VERSION), context));
            } catch (JSONException unused) {
                C5602as.m32912d(TAG, "JSONException, errorcode is:2015", true);
                C8941i c8941i = new C8941i();
                c8941i.m56657c(new ApiException(new Status(2015)));
                return c8941i.m56656b();
            }
        }
        AccountIcon accountIcon = new AccountIcon(string2, stringToBitmap(string));
        C8941i c8941i2 = new C8941i();
        c8941i2.m56658d(accountIcon);
        c8941i2.m56657c(new ApiException(new Status(0)));
        return c8941i2.m56656b();
    }

    @Override // com.huawei.hms.support.account.service.AccountAuthService
    public Intent getIndependentSignInIntent(String str) {
        C5602as.m32910b(TAG, "getIndependentSignInIntent", true);
        return C5607f.m32919a(getContext(), getOption(), getSubAppID(), str);
    }

    @Override // com.huawei.hms.support.feature.service.AuthService
    public Intent getSignInIntent() {
        C5602as.m32910b(TAG, "getSignInIntent", true);
        return C5607f.m32917a(getContext(), getOption(), getSubAppID());
    }

    @Override // com.huawei.hms.support.account.service.AccountAuthService
    public Task<Void> logout() {
        C5602as.m32910b(TAG, "logout", true);
        AccountLogoutRequest accountLogoutRequest = new AccountLogoutRequest();
        accountLogoutRequest.setAccountAuthParams(getOption());
        try {
            return doWrite(new C5612j(AccountNaming.logout, accountLogoutRequest.toJson(), HiAnalyticsClient.reportEntry(getContext(), AccountNaming.logout, AuthInternalPickerConstant.HMS_SDK_VERSION)));
        } catch (JSONException unused) {
            C5602as.m32912d(TAG, "JSONException, errorcode is:2015", true);
            C8941i c8941i = new C8941i();
            c8941i.m56657c(new ApiException(new Status(2015)));
            return c8941i.m56656b();
        }
    }

    @Override // com.huawei.hms.support.feature.service.AuthService
    public Task<Void> signOut() {
        C5602as.m32910b(TAG, "signOut", true);
        C5607f.m32922a();
        AccountSignOutReq accountSignOutReq = new AccountSignOutReq();
        return doWrite(new C5616n(AccountNaming.signoutAccount, accountSignOutReq.toJson(), HiAnalyticsClient.reportEntry(getContext(), "hwid.signout", AuthInternalPickerConstant.HMS_SDK_VERSION)));
    }

    @Override // com.huawei.hms.support.account.service.AccountAuthService
    public Task<AuthAccount> silentSignIn() {
        C5602as.m32910b(TAG, "silentSignIn", true);
        AccountSignInRequest accountSignInRequest = new AccountSignInRequest();
        AccountAuthParams option = getOption();
        accountSignInRequest.setAccountAuthParams(option);
        boolean z10 = this.mFromRequestToken;
        if (z10) {
            accountSignInRequest.setAccountGetTokenOptions(new AccountGetTokenOptions(this.mAccountName, z10));
        }
        if (!checkIdTokenSignAlg(option)) {
            C5602as.m32912d(TAG, "idTokenSignAlg is invalid", true);
            C8941i c8941i = new C8941i();
            c8941i.m56657c(new ApiException(new Status(2003, "idTokenSignAlg is invalid")));
            return c8941i.m56656b();
        }
        try {
            String json = accountSignInRequest.toJson();
            String strReportEntry = HiAnalyticsClient.reportEntry(getContext(), AccountNaming.silentSignInAccount, AuthInternalPickerConstant.HMS_SDK_VERSION);
            return this.mFromRequestToken ? doWrite(new C5614l(AccountNaming.silentSignInAccount, json, strReportEntry)) : doWrite(new C5615m(AccountNaming.silentSignInAccount, json, strReportEntry));
        } catch (JSONException unused) {
            C5602as.m32912d(TAG, "JSONException, errorcode is:2015", true);
            C8941i c8941i2 = new C8941i();
            c8941i2.m56657c(new ApiException(new Status(2015)));
            return c8941i2.m56656b();
        }
    }

    @Override // com.huawei.hms.support.account.service.AccountAuthService
    public Task<Void> startAssistLogin(String str) {
        C5602as.m32910b(TAG, "startAssistLogin", true);
        try {
            return doWrite(new C5617o(AccountNaming.startAssistLogin, new AccountStartAssistLoginRequest(str).toJson(), HiAnalyticsClient.reportEntry(getContext(), AccountNaming.startAssistLogin, AuthInternalPickerConstant.HMS_SDK_VERSION)));
        } catch (JSONException unused) {
            C5602as.m32912d(TAG, "JSONException, errorcode is:2015", true);
            C8941i c8941i = new C8941i();
            c8941i.m56657c(new ApiException(new Status(2015)));
            return c8941i.m56656b();
        }
    }

    public AccountAuthServiceImpl(Context context, AccountAuthParams accountAuthParams, int i10) {
        super(context, ACCOUNT_AUTH_API, accountAuthParams, new C5605d(), i10);
    }

    public AccountAuthServiceImpl(Context context, AccountAuthParams accountAuthParams, String str, int i10) {
        super(context, ACCOUNT_AUTH_API, accountAuthParams, new C5605d(), i10);
        this.mAccountName = str;
        this.mFromRequestToken = true;
    }

    public AccountAuthServiceImpl(Activity activity, AccountAuthParams accountAuthParams, String str, int i10) {
        super(activity, ACCOUNT_AUTH_API, accountAuthParams, (AbstractClientBuilder) new C5605d(), i10);
        this.mAccountName = str;
        this.mFromRequestToken = true;
    }
}
