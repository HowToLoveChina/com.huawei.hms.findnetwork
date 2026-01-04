package com.huawei.android.hicloud.p088ui.activity;

import android.accounts.OperationCanceledException;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import au.C1026a;
import com.huawei.android.hicloud.commonlib.util.HwAnimationReflection;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.extend.AutoStyleButtonAnnotation;
import com.huawei.android.hicloud.task.pay.ActionRouteTask;
import com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable;
import com.huawei.android.p073ds.R$anim;
import com.huawei.android.p073ds.R$id;
import com.huawei.hicloud.bean.DeeplinkGuidePage;
import com.huawei.hicloud.bean.DeeplinkRoute;
import com.huawei.hicloud.bean.SpaceInsufficientH5PageInfo;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.task.BatchGetLatestConfigTask;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.network.embedded.C5914f2;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.phone.hwbutton.widget.HwButton;
import gp.C10028c;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import je.C10807u;
import mc.C11436a;
import p015ak.C0203a;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0224k0;
import p015ak.C0239x;
import p015ak.C0241z;
import p054cj.C1442a;
import p252e9.C9438o;
import p292fn.C9733f;
import p450le.C11273b;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p616rk.C12515a;
import p674ub.C13149f;
import p676ud.AlertDialogC13157d;
import p684un.C13222a;
import p684un.C13223b;
import p684un.C13230i;
import p709vj.C13452e;
import p742wj.C13612b;
import p807yd.C13946b;
import p837z9.C14163d;
import p846zj.C14303a;
import sk.C12809f;

@AutoStyleButtonAnnotation
/* loaded from: classes3.dex */
public class NewHiSyncSettingActivity extends WelcomeBaseActivity {

    /* renamed from: k1 */
    public String f15604k1;

    /* renamed from: i1 */
    public C13149f f15602i1 = new C13149f();

    /* renamed from: j1 */
    public String f15603j1 = "";

    /* renamed from: l1 */
    public boolean f15605l1 = false;

    /* renamed from: m1 */
    public Handler f15606m1 = new HandlerC3416c(this);

    /* renamed from: n1 */
    public Boolean f15607n1 = null;

    public static class WelcomeFinishResultReceiver extends ResultReceiver {

        /* renamed from: a */
        public final Handler f15608a;

        public WelcomeFinishResultReceiver(WeakReference<Handler> weakReference) {
            super(weakReference.get());
            this.f15608a = weakReference.get();
        }

