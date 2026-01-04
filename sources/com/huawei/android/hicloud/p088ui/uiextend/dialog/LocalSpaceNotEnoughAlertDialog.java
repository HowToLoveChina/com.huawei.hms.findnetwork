package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import com.huawei.android.p073ds.R$string;
import p676ud.AlertDialogC13154a;

/* loaded from: classes3.dex */
public class LocalSpaceNotEnoughAlertDialog extends AlertDialogC13154a {
    private Context mContext;

    public class BtnOnClickListner implements DialogInterface.OnClickListener {
        public BtnOnClickListner() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            LocalSpaceNotEnoughAlertDialog.this.dismiss();
        }
    }

    public LocalSpaceNotEnoughAlertDialog(Context context) {
        super(context);
        this.mContext = context;
        setButton(-1, this.mContext.getString(R$string.backup_no_space_local_dialog_tip_button), new BtnOnClickListner());
        setTitle(this.mContext.getString(R$string.backup_no_space_local_dialog_tip_title));
        setMessage(this.mContext.getString(R$string.backup_no_space_local_dialog_tip_content));
    }

    private void setHeight() {
        Context context = this.mContext;
        if (context == null || context.getResources() == null) {
            return;
        }
        Window window = getWindow();
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        if (window == null || displayMetrics == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        int height = window.getDecorView().getHeight();
        int i10 = displayMetrics.heightPixels;
        if (height >= ((int) (i10 * 0.8d))) {
            attributes.height = (int) (i10 * 0.8d);
            int height2 = window.getDecorView().getHeight();
            int i11 = displayMetrics.heightPixels;
            if (height2 >= ((int) (i11 * 0.7d))) {
                attributes.height = (int) (i11 * 0.7d);
            } else {
                attributes.height = -2;
            }
            window.setAttributes(attributes);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        setHeight();
    }
}
