package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.DialogInterface;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import p676ud.AlertDialogC13154a;

/* loaded from: classes3.dex */
public class BackupUpGradeRecordDialog extends AlertDialogC13154a {
    public BackupUpGradeRecordDialog(Context context, DialogInterface.OnClickListener onClickListener) {
        super(context);
        setButton(-1, context.getResources().getString(R$string.upgrade_member), onClickListener);
        setButton(-2, context.getResources().getString(R$string.cloudbackup_btn_cancel), onClickListener);
        setMessage(context.getResources().getQuantityString(R$plurals.backup_record_page_upgrade_dialog_title, 3, 3));
        setCanceledOnTouchOutside(false);
    }
}
