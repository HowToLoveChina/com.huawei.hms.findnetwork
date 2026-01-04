package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.PayActivityInfo;
import p514o9.C11829c;
import p514o9.C11839m;
import sk.C12809f;

/* loaded from: classes3.dex */
public class HicloudPushGuideDialog {
    private static final String TAG = "HicloudPushGuideDialog";
    private PushGuideDialogCallback mActivity;
    private AlertDialog mAlertDialog;
    private Context mContext;
    private PayActivityInfo mPayActivityInfo;

    public class BtnOnClickListner implements DialogInterface.OnClickListener {
        public BtnOnClickListner() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (-1 == i10) {
                HicloudPushGuideDialog.this.mActivity.onPositiveClick(HicloudPushGuideDialog.this.mPayActivityInfo);
            } else if (-2 == i10) {
                HicloudPushGuideDialog.this.mActivity.onNegativeClick();
            }
        }
    }

    public static class DialogOnCancelListener implements DialogInterface.OnCancelListener {
        private DialogOnCancelListener() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            C11839m.m70686d(HicloudPushGuideDialog.TAG, "pushGuideDialog cancel");
        }
    }

    public static class DialogOnDismissListener implements DialogInterface.OnDismissListener {
        private DialogOnDismissListener() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            C11839m.m70686d(HicloudPushGuideDialog.TAG, "pushGuideDialog dismiss");
        }
    }

    private View getContentView(String str, String str2, String str3) {
        View viewInflate = LayoutInflater.from(this.mContext).inflate(R$layout.dialog_hicloud_push_guide, (ViewGroup) null);
        TextView textView = (TextView) C12809f.m76831d(viewInflate, R$id.push_guide_title);
        TextView textView2 = (TextView) C12809f.m76831d(viewInflate, R$id.push_guide_main_text);
        TextView textView3 = (TextView) C12809f.m76831d(viewInflate, R$id.push_guide_packagedesc);
        textView.setText(str);
        textView2.setText(str2);
        if (TextUtils.isEmpty(str3)) {
            textView3.setVisibility(8);
        }
        textView3.setText(str3);
        return viewInflate;
    }

    public void dismissAndDestroy() {
        AlertDialog alertDialog = this.mAlertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.mAlertDialog = null;
        }
    }

    public Dialog prepareDialog(Context context, PushGuideDialogCallback pushGuideDialogCallback, String str, String str2, String str3) {
        this.mContext = context;
        this.mActivity = pushGuideDialogCallback;
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(getContentView(str, str2, str3));
        builder.setOnCancelListener(new DialogOnCancelListener());
        builder.setCancelable(false);
        builder.setOnDismissListener(new DialogOnDismissListener());
        this.mAlertDialog = builder.create();
        BtnOnClickListner btnOnClickListner = new BtnOnClickListner();
        this.mAlertDialog.setButton(-1, context.getString(R$string.user_permission_ok), btnOnClickListner);
        this.mAlertDialog.setButton(-2, context.getString(R$string.update_later_new), btnOnClickListner);
        C11829c.m70594l1(this.mContext, this.mAlertDialog);
        return this.mAlertDialog;
    }

    public void setPayActivityInfo(PayActivityInfo payActivityInfo) {
        this.mPayActivityInfo = payActivityInfo;
    }
}
