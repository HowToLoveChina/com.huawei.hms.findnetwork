package com.huawei.android.hicloud.p088ui.activity;

import android.R;
import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.format.DateFormat;
import android.text.style.TypefaceSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import co.AbstractHandlerC1512a;
import com.huawei.android.app.ActionBarEx;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.PermissionListView;
import com.huawei.android.hicloud.p088ui.uiadapter.PermissionsItemAdapter;
import com.huawei.android.os.BuildEx;
import com.huawei.android.p073ds.R$dimen;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.request.agreement.request.SignInfo;
import gp.C10028c;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import p015ak.C0209d;
import p336he.C10161l;
import p446l7.C11253a;
import p472m7.C11427b;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p616rk.C12515a;
import p709vj.C13452e;
import p783xp.C13843a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class AgreementLogActivity extends UIActivity {

    /* renamed from: p */
    public NotchTopFitLinearLayout f13497p;

    /* renamed from: q */
    public View f13498q;

    /* renamed from: r */
    public View f13499r;

    /* renamed from: s */
    public View f13500s;

    /* renamed from: t */
    public ProgressDialog f13501t;

    /* renamed from: com.huawei.android.hicloud.ui.activity.AgreementLogActivity$a */
    public class HandlerC3119a extends AbstractHandlerC1512a {
        public HandlerC3119a(Activity activity) {
            super(activity);
        }

        @Override // co.AbstractHandlerC1512a
        /* renamed from: d */
        public void mo8607d() {
            AgreementLogActivity.this.m18562S1();
        }

        @Override // co.AbstractHandlerC1512a
        /* renamed from: e */
        public void mo8608e(String str) {
            AgreementLogActivity.this.m18562S1();
        }

        @Override // co.AbstractHandlerC1512a
        /* renamed from: g */
        public void mo8610g() {
            AgreementLogActivity.this.m18562S1();
        }

        @Override // co.AbstractHandlerC1512a
        /* renamed from: h */
        public void mo8611h(List<SignInfo> list) {
            AgreementLogActivity.this.m18562S1();
        }

        @Override // co.AbstractHandlerC1512a
        /* renamed from: i */
        public void mo8612i() {
            AgreementLogActivity.this.m18562S1();
        }
    }

    /* renamed from: O1 */
    private void m18554O1() {
        if (C0209d.m1312u0() < 11) {
            setTheme(R.style.Theme);
        } else {
            m18558N1(getResources().getString(R$string.cloud_terms_title), false, null);
        }
    }

    /* renamed from: T1 */
    private void m18555T1() {
        TextView textView = (TextView) C12809f.m76829b(this, R$id.agreement_data_info_content);
        if (textView != null && C0209d.m1202Q0()) {
            textView.setText(R$string.cloud_service_agreement_datainfo_emui9_2);
        }
        this.f13497p = (NotchTopFitLinearLayout) C12809f.m76829b(this, R$id.main_layout);
        this.f13498q = C12809f.m76829b(this, R$id.layout_agreement_log);
        View viewM76829b = C12809f.m76829b(this, R$id.layout_privacy_notice);
        this.f13499r = viewM76829b;
        TextView textView2 = (TextView) C12809f.m76831d(viewM76829b, R$id.more_info);
        if (getResources() != null) {
            C11842p.m70815g2(textView2, getResources().getDimensionPixelSize(R$dimen.margin_xl));
        }
        View viewM76829b2 = C12809f.m76829b(this, R$id.layout_permissions_agreement);
        this.f13500s = viewM76829b2;
        TextView textView3 = (TextView) C12809f.m76831d(viewM76829b2, R$id.overseas_confirm_text);
        if (getResources() != null) {
            C11842p.m70815g2(textView3, getResources().getDimensionPixelSize(R$dimen.margin_xl));
        }
        this.f13501t = new ProgressDialog(this);
        m22381r1();
        Intent intent = getIntent();
        if (intent == null) {
            C11839m.m70687e("AgreementLogActivity", "Intent param null!");
            finish();
            return;
        }
        try {
            short shortExtra = intent.getShortExtra("term_type_key", (short) 0);
            if (shortExtra == 125) {
                m18563U1();
                return;
            }
            if (shortExtra == 10013) {
                m18561R1();
                return;
            }
            C11839m.m70687e("AgreementLogActivity", "Intent param error! actType:" + ((int) shortExtra));
        } catch (RuntimeException unused) {
            C11839m.m70687e("AgreementLogActivity", "getIntExtra error!");
            finish();
        }
    }

    /* renamed from: W1 */
    private void m18556W1(String str) {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle(str);
        }
    }

    /* renamed from: M1 */
    public final void m18557M1() {
        ProgressDialog progressDialog = this.f13501t;
        if (progressDialog != null) {
            progressDialog.cancel();
            this.f13501t = null;
        }
    }

    /* renamed from: N1 */
    public void m18558N1(String str, boolean z10, View.OnClickListener onClickListener) {
        if (C0209d.m1312u0() < 11) {
            setTheme(R.style.Theme);
            return;
        }
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            if (C0209d.m1212T1()) {
                ActionBarEx.setStartIcon(actionBar, z10, (Drawable) null, onClickListener);
            } else {
                actionBar.setDisplayShowHomeEnabled(true);
                actionBar.setDisplayHomeAsUpEnabled(true);
            }
            if (str != null) {
                actionBar.setTitle(str);
            }
        }
    }

    /* renamed from: P1 */
    public final void m18559P1() {
        this.f13498q.setVisibility(0);
        this.f13499r.setVisibility(8);
        this.f13500s.setVisibility(8);
        String string = getString(R$string.cloud_service_content_1_alert_new);
        SpannableString spannableString = new SpannableString(getString(R$string.cloud_service_content_1_upd_new, string));
        int iIndexOf = spannableString.toString().indexOf(string);
        spannableString.setSpan(new TypefaceSpan("HwChinese-medium"), iIndexOf, string.length() + iIndexOf, 33);
        ((TextView) C12809f.m76829b(this, R$id.hicloud_terms_1)).setText(spannableString);
        long jM62247N = C10028c.m62183d0(this).m62247N("agr_sign_time");
        if (jM62247N == 0 || C11829c.m70534N0(this, C13452e.m80781L().m80942m())) {
            C12809f.m76829b(this, R$id.terms_log_layout).setVisibility(8);
            return;
        }
        m18564V1((SpanClickText) C12809f.m76829b(this, R$id.terms_log), jM62247N);
        TextView textView = (TextView) C12809f.m76829b(this, R$id.hicloud_terms_6);
        if (C0209d.m1277l1() || BuildEx.VERSION.EMUI_SDK_INT >= 12) {
            return;
        }
        textView.setText(R$string.cloud_service_content_6_no_switch);
    }

    /* renamed from: Q1 */
    public final void m18560Q1() {
        this.f13498q.setVisibility(8);
        this.f13499r.setVisibility(8);
        this.f13500s.setVisibility(0);
        PermissionListView permissionListView = (PermissionListView) C12809f.m76829b(this, R$id.permissions_list);
        permissionListView.setAdapter((ListAdapter) new PermissionsItemAdapter(this));
        permissionListView.setFocusable(false);
        SpanClickText spanClickText = (SpanClickText) C12809f.m76829b(this, R$id.overseas_confirm_text);
        long jM62247N = C10028c.m62183d0(this).m62247N("agr_sign_time");
        if (jM62247N == 0) {
            spanClickText.setVisibility(8);
        } else {
            m18564V1(spanClickText, jM62247N);
        }
    }

    /* renamed from: R1 */
    public final void m18561R1() {
        m18556W1(getString(R$string.huaweicloud_overseas_privacy));
        this.f13498q.setVisibility(8);
        this.f13499r.setVisibility(0);
        this.f13500s.setVisibility(8);
        boolean zM70620u0 = C11829c.m70620u0(this);
        String string = getString(R$string.huaweicloud_notice_here);
        String string2 = getString(zM70620u0 ? R$string.huaweicloud_notice_confirm : R$string.huaweicloud_notice_sg_confirm, string);
        SpanClickText spanClickText = (SpanClickText) C12809f.m76829b(this, R$id.more_info);
        spanClickText.m15931c(string, new C11427b(this, "privacy_statement"));
        spanClickText.m15934g(string2, false);
        if (zM70620u0) {
            return;
        }
        ((TextView) C12809f.m76831d(this.f13499r, R$id.purpose)).setText(getString(R$string.huaweicloud_data_sg_controller));
    }

    /* renamed from: S1 */
    public final void m18562S1() {
        C11839m.m70688i("AgreementLogActivity", "initTermsView");
        m18557M1();
        if ("CN".equals(C13452e.m80781L().m80942m())) {
            m18559P1();
        } else {
            m18560Q1();
        }
    }

    /* renamed from: U1 */
    public void m18563U1() {
        C11839m.m70688i("AgreementLogActivity", "queryAgreement");
        if (!C0209d.m1333z1(this)) {
            m18562S1();
            return;
        }
        C12515a.m75110o().m75172d(new C11253a(this, new HandlerC3119a(this), true));
        m18565X1();
    }

    /* renamed from: V1 */
    public final void m18564V1(SpanClickText spanClickText, long j10) {
        String str = DateFormat.getLongDateFormat(this).format(new Date(j10));
        String string = getString(R$string.cloud_service_terms_text);
        String string2 = getString(R$string.cloud_service_privacy_statement);
        String string3 = getString(R$string.cloud_terms_log_text, str, string, string2);
        spanClickText.m15931c(string, new C11427b(this, "user_agreement"));
        spanClickText.m15931c(string2, new C11427b(this, "privacy_statement"));
        spanClickText.m15934g(string3, false);
    }

    /* renamed from: X1 */
    public final void m18565X1() {
        ProgressDialog progressDialog = this.f13501t;
        if (progressDialog != null) {
            progressDialog.setMessage(getResources().getString(R$string.wait_loging));
            this.f13501t.setCancelable(false);
            this.f13501t.show();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f13497p);
        arrayList.add(this.f13498q);
        arrayList.add(this.f13499r);
        arrayList.add(this.f13500s);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: f1 */
    public int mo18507f1() {
        return R$id.hicloud_terms_of_service;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!C13843a.m83076a0(this)) {
            setRequestedOrientation(1);
        }
        C10161l.m63342b().m63345d(this);
        m18554O1();
        setContentView(R$layout.agreement_log);
        m18555T1();
        mo19005p1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        C10161l.m63342b().m63344c(this);
        super.onDestroy();
        m18557M1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
