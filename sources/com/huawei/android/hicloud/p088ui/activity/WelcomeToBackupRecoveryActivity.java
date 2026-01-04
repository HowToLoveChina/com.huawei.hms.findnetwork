package com.huawei.android.hicloud.p088ui.activity;

import android.accounts.OperationCanceledException;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.p073ds.R$layout;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import gp.C10028c;
import java.lang.reflect.InvocationTargetException;
import p015ak.C0209d;
import p514o9.C11839m;
import p709vj.C13452e;
import p742wj.C13612b;

/* loaded from: classes3.dex */
public class WelcomeToBackupRecoveryActivity extends WelcomeBaseActivity {

    /* renamed from: i1 */
    public String f16463i1;

    /* renamed from: j1 */
    public String f16464j1;

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: Q2 */
    public void mo20570Q2() {
        super.mo20570Q2();
        if (StringUtil.equals(this.f16463i1, "myHuawei")) {
            m22652k3("22");
        } else {
            m22652k3("6");
        }
    }

    /* renamed from: Z3 */
    public final boolean m22697Z3() {
        int iM80916g0 = C13452e.m80781L().m80916g0();
        C11839m.m70688i("WelcomeToBackupRecoveryActivity", "restoreStatus: " + iM80916g0);
        boolean z10 = m22698a4() || iM80916g0 != 3;
        if (iM80916g0 == 0 || !z10 || iM80916g0 == 8 || iM80916g0 == 5) {
            return false;
        }
        if (CBAccess.inRestoreTask()) {
            m22700c4(2, iM80916g0);
            C11839m.m70688i("WelcomeToBackupRecoveryActivity", "inRestore: " + CBAccess.inRestore());
        } else {
            if (C0209d.m1150A1(this)) {
                if (iM80916g0 == 1) {
                    C13452e.m80781L().m80914f3(7);
                } else if (iM80916g0 != 2) {
                    C13452e.m80781L().m80914f3(6);
                }
            } else if (iM80916g0 == 1) {
                C13452e.m80781L().m80914f3(7);
            }
            m22700c4(2, iM80916g0);
        }
        return true;
    }

    /* renamed from: a4 */
    public final boolean m22698a4() {
        return "restore_success".equals(this.f16464j1);
    }

    /* renamed from: b4 */
    public final void m22699b4() {
        Intent intent = new Intent(this, (Class<?>) CloudBackupRecordsActivity.class);
        if (TextUtils.isEmpty(this.f16463i1) || !"myHuawei".equals(this.f16463i1)) {
            intent.putExtra(FamilyShareConstants.ENTRY_TYPE, 2);
        } else {
            intent.putExtra("moudle", this.f16463i1);
            intent.putExtra(FamilyShareConstants.ENTRY_TYPE, 5);
        }
        startActivityForResult(intent, 1);
    }

    /* renamed from: c4 */
    public final void m22700c4(int i10, int i11) {
        Intent intent = new Intent(this, (Class<?>) RestoreMainActivity.class);
        if (!TextUtils.isEmpty(this.f16463i1)) {
            intent.putExtra("moudle", this.f16463i1);
            if ("myHuawei".equals(this.f16463i1)) {
                intent.putExtra(FamilyShareConstants.ENTRY_TYPE, 5);
            }
        }
        Bundle bundle = new Bundle();
        bundle.putInt("current_status", i10);
        bundle.putInt("restore_status", i11);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity, com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, p709vj.InterfaceC13449b
    /* renamed from: e */
    public void mo13829e(OperationCanceledException operationCanceledException) {
        super.mo13829e(operationCanceledException);
        finish();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity, com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, com.huawei.android.hicloud.p088ui.CommonActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (i10 == 1) {
            setResult(-1);
            finish();
        }
        super.onActivityResult(i10, i11, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (StringUtil.equals(this.f16463i1, "myHuawei")) {
            moveTaskToBack(true);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity, com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, com.huawei.android.hicloud.p088ui.CommonActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setContentView(R$layout.welcom_layout);
        m22651k2();
        m22645h2();
        m22599J3();
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        if (C13612b.m81829B().isLogin() && c10028cM62182c0.m62395t1("is_already_configed_NV4") && m22598J2()) {
            m22591E3();
        }
        m22594G3();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity, com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, com.huawei.android.hicloud.p088ui.CommonActivity, com.huawei.hicloud.base.p103ui.uiextend.EntrancePermissionCheckActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        C11839m.m70686d("WelcomeToBackupRecoveryActivity", "onCreate");
        if (C0209d.m1293p1()) {
            C11839m.m70688i("WelcomeToBackupRecoveryActivity", "isInkScreen return");
            finish();
            return;
        }
        m22671u1();
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(getIntent());
        C10028c.m62182c0().m62323f(hiCloudSafeIntent);
        this.f16463i1 = hiCloudSafeIntent.getStringExtra("moudle");
        this.f16464j1 = hiCloudSafeIntent.getStringExtra("renovation_status");
        if (!m22667s2()) {
            m22637b2();
            return;
        }
        if (m22598J2()) {
            C11839m.m70686d("WelcomeToBackupRecoveryActivity", "backup module disable");
            m22651k2();
            m22645h2();
            m22591E3();
            return;
        }
        if (m22697Z3()) {
            C11839m.m70688i("WelcomeToBackupRecoveryActivity", "onCreate RestoreMainActivity");
            return;
        }
        m22699b4();
        if (StringUtil.equals(this.f16463i1, "myHuawei")) {
            finish();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity, com.huawei.hicloud.base.p103ui.uiextend.EntrancePermissionCheckActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: w2 */
    public void mo22676w2() {
        if (m22598J2()) {
            m22591E3();
        } else {
            if (m22697Z3()) {
                C11839m.m70688i("WelcomeToBackupRecoveryActivity", "jumpToNextActivity RestoreMainActivity");
                return;
            }
            m22699b4();
            mo20570Q2();
            finish();
        }
    }
}
