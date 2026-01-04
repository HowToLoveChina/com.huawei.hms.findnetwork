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
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ScrollView;
import android.widget.TextView;
import com.huawei.android.hicloud.oobe.R$color;
import com.huawei.android.hicloud.oobe.R$dimen;
import com.huawei.android.hicloud.oobe.R$id;
import com.huawei.android.hicloud.oobe.R$layout;
import com.huawei.android.hicloud.oobe.R$string;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.OOBENavLayout;
import com.huawei.android.hicloud.p088ui.extend.PermissionListView;
import com.huawei.android.os.BuildEx;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.push.constant.RemoteMessageConst;
import gp.C10028c;
import java.lang.reflect.InvocationTargetException;
import p015ak.C0209d;
import p015ak.C0219i;
import p034bc.C1162b;
import p422k9.C11019b;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p684un.C13227f;
import p709vj.C13452e;
import p709vj.InterfaceC13456i;
import sk.C12809f;

/* loaded from: classes3.dex */
public class SimplifyOOBETermsActivity extends OOBEBaseActivity {

    /* renamed from: B */
    public ScrollView f12557B;

    /* renamed from: C */
    public ScrollView f12558C;

    /* renamed from: A */
    public int f12556A = 16;

    /* renamed from: D */
    public String f12559D = "";

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.SimplifyOOBETermsActivity$a */
    public class C2851a implements InterfaceC13456i {
        public C2851a() {
        }

        @Override // p709vj.InterfaceC13456i
        public void loginResult(boolean z10) {
            boolean zM66400T = C11019b.m66371t().m66400T();
            if (!C0209d.m1333z1(SimplifyOOBETermsActivity.this) || !z10 || !zM66400T) {
                C11019b.m66371t().m66420g0(SimplifyOOBETermsActivity.this);
                C11019b.m66371t().m66427k(SimplifyOOBETermsActivity.this, "phonefinderOOBE", "0");
                UBAAnalyze.m29949J("CKC", "phonefinderOOBE", "value", "0");
                SimplifyOOBETermsActivity.this.setResult(-1);
                SimplifyOOBETermsActivity.this.finish();
                return;
            }
            Class clsM66441r = C11019b.m66371t().m66441r("OOBEPhoneFinderActivity");
            if (clsM66441r != null) {
                Intent intent = new Intent(SimplifyOOBETermsActivity.this, (Class<?>) clsM66441r);
                intent.putExtra(RemoteMessageConst.FROM, SimplifyOOBETermsActivity.this.getPackageName());
                SimplifyOOBETermsActivity.this.startActivityForResult(intent, 10005);
            }
        }
    }

