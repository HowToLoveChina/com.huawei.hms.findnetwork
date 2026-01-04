package com.huawei.android.hicloud.p088ui.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.RiskConfirmDialog;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.lang.reflect.InvocationTargetException;
import p015ak.C0234s;
import p514o9.C11839m;
import p684un.C13223b;
import sk.C12808e;

/* loaded from: classes3.dex */
public class SyncRiskNotificationActivity extends Activity {

    /* renamed from: a */
    public RiskConfirmDialog f16150a;

    /* renamed from: b */
    public String f16151b = "";

    /* renamed from: c */
    public String f16152c = "";

    /* renamed from: com.huawei.android.hicloud.ui.activity.SyncRiskNotificationActivity$b */
    public class DialogInterfaceOnClickListenerC3505b implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3505b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            C11839m.m70688i("SyncRiskNotificationActivity", "clicked");
            dialogInterface.cancel();
            C13223b.m79473a(SyncRiskNotificationActivity.this, "risk_click_desktop", "1");
            UBAAnalyze.m29954O("PVC", "risk_click_desktop", "1", "38");
            SyncRiskNotificationActivity.this.startActivity(new Intent(SyncRiskNotificationActivity.this, (Class<?>) MainActivity.class));
            SyncRiskNotificationActivity.this.finish();
        }
    }

    /* renamed from: a */
    public final void m22353a() {
        if (this.f16150a == null) {
            this.f16150a = new RiskConfirmDialog(this);
        }
        this.f16150a.show(this.f16151b, this.f16152c, getString(R$string.risk_sync_handle), "", new DialogInterfaceOnClickListenerC3505b());
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        C0234s.m1639q(this);
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Intent intent;
        C11839m.m70688i("SyncRiskNotificationActivity", "onCreate");
        super.onCreate(bundle);
        C12808e.m76822a(this);
        try {
            intent = getIntent();
        } catch (Exception unused) {
            C11839m.m70687e("SyncRiskNotificationActivity", "getIntent error");
        }
        if (intent == null) {
            return;
        }
        this.f16151b = intent.getStringExtra("risk_notify_title_key");
        this.f16152c = intent.getStringExtra("risk_notify_ctt_key");
        m22353a();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        RiskConfirmDialog riskConfirmDialog = this.f16150a;
        if (riskConfirmDialog != null) {
            riskConfirmDialog.cancel();
        }
    }
}
