package com.huawei.hms.support.hwid.tools;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.constant.AuthInternalPickerConstant;
import com.huawei.hms.hwid.C5584aa;
import com.huawei.hms.hwid.C5602as;
import com.huawei.hms.hwid.C5620r;
import com.huawei.hms.hwid.C5622t;
import com.huawei.hms.hwid.C5626x;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.support.hwid.common.HuaweiIdAuthException;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParams;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import com.huawei.hms.support.hwid.service.HuaweiIdAuthService;
import com.huawei.hms.support.hwid.service.HuaweiIdAuthServiceImpl;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import p208cq.InterfaceC8938f;
import p208cq.InterfaceC8939g;

/* loaded from: classes8.dex */
public class HuaweiIdAuthTool {
    protected static final String TAG = "[HUAWEIIDSDK]HuaweiIdAuthTool";

    /* renamed from: com.huawei.hms.support.hwid.tools.HuaweiIdAuthTool$a */
    public static class C6501a {

        /* renamed from: a */
        private int f30107a;

        private C6501a() {
        }

        /* renamed from: a */
        public void m36968a(int i10) {
            this.f30107a = i10;
        }

        /* renamed from: a */
        public int m36967a() {
            return this.f30107a;
        }
    }

    private HuaweiIdAuthTool() {
    }

