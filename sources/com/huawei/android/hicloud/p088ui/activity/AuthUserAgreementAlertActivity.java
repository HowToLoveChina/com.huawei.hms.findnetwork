package com.huawei.android.hicloud.p088ui.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.AutoStyleButtonAnnotation;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitLinearLayout;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import gp.C10028c;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0212e0;
import p446l7.C11258f;
import p472m7.C11427b;
import p514o9.C11839m;
import p514o9.C11842p;
import p616rk.C12515a;
import sk.C12809f;

@AutoStyleButtonAnnotation
/* loaded from: classes3.dex */
public class AuthUserAgreementAlertActivity extends UIActivity {

    /* renamed from: p */
    public AutoSizeButton f13515p;

    /* renamed from: q */
    public AutoSizeButton f13516q;

    /* renamed from: r */
    public NotchTopFitLinearLayout f13517r;

    /* renamed from: s */
    public NotchFitLinearLayout f13518s;

    /* renamed from: t */
    public NotchFitLinearLayout f13519t;

    /* renamed from: u */
    public View f13520u;

    /* renamed from: v */
    public LinearLayout f13521v;

    /* renamed from: w */
    public CheckBox f13522w;

    /* renamed from: x */
    public boolean f13523x = false;

    /* renamed from: y */
    public boolean f13524y;

    /* renamed from: com.huawei.android.hicloud.ui.activity.AuthUserAgreementAlertActivity$a */
    public class ViewOnClickListenerC3122a implements View.OnClickListener {
        public ViewOnClickListenerC3122a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C11839m.m70688i("AuthUserAgreementAlertActivity", "Agree button Clicked");
            AuthUserAgreementAlertActivity.this.m18577Q1();
            AuthUserAgreementAlertActivity.this.m18578R1();
            AuthUserAgreementAlertActivity.this.setResult(1, AuthUserAgreementAlertActivity.this.getIntent());
            AuthUserAgreementAlertActivity.this.finish();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.AuthUserAgreementAlertActivity$b */
    public class ViewOnClickListenerC3123b implements View.OnClickListener {
        public ViewOnClickListenerC3123b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C11839m.m70688i("AuthUserAgreementAlertActivity", "DisAgree button Clicked");
            AuthUserAgreementAlertActivity.this.m18578R1();
            AuthUserAgreementAlertActivity.this.setResult(2, AuthUserAgreementAlertActivity.this.getIntent());
            AuthUserAgreementAlertActivity.this.finish();
        }
    }

