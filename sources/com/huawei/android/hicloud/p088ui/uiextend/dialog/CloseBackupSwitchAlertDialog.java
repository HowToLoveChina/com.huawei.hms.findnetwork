package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.DialogInterface;
import com.huawei.android.p073ds.R$string;
import p676ud.AlertDialogC13154a;

/* loaded from: classes3.dex */
public class CloseBackupSwitchAlertDialog extends AlertDialogC13154a {
    private DialogCallBack mCallBack;
    private Context mContext;

    public interface DialogCallBack {
        void cancel();

        void confirm();
    }

    public CloseBackupSwitchAlertDialog(Context context, DialogCallBack dialogCallBack) {
        super(context);
        this.mCallBack = dialogCallBack;
        this.mContext = context;
        setButton(-1, context.getString(R$string.btn_close_backup), new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.t
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f19251a.lambda$new$0(dialogInterface, i10);
            }
        });
        setButton(-2, this.mContext.getString(R$string.cloudbackup_btn_cancel), new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.u
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f19253a.lambda$new$1(dialogInterface, i10);
            }
        });
        setCanceledOnTouchOutside(false);
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.v
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.f19255a.lambda$new$2(dialogInterface);
            }
        });
        setTitle(this.mContext.getString(R$string.data_security_tips));
        setMessage(this.mContext.getString(R$string.cloudbackup_close_later_tips));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(DialogInterface dialogInterface, int i10) {
        this.mCallBack.confirm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(DialogInterface dialogInterface, int i10) {
        this.mCallBack.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(DialogInterface dialogInterface) {
        this.mCallBack.cancel();
    }
}
