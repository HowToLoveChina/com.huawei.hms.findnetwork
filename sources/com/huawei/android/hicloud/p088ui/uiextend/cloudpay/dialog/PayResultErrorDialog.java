package com.huawei.android.hicloud.p088ui.uiextend.cloudpay.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.view.ViewGroup;
import com.huawei.android.hicloud.p088ui.activity.OperationWebViewActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.p098ui.activity.BasePayActivity;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.util.LinkedHashMap;
import p054cj.C1442a;
import p676ud.AlertDialogC13154a;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;

/* loaded from: classes3.dex */
public class PayResultErrorDialog extends AlertDialogC13154a {
    private static final String TAG = "PayResultErrorDialog";
    private boolean isAopPay;
    private boolean isIAP4;
    private Context mContext;
    private BtnOnClickListener mOnClickListener;
    private RefreshBtnOnClickListener mRefreshOnClickListener;

    /* renamed from: com.huawei.android.hicloud.ui.uiextend.cloudpay.dialog.PayResultErrorDialog$1 */
    public class DialogInterfaceOnClickListenerC41571 implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC41571() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (PayResultErrorDialog.this.mContext instanceof BasePayActivity) {
                ((BasePayActivity) PayResultErrorDialog.this.mContext).mo22881v1();
            }
            PayResultErrorDialog.this.dismiss();
        }
    }

    public class BtnOnClickListener implements DialogInterface.OnClickListener {
        public BtnOnClickListener() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (PayResultErrorDialog.this.mContext == null) {
                return;
            }
            if (-1 == i10) {
                if (PayResultErrorDialog.this.mContext instanceof BasePayActivity) {
                    ((BasePayActivity) PayResultErrorDialog.this.mContext).mo22821b1();
                }
            } else if (PayResultErrorDialog.this.isAopPay) {
                C1442a.m8290i(PayResultErrorDialog.TAG, "BtnOnClickListener is Aop cancel");
                if (PayResultErrorDialog.this.mContext instanceof BuyPackageBaseActivity) {
                    ((BuyPackageBaseActivity) PayResultErrorDialog.this.mContext).m22863q2();
                } else if (PayResultErrorDialog.this.mContext instanceof OperationWebViewActivity) {
                    ((OperationWebViewActivity) PayResultErrorDialog.this.mContext).m21823N2();
                }
            }
            PayResultErrorDialog.this.dismiss();
        }
    }

    public class DialogOnCancelListener implements DialogInterface.OnCancelListener {
        public DialogOnCancelListener() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (PayResultErrorDialog.this.isAopPay) {
                C1442a.m8290i(PayResultErrorDialog.TAG, "DialogOnCancelListener is Aop");
                if (PayResultErrorDialog.this.mContext instanceof BuyPackageBaseActivity) {
                    ((BuyPackageBaseActivity) PayResultErrorDialog.this.mContext).m22863q2();
                } else if (PayResultErrorDialog.this.mContext instanceof OperationWebViewActivity) {
                    ((OperationWebViewActivity) PayResultErrorDialog.this.mContext).m21823N2();
                }
            }
            PayResultErrorDialog.this.dismiss();
        }
    }

    public class RefreshBtnOnClickListener implements DialogInterface.OnClickListener {
        public RefreshBtnOnClickListener() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (PayResultErrorDialog.this.mContext == null) {
                return;
            }
            if (PayResultErrorDialog.this.isAopPay) {
                ((BuyPackageBaseActivity) PayResultErrorDialog.this.mContext).m22863q2();
            } else if (PayResultErrorDialog.this.mContext instanceof BasePayActivity) {
                ((BasePayActivity) PayResultErrorDialog.this.mContext).mo22881v1();
            }
            PayResultErrorDialog.this.dismiss();
        }
    }

    public class RepeatPurchaseOnClickListener implements DialogInterface.OnClickListener {
        private String receiverAccount;

        public RepeatPurchaseOnClickListener(String str) {
            this.receiverAccount = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (PayResultErrorDialog.this.mContext == null) {
                C1442a.m8291w(PayResultErrorDialog.TAG, "RepeatPurchaseOnClickListener mContext is null");
                return;
            }
            if (PayResultErrorDialog.this.mContext instanceof BuyPackageBaseActivity) {
                BuyPackageBaseActivity buyPackageBaseActivity = (BuyPackageBaseActivity) PayResultErrorDialog.this.mContext;
                if (-1 == i10) {
                    buyPackageBaseActivity.m22853n4("positive");
                    if (PayResultErrorDialog.this.isIAP4) {
                        buyPackageBaseActivity.m22873t2();
                    } else {
                        buyPackageBaseActivity.m22877u2(this.receiverAccount);
                    }
                } else {
                    buyPackageBaseActivity.m22853n4("negative");
                    buyPackageBaseActivity.mo22881v1();
                }
            }
            PayResultErrorDialog.this.dismiss();
        }
    }

    public PayResultErrorDialog(Context context, boolean z10) {
        super(context);
        this.mOnClickListener = new BtnOnClickListener();
        this.isIAP4 = false;
        this.mRefreshOnClickListener = new RefreshBtnOnClickListener();
        this.mContext = context;
        this.isAopPay = z10;
        initView();
    }

    private void initView() {
        setOnCancelListener(new DialogOnCancelListener());
    }

    private void show(String str, String str2, boolean z10) {
        show(str, str2, z10, false);
    }

    private void showErrorCodeExternal(int i10) {
        if (i10 == 5) {
            show(this.mContext.getString(R$string.cloudpay_payment_result_dialog_title), this.mContext.getString(R$string.cloudpay_payment_result_dialog_text_1), false);
            return;
        }
        if (i10 == 27) {
            show(null, this.mContext.getString(R$string.over_buy_current_package_time_limit), false);
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            C13227f.m79492i1().m79567R("UNIFORM_CLOUDPAY_PACKAGE_TIME_LIMIT_DIALOG_SHOW", linkedHashMapM79497A);
            UBAAnalyze.m29958S("PVC", "UNIFORM_CLOUDPAY_PACKAGE_TIME_LIMIT_DIALOG_SHOW", "1", "31", linkedHashMapM79497A);
            return;
        }
        if (i10 == 56) {
            show(null, this.mContext.getString(R$string.cloudpay_order_refunding_dialog), false);
            return;
        }
        if (i10 == 108) {
            show(null, this.mContext.getString(R$string.cloudpay_owner_buy_less_package), false);
            return;
        }
        if (i10 == 120) {
            show(null, this.mContext.getString(R$string.cloudpay_free_package_conflict), false, true);
            return;
        }
        if (i10 == 707) {
            show(null, this.mContext.getString(R$string.CS_area_not_support_service), false);
            return;
        }
        if (i10 == 114) {
            showPresentFailRefund();
        } else if (i10 != 115) {
            show(this.mContext.getString(R$string.cloudpay_pay_net_error_title), this.mContext.getString(R$string.cloudpay_pay_connection_and_try_again), false);
        } else {
            showPresentDelay();
        }
    }

    private void showOrderConfirmtDialog(int i10) {
        Context context = this.mContext;
        if (context == null) {
            C1442a.m8291w(TAG, "showOrderConfirmtDialog mContext is null");
            return;
        }
        setTitle(context.getString(R$string.cloudpay_payment_result_dialog_title));
        setView(getLayoutInflater().inflate(R$layout.cloud_pay_order_confirm_dialog_context, (ViewGroup) null));
        if (i10 != 4) {
            setButton(-2, this.mContext.getString(R$string.cloudpay_payment_result_dialog_agree), this.mOnClickListener);
        } else {
            setButton(-2, this.mContext.getString(R$string.cloudpay_payment_result_dialog_agree), this.mRefreshOnClickListener);
        }
        show();
    }

    private void showPresentDelay() {
        Context context = this.mContext;
        if (context == null) {
            C1442a.m8291w(TAG, "showRepeatPurchaseDialog mContext is null");
            return;
        }
        if (context instanceof BuyPackageBaseActivity) {
            ((BuyPackageBaseActivity) context).m22763F4();
        }
        show(null, this.mContext.getString(R$string.cloudpay_present_fail_presenting_desc), false);
    }

    private void showPresentFailRefund() {
        Context context = this.mContext;
        if (context == null) {
            C1442a.m8291w(TAG, "showRepeatPurchaseDialog mContext is null");
            return;
        }
        if (context instanceof BuyPackageBaseActivity) {
            ((BuyPackageBaseActivity) context).m22767G4();
        }
        show(this.mContext.getString(R$string.cloudpay_present_fail_title), this.mContext.getString(R$string.cloudpay_present_fail_refund_desc), false);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.isAopPay) {
            C1442a.m8290i(TAG, "onBackPressed is Aop");
            Context context = this.mContext;
            if (context instanceof BuyPackageBaseActivity) {
                ((BuyPackageBaseActivity) context).m22863q2();
            } else if (context instanceof OperationWebViewActivity) {
                ((OperationWebViewActivity) context).m21823N2();
            }
        }
    }

    public void showDegradeFailDialog(int i10) {
        Context context = this.mContext;
        if (context == null) {
            C1442a.m8291w(TAG, "showDegradeFailDialog mContext is null.");
        } else {
            show(null, context.getString(R$string.cloudpay_small_problem_tips, Integer.valueOf(i10)), false);
        }
    }

    public void showRepeatPurchaseDialog(String str) {
        showRepeatPurchaseDialog(str, false);
    }

    private void show(String str, String str2, boolean z10, boolean z11) {
        Context context = this.mContext;
        if (context == null) {
            C1442a.m8291w(TAG, "show mContext is null.");
            return;
        }
        if (z10) {
            setButton(-1, context.getString(R$string.cloudpay_pay_retry), this.mOnClickListener);
            setButton(-2, this.mContext.getString(R$string.package_info_dialog_cancel), this.mOnClickListener);
        } else if (z11) {
            setButton(-2, context.getString(R$string.cloudpay_payment_result_dialog_agree), new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.cloudpay.dialog.PayResultErrorDialog.1
                public DialogInterfaceOnClickListenerC41571() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i10) {
                    if (PayResultErrorDialog.this.mContext instanceof BasePayActivity) {
                        ((BasePayActivity) PayResultErrorDialog.this.mContext).mo22881v1();
                    }
                    PayResultErrorDialog.this.dismiss();
                }
            });
        } else {
            setButton(-2, context.getString(R$string.cloudpay_payment_result_dialog_agree), this.mOnClickListener);
        }
        if (str != null && !str.isEmpty()) {
            setTitle(str);
        }
        if (str2 != null && !str2.isEmpty()) {
            setMessage(str2);
        }
        show();
    }

    public void showRepeatPurchaseDialog(String str, boolean z10) {
        this.isIAP4 = z10;
        Context context = this.mContext;
        if (context == null) {
            C1442a.m8291w(TAG, "showRepeatPurchaseDialog mContext is null");
            return;
        }
        if (context instanceof BuyPackageBaseActivity) {
            ((BuyPackageBaseActivity) context).m22772I4();
        }
        setMessage(this.mContext.getString(R$string.continue_buy_dialog_title));
        setButton(-1, this.mContext.getString(R$string.continue_buy_dialog_agree), new RepeatPurchaseOnClickListener(str));
        setButton(-2, this.mContext.getString(R$string.package_info_dialog_cancel), new RepeatPurchaseOnClickListener(str));
        show();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:112:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void show(int r6) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.p088ui.uiextend.cloudpay.dialog.PayResultErrorDialog.show(int):void");
    }
}
