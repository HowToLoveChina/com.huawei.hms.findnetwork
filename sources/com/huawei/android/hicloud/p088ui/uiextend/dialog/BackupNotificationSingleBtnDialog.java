package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.huawei.android.hicloud.p088ui.activity.BackupNotificationActivity;
import com.huawei.android.p073ds.R$string;
import p676ud.AlertDialogC13154a;

/* loaded from: classes3.dex */
public class BackupNotificationSingleBtnDialog extends AlertDialogC13154a {
    private Context mContext;

    public class BtnOnClickListner implements DialogInterface.OnClickListener {
        public BtnOnClickListner() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (-1 == i10) {
                BackupNotificationSingleBtnDialog.this.dismiss();
                ((BackupNotificationActivity) BackupNotificationSingleBtnDialog.this.mContext).finish();
            }
        }
    }

    public class DialogOnCancelListener implements DialogInterface.OnCancelListener {
        public DialogOnCancelListener() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            BackupNotificationSingleBtnDialog.this.dismiss();
            ((BackupNotificationActivity) BackupNotificationSingleBtnDialog.this.mContext).finish();
        }
    }

    public BackupNotificationSingleBtnDialog(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    public void initView() {
        setButton(-1, this.mContext.getString(R$string.beta_ok), new BtnOnClickListner());
        setOnCancelListener(new DialogOnCancelListener());
    }

    public void show(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            setTitle(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            setMessage(str2);
        }
        show();
    }
}
