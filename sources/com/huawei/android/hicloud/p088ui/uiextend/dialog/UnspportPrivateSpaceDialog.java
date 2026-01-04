package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import com.huawei.android.p073ds.R$string;
import p223db.C9062b;
import p514o9.C11839m;
import p676ud.AlertDialogC13154a;
import p742wj.C13612b;

/* loaded from: classes3.dex */
public class UnspportPrivateSpaceDialog extends AlertDialogC13154a {
    private static final String TAG = "UnspportPrivateSpaceDialog";
    private Activity mAtivity;
    private Context mContext;

    public UnspportPrivateSpaceDialog(Context context, Activity activity) {
        super(context);
        this.mContext = context;
        this.mAtivity = activity;
        initView();
    }

    private void initView() {
        setCancelable(false);
        setMessage(this.mContext.getString(R$string.cloud_unsupport_private_space));
        setButton(-1, this.mContext.getString(R$string.cloudbackup_btn_ok_new), new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.UnspportPrivateSpaceDialog.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                UnspportPrivateSpaceDialog.this.cancel();
                if (C13612b.m81829B().isLogin()) {
                    C11839m.m70688i(UnspportPrivateSpaceDialog.TAG, "Cloud login, now exit!");
                    C9062b.m57146k().m57155h(false, false);
                }
                UnspportPrivateSpaceDialog.this.mAtivity.finish();
            }
        });
    }
}
