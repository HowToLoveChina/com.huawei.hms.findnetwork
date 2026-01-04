package com.huawei.android.hicloud.p088ui.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import com.huawei.android.hicloud.p088ui.CommonActivity;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import p514o9.C11842p;
import p684un.C13227f;
import p783xp.C13843a;

/* loaded from: classes3.dex */
public class TermsBaseActivity extends CommonActivity {

    /* renamed from: i */
    public ScrollView f16154i;

    /* renamed from: j */
    public View f16155j;

    /* renamed from: b1 */
    public void m22354b1() {
        if (getResources().getConfiguration().orientation == 2) {
            C11842p.m70775V1(this, this.f16155j);
            C11842p.m70775V1(this, this.f16154i);
        } else {
            C11842p.m70791a2(this.f16155j);
            C11842p.m70791a2(this.f16154i);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.CommonActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (C11842p.m70771U0()) {
            m22354b1();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.CommonActivity, com.huawei.hicloud.base.p103ui.uiextend.EntrancePermissionCheckActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!C11842p.m70759Q0() || C13843a.m83076a0(this)) {
            return;
        }
        setRequestedOrientation(1);
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.EntrancePermissionCheckActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        C13227f.m79492i1().m79577X(this);
        UBAAnalyze.m29964Y("PVC", getClass().getCanonicalName(), "1", "34", super.mo18593F0());
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.EntrancePermissionCheckActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        C13227f.m79492i1().m79582b0(this);
        UBAAnalyze.m29967a0("PVC", getClass().getCanonicalName(), "1", "34");
    }
}
