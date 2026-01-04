package com.huawei.android.remotecontrol.p093ui.activation;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.huawei.android.remotecontrol.p093ui.activation.RemoteActivationUtil;
import com.huawei.android.remotecontrol.sdk.R$color;
import com.huawei.android.remotecontrol.sdk.R$id;
import com.huawei.android.remotecontrol.sdk.R$layout;
import com.huawei.android.remotecontrol.sdk.R$string;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import java.lang.reflect.InvocationTargetException;
import java.text.NumberFormat;
import p015ak.C0219i;
import p514o9.C11829c;
import p514o9.C11842p;
import p521og.C11877j;
import p809yg.C13981a;
import pg.AbstractC12139d;
import sk.C12809f;

/* loaded from: classes4.dex */
public class ActivationAppealActivity extends ActivationBaseActivity {

    /* renamed from: H */
    public View f20525H;

    /* renamed from: I */
    public View f20526I;

    /* renamed from: J */
    public View f20527J;

    /* renamed from: K */
    public TextView f20528K;

    /* renamed from: L */
    public TextView f20529L;

    /* renamed from: M */
    public View f20530M;

    /* renamed from: O */
    public Dialog f20532O;

    /* renamed from: T */
    public C4475b f20537T;

    /* renamed from: U */
    public RemoteActivationUtil.InterfaceC4524b f20538U;

    /* renamed from: N */
    public int f20531N = 0;

    /* renamed from: P */
    public String f20533P = null;

    /* renamed from: Q */
    public boolean f20534Q = false;

    /* renamed from: R */
    public RemoteActivationUtil.InterfaceC4525c f20535R = new RemoteActivationUtil.InterfaceC4525c() { // from class: hg.a
        @Override // com.huawei.android.remotecontrol.p093ui.activation.RemoteActivationUtil.InterfaceC4525c
        public final void onFinish() {
            this.f49470a.m27239p1();
        }
    };

    /* renamed from: S */
    public RemoteActivationUtil.InterfaceC4526d f20536S = new C4474a();

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.ActivationAppealActivity$a */
    public class C4474a implements RemoteActivationUtil.InterfaceC4526d {
        public C4474a() {
        }

        @Override // com.huawei.android.remotecontrol.p093ui.activation.RemoteActivationUtil.InterfaceC4526d
        /* renamed from: a */
        public void mo27245a(int i10) {
            if (ActivationAppealActivity.this.f20529L == null || ActivationAppealActivity.this.f20530M == null) {
                return;
            }
            if (i10 == 1) {
                ActivationAppealActivity.this.f20530M.setVisibility(0);
                ActivationAppealActivity.this.f20529L.setText(R$string.unbanding_net_invalued);
            } else {
                ActivationAppealActivity.this.f20530M.setVisibility(8);
                ActivationAppealActivity.this.f20529L.setText(R$string.connect_server_fail_msg1);
            }
            ActivationAppealActivity.this.m27243q1(1);
        }

