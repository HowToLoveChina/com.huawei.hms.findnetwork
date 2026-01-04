package com.huawei.android.hicloud.p088ui.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import gp.C10028c;
import org.json.JSONException;
import p015ak.C0209d;
import p015ak.C0240y;
import p336he.C10155f;
import p514o9.C11839m;
import p783xp.C13843a;

/* loaded from: classes3.dex */
public class BrowserDetailActivity extends UIManagerActivity {
    /* renamed from: S2 */
    private void m19215S2() throws Resources.NotFoundException {
        int i10 = R$string.browser;
        m22365E1(i10);
        mo19982C1();
        this.f16187H.setText(i10);
        Intent intent = getIntent();
        if (intent != null) {
            this.f16175B = new HiCloudSafeIntent(intent).getIntExtra("history_num", 0);
        }
        if (C0209d.m1269j1()) {
            this.f16197M.setImageDrawable(getResources().getDrawable(R$drawable.ic_hicloud_browser_list_new_honor));
        } else {
            this.f16197M.setImageDrawable(getResources().getDrawable(R$drawable.ic_hicloud_browser_list_new));
        }
        String strM83092n = C13843a.m83092n(this);
        if (strM83092n == null) {
            strM83092n = "com.android.browser";
        }
        m22417D2(R$id.enter_hyperlink, strM83092n, "", getString(i10));
        m22420G2(this, C0240y.m1681c(this, strM83092n));
        if (this.f16175B > 0) {
            this.f16203R.setVisibility(0);
            this.f16204S.setText(R$string.browserhistory);
            Resources resources = getResources();
            int i11 = R$plurals.cloudbackup_some_records;
            int i12 = this.f16175B;
            this.f16205T.setText(C2783d.m16095M(resources.getQuantityString(i11, i12, Integer.valueOf(i12)), Integer.valueOf(this.f16175B)));
        }
        if (C10155f.m63285i(this)) {
            m22419F2(this.f16195L, this.f16191J, "", getString(R$string.goto_specific_app, getString(i10)));
        }
    }

    /* renamed from: T2 */
    public final void m19216T2() {
        if (!C10155f.m63285i(this) || C0209d.m1293p1()) {
            View view = this.f16207V;
            if (view != null) {
                view.setVisibility(8);
            }
            this.f16195L.setVisibility(8);
            return;
        }
        if (this.f16207V != null) {
            if (this.f16199N.getVisibility() == 8 && this.f16203R.getVisibility() == 8) {
                this.f16207V.setVisibility(8);
            } else {
                this.f16207V.setVisibility(0);
            }
        }
        this.f16195L.setVisibility(0);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity
    /* renamed from: h2 */
    public boolean mo19217h2() {
        return C10028c.m62182c0().m62388s("browser");
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, android.view.View.OnClickListener
    public void onClick(View view) throws IllegalAccessException, JSONException, Resources.NotFoundException, IllegalArgumentException {
        super.onClick(view);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws Resources.NotFoundException {
        C11839m.m70688i("BrowserDetailActivity", "onCreate");
        super.onCreate(bundle);
        m22433f2(false);
        m19215S2();
        m19216T2();
    }
}
