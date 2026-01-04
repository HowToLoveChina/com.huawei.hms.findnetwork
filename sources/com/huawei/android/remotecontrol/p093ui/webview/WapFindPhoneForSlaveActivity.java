package com.huawei.android.remotecontrol.p093ui.webview;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.remotecontrol.p093ui.BaseActivity;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.picker.AccountPickerManager;
import com.huawei.hms.support.picker.result.AuthAccountPicker;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.util.function.Consumer;
import ng.C11697d;
import p521og.C11868a;
import p575qe.C12347f;
import p739wg.C13605a;
import p809yg.C13981a;
import sg.C12797b;

/* loaded from: classes4.dex */
public class WapFindPhoneForSlaveActivity extends BaseActivity {
    /* renamed from: Q1 */
    private boolean m27966Q1() {
        String callingPackage = getCallingPackage();
        if (TextUtils.isEmpty(callingPackage)) {
            C13981a.m83988e("WapFindPhoneForSlaveActivity", "calling pkg name empty");
            return false;
        }
        if (!"com.huawei.android.findmyphone".equals(callingPackage) && !getPackageName().equals(callingPackage)) {
            C13981a.m83988e("WapFindPhoneForSlaveActivity", "calling pkg not from slave");
        } else {
            if (C13605a.m81797e(this, callingPackage)) {
                C13981a.m83989i("WapFindPhoneForSlaveActivity", "from slave");
                return true;
            }
            C13981a.m83988e("WapFindPhoneForSlaveActivity", "slave sign not match");
        }
        return false;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: D1 */
    public void mo20612D1() {
    }

    /* renamed from: R1 */
    public final void m27967R1(String str, boolean z10) {
        C13981a.m83989i("WapFindPhoneForSlaveActivity", "jumpToWapFindPhone isSys =" + z10);
        C11868a.m71128d().m71130b(WapFindPhoneActivity.class);
        SafeIntent safeIntent = new SafeIntent(getIntent());
        String stringExtra = safeIntent.getStringExtra(RemoteMessageConst.FROM);
        boolean booleanExtra = safeIntent.getBooleanExtra("isEnableJs", false);
        boolean booleanExtra2 = safeIntent.getBooleanExtra("needShowLoading", false);
        boolean booleanExtra3 = safeIntent.getBooleanExtra("isAddShare", false);
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(this, (Class<?>) WapFindPhoneActivity.class));
            intent.putExtra(RemoteMessageConst.FROM, stringExtra);
            intent.putExtra("isEnableJs", booleanExtra);
            intent.putExtra("isSystemAcc", z10);
            intent.putExtra("needShowLoading", booleanExtra2);
            intent.putExtra("isAddShare", booleanExtra3);
            intent.putExtra("authCode", str);
            startActivity(intent);
            finish();
        } catch (Exception unused) {
            C13981a.m83988e("WapFindPhoneForSlaveActivity", "startActivity exception");
            finish();
        }
    }

    /* renamed from: S1 */
    public final /* synthetic */ void m27968S1(boolean z10, boolean z11, String str) {
        if (!TextUtils.isEmpty(str)) {
            C13981a.m83989i("WapFindPhoneForSlaveActivity", "sign in auth not empty");
            m27967R1(str, z10);
        } else {
            C13981a.m83989i("WapFindPhoneForSlaveActivity", "picker Sdk Login");
            if (C11697d.m69760e().m69766j(this, z11)) {
                return;
            }
            m27967R1(str, z10);
        }
    }

    /* renamed from: T1 */
    public final void m27969T1(final boolean z10, final boolean z11) {
        C11697d.m69760e().m69767k(new Consumer() { // from class: jg.s1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f51701a.m27968S1(z11, z10, (String) obj);
            }
        });
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HMSTermsProcessBaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        int statusCode;
        super.onActivityResult(i10, i11, intent);
        if (i10 == 8911) {
            Task<AuthAccountPicker> authResultFromIntent = AccountPickerManager.parseAuthResultFromIntent(intent);
            if (authResultFromIntent.isSuccessful()) {
                AuthAccountPicker result = authResultFromIntent.getResult();
                String authorizationCode = result.getAuthorizationCode();
                statusCode = 0;
                boolean z10 = result.getAccountAttr() == 0;
                C13981a.m83989i("WapFindPhoneForSlaveActivity", "accountAttr is system:" + z10);
                m27967R1(authorizationCode, z10);
            } else {
                finish();
                statusCode = ((ApiException) authResultFromIntent.getException()).getStatusCode();
                C13981a.m83988e("WapFindPhoneForSlaveActivity", "sign in failed : " + statusCode);
            }
            int i12 = statusCode;
            new C12797b().m76782h(C12347f.m74285n().m74301m(), "WapFindPhoneForSlaveActivity", String.valueOf(i12), i12, "picker login result", "001_3017", null, null, "picker login", true);
        }
    }

    @Override // com.huawei.android.remotecontrol.p093ui.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C13981a.m83989i("WapFindPhoneForSlaveActivity", "onCreate");
        if (!m27966Q1()) {
            C13981a.m83989i("WapFindPhoneForSlaveActivity", "check permission false, finish");
            finish();
            return;
        }
        SafeIntent safeIntent = new SafeIntent(getIntent());
        try {
            boolean booleanExtra = safeIntent.getBooleanExtra("isSupportPicker", false);
            C13981a.m83989i("WapFindPhoneForSlaveActivity", " isSupportPicker:" + booleanExtra);
            if (booleanExtra) {
                m27969T1(safeIntent.getBooleanExtra("isAutoLogin", false), safeIntent.getBooleanExtra("isSystemAcc", true));
            } else {
                m27967R1("", safeIntent.getBooleanExtra("isSystemAcc", false));
            }
        } catch (Throwable th2) {
            C13981a.m83989i("WapFindPhoneForSlaveActivity", "catch intent error:" + th2.getMessage());
            finish();
        }
    }

    @Override // com.huawei.android.remotecontrol.p093ui.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C13981a.m83989i("WapFindPhoneForSlaveActivity", "onDestroy");
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        C13981a.m83989i("WapFindPhoneForSlaveActivity", "onPause");
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        C13981a.m83989i("WapFindPhoneForSlaveActivity", "onResume");
    }
}
