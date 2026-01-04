package com.huawei.hms.support.hwid.service;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.api.HuaweiApiClientImpl;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.api.OptionalPendingResult;
import com.huawei.hms.common.api.internal.OptionalPendingResultImpl;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.hwid.C5602as;
import com.huawei.hms.hwid.C5626x;
import com.huawei.hms.p148ui.SafeBundle;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.core.ConnectService;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.hms.support.api.entity.common.CommonNaming;
import com.huawei.hms.support.api.entity.core.JosGetNoticeResp;
import com.huawei.hms.support.api.entity.hwid.RevokeAccessResp;
import com.huawei.hms.support.api.entity.hwid.SignInReq;
import com.huawei.hms.support.api.entity.hwid.SignInResp;
import com.huawei.hms.support.api.entity.hwid.SignOutReq;
import com.huawei.hms.support.api.entity.hwid.SignOutResp;
import com.huawei.hms.support.api.hwid.SignInResult;
import com.huawei.hms.support.hwid.HuaweiIdAuthAPIManager;
import com.huawei.hms.support.hwid.HuaweiIdAuthManager;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParams;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import com.huawei.hms.support.hwid.result.HuaweiIdAuthResult;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.Util;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import p208cq.InterfaceC8937e;

/* loaded from: classes8.dex */
public class HuaweiIdAuthAPIServiceImpl implements HuaweiIdAuthAPIService {

    /* renamed from: a */
    private HuaweiApiClient f30079a = null;

    /* renamed from: b */
    private WeakReference<Activity> f30080b = null;

    public static class SignOutNoConnectPendingResult extends PendingResultImpl<Status, SignOutResp> {

        /* renamed from: a */
        private ResultCallback f30085a;

