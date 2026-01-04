package com.huawei.hms.support.picker.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.activity.ForegroundIntentBuilder;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.common.internal.constant.AuthInternalPickerConstant;
import com.huawei.hms.common.utils.PickerHiAnalyticsUtil;
import com.huawei.hms.p109a.p110a.p111a.C5037a;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.common.CommonPickerConstant;
import com.huawei.hms.support.api.entity.common.PickerCommonNaming;
import com.huawei.hms.support.api.entity.hwid.AccountPickerSignInRequest;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.support.picker.activity.AccountPickerSignInHubContract;
import com.huawei.hms.support.picker.common.AccountPickerUtil;
import com.huawei.hms.support.picker.common.HMSAPKVersionCheckUtil;
import com.huawei.hms.support.picker.request.AccountPickerParams;
import com.huawei.hms.support.picker.result.AccountPickerResult;
import com.huawei.hms.support.picker.result.AuthAccountPicker;
import com.huawei.hms.support.picker.service.AccountLiteSdkServiceImpl;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hwidauth.datatype.DeviceInfo;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import com.huawei.secure.android.common.intent.SafeIntent;
import iq.C10588b;
import iq.C10591e;
import iq.C10593g;
import iq.InterfaceC10596j;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import p432kq.C11135g;
import p432kq.C11136h;
import p432kq.C11139k;
import p432kq.C11140l;
import p432kq.C11141m;
import p432kq.InterfaceC11137i;
import p640sq.C12824c;
import p640sq.C12826e;
import p640sq.C12832k;
import p640sq.C12836o;
import p640sq.C12842u;

/* loaded from: classes8.dex */
public class AccountPickerSignInHubPresenter extends AccountPickerSignInHubContract.Presenter {
    private static final int API_LEVEL_11 = 11;
    private static final int API_LEVEL_9 = 9;
    private static final int STRING_LENGTH_512 = 512;
    private static final String TAG = "AccountPickerSignInHubPresenter";
    private static final String TAINSID_KEY = "HiAnalyticsTransId";
    private String mAction;
    private C5037a mClientInfo;
    private String mCodeVerifier;
    private final Activity mContext;
    private DeviceInfo mDeviceInfo;
    private String mDeviceInfoStr;
    private boolean mHasAtPerMission;
    private boolean mHasIDTokenPerMission;
    private int mIdTokenSignAlg;
    private boolean mIsGuideLogin;
    private String mJsonCpClientInfo;
    private String mJsonSignInRequest;
    private String mParentAccessToken;
    private int mPickerType;
    private String mRedirectUrl;
    private String[] mScopes;
    private final AccountPickerSignInHubContract.View mView;
    private AccountPickerSignInRequest mSignInRequest = null;
    private boolean mIsSignInByMCP = false;
    private boolean mIsNewService = false;
    private String mTransId = null;
    public boolean mIsActivityFullScreen = false;
    private String mLoginUrl = "";
    private String mGrsAppName = "";

    /* renamed from: com.huawei.hms.support.picker.activity.AccountPickerSignInHubPresenter$1 */
    public class C65021 implements InterfaceC11137i {
        public C65021() {
        }

