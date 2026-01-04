package com.huawei.android.hicloud.p088ui.activity;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitLinearLayout;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.sync.R$drawable;
import com.huawei.hicloud.sync.R$id;
import com.huawei.hicloud.sync.R$layout;
import java.util.ArrayList;
import java.util.List;
import mc.C11436a;
import mc.C11437b;
import p015ak.C0213f;
import p223db.C9062b;
import p422k9.C11019b;
import p514o9.C11839m;
import p514o9.C11842p;
import sk.C12809f;

/* loaded from: classes3.dex */
public class SiteChangeTipActivity extends SiteChangeBaseActivity {

    /* renamed from: p */
    public NotchTopFitLinearLayout f15995p;

    /* renamed from: q */
    public NotchFitLinearLayout f15996q;

    /* renamed from: r */
    public AutoSizeButton f15997r;

    /* renamed from: s */
    public AutoSizeButton f15998s;

    /* renamed from: t */
    public ActionBar f15999t;

    /* renamed from: com.huawei.android.hicloud.ui.activity.SiteChangeTipActivity$a */
    public class ViewOnClickListenerC3473a implements View.OnClickListener {
        public ViewOnClickListenerC3473a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C11839m.m70688i("SiteChangeTipActivity", "button continue clicked.");
            Context contextM1377a = C0213f.m1377a();
            if (contextM1377a != null) {
                C11437b.m68501e().m68504c(contextM1377a);
                C9062b.m57146k().m57155h(false, false);
            }
            Intent intent = new Intent();
            intent.setClass(SiteChangeTipActivity.this, C11019b.m66371t().m66441r(NotifyConstants.ActivityName.HISYNC_SETTING_ACTIVITY));
            SiteChangeTipActivity.this.startActivity(intent);
            SiteChangeTipActivity.this.finish();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.SiteChangeTipActivity$b */
    public class ViewOnClickListenerC3474b implements View.OnClickListener {
        public ViewOnClickListenerC3474b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C11839m.m70688i("SiteChangeTipActivity", "button know more clicked.");
            C11436a.m68492d().m68496e("siteChange", SiteChangeTipActivity.this);
        }
    }

    /* renamed from: M1 */
    private void m22158M1() {
        this.f15995p = (NotchTopFitLinearLayout) C12809f.m76829b(this, R$id.main_notch_fit_top_layout);
        this.f15996q = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76829b(this, R$id.site_change_continue_btn);
        this.f15997r = autoSizeButton;
        autoSizeButton.setOnClickListener(new ViewOnClickListenerC3473a());
        AutoSizeButton autoSizeButton2 = (AutoSizeButton) C12809f.m76829b(this, R$id.site_change_know_more);
        this.f15998s = autoSizeButton2;
        autoSizeButton2.setOnClickListener(new ViewOnClickListenerC3474b());
        C11842p.m70874v1(this, this.f15997r);
        mo19005p1();
        ActionBar actionBar = getActionBar();
        this.f15999t = actionBar;
        if (actionBar != null) {
            actionBar.setTitle("");
            this.f15999t.setDisplayHomeAsUpEnabled(true);
            this.f15999t.setHomeAsUpIndicator(R$drawable.cloud_space_guide_back_icon);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f15995p);
        arrayList.add(this.f15996q);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (new HiCloudSafeIntent(getIntent()).getIntExtra(NotifyConstants.NOTIFY_ID_KEY, 0) == 289) {
            C11437b.m68501e().m68503b(this);
        }
        setContentView(R$layout.site_change_tip_activity);
        m22158M1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (new HiCloudSafeIntent(getIntent()).getIntExtra(NotifyConstants.NOTIFY_ID_KEY, 0) == 289) {
            C11437b.m68501e().m68503b(this);
        }
    }
}