        public SignOutNoConnectPendingResult(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        public ResultCallback getCallback() {
            return this.f30085a;
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl, com.huawei.hms.support.api.client.PendingResult
        public void setResultCallback(ResultCallback<Status> resultCallback) {
            this.f30085a = resultCallback;
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        public Status onComplete(SignOutResp signOutResp) {
            Status status = new Status(0);
            C5602as.m32910b("HuaweiIdAuthAPIServiceImpl", "signOut onComplete", true);
            return status;
        }
    }

    public static class SignOutOnCompleteListener implements InterfaceC8937e<Void> {

        /* renamed from: a */
        private final SignOutNoConnectPendingResult f30086a;

        public SignOutOnCompleteListener(SignOutNoConnectPendingResult signOutNoConnectPendingResult) {
            this.f30086a = signOutNoConnectPendingResult;
        }

        @Override // p208cq.InterfaceC8937e
        public void onComplete(Task<Void> task) {
            C5602as.m32910b("HuaweiIdAuthAPIServiceImpl", "SignOutOnCompleteListener onComplete", true);
            if (this.f30086a == null) {
                C5602as.m32912d("HuaweiIdAuthAPIServiceImpl", "signOutResultPendingResult is null", true);
                return;
            }
            Status status = Status.FAILURE;
            if (task.isSuccessful()) {
                status = Status.SUCCESS;
            } else {
                Exception exception = task.getException();
                if (exception == null || !(exception instanceof ApiException)) {
                    C5602as.m32912d("HuaweiIdAuthAPIServiceImpl", "wrong exception while failed", true);
                } else {
                    status = new Status(((ApiException) exception).getStatusCode());
                }
            }
            ResultCallback callback = this.f30086a.getCallback();
            if (callback != null) {
                callback.onResult(status);
            } else {
                C5602as.m32912d("HuaweiIdAuthAPIServiceImpl", "set Result callback after signOut completed", true);
            }
        }
    }

    /* renamed from: com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIServiceImpl$a */
    public class C6492a implements ResultCallback<ResolveResult<JosGetNoticeResp>> {
        private C6492a() {
        }

        @Override // com.huawei.hms.support.api.client.ResultCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(ResolveResult<JosGetNoticeResp> resolveResult) {
            JosGetNoticeResp value;
            Intent noticeIntent;
            if (resolveResult == null || !resolveResult.getStatus().isSuccess() || (noticeIntent = (value = resolveResult.getValue()).getNoticeIntent()) == null || value.getStatusCode() != 0) {
                return;
            }
            C5602as.m32909a("HuaweiIdAuthAPIServiceImpl", "get notice has intent.", true);
            Activity validActivity = Util.getValidActivity((Activity) HuaweiIdAuthAPIServiceImpl.this.f30080b.get(), HuaweiIdAuthAPIServiceImpl.this.f30079a.getTopActivity());
            if (validActivity == null) {
                C5602as.m32912d("HuaweiIdAuthAPIServiceImpl", "showNotice no valid activity!", true);
                return;
            }
            try {
                validActivity.startActivity(noticeIntent);
            } catch (Exception e10) {
                C5602as.m32912d("HuaweiIdAuthAPIServiceImpl", "startActivity exception" + e10.getClass().getSimpleName(), true);
            }
        }
    }

    /* renamed from: com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIServiceImpl$b */
    public static class C6493b extends PendingResultImpl<Status, RevokeAccessResp> {
        public C6493b(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Status onComplete(RevokeAccessResp revokeAccessResp) {
            C5602as.m32910b("HuaweiIdAuthAPIServiceImpl", "RevokeAccessPendingResult onComplete", true);
            return new Status(revokeAccessResp.getRetCode());
        }
    }

    /* renamed from: com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIServiceImpl$c */
    public static class C6494c extends PendingResultImpl<Status, SignOutResp> {
        public C6494c(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Status onComplete(SignOutResp signOutResp) {
            Status status = new Status(0);
            C5602as.m32910b("HuaweiIdAuthAPIServiceImpl", "signOut onComplete", true);
            return status;
        }
    }

    /* renamed from: c */
    private int m36932c(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            C5602as.m32912d("HuaweiIdAuthAPIServiceImpl", "parse homeZone error.", true);
            return 0;
        }
    }

    public static int conversionGender(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "-1";
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static int conversionHomeZone(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static HashSet<Scope> conversionScopes(String str) {
        HashSet<Scope> hashSet = new HashSet<>();
        if (str != null) {
            for (String str2 : str.split(" ")) {
                hashSet.add(new Scope(str2));
            }
        }
        return hashSet;
    }

    public static int conversionStatus(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    /* renamed from: d */
    private PendingResult<Status> m36934d(HuaweiApiClient huaweiApiClient) {
        C5602as.m32910b("HuaweiIdAuthAPIServiceImpl", "Enter signOutNoConnected", true);
        Task<Void> taskSignOut = HuaweiIdAuthManager.getService(huaweiApiClient.getContext(), getSignInOption(huaweiApiClient)).signOut();
        SignOutNoConnectPendingResult signOutNoConnectPendingResult = new SignOutNoConnectPendingResult(huaweiApiClient, "hwid.signout", new SignOutReq());
        taskSignOut.addOnCompleteListener(new SignOutOnCompleteListener(signOutNoConnectPendingResult));
        return signOutNoConnectPendingResult;
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService
    public PendingResult<Status> cancelAuthorization(HuaweiApiClient huaweiApiClient) {
        C5602as.m32910b("HuaweiIdAuthAPIServiceImpl", "Enter cancelAuthorization", true);
        this.f30079a = huaweiApiClient;
        return new C6493b(huaweiApiClient, "hwid.revokeAccess", m36933c(huaweiApiClient));
    }

    public HuaweiIdAuthResult getHuaweiIdSignInResultFromIntent(Intent intent) {
        Status status;
        HuaweiIdAuthResult huaweiIdAuthResult = new HuaweiIdAuthResult();
        if (intent == null || intent.getExtras() == null) {
            status = new Status(2003);
            C5602as.m32912d("HuaweiIdAuthAPIServiceImpl", "getSignInResult error", true);
        } else {
            SafeBundle safeBundle = new SafeBundle(intent.getExtras());
            int i10 = safeBundle.getInt(CommonConstant.RETKEY.RETCODE, 0);
            status = new Status(i10);
            if (i10 == 0) {
                huaweiIdAuthResult.setAuthHuaweiId(m36925a(safeBundle));
                C5602as.m32910b("HuaweiIdAuthAPIServiceImpl", "getSignInResult success", true);
            } else {
                C5602as.m32910b("HuaweiIdAuthAPIServiceImpl", "getSignInResult fail", true);
            }
        }
        huaweiIdAuthResult.setStatus(status);
        return huaweiIdAuthResult;
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService
    public SignInResult getHwIdSignInResultFromIntent(Intent intent) {
        PendingIntent activity;
        if (intent == null || intent.getExtras() == null) {
            SignInResult signInResult = new SignInResult(new Status(2003));
            C5602as.m32912d("HuaweiIdAuthAPIServiceImpl", "getSignInResult error", true);
            return signInResult;
        }
        SafeBundle safeBundle = new SafeBundle(intent.getExtras());
        int i10 = safeBundle.getInt(CommonConstant.RETKEY.RETCODE, 0);
        if (i10 != 0) {
            if (i10 == 2002 || i10 == 2004) {
                Random random = new Random();
                C5602as.m32910b("HuaweiIdAuthAPIServiceImpl", "SDK version >= 23", true);
                activity = PendingIntent.getActivity(this.f30079a.getContext(), random.nextInt(), intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_CARD_MASK);
            } else {
                activity = null;
            }
            Status status = new Status(i10, (String) null, activity);
            SignInResult signInResult2 = new SignInResult(status);
            signInResult2.setStatus(status);
            signInResult2.setData(intent);
            C5602as.m32910b("HuaweiIdAuthAPIServiceImpl", "getSignInResult fail", true);
            return signInResult2;
        }
        String string = safeBundle.getString(CommonConstant.RETKEY.GENDER);
        String string2 = safeBundle.getString(CommonConstant.RETKEY.USERID, "");
        String string3 = safeBundle.getString(CommonConstant.RETKEY.STATUS);
        String string4 = safeBundle.getString(CommonConstant.RETKEY.SCOPE);
        String string5 = safeBundle.getString(CommonConstant.RETKEY.ID_TOKEN);
        String string6 = safeBundle.getString(CommonConstant.RETKEY.EMAIL);
        String string7 = safeBundle.getString(CommonConstant.RETKEY.FAMILY_NAME);
        String string8 = safeBundle.getString(CommonConstant.RETKEY.GIVEN_NAME);
        String string9 = safeBundle.getString(CommonConstant.RETKEY.AGE_RANGE);
        String string10 = safeBundle.getString(CommonConstant.RETKEY.HOME_ZONE);
        AuthHuaweiId authHuaweiIdBuild = AuthHuaweiId.build(safeBundle.getString(CommonConstant.RETKEY.OPENID, ""), string2, safeBundle.getString(CommonConstant.RETKEY.DISPLAYNAME, ""), safeBundle.getString(CommonConstant.RETKEY.PHOTOURL), safeBundle.getString(CommonConstant.RETKEY.ACCESS_TOKEN, ""), safeBundle.getString(CommonConstant.RETKEY.SERVICECOUNTRYCODE, ""), conversionStatus(string3), conversionGender(string), conversionScopes(string4), safeBundle.getString(CommonConstant.RETKEY.SERVICEAUTHCODE, ""), safeBundle.getString(CommonConstant.RETKEY.UNIONID, ""), safeBundle.getString(CommonConstant.RETKEY.COUNTRYCODE, ""));
        authHuaweiIdBuild.setIdToken(string5);
        authHuaweiIdBuild.setEmail(string6);
        authHuaweiIdBuild.setFamilyName(string7);
        authHuaweiIdBuild.setGivenName(string8);
        authHuaweiIdBuild.setAgeRange(string9);
        authHuaweiIdBuild.setHomeZone(conversionHomeZone(string10));
        Status status2 = new Status(i10);
        SignInResult signInResult3 = new SignInResult(status2);
        signInResult3.setStatus(status2);
        signInResult3.setAuthHuaweiId(authHuaweiIdBuild);
        C5602as.m32910b("HuaweiIdAuthAPIServiceImpl", "getSignInResult success", true);
        return signInResult3;
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService
    public Intent getSignInIntent(HuaweiApiClient huaweiApiClient) {
        Context context = huaweiApiClient.getContext();
        HuaweiIdAuthParams signInOption = getSignInOption(huaweiApiClient);
        if (signInOption == null) {
            return null;
        }
        return C5626x.m32961a(context, signInOption, huaweiApiClient.getSubAppInfo() != null ? huaweiApiClient.getSubAppInfo().getSubAppID() : null);
    }

    public HuaweiIdAuthParams getSignInOption(HuaweiApiClient huaweiApiClient) {
        Api.ApiOptions apiOptions;
        Map<Api<?>, Api.ApiOptions> apiMap = huaweiApiClient.getApiMap();
        if (apiMap == null || (apiOptions = apiMap.get(HuaweiIdAuthAPIManager.HUAWEI_OAUTH_API)) == null || !(apiOptions instanceof HuaweiIdAuthParams)) {
            return null;
        }
        return (HuaweiIdAuthParams) apiOptions;
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService
    public HuaweiIdAuthResult parseHuaweiIdFromIntent(Intent intent) {
        return C5626x.m32963a(intent);
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService
    public PendingResult<SignInResult> signIn(Activity activity, HuaweiApiClient huaweiApiClient) {
        C5602as.m32910b("HuaweiIdAuthAPIServiceImpl", "Enter signIn", true);
        Checker.checkNonNull(activity, "Activity must not be null.");
        Checker.checkNonNull(huaweiApiClient, "HuaweiApiClient must not be null.");
        List<Scope> listM36926a = m36926a(huaweiApiClient);
        List<PermissionInfo> listM36931b = m36931b(huaweiApiClient);
        HashSet hashSet = new HashSet();
        Iterator<Scope> it = listM36926a.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getScopeUri());
        }
        HashSet hashSet2 = new HashSet();
        Iterator<PermissionInfo> it2 = listM36931b.iterator();
        while (it2.hasNext()) {
            hashSet2.add(it2.next().getPermission());
        }
        SignInReq signInReq = new SignInReq(hashSet, hashSet2);
        this.f30079a = huaweiApiClient;
        this.f30080b = new WeakReference<>(activity);
        return new PendingResultImpl<SignInResult, SignInResp>(huaweiApiClient, CommonNaming.signin, signInReq) { // from class: com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIServiceImpl.1
            @Override // com.huawei.hms.support.api.PendingResultImpl
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SignInResult onComplete(SignInResp signInResp) {
                C5602as.m32910b("HuaweiIdAuthAPIServiceImpl", "signIn onComplete:" + signInResp.getRetCode(), true);
                HuaweiIdAuthAPIServiceImpl.this.m36927a(signInResp.getRetCode());
                Intent data = signInResp.getData();
                data.putExtra(CommonConstant.RETKEY.RETCODE, signInResp.getRetCode());
                return HuaweiIdAuthAPIServiceImpl.this.getHwIdSignInResultFromIntent(data);
            }
        };
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService
    public PendingResult<SignInResult> signInBackend(HuaweiApiClient huaweiApiClient) {
        C5602as.m32910b("HuaweiIdAuthAPIServiceImpl", "Enter signInBackend", true);
        Checker.checkNonNull(huaweiApiClient, "HuaweiApiClient must not be null.");
        this.f30079a = huaweiApiClient;
        List<Scope> listM36926a = m36926a(huaweiApiClient);
        List<PermissionInfo> listM36931b = m36931b(huaweiApiClient);
        HashSet hashSet = new HashSet();
        Iterator<Scope> it = listM36926a.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getScopeUri());
        }
        HashSet hashSet2 = new HashSet();
        Iterator<PermissionInfo> it2 = listM36931b.iterator();
        while (it2.hasNext()) {
            hashSet2.add(it2.next().getPermission());
        }
        return new PendingResultImpl<SignInResult, SignInResp>(huaweiApiClient, CommonNaming.singinbackend, new SignInReq(hashSet, hashSet2)) { // from class: com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIServiceImpl.2
            @Override // com.huawei.hms.support.api.PendingResultImpl
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SignInResult onComplete(SignInResp signInResp) {
                C5602as.m32910b("HuaweiIdAuthAPIServiceImpl", "signInBackend onComplete:" + signInResp.getRetCode(), true);
                Intent data = signInResp.getData();
                data.putExtra(CommonConstant.RETKEY.RETCODE, signInResp.getRetCode());
                return HuaweiIdAuthAPIServiceImpl.this.getHwIdSignInResultFromIntent(data);
            }
        };
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService
    public PendingResult<Status> signOut(HuaweiApiClient huaweiApiClient) {
        C5602as.m32910b("HuaweiIdAuthAPIServiceImpl", "Enter signOut", true);
        return !huaweiApiClient.isConnected() ? m36934d(huaweiApiClient) : new C6494c(huaweiApiClient, "hwid.signout", new SignOutReq());
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService
    public OptionalPendingResult<HuaweiIdAuthResult> silentSignIn(HuaweiApiClient huaweiApiClient) {
        C5602as.m32910b("HuaweiIdAuthAPIServiceImpl", "Enter silentSignIn", true);
        Checker.checkNonNull(huaweiApiClient, "HuaweiApiClient must not be null.");
        this.f30079a = huaweiApiClient;
        return new OptionalPendingResultImpl(new PendingResultImpl<HuaweiIdAuthResult, SignInResp>(huaweiApiClient, CommonNaming.singinbackend, m36933c(huaweiApiClient)) { // from class: com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIServiceImpl.3
            @Override // com.huawei.hms.support.api.PendingResultImpl
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public HuaweiIdAuthResult onComplete(SignInResp signInResp) {
                C5602as.m32910b("HuaweiIdAuthAPIServiceImpl", "signInBackend onComplete:" + signInResp.getRetCode(), true);
                Intent data = signInResp.getData();
                data.putExtra(CommonConstant.RETKEY.RETCODE, signInResp.getRetCode());
                return HuaweiIdAuthAPIServiceImpl.this.getHuaweiIdSignInResultFromIntent(data);
            }
        });
    }

    /* renamed from: b */
    public static List<PermissionInfo> m36931b(HuaweiApiClient huaweiApiClient) {
        return ((HuaweiApiClientImpl) huaweiApiClient).getPermissionInfos();
    }

    /* renamed from: a */
    public static List<Scope> m36926a(HuaweiApiClient huaweiApiClient) {
        return ((HuaweiApiClientImpl) huaweiApiClient).getScopes();
    }

    /* renamed from: b */
    private int m36929b(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    /* renamed from: a */
    private AuthHuaweiId m36925a(SafeBundle safeBundle) {
        int i10;
        if (safeBundle == null) {
            C5602as.m32910b("HuaweiIdAuthAPIServiceImpl", "bd is null", true);
            return new AuthHuaweiId();
        }
        String string = safeBundle.getString(CommonConstant.RETKEY.ACCESS_TOKEN, "");
        String string2 = safeBundle.getString(CommonConstant.RETKEY.SERVICEAUTHCODE, "");
        String string3 = safeBundle.getString(CommonConstant.RETKEY.DISPLAYNAME, "");
        String string4 = safeBundle.getString(CommonConstant.RETKEY.USERID, "");
        String string5 = safeBundle.getString(CommonConstant.RETKEY.OPENID, "");
        String string6 = safeBundle.getString(CommonConstant.RETKEY.PHOTOURL);
        String string7 = safeBundle.getString(CommonConstant.RETKEY.SERVICECOUNTRYCODE, "");
        String string8 = safeBundle.getString(CommonConstant.RETKEY.COUNTRYCODE, "");
        String string9 = safeBundle.getString(CommonConstant.RETKEY.UNIONID, "");
        int iM36923a = m36923a(safeBundle.getString(CommonConstant.RETKEY.GENDER));
        int iM36929b = m36929b(safeBundle.getString(CommonConstant.RETKEY.STATUS));
        int iM36932c = m36932c(safeBundle.getString(CommonConstant.RETKEY.HOME_ZONE));
        String string10 = safeBundle.getString(CommonConstant.RETKEY.SCOPE);
        HashSet hashSet = new HashSet();
        if (string10 != null) {
            String[] strArrSplit = string10.split(" ");
            int length = strArrSplit.length;
            i10 = iM36932c;
            int i11 = 0;
            while (i11 < length) {
                hashSet.add(new Scope(strArrSplit[i11]));
                i11++;
                length = length;
                strArrSplit = strArrSplit;
            }
        } else {
            i10 = iM36932c;
        }
        AuthHuaweiId authHuaweiIdBuild = AuthHuaweiId.build(string5, string4, string3, string6, string, string7, iM36929b, iM36923a, hashSet, string2, string9, string8);
        authHuaweiIdBuild.setIdToken(safeBundle.getString(CommonConstant.RETKEY.ID_TOKEN));
        authHuaweiIdBuild.setEmail(safeBundle.getString(CommonConstant.RETKEY.EMAIL));
        authHuaweiIdBuild.setFamilyName(safeBundle.getString(CommonConstant.RETKEY.FAMILY_NAME));
        authHuaweiIdBuild.setGivenName(safeBundle.getString(CommonConstant.RETKEY.GIVEN_NAME));
        authHuaweiIdBuild.setAgeRange(safeBundle.getString(CommonConstant.RETKEY.AGE_RANGE));
        authHuaweiIdBuild.setHomeZone(i10);
        return authHuaweiIdBuild;
    }

    /* renamed from: c */
    private SignInReq m36933c(HuaweiApiClient huaweiApiClient) {
        List<Scope> listM36926a = m36926a(huaweiApiClient);
        List<PermissionInfo> listM36931b = m36931b(huaweiApiClient);
        HashSet hashSet = new HashSet();
        Iterator<Scope> it = listM36926a.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getScopeUri());
        }
        HashSet hashSet2 = new HashSet();
        Iterator<PermissionInfo> it2 = listM36931b.iterator();
        while (it2.hasNext()) {
            hashSet2.add(it2.next().getPermission());
        }
        return new SignInReq(hashSet, hashSet2);
    }

    /* renamed from: a */
    private int m36923a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "-1";
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m36927a(int i10) {
        if (i10 == 0 && HuaweiApiAvailability.getInstance().isHuaweiMobileNoticeAvailable(this.f30079a.getContext()) == 0) {
            new Timer().schedule(new TimerTask() { // from class: com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIServiceImpl.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    ConnectService.getNotice(HuaweiIdAuthAPIServiceImpl.this.f30079a, 1, "6.12.0.300").setResultCallback(new C6492a());
                }
            }, 200L);
        }
    }
}
