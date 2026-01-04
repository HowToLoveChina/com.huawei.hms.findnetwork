package com.huawei.android.hicloud.p088ui.activity;

import android.accounts.OperationCanceledException;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.View;
import com.huawei.android.hicloud.p088ui.extend.AutoStyleButtonAnnotation;
import com.huawei.android.hicloud.sync.syncutil.C2987p;
import com.huawei.android.p073ds.R$layout;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.secure.android.common.intent.SafeIntent;
import ge.C9908c;
import gp.C10028c;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import mc.C11436a;
import p015ak.C0209d;
import p015ak.C0239x;
import p252e9.C9438o;
import p284fb.C9681b;
import p364ib.C10465b;
import p514o9.C11839m;
import p514o9.C11842p;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import p742wj.C13612b;
import p837z9.C14163d;

@AutoStyleButtonAnnotation
/* loaded from: classes3.dex */
public class HisyncExternalActivity extends WelcomeBaseActivity {

    /* renamed from: i1 */
    public String f15001i1;

    /* renamed from: j1 */
    public String f15002j1;

    /* renamed from: l1 */
    public boolean f15004l1;

    /* renamed from: k1 */
    public boolean f15003k1 = false;

    /* renamed from: m1 */
    public String f15005m1 = "12";

    public static class ExternalFinishResultReceiver extends ResultReceiver {

        /* renamed from: a */
        public final Handler f15006a;

        public ExternalFinishResultReceiver(WeakReference<Handler> weakReference) {
            super(weakReference.get());
            this.f15006a = weakReference.get();
        }

