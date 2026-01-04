package com.huawei.android.hicloud.p088ui.uiextend.cloudpay.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.CloudSpace;
import com.huawei.cloud.pay.model.UserPackage;
import com.huawei.cloud.pay.model.WelfarePickAndCancelRenewalInterface;
import java.util.List;
import ne.C11667a;
import p015ak.C0223k;
import p054cj.C1442a;
import p676ud.AlertDialogC13154a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class CancelSubscriptionDlg extends AlertDialogC13154a {
    private static final String CANCEL_RENEW_NEW_DIALOG_PRESS_BACK = "cancel_renew_new_dialog_press_back";
    private static final long DEFAULT_USE_SPACE = 5368709120L;
    private static final String OLD_BUSINESS_DEFAULT_SPACE = "5";
    private static final long ONE_DAY_MILLION = 86400000;
    private static final String TAG = "CancelSubscriptionDlg";
    private final CloudSpace cloudSpace;
    private TextView contentTips;
    private final Context context;
    private LinearLayout defaultTips;
    private boolean hasNotCloudPackage;
    private ImageView imgDot;
    private boolean initSuccess;
    private boolean isAppendEventId;
    private final boolean isNewBm;
    private final WelfarePickAndCancelRenewalInterface renewalInterface;
    private final UserPackage userPackage;

    public class ClickListener implements DialogInterface.OnClickListener {
        public ClickListener() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (CancelSubscriptionDlg.this.renewalInterface == null) {
                C1442a.m8291w(CancelSubscriptionDlg.TAG, "onClick, mCancelAutoRenewalInterface is null.");
                CancelSubscriptionDlg.this.dismiss();
                return;
            }
            if (i10 == -2) {
                C1442a.m8290i(CancelSubscriptionDlg.TAG, "continue subscribe");
                CancelSubscriptionDlg.this.renewalInterface.retentionSuccessIAP();
                CancelSubscriptionDlg.this.renewalInterface.reportCancelAutoRenewalResultFailed("cancel_auto_renewal_result_confirm_dialog_negative");
            } else if (i10 == -1) {
                C1442a.m8290i(CancelSubscriptionDlg.TAG, "cancel subscribe, check password.");
                CancelSubscriptionDlg.this.renewalInterface.checkConfirmCancelPassword();
                CancelSubscriptionDlg.this.renewalInterface.reportButtonPositiveClicked();
            }
            CancelSubscriptionDlg.this.dismiss();
        }
    }

    public CancelSubscriptionDlg(Context context, boolean z10, WelfarePickAndCancelRenewalInterface welfarePickAndCancelRenewalInterface, UserPackage userPackage, CloudSpace cloudSpace) {
        super(context);
        this.isAppendEventId = false;
        this.initSuccess = false;
        this.context = context;
        this.isNewBm = z10;
        this.renewalInterface = welfarePickAndCancelRenewalInterface;
        this.userPackage = userPackage;
        this.cloudSpace = cloudSpace;
        this.hasNotCloudPackage = hasOtherPackage();
        if (context == null) {
            C1442a.m8291w(TAG, "context is null, initView Failed");
        } else {
            initView(context);
        }
    }

    private String getMessage(long j10, String str, String str2, String str3) {
        if (this.isNewBm) {
            return (this.hasNotCloudPackage || TextUtils.isEmpty(str2)) ? this.context.getString(R$string.cloudpay_confirm_cancel_monthly_new_bm_context_two, str, str) : this.context.getString(R$string.cloudpay_confirm_cancel_monthly_new_bm_context, str, str2, str3, str);
        }
        String string = (this.hasNotCloudPackage || TextUtils.isEmpty(str2)) ? this.context.getString(R$string.cloudpay_confirm_cancel_monthly_context_three, str, "5") : this.context.getString(R$string.cloudpay_confirm_cancel_monthly_context_one, str, str2, str3, "5");
        return j10 > DEFAULT_USE_SPACE ? this.context.getString(R$string.cloudpay_confirm_cancel_monthly_context_two, string, "5") : string;
    }

    private String getNoUseSpaceMessage(String str, String str2) {
        return this.isNewBm ? (this.hasNotCloudPackage || TextUtils.isEmpty(str)) ? this.context.getString(R$string.cloudpay_confirm_cancel_monthly_new_bm_no_use_space_context_two) : this.context.getString(R$string.cloudpay_confirm_cancel_monthly_new_bm_no_use_space_context, str, str2) : (this.hasNotCloudPackage || TextUtils.isEmpty(str)) ? this.context.getString(R$string.cloudpay_confirm_cancel_monthly_no_use_space_context_three, "5") : this.context.getString(R$string.cloudpay_confirm_cancel_monthly_no_use_space_context_one, str, str2, "5");
    }

    private boolean hasOtherPackage() {
        List<CloudSpace> effectivePackages;
        UserPackage userPackage = this.userPackage;
        if (userPackage != null && (effectivePackages = userPackage.getEffectivePackages()) != null && !effectivePackages.isEmpty()) {
            for (CloudSpace cloudSpace : effectivePackages) {
                if (cloudSpace.getScheme() != 0 && cloudSpace.getEndTime() >= this.userPackage.getServerTime()) {
                    return true;
                }
            }
        }
        return false;
    }

    private void initContentTips() {
        UserPackage userPackage = this.userPackage;
        if (userPackage == null || this.cloudSpace == null) {
            C1442a.m8291w(TAG, "userPackage or cloudSpace is null, initView Failed");
            this.contentTips.setVisibility(8);
            this.imgDot.setVisibility(8);
            this.defaultTips.setVisibility(0);
            this.isAppendEventId = true;
            return;
        }
        long used = userPackage.getUsed();
        long serverTime = this.userPackage.getServerTime();
        long endTime = this.cloudSpace.getEndTime();
        this.isAppendEventId = false;
        this.contentTips.setVisibility(0);
        this.defaultTips.setVisibility(8);
        String strM1524g = C0223k.m1524g(this.context, used);
        int iM69667i = C11667a.m69667i(serverTime, endTime);
        C1442a.m8290i(TAG, "initContentTips:" + used + " ; " + serverTime + " ; " + endTime + " ; " + this.hasNotCloudPackage + " ; " + iM69667i);
        String quantityString = iM69667i == 0 ? "" : this.context.getResources().getQuantityString(R$plurals.common_days, iM69667i, Integer.valueOf(iM69667i));
        String strM69668j = C11667a.m69668j(Long.valueOf(endTime), this.context);
        String message = getMessage(used, C0223k.m1529l(strM1524g), quantityString, strM69668j);
        if (used <= 0) {
            message = getNoUseSpaceMessage(quantityString, strM69668j);
        }
        this.contentTips.setText(message);
    }

    private void initView(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.cancel_auto_renewal_new_business_dialog_layout, (ViewGroup) null);
        this.defaultTips = (LinearLayout) C12809f.m76831d(viewInflate, R$id.ll_default_tips);
        this.contentTips = (TextView) C12809f.m76831d(viewInflate, R$id.content_tips);
        this.imgDot = (ImageView) C12809f.m76831d(viewInflate, R$id.img_dot);
        initContentTips();
        ClickListener clickListener = new ClickListener();
        setTitle(R$string.cloudpay_confirm_cancel_monthly_title);
        setView(viewInflate);
        setButton(-2, context.getString(R$string.cloudpay_exit_cancel_continuous_monthly_second), clickListener);
        setButton(-1, context.getString(R$string.cloudpay_confirm_still_cancel_monthly), clickListener);
        setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.huawei.android.hicloud.ui.uiextend.cloudpay.dialog.c
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                return this.f19199a.lambda$initView$0(dialogInterface, i10, keyEvent);
            }
        });
        this.initSuccess = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initView$0(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        if (i10 != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        WelfarePickAndCancelRenewalInterface welfarePickAndCancelRenewalInterface = this.renewalInterface;
        if (welfarePickAndCancelRenewalInterface == null) {
            C1442a.m8291w(TAG, "initView, cancel dialog.");
            dismiss();
            return false;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(CANCEL_RENEW_NEW_DIALOG_PRESS_BACK);
        sb2.append(this.isAppendEventId ? "_default" : "");
        welfarePickAndCancelRenewalInterface.backPressEvent(sb2.toString());
        dismiss();
        return true;
    }

    @Override // android.app.Dialog
    public void show() {
        if (this.initSuccess) {
            super.show();
            getButton(-1).setTextColor(this.context.getResources().getColor(R$color.enui50_red_color));
        }
    }
}
