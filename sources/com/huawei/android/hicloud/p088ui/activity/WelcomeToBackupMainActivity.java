package com.huawei.android.hicloud.p088ui.activity;

import android.accounts.OperationCanceledException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.p073ds.R$layout;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import com.huawei.secure.android.common.intent.SafeIntent;
import gp.C10028c;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import mc.C11436a;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0216g0;
import p495nm.C11727h;
import p514o9.C11839m;
import p514o9.C11842p;
import p664u0.C13108a;
import p684un.C13230i;
import p709vj.C13452e;
import p742wj.C13612b;

/* loaded from: classes3.dex */
public class WelcomeToBackupMainActivity extends WelcomeBaseActivity {

    /* renamed from: i1 */
    public C3537a f16447i1 = null;

    /* renamed from: j1 */
    public String f16448j1;

    /* renamed from: k1 */
    public String f16449k1;

    /* renamed from: com.huawei.android.hicloud.ui.activity.WelcomeToBackupMainActivity$a */
    public static class C3537a extends BroadcastReceiver {

        /* renamed from: a */
        public WeakReference<WelcomeToBackupMainActivity> f16450a;

        public C3537a(WelcomeToBackupMainActivity welcomeToBackupMainActivity) {
            this.f16450a = new WeakReference<>(welcomeToBackupMainActivity);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            WeakReference<WelcomeToBackupMainActivity> weakReference;
            WelcomeToBackupMainActivity welcomeToBackupMainActivity;
            if (intent == null || !TextUtils.equals(intent.getAction(), "finish_welcome_backup_action") || (weakReference = this.f16450a) == null || (welcomeToBackupMainActivity = weakReference.get()) == null || welcomeToBackupMainActivity.isDestroyed() || welcomeToBackupMainActivity.isFinishing()) {
                return;
            }
            try {
                if ("com.huawei.hicloud.action.BACKUP_OPTIONS".equals(new SafeIntent(intent).getStringExtra("com.huawei.hicloud.action.BACKUP_OPTIONS"))) {
                    C11839m.m70688i("WelcomeToBackupMainActivity", "receiver BACKUP_OPTIONS finish msg");
                    welcomeToBackupMainActivity.finishAndRemoveTask();
                } else {
                    welcomeToBackupMainActivity.finish();
                }
                C11839m.m70688i("WelcomeToBackupMainActivity", "receiver and finish backup welcome");
            } catch (Exception e10) {
                C11839m.m70687e("WelcomeToBackupMainActivity", "finish current activity error: " + e10.toString());
            }
        }
    }

