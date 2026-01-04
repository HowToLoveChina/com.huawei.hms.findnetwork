package com.huawei.android.hicloud.oobe.p086ui.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.oobe.R$dimen;
import com.huawei.android.hicloud.oobe.R$id;
import com.huawei.android.hicloud.oobe.R$layout;
import com.huawei.android.hicloud.oobe.R$string;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.DisableSupportedRelativeLayout;
import com.huawei.android.hicloud.oobe.p086ui.uiextend.UnionSwitch;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import gp.C10028c;
import p015ak.C0209d;
import p422k9.C11019b;
import p514o9.C11829c;
import p514o9.C11842p;
import p684un.C13227f;
import sk.C12809f;

/* loaded from: classes3.dex */
public class SimplifyOOBECloudItemActivity extends OOBEAuthCallbackActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    /* renamed from: e */
    public LinearLayout f12459e;

    /* renamed from: f */
    public UnionSwitch f12460f;

    /* renamed from: g */
    public UnionSwitch f12461g;

    /* renamed from: h */
    public UnionSwitch f12462h;

    /* renamed from: i */
    public UnionSwitch f12463i;

    /* renamed from: j */
    public UnionSwitch f12464j;

    /* renamed from: k */
    public UnionSwitch f12465k;

    /* renamed from: l */
    public RelativeLayout f12466l;

    /* renamed from: m */
    public DisableSupportedRelativeLayout f12467m;

    /* renamed from: n */
    public DisableSupportedRelativeLayout f12468n;

    /* renamed from: o */
    public RelativeLayout f12469o;

    /* renamed from: p */
    public RelativeLayout f12470p;

    /* renamed from: q */
    public RelativeLayout f12471q;

    /* renamed from: r */
    public RelativeLayout f12472r;

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.SimplifyOOBECloudItemActivity$a */
    public class ViewOnSystemUiVisibilityChangeListenerC2836a implements View.OnSystemUiVisibilityChangeListener {
        public ViewOnSystemUiVisibilityChangeListenerC2836a() {
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i10) {
            C11829c.m70585i1(SimplifyOOBECloudItemActivity.this.getWindow());
            C11829c.m70633y1(SimplifyOOBECloudItemActivity.this.getApplicationContext(), SimplifyOOBECloudItemActivity.this.getWindow());
        }
    }

    /* renamed from: i */
    private void m16736i() {
        RelativeLayout relativeLayout;
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        if (!c10028cM62182c0.m62395t1("funcfg_contacts")) {
            this.f12469o.setVisibility(8);
        }
        if (!c10028cM62182c0.m62395t1("funcfg_calendar")) {
            this.f12471q.setVisibility(8);
        }
        if (!c10028cM62182c0.m62395t1("funcfg_wlan")) {
            this.f12468n.setVisibility(8);
        }
        if (!c10028cM62182c0.m62395t1("funcfg_cloud_backup")) {
            this.f12470p.setVisibility(8);
        }
        if (!C11019b.m66371t().m66399S()) {
            this.f12467m.setVisibility(8);
        }
        if (c10028cM62182c0.m62395t1("funcfg_browser") || (relativeLayout = this.f12472r) == null) {
            return;
        }
        relativeLayout.setVisibility(8);
    }

    /* renamed from: j */
    private void m16737j() {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    /* renamed from: k */
    private void m16738k() {
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        boolean zM62388s = c10028cM62182c0.m62388s("addressbook");
        boolean zM62388s2 = c10028cM62182c0.m62388s("calendar");
        boolean zM62388s3 = c10028cM62182c0.m62388s("uploadphotokey");
        boolean zM62388s4 = c10028cM62182c0.m62388s("notepad");
        boolean zM62388s5 = c10028cM62182c0.m62388s("wlan");
        boolean zM62388s6 = c10028cM62182c0.m62388s("browser");
        this.f12460f.setChecked(zM62388s);
        this.f12461g.setChecked(zM62388s);
        this.f12465k.setChecked(zM62388s4);
        this.f12463i.setChecked(zM62388s5);
        this.f12461g.setChecked(zM62388s2);
        this.f12462h.setChecked(zM62388s3);
        this.f12464j.setChecked(zM62388s6);
    }

    /* renamed from: l */
    private void m16739l() {
        if (C0209d.m1166E1()) {
            return;
        }
        this.f12467m.m17033a();
        this.f12468n.m17033a();
    }

    /* renamed from: m */
    private void m16740m() {
        if (getResources().getConfiguration().orientation == 2) {
            C11842p.m70775V1(this, this.f12459e);
        } else {
            C11842p.m70791a2(this.f12459e);
        }
    }

    /* renamed from: n */
    private void m16741n() {
        TextView textView = (TextView) C12809f.m76829b(this, R$id.open_wlan_title);
        if (C0209d.m1262h2()) {
            textView.setText(getResources().getString(R$string.wlan_sync));
        } else {
            textView.setText(getResources().getString(R$string.wifi_sync));
        }
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76829b(this, R$id.main_layout);
        this.f12466l = relativeLayout;
        C11842p.m70891z2(this, relativeLayout);
        UnionSwitch unionSwitch = (UnionSwitch) C12809f.m76829b(this, R$id.open_notepad_switch);
        this.f12465k = unionSwitch;
        unionSwitch.setOnCheckedChangeListener(this);
        UnionSwitch unionSwitch2 = (UnionSwitch) C12809f.m76829b(this, R$id.open_wlan_switch);
        this.f12463i = unionSwitch2;
        unionSwitch2.setOnCheckedChangeListener(this);
        UnionSwitch unionSwitch3 = (UnionSwitch) C12809f.m76829b(this, R$id.open_browser_switch);
        this.f12464j = unionSwitch3;
        unionSwitch3.setOnCheckedChangeListener(this);
        UnionSwitch unionSwitch4 = (UnionSwitch) C12809f.m76829b(this, R$id.open_contact_switch);
        this.f12460f = unionSwitch4;
        unionSwitch4.setOnCheckedChangeListener(this);
        UnionSwitch unionSwitch5 = (UnionSwitch) C12809f.m76829b(this, R$id.open_gellery_switch);
        this.f12462h = unionSwitch5;
        unionSwitch5.setOnCheckedChangeListener(this);
        UnionSwitch unionSwitch6 = (UnionSwitch) C12809f.m76829b(this, R$id.open_calendar_switch);
        this.f12461g = unionSwitch6;
        unionSwitch6.setOnCheckedChangeListener(this);
        RelativeLayout relativeLayout2 = (RelativeLayout) C12809f.m76829b(this, R$id.open_notepad);
        this.f12470p = relativeLayout2;
        relativeLayout2.setOnClickListener(this);
        DisableSupportedRelativeLayout disableSupportedRelativeLayout = (DisableSupportedRelativeLayout) C12809f.m76829b(this, R$id.open_wlan);
        this.f12468n = disableSupportedRelativeLayout;
        disableSupportedRelativeLayout.setOnClickListener(this);
        RelativeLayout relativeLayout3 = (RelativeLayout) C12809f.m76829b(this, R$id.open_contact);
        this.f12469o = relativeLayout3;
        relativeLayout3.setOnClickListener(this);
        RelativeLayout relativeLayout4 = (RelativeLayout) C12809f.m76829b(this, R$id.open_calendar);
        this.f12471q = relativeLayout4;
        relativeLayout4.setOnClickListener(this);
        DisableSupportedRelativeLayout disableSupportedRelativeLayout2 = (DisableSupportedRelativeLayout) C12809f.m76829b(this, R$id.open_gellery);
        this.f12467m = disableSupportedRelativeLayout2;
        disableSupportedRelativeLayout2.setOnClickListener(this);
        RelativeLayout relativeLayout5 = (RelativeLayout) C12809f.m76829b(this, R$id.open_browser);
        this.f12472r = relativeLayout5;
        relativeLayout5.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) C12809f.m76829b(this, R$id.oobe_guide_main_frame);
        this.f12459e = linearLayout;
        if (linearLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) this.f12459e.getLayoutParams()).setMarginEnd(getResources().getDimensionPixelSize(R$dimen.margin_xl));
        }
        if (C11019b.m66371t().m66391K(this)) {
            this.f12472r.setVisibility(0);
        } else {
            this.f12472r.setVisibility(8);
        }
        if (C11842p.m70771U0()) {
            m16740m();
        }
    }

    /* renamed from: o */
    public void m16742o() {
        C11829c.m70585i1(getWindow());
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new ViewOnSystemUiVisibilityChangeListenerC2836a());
        C11829c.m70633y1(this, getWindow());
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (-1 == i11) {
            setResult(-1);
            finish();
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
        int id2 = compoundButton.getId();
        C10028c c10028cM62183d0 = C10028c.m62183d0(this);
        if (id2 == R$id.open_contact_switch) {
            c10028cM62183d0.m62336h2("addressbook", z10);
            return;
        }
        if (id2 == R$id.open_wlan_switch) {
            c10028cM62183d0.m62336h2("wlan", z10);
            return;
        }
        if (id2 == R$id.open_calendar_switch) {
            c10028cM62183d0.m62336h2("calendar", z10);
            return;
        }
        if (id2 == R$id.open_gellery_switch) {
            c10028cM62183d0.m62336h2("uploadphotokey", z10);
        } else if (id2 == R$id.open_notepad_switch) {
            c10028cM62183d0.m62336h2("notepad", z10);
        } else if (id2 == R$id.open_browser_switch) {
            c10028cM62183d0.m62336h2("browser", z10);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R$id.open_contact) {
            this.f12460f.setChecked(!r2.isChecked());
            return;
        }
        if (view.getId() == R$id.open_gellery) {
            this.f12462h.setChecked(!r2.isChecked());
            return;
        }
        if (view.getId() == R$id.open_calendar) {
            this.f12461g.setChecked(!r2.isChecked());
            return;
        }
        if (view.getId() == R$id.open_notepad) {
            this.f12465k.setChecked(!r2.isChecked());
        } else if (view.getId() == R$id.open_wlan) {
            this.f12463i.setChecked(!r2.isChecked());
        } else if (view.getId() == R$id.open_browser) {
            this.f12464j.setChecked(!r2.isChecked());
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEAuthCallbackActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (C11842p.m70771U0()) {
            m16740m();
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEAuthCallbackActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (C11842p.m70759Q0()) {
            setRequestedOrientation(1);
        }
        setContentView(R$layout.simplify_oobe_cloud_items);
        m16741n();
        m16738k();
        m16737j();
        m16736i();
        m16739l();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        C13227f.m79492i1().m79577X(this);
        UBAAnalyze.m29964Y("PVC", getClass().getCanonicalName(), "1", "18", super.m16544a());
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEAuthCallbackActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        m16742o();
        C13227f.m79492i1().m79582b0(this);
        UBAAnalyze.m29967a0("PVC", getClass().getCanonicalName(), "1", "18");
    }
}
