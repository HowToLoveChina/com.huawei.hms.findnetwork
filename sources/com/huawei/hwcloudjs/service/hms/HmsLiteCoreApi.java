package com.huawei.hwcloudjs.service.hms;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.webkit.WebView;
import com.huawei.hwcloudjs.JsClientApi;
import com.huawei.hwcloudjs.annotation.JSMethod;
import com.huawei.hwcloudjs.api.IAccessToken;
import com.huawei.hwcloudjs.api.JsParam;
import com.huawei.hwcloudjs.core.JSRequest;
import com.huawei.hwcloudjs.core.JsCallback;
import com.huawei.hwcloudjs.p164f.C6659d;
import com.huawei.hwcloudjs.service.hms.bean.C6670a;
import com.huawei.hwcloudjs.support.enables.NoProguard;
import iq.C10589c;
import iq.C10591e;
import iq.C10593g;
import iq.C10598l;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class HmsLiteCoreApi extends JSRequest {

    /* renamed from: b */
    private static final String f30921b = "HmsLiteCoreApi";

    /* renamed from: c */
    private static final long f30922c = 5000;

    /* renamed from: d */
    private static final int f30923d = 4;
    public static String mGrsAppName = "";

    /* renamed from: e */
    private IAccessToken f30924e;

    /* renamed from: f */
    private volatile boolean f30925f = false;

    /* renamed from: g */
    private Handler f30926g = new Handler(new C6682n(this));

    @NoProguard
    public static final class LoginLiteReq extends JsParam {
        private String IMEI;

        /* renamed from: SN */
        private String f30927SN;
        private String UDID;
        private String UUID;
        private String redirectUrl;
        private String scope;
        private boolean needAuthCode = false;
        private boolean guideLogin = true;

        public boolean getGuideLogin() {
            return this.guideLogin;
        }

        public String getIMEI() {
            return this.IMEI;
        }

        public boolean getNeedAuthCode() {
            return this.needAuthCode;
        }

        public String getRedirectUrl() {
            return this.redirectUrl;
        }

        public String getSN() {
            return this.f30927SN;
        }

        public String getScope() {
            return this.scope;
        }

        public String getUDID() {
            return this.UDID;
        }

        public String getUUID() {
            return this.UUID;
        }

        public void setGuideLogin(boolean z10) {
            this.guideLogin = z10;
        }

        public void setIMEI(String str) {
            this.IMEI = str;
        }

        public void setNeedAuthCode(boolean z10) {
            this.needAuthCode = z10;
        }

        public void setRedirectUrl(String str) {
            this.redirectUrl = str;
        }

        public void setSN(String str) {
            this.f30927SN = str;
        }

        public void setScope(String str) {
            this.scope = str;
        }

        public void setUDID(String str) {
            this.UDID = str;
        }

        public void setUUID(String str) {
            this.UUID = str;
        }
    }

    @NoProguard
    public static final class RevokeLiteReq extends JsParam {
        private String accessToken;

        public String getAccessToken() {
            return this.accessToken;
        }

        public void setAccessToken(String str) {
            this.accessToken = str;
        }
    }

    /* renamed from: a */
    private String m37935a(LoginLiteReq loginLiteReq) {
        String sn2 = loginLiteReq.getSN();
        return C10589c.m64966a(loginLiteReq.getIMEI(), loginLiteReq.getUUID(), sn2, loginLiteReq.getUDID());
    }

    @JSMethod(isOpen = true, name = "cancelAuthorization")
    public void cancelAuthorization(RevokeLiteReq revokeLiteReq, JsCallback jsCallback) throws JSONException {
        C6659d.m37882c(f30921b, "cancelAuthorization begin", true);
        if (jsCallback == null) {
            C6659d.m37881b(f30921b, "cancelAuthorization JsCallback is null", true);
            return;
        }
        WebView webView = jsCallback.getWebView();
        if (webView == null) {
            C6659d.m37881b(f30921b, "cancelAuthorization webview is null", true);
            jsCallback.failure("webview is null");
            return;
        }
        if (revokeLiteReq == null) {
            C6659d.m37881b(f30921b, "cancelAuthorization JS_RET_CODE_PARSE_PARAM_ERROR", true);
            jsCallback.failure(13);
            return;
        }
        String appId = revokeLiteReq.getAppId();
        String accessToken = revokeLiteReq.getAccessToken();
        if (appId == null || accessToken == null) {
            C6659d.m37881b(f30921b, "cancelAuthorization appid is null", true);
            jsCallback.failure("ParamInvalidException error!");
        } else {
            if (!(webView.getContext() instanceof Activity)) {
                C6659d.m37881b(f30921b, "webView is error", true);
                jsCallback.failure("webview is error");
                return;
            }
            try {
                C10591e.m64988f((Activity) webView.getContext(), mGrsAppName, accessToken, new C6685q(this, jsCallback));
            } catch (C10593g unused) {
                C6659d.m37881b(f30921b, "cancelAuthorization exception", true);
                jsCallback.failure("cancelAuthorization parameter invalid");
            }
        }
    }

    @JSMethod(isOpen = true, name = "signIn")
    public void signIn(LoginLiteReq loginLiteReq, JsCallback jsCallback) throws JSONException {
        C6659d.m37882c(f30921b, "signIn begin", true);
        if (jsCallback == null) {
            C6659d.m37881b(f30921b, "signIn JsCallback is null", true);
            return;
        }
        WebView webView = jsCallback.getWebView();
        if (webView == null || !(webView.getContext() instanceof Activity)) {
            C6659d.m37881b(f30921b, "signIn webview is null", true);
            jsCallback.failure("webview is null");
            return;
        }
        if (loginLiteReq == null) {
            C6659d.m37881b(f30921b, "signIn JS_RET_CODE_PARSE_PARAM_ERROR", true);
            jsCallback.failure(13);
            return;
        }
        String appId = loginLiteReq.getAppId();
        String scope = loginLiteReq.getScope();
        String strM37935a = m37935a(loginLiteReq);
        String redirectUrl = loginLiteReq.getRedirectUrl();
        String[] strArrSplit = scope.split("\\,");
        boolean guideLogin = loginLiteReq.getGuideLogin();
        Activity activity = (Activity) webView.getContext();
        C6659d.m37882c(f30921b, "req:" + loginLiteReq.toString(), false);
        C6659d.m37882c(f30921b, "deviceInfo:" + strM37935a, false);
        if (appId == null || redirectUrl == null || activity == null) {
            C6659d.m37881b(f30921b, "signIn appId or redirectUrl or mActivity is null", true);
            jsCallback.failure("ParamInvalidException error!");
            return;
        }
        IAccessToken iAccessTokenClass = JsClientApi.getIAccessTokenClass();
        this.f30924e = iAccessTokenClass;
        if (iAccessTokenClass == null) {
            C6659d.m37882c(f30921b, "not initAccessTokenClass!", true);
            m37936a(activity, appId, strArrSplit, redirectUrl, strM37935a, null, guideLogin, jsCallback);
            return;
        }
        Message message = new Message();
        message.obj = new C6670a(loginLiteReq, jsCallback);
        message.what = 4;
        this.f30926g.sendMessageDelayed(message, 5000L);
        this.f30925f = false;
        this.f30924e.getAccessToken(new C6681m(this, activity, appId, strArrSplit, redirectUrl, strM37935a, guideLogin, jsCallback));
    }

    @JSMethod(isOpen = true, name = "signOut")
    public void signOut(JsParam jsParam, JsCallback jsCallback) throws JSONException {
        String str;
        C6659d.m37882c(f30921b, "signOut begin", true);
        if (jsParam.getAppId() == null) {
            C6659d.m37881b(f30921b, "signOut appid is null", true);
            str = "ParamInvalidException error!";
        } else {
            WebView webView = jsCallback.getWebView();
            if (webView != null) {
                try {
                    C10591e.m64990h((Activity) webView.getContext(), new C6684p(this, jsCallback));
                    return;
                } catch (C10593g unused) {
                    C6659d.m37881b(f30921b, "signOut failed", true);
                    jsCallback.failure("JS signOut parameter invalid");
                    return;
                }
            }
            C6659d.m37881b(f30921b, "signOut webview is null", true);
            str = "webview is null";
        }
        jsCallback.failure(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m37936a(Activity activity, String str, String[] strArr, String str2, String str3, String str4, boolean z10, JsCallback jsCallback) throws JSONException {
        C6659d.m37882c(f30921b, "signInOauth begin", true);
        this.f30925f = true;
        try {
            C10591e.m64989g(activity, mGrsAppName, str, strArr, str2, str3, str4, z10, new C6683o(this, jsCallback));
        } catch (C10593g unused) {
            C6659d.m37881b(f30921b, "signOAuth ParamInvalidException!", true);
            jsCallback.failure("ParamInvalidException");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m37940a(C6670a c6670a) throws JSONException {
        C6659d.m37882c(f30921b, "get Token timeout handlerResult", true);
        JsCallback jsCallbackM37955a = c6670a.m37955a();
        LoginLiteReq loginLiteReqM37958b = c6670a.m37958b();
        m37936a((Activity) jsCallbackM37955a.getWebView().getContext(), loginLiteReqM37958b.getAppId(), c6670a.m37958b().getScope().split("\\,"), loginLiteReqM37958b.getRedirectUrl(), m37935a(loginLiteReqM37958b), null, loginLiteReqM37958b.getGuideLogin(), jsCallbackM37955a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m37941a(C10598l c10598l, JsCallback jsCallback) throws JSONException {
        String str;
        C6659d.m37882c(f30921b, "signInOauth onSignInResult begin", true);
        if (c10598l == null || c10598l.m64993b() == null) {
            jsCallback.failure("signIn result is null");
            str = "signInResult is null or signInResult.getStatus() is null";
        } else if (c10598l.m64994c()) {
            C6659d.m37882c(f30921b, "onSignOAuthResult Success", true);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("AuthorizationCode", c10598l.m64992a());
                jSONObject.put("StatusCode", c10598l.m64993b().m64995a());
                jSONObject.put("StatusMessage", c10598l.m64993b().m64996b());
                jsCallback.success(jSONObject.toString());
                return;
            } catch (JSONException unused) {
                jsCallback.failure();
                str = "onSignOAuthResult JSONException!";
            }
        } else {
            jsCallback.failure(c10598l.m64993b().m64995a(), c10598l.m64993b().m64996b());
            str = "StatusCode:" + c10598l.m64993b().m64995a() + " StatusMessage:" + c10598l.m64993b().m64996b();
        }
        C6659d.m37881b(f30921b, str, true);
    }
}
