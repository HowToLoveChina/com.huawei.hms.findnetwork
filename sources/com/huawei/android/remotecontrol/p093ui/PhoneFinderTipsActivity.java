package com.huawei.android.remotecontrol.p093ui;

import android.app.ActionBar;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.huawei.android.hicloud.commonlib.util.HwAnimationReflection;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitLinearLayout;
import com.huawei.android.remotecontrol.sdk.R$color;
import com.huawei.android.remotecontrol.sdk.R$id;
import com.huawei.android.remotecontrol.sdk.R$layout;
import com.huawei.android.remotecontrol.sdk.R$string;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.secure.android.common.intent.SafeBroadcastReceiver;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import p015ak.C0209d;
import p428kj.AlertDialogC11057b;
import p514o9.C11842p;
import p520of.C11860j;
import p521og.C11877j;
import p521og.C11880m;
import p655te.C13009a;
import p664u0.C13108a;
import p681uj.C13195l;
import p684un.C13222a;
import p709vj.C13452e;
import p709vj.InterfaceC13450c;
import p783xp.C13843a;
import p809yg.C13981a;
import sk.C12809f;

/* loaded from: classes4.dex */
public class PhoneFinderTipsActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: A */
    public static PhoneFinderOpenReceiver f20505A;

    /* renamed from: s */
    public LinearLayout f20507s;

    /* renamed from: t */
    public LinearLayout f20508t;

    /* renamed from: u */
    public ScrollView f20509u;

    /* renamed from: v */
    public AlertDialogC11057b f20510v;

    /* renamed from: w */
    public String f20511w;

    /* renamed from: x */
    public boolean f20512x;

    /* renamed from: y */
    public Timer f20513y;

    /* renamed from: r */
    public NotchTopFitLinearLayout f20506r = null;

    /* renamed from: z */
    public C4470b f20514z = new C4470b();

    public static class PhoneFinderOpenReceiver extends SafeBroadcastReceiver {

        /* renamed from: k */
        public Activity f20515k;

        public PhoneFinderOpenReceiver(Activity activity) {
            this.f20515k = activity;
        }

        @Override // com.huawei.secure.android.common.intent.SafeBroadcastReceiver
        public void onReceiveMsg(Context context, Intent intent) {
            if (intent == null || context == null || this.f20515k == null) {
                return;
            }
            if (PhoneFinderTipsActivity.f20505A != null) {
                C13108a.m78878b(context.getApplicationContext()).m78883f(PhoneFinderTipsActivity.f20505A);
                PhoneFinderOpenReceiver unused = PhoneFinderTipsActivity.f20505A = null;
            }
            String action = intent.getAction();
            C13981a.m83989i("PhoneFinderTipsActivity", "receive action: " + action);
            if (!TextUtils.isEmpty(action) && "com.huawei.android.remotecontrol.intent.PHONEFINDER_RESULT".equals(action)) {
                Activity activity = this.f20515k;
                if (activity instanceof PhoneFinderTipsActivity) {
                    ((PhoneFinderTipsActivity) activity).m27213U1();
                }
                this.f20515k.finish();
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.PhoneFinderTipsActivity$a */
    public class C4469a extends TimerTask {
        public C4469a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            PhoneFinderTipsActivity.this.finish();
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.PhoneFinderTipsActivity$b */
    public class C4470b implements InterfaceC13450c {
        public C4470b() {
        }

        @Override // p709vj.InterfaceC13450c
        /* renamed from: a */
        public void mo20330a(ErrorStatus errorStatus) {
            C13981a.m83988e("PhoneFinderTipsActivity", "CloudAccount on error callback");
            if (errorStatus == null) {
                C13981a.m83988e("PhoneFinderTipsActivity", "errorStatus is null");
                return;
            }
            if (errorStatus.getErrorReason().isEmpty() || errorStatus.getErrorCode() == 3002) {
                return;
            }
            String errorReason = errorStatus.getErrorReason();
            C13981a.m83988e("PhoneFinderTipsActivity", "CloudAccount on error reason: " + errorReason);
            C11880m.m71337d(PhoneFinderTipsActivity.this, errorReason);
        }

        @Override // p709vj.InterfaceC13450c
        /* renamed from: b */
        public void mo20331b() {
            C13981a.m83989i("PhoneFinderTipsActivity", "CloudAccount on finish callback");
            Context applicationContext = PhoneFinderTipsActivity.this.getApplicationContext();
            C11877j.m71307t1(applicationContext);
            C11860j.m71037a1(1);
            C11860j.m71030X0(500);
            C11860j.m71051f0(applicationContext, 6, false);
            PhoneFinderTipsActivity.this.m27219c2();
            PhoneFinderTipsActivity.this.m27216X1(applicationContext);
        }
    }

    /* renamed from: Z1 */
    private void m27211Z1() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(getIntent());
        this.f20511w = hiCloudSafeIntent.getStringExtra(RemoteMessageConst.FROM);
        this.f20512x = hiCloudSafeIntent.getBooleanExtra("guide_open_phone_finder", false);
        if (!m27218b2() && (C11842p.m70771U0() || C11842p.m70735I0())) {
            m27214V1();
        }
        ActionBar actionBar = getActionBar();
        if (actionBar == null) {
            C13981a.m83988e("PhoneFinderTipsActivity", "actionBar is null");
            return;
        }
        int i10 = R$color.hicloud_hmos_bg;
        C11842p.m70842n1(actionBar, new ColorDrawable(getColor(i10)));
        actionBar.setBackgroundDrawable(new ColorDrawable(getColor(i10)));
        if (this.f20512x) {
            actionBar.hide();
        } else {
            actionBar.setTitle(getString(R$string.start_finder_phone_new));
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    /* renamed from: a2 */
    private void m27212a2() {
        setTheme(getResources().getIdentifier(C13843a.m83102x(), null, null));
        setContentView(R$layout.pf_tips_activity);
        this.f20506r = (NotchTopFitLinearLayout) C12809f.m76829b(this, R$id.tips_notch_fit_layout);
        this.f20507s = (LinearLayout) C12809f.m76829b(this, R$id.tips_top_region);
        this.f20508t = (LinearLayout) C12809f.m76829b(this, R$id.tips_bottom_region);
        this.f20509u = (ScrollView) C12809f.m76829b(this, R$id.pf_tips_scrollview);
        AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76829b(this, R$id.pf_start_button);
        getWindow().setStatusBarColor(getColor(R$color.hicloud_hmos_bg));
        if (3.2f == C0209d.m1195O(this) && autoSizeButton != null) {
            autoSizeButton.setGravity(1);
        }
        m27217Y1();
        mo19005p1();
        if (autoSizeButton != null) {
            autoSizeButton.setOnClickListener(this);
        }
        ImageView imageView = (ImageView) C12809f.m76829b(this, R$id.item_point1);
        ImageView imageView2 = (ImageView) C12809f.m76829b(this, R$id.item_point2);
        ImageView imageView3 = (ImageView) C12809f.m76829b(this, R$id.item_point3);
        TextView textView = (TextView) C12809f.m76829b(this, R$id.pf_tips_item1);
        TextView textView2 = (TextView) C12809f.m76829b(this, R$id.pf_tips_item2);
        TextView textView3 = (TextView) C12809f.m76829b(this, R$id.pf_tips_item3);
        if (TextUtils.equals("CN", GrsApp.getInstance().getIssueCountryCode(this))) {
            C13981a.m83989i("PhoneFinderTipsActivity", "grs is china");
            String strM80942m = C13452e.m80781L().m80942m();
            C13981a.m83989i("PhoneFinderTipsActivity", "countryCodeSp:" + strM80942m);
            if (strM80942m == null || TextUtils.isEmpty(strM80942m) || TextUtils.equals("CN", strM80942m)) {
                C12809f.m76840m(textView, R$string.open_phone_finder_content_1);
            } else {
                C12809f.m76840m(textView, R$string.open_phone_finder_content_4);
            }
        } else {
            C12809f.m76840m(textView, R$string.open_phone_finder_content_4);
        }
        imageView.setPadding(0, (textView.getLineHeight() * 5) / 11, 0, 0);
        imageView2.setPadding(0, (textView2.getLineHeight() * 5) / 11, 0, 0);
        imageView3.setPadding(0, (textView3.getLineHeight() * 5) / 11, 0, 0);
    }

    /* renamed from: U1 */
    public final void m27213U1() {
        Timer timer = this.f20513y;
        if (timer != null) {
            timer.cancel();
            this.f20513y = null;
        }
    }

    /* renamed from: V1 */
    public final void m27214V1() {
        LinearLayout linearLayout = (LinearLayout) C12809f.m76829b(this, R$id.detail_part);
        if (linearLayout != null) {
            int iM70844o = (int) (C11842p.m70753O0(this) ? C11842p.m70844o(this, ErrorCode.ERROR_WRITE_FAIL) : C11842p.m70844o(this, 400));
            ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
            if (layoutParams == null || !(layoutParams instanceof LinearLayout.LayoutParams)) {
                return;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.width = iM70844o;
            layoutParams2.gravity = 17;
            linearLayout.setLayoutParams(layoutParams2);
        }
    }

    /* renamed from: W1 */
    public final void m27215W1(String str) {
        String strM80790C = C13452e.m80781L().m80790C();
        C13009a.m78309d(str, "1", C13452e.m80781L().m80971t0(), C13222a.m79465g(this), strM80790C);
        UBAAnalyze.m29960U("PVP", str, "1", "19", "1", C13222a.m79465g(this), strM80790C);
    }

    /* renamed from: X1 */
    public final synchronized void m27216X1(Context context) {
        if (f20505A == null) {
            f20505A = new PhoneFinderOpenReceiver(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.huawei.android.remotecontrol.intent.PHONEFINDER_RESULT");
            C13108a.m78878b(context).m78880c(f20505A, intentFilter);
        }
    }

    /* renamed from: Y1 */
    public final void m27217Y1() {
        LinearLayout linearLayout = this.f20507s;
        if (linearLayout == null || this.f20508t == null) {
            C13981a.m83988e("PhoneFinderTipsActivity", "layout is null");
        } else {
            C11842p.m70795b2(this, linearLayout);
            C11842p.m70795b2(this, this.f20508t);
        }
    }

    /* renamed from: b2 */
    public final boolean m27218b2() {
        if (this.f20512x) {
            return false;
        }
        if (TextUtils.isEmpty(this.f20511w) || !("com.android.settings".equals(this.f20511w) || "com.huawei.systemmanager".equals(this.f20511w) || "com.huawei.hwid".equals(this.f20511w))) {
            return !C13452e.m80781L().m80842P0();
        }
        return true;
    }

    /* renamed from: c2 */
    public final void m27219c2() {
        if (this.f20513y == null) {
            this.f20513y = new Timer();
        }
        this.f20513y.schedule(new C4469a(), 15000L);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f20506r);
        arrayList.add(this.f20507s);
        return arrayList;
    }

    /* renamed from: d2 */
    public void m27220d2() {
        if (C11842p.m70759Q0()) {
            setRequestedOrientation(1);
        } else {
            setRequestedOrientation(-1);
        }
    }

    /* renamed from: e2 */
    public void m27221e2() {
        AlertDialogC11057b alertDialogC11057b = this.f20510v;
        if (alertDialogC11057b == null) {
            AlertDialogC11057b alertDialogC11057b2 = new AlertDialogC11057b(this, this);
            this.f20510v = alertDialogC11057b2;
            alertDialogC11057b2.show();
        } else {
            if (alertDialogC11057b.isShowing()) {
                return;
            }
            this.f20510v.show();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public void finish() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.finish();
        if ("com.android.settings".equals(this.f20511w) || "com.huawei.hwid".equals(this.f20511w)) {
            new HwAnimationReflection(this).m15927c(2);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HMSTermsProcessBaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 8901) {
            C13195l.m79272J().m79297M(this, this.f20514z, i11, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (view == null) {
            C13981a.m83988e("PhoneFinderTipsActivity", "view is null");
            return;
        }
        if (C0209d.m1226Y0()) {
            C13981a.m83990w("PhoneFinderTipsActivity", "click too fast");
            return;
        }
        if (view.getId() == R$id.pf_start_button) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(getPackageName(), "com.huawei.android.hicloud.ui.activity.HisyncExternalActivity"));
            intent.putExtra("is_password_verify_finished", FaqConstants.DISABLE_HA_REPORT);
            intent.putExtra("is_from_phonefinder_guide", true);
            if ("com.huawei.hwid".equals(this.f20511w)) {
                intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SCALE_CARD_MASK);
                intent.putExtra("channel_of_open_switch", "12");
            }
            startActivity(intent);
            m27215W1("PHONE_FINDER_GUIDE_CLOUD");
            finish();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onConfigurationChanged(configuration);
        m27220d2();
        m27212a2();
        m27211Z1();
        ScrollView scrollView = this.f20509u;
        if (scrollView != null) {
            scrollView.scrollTo(0, 0);
        }
    }

    @Override // com.huawei.android.remotecontrol.p093ui.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        C13981a.m83989i("PhoneFinderTipsActivity", "onCreate");
        m29137U0();
        m27220d2();
        String stringExtra = new HiCloudSafeIntent(getIntent()).getStringExtra(RemoteMessageConst.FROM);
        if ("com.android.settings".equals(stringExtra) || "com.huawei.hwid".equals(stringExtra)) {
            new HwAnimationReflection(this).m15927c(1);
        }
        super.onCreate(bundle);
        if (C0209d.m1173G1(this)) {
            C13981a.m83989i("PhoneFinderTipsActivity", "isPrivacyUser, now exit Cloud!");
            m27221e2();
        } else {
            m27212a2();
            m27211Z1();
        }
    }

    @Override // com.huawei.android.remotecontrol.p093ui.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        AlertDialogC11057b alertDialogC11057b = this.f20510v;
        if (alertDialogC11057b != null) {
            alertDialogC11057b.dismiss();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
