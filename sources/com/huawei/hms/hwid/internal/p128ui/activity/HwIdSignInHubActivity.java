package com.huawei.hms.hwid.internal.p128ui.activity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.activity.ForegroundIntentBuilder;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.common.internal.constant.AuthInternalPickerConstant;
import com.huawei.hms.hwid.C5598ao;
import com.huawei.hms.hwid.C5601ar;
import com.huawei.hms.hwid.C5602as;
import com.huawei.hms.hwid.C5607f;
import com.huawei.hms.hwid.C5619q;
import com.huawei.hms.hwid.C5621s;
import com.huawei.hms.hwid.C5627y;
import com.huawei.hms.p148ui.SafeIntent;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.common.CommonNaming;
import com.huawei.hms.support.api.entity.hwid.HuaweiIdSignInRequest;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.support.hwid.result.HuaweiIdAuthResult;
import com.huawei.hms.support.picker.activity.AccountPickerSignInHubActivity;
import com.huawei.hms.utils.HMSPackageManager;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class HwIdSignInHubActivity extends Activity {

    /* renamed from: a */
    private String f25361a = null;

    /* renamed from: b */
    private boolean f25362b = false;

    /* renamed from: c */
    private HuaweiIdSignInRequest f25363c = null;

    /* renamed from: d */
    private HuaweiIdAuthResult f25364d = null;

    /* renamed from: e */
    private C5621s f25365e;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m32940b() {
        C5602as.m32910b("[HUAWEIIDSDK]HwIdSignInClientHub", "startSignInActivity", true);
        try {
            startActivityForResult(m32941c(), AccountPickerSignInHubActivity.IDENTIFIER);
        } catch (ActivityNotFoundException e10) {
            this.f25362b = true;
            C5602as.m32912d("[HUAWEIIDSDK]HwIdSignInClientHub", "Launch sign in Intent failed. hms is probably being updated：" + e10.getClass().getSimpleName(), true);
            m32935a(17);
        }
    }

    /* renamed from: c */
    private Intent m32941c() throws JSONException {
        C5602as.m32910b("[HUAWEIIDSDK]HwIdSignInClientHub", "getJosSignInIntent", true);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra(AuthInternalPickerConstant.SignInReqKey.HUAWEIIDCPCLIENTINFO);
        String stringExtra2 = intent.getStringExtra(AuthInternalPickerConstant.SignInReqKey.HUAWEIIDSIGNINREQUEST);
        String stringExtra3 = intent.getStringExtra("exParams");
        C5602as.m32910b("[HUAWEIIDSDK]HwIdSignInClientHub", "getJosSignInIntent. exParams is null " + TextUtils.isEmpty(stringExtra3), true);
        if (!TextUtils.isEmpty(stringExtra3)) {
            try {
                JSONObject jSONObject = new JSONObject(stringExtra2);
                jSONObject.put("exParams", stringExtra3);
                stringExtra2 = jSONObject.toString();
            } catch (JSONException e10) {
                C5602as.m32910b("[HUAWEIIDSDK]HwIdSignInClientHub", "getJosSignInIntent Exception " + e10.getClass().getSimpleName(), true);
            }
        }
        String action = intent.getAction();
        try {
            C5621s c5621sM32957a = C5621s.m32957a(stringExtra);
            ForegroundIntentBuilder kitSdkVersion = new ForegroundIntentBuilder(this).setAction(action).setRequestBody(stringExtra2).setKitSdkVersion(AuthInternalPickerConstant.HMS_SDK_VERSION);
            if (c5621sM32957a.m32884c() != null) {
                kitSdkVersion.setSubAppId(c5621sM32957a.m32884c());
            }
            Intent intentBuild = kitSdkVersion.build();
            C5602as.m32910b("[HUAWEIIDSDK]HwIdSignInClientHub", "get package name of hms is " + HMSPackageManager.getInstance(this).getHMSPackageName(), true);
            C5602as.m32910b("[HUAWEIIDSDK]HwIdSignInClientHub", "Current package name is " + getPackageName(), true);
            intentBuild.setPackage(getPackageName());
            return intentBuild;
        } catch (Exception e11) {
            C5602as.m32912d("[HUAWEIIDSDK]HwIdSignInClientHub", "getSignInIntent failed because:" + e11.getClass().getSimpleName(), true);
            return new Intent();
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        String stringExtra;
        C5621s c5621s;
        super.onActivityResult(i10, i11, intent);
        C5602as.m32910b("[HUAWEIIDSDK]HwIdSignInClientHub", "onActivityResult: requestCode：" + i10 + " , resultCode：" + i11, true);
        SafeIntent safeIntent = intent != null ? new SafeIntent(intent) : null;
        if (this.f25362b || i10 != 16587) {
            return;
        }
        int statusCode = 8;
        if (safeIntent == null || (stringExtra = intent.getStringExtra("HUAWEIID_SIGNIN_RESULT")) == null) {
            if (i11 <= 0) {
                i11 = 8;
            }
            m32935a(i11);
            return;
        }
        try {
            this.f25364d = new HuaweiIdAuthResult().fromJson(stringExtra);
            C5627y.m32967a().m32969a(this.f25364d.getHuaweiId(), this.f25363c.getHuaweiIdAuthParams());
            statusCode = this.f25364d.getStatus().getStatusCode();
        } catch (JSONException unused) {
            this.f25364d = null;
            C5602as.m32912d("[HUAWEIIDSDK]HwIdSignInClientHub", "onActivityResult: JsonException", true);
        }
        int i12 = statusCode;
        String str = this.f25361a;
        if (str != null && (c5621s = this.f25365e) != null) {
            HiAnalyticsClient.reportExit(this, CommonNaming.signinIntent, str, c5621s.m32880a(), C5601ar.m32908a(i12), i12, (int) this.f25365e.m32882b());
            C5602as.m32910b("[HUAWEIIDSDK]HwIdSignInClientHub", "report: api=hwid.signinintentversion=" + this.f25365e.m32882b(), true);
        }
        setResult(i11, safeIntent);
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        C5602as.m32910b("[HUAWEIIDSDK]HwIdSignInClientHub", "onCreate", true);
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (m32939a(intent)) {
            m32936a(0, "invalid intent");
            return;
        }
        SafeIntent safeIntent = new SafeIntent(intent);
        boolean booleanExtra = safeIntent.getBooleanExtra("intent.extra.isfullscreen", false);
        C5602as.m32910b("[HUAWEIIDSDK]HwIdSignInClientHub", "isActivityFullScreen is :" + booleanExtra, true);
        if (booleanExtra) {
            C5607f.m32924a(getWindow());
            getWindow().setFlags(1024, 1024);
        } else {
            C5607f.m32923a(this);
        }
        String action = safeIntent.getAction();
        if (!TextUtils.equals("com.huawei.hms.jos.signIn", action)) {
            String str = "unknow Action:";
            if (action != null) {
                str = "unknow Action:" + action;
            }
            m32936a(0, str);
            return;
        }
        String stringExtra = safeIntent.getStringExtra(AuthInternalPickerConstant.SignInReqKey.HUAWEIIDCPCLIENTINFO);
        try {
            this.f25363c = HuaweiIdSignInRequest.fromJson(safeIntent.getStringExtra(AuthInternalPickerConstant.SignInReqKey.HUAWEIIDSIGNINREQUEST));
        } catch (JSONException unused) {
            this.f25363c = null;
            C5602as.m32912d("[HUAWEIIDSDK]HwIdSignInClientHub", "onCreate: JsonException", true);
        }
        if (TextUtils.isEmpty(stringExtra)) {
            m32936a(0, "Activity started with invalid cp client info");
            return;
        }
        try {
            this.f25365e = C5621s.m32957a(stringExtra);
        } catch (JSONException unused2) {
            this.f25365e = null;
            C5602as.m32912d("[HUAWEIIDSDK]HwIdSignInClientHub", "onCreate: JsonException", true);
        }
        if (this.f25363c == null || this.f25365e == null) {
            m32936a(0, "Activity started with invalid sign in request info");
            return;
        }
        C5598ao.m32896a(this);
        if (bundle != null) {
            restoreInstanceState(bundle);
        } else {
            this.f25361a = HiAnalyticsClient.reportEntry(this, CommonNaming.signinIntent, AuthInternalPickerConstant.HMS_SDK_VERSION);
            m32934a();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        String str = this.f25361a;
        if (str == null || bundle == null) {
            return;
        }
        bundle.putString("HiAnalyticsTransId", str);
    }

    public void restoreInstanceState(Bundle bundle) {
        if (bundle != null) {
            this.f25361a = bundle.getString("HiAnalyticsTransId");
        }
    }

    /* renamed from: a */
    private boolean m32939a(Intent intent) {
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
    private void m32936a(int i10, String str) {
        C5602as.m32912d("[HUAWEIIDSDK]HwIdSignInClientHub", str, true);
        setResult(0);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m32935a(int i10) {
        C5621s c5621s;
        C5602as.m32910b("[HUAWEIIDSDK]HwIdSignInClientHub", "onSignInAccountFailed: retCode：" + i10, true);
        String str = this.f25361a;
        if (str != null && (c5621s = this.f25365e) != null) {
            HiAnalyticsClient.reportExit(this, CommonNaming.signinIntent, str, c5621s.m32880a(), C5601ar.m32908a(i10), i10, (int) this.f25365e.m32882b());
            C5602as.m32910b("[HUAWEIIDSDK]HwIdSignInClientHub", "report: api=hwid.signinintentversion=" + this.f25365e.m32882b(), true);
        }
        Status status = new Status(i10);
        HuaweiIdAuthResult huaweiIdAuthResult = new HuaweiIdAuthResult();
        huaweiIdAuthResult.setStatus(status);
        Intent intent = new Intent();
        try {
            intent.putExtra("HUAWEIID_SIGNIN_RESULT", huaweiIdAuthResult.toJson());
        } catch (JSONException unused) {
            C5602as.m32912d("[HUAWEIIDSDK]HwIdSignInClientHub", "convert result to json failed", true);
        }
        setResult(0, intent);
        finish();
    }

    /* renamed from: a */
    private void m32934a() {
        C5602as.m32910b("[HUAWEIIDSDK]HwIdSignInClientHub", "checkMinVersion start.", true);
        C5619q.m32954a(this, new AvailableAdapter.AvailableCallBack() { // from class: com.huawei.hms.hwid.internal.ui.activity.HwIdSignInHubActivity.1
            @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
            public void onComplete(int i10) {
                if (i10 == 0) {
                    C5602as.m32910b("[HUAWEIIDSDK]HwIdSignInClientHub", "version check ok", true);
                    HwIdSignInHubActivity.this.m32940b();
                } else {
                    C5602as.m32910b("[HUAWEIIDSDK]HwIdSignInClientHub", "version check failed", true);
                    HwIdSignInHubActivity.this.m32935a(i10);
                }
            }
        });
    }
}
