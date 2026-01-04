package com.huawei.android.hicloud.p088ui.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitLinearLayout;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import gp.C10028c;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0212e0;
import p446l7.C11258f;
import p472m7.C11426a;
import p472m7.C11427b;
import p514o9.C11839m;
import p514o9.C11842p;
import p616rk.C12515a;
import p684un.C13223b;
import sk.C12809f;

/* loaded from: classes3.dex */
public class SecondCenterAuthorizationActivity extends UIActivity {

    /* renamed from: A */
    public boolean f15952A;

    /* renamed from: p */
    public SpanClickText f15953p;

    /* renamed from: q */
    public SpanClickText f15954q;

    /* renamed from: r */
    public AutoSizeButton f15955r;

    /* renamed from: s */
    public AutoSizeButton f15956s;

    /* renamed from: t */
    public NotchTopFitLinearLayout f15957t;

    /* renamed from: u */
    public NotchFitLinearLayout f15958u;

    /* renamed from: v */
    public NotchFitLinearLayout f15959v;

    /* renamed from: w */
    public View f15960w;

    /* renamed from: x */
    public LinearLayout f15961x;

    /* renamed from: y */
    public CheckBox f15962y;

    /* renamed from: z */
    public boolean f15963z = false;

    /* renamed from: com.huawei.android.hicloud.ui.activity.SecondCenterAuthorizationActivity$a */
    public class ViewOnClickListenerC3465a implements View.OnClickListener {
        public ViewOnClickListenerC3465a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C11839m.m70688i("SecondCenterAuthorizationActivity", "Agree button Clicked");
            C13223b.m79473a(SecondCenterAuthorizationActivity.this, "CLOUDBACKUP_HICLOUD_CLICK_NEXT", "1");
            UBAAnalyze.m29954O("PVC", "CLOUDBACKUP_HICLOUD_CLICK_NEXT", "1", "2");
            SecondCenterAuthorizationActivity.this.m22135T1(1);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.SecondCenterAuthorizationActivity$b */
    public class ViewOnClickListenerC3466b implements View.OnClickListener {
        public ViewOnClickListenerC3466b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C11839m.m70688i("SecondCenterAuthorizationActivity", "DisAgree button Clicked");
            SecondCenterAuthorizationActivity.this.m22135T1(2);
        }
    }

    /* renamed from: N1 */
    private void m22128N1() {
        NotchFitLinearLayout notchFitLinearLayout;
        View view;
        this.f15961x = (LinearLayout) C12809f.m76829b(this, R$id.ll_push_gush);
        this.f15962y = (CheckBox) C12809f.m76829b(this, R$id.cb_push_guide);
        this.f15957t = (NotchTopFitLinearLayout) C12809f.m76829b(this, R$id.main_notch_fit_top_layout);
        this.f15958u = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f15953p = (SpanClickText) C12809f.m76829b(this, R$id.text_auth_description);
        this.f15954q = (SpanClickText) C12809f.m76829b(this, R$id.text_auth_description_link);
        m22134Q1(this.f15953p);
        m22131R1(this.f15954q);
        m22133U1();
        AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76829b(this, R$id.auth_button_positive);
        this.f15955r = autoSizeButton;
        autoSizeButton.setOnClickListener(new ViewOnClickListenerC3465a());
        AutoSizeButton autoSizeButton2 = (AutoSizeButton) C12809f.m76829b(this, R$id.auth_button_negative);
        this.f15956s = autoSizeButton2;
        autoSizeButton2.setOnClickListener(new ViewOnClickListenerC3466b());
        this.f15959v = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.auth_under_icon_layout);
        this.f15960w = C12809f.m76829b(this, R$id.auth_cloud_icon_layout);
        if (!C11842p.m70753O0(this)) {
            NotchFitLinearLayout notchFitLinearLayout2 = this.f15959v;
            if (notchFitLinearLayout2 != null) {
                notchFitLinearLayout2.getLayoutParams().height = (int) (C11842p.m70752O(this) * 0.529d);
            }
            if (C11842p.m70771U0() && (view = this.f15960w) != null) {
                m22132S1(view);
            }
        } else if (C11842p.m70771U0() && (notchFitLinearLayout = this.f15959v) != null) {
            notchFitLinearLayout.getLayoutParams().height = (int) (C11842p.m70758Q(this) * 0.529d);
        }
        mo19005p1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O1 */
    public /* synthetic */ void m22129O1(CompoundButton compoundButton, boolean z10) {
        this.f15952A = z10;
    }

