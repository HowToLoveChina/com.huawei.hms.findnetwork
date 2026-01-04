package com.huawei.android.hicloud.oobe.p086ui.activity;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.android.hicloud.commonlib.receiver.LocalOpenPhoneFinderReceiver;
import com.huawei.android.hicloud.commonlib.util.HwAnimationReflection;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.oobe.R$color;
import com.huawei.android.hicloud.oobe.R$dimen;
import com.huawei.android.hicloud.oobe.R$id;
import com.huawei.android.hicloud.oobe.R$layout;
import com.huawei.android.hicloud.oobe.R$string;
import com.huawei.android.hicloud.oobe.p086ui.activity.OOBEQueryBaseActivity;
import com.huawei.android.hicloud.oobe.p086ui.activity.SimplifyOOBEQueryinfoActivity;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.OOBENavLayout;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.OOBETopView;
import com.huawei.android.hicloud.p088ui.extend.AutoStyleButtonAnnotation;
import com.huawei.android.hicloud.p088ui.extend.NotchBottomFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchFitOOBENavLinearLayout;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.bean.DriveConfigService;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.manager.AdSwitchManager;
import com.huawei.hicloud.notification.util.ModuleConfigUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.phone.hwbutton.widget.HwButton;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import gp.C10028c;
import hu.C10343b;
import huawei.android.widget.HwToolbar;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0216g0;
import p015ak.C0219i;
import p015ak.C0224k0;
import p015ak.C0226l0;
import p020ap.C1006a;
import p020ap.C1010e;
import p034bc.C1162b;
import p034bc.C1163c;
import p422k9.AbstractC11020c;
import p422k9.C11019b;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p572qb.C12300b0;
import p676ud.AlertDialogC13156c;
import p681uj.C13192i;
import p681uj.C13195l;
import p684un.C13227f;
import p709vj.C13452e;
import p709vj.InterfaceC13456i;
import p742wj.C13612b;
import sk.C12806c;
import sk.C12809f;
import tm.C13040c;

@AutoStyleButtonAnnotation
/* loaded from: classes3.dex */
public class SimplifyOOBEQueryinfoActivity extends OOBEQueryBaseActivity implements View.OnClickListener {

    /* renamed from: B */
    public OOBENavLayout f12527B;

    /* renamed from: C */
    public LinearLayout f12528C;

    /* renamed from: D */
    public OOBETopView f12529D;

    /* renamed from: E */
    public NotchBottomFitRelativeLayout f12530E;

    /* renamed from: F */
    public NotchFitOOBENavLinearLayout f12531F;

    /* renamed from: M */
    public ProgressDialog f12538M;

    /* renamed from: N */
    public TextView f12539N;

    /* renamed from: O */
    public View f12540O;

    /* renamed from: P */
    public HwButton f12541P;

    /* renamed from: Q */
    public HwButton f12542Q;

    /* renamed from: R */
    public AlertDialogC13156c f12543R;

    /* renamed from: T */
    public View f12545T;

    /* renamed from: U */
    public View f12546U;

    /* renamed from: z */
    public boolean f12549z = false;

    /* renamed from: A */
    public boolean f12526A = false;

    /* renamed from: G */
    public List<View> f12532G = new ArrayList();

    /* renamed from: H */
    public boolean f12533H = false;

    /* renamed from: I */
    public boolean f12534I = false;

    /* renamed from: J */
    public Bundle f12535J = null;

    /* renamed from: K */
    public String f12536K = "";

    /* renamed from: L */
    public int f12537L = 0;

    /* renamed from: S */
    @SuppressLint({"HandlerLeak"})
    public Handler f12544S = new HandlerC2845a();

    /* renamed from: V */
    public Handler f12547V = new HandlerC2846b();