        @Override // com.huawei.android.remotecontrol.p093ui.activation.RemoteActivationUtil.InterfaceC4526d
        /* renamed from: b */
        public void mo27246b(String str) {
            if (ActivationAppealActivity.this.f20528K == null) {
                return;
            }
            ActivationAppealActivity.this.f20528K.setText(str);
            ActivationAppealActivity.this.m27243q1(2);
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.ActivationAppealActivity$b */
    public static class C4475b implements RemoteActivationUtil.InterfaceC4524b {
        public C4475b() {
        }

        @Override // com.huawei.android.remotecontrol.p093ui.activation.RemoteActivationUtil.InterfaceC4524b
        /* renamed from: a */
        public void mo27247a(boolean z10) {
            if (z10) {
                return;
            }
            RemoteActivationUtil.m27647r().m27652E();
        }

        public /* synthetic */ C4475b(C4474a c4474a) {
            this();
        }
    }

    public ActivationAppealActivity() {
        C4475b c4475b = new C4475b(null);
        this.f20537T = c4475b;
        this.f20538U = c4475b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p1 */
    public /* synthetic */ void m27239p1() {
        mo27259Y0(true);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEPhoneFinderBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: G */
    public void mo16559G() throws Resources.NotFoundException {
        super.mo16559G();
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        this.f20526I = C12809f.m76829b(this, R$id.activation_main);
        this.f20525H = C12809f.m76829b(this, R$id.activation_progressbar);
        this.f20527J = C12809f.m76829b(this, R$id.activation_error);
        this.f20528K = (TextView) C12809f.m76829b(this, R$id.activation_unbandingcode);
        this.f20529L = (TextView) C12809f.m76829b(this, R$id.activation_retry);
        this.f20530M = C12809f.m76829b(this, R$id.goto_set_network);
        TextView textView = this.f20529L;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        View view = this.f20530M;
        if (view != null) {
            view.setOnClickListener(this);
        }
        ((TextView) C12809f.m76829b(this, R$id.activation_tv_website_desc)).setText(getString(R$string.unbanding_title_website_90, getString(R$string.phonefinder_show_url)));
        TextView textView2 = (TextView) C12809f.m76829b(this, R$id.unbanding_goods_1);
        if (textView2 != null) {
            textView2.setText(getString(R$string.unbanding_goods_list_1_1, NumberFormat.getNumberInstance().format(1L)));
        }
        TextView textView3 = (TextView) C12809f.m76829b(this, R$id.unbanding_goods_2);
        if (textView3 != null) {
            textView3.setText(getString(R$string.unbanding_goods_list_2, NumberFormat.getNumberInstance().format(2L)));
        }
        m27242o1();
        RemoteActivationUtil.m27647r().m27656n(this.f20535R);
        RemoteActivationUtil.m27647r().m27657o(this.f20536S);
        RemoteActivationUtil.m27647r().m27655m(this.f20538U);
        m27244r1();
    }

    @Override // com.huawei.android.remotecontrol.p093ui.activation.ActivationBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEPhoneFinderBaseActivity
    /* renamed from: H0 */
    public int mo16662H0() {
        return R$layout.activation_appeal_100;
    }

    @Override // com.huawei.android.remotecontrol.p093ui.activation.ActivationBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEPhoneFinderBaseActivity
    /* renamed from: I0 */
    public int mo16663I0() {
        return R$layout.activation_appeal;
    }

    @Override // com.huawei.android.remotecontrol.p093ui.activation.ActivationBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEPhoneFinderBaseActivity
    /* renamed from: J0 */
    public int mo16664J0() {
        return R$layout.activation_appeal;
    }

    @Override // com.huawei.android.remotecontrol.p093ui.activation.ActivationBaseActivity
    /* renamed from: R0 */
    public String mo27240R0() {
        return getResources().getString(R$string.appeal_activation);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: c */
    public int mo16578c() {
        return R$layout.activation_appeal_101;
    }

    /* renamed from: n1 */
    public final void m27241n1() {
        Dialog dialog = this.f20532O;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.f20532O.cancel();
        this.f20532O = null;
    }

    /* renamed from: o1 */
    public final void m27242o1() {
        C11842p.m70827j2(this.f20529L, (int) (((C11842p.m70876w(this).heightPixels * 0.33f) - C11842p.m70852q(this)) - C11842p.m70789a0(this)));
    }

    @Override // com.huawei.android.remotecontrol.p093ui.activation.ActivationBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id2 = view.getId();
        if (R$id.activation_retry == id2) {
            m27244r1();
            return;
        }
        if (R$id.goto_set_network == id2) {
            try {
                Intent intent = new Intent();
                intent.setAction("android.settings.WIRELESS_SETTINGS");
                intent.putExtra("use_emui_ui", true);
                intent.putExtra("hw_frp_token", this.f20533P);
                startActivity(intent);
            } catch (ActivityNotFoundException unused) {
                C13981a.m83988e("ActivationAppealActivity", "startActivity: setNet failed");
            }
        }
    }

    @Override // com.huawei.android.remotecontrol.p093ui.activation.ActivationBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEPhoneFinderBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        getWindow().setFlags(16777216, 16777216);
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(getIntent());
        this.f20533P = hiCloudSafeIntent.getStringExtra("hw_frp_token");
        this.f20534Q = hiCloudSafeIntent.getBooleanExtra("isCloudActivation", false);
        super.onCreate(bundle);
    }

    @Override // com.huawei.android.remotecontrol.p093ui.activation.ActivationBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onDestroy() {
        m27241n1();
        RemoteActivationUtil.m27647r().m27650C(this.f20535R);
        RemoteActivationUtil.m27647r().m27651D(this.f20536S);
        RemoteActivationUtil.m27647r().m27649B(this.f20538U);
        super.onDestroy();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        C13981a.m83987d("ActivationAppealActivity", "onResume");
    }

    /* renamed from: q1 */
    public final void m27243q1(int i10) {
        this.f20531N = i10;
        this.f20525H.setVisibility(i10 == 0 ? 0 : 8);
        this.f20527J.setVisibility(1 == this.f20531N ? 0 : 8);
        this.f20526I.setVisibility(2 == this.f20531N ? 0 : 8);
    }

    /* renamed from: r1 */
    public final void m27244r1() {
        m27243q1(0);
        if (!this.f20534Q) {
            RemoteActivationUtil.m27647r().m27653F(AbstractC12139d.m72766e(getApplicationContext()).getSiteID());
            return;
        }
        String strM71282l0 = C11877j.m71282l0(this);
        if (TextUtils.isEmpty(AbstractC12139d.m72766e(this).getChallengeString()) || TextUtils.isEmpty(strM71282l0)) {
            RemoteActivationUtil.m27647r().m27652E();
            return;
        }
        TextView textView = this.f20528K;
        if (textView != null) {
            textView.setText(strM71282l0);
        }
        m27243q1(2);
    }

    @Override // com.huawei.android.remotecontrol.p093ui.activation.ActivationBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: u0 */
    public void mo16613u0() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.mo16613u0();
        if (C0219i.m1463a() >= 27) {
            C11829c.m70624v1(this, getWindow());
            ActionBar actionBar = getActionBar();
            int i10 = R$color.hicloud_hmos_bg;
            C11842p.m70842n1(actionBar, new ColorDrawable(getColor(i10)));
            actionBar.setBackgroundDrawable(new ColorDrawable(getColor(i10)));
            ((FrameLayout) C12809f.m76829b(this, R$id.avtivation_main_layout)).setBackgroundColor(getColor(i10));
        }
    }
}