    /* renamed from: a */
    private static void m36963a(final Task<Void> task) throws HuaweiIdAuthException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final C6501a c6501a = new C6501a();
        task.addOnSuccessListener(new InterfaceC8939g<Void>() { // from class: com.huawei.hms.support.hwid.tools.HuaweiIdAuthTool.2
            @Override // p208cq.InterfaceC8939g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r32) {
                C5602as.m32910b(HuaweiIdAuthTool.TAG, "deleteAuthInfo Success.", true);
                countDownLatch.countDown();
                c6501a.m36968a(0);
            }
        }).addOnFailureListener(new InterfaceC8938f() { // from class: com.huawei.hms.support.hwid.tools.HuaweiIdAuthTool.1
            @Override // p208cq.InterfaceC8938f
            public void onFailure(Exception exc) {
                int statusCode = ((ApiException) task.getException()).getStatusCode();
                C5602as.m32910b(HuaweiIdAuthTool.TAG, "deleteAuthInfo fail: " + statusCode, true);
                countDownLatch.countDown();
                c6501a.m36968a(statusCode);
            }
        });
        try {
        } catch (InterruptedException unused) {
            c6501a.m36968a(8);
        }
        if (!countDownLatch.await(10L, TimeUnit.SECONDS)) {
            throw new HuaweiIdAuthException("connection timeout[907135004 ].");
        }
        if (c6501a.m36967a() != 0) {
            if (c6501a.m36967a() == 8) {
                throw new HuaweiIdAuthException("unknown interruption[8].");
            }
            if (c6501a.m36967a() == 2010) {
                C5602as.m32911c(TAG, "invalid arguments[907135000].", true);
            }
        }
        C5602as.m32910b(TAG, "deleteAuthInfo return[success]", true);
    }

    /* renamed from: b */
    private static Account m36964b(Context context, String str) throws HuaweiIdAuthException {
        if (context == null) {
            C5602as.m32910b(TAG, "context is null", true);
            throw new HuaweiIdAuthException("context is null");
        }
        String hMSPackageName = HMSPackageManager.getInstance(context).getHMSPackageName();
        C5602as.m32910b(TAG, "get package name of hms is " + hMSPackageName, true);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(hMSPackageName)) {
            return null;
        }
        return new Account(str, hMSPackageName);
    }

    public static void deleteAuthInfo(Context context, String str) throws HuaweiIdAuthException, JSONException {
        m36962a(context, str);
    }

    @Deprecated
    public static String requestAccessToken(Context context, String str, List<Scope> list, Bundle bundle) throws HuaweiIdAuthException {
        return requestAccessToken(context, m36964b(context, str), list, bundle);
    }

    public static String requestUnionId(Context context, String str) throws HuaweiIdAuthException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Scope("openid"));
        return m36958a(context, m36964b(context, str), arrayList, new Bundle(), "requestUnionId").m32894c();
    }

    public static void deleteAuthInfo(Activity activity, String str) throws HuaweiIdAuthException, JSONException {
        m36962a(activity, str);
    }

    @Deprecated
    public static String requestAccessToken(Activity activity, String str, List<Scope> list, Bundle bundle) throws HuaweiIdAuthException {
        return requestAccessToken(activity, m36964b(activity, str), list, bundle);
    }

    @Deprecated
    public static String requestAccessToken(Context context, String str, List<Scope> list) throws HuaweiIdAuthException {
        return requestAccessToken(context, m36964b(context, str), list, new Bundle());
    }

    @Deprecated
    public static String requestAccessToken(Activity activity, String str, List<Scope> list) throws HuaweiIdAuthException {
        return requestAccessToken(activity, m36964b(activity, str), list, new Bundle());
    }

    public static String requestAccessToken(Context context, Account account, List<Scope> list) throws HuaweiIdAuthException {
        return requestAccessToken(context, account, list, new Bundle());
    }

    public static String requestUnionId(Activity activity, String str) throws HuaweiIdAuthException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Scope("openid"));
        return m36958a(activity, m36964b(activity, str), arrayList, new Bundle(), "requestUnionId").m32894c();
    }

    public static String requestAccessToken(Activity activity, Account account, List<Scope> list) throws HuaweiIdAuthException {
        return requestAccessToken(activity, account, list, new Bundle());
    }

    public static String requestAccessToken(Context context, Account account, List<Scope> list, Bundle bundle) throws HuaweiIdAuthException {
        return m36958a(context, account, list, bundle, "requestAccessToken").m32892b();
    }

    public static String requestAccessToken(Activity activity, Account account, List<Scope> list, Bundle bundle) throws HuaweiIdAuthException {
        return m36958a(activity, account, list, bundle, "requestAccessToken").m32892b();
    }

    /* renamed from: a */
    private static void m36962a(Context context, String str) throws HuaweiIdAuthException, JSONException {
        boolean z10;
        C5620r.m32955a();
        C5626x.m32964a();
        if (context != null) {
            if (context instanceof Activity) {
                z10 = true;
            } else {
                m36960a(context);
                z10 = false;
            }
            if (TextUtils.isEmpty(str)) {
                C5602as.m32910b(TAG, "accessToken is null or empty.", true);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("accessToken", str);
                HuaweiIdAuthServiceImpl huaweiIdAuthServiceImpl = new HuaweiIdAuthServiceImpl(context, (HuaweiIdAuthParams) null, AuthInternalPickerConstant.HMS_SDK_VERSION);
                if (z10) {
                    huaweiIdAuthServiceImpl = new HuaweiIdAuthServiceImpl((Activity) context, (HuaweiIdAuthParams) null, AuthInternalPickerConstant.HMS_SDK_VERSION);
                }
                m36963a((Task<Void>) huaweiIdAuthServiceImpl.doWrite(new C5584aa("hwid.signout", jSONObject.toString(), HiAnalyticsClient.reportEntry(context, "hwid.signout", AuthInternalPickerConstant.HMS_SDK_VERSION))));
                return;
            } catch (JSONException unused) {
                throw new HuaweiIdAuthException("json error.");
            }
        }
        throw new HuaweiIdAuthException("Context or Activity is null.");
    }

    /* renamed from: a */
    private static C5622t m36958a(Context context, Account account, List<Scope> list, Bundle bundle, String str) throws HuaweiIdAuthException {
        boolean z10;
        HuaweiIdAuthServiceImpl huaweiIdAuthServiceImpl;
        C5620r.m32955a();
        if (context != null) {
            if (context instanceof Activity) {
                z10 = true;
            } else {
                m36960a(context);
                z10 = false;
            }
            m36961a(context, account, list, bundle);
            HuaweiIdAuthParams huaweiIdAuthParamsCreateParams = new HuaweiIdAuthParamsHelper().setAccessToken().setScopeList(list).createParams();
            String str2 = account == null ? "" : account.name;
            if (z10) {
                huaweiIdAuthServiceImpl = new HuaweiIdAuthServiceImpl((Activity) context, huaweiIdAuthParamsCreateParams, str2, AuthInternalPickerConstant.HMS_SDK_VERSION);
            } else {
                huaweiIdAuthServiceImpl = new HuaweiIdAuthServiceImpl(context, huaweiIdAuthParamsCreateParams, str2, AuthInternalPickerConstant.HMS_SDK_VERSION);
            }
            return m36959a(huaweiIdAuthServiceImpl, str);
        }
        throw new HuaweiIdAuthException("Context or Activity is null.");
    }

    /* renamed from: a */
    private static void m36960a(Context context) throws HuaweiIdAuthException {
        int iIsHuaweiMobileServicesAvailable = new AvailableAdapter(Constants.HMS_VERSION_CODE_40000300).isHuaweiMobileServicesAvailable(context);
        C5602as.m32910b(TAG, "checkDependentHMSVersion result is: " + iIsHuaweiMobileServicesAvailable, true);
        if (1 == iIsHuaweiMobileServicesAvailable) {
            throw new HuaweiIdAuthException("hms apk is not exist[2013]");
        }
        if (2 == iIsHuaweiMobileServicesAvailable) {
            throw new HuaweiIdAuthException("hms apk version is low[2013]");
        }
    }

    /* renamed from: a */
    private static void m36961a(Context context, Account account, List<Scope> list, Bundle bundle) throws HuaweiIdAuthException {
        String hMSPackageName = HMSPackageManager.getInstance(context).getHMSPackageName();
        C5602as.m32910b(TAG, "get package name of hms is " + hMSPackageName, true);
        String str = (account == null || hMSPackageName.equals(account.type)) ? null : "Account type is not supported.";
        if (!TextUtils.isEmpty(str)) {
            throw new HuaweiIdAuthException(str);
        }
    }

    /* renamed from: a */
    private static C5622t m36959a(HuaweiIdAuthService huaweiIdAuthService, String str) throws HuaweiIdAuthException, InterruptedException {
        C5602as.m32910b(TAG, "start countDownLatch innerSignIn:" + str, true);
        final C5622t c5622t = new C5622t();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        Task<AuthHuaweiId> taskSilentSignIn = huaweiIdAuthService.silentSignIn();
        taskSilentSignIn.addOnSuccessListener(new InterfaceC8939g<AuthHuaweiId>() { // from class: com.huawei.hms.support.hwid.tools.HuaweiIdAuthTool.3
            @Override // p208cq.InterfaceC8939g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(AuthHuaweiId authHuaweiId) {
                C5602as.m32910b(HuaweiIdAuthTool.TAG, "silentSignIn success", true);
                c5622t.m32890a(0);
                c5622t.m32891a(authHuaweiId.getAccessToken());
                c5622t.m32893b(authHuaweiId.getUnionId());
                countDownLatch.countDown();
            }
        });
        taskSilentSignIn.addOnFailureListener(new InterfaceC8938f() { // from class: com.huawei.hms.support.hwid.tools.HuaweiIdAuthTool.4
            @Override // p208cq.InterfaceC8938f
            public void onFailure(Exception exc) {
                C5602as.m32910b(HuaweiIdAuthTool.TAG, "silentSignIn fail", true);
                if (exc instanceof ApiException) {
                    c5622t.m32890a(((ApiException) exc).getStatusCode());
                }
                countDownLatch.countDown();
            }
        });
        boolean zAwait = false;
        try {
            zAwait = countDownLatch.await(10L, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            C5602as.m32912d(TAG, "innerSignIn InterruptedException.", true);
            c5622t.m32890a(8);
        }
        if (!zAwait) {
            throw new HuaweiIdAuthException("connection timeout[907135004 ].");
        }
        C5602as.m32910b(TAG, str + " end countDownLatch awaitValue:" + zAwait, true);
        int iM32889a = c5622t.m32889a();
        if (iM32889a == 0) {
            return c5622t;
        }
        C5602as.m32912d(TAG, str + " fail, error code is:" + iM32889a, true);
        throw new HuaweiIdAuthException(str + " error[" + iM32889a + "]");
    }
}
