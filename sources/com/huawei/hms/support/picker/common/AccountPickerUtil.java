package com.huawei.hms.support.picker.common;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.UserManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.huawei.hms.common.internal.constant.AuthInternalPickerConstant;
import com.huawei.hms.common.utils.AccountPickerEmuiUtil;
import com.huawei.hms.p109a.p110a.p111a.C5037a;
import com.huawei.hms.p109a.p110a.p113c.C5040a;
import com.huawei.hms.support.api.entity.hwid.AccountPickerSignInRequest;
import com.huawei.hms.support.picker.activity.AccountPickerSignInHubActivity;
import com.huawei.hms.support.picker.request.AccountPickerParams;
import com.huawei.hms.support.picker.result.AccountPickerResult;
import com.huawei.hms.support.picker.result.AuthAccountPicker;
import com.huawei.hms.utils.Util;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONException;
import org.json.JSONObject;
import p640sq.C12836o;

/* loaded from: classes8.dex */
public class AccountPickerUtil {
    private static final String DISPLAYSIDEREGIONEX = "com.huawei.android.view.DisplaySideRegionEx";
    private static final String HUAWEI_ANDROID_VIEW_LAYOUTPARAMSEX = "com.huawei.android.view.LayoutParamsEx";
    private static final String HWFLAGS = "addHwFlags";
    private static final int LAYOUT_IN_DISPLAY = 1;
    private static final int SECURE_SCREENSHOT = 4096;
    private static final String TAG = "[ACCOUNTSDK]AccountPickerUtil";
    private static final String WINDOW_MANAGER_EX_LAYOUT_PARAMS_EX = "com.huawei.android.view.WindowManagerEx$LayoutParamsEx";
    private static Boolean isPhoneStillInLockMode;

    /* renamed from: com.huawei.hms.support.picker.common.AccountPickerUtil$1 */
    public class ViewOnApplyWindowInsetsListenerC65061 implements View.OnApplyWindowInsetsListener {
        final /* synthetic */ ViewGroup val$sRootView;

        public ViewOnApplyWindowInsetsListenerC65061(ViewGroup viewGroup) {
            viewGroup = viewGroup;
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            try {
                Object objInvoke = Class.forName(AccountPickerUtil.WINDOW_MANAGER_EX_LAYOUT_PARAMS_EX).getMethod("getDisplaySideRegion", WindowInsets.class).invoke(null, windowInsets);
                if (objInvoke == null) {
                    C12836o.m77097b(AccountPickerUtil.TAG, "Non-hypersurface equipment", true);
                } else {
                    Rect rect = (Rect) Class.forName(AccountPickerUtil.DISPLAYSIDEREGIONEX).getMethod("getSafeInsets", new Class[0]).invoke(objInvoke, new Object[0]);
                    C12836o.m77097b(AccountPickerUtil.TAG, "safeInsets Left and Right: " + rect.left + ":" + rect.right, true);
                    C12836o.m77097b(AccountPickerUtil.TAG, "safeInsets Top and BOttom: " + rect.top + ":" + rect.bottom, true);
                    ViewGroup viewGroup = viewGroup;
                    if (viewGroup != null) {
                        viewGroup.setPadding(rect.left, 0, rect.right, 0);
                    }
                }
            } catch (ClassNotFoundException unused) {
                C12836o.m77099d(AccountPickerUtil.TAG, "ClassNotFoundException", true);
            } catch (IllegalAccessException unused2) {
                C12836o.m77099d(AccountPickerUtil.TAG, "IllegalAccessException", true);
            } catch (NoSuchMethodException unused3) {
                C12836o.m77099d(AccountPickerUtil.TAG, "NoSuchMethodException", true);
            } catch (InvocationTargetException unused4) {
                C12836o.m77099d(AccountPickerUtil.TAG, "InvocationTargetException", true);
            } catch (Throwable th2) {
                C12836o.m77099d(AccountPickerUtil.TAG, "onApplyWindowInsets: " + th2.getClass().getSimpleName(), true);
            }
            return view.onApplyWindowInsets(windowInsets);
        }
    }