    /* renamed from: G0 */
    private void m16885G0() {
        String string = this.f12556A == 16 ? "CN".equalsIgnoreCase(C13452e.m80781L().m80942m()) ? getString(R$string.cloud_terms_title) : getString(R$string.huaweicloud_user_agreement_title) : getString(R$string.hicloud_migrate_terms_of_service_title_180531);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle(string);
        }
    }

    /* renamed from: I0 */
    private void m16886I0() {
        C11829c.m70582h1(this, this.f12559D);
        C11019b.m66371t().m66419g(this);
        C13227f.m79492i1().m79560L(this, C13452e.m80781L().m80971t0());
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        c10028cM62182c0.m62377p3("is_all_guide_over", true);
        C11019b.m66371t().m66381E0(this);
        if (c10028cM62182c0.m62395t1("funcfg_find_my_phone_globe")) {
            m16887J0();
        } else {
            setResult(-1);
            finish();
        }
    }

    /* renamed from: J0 */
    private void m16887J0() {
        C1162b.m7257a().m7258b(this, new C2851a());
    }

    /* renamed from: K0 */
    private void m16888K0() {
        C11019b.m66371t().m66424i0(this, true, true, true, true);
    }

    /* renamed from: L0 */
    private void m16889L0() {
        ViewGroup.LayoutParams layoutParams = ((ViewGroup) C12809f.m76829b(this, R$id.main_layout)).getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).setMargins(0, C11842p.m70852q(this) + C11842p.m70789a0(this), 0, 0);
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: C0 */
    public void mo16555C0() {
    }

    /* renamed from: D0 */
    public final void m16890D0() {
        int i10 = R$id.layout_permissions_agreement;
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
        View viewM76829b2 = C12809f.m76829b(this, R$id.layout_privacy_notice);
        TextView textView = (TextView) C12809f.m76831d(viewM76829b2, R$id.more_info);
        if (getResources() != null && C0219i.m1463a() < 21) {
            C11842p.m70815g2(textView, getResources().getDimensionPixelSize(R$dimen.margin_xl));
        }
        View viewM76829b3 = C12809f.m76829b(this, i10);
        int i11 = R$id.overseas_confirm_text;
        TextView textView2 = (TextView) C12809f.m76831d(viewM76829b3, i11);
        if (getResources() != null && C0219i.m1463a() < 21) {
            C11842p.m70815g2(textView2, getResources().getDimensionPixelSize(R$dimen.margin_xl));
        }
        viewM76829b.setVisibility(8);
        viewM76829b2.setVisibility(8);
        viewM76829b3.setVisibility(0);
        PermissionListView permissionListView = (PermissionListView) C12809f.m76829b(this, R$id.permissions_list);
        BaseAdapter baseAdapterM66406Z = C11019b.m66371t().m66406Z(this);
        if (baseAdapterM66406Z != null) {
            permissionListView.setAdapter((ListAdapter) baseAdapterM66406Z);
        }
        permissionListView.setFocusable(false);
        String string = getString(R$string.user_agreement);
        SpannableString spannableString = new SpannableString(getString(R$string.huaweicloud_overseas_agreement, string));
        int iIndexOf = spannableString.toString().indexOf(string);
        ClickableSpan clickableSpanM66405Y = C11019b.m66371t().m66405Y(this, "user_agreement");
        if (clickableSpanM66405Y != null) {
            spannableString.setSpan(clickableSpanM66405Y, iIndexOf, string.length() + iIndexOf, 33);
        }
        spannableString.setSpan(new TypefaceSpan("HwChinese-medium"), iIndexOf, string.length() + iIndexOf, 33);
        TextView textView3 = (TextView) C12809f.m76829b(this, i11);
        textView3.setText(spannableString);
        LinkMovementMethod linkMovementMethodM66414d0 = C11019b.m66371t().m66414d0();
        if (linkMovementMethodM66414d0 != null) {
            textView3.setMovementMethod(linkMovementMethodM66414d0);
        }
        textView3.setHighlightColor(getColor(R$color.transparent));
    }

    /* renamed from: E0 */
    public void m16891E0() {
        String string = getString(R$string.cloud_service_terms_text);
        String string2 = getString(R$string.cloud_service_privacy_statement);
        SpannableString spannableString = new SpannableString(getString(R$string.cloud_service_content_8, string, string2));
        int iIndexOf = spannableString.toString().indexOf(string);
        ClickableSpan clickableSpanM66405Y = C11019b.m66371t().m66405Y(this, "user_agreement");
        if (clickableSpanM66405Y != null) {
            spannableString.setSpan(clickableSpanM66405Y, iIndexOf, string.length() + iIndexOf, 33);
        }
        spannableString.setSpan(new TypefaceSpan("HwChinese-medium"), iIndexOf, string.length() + iIndexOf, 33);
        int iIndexOf2 = spannableString.toString().indexOf(string2);
        ClickableSpan clickableSpanM66405Y2 = C11019b.m66371t().m66405Y(this, "privacy_statement");
        if (clickableSpanM66405Y2 != null) {
            spannableString.setSpan(clickableSpanM66405Y2, iIndexOf2, string2.length() + iIndexOf2, 33);
        }
        spannableString.setSpan(new TypefaceSpan("HwChinese-medium"), iIndexOf2, string2.length() + iIndexOf2, 33);
        TextView textView = (TextView) C12809f.m76829b(this, R$id.hicloud_terms_8);
        textView.setText(spannableString);
        LinkMovementMethod linkMovementMethodM66414d0 = C11019b.m66371t().m66414d0();
        if (linkMovementMethodM66414d0 != null) {
            textView.setMovementMethod(linkMovementMethodM66414d0);
        }
        textView.setHighlightColor(getColor(R$color.transparent));
        String string3 = getString(R$string.cloud_service_content_1_alert_new);
        SpannableString spannableString2 = new SpannableString(getString(R$string.cloud_service_content_1_upd_new, string3));
        int iIndexOf3 = spannableString2.toString().indexOf(string3);
        spannableString2.setSpan(new TypefaceSpan("HwChinese-medium"), iIndexOf3, string3.length() + iIndexOf3, 33);
        ((TextView) C12809f.m76829b(this, R$id.hicloud_terms_1)).setText(spannableString2);
    }

    /* renamed from: F0 */
    public void m16892F0() {
        TextView textView = (TextView) C12809f.m76829b(this, R$id.migrate_terms_1);
        if (textView == null) {
            C11839m.m70687e("SimplifyOOBETermsActivity", "contentview is null");
            return;
        }
        if (C0209d.m1197O1()) {
            textView.setText(getString(R$string.hicloud_migrate_terms_of_service_1_170303_emui6, 1));
        } else {
            textView.setText(getString(R$string.hicloud_migrate_terms_of_service_1_170303, 1));
        }
        textView.setAlpha(1.0f);
        ((TextView) C12809f.m76829b(this, R$id.migrate_terms_2_1)).setAlpha(1.0f);
        ((TextView) C12809f.m76829b(this, R$id.migrate_terms_2_2)).setAlpha(1.0f);
        ((TextView) C12809f.m76829b(this, R$id.migrate_terms_2_3)).setAlpha(1.0f);
        C12809f.m76829b(this, R$id.hicloud_terms_of_service).setVisibility(8);
        C12809f.m76829b(this, R$id.migrate_terms_of_service).setVisibility(0);
        TextView textView2 = (TextView) C12809f.m76829b(this, R$id.migrate_terms_4);
        String string = getString(R$string.privacy_protect_title_new);
        SpannableString spannableString = new SpannableString(getString(R$string.hicloud_migrate_terms_of_service_8, string));
        int iIndexOf = spannableString.toString().indexOf(string);
        ClickableSpan clickableSpanM66403W = C11019b.m66371t().m66403W(this, 9);
        if (clickableSpanM66403W != null) {
            spannableString.setSpan(clickableSpanM66403W, iIndexOf, string.length() + iIndexOf, 33);
        }
        textView2.setText(spannableString);
        LinkMovementMethod linkMovementMethodM66404X = C11019b.m66371t().m66404X();
        if (linkMovementMethodM66404X != null) {
            textView2.setMovementMethod(linkMovementMethodM66404X);
        }
        textView2.setHighlightColor(getColor(R$color.transparent));
        TextView textView3 = (TextView) C12809f.m76829b(this, R$id.migrate_terms_2);
        textView3.setText(getString(R$string.hicloud_migrate_terms_of_service_2_170303, 2));
        textView3.setAlpha(1.0f);
        TextView textView4 = (TextView) C12809f.m76829b(this, R$id.migrate_terms_3);
        textView4.setText(getString(R$string.hicloud_migrate_terms_of_service_7_170303, 3));
        textView4.setAlpha(1.0f);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: G */
    public void mo16559G() {
        OOBENavLayout oOBENavLayout = (OOBENavLayout) C12809f.m76829b(this, R$id.oobe_nav_layout);
        this.f12351k = oOBENavLayout;
        oOBENavLayout.setVisibility(0);
        this.f12351k.m17039a();
        this.f12351k.setBackBtnClickListener(this);
        this.f12351k.setNextBtnClickListener(this);
        if (getResources() != null) {
            if (C0219i.m1463a() >= 23) {
                C11842p.m70795b2(this, this.f12351k);
            } else {
                this.f12351k.setMarginHorizontal(getResources().getDimensionPixelSize(R$dimen.hisync_oobe_bar_margin));
            }
        }
    }

    /* renamed from: H0 */
    public final void m16893H0() {
        TextView textView = (TextView) C12809f.m76829b(this, R$id.hicloud_terms_6);
        if (!C0209d.m1277l1() && BuildEx.VERSION.EMUI_SDK_INT < 12) {
            textView.setText(R$string.cloud_service_content_6_no_switch);
        }
        TextView textView2 = (TextView) C12809f.m76829b(this, R$id.agreement_data_info_content);
        if (textView2 == null || !C0209d.m1202Q0()) {
            return;
        }
        textView2.setText(R$string.cloud_service_agreement_datainfo_emui9_2);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: I */
    public void mo16561I() {
        mo16562J();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: J */
    public void mo16562J() {
        m16893H0();
        if (this.f12556A != 16) {
            m16892F0();
        } else if ("CN".equalsIgnoreCase(C13452e.m80781L().m80942m())) {
            m16891E0();
        } else {
            m16890D0();
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: K */
    public void mo16563K() {
        mo16562J();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: M */
    public void mo16564M() {
        mo16563K();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: O */
    public void mo16566O() {
        this.f12558C = (ScrollView) C12809f.m76829b(this, R$id.migrate_terms_of_service);
        this.f12557B = (ScrollView) C12809f.m76829b(this, R$id.hicloud_terms_of_service);
        if (C0219i.m1463a() >= 23) {
            C11842p.m70795b2(this, this.f12351k);
        }
        m16889L0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: S */
    public void mo16569S() {
        mo16572V();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: T */
    public void mo16570T() {
        setResult(0);
        finish();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: U */
    public void mo16571U() {
        setResult(0);
        finish();
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
        mo16577b0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: Z */
    public void mo16575Z() {
        m16888K0();
        m16886I0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: a0 */
    public void mo16576a0() {
        m16888K0();
        m16886I0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: b0 */
    public void mo16577b0() {
        m16888K0();
        m16886I0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: c */
    public int mo16578c() {
        return "CN".equalsIgnoreCase(C13452e.m80781L().m80942m()) ? R$layout.simplify_hicloud_terms_of_service_emui : R$layout.agreement_log_oobe_emui;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: f */
    public int mo16583f() {
        return "CN".equalsIgnoreCase(C13452e.m80781L().m80942m()) ? R$layout.simplify_hicloud_terms_of_service_emui10 : R$layout.agreement_log_oobe_emui10;
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
        return mo16589i();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: h0 */
    public void mo16588h0(View view) {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: i */
    public int mo16589i() {
        return "CN".equalsIgnoreCase(C13452e.m80781L().m80942m()) ? R$layout.simplify_hicloud_terms_of_service : R$layout.agreement_log_oobe;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: i0 */
    public void mo16590i0(View view) {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: j */
    public int mo16591j() {
        return mo16589i();
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
        Intent intent = getIntent();
        if (intent == null) {
            C11839m.m70687e("SimplifyOOBETermsActivity", "Intent is null");
            return;
        }
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
        this.f12556A = hiCloudSafeIntent.getIntExtra("termsType", 16);
        this.f12559D = hiCloudSafeIntent.getStringExtra("channel_of_open_switch");
        C11839m.m70688i("SimplifyOOBETermsActivity", "channel_of_open_switch" + this.f12559D);
        super.onCreate(bundle);
        m16885G0();
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
