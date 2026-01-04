package com.huawei.android.hicloud.oobe.p086ui.uiextend.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.huawei.android.hicloud.oobe.R$string;
import p015ak.C0209d;
import p422k9.C11019b;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11840n;

/* loaded from: classes3.dex */
public class OOBEBackupRecoveryWlanDialog extends AlertDialog {

    /* renamed from: a */
    public Context f12710a;

    /* renamed from: b */
    public boolean f12711b;

    /* renamed from: c */
    public DialogInterfaceOnClickListenerC2871b f12712c;

    /* renamed from: com.huawei.android.hicloud.oobe.ui.uiextend.dialog.OOBEBackupRecoveryWlanDialog$a */
    public class DialogInterfaceOnCancelListenerC2870a implements DialogInterface.OnCancelListener {
        public DialogInterfaceOnCancelListenerC2870a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            OOBEBackupRecoveryWlanDialog.this.dismiss();
        }
    }

    /* renamed from: com.huawei.android.hicloud.oobe.ui.uiextend.dialog.OOBEBackupRecoveryWlanDialog$b */
    public class DialogInterfaceOnClickListenerC2871b implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2871b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (-1 == i10) {
                if (OOBEBackupRecoveryWlanDialog.this.f12711b) {
                    OOBEBackupRecoveryWlanDialog.this.m17070f();
                } else {
                    C11019b.m66371t().m66451w0(OOBEBackupRecoveryWlanDialog.this.f12710a);
                }
            }
            OOBEBackupRecoveryWlanDialog.this.dismiss();
        }
    }

    public OOBEBackupRecoveryWlanDialog(Context context) {
        super(context);
        this.f12711b = false;
        this.f12712c = new DialogInterfaceOnClickListenerC2871b();
        this.f12710a = context;
        m17069e();
    }

    /* renamed from: d */
    public void m17068d() {
        if (this.f12711b) {
            C11829c.m70585i1(getWindow());
            C11840n.m70694e(this);
        }
        show();
    }

    /* renamed from: e */
    public final void m17069e() {
        setMessage(this.f12710a.getString(C0209d.m1167E2(R$string.recovery_need_wlan_20160910, R$string.recovery_need_wifi_20160910)));
        setButton(-1, this.f12710a.getString(R$string.set_wlan), this.f12712c);
        setButton(-2, this.f12710a.getString(R$string.cloudbackup_btn_cancel), this.f12712c);
        setOnCancelListener(new DialogInterfaceOnCancelListenerC2870a());
    }

    /* renamed from: f */
    public final void m17070f() {
        Intent intent = new Intent("com.android.net.wifi.SETUP_WIFI_NETWORK");
        C0209d.m1302r2(intent, "com.android.settings");
        intent.putExtra("extra_prefs_show_button_bar", true);
        intent.putExtra("firstRun", true);
        intent.putExtra("extra_show_fake_status_bar", true);
        try {
            this.f12710a.startActivity(intent);
        } catch (Exception unused) {
            C11839m.m70687e("BackupRecoveryWlanDialog", "startActivity WIFI Activity failed");
        }
    }

    /* renamed from: g */
    public void m17071g(boolean z10) {
        this.f12711b = z10;
    }
}
