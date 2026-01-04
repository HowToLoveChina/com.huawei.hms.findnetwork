package com.huawei.android.hicloud.p088ui.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.lang.reflect.InvocationTargetException;
import p015ak.C0234s;
import p223db.C9062b;
import p514o9.C11839m;
import p664u0.C13108a;
import p684un.C13227f;
import sk.C12808e;

/* loaded from: classes3.dex */
public class LogoutProcessActivity extends Activity implements View.OnClickListener {

    /* renamed from: a */
    public Context f15162a = null;

    /* renamed from: b */
    public boolean f15163b = false;

    /* renamed from: c */
    public ProgressDialog f15164c;

    /* renamed from: d */
    public long f15165d;

    /* renamed from: e */
    public C3335b f15166e;

    /* renamed from: com.huawei.android.hicloud.ui.activity.LogoutProcessActivity$b */
    public class C3335b extends BroadcastReceiver {
        public C3335b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (context == null || intent == null) {
                C11839m.m70688i(NotifyConstants.ActivityName.LOGOUT_PROCESS_ACTIVITY, "context or intent is null");
            } else if ("quit_account".equals(intent.getAction())) {
                LogoutProcessActivity.this.m20947c();
            }
        }
    }

    /* renamed from: b */
    public int m20946b() {
        int iCurrentTimeMillis = (int) ((System.currentTimeMillis() - this.f15165d) / 1000);
        if (iCurrentTimeMillis <= 0) {
            return 1;
        }
        return iCurrentTimeMillis;
    }

    /* renamed from: c */
    public final void m20947c() {
        C11839m.m70688i(NotifyConstants.ActivityName.LOGOUT_PROCESS_ACTIVITY, "Enter processLogout");
        C9062b.m57149s(false);
        ProgressDialog progressDialog = this.f15164c;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        setResult(-1);
        finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        C11839m.m70688i(NotifyConstants.ActivityName.LOGOUT_PROCESS_ACTIVITY, "onConfigurationChanged");
        C0234s.m1639q(this);
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        C11839m.m70688i(NotifyConstants.ActivityName.LOGOUT_PROCESS_ACTIVITY, "onCreate");
        C12808e.m76822a(this);
        if (C9062b.m57147m()) {
            C11839m.m70688i(NotifyConstants.ActivityName.LOGOUT_PROCESS_ACTIVITY, "sync delete success finish Activity");
            m20947c();
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("quit_account");
        this.f15166e = new C3335b();
        C13108a.m78878b(this).m78880c(this.f15166e, intentFilter);
        Bundle extras = new HiCloudSafeIntent(getIntent()).getExtras();
        if (extras != null) {
            this.f15163b = extras.getBoolean("isMainActivity", false);
        }
        this.f15162a = this;
        if (C9062b.m57146k().m57158l()) {
            C11839m.m70688i(NotifyConstants.ActivityName.LOGOUT_PROCESS_ACTIVITY, "onActivityResult delete local sync data");
            if (C2783d.m16127b0(this.f15162a)) {
                C11839m.m70686d(NotifyConstants.ActivityName.LOGOUT_PROCESS_ACTIVITY, "Show dialog");
                ProgressDialog progressDialog = new ProgressDialog(this);
                this.f15164c = progressDialog;
                progressDialog.setMessage(getString(R$string.exit_account_removing));
                this.f15164c.setCancelable(false);
                this.f15164c.show();
            }
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        C11839m.m70688i(NotifyConstants.ActivityName.LOGOUT_PROCESS_ACTIVITY, "onDestroy");
        super.onDestroy();
        ProgressDialog progressDialog = this.f15164c;
        if (progressDialog != null) {
            progressDialog.dismiss();
            this.f15164c = null;
        }
        if (this.f15166e != null) {
            C13108a.m78878b(this).m78883f(this.f15166e);
            this.f15166e = null;
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        C11839m.m70688i(NotifyConstants.ActivityName.LOGOUT_PROCESS_ACTIVITY, "onPause");
        super.onPause();
        C13227f.m79492i1().m79577X(this);
        UBAAnalyze.m29964Y("PVC", getClass().getCanonicalName(), "1", "24", m20946b());
    }

    @Override // android.app.Activity
    public void onResume() {
        C11839m.m70688i(NotifyConstants.ActivityName.LOGOUT_PROCESS_ACTIVITY, "onResume");
        this.f15165d = System.currentTimeMillis();
        super.onResume();
        C13227f.m79492i1().m79582b0(this);
        UBAAnalyze.m29967a0("PVC", getClass().getCanonicalName(), "1", "24");
    }
}
