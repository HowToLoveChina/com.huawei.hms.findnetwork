package com.huawei.android.hicloud.p088ui.activity;

import android.app.ActionBar;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitLinearLayout;
import com.huawei.hicloud.sync.R$drawable;
import com.huawei.hicloud.sync.R$id;
import com.huawei.hicloud.sync.R$layout;
import java.util.ArrayList;
import java.util.List;
import mc.C11436a;
import mc.C11437b;
import p015ak.C0213f;
import p223db.C9062b;
import p514o9.C11839m;
import p514o9.C11842p;
import sk.C12809f;

/* loaded from: classes3.dex */
public class SiteOfflineTipActivity extends SiteChangeBaseActivity {

    /* renamed from: p */
    public NotchTopFitLinearLayout f16002p;

    /* renamed from: q */
    public NotchFitLinearLayout f16003q;

    /* renamed from: r */
    public AutoSizeButton f16004r;

    /* renamed from: s */
    public AutoSizeButton f16005s;

    /* renamed from: t */
    public ActionBar f16006t;

    /* renamed from: com.huawei.android.hicloud.ui.activity.SiteOfflineTipActivity$a */
    public class ViewOnClickListenerC3475a implements View.OnClickListener {
        public ViewOnClickListenerC3475a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C11839m.m70688i("SiteOfflineTipActivity", "button continue clicked.");
            Context contextM1377a = C0213f.m1377a();
            if (contextM1377a != null) {
                C11437b.m68501e().m68505d(contextM1377a);
                C9062b.m57146k().m57155h(false, false);
            }
            SiteOfflineTipActivity.this.finish();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.SiteOfflineTipActivity$b */
    public class ViewOnClickListenerC3476b implements View.OnClickListener {
        public ViewOnClickListenerC3476b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C11839m.m70688i("SiteOfflineTipActivity", "button know more clicked.");
            C11436a.m68492d().m68496e("siteOffline", SiteOfflineTipActivity.this);
        }
    }

    /* renamed from: M1 */
    private void m22159M1() {
        this.f16002p = (NotchTopFitLinearLayout) C12809f.m76829b(this, R$id.main_notch_fit_top_layout);
        this.f16003q = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76829b(this, R$id.site_offline_continue_btn);
        this.f16004r = autoSizeButton;
        autoSizeButton.setOnClickListener(new ViewOnClickListenerC3475a());
        AutoSizeButton autoSizeButton2 = (AutoSizeButton) C12809f.m76829b(this, R$id.site_offline_know_more);
        this.f16005s = autoSizeButton2;
        autoSizeButton2.setOnClickListener(new ViewOnClickListenerC3476b());
        C11842p.m70874v1(this, this.f16004r);
        mo19005p1();
        ActionBar actionBar = getActionBar();
        this.f16006t = actionBar;
        if (actionBar != null) {
            actionBar.setTitle("");
            this.f16006t.setDisplayHomeAsUpEnabled(true);
            this.f16006t.setHomeAsUpIndicator(R$drawable.cloud_space_guide_back_icon);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f16002p);
        arrayList.add(this.f16003q);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.site_offline_tip_activity);
        m22159M1();
    }
}
