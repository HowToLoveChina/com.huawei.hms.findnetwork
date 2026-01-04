package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import p514o9.C11839m;
import p676ud.AlertDialogC13154a;

/* loaded from: classes3.dex */
public class InviteMemberErrorTipDialog extends AlertDialogC13154a {
    private static final String TAG = "InviteMemberErrorTipDialog";
    private Context mContext;
    private DialogInterface.OnClickListener mListener;

    public InviteMemberErrorTipDialog(Context context, DialogInterface.OnClickListener onClickListener) {
        super(context);
        this.mContext = context;
        this.mListener = onClickListener;
        initView();
    }

    private void initView() {
        Context context = this.mContext;
        if (context == null) {
            C11839m.m70687e(TAG, "init view fail, mcontext is null");
            dismiss();
        } else {
            setView(LayoutInflater.from(context).inflate(R$layout.invite_family_error_dialog, (ViewGroup) null));
            setButton(-1, this.mContext.getString(R$string.invite_family_member_error_dialog_button), this.mListener);
        }
    }
}
