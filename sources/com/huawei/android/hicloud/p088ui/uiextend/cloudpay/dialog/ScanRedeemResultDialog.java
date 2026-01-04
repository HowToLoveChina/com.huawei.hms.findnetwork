package com.huawei.android.hicloud.p088ui.uiextend.cloudpay.dialog;

import android.content.Context;
import android.content.DialogInterface;
import com.huawei.android.p073ds.R$string;
import p054cj.C1442a;
import p676ud.AlertDialogC13154a;

/* loaded from: classes3.dex */
public class ScanRedeemResultDialog extends AlertDialogC13154a {
    private static final String TAG = "ScanRedeemResultDialog";
    private Context mContext;

    public ScanRedeemResultDialog(Context context) {
        super(context);
        this.mContext = context;
    }

    public void show(int i10) {
        Context context = this.mContext;
        if (context == null) {
            C1442a.m8291w(TAG, "show mContext is null.");
            return;
        }
        setButton(-2, context.getString(R$string.cloudpay_payment_result_dialog_agree), (DialogInterface.OnClickListener) null);
        String string = this.mContext.getString(R$string.cloudpay_small_problem_tips, Integer.valueOf(i10));
        if (string != null && !string.isEmpty()) {
            setMessage(string);
        }
        show();
    }
}
