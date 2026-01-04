package com.huawei.android.hicloud.p088ui.uiextend.cloudpay.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.TypefaceSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$dimen;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.TerminationRetentionData;
import com.huawei.cloud.pay.model.Welfare;
import com.huawei.cloud.pay.model.WelfareContent;
import com.huawei.cloud.pay.model.WelfarePickAndCancelRenewalInterface;
import p015ak.C0209d;
import p054cj.C1442a;
import p211d.C8968a;
import p292fn.C9733f;
import p336he.C10155f;
import p450le.C11273b;
import p618rm.C12540b1;
import p676ud.AlertDialogC13154a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class WelfarePickDialog extends AlertDialogC13154a implements View.OnClickListener {
    private static final long DIAMOND_CARD = 2199023255552L;
    private static final long GOLD_CARD = 214748364800L;
    private static final long SLIVER_CARD = 53687091200L;
    private static final String TAG = "WelfarePickDialog";
    private RelativeLayout cancelButton;
    private ImageView cloudWelfare;
    private RelativeLayout confirmButton;
    private View confirmDialogView;
    private TextView giftDay;
    private RelativeLayout giftLable;
    private ImageView iconWelfare;
    private boolean isPicked;
    private Context mContext;
    private RetentionDialog retentionDialog;
    private TextView subTitle;
    private TerminationRetentionData terminationRetentionData;
    private TextView title;
    private TextView tvConfirm;
    private Welfare welfare;
    private RelativeLayout welfareLayout;
    private TextView welfareName;
    private WelfarePickAndCancelRenewalInterface welfarePickInterface;

    public WelfarePickDialog(Context context, Welfare welfare, boolean z10, WelfarePickAndCancelRenewalInterface welfarePickAndCancelRenewalInterface, TerminationRetentionData terminationRetentionData) throws Resources.NotFoundException {
        super(context);
        this.mContext = context;
        this.welfare = welfare;
        this.isPicked = z10;
        this.welfarePickInterface = welfarePickAndCancelRenewalInterface;
        this.terminationRetentionData = terminationRetentionData;
        initView(context);
    }

    private WelfareContent getContent(Welfare welfare) {
        return (WelfareContent) C12540b1.m75483a(welfare.getContent(), WelfareContent.class);
    }

    private void initView(Context context) throws Resources.NotFoundException {
        if (context == null) {
            C1442a.m8290i(TAG, "context is null, initView Failed");
            return;
        }
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.welfare_pick_dialog_layout, (ViewGroup) null);
        this.confirmDialogView = viewInflate;
        this.giftLable = (RelativeLayout) C12809f.m76831d(viewInflate, R$id.gift_tag);
        this.title = (TextView) C12809f.m76831d(this.confirmDialogView, R$id.welfare_pick_title);
        this.subTitle = (TextView) C12809f.m76831d(this.confirmDialogView, R$id.welfare_pick_subtitle);
        this.welfareName = (TextView) C12809f.m76831d(this.confirmDialogView, R$id.welfare_name);
        this.welfareLayout = (RelativeLayout) C12809f.m76831d(this.confirmDialogView, R$id.rl_welfare);
        this.iconWelfare = (ImageView) C12809f.m76831d(this.confirmDialogView, R$id.icon_welfare);
        this.cloudWelfare = (ImageView) C12809f.m76831d(this.confirmDialogView, R$id.welfare_cloud);
        this.giftDay = (TextView) C12809f.m76831d(this.confirmDialogView, R$id.welfare_day);
        this.cancelButton = (RelativeLayout) C12809f.m76831d(this.confirmDialogView, R$id.cancel_btn);
        this.confirmButton = (RelativeLayout) C12809f.m76831d(this.confirmDialogView, R$id.confirm_btn);
        this.tvConfirm = (TextView) C12809f.m76831d(this.confirmDialogView, R$id.tv_confirm);
        this.welfareName.setText(this.welfare.getName());
        Resources resources = this.mContext.getResources();
        WelfareContent content = getContent(this.welfare);
        int duration = content.getDuration();
        if (resources == null) {
            return;
        }
        if (!this.isPicked) {
            this.welfareName.setPaddingRelative(0, 0, resources.getDimensionPixelSize(R$dimen.cloud_space_36_dp), 0);
        }
        if (C0209d.m1220W0()) {
            this.tvConfirm.setTextColor(context.getColor(R$color.welfare_cancel_text_color));
        } else {
            this.confirmButton.setBackground(C8968a.m56743b(context, R$drawable.welfare_dialog_button_bg));
            this.tvConfirm.setTextColor(context.getColor(R$color.white));
        }
        String quantityString = resources.getQuantityString(R$plurals.welfare_free_days, duration, Integer.valueOf(duration));
        SpannableString spannableString = new SpannableString(quantityString);
        String strValueOf = String.valueOf(duration);
        int iIndexOf = quantityString.indexOf(strValueOf);
        spannableString.setSpan(new TypefaceSpan("HwChinese-regular"), strValueOf.length() + iIndexOf, quantityString.length(), 33);
        spannableString.setSpan(new AbsoluteSizeSpan(resources.getDimensionPixelSize(R$dimen.cloud_space_20_dp)), iIndexOf + strValueOf.length(), quantityString.length(), 33);
        this.giftDay.setText(spannableString);
        if (this.isPicked) {
            this.giftLable.setVisibility(8);
            this.tvConfirm.setText(context.getString(R$string.continue_auto_renewal));
            this.subTitle.setText(resources.getQuantityString(R$plurals.welfare_cancel_info, duration, Integer.valueOf(duration)));
        } else {
            this.subTitle.setText(resources.getQuantityString(R$plurals.welfare_pick_dialog_info, duration, Integer.valueOf(duration)));
            this.giftLable.setVisibility(0);
            this.tvConfirm.setText(context.getString(R$string.pick_welfare_now));
        }
        setMemberCard(content.getSpace());
        this.cancelButton.setOnClickListener(this);
        this.confirmButton.setOnClickListener(this);
        setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.huawei.android.hicloud.ui.uiextend.cloudpay.dialog.WelfarePickDialog.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                if (i10 != 4 || keyEvent.getAction() != 1) {
                    return false;
                }
                if (WelfarePickDialog.this.terminationRetentionData == null) {
                    C1442a.m8289e(WelfarePickDialog.TAG, "initView, terminationRetentionData is null.");
                    WelfarePickDialog.this.dismiss();
                    return false;
                }
                if (WelfarePickDialog.this.welfarePickInterface == null) {
                    WelfarePickDialog.this.dismiss();
                    C1442a.m8289e(WelfarePickDialog.TAG, "initView, welfarePickInterface is null.");
                    return false;
                }
                if (WelfarePickDialog.this.isPicked) {
                    WelfarePickDialog.this.welfarePickInterface.backPressEvent("WELFARE_PICKED_DIALOG_PRESS_BACK");
                } else {
                    WelfarePickDialog.this.welfarePickInterface.backPressEvent("WELFARE_PICK_DIALOG_PRESS_BACK");
                }
                if (!WelfarePickDialog.this.terminationRetentionData.isFromIAP()) {
                    WelfarePickDialog.this.dismiss();
                }
                return true;
            }
        });
        setView(this.confirmDialogView);
    }

    private void setMemberCard(long j10) {
        if (C10155f.m63293q(500L)) {
            C1442a.m8290i(TAG, "is new business user");
            this.welfareLayout.setBackground(this.mContext.getDrawable(R$drawable.welfare_diamond_card_bg));
            this.iconWelfare.setImageResource(R$drawable.icon_welfare_diamond);
            this.cloudWelfare.setImageResource(R$drawable.icon_welfare_diamond_cloud);
            this.welfareName.setTextColor(this.mContext.getColor(R$color.welfare_name_color_diamond));
            this.giftDay.setTextColor(this.mContext.getColor(R$color.welfare_duration_color_diamond));
            return;
        }
        if (SLIVER_CARD == j10) {
            this.welfareLayout.setBackground(this.mContext.getDrawable(R$drawable.welfare_silver_card_bg));
            this.iconWelfare.setImageResource(R$drawable.icon_welfare_sliver);
            this.cloudWelfare.setImageResource(R$drawable.icon_welfare_sliver_cloud);
            this.welfareName.setTextColor(this.mContext.getColor(R$color.welfare_name_color_silver));
            this.giftDay.setTextColor(this.mContext.getColor(R$color.welfare_duration_color_silver));
            return;
        }
        if (214748364800L == j10) {
            this.welfareLayout.setBackground(this.mContext.getDrawable(R$drawable.welfare_gold_card_bg));
            this.iconWelfare.setImageResource(R$drawable.icon_welfare_gold);
            this.cloudWelfare.setImageResource(R$drawable.icon_welfare_gold_cloud);
            this.welfareName.setTextColor(this.mContext.getColor(R$color.welfare_name_color_gold));
            this.giftDay.setTextColor(this.mContext.getColor(R$color.welfare_duration_color_gold));
            return;
        }
        if (DIAMOND_CARD != j10) {
            C1442a.m8290i(TAG, "no matched space");
            return;
        }
        this.welfareLayout.setBackground(this.mContext.getDrawable(R$drawable.welfare_diamond_card_bg));
        this.iconWelfare.setImageResource(R$drawable.icon_welfare_diamond);
        this.cloudWelfare.setImageResource(R$drawable.icon_welfare_diamond_cloud);
        this.welfareName.setTextColor(this.mContext.getColor(R$color.welfare_name_color_diamond));
        this.giftDay.setTextColor(this.mContext.getColor(R$color.welfare_duration_color_diamond));
    }

    private void showRetentionDialog() {
        RetentionDialog retentionDialog = new RetentionDialog(this.mContext, true, this.welfarePickInterface, this.terminationRetentionData);
        this.retentionDialog = retentionDialog;
        retentionDialog.setCanceledOnTouchOutside(false);
        this.retentionDialog.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WelfarePickAndCancelRenewalInterface welfarePickAndCancelRenewalInterface;
        if (this.terminationRetentionData == null) {
            C1442a.m8289e(TAG, "onClick, terminationRetentionData is null.");
            return;
        }
        int id2 = view.getId();
        if (id2 != R$id.cancel_btn) {
            if (id2 == R$id.confirm_btn) {
                if (!this.isPicked) {
                    this.welfarePickInterface.pickWelfare(this.welfare.getId());
                    return;
                }
                if (this.terminationRetentionData.isFromIAP() && (welfarePickAndCancelRenewalInterface = this.welfarePickInterface) != null) {
                    welfarePickAndCancelRenewalInterface.retentionSuccessIAP();
                }
                this.welfarePickInterface.reportWelfare("CLICK_USE_RENEWAL_WITH_WELFARE");
                dismiss();
                return;
            }
            return;
        }
        if (C9733f.m60705z().m60763v("businessTerminationRetentionPopup") != 1 || C10155f.m63293q(500L)) {
            if (this.welfarePickInterface != null) {
                C1442a.m8290i(TAG, "onClick, switch close, check password.");
                this.welfarePickInterface.checkConfirmCancelPassword();
            } else {
                C1442a.m8289e(TAG, "onClick, welfarePickInterface is null.");
            }
        } else if (C11273b.m67652g(this.terminationRetentionData.getUserPackage())) {
            WelfarePickAndCancelRenewalInterface welfarePickAndCancelRenewalInterface2 = this.welfarePickInterface;
            if (welfarePickAndCancelRenewalInterface2 != null) {
                welfarePickAndCancelRenewalInterface2.checkConfirmCancelPassword();
            } else {
                C1442a.m8289e(TAG, "onClick, switch open, not multiple renew, welfarePickInterface is null.");
            }
        } else {
            if (this.terminationRetentionData.isFromIAP() ? C11273b.m67653h(this.terminationRetentionData) : C11273b.m67654i(this.terminationRetentionData.getGetClientUIConfigResp(), this.terminationRetentionData.getUserPackage())) {
                C1442a.m8289e(TAG, "onClick, retention text is empty.");
                WelfarePickAndCancelRenewalInterface welfarePickAndCancelRenewalInterface3 = this.welfarePickInterface;
                if (welfarePickAndCancelRenewalInterface3 != null) {
                    welfarePickAndCancelRenewalInterface3.checkConfirmCancelPassword();
                } else {
                    C1442a.m8289e(TAG, "onClick, switch open, welfarePickInterface is null.");
                }
            } else {
                showRetentionDialog();
            }
        }
        if (this.isPicked) {
            this.welfarePickInterface.reportWelfare("CLICK_CANCEL_RENEWAL_WITH_PICK");
        } else {
            this.welfarePickInterface.reportWelfare("CLICK_CANCEL_RENEWAL_NO_PICK");
        }
        dismiss();
    }
}
