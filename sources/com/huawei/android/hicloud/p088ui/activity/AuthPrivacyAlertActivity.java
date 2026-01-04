package com.huawei.android.hicloud.p088ui.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
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
import p472m7.C11427b;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import sk.C12809f;

@AutoStyleButtonAnnotation
/* loaded from: classes3.dex */
public class AuthPrivacyAlertActivity extends UIActivity {

    /* renamed from: p */
    public AutoSizeButton f13506p;

    /* renamed from: q */
    public AutoSizeButton f13507q;

    /* renamed from: r */
    public NotchTopFitLinearLayout f13508r;

    /* renamed from: s */
    public NotchFitLinearLayout f13509s;

    /* renamed from: t */
    public NotchFitLinearLayout f13510t;

    /* renamed from: u */
    public View f13511u;

    /* renamed from: v */
    public boolean f13512v = false;

    /* renamed from: com.huawei.android.hicloud.ui.activity.AuthPrivacyAlertActivity$a */
    public class ViewOnClickListenerC3120a implements View.OnClickListener {
        public ViewOnClickListenerC3120a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C11839m.m70688i("AuthPrivacyAlertActivity", "Agree button Clicked");
            Intent intent = new Intent();
            intent.setClass(AuthPrivacyAlertActivity.this, AuthUserAgreementAlertActivity.class);
            intent.putExtra("is_show_push_protocol", AuthPrivacyAlertActivity.this.f13512v);
            AuthPrivacyAlertActivity.this.startActivityForResult(intent, 10001);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.AuthPrivacyAlertActivity$b */
    public class ViewOnClickListenerC3121b implements View.OnClickListener {
        public ViewOnClickListenerC3121b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C11839m.m70688i("AuthPrivacyAlertActivity", "DisAgree button Clicked");
            AuthPrivacyAlertActivity.this.setResult(2, AuthPrivacyAlertActivity.this.getIntent());
            AuthPrivacyAlertActivity.this.finish();
        }
    }

    /* renamed from: M1 */
    private void m18568M1() {
        NotchFitLinearLayout notchFitLinearLayout;
        View view;
        boolean zM70620u0 = C11829c.m70620u0(this);
        m18569N1((SpanClickText) C12809f.m76829b(this, R$id.more_info), zM70620u0);
        if (!zM70620u0) {
            ((TextView) C12809f.m76829b(this, R$id.purpose)).setText(getString(R$string.huaweicloud_data_sg_controller));
        }
        AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76829b(this, R$id.auth_button_positive);
        this.f13506p = autoSizeButton;
        autoSizeButton.setOnClickListener(new ViewOnClickListenerC3120a());
        AutoSizeButton autoSizeButton2 = (AutoSizeButton) C12809f.m76829b(this, R$id.auth_button_negative);
        this.f13507q = autoSizeButton2;
        autoSizeButton2.setOnClickListener(new ViewOnClickListenerC3121b());
        this.f13511u = C12809f.m76829b(this, R$id.auth_cloud_icon_layout);
        this.f13510t = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.auth_under_icon_layout);
        this.f13508r = (NotchTopFitLinearLayout) C12809f.m76829b(this, R$id.main_notch_fit_top_layout);
        this.f13509s = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        if (!C11842p.m70753O0(this)) {
            NotchFitLinearLayout notchFitLinearLayout2 = this.f13510t;
            if (notchFitLinearLayout2 != null) {
                notchFitLinearLayout2.getLayoutParams().height = (int) (C11842p.m70752O(this) * 0.529d);
            }
            if (C11842p.m70771U0() && (view = this.f13511u) != null) {
                m18570O1(view);
            }
        } else if (C11842p.m70771U0() && (notchFitLinearLayout = this.f13510t) != null) {
            notchFitLinearLayout.getLayoutParams().height = (int) (C11842p.m70758Q(this) * 0.529d);
        }
        mo19005p1();
    }

    /* renamed from: N1 */
    public final void m18569N1(SpanClickText spanClickText, boolean z10) {
        String string = getString(R$string.huaweicloud_notice_here);
        String string2 = getString(z10 ? R$string.huaweicloud_notice_confirm : R$string.huaweicloud_notice_sg_confirm, string);
        spanClickText.m15931c(string, new C11427b(this, "privacy_statement"));
        spanClickText.m15934g(string2, false);
    }

    /* renamed from: O1 */
    public final void m18570O1(View view) {
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

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f13508r);
        arrayList.add(this.f13509s);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        C11839m.m70686d("AuthPrivacyAlertActivity", "onActivityResult requestCode=" + i10 + ", resultCode=" + i11 + ",this: " + toString());
        if (i10 == 10001) {
            if (i11 == 1) {
                C11839m.m70688i("AuthPrivacyAlertActivity", "AuthUserAgreementAlertActivity agreed");
                setResult(1, intent);
                finish();
            } else {
                if (i11 == 2) {
                    C11839m.m70688i("AuthPrivacyAlertActivity", "AuthUserAgreementAlertActivity not agreed");
                    return;
                }
                C11839m.m70688i("AuthPrivacyAlertActivity", "unknown resultCode: " + i11);
            }
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setContentView(R$layout.auth_oversea_privacy_activity);
        m18568M1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        C11839m.m70686d("AuthPrivacyAlertActivity", "AuthPrivacyAlertActivity on create, this: " + toString());
        super.onCreate(bundle);
        this.f13512v = new HiCloudSafeIntent(getIntent()).getBooleanExtra("is_show_push_protocol", false);
        if (!C10028c.m62182c0().m62221H1() || this.f13512v) {
            setContentView(R$layout.auth_oversea_privacy_activity);
            m18568M1();
        } else {
            setResult(1, getIntent());
            finish();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        C11839m.m70686d("AuthPrivacyAlertActivity", "AuthPrivacyAlertActivity onResume, this: " + toString());
        super.onResume();
        if (!C10028c.m62182c0().m62221H1() || this.f13512v) {
            return;
        }
        C11839m.m70688i("AuthPrivacyAlertActivity", "onResume, terms have confirmed");
        setResult(1, getIntent());
        finish();
    }
}