        @Override // android.os.ResultReceiver
        public void onReceiveResult(int i10, Bundle bundle) {
            if (this.f15608a == null) {
                C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "mHandler is null");
            } else if (1 == i10) {
                C11839m.m70686d(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "newhisyncsettingactivity finish");
                this.f15608a.sendEmptyMessage(9);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.NewHiSyncSettingActivity$a */
    public class C3414a implements ActionRouteTask.ActionRouteTaskCallback {

        /* renamed from: a */
        public final /* synthetic */ DeeplinkRoute f15609a;

        /* renamed from: b */
        public final /* synthetic */ Intent f15610b;

        /* renamed from: c */
        public final /* synthetic */ boolean f15611c;

        /* renamed from: d */
        public final /* synthetic */ SafeIntent f15612d;

        /* renamed from: e */
        public final /* synthetic */ String f15613e;

        public C3414a(DeeplinkRoute deeplinkRoute, Intent intent, boolean z10, SafeIntent safeIntent, String str) {
            this.f15609a = deeplinkRoute;
            this.f15610b = intent;
            this.f15611c = z10;
            this.f15612d = safeIntent;
            this.f15613e = str;
        }

        @Override // com.huawei.android.hicloud.task.pay.ActionRouteTask.ActionRouteTaskCallback
        /* renamed from: a */
        public void mo18041a() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "actionGuide, processRoute");
            String params = this.f15609a.getParams();
            String paramsSec = this.f15609a.getParamsSec();
            if (TextUtils.isEmpty(params)) {
                C11839m.m70689w(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "actionGuide, guidePageKey is empty!");
                NewHiSyncSettingActivity.this.m21678g4(this.f15610b, this.f15611c);
                return;
            }
            if (!C9733f.m60705z().m60720O(params)) {
                C11839m.m70689w(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "actionGuide, guidePageKey is closed!");
                if (TextUtils.isEmpty(paramsSec) || !C9733f.m60705z().m60720O(paramsSec)) {
                    C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "actionGuide, guidePageKeySec is closed!");
                    NewHiSyncSettingActivity.this.m21678g4(this.f15610b, this.f15611c);
                    return;
                } else {
                    C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "actionGuide, guidePageKeySec is true");
                    params = paramsSec;
                }
            }
            SpaceInsufficientH5PageInfo spaceInsufficientH5PageInfoM60710E = C9733f.m60705z().m60710E(params);
            if (spaceInsufficientH5PageInfoM60710E == null) {
                C1442a.m8291w(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "actionGuide, accountH5PageInfo is null");
                NewHiSyncSettingActivity.this.m21678g4(this.f15610b, this.f15611c);
            } else if (C11273b.m67657l(NewHiSyncSettingActivity.this, spaceInsufficientH5PageInfoM60710E.getUrl(), this.f15612d, this.f15613e)) {
                C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "actionGuide, open H5");
                NewHiSyncSettingActivity.this.finish();
            } else {
                C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "actionGuide, actionGuide end, processStartActivity");
                NewHiSyncSettingActivity.this.m21678g4(this.f15610b, this.f15611c);
            }
        }

        @Override // com.huawei.android.hicloud.task.pay.ActionRouteTask.ActionRouteTaskCallback
        /* renamed from: b */
        public void mo18042b() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "actionGuide, processNormal");
            NewHiSyncSettingActivity.this.m21678g4(this.f15610b, this.f15611c);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.NewHiSyncSettingActivity$b */
    public class RunnableC3415b implements Runnable {
        public RunnableC3415b() {
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            NewHiSyncSettingActivity.this.finish();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.NewHiSyncSettingActivity$c */
    public static class HandlerC3416c extends Handler {

        /* renamed from: a */
        public WeakReference<NewHiSyncSettingActivity> f15616a;

        public HandlerC3416c(NewHiSyncSettingActivity newHiSyncSettingActivity) {
            this.f15616a = new WeakReference<>(newHiSyncSettingActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            NewHiSyncSettingActivity newHiSyncSettingActivity;
            if (message == null || 9 != message.what) {
                return;
            }
            C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "receive result finish");
            WeakReference<NewHiSyncSettingActivity> weakReference = this.f15616a;
            if (weakReference == null || (newHiSyncSettingActivity = weakReference.get()) == null) {
                return;
            }
            if (newHiSyncSettingActivity.isFinishing() || newHiSyncSettingActivity.isDestroyed()) {
                C11839m.m70686d(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "activity is finished");
            } else {
                newHiSyncSettingActivity.mo20569M1();
            }
        }
    }

    /* renamed from: j4 */
    private void m21665j4(int i10) {
        try {
            Intent intent = new Intent();
            intent.setClass(this, UpgradeIntroductionActivity.class);
            intent.putExtra("navigation_dest", i10);
            startActivityForResult(intent, 10037);
        } catch (ActivityNotFoundException e10) {
            C11839m.m70687e(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "startUpGuideActivity failed, exception: " + e10.toString());
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: C1 */
    public void mo21666C1() {
        HwButton hwButton;
        if (C11842p.m70774V0(this) || (hwButton = this.f16418r) == null) {
            return;
        }
        hwButton.setVisibility(8);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: E2 */
    public void mo21667E2() {
        C11839m.m70686d(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "loginProcess");
        mo21956I3();
        if (C13612b.m81829B().isLogin() && C0209d.m1162D1()) {
            C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "overlay install, do not need to login again.");
            m22614R1();
        } else if (C0209d.m1208S0(this)) {
            C13612b.m81829B().m81856U(this, this);
        } else {
            mo21955C2(0, 8, 8, 8);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: F2 */
    public void mo20568F2() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Boolean bool;
        C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "NavToMainPage");
        if (C2783d.m16111U(this) && C11829c.m70508D0()) {
            C11829c.m70564b1(this);
        }
        boolean zM65793i = !AlertDialogC13157d.m79147c(this, 2) ? C10807u.m65793i(this) : false;
        SafeIntent safeIntent = new SafeIntent(getIntent());
        if (C13946b.m83729e().m83752W(this, safeIntent)) {
            C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "EntranceTransUtil transfer");
            finish();
            return;
        }
        if (C14163d.m84990g().m85009o()) {
            Intent intent = new Intent();
            intent.setClass(this, DataMigrationAuthActivity.class);
            intent.putExtra("jump_where", "nav_main");
            startActivityForResult(intent, 10023);
            return;
        }
        Bundle bundle = new Bundle();
        Intent intent2 = new Intent(this, (Class<?>) MainActivity.class);
        m21680i4(safeIntent, intent2);
        intent2.putExtra("intent_from_settings", this.f16373T);
        C13230i.m79525e1(intent2, this.f16427v0, this.f16425u0);
        bundle.putParcelable("welcome_finisher", this.f16411n0);
        intent2.putExtras(bundle);
        if (zM65793i) {
            intent2.putExtra("need_root_alert", true);
        }
        if (!TextUtils.isEmpty(this.f15603j1)) {
            intent2.putExtra("channel_of_open_switch", this.f15603j1);
        }
        if (!C0203a.m1124a(MainActivity.class.getName(), this)) {
            intent2.setFlags(C5914f2.f26733f);
        }
        if (this.f15605l1 && C10028c.m62182c0().m62410w1() && ((bool = this.f15607n1) == null || bool.booleanValue())) {
            intent2.putExtra("is_nav_to_back_up_main_activity", true);
        }
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76829b(this, R$id.welcome_rl);
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
        boolean zM22662q2 = m22662q2();
        if (m21671Z3(safeIntent, intent2, zM22662q2)) {
            C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "navToMainPage to actionGuide.");
            return;
        }
        startActivity(intent2);
        if (!zM22662q2) {
            mo21674c4();
        }
        finish();
        if (zM22662q2) {
            overridePendingTransition(0, R$anim.activity_fade_out_zero);
        }
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity
    /* renamed from: H0 */
    public boolean mo21668H0() {
        return false;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: I1 */
    public void mo21669I1() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (m22670t2()) {
            mo20568F2();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: M1 */
    public void mo20569M1() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.mo20569M1();
        C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "finish self");
        mo20698r3();
        finish();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: O2 */
    public void mo20682O2() {
        super.mo20682O2();
        if (C13452e.m80781L().m80803F0().booleanValue()) {
            this.f15602i1.m79065c(this, getIntent(), C13222a.m79465g(this));
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: Q2 */
    public void mo20570Q2() {
        super.mo20570Q2();
        boolean zM79064b = this.f15602i1.m79064b();
        if (!TextUtils.isEmpty(this.f15604k1)) {
            if (TextUtils.equals(this.f15604k1, "dbank")) {
                m22652k3("14");
                return;
            } else if (TextUtils.equals(this.f15604k1, "contacts")) {
                m22652k3("8");
                return;
            } else {
                m22652k3("15");
                return;
            }
        }
        if (C10028c.m62182c0().m62325f1()) {
            m22652k3("22");
            return;
        }
        if (zM79064b) {
            m22652k3(DownloadTaskBaseCallable.DOWNLOAD_POOL_SHUTDOWN);
        } else if (this.f16375U) {
            m22652k3("23");
        } else {
            m22652k3("3");
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: Z2 */
    public void mo21670Z2(int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (i10 == 1) {
            mo20568F2();
            C0212e0.m1365o(this, "checkbox_push_guide_sp", "key_push_guide_checkbox_showed", true);
            return;
        }
        C13223b.m79473a(this, "CLOUDBACKUP_HICLOUD_CLICK_NEXT", "0");
        UBAAnalyze.m29954O("PVC", "CLOUDBACKUP_HICLOUD_CLICK_NEXT", "0", "2");
        if (C11842p.m70774V0(this)) {
            return;
        }
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4, types: [int] */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* renamed from: Z3 */
    public boolean m21671Z3(SafeIntent safeIntent, Intent intent, boolean z10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        boolean z11;
        boolean z12 = false;
        if (!C9733f.m60705z().m60720O("deeplinkActionGuidePage")) {
            C11839m.m70689w(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "actionGuide, OM DEEPLINK_ACTION_GUIDE_PAGE false");
            return false;
        }
        DeeplinkGuidePage deeplinkGuidePageM60760s = C9733f.m60705z().m60760s();
        if (deeplinkGuidePageM60760s == null) {
            C11839m.m70687e(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "actionGuide, deeplinkGuidePage is null.");
            return false;
        }
        String strM70504C = C11829c.m70504C(this);
        String stringExtra = safeIntent.getStringExtra("startSource");
        boolean z13 = true;
        if (!TextUtils.isEmpty(stringExtra)) {
            DeeplinkRoute[] actionRoute = deeplinkGuidePageM60760s.getActionRoute();
            if (actionRoute == null || actionRoute.length == 0) {
                C11839m.m70687e(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "actionGuide, actionRoutes is null or empty.");
                return false;
            }
            int length = actionRoute.length;
            int i10 = 0;
            while (i10 < length) {
                DeeplinkRoute deeplinkRoute = actionRoute[i10];
                String[] startupSourceId = deeplinkRoute.getStartupSourceId();
                if (startupSourceId != null && startupSourceId.length != 0) {
                    int length2 = startupSourceId.length;
                    for (?? r15 = z12; r15 < length2; r15++) {
                        if (TextUtils.equals(startupSourceId[r15], stringExtra)) {
                            C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "actionGuide, hasResult is true;");
                            new ActionRouteTask(new C3414a(deeplinkRoute, intent, z10, safeIntent, strM70504C)).m63381g();
                            return true;
                        }
                    }
                }
                i10++;
                z12 = false;
            }
            return z12;
        }
        if (TextUtils.isEmpty(strM70504C)) {
            C11839m.m70687e(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "callerPackageName is null or empty.");
            return false;
        }
        String stringExtra2 = safeIntent.getStringExtra("path");
        DeeplinkRoute[] actionPackageRoute = deeplinkGuidePageM60760s.getActionPackageRoute();
        if (actionPackageRoute == null || actionPackageRoute.length == 0) {
            C11839m.m70687e(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "no sourceId, actionPackageRoutes is null or empty.");
            return false;
        }
        int length3 = actionPackageRoute.length;
        int i11 = 0;
        boolean z14 = false;
        while (i11 < length3) {
            DeeplinkRoute deeplinkRoute2 = actionPackageRoute[i11];
            if (TextUtils.equals(stringExtra2, deeplinkRoute2.getPath())) {
                String[] referrerPackage = deeplinkRoute2.getReferrerPackage();
                if (referrerPackage == null || referrerPackage.length == 0) {
                    z11 = z13;
                    C11839m.m70689w(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "no sourceId, referrerPackages is null or empty.");
                } else {
                    int length4 = referrerPackage.length;
                    int i12 = 0;
                    while (true) {
                        if (i12 >= length4) {
                            break;
                        }
                        if (TextUtils.equals(strM70504C, referrerPackage[i12])) {
                            z14 = true;
                            break;
                        }
                        i12++;
                    }
                    if (z14) {
                        C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "no sourceId, hasResult");
                        String params = deeplinkRoute2.getParams();
                        String paramsSec = deeplinkRoute2.getParamsSec();
                        if (TextUtils.isEmpty(params)) {
                            C11839m.m70689w(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "no sourceId, guidePageKey is empty!");
                            return false;
                        }
                        if (!C9733f.m60705z().m60720O(params)) {
                            C11839m.m70689w(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "no sourceId, guidePageKey is closed!");
                            if (TextUtils.isEmpty(paramsSec) || !C9733f.m60705z().m60720O(paramsSec)) {
                                m21678g4(intent, z10);
                                return false;
                            }
                            C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "no sourceId, guidePageKeySec is true");
                            params = paramsSec;
                        }
                        SpaceInsufficientH5PageInfo spaceInsufficientH5PageInfoM60710E = C9733f.m60705z().m60710E(params);
                        if (spaceInsufficientH5PageInfoM60710E == null) {
                            C11839m.m70689w(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "no sourceId, accountH5PageInfo is null");
                            m21678g4(intent, z10);
                            return false;
                        }
                        if (!C11273b.m67657l(this, spaceInsufficientH5PageInfoM60710E.getUrl(), safeIntent, strM70504C)) {
                            return false;
                        }
                        C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "no sourceId, open H5");
                        finish();
                        return true;
                    }
                    z11 = true;
                }
            } else {
                z11 = z13;
            }
            i11++;
            z13 = z11;
        }
        return false;
    }

    /* renamed from: a4 */
    public final boolean m21672a4() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!C13452e.m80781L().m80803F0().booleanValue()) {
            this.f15602i1.m79065c(this, getIntent(), C13222a.m79465g(this));
        }
        this.f16411n0 = new WelcomeFinishResultReceiver(new WeakReference(this.f15606m1));
        m22647i2();
        m22671u1();
        m22640d3();
        m21677f4();
        if (!m22670t2()) {
            mo21676e4(1);
            this.f16376U0 = true;
            C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "activityInit notnavetomain");
            if (!C9438o.m59204a().m59205b() || this.f16386Z0) {
                m21675d4();
                return false;
            }
            m21665j4(2);
            return false;
        }
        if (C9438o.m59204a().m59205b()) {
            m21665j4(1);
        } else {
            mo20568F2();
            long jM85186b = C14303a.m85185a().m85186b();
            C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, " VERSION_CODE 160000300 lastClientVersion " + jM85186b);
            if (C0241z.m1688f("160000300") > jM85186b) {
                C12515a.m75110o().m75172d(new BatchGetLatestConfigTask());
            }
        }
        return true;
    }

    /* renamed from: b4 */
    public final void m21673b4() {
        C13612b.m81829B().m81856U(this, this);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: c3 */
    public void mo20687c3(int i10, Intent intent) {
        C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "processUpGuideResult resultCode = " + i10);
        try {
            if (intent == null) {
                C11839m.m70687e(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "processUpGuideResult error, intent is null");
                finish();
                return;
            }
            int intExtra = intent.getIntExtra("navigation_dest", 0);
            C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "dest is " + intExtra);
            if (intExtra == 1) {
                if (i10 == -1) {
                    mo20568F2();
                    return;
                } else {
                    finish();
                    return;
                }
            }
            if (intExtra != 2) {
                C11839m.m70687e(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "UpGuideActivity result, but dest is 0");
            } else if (i10 == -1) {
                m21675d4();
            } else {
                finish();
            }
        } catch (Exception e10) {
            C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "processUpGuideResult exception = " + e10);
        }
    }

    /* renamed from: c4 */
    public void mo21674c4() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        mo21676e4(1);
    }

    /* renamed from: d4 */
    public final void m21675d4() {
        m22651k2();
        m22645h2();
        if (!this.f16344E0) {
            m29130D0();
        } else {
            C11839m.m70686d(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "logout is processing");
            m22593F3();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity, com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, p709vj.InterfaceC13449b
    /* renamed from: e */
    public void mo13829e(OperationCanceledException operationCanceledException) {
        super.mo13829e(operationCanceledException);
        if (C11842p.m70774V0(this)) {
            return;
        }
        this.f16402h1.postDelayed(new RunnableC3415b(), 200L);
    }

    /* renamed from: e4 */
    public void mo21676e4(int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        new HwAnimationReflection(this).m15927c(i10);
    }

    /* renamed from: f4 */
    public final void m21677f4() {
        String strM79502E;
        try {
            this.f15605l1 = false;
            String action = new SafeIntent(getIntent()).getAction();
            if (TextUtils.isEmpty(action)) {
                strM79502E = C13230i.m79502E(this);
            } else {
                strM79502E = action.equals("com.huawei.android.intent.action.otherapp.HICLOUD_ENTTRANCE") ? "1" : "";
                if (action.equals("com.huawei.android.intent.action.settings.HICLOUD_ENTTRANCE")) {
                    strM79502E = "4";
                }
            }
            C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "parseIsFromHwid, source: " + strM79502E);
            if ("1".equals(strM79502E)) {
                this.f15605l1 = true;
            }
        } catch (Exception e10) {
            C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "parseIsFromHwid exception: " + e10.toString());
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, android.app.Activity
    public void finish() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.finish();
        C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "finish isFromSetting:" + this.f16373T);
        if (this.f16373T) {
            mo21676e4(2);
        } else {
            mo20698r3();
        }
    }

    /* renamed from: g4 */
    public void m21678g4(Intent intent, boolean z10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        startActivity(intent);
        if (!z10) {
            mo21674c4();
        }
        finish();
        if (z10) {
            overridePendingTransition(0, R$anim.activity_fade_out_zero);
        }
    }

    /* renamed from: h4 */
    public final void m21679h4() {
        SafeIntent safeIntent = new SafeIntent(getIntent());
        try {
            C0239x.m1671c().m1677g(safeIntent.hasExtra("enterFrom") ? safeIntent.getStringExtra("enterFrom") : "0003");
        } catch (Exception unused) {
            C11839m.m70687e(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "parseOpenSwitchChannel get extra error");
        }
    }

    /* renamed from: i4 */
    public final void m21680i4(SafeIntent safeIntent, Intent intent) {
        Bundle extras = safeIntent.getExtras();
        if (extras == null || !extras.containsKey("startSource")) {
            return;
        }
        String string = extras.getString("startSource");
        if (!"hwID".equals(string)) {
            intent.putExtra("SOURCE_OTHER_APP", string);
        } else {
            C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "tran SOURCE_ID_ACCOUNT_CENTER, VALUE_SOURCE_HWID");
            intent.putExtra("SOURCE_OTHER_APP", "SOURCE_ID_ACCOUNT_CENTER");
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (SystemClock.elapsedRealtime() - this.f16430x < 1500) {
            C11839m.m70689w(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "click the start button twice too fast");
            return;
        }
        super.onClick(view);
        this.f16430x = SystemClock.elapsedRealtime();
        if (view.getId() == R$id.start_button) {
            m21673b4();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity, com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, com.huawei.android.hicloud.p088ui.CommonActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (C0209d.m1173G1(this)) {
            C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "onConfigurationChanged(), isPrivacyUser, now exit Cloud!");
            m22602L3();
            return;
        }
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
        if (!m22672u2()) {
            m29137U0();
        }
        super.onCreate(bundle);
        C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "onCreate");
        C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "is need nav to backupPage is : " + this.f15607n1);
        if (!C1026a.m6220d()) {
            C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "showRestrictionRunDialog");
            return;
        }
        if (C0224k0.m1570y(this)) {
            C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "isPrivacyUser, now exit Cloud!");
            m22602L3();
        } else if (C13452e.m80781L().m80912f1()) {
            C11839m.m70687e(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "site not match");
            C11436a.m68492d().m68499h(this);
            finish();
            return;
        } else {
            m21679h4();
            if (m21672a4()) {
                return;
            } else {
                m22642f2();
            }
        }
        SafeIntent safeIntent = new SafeIntent(getIntent());
        try {
            if (safeIntent.hasExtra("channel_of_open_switch")) {
                this.f15603j1 = safeIntent.getStringExtra("channel_of_open_switch");
            }
            if (safeIntent.hasExtra(FaqConstants.FAQ_MODULE)) {
                this.f15604k1 = safeIntent.getStringExtra(FaqConstants.FAQ_MODULE);
            }
        } catch (Exception unused) {
            C11839m.m70687e(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "parseOpenSwitchChannel get extra error");
        }
        C11839m.m70686d(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "parseOpenSwitchChannel channel: " + this.f15603j1);
        this.f16380W0 = true;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity, com.huawei.hicloud.base.p103ui.uiextend.EntrancePermissionCheckActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f16411n0 = null;
        this.f15606m1 = null;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onNewIntent(Intent intent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onNewIntent(intent);
        C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "onNewIntent");
        setIntent(intent);
        m21672a4();
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        if (bundle.keySet().contains("is_need_nav_to_backup_page")) {
            this.f15607n1 = Boolean.valueOf(bundle.getBoolean("is_need_nav_to_backup_page", false));
            bundle.remove("is_need_nav_to_backup_page");
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Boolean bool = this.f15607n1;
        Boolean boolValueOf = Boolean.valueOf(bool == null ? this.f15605l1 && C10028c.m62182c0().m62410w1() : bool.booleanValue());
        this.f15607n1 = boolValueOf;
        bundle.putBoolean("is_need_nav_to_backup_page", boolValueOf.booleanValue());
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: r3 */
    public void mo20698r3() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.f16376U0) {
            C11839m.m70686d(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "setCloseAnimation");
            this.f16376U0 = false;
            mo21676e4(2);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: v2 */
    public boolean mo20573v2() {
        if (C13452e.m80781L().m80803F0().booleanValue() && !C0209d.m1173G1(C0213f.m1377a()) && C0209d.m1166E1() && !C2783d.m16099O()) {
            C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "match region");
            return true;
        }
        if (!super.mo20573v2()) {
            C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "super showswitch false");
            return false;
        }
        String stringExtra = new SafeIntent(getIntent()).getStringExtra("need_guide");
        if (TextUtils.isEmpty(stringExtra) || !FaqConstants.DISABLE_HA_REPORT.equals(stringExtra)) {
            C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "showswitch false");
            return false;
        }
        C11839m.m70688i(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY, "showswitch true");
        return true;
    }
}
