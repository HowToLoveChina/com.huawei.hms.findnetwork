package com.huawei.hicloud.account.p102ui.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import com.huawei.hicloud.account.R$string;
import com.huawei.secure.android.common.intent.SafeIntent;
import p015ak.C0234s;
import p399jk.AbstractC10896a;
import p664u0.C13108a;
import p742wj.C13612b;
import p812yj.AlertDialogC13993b;
import p812yj.InterfaceC13992a;

/* loaded from: classes5.dex */
public class StInvalidNotificationActivity extends Activity implements InterfaceC13992a {

    /* renamed from: a */
    public AlertDialogC13993b f22087a;

    /* renamed from: b */
    public AlertDialogC13993b f22088b;

    /* renamed from: c */
    public C4850b f22089c;

    /* renamed from: com.huawei.hicloud.account.ui.activity.StInvalidNotificationActivity$b */
    public class C4850b extends BroadcastReceiver {
        public C4850b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || !"com.huawei.hicloud.ST_FIXED".equals(new SafeIntent(intent).getAction())) {
                return;
            }
            AbstractC10896a.m65887i("StInvalidNotificationActivity", "Receive STORAGE_ST_FIXED_ACTION");
            StInvalidNotificationActivity.this.finish();
        }
    }

    @Override // p812yj.InterfaceC13992a
    /* renamed from: a */
    public void mo29091a(int i10) {
        AbstractC10896a.m65887i("StInvalidNotificationActivity", "onClickPositive, dialogId = " + i10);
        try {
            startActivity(C13612b.m81829B().m81846I());
        } catch (Exception e10) {
            AbstractC10896a.m65886e("StInvalidNotificationActivity", "onClickPositive exception:" + e10.toString());
        }
        finish();
    }

    /* renamed from: b */
    public final void m29092b() {
        try {
            AlertDialogC13993b alertDialogC13993b = this.f22088b;
            if (alertDialogC13993b != null) {
                alertDialogC13993b.dismiss();
                this.f22088b = null;
            }
        } catch (Exception unused) {
            AbstractC10896a.m65886e("StInvalidNotificationActivity", "Dialog dismiss exception");
        }
    }

    /* renamed from: c */
    public final void m29093c() {
        try {
            AlertDialogC13993b alertDialogC13993b = this.f22087a;
            if (alertDialogC13993b != null) {
                alertDialogC13993b.dismiss();
                this.f22087a = null;
            }
        } catch (Exception unused) {
            AbstractC10896a.m65886e("StInvalidNotificationActivity", "Dialog dismiss exception");
        }
    }

    /* renamed from: d */
    public final void m29094d() {
        if (getIntent() == null) {
            AbstractC10896a.m65886e("StInvalidNotificationActivity", "intent is null");
            finish();
        } else {
            try {
                this.f22087a.m84031c(getString(R$string.st_tips_dialog_title), getString(R$string.st_tips_dialog_content_st_invalid, getString(R$string.HiCloud_app_name)), getString(R$string.st_tips_relogin), getString(R$string.sync_data_merge_btn_confirm));
            } catch (Exception unused) {
                AbstractC10896a.m65886e("StInvalidNotificationActivity", "initView exception");
                finish();
            }
        }
    }

    @Override // p812yj.InterfaceC13992a
    public void onClickNegative(int i10) {
        AbstractC10896a.m65887i("StInvalidNotificationActivity", "onClickNegative, dialogId = " + i10);
        if (i10 == 1) {
            AlertDialogC13993b alertDialogC13993b = new AlertDialogC13993b(this, this, 2);
            this.f22088b = alertDialogC13993b;
            alertDialogC13993b.m84031c(getString(R$string.st_tips_dialog_cancel_title), getString(R$string.st_tips_dialog_cancel_confirm_content, getString(R$string.HiCloud_app_name)), getString(R$string.st_tips_dialog_cancel_positive), getString(R$string.st_tips_dialog_cancel_negative));
        } else if (i10 == 2) {
            m29093c();
            finish();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        C0234s.m1639q(this);
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f22087a = new AlertDialogC13993b(this, this, 1);
        m29094d();
        this.f22089c = new C4850b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.hicloud.ST_FIXED");
        C13108a.m78878b(this).m78880c(this.f22089c, intentFilter);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        m29093c();
        m29092b();
        C13612b.m81829B().m81885s0(false);
        if (this.f22089c != null) {
            AbstractC10896a.m65885d("StInvalidNotificationActivity", "onDestroy unregisterReceiver");
            C13108a.m78878b(this).m78883f(this.f22089c);
            this.f22089c = null;
        }
        AlertDialogC13993b alertDialogC13993b = this.f22087a;
        if (alertDialogC13993b != null) {
            alertDialogC13993b.dismiss();
            this.f22087a = null;
        }
    }
}
