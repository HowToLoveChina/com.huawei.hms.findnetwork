package com.huawei.android.hicloud.oobe.p086ui.activity;

import android.app.ActionBar;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.oobe.R$dimen;
import com.huawei.android.hicloud.oobe.R$id;
import com.huawei.android.hicloud.oobe.R$layout;
import com.huawei.android.hicloud.oobe.R$string;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.OOBENavLayout;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.lang.reflect.InvocationTargetException;
import p015ak.C0209d;
import p015ak.C0219i;
import p514o9.C11842p;
import p684un.C13227f;
import sk.C12809f;

/* loaded from: classes3.dex */
public class OOBEMigrateTermsActivity extends OOBEBaseActivity implements View.OnClickListener {

    /* renamed from: A */
    public int f12401A = 17;

    /* renamed from: B */
    public View f12402B;

    /* renamed from: D0 */
    private int m16651D0() {
        return R$layout.oobe_hicloud_terms_of_service_emui10;
    }

    /* renamed from: G0 */
    private void m16652G0() {
        String string = getString(R$string.hicloud_migrate_terms_of_service_title_180531);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle(string);
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: C0 */
    public void mo16555C0() {
    }

    /* renamed from: E0 */
    public void m16653E0() {
        OOBENavLayout oOBENavLayout = (OOBENavLayout) C12809f.m76829b(this, R$id.oobe_terms_buttons);
        this.f12351k = oOBENavLayout;
        oOBENavLayout.setBackBtnClickListener(this);
        this.f12351k.setNextBtnClickListener(this);
        int iM1463a = C0219i.m1463a();
        if (iM1463a >= 23) {
            this.f12351k.m17039a();
        } else if (iM1463a >= 17) {
            this.f12351k.m17039a();
            if (getResources() != null) {
                this.f12351k.setMarginHorizontal(getResources().getDimensionPixelSize(R$dimen.hisync_oobe_bar_margin));
            }
        } else {
            this.f12351k.setMarginHorizontal(C11842p.m70840n(this, 16));
        }
        TextView textView = (TextView) C12809f.m76829b(this, R$id.migrate_terms_1);
        textView.setText(getString(R$string.hicloud_migrate_terms_of_service_1_180531, 1));
        textView.setAlpha(1.0f);
        ((TextView) C12809f.m76829b(this, R$id.migrate_terms_2_1)).setAlpha(1.0f);
        ((TextView) C12809f.m76829b(this, R$id.migrate_terms_2_2)).setAlpha(1.0f);
        ((TextView) C12809f.m76829b(this, R$id.migrate_terms_2_3)).setAlpha(1.0f);
        C12809f.m76829b(this, R$id.hicloud_terms_of_service).setVisibility(8);
        C12809f.m76829b(this, R$id.migrate_terms_of_service).setVisibility(0);
        ((TextView) C12809f.m76829b(this, R$id.migrate_terms_4)).setText(new SpannableString(getString(R$string.hicloud_migrate_terms_of_service_8, getString(R$string.about_recover_tip_null, getString(R$string.cloud_service_legal_privacy_text), C0209d.m1236b0(getString(R$string.oobelocal_term_show_url))))));
        TextView textView2 = (TextView) C12809f.m76829b(this, R$id.migrate_terms_2);
        String string = getString(R$string.hicloud_migrate_terms_of_service_2_170303_wifi_1);
        int i10 = R$string.hicloud_terms_paragraph_header;
        textView2.setText(getString(i10, 2, string));
        textView2.setAlpha(1.0f);
        TextView textView3 = (TextView) C12809f.m76829b(this, R$id.migrate_terms_3);
        textView3.setText(getString(R$string.hicloud_migrate_terms_of_service_7_170303_wifi, 3));
        textView3.setAlpha(1.0f);
        if (C0209d.m1262h2()) {
            textView2.setText(getString(i10, 2, getString(R$string.hicloud_migrate_terms_of_service_2_170303_wlan_1)));
            textView3.setText(getString(R$string.hicloud_migrate_terms_of_service_7_170303_wlan, 3));
        }
    }

    /* renamed from: F0 */
    public void m16654F0() {
        if (getResources().getConfiguration().orientation == 2) {
            C11842p.m70775V1(this, this.f12402B);
        } else {
            C11842p.m70791a2(this.f12402B);
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: G */
    public void mo16559G() {
        m16653E0();
        this.f12402B = C12809f.m76829b(this, R$id.migrate_terms_of_service);
        if (!C11842p.m70771U0() || C0219i.m1463a() >= 23) {
            return;
        }
        m16654F0();
    }

    /* renamed from: H0 */
    public final void m16655H0() {
        setResult(0);
        finish();
    }

    /* renamed from: I0 */
    public final void m16656I0() {
        setResult(-1);
        finish();
    }

    /* renamed from: J0 */
    public void m16657J0() {
        ViewGroup.LayoutParams layoutParams = ((RelativeLayout) C12809f.m76829b(this, R$id.main_layout)).getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).setMargins(0, C11842p.m70852q(this) + C11842p.m70789a0(this), 0, 0);
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: O */
    public void mo16566O() {
        m16657J0();
        if (this.f12351k == null || C0219i.m1463a() < 23) {
            return;
        }
        C11842p.m70795b2(this, this.f12351k);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: S */
    public void mo16569S() {
        m16655H0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: T */
    public void mo16570T() {
        m16655H0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: U */
    public void mo16571U() {
        m16655H0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: V */
    public void mo16572V() {
        m16655H0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: Y */
    public void mo16574Y() {
        m16656I0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: Z */
    public void mo16575Z() {
        m16656I0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: a0 */
    public void mo16576a0() {
        m16656I0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: b0 */
    public void mo16577b0() {
        m16656I0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: c */
    public int mo16578c() {
        return R$layout.oobe_hicloud_terms_of_service;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: f */
    public int mo16583f() {
        return m16651D0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: f0 */
    public void mo16584f0(View view) {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: g */
    public int mo16585g() {
        return m16651D0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: g0 */
    public void mo16586g0(View view) {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: h */
    public int mo16587h() {
        return m16651D0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: h0 */
    public void mo16588h0(View view) {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: i */
    public int mo16589i() {
        return m16651D0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: i0 */
    public void mo16590i0(View view) {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: j */
    public int mo16591j() {
        return m16651D0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: l0 */
    public void mo16596l0() {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!C11842p.m70771U0() || C0219i.m1463a() >= 23) {
            return;
        }
        m16654F0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        m16652G0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            setResult(0);
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        C13227f.m79492i1().m79577X(this);
        UBAAnalyze.m29964Y("PVC", getClass().getCanonicalName(), "1", "18", super.m16612u());
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        C13227f.m79492i1().m79582b0(this);
        UBAAnalyze.m29967a0("PVC", getClass().getCanonicalName(), "1", "18");
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: u0 */
    public void mo16613u0() {
        super.m16617w0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: y0 */
    public void mo16620y0() {
    }
}
