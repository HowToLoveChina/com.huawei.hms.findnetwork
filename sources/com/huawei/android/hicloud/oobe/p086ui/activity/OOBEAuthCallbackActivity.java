package com.huawei.android.hicloud.oobe.p086ui.activity;

import android.accounts.OperationCanceledException;
import android.app.ActionBar;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import p015ak.C0209d;
import p015ak.C0219i;
import p015ak.C0234s;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p709vj.InterfaceC13449b;
import sk.C12808e;

/* loaded from: classes3.dex */
public class OOBEAuthCallbackActivity extends Activity implements InterfaceC13449b {

    /* renamed from: a */
    public int f12337a;

    /* renamed from: b */
    public int f12338b;

    /* renamed from: c */
    public int f12339c;

    /* renamed from: d */
    public long f12340d;

    /* renamed from: c */
    private void m16542c() throws IllegalAccessException, IllegalArgumentException {
        if (C0219i.m1463a() < 17 || !C11829c.m70563b0(this)) {
            return;
        }
        C11829c.m70591k1(this);
    }

    /* renamed from: g */
    private void m16543g() {
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

    /* renamed from: a */
    public int m16544a() {
        int iCurrentTimeMillis = (int) ((System.currentTimeMillis() - this.f12340d) / 1000);
        if (iCurrentTimeMillis <= 0) {
            return 1;
        }
        return iCurrentTimeMillis;
    }

    /* renamed from: b */
    public void m16545b(Button button) {
        if (button == null) {
            C11839m.m70688i("AuthCallbackActivity", "initButton view is null");
        } else if (C0219i.m1463a() < 23) {
            m16547f(button);
        }
    }

    /* renamed from: d */
    public void m16546d(Context context, String str, int i10) {
        Intent intent = new Intent();
        intent.setAction("com.huawei.hwid.action.START_BY_OOBE_APP");
        C0209d.m1302r2(intent, "com.huawei.hwid");
        if (intent.resolveActivity(getPackageManager()) == null) {
            C11839m.m70688i(str, "the hw id apk is not exist");
            setResult(-1);
            finish();
            return;
        }
        C11839m.m70688i(str, "the hw id apk is installed");
        Intent intent2 = new Intent();
        intent2.setComponent(new ComponentName("com.huawei.hicloud", "com.huawei.android.hicloud.oobe.ui.activity.OOBEStartActivity"));
        try {
            startActivityForResult(intent2, 10009);
        } catch (Exception e10) {
            C11839m.m70688i(str, "startActivity Exception: " + e10.toString());
        }
    }

    @Override // p709vj.InterfaceC13449b
    /* renamed from: e */
    public void mo13829e(OperationCanceledException operationCanceledException) {
    }

    /* renamed from: f */
    public final void m16547f(Button button) {
        boolean z10 = getResources().getConfiguration().orientation == 2;
        if (!C11842p.m70771U0()) {
            C11842p.m70780X0(button, this);
        } else if (z10) {
            C11842p.m70781X1(this, button);
        } else {
            C11842p.m70787Z1(this, button);
        }
    }

    @Override // android.app.Activity
    public void finish() {
        try {
            super.finish();
        } catch (Exception unused) {
            C11839m.m70687e("AuthCallbackActivity", "finish activity exception , activity :" + getClass().getName());
        }
    }

    /* renamed from: h */
    public void m16548h(int i10, Context context, int i11) {
        if (i11 == 2) {
            Intent intent = new Intent();
            intent.setClass(context, MigrateTermsDialogActivity.class);
            startActivityForResult(intent, i10);
        } else {
            Intent intent2 = new Intent(context, (Class<?>) OOBEMigrateTermsActivity.class);
            intent2.putExtra("termsType", i10);
            startActivityForResult(intent2, i10);
        }
    }

    public void initHwButton(View view) {
        if (view == null || C0219i.m1463a() >= 23) {
            C11839m.m70688i("AuthCallbackActivity", "initHwButton view is null");
        } else {
            C11842p.m70874v1(this, view);
        }
    }

    @Override // p709vj.InterfaceC13449b
    /* renamed from: m0 */
    public void mo13838m0(Bundle bundle) {
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        C0234s.m1639q(this);
        super.onConfigurationChanged(configuration);
        this.f12337a = C11842p.m70789a0(this);
        this.f12338b = C11842p.m70852q(this);
        this.f12339c = C11842p.m70725F(C11842p.m70876w(this), this);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m16543g();
        m16542c();
        C12808e.m76822a(this);
        this.f12337a = C11842p.m70789a0(this);
        this.f12338b = C11842p.m70852q(this);
        this.f12339c = C11842p.m70725F(C11842p.m70876w(this), this);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    @Override // android.app.Activity
    public void onResume() {
        this.f12340d = System.currentTimeMillis();
        super.onResume();
    }

    public void setEmptyViewMarginTop(View view) {
        if (view == null) {
            C11839m.m70688i("AuthCallbackActivity", "setEmptyViewMarginTop view is null");
            return;
        }
        boolean z10 = getResources().getConfiguration().orientation == 2;
        DisplayMetrics displayMetricsM70876w = C11842p.m70876w(this);
        ViewGroup.MarginLayoutParams layoutParams = view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) view.getLayoutParams() : new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(0, z10 ? (int) ((((displayMetricsM70876w.heightPixels * 0.4f) + 0.5f) - this.f12337a) - this.f12338b) : (int) ((((displayMetricsM70876w.heightPixels * 0.3d) + 0.5d) - this.f12337a) - this.f12338b), 0, 0);
        view.setLayoutParams(layoutParams);
    }
}
