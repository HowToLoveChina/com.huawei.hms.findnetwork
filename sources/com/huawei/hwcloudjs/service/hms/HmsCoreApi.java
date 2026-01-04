package com.huawei.hwcloudjs.service.hms;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.WebView;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.api.HuaweiApiClientImpl;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.hwid.SignInResult;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.huawei.hms.support.hwid.HuaweiIdAuthAPIManager;
import com.huawei.hms.support.hwid.HuaweiIdAuthManager;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParams;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import com.huawei.hms.support.hwid.service.HuaweiIdAuthService;
import com.huawei.hwcloudjs.annotation.JSMethod;
import com.huawei.hwcloudjs.api.JsParam;
import com.huawei.hwcloudjs.core.InterfaceC6625c;
import com.huawei.hwcloudjs.core.JSRequest;
import com.huawei.hwcloudjs.core.JsCallback;
import com.huawei.hwcloudjs.p164f.C6659d;
import com.huawei.hwcloudjs.p165g.C6664a;
import com.huawei.hwcloudjs.service.hms.C6668a;
import com.huawei.hwcloudjs.service.hms.C6679k;
import com.huawei.hwcloudjs.support.enables.NoProguard;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class HmsCoreApi extends JSRequest implements InterfaceC6625c {

    /* renamed from: b */
    private static final String f30915b = "HmsCoreApi";

    /* renamed from: c */
    private static final int f30916c = 9001;

    /* renamed from: d */
    private static final int f30917d = 9002;

    /* renamed from: e */
    private static final int f30918e = 9005;

    @NoProguard
    public static final class LoginReq extends JsParam {
        private boolean needAuthCode = false;
        private boolean needIdToken = false;
        private String scope;

        public String getScope() {
            return this.scope;
        }

        public boolean getneedAuthCode() {
            return this.needAuthCode;
        }

        public void setScope(String str) {
            this.scope = str;
        }

        public void setneedAuthCode(boolean z10) {
            this.needAuthCode = z10;
        }
    }

    /* renamed from: com.huawei.hwcloudjs.service.hms.HmsCoreApi$a */
    public static final class C6667a implements C6668a.c {

        /* renamed from: a */
        private JsCallback f30919a;

        /* renamed from: b */
        private boolean f30920b;

        public C6667a(JsCallback jsCallback, boolean z10) {
            this.f30919a = jsCallback;
            this.f30920b = z10;
        }

        @Override // com.huawei.hwcloudjs.service.hms.C6668a.c
        /* renamed from: a */
        public void mo37934a(C6668a.b bVar) throws JSONException {
            JsCallback jsCallback;
            String str;
            Intent intentM37949a = bVar.m37949a();
            if (intentM37949a != null) {
                SignInResult hwIdSignInResultFromIntent = HuaweiIdAuthAPIManager.HuaweiIdAuthAPIService.getHwIdSignInResultFromIntent(intentM37949a);
                if (hwIdSignInResultFromIntent != null) {
                    if (hwIdSignInResultFromIntent.isSuccess()) {
                        C6659d.m37882c(HmsCoreApi.f30915b, "signIn onResult isSuccess", true);
                        this.f30919a.success(C6679k.m37962a(hwIdSignInResultFromIntent, this.f30920b));
                        return;
                    }
                    C6659d.m37881b(HmsCoreApi.f30915b, "signIn onResult" + hwIdSignInResultFromIntent.getStatus().getStatusCode(), true);
                    this.f30919a.failure(hwIdSignInResultFromIntent.getStatus().getStatusCode());
                    return;
                }
                C6659d.m37881b(HmsCoreApi.f30915b, "signIn onResult signInResult is null", true);
                jsCallback = this.f30919a;
                str = "signInResult is null";
            } else if (bVar.m37954c() != -1) {
                C6659d.m37881b(HmsCoreApi.f30915b, "signIn onResult JS_RET_CODE_USER_DENAL", true);
                this.f30919a.failure(1);
                return;
            } else {
                C6659d.m37881b(HmsCoreApi.f30915b, "signIn onResult hms not ret data", true);
                jsCallback = this.f30919a;
                str = "hms not ret data";
            }
            jsCallback.failure(str);
        }
    }

    /* renamed from: a */
    private HuaweiApiClient m37919a(Context context, boolean z10, List<Scope> list) {
        HuaweiIdAuthParamsHelper huaweiIdAuthParamsHelper = new HuaweiIdAuthParamsHelper(HuaweiIdAuthParams.DEFAULT_AUTH_REQUEST_PARAM);
        if (z10) {
            huaweiIdAuthParamsHelper.setAuthorizationCode();
        } else {
            huaweiIdAuthParamsHelper.setAccessToken().setId();
        }
        HuaweiApiClient.Builder builder = new HuaweiApiClient.Builder(context.getApplicationContext());
        builder.addApi(HuaweiIdAuthAPIManager.HUAWEI_OAUTH_API, huaweiIdAuthParamsHelper.createParams());
        if (list != null) {
            Iterator<Scope> it = list.iterator();
            while (it.hasNext()) {
                builder.addScope(it.next());
            }
        }
        return builder.build();
    }

    @JSMethod(isOpen = true, name = "cancelAuthorization")
    public void cancelAuthorization(JsParam jsParam, JsCallback jsCallback) throws JSONException {
        C6659d.m37882c(f30915b, "cancelAuthorization begin", true);
        String appId = jsParam.getAppId();
        String bridgeId = jsParam.getBridgeId();
        HuaweiIdAuthService huaweiIdAuthServiceM37973a = C6686r.m37972a().m37973a(bridgeId, appId);
        HuaweiApiClient huaweiApiClientM37977b = C6686r.m37972a().m37977b(bridgeId, appId);
        if (huaweiIdAuthServiceM37973a == null && huaweiApiClientM37977b == null) {
            C6659d.m37881b(f30915b, "cancelAuthorization failed, HuaweiIdAuthService is null", true);
            jsCallback.failure("cancelAuthorization failed, please invoke signIn/getSignInIntent/silentSignIn first");
        } else if (huaweiIdAuthServiceM37973a != null) {
            C6659d.m37882c(f30915b, "cancelAuthorization service is not null", true);
            huaweiIdAuthServiceM37973a.cancelAuthorization().addOnCompleteListener(new C6672d(this, jsCallback));
        } else {
            C6659d.m37882c(f30915b, "cancelAuthorization service is null", true);
            HuaweiIdAuthAPIManager.HuaweiIdAuthAPIService.cancelAuthorization(huaweiApiClientM37977b).setResultCallback(new C6673e(this, jsCallback));
        }
    }

    @Override // com.huawei.hwcloudjs.core.InterfaceC6625c
    public String getApi() {
        return C6664a.f30905c;
    }

    @JSMethod(isOpen = true, name = "getSignInIntent")
    public void getSignInIntent(LoginReq loginReq, JsCallback jsCallback) throws JSONException {
        C6659d.m37882c(f30915b, "getSignInIntent begin", true);
        WebView webView = jsCallback.getWebView();
        Activity activity = (Activity) webView.getContext();
        if (!m37933a(loginReq, jsCallback, webView)) {
            C6659d.m37881b(f30915b, "getSignInIntent checkparam false", true);
            return;
        }
        try {
            C6668a.m37944a().m37946a(activity, m37920a(loginReq, activity).getSignInIntent(), 9005, new C6669b(this, loginReq, jsCallback));
        } catch (ApiException unused) {
            C6659d.m37881b(f30915b, "appid is not correct", true);
            jsCallback.failure("appid is not correct");
        }
    }

    @Override // com.huawei.hwcloudjs.core.InterfaceC6625c
    public void onCompletedConfig(Context context, String str, String str2, String str3, JSONObject jSONObject) {
        String strOptString;
        boolean zOptBoolean = false;
        if (jSONObject != null) {
            strOptString = jSONObject.optString("scope", null);
            zOptBoolean = jSONObject.optBoolean("needAuthCode", false);
        } else {
            strOptString = null;
        }
        List<Scope> listM37921a = m37921a(strOptString);
        if (listM37921a.isEmpty()) {
            return;
        }
        HuaweiApiClient huaweiApiClientM37919a = m37919a(context, zOptBoolean, listM37921a);
        huaweiApiClientM37919a.setSubAppInfo(new SubAppInfo(str));
        if (context instanceof Activity) {
            huaweiApiClientM37919a.connect((Activity) context);
        } else {
            huaweiApiClientM37919a.connect((Activity) null);
        }
        C6686r.m37972a().m37975a(str3, str, huaweiApiClientM37919a);
    }

    @Override // com.huawei.hwcloudjs.core.InterfaceC6625c
    public void onDestroy(String str) {
        C6686r.m37972a().m37978b(str);
        C6686r.m37972a().m37974a(str);
    }

    @JSMethod(isOpen = true, name = "signIn")
    public void signIn(LoginReq loginReq, JsCallback jsCallback) throws JSONException {
        WebView webView = jsCallback.getWebView();
        boolean z10 = true;
        if (!m37933a(loginReq, jsCallback, webView)) {
            C6659d.m37881b(f30915b, "signIn checkparam false", true);
            return;
        }
        if (!(webView.getContext() instanceof Activity)) {
            C6659d.m37881b(f30915b, "webView is error", true);
            jsCallback.failure("webView is error");
            return;
        }
        String appId = loginReq.getAppId();
        String bridgeId = loginReq.getBridgeId();
        List<Scope> listM37921a = m37921a(loginReq.scope);
        boolean zIsEmpty = listM37921a.isEmpty();
        boolean z11 = loginReq.needAuthCode;
        try {
            m37920a(loginReq, (Activity) webView.getContext());
            HuaweiApiClient huaweiApiClientM37977b = C6686r.m37972a().m37977b(bridgeId, appId);
            boolean z12 = false;
            if (huaweiApiClientM37977b == null || !(huaweiApiClientM37977b instanceof HuaweiApiClientImpl)) {
                z10 = false;
            } else {
                HuaweiApiClientImpl huaweiApiClientImpl = (HuaweiApiClientImpl) huaweiApiClientM37977b;
                boolean zM37965a = C6679k.m37965a(listM37921a, huaweiApiClientImpl.getScopes());
                List<PermissionInfo> permissionInfos = huaweiApiClientImpl.getPermissionInfos();
                if (permissionInfos != null) {
                    for (PermissionInfo permissionInfo : permissionInfos) {
                        if (permissionInfo != null && "https://www.huawei.com/auth/account/base.profile/serviceauthcode".equals(permissionInfo.getPermission())) {
                            break;
                        }
                    }
                    z10 = false;
                    z12 = zM37965a;
                } else {
                    z10 = false;
                    z12 = zM37965a;
                }
            }
            if (huaweiApiClientM37977b == null || !z12 || z10 != z11) {
                if (huaweiApiClientM37977b != null) {
                    huaweiApiClientM37977b.disconnect();
                }
                huaweiApiClientM37977b = m37919a(webView.getContext().getApplicationContext(), z11, listM37921a);
                huaweiApiClientM37977b.setSubAppInfo(new SubAppInfo(appId));
                C6686r.m37972a().m37975a(bridgeId, appId, huaweiApiClientM37977b);
            }
            Activity activity = (Activity) webView.getContext();
            WeakReference<HuaweiApiClient> weakReference = new WeakReference<>(huaweiApiClientM37977b);
            WeakReference<Activity> weakReference2 = new WeakReference<>(activity);
            if (huaweiApiClientM37977b.isConnected()) {
                m37932a(weakReference, jsCallback, weakReference2, z11, zIsEmpty);
                return;
            }
            huaweiApiClientM37977b.setConnectionCallbacks(new C6676h(this, weakReference, jsCallback, weakReference2, z11, zIsEmpty));
            huaweiApiClientM37977b.setConnectionFailedListener(new C6679k.b(weakReference, jsCallback, weakReference2));
            huaweiApiClientM37977b.connect(activity);
        } catch (ApiException unused) {
            C6659d.m37881b(f30915b, "appid is not correct", true);
            jsCallback.failure("appid is not correct");
        }
    }

    @JSMethod(isOpen = true, name = "signOut")
    public void signOut(JsParam jsParam, JsCallback jsCallback) throws JSONException {
        C6659d.m37882c(f30915b, "signOut begin", true);
        String appId = jsParam.getAppId();
        String bridgeId = jsParam.getBridgeId();
        HuaweiIdAuthService huaweiIdAuthServiceM37973a = C6686r.m37972a().m37973a(bridgeId, appId);
        HuaweiApiClient huaweiApiClientM37977b = C6686r.m37972a().m37977b(bridgeId, appId);
        if (huaweiIdAuthServiceM37973a == null && huaweiApiClientM37977b == null) {
            C6659d.m37881b(f30915b, "signOut failed, HuaweiIdAuthService is null", true);
            jsCallback.failure("signOut failed, please invoke signIn/getSignInIntent/silentSignIn first");
        } else if (huaweiIdAuthServiceM37973a != null) {
            C6659d.m37882c(f30915b, "signOut service is not null", true);
            huaweiIdAuthServiceM37973a.signOut().addOnCompleteListener(new C6674f(this, jsCallback));
        } else {
            C6659d.m37882c(f30915b, "signOut service is null", true);
            HuaweiIdAuthAPIManager.HuaweiIdAuthAPIService.signOut(huaweiApiClientM37977b).setResultCallback(new C6675g(this, jsCallback));
        }
    }

    @JSMethod(isOpen = true, name = "silentSignIn")
    public void silentSignIn(LoginReq loginReq, JsCallback jsCallback) throws JSONException {
        C6659d.m37882c(f30915b, "silentSignIn begin", true);
        WebView webView = jsCallback.getWebView();
        if (!m37933a(loginReq, jsCallback, webView)) {
            C6659d.m37881b(f30915b, "silentSignIn checkparam false", true);
            return;
        }
        if (!(webView.getContext() instanceof Activity)) {
            C6659d.m37881b(f30915b, "webView is error", true);
            return;
        }
        try {
            Task<AuthHuaweiId> taskSilentSignIn = m37920a(loginReq, (Activity) webView.getContext()).silentSignIn();
            if (taskSilentSignIn == null) {
                C6659d.m37881b(f30915b, "silentSignIn failed, task is null", true);
                jsCallback.failure("silentSignIn failed, task is null");
                return;
            }
            C6659d.m37882c(f30915b, "silentSignIn task is not null", true);
            if (taskSilentSignIn.isSuccessful()) {
                m37925a(taskSilentSignIn.getResult(), loginReq.needAuthCode, jsCallback);
            } else {
                taskSilentSignIn.addOnCompleteListener(new C6671c(this, loginReq, jsCallback));
            }
        } catch (ApiException unused) {
            C6659d.m37881b(f30915b, "silentSignIn appid is not correct", true);
            jsCallback.failure("appid is not correct");
        }
    }

    /* renamed from: a */
    private HuaweiIdAuthService m37920a(LoginReq loginReq, Activity activity) throws ApiException {
        String appId = loginReq.getAppId();
        String bridgeId = loginReq.getBridgeId();
        List<Scope> listM37921a = m37921a(loginReq.scope);
        C6659d.m37882c(f30915b, "getAuthService appId:" + appId, false);
        C6659d.m37882c(f30915b, "getAuthService bridgeId:" + bridgeId, false);
        C6659d.m37882c(f30915b, "getAuthService scopeList:" + listM37921a, false);
        HuaweiIdAuthParamsHelper scopeList = new HuaweiIdAuthParamsHelper(HuaweiIdAuthParams.DEFAULT_AUTH_REQUEST_PARAM).setScopeList(listM37921a);
        if (loginReq.needAuthCode) {
            scopeList.setAuthorizationCode();
        } else {
            scopeList.setAccessToken().setId();
        }
        if (loginReq.needIdToken) {
            scopeList.setIdToken();
        }
        HuaweiIdAuthService service = HuaweiIdAuthManager.getService(activity, scopeList.createParams());
        service.setSubAppId(appId);
        C6686r.m37972a().m37976a(bridgeId, appId, service);
        return service;
    }

    /* renamed from: a */
    private static List<Scope> m37921a(String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            C6659d.m37882c(f30915b, "parserScope scopeEmpty", true);
        } else {
            for (String str2 : str.split("\\,")) {
                if (!TextUtils.isEmpty(str2)) {
                    arrayList.add(new Scope(str2));
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m37922a(ApiException apiException, JsCallback jsCallback) throws JSONException {
        C6659d.m37881b(f30915b, "silentSignIn failed, statusCode:" + apiException.getStatusCode() + " msg:" + apiException.getStatusMessage(), true);
        String statusMessage = apiException.getStatusMessage();
        if (apiException.getStatusCode() == 2002) {
            statusMessage = "silentSignIn failed, please invoke signIn/getSignInIntent first";
        }
        jsCallback.failure(apiException.getStatusCode(), statusMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m37923a(SignInResult signInResult, boolean z10, WeakReference<Activity> weakReference, WeakReference<HuaweiApiClient> weakReference2, boolean z11, JsCallback jsCallback) throws JSONException {
        if (signInResult != null) {
            C6659d.m37882c(f30915b, "signIn result is not null", true);
            if (signInResult.isSuccess()) {
                C6659d.m37882c(f30915b, "signIn result isSuccess", true);
                jsCallback.success(C6679k.m37962a(signInResult, z10));
                return;
            }
            int statusCode = signInResult.getStatus().getStatusCode();
            C6659d.m37882c(f30915b, "signIn result statusCode:" + statusCode, true);
            if (statusCode == 2001 || statusCode == 2004) {
                Activity activity = weakReference.get();
                if (activity != null) {
                    m37924a(signInResult, z10, weakReference, weakReference2, z11, jsCallback, activity);
                    return;
                }
                C6659d.m37881b(f30915b, "signIn webViewActivity == null", true);
            } else {
                if (statusCode != 2002) {
                    jsCallback.failure(signInResult.getStatus().getStatusCode());
                    return;
                }
                C6659d.m37882c(f30915b, "signIn SIGN_IN_AUTH", true);
                Activity activity2 = weakReference.get();
                if (activity2 != null) {
                    C6668a.m37944a().m37946a(activity2, signInResult.getData(), 9002, new C6667a(jsCallback, z10));
                    return;
                }
                C6659d.m37882c(f30915b, "webViewActivity is null", true);
            }
            jsCallback.failure();
            return;
        }
        C6659d.m37881b(f30915b, "signIn failed, result is null", true);
        jsCallback.failure("signIn failed, result is null");
    }

    /* renamed from: a */
    private void m37924a(SignInResult signInResult, boolean z10, WeakReference<Activity> weakReference, WeakReference<HuaweiApiClient> weakReference2, boolean z11, JsCallback jsCallback, Activity activity) {
        C6668a.m37944a().m37946a(activity, signInResult.getData(), 9001, new C6678j(this, weakReference2, jsCallback, weakReference, z10, z11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m37925a(AuthHuaweiId authHuaweiId, boolean z10, JsCallback jsCallback) throws JSONException {
        String familyName;
        String str;
        try {
            JSONObject jSONObject = new JSONObject();
            if (z10) {
                familyName = authHuaweiId.getAuthorizationCode();
                str = "serverAuthCode";
            } else {
                jSONObject.put("openId", authHuaweiId.getOpenId());
                jSONObject.put("accessToken", authHuaweiId.getAccessToken());
                jSONObject.put(CommonConstant.KEY_DISPLAY_NAME, authHuaweiId.getDisplayName());
                jSONObject.put("photoUrl", authHuaweiId.getAvatarUriString());
                jSONObject.put(CommonConstant.KEY_ID_TOKEN, authHuaweiId.getIdToken());
                jSONObject.put(CommonConstant.KEY_UNION_ID, authHuaweiId.getUnionId());
                jSONObject.put("email", authHuaweiId.getEmail());
                jSONObject.put(CommonConstant.KEY_GIVEN_NAME, authHuaweiId.getGivenName());
                familyName = authHuaweiId.getFamilyName();
                str = CommonConstant.KEY_FAMILY_NAME;
            }
            jSONObject.put(str, familyName);
            jsCallback.success(jSONObject.toString());
        } catch (JSONException unused) {
            C6659d.m37881b(f30915b, "handleAuthHuaweiId JSONException", true);
            jsCallback.failure();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m37931a(C6668a.b bVar, WeakReference<HuaweiApiClient> weakReference, JsCallback jsCallback, WeakReference<Activity> weakReference2, boolean z10, boolean z11) throws JSONException {
        if (bVar.m37954c() == -1) {
            C6659d.m37882c(f30915b, "signIn Activity.RESULT_OK", true);
            m37932a(weakReference, jsCallback, weakReference2, z10, z11);
        } else {
            C6659d.m37881b(f30915b, "signIn JS_RET_CODE_USER_DENAL", true);
            jsCallback.failure(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m37932a(WeakReference<HuaweiApiClient> weakReference, JsCallback jsCallback, WeakReference<Activity> weakReference2, boolean z10, boolean z11) {
        PendingResult<SignInResult> pendingResultSignIn;
        C6659d.m37882c(f30915b, "signIn begin", true);
        HuaweiApiClient huaweiApiClient = weakReference.get();
        if (huaweiApiClient == null) {
            C6659d.m37881b(f30915b, "client is null", true);
            jsCallback.failure();
            return;
        }
        if (z11) {
            pendingResultSignIn = HuaweiIdAuthAPIManager.HuaweiIdAuthAPIService.signInBackend(huaweiApiClient);
        } else {
            Activity activity = weakReference2.get();
            if (activity == null) {
                C6659d.m37881b(f30915b, "signIn with null activity", true);
                jsCallback.failure();
                return;
            }
            pendingResultSignIn = HuaweiIdAuthAPIManager.HuaweiIdAuthAPIService.signIn(activity, huaweiApiClient);
        }
        pendingResultSignIn.setResultCallback(new C6677i(this, z10, weakReference2, weakReference, z11, jsCallback));
    }

    /* renamed from: a */
    private boolean m37933a(LoginReq loginReq, JsCallback jsCallback, WebView webView) throws JSONException {
        if (webView == null) {
            C6659d.m37881b(f30915b, "signIn webview is null", true);
            jsCallback.failure("webview is null");
            return false;
        }
        if (loginReq == null) {
            C6659d.m37881b(f30915b, "signIn JS_RET_CODE_PARSE_PARAM_ERROR", true);
            jsCallback.failure(13);
            return false;
        }
        if (loginReq.getAppId() != null && !loginReq.getAppId().isEmpty()) {
            return true;
        }
        C6659d.m37881b(f30915b, "appid is not config", true);
        jsCallback.failure("appid is not config");
        return false;
    }
}
