package com.huawei.android.hicloud.p088ui.activity;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$string;
import gp.C10028c;
import org.json.JSONException;
import p015ak.C0209d;
import p015ak.C0240y;
import p514o9.C11839m;
import p783xp.C13843a;

/* loaded from: classes3.dex */
public class CalendarDetailActivity extends UIManagerActivity {
    /* renamed from: S2 */
    private void m19218S2() throws Resources.NotFoundException {
        int i10 = R$string.calendar_sync_item;
        m22365E1(i10);
        mo19982C1();
        this.f16187H.setText(i10);
        if (C0209d.m1269j1()) {
            this.f16197M.setImageDrawable(getResources().getDrawable(R$drawable.icon_calendar_honor));
        } else {
            this.f16197M.setImageDrawable(getResources().getDrawable(R$drawable.icon_calendar));
        }
        String strM83093o = C13843a.m83093o(this);
        C11839m.m70688i("CalendarDetailActivity", "calendar package name: " + strM83093o);
        m22420G2(this, C0240y.m1681c(this, strM83093o));
        if (C0209d.m1184K0(this, strM83093o)) {
            if (this.f16207V != null) {
                if (this.f16199N.getVisibility() == 8 && this.f16203R.getVisibility() == 8) {
                    this.f16207V.setVisibility(8);
                } else {
                    this.f16207V.setVisibility(0);
                }
            }
            this.f16195L.setVisibility(0);
        } else {
            View view = this.f16207V;
            if (view != null) {
                view.setVisibility(8);
            }
        }
        m22418E2(R$id.enter_hyperlink, strM83093o, "", getString(i10), 2);
        m22419F2(this.f16195L, this.f16191J, "", getString(R$string.goto_specific_app, getString(i10)));
    }

    /* renamed from: T2 */
    public final void m19219T2() {
        this.f16202Q.setVisibility(8);
    }

    /* renamed from: U2 */
    public final void m19220U2() {
        C11839m.m70688i("CalendarDetailActivity", "calendar detail showDataSize size = " + this.f16247z);
        if (TextUtils.isEmpty(this.f16247z)) {
            this.f16199N.setVisibility(8);
            this.f16202Q.setVisibility(8);
        } else {
            this.f16199N.setVisibility(0);
            this.f16202Q.setVisibility(0);
            this.f16200O.setText(R$string.disk_app_detail_title);
            this.f16201P.setText(this.f16247z);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity
    /* renamed from: h2 */
    public boolean mo19217h2() {
        return C10028c.m62182c0().m62388s("calendar");
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, android.view.View.OnClickListener
    public void onClick(View view) throws IllegalAccessException, JSONException, Resources.NotFoundException, IllegalArgumentException {
        super.onClick(view);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws Resources.NotFoundException {
        C11839m.m70688i("CalendarDetailActivity", "onCreate");
        super.onCreate(bundle);
        m22433f2(true);
        m19218S2();
        m19220U2();
        m19219T2();
    }
}
