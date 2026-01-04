package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.DialogInterface;
import com.huawei.android.hicloud.p088ui.activity.OOBECloudBackupRecordsActivity;
import com.huawei.android.p073ds.R$string;
import p676ud.AlertDialogC13154a;

/* loaded from: classes3.dex */
public class NotSupportSecondUserDialog extends AlertDialogC13154a {
    private static final String TAG = "NotSupportSecondUserDialog";
    private Context mContext;
    private BtnOnClickListner onClicklistner;

    public class BtnOnClickListner implements DialogInterface.OnClickListener {
        public BtnOnClickListner() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            NotSupportSecondUserDialog.this.dismiss();
            ((OOBECloudBackupRecordsActivity) NotSupportSecondUserDialog.this.mContext).finish();
        }
    }

    public class DialogOnCancelListener implements DialogInterface.OnCancelListener {
        public DialogOnCancelListener() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            NotSupportSecondUserDialog.this.dismiss();
            ((OOBECloudBackupRecordsActivity) NotSupportSecondUserDialog.this.mContext).finish();
        }
    }

    public NotSupportSecondUserDialog(Context context) {
        super(context);
        this.onClicklistner = new BtnOnClickListner();
        this.mContext = context;
        initView();
    }

    private void initView() {
        setTitle(R$string.alert);
        setMessage(this.mContext.getString(R$string.only_owner_tips));
        setButton(-1, this.mContext.getString(R$string.cloudbackup_restart_msgtip), this.onClicklistner);
        setOnCancelListener(new DialogOnCancelListener());
    }
}
