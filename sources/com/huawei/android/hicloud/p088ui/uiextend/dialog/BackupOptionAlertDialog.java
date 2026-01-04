package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.DialogInterface;
import com.huawei.android.p073ds.R$string;
import p676ud.AlertDialogC13154a;

/* loaded from: classes3.dex */
public class BackupOptionAlertDialog extends AlertDialogC13154a {
    public BackupOptionAlertDialog(Context context) {
        super(context);
        setTitle(R$string.cloudbackup_alert);
        setButton(-1, context.getString(R$string.cloudbackup_btn_ok_new), new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f19208a.lambda$new$0(dialogInterface, i10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(DialogInterface dialogInterface, int i10) {
        dismiss();
    }
}
