package com.huawei.android.hicloud.p088ui.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.uiextend.HiCloudItemView;
import com.huawei.android.sync.R$drawable;
import com.huawei.android.sync.R$id;
import com.huawei.android.sync.R$layout;
import com.huawei.android.sync.R$string;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import gp.C10028c;
import hu.C10343b;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p336he.C10155f;
import p514o9.C11839m;
import p514o9.C11842p;
import p684un.C13226e;
import p684un.C13230i;
import p709vj.C13452e;
import p807yd.C13947c;
import sk.C12809f;

/* loaded from: classes3.dex */
public class CloudDiskMainActivity extends UIActivity implements View.OnClickListener {

    /* renamed from: A */
    public boolean f14229A;

    /* renamed from: B */
    public boolean f14230B;

    /* renamed from: C */
    public NotchFitLinearLayout f14231C;

    /* renamed from: p */
    public C13947c f14232p;

    /* renamed from: q */
    public NotchTopFitRelativeLayout f14233q;

    /* renamed from: r */
    public HiCloudItemView f14234r;

    /* renamed from: s */
    public HiCloudItemView f14235s;

    /* renamed from: t */
    public HiCloudItemView f14236t;

    /* renamed from: u */
    public HiCloudItemView f14237u;

    /* renamed from: v */
    public HiCloudItemView f14238v;

    /* renamed from: w */
    public List<HiCloudItemView> f14239w = new ArrayList();

    /* renamed from: x */
    public boolean f14240x;

    /* renamed from: y */
    public boolean f14241y;

    /* renamed from: z */
    public boolean f14242z;

    /* renamed from: S1 */
    private void m19685S1() {
        if (C10028c.m62183d0(this).m62388s("autocallloglistkey")) {
            m19697X1(getResources().getString(R$string.settings_hicloud_open), "autocallloglistkey");
        } else {
            m19697X1(getResources().getString(R$string.settings_hicloud_close), "autocallloglistkey");
        }
        if (C10028c.m62183d0(this).m62388s("autosmslistkey")) {
            m19697X1(getResources().getString(R$string.settings_hicloud_open), "autosmslistkey");
        } else {
            m19697X1(getResources().getString(R$string.settings_hicloud_close), "autosmslistkey");
        }
        if (C10028c.m62183d0(this).m62388s("autorecordingkey")) {
            m19697X1(getResources().getString(R$string.settings_hicloud_open), "autorecordingkey");
        } else {
            m19697X1(getResources().getString(R$string.settings_hicloud_close), "autorecordingkey");
        }
        if (C10028c.m62183d0(this).m62388s("autophonemanagerkey")) {
            m19697X1(getResources().getString(R$string.settings_hicloud_open), "autophonemanagerkey");
        } else {
            m19697X1(getResources().getString(R$string.settings_hicloud_close), "autophonemanagerkey");
        }
    }

