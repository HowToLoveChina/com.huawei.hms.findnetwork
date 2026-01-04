package com.huawei.android.hicloud.p088ui.activity;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.huawei.hicloud.sync.R$string;
import p514o9.C11829c;
import p514o9.C11839m;
import p664u0.C13108a;

/* loaded from: classes3.dex */
public class SiteChangeDialogActivity extends UIActivity {

    /* renamed from: p */
    public AlertDialog f15990p;

    /* renamed from: q */
    public BroadcastReceiver f15991q;

    /* renamed from: com.huawei.android.hicloud.ui.activity.SiteChangeDialogActivity$a */
    public class DialogInterfaceOnCancelListenerC3470a implements DialogInterface.OnCancelListener {
        public DialogInterfaceOnCancelListenerC3470a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            dialogInterface.dismiss();
            SiteChangeDialogActivity.this.finish();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.SiteChangeDialogActivity$b */
    public class DialogInterfaceOnClickListenerC3471b implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener {
        public DialogInterfaceOnClickListenerC3471b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            dialogInterface.dismiss();
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (i10 != -1) {
                C11839m.m70688i("SiteChangeDialogActivity", "click cancel");
                dialogInterface.dismiss();
                SiteChangeDialogActivity.this.finish();
            } else {
                Intent intent = new Intent();
                intent.setClass(SiteChangeDialogActivity.this, SiteChangeTipActivity.class);
                SiteChangeDialogActivity.this.startActivity(intent);
                SiteChangeDialogActivity.this.finish();
            }
        }

        public /* synthetic */ DialogInterfaceOnClickListenerC3471b(SiteChangeDialogActivity siteChangeDialogActivity, DialogInterfaceOnCancelListenerC3470a dialogInterfaceOnCancelListenerC3470a) {
            this();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.SiteChangeDialogActivity$c */
    public class C3472c extends BroadcastReceiver {
        public C3472c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            C11839m.m70688i("SiteChangeDialogActivity", "receive broadcast, finish.");
            SiteChangeDialogActivity.this.finish();
        }

        public /* synthetic */ C3472c(SiteChangeDialogActivity siteChangeDialogActivity, DialogInterfaceOnCancelListenerC3470a dialogInterfaceOnCancelListenerC3470a) {
            this();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: D1 */
    public void mo20612D1() {
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException {
        super.onCreate(bundle);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.f15990p = alertDialogCreate;
        C11829c.m70594l1(this, alertDialogCreate);
        this.f15990p.setTitle(getString(R$string.hicloud_service_location_change_1));
        this.f15990p.setMessage(getString(R$string.hicloud_service_location_change_2));
        DialogInterfaceOnCancelListenerC3470a dialogInterfaceOnCancelListenerC3470a = null;
        this.f15990p.setButton(-1, getString(R$string.hicloud_service_location_change_4), new DialogInterfaceOnClickListenerC3471b(this, dialogInterfaceOnCancelListenerC3470a));
        this.f15990p.setButton(-2, getString(R$string.hicloud_service_location_change_3), new DialogInterfaceOnClickListenerC3471b(this, dialogInterfaceOnCancelListenerC3470a));
        this.f15990p.setOnCancelListener(new DialogInterfaceOnCancelListenerC3470a());
        this.f15990p.show();
        IntentFilter intentFilter = new IntentFilter("com.huawei.hicloud.CLOSE_DIALOG_ACTION");
        this.f15991q = new C3472c(this, dialogInterfaceOnCancelListenerC3470a);
        C13108a.m78878b(this).m78880c(this.f15991q, intentFilter);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        AlertDialog alertDialog = this.f15990p;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f15990p = null;
        }
        if (this.f15991q != null) {
            C13108a.m78878b(this).m78883f(this.f15991q);
        }
    }
}
