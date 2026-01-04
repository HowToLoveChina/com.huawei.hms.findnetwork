package com.huawei.android.hicloud.p088ui.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cc.C1417a;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.complexutil.C2784e;
import com.huawei.android.hicloud.oobe.R$drawable;
import com.huawei.android.hicloud.oobe.R$id;
import com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.DisableSupportedRelativeLayout;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.UnionSwitch;
import com.huawei.android.hicloud.p088ui.activity.UniformGuideActivity;
import com.huawei.android.hicloud.p088ui.extend.AutoStyleButtonAnnotation;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.DialogCallback;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.NewMergeAlertDialog;
import com.huawei.android.hicloud.sync.service.aidl.SyncType;
import com.huawei.android.hicloud.task.simple.C3076q2;
import com.huawei.android.hicloud.task.simple.FullReportSwitchStatusTask;
import com.huawei.android.p073ds.R$anim;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.ReceiveActivityGiftResq;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.base.p103ui.NewDialogUtil;
import com.huawei.hicloud.bean.DriveConfigService;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.manager.CommonReportUtil;
import com.huawei.hicloud.notification.spacelanguage.util.SpaceMultLanguageUtil;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.appmashup.bean.C4987f;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.secure.android.common.intent.SafeIntent;
import fk.C9721b;
import gp.C10028c;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p015ak.C0209d;
import p015ak.C0214f0;
import p015ak.C0223k;
import p015ak.C0226l0;
import p015ak.C0236u;
import p020ap.C1006a;
import p020ap.C1008c;
import p020ap.C1010e;
import p037bp.C1270a;
import p051c9.C1396a;
import p232dp.InterfaceC9282a;
import p232dp.InterfaceC9283b;
import p292fn.C9733f;
import p315gj.C9948a;
import p336he.C10155f;
import p372ip.C10583a;
import p422k9.C11019b;
import p431ko.C11076b;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p681uj.C13195l;
import p684un.C13222a;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import p746wn.C13622a;
import p783xp.C13843a;
import p836z8.C14157f;
import sk.C12806c;
import sk.C12809f;
import vn.C13471c;

@AutoStyleButtonAnnotation
/* loaded from: classes3.dex */
public class UniformGuideActivity extends UniformGuideBaseActivity implements DialogCallback {

    /* renamed from: A1 */
    public NewMergeAlertDialog f16259A1;

    /* renamed from: B1 */
    public boolean f16260B1;

    /* renamed from: C1 */
    public int f16261C1;

    /* renamed from: E1 */
    public boolean f16263E1;

    /* renamed from: t1 */
    public ArrayList<String> f16270t1;

    /* renamed from: u1 */
    public NewDialogUtil f16271u1;

    /* renamed from: w1 */
    public LinearLayout f16273w1;

    /* renamed from: x1 */
    public TextView f16274x1;

    /* renamed from: y1 */
    public TextView f16275y1;

    /* renamed from: z1 */
    public CheckBox f16276z1;

    /* renamed from: r1 */
    public C2784e f16268r1 = new C2784e();

    /* renamed from: s1 */
    public ArrayList<String> f16269s1 = new ArrayList<>();

    /* renamed from: v1 */
    public Activity f16272v1 = null;

    /* renamed from: D1 */
    public int f16262D1 = 4;

    /* renamed from: F1 */
    public Handler f16264F1 = new HandlerC3518a();

    /* renamed from: G1 */
    public Messenger f16265G1 = new Messenger(this.f16264F1);

    /* renamed from: H1 */
    public HashMap<String, Boolean> f16266H1 = new HashMap<>();

    /* renamed from: I1 */
    public boolean f16267I1 = false;

    /* renamed from: com.huawei.android.hicloud.ui.activity.UniformGuideActivity$a */
    public class HandlerC3518a extends Handler {
        public HandlerC3518a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (UniformGuideActivity.this.isFinishing()) {
                C11839m.m70686d(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "activity is finished");
                return;
            }
            int i10 = message.what;
            if (1046 == i10 || 1047 == i10) {
                UniformGuideActivity.this.mo22492n4(message);
                return;
            }
            if (1049 == i10) {
                if (C1010e.m6125b().m6144j()) {
                    C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "initPhoneFinderSwitch PhoneFinder opening");
                    UniformGuideActivity.this.m16922B3();
                } else {
                    C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "initPhoneFinderSwitch PhoneFinder not opening");
                    UniformGuideActivity.this.m16972e2();
                }
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.UniformGuideActivity$b */
    public class C3519b extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ TextView f16278a;

