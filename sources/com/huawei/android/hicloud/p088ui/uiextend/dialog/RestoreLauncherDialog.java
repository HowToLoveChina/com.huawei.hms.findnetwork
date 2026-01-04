package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.DialogInterface;
import com.huawei.android.hicloud.commonlib.view.CommonDialogInterface;
import com.huawei.android.hicloud.oobe.p086ui.activity.OOBERecoveringActivity;
import com.huawei.android.p073ds.R$string;
import p676ud.AlertDialogC13154a;

/* loaded from: classes3.dex */
public class RestoreLauncherDialog extends AlertDialogC13154a implements CommonDialogInterface {
    private boolean isNewRestore;
    private Context mContext;
    private BtnOnClickListner onClicklistner;

    public class BtnOnClickListner implements DialogInterface.OnClickListener {
        public BtnOnClickListner() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (!RestoreLauncherDialog.this.isNewRestore) {
                ((OOBERecoveringActivity) RestoreLauncherDialog.this.mContext).m16696V0();
            }
            RestoreLauncherDialog.this.dismiss();
        }
    }

    public class DialogOnCancelListener implements DialogInterface.OnCancelListener {
        public DialogOnCancelListener() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            RestoreLauncherDialog.this.dismiss();
        }
    }

    public RestoreLauncherDialog(Context context) {
        super(context);
        this.isNewRestore = false;
        this.onClicklistner = new BtnOnClickListner();
        this.mContext = context;
        initView();
    }

    private void initView() {
        setTitle(this.mContext.getString(R$string.restore_hwlauncher_tip_title));
        setMessage(this.mContext.getString(R$string.restore_hwlauncher_tip_content));
        setButton(-1, this.mContext.getString(R$string.cloudbackup_btn_ok_new), this.onClicklistner);
        setOnCancelListener(new DialogOnCancelListener());
    }

    @Override // com.huawei.android.hicloud.commonlib.view.CommonDialogInterface
    public void customShow() {
    }

    @Override // com.huawei.android.hicloud.commonlib.view.CommonDialogInterface
    public void setIsOOBE(boolean z10) {
    }

    public RestoreLauncherDialog(Context context, boolean z10) {
        super(context);
        this.isNewRestore = false;
        this.onClicklistner = new BtnOnClickListner();
        this.mContext = context;
        this.isNewRestore = z10;
        initView();
    }
}
