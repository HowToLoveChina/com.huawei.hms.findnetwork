package com.huawei.android.hicloud.p088ui.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import gp.C10028c;
import org.json.JSONException;
import p015ak.C0209d;
import p015ak.C0240y;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public class WlanDetailActivity extends UIManagerActivity {
    /* renamed from: S2 */
    private void m22701S2() throws Resources.NotFoundException {
        int i10;
        int i11 = C0209d.m1262h2() ? R$string.wlan_detail : R$string.wifi_sync;
        m22365E1(i11);
        mo19982C1();
        this.f16187H.setText(i11);
        this.f16197M.setImageDrawable(getResources().getDrawable(R$drawable.ic_wifi));
        m22420G2(this, C0240y.m1681c(this, "com.android.settings"));
        Resources resources = getResources();
        int i12 = R$plurals.cloudbackup_some_records;
        int i13 = this.f16173A;
        String quantityString = resources.getQuantityString(i12, i13, Integer.valueOf(i13));
        if (C0209d.m1262h2()) {
            i10 = R$string.goto_wlan_global;
            m22417D2(R$id.enter_hyperlink, "com.android.settings", "com.android.settings.Settings$WifiSettingsActivity", getString(R$string.wlan_detail));
            this.f16200O.setText(R$string.wlan_setting);
        } else {
            i10 = R$string.goto_wifi_global;
            m22417D2(R$id.enter_hyperlink, "com.android.settings", "com.android.settings.Settings$WifiSettingsActivity", getString(R$string.wifi_sync));
            this.f16200O.setText(R$string.wifi_setting);
        }
        if (this.f16173A != 0) {
            this.f16199N.setVisibility(0);
        } else {
            this.f16199N.setVisibility(8);
        }
        this.f16201P.setText(C2783d.m16095M(quantityString, Integer.valueOf(this.f16173A)));
        m22419F2(this.f16195L, this.f16191J, "", getString(i10, "").trim());
    }

    /* renamed from: T2 */
    private void m22702T2() {
        this.f16199N.setVisibility(8);
        View view = this.f16207V;
        if (view != null) {
            view.setVisibility(8);
        }
        this.f16195L.setVisibility(0);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity
    /* renamed from: h2 */
    public boolean mo19217h2() {
        return C10028c.m62182c0().m62388s("wlan");
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, android.view.View.OnClickListener
    public void onClick(View view) throws IllegalAccessException, JSONException, Resources.NotFoundException, IllegalArgumentException {
        super.onClick(view);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws Resources.NotFoundException {
        C11839m.m70688i("WlanDetailActivity", "onCreate");
        super.onCreate(bundle);
        m22433f2(false);
        m22702T2();
        m22701S2();
    }
}