    public static void clearSignInAccountCache() {
        C5040a.m30081a().m30085c();
    }

    public static AuthAccountPicker getCachedSignInAccount() {
        return C5040a.m30081a().m30084b();
    }

    public static Intent getSignInByMcpIntent(Context context, AccountPickerParams accountPickerParams, String str, String str2, int i10, boolean z10) throws JSONException {
        Intent signInIntent = getSignInIntent(context, accountPickerParams, str, str2, i10, z10);
        signInIntent.putExtra(AuthInternalPickerConstant.SignInReqKey.MCP_SIGN_IN, true);
        return signInIntent;
    }

    public static Intent getSignInIntent(Context context, AccountPickerParams accountPickerParams, String str, String str2, int i10, boolean z10) throws JSONException {
        C12836o.m77097b(TAG, "getSignInIntent", true);
        Intent intent = new Intent(AuthInternalPickerConstant.IntentAction.ACTION_SIGN_IN_HUB);
        try {
            intent.setPackage(context.getPackageName());
            if (z10) {
                C12836o.m77097b(TAG, "pickerType is " + i10, true);
                try {
                    JSONObject jSONObject = new JSONObject(accountPickerParams.getSignInParams());
                    jSONObject.put(AuthInternalPickerConstant.SignInReqKey.PICKER_TYPE, i10);
                    accountPickerParams.setSignInParams(jSONObject.toString());
                } catch (JSONException e10) {
                    C12836o.m77099d(TAG, "JSONException:" + e10.getClass().getSimpleName(), true);
                }
            }
            intent.setClass(context, AccountPickerSignInHubActivity.class);
            intent.putExtra(AuthInternalPickerConstant.SignInReqKey.HUAWEIIDSIGNINREQUEST, str2);
            intent.putExtra(AuthInternalPickerConstant.SignInReqKey.IS_NEW_SERVICE, z10);
            String appId = Util.getAppId(context);
            String packageName = context.getPackageName();
            C5037a c5037a = new C5037a();
            c5037a.setAppId(appId);
            c5037a.setPackageName(packageName);
            c5037a.setHmsSdkVersion(61200300L);
            c5037a.setSubAppId(str);
            AccountPickerSignInRequest accountPickerSignInRequest = new AccountPickerSignInRequest();
            accountPickerSignInRequest.setAccountPickerParams(accountPickerParams);
            try {
                intent.putExtra(AuthInternalPickerConstant.SignInReqKey.HUAWEIIDCPCLIENTINFO, c5037a.toJson());
                intent.putExtra(AuthInternalPickerConstant.SignInReqKey.HUAWEIIDSIGNINREQUEST, accountPickerSignInRequest.toJson());
            } catch (JSONException e11) {
                C12836o.m77099d(TAG, "JSONException:" + e11.getClass().getSimpleName(), true);
            }
        } catch (Exception e12) {
            C12836o.m77099d(TAG, "Exception:" + e12.getClass().getSimpleName(), true);
        }
        return intent;
    }

    public static AccountPickerResult getSignInResultFromIntent(Intent intent) {
        C12836o.m77097b(TAG, "getSignInResultFromIntent", true);
        if (intent == null || !intent.hasExtra("HUAWEIID_SIGNIN_RESULT")) {
            C12836o.m77099d(TAG, "data or signInResult is null", true);
            return null;
        }
        try {
            return new AccountPickerResult().fromJson(intent.getStringExtra("HUAWEIID_SIGNIN_RESULT"));
        } catch (JSONException unused) {
            C12836o.m77099d(TAG, "JSONException", true);
            return null;
        }
    }

