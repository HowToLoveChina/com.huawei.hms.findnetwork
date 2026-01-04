package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.DialogInterface;
import com.huawei.android.hicloud.commonlib.view.CommonDialogInterface;
import com.huawei.android.hicloud.oobe.p086ui.activity.OOBERecoveringActivity;
import com.huawei.android.hicloud.p088ui.activity.RestoreMainActivity;
import com.huawei.android.p073ds.R$string;
import p676ud.AlertDialogC13154a;

/* loaded from: classes3.dex */
public class RestoreFailedDialog extends AlertDialogC13154a implements CommonDialogInterface {
    private Context mContext;

    public class BtnOnClickListner implements DialogInterface.OnClickListener {
        public BtnOnClickListner() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (-1 == i10) {
                RestoreFailedDialog.this.dismiss();
                if (RestoreFailedDialog.this.mContext instanceof OOBERecoveringActivity) {
                    ((OOBERecoveringActivity) RestoreFailedDialog.this.mContext).m16694T0();
                } else if (RestoreFailedDialog.this.mContext instanceof RestoreMainActivity) {
                    ((RestoreMainActivity) RestoreFailedDialog.this.mContext).m22060Q2();
                }
            }
        }
    }

    public class DialogOnCancelListener implements DialogInterface.OnCancelListener {
        public DialogOnCancelListener() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            RestoreFailedDialog.this.dismiss();
            if (RestoreFailedDialog.this.mContext instanceof OOBERecoveringActivity) {
                ((OOBERecoveringActivity) RestoreFailedDialog.this.mContext).m16694T0();
            } else if (RestoreFailedDialog.this.mContext instanceof RestoreMainActivity) {
                ((RestoreMainActivity) RestoreFailedDialog.this.mContext).m22060Q2();
            }
        }
    }

    public RestoreFailedDialog(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    private void initView() {
        setButton(-1, this.mContext.getString(R$string.cloudbackup_btn_ok_new), new BtnOnClickListner());
        setOnCancelListener(new DialogOnCancelListener());
        setMessage(this.mContext.getString(R$string.restore_failed_tip));
    }

    @Override // com.huawei.android.hicloud.commonlib.view.CommonDialogInterface
    public void customShow() {
    }

    @Override // com.huawei.android.hicloud.commonlib.view.CommonDialogInterface
    public void setIsOOBE(boolean z10) {
    }
}
