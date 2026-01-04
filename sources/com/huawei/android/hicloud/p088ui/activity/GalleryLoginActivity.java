package com.huawei.android.hicloud.p088ui.activity;

import android.accounts.OperationCanceledException;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.huawei.android.p073ds.R$layout;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.basic.bean.UserDataStateInfo;
import com.huawei.secure.android.common.intent.SafeIntent;
import gp.C10028c;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import je.C10807u;
import mc.C11436a;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0239x;
import p020ap.C1006a;
import p037bp.C1270a;
import p232dp.InterfaceC9282a;
import p232dp.InterfaceC9283b;
import p431ko.C11079e;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p616rk.C12515a;
import p676ud.AlertDialogC13157d;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p742wj.C13612b;
import p837z9.C14163d;

/* loaded from: classes3.dex */
public class GalleryLoginActivity extends WelcomeBaseActivity {

    /* renamed from: i1 */
    public boolean f14884i1;

    /* renamed from: j1 */
    public Handler f14885j1 = new HandlerC3307a();

    public static class GalleryFinishResultReceiver extends ResultReceiver {

        /* renamed from: a */
        public final Handler f14886a;

        public GalleryFinishResultReceiver(WeakReference<Handler> weakReference) {
            super(weakReference.get());
            this.f14886a = weakReference.get();
        }