    /* renamed from: W */
    public Handler f12548W = new HandlerC2847c();

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.SimplifyOOBEQueryinfoActivity$a */
    public class HandlerC2845a extends Handler {
        public HandlerC2845a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "myHandler Receive msg=" + message.what);
            if (SimplifyOOBEQueryinfoActivity.this.isFinishing() || SimplifyOOBEQueryinfoActivity.this.isDestroyed() || (SimplifyOOBEQueryinfoActivity.this.m16875u0(message.what) && !C0209d.m1245d1(SimplifyOOBEQueryinfoActivity.this.getApplicationContext(), SimplifyOOBEQueryinfoActivity.this.getLocalClassName()))) {
                C11839m.m70687e("SimplifyOOBEQueryinfoActivity", "the oobequery activity is not avaiable");
                return;
            }
            switch (message.what) {
                case 1001:
                    C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "oobe auth token success");
                    SimplifyOOBEQueryinfoActivity.this.m16798J();
                    break;
                case 1002:
                    C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "OOBE auth Failed");
                    SimplifyOOBEQueryinfoActivity.this.m16815r0(8, 8, 0, 8);
                    break;
                case 1003:
                    C11839m.m70689w("SimplifyOOBEQueryinfoActivity", "open finder timeout");
                    SimplifyOOBEQueryinfoActivity.this.finish();
                    break;
                case 1004:
                    SimplifyOOBEQueryinfoActivity.this.m16826A0(message);
                    break;
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.SimplifyOOBEQueryinfoActivity$b */
    public class HandlerC2846b extends Handler {
        public HandlerC2846b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "queryHandler Receive msg=" + message.what);
            if (SimplifyOOBEQueryinfoActivity.this.isFinishing() || SimplifyOOBEQueryinfoActivity.this.isDestroyed() || (SimplifyOOBEQueryinfoActivity.this.m16875u0(message.what) && !C0209d.m1245d1(SimplifyOOBEQueryinfoActivity.this.getApplicationContext(), SimplifyOOBEQueryinfoActivity.this.getLocalClassName()))) {
                C11839m.m70687e("SimplifyOOBEQueryinfoActivity", "the oobequery activity is not avaiable");
                return;
            }
            int i10 = message.arg1;
            if (i10 != SimplifyOOBEQueryinfoActivity.this.f12537L && i10 >= 1) {
                C11839m.m70689w("SimplifyOOBEQueryinfoActivity", "the callback is invalid, queryTime = " + i10 + ", queryServerTime = " + SimplifyOOBEQueryinfoActivity.this.f12537L);
            }
            switch (message.what) {
                case 1:
                    C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "get server info fail");
                    SimplifyOOBEQueryinfoActivity.this.m16858a0();
                    break;
                case 2:
                    C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "get server info success");
                    SimplifyOOBEQueryinfoActivity.this.m16862c0();
                    break;
                case 3:
                    C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "get server info without net");
                    SimplifyOOBEQueryinfoActivity.this.f12547V.removeMessages(1);
                    SimplifyOOBEQueryinfoActivity.this.m16672l(false);
                    SimplifyOOBEQueryinfoActivity.this.m16815r0(0, 8, 8, 8);
                    break;
                case 4:
                    SimplifyOOBEQueryinfoActivity.this.m16860b0();
                    break;
                case 5:
                    SimplifyOOBEQueryinfoActivity.this.m16852X();
                    break;
                case 6:
                    SimplifyOOBEQueryinfoActivity.this.f12547V.removeMessages(1);
                    Intent intent = new Intent();
                    intent.putExtra(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, 2);
                    SimplifyOOBEQueryinfoActivity.this.setResult(3, intent);
                    SimplifyOOBEQueryinfoActivity.this.m16879z0(2);
                    SimplifyOOBEQueryinfoActivity.this.finish();
                    break;
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.SimplifyOOBEQueryinfoActivity$c */
    public class HandlerC2847c extends Handler {
        public HandlerC2847c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "mOnlineUpdateHandler msg:" + message.what);
            int i10 = message.what;
            if (i10 == 1) {
                SimplifyOOBEQueryinfoActivity.this.m16799K(message.obj);
            } else {
                if (i10 != 2) {
                    return;
                }
                SimplifyOOBEQueryinfoActivity.this.m16800T();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.SimplifyOOBEQueryinfoActivity$d */
    public class C2848d implements InterfaceC13456i {
        public C2848d() {
        }

        /* renamed from: b */
        public final /* synthetic */ void m16881b() {
            SimplifyOOBEQueryinfoActivity.this.m16857Z0(false);
        }

        @Override // p709vj.InterfaceC13456i
        public void loginResult(boolean z10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (z10) {
                C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "the account is login");
                C1162b c1162bM7257a = C1162b.m7257a();
                SimplifyOOBEQueryinfoActivity simplifyOOBEQueryinfoActivity = SimplifyOOBEQueryinfoActivity.this;
                c1162bM7257a.m7260d(simplifyOOBEQueryinfoActivity, simplifyOOBEQueryinfoActivity);
                return;
            }
            C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "the account is not login and start to login");
            Intent intent = new Intent();
            intent.setAction("com.huawei.hwid.action.START_BY_OOBE_APP");
            C0209d.m1302r2(intent, "com.huawei.hwid");
            if (intent.resolveActivity(SimplifyOOBEQueryinfoActivity.this.getPackageManager()) != null) {
                C0226l0.m1584d(new Runnable() { // from class: zb.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f63330a.m16881b();
                    }
                });
                C0224k0.m1544N(SimplifyOOBEQueryinfoActivity.this, intent, 1003);
            } else {
                SimplifyOOBEQueryinfoActivity.this.setResult(-1);
                SimplifyOOBEQueryinfoActivity.this.finish();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.SimplifyOOBEQueryinfoActivity$e */
    public class C2849e extends AbstractC11020c {
        public C2849e() {
        }

        @Override // p422k9.AbstractC11020c
        /* renamed from: a */
        public void mo16882a() {
            C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "doNoSign");
            SimplifyOOBEQueryinfoActivity.this.m16829F0();
        }

        @Override // p422k9.AbstractC11020c
        /* renamed from: b */
        public void mo16883b() {
            C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "querySignFail");
            SimplifyOOBEQueryinfoActivity.this.m16829F0();
        }

        @Override // p422k9.AbstractC11020c
        /* renamed from: c */
        public void mo16884c() {
            C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "check hicloud sign success.");
            C10028c.m62182c0().m62377p3("is_hicloud_terms_confirm", true);
            SimplifyOOBEQueryinfoActivity.this.m16829F0();
        }
    }

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.SimplifyOOBEQueryinfoActivity$f */
    public class HandlerC2850f extends Handler {
        public HandlerC2850f() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (8 == i10) {
                C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "CHECK GRS URLS SUCCESS");
                SimplifyOOBEQueryinfoActivity.this.m16793D0();
                return;
            }
            if (9 == i10) {
                C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "CHECK GRS URLS FAIL");
                SimplifyOOBEQueryinfoActivity.this.f12547V.sendEmptyMessage(1);
                return;
            }
            if (10 == i10) {
                C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "SITE NOT SUPPORT");
                C0209d.m1318v2(SimplifyOOBEQueryinfoActivity.this);
                SimplifyOOBEQueryinfoActivity.this.f12547V.sendEmptyMessage(4);
            } else if (11 == i10) {
                SimplifyOOBEQueryinfoActivity.this.f12547V.sendEmptyMessageDelayed(6, 200L);
            } else if (12 == i10) {
                SimplifyOOBEQueryinfoActivity.this.f12547V.sendEmptyMessage(3);
            }
        }
    }

    /* renamed from: B0 */
    private void m16790B0(boolean z10) {
        C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "processPhoneFinderSwitch: " + z10);
        if (z10) {
            LocalOpenPhoneFinderReceiver.m15903a().m15905c(this.f12544S, 1003);
            m16878x0();
            Handler handler = this.f12544S;
            if (handler != null) {
                handler.sendEmptyMessageDelayed(1003, 40000L);
            }
        }
        C11019b.m66371t().m66436o0(this, "phonefinderOOBE", z10);
    }

    /* renamed from: D0 */
    public void m16793D0() {
        C11019b.m66371t().m66426j0(this, new C2849e());
    }

    /* renamed from: J */
    public void m16798J() {
        C10343b c10343b = new C10343b(new SafeIntent(getIntent()).getExtras());
        boolean zM63682d = c10343b.m63682d("intent_from_settings_data", false);
        C11839m.m70686d("SimplifyOOBEQueryinfoActivity", "isUpdated: " + c10343b.m63682d("have_update", false));
        C11839m.m70686d("SimplifyOOBEQueryinfoActivity", "isFromRecover: " + zM63682d);
        m16800T();
    }

    /* renamed from: K */
    public void m16799K(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Intent intent = getIntent();
        if (intent == null) {
            C11839m.m70687e("SimplifyOOBEQueryinfoActivity", "intent is null");
            return;
        }
        if (new SafeIntent(intent).getExtras() == null) {
            C11839m.m70687e("SimplifyOOBEQueryinfoActivity", "bundle is null");
            return;
        }
        ApkUpgradeInfo apkUpgradeInfo = (ApkUpgradeInfo) obj;
        Bundle bundle = new Bundle();
        bundle.putString("name", apkUpgradeInfo.getName_());
        bundle.putString("downUrl", apkUpgradeInfo.getDownurl_());
        bundle.putString("sha256", apkUpgradeInfo.getSha256_());
        bundle.putString("version", apkUpgradeInfo.getVersion_());
        bundle.putInt(FamilyShareConstants.ENTRY_TYPE, 1);
        Intent intent2 = new Intent();
        intent2.putExtras(bundle);
        setResult(ErrorCode.ERROR_BANNER_AD_EXPIRE, intent2);
        finish();
    }

    /* renamed from: T */
    public void m16800T() {
        if (!C0209d.m1333z1(this)) {
            m16815r0(0, 8, 8, 8);
            return;
        }
        if (!C1162b.m7257a().m7259c()) {
            C1162b.m7257a().m7258b(this, new C2848d());
            return;
        }
        C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "cloudspace is login");
        if (!C13452e.m80781L().m80803F0().booleanValue() || C13452e.m80781L().m80795D0()) {
            C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "!isChinaRegion() or isChildAccount(), close ad switch ");
            m16838M0();
        }
        if (!m16870k0()) {
            m16803V();
            return;
        }
        if (this.f12549z) {
            C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "isRecreated no need jump");
            return;
        }
        C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "go uniformGuide direct");
        Intent intent = new Intent(getApplicationContext(), (Class<?>) OOBEUniformGuideFrontActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt(FamilyShareConstants.ENTRY_TYPE, this.f12406f);
        bundle.putBoolean("is_from_mr_guide", this.f12408h);
        if (!TextUtils.isEmpty(this.f12536K)) {
            bundle.putString("channel_of_open_switch", this.f12536K);
            C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "channel_of_open_switch " + this.f12536K);
        }
        intent.putExtras(bundle);
        if (isFinishing() || isDestroyed()) {
            C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "SimplifyOOBEQueryinfoActivity is finishiing");
        } else {
            this.f12526A = true;
            startActivityForResult(intent, 10004);
        }
    }

    /* renamed from: T0 */
    private void m16801T0() {
        int iM70731H = C11842p.m70731H(this, (int) C11842p.m70844o(this, 36));
        int iM70731H2 = C11842p.m70731H(this, (int) C11842p.m70844o(this, 60));
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76829b(this, R$id.oobe_net_error_icon);
        RelativeLayout relativeLayout2 = (RelativeLayout) C12809f.m76829b(this, R$id.oobe_server_error_icon);
        C11842p.m70763R1(this, this.f12416p, iM70731H);
        C11842p.m70763R1(this, relativeLayout, iM70731H2);
        C11842p.m70763R1(this, relativeLayout2, iM70731H2);
    }

    /* renamed from: U0 */
    private void m16802U0() {
        boolean z10 = !this.f12408h && C0209d.m1200P1(this);
        if (1 == this.f12406f && !z10 && !m16876v0()) {
            C11839m.m70686d("SimplifyOOBEQueryinfoActivity", "setNoNavAndStatusBar");
            C11829c.m70585i1(getWindow());
            getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new OOBEQueryBaseActivity.ViewOnSystemUiVisibilityChangeListenerC2832d(getApplicationContext(), getWindow()));
            C11829c.m70633y1(this, getWindow());
            return;
        }
        if (m16876v0() && 1 == this.f12406f) {
            if (z10) {
                C11839m.m70686d("SimplifyOOBEQueryinfoActivity", "setStatusAndNavBarColor");
                C11829c.m70624v1(this, getWindow());
            } else {
                C11839m.m70686d("SimplifyOOBEQueryinfoActivity", "hide nav bar");
                C11829c.m70585i1(getWindow());
            }
        }
    }

    /* renamed from: V */
    private void m16803V() {
        this.f12533H = false;
        m16815r0(8, 8, 8, 0);
        C13040c.m78609F().m78656k0();
        C11019b.m66371t().m66385G0(this, new HandlerC2850f());
    }

    /* renamed from: V0 */
    private void m16804V0() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent == null || (extras = new HiCloudSafeIntent(intent).getExtras()) == null) {
            return;
        }
        this.f12406f = extras.getInt(FamilyShareConstants.ENTRY_TYPE, 1);
        this.f12408h = extras.getBoolean("is_from_mr_guide", false);
        this.f12536K = extras.getString("channel_of_open_switch");
        int i10 = this.f12406f;
        if (2 != i10 && 3 != i10) {
            this.f12527B.m17046h();
            this.f12527B.m17042d();
            return;
        }
        C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "mEntryType  =  " + this.f12406f);
        this.f12527B.setVisibility(8);
    }

    /* renamed from: b1 */
    private void m16805b1() {
        if (this.f12543R == null) {
            this.f12543R = new AlertDialogC13156c(this, new DialogInterface.OnClickListener() { // from class: zb.a
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    this.f63326a.m16873q0(dialogInterface, i10);
                }
            });
        }
        m16844P0(this.f12543R);
        this.f12543R.show();
    }

    /* renamed from: c1 */
    private void m16806c1() {
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        c10028cM62182c0.m62377p3("is_all_guide_over", false);
        c10028cM62182c0.m62377p3("is_already_configed_NV4", false);
        C11019b.m66371t().m66444s0(getApplicationContext());
        C11019b.m66371t().m66425j(false);
        C13452e.m80781L().m80885a();
        C10028c.m62182c0().m62343j();
    }

    /* renamed from: e1 */
    private void m16807e1() {
        if (this.f12406f == 1) {
            C0216g0.m1402e(this).m1421S("SOURCE_STARTGUIDE", "SOURCE_ID_OOBE");
        }
    }

    /* renamed from: h0 */
    private void m16808h0() throws Resources.NotFoundException {
        WindowManager windowManager = getWindowManager();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        int i10 = displayMetrics.heightPixels;
        int i11 = displayMetrics.widthPixels;
        C11839m.m70686d("SimplifyOOBEQueryinfoActivity", "screen height = " + i10 + "  screen width = " + i11);
        this.f12410j = (LinearLayout) C12809f.m76829b(this, R$id.query_server_info_nonet);
        this.f12416p = (LinearLayout) C12809f.m76829b(this, R$id.quering_layout);
        this.f12411k = (LinearLayout) C12809f.m76829b(this, R$id.server_not_avaiable_layout);
        this.f12530E = (NotchBottomFitRelativeLayout) C12809f.m76829b(this, R$id.notch_fit_bottom_frame);
        this.f12531F = (NotchFitOOBENavLinearLayout) C12809f.m76829b(this, R$id.notch_fit_oobe_nav);
        LinearLayout linearLayout = (LinearLayout) C12809f.m76829b(this, R$id.getserver_info_timeout_layout);
        this.f12412l = linearLayout;
        linearLayout.setOnClickListener(this);
        TextView textView = (TextView) C12809f.m76829b(this, R$id.set_the_net);
        TextView textView2 = (TextView) C12809f.m76829b(this, R$id.retry_getinfo);
        this.f12417q = (LinearLayout) C12809f.m76829b(this, R$id.set_server_not_avaiable_layout);
        this.f12418r = (RelativeLayout) C12809f.m76829b(this, R$id.set_query_server_info_nonet);
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76829b(this, R$id.set_getserver_info_timeout_layout);
        this.f12419s = relativeLayout;
        relativeLayout.setOnClickListener(this);
        this.f12420t = (LinearLayout) C12809f.m76829b(this, R$id.oobe_net_error_tips);
        this.f12421u = (LinearLayout) C12809f.m76829b(this, R$id.oobe_server_error_tips);
        OOBENavLayout oOBENavLayout = (OOBENavLayout) C12809f.m76829b(this, R$id.oobe_nav_layout);
        this.f12527B = oOBENavLayout;
        oOBENavLayout.m17042d();
        this.f12423w = (Button) C12809f.m76829b(this, R$id.set_no_net_btn);
        this.f12424x = (Button) C12809f.m76829b(this, R$id.set_retry_getinfo);
        this.f12425y = (TextView) C12809f.m76829b(this, R$id.set_server_not_avaiable_tips);
        this.f12528C = (LinearLayout) C12809f.m76829b(this, R$id.oobe_error_tips);
        this.f12529D = (OOBETopView) C12809f.m76829b(this, R$id.oobe_start_top_frame);
        if (this.f12406f == 1) {
            C11842p.m70827j2(this.f12528C, C11842p.m70789a0(this));
        }
        if (m16876v0()) {
            this.f12529D.m17062l();
            m16847R0();
        } else {
            this.f12529D.m17054d(this, 48);
        }
        String strM16841O = m16841O();
        ((TextView) C12809f.m76829b(this, R$id.oobe_error_tips_text)).setText(strM16841O);
        ((TextView) C12809f.m76829b(this, R$id.oobe_server_not_avaiable_tips)).setText(strM16841O);
        RelativeLayout relativeLayout2 = (RelativeLayout) C12809f.m76829b(this, R$id.set_network_not_connect);
        LinearLayout linearLayout2 = (LinearLayout) C12809f.m76829b(this, R$id.network_not_connect);
        HwButton hwButton = (HwButton) C12809f.m76829b(this, R$id.oobe_net_error_tips_set_net);
        this.f12422v = hwButton;
        hwButton.setOnClickListener(this);
        initHwButton(this.f12422v);
        ((RelativeLayout) C12809f.m76829b(this, R$id.oobe_net_error_tips_retry)).setOnClickListener(this);
        this.f12421u.setOnClickListener(this);
        relativeLayout2.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(0, ((int) (i11 * 0.8d * 0.16d)) + this.f12337a, 0, 0);
        this.f12411k.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        int i12 = (int) (i10 * 0.3d);
        layoutParams2.setMargins(0, i12, 0, 0);
        this.f12410j.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams3.setMargins(0, i12, 0, 0);
        this.f12412l.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams4.setMargins(0, (int) (this.f12339c * 0.1d), 0, 0);
        this.f12417q.setLayoutParams(layoutParams4);
        setEmptyViewMarginTop(this.f12418r);
        setEmptyViewMarginTop(this.f12419s);
        textView.setOnClickListener(this);
        textView2.setOnClickListener(this);
        this.f12423w.setOnClickListener(this);
        this.f12424x.setOnClickListener(this);
        int dimensionPixelSize = (C0219i.m1463a() < 17 && C11842p.m70771U0()) ? getResources().getDimensionPixelSize(R$dimen.margin_l) : getResources().getDimensionPixelSize(R$dimen.margin_xl);
        if (m16876v0()) {
            m16866f0();
        } else if (C0219i.m1463a() >= 27) {
            C11842p.m70799c2(this, this.f12527B);
        } else if (C0219i.m1463a() >= 27 || C0219i.m1463a() < 23) {
            this.f12527B.setMarginHorizontal(dimensionPixelSize);
        } else {
            C11842p.m70795b2(this, this.f12527B);
        }
        this.f12527B.setBackBtnClickListener(this);
        this.f12527B.setNextBtnClickListener(this);
        m16801T0();
        m16867g0();
    }

    /* renamed from: n0 */
    public /* synthetic */ void m16809n0() {
        C13227f.m79492i1().m79566Q0(C13452e.m80781L().m80971t0(), "finderSetupLockScreen", "SimplifyOOBEQueryinfoActivity", "isLock:" + C0209d.m1301r1(this));
    }

    /* renamed from: o0 */
    public static /* synthetic */ void m16811o0(String str) {
        C13227f.m79492i1().m79566Q0(C13452e.m80781L().m80971t0(), "finderSetupLockScreen", "SimplifyOOBEQueryinfoActivity", str);
    }

    /* renamed from: r0 */
    public void m16815r0(int i10, int i11, int i12, int i13) {
        C11839m.m70688i("SimplifyOOBEQueryinfoActivity", " layoutSet noNet:" + i10 + " notAvi:" + i11 + " timeOut:" + i12 + "querying:" + i13);
        this.f12416p.setVisibility(8);
        initHwButton(this.f12422v);
        int i14 = this.f12406f;
        if (2 == i14 || 3 == i14 || i14 == 0) {
            m16839N(i10, i11, i12, i13);
            return;
        }
        if (1 == i14) {
            if (!m16876v0() || this.f12414n) {
                C11839m.m70686d("SimplifyOOBEQueryinfoActivity", " enteryTypeFromOobe(noNet, notAvi, timeOut, querying)");
                m16837M(i10, i11, i12, i13);
            } else {
                C11839m.m70686d("SimplifyOOBEQueryinfoActivity", " layoutSetGrateThanHarmony3_1(noNet, notAvi, timeOut, querying)");
                m16874s0(i10, i11, i12, i13);
            }
        }
    }

    /* renamed from: t0 */
    private void m16818t0() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        setResult(-1);
        if (C0209d.m1200P1(this)) {
            C0209d.m1318v2(this);
        }
        finish();
    }

    /* renamed from: y0 */
    private void m16824y0(boolean z10) {
        boolean z11 = this.f12535J.getBoolean("is_agree_to_basic_user");
        C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "processCloudBackupSwitch, switch status = " + z10 + " isBackupBasic: " + z11);
        if (!z11 || z10) {
            C11019b.m66371t().m66425j(z10);
        } else {
            C11019b.m66371t().m66431m();
        }
    }

    /* renamed from: A0 */
    public final void m16826A0(Message message) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (message == null) {
            C11839m.m70689w("SimplifyOOBEQueryinfoActivity", "processOpenFinderResult message is null ");
            return;
        }
        if (new C10343b(message.getData()).m63682d("phonefinder_result", false) && this.f12406f == 1 && C1010e.m6125b().m6150p(getApplicationContext()) && !C0209d.m1301r1(getApplicationContext())) {
            m16849S0();
        } else {
            C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "processOpenFinderResult finish");
            finish();
        }
    }

    /* renamed from: C0 */
    public final void m16827C0(String str, boolean z10) {
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        if (HNConstants.DataType.MEDIA.equals(str)) {
            if (C0209d.m1166E1()) {
                C1006a.m5936k().m5951O(z10, this);
                c10028cM62182c0.m62336h2("uploadphotokey", z10);
                return;
            }
            return;
        }
        if ("wlan".equals(str)) {
            if (C0209d.m1166E1()) {
                c10028cM62182c0.m62336h2(str, z10);
                return;
            }
            return;
        }
        boolean z11 = false;
        if ("addressbook".equals(str)) {
            if (z10 && !C0209d.m1293p1()) {
                z11 = true;
            }
            c10028cM62182c0.m62336h2(str, z11);
            return;
        }
        if ("notepad".equals(str)) {
            if (z10 && C0209d.m1215U1(this)) {
                z11 = true;
            }
            c10028cM62182c0.m62336h2(str, z11);
            return;
        }
        if (!"browser".equals(str)) {
            c10028cM62182c0.m62336h2(str, z10);
            return;
        }
        if (z10 && !C0209d.m1293p1()) {
            z11 = true;
        }
        c10028cM62182c0.m62336h2(str, z11);
    }

    /* renamed from: E0 */
    public final void m16828E0() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        Class clsM66441r = C11019b.m66371t().m66441r("BackupMainforSettingActivity");
        if (!c10028cM62182c0.m62395t1("funcfg_cloud_backup") && clsM66441r != null) {
            getPackageManager().setComponentEnabledSetting(new ComponentName(this, (Class<?>) clsM66441r), 2, 1);
        }
        m16830G0();
        C11019b.m66371t().m66376C(this);
        C11019b.m66371t().m66442r0(this);
    }

    /* renamed from: F0 */
    public final void m16829F0() {
        m16815r0(8, 8, 8, 0);
        this.f12547V.sendEmptyMessageDelayed(1, 30000L);
        this.f12537L++;
        C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "queryServerTime =" + this.f12537L + " entryType = " + this.f12406f);
        if (1 == this.f12406f) {
            C11019b.m66371t().m66435o(this, this.f12547V, this.f12537L, true);
        } else {
            C11019b.m66371t().m66435o(this, this.f12547V, this.f12537L, false);
        }
    }

    /* renamed from: G0 */
    public final void m16830G0() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        m16670j();
        C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "oobe BasicModuleConfigV3Rsp.MATCH_SUCCESS, entry type = " + this.f12406f);
        if (this.f12414n) {
            setResult(-1);
            finish();
            return;
        }
        int i10 = this.f12406f;
        if (i10 == 3) {
            Intent intent = new Intent();
            intent.setClassName(this, "com.huawei.android.remotecontrol.ui.PhoneFinderActivity");
            intent.setAction("com.huawei.android.remotecontrol.PHONEFINDER_ENTTRANCE");
            String packageName = this.f12409i;
            if (packageName == null) {
                packageName = getPackageName();
            }
            intent.putExtra(RemoteMessageConst.FROM, packageName);
            startActivity(intent);
            new HwAnimationReflection(this).m15927c(2);
            m16833I0();
            finish();
            return;
        }
        if (i10 != 1) {
            if (i10 != 2) {
                setResult(-1);
                finish();
                return;
            }
            Class clsM66441r = C11019b.m66371t().m66441r("HisyncGuideActivity");
            if (clsM66441r != null) {
                Intent intent2 = new Intent(getApplicationContext(), (Class<?>) clsM66441r);
                intent2.putExtra("intent_from_settings", this.f12413m);
                startActivityForResult(intent2, 10004);
                return;
            }
            return;
        }
        if (m16876v0() && ModuleConfigUtil.getInstance().isAllModuleDisabledIncludePhonefinder(this)) {
            C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "ModuleConfigUtil.getInstance().isAllModuleDisabledIncludePhonefinder(this)");
            m16815r0(8, 0, 8, 8);
            return;
        }
        if (m16854Y() || m16863d0()) {
            return;
        }
        if (isFinishing() || isDestroyed()) {
            C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "SimplifyOOBEQueryinfoActivity is finishiing");
            return;
        }
        Intent intentM16846R = m16846R();
        Bundle bundle = new Bundle();
        bundle.putInt(FamilyShareConstants.ENTRY_TYPE, this.f12406f);
        bundle.putBoolean("is_from_mr_guide", this.f12408h);
        if (!TextUtils.isEmpty(this.f12536K)) {
            bundle.putString("channel_of_open_switch", this.f12536K);
            C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "channel_of_open_switch " + this.f12536K);
        }
        intentM16846R.putExtras(bundle);
        startActivityForResult(intentM16846R, 10004);
    }

    /* renamed from: H0 */
    public void m16831H0(List<View> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f12532G.addAll(list);
    }

    /* renamed from: I */
    public final boolean m16832I(int i10) {
        return i10 == R$id.retry_getinfo || i10 == R$id.set_retry_getinfo || i10 == R$id.set_network_not_connect || i10 == R$id.network_not_connect || i10 == R$id.oobe_net_error_tips_retry || i10 == R$id.oobe_server_error_tips || i10 == R$id.getserver_info_timeout_layout || i10 == R$id.set_getserver_info_timeout_layout;
    }

    /* renamed from: I0 */
    public final void m16833I0() {
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        boolean zM62395t1 = c10028cM62182c0.m62395t1("is_already_configed_NV4");
        boolean zM62221H1 = c10028cM62182c0.m62221H1();
        if (zM62395t1 && zM62221H1) {
            C13227f.m79492i1().m79561L0("16");
        }
    }

    /* renamed from: J0 */
    public final void m16834J0() {
        ArrayList<DriveConfigService> arrayListM66454y = C11019b.m66371t().m66454y(this);
        if (arrayListM66454y.isEmpty()) {
            C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "saveSwitchStatus driveConfigService is null");
            return;
        }
        C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "saveSwitchStatus driveConfigService count = " + arrayListM66454y.size());
        Iterator<DriveConfigService> it = arrayListM66454y.iterator();
        while (it.hasNext()) {
            String id2 = it.next().getId();
            this.f12405e.m62336h2(id2, C11019b.m66371t().m66372A(this, id2, true));
        }
    }

    /* renamed from: K0 */
    public final void m16835K0() {
        C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "saveStatusAndSetOOBBEFinish: ");
        C11019b.m66371t().m66420g0(this);
        C11829c.m70582h1(this, this.f12536K);
        C11019b.m66371t().m66419g(this);
        C10028c.m62182c0().m62377p3("is_all_guide_over", true);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEAuthCallbackActivity, p709vj.InterfaceC13449b
    /* renamed from: L */
    public void mo13808L(Exception exc) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 1002;
        this.f12544S.sendMessage(messageObtain);
    }

    /* renamed from: L0 */
    public final boolean m16836L0() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "saveSwitchStatus");
        if (m16869j0()) {
            C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "OOBE guide all module disabled");
            setResult(-1);
            finish();
            return true;
        }
        m16853X0();
        if (this.f12405e.m62395t1("funcfg_cloud_backup") && !C0209d.m1293p1()) {
            C11019b.m66371t().m66425j(C11019b.m66371t().m66372A(this, "cloudbackup", true));
        }
        if (this.f12405e.m62395t1("funcfg_gallery") && !C0209d.m1293p1()) {
            C11019b.m66371t().m66445t0(this);
        }
        ArrayList<SyncConfigService> arrayListM66456z = C11019b.m66371t().m66456z(this);
        if (arrayListM66456z == null || arrayListM66456z.size() <= 0) {
            C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "saveSwitchStatus syncconfig services is null");
        } else {
            C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "saveSwitchStatus syncconfig services count = " + arrayListM66456z.size());
            Iterator<SyncConfigService> it = arrayListM66456z.iterator();
            while (it.hasNext()) {
                String id2 = it.next().getId();
                this.f12405e.m62336h2(id2, C11019b.m66371t().m66372A(this, id2, true));
            }
        }
        m16834J0();
        if (!m16876v0()) {
            return false;
        }
        m16835K0();
        C0209d.m1318v2(this);
        setResult(-1);
        if (C11829c.m70536O0()) {
            m16790B0(true);
        } else {
            C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "not support phoneFinder finish");
            finish();
        }
        return true;
    }

    /* renamed from: M */
    public final void m16837M(int i10, int i11, int i12, int i13) {
        m16859a1(false);
        m16857Z0(false);
        if (C0219i.m1463a() < 17) {
            this.f12411k.setVisibility(i11);
            this.f12412l.setVisibility(i12);
            this.f12410j.setVisibility(i10);
            this.f12528C.setVisibility(8);
            this.f12420t.setVisibility(8);
            this.f12421u.setVisibility(8);
        } else {
            this.f12411k.setVisibility(8);
            this.f12412l.setVisibility(8);
            this.f12410j.setVisibility(8);
            if (m16876v0() && i11 == 0) {
                m16851W0(true);
            } else {
                this.f12528C.setVisibility(i11);
            }
            this.f12420t.setVisibility(i10);
            this.f12421u.setVisibility(i12);
        }
        this.f12418r.setVisibility(8);
        this.f12417q.setVisibility(8);
        this.f12416p.setVisibility(i13);
        this.f12527B.m17046h();
        this.f12527B.m17049k();
        if (i10 == 0 || i12 == 0) {
            this.f12527B.setNextBtnText(getString(R$string.oobe_skip));
            if (C0219i.m1463a() >= 21) {
                this.f12527B.m17048j();
            } else {
                this.f12527B.m17041c();
            }
        } else {
            this.f12527B.setNextBtnText(getString(R$string.next_step));
            this.f12527B.m17048j();
        }
        if (i13 == 0) {
            this.f12527B.m17042d();
        } else {
            this.f12527B.m17049k();
        }
    }

    /* renamed from: M0 */
    public final void m16838M0() {
        C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "close ad switch");
        AdSwitchManager.getInstance().setPersonalizationAdSwitch(false);
        AdSwitchManager.getInstance().setHuaweiAdSwitch(false);
        AdSwitchManager.getInstance().setThreeAdSwitch(false);
    }

    /* renamed from: N */
    public final void m16839N(int i10, int i11, int i12, int i13) {
        this.f12410j.setVisibility(8);
        this.f12411k.setVisibility(8);
        this.f12412l.setVisibility(8);
        if (C0219i.m1463a() < 17) {
            this.f12417q.setVisibility(i11);
            this.f12419s.setVisibility(i12);
            this.f12418r.setVisibility(i10);
            this.f12528C.setVisibility(8);
            this.f12421u.setVisibility(8);
            this.f12420t.setVisibility(8);
        } else {
            this.f12417q.setVisibility(8);
            this.f12419s.setVisibility(8);
            this.f12418r.setVisibility(8);
            this.f12528C.setVisibility(i11);
            this.f12421u.setVisibility(i12);
            this.f12420t.setVisibility(i10);
        }
        this.f12416p.setVisibility(i13);
        if (i11 == 0) {
            m16673m();
        }
        this.f12527B.m17039a();
    }

    /* renamed from: N0 */
    public void m16840N0(boolean z10) {
        if (z10) {
            this.f12542Q.setText(R$string.cloud_oobe_agree_and_proceed);
            this.f12540O.setVisibility(0);
            C11842p.m70850p1(this, (SpanClickText) C12809f.m76829b(this, R$id.unifrom_privacy_content_first), (SpanClickText) C12809f.m76829b(this, R$id.unifrom_privacy_content_second), (SpanClickText) C12809f.m76829b(this, R$id.unifrom_privacy_content_third), (SpanClickText) C12809f.m76829b(this, R$id.unifrom_privacy_content_fourth), true, false, true);
        } else {
            this.f12540O.setVisibility(8);
            this.f12542Q.setText(R$string.cloud_oobe_open_and_proceed);
            m16838M0();
        }
    }

    /* renamed from: O */
    public final String m16841O() {
        String string = getString(R$string.set_get_info_not_avi, getString(R$string.contact_email_value));
        if (!C0209d.m1278l2("zh") || TextUtils.isEmpty(string) || string.endsWith("。")) {
            return string;
        }
        return string + "。";
    }

    /* renamed from: O0 */
    public final void m16842O0(boolean z10) {
        if (this.f12542Q == null) {
            this.f12542Q = (HwButton) findViewById(R$id.open_cloud_button);
        }
        HwButton hwButton = this.f12542Q;
        if (hwButton != null) {
            hwButton.setEnabled(z10);
        }
    }

    /* renamed from: P */
    public List<View> m16843P() {
        ArrayList arrayList = new ArrayList();
        NotchBottomFitRelativeLayout notchBottomFitRelativeLayout = this.f12530E;
        if (notchBottomFitRelativeLayout != null) {
            arrayList.add(notchBottomFitRelativeLayout);
        }
        NotchFitOOBENavLinearLayout notchFitOOBENavLinearLayout = this.f12531F;
        if (notchFitOOBENavLinearLayout != null) {
            arrayList.add(notchFitOOBENavLinearLayout);
        }
        return arrayList;
    }

    /* renamed from: P0 */
    public final void m16844P0(Dialog dialog) {
        C11829c.m70600n1(dialog, !this.f12408h && C0209d.m1200P1(this), this.f12406f == 1);
    }

    /* renamed from: Q0 */
    public final void m16845Q0() {
        if (C0219i.m1463a() < 23 && C0219i.m1463a() >= 21) {
            setContentView(R$layout.simplify_oobe_queryinfo_emui10);
            return;
        }
        if (m16876v0()) {
            setContentView(R$layout.simplify_oobe_queryinfo_harmony_os_3_1);
        } else if (C0219i.m1463a() >= 23) {
            setContentView(R$layout.simplify_oobe_queryinfo);
        } else {
            setContentView(R$layout.simplify_oobe_queryinfo_emui9);
        }
    }

    /* renamed from: R */
    public final Intent m16846R() {
        return (C0219i.m1463a() < 21 || !C13452e.m80781L().m80803F0().booleanValue()) ? new Intent(getApplicationContext(), (Class<?>) SimplifyOOBEGuideActivity.class) : C11829c.m70534N0(this, C13452e.m80781L().m80942m()) ? new Intent(getApplicationContext(), (Class<?>) OOBEUniformGuideActivity.class) : new Intent(getApplicationContext(), (Class<?>) SimplifyOOBEGuideActivity.class);
    }

    /* renamed from: R0 */
    public final void m16847R0() {
        TextView textView = (TextView) C12809f.m76829b(this, R$id.is_query_server_info);
        if (textView != null) {
            textView.setText(R$string.query_server_info);
            textView.append("…");
        }
    }

    /* renamed from: S */
    public final boolean m16848S(Context context, String str) {
        if (context == null) {
            return false;
        }
        return this.f12405e.m62395t1(str);
    }

    /* renamed from: S0 */
    public void m16849S0() {
        final String message;
        C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "setLockScreen");
        Intent intent = new Intent();
        intent.setAction("com.android.settings.SETUP_LOCK_SCREEN");
        C0209d.m1302r2(intent, "com.android.settings");
        intent.putExtra("useImmersiveMode", true);
        intent.putExtra("firstRun", true);
        intent.putExtra("hasMultipleUsers", false);
        intent.putExtra("oobe_phonefinder", true);
        try {
            startActivityForResult(intent, 10025);
            message = "success";
        } catch (RuntimeException e10) {
            C11839m.m70689w("SimplifyOOBEQueryinfoActivity", "setLockScreen activity not found" + e10.getMessage());
            message = e10.getMessage();
        }
        C0226l0.m1585e(new Runnable() { // from class: zb.d
            @Override // java.lang.Runnable
            public final void run() {
                SimplifyOOBEQueryinfoActivity.m16811o0(message);
            }
        }, 60000L);
    }

    /* renamed from: U */
    public boolean m16850U(Context context, String str, boolean z10) {
        return !m16871l0(context) ? z10 : m16848S(context, str);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEAuthCallbackActivity, p709vj.InterfaceC13449b
    /* renamed from: W */
    public void mo13820W(Bundle bundle) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 1001;
        this.f12544S.sendMessage(messageObtain);
    }

    /* renamed from: W0 */
    public void m16851W0(boolean z10) {
        this.f12415o = z10;
        if (this.f12539N == null || this.f12540O == null || this.f12542Q == null || this.f12541P == null) {
            return;
        }
        m16859a1(true);
        m16857Z0(false);
        C12809f.m76843p(this.f12416p, false);
        if (!this.f12415o) {
            this.f12539N.setText(R$string.cloud_oobe_tips);
            this.f12540O.setVisibility(0);
            this.f12541P.setVisibility(0);
            this.f12542Q.setText(R$string.cloud_oobe_agree_and_proceed);
            return;
        }
        C10028c.m62182c0().m62377p3("is_all_guide_over", true);
        m16672l(true);
        C0209d.m1318v2(this);
        this.f12539N.setText(m16841O());
        this.f12540O.setVisibility(8);
        this.f12541P.setVisibility(4);
        this.f12542Q.setText(R$string.cloud_oobe_continue_btn);
    }

    /* renamed from: X */
    public final void m16852X() {
        Class clsM66441r = C11019b.m66371t().m66441r("BackupMainforSettingActivity");
        if (clsM66441r != null) {
            getPackageManager().setComponentEnabledSetting(new ComponentName(this, (Class<?>) clsM66441r), 2, 1);
        }
        this.f12405e.m62377p3("is_already_configed_NV4", true);
        this.f12405e.m62377p3("funcfg_cloud_backup", false);
        this.f12405e.m62377p3("funcfg_find_my_phone_globe", false);
        C11019b.m66371t().m66374B(this);
        this.f12547V.sendEmptyMessage(4);
    }

    /* renamed from: X0 */
    public final void m16853X0() {
        if (this.f12405e.m62395t1("funcfg_contacts") && !C0209d.m1293p1()) {
            this.f12405e.m62336h2("addressbook", C11019b.m66371t().m66372A(this, "addressbook", true));
        }
        if (this.f12405e.m62395t1("funcfg_calendar")) {
            this.f12405e.m62336h2("calendar", m16850U(this, "calendar_toogle", false));
        }
        if (this.f12405e.m62395t1("funcfg_wlan")) {
            this.f12405e.m62336h2("wlan", C0209d.m1166E1() ? m16850U(this, "wlan_toogle", false) : false);
        }
        if (this.f12405e.m62395t1("funcfg_browser") && C11019b.m66371t().m66391K(this) && !C0209d.m1293p1()) {
            this.f12405e.m62336h2("browser", m16850U(this, "browser_toogle", false));
        }
        if (this.f12405e.m62395t1("funcfg_notes") && C0209d.m1215U1(this)) {
            this.f12405e.m62336h2("notepad", m16850U(this, "notepad_toogle", false));
        }
    }

    /* renamed from: Y */
    public final boolean m16854Y() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!m16870k0()) {
            return false;
        }
        C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "swith already config ");
        boolean zM16864d1 = m16864d1();
        setResult(-1);
        if (!zM16864d1) {
            return true;
        }
        finish();
        return true;
    }

    /* renamed from: Y0 */
    public final void m16855Y0() {
        C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "showFailedTips");
        Toast.makeText(this, getString(R$string.cloud_oobe_loading_failed), 0).show();
        m16857Z0(false);
    }

    /* renamed from: Z */
    public final void m16856Z() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (m16876v0()) {
            C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "needShowNewUIStyle: showLoadingDialog(false)");
            m16857Z0(false);
        } else {
            setResult(4);
            finish();
        }
    }

    /* renamed from: Z0 */
    public final void m16857Z0(boolean z10) {
        if (this.f12538M == null) {
            if (!z10) {
                return;
            }
            ProgressDialog progressDialog = new ProgressDialog(this);
            this.f12538M = progressDialog;
            progressDialog.setMessage(getString(R$string.cloud_oobe_configuring_cloud_space));
            this.f12538M.setCancelable(false);
            this.f12538M.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: zb.b
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    this.f63327a.m16872p0(dialogInterface);
                }
            });
        }
        if (z10 && !this.f12538M.isShowing()) {
            C11829c.m70600n1(this.f12538M, false, true);
            if (!isFinishing() && !isDestroyed()) {
                this.f12538M.show();
            }
        }
        if (!z10 && this.f12538M.isShowing()) {
            this.f12538M.dismiss();
        }
        m16842O0(!z10);
    }

    /* renamed from: a0 */
    public final void m16858a0() {
        this.f12547V.removeMessages(1);
        if (!C0209d.m1333z1(getApplicationContext())) {
            this.f12547V.sendEmptyMessage(3);
            return;
        }
        m16672l(false);
        this.f12533H = true;
        m16815r0(8, 8, 0, 8);
    }

    /* renamed from: a1 */
    public final void m16859a1(boolean z10) {
        C12809f.m76843p(this.f12545T, z10);
        C12809f.m76843p(this.f12546U, z10);
    }

    /* renamed from: b0 */
    public final void m16860b0() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "oobe get server info not avi");
        if (this.f12414n) {
            setResult(-1);
            finish();
            return;
        }
        if (this.f12406f != 3) {
            m16815r0(8, 0, 8, 8);
            this.f12547V.removeMessages(1);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(this, "com.huawei.android.remotecontrol.ui.PhoneFinderActivity");
        intent.setAction("com.huawei.android.remotecontrol.PHONEFINDER_ENTTRANCE");
        String packageName = this.f12409i;
        if (packageName == null) {
            packageName = getPackageName();
        }
        intent.putExtra(RemoteMessageConst.FROM, packageName);
        startActivity(intent);
        new HwAnimationReflection(getApplicationContext()).m15927c(2);
        finish();
    }

    /* renamed from: c */
    public final void m16861c() throws IllegalAccessException, IllegalArgumentException {
        View decorView;
        if (C0219i.m1463a() < 17 || !C11829c.m70563b0(this)) {
            return;
        }
        C11829c.m70591k1(this);
        Window window = getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 1024);
    }

    /* renamed from: c0 */
    public final void m16862c0() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.f12533H) {
            return;
        }
        this.f12547V.removeMessages(1);
        m16828E0();
    }

    /* renamed from: d0 */
    public final boolean m16863d0() {
        return C0219i.m1463a() >= 21 && C11829c.m70534N0(this, C13452e.m80781L().m80942m()) && m16836L0();
    }

    /* renamed from: d1 */
    public final boolean m16864d1() {
        Bundle bundle = this.f12535J;
        boolean z10 = true;
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object obj = this.f12535J.get(str);
                boolean zBooleanValue = obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false;
                if (str.equals("cloudbackup")) {
                    m16824y0(zBooleanValue);
                } else if (str.equals("phoneFinder")) {
                    m16790B0(zBooleanValue);
                    z10 = !zBooleanValue;
                } else {
                    m16827C0(str, zBooleanValue);
                }
            }
        }
        m16835K0();
        return z10;
    }

    /* renamed from: e0 */
    public void m16865e0() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (m16876v0()) {
            HwToolbar hwToolbarFindViewById = findViewById(R$id.hwtoolbar);
            if (hwToolbarFindViewById == null) {
                C11839m.m70689w("SimplifyOOBEQueryinfoActivity", "mToolbar is null");
                return;
            }
            m16861c();
            hwToolbarFindViewById.setVisibility(0);
            setActionBar(hwToolbarFindViewById);
            ActionBar actionBar = getActionBar();
            if (actionBar == null) {
                return;
            }
            Window window = getWindow();
            if (window != null) {
                window.getDecorView().setBackgroundResource(R$color.pay_activity_harmony_bg);
            }
            hwToolbarFindViewById.setPadding(hwToolbarFindViewById.getPaddingLeft(), C11842p.m70789a0(this), hwToolbarFindViewById.getPaddingRight(), hwToolbarFindViewById.getPaddingBottom());
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
            C11842p.m70842n1(actionBar, new ColorDrawable(0));
            actionBar.setBackgroundDrawable(new ColorDrawable(0));
            this.f12527B.setVisibility(8);
            C11829c.m70627w1(this, getWindow());
        }
    }

    /* renamed from: f0 */
    public final void m16866f0() {
        C11839m.m70686d("SimplifyOOBEQueryinfoActivity", "initGrateOrEqualsThanHarmony31View");
        this.f12539N = (TextView) C12809f.m76829b(this, R$id.oobe_start_tips_first);
        this.f12542Q = (HwButton) findViewById(R$id.open_cloud_button);
        this.f12541P = (HwButton) findViewById(R$id.open_later);
        this.f12540O = findViewById(R$id.oobe_privacy);
        this.f12545T = findViewById(R$id.oobe_main_content);
        View viewFindViewById = findViewById(R$id.open_or_later_frame);
        this.f12546U = viewFindViewById;
        viewFindViewById.setVisibility(0);
        m16840N0(TextUtils.equals("CN", C0209d.m1328y0(this)));
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEAuthCallbackActivity, android.app.Activity
    public void finish() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        m16857Z0(false);
        super.finish();
        if (m16876v0()) {
            overridePendingTransition(0, 0);
        } else {
            new HwAnimationReflection(this).m15927c(2);
        }
    }

    /* renamed from: g0 */
    public void m16867g0() {
        List<View> listM16843P = m16843P();
        List<List<View>> listM70887y2 = C11842p.m70887y2(listM16843P);
        if (C0219i.m1463a() >= 17 && C11829c.m70563b0(this)) {
            C12806c.m76821l(this, listM16843P);
            C12806c.m76820k(this, listM70887y2.get(1));
        }
        m16831H0(listM70887y2.get(0));
        C12806c.m76820k(this, listM70887y2.get(0));
    }

    /* renamed from: i0 */
    public final void m16868i0() throws Resources.NotFoundException {
        Resources resources = getResources();
        if (resources == null) {
            C11839m.m70687e("SimplifyOOBEQueryinfoActivity", "resources null");
            return;
        }
        Configuration configuration = resources.getConfiguration();
        if (configuration == null) {
            C11839m.m70687e("SimplifyOOBEQueryinfoActivity", "configuration null");
            return;
        }
        if (this.f12406f == 1) {
            if (C0219i.m1463a() >= 27) {
                C11842p.m70799c2(this, this.f12527B);
                return;
            }
            if (C0219i.m1463a() < 27 && C0219i.m1463a() >= 23) {
                C11842p.m70795b2(this, this.f12527B);
                return;
            }
            if (C0219i.m1463a() >= 17) {
                if (!C11842p.m70771U0() && !C11842p.m70747M0(this)) {
                    C11842p.m70783Y0(this);
                } else if (configuration.orientation == 2) {
                    C11842p.m70802d1(this);
                } else {
                    C11842p.m70798c1(this);
                }
            }
        }
    }

    /* renamed from: j0 */
    public final boolean m16869j0() {
        return (this.f12405e.m62395t1("funcfg_contacts") || this.f12405e.m62395t1("funcfg_cloud_backup") || this.f12405e.m62395t1("funcfg_wlan") || this.f12405e.m62395t1("funcfg_calendar") || this.f12405e.m62395t1("funcfg_notes") || this.f12405e.m62395t1("funcfg_gallery") || this.f12405e.m62395t1("funcfg_browser") || C11829c.m70536O0()) ? false : true;
    }

    /* renamed from: k0 */
    public final boolean m16870k0() {
        return C13452e.m80781L().m80803F0().booleanValue() && C0219i.m1463a() >= 27 && !m16876v0() && !C0209d.m1269j1() && !this.f12407g && this.f12406f == 1;
    }

    /* renamed from: l0 */
    public boolean m16871l0(Context context) {
        if (context != null) {
            return C10028c.m62183d0(context).m62395t1("toggle_default");
        }
        return false;
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "onActivityResult requestCode " + i10 + " resultCode " + i11);
        if (i10 == 1003) {
            if (-1 == i11) {
                C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "simplify OOBE  login successful.");
                if (m16876v0()) {
                    m16815r0(8, 8, 8, 0);
                }
                C1162b.m7257a().m7260d(this, this);
                return;
            }
            C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "simplify OOBE login canceled resultCode : " + i11);
            setResult(0);
        } else {
            if (i10 == 10019) {
                C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "hms update,cancel or result_ok");
                m16856Z();
                return;
            }
            if (i10 == 8701) {
                C13195l.m79272J().m79299O(this, this, i10, i11, intent);
                if (i11 == 0) {
                    C11839m.m70687e("SimplifyOOBEQueryinfoActivity", "hms foreground login failed");
                    m16856Z();
                    return;
                }
                return;
            }
            if (i10 == 10004 && i11 == 1003) {
                C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "download Config");
                this.f12534I = true;
                if (intent != null) {
                    this.f12535J = new SafeIntent(intent).getBundleExtra("tempKeyBundle");
                }
                m16803V();
                return;
            }
            if (i10 == 10004 && i11 == 0 && m16876v0()) {
                m16857Z0(false);
                return;
            }
            if (i10 == 10025) {
                C0226l0.m1585e(new Runnable() { // from class: zb.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f63328a.m16809n0();
                    }
                }, 60000L);
                if (C0209d.m1301r1(this)) {
                    C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "update public key");
                    C1010e.m6125b().m6131F(getApplicationContext());
                }
                setResult(-1);
            } else if (-1 == i11) {
                setResult(-1);
            } else if (i11 == 1) {
                setResult(1);
            } else {
                setResult(0);
            }
        }
        finish();
    }

    @Override // android.app.Activity
    public void onBackPressed() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "onBackPressed");
        setResult(this.f12415o ? -1 : 0);
        finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int id2 = view.getId();
        if (view.getId() == R$id.oobe_nav_back_layout) {
            setResult(703);
            if (this.f12534I) {
                C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "FromUniformGuide，clean data");
                C11019b.m66371t().m66415e();
                C13612b.m81829B().m81888u();
                C13452e.m80781L().m80885a();
                C10028c.m62182c0().m62338i();
            }
            finish();
            return;
        }
        if (view.getId() == R$id.oobe_nav_next_layout) {
            if (!this.f12415o) {
                C10028c.m62182c0().m62377p3("is_all_guide_over", false);
            }
            m16818t0();
            return;
        }
        if (id2 == R$id.set_the_net || id2 == R$id.set_no_net_btn || id2 == R$id.oobe_net_error_tips_set_net) {
            C11829c.m70615s1(this, this.f12406f);
            return;
        }
        if (m16832I(id2)) {
            m16800T();
            return;
        }
        if (id2 != R$id.open_cloud_button) {
            if (view.getId() == R$id.open_later) {
                m16877w0();
                return;
            }
            return;
        }
        AdSwitchManager.getInstance().saveAdSwitch();
        if (this.f12415o) {
            setResult(-1);
            finish();
            return;
        }
        m16857Z0(true);
        if (view instanceof HwButton) {
            ((HwButton) view).setEnabled(false);
            C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "click open_cloud_button");
        }
        m16800T();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEQueryBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEAuthCallbackActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        m16868i0();
        m16545b(this.f12423w);
        m16545b(this.f12424x);
        initHwButton(this.f12422v);
        setEmptyViewMarginTop(this.f12418r);
        setEmptyViewMarginTop(this.f12419s);
        if (C0219i.m1463a() >= 27) {
            C11842p.m70799c2(this, this.f12527B);
        } else {
            if (C0219i.m1463a() >= 27 || C0219i.m1463a() < 23) {
                return;
            }
            C11842p.m70795b2(this, this.f12527B);
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEAuthCallbackActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        C13192i.m79258g().m79267m(true);
        super.onCreate(bundle);
        if (bundle != null) {
            this.f12549z = bundle.getBoolean("is_recreate");
            C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "isRecreated: " + this.f12549z);
        }
        C1163c.m7263b(true);
        getWindow().setFlags(16777216, 16777216);
        C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "come in query activity");
        m16674n();
        m16845Q0();
        m16808h0();
        m16868i0();
        m16804V0();
        m16865e0();
        if (!m16876v0() || this.f12414n) {
            m16859a1(false);
            m16798J();
        }
        m16807e1();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C1163c.m7263b(false);
        ProgressDialog progressDialog = this.f12538M;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f12538M.dismiss();
        }
        AlertDialogC13156c alertDialogC13156c = this.f12543R;
        if (alertDialogC13156c == null || !alertDialogC13156c.isShowing()) {
            return;
        }
        this.f12543R.dismiss();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        C13227f.m79492i1().m79577X(this);
        UBAAnalyze.m29964Y("PVC", getClass().getCanonicalName(), "1", "18", super.m16544a());
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEAuthCallbackActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        C13227f.m79492i1().m79582b0(this);
        UBAAnalyze.m29967a0("PVC", getClass().getCanonicalName(), "1", "18");
        C13192i.m79258g().m79267m(true);
        m16802U0();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("is_recreate", this.f12526A);
    }

    /* renamed from: p0 */
    public final /* synthetic */ void m16872p0(DialogInterface dialogInterface) {
        m16842O0(true);
    }

    /* renamed from: q0 */
    public final /* synthetic */ void m16873q0(DialogInterface dialogInterface, int i10) {
        if (i10 == -1) {
            C11829c.m70615s1(this, this.f12406f);
        } else if (i10 == -2) {
            C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "showNoNetDialog, cancel");
        }
        this.f12543R.dismiss();
    }

    /* renamed from: s0 */
    public final void m16874s0(int i10, int i11, int i12, int i13) {
        if (i13 == 0) {
            m16857Z0(true);
            return;
        }
        m16857Z0(false);
        if (i10 == 0) {
            m16805b1();
        } else if (i12 == 0) {
            m16855Y0();
        } else {
            m16851W0(i11 == 0);
        }
    }

    /* renamed from: u0 */
    public final boolean m16875u0(int i10) {
        return (i10 == 1 || i10 == 1001 || i10 == 1002) ? false : true;
    }

    /* renamed from: v0 */
    public boolean m16876v0() {
        return C0219i.m1465c() && !this.f12408h;
    }

    /* renamed from: w0 */
    public final void m16877w0() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "openLater");
        setResult(1);
        m16806c1();
        C0209d.m1322w2(this);
        finish();
    }

    /* renamed from: x0 */
    public void m16878x0() {
        C11839m.m70688i("SimplifyOOBEQueryinfoActivity", "openPhoneFinder: ");
        if (isFinishing()) {
            C11839m.m70687e("SimplifyOOBEQueryinfoActivity", "OpenPhoneFinder is finishing");
        } else {
            C1010e.m6125b().m6135J(C0213f.m1377a());
            C12300b0.m73940b().m73943e(5);
        }
    }

    /* renamed from: z0 */
    public final void m16879z0(int i10) {
        if (i10 != -1) {
            C13192i.m79258g().m79265k(this, 10019, i10, 1);
        }
    }
}
