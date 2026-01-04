package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.views.RenewAgreementTextview;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import p010a9.C0079a;
import p015ak.C0209d;
import p054cj.C1442a;
import p514o9.C11829c;
import p514o9.C11842p;
import sk.C12809f;

/* loaded from: classes3.dex */
public class ConfirmRenewAgreementDialog extends AlertDialog {
    private static final String TAG = "ConfirmRenewAgreementDialog";
    private C0079a mAgreementDialogNeedData;
    private Context mContext;

    public interface AgreementDlgCallback {
        void refreshCheckboxStatus(boolean z10);

        void reportRenewDlgEvent(String str, LinkedHashMap<String, String> linkedHashMap);

        void startPaymentProcess(C0079a c0079a);
    }

    public ConfirmRenewAgreementDialog(Context context, C0079a c0079a) {
        super(context);
        this.mContext = context;
        this.mAgreementDialogNeedData = c0079a;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        C11829c.m70594l1(this.mContext, this);
        if (C0209d.m1195O(this.mContext) >= 1.75f) {
            setContentView(R$layout.confirm_renew_agreement_dialog_extend);
        } else {
            setContentView(R$layout.confirm_renew_agreement_dialog);
        }
        Window window = getWindow();
        window.setBackgroundDrawableResource(R.color.transparent);
        C11842p.m70816h(window);
        if (this.mContext == null) {
            C1442a.m8289e(TAG, "onCreate, mContext is null.");
            return;
        }
        C0079a c0079a = this.mAgreementDialogNeedData;
        if (c0079a == null) {
            C1442a.m8289e(TAG, "onCreate, mAgreementDialogNeedData is null.");
            return;
        }
        String strM645b = c0079a.m645b();
        if (TextUtils.isEmpty(strM645b)) {
            C1442a.m8289e(TAG, "onCreate, dlgRenewAgreementText is null.");
            return;
        }
        RenewAgreementTextview renewAgreementTextview = (RenewAgreementTextview) C12809f.m76830c(this, R$id.dialog_agreement_text);
        renewAgreementTextview.setShowRuleIcon(false);
        if (this.mContext instanceof Activity) {
            RenewAgreementTextview.RenewAgreementTVCallback renewAgreementTVCallbackM647d = this.mAgreementDialogNeedData.m647d();
            String string = this.mContext.getString(R$string.cloudpay_monthly_renew_agreement);
            String string2 = this.mContext.getString(R$string.cloudpay_user_agreement);
            if (renewAgreementTVCallbackM647d != null) {
                renewAgreementTextview.m25806w(strM645b, string2, string, (Activity) this.mContext, renewAgreementTVCallbackM647d);
            } else {
                renewAgreementTextview.m25807x(strM645b, string2, string, this.mAgreementDialogNeedData.m644a(), (Activity) this.mContext);
            }
        } else {
            C1442a.m8289e(TAG, "onCreate, mContext not instanceof Activity");
        }
        ((ImageView) C12809f.m76830c(this, R$id.agreement_close)).setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.ConfirmRenewAgreementDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C1442a.m8290i(ConfirmRenewAgreementDialog.TAG, "click cancel btn, dismiss");
                if (ConfirmRenewAgreementDialog.this.mAgreementDialogNeedData == null) {
                    C1442a.m8289e(ConfirmRenewAgreementDialog.TAG, "cancelBtn, mAgreementDialogNeedData is null.");
                    return;
                }
                AgreementDlgCallback agreementDlgCallbackM644a = ConfirmRenewAgreementDialog.this.mAgreementDialogNeedData.m644a();
                if (agreementDlgCallbackM644a != null) {
                    agreementDlgCallbackM644a.reportRenewDlgEvent("UNIFORM_CLOUDPAY_CLICK_RENEW_DIALOG_CANCEL_BTN", new LinkedHashMap<>());
                }
                ConfirmRenewAgreementDialog.this.dismiss();
            }
        });
        ((TextView) C12809f.m76830c(this, R$id.agreement_dialog_order_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.ConfirmRenewAgreementDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C1442a.m8290i(ConfirmRenewAgreementDialog.TAG, "click order btn");
                if (ConfirmRenewAgreementDialog.this.mAgreementDialogNeedData == null) {
                    C1442a.m8289e(ConfirmRenewAgreementDialog.TAG, "orderBtn, mAgreementDialogNeedData is null.");
                    return;
                }
                AgreementDlgCallback agreementDlgCallbackM644a = ConfirmRenewAgreementDialog.this.mAgreementDialogNeedData.m644a();
                if (agreementDlgCallbackM644a != null) {
                    agreementDlgCallbackM644a.refreshCheckboxStatus(true);
                    agreementDlgCallbackM644a.reportRenewDlgEvent("UNIFORM_CLOUDPAY_CLICK_RENEW_DIALOG_AGREE_BTN", new LinkedHashMap<>());
                    agreementDlgCallbackM644a.startPaymentProcess(ConfirmRenewAgreementDialog.this.mAgreementDialogNeedData);
                } else {
                    C1442a.m8289e(ConfirmRenewAgreementDialog.TAG, "orderBtn, agreementDlgCallback is null.");
                }
                ConfirmRenewAgreementDialog.this.dismiss();
            }
        });
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        C0079a c0079a = this.mAgreementDialogNeedData;
        if (c0079a == null) {
            C1442a.m8289e(TAG, "show, mAgreementDialogNeedData is null.");
            return;
        }
        AgreementDlgCallback agreementDlgCallbackM644a = c0079a.m644a();
        if (agreementDlgCallbackM644a == null) {
            C1442a.m8289e(TAG, "show, agreementDlgCallback is null.");
        } else {
            agreementDlgCallbackM644a.reportRenewDlgEvent("UNIFORM_CLOUDPAY_CLICK_RENEW_DIALOG_SHOW", new LinkedHashMap<>());
        }
    }
}