        @Override // android.os.ResultReceiver
        public void onReceiveResult(int i10, Bundle bundle) {
            if (this.f15006a == null) {
                C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_EXTERNAL_ACTIVITY, "mHandler is null");
            } else if (1 == i10) {
                C11839m.m70686d(NotifyConstants.ActivityName.HISYNC_EXTERNAL_ACTIVITY, "hisyncexternalactivity finish");
                this.f15006a.sendEmptyMessage(9);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.HisyncExternalActivity$a */
    public class RunnableC3323a implements Runnable {
        public RunnableC3323a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HisyncExternalActivity.this.finish();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: G2 */
    public void mo20680G2() {
        if (NavigationUtils.SMS_SCHEMA_PREF.equals(this.f15001i1)) {
            m20686b4();
            return;
        }
        if ("spaceShare".equals(this.f15001i1)) {
            mo18552e4();
        } else if (!C9438o.m59204a().m59205b() || m22658o2()) {
            m20689d4();
        } else {
            m20696l4(1);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: I2 */
    public boolean mo20681I2() {
        if ("dbank".equals(this.f15001i1) && "LoginByShareActivity".equals(this.f15002j1)) {
            return true;
        }
        if (!this.f16336A0 || !this.f16429w0) {
            return false;
        }
        m20694j4(this.f16431x0, this.f16433y0);
        return true;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: M1 */
    public void mo20569M1() {
        super.mo20569M1();
        C11839m.m70686d(NotifyConstants.ActivityName.HISYNC_EXTERNAL_ACTIVITY, "finish self");
        mo20698r3();
        finish();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: O2 */
    public void mo20682O2() {
        super.mo20682O2();
        if (C13452e.m80781L().m80803F0().booleanValue()) {
            if (this.f16434z == 5) {
                C9681b.m60470l().m60477G(FamilyShareConstants.Report.CLICK_SPACE_SHARE_ENABLE_NOTICE);
            }
            C9908c.m61499D().m61548i0(getApplicationContext());
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: Q2 */
    public void mo20570Q2() {
        super.mo20570Q2();
        m22652k3(this.f15005m1);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: W3 */
    public void mo20683W3() {
        super.mo20683W3();
        C9908c.m61499D().m61548i0(getApplicationContext());
    }

    /* renamed from: Z3 */
    public final void m20684Z3() {
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(getIntent());
        try {
            this.f15001i1 = hiCloudSafeIntent.getStringExtra(FaqConstants.FAQ_MODULE);
            this.f16429w0 = hiCloudSafeIntent.getBooleanExtra("auto_upload", false);
            this.f16431x0 = hiCloudSafeIntent.getIntExtra("auto_upload_triggerPage", -1);
            this.f16433y0 = hiCloudSafeIntent.getStringExtra("auto_upload_appId");
            this.f16435z0 = hiCloudSafeIntent.getBooleanExtra("file_clean_gallery", false);
            this.f16336A0 = StringUtil.equals("dbank", this.f15001i1);
            this.f16338B0 = hiCloudSafeIntent.getBooleanExtra("file_to_release_space", false);
            this.f16340C0 = hiCloudSafeIntent.getIntExtra(FamilyShareConstants.EXTRA_KEY, -1);
            this.f16434z = hiCloudSafeIntent.getIntExtra(FamilyShareConstants.ENTRY_TYPE, 1);
            this.f15004l1 = hiCloudSafeIntent.getBooleanExtra("channel_from_otherApp_login", false);
            this.f15002j1 = hiCloudSafeIntent.getStringExtra("filemanager_enter_loginTag");
        } catch (RuntimeException unused) {
            C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_EXTERNAL_ACTIVITY, "intent Serializable error.");
        }
        if (NavigationUtils.SMS_SCHEMA_PREF.equals(this.f15001i1)) {
            this.f16425u0 = "12";
            this.f15005m1 = "11";
        } else if ("notepad".equals(this.f15001i1)) {
            this.f16425u0 = "10";
            this.f15005m1 = "9";
        } else if ("calendar".equals(this.f15001i1)) {
            this.f16425u0 = "11";
            this.f15005m1 = "10";
        } else if ("dbank".equals(this.f15001i1)) {
            this.f15005m1 = "7";
            C0239x.m1671c().m1677g("0005");
        } else {
            boolean zM22658o2 = m22658o2();
            C11839m.m70686d(NotifyConstants.ActivityName.HISYNC_EXTERNAL_ACTIVITY, "fromHwidOpenGuide: " + zM22658o2);
            if (zM22658o2) {
                this.f15005m1 = "17";
            }
        }
        if (this.f16434z == 5 && !C13452e.m80781L().m80803F0().booleanValue()) {
            C9681b.m60470l().m60477G(FamilyShareConstants.Report.CLICK_SPACE_SHARE_ENABLE_NOTICE);
        }
        if (this.f15004l1) {
            this.f15005m1 = "19";
        }
        if (C10028c.m62182c0().m62325f1()) {
            this.f15005m1 = "22";
        }
    }

    /* renamed from: a4 */
    public final boolean m20685a4(String str) {
        C10028c c10028cM62183d0 = C10028c.m62183d0(this);
        if ("notepad".equals(str)) {
            return c10028cM62183d0.m62395t1("funcfg_notes");
        }
        return true;
    }

    /* renamed from: b4 */
    public final void m20686b4() {
        Intent intent = new Intent();
        intent.setClass(this, BackupMainActivity.class);
        m20688c4(intent);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: c3 */
    public void mo20687c3(int i10, Intent intent) {
        C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_EXTERNAL_ACTIVITY, "processUpGuideResult resultCode = " + i10);
        if (intent == null) {
            C11839m.m70687e(NotifyConstants.ActivityName.HISYNC_EXTERNAL_ACTIVITY, "processUpGuideResult error, intent is null");
            finish();
            return;
        }
        int intExtra = new SafeIntent(intent).getIntExtra("navigation_dest", 0);
        C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_EXTERNAL_ACTIVITY, "dest is " + intExtra);
        if (intExtra == 1) {
            if (i10 == -1) {
                m20689d4();
                return;
            } else {
                finish();
                return;
            }
        }
        if (intExtra != 2) {
            C11839m.m70687e(NotifyConstants.ActivityName.HISYNC_EXTERNAL_ACTIVITY, "UpGuideActivity result, but dest is 0");
        } else if (i10 == -1) {
            m20690f4();
        } else {
            finish();
        }
    }

    /* renamed from: c4 */
    public final void m20688c4(Intent intent) {
        if (intent == null) {
            C11839m.m70687e(NotifyConstants.ActivityName.HISYNC_EXTERNAL_ACTIVITY, "move to intent error, intent is null");
            return;
        }
        C13230i.m79525e1(intent, "1", this.f16425u0);
        intent.putExtra("external_finisher", this.f16411n0);
        startActivity(intent);
        finish();
    }

    /* renamed from: d4 */
    public final void m20689d4() {
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        intent.putExtra("file_clean_gallery", this.f16435z0);
        intent.putExtra("file_to_release_space", this.f16338B0);
        m20688c4(intent);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity, com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, p709vj.InterfaceC13449b
    /* renamed from: e */
    public void mo13829e(OperationCanceledException operationCanceledException) {
        super.mo13829e(operationCanceledException);
        this.f16402h1.postDelayed(new RunnableC3323a(), 200L);
    }

    /* renamed from: e4 */
    public void mo18552e4() {
    }

    /* renamed from: f4 */
    public final void m20690f4() {
        m22651k2();
        m22645h2();
        if (this.f15003k1) {
            m22591E3();
            return;
        }
        if (this.f16344E0) {
            C11839m.m70686d(NotifyConstants.ActivityName.HISYNC_EXTERNAL_ACTIVITY, "logout is processing");
            m22593F3();
        } else {
            m29130D0();
        }
        m22642f2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, android.app.Activity
    public void finish() {
        super.finish();
        mo20698r3();
    }

    /* renamed from: g4 */
    public void m20691g4(int i10, String str) {
        C11839m.m70689w(NotifyConstants.ActivityName.HISYNC_EXTERNAL_ACTIVITY, "onErrorAndFinish, errorCode: " + i10 + ", errorDesc: " + str);
        setResult(1, C10465b.m64291a(i10, str));
        finish();
    }

    /* renamed from: h4 */
    public final void m20692h4() {
        if (C13452e.m80781L().m80912f1()) {
            C11839m.m70687e(NotifyConstants.ActivityName.HISYNC_EXTERNAL_ACTIVITY, "site not match");
            C11436a.m68492d().m68499h(this);
            finish();
            return;
        }
        C0239x.m1671c().m1677g("0006");
        if (C0209d.m1173G1(this)) {
            C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_EXTERNAL_ACTIVITY, "isPrivacyUser, now exit Cloud!");
            m22602L3();
            return;
        }
        if (C2987p.m17951a(this)) {
            C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_EXTERNAL_ACTIVITY, "checkSyncRisk, effective");
            return;
        }
        this.f16432y = 4;
        this.f16411n0 = new ExternalFinishResultReceiver(new WeakReference(this.f16402h1));
        C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_EXTERNAL_ACTIVITY, "HisyncExternalActivity + moduleName is " + this.f15001i1);
        m22671u1();
        m20697m4();
        boolean zM62395t1 = C10028c.m62182c0().m62395t1("is_all_guide_over");
        boolean zM22667s2 = m22667s2();
        C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_EXTERNAL_ACTIVITY, "isJumptoNext=" + zM22667s2 + ",IS_ALL_GUIDE_OVER=" + zM62395t1);
        if (zM22667s2 && zM62395t1) {
            if (m20685a4(this.f15001i1)) {
                if (!C14163d.m84990g().m85009o()) {
                    mo20680G2();
                    return;
                }
                Intent intent = new Intent(this, (Class<?>) DataMigrationAuthActivity.class);
                intent.putExtra("jump_where", "nav_module");
                startActivityForResult(intent, 10023);
                return;
            }
            this.f15003k1 = true;
        }
        mo20695k4();
        if (!C9438o.m59204a().m59205b() || m22658o2()) {
            m20690f4();
        } else {
            m20696l4(2);
        }
    }

    /* renamed from: i4 */
    public final void m20693i4() {
        if (C13452e.m80781L().m80912f1()) {
            C11839m.m70687e(NotifyConstants.ActivityName.HISYNC_EXTERNAL_ACTIVITY, "site not match");
            m20691g4(2, FamilyShareConstants.OpenCloudShareResultInfo.DESC_SITE_STATUS_ERROR);
            return;
        }
        C0239x.m1671c().m1677g("0006");
        if (C0209d.m1173G1(this)) {
            C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_EXTERNAL_ACTIVITY, "isPrivacyUser, now exit Cloud!");
            m20691g4(3, FamilyShareConstants.OpenCloudShareResultInfo.DESC_PRIVACY_USER);
            return;
        }
        if (C2987p.m17951a(this)) {
            C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_EXTERNAL_ACTIVITY, "checkSyncRisk, effective");
            m20691g4(4, FamilyShareConstants.OpenCloudShareResultInfo.DESC_SYNC_RISK);
            return;
        }
        this.f16432y = 4;
        this.f16411n0 = new ExternalFinishResultReceiver(new WeakReference(this.f16402h1));
        C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_EXTERNAL_ACTIVITY, "HisyncExternalActivity + moduleName is " + this.f15001i1);
        m22671u1();
        m20697m4();
        boolean zM62395t1 = C10028c.m62182c0().m62395t1("is_all_guide_over");
        boolean zM22667s2 = m22667s2();
        C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_EXTERNAL_ACTIVITY, "isJumptoNext=" + zM22667s2 + ",IS_ALL_GUIDE_OVER=" + zM62395t1);
        if (!zM22667s2 || !zM62395t1) {
            m20691g4(1, FamilyShareConstants.OpenCloudShareResultInfo.DESC_CLOUD_NOT_OPEN);
            return;
        }
        if (!m20685a4(this.f15001i1)) {
            m20691g4(5, FamilyShareConstants.OpenCloudShareResultInfo.DESC_MODULE_NOT_SUPPORT);
            this.f15003k1 = true;
        } else if (C14163d.m84990g().m85009o()) {
            m20691g4(6, FamilyShareConstants.OpenCloudShareResultInfo.DESC_MIGRATING_DATA);
        } else {
            mo18552e4();
        }
    }

    /* renamed from: j4 */
    public final void m20694j4(int i10, String str) {
        C13227f.m79492i1().m79595s0("auto_upload_login_cloud_space_success", str, i10 == 0 ? "open_cloud_space_from_quick_access" : i10 == 1 ? "open_cloud_space_from_setting" : null);
    }

    /* renamed from: k4 */
    public void mo20695k4() {
    }

    /* renamed from: l4 */
    public final void m20696l4(int i10) {
        try {
            Intent intent = new Intent();
            intent.setClass(this, UpgradeIntroductionActivity.class);
            intent.putExtra("navigation_dest", i10);
            startActivityForResult(intent, 10037);
        } catch (ActivityNotFoundException e10) {
            C11839m.m70687e(NotifyConstants.ActivityName.HISYNC_EXTERNAL_ACTIVITY, "startUpGuideActivity failed, exception: " + e10.toString());
        }
    }

    /* renamed from: m4 */
    public final void m20697m4() {
        C10028c c10028c;
        if (!C13612b.m81829B().isLogin() || (c10028c = this.f16395e0) == null) {
            return;
        }
        c10028c.m62281U2("show_merge_sp", true);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity, com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, com.huawei.android.hicloud.p088ui.CommonActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (C0209d.m1173G1(this)) {
            C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_EXTERNAL_ACTIVITY, "onConfigurationChanged(), isPrivacyUser, now exit Cloud!");
            m22602L3();
            return;
        }
        setContentView(R$layout.welcom_layout);
        m22651k2();
        m22645h2();
        m22599J3();
        if (this.f16415p0) {
            m22591E3();
        }
        m22594G3();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity, com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, com.huawei.android.hicloud.p088ui.CommonActivity, com.huawei.hicloud.base.p103ui.uiextend.EntrancePermissionCheckActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        m29137U0();
        super.onCreate(bundle);
        C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_EXTERNAL_ACTIVITY, "onCreate");
        m20684Z3();
        if (this.f16340C0 == 2 && "spaceShare".equals(this.f15001i1)) {
            m20693i4();
        } else {
            m20692h4();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        m20684Z3();
        if (this.f16340C0 == 2 && "spaceShare".equals(this.f15001i1)) {
            m20693i4();
        } else {
            m20692h4();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: v2 */
    public boolean mo20573v2() {
        if (super.mo20573v2()) {
            C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_EXTERNAL_ACTIVITY, "showswitch true");
            return true;
        }
        C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_EXTERNAL_ACTIVITY, "super showswitch false");
        return false;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: x3 */
    public void mo20574x3() {
        if (this.f16420s.getVisibility() == 0) {
            C11842p.m70827j2(this.f16420s, this.f13504j + this.f13505k);
        }
    }
}
