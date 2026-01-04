package com.huawei.android.hicloud.p088ui.uiextend.cloudpay.dialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.Welfare;
import com.huawei.cloud.pay.model.WelfareContent;
import com.huawei.cloud.pay.model.WelfarePickAndCancelRenewalInterface;
import p054cj.C1442a;
import p618rm.C12540b1;
import p676ud.AlertDialogC13154a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class WelfarePickSuccessDialog extends AlertDialogC13154a {
    private static final String TAG = "WelfarePickSuccessDialog";
    private WelfarePickAndCancelRenewalInterface callback;
    private boolean isFromIAP;
    private Activity mActivity;
    private View successDialogView;
    private Welfare welfare;

    public class ClickListner implements DialogInterface.OnClickListener {
        public ClickListner() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (WelfarePickSuccessDialog.this.isFromIAP && WelfarePickSuccessDialog.this.callback != null) {
                C1442a.m8290i(WelfarePickSuccessDialog.TAG, "onClick, retentionSuccessIAP");
                WelfarePickSuccessDialog.this.callback.retentionSuccessIAP();
            } else if (WelfarePickSuccessDialog.this.mActivity == null) {
                C1442a.m8289e(WelfarePickSuccessDialog.TAG, "onClick mActivity is null.");
            } else if (i10 == -2) {
                WelfarePickSuccessDialog.this.dismiss();
            }
        }
    }

    public WelfarePickSuccessDialog(Activity activity, Welfare welfare, boolean z10, WelfarePickAndCancelRenewalInterface welfarePickAndCancelRenewalInterface) {
        super(activity);
        if (activity == null) {
            C1442a.m8290i(TAG, "activity is null, not show");
            return;
        }
        this.mActivity = activity;
        ClickListner clickListner = new ClickListner();
        View viewInflate = LayoutInflater.from(activity).inflate(R$layout.welfare_pick_success_dialog_layout, (ViewGroup) null);
        this.successDialogView = viewInflate;
        TextView textView = (TextView) C12809f.m76831d(viewInflate, R$id.welfare_day_tip);
        Resources resources = activity.getResources();
        int duration = getContent(welfare).getDuration();
        if (resources == null) {
            return;
        }
        textView.setText(resources.getQuantityString(R$plurals.welfare_pick_success_info, duration, Integer.valueOf(duration)));
        setTitle(R$string.welfare_pick_success_title);
        setView(this.successDialogView);
        setButton(-2, activity.getString(R$string.cloudpay_huaweipay_sure), clickListner);
        this.isFromIAP = z10;
        this.callback = welfarePickAndCancelRenewalInterface;
    }

    private WelfareContent getContent(Welfare welfare) {
        return (WelfareContent) C12540b1.m75483a(welfare.getContent(), WelfareContent.class);
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
