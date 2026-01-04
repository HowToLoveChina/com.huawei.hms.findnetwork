package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.DialogInterface;
import com.huawei.android.p073ds.R$string;
import p676ud.AlertDialogC13154a;

/* loaded from: classes3.dex */
public class BackupDetailOtherDialog extends AlertDialogC13154a {

    public class BtnOnClickListner implements DialogInterface.OnClickListener {
        public BtnOnClickListner() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            BackupDetailOtherDialog.this.dismiss();
        }
    }

    public BackupDetailOtherDialog(Context context) {
        super(context);
        setButton(-1, context.getString(R$string.beta_ok), new BtnOnClickListner());
    }

    public void show(String str, String str2) {
        setTitle(str);
        setMessage(str2);
        show();
    }
}
