package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.view.ViewGroup;
import com.huawei.android.p073ds.R$layout;
import java.util.Timer;
import java.util.TimerTask;
import p676ud.AlertDialogC13154a;

/* loaded from: classes3.dex */
public class BackupCleanLoadingDialog extends AlertDialogC13154a {
    public BackupCleanLoadingDialog(Context context) {
        super(context);
        setView(getLayoutInflater().inflate(R$layout.dialog_backup_clean_loading, (ViewGroup) null));
        setCancelable(false);
    }

    public void show(long j10) {
        show();
        new Timer().schedule(new TimerTask() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.BackupCleanLoadingDialog.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                BackupCleanLoadingDialog.this.dismiss();
            }
        }, j10);
    }
}
