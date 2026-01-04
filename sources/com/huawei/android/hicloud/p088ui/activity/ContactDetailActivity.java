package com.huawei.android.hicloud.p088ui.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
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
import p020ap.C1008c;
import p514o9.C11839m;
import p783xp.C13843a;

/* loaded from: classes3.dex */
public class ContactDetailActivity extends UIManagerActivity {
    /* renamed from: S2 */
    private void m20321S2() throws Resources.NotFoundException {
        Intent intent = getIntent();
        int intExtra = intent != null ? new HiCloudSafeIntent(intent).getIntExtra("recycle_contact_num", 0) : 0;
        C11839m.m70688i("ContactDetailActivity", "recycleNum: " + intExtra);
        int i10 = R$string.contact;
        m22365E1(i10);
        mo19982C1();
        this.f16187H.setText(i10);
        if (C0209d.m1269j1()) {
            this.f16197M.setImageDrawable(getResources().getDrawable(R$drawable.ic_contacts_honor));
        } else {
            this.f16197M.setImageDrawable(getResources().getDrawable(R$drawable.ic_contacts));
        }
        String strM83094p = C13843a.m83094p(this);
        C11839m.m70688i("ContactDetailActivity", "contact package name: " + strM83094p);
        m22420G2(this, C0240y.m1681c(this, strM83094p));
        if (!TextUtils.isEmpty(this.f16247z)) {
            this.f16199N.setVisibility(0);
            this.f16200O.setText(R$string.disk_app_detail_title);
            this.f16201P.setText(this.f16247z);
            this.f16202Q.setVisibility(0);
        }
        if (this.f16173A != 0) {
            this.f16203R.setVisibility(0);
            this.f16173A = C1008c.m6035v().m6106x();
            C11839m.m70688i("ContactDetailActivity", "refresh num = " + this.f16173A);
        }
        Resources resources = getResources();
        int i11 = R$plurals.contact_num;
        int i12 = this.f16173A;
        String quantityString = resources.getQuantityString(i11, i12, Integer.valueOf(i12));
        this.f16204S.setText(i10);
        this.f16205T.setText(C2783d.m16095M(quantityString, Integer.valueOf(this.f16173A)));
        if (intExtra == 0) {
            C11839m.m70688i("ContactDetailActivity", "refresh recycleNum = " + intExtra);
        }
        if (C0209d.m1184K0(this, strM83094p)) {
            if (this.f16207V != null) {
                if (this.f16203R.getVisibility() == 8 && this.f16199N.getVisibility() == 8 && this.f16208W.getVisibility() == 8) {
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
        m22418E2(R$id.enter_hyperlink, strM83094p, "", getString(i10), 1);
        m22419F2(this.f16195L, this.f16191J, "", getString(R$string.goto_specific_app, getString(i10)));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIManagerActivity
    /* renamed from: h2 */
    public boolean mo19217h2() {
        return C10028c.m62182c0().m62388s("addressbook");
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
        C11839m.m70688i("ContactDetailActivity", "onCreate");
        super.onCreate(bundle);
        m22433f2(true);
        m20321S2();
    }
}