    /* renamed from: P1 */
    private void m22130P1() {
        C11839m.m70688i("SecondCenterAuthorizationActivity", "savePushGuide");
        if (!this.f15961x.isShown()) {
            C11839m.m70688i("SecondCenterAuthorizationActivity", "savePushGuide llPushGush not show!");
            return;
        }
        int i10 = 1;
        C10028c.m62182c0().m62367n3(true);
        if (this.f15962y.isChecked()) {
            C10028c.m62182c0().m62296Y1("1111222222222222");
            C12515a.m75110o().m75172d(new C11258f(true, "1111222222222222", "welcome_agreement_scene"));
            i10 = 2;
        }
        C0212e0.m1368r(this, "checkbox_push_guide_sp", "key_push_guide_result", i10);
    }

    /* renamed from: R1 */
    private void m22131R1(SpanClickText spanClickText) {
        if (spanClickText == null) {
            return;
        }
        String string = getString(R$string.cloud_service_privacy_text);
        String string2 = getString(R$string.cloud_service_terms_text);
        String string3 = getString(R$string.permission_instruction);
        String string4 = getString(R$string.second_data_center_terms_description_7, string2, string, string3);
        spanClickText.m15931c(string2, new C11427b(this, "user_agreement"));
        spanClickText.m15931c(string, new C11427b(this, "privacy_statement"));
        spanClickText.m15931c(string3, new C11426a(this, "permission_description", false));
        spanClickText.m15934g(string4, false);
    }

    /* renamed from: S1 */
    private void m22132S1(View view) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        if (view != null) {
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            int measuredHeight = view.getMeasuredHeight();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams2.topMargin = ((C11842p.m70758Q(this) - measuredHeight) / 2) - C11842p.m70789a0(this);
                view.setLayoutParams(layoutParams2);
            }
        }
    }

    /* renamed from: U1 */
    private void m22133U1() {
        if (this.f15963z) {
            this.f15961x.setVisibility(0);
            this.f15962y.setChecked(this.f15952A);
            this.f15962y.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.huawei.android.hicloud.ui.activity.l8
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                    this.f17668a.m22129O1(compoundButton, z10);
                }
            });
        }
    }

    /* renamed from: Q1 */
    public final void m22134Q1(SpanClickText spanClickText) {
        if (spanClickText == null) {
            return;
        }
        String string = getString(R$string.second_data_center_terms_description_5);
        String string2 = getString(R$string.second_data_center_terms_description_2_new2);
        String string3 = getString(R$string.second_data_center_terms_description_1_new, string, string2);
        spanClickText.m15930b(string);
        spanClickText.m15930b(string2);
        spanClickText.m15934g(string3, false);
    }

    /* renamed from: T1 */
    public final void m22135T1(int i10) {
        LinearLayout linearLayout = this.f15961x;
        if (linearLayout != null && this.f15962y != null && linearLayout.isShown()) {
            C0212e0.m1365o(this, "checkbox_push_guide_sp", "key_push_guide_default_status", this.f15962y.isChecked());
        }
        Intent intent = getIntent();
        if (i10 == 1) {
            m22130P1();
        }
        setResult(i10, intent);
        finish();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f15957t);
        arrayList.add(this.f15958u);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setContentView(R$layout.second_center_auth_activity);
        m22128N1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f15963z = new HiCloudSafeIntent(getIntent()).getBooleanExtra("is_show_push_protocol", false);
        if (C10028c.m62182c0().m62221H1() && !this.f15963z) {
            m22135T1(1);
            return;
        }
        this.f15952A = C0212e0.m1354d(this, "checkbox_push_guide_sp", "key_push_guide_default_status", true);
        setContentView(R$layout.second_center_auth_activity);
        m22128N1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!C10028c.m62182c0().m62221H1() || this.f15963z) {
            return;
        }
        C11839m.m70688i("SecondCenterAuthorizationActivity", "onResume, terms have confirmed");
        m22135T1(1);
    }
}
