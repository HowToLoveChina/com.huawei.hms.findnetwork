package com.huawei.hms.hwid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.huawei.hms.account.internal.p115ui.activity.AccountSignInHubActivity;
import com.huawei.hms.common.internal.constant.AuthInternalPickerConstant;
import com.huawei.hms.support.account.request.AccountAuthParams;
import com.huawei.hms.support.account.request.AccountAuthParamsHelper;
import com.huawei.hms.support.account.result.AccountAuthResult;
import com.huawei.hms.support.account.result.AuthAccount;
import com.huawei.hms.support.api.entity.account.AccountSignInRequest;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.utils.Util;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hwid.f */
/* loaded from: classes8.dex */
public final class C5607f {
    /* renamed from: a */
    public static Intent m32917a(Context context, AccountAuthParams accountAuthParams, String str) {
        C5602as.m32910b("[AccountSDK]AccountAuthUtil", "getSignInIntent", true);
        return m32918a(context, accountAuthParams, str, 0, "");
    }

    /* renamed from: b */
    public static AuthAccount m32925b() {
        return C5608g.m32926a().m32929b();
    }

    /* renamed from: a */
    public static Intent m32919a(Context context, AccountAuthParams accountAuthParams, String str, String str2) {
        C5602as.m32910b("[AccountSDK]AccountAuthUtil", "getIndependentSignInIntent", true);
        return m32918a(context, accountAuthParams, str, 1, str2);
    }

    /* renamed from: a */
    private static Intent m32918a(Context context, AccountAuthParams accountAuthParams, String str, int i10, String str2) throws JSONException {
        String str3;
        JSONObject jSONObject;
        if (i10 == 1) {
            str3 = AuthInternalPickerConstant.IntentAction.ACTION_SIGN_IN_HUB;
        } else {
            str3 = "com.huawei.hms.account.signIn";
        }
        Intent intent = new Intent(str3);
        try {
            intent.setPackage(context.getPackageName());
            intent.setClass(context, AccountSignInHubActivity.class);
            if (i10 == 1) {
                intent.putExtra("ACCESS_TOKEN", str2);
                intent.putExtra("INDEPENDENT_SIGN_IN_FLAG", i10);
                try {
                    String signInParams = accountAuthParams.getSignInParams();
                    if (TextUtils.isEmpty(signInParams)) {
                        jSONObject = new JSONObject();
                    } else {
                        jSONObject = new JSONObject(signInParams);
                    }
                    jSONObject.put("ACCESS_TOKEN", str2);
                    jSONObject.put("INDEPENDENT_SIGN_IN_FLAG", i10);
                    accountAuthParams.setSignInParams(jSONObject.toString());
                } catch (JSONException e10) {
                    C5602as.m32912d("[AccountSDK]AccountAuthUtil", "JSONException:" + e10.getClass().getSimpleName(), true);
                }
            }
            String appId = Util.getAppId(context);
            String packageName = context.getPackageName();
            C5603b c5603b = new C5603b();
            c5603b.m32883b(appId);
            c5603b.m32885c(packageName);
            c5603b.m32881a(61200300L);
            c5603b.m32887d(str);
            AccountSignInRequest accountSignInRequest = new AccountSignInRequest();
            accountSignInRequest.setAccountAuthParams(accountAuthParams);
            try {
                intent.putExtra(AuthInternalPickerConstant.SignInReqKey.HUAWEIIDCPCLIENTINFO, c5603b.m32886d());
                intent.putExtra(AuthInternalPickerConstant.SignInReqKey.HUAWEIIDSIGNINREQUEST, accountSignInRequest.toJson());
            } catch (JSONException e11) {
                C5602as.m32912d("[AccountSDK]AccountAuthUtil", "JSONException:" + e11.getClass().getSimpleName(), true);
            }
        } catch (Exception e12) {
            C5602as.m32912d("[AccountSDK]AccountAuthUtil", "Exception:" + e12.getClass().getSimpleName(), true);
        }
        return intent;
    }

    /* renamed from: a */
    public static AccountAuthResult m32921a(Intent intent) {
        C5602as.m32910b("[AccountSDK]AccountAuthUtil", "getSignInResultFromIntent", true);
        if (intent == null || !intent.hasExtra("HUAWEIID_SIGNIN_RESULT")) {
            C5602as.m32912d("[AccountSDK]AccountAuthUtil", "data or signInResult is null", true);
            return null;
        }
        try {
            return new AccountAuthResult().fromJson(intent.getStringExtra("HUAWEIID_SIGNIN_RESULT"));
        } catch (JSONException unused) {
            C5602as.m32912d("[AccountSDK]AccountAuthUtil", "JSONException", true);
            return null;
        }
    }

    /* renamed from: a */
    public static void m32922a() {
        C5608g.m32926a().m32930c();
    }

    /* renamed from: a */
    public static AccountAuthParams m32920a(List<Scope> list) {
        AccountAuthParamsHelper accountAuthParamsHelper = new AccountAuthParamsHelper();
        if (C5599ap.m32901b(list).booleanValue()) {
            accountAuthParamsHelper.setScopeList(list);
        }
        return accountAuthParamsHelper.createParams();
    }

    /* renamed from: a */
    public static void m32924a(Window window) {
        if (window == null) {
            return;
        }
        C5602as.m32910b("[AccountSDK]AccountAuthUtil", "android version is Higher than 9.0", true);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.layoutInDisplayCutoutMode = 1;
        window.setAttributes(attributes);
        window.getDecorView().setSystemUiVisibility(5894);
    }

    /* renamed from: a */
    public static void m32923a(Activity activity) {
        try {
            int systemUiVisibility = activity.getWindow().getDecorView().getSystemUiVisibility();
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            activity.getWindow().getDecorView().setSystemUiVisibility(systemUiVisibility | 1024);
            activity.getWindow().setStatusBarColor(0);
            activity.getWindow().setNavigationBarColor(0);
            activity.getWindow().setNavigationBarContrastEnforced(false);
        } catch (Exception e10) {
            C5602as.m32912d("[AccountSDK]AccountAuthUtil", "exception occured:" + e10.getClass().getSimpleName(), true);
        }
    }
}
