package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.DialogInterface;
import com.huawei.android.p073ds.R$string;
import p676ud.AlertDialogC13154a;

/* loaded from: classes3.dex */
public class BackupChangeRecordNumDialog extends AlertDialogC13154a {
    public BackupChangeRecordNumDialog(Context context, DialogInterface.OnClickListener onClickListener) {
        super(context);
        setButton(-1, context.getResources().getString(R$string.gallery_shelve_confirm), onClickListener);
        setButton(-2, context.getResources().getString(R$string.cloudbackup_btn_cancel), onClickListener);
        setMessage(context.getResources().getString(R$string.backup_record_page_change_dialog_title_new));
        setCanceledOnTouchOutside(false);
    }
}
