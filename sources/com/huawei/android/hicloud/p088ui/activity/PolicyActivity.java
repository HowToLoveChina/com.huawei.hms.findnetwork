package com.huawei.android.hicloud.p088ui.activity;

import android.R;
import android.app.ActionBar;
import android.app.Application;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.app.ActionBarEx;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.OOBENavLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.os.BuildEx;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p514o9.C11839m;
import p514o9.C11842p;
import p684un.C13227f;
import p783xp.C13843a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class PolicyActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: p */
    public NotchTopFitRelativeLayout f15808p;

    /* renamed from: q */
    public NotchFitLinearLayout f15809q;

    /* renamed from: r */
    public NotchFitRelativeLayout f15810r;

    /* renamed from: s */
    public View f15811s;

    /* renamed from: t */
    public ImageView f15812t = null;

    /* renamed from: u */
    public int f15813u = 0;

    /* renamed from: O1 */
    private void m21963O1() {
        this.f15808p = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f15809q = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.layout_loading);
        this.f15810r = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.layout_retry);
        this.f15812t = (ImageView) C12809f.m76829b(this, R$id.wlan_disconnected_icon);
        this.f15810r.setVisibility(8);
        int i10 = this.f15813u;
        if (7 == i10) {
            View viewM76829b = C12809f.m76829b(this, R$id.terms_of_service);
            this.f15811s = viewM76829b;
            ((TextView) C12809f.m76831d(viewM76829b, R$id.hicloud_terms_1)).setText(getString(R$string.huaweicloud_service_content_item_1_170303_emui6_0, 1));
            ((TextView) C12809f.m76831d(this.f15811s, R$id.hicloud_terms_1_2)).setText(C2783d.m16179s1(R$string.huaweicloud_service_content_item_3_wlan_new1, R$string.huaweicloud_service_content_item_3_wifi_new1));
            ((TextView) C12809f.m76831d(this.f15811s, R$id.hicloud_terms_2)).setText(getString(R$string.huaweicloud_service_content_item_phonefinder_new, 2));
            ((TextView) C12809f.m76831d(this.f15811s, R$id.hicloud_terms_3)).setText(getString(R$string.huaweicloud_service_content_item_4_170303, 3));
            int i11 = 4;
            if (C0209d.m1277l1() || BuildEx.VERSION.EMUI_SDK_INT >= 12) {
                TextView textView = (TextView) C12809f.m76831d(this.f15811s, R$id.hicloud_terms_4);
                textView.setText(getString(R$string.huaweicloud_service_content_item_8_push, 4));
                textView.setVisibility(0);
                i11 = 5;
            }
            ((TextView) C12809f.m76831d(this.f15811s, R$id.hicloud_terms_5)).setText(getString(R$string.huaweicloud_service_content_item_7_170303, Integer.valueOf(i11)));
            ((TextView) C12809f.m76831d(this.f15811s, R$id.hicloud_terms_6)).setVisibility(8);
            this.f15811s.setVisibility(0);
        } else if (6 == i10) {
            RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76829b(this, R$id.terms_of_service);
            ((OOBENavLayout) C12809f.m76831d(relativeLayout, R$id.oobe_terms_buttons)).setVisibility(8);
            m21965N1();
            C12809f.m76831d(relativeLayout, R$id.hicloud_terms_of_service).setVisibility(8);
            C12809f.m76831d(relativeLayout, R$id.migrate_terms_of_service).setVisibility(0);
            relativeLayout.setVisibility(0);
        }
        m21966P1(this.f15812t);
    }

    /* renamed from: M1 */
    public void m21964M1(String str, boolean z10, View.OnClickListener onClickListener) {
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

    /* renamed from: N1 */
    public void m21965N1() {
        TextView textView = (TextView) C12809f.m76829b(this, R$id.migrate_terms_1);
        textView.setText(getString(R$string.hicloud_migrate_terms_of_service_1_180531, 1));
        textView.setAlpha(1.0f);
        ((TextView) C12809f.m76829b(this, R$id.migrate_terms_2_1)).setAlpha(1.0f);
        ((TextView) C12809f.m76829b(this, R$id.migrate_terms_2_2)).setAlpha(1.0f);
        ((TextView) C12809f.m76829b(this, R$id.migrate_terms_2_3)).setAlpha(1.0f);
        C12809f.m76829b(this, R$id.hicloud_terms_of_service).setVisibility(8);
        C12809f.m76829b(this, R$id.migrate_terms_of_service).setVisibility(0);
        ((TextView) C12809f.m76829b(this, R$id.migrate_terms_4)).setVisibility(8);
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

    /* renamed from: P1 */
    public final void m21966P1(ImageView imageView) {
        Application application = getApplication();
        int i10 = C11842p.m70876w(application).heightPixels;
        float fM70789a0 = ((i10 * 0.3f) - C11842p.m70789a0(application)) - (application.getTheme().resolveAttribute(R.attr.actionBarSize, new TypedValue(), true) ? TypedValue.complexToDimensionPixelSize(r2.data, application.getResources().getDisplayMetrics()) : 0);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) C12809f.m76834g(imageView);
        layoutParams.topMargin = (int) fM70789a0;
        imageView.setLayoutParams(layoutParams);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f15808p);
        arrayList.add(this.f15809q);
        arrayList.add(this.f15810r);
        arrayList.add(this.f15811s);
        return arrayList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == C0209d.m1308t0("icon1")) {
            finish();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!C13843a.m83076a0(this)) {
            setRequestedOrientation(1);
        }
        setContentView(R$layout.hisync_policy_activity);
        try {
            Intent intent = getIntent();
            if (intent != null) {
                this.f15813u = new HiCloudSafeIntent(intent).getIntExtra("policytype", 0);
            }
        } catch (RuntimeException unused) {
            C11839m.m70688i("PolicyActivity", "intent Serializable error.");
        }
        int i10 = this.f15813u;
        m21964M1(i10 != 0 ? i10 != 1 ? i10 != 3 ? i10 != 6 ? i10 != 7 ? "" : getString(R$string.huaweicloud_service_item) : getString(R$string.hicloud_migrate_terms_of_service_title_180531) : getString(R$string.hw_privacy) : getString(R$string.huaweicloud_about_privacy) : getString(R$string.cloud_service_terms_text), false, this);
        m21963O1();
        mo19005p1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        C13227f.m79492i1().m79577X(this);
        UBAAnalyze.m29964Y("PVC", getClass().getCanonicalName(), "1", "34", super.mo18593F0());
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        C13227f.m79492i1().m79582b0(this);
        UBAAnalyze.m29967a0("PVC", getClass().getCanonicalName(), "1", "34");
    }
}
