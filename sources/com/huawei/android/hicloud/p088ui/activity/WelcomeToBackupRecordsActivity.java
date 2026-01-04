package com.huawei.android.hicloud.p088ui.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity;
import com.huawei.android.hicloud.oobe.p086ui.activity.SimplifyOOBEQueryinfoActivity;
import com.huawei.android.hicloud.p088ui.extend.AutoStyleButtonAnnotation;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.uikit.phone.hwbutton.widget.HwButton;
import java.lang.reflect.InvocationTargetException;
import p514o9.C11839m;
import p514o9.C11842p;
import p709vj.C13452e;
import sk.C12809f;

@AutoStyleButtonAnnotation
/* loaded from: classes3.dex */
public class WelcomeToBackupRecordsActivity extends OOBEBaseActivity {

    /* renamed from: A */
    public ImageView f16451A;

    /* renamed from: B */
    public LinearLayout f16452B;

    /* renamed from: C */
    public SpanClickText f16453C;

    /* renamed from: D */
    public SpanClickText f16454D;

    /* renamed from: E */
    public SpanClickText f16455E;

    /* renamed from: F */
    public SpanClickText f16456F;

    /* renamed from: G */
    public LinearLayout f16457G;

    /* renamed from: H */
    public HwButton f16458H;

    /* renamed from: I */
    public HwButton f16459I;

    /* renamed from: J */
    public LinearLayout f16460J;

    /* renamed from: K */
    public HwButton f16461K;

    /* renamed from: L */
    public RelativeLayout f16462L;

    /* renamed from: D0 */
    private void m22694D0() {
        C11839m.m70688i("WelcomeBaseActivity", "initLandscapeUI");
        ((WindowManager) getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getRealMetrics(new DisplayMetrics());
        if (C11842p.m70771U0()) {
            return;
        }
        C11842p.m70827j2(this.f16462L, C11842p.m70852q(this));
    }

    /* renamed from: E0 */
    private void m22695E0() {
        if (C11842p.m70753O0(this) && !C11842p.m70747M0(this)) {
            m22694D0();
        } else {
            ((WindowManager) getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getMetrics(new DisplayMetrics());
        }
    }

    /* renamed from: F0 */
    private void m22696F0() {
        if (C11842p.m70771U0() || C11842p.m70747M0(this)) {
            LinearLayout linearLayout = this.f16457G;
            if (linearLayout != null) {
                C11842p.m70733H1(linearLayout, C11842p.m70864t(this));
            }
            LinearLayout linearLayout2 = this.f16452B;
            if (linearLayout2 != null) {
                C11842p.m70733H1(linearLayout2, C11842p.m70864t(this));
            }
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: A */
    public void mo16550A() {
        super.mo16550A();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: B */
    public void mo16552B() {
        super.mo16552B();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: C */
    public void mo16554C() {
        super.mo16554C();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: C0 */
    public void mo16555C0() {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: G */
    public void mo16559G() {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: M */
    public void mo16564M() {
        if (C13452e.m80781L().m80803F0().booleanValue()) {
            this.f16451A = (ImageView) C12809f.m76829b(this, R$id.welcome_icon_privacy);
            this.f16452B = (LinearLayout) C12809f.m76829b(this, R$id.welcome_privacy_content_ll);
            this.f16453C = (SpanClickText) C12809f.m76829b(this, R$id.welcome_privacy_content_first);
            this.f16454D = (SpanClickText) C12809f.m76829b(this, R$id.welcome_privacy_content_second);
            this.f16455E = (SpanClickText) C12809f.m76829b(this, R$id.welcome_privacy_content_third);
            this.f16456F = (SpanClickText) C12809f.m76829b(this, R$id.welcome_privacy_content_fourth);
            ImageView imageView = this.f16451A;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            C11842p.m70846o1(this, this.f16453C, this.f16454D, this.f16455E, this.f16456F, true, true);
        }
        HwButton hwButton = (HwButton) C12809f.m76829b(this, R$id.welcome_agree_button);
        this.f16458H = hwButton;
        if (hwButton != null) {
            hwButton.setOnClickListener(this);
        }
        HwButton hwButton2 = (HwButton) C12809f.m76829b(this, R$id.welcome_cancel_button);
        this.f16459I = hwButton2;
        if (hwButton2 != null) {
            hwButton2.setOnClickListener(this);
        }
        LinearLayout linearLayout = (LinearLayout) C12809f.m76829b(this, R$id.welcome_agree_layout);
        this.f16457G = linearLayout;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        m22696F0();
        LinearLayout linearLayout2 = (LinearLayout) C12809f.m76829b(this, R$id.welcome_frame);
        this.f16460J = linearLayout2;
        linearLayout2.setVisibility(0);
        HwButton hwButton3 = (HwButton) C12809f.m76829b(this, R$id.start_button);
        this.f16461K = hwButton3;
        hwButton3.setVisibility(8);
        this.f16462L = (RelativeLayout) C12809f.m76829b(this, R$id.welcome_button);
        m22695E0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: R */
    public void mo16568R() {
        super.mo16568R();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: S */
    public void mo16569S() {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: T */
    public void mo16570T() {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: U */
    public void mo16571U() {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: V */
    public void mo16572V() {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: X */
    public void mo16573X() {
        super.mo16573X();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: Y */
    public void mo16574Y() {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: Z */
    public void mo16575Z() {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: a0 */
    public void mo16576a0() {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: b0 */
    public void mo16577b0() {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: c */
    public int mo16578c() {
        return C11842p.m70771U0() ? R$layout.welcom_layout_pad : C11842p.m70747M0(this) ? R$layout.welcom_layout_folder_screen : R$layout.welcom_layout;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: f */
    public int mo16583f() {
        return mo16578c();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: f0 */
    public void mo16584f0(View view) {
        int id2 = view.getId();
        if (id2 != R$id.welcome_agree_button) {
            if (id2 == R$id.welcome_cancel_button) {
                onBackPressed();
            }
        } else {
            Intent intent = new Intent(this, (Class<?>) SimplifyOOBEQueryinfoActivity.class);
            intent.putExtra(FamilyShareConstants.ENTRY_TYPE, this.f12341a);
            intent.putExtra("intent_from_settings_data", true);
            intent.putExtra("intent_from_settings", this.f12360t);
            intent.putExtra("is_from_oobe_recover", true);
            startActivityForResult(intent, 10014);
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: g */
    public int mo16585g() {
        return mo16578c();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: g0 */
    public void mo16586g0(View view) {
        mo16584f0(view);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: h */
    public int mo16587h() {
        return mo16578c();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: h0 */
    public void mo16588h0(View view) {
        mo16584f0(view);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: i */
    public int mo16589i() {
        return mo16578c();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: i0 */
    public void mo16590i0(View view) {
        mo16584f0(view);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: j */
    public int mo16591j() {
        return mo16578c();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: l0 */
    public void mo16596l0() {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        C11839m.m70688i("WelcomeBaseActivity", "onActivityResult: requestCode: " + i10 + " resultCode: " + i11);
        setResult(i11, intent);
        finish();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(703);
        finish();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        setContentView(mo16578c());
        mo16564M();
        super.onConfigurationChanged(configuration);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: x0 */
    public void mo16618x0() {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: y0 */
    public void mo16620y0() {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle("");
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: z */
    public void mo16621z() {
        super.mo16621z();
    }
}
