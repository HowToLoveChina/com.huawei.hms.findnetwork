package com.huawei.android.remotecontrol.p093ui;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import com.huawei.android.hicloud.p088ui.activity.HMSTermsProcessBaseActivity;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import p664u0.C13108a;
import p809yg.C13981a;

/* loaded from: classes4.dex */
public abstract class BaseActivity extends HMSTermsProcessBaseActivity {

    /* renamed from: p */
    public AlertDialog f20406p = null;

    /* renamed from: q */
    public HiSyncReceiver f20407q = null;

    public class HiSyncReceiver extends BroadcastReceiver {
        public HiSyncReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                C13981a.m83988e("BaseActivity", "HiSyncReceiver intent is null");
                return;
            }
            HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
            if (hiCloudSafeIntent.getAction() == null) {
                C13981a.m83988e("BaseActivity", "HiSyncReceiver action is null");
            } else if ("com.huawei.android.hicloud.intent.PHONEFINDER_FINDMYPHONELOGOFF_COMPLETED".equals(hiCloudSafeIntent.getAction())) {
                BaseActivity.this.m27037O1(context, hiCloudSafeIntent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O1 */
    public void m27037O1(Context context, Intent intent) {
        C13981a.m83987d("BaseActivity", "onReceiveLogoffSucess received");
        finish();
    }

    /* renamed from: N1 */
    public void m27038N1() {
        if (this.f20407q == null) {
            this.f20407q = new HiSyncReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_FINDMYPHONELOGOFF_COMPLETED");
            C13108a.m78878b(this).m78880c(this.f20407q, intentFilter);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 82) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m27038N1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        C13981a.m83989i("BaseActivity", "destroy activity");
        super.onDestroy();
        AlertDialog alertDialog = this.f20406p;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f20406p = null;
        }
        if (this.f20407q != null) {
            C13108a.m78878b(this).m78883f(this.f20407q);
        }
    }
}
