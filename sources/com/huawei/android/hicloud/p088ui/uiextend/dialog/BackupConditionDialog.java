package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import p676ud.AlertDialogC13154a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class BackupConditionDialog extends AlertDialogC13154a {
    private TextView backupCoditionTip;
    private Context context;

    public class BtnOnClickListner implements DialogInterface.OnClickListener {
        public BtnOnClickListner() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (-2 == i10) {
                BackupConditionDialog.this.dismiss();
            }
        }
    }

    public BackupConditionDialog(Context context) {
        super(context);
        this.context = context;
        setButton(-2, context.getString(R$string.backup_guide_tips_button), new BtnOnClickListner());
        initView();
    }

    private void initView() {
        View viewInflate = LayoutInflater.from(this.context).inflate(R$layout.backup_condition_dialog, (ViewGroup) null);
        this.backupCoditionTip = (TextView) C12809f.m76831d(viewInflate, R$id.tv_backup_condition);
        setView(viewInflate);
    }

    public void setBackupCoditionTip(String str) {
        this.backupCoditionTip.setText(str);
    }
}
