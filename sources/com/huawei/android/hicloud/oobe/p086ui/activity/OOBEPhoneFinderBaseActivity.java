package com.huawei.android.hicloud.oobe.p086ui.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import com.huawei.android.hicloud.oobe.R$drawable;
import com.huawei.android.hicloud.oobe.R$id;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.OOBENavLayout;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.OOBENavLayoutPf;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.OOBETopView;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import java.lang.reflect.InvocationTargetException;
import p015ak.C0209d;
import p015ak.C0219i;
import p020ap.C1010e;
import p514o9.C11839m;
import sk.C12809f;

/* loaded from: classes3.dex */
public abstract class OOBEPhoneFinderBaseActivity extends OOBEBaseActivity {

    /* renamed from: A */
    public OOBENavLayoutPf f12403A;

    /* renamed from: B */
    public String f12404B;

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: C0 */
    public void mo16555C0() {
        mo16666L0();
    }

    /* renamed from: D0 */
    public OOBENavLayoutPf.EnumC2866b m16658D0() {
        OOBENavLayoutPf oOBENavLayoutPf = this.f12403A;
        return oOBENavLayoutPf == null ? OOBENavLayoutPf.EnumC2866b.NEXT : oOBENavLayoutPf.getmNextButtonState();
    }

    /* renamed from: E0 */
    public abstract void mo16659E0();

    /* renamed from: F0 */
    public abstract void mo16660F0();

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: G */
    public void mo16559G() throws Resources.NotFoundException {
        this.f12349i = (RelativeLayout) C12809f.m76829b(this, R$id.oobe_start_main_frame);
        this.f12350j = (OOBETopView) C12809f.m76829b(this, R$id.oobe_start_top_frame);
        OOBENavLayout oOBENavLayout = (OOBENavLayout) C12809f.m76829b(this, R$id.oobe_nav_layout);
        this.f12351k = oOBENavLayout;
        if (oOBENavLayout != null) {
            oOBENavLayout.setBackBtnClickListener(this);
            this.f12351k.setNextBtnClickListener(this);
            try {
                this.f12403A = (OOBENavLayoutPf) this.f12351k;
            } catch (ClassCastException e10) {
                C11839m.m70687e("OOBEPhoneFinderBaseActivity", "initView error:" + e10.getMessage());
            }
        }
        if (this.f12350j == null || !m16581d0()) {
            return;
        }
        this.f12350j.m17062l();
    }

    /* renamed from: G0 */
    public abstract void mo16661G0();

    /* renamed from: H0 */
    public abstract int mo16662H0();

    /* renamed from: I0 */
    public abstract int mo16663I0();

    /* renamed from: J0 */
    public abstract int mo16664J0();

    /* renamed from: K0 */
    public abstract void mo16665K0();

    /* renamed from: L0 */
    public abstract void mo16666L0();

    /* renamed from: M0 */
    public void m16667M0(OOBETopView oOBETopView) {
        if (oOBETopView != null && C0219i.m1463a() >= 27 && C0209d.m1269j1()) {
            oOBETopView.setIconView(getDrawable(R$drawable.honor_pf_oobe_img));
        }
    }

    /* renamed from: N0 */
    public void m16668N0(OOBENavLayoutPf.EnumC2866b enumC2866b) {
        OOBENavLayoutPf oOBENavLayoutPf = this.f12403A;
        if (oOBENavLayoutPf == null) {
            return;
        }
        oOBENavLayoutPf.setNextButtonState(enumC2866b);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: S */
    public void mo16569S() {
        mo16572V();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: T */
    public void mo16570T() {
        mo16659E0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: U */
    public void mo16571U() {
        mo16659E0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: V */
    public void mo16572V() {
        mo16659E0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: Y */
    public void mo16574Y() {
        mo16577b0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: Z */
    public void mo16575Z() {
        if (OOBENavLayoutPf.EnumC2866b.SKIP == m16658D0()) {
            mo16661G0();
        } else if (OOBENavLayoutPf.EnumC2866b.NEXT == m16658D0()) {
            mo16660F0();
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: a0 */
    public void mo16576a0() {
        if (OOBENavLayoutPf.EnumC2866b.SKIP == m16658D0()) {
            mo16661G0();
        } else if (OOBENavLayoutPf.EnumC2866b.NEXT == m16658D0()) {
            mo16660F0();
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: b0 */
    public void mo16577b0() {
        if (OOBENavLayoutPf.EnumC2866b.SKIP == m16658D0()) {
            mo16661G0();
        } else if (OOBENavLayoutPf.EnumC2866b.NEXT == m16658D0()) {
            mo16660F0();
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: f */
    public int mo16583f() {
        return mo16662H0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: f0 */
    public void mo16584f0(View view) {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: g */
    public int mo16585g() {
        return mo16578c();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: g0 */
    public void mo16586g0(View view) {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: h */
    public int mo16587h() {
        return mo16663I0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: h0 */
    public void mo16588h0(View view) {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: i */
    public int mo16589i() {
        return mo16663I0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: i0 */
    public void mo16590i0(View view) {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: j */
    public int mo16591j() {
        return mo16664J0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: l0 */
    public void mo16596l0() {
        mo16665K0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        this.f12404B = new HiCloudSafeIntent(getIntent()).getStringExtra("hw_frp_token");
        C1010e.m6125b().m6159y(this.f12404B);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: x0 */
    public void mo16618x0() {
        if (this.f12351k == null) {
            return;
        }
        super.mo16618x0();
    }
}
