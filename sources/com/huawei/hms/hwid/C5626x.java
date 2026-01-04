package com.huawei.hms.hwid;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.common.internal.constant.AuthInternalPickerConstant;
import com.huawei.hms.hwid.internal.p128ui.activity.HwIdSignInHubActivity;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.hwid.HuaweiIdSignInRequest;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParams;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import com.huawei.hms.support.hwid.result.HuaweiIdAuthResult;
import com.huawei.hms.utils.Util;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

/* renamed from: com.huawei.hms.hwid.x */
/* loaded from: classes8.dex */
public final class C5626x {
    /* renamed from: a */
    public static Intent m32961a(Context context, HuaweiIdAuthParams huaweiIdAuthParams, String str) {
        C5602as.m32910b("[HUAWEIIDSDK]HuaweiIdAuthTool", "getSignInIntent enter", true);
        Intent intent = new Intent("com.huawei.hms.jos.signIn");
        try {
            intent.setPackage(context.getPackageName());
            intent.setClass(context, HwIdSignInHubActivity.class);
            String appId = Util.getAppId(context);
            String packageName = context.getPackageName();
            C5621s c5621s = new C5621s();
            c5621s.m32883b(appId);
            c5621s.m32885c(packageName);
            c5621s.m32881a(61200300L);
            c5621s.m32887d(str);
            HuaweiIdSignInRequest huaweiIdSignInRequest = new HuaweiIdSignInRequest();
            huaweiIdSignInRequest.setHuaweiIdAuthParams(huaweiIdAuthParams);
            try {
                intent.putExtra(AuthInternalPickerConstant.SignInReqKey.HUAWEIIDCPCLIENTINFO, c5621s.m32886d());
                intent.putExtra(AuthInternalPickerConstant.SignInReqKey.HUAWEIIDSIGNINREQUEST, huaweiIdSignInRequest.toJson());
            } catch (JSONException e10) {
                C5602as.m32912d("[HUAWEIIDSDK]HuaweiIdAuthTool", "JSONException:" + e10.getClass().getSimpleName(), true);
            }
        } catch (Exception e11) {
            C5602as.m32912d("[HUAWEIIDSDK]HuaweiIdAuthTool", "Exception:" + e11.getClass().getSimpleName(), true);
        }
        return intent;
    }

    /* renamed from: b */
    public static AuthHuaweiId m32966b() {
        return C5627y.m32967a().m32970b();
    }

    /* renamed from: a */
    public static HuaweiIdAuthResult m32963a(Intent intent) {
        C5602as.m32910b("[HUAWEIIDSDK]HuaweiIdAuthTool", "getSignInResultFromIntent", true);
        if (intent == null || !intent.hasExtra("HUAWEIID_SIGNIN_RESULT")) {
            C5602as.m32912d("[HUAWEIIDSDK]HuaweiIdAuthTool", "data or signInResult is null", true);
            return null;
        }
        try {
            return new HuaweiIdAuthResult().fromJson(intent.getStringExtra("HUAWEIID_SIGNIN_RESULT"));
        } catch (JSONException unused) {
            C5602as.m32912d("[HUAWEIIDSDK]HuaweiIdAuthTool", "JSONException", true);
            return null;
        }
    }

    /* renamed from: a */
    public static void m32964a() {
        C5627y.m32967a().m32971c();
    }

    /* renamed from: a */
    public static HuaweiIdAuthParams m32962a(List<Scope> list) {
        HuaweiIdAuthParamsHelper huaweiIdAuthParamsHelper = new HuaweiIdAuthParamsHelper();
        if (C5599ap.m32901b(list).booleanValue()) {
            huaweiIdAuthParamsHelper.setScopeList(list);
        }
        Iterator<Scope> it = list.iterator();
        while (it.hasNext()) {
            if (m32965a(it.next(), "https://www.huawei.com/auth/account/shipping.address")) {
                huaweiIdAuthParamsHelper.setShippingAddress();
            }
        }
        return huaweiIdAuthParamsHelper.createParams();
    }

    /* renamed from: a */
    private static boolean m32965a(Scope scope, String str) {
        if (scope != null) {
            return TextUtils.equals(scope.getScopeUri(), str);
        }
        return false;
    }
}
