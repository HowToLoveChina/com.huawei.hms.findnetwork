package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.DialogInterface;
import com.huawei.android.p073ds.R$string;
import p676ud.AlertDialogC13154a;

/* loaded from: classes3.dex */
public class RefurbishUpgradDialog extends AlertDialogC13154a {
    public RefurbishUpgradDialog(Context context) {
        super(context);
        setMessage(context.getString(R$string.cloudbackup_refurbish_dialog_text));
        setButton(-1, context.getString(R$string.cloudbackup_btn_ok_new), new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.RefurbishUpgradDialog.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                RefurbishUpgradDialog.this.dismiss();
            }
        });
    }
}