        @Override // android.os.ResultReceiver
        public void onReceiveResult(int i10, Bundle bundle) {
            if (this.f14886a == null) {
                C11839m.m70688i(NotifyConstants.ActivityName.GALLERY_LOGIN_ACTIVITY, "mHandler is null");
            } else if (1 == i10) {
                C11839m.m70686d(NotifyConstants.ActivityName.GALLERY_LOGIN_ACTIVITY, "galleryloginactivity finish");
                this.f14886a.sendEmptyMessage(9);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.GalleryLoginActivity$a */
    public class HandlerC3307a extends Handler {
        public HandlerC3307a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (1 == i10) {
                C11839m.m70686d(NotifyConstants.ActivityName.GALLERY_LOGIN_ACTIVITY, "finish galleryLogin");
                GalleryLoginActivity.this.finish();
            } else if (9 == i10) {
                C11839m.m70688i(NotifyConstants.ActivityName.GALLERY_LOGIN_ACTIVITY, "receive result finish");
                GalleryLoginActivity.this.mo20569M1();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.GalleryLoginActivity$b */
    public class RunnableC3308b implements Runnable {
        public RunnableC3308b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            GalleryLoginActivity.this.finish();
        }
    }

    /* renamed from: a4 */
    public static /* synthetic */ void m20567a4(InterfaceC9282a interfaceC9282a, UserDataStateInfo userDataStateInfo) {
        if (userDataStateInfo == null || userDataStateInfo.getBmType() == -1) {
            return;
        }
        if (!TextUtils.isEmpty(userDataStateInfo.getBsGrade())) {
            C11839m.m70688i(NotifyConstants.ActivityName.GALLERY_LOGIN_ACTIVITY, "bs grade:" + userDataStateInfo.getBsGrade());
            C13452e.m80781L().m80940l1(userDataStateInfo.getBsGrade());
        }
        if (userDataStateInfo.getBmType() == 1) {
            C13452e.m80781L().m80985w2(true);
            C11839m.m70688i(NotifyConstants.ActivityName.GALLERY_LOGIN_ACTIVITY, "new bm type:true");
        } else if (userDataStateInfo.getBmType() == 0) {
            C11839m.m70688i(NotifyConstants.ActivityName.GALLERY_LOGIN_ACTIVITY, "new bm type:false");
            C13452e.m80781L().m80985w2(false);
        }
        C11839m.m70688i(NotifyConstants.ActivityName.GALLERY_LOGIN_ACTIVITY, "bm grade state and period: " + userDataStateInfo.getBmGradeState() + ", " + userDataStateInfo.getDataPeriod());
        interfaceC9282a.mo58410a1(userDataStateInfo.getBmGradeState(), userDataStateInfo.getDataPeriod());
        interfaceC9282a.mo58399V0(System.currentTimeMillis());
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: F2 */
    public void mo20568F2() {
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            interfaceC9282a.mo58454s0(this, this.f16411n0, false, new SafeIntent(getIntent()).getBooleanExtra(HNConstants.C4906BI.FROM_NOTIFY, false));
        }
        m20572c4();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: M1 */
    public void mo20569M1() {
        super.mo20569M1();
        C11839m.m70686d(NotifyConstants.ActivityName.GALLERY_LOGIN_ACTIVITY, "finish self");
        finish();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: Q2 */
    public void mo20570Q2() {
        super.mo20570Q2();
        m22652k3("4");
    }

    /* renamed from: b4 */
    public final void m20571b4(String str, String str2, boolean z10, int i10, boolean z11) {
        LinkedHashMap<String, String> linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        if (!TextUtils.isEmpty(str)) {
            linkedHashMapM79499C.put("callingPackage", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            linkedHashMapM79499C.put("sceneId", str2);
        }
        linkedHashMapM79499C.put("fromNotify", String.valueOf(z10));
        linkedHashMapM79499C.put("sourceType", String.valueOf(i10));
        linkedHashMapM79499C.put("isOpenSwitch", String.valueOf(z11));
        linkedHashMapM79499C.put("isBasicBusiness", String.valueOf(C13452e.m80781L().m80791C0()));
        C13225d.m79490f1().m79567R("gallery_openswitch_data_info", linkedHashMapM79499C);
        UBAAnalyze.m29947H("PVC", "gallery_openswitch_data_info", linkedHashMapM79499C);
    }

    /* renamed from: c4 */
    public final void m20572c4() {
        C10028c c10028cM62183d0 = C10028c.m62183d0(this);
        if (c10028cM62183d0 != null) {
            c10028cM62183d0.m62377p3("gallery_login_key", true);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity, com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, p709vj.InterfaceC13449b
    /* renamed from: e */
    public void mo13829e(OperationCanceledException operationCanceledException) {
        super.mo13829e(operationCanceledException);
        this.f16402h1.postDelayed(new RunnableC3308b(), 200L);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity, com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, com.huawei.android.hicloud.p088ui.CommonActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (C0209d.m1173G1(this)) {
            C11839m.m70688i(NotifyConstants.ActivityName.GALLERY_LOGIN_ACTIVITY, "onConfigurationChanged, isPrivacyUser, now exit Cloud!");
            m22602L3();
            return;
        }
        setContentView(R$layout.welcom_layout);
        m22651k2();
        m22645h2();
        m22599J3();
        m22594G3();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity, com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, com.huawei.android.hicloud.p088ui.CommonActivity, com.huawei.hicloud.base.p103ui.uiextend.EntrancePermissionCheckActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        if (C13452e.m80781L().m80912f1()) {
            C11839m.m70687e(NotifyConstants.ActivityName.GALLERY_LOGIN_ACTIVITY, "site not match");
            C11436a.m68492d().m68499h(this);
            finish();
            return;
        }
        this.f16414p = true;
        if (C0209d.m1173G1(this)) {
            C11839m.m70688i(NotifyConstants.ActivityName.GALLERY_LOGIN_ACTIVITY, "isPrivacyUser, now exit Cloud!");
            m22602L3();
            return;
        }
        C11839m.m70687e(NotifyConstants.ActivityName.GALLERY_LOGIN_ACTIVITY, "checkServiceStatus");
        C1006a.m5936k().m5957c(getApplicationContext());
        this.f16411n0 = new GalleryFinishResultReceiver(new WeakReference(this.f14885j1));
        this.f16432y = 0;
        C0239x.m1671c().m1677g("0004");
        m22671u1();
        this.f14884i1 = false;
        if (!AlertDialogC13157d.m79147c(this, 1)) {
            this.f14884i1 = C10807u.m65793i(this);
        }
        if (!C13612b.m81829B().m81853R()) {
            InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
            if (interfaceC9282a != null) {
                interfaceC9282a.mo58453s(getApplicationContext());
            } else {
                C11839m.m70688i(NotifyConstants.ActivityName.GALLERY_LOGIN_ACTIVITY, "cloudAlbumRouterImpl is null");
            }
        } else if (m22667s2()) {
            if (C14163d.m84990g().m85009o()) {
                Intent intent = new Intent();
                intent.setClass(this, DataMigrationAuthActivity.class);
                intent.putExtra("jump_where", "nav_main");
                startActivityForResult(intent, 10023);
                return;
            }
            SafeIntent safeIntent = new SafeIntent(getIntent());
            final InterfaceC9282a interfaceC9282a2 = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
            InterfaceC9283b interfaceC9283b = (InterfaceC9283b) C1270a.m7534b().m7535a(InterfaceC9283b.class);
            if (interfaceC9282a2 == null) {
                C11839m.m70688i(NotifyConstants.ActivityName.GALLERY_LOGIN_ACTIVITY, "cloudAlbumRouterImpl is null");
                finish();
                return;
            }
            if (interfaceC9283b == null) {
                C11839m.m70688i(NotifyConstants.ActivityName.GALLERY_LOGIN_ACTIVITY, "cloudBackupRouter is null");
                finish();
                return;
            }
            String callingPackage = getCallingPackage();
            C11839m.m70688i(NotifyConstants.ActivityName.GALLERY_LOGIN_ACTIVITY, "pkgName:" + callingPackage);
            boolean z10 = !C11829c.m70532M0() || C10028c.m62182c0().m62413x();
            C11839m.m70688i(NotifyConstants.ActivityName.GALLERY_LOGIN_ACTIVITY, "isCloudSpaceFunctionItemSwitchOpen:" + z10 + ",sourceType:" + this.f16396e1 + ",pkgName:" + callingPackage);
            String stringExtra = safeIntent.getStringExtra("gallery_cloud_sync_card_scene_id");
            boolean booleanExtra = safeIntent.getBooleanExtra(HNConstants.C4906BI.FROM_NOTIFY, false);
            int intExtra = safeIntent.getIntExtra("start_to_open_cloud_album_source", 0);
            boolean booleanExtra2 = safeIntent.getBooleanExtra("gallery_start_to_open_cloud_album", false);
            m20571b4(callingPackage, stringExtra, booleanExtra, intExtra, booleanExtra2);
            if (C13452e.m80781L().m80791C0() && "OPEN_CLOUD_PHOTO_IN_APP".equals(stringExtra) && z10) {
                C11839m.m70688i(NotifyConstants.ActivityName.GALLERY_LOGIN_ACTIVITY, "jump to cloud space upgrade page,sceneId:" + stringExtra);
                interfaceC9283b.mo58515k(C0213f.m1377a(), stringExtra);
            } else if (C13452e.m80781L().m80791C0() && "com.huawei.systemmanager".equals(callingPackage) && z10) {
                C11839m.m70688i(NotifyConstants.ActivityName.GALLERY_LOGIN_ACTIVITY, "jump to cloud space upgrade page.phone manager");
                interfaceC9283b.mo58515k(C0213f.m1377a(), "OPEN_CLOUD_PHOTO_FROM_OTHER");
            } else if (C13452e.m80781L().m80791C0() && interfaceC9282a2.mo58370H() == 1 && z10) {
                C11839m.m70688i(NotifyConstants.ActivityName.GALLERY_LOGIN_ACTIVITY, "jump to cloud space upgrade page.");
                interfaceC9283b.mo58515k(C0213f.m1377a(), "OPEN_CLOUD_PHOTO_FROM_OTHER");
            } else if (C13452e.m80781L().m80791C0() && interfaceC9282a2.mo58370H() == 0 && ((interfaceC9282a2.mo58409a0() == 1 || interfaceC9282a2.mo58409a0() == 2) && z10)) {
                C11839m.m70688i(NotifyConstants.ActivityName.GALLERY_LOGIN_ACTIVITY, "jump to data expire download page.old gallery");
                interfaceC9283b.mo58530u(C0213f.m1377a(), "OPEN_CLOUD_PHOTO_FROM_OTHER");
            } else {
                boolean booleanExtra3 = safeIntent.getBooleanExtra("gallery_start_to_close_cloud_album", false);
                String stringExtra2 = safeIntent.getStringExtra("sceneCode");
                C11839m.m70688i(NotifyConstants.ActivityName.GALLERY_LOGIN_ACTIVITY, "sourceType:" + intExtra + " isOpenSwitch:" + booleanExtra2 + " sceneCode:" + stringExtra2);
                interfaceC9282a2.mo58411b(this, this.f16411n0, this.f14884i1, booleanExtra, intExtra, booleanExtra2, booleanExtra3, stringExtra2);
                LinkedHashMap<String, String> linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
                linkedHashMapM79499C.put("fromNotify", String.valueOf(booleanExtra));
                linkedHashMapM79499C.put("sourceType", String.valueOf(intExtra));
                linkedHashMapM79499C.put("isOpenSwitch", String.valueOf(booleanExtra2));
                linkedHashMapM79499C.put("isCloseSwitch", String.valueOf(booleanExtra3));
                if (!TextUtils.isEmpty(stringExtra2)) {
                    linkedHashMapM79499C.put("sceneCode", stringExtra2);
                }
                if (!TextUtils.isEmpty(callingPackage)) {
                    linkedHashMapM79499C.put("callingPackage", callingPackage);
                }
                C13225d.m79490f1().m79567R("gallery_openswitch_data_info", linkedHashMapM79499C);
                UBAAnalyze.m29947H("PVC", "gallery_openswitch_data_info", linkedHashMapM79499C);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add("bs.bm.type");
            arrayList.add("bs.bm.usergrade.info");
            C12515a.m75110o().m75175e(new C11079e(new C11079e.a() { // from class: com.huawei.android.hicloud.ui.activity.k5
                @Override // p431ko.C11079e.a
                /* renamed from: a */
                public final void mo14511a(UserDataStateInfo userDataStateInfo) {
                    GalleryLoginActivity.m20567a4(interfaceC9282a2, userDataStateInfo);
                }
            }, false, arrayList, "GalleryLogin"), false);
            finish();
            return;
        }
        m22651k2();
        m22645h2();
        this.f16423t0 = 1;
        if (this.f16344E0) {
            C11839m.m70686d(NotifyConstants.ActivityName.GALLERY_LOGIN_ACTIVITY, "logout is processing");
            m22593F3();
        } else {
            m29130D0();
        }
        m22642f2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity, com.huawei.hicloud.base.p103ui.uiextend.EntrancePermissionCheckActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: v2 */
    public boolean mo20573v2() {
        return super.mo20573v2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.WelcomeBaseActivity
    /* renamed from: x3 */
    public void mo20574x3() {
        if (this.f16420s.getVisibility() == 0) {
            C11842p.m70827j2(this.f16420s, this.f13504j + this.f13505k);
        }
    }
}
