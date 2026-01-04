package com.huawei.android.hicloud.oobe.p086ui.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.TypefaceSpan;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.huawei.android.hicloud.oobe.R$color;
import com.huawei.android.hicloud.oobe.R$dimen;
import com.huawei.android.hicloud.oobe.R$id;
import com.huawei.android.hicloud.oobe.R$layout;
import com.huawei.android.hicloud.oobe.R$string;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.OOBENavLayout;
import java.lang.reflect.InvocationTargetException;
import p015ak.C0219i;
import p422k9.C11019b;
import p514o9.C11829c;
import p514o9.C11842p;
import sk.C12809f;

/* loaded from: classes3.dex */
public class SimplifyOOBENoticeActivity extends OOBEBaseActivity {

    /* renamed from: A */
    public ScrollView f12525A;

    /* renamed from: D0 */
    private void m16784D0() {
        if (getResources().getConfiguration().orientation == 2) {
            C11842p.m70775V1(this, this.f12525A);
        } else {
            C11842p.m70791a2(this.f12525A);
        }
    }

    /* renamed from: E0 */
    private void m16785E0() {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R$string.huaweicloud_privacy_notice_title));
        }
    }

    /* renamed from: F0 */
    private void m16786F0() {
        startActivityForResult(new Intent(this, (Class<?>) SimplifyOOBETermsActivity.class), 0);
    }

    /* renamed from: G0 */
    private void m16787G0() {
        ViewGroup.LayoutParams layoutParams = ((LinearLayout) C12809f.m76829b(this, R$id.main_layout)).getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).setMargins(0, C11842p.m70852q(this) + C11842p.m70789a0(this), 0, 0);
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: C0 */
    public void mo16555C0() {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: G */
    public void mo16559G() {
        int i10 = R$id.layout_privacy_notice;
        OOBENavLayout oOBENavLayout = (OOBENavLayout) C12809f.m76831d(C12809f.m76829b(this, i10), R$id.oobe_nav_layout);
        this.f12351k = oOBENavLayout;
        oOBENavLayout.setVisibility(0);
        this.f12351k.setBackBtnClickListener(this);
        this.f12351k.setNextBtnClickListener(this);
        if (getResources() != null) {
            if (C0219i.m1463a() >= 23) {
                C11842p.m70795b2(this, this.f12351k);
            } else {
                this.f12351k.setMarginHorizontal(getResources().getDimensionPixelSize(R$dimen.hisync_oobe_bar_margin));
            }
        }
        View viewM76829b = C12809f.m76829b(this, R$id.layout_agreement_log);
        View viewM76829b2 = C12809f.m76829b(this, i10);
        int i11 = R$id.more_info;
        TextView textView = (TextView) C12809f.m76831d(viewM76829b2, i11);
        if (getResources() != null && C0219i.m1463a() < 21) {
            C11842p.m70815g2(textView, getResources().getDimensionPixelSize(R$dimen.margin_xl));
        }
        View viewM76829b3 = C12809f.m76829b(this, R$id.layout_permissions_agreement);
        TextView textView2 = (TextView) C12809f.m76831d(viewM76829b3, R$id.overseas_confirm_text);
        if (getResources() != null && C0219i.m1463a() < 21) {
            C11842p.m70815g2(textView2, getResources().getDimensionPixelSize(R$dimen.margin_xl));
        }
        viewM76829b.setVisibility(8);
        viewM76829b2.setVisibility(0);
        viewM76829b3.setVisibility(8);
        boolean zM70620u0 = C11829c.m70620u0(this);
        String string = getString(R$string.huaweicloud_notice_here);
        SpannableString spannableString = new SpannableString(getString(zM70620u0 ? R$string.huaweicloud_notice_confirm : R$string.huaweicloud_notice_sg_confirm, string));
        int iLastIndexOf = spannableString.toString().lastIndexOf(string);
        ClickableSpan clickableSpanM66405Y = C11019b.m66371t().m66405Y(this, "privacy_statement");
        if (clickableSpanM66405Y != null) {
            spannableString.setSpan(clickableSpanM66405Y, iLastIndexOf, string.length() + iLastIndexOf, 33);
        }
        spannableString.setSpan(new TypefaceSpan("HwChinese-medium"), iLastIndexOf, string.length() + iLastIndexOf, 33);
        TextView textView3 = (TextView) C12809f.m76829b(this, i11);
        textView3.setText(spannableString);
        LinkMovementMethod linkMovementMethodM66414d0 = C11019b.m66371t().m66414d0();
        if (linkMovementMethodM66414d0 != null) {
            textView3.setMovementMethod(linkMovementMethodM66414d0);
        }
        textView3.setHighlightColor(getColor(R$color.transparent));
        if (zM70620u0) {
            return;
        }
        ((TextView) C12809f.m76831d(viewM76829b2, R$id.purpose)).setText(getString(R$string.huaweicloud_data_sg_controller));
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: O */
    public void mo16566O() {
        this.f12525A = (ScrollView) C12809f.m76829b(this, R$id.hicloud_terms_of_service);
        m16787G0();
        if (C0219i.m1463a() >= 23) {
            C11842p.m70795b2(this, this.f12351k);
        } else if (C11842p.m70771U0()) {
            m16784D0();
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: S */
    public void mo16569S() {
        mo16572V();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: T */
    public void mo16570T() {
        mo16569S();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: U */
    public void mo16571U() {
        mo16569S();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: V */
    public void mo16572V() {
        setResult(0);
        finish();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: Y */
    public void mo16574Y() {
        m16786F0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: Z */
    public void mo16575Z() {
        mo16574Y();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: a0 */
    public void mo16576a0() {
        mo16574Y();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: b0 */
    public void mo16577b0() {
        m16786F0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: c */
    public int mo16578c() {
        return R$layout.agreement_log_oobe_emui;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: f */
    public int mo16583f() {
        return R$layout.agreement_log_oobe_emui10;
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
        return mo16583f();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: h0 */
    public void mo16588h0(View view) {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: i */
    public int mo16589i() {
        return mo16583f();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: i0 */
    public void mo16590i0(View view) {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: j */
    public int mo16591j() {
        return R$layout.agreement_log_oobe;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: l0 */
    public void mo16596l0() {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (i11 == -1) {
            setResult(-1);
            finish();
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        m16785E0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            setResult(0);
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
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