        @Override // p432kq.InterfaceC11137i
        public void onFailure(int i10, String str) {
            C12836o.m77097b(AccountPickerSignInHubPresenter.TAG, "doSilentTokeRequest onFailure: error code = " + i10 + ",error msg =" + str, false);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("doSilentTokeRequest onFailure: error code = ");
            sb2.append(i10);
            C12836o.m77097b(AccountPickerSignInHubPresenter.TAG, sb2.toString(), true);
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has(VastAttribute.ERROR)) {
                    AccountPickerSignInHubPresenter.this.dealSilentTokenErrorResponse(jSONObject.optInt(VastAttribute.ERROR));
                } else {
                    AccountPickerSignInHubPresenter.this.onSignInFailed(i10);
                }
            } catch (JSONException e10) {
                C12836o.m77099d(AccountPickerSignInHubPresenter.TAG, "exception: " + e10.getClass().getSimpleName(), true);
                AccountPickerSignInHubPresenter.this.onSignInFailed(2015);
            }
        }

        @Override // p432kq.InterfaceC11137i
        public void onSuccess(String str) {
            C12836o.m77097b(AccountPickerSignInHubPresenter.TAG, "doSilentTokeRequest success: response is empty?" + TextUtils.isEmpty(str), true);
            C12836o.m77097b(AccountPickerSignInHubPresenter.TAG, "response : " + str, false);
            if (TextUtils.isEmpty(str)) {
                AccountPickerSignInHubPresenter.this.onSignInFailed(2015);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has(VastAttribute.ERROR)) {
                    AccountPickerSignInHubPresenter.this.dealSilentTokenErrorResponse(jSONObject.optInt(VastAttribute.ERROR));
                } else {
                    AccountPickerSignInHubPresenter.this.onSignInSuccess(str);
                }
            } catch (Exception e10) {
                C12836o.m77099d(AccountPickerSignInHubPresenter.TAG, "exception: " + e10.getClass().getSimpleName(), true);
                AccountPickerSignInHubPresenter.this.onSignInFailed(2015);
            }
        }
    }

    /* renamed from: com.huawei.hms.support.picker.activity.AccountPickerSignInHubPresenter$2 */
    public class C65032 implements AvailableAdapter.AvailableCallBack {
        public C65032() {
        }

        @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
        public void onComplete(int i10) throws JSONException {
            if (i10 == 0) {
                C12836o.m77097b(AccountPickerSignInHubPresenter.TAG, "version check ok", true);
                AccountPickerSignInHubPresenter.this.mView.startSignInActivity(AccountPickerSignInHubPresenter.this.getApkSignInIntent(), AccountPickerSignInHubActivity.IDENTIFIER);
            } else if (1 != i10) {
                C12836o.m77097b(AccountPickerSignInHubPresenter.TAG, "version check failed", true);
                AccountPickerSignInHubPresenter.this.onSignInFailed(i10);
            } else {
                C12836o.m77097b(AccountPickerSignInHubPresenter.TAG, "hms core is not install", true);
                C12832k.m77083b(AccountPickerSignInHubPresenter.this.mContext, AccountPickerSignInHubPresenter.this.mIsSignInByMCP);
                AccountPickerSignInHubPresenter.this.getSignInIntentByH5();
            }
        }
    }

    /* renamed from: com.huawei.hms.support.picker.activity.AccountPickerSignInHubPresenter$3 */
    public class C65043 implements InterfaceC11137i {
        public C65043() {
        }

        @Override // p432kq.InterfaceC11137i
        public void onFailure(int i10, String str) {
            C12836o.m77097b(AccountPickerSignInHubPresenter.TAG, "doTokenRequest onFailure: error code = " + i10, true);
            C12836o.m77097b(AccountPickerSignInHubPresenter.TAG, "doTokenRequest onFailure: error code = " + i10 + ",error msg =" + str, false);
            AccountPickerSignInHubPresenter.this.onSignInFailed(i10);
        }

        @Override // p432kq.InterfaceC11137i
        public void onSuccess(String str) throws JSONException {
            C12836o.m77097b(AccountPickerSignInHubPresenter.TAG, "doTokenRequest success: response is empty?" + TextUtils.isEmpty(str), true);
            C12836o.m77097b(AccountPickerSignInHubPresenter.TAG, "response : " + str, false);
            if (TextUtils.isEmpty(str)) {
                AccountPickerSignInHubPresenter.this.onSignInFailed(2015);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has(VastAttribute.ERROR)) {
                    int i10 = jSONObject.getInt(VastAttribute.ERROR);
                    C12836o.m77097b(AccountPickerSignInHubPresenter.TAG, "error = " + i10, true);
                    AccountPickerSignInHubPresenter.this.onSignInFailed(i10);
                } else {
                    AccountPickerSignInHubPresenter.this.onSignInSuccess(str);
                }
            } catch (JSONException unused) {
                C12836o.m77099d(AccountPickerSignInHubPresenter.TAG, "doTokenRequest JSONException", true);
                AccountPickerSignInHubPresenter.this.onSignInFailed(2015);
            }
        }
    }

    /* renamed from: com.huawei.hms.support.picker.activity.AccountPickerSignInHubPresenter$4 */
    public class C65054 implements InterfaceC10596j<C10588b> {
        public C65054() {
        }

        @Override // iq.InterfaceC10596j
        public void onResult(C10588b c10588b) {
            if (!c10588b.m64964a().m64997c()) {
                AccountPickerSignInHubPresenter.this.onSignInFailed(2015);
            } else {
                C12836o.m77097b(AccountPickerSignInHubPresenter.TAG, "signOut success", false);
                AccountPickerSignInHubPresenter.this.getSignInIntentByH5();
            }
        }
    }

    public AccountPickerSignInHubPresenter(Activity activity, AccountPickerSignInHubContract.View view) {
        this.mContext = activity;
        this.mView = view;
    }

    private boolean checkClientInfo() {
        if (TextUtils.isEmpty(this.mJsonCpClientInfo)) {
            onSignInFailed("Activity started with invalid cp client info");
            return false;
        }
        try {
            this.mClientInfo = C5037a.m30078a(this.mJsonCpClientInfo);
        } catch (JSONException unused) {
            this.mClientInfo = null;
            C12836o.m77099d(TAG, "checkClientInfo: JsonException", true);
        }
        if (this.mSignInRequest != null && this.mClientInfo != null) {
            return true;
        }
        onSignInFailed("Activity started with invalid sign in request info");
        return false;
    }

    private boolean checkIntentBomb(Intent intent) {
        if (intent == null) {
            return true;
        }
        try {
            intent.getStringExtra("ANYTHING");
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    private boolean checkParams(SafeIntent safeIntent) {
        String str;
        String action = safeIntent.getAction();
        this.mAction = action;
        if (TextUtils.equals(AuthInternalPickerConstant.IntentAction.ACTION_SIGN_IN_HUB, action)) {
            if (!checkClientInfo()) {
                return false;
            }
            AccountPickerParams accountPickerParams = this.mSignInRequest.getAccountPickerParams();
            if (checkRequestParameters(safeIntent, accountPickerParams)) {
                return initAccountPickerParam(accountPickerParams);
            }
            onSignInFailed("Paramers is invalid");
            return false;
        }
        if (this.mAction == null) {
            str = "unknow Action:";
        } else {
            str = "Action:" + this.mAction;
        }
        onSignInFailed(str);
        return false;
    }

    private boolean checkRequestParameters(SafeIntent safeIntent, AccountPickerParams accountPickerParams) throws JSONException {
        C12836o.m77097b(TAG, "checkRequestParameters start.", true);
        try {
            JSONObject jSONObject = new JSONObject(accountPickerParams.getSignInParams());
            this.mPickerType = jSONObject.optInt(AuthInternalPickerConstant.SignInReqKey.PICKER_TYPE);
            int i10 = jSONObject.getInt("idTokenSignAlg");
            this.mIdTokenSignAlg = i10;
            if (i10 != 1 && i10 != 2) {
                C12836o.m77099d(TAG, "idTokenSignAlg is invalid", true);
                return false;
            }
            this.mParentAccessToken = jSONObject.optString(CommonPickerConstant.RequestParams.KEY_HOST_ACCESS_TOKEN, this.mParentAccessToken);
            C12836o.m77097b(TAG, "hostAccessToken is " + this.mParentAccessToken, false);
            if (this.mIsSignInByMCP && (TextUtils.isEmpty(this.mParentAccessToken) || TextUtils.isEmpty(this.mClientInfo.getSubAppId()))) {
                C12836o.m77099d(TAG, "hostAccessToken is empty or subAppId is empty when sign by MCP", true);
                return false;
            }
            if (TextUtils.isEmpty(jSONObject.optString(CommonPickerConstant.RequestParams.KEY_GRS_APP_NAME))) {
                C12836o.m77099d(TAG, "grsAppName is empty", true);
                return false;
            }
            String stringExtra = safeIntent.getStringExtra(CommonPickerConstant.RequestParams.PETAL_MAIL_ADDR);
            int intExtra = safeIntent.getIntExtra(AuthInternalPickerConstant.SignInReqKey.PETAL_MAIL_FLAG, 0);
            int intExtra2 = safeIntent.getIntExtra(AuthInternalPickerConstant.SignInReqKey.UI_STYLE, 1);
            if (!TextUtils.isEmpty(stringExtra)) {
                jSONObject.put(CommonPickerConstant.RequestParams.PETAL_MAIL_ADDR, stringExtra);
            }
            jSONObject.put(AuthInternalPickerConstant.SignInReqKey.UI_STYLE, intExtra2);
            C12836o.m77097b(TAG, "request picker type is " + this.mPickerType + " and petalMailFlag is " + intExtra + " and uiStyle is " + intExtra2, true);
            String stringExtra2 = safeIntent.getStringExtra(AuthInternalPickerConstant.SignInReqKey.MAIL_SUPPORT_COUNTRY_LIST);
            if (intExtra == 1 && TextUtils.isEmpty(stringExtra2)) {
                return false;
            }
            C12836o.m77097b(TAG, "petalMail request Parameters is ok.", true);
            jSONObject.put(AuthInternalPickerConstant.SignInReqKey.PETAL_MAIL_FLAG, intExtra);
            jSONObject.put(AuthInternalPickerConstant.SignInReqKey.MAIL_SUPPORT_COUNTRY_LIST, stringExtra2);
            accountPickerParams.setSignInParams(jSONObject.toString());
            this.mJsonSignInRequest = this.mSignInRequest.toJson();
            return true;
        } catch (JSONException e10) {
            C12836o.m77099d(TAG, "JSONException:" + e10.getClass().getSimpleName(), true);
            return false;
        }
    }

    public void dealSilentTokenErrorResponse(int i10) {
        C12836o.m77097b(TAG, "dealSilentTokenErrorResponse:error = " + i10, true);
        if (1301 == i10) {
            C12836o.m77097b(TAG, "dealSilentTokenErrorResponse: H5 unauthorized", true);
            getSignInIntentByH5();
            return;
        }
        if (1203 != i10) {
            onSignInFailed(2008);
            return;
        }
        C12836o.m77097b(TAG, "dealSilentTokenErrorResponse: H5 token revoked" + i10, true);
        if (!this.mIsGuideLogin) {
            onSignInFailed(2008);
            return;
        }
        this.mParentAccessToken = "";
        try {
            C10591e.m64990h(this.mContext, new InterfaceC10596j<C10588b>() { // from class: com.huawei.hms.support.picker.activity.AccountPickerSignInHubPresenter.4
                public C65054() {
                }

                @Override // iq.InterfaceC10596j
                public void onResult(C10588b c10588b) {
                    if (!c10588b.m64964a().m64997c()) {
                        AccountPickerSignInHubPresenter.this.onSignInFailed(2015);
                    } else {
                        C12836o.m77097b(AccountPickerSignInHubPresenter.TAG, "signOut success", false);
                        AccountPickerSignInHubPresenter.this.getSignInIntentByH5();
                    }
                }
            });
        } catch (C10593g unused) {
            C12836o.m77099d(TAG, "ParmaInvalidException", true);
            onSignInFailed(2015);
        }
    }

    public Intent getApkSignInIntent() {
        C12836o.m77097b(TAG, "getApkSignInIntent", true);
        try {
            ForegroundIntentBuilder kitSdkVersion = new ForegroundIntentBuilder(this.mContext).setAction(this.mAction).setRequestBody(this.mJsonSignInRequest).setKitSdkVersion(AuthInternalPickerConstant.HMS_SDK_VERSION);
            C12836o.m77097b(TAG, "isNewService: " + this.mIsNewService, true);
            kitSdkVersion.setApiLevel(this.mIsNewService ? 11 : 9);
            String subAppId = this.mClientInfo.getSubAppId();
            if (!TextUtils.isEmpty(subAppId)) {
                this.mIsSignInByMCP = true;
                kitSdkVersion.setSubAppId(subAppId);
            }
            Intent intentBuild = kitSdkVersion.build();
            C12836o.m77097b(TAG, "get package name of hms is " + HMSPackageManager.getInstance(this.mContext).getHMSPackageName(), true);
            C12836o.m77097b(TAG, "current package is " + this.mContext.getPackageName(), true);
            intentBuild.setPackage(this.mContext.getPackageName());
            return intentBuild;
        } catch (Exception e10) {
            C12836o.m77099d(TAG, "getSignInIntent failed because:" + e10.getClass().getSimpleName(), true);
            return new Intent();
        }
    }

    public void getSignInIntentByH5() {
        C12836o.m77097b(TAG, "getSignInIntentByH5 start", true);
        if (!AccountPickerUtil.networkIsAvaiable(this.mContext)) {
            C12836o.m77097b(TAG, "Network  is Unavailable", true);
            onSignInFailed(2005);
            return;
        }
        try {
            C12836o.m77097b(TAG, "getSignInIntentByH5 input deviceInfo", true);
            Activity activity = this.mContext;
            String str = this.mGrsAppName;
            String[] strArr = this.mScopes;
            String str2 = this.mRedirectUrl;
            String str3 = this.mDeviceInfoStr;
            String str4 = this.mCodeVerifier;
            boolean z10 = this.mIsSignInByMCP;
            this.mView.startSignInActivity(AccountLiteSdkServiceImpl.signInH5(activity, str, strArr, str2, str3, str4, z10, this.mParentAccessToken, z10 ? this.mClientInfo.getSubAppId() : this.mClientInfo.getAppId(), this.mLoginUrl), AccountPickerSignInHubActivity.IDENTIFIER_H5);
        } catch (Exception e10) {
            C12836o.m77099d(TAG, "Exception = " + e10.getClass().getSimpleName(), true);
            if (e10 instanceof C10593g) {
                onSignInFailed(2003);
            } else {
                onSignInFailed(2015);
            }
        }
    }

    private boolean initAccountPickerParam(AccountPickerParams accountPickerParams) {
        this.mRedirectUrl = accountPickerParams.getRedirectUrl();
        String deviceInfo = accountPickerParams.getDeviceInfo();
        this.mDeviceInfoStr = deviceInfo;
        this.mDeviceInfo = DeviceInfo.m38003c(this.mContext, deviceInfo);
        if (TextUtils.isEmpty(this.mDeviceInfoStr) || this.mDeviceInfo == null) {
            onSignInFailed("device info is null");
            return false;
        }
        this.mScopes = accountPickerParams.getStringArray();
        this.mIsGuideLogin = accountPickerParams.isGuideLogin();
        this.mLoginUrl = accountPickerParams.getLoginUrl();
        this.mGrsAppName = accountPickerParams.getGrsAppName();
        if (accountPickerParams.getQRPromptSecondLevel().length() > 512) {
            onSignInFailed("qRPromptSecondLevel length is too long.");
            return false;
        }
        ArrayList<PermissionInfo> permissionArray = accountPickerParams.getPermissionArray();
        if (permissionArray != null) {
            Iterator<PermissionInfo> it = permissionArray.iterator();
            while (it.hasNext()) {
                PermissionInfo next = it.next();
                if ("https://www.huawei.com/auth/account/base.profile/accesstoken".equals(next.getPermission())) {
                    this.mHasAtPerMission = true;
                } else if ("idtoken".equals(next.getPermission())) {
                    this.mHasIDTokenPerMission = true;
                }
            }
        }
        return true;
    }

    private String resetJson(String str) {
        C12836o.m77097b(TAG, "resetJson before: json = " + str, false);
        String strReplace = str.replace("\"access_token\"", "\"accessToken\"").replace("\"open_id\"", "\"openId\"").replace("\"code\"", "\"serverAuthCode\"").replace("\"id_token\"", "\"idToken\"");
        C12836o.m77097b(TAG, "resetJson before: json =  " + strReplace, false);
        return strReplace;
    }

    @Override // com.huawei.hms.support.picker.activity.AccountPickerSignInHubContract.Presenter
    public void checkMinVersion() {
        C12836o.m77097b(TAG, "checkMinVersion start.", true);
        if (!this.mIsSignInByMCP) {
            HMSAPKVersionCheckUtil.checkAvailabilityAndConnect(this.mContext, this.mPickerType, new AvailableAdapter.AvailableCallBack() { // from class: com.huawei.hms.support.picker.activity.AccountPickerSignInHubPresenter.2
                public C65032() {
                }

                @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
                public void onComplete(int i10) throws JSONException {
                    if (i10 == 0) {
                        C12836o.m77097b(AccountPickerSignInHubPresenter.TAG, "version check ok", true);
                        AccountPickerSignInHubPresenter.this.mView.startSignInActivity(AccountPickerSignInHubPresenter.this.getApkSignInIntent(), AccountPickerSignInHubActivity.IDENTIFIER);
                    } else if (1 != i10) {
                        C12836o.m77097b(AccountPickerSignInHubPresenter.TAG, "version check failed", true);
                        AccountPickerSignInHubPresenter.this.onSignInFailed(i10);
                    } else {
                        C12836o.m77097b(AccountPickerSignInHubPresenter.TAG, "hms core is not install", true);
                        C12832k.m77083b(AccountPickerSignInHubPresenter.this.mContext, AccountPickerSignInHubPresenter.this.mIsSignInByMCP);
                        AccountPickerSignInHubPresenter.this.getSignInIntentByH5();
                    }
                }
            });
        } else {
            C12836o.m77097b(TAG, "sign by MCP", true);
            doSilentTokenRequest();
        }
    }

    @Override // com.huawei.hms.support.picker.activity.AccountPickerSignInHubContract.Presenter
    public void doSilentTokenRequest() {
        C11139k.m66996a().m66997b(this.mContext, this.mGrsAppName, new C11140l(this.mContext, new C11141m.a().m67039f(this.mClientInfo.getSubAppId()).m67040g("access_token").m67038e(this.mParentAccessToken).m67042i(this.mContext.getPackageName()).m67043j(this.mDeviceInfo.m38007e()).m67044k(this.mDeviceInfo.m38011m()).m67041h(C12824c.m77001d(this.mScopes)).m67035b(this.mDeviceInfo.m38015q()).m67036c(true).m67034a(1).m67045l(this.mIdTokenSignAlg == 1 ? "PS256" : CommonPickerConstant.IdTokenSupportAlg.RS_256).m67037d()), new InterfaceC11137i() { // from class: com.huawei.hms.support.picker.activity.AccountPickerSignInHubPresenter.1
            public C65021() {
            }

            @Override // p432kq.InterfaceC11137i
            public void onFailure(int i10, String str) {
                C12836o.m77097b(AccountPickerSignInHubPresenter.TAG, "doSilentTokeRequest onFailure: error code = " + i10 + ",error msg =" + str, false);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("doSilentTokeRequest onFailure: error code = ");
                sb2.append(i10);
                C12836o.m77097b(AccountPickerSignInHubPresenter.TAG, sb2.toString(), true);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has(VastAttribute.ERROR)) {
                        AccountPickerSignInHubPresenter.this.dealSilentTokenErrorResponse(jSONObject.optInt(VastAttribute.ERROR));
                    } else {
                        AccountPickerSignInHubPresenter.this.onSignInFailed(i10);
                    }
                } catch (JSONException e10) {
                    C12836o.m77099d(AccountPickerSignInHubPresenter.TAG, "exception: " + e10.getClass().getSimpleName(), true);
                    AccountPickerSignInHubPresenter.this.onSignInFailed(2015);
                }
            }

            @Override // p432kq.InterfaceC11137i
            public void onSuccess(String str) {
                C12836o.m77097b(AccountPickerSignInHubPresenter.TAG, "doSilentTokeRequest success: response is empty?" + TextUtils.isEmpty(str), true);
                C12836o.m77097b(AccountPickerSignInHubPresenter.TAG, "response : " + str, false);
                if (TextUtils.isEmpty(str)) {
                    AccountPickerSignInHubPresenter.this.onSignInFailed(2015);
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has(VastAttribute.ERROR)) {
                        AccountPickerSignInHubPresenter.this.dealSilentTokenErrorResponse(jSONObject.optInt(VastAttribute.ERROR));
                    } else {
                        AccountPickerSignInHubPresenter.this.onSignInSuccess(str);
                    }
                } catch (Exception e10) {
                    C12836o.m77099d(AccountPickerSignInHubPresenter.TAG, "exception: " + e10.getClass().getSimpleName(), true);
                    AccountPickerSignInHubPresenter.this.onSignInFailed(2015);
                }
            }
        });
    }

    @Override // com.huawei.hms.support.picker.activity.AccountPickerSignInHubContract.Presenter
    public void doTokenRequest(String str) {
        C12836o.m77097b(TAG, "doTokenRequest: enter", true);
        C11139k.m66996a().m66997b(this.mContext, this.mGrsAppName, new C11135g(this.mContext, new C11136h.a().m66992l(str).m66982b(this.mClientInfo.getSubAppId()).m66991k(this.mRedirectUrl).m66990j(this.mContext.getPackageName()).m66981a(1).m66988h(this.mDeviceInfo.m38007e()).m66989i(this.mDeviceInfo.m38011m()).m66987g(this.mDeviceInfo.m38015q()).m66983c(true).m66986f(true).m66985e(this.mCodeVerifier).m66993m(this.mIdTokenSignAlg == 1 ? "PS256" : CommonPickerConstant.IdTokenSupportAlg.RS_256).m66984d()), new InterfaceC11137i() { // from class: com.huawei.hms.support.picker.activity.AccountPickerSignInHubPresenter.3
            public C65043() {
            }

            @Override // p432kq.InterfaceC11137i
            public void onFailure(int i10, String str2) {
                C12836o.m77097b(AccountPickerSignInHubPresenter.TAG, "doTokenRequest onFailure: error code = " + i10, true);
                C12836o.m77097b(AccountPickerSignInHubPresenter.TAG, "doTokenRequest onFailure: error code = " + i10 + ",error msg =" + str2, false);
                AccountPickerSignInHubPresenter.this.onSignInFailed(i10);
            }

            @Override // p432kq.InterfaceC11137i
            public void onSuccess(String str2) throws JSONException {
                C12836o.m77097b(AccountPickerSignInHubPresenter.TAG, "doTokenRequest success: response is empty?" + TextUtils.isEmpty(str2), true);
                C12836o.m77097b(AccountPickerSignInHubPresenter.TAG, "response : " + str2, false);
                if (TextUtils.isEmpty(str2)) {
                    AccountPickerSignInHubPresenter.this.onSignInFailed(2015);
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    if (jSONObject.has(VastAttribute.ERROR)) {
                        int i10 = jSONObject.getInt(VastAttribute.ERROR);
                        C12836o.m77097b(AccountPickerSignInHubPresenter.TAG, "error = " + i10, true);
                        AccountPickerSignInHubPresenter.this.onSignInFailed(i10);
                    } else {
                        AccountPickerSignInHubPresenter.this.onSignInSuccess(str2);
                    }
                } catch (JSONException unused) {
                    C12836o.m77099d(AccountPickerSignInHubPresenter.TAG, "doTokenRequest JSONException", true);
                    AccountPickerSignInHubPresenter.this.onSignInFailed(2015);
                }
            }
        });
    }

    @Override // com.huawei.hms.support.picker.activity.AccountPickerSignInHubContract.Presenter
    public AccountPickerSignInRequest getSignInRequest() {
        return this.mSignInRequest;
    }

    @Override // com.huawei.hwidauth.p167ui.AbstractC6717b
    public void init(SafeIntent safeIntent) {
    }

    @Override // com.huawei.hms.support.picker.activity.AccountPickerSignInHubContract.Presenter
    public boolean initIntent(Intent intent) {
        if (intent == null || checkIntentBomb(intent)) {
            onSignInFailed("invalid intent");
            return false;
        }
        SafeIntent safeIntent = new SafeIntent(intent);
        this.mTransId = safeIntent.getStringExtra("transId");
        this.mJsonCpClientInfo = safeIntent.getStringExtra(AuthInternalPickerConstant.SignInReqKey.HUAWEIIDCPCLIENTINFO);
        this.mJsonSignInRequest = safeIntent.getStringExtra(AuthInternalPickerConstant.SignInReqKey.HUAWEIIDSIGNINREQUEST);
        this.mIsNewService = safeIntent.getBooleanExtra(AuthInternalPickerConstant.SignInReqKey.IS_NEW_SERVICE, false);
        this.mIsSignInByMCP = safeIntent.getBooleanExtra(AuthInternalPickerConstant.SignInReqKey.MCP_SIGN_IN, false);
        C12836o.m77097b(TAG, "onCreate: isSignInByMCP = " + this.mIsSignInByMCP, true);
        byte[] bArr = new byte[32];
        C12842u.m77122a().nextBytes(bArr);
        this.mCodeVerifier = C12826e.m77026a(bArr);
        C12836o.m77097b(TAG, "onCreate: mCodeVerifier = " + this.mCodeVerifier, false);
        this.mIsActivityFullScreen = safeIntent.getBooleanExtra("intent.extra.isfullscreen", false);
        C12836o.m77097b(TAG, "mIsActivityFullScreen = " + this.mIsActivityFullScreen, true);
        try {
            this.mSignInRequest = AccountPickerSignInRequest.fromJson(this.mJsonSignInRequest);
        } catch (JSONException unused) {
            this.mSignInRequest = null;
            C12836o.m77099d(TAG, "onCreate: JsonException", true);
        }
        return checkParams(safeIntent);
    }

    @Override // com.huawei.hms.support.picker.activity.AccountPickerSignInHubContract.Presenter
    public boolean isNeedRequestToken(String str) {
        return this.mIsSignInByMCP && (this.mHasIDTokenPerMission || this.mHasAtPerMission) && "1".equals(str);
    }

    @Override // com.huawei.hms.support.picker.activity.AccountPickerSignInHubContract.Presenter
    public void onSaveInstanceState(Bundle bundle) {
        String str = this.mTransId;
        if (str == null || bundle == null) {
            return;
        }
        bundle.putString(TAINSID_KEY, str);
    }

    @Override // com.huawei.hms.support.picker.activity.AccountPickerSignInHubContract.Presenter
    public void onSignInFailed(int i10) {
        C12836o.m77097b(TAG, "onSignInFailed, retCode：" + i10, true);
        report(i10);
        Status status = new Status(i10);
        AccountPickerResult accountPickerResult = new AccountPickerResult();
        accountPickerResult.setStatus(status);
        Intent intent = new Intent();
        try {
            intent.putExtra("HUAWEIID_SIGNIN_RESULT", accountPickerResult.toJson());
        } catch (JSONException unused) {
            C12836o.m77099d(TAG, "translate result to json exception", true);
        }
        this.mView.exit(0, intent);
    }

    @Override // com.huawei.hms.support.picker.activity.AccountPickerSignInHubContract.Presenter
    public void onSignInSuccess(String str) throws JSONException {
        C12836o.m77097b(TAG, "onSignInSuccess: enter", true);
        AuthAccountPicker authAccountPickerFromJson = AuthAccountPicker.fromJson(resetJson(str));
        authAccountPickerFromJson.setAccountAttr(Integer.parseInt("1"));
        if (!this.mHasAtPerMission) {
            authAccountPickerFromJson.setAccessToken(null);
        }
        if (!this.mHasIDTokenPerMission) {
            authAccountPickerFromJson.setIdToken(null);
        }
        AccountPickerResult accountPickerResult = new AccountPickerResult();
        accountPickerResult.setAuthAccountPicker(authAccountPickerFromJson);
        accountPickerResult.setStatus(new Status(0));
        Intent intent = new Intent();
        String json = accountPickerResult.toJson();
        C12836o.m77097b(TAG, "onSignInSuccess: json = " + json, false);
        intent.putExtra("HUAWEIID_SIGNIN_RESULT", json);
        report(0);
        HiAnalyticsClient.reportExit(this.mContext, PickerCommonNaming.signinIntent, this.mTransId, this.mClientInfo.getAppId(), PickerHiAnalyticsUtil.getHiAnalyticsStatus(0), 0, (int) this.mClientInfo.getHmsSdkVersion());
        this.mView.exit(-1, intent);
    }

    @Override // com.huawei.hms.support.picker.activity.AccountPickerSignInHubContract.Presenter
    public void report(int i10) {
        C5037a c5037a;
        if (this.mTransId == null || (c5037a = this.mClientInfo) == null) {
            return;
        }
        String str = this.mIsNewService ? PickerCommonNaming.signinAccountPickerType : PickerCommonNaming.signinIntent;
        long hmsSdkVersion = c5037a.getHmsSdkVersion();
        String appId = this.mClientInfo.getAppId();
        HiAnalyticsClient.reportExit(this.mContext, str, this.mTransId, appId, PickerHiAnalyticsUtil.getHiAnalyticsStatus(i10), i10, (int) hmsSdkVersion);
        C12836o.m77097b(TAG, "report: api = " + str + ",HmsSdkVersion = " + hmsSdkVersion + ",appId = " + appId, true);
    }

    @Override // com.huawei.hms.support.picker.activity.AccountPickerSignInHubContract.Presenter
    public void restoreInstanceState(Bundle bundle) {
        if (bundle != null) {
            this.mTransId = bundle.getString(TAINSID_KEY);
        }
    }

    @Override // com.huawei.hms.support.picker.activity.AccountPickerSignInHubContract.Presenter
    public void startWebViewActivity() {
        if (!this.mIsSignInByMCP && TextUtils.isEmpty(this.mClientInfo.getSubAppId())) {
            getSignInIntentByH5();
        } else if (!TextUtils.isEmpty(this.mParentAccessToken)) {
            doSilentTokenRequest();
        } else {
            C12836o.m77099d(TAG, "param is error, hostAccessToken cannot be empty", true);
            onSignInFailed(2003);
        }
    }

    private void onSignInFailed(String str) {
        C12836o.m77097b(TAG, "onSignInFailed: errMSG = " + str, true);
        onSignInFailed(2003);
    }
}