        public C3519b(TextView textView) {
            this.f16278a = textView;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            final String spaceMultLanguage = SpaceMultLanguageUtil.getSpaceMultLanguage("cloud_pick_vip_item_title");
            final String spaceMultLanguage2 = SpaceMultLanguageUtil.getSpaceMultLanguage("uniform_pick_vip_subhint_new");
            final String spaceMultLanguage3 = SpaceMultLanguageUtil.getSpaceMultLanguage("uniform_pick_vip_subtitle_new");
            final long jM62408w = C10028c.m62183d0(UniformGuideActivity.this).m62408w();
            final int iM62233K = C10028c.m62183d0(UniformGuideActivity.this).m62233K();
            if (TextUtils.isEmpty(spaceMultLanguage) || TextUtils.isEmpty(spaceMultLanguage2) || TextUtils.isEmpty(spaceMultLanguage3) || jM62408w <= 0 || iM62233K <= 0) {
                C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "text is null");
                UniformGuideActivity.this.f16273w1.setVisibility(8);
                UniformGuideActivity.this.f16274x1.setVisibility(8);
                return;
            }
            if (UniformGuideActivity.this.f16276z1.getVisibility() == 0) {
                C10028c.m62182c0().m62193B3(true);
            }
            final TextView textView = this.f16278a;
            C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.y8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17824a.m22503d(jM62408w, spaceMultLanguage2, iM62233K, spaceMultLanguage, textView, spaceMultLanguage3);
                }
            });
            LinkedHashMap<String, String> linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
            linkedHashMapM79499C.put("isChecked", Boolean.valueOf(UniformGuideActivity.this.f16276z1.isChecked()));
            C13227f.m79492i1().m79567R("key_receive_activity_gift_show", linkedHashMapM79499C);
            UBAAnalyze.m29947H("CKC", "key_receive_activity_gift_show", linkedHashMapM79499C);
        }

        /* renamed from: d */
        public final /* synthetic */ void m22503d(long j10, String str, int i10, String str2, TextView textView, String str3) {
            String strM1520c = C0223k.m1520c(UniformGuideActivity.this, j10);
            UniformGuideActivity.this.f16274x1.setText(String.format(str, strM1520c, Integer.valueOf(i10)));
            UniformGuideActivity.this.f16275y1.setText(String.format(str2, strM1520c, Integer.valueOf(i10)));
            textView.setText(str3);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.UniformGuideActivity$c */
    public class C3520c implements NewDialogUtil.InterfaceC4854c {
        public C3520c() {
        }

        /* renamed from: e */
        public static /* synthetic */ void m22506e() {
            C13227f.m79492i1().m79566Q0(C13452e.m80781L().m80971t0(), "finderSetupLockScreen", NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "cancel");
        }

        /* renamed from: f */
        public static /* synthetic */ void m22507f(String str) {
            C13227f.m79492i1().m79566Q0(C13452e.m80781L().m80971t0(), "finderSetupLockScreen", NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, str);
        }

        @Override // com.huawei.hicloud.base.p103ui.NewDialogUtil.InterfaceC4854c
        /* renamed from: a */
        public void mo22508a() {
            final String message;
            try {
                Intent intent = new Intent(C0209d.m1165E0(UniformGuideActivity.this.f16272v1) ? "com.android.settings.PHONE_FINDER_LOCK_SCREEN" : "android.app.action.SET_NEW_PASSWORD");
                intent.addCategory("android.intent.category.DEFAULT");
                C0209d.m1302r2(intent, "com.android.settings");
                UniformGuideActivity.this.f16272v1.startActivityForResult(intent, UniformGuideActivity.this.f16262D1);
                message = "success";
            } catch (Exception e10) {
                message = e10.getMessage();
                C11839m.m70687e(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "Start set new password activity error." + message);
            }
            C0226l0.m1585e(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.a9
                @Override // java.lang.Runnable
                public final void run() {
                    UniformGuideActivity.C3520c.m22507f(message);
                }
            }, 60000L);
            C11839m.m70686d(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, message);
        }

        @Override // com.huawei.hicloud.base.p103ui.NewDialogUtil.InterfaceC4854c
        /* renamed from: b */
        public void mo22509b() throws Throwable {
            UniformGuideActivity.this.m22484f4();
            C0226l0.m1585e(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.z8
                @Override // java.lang.Runnable
                public final void run() {
                    UniformGuideActivity.C3520c.m22506e();
                }
            }, 60000L);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.UniformGuideActivity$d */
    public class C3521d extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ CountDownLatch f16281a;

        /* renamed from: com.huawei.android.hicloud.ui.activity.UniformGuideActivity$d$a */
        public class a implements C11076b.a {
            public a() {
            }

            @Override // p431ko.C11076b.a
            /* renamed from: a */
            public void mo18400a() {
                try {
                    ReceiveActivityGiftResq receiveActivityGiftResqM61677j0 = C9948a.m61631C().m61677j0(C13452e.m80781L().m80892b1(), "BUSINESS_MODE_UPDATE");
                    if (receiveActivityGiftResqM61677j0 == null || !receiveActivityGiftResqM61677j0.isEffect()) {
                        if (receiveActivityGiftResqM61677j0 != null) {
                            UniformGuideActivity.this.m22470E4(receiveActivityGiftResqM61677j0.getResultCode(), receiveActivityGiftResqM61677j0.getResultDesc(), receiveActivityGiftResqM61677j0.isEffect());
                            return;
                        } else {
                            UniformGuideActivity.this.m22470E4(-1, "receiveActivityGiftResq is null", false);
                            return;
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("bs.grade");
                    for (C4987f c4987f : C14157f.m84942g().m84949i(null, arrayList, "RefreshGrade")) {
                        try {
                            if (TextUtils.equals(c4987f.m30026b(), "bs.grade")) {
                                C13452e.m80781L().m80940l1(c4987f.m30027c());
                            }
                        } catch (Exception unused) {
                            C11839m.m70689w(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "getParams " + c4987f.m30026b() + "--" + c4987f.m30027c());
                        }
                    }
                    UniformGuideActivity.this.m22476K4();
                    UniformGuideActivity.this.m22471F4(receiveActivityGiftResqM61677j0.getSpacePackage());
                } catch (C9721b e10) {
                    UniformGuideActivity.this.m22470E4(e10.m60659c(), e10.getMessage(), false);
                }
            }
        }

        public C3521d(CountDownLatch countDownLatch) {
            this.f16281a = countDownLatch;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$call$0() {
            UniformGuideActivity.this.mo16699C2();
            UniformGuideActivity.this.m16947O1();
            UniformGuideActivity.this.mo16704E1();
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            Runnable runnable;
            new C11076b(this.f16281a, new a()).execute();
            try {
                try {
                    C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "receiveActivityGift");
                    this.f16281a.await(5L, TimeUnit.SECONDS);
                    C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "receiveActivityGift end");
                    runnable = new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.b9
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f16487a.lambda$call$0();
                        }
                    };
                } catch (InterruptedException e10) {
                    C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "receiveActivityGift countDownLatch error" + e10);
                    C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "receiveActivityGift end");
                    runnable = new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.b9
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f16487a.lambda$call$0();
                        }
                    };
                }
                C0226l0.m1584d(runnable);
            } catch (Throwable th2) {
                C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "receiveActivityGift end");
                C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.b9
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f16487a.lambda$call$0();
                    }
                });
                throw th2;
            }
        }
    }

    /* renamed from: e4 */
    private void m22462e4() {
        C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "albumReport");
        LinkedHashMap<String, String> linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("isAutoOpen", C13222a.m79466h(this.f16260B1));
        linkedHashMapM79499C.put("sourceType", C13222a.m79467i(this.f16261C1));
        C13227f.m79492i1().m79567R("uniformguide_album_openswitch_data", linkedHashMapM79499C);
        UBAAnalyze.m29947H("PVC", "uniformguide_album_openswitch_data", linkedHashMapM79499C);
    }

    /* renamed from: t4 */
    public static boolean m22463t4() {
        if (!C13452e.m80781L().m80892b1() || !C13452e.m80781L().m80791C0() || C0209d.m1269j1()) {
            C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "initAvailableData return");
            return true;
        }
        if (!C9733f.m60705z().m60720O("bmEnabled")) {
            C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "bmEnabled return false");
            return true;
        }
        if (C9733f.m60705z().m60715J()) {
            return false;
        }
        C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "isBmGuideEnabled return false");
        return true;
    }

    /* renamed from: x4 */
    public static /* synthetic */ void m22464x4(boolean z10) {
        C13227f.m79492i1().m79566Q0(C13452e.m80781L().m80971t0(), "finderSetupLockScreen", NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "isLock:" + z10);
    }

    /* renamed from: y4 */
    public static /* synthetic */ void m22465y4() {
        C13227f.m79492i1().m79566Q0(C13452e.m80781L().m80971t0(), "finderSetupLockScreen", NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "showDialog");
    }

    /* renamed from: A4 */
    public void mo22466A4(C10028c c10028c) {
        ArrayList<SyncConfigService> shownSyncServiceItems = NotifyUtil.getShownSyncServiceItems(this);
        if (shownSyncServiceItems.size() > 0) {
            Iterator<SyncConfigService> it = shownSyncServiceItems.iterator();
            while (it.hasNext()) {
                SyncConfigService next = it.next();
                if (next != null) {
                    String id2 = next.getId();
                    if (!TextUtils.isEmpty(id2) && m16989o2(next.getId())) {
                        if (c10028c.m62395t1("funcfg_" + id2)) {
                            boolean zM16195b = this.f16268r1.m16195b(this, id2, false);
                            if (this.f12598Y0.containsKey(id2)) {
                                Boolean bool = this.f12598Y0.get(id2);
                                if (bool != null) {
                                    zM16195b = bool.booleanValue();
                                }
                            }
                            if (zM16195b) {
                                this.f16269s1.add(id2);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: B0 */
    public void mo16553B0() {
        if (!C13843a.m83076a0(this)) {
            setRequestedOrientation(1);
        }
        m16614v();
    }

    /* renamed from: B4 */
    public final void m22467B4() {
        C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "openSwitchReport");
        if (C0209d.m1166E1() && !m16985m2() && this.f12598Y0.containsKey(HNConstants.DataType.MEDIA)) {
            Boolean bool = this.f12598Y0.get(HNConstants.DataType.MEDIA);
            zBooleanValue = bool != null ? bool.booleanValue() : false;
            C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "galleryDefaultValue" + zBooleanValue);
        }
        C13222a.m79463e(zBooleanValue ? "CLOUDBACKUP_CLOUDALBUM_OPEN_GALLERY_UNIFORMGUIDE" : "CLOUDBACKUP_CLOUDALBUM_CLOSE_GALLERY_UNIFORMGUIDE", "1", C13452e.m80781L().m80971t0(), C13222a.m79465g(this), this.f16260B1, this.f16261C1);
        UBAAnalyze.m29962W("PVC", zBooleanValue ? "CLOUDBACKUP_CLOUDALBUM_OPEN_GALLERY_UNIFORMGUIDE" : "CLOUDBACKUP_CLOUDALBUM_CLOSE_GALLERY_UNIFORMGUIDE", "1", "15", "1", C13222a.m79465g(this), this.f16260B1, this.f16261C1);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("isAutoOpen", C13222a.m79466h(this.f16260B1));
        linkedHashMap.put("sourceType", C13222a.m79467i(this.f16261C1));
        linkedHashMap.put("gallerySwitchOpen", zBooleanValue ? "1" : "0");
        C13227f.m79492i1().m79590k0("mecloud_gallerymain_click_switch_uniformguide", "1", "1", C13452e.m80781L().m80971t0(), linkedHashMap);
        UBAAnalyze.m29979g0("PVC", "mecloud_gallerymain_click_switch_uniformguide", "1", "15", "1", "1", linkedHashMap);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: C0 */
    public void mo16555C0() {
        super.mo16555C0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: C2 */
    public void mo16699C2() {
        C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "click moveNextHisync");
        m16973e3();
        m16975f3();
        Bundle bundle = new Bundle();
        for (Map.Entry<String, Boolean> entry : this.f12598Y0.entrySet()) {
            bundle.putBoolean(entry.getKey(), entry.getValue().booleanValue());
        }
        if (!TextUtils.isEmpty(this.f12568H0)) {
            bundle.putString("channel_of_open_switch", this.f12568H0);
        }
        C12515a.m75110o().m75172d(new C3076q2(getApplicationContext(), bundle, 6));
        C12515a.m75110o().m75172d(new FullReportSwitchStatusTask(this));
        C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "mOpenFamilySpaceShare:" + this.f12345e);
        if (this.f12345e) {
            if (C11829c.m70626w0()) {
                C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "spaceshare enable true");
                C2783d.m16166o0(this, this.f12346f, this.f12347g);
            } else {
                C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "spaceshare enable false");
            }
        }
        Intent intent = getIntent();
        if (intent == null) {
            C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "intent is null");
            return;
        }
        boolean booleanExtra = new SafeIntent(intent).getBooleanExtra(FamilyShareConstants.IS_FROM_GALLERY_LOGIN, false);
        boolean z10 = !C11829c.m70532M0() || C10028c.m62182c0().m62413x();
        C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "isCloudSpaceFunctionItemSwitchOpen:" + z10 + ",isFromGalleryLogin:" + booleanExtra);
        if (C13452e.m80781L().m80791C0() && booleanExtra && z10) {
            C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "jump to cloud space upgrade page.");
            InterfaceC9283b interfaceC9283b = (InterfaceC9283b) C1270a.m7534b().m7535a(InterfaceC9283b.class);
            if (interfaceC9283b != null) {
                interfaceC9283b.mo58515k(this, "OPEN_CLOUD_PHOTO_FROM_OTHER");
            } else {
                C11839m.m70687e(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "cloudBackupRouter is null");
            }
        }
    }

    /* renamed from: C4 */
    public void m22468C4() {
        C10028c.m62182c0().m62377p3("is_all_guide_over", true);
        m22469D4();
        if (!m22499v4()) {
            mo16699C2();
            mo16704E1();
            return;
        }
        NewMergeAlertDialog newMergeAlertDialog = this.f16259A1;
        if (newMergeAlertDialog != null && newMergeAlertDialog.isShowing()) {
            this.f16259A1.dismiss();
        }
        C10028c.m62182c0().m62198C3(true);
        m17008v3();
        C12515a.m75110o().m75172d(new C3521d(new CountDownLatch(1)));
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: D2 */
    public void mo16700D2() throws Throwable {
        C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "click moveToNext");
        if (!this.f12596X0 && !C0209d.m1333z1(this)) {
            m17013x3();
            return;
        }
        if (SystemClock.elapsedRealtime() - this.f12570J0 < 1500) {
            C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "click the next button twice too fast");
            return;
        }
        this.f12570J0 = SystemClock.elapsedRealtime();
        m17008v3();
        this.f12630o1 = C1008c.m6035v().m6036A(this);
        mo16729g3();
        C2783d.m16173q1(this);
        m22488j4(m22485g4());
        if (this.f12344d && m16931G1(this) && !m16936I1() && this.f12595X.isEnabled()) {
            m16947O1();
            C13195l.m79272J().m79326p(this, 8908, C13452e.m80781L().m80799E0(), "", this.f12586S0);
            return;
        }
        if (!C11829c.m70536O0()) {
            m16947O1();
            mo16941K2();
            return;
        }
        boolean zM16936I1 = m16936I1();
        C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "phoneFinderSwitchView isOpen: " + zM16936I1);
        if (zM16936I1) {
            if (C1010e.m6125b().m6142h(C13452e.m80781L().m80971t0())) {
                C1010e.m6125b().m6127B(this, 10044);
                m16947O1();
                return;
            }
        }
        if (m16991p1(zM16936I1)) {
            mo16952R2(zM16936I1);
        }
    }

    /* renamed from: D4 */
    public final void m22469D4() {
        if (!C10028c.m62182c0().m62395t1("funcfg_find_my_phone_globe")) {
            C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "phone finder not enabled");
            return;
        }
        if (this.f12343c) {
            C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "enter from phone finder guide");
            return;
        }
        if (m22498u4()) {
            return;
        }
        C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "need to guide phone finder");
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(this, "com.huawei.android.remotecontrol.ui.PhoneFinderTipsActivity"));
        intent.putExtra("guide_open_phone_finder", true);
        startActivity(intent);
    }

    /* renamed from: E4 */
    public final void m22470E4(int i10, String str, boolean z10) {
        LinkedHashMap<String, String> linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("isSuccess", Boolean.FALSE);
        linkedHashMapM79499C.put(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, Integer.valueOf(i10));
        linkedHashMapM79499C.put("resultDesc", str);
        linkedHashMapM79499C.put("isEffect", Boolean.valueOf(z10));
        C13227f.m79492i1().m79567R("key_receive_activity_gift", linkedHashMapM79499C);
        UBAAnalyze.m29947H("CKC", "key_receive_activity_gift", linkedHashMapM79499C);
    }

    /* renamed from: F4 */
    public final void m22471F4(ReceiveActivityGiftResq.SpacePackage spacePackage) {
        LinkedHashMap<String, String> linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("isSuccess", Boolean.TRUE);
        if (spacePackage != null) {
            linkedHashMapM79499C.put(HwPayConstant.KEY_PRODUCTNAME, spacePackage.getProductName());
        }
        C13227f.m79492i1().m79567R("key_receive_activity_gift", linkedHashMapM79499C);
        UBAAnalyze.m29947H("CKC", "key_receive_activity_gift", linkedHashMapM79499C);
    }

    /* renamed from: G4 */
    public final void m22472G4() {
        SharedPreferences.Editor editorEdit = C0214f0.m1382b(this, "com.huawei.android.cg.fileshare.SETTING", 0).edit();
        editorEdit.putBoolean("SwitchHelperUtilinheritisCloudAlbumOn", false);
        editorEdit.commit();
        C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "gellerySwitchView setChecked false");
    }

    /* renamed from: H4 */
    public void mo22473H4(ArrayList<String> arrayList) {
        C10028c c10028cM62183d0 = C10028c.m62183d0(this);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (this.f12598Y0.containsKey(next)) {
                Boolean bool = this.f12598Y0.get(next);
                boolean zBooleanValue = bool == null ? false : bool.booleanValue();
                if (HNConstants.DataType.MEDIA.equals(next)) {
                    if (C0209d.m1166E1()) {
                        C1006a.m5936k().m5951O(zBooleanValue, this);
                        c10028cM62183d0.m62336h2("uploadphotokey", zBooleanValue);
                    }
                } else if (!"wlan".equals(next)) {
                    c10028cM62183d0.m62336h2(next, zBooleanValue);
                } else if (C0209d.m1166E1()) {
                    c10028cM62183d0.m62336h2(next, zBooleanValue);
                }
            }
        }
    }

    /* renamed from: I4 */
    public void m22474I4(int i10) {
        Iterator<String> it = this.f16270t1.iterator();
        while (it.hasNext()) {
            String next = it.next();
            C10155f.m63268U(this, next, i10);
            this.f12598Y0.put(next, Boolean.FALSE);
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: J1 */
    public void mo16938J1() {
        this.f12566F0 = getDrawable(R$drawable.list_spread_gray_harmony);
        Drawable drawable = getDrawable(R$drawable.list_spreadoff_gray_harmony);
        this.f12567G0 = drawable;
        this.f12565E0.setImageDrawable(drawable);
    }

    /* renamed from: J4 */
    public void m22475J4() throws IllegalAccessException, IllegalArgumentException {
        if (this.f16271u1 == null) {
            C11839m.m70687e(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "newHiSyncActivityUtil is null");
            return;
        }
        C0226l0.m1585e(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.v8
            @Override // java.lang.Runnable
            public final void run() {
                UniformGuideActivity.m22465y4();
            }
        }, 60000L);
        this.f16267I1 = true;
        this.f16271u1.m29117b(this, getResources().getString(R$string.phonefinder_title_lockscreen_password), getResources().getString(R$string.phonefinder_content_set_lockscreen), getResources().getString(R$string.phonefinder_set_lockscreen_now), getResources().getString(R$string.phonefinder_set_lockscreen_later), new C3520c());
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: K2 */
    public void mo16941K2() throws Throwable {
        if (!C0209d.m1245d1(getApplicationContext(), getLocalClassName())) {
            C11839m.m70687e(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "the activity is not foreground");
            return;
        }
        m17008v3();
        if (this.f16267I1) {
            C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "hasShowLockScreenDialog");
            m22484f4();
        } else if (this.f12595X.isEnabled() && this.f12616h1 && C1010e.m6125b().m6150p(this.f16272v1) && !C0209d.m1301r1(this.f16272v1)) {
            m22475J4();
        } else {
            m22484f4();
        }
    }

    /* renamed from: K4 */
    public final void m22476K4() {
        InterfaceC9282a interfaceC9282a;
        boolean booleanExtra = new SafeIntent(getIntent()).getBooleanExtra(FamilyShareConstants.IS_FROM_GALLERY_LOGIN, false);
        boolean z10 = !C11829c.m70532M0() || C10028c.m62182c0().m62413x();
        if (C13452e.m80781L().m80892b1() && booleanExtra && z10 && (interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class)) != null) {
            interfaceC9282a.mo58401W0(this, true);
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: L1 */
    public void mo16942L1(int i10) {
        View view = this.f12592V0;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* renamed from: L4 */
    public final void m22477L4(ArrayList<String> arrayList, int i10) {
        C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "sync4LocalDataCheck");
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            m22489k4(it.next(), i10);
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: N2 */
    public void mo16710N2(SyncConfigService syncConfigService) {
        this.f12598Y0.put(syncConfigService.getId(), Boolean.TRUE);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: O */
    public void mo16566O() {
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76829b(this, R$id.oobe_start_main_frame);
        if (relativeLayout != null) {
            C11842p.m70811f2(relativeLayout, C11842p.m70864t(this));
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: P1 */
    public void mo16949P1() {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: P2 */
    public void mo16713P2() {
        RelativeLayout relativeLayout = this.f12611f0;
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            this.f12598Y0.put("addressbook", Boolean.TRUE);
        }
        DisableSupportedRelativeLayout disableSupportedRelativeLayout = this.f12613g0;
        if (disableSupportedRelativeLayout != null && disableSupportedRelativeLayout.getVisibility() == 0 && C0209d.m1166E1()) {
            this.f12598Y0.put(HNConstants.DataType.MEDIA, Boolean.TRUE);
        }
        RelativeLayout relativeLayout2 = this.f12615h0;
        if (relativeLayout2 != null && relativeLayout2.getVisibility() == 0) {
            this.f12598Y0.put("calendar", Boolean.TRUE);
        }
        RelativeLayout relativeLayout3 = this.f12617i0;
        if (relativeLayout3 != null && relativeLayout3.getVisibility() == 0) {
            this.f12598Y0.put("notepad", Boolean.TRUE);
        }
        DisableSupportedRelativeLayout disableSupportedRelativeLayout2 = this.f12619j0;
        if (disableSupportedRelativeLayout2 != null && disableSupportedRelativeLayout2.getVisibility() == 0 && C0209d.m1166E1()) {
            this.f12598Y0.put("wlan", Boolean.TRUE);
        }
        RelativeLayout relativeLayout4 = this.f12621k0;
        if (relativeLayout4 != null && relativeLayout4.getVisibility() == 0) {
            this.f12598Y0.put("browser", Boolean.TRUE);
        }
        m16945M2();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: U2 */
    public void mo16957U2() throws Throwable {
        m22484f4();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: V1 */
    public int mo16722V1(int i10) {
        ArrayList<Object> arrayListM8154d = this.f12590U0.m8154d();
        if (arrayListM8154d != null && arrayListM8154d.size() > 0) {
            Iterator<Object> it = arrayListM8154d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof SyncConfigService) {
                    this.f12637t0++;
                    if (((SyncConfigService) next).getSwitchStatus()) {
                        i10++;
                    }
                } else if (next instanceof DriveConfigService) {
                    this.f12637t0++;
                    if (((DriveConfigService) next).isSwitchStatus()) {
                        i10++;
                    }
                }
            }
        }
        return i10;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: X1 */
    public void mo16725X1() {
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        boolean z10 = this.f16268r1.m16195b(this, "addressbook", true) && !C0209d.m1293p1();
        boolean zM16195b = this.f16268r1.m16195b(this, "calendar", false);
        boolean zM16195b2 = this.f16268r1.m16195b(this, HNConstants.DataType.MEDIA, false);
        boolean zM16195b3 = this.f16268r1.m16195b(this, "wlan", false);
        boolean z11 = this.f16268r1.m16195b(this, "notepad", false) && C0209d.m1215U1(this);
        boolean z12 = this.f16268r1.m16195b(this, "browser", false) && !C0209d.m1293p1();
        boolean zM62388s = c10028cM62182c0.m62388s("backup_key");
        if (!C0209d.m1166E1() || C0209d.m1293p1()) {
            zM16195b2 = false;
        }
        boolean z13 = C0209d.m1166E1() ? zM16195b3 : false;
        this.f12585S.setCheckedProgrammatically(zM62388s);
        this.f12599Z.setChecked(z10);
        this.f12605c0.setChecked(z11);
        this.f12603b0.setChecked(zM16195b);
        this.f12607d0.setChecked(z13);
        this.f12603b0.setChecked(zM16195b);
        this.f12601a0.setChecked(zM16195b2);
        this.f12609e0.setChecked(z12);
        m16960Y2("addressbook", z10);
        m16960Y2("calendar", zM16195b);
        m16960Y2(HNConstants.DataType.MEDIA, zM16195b2);
        m16960Y2("notepad", z11);
        m16960Y2("wlan", z13);
        m16960Y2("browser", z12);
        m22495q4();
        if (!this.f12604b1) {
            m16935H2();
        }
        mo16727Y1();
        this.f16266H1.putAll(this.f12598Y0);
        this.f16266H1.put("cloud_backup", Boolean.valueOf(this.f12614g1));
        this.f16266H1.put("findmyphone", Boolean.valueOf(this.f12616h1));
        UnionSwitch unionSwitch = this.f12597Y;
        if (unionSwitch != null) {
            this.f16266H1.put("cloud_sync", Boolean.valueOf(unionSwitch.isChecked()));
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: Y */
    public void mo16574Y() {
        super.mo16700D2();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: Y1 */
    public void mo16727Y1() {
        ArrayList<Object> arrayListM8154d;
        C1417a c1417a = this.f12590U0;
        if (c1417a == null || (arrayListM8154d = c1417a.m8154d()) == null || arrayListM8154d.size() <= 0) {
            return;
        }
        Iterator<Object> it = arrayListM8154d.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof SyncConfigService) {
                SyncConfigService syncConfigService = (SyncConfigService) next;
                boolean zM16195b = this.f16268r1.m16195b(this, syncConfigService.getId(), false);
                if (this.f12600Z0.containsKey(syncConfigService.getId())) {
                    zM16195b = this.f12600Z0.get(syncConfigService.getId()).booleanValue();
                }
                syncConfigService.setSwitchStatus(Boolean.valueOf(zM16195b));
                this.f12598Y0.put(syncConfigService.getId(), Boolean.valueOf(zM16195b));
            } else if (next instanceof DriveConfigService) {
                DriveConfigService driveConfigService = (DriveConfigService) next;
                boolean zM16195b2 = this.f16268r1.m16195b(this, driveConfigService.getId(), false);
                if (this.f12600Z0.containsKey(driveConfigService.getId())) {
                    zM16195b2 = this.f12600Z0.get(driveConfigService.getId()).booleanValue();
                }
                driveConfigService.setSwitchStatus(zM16195b2);
                this.f12598Y0.put(driveConfigService.getId(), Boolean.valueOf(zM16195b2));
            }
        }
        this.f12590U0.notifyDataSetChanged();
    }

    /* renamed from: Y3 */
    public final void m22478Y3() {
        Boolean bool;
        if (C10028c.m62182c0().m62395t1("funcfg_browser") && m16989o2("browser") && C10155f.m63285i(this) && this.f12598Y0.containsKey("browser") && (bool = this.f12598Y0.get("browser")) != null && bool.booleanValue() && !C0209d.m1293p1()) {
            this.f16269s1.add("browser");
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: Z2 */
    public void mo16962Z2() {
        ArrayList<Object> arrayListM8154d;
        C1417a c1417a = this.f12590U0;
        if (c1417a == null || (arrayListM8154d = c1417a.m8154d()) == null || arrayListM8154d.size() <= 0) {
            return;
        }
        Iterator<Object> it = arrayListM8154d.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            boolean z10 = false;
            if (next instanceof SyncConfigService) {
                SyncConfigService syncConfigService = (SyncConfigService) next;
                Boolean bool = this.f12598Y0.get(syncConfigService.getId());
                if (bool != null && bool.booleanValue()) {
                    z10 = true;
                }
                syncConfigService.setSwitchStatus(Boolean.valueOf(z10));
            } else if (next instanceof DriveConfigService) {
                DriveConfigService driveConfigService = (DriveConfigService) next;
                Boolean bool2 = this.f12598Y0.get(driveConfigService.getId());
                if (bool2 != null && bool2.booleanValue()) {
                    z10 = true;
                }
                driveConfigService.setSwitchStatus(z10);
            }
        }
        this.f12590U0.notifyDataSetChanged();
    }

    /* renamed from: Z3 */
    public final void m22479Z3() {
        Boolean bool;
        if (C10028c.m62182c0().m62395t1("funcfg_calendar") && m16989o2("calendar") && this.f12598Y0.containsKey("calendar") && (bool = this.f12598Y0.get("calendar")) != null && bool.booleanValue()) {
            this.f16269s1.add("calendar");
        }
    }

    /* renamed from: a4 */
    public final void m22480a4() {
        Boolean bool;
        if (C10028c.m62182c0().m62395t1("funcfg_contacts") && m16989o2("addressbook")) {
            if (!this.f12598Y0.containsKey("addressbook") || ((bool = this.f12598Y0.get("addressbook")) != null && bool.booleanValue())) {
                this.f16269s1.add("addressbook");
            }
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: b3 */
    public void mo16968b3() {
        int iMo16732o1 = mo16732o1();
        TextView textView = this.f12583R;
        if (textView != null) {
            textView.setText(getResources().getQuantityString(R$plurals.temp_backup_confirm_dialog_content_placeholder, iMo16732o1, Integer.valueOf(iMo16732o1), Integer.valueOf(this.f12637t0)));
        }
    }

    /* renamed from: b4 */
    public final void m22481b4() {
        Boolean bool;
        if (!C0209d.m1166E1() || m16985m2()) {
            return;
        }
        boolean zBooleanValue = false;
        if (this.f12598Y0.containsKey(HNConstants.DataType.MEDIA) && (bool = this.f12598Y0.get(HNConstants.DataType.MEDIA)) != null) {
            zBooleanValue = bool.booleanValue();
        }
        C10028c c10028cM62183d0 = C10028c.m62183d0(this);
        if (c10028cM62183d0 != null && c10028cM62183d0.m62395t1("gallery_login_key")) {
            C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "GalleryAlreadyLogin");
        } else if (zBooleanValue) {
            this.f16269s1.add(HNConstants.DataType.MEDIA);
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: c */
    public int mo16578c() {
        C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "use content layout");
        this.f12602a1 = true;
        return R$layout.uniform_guide_for_non_oobe;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: c2 */
    public void mo16969c2() {
        mo16970d2();
    }

    /* renamed from: c4 */
    public final void m22482c4() {
        Boolean bool;
        if (C10028c.m62182c0().m62395t1("funcfg_notes") && m16989o2("notepad") && C0209d.m1215U1(this) && this.f12598Y0.containsKey("notepad") && (bool = this.f12598Y0.get("notepad")) != null && bool.booleanValue()) {
            this.f16269s1.add("notepad");
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: d2 */
    public void mo16970d2() {
        if (!C11829c.m70536O0() || !m22498u4()) {
            C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "initPhoneFinderSwitch not support");
            this.f12589U.setVisibility(8);
            m16944M1();
            this.f12595X.setCheckedProgrammatically(false);
            return;
        }
        C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "initPhoneFinderSwitch supportPhoneFinder");
        if (C0209d.m1166E1()) {
            this.f12595X.setCheckedProgrammatically(this.f12616h1);
        } else {
            m17014y1();
        }
    }

    /* renamed from: d4 */
    public final void m22483d4() {
        Boolean bool;
        if (C10028c.m62182c0().m62395t1("funcfg_wlan") && m16989o2("wlan") && C0209d.m1166E1() && this.f12598Y0.containsKey("wlan") && (bool = this.f12598Y0.get("wlan")) != null && bool.booleanValue()) {
            this.f16269s1.add("wlan");
        }
    }

    /* renamed from: f4 */
    public final void m22484f4() throws Throwable {
        C10028c c10028cM62183d0 = C10028c.m62183d0(this);
        m22480a4();
        m22479Z3();
        m22483d4();
        m22478Y3();
        m22482c4();
        if (C10155f.m63249B() && !C0209d.m1293p1()) {
            m22481b4();
        }
        mo22466A4(c10028cM62183d0);
        mo22501z4(c10028cM62183d0);
        m22497s4();
        new C1396a(this.f16264F1).m7988b(this, this.f16269s1, 6);
        CommonReportUtil.reportLocalDataCheck(this.f16269s1);
    }

    @Override // android.app.Activity
    public void finish() {
        C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "finish");
        super.finish();
        overridePendingTransition(R$anim.activity_fade_in, R$anim.activity_fade_out);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: g */
    public int mo16585g() {
        return mo16578c();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: g3 */
    public void mo16729g3() {
        if (m16987n2() && !this.f12585S.isChecked()) {
            C11019b.m66371t().m66431m();
            return;
        }
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        if (!this.f12585S.isChecked() && c10028cM62182c0.m62388s("backup_key")) {
            C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "satisfy report close cloudbackup switch condition");
            C12515a.m75110o().m75172d(new UniformGuideBaseActivity.C2860i());
        }
        C13227f.m79492i1().m79597u0(getClass().getSimpleName() + ":  change all switch", C13471c.f.ALL_SWITCH, this.f12585S.isChecked());
        CloudBackupService.getInstance().cloudbackupOpr(this.f12585S.isChecked());
        if (this.f12585S.isChecked()) {
            return;
        }
        C11839m.m70689w(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "abort backup");
        CloudBackupService.getInstance().abort();
    }

    /* renamed from: g4 */
    public final HashMap<String, Boolean> m22485g4() {
        HashMap<String, Boolean> map = new HashMap<>();
        try {
            for (Map.Entry<String, Boolean> entry : this.f16266H1.entrySet()) {
                String key = entry.getKey();
                boolean zBooleanValue = entry.getValue().booleanValue();
                if (this.f12598Y0.containsKey(key) && (!zBooleanValue) == this.f12598Y0.get(key).booleanValue()) {
                    map.put(key, this.f12598Y0.get(key));
                }
            }
            boolean zBooleanValue2 = this.f16266H1.get("cloud_backup").booleanValue();
            boolean zBooleanValue3 = this.f16266H1.get("findmyphone").booleanValue();
            boolean zBooleanValue4 = this.f16266H1.get("cloud_sync").booleanValue();
            boolean z10 = this.f12614g1;
            if (zBooleanValue2 != z10) {
                map.put("cloud_backup", Boolean.valueOf(z10));
            }
            boolean z11 = this.f12616h1;
            if (zBooleanValue3 != z11) {
                map.put("findmyphone", Boolean.valueOf(z11));
            }
            UnionSwitch unionSwitch = this.f12597Y;
            if (unionSwitch != null && zBooleanValue4 != unionSwitch.isChecked()) {
                map.put("cloud_sync", Boolean.valueOf(this.f12597Y.isChecked()));
            }
        } catch (Exception e10) {
            C11839m.m70687e(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "CompareMaps exception: " + e10.toString());
        }
        return map;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: h */
    public int mo16587h() {
        return mo16578c();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: h2 */
    public void mo16730h2() {
        UnionSwitch unionSwitch;
        C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "initSyncItemOpenNum");
        int iM22491m4 = m22491m4(0);
        if (this.f12569I0.m62395t1("funcfg_gallery") && !C0209d.m1293p1() && !m16985m2()) {
            this.f12637t0++;
            this.f12639v0 = true;
            iM22491m4 = m16955T1(iM22491m4, C0209d.m1166E1() ? this.f12601a0.isChecked() : false);
        }
        if (this.f12561A0 && this.f12590U0 != null) {
            iM22491m4 = mo16722V1(iM22491m4);
        }
        if (iM22491m4 == 0 && (unionSwitch = this.f12597Y) != null) {
            this.f12608d1 = false;
            unionSwitch.setChecked(false);
        }
        this.f12583R.setText(getResources().getQuantityString(com.huawei.android.hicloud.oobe.R$plurals.uniform_sync_item_num, iM22491m4, Integer.valueOf(iM22491m4)));
    }

    /* renamed from: h4 */
    public void m22486h4() {
        Iterator<String> it = this.f16270t1.iterator();
        while (it.hasNext()) {
            String next = it.next();
            Iterator<String> it2 = this.f16269s1.iterator();
            while (it2.hasNext()) {
                if (next.equals(it2.next())) {
                    it2.remove();
                }
            }
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: i */
    public int mo16589i() {
        return mo16578c();
    }

    /* renamed from: i4 */
    public final void m22487i4() {
        String str = !C0236u.m1652c() ? "enterByFreePackageBtn" : "enter_guide_default";
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("uniform_guide_start_from", str);
        C13227f.m79492i1().m79567R("enter_uniform_guide", linkedHashMapM79497A);
        UBAAnalyze.m29947H("PVC", "enter_uniform_guide", linkedHashMapM79497A);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: j */
    public int mo16591j() {
        return mo16578c();
    }

    /* renamed from: j4 */
    public final void m22488j4(HashMap<String, Boolean> map) {
        for (Map.Entry<String, Boolean> entry : map.entrySet()) {
            String key = entry.getKey();
            boolean zBooleanValue = entry.getValue().booleanValue();
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            linkedHashMapM79497A.put("switchStatus", String.valueOf(zBooleanValue));
            C13227f.m79492i1().m79567R("guide_diff_switch_" + key, linkedHashMapM79497A);
            UBAAnalyze.m29947H("CKC", "guide_diff_switch_" + key, linkedHashMapM79497A);
        }
    }

    /* renamed from: k4 */
    public final void m22489k4(String str, int i10) {
        String strM81958d = C13622a.m81958d("03003");
        C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "executeSync, syncModuleName" + str + ", traceId: " + strM81958d);
        if ("addressbook".equals(str)) {
            C1008c.m6035v().m6050O(this, "addressbook", true);
            C10155f.m63272Y(this, strM81958d, SyncType.OPEN_SWITCH_FROM_GUIDE, i10);
            return;
        }
        if ("calendar".equals(str)) {
            C10155f.m63271X(this, strM81958d, i10);
            return;
        }
        if ("notepad".equals(str)) {
            C10155f.m63275a0(this, strM81958d, i10);
            return;
        }
        if ("wlan".equals(str)) {
            C1008c.m6035v().m6050O(this, "wlan", true);
            C10155f.m63279c0(this, strM81958d, i10);
        } else if ("browser".equals(str)) {
            C10155f.m63270W(this, strM81958d, i10);
        } else if (HNConstants.DataType.MEDIA.equals(str)) {
            C2783d.m16175r0(getApplicationContext());
        } else {
            C10155f.m63277b0(this, str, strM81958d, i10);
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: l0 */
    public void mo16596l0() {
        super.mo16596l0();
    }

    /* renamed from: l4 */
    public final int m22490l4(boolean z10) {
        return z10 ? R$string.uniform_guide_membership_service_tips : R$string.uniform_guide_basic_service_tips_new;
    }

    /* renamed from: m4 */
    public final int m22491m4(int i10) {
        if (this.f12569I0.m62395t1("funcfg_contacts") && !C0209d.m1293p1() && m16989o2("addressbook")) {
            this.f12637t0++;
            this.f12638u0 = true;
            i10 = m16955T1(i10, this.f12599Z.isChecked());
        }
        if (this.f12569I0.m62395t1("funcfg_calendar") && m16989o2("calendar")) {
            this.f12637t0++;
            this.f12641x0 = true;
            i10 = m16955T1(i10, this.f12603b0.isChecked());
        }
        if (this.f12569I0.m62395t1("funcfg_wlan") && m16989o2("wlan")) {
            this.f12637t0++;
            this.f12643z0 = true;
            i10 = m16955T1(i10, C0209d.m1166E1() ? this.f12607d0.isChecked() : false);
        }
        if (this.f12569I0.m62395t1("funcfg_browser") && C11019b.m66371t().m66391K(this) && !C0209d.m1293p1() && m16989o2("browser")) {
            this.f12637t0++;
            this.f12642y0 = true;
            i10 = m16955T1(i10, this.f12609e0.isChecked());
        }
        if (!this.f12569I0.m62395t1("funcfg_notes") || !C0209d.m1215U1(this) || !m16989o2("notepad")) {
            return i10;
        }
        this.f12637t0++;
        this.f12640w0 = true;
        return m16955T1(i10, this.f12605c0.isChecked());
    }

    /* renamed from: n4 */
    public void mo22492n4(Message message) {
        C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "handleLocalDataCheckMsg");
        m16947O1();
        int i10 = message.arg1;
        int i11 = message.what;
        if (i11 != 1046) {
            if (i11 == 1047) {
                mo22473H4(this.f16269s1);
                m22477L4(this.f16269s1, i10);
                m22467B4();
                CommonReportUtil.reportLocalDataCheckResult("0", null);
                m22468C4();
                return;
            }
            return;
        }
        if (this.f16259A1 == null) {
            this.f16259A1 = new NewMergeAlertDialog(this, this, i10);
        }
        this.f16270t1 = (ArrayList) message.obj;
        C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "MSG_SYNC_LOCAL_DATA_EXIST, module size = " + this.f16270t1.size());
        this.f16259A1.show(this.f16270t1, "");
        m22486h4();
        mo22473H4(this.f16269s1);
        m22477L4(this.f16269s1, i10);
        CommonReportUtil.reportLocalDataCheckResult("1", this.f16269s1);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: o1 */
    public int mo16732o1() {
        RelativeLayout relativeLayout;
        DisableSupportedRelativeLayout disableSupportedRelativeLayout;
        RelativeLayout relativeLayout2;
        DisableSupportedRelativeLayout disableSupportedRelativeLayout2;
        RelativeLayout relativeLayout3;
        RelativeLayout relativeLayout4;
        int i10 = this.f12637t0;
        C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "calculateOpenItemNum supportFeatureNum: " + this.f12637t0);
        boolean zIsChecked = this.f12599Z.isChecked();
        boolean zIsChecked2 = this.f12603b0.isChecked();
        boolean zIsChecked3 = this.f12601a0.isChecked();
        boolean zIsChecked4 = this.f12605c0.isChecked();
        boolean zIsChecked5 = this.f12607d0.isChecked();
        boolean zIsChecked6 = this.f12609e0.isChecked();
        if (!zIsChecked && this.f12638u0 && (relativeLayout4 = this.f12611f0) != null && relativeLayout4.getVisibility() == 0) {
            i10--;
        }
        if (!zIsChecked2 && this.f12641x0 && (relativeLayout3 = this.f12615h0) != null && relativeLayout3.getVisibility() == 0) {
            i10--;
        }
        if (!zIsChecked3 && this.f12639v0 && (disableSupportedRelativeLayout2 = this.f12613g0) != null && disableSupportedRelativeLayout2.getVisibility() == 0) {
            i10--;
        }
        if (!zIsChecked4 && this.f12640w0 && (relativeLayout2 = this.f12617i0) != null && relativeLayout2.getVisibility() == 0) {
            i10--;
        }
        if (!zIsChecked5 && this.f12643z0 && (disableSupportedRelativeLayout = this.f12619j0) != null && disableSupportedRelativeLayout.getVisibility() == 0) {
            i10--;
        }
        if (!zIsChecked6 && this.f12642y0 && (relativeLayout = this.f12621k0) != null && relativeLayout.getVisibility() == 0) {
            i10--;
        }
        return (!this.f12561A0 || this.f12590U0 == null) ? i10 : mo16733s1(i10);
    }

    /* renamed from: o4 */
    public boolean m22493o4() {
        return (!C13452e.m80781L().m80803F0().booleanValue() || C10028c.m62182c0().m62395t1("confirm_permission_tips") || C11842p.m70747M0(this) || C11842p.m70771U0()) ? false : true;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseAuthActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) throws Throwable {
        C11839m.m70686d(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "onActivityResult requestCode=" + i10 + ", resultCode=" + i11);
        if (i10 == this.f16262D1) {
            final boolean zM1301r1 = C0209d.m1301r1(this);
            if (zM1301r1) {
                C1010e.m6125b().m6131F(this);
            }
            m22484f4();
            C0226l0.m1585e(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.w8
                @Override // java.lang.Runnable
                public final void run() {
                    UniformGuideActivity.m22464x4(zM1301r1);
                }
            }, 30000L);
        }
        super.onActivityResult(i10, i11, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() throws Throwable {
        C2783d.m16173q1(this);
        m22497s4();
        super.onBackPressed();
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.DialogCallback
    public void onCanceled(String str, int i10) {
        if ("all_module".equals(str)) {
            m22474I4(i10);
            C2783d.m16114V0(str, "1", "2", i10);
        }
        m22468C4();
        m22467B4();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity, android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z10) throws IllegalAccessException, IllegalArgumentException {
        UnionSwitch unionSwitch;
        int id2 = compoundButton.getId();
        if (id2 == R$id.open_contact_switch) {
            this.f12598Y0.put("addressbook", Boolean.valueOf(z10));
            m16994q1(z10, "addressbook");
            this.f12620j1 = z10;
        } else if (id2 == R$id.open_gellery_switch) {
            this.f12598Y0.put(HNConstants.DataType.MEDIA, Boolean.valueOf(z10));
            m16994q1(z10, HNConstants.DataType.MEDIA);
            this.f12618i1 = z10;
        } else if (id2 == R$id.open_calendar_switch) {
            this.f12598Y0.put("calendar", Boolean.valueOf(z10));
            m16994q1(z10, "calendar");
            this.f12624l1 = z10;
        } else if (id2 == R$id.open_notepad_switch) {
            this.f12598Y0.put("notepad", Boolean.valueOf(z10));
            this.f12626m1 = z10;
        } else if (id2 == R$id.open_wlan_switch) {
            this.f12598Y0.put("wlan", Boolean.valueOf(z10));
            this.f12628n1 = z10;
        } else if (id2 == R$id.open_browser_switch) {
            this.f12598Y0.put("browser", Boolean.valueOf(z10));
            this.f12622k1 = z10;
        } else if (id2 == R$id.open_backup_switch) {
            if (m16994q1(z10, CloudBackupConstant.Command.PMS_CMD_BACKUP)) {
                return;
            }
            this.f12614g1 = z10;
            m16995q3();
        } else if (id2 == R$id.open_phonefinder_switch) {
            if (this.f12595X.isEnabled()) {
                this.f12616h1 = z10;
                m16954S2(z10);
            }
        } else if (id2 == R$id.open_sync_item_switch) {
            Object tag = compoundButton.getTag();
            if (tag instanceof String) {
                String str = (String) tag;
                if (!TextUtils.isEmpty(str)) {
                    m16980k3(str, Boolean.valueOf(z10));
                    this.f12598Y0.put(str, Boolean.valueOf(z10));
                }
            }
        } else if (id2 == R$id.open_sync_switch) {
            m16999s3(true);
        }
        if (!z10) {
            m17000t1();
        }
        if (z10 && (unionSwitch = this.f12597Y) != null && !unionSwitch.isChecked() && m16930F3() && id2 != R$id.open_sync_switch && id2 != R$id.open_backup_switch && id2 != R$id.open_phonefinder_switch) {
            this.f12610e1 = false;
            this.f12597Y.setChecked(true);
        }
        mo16968b3();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseAuthActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C12806c.m76820k(this, this.f12361u);
        m16614v();
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.DialogCallback
    public void onConfirmed(String str, String str2, int i10) {
        if ("all_module".equals(str)) {
            mo22473H4(this.f16270t1);
            m22477L4(this.f16270t1, i10);
        }
        m22468C4();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseAuthActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "onCreate");
        m16557E();
        this.f16272v1 = this;
        this.f16271u1 = new NewDialogUtil(this);
        m22487i4();
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(getIntent());
        this.f16261C1 = hiCloudSafeIntent.getIntExtra("start_to_open_cloud_album_source", 0);
        this.f16260B1 = hiCloudSafeIntent.getBooleanExtra("gallery_start_to_open_cloud_album", false);
        this.f16263E1 = hiCloudSafeIntent.getBooleanExtra(FamilyShareConstants.IS_FROM_GALLERY_LOGIN, false);
        m22462e4();
        m22494p4();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseAuthActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "onDestroy");
        NewMergeAlertDialog newMergeAlertDialog = this.f16259A1;
        if (newMergeAlertDialog != null) {
            newMergeAlertDialog.dismiss();
            this.f16259A1 = null;
        }
        NewDialogUtil newDialogUtil = this.f16271u1;
        if (newDialogUtil != null) {
            newDialogUtil.m29116a();
            this.f16271u1 = null;
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) throws Throwable {
        if (i10 != 4) {
            return super.onKeyDown(i10, keyEvent);
        }
        onBackPressed();
        C1006a.m5936k().m5952P(false, this);
        return true;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        if (C13452e.m80781L().m80842P0()) {
            return;
        }
        finish();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseAuthActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* renamed from: p4 */
    public final void m22494p4() {
        if (m22463t4()) {
            C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "isHideReceiveActivityCrad return");
            return;
        }
        LinearLayout linearLayout = (LinearLayout) C12809f.m76829b(this, R$id.oobe_guide_main_frame);
        if (linearLayout == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams();
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = 0;
        }
        LinearLayout linearLayout2 = (LinearLayout) C12809f.m76829b(this, R$id.pick_vip_card_layout);
        this.f16273w1 = linearLayout2;
        linearLayout2.setVisibility(0);
        TextView textView = (TextView) C12809f.m76829b(this, R$id.pick_vip_sub_hint);
        this.f16274x1 = textView;
        textView.setVisibility(0);
        this.f16275y1 = (TextView) C12809f.m76829b(this, R$id.pick_vip_title);
        TextView textView2 = (TextView) C12809f.m76829b(this, R$id.pick_vip_sub_title);
        this.f16276z1 = (CheckBox) C12809f.m76829b(this, R$id.pick_vip_checkbox);
        boolean zM60756o = C9733f.m60705z().m60756o();
        C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "bmGuideCheckStatus " + zM60756o);
        this.f16276z1.setChecked(zM60756o);
        this.f16276z1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.huawei.android.hicloud.ui.activity.x8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                this.f17806a.m22500w4(compoundButton, z10);
            }
        });
        TextView textView3 = this.f12591V;
        if (textView3 != null) {
            textView3.setText(m22490l4(zM60756o));
        }
        m22496r4(this.f16276z1.isChecked());
        m22472G4();
        C12515a.m75110o().m75172d(new C3519b(textView2));
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: q0 */
    public void mo16605q0() {
    }

    /* renamed from: q4 */
    public void m22495q4() {
        if (!this.f12569I0.m62395t1("funcfg_cloud_backup") || C0209d.m1293p1()) {
            this.f12587T.setVisibility(8);
            View view = this.f12593W;
            if (view != null) {
                view.setVisibility(8);
            }
            this.f12585S.setCheckedProgrammatically(false);
        }
    }

    /* renamed from: r4 */
    public final void m22496r4(boolean z10) {
        if (C13452e.m80781L().m80791C0()) {
            if (z10) {
                if (this.f12613g0.getVisibility() == 8) {
                    this.f12637t0++;
                }
                this.f12613g0.setVisibility(0);
                this.f12639v0 = true;
                if (this.f16263E1) {
                    this.f12601a0.setChecked(true);
                } else {
                    this.f12601a0.setChecked(false);
                }
            } else {
                if (this.f12613g0.getVisibility() == 0) {
                    this.f12637t0--;
                }
                this.f12639v0 = false;
                this.f12613g0.setVisibility(8);
                this.f12601a0.setChecked(false);
            }
        }
        mo16968b3();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: s1 */
    public int mo16733s1(int i10) {
        try {
            ArrayList<Object> arrayListM8154d = this.f12590U0.m8154d();
            if (arrayListM8154d != null && arrayListM8154d.size() > 0) {
                Iterator<Object> it = arrayListM8154d.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    boolean z10 = false;
                    if (next instanceof SyncConfigService) {
                        Boolean bool = this.f12598Y0.get(((SyncConfigService) next).getId());
                        if (bool != null && bool.booleanValue()) {
                            z10 = true;
                        }
                        if (!z10) {
                            i10--;
                        }
                    } else if (next instanceof DriveConfigService) {
                        Boolean bool2 = this.f12598Y0.get(((DriveConfigService) next).getId());
                        if (bool2 != null && bool2.booleanValue()) {
                            z10 = true;
                        }
                        if (!z10) {
                            i10--;
                        }
                    }
                }
            }
        } catch (Exception e10) {
            C11839m.m70687e(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "checkSyncConfigOpenNum exception: " + e10.toString());
        }
        return i10;
    }

    /* renamed from: s4 */
    public final void m22497s4() throws Throwable {
        ArrayList<SyncConfigService> notShownSyncServiceItems = NotifyUtil.getNotShownSyncServiceItems(this);
        C11839m.m70688i(NotifyConstants.ActivityName.UNIFORM_GUIDE_ACTIVITY, "closeUnShownItemSyncBackground size = " + notShownSyncServiceItems.size());
        Iterator<SyncConfigService> it = notShownSyncServiceItems.iterator();
        while (it.hasNext()) {
            String id2 = it.next().getId();
            if (!TextUtils.isEmpty(id2)) {
                C12515a.m75110o().m75172d(new C10583a(this, id2, -1));
            }
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: t */
    public List<View> mo16610t() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f12354n);
        arrayList.add(this.f12355o);
        arrayList.add(this.f12356p);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: u0 */
    public void mo16613u0() {
        Window window = getWindow();
        if (window != null) {
            C11829c.m70627w1(this, window);
        }
    }

    /* renamed from: u4 */
    public boolean m22498u4() {
        return FaqConstants.DISABLE_HA_REPORT.equals(this.f12342b) || C0209d.m1193N0();
    }

    /* renamed from: v4 */
    public final boolean m22499v4() {
        CheckBox checkBox = this.f16276z1;
        boolean z10 = checkBox != null && checkBox.isChecked() && this.f16276z1.getVisibility() == 0;
        LinearLayout linearLayout = this.f16273w1;
        return z10 && (linearLayout != null && linearLayout.getVisibility() == 0) && (m22463t4() ^ true);
    }

    /* renamed from: w4 */
    public final /* synthetic */ void m22500w4(CompoundButton compoundButton, boolean z10) {
        int iM22490l4 = m22490l4(z10);
        TextView textView = this.f12591V;
        if (textView != null) {
            textView.setText(iM22490l4);
        }
        m22496r4(z10);
        LinkedHashMap<String, String> linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("isChecked", Boolean.valueOf(z10));
        C13227f.m79492i1().m79567R("key_receive_activity_gift_click", linkedHashMapM79499C);
        UBAAnalyze.m29947H("CKC", "key_receive_activity_gift_click", linkedHashMapM79499C);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: x1 */
    public void mo16734x1(SyncConfigService syncConfigService) {
        this.f12598Y0.put(syncConfigService.getId(), Boolean.FALSE);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: y0 */
    public void mo16620y0() {
        if (2 != this.f12341a || getActionBar() == null) {
            return;
        }
        getActionBar().hide();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.UniformGuideBaseActivity
    /* renamed from: z1 */
    public void mo16735z1() {
        RelativeLayout relativeLayout = this.f12611f0;
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            this.f12598Y0.put("addressbook", Boolean.FALSE);
        }
        DisableSupportedRelativeLayout disableSupportedRelativeLayout = this.f12613g0;
        if (disableSupportedRelativeLayout != null && disableSupportedRelativeLayout.getVisibility() == 0 && C0209d.m1166E1()) {
            this.f12598Y0.put(HNConstants.DataType.MEDIA, Boolean.FALSE);
        }
        RelativeLayout relativeLayout2 = this.f12615h0;
        if (relativeLayout2 != null && relativeLayout2.getVisibility() == 0) {
            this.f12598Y0.put("calendar", Boolean.FALSE);
        }
        RelativeLayout relativeLayout3 = this.f12617i0;
        if (relativeLayout3 != null && relativeLayout3.getVisibility() == 0) {
            this.f12598Y0.put("notepad", Boolean.FALSE);
        }
        DisableSupportedRelativeLayout disableSupportedRelativeLayout2 = this.f12619j0;
        if (disableSupportedRelativeLayout2 != null && disableSupportedRelativeLayout2.getVisibility() == 0 && C0209d.m1166E1()) {
            this.f12598Y0.put("wlan", Boolean.FALSE);
        }
        RelativeLayout relativeLayout4 = this.f12621k0;
        if (relativeLayout4 == null || relativeLayout4.getVisibility() != 0) {
            return;
        }
        this.f12598Y0.put("browser", Boolean.FALSE);
    }

    /* renamed from: z4 */
    public void mo22501z4(C10028c c10028c) {
        ArrayList<DriveConfigService> shownDriveServiceItems = NotifyUtil.getShownDriveServiceItems(this);
        if (shownDriveServiceItems.size() > 0) {
            Iterator<DriveConfigService> it = shownDriveServiceItems.iterator();
            while (it.hasNext()) {
                DriveConfigService next = it.next();
                if (next != null) {
                    String id2 = next.getId();
                    if (!TextUtils.isEmpty(id2)) {
                        if (c10028c.m62395t1("funcfg_" + id2)) {
                            boolean zM16195b = this.f16268r1.m16195b(this, id2, false);
                            if (this.f12598Y0.containsKey(id2)) {
                                Boolean bool = this.f12598Y0.get(id2);
                                if (bool != null) {
                                    zM16195b = bool.booleanValue();
                                }
                            }
                            if (zM16195b) {
                                this.f16269s1.add(id2);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.dialog.DialogCallback
    public void onConfirmed(String str, String str2, ArrayList<String> arrayList, int i10) {
        if ("all_module".equals(str)) {
            Iterator<String> it = this.f16270t1.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!arrayList.contains(next)) {
                    C10155f.m63268U(this, next, i10);
                    this.f12598Y0.put(next, Boolean.FALSE);
                }
            }
            mo22473H4(arrayList);
            m22477L4(arrayList, i10);
        }
        m22468C4();
        m22467B4();
    }
}
