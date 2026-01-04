package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.p073ds.R$string;
import p015ak.C0209d;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11840n;
import p676ud.AlertDialogC13154a;

/* loaded from: classes3.dex */
public class BackupRecoveryWlanDialog extends AlertDialogC13154a {
    private static final String TAG = "BackupRecoveryWlanDialog";
    private boolean isOOBE;
    private Context mContext;
    private WlanBtnOnClickListner wlanOnClicklistner;

    public class DialogOnCancelListener implements DialogInterface.OnCancelListener {
        public DialogOnCancelListener() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            BackupRecoveryWlanDialog.this.dismiss();
        }
    }

    public class WlanBtnOnClickListner implements DialogInterface.OnClickListener {
        public WlanBtnOnClickListner() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (-1 == i10) {
                if (BackupRecoveryWlanDialog.this.isOOBE) {
                    BackupRecoveryWlanDialog.this.intentToWifiSetupActivity();
                } else {
                    C2783d.m16149i1(BackupRecoveryWlanDialog.this.mContext);
                }
            }
            BackupRecoveryWlanDialog.this.dismiss();
        }
    }

    public BackupRecoveryWlanDialog(Context context) {
        super(context);
        this.isOOBE = false;
        this.wlanOnClicklistner = new WlanBtnOnClickListner();
        this.mContext = context;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void intentToWifiSetupActivity() {
        Intent intent = new Intent("com.android.net.wifi.SETUP_WIFI_NETWORK");
        C0209d.m1302r2(intent, "com.android.settings");
        intent.putExtra("extra_prefs_show_button_bar", true);
        intent.putExtra("extra_show_fake_status_bar", true);
        intent.putExtra("firstRun", true);
        try {
            this.mContext.startActivity(intent);
        } catch (Exception unused) {
            C11839m.m70687e(TAG, "startActivity WIFI Activity failed");
        }
    }

    public void customShow() {
        if (this.isOOBE) {
            C11829c.m70585i1(getWindow());
            C11840n.m70694e(this);
        }
        show();
    }

    public void initView() {
        setMessage(this.mContext.getString(C2783d.m16179s1(R$string.recovery_need_wlan_20160910, R$string.recovery_need_wifi_20160910)));
        setButton(-1, this.mContext.getString(R$string.set_wlan), this.wlanOnClicklistner);
        setButton(-2, this.mContext.getString(R$string.cloudbackup_btn_cancel), this.wlanOnClicklistner);
        setOnCancelListener(new DialogOnCancelListener());
    }

    public void setIsOOBE(boolean z10) {
        this.isOOBE = z10;
    }
}
