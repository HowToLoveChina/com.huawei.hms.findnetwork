package com.huawei.android.hicloud.p088ui.activity;

import android.accounts.OperationCanceledException;
import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import com.huawei.android.hicloud.p088ui.CommonActivity;
import p514o9.C11839m;
import p514o9.C11842p;
import p681uj.C13195l;
import p709vj.InterfaceC13449b;

/* loaded from: classes3.dex */
public class AuthCallbackActivity extends CommonActivity implements InterfaceC13449b {

    /* renamed from: i */
    public int f13503i;

    /* renamed from: j */
    public int f13504j;

    /* renamed from: k */
    public int f13505k;

    /* renamed from: b1 */
    private void m18566b1() {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override // p709vj.InterfaceC13449b
    /* renamed from: L */
    public void mo13808L(Exception exc) {
    }

    @Override // p709vj.InterfaceC13449b
    /* renamed from: Q */
    public boolean mo13814Q(Bundle bundle) {
        return false;
    }

    @Override // p709vj.InterfaceC13449b
    /* renamed from: W */
    public void mo13820W(Bundle bundle) {
    }

    /* renamed from: e */
    public void mo13829e(OperationCanceledException operationCanceledException) {
    }

    @Override // android.app.Activity
    public void finish() {
        try {
            super.finish();
        } catch (Exception unused) {
            C11839m.m70687e("AuthCallbackActivity", "finish activity exception , activity :" + getClass().getName());
        }
    }

    @Override // p709vj.InterfaceC13449b
    /* renamed from: m0 */
    public void mo13838m0(Bundle bundle) {
    }

    @Override // com.huawei.android.hicloud.p088ui.CommonActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 8701) {
            C13195l.m79272J().m79299O(this, this, i10, i11, intent);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.CommonActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f13505k = C11842p.m70852q(this);
        this.f13504j = C11842p.m70789a0(this);
        this.f13503i = C11842p.m70725F(C11842p.m70876w(this), this);
    }

    @Override // com.huawei.android.hicloud.p088ui.CommonActivity, com.huawei.hicloud.base.p103ui.uiextend.EntrancePermissionCheckActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m18566b1();
        this.f13504j = C11842p.m70789a0(this);
        this.f13505k = C11842p.m70852q(this);
        this.f13503i = C11842p.m70725F(C11842p.m70876w(this), this);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }
}
