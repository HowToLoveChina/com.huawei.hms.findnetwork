package com.huawei.hms.support.picker.service;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hwidauth.datatype.DeviceInfo;
import com.huawei.hwidauth.p167ui.WebViewActivity;
import iq.C10588b;
import iq.C10591e;
import iq.C10593g;
import iq.C10597k;
import iq.InterfaceC10596j;
import p640sq.C12836o;

/* loaded from: classes8.dex */
public class AccountLiteSdkServiceImpl {
    private static final String AT_INVALID = "AT invalid";
    private static final String CONST_SIGN = "from_signin";
    private static final String CONTEXT_INVALID = "Context is null";
    private static final String DEVICEID_DEVICETYPE_EXCEPTION = "deviceID and deviceType are null";
    private static final String PARAM_EXCEPTION = "param is error";
    private static final String PICKER_SIGNIN = "pickerSignIn";
    private static final String REDIRECURI_INVALID = "RedirectUri is null";
    private static final String SCOPE_EXCEPTION = "scopes is null";
    private static final String SPLIT_CHAR = " ";
    private static final String TAG = "AccountLiteSdkServiceImpl";

    public static void h5SignOut(Context context, InterfaceC10596j<C10588b> interfaceC10596j) throws C10593g {
        C12836o.m77097b(TAG, "accountPicker signOut", true);
        C10591e.m64990h(context, interfaceC10596j);
    }

    public static void revoke(Context context, String str, String str2, InterfaceC10596j<C10597k> interfaceC10596j) throws C10593g {
        C12836o.m77097b(TAG, "accountPicker revoke", true);
        C10591e.m64988f(context, str, str2, interfaceC10596j);
    }

    private static String setScopes(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (String str : strArr) {
            sb2.append(str);
            sb2.append(" ");
        }
        return sb2.toString();
    }

    public static Intent signInH5(Context context, String str, String[] strArr, String str2, String str3, String str4, boolean z10, String str5, String str6, String str7) throws C10593g {
        C12836o.m77097b(TAG, "accountPicker: signInH5", true);
        if (context == null) {
            throw new C10593g(CONTEXT_INVALID);
        }
        if (TextUtils.isEmpty(str6)) {
            C12836o.m77097b(TAG, "Appid is null", true);
            throw new C10593g(AT_INVALID);
        }
        if (strArr == null || strArr.length == 0) {
            C12836o.m77097b(TAG, SCOPE_EXCEPTION, true);
            throw new C10593g(SCOPE_EXCEPTION);
        }
        if (TextUtils.isEmpty(str2)) {
            C12836o.m77097b(TAG, REDIRECURI_INVALID, true);
            throw new C10593g(REDIRECURI_INVALID);
        }
        if (TextUtils.isEmpty(str3)) {
            C12836o.m77097b(TAG, "deviceID or deviceType are null", true);
            throw new C10593g(DEVICEID_DEVICETYPE_EXCEPTION);
        }
        try {
            Intent intent = new Intent(context, (Class<?>) WebViewActivity.class);
            intent.setPackage(context.getPackageName());
            intent.putExtra("key_pickerSignIn", PICKER_SIGNIN);
            if (TextUtils.isEmpty(str7)) {
                intent.putExtra("key_oper", CONST_SIGN);
            } else {
                intent.putExtra("key_cp_login_url", str7);
                intent.putExtra("key_oper", "from_other_app_signin");
            }
            intent.putExtra("key_app_id", str6);
            intent.putExtra("key_scopes", setScopes(strArr));
            intent.putExtra("key_redirecturi", str2);
            intent.putExtra("key_code_verifier", str4);
            intent.putExtra("key_mcp_signIn", z10);
            intent.putExtra("grs_app_name", str);
            if (z10) {
                intent.putExtra("key_access_token", str5);
            }
            intent.putExtra("key_device_info", (Parcelable) DeviceInfo.m38003c(context, str3));
            return intent;
        } catch (RuntimeException unused) {
            C12836o.m77099d(TAG, "RuntimeException signInH5", true);
            throw new C10593g(PARAM_EXCEPTION);
        } catch (Exception unused2) {
            C12836o.m77099d(TAG, "Exception signInH5", true);
            throw new C10593g(PARAM_EXCEPTION);
        }
    }
}
