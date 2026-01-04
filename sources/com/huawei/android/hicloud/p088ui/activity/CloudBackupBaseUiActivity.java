package com.huawei.android.hicloud.p088ui.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import p514o9.C11842p;
import p684un.C13225d;
import p684un.C13230i;
import sk.C12809f;

/* loaded from: classes3.dex */
public abstract class CloudBackupBaseUiActivity extends BaseActivity {

    /* renamed from: A */
    public RelativeLayout f13883A;

    /* renamed from: B */
    public RelativeLayout f13884B;

    /* renamed from: p */
    public NotchTopFitRelativeLayout f13885p;

    /* renamed from: q */
    public NotchFitRelativeLayout f13886q;

    /* renamed from: r */
    public NotchFitRelativeLayout f13887r;

    /* renamed from: s */
    public AutoSizeButton f13888s;

    /* renamed from: t */
    public TextView f13889t;

    /* renamed from: u */
    public RelativeLayout f13890u;

    /* renamed from: v */
    public TextView f13891v;

    /* renamed from: w */
    public ImageView f13892w;

    /* renamed from: x */
    public TextView f13893x;

    /* renamed from: y */
    public RelativeLayout f13894y;

    /* renamed from: z */
    public RelativeLayout f13895z;

    /* renamed from: M1 */
    public final void m19234M1() {
        C11842p.m70760Q1(this, this.f13883A);
        C11842p.m70760Q1(this, this.f13895z);
        C11842p.m70760Q1(this, this.f13884B);
    }

    /* renamed from: N1 */
    public final void m19235N1() {
        this.f13885p = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f13886q = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.rl_loading);
        this.f13887r = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.rl_nonet);
        AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76829b(this, R$id.bt_no_net);
        this.f13888s = autoSizeButton;
        C11842p.m70874v1(this, autoSizeButton);
        this.f13889t = (TextView) C12809f.m76829b(this, R$id.tv_network);
        this.f13895z = (RelativeLayout) C12809f.m76829b(this, R$id.rl_network_not_connect);
        this.f13883A = (RelativeLayout) C12809f.m76829b(this, R$id.rl_fit_loading);
        this.f13890u = (RelativeLayout) C12809f.m76829b(this, R$id.rl_no_data);
        this.f13891v = (TextView) C12809f.m76829b(this, R$id.tv_empty_top_tip);
        this.f13892w = (ImageView) C12809f.m76829b(this, R$id.iv_data_mepty);
        this.f13893x = (TextView) C12809f.m76829b(this, R$id.tv_data_empty);
        this.f13884B = (RelativeLayout) C12809f.m76829b(this, R$id.rl_fit_no_data);
        this.f13894y = (RelativeLayout) C12809f.m76829b(this, R$id.rl_pager_content);
        m19234M1();
    }

    /* renamed from: O1 */
    public void mo19236O1() {
        this.f13886q.setVisibility(8);
        this.f13887r.setVisibility(8);
        this.f13890u.setVisibility(8);
        this.f13894y.setVisibility(0);
    }

    /* renamed from: P1 */
    public void mo19229P1(int i10, int i11) {
        this.f13886q.setVisibility(8);
        this.f13887r.setVisibility(8);
        this.f13890u.setVisibility(0);
        this.f13894y.setVisibility(8);
        this.f13893x.setVisibility(0);
        this.f13893x.setText(i10);
        this.f13892w.setVisibility(0);
        this.f13892w.setImageResource(i11);
    }

    /* renamed from: Q1 */
    public void m19237Q1(int i10) {
        this.f13886q.setVisibility(8);
        this.f13887r.setVisibility(0);
        this.f13890u.setVisibility(8);
        this.f13894y.setVisibility(8);
        this.f13889t.setText(i10);
        this.f13888s.setVisibility(8);
    }

    /* renamed from: R1 */
    public void m19238R1() {
        this.f13886q.setVisibility(0);
        this.f13887r.setVisibility(8);
        this.f13890u.setVisibility(8);
        this.f13894y.setVisibility(8);
    }

    /* renamed from: S1 */
    public void m19239S1() {
        this.f13886q.setVisibility(8);
        this.f13887r.setVisibility(0);
        this.f13890u.setVisibility(8);
        this.f13894y.setVisibility(8);
        this.f13889t.setText(R$string.network_unavailable);
        this.f13888s.setVisibility(0);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: b1 */
    public C13230i mo18601b1() {
        return C13225d.m79490f1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m19234M1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_backup_base_ui);
        m19235N1();
        mo19982C1();
    }
}
