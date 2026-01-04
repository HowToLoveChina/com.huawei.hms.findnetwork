package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.DialogInterface;
import com.huawei.android.hicloud.p088ui.activity.CloudBackupOldDevicesCleanActivity;
import com.huawei.android.p073ds.R$string;
import p676ud.AlertDialogC13154a;

/* loaded from: classes3.dex */
public class OpenAutomaticCleanDialog extends AlertDialogC13154a {
    private static final String TAG = "OpenAutomaticCleanDialog";
    private Context mContext;
    private CloudBackupOldDevicesCleanActivity mMainActivity;

    public class BtnOnClickListner implements DialogInterface.OnClickListener {
        public BtnOnClickListner() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (-1 == i10) {
                OpenAutomaticCleanDialog.this.mMainActivity.m19343M2(true);
                OpenAutomaticCleanDialog.this.dismiss();
            } else if (-2 == i10) {
                OpenAutomaticCleanDialog.this.mMainActivity.m19354u2();
                OpenAutomaticCleanDialog.this.dismiss();
            }
        }
    }

    public class DialogOnCancelListener implements DialogInterface.OnCancelListener {
        public DialogOnCancelListener() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            OpenAutomaticCleanDialog.this.dismiss();
        }
    }

    public OpenAutomaticCleanDialog(Context context, CloudBackupOldDevicesCleanActivity cloudBackupOldDevicesCleanActivity) {
        super(context);
        this.mMainActivity = cloudBackupOldDevicesCleanActivity;
        this.mContext = context;
        BtnOnClickListner btnOnClickListner = new BtnOnClickListner();
        setButton(-1, context.getString(R$string.cloudbackup_delete_dialog_open), btnOnClickListner);
        setButton(-2, context.getString(R$string.cloudbackup_Cancel), btnOnClickListner);
        setOnCancelListener(new DialogOnCancelListener());
        setMessage(this.mContext.getResources().getString(R$string.cloudbackup_delete_dialog_auto_clean));
    }
}