    /* renamed from: H2 */
    public final void m22687H2() {
        Intent intent = new Intent();
        intent.setClass(this, UniformGuideFrontActivity.class);
        intent.putExtra(FamilyShareConstants.OPEN_FAMILY_SPACE_SHARE, this.f16370R0);
        intent.putExtra("is_password_verify_finished", this.f16366P0);
        intent.putExtra(FamilyShareConstants.ENTRY_TYPE, 2);
        intent.putExtra("is_from_phonefinder_guide", this.f16426v);
        intent.putExtra("is_from_hwid_open_guide", m22658o2());
        startActivityForResult(intent, 10027);
        this.f16362N0 = false;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: Q2 */
    public void mo20570Q2() {
        super.mo20570Q2();
        if (StringUtil.equals(this.f16448j1, "myHuawei")) {
            m22652k3("22");
        } else {
            m22652k3("5");
        }
    }

    /* renamed from: Z3 */
    public final void m22688Z3() {
        if (StringUtil.equals(this.f16448j1, "myHuawei") && CBAccess.inRestore()) {
            C11839m.m70686d("WelcomeToBackupMainActivity", "checkNeedAbortRestoreTask");
            CloudBackupService.getInstance().abort();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ad  */
    /* renamed from: a4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m22689a4() throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.String r0 = "moduleSystemRefurbish"
            java.lang.String r1 = r9.f16448j1
            boolean r0 = r0.equals(r1)
            r1 = 0
            if (r0 == 0) goto Lb1
            r0 = 0
            com.huawei.android.hicloud.cloudbackup.util.CloudBackupStateUtil r2 = com.huawei.android.hicloud.cloudbackup.util.CloudBackupStateUtil.getInstance()     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L7a
            android.database.Cursor r2 = r2.queryBackupState(r0)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L7a
            r3 = 1
            r4 = 2
            r5 = -1
            if (r2 == 0) goto L41
            r2.moveToFirst()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3c
            java.lang.String r6 = "backupStatus"
            int r6 = r2.getColumnIndex(r6)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3c
            if (r6 == r5) goto L41
            int r6 = r2.getInt(r6)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3c
            r7 = 3
            if (r6 == r7) goto L2d
            if (r6 != r4) goto L41
        L2d:
            int r4 = com.huawei.android.p073ds.R$string.cloud_backup_running     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3c
            p514o9.C11841o.m70707c(r9, r4, r1)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3c
            r2.close()
            return r3
        L36:
            r9 = move-exception
            r8 = r2
            r2 = r0
            r0 = r8
            goto La6
        L3c:
            r3 = move-exception
            r8 = r2
            r2 = r0
            r0 = r8
            goto L7c
        L41:
            com.huawei.android.hicloud.cloudbackup.util.CloudBackupStateUtil r6 = com.huawei.android.hicloud.cloudbackup.util.CloudBackupStateUtil.getInstance()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3c
            android.database.Cursor r0 = r6.queryRestoreState(r0)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3c
            if (r0 == 0) goto L6c
            r0.moveToFirst()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3c
            java.lang.String r6 = "restoreStatus"
            int r6 = r0.getColumnIndex(r6)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3c
            if (r6 == r5) goto L6c
            int r5 = r0.getInt(r6)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3c
            if (r5 == 0) goto L5e
            if (r5 != r4) goto L6c
        L5e:
            int r4 = com.huawei.android.p073ds.R$string.cloud_backup_running     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3c
            p514o9.C11841o.m70707c(r9, r4, r1)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3c
            if (r2 == 0) goto L68
            r2.close()
        L68:
            r0.close()
            return r3
        L6c:
            if (r2 == 0) goto L71
            r2.close()
        L71:
            if (r0 == 0) goto La0
            r0.close()
            goto La0
        L77:
            r9 = move-exception
            r2 = r0
            goto La6
        L7a:
            r3 = move-exception
            r2 = r0
        L7c:
            java.lang.String r4 = "WelcomeToBackupMainActivity"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La5
            r5.<init>()     // Catch: java.lang.Throwable -> La5
            java.lang.String r6 = "checkTaskSystemRefurbishUpgrade error: "
            r5.append(r6)     // Catch: java.lang.Throwable -> La5
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> La5
            r5.append(r3)     // Catch: java.lang.Throwable -> La5
            java.lang.String r3 = r5.toString()     // Catch: java.lang.Throwable -> La5
            p514o9.C11839m.m70688i(r4, r3)     // Catch: java.lang.Throwable -> La5
            if (r0 == 0) goto L9b
            r0.close()
        L9b:
            if (r2 == 0) goto La0
            r2.close()
        La0:
            java.lang.String r0 = "myHuawei"
            r9.f16448j1 = r0
            goto Lb1
        La5:
            r9 = move-exception
        La6:
            if (r0 == 0) goto Lab
            r0.close()
        Lab:
            if (r2 == 0) goto Lb0
            r2.close()
        Lb0:
            throw r9
        Lb1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.p088ui.activity.WelcomeToBackupMainActivity.m22689a4():boolean");
    }

    /* renamed from: b4 */
    public final void m22690b4(HiCloudSafeIntent hiCloudSafeIntent) {
        ArrayList<String> stringArrayListExtra = hiCloudSafeIntent.getStringArrayListExtra("EXTRA_RESULT_UNRECOGNIZED_PKGS");
        ArrayList<String> stringArrayListExtra2 = hiCloudSafeIntent.getStringArrayListExtra("EXTRA_RESULT_UNSAFE_PKGS");
        if (stringArrayListExtra2 != null && stringArrayListExtra2.size() > 0) {
            C11727h.m69967b().m69972f(stringArrayListExtra2);
        }
        if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
            C11727h.m69967b().m69971e(stringArrayListExtra);
        }
        C11839m.m70688i("WelcomeToBackupMainActivity", "unSafePackageName: " + stringArrayListExtra2 + "  unRecognizedPackageName " + stringArrayListExtra);
    }

    /* renamed from: c4 */
    public final void m22691c4() {
        if (m22689a4()) {
            finish();
            return;
        }
        m22688Z3();
        Intent intent = new Intent(this, (Class<?>) ("com.huawei.hicloud.action.BACKUP_OPTIONS".equals(this.f16449k1) ? BackupOptionsRefurbishActivity.class : BackupMainActivity.class));
        if (!TextUtils.isEmpty(this.f16448j1)) {
            intent.putExtra("moudle", this.f16448j1);
            C10028c.m62182c0().m62328g(this.f16448j1);
        }
        C13230i.m79525e1(intent, "1", "9");
        startActivityForResult(intent, 1);
        mo20570Q2();
    }

    /* renamed from: d4 */
    public final void m22692d4() {
        this.f16447i1 = new C3537a(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("finish_welcome_backup_action");
        C13108a.m78878b(this).m78880c(this.f16447i1, intentFilter);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity, com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, p709vj.InterfaceC13449b
    /* renamed from: e */
    public void mo13829e(OperationCanceledException operationCanceledException) {
        super.mo13829e(operationCanceledException);
        finish();
    }

    /* renamed from: e4 */
    public final void m22693e4() {
        if (this.f16447i1 == null) {
            return;
        }
        try {
            C13108a.m78878b(this).m78883f(this.f16447i1);
        } catch (Exception e10) {
            C11839m.m70687e("WelcomeToBackupMainActivity", "unreisterRevoler error: " + e10.toString());
        }
        this.f16447i1 = null;
    }

    @Override // android.app.Activity
    public void finishAndRemoveTask() {
        try {
            super.finishAndRemoveTask();
        } catch (Exception unused) {
            C11839m.m70687e("WelcomeToBackupMainActivity", "finishAndRemoveTask activity exception , activity :" + getClass().getName());
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity, com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, com.huawei.android.hicloud.p088ui.CommonActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C11839m.m70688i("WelcomeToBackupMainActivity", "onActivityResult, requestCode: " + i10);
        if (i10 == 1) {
            setResult(-1);
            finish();
        } else if (i10 == 10027) {
            if (i11 == -1) {
                this.f16378V0 = new SafeIntent(intent).getBundleExtra("tempKeyBundle");
            }
            m22622T3(6);
            m22691c4();
        } else if (i10 == 2) {
            setResult(-1);
            if ("moduleSystemRefurbish".equals(new SafeIntent(intent).getStringExtra("moduleSystemRefurbish"))) {
                finishAndRemoveTask();
            } else {
                finish();
            }
        }
        super.onActivityResult(i10, i11, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (StringUtil.equals(this.f16448j1, "myHuawei")) {
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
        C0216g0.m1402e(this).m1417O();
        C11839m.m70686d("WelcomeToBackupMainActivity", "onCreate");
        if (C0209d.m1293p1()) {
            C11839m.m70688i("WelcomeToBackupMainActivity", "isInkScreen return");
            finish();
            return;
        }
        m22671u1();
        m22692d4();
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(getIntent());
        this.f16448j1 = hiCloudSafeIntent.getStringExtra("moudle");
        this.f16449k1 = hiCloudSafeIntent.getAction();
        m22690b4(hiCloudSafeIntent);
        if (C13452e.m80781L().m80912f1()) {
            C11839m.m70687e("WelcomeToBackupMainActivity", "site not match");
            C11436a.m68492d().m68499h(this);
            finish();
            return;
        }
        if (!m22667s2()) {
            m22637b2();
            return;
        }
        if (m22598J2()) {
            C11839m.m70686d("WelcomeToBackupMainActivity", "backup module disable");
            m22651k2();
            m22645h2();
            m22591E3();
            return;
        }
        if ("moduleSystemRefurbish".equals(this.f16448j1) && mo20573v2() && !C10028c.m62182c0().m62388s("backup_key")) {
            C11839m.m70688i("WelcomeToBackupMainActivity", "navToSwitchConfirmPage");
            m22687H2();
            return;
        }
        if (m22689a4()) {
            finish();
            return;
        }
        m22688Z3();
        Intent intent = new Intent(this, (Class<?>) ("com.huawei.hicloud.action.BACKUP_OPTIONS".equals(this.f16449k1) ? BackupOptionsRefurbishActivity.class : BackupMainActivity.class));
        if (!TextUtils.isEmpty(this.f16448j1)) {
            intent.putExtra("moudle", this.f16448j1);
            C10028c.m62182c0().m62328g(this.f16448j1);
        }
        intent.putExtras(new Bundle());
        C13230i.m79525e1(intent, "1", "9");
        intent.putExtra("from_welcome_backup", true);
        startActivityForResult(intent, 2);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity, com.huawei.hicloud.base.p103ui.uiextend.EntrancePermissionCheckActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        m22693e4();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: v2 */
    public boolean mo20573v2() {
        if (C13452e.m80781L().m80803F0().booleanValue() && !C0209d.m1173G1(C0213f.m1377a()) && C0209d.m1166E1() && !C2783d.m16099O()) {
            C11839m.m70688i("WelcomeToBackupMainActivity", "match region");
            return true;
        }
        if (super.mo20573v2()) {
            C11839m.m70688i("WelcomeToBackupMainActivity", "showswitch false");
            return false;
        }
        C11839m.m70688i("WelcomeToBackupMainActivity", "super showswitch false");
        return false;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: w2 */
    public void mo22676w2() {
        if (!StringUtil.equals(this.f16448j1, "myHuawei")) {
            m22663q3();
            m22616R3(C10028c.m62182c0().m62403v("backup_key", false));
        }
        if (m22598J2()) {
            m22591E3();
        } else if (!StringUtil.equals(this.f16448j1, "myHuawei") || !mo20573v2()) {
            m22691c4();
        } else {
            C11839m.m70688i("WelcomeToBackupMainActivity", "navToSwitchConfirmPage");
            m22687H2();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: x3 */
    public void mo20574x3() {
        if (this.f16420s.getVisibility() == 0) {
            C11842p.m70827j2(this.f16420s, this.f13504j + this.f13505k);
        }
    }
}
