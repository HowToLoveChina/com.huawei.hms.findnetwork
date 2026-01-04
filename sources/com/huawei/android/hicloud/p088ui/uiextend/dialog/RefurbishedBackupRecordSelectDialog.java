package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.hicloud.cloudbackup.model.CloudRecoveryItem;
import p676ud.AlertDialogC13154a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class RefurbishedBackupRecordSelectDialog extends AlertDialogC13154a implements View.OnClickListener {
    private TextView cancel;
    private TextView goRestoreBtn;
    private long mLastClickTime;
    private CloudRecoveryItem recoveryItem;
    private SelectDialogClickCallback selectDialogClickCallback;

    public interface SelectDialogClickCallback {
        void onGoToRestore(CloudRecoveryItem cloudRecoveryItem);
    }

    public RefurbishedBackupRecordSelectDialog(Context context, SelectDialogClickCallback selectDialogClickCallback) {
        super(context);
        this.selectDialogClickCallback = selectDialogClickCallback;
        initView(context);
    }

    private void initView(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.refurbished_backup_record_select_dialog_layout, (ViewGroup) null);
        this.goRestoreBtn = (TextView) C12809f.m76831d(viewInflate, R$id.restore_entrance);
        TextView textView = (TextView) C12809f.m76831d(viewInflate, R$id.cancel);
        this.cancel = textView;
        textView.setOnClickListener(this);
        this.goRestoreBtn.setOnClickListener(this);
        setCanceledOnTouchOutside(false);
        setView(viewInflate);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.mLastClickTime < 600) {
            return;
        }
        this.mLastClickTime = jCurrentTimeMillis;
        int id2 = view.getId();
        if (id2 != R$id.restore_entrance) {
            if (id2 == R$id.cancel) {
                dismiss();
            }
        } else {
            SelectDialogClickCallback selectDialogClickCallback = this.selectDialogClickCallback;
            if (selectDialogClickCallback != null) {
                selectDialogClickCallback.onGoToRestore(this.recoveryItem);
            }
        }
    }

    public void setRecoveryItem(CloudRecoveryItem cloudRecoveryItem) {
        this.recoveryItem = cloudRecoveryItem;
    }
}
