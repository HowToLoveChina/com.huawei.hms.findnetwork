package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.widget.Button;
import com.huawei.android.hicloud.oobe.R$color;
import p514o9.C11839m;
import p676ud.AlertDialogC13154a;

/* loaded from: classes3.dex */
public class JoinSpaceShareDialog extends AlertDialogC13154a {
    private static final String TAG = "JoinSpaceShareDialog";
    private JoinShareCallback mActivity;
    private Context mContext;

    public class BtnOnClickListner implements DialogInterface.OnClickListener {
        public BtnOnClickListner() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (JoinSpaceShareDialog.this.mActivity == null) {
                C11839m.m70687e(JoinSpaceShareDialog.TAG, "mActivity is null");
            } else if (-1 == i10) {
                JoinSpaceShareDialog.this.mActivity.onConfirmed();
            } else if (-2 == i10) {
                JoinSpaceShareDialog.this.mActivity.onCanceled();
            }
        }
    }

    public JoinSpaceShareDialog(Context context, JoinShareCallback joinShareCallback, String str, String str2) {
        super(context);
        this.mActivity = joinShareCallback;
        this.mContext = context;
        BtnOnClickListner btnOnClickListner = new BtnOnClickListner();
        setButton(-1, str, btnOnClickListner);
        setButton(-2, str2, btnOnClickListner);
    }

    public void showDialog(String str, String str2) {
        setMessage(str);
        setTitle(str2);
        show();
        Context context = this.mContext;
        if (context == null) {
            C11839m.m70687e(TAG, "mContext is null");
            return;
        }
        Resources resources = context.getResources();
        Button button = getButton(-1);
        if (button == null || resources == null) {
            return;
        }
        button.setTextColor(resources.getColor(R$color.emui_functional_red));
    }
}
