package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import com.huawei.android.hicloud.p088ui.activity.BackupMainActivity;
import com.huawei.android.hicloud.p088ui.activity.CloudRestoreOptionsActivity;
import com.huawei.android.hicloud.p088ui.activity.MainActivity;
import com.huawei.android.p073ds.R$string;
import p676ud.AlertDialogC13154a;

/* loaded from: classes3.dex */
public class ConfirmJumpRefurbishDialog extends AlertDialogC13154a {
    private Activity mActivity;

    public class BtnOnClickListener implements DialogInterface.OnClickListener {
        public BtnOnClickListener() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (ConfirmJumpRefurbishDialog.this.mActivity == null) {
                return;
            }
            if (-1 == i10) {
                if (ConfirmJumpRefurbishDialog.this.mActivity instanceof BackupMainActivity) {
                    ((BackupMainActivity) ConfirmJumpRefurbishDialog.this.mActivity).m18726F5();
                } else if (ConfirmJumpRefurbishDialog.this.mActivity instanceof MainActivity) {
                    ((MainActivity) ConfirmJumpRefurbishDialog.this.mActivity).m21179H7();
                } else if (ConfirmJumpRefurbishDialog.this.mActivity instanceof CloudRestoreOptionsActivity) {
                    ((CloudRestoreOptionsActivity) ConfirmJumpRefurbishDialog.this.mActivity).m19870C3();
                }
            } else if (ConfirmJumpRefurbishDialog.this.mActivity instanceof BackupMainActivity) {
                ((BackupMainActivity) ConfirmJumpRefurbishDialog.this.mActivity).m18735I4();
            } else if (ConfirmJumpRefurbishDialog.this.mActivity instanceof MainActivity) {
                ((MainActivity) ConfirmJumpRefurbishDialog.this.mActivity).m21123B4();
            } else if (ConfirmJumpRefurbishDialog.this.mActivity instanceof CloudRestoreOptionsActivity) {
                ((CloudRestoreOptionsActivity) ConfirmJumpRefurbishDialog.this.mActivity).m19884M2();
            }
            dialogInterface.dismiss();
        }
    }

    public ConfirmJumpRefurbishDialog(Context context, Activity activity) {
        super(context);
        this.mActivity = activity;
        BtnOnClickListener btnOnClickListener = new BtnOnClickListener();
        setButton(-1, context.getString(R$string.cloudbackup_jump_refurbish), btnOnClickListener);
        setButton(-2, context.getString(R$string.cloudbackup_Cancel), btnOnClickListener);
        setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.h0
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                return this.f19219a.lambda$new$0(dialogInterface, i10, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$0(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        if (i10 != 4) {
            return false;
        }
        Activity activity = this.mActivity;
        if (activity instanceof BackupMainActivity) {
            ((BackupMainActivity) activity).m18735I4();
        } else if (activity instanceof MainActivity) {
            ((MainActivity) activity).m21123B4();
        } else if (activity instanceof CloudRestoreOptionsActivity) {
            ((CloudRestoreOptionsActivity) activity).m19884M2();
        }
        dialogInterface.dismiss();
        return false;
    }

    public void show(String str) {
        setMessage(str);
        show();
    }
}