    /* renamed from: V1 */
    private void m19686V1() {
        this.f14233q = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f14231C = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.cloud_disk_notch_fit_linear_layout);
        m19696W1();
        m19693R1();
        m19695U1();
        m19694T1();
        m19689N1();
        m19687L1();
        m22381r1();
    }

    /* renamed from: L1 */
    public final void m19687L1() {
        this.f14239w.add(this.f14234r);
        this.f14239w.add(this.f14235s);
        this.f14239w.add(this.f14236t);
        this.f14239w.add(this.f14237u);
    }

    /* renamed from: M1 */
    public final void m19688M1() {
        if (C10155f.m63298v(this) && (this.f14240x || this.f14242z)) {
            this.f14235s.setVisibility(0);
            this.f14238v = this.f14235s;
        } else {
            C11839m.m70688i("CloudDiskMainActivity", "Voice not capable, disable callLog");
            this.f14235s.setVisibility(8);
        }
    }

    /* renamed from: N1 */
    public final void m19689N1() {
        Bundle extras = new HiCloudSafeIntent(getIntent()).getExtras();
        if (extras != null) {
            C10343b c10343b = new C10343b(extras);
            this.f14240x = c10343b.m63682d("isShowCloudDisk", false);
            this.f14241y = c10343b.m63682d(NavigationUtils.SMS_SCHEMA_PREF, false);
            this.f14242z = c10343b.m63682d("calllog", false);
            this.f14229A = c10343b.m63682d("recordig", false);
            this.f14230B = c10343b.m63682d("phonemanager", false);
        }
        m19692Q1();
        m19688M1();
        m19691P1();
        m19690O1();
        HiCloudItemView hiCloudItemView = this.f14238v;
        if (hiCloudItemView != null) {
            hiCloudItemView.hideDivider();
        }
    }

    /* renamed from: O1 */
    public final void m19690O1() {
        if (C10155f.m63250C(this) && (this.f14240x || this.f14230B)) {
            this.f14237u.setVisibility(0);
            this.f14238v = this.f14237u;
        } else {
            C11839m.m70688i("CloudDiskMainActivity", "Intercept not capable, disable interception");
            this.f14237u.setVisibility(8);
        }
    }

    /* renamed from: P1 */
    public final void m19691P1() {
        if (C10155f.m63254G(this) && (this.f14240x || this.f14229A)) {
            this.f14236t.setVisibility(0);
            this.f14238v = this.f14236t;
        } else {
            C11839m.m70688i("CloudDiskMainActivity", "Record not capable, disable record");
            this.f14236t.setVisibility(8);
        }
    }

    /* renamed from: Q1 */
    public final void m19692Q1() {
        if (C10155f.m63255H(this) && (this.f14240x || this.f14241y)) {
            this.f14234r.setVisibility(0);
            this.f14238v = this.f14234r;
        } else {
            C11839m.m70688i("CloudDiskMainActivity", "SMS not capable, disable SMS");
            this.f14234r.setVisibility(8);
        }
    }

    /* renamed from: R1 */
    public final void m19693R1() {
        HiCloudItemView hiCloudItemView = (HiCloudItemView) C12809f.m76829b(this, R$id.calllog_item_view);
        this.f14235s = hiCloudItemView;
        hiCloudItemView.setOnClickListener(this);
        if (C0209d.m1269j1()) {
            this.f14235s.setImage(getDrawable(R$drawable.icon_call_log_honor));
        } else {
            this.f14235s.setImage(getDrawable(R$drawable.icon_call_log));
        }
    }

    /* renamed from: T1 */
    public final void m19694T1() {
        HiCloudItemView hiCloudItemView = (HiCloudItemView) C12809f.m76829b(this, R$id.interception_item_view);
        this.f14237u = hiCloudItemView;
        hiCloudItemView.setOnClickListener(this);
    }

    /* renamed from: U1 */
    public final void m19695U1() {
        HiCloudItemView hiCloudItemView = (HiCloudItemView) C12809f.m76829b(this, R$id.record_item_view);
        this.f14236t = hiCloudItemView;
        hiCloudItemView.setOnClickListener(this);
        if (C0209d.m1269j1()) {
            this.f14236t.setImage(getDrawable(R$drawable.icon_record_detail_honor));
        } else {
            this.f14236t.setImage(getDrawable(R$drawable.icon_record_detail));
        }
    }

    /* renamed from: W1 */
    public final void m19696W1() {
        HiCloudItemView hiCloudItemView = (HiCloudItemView) C12809f.m76829b(this, R$id.message_item_view);
        this.f14234r = hiCloudItemView;
        hiCloudItemView.setOnClickListener(this);
        if (C0209d.m1269j1()) {
            this.f14234r.setImage(getDrawable(R$drawable.icon_message_honor));
        } else {
            this.f14234r.setImage(getDrawable(R$drawable.icon_message));
        }
    }

    /* renamed from: X1 */
    public void m19697X1(String str, String str2) {
        str2.hashCode();
        switch (str2) {
            case "autorecordingkey":
                if (CloudSyncUtil.m15948E0(this)) {
                    this.f14236t.setStatusText(str);
                    break;
                }
                break;
            case "autosmslistkey":
                if (CloudSyncUtil.m15950F0(this)) {
                    this.f14234r.setStatusText(str);
                    break;
                }
                break;
            case "autophonemanagerkey":
                if (CloudSyncUtil.m15946D0(this)) {
                    this.f14237u.setStatusText(str);
                    break;
                }
                break;
            case "autocallloglistkey":
                if (CloudSyncUtil.m15944C0(this)) {
                    this.f14235s.setStatusText(str);
                    break;
                }
                break;
            default:
                C11839m.m70687e("CloudDiskMainActivity", "model is null");
                break;
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: b1 */
    public C13230i mo18601b1() {
        return C13226e.m79491f1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f14233q);
        arrayList.add(this.f14234r);
        arrayList.add(this.f14231C);
        arrayList.add(this.f14235s);
        arrayList.add(this.f14236t);
        arrayList.add(this.f14237u);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: f1 */
    public int mo18507f1() {
        return R$id.cloud_disk_scroll_view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (R$id.message_item_view == id2) {
            Intent intent = new Intent(this, (Class<?>) CloudDiskSmsActivity.class);
            Bundle bundle = new Bundle();
            bundle.putBoolean("isShowCloudDisk", this.f14240x);
            intent.putExtras(bundle);
            startActivity(intent);
            C13226e.m79491f1().m79585f0("mecloud_clouddiskmain_click_messages", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_clouddiskmain_click_messages", "1", "12");
            return;
        }
        if (R$id.calllog_item_view == id2) {
            Intent intent2 = new Intent(this, (Class<?>) CloudDiskCallLogActivity.class);
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("isShowCloudDisk", this.f14240x);
            intent2.putExtras(bundle2);
            startActivity(intent2);
            C13226e.m79491f1().m79585f0("mecloud_clouddiskmain_click_calllog", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_clouddiskmain_click_calllog", "1", "25");
            return;
        }
        if (R$id.record_item_view == id2) {
            Intent intent3 = new Intent(this, (Class<?>) CloudDiskRecordingActivity.class);
            Bundle bundle3 = new Bundle();
            bundle3.putBoolean("isShowCloudDisk", this.f14240x);
            intent3.putExtras(bundle3);
            startActivity(intent3);
            C13226e.m79491f1().m79585f0("mecloud_clouddiskmain_click_recordings", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_clouddiskmain_click_recordings", "1", "26");
            return;
        }
        if (R$id.interception_item_view == id2) {
            Intent intent4 = new Intent(this, (Class<?>) CloudDiskInterceptionActivity.class);
            Bundle bundle4 = new Bundle();
            bundle4.putBoolean("isShowCloudDisk", this.f14240x);
            intent4.putExtras(bundle4);
            startActivity(intent4);
            C13226e.m79491f1().m79585f0("mecloud_clouddiskmain_click_phonemanager", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_clouddiskmain_click_phonemanager", "1", "6");
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        CloudSyncUtil.m15970P0(this.f14239w);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.cloud_disk_main);
        m19686V1();
        mo19005p1();
        if (this.f14240x) {
            C13947c c13947c = new C13947c(this);
            this.f14232p = c13947c;
            c13947c.m83785g();
            m22365E1(R$string.cloud_disk_item_title_new_update);
        } else {
            m22365E1(R$string.history_data_title);
        }
        mo19982C1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        C11842p.m70836m(this);
        super.onDestroy();
        C13947c c13947c = this.f14232p;
        if (c13947c != null) {
            c13947c.m83780b();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() throws Resources.NotFoundException {
        super.onResume();
        if (this.f14240x) {
            m19685S1();
            C13947c c13947c = this.f14232p;
            if (c13947c != null) {
                c13947c.m83782d();
                this.f14232p.m83786h();
            }
        }
    }
}
