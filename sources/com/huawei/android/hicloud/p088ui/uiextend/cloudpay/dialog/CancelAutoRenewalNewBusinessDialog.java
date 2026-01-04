package com.huawei.android.hicloud.p088ui.uiextend.cloudpay.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.CloudSpace;
import com.huawei.cloud.pay.model.TerminationRetentionData;
import com.huawei.cloud.pay.model.WelfarePickAndCancelRenewalInterface;
import java.util.Iterator;
import p015ak.C0226l0;
import p015ak.C0241z;
import p054cj.C1442a;
import p336he.C10155f;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p676ud.AlertDialogC13154a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class CancelAutoRenewalNewBusinessDialog extends AlertDialogC13154a {
    private static final String CANCENL_RENEW_NEW_DIALOG_BUTTON_NEGATIVE = "cancel_renew_new_dialog_keep_cancel";
    private static final String CANCENL_RENEW_NEW_DIALOG_BUTTON_POSITIVE = "cancel_renew_new_dialog_not_cancel";
    private static final String CANCENL_RENEW_NEW_DIALOG_PRESS_BACK = "cancel_renew_new_dialog_press_back";
    private static final int DEFAULT_DAY = 60;
    private static final String EVENT_SHOW_DIALOG = "show_cancel_renewal_new_business_dialog";
    private static final String TAG = "CancelAutoRenewalNewBusinessDialog";
    private TextView contentTips;
    private final Context context;
    private boolean isAppendEventId;
    private LinearLayout linearLayoutDefaultTips;
    private final WelfarePickAndCancelRenewalInterface mCancelAutoRenewalInterface;
    private TerminationRetentionData terminationRetentionData;

    /* renamed from: com.huawei.android.hicloud.ui.uiextend.cloudpay.dialog.CancelAutoRenewalNewBusinessDialog$1 */
    public class C41561 extends AbstractC12367d {
        public C41561() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$call$0(String str) {
            CancelAutoRenewalNewBusinessDialog.this.contentTips.setText(str);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                int iM1686d = C0241z.m1686d(C10155f.m63283g("bs.userdata.overdue.days"), 60);
                final String string = CancelAutoRenewalNewBusinessDialog.this.context.getString(R$string.cancel_auto_renewal_new_business_content_tips_update, CancelAutoRenewalNewBusinessDialog.this.context.getResources().getQuantityString(R$plurals.common_days, iM1686d, Integer.valueOf(iM1686d)));
                C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.ui.uiextend.cloudpay.dialog.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f19197a.lambda$call$0(string);
                    }
                });
            } catch (NumberFormatException e10) {
                C1442a.m8289e(CancelAutoRenewalNewBusinessDialog.TAG, "getDataRetentionTime failed, " + e10.getMessage());
            }
        }
    }

    public class ClickListener implements DialogInterface.OnClickListener {
        public ClickListener() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (CancelAutoRenewalNewBusinessDialog.this.terminationRetentionData == null) {
                C1442a.m8291w(CancelAutoRenewalNewBusinessDialog.TAG, "onClick, terminationRetentionData is null.");
                CancelAutoRenewalNewBusinessDialog.this.dismiss();
                return;
            }
            if (CancelAutoRenewalNewBusinessDialog.this.mCancelAutoRenewalInterface == null) {
                C1442a.m8291w(CancelAutoRenewalNewBusinessDialog.TAG, "onClick, mCancelAutoRenewalInterface is null.");
                CancelAutoRenewalNewBusinessDialog.this.dismiss();
                return;
            }
            if (i10 == -1) {
                if (CancelAutoRenewalNewBusinessDialog.this.terminationRetentionData.isFromIAP()) {
                    CancelAutoRenewalNewBusinessDialog.this.mCancelAutoRenewalInterface.retentionSuccessIAP();
                }
                WelfarePickAndCancelRenewalInterface welfarePickAndCancelRenewalInterface = CancelAutoRenewalNewBusinessDialog.this.mCancelAutoRenewalInterface;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(CancelAutoRenewalNewBusinessDialog.CANCENL_RENEW_NEW_DIALOG_BUTTON_POSITIVE);
                sb2.append(CancelAutoRenewalNewBusinessDialog.this.isAppendEventId ? "_default" : "");
                welfarePickAndCancelRenewalInterface.reportWelfare(sb2.toString());
            } else if (i10 == -2) {
                C1442a.m8290i(CancelAutoRenewalNewBusinessDialog.TAG, "onClick, switch close, check password.");
                CancelAutoRenewalNewBusinessDialog.this.mCancelAutoRenewalInterface.checkConfirmCancelPassword();
                WelfarePickAndCancelRenewalInterface welfarePickAndCancelRenewalInterface2 = CancelAutoRenewalNewBusinessDialog.this.mCancelAutoRenewalInterface;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(CancelAutoRenewalNewBusinessDialog.CANCENL_RENEW_NEW_DIALOG_BUTTON_NEGATIVE);
                sb3.append(CancelAutoRenewalNewBusinessDialog.this.isAppendEventId ? "_default" : "");
                welfarePickAndCancelRenewalInterface2.reportWelfare(sb3.toString());
            }
            CancelAutoRenewalNewBusinessDialog.this.dismiss();
        }
    }

    public CancelAutoRenewalNewBusinessDialog(Context context, WelfarePickAndCancelRenewalInterface welfarePickAndCancelRenewalInterface, TerminationRetentionData terminationRetentionData) {
        super(context);
        this.isAppendEventId = false;
        this.context = context;
        this.mCancelAutoRenewalInterface = welfarePickAndCancelRenewalInterface;
        this.terminationRetentionData = terminationRetentionData;
        initView(context);
    }

    private void initContentTips() {
        Iterator<CloudSpace> it = this.terminationRetentionData.getUserPackage().getEffectivePackages().iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (it.next().getIsAutoPay() == 1) {
                i10++;
            }
        }
        if (i10 > 1) {
            this.contentTips.setVisibility(8);
            this.linearLayoutDefaultTips.setVisibility(0);
            this.isAppendEventId = true;
        } else {
            this.isAppendEventId = false;
            this.contentTips.setVisibility(0);
            this.linearLayoutDefaultTips.setVisibility(8);
            C12515a.m75110o().m75172d(new C41561());
        }
    }

    private void initView(Context context) {
        if (context == null) {
            C1442a.m8291w(TAG, "context is null, initView Failed");
            return;
        }
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.cancel_auto_renewal_new_business_dialog_layout, (ViewGroup) null);
        this.linearLayoutDefaultTips = (LinearLayout) C12809f.m76831d(viewInflate, R$id.ll_default_tips);
        this.contentTips = (TextView) C12809f.m76831d(viewInflate, R$id.content_tips);
        initContentTips();
        ClickListener clickListener = new ClickListener();
        setTitle(R$string.cloudpay_cancel_continuous_monthly_new);
        setView(viewInflate);
        setButton(-1, context.getString(R$string.cloudpay_exit_cancel_continuous_monthly_second), clickListener);
        setButton(-2, context.getString(R$string.cloudpay_conform_cancel_continuous_monthly_new), clickListener);
        setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.huawei.android.hicloud.ui.uiextend.cloudpay.dialog.a
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                return this.f19196a.lambda$initView$0(dialogInterface, i10, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initView$0(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        if (i10 != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        if (this.terminationRetentionData == null) {
            C1442a.m8291w(TAG, "initView, terminationRetentionData is null.");
            dismiss();
            return false;
        }
        WelfarePickAndCancelRenewalInterface welfarePickAndCancelRenewalInterface = this.mCancelAutoRenewalInterface;
        if (welfarePickAndCancelRenewalInterface == null) {
            C1442a.m8291w(TAG, "initView, mCancelAutoRenewalInterface is null.");
            dismiss();
            return false;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(CANCENL_RENEW_NEW_DIALOG_PRESS_BACK);
        sb2.append(this.isAppendEventId ? "_default" : "");
        welfarePickAndCancelRenewalInterface.backPressEvent(sb2.toString());
        if (!this.terminationRetentionData.isFromIAP()) {
            dismiss();
        }
        return true;
    }

    @Override // android.app.Dialog
    public void show() {
        WelfarePickAndCancelRenewalInterface welfarePickAndCancelRenewalInterface = this.mCancelAutoRenewalInterface;
        if (welfarePickAndCancelRenewalInterface != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(EVENT_SHOW_DIALOG);
            sb2.append(this.isAppendEventId ? "_default" : "");
            welfarePickAndCancelRenewalInterface.reportWelfare(sb2.toString());
        }
        super.show();
    }
}