    /* renamed from: O1 */
    private void m18574O1() {
        NotchFitLinearLayout notchFitLinearLayout;
        View view;
        this.f13521v = (LinearLayout) C12809f.m76829b(this, R$id.ll_push_gush);
        this.f13522w = (CheckBox) C12809f.m76829b(this, R$id.cb_push_guide);
        m18579S1((SpanClickText) C12809f.m76829b(this, R$id.overseas_confirm_text));
        m18580U1();
        AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76829b(this, R$id.auth_button_positive);
        this.f13515p = autoSizeButton;
        autoSizeButton.setOnClickListener(new ViewOnClickListenerC3122a());
        AutoSizeButton autoSizeButton2 = (AutoSizeButton) C12809f.m76829b(this, R$id.auth_button_negative);
        this.f13516q = autoSizeButton2;
        autoSizeButton2.setOnClickListener(new ViewOnClickListenerC3123b());
        this.f13517r = (NotchTopFitLinearLayout) C12809f.m76829b(this, R$id.main_notch_fit_top_layout);
        this.f13518s = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f13520u = C12809f.m76829b(this, R$id.auth_cloud_icon_layout);
        this.f13519t = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.auth_under_icon_layout);
        if (!C11842p.m70753O0(this)) {
            NotchFitLinearLayout notchFitLinearLayout2 = this.f13519t;
            if (notchFitLinearLayout2 != null) {
                notchFitLinearLayout2.getLayoutParams().height = (int) (C11842p.m70752O(this) * 0.529d);
            }
            if (C11842p.m70771U0() && (view = this.f13520u) != null) {
                m18575T1(view);
            }
        } else if (C11842p.m70771U0() && (notchFitLinearLayout = this.f13519t) != null) {
            notchFitLinearLayout.getLayoutParams().height = (int) (C11842p.m70758Q(this) * 0.529d);
        }
        mo19005p1();
    }

    /* renamed from: T1 */
    private void m18575T1(View view) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        if (view != null) {
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            int measuredHeight = view.getMeasuredHeight();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null || !(layoutParams instanceof LinearLayout.LayoutParams)) {
                return;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.topMargin = ((C11842p.m70758Q(this) - measuredHeight) / 2) - C11842p.m70789a0(this);
            view.setLayoutParams(layoutParams2);
        }
    }

    /* renamed from: P1 */
    public final /* synthetic */ void m18576P1(CompoundButton compoundButton, boolean z10) {
        this.f13524y = z10;
    }

    /* renamed from: Q1 */
    public final void m18577Q1() {
        C11839m.m70688i("AuthUserAgreementAlertActivity", "savePushGuide");
        if (!this.f13521v.isShown()) {
            C11839m.m70688i("AuthUserAgreementAlertActivity", "savePushGuide llPushGush not show!");
            return;
        }
        int i10 = 1;
        C10028c.m62182c0().m62367n3(true);
        if (this.f13522w.isChecked()) {
            C10028c.m62182c0().m62296Y1("1111222222222222");
            C12515a.m75110o().m75172d(new C11258f(true, "1111222222222222", "welcome_agreement_scene"));
            i10 = 2;
        }
        C0212e0.m1368r(this, "checkbox_push_guide_sp", "key_push_guide_result", i10);
    }

    /* renamed from: R1 */
    public final void m18578R1() {
        LinearLayout linearLayout = this.f13521v;
        if (linearLayout == null || this.f13522w == null || !linearLayout.isShown()) {
            return;
        }
        C0212e0.m1365o(this, "checkbox_push_guide_sp", "key_push_guide_default_status", this.f13522w.isChecked());
    }

    /* renamed from: S1 */
    public final void m18579S1(SpanClickText spanClickText) {
        String string = getString(R$string.cloud_service_terms_text);
        String string2 = getString(R$string.huaweicloud_overseas_agreement, string);
        spanClickText.m15931c(string, new C11427b(this, "user_agreement"));
        spanClickText.m15934g(string2, false);
    }

    /* renamed from: U1 */
    public final void m18580U1() {
        if (this.f13523x) {
            this.f13521v.setVisibility(0);
            this.f13522w.setChecked(this.f13524y);
            this.f13522w.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.huawei.android.hicloud.ui.activity.b
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                    this.f16477a.m18576P1(compoundButton, z10);
                }
            });
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f13517r);
        arrayList.add(this.f13518s);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setContentView(R$layout.auth_oversea_user_agreement_activity);
        m18574O1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        C11839m.m70686d("AuthUserAgreementAlertActivity", "AuthUserAgreementAlertActivity on create, this: " + toString());
        super.onCreate(bundle);
        this.f13523x = new HiCloudSafeIntent(getIntent()).getBooleanExtra("is_show_push_protocol", false);
        if (C10028c.m62182c0().m62221H1() && !this.f13523x) {
            setResult(2, getIntent());
            finish();
        } else {
            this.f13524y = C0212e0.m1354d(this, "checkbox_push_guide_sp", "key_push_guide_default_status", true);
            setContentView(R$layout.auth_oversea_user_agreement_activity);
            m18574O1();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        C11839m.m70686d("AuthUserAgreementAlertActivity", "AuthUserAgreementAlertActivity onResume, this: " + toString());
        super.onResume();
        if (!C10028c.m62182c0().m62221H1() || this.f13523x) {
            return;
        }
        C11839m.m70688i("AuthUserAgreementAlertActivity", "onResume, terms have confirmed");
        setResult(1, getIntent());
        finish();
    }
}
