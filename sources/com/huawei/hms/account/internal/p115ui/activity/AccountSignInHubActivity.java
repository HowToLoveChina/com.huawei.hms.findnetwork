package com.huawei.hms.account.internal.p115ui.activity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.activity.ForegroundIntentBuilder;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.common.internal.constant.AuthInternalPickerConstant;
import com.huawei.hms.hwid.C5583a;
import com.huawei.hms.hwid.C5598ao;
import com.huawei.hms.hwid.C5599ap;
import com.huawei.hms.hwid.C5601ar;
import com.huawei.hms.hwid.C5602as;
import com.huawei.hms.hwid.C5603b;
import com.huawei.hms.hwid.C5607f;
import com.huawei.hms.hwid.C5608g;
import com.huawei.hms.p148ui.SafeIntent;
import com.huawei.hms.support.account.request.AccountAuthParams;
import com.huawei.hms.support.account.result.AccountAuthResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.account.AccountSignInRequest;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.hms.support.api.entity.common.CommonNaming;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.support.picker.activity.AccountPickerSignInHubActivity;
import com.huawei.hms.utils.HMSPackageManager;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class AccountSignInHubActivity extends Activity {

    /* renamed from: e */
    private C5603b f23047e;

    /* renamed from: f */
    private int f23048f;

    /* renamed from: a */
    private String f23043a = null;

    /* renamed from: b */
    private boolean f23044b = false;

    /* renamed from: c */
    private AccountSignInRequest f23045c = null;

    /* renamed from: d */
    private AccountAuthResult f23046d = null;

    /* renamed from: g */
    private String f23049g = CommonNaming.signinIntent;

    /* renamed from: b */
    private void m30117b() {
        C5602as.m32910b("[ACCOUNTSDK]AccountSignInHubActivity", "checkMinVersion start.", true);
        C5583a.m32858a(this, new AvailableAdapter.AvailableCallBack() { // from class: com.huawei.hms.account.internal.ui.activity.AccountSignInHubActivity.1
            @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
            public void onComplete(int i10) {
                if (i10 == 0) {
                    C5602as.m32910b("[ACCOUNTSDK]AccountSignInHubActivity", "version check ok", true);
                    AccountSignInHubActivity.this.m30118c();
                } else {
                    C5602as.m32910b("[ACCOUNTSDK]AccountSignInHubActivity", "version check failed", true);
                    AccountSignInHubActivity.this.m30109a(i10);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m30118c() {
        C5602as.m32910b("[ACCOUNTSDK]AccountSignInHubActivity", "startSignInActivity", true);
        try {
            startActivityForResult(m30119d(), this.f23048f == 1 ? AccountPickerSignInHubActivity.IDENTIFIER_H5 : AccountPickerSignInHubActivity.IDENTIFIER);
        } catch (ActivityNotFoundException e10) {
            this.f23044b = true;
            C5602as.m32912d("[ACCOUNTSDK]AccountSignInHubActivity", "Launch sign in Intent failed. hms is probably being updated：" + e10.getClass().getSimpleName(), true);
            m30109a(17);
        }
    }

    /* renamed from: d */
    private Intent m30119d() throws JSONException {
        C5602as.m32910b("[ACCOUNTSDK]AccountSignInHubActivity", "getJosSignInIntent", true);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra(AuthInternalPickerConstant.SignInReqKey.HUAWEIIDCPCLIENTINFO);
        String stringExtra2 = intent.getStringExtra(AuthInternalPickerConstant.SignInReqKey.HUAWEIIDSIGNINREQUEST);
        String stringExtra3 = intent.getStringExtra("exParams");
        C5602as.m32910b("[ACCOUNTSDK]AccountSignInHubActivity", "getJosSignInIntent. exParams is null " + TextUtils.isEmpty(stringExtra3), true);
        if (!TextUtils.isEmpty(stringExtra3)) {
            try {
                JSONObject jSONObject = new JSONObject(stringExtra2);
                jSONObject.put("exParams", stringExtra3);
                stringExtra2 = jSONObject.toString();
            } catch (JSONException e10) {
                C5602as.m32910b("[ACCOUNTSDK]AccountSignInHubActivity", "getJosSignInIntent Exception " + e10.getClass().getSimpleName(), true);
            }
        }
        String action = intent.getAction();
        try {
            C5603b c5603bM32913a = C5603b.m32913a(stringExtra);
            ForegroundIntentBuilder kitSdkVersion = new ForegroundIntentBuilder(this).setAction(action).setRequestBody(stringExtra2).setKitSdkVersion(AuthInternalPickerConstant.HMS_SDK_VERSION);
            if (c5603bM32913a.m32884c() != null) {
                kitSdkVersion.setSubAppId(c5603bM32913a.m32884c());
            }
            if (this.f23048f == 1) {
                C5602as.m32910b("[ACCOUNTSDK]AccountSignInHubActivity", "setApiLevel is 11", true);
                kitSdkVersion.setApiLevel(11);
            }
            if (m30120e().booleanValue()) {
                C5602as.m32910b("[ACCOUNTSDK]AccountSignInHubActivity", "setApiLevel is 13", true);
                kitSdkVersion.setApiLevel(13);
            }
            if (m30121f()) {
                C5602as.m32910b("[ACCOUNTSDK]AccountSignInHubActivity", "setApiLevel is 22", true);
                kitSdkVersion.setApiLevel(22);
            }
            Intent intentBuild = kitSdkVersion.build();
            C5602as.m32910b("[ACCOUNTSDK]AccountSignInHubActivity", "get package name of hms is " + HMSPackageManager.getInstance(this).getHMSPackageName(), true);
            C5602as.m32910b("[ACCOUNTSDK]AccountSignInHubActivity", "current package name is " + getPackageName(), true);
            intentBuild.setPackage(getPackageName());
            return intentBuild;
        } catch (Exception e11) {
            C5602as.m32912d("[ACCOUNTSDK]AccountSignInHubActivity", "getSignInIntent failed because:" + e11.getClass().getSimpleName(), true);
            return new Intent();
        }
    }

    /* renamed from: e */
    private Boolean m30120e() {
        C5602as.m32910b("[ACCOUNTSDK]AccountSignInHubActivity", "checkCarrierIdPermission begin", true);
        AccountAuthParams accountAuthParams = this.f23045c.getAccountAuthParams();
        if (accountAuthParams == null) {
            return Boolean.FALSE;
        }
        List<PermissionInfo> permissionInfos = accountAuthParams.getPermissionInfos();
        if (C5599ap.m32901b(permissionInfos).booleanValue()) {
            Iterator<PermissionInfo> it = permissionInfos.iterator();
            while (it.hasNext()) {
                String permission = it.next().getPermission();
                if (permission != null && permission.equals(CommonConstant.LocalPermission.CARRIER_ID)) {
                    C5602as.m32910b("[ACCOUNTSDK]AccountSignInHubActivity", "permissioninfos contain carrierId", true);
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;
    }

    /* renamed from: f */
    private boolean m30121f() {
        C5602as.m32910b("[ACCOUNTSDK]AccountSignInHubActivity", "checkNeedConsent begin", true);
        AccountAuthParams accountAuthParams = this.f23045c.getAccountAuthParams();
        if (accountAuthParams == null) {
            return false;
        }
        try {
            return new JSONObject(accountAuthParams.getSignInParams()).optBoolean(CommonConstant.RequestParams.KEY_ID_NEED_CONSENT, false);
        } catch (JSONException e10) {
            C5602as.m32912d("[ACCOUNTSDK]AccountSignInHubActivity", "JSONException:" + e10.getClass().getSimpleName(), true);
            return false;
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        String stringExtra;
        int statusCode;
        C5603b c5603b;
        super.onActivityResult(i10, i11, intent);
        C5602as.m32910b("[ACCOUNTSDK]AccountSignInHubActivity", "onActivityResult: requestCode：" + i10 + " , resultCode：" + i11, true);
        SafeIntent safeIntent = intent != null ? new SafeIntent(intent) : null;
        if (this.f23044b) {
            return;
        }
        if (i10 == 16587 || i10 == 16588) {
            if (safeIntent == null || (stringExtra = intent.getStringExtra("HUAWEIID_SIGNIN_RESULT")) == null) {
                m30109a(i11 > 0 ? i11 : 8);
                return;
            }
            try {
                this.f23046d = new AccountAuthResult().fromJson(stringExtra);
                if (i10 == 16587) {
                    C5608g.m32926a().m32928a(this.f23046d.getAccount(), this.f23045c.getAccountAuthParams());
                }
                statusCode = this.f23046d.getStatus().getStatusCode();
            } catch (JSONException unused) {
                this.f23046d = null;
                C5602as.m32912d("[ACCOUNTSDK]AccountSignInHubActivity", "onActivityResult: JsonException", true);
                statusCode = 8;
            }
            String str = this.f23043a;
            if (str != null && (c5603b = this.f23047e) != null) {
                HiAnalyticsClient.reportExit(this, this.f23049g, str, c5603b.m32880a(), C5601ar.m32908a(statusCode), statusCode, (int) this.f23047e.m32882b());
            }
            setResult(i11, safeIntent);
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        C5602as.m32910b("[ACCOUNTSDK]AccountSignInHubActivity", "onCreate", true);
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (m30116a(intent)) {
            m30110a(0, "invalid intent");
            return;
        }
        SafeIntent safeIntent = new SafeIntent(intent);
        m30114a(safeIntent.getBooleanExtra("intent.extra.isfullscreen", false));
        String action = safeIntent.getAction();
        if (!TextUtils.equals("com.huawei.hms.jos.signIn", action) && !TextUtils.equals("com.huawei.hms.account.signIn", action) && !TextUtils.equals(AuthInternalPickerConstant.IntentAction.ACTION_SIGN_IN_HUB, action)) {
            String str = "unknow Action:";
            if (action != null) {
                str = "unknow Action:" + action;
            }
            m30110a(0, str);
            return;
        }
        String stringExtra = safeIntent.getStringExtra(AuthInternalPickerConstant.SignInReqKey.HUAWEIIDCPCLIENTINFO);
        try {
            this.f23045c = AccountSignInRequest.fromJson(safeIntent.getStringExtra(AuthInternalPickerConstant.SignInReqKey.HUAWEIIDSIGNINREQUEST));
        } catch (JSONException unused) {
            this.f23045c = null;
            C5602as.m32912d("[ACCOUNTSDK]AccountSignInHubActivity", "onCreate: JsonException", true);
        }
        if (TextUtils.isEmpty(stringExtra)) {
            m30110a(0, "Activity started with invalid cp client info");
            return;
        }
        try {
            this.f23047e = C5603b.m32913a(stringExtra);
        } catch (JSONException unused2) {
            this.f23047e = null;
            C5602as.m32912d("[ACCOUNTSDK]AccountSignInHubActivity", "onCreate: JsonException", true);
        }
        if (this.f23045c == null || this.f23047e == null) {
            m30110a(0, "Activity started with invalid sign in request info");
            return;
        }
        if (!m30115a()) {
            m30109a(2003);
            return;
        }
        int intExtra = safeIntent.getIntExtra("INDEPENDENT_SIGN_IN_FLAG", 0);
        this.f23048f = intExtra;
        if (intExtra == 1 && !m30108a(safeIntent).booleanValue()) {
            m30109a(2003);
            return;
        }
        C5598ao.m32896a(this);
        if (bundle != null) {
            restoreInstanceState(bundle);
        } else {
            this.f23043a = HiAnalyticsClient.reportEntry(this, this.f23049g, AuthInternalPickerConstant.HMS_SDK_VERSION);
            m30117b();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        C5602as.m32910b("[ACCOUNTSDK]AccountSignInHubActivity", "onSaveInstanceState start", true);
        String str = this.f23043a;
        if (str == null || bundle == null) {
            return;
        }
        bundle.putString("HiAnalyticsTransId", str);
    }

    public void restoreInstanceState(Bundle bundle) {
        if (bundle != null) {
            this.f23043a = bundle.getString("HiAnalyticsTransId");
        }
    }

    /* renamed from: a */
    private boolean m30115a() {
        AccountAuthParams accountAuthParams = this.f23045c.getAccountAuthParams();
        if (accountAuthParams == null) {
            return false;
        }
        try {
            int iOptInt = new JSONObject(accountAuthParams.getSignInParams()).optInt("idTokenSignAlg", 2);
            return iOptInt == 1 || iOptInt == 2;
        } catch (JSONException e10) {
            C5602as.m32912d("[ACCOUNTSDK]AccountSignInHubActivity", "JSONException:" + e10.getClass().getSimpleName(), true);
            return false;
        }
    }

    /* renamed from: a */
    private boolean m30116a(Intent intent) {
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

    /* renamed from: a */
    private void m30110a(int i10, String str) {
        C5602as.m32912d("[ACCOUNTSDK]AccountSignInHubActivity", "errMessage is: " + str, true);
        setResult(0);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m30109a(int i10) {
        C5603b c5603b;
        C5602as.m32910b("[ACCOUNTSDK]AccountSignInHubActivity", "onSignInAccountFailed: retCode：" + i10, true);
        String str = this.f23043a;
        if (str != null && (c5603b = this.f23047e) != null) {
            HiAnalyticsClient.reportExit(this, this.f23049g, str, c5603b.m32880a(), C5601ar.m32908a(i10), i10, (int) this.f23047e.m32882b());
        }
        Status status = new Status(i10);
        AccountAuthResult accountAuthResult = new AccountAuthResult();
        accountAuthResult.setStatus(status);
        Intent intent = new Intent();
        try {
            intent.putExtra("HUAWEIID_SIGNIN_RESULT", accountAuthResult.toJson());
        } catch (JSONException unused) {
            C5602as.m32912d("[ACCOUNTSDK]AccountSignInHubActivity", "convert result to json failed", true);
        }
        setResult(0, intent);
        finish();
    }

    /* renamed from: a */
    private Boolean m30108a(SafeIntent safeIntent) {
        String stringExtra = safeIntent.getStringExtra("ACCESS_TOKEN");
        AccountAuthParams accountAuthParams = this.f23045c.getAccountAuthParams();
        if (accountAuthParams == null) {
            m30113a("accountAuthParams is null");
            return Boolean.FALSE;
        }
        List<Scope> requestScopeList = accountAuthParams.getRequestScopeList();
        if (!TextUtils.isEmpty(stringExtra) && !C5599ap.m32900a(requestScopeList).booleanValue() && requestScopeList.size() == 1) {
            this.f23049g = CommonNaming.independentsigninIntent;
            return Boolean.TRUE;
        }
        m30113a("independent sign in params error");
        return Boolean.FALSE;
    }

    /* renamed from: a */
    private void m30113a(String str) {
        C5602as.m32912d("[ACCOUNTSDK]AccountSignInHubActivity", "onIndependentSignInFailed errMessage:" + str, true);
        Status status = new Status(2003, str);
        AccountAuthResult accountAuthResult = new AccountAuthResult();
        accountAuthResult.setStatus(status);
        Intent intent = new Intent();
        try {
            intent.putExtra("HUAWEIID_SIGNIN_RESULT", accountAuthResult.toJson());
        } catch (JSONException unused) {
            C5602as.m32912d("[ACCOUNTSDK]AccountSignInHubActivity", "convert result to json failed", true);
        }
        setResult(0, intent);
        finish();
    }

    /* renamed from: a */
    private void m30114a(boolean z10) {
        C5602as.m32910b("[ACCOUNTSDK]AccountSignInHubActivity", "isActivityFullScreen is :" + z10, true);
        if (z10) {
            C5607f.m32924a(getWindow());
            getWindow().setFlags(1024, 1024);
        } else {
            C5607f.m32923a(this);
        }
    }
}
