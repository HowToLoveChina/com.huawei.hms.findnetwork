package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.DialogInterface;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.commonlib.view.CommonDialogInterface;
import com.huawei.android.hicloud.oobe.p086ui.activity.OOBERecoveringActivity;
import com.huawei.android.hicloud.p088ui.activity.RestoreMainActivity;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$string;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11840n;
import p676ud.AlertDialogC13154a;

/* loaded from: classes3.dex */
public class StopRecoveryDialog extends AlertDialogC13154a implements CommonDialogInterface {
    private static final String TAG = "StopRecoveryDialog";
    private boolean isNewRestore;
    private boolean isOOBE;
    private Context mContext;
    private BtnOnClickListner onClicklistner;

    public class BtnOnClickListner implements DialogInterface.OnClickListener {
        public BtnOnClickListner() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            StopRecoveryDialog.this.dismiss();
            if (!CBAccess.inRestore()) {
                C11839m.m70688i(StopRecoveryDialog.TAG, "is not inRestore");
            } else if (-1 == i10) {
                if (StopRecoveryDialog.this.isNewRestore) {
                    ((RestoreMainActivity) StopRecoveryDialog.this.mContext).m22050B3();
                } else {
                    ((OOBERecoveringActivity) StopRecoveryDialog.this.mContext).m16698Z0();
                }
            }
        }
    }

    public class DialogOnCancelListener implements DialogInterface.OnCancelListener {
        public DialogOnCancelListener() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            StopRecoveryDialog.this.dismiss();
        }
    }

    public StopRecoveryDialog(Context context) {
        super(context);
        this.isOOBE = false;
        this.isNewRestore = false;
        this.onClicklistner = new BtnOnClickListner();
        this.mContext = context;
        initView();
    }

    @Override // com.huawei.android.hicloud.commonlib.view.CommonDialogInterface
    public void customShow() {
        if (this.isOOBE) {
            C11829c.m70585i1(getWindow());
            C11829c.m70572e0(this);
            C11840n.m70694e(this);
        }
        show();
        getButton(-1).setTextColor(this.mContext.getResources().getColor(R$color.emui_functional_red));
    }

    public void initView() {
        setMessage(this.mContext.getString(R$string.restore_new_if_cancel_restore));
        setButton(-1, this.mContext.getString(R$string.restore_new_cancel), this.onClicklistner);
        setButton(-2, this.mContext.getString(R$string.restore_new_not_cancel), this.onClicklistner);
        setOnCancelListener(new DialogOnCancelListener());
    }

    @Override // com.huawei.android.hicloud.commonlib.view.CommonDialogInterface
    public void setIsOOBE(boolean z10) {
        this.isOOBE = z10;
    }

    public StopRecoveryDialog(Context context, boolean z10) {
        super(context);
        this.isOOBE = false;
        this.isNewRestore = false;
        this.onClicklistner = new BtnOnClickListner();
        this.mContext = context;
        this.isNewRestore = z10;
        initView();
    }
}
