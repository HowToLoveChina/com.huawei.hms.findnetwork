package com.huawei.android.hicloud.p088ui.uiextend.cloudpay.dialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import p054cj.C1442a;
import p676ud.AlertDialogC13154a;

/* loaded from: classes3.dex */
public class CancelAutoRenewalSuccessDialog extends AlertDialogC13154a {
    private static final String TAG = "CancelAutoRenewalSuccessDialog";
    private Activity mActivity;
    private View successDialogView;

    public class ClickListner implements DialogInterface.OnClickListener {
        public ClickListner() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (CancelAutoRenewalSuccessDialog.this.mActivity == null) {
                C1442a.m8289e(CancelAutoRenewalSuccessDialog.TAG, "onClick mActivity is null.");
            } else if (i10 == -2) {
                CancelAutoRenewalSuccessDialog.this.dismiss();
                CancelAutoRenewalSuccessDialog.this.mActivity.setResult(-1);
                CancelAutoRenewalSuccessDialog.this.mActivity.finish();
            }
        }
    }

    public CancelAutoRenewalSuccessDialog(Activity activity) {
        super(activity);
        if (activity == null) {
            C1442a.m8290i(TAG, "activity is null, not show");
            return;
        }
        this.mActivity = activity;
        ClickListner clickListner = new ClickListner();
        this.successDialogView = LayoutInflater.from(activity).inflate(R$layout.cancel_auto_renewal_success_dialog_layout, (ViewGroup) null);
        setTitle(R$string.cloudpay_cancel_continuous_monthly_success_tips1);
        setView(this.successDialogView);
        setButton(-2, activity.getString(R$string.cloudpay_huaweipay_sure), clickListner);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        Activity activity = this.mActivity;
        if (activity != null) {
            activity.setResult(-1);
            this.mActivity.finish();
        }
    }
}
