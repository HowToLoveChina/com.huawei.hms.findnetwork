package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.DialogInterface;
import com.huawei.android.hicloud.p088ui.activity.BackupCleanRecordsDetailActivity;
import com.huawei.android.p073ds.R$string;
import p676ud.AlertDialogC13154a;

/* loaded from: classes3.dex */
public class BackupCleanRecordConfirmDialog extends AlertDialogC13154a {
    private Context mContext;

    public class ButtonClickListener implements DialogInterface.OnClickListener {
        public ButtonClickListener() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (i10 == -1 && (BackupCleanRecordConfirmDialog.this.mContext instanceof BackupCleanRecordsDetailActivity)) {
                ((BackupCleanRecordsDetailActivity) BackupCleanRecordConfirmDialog.this.mContext).m18614c2();
            }
            BackupCleanRecordConfirmDialog.this.dismiss();
        }
    }

    public BackupCleanRecordConfirmDialog(Context context) {
        super(context);
        this.mContext = context;
        setTitle(context.getString(R$string.backup_record_delete));
        setMessage(context.getString(R$string.backup_clean_record_confirm_msg));
        ButtonClickListener buttonClickListener = new ButtonClickListener();
        setButton(-1, context.getString(R$string.cloudbackup_btn_delete), buttonClickListener);
        setButton(-2, context.getString(R$string.cloudbackup_btn_cancel), buttonClickListener);
    }
}
