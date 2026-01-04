package com.huawei.android.hicloud.p088ui.activity;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.report.p107bi.HiAnalyticsBaselActivity;
import java.lang.reflect.InvocationTargetException;
import p514o9.C11829c;
import p514o9.C11839m;
import p664u0.C13108a;
import sk.C12808e;

/* loaded from: classes3.dex */
public class DataMigrateDialogActivity extends HiAnalyticsBaselActivity {

    /* renamed from: b */
    public AlertDialog f14671b;

    /* renamed from: c */
    public BroadcastReceiver f14672c;

    /* renamed from: com.huawei.android.hicloud.ui.activity.DataMigrateDialogActivity$a */
    public class DialogInterfaceOnCancelListenerC3260a implements DialogInterface.OnCancelListener {
        public DialogInterfaceOnCancelListenerC3260a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            dialogInterface.dismiss();
            DataMigrateDialogActivity.this.finish();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.DataMigrateDialogActivity$b */
    public class DialogInterfaceOnClickListenerC3261b implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener {
        public DialogInterfaceOnClickListenerC3261b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            dialogInterface.dismiss();
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (i10 != -1) {
                C11839m.m70688i("DataMigrateDialogActivity", "click cancel");
                dialogInterface.dismiss();
                DataMigrateDialogActivity.this.finish();
            } else {
                Intent intent = new Intent();
                intent.setClass(DataMigrateDialogActivity.this, DataMigrationAuthActivity.class);
                DataMigrateDialogActivity.this.startActivity(intent);
                DataMigrateDialogActivity.this.finish();
            }
        }

        public /* synthetic */ DialogInterfaceOnClickListenerC3261b(DataMigrateDialogActivity dataMigrateDialogActivity, DialogInterfaceOnCancelListenerC3260a dialogInterfaceOnCancelListenerC3260a) {
            this();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.DataMigrateDialogActivity$c */
    public class C3262c extends BroadcastReceiver {
        public C3262c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            C11839m.m70688i("DataMigrateDialogActivity", "receive broadcast, finish.");
            DataMigrateDialogActivity.this.finish();
        }

        public /* synthetic */ C3262c(DataMigrateDialogActivity dataMigrateDialogActivity, DialogInterfaceOnCancelListenerC3260a dialogInterfaceOnCancelListenerC3260a) {
            this();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
    }

    @Override // com.huawei.hicloud.report.p107bi.HiAnalyticsBaselActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        C12808e.m76822a(this);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.f14671b = alertDialogCreate;
        C11829c.m70594l1(this, alertDialogCreate);
        this.f14671b.setTitle(getString(R$string.migrate_terms_title2));
        this.f14671b.setMessage(getString(R$string.migrate_terms_2_dialog));
        DialogInterfaceOnCancelListenerC3260a dialogInterfaceOnCancelListenerC3260a = null;
        this.f14671b.setButton(-1, getString(R$string.gallery_main_shelve_setup), new DialogInterfaceOnClickListenerC3261b(this, dialogInterfaceOnCancelListenerC3260a));
        this.f14671b.setButton(-2, getString(R$string.not_process_now), new DialogInterfaceOnClickListenerC3261b(this, dialogInterfaceOnCancelListenerC3260a));
        this.f14671b.setOnCancelListener(new DialogInterfaceOnCancelListenerC3260a());
        this.f14671b.show();
        IntentFilter intentFilter = new IntentFilter("com.huawei.hicloud.MIGRATION_POLICY_HANDLED");
        this.f14672c = new C3262c(this, dialogInterfaceOnCancelListenerC3260a);
        C13108a.m78878b(this).m78880c(this.f14672c, intentFilter);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        AlertDialog alertDialog = this.f14671b;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f14671b = null;
        }
        if (this.f14672c != null) {
            C13108a.m78878b(this).m78883f(this.f14672c);
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
    }
}