    private static void initOnApplyWindowInsets(Activity activity) {
        C12836o.m77097b(TAG, "begin initOnApplyWindowInsets", true);
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().findViewById(R.id.content);
        if (viewGroup == null) {
            C12836o.m77099d(TAG, "sRootView is null", true);
        } else {
            setLayoutDisplaySide(activity);
            activity.getWindow().getDecorView().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.huawei.hms.support.picker.common.AccountPickerUtil.1
                final /* synthetic */ ViewGroup val$sRootView;

                public ViewOnApplyWindowInsetsListenerC65061(ViewGroup viewGroup2) {
                    viewGroup = viewGroup2;
                }

                @Override // android.view.View.OnApplyWindowInsetsListener
                public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    try {
                        Object objInvoke = Class.forName(AccountPickerUtil.WINDOW_MANAGER_EX_LAYOUT_PARAMS_EX).getMethod("getDisplaySideRegion", WindowInsets.class).invoke(null, windowInsets);
                        if (objInvoke == null) {
                            C12836o.m77097b(AccountPickerUtil.TAG, "Non-hypersurface equipment", true);
                        } else {
                            Rect rect = (Rect) Class.forName(AccountPickerUtil.DISPLAYSIDEREGIONEX).getMethod("getSafeInsets", new Class[0]).invoke(objInvoke, new Object[0]);
                            C12836o.m77097b(AccountPickerUtil.TAG, "safeInsets Left and Right: " + rect.left + ":" + rect.right, true);
                            C12836o.m77097b(AccountPickerUtil.TAG, "safeInsets Top and BOttom: " + rect.top + ":" + rect.bottom, true);
                            ViewGroup viewGroup2 = viewGroup;
                            if (viewGroup2 != null) {
                                viewGroup2.setPadding(rect.left, 0, rect.right, 0);
                            }
                        }
                    } catch (ClassNotFoundException unused) {
                        C12836o.m77099d(AccountPickerUtil.TAG, "ClassNotFoundException", true);
                    } catch (IllegalAccessException unused2) {
                        C12836o.m77099d(AccountPickerUtil.TAG, "IllegalAccessException", true);
                    } catch (NoSuchMethodException unused3) {
                        C12836o.m77099d(AccountPickerUtil.TAG, "NoSuchMethodException", true);
                    } catch (InvocationTargetException unused4) {
                        C12836o.m77099d(AccountPickerUtil.TAG, "InvocationTargetException", true);
                    } catch (Throwable th2) {
                        C12836o.m77099d(AccountPickerUtil.TAG, "onApplyWindowInsets: " + th2.getClass().getSimpleName(), true);
                    }
                    return view.onApplyWindowInsets(windowInsets);
                }
            });
        }
    }

    public static boolean isPcSimulator(String str) {
        C12836o.m77097b(TAG, "isPcSimulator start.", true);
        try {
            return FaqConstants.DISABLE_HA_REPORT.equalsIgnoreCase(new JSONObject(str).optString("isPcSimulator", ""));
        } catch (JSONException unused) {
            C12836o.m77099d(TAG, "isPcSimulator: JsonException", true);
            return false;
        } catch (Exception unused2) {
            C12836o.m77099d(TAG, "isPcSimulator: Exception", true);
            return false;
        }
    }

    public static boolean isPhoneStillInLockMode(Context context) {
        if (context == null) {
            C12836o.m77099d(TAG, "context is null", true);
            return false;
        }
        Boolean bool = isPhoneStillInLockMode;
        if (bool != null && !bool.booleanValue()) {
            C12836o.m77097b(TAG, "isPhoneStillInLockMode is already false", true);
            return false;
        }
        int i10 = Build.VERSION.SDK_INT;
        UserManager userManager = (UserManager) context.getApplicationContext().getSystemService(UserManager.class);
        if (userManager == null) {
            C12836o.m77099d(TAG, "userManager is null.", true);
            return false;
        }
        if (userManager.isUserUnlocked()) {
            isPhoneStillInLockMode = Boolean.FALSE;
            C12836o.m77097b(TAG, "isPhoneStillInLockMode false", true);
        } else {
            C12836o.m77099d(TAG, "isPhoneStillInLockMode true", true);
            isPhoneStillInLockMode = Boolean.TRUE;
        }
        C12836o.m77099d(TAG, "Build.VERSION.SDK_INT : " + i10 + " isPhoneStillInLockMode " + isPhoneStillInLockMode, true);
        Boolean bool2 = isPhoneStillInLockMode;
        if (bool2 == null) {
            return false;
        }
        return bool2.booleanValue();
    }

    public static boolean networkIsAvaiable(Context context) {
        C12836o.m77097b(TAG, "enter networkIsAvaiable", true);
        if (context == null) {
            C12836o.m77099d(TAG, "context is null", true);
            return false;
        }
        Object systemService = context.getApplicationContext().getSystemService("connectivity");
        if (systemService == null) {
            C12836o.m77099d(TAG, "connectivity is null,so networkIsAvaiable is unaviable", true);
            return false;
        }
        NetworkInfo[] allNetworkInfo = ((ConnectivityManager) systemService).getAllNetworkInfo();
        if (allNetworkInfo == null || allNetworkInfo.length == 0) {
            C12836o.m77097b(TAG, "NetworkInfo is null,so networkIsAvaiable is unaviable", true);
            return false;
        }
        for (NetworkInfo networkInfo : allNetworkInfo) {
            if (networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                return true;
            }
        }
        C12836o.m77097b(TAG, "NetworkInfo state is unaviable", true);
        return false;
    }

    public static void setEMUI10StatusBarColor(Activity activity) {
        if (AccountPickerEmuiUtil.isAboveEMUI100()) {
            initOnApplyWindowInsets(activity);
        }
    }

    public static void setFullScreenAdaptCutout(Window window) {
        if (window == null) {
            return;
        }
        C12836o.m77097b(TAG, "android version is Higher than 9.0", true);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.layoutInDisplayCutoutMode = 1;
        window.setAttributes(attributes);
        window.getDecorView().setSystemUiVisibility(1280);
    }

    private static void setLayoutDisplaySide(Activity activity) {
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        try {
            Class<?> cls = Class.forName(WINDOW_MANAGER_EX_LAYOUT_PARAMS_EX);
            cls.getMethod("setDisplaySideMode", Integer.TYPE).invoke(cls.getDeclaredConstructor(WindowManager.LayoutParams.class).newInstance(attributes), 1);
        } catch (ClassNotFoundException unused) {
            C12836o.m77099d(TAG, "ClassNotFoundException", true);
        } catch (IllegalAccessException unused2) {
            C12836o.m77099d(TAG, "IllegalAccessException", true);
        } catch (InstantiationException unused3) {
            C12836o.m77099d(TAG, "InstantiationException", true);
        } catch (NoSuchMethodException unused4) {
            C12836o.m77099d(TAG, "NoSuchMethodException", true);
        } catch (InvocationTargetException unused5) {
            C12836o.m77099d(TAG, "InvocationTargetException", true);
        } catch (Throwable th2) {
            C12836o.m77099d(TAG, "setDisplaySideMode: " + th2.getClass().getSimpleName(), true);
        }
    }

    public static void setStatusBarColor(Activity activity) {
        try {
            int systemUiVisibility = activity.getWindow().getDecorView().getSystemUiVisibility();
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            activity.getWindow().getDecorView().setSystemUiVisibility(systemUiVisibility | 1024);
            activity.getWindow().setStatusBarColor(0);
            activity.getWindow().setNavigationBarColor(0);
            activity.getWindow().setNavigationBarContrastEnforced(false);
        } catch (Exception e10) {
            C12836o.m77099d(TAG, "exception occured:" + e10.getClass().getSimpleName(), true);
        }
    }
}
