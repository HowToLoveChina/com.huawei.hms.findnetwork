package com.huawei.android.hicloud.p088ui.uiextend;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.views.RenewAgreementTextview;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.uikit.phone.hwbutton.widget.HwButton;
import java.util.LinkedHashMap;
import p015ak.C0209d;
import p015ak.C0213f;
import p054cj.C1442a;
import p292fn.C9733f;
import p514o9.C11839m;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import sk.C12809f;

/* loaded from: classes3.dex */
public class DialogMarketLayout extends RelativeLayout {
    private static final String TAG = "DialogMarketLayout";
    private String checkDialogRenewAgreementText;
    private boolean checkStatus;
    private TextView mDescTextView;
    private HwButton mJumpButton;
    private TextView mRecommendDescTextView;
    private TextView mTitleTextView;
    private String packageCardRenewAgreementText;
    private RenewAgreementTextview renewAgreementTV;
    private LinearLayout renewCheckViewArea;
    private ImageView renewCheckboxView;

    public DialogMarketLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    private void initView(Context context) {
        float fM1195O = C0209d.m1195O(C0213f.m1377a());
        if (fM1195O >= 2.0f) {
            View.inflate(context, R$layout.space_not_enough_dialog_market_layout_2, this);
        } else if (fM1195O >= 1.75f) {
            View.inflate(context, R$layout.space_not_enough_dialog_market_layout_1dot75, this);
        } else {
            View.inflate(context, R$layout.space_not_enough_dialog_market_layout, this);
        }
        this.mTitleTextView = (TextView) C12809f.m76831d(this, R$id.title_text);
        this.mRecommendDescTextView = (TextView) C12809f.m76831d(this, R$id.recommend_desc_text);
        this.mDescTextView = (TextView) C12809f.m76831d(this, R$id.desc_text);
        this.mJumpButton = (HwButton) C12809f.m76831d(this, R$id.jump_button);
        this.renewCheckViewArea = (LinearLayout) C12809f.m76831d(this, R$id.not_enough_renew_check_area);
        this.renewAgreementTV = (RenewAgreementTextview) C12809f.m76831d(this, R$id.not_enough_renew_text);
        ImageView imageView = (ImageView) C12809f.m76831d(this, R$id.not_enough_renew_check_view);
        this.renewCheckboxView = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.DialogMarketLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DialogMarketLayout.this.checkStatus) {
                    DialogMarketLayout.this.renewCheckboxView.setBackground(DialogMarketLayout.this.getContext().getDrawable(R$drawable.renew_check_icon_off));
                    DialogMarketLayout.this.checkStatus = false;
                } else {
                    DialogMarketLayout.this.renewCheckboxView.setBackground(DialogMarketLayout.this.getContext().getDrawable(R$drawable.renew_check_icon_on));
                    DialogMarketLayout.this.checkStatus = true;
                }
                LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
                linkedHashMapM79499C.put("renew_checkbox_status", String.valueOf(DialogMarketLayout.this.checkStatus));
                linkedHashMapM79499C.put("way_of_purchase", "backup_dialog_purchase");
                C13225d.m79490f1().m79591l0("UNIFORM_CLOUDPAY_CLICK_RENEW_CHECKBOX", linkedHashMapM79499C);
                UBAAnalyze.m29958S("PVC", "UNIFORM_CLOUDPAY_CLICK_RENEW_CHECKBOX", "4", "9", linkedHashMapM79499C);
            }
        });
    }

    public void fullInitLayout(String str, String str2, String str3, String str4, View.OnClickListener onClickListener) {
        this.mTitleTextView.setText(str);
        this.mDescTextView.setText(str3);
        if (TextUtils.isEmpty(str4) || onClickListener == null) {
            this.mJumpButton.setVisibility(8);
            this.renewCheckViewArea.setVisibility(8);
        } else {
            this.mJumpButton.setVisibility(0);
            this.mJumpButton.setText(str4);
            this.mJumpButton.setOnClickListener(onClickListener);
        }
        if (TextUtils.isEmpty(str2)) {
            C11839m.m70686d(TAG, "mRecommendDescTextView gone");
            this.mRecommendDescTextView.setVisibility(8);
        } else {
            C11839m.m70686d(TAG, "mRecommendDescTextView show");
            this.mRecommendDescTextView.setVisibility(0);
            this.mRecommendDescTextView.setText(str2);
        }
    }

    public boolean isCheckStatus() {
        return this.checkStatus;
    }

    public boolean isShowRenewAgreementArea() {
        LinearLayout linearLayout = this.renewCheckViewArea;
        return linearLayout != null && linearLayout.getVisibility() == 0;
    }

    public void refreshCheckboxStatus(boolean z10) {
        this.checkStatus = z10;
        ImageView imageView = this.renewCheckboxView;
        if (imageView == null) {
            C11839m.m70687e(TAG, "refreshCheckboxStatus, renewCheckboxView is null.");
        } else if (z10) {
            imageView.setBackground(getContext().getDrawable(R$drawable.renew_check_icon_on));
        } else {
            imageView.setBackground(getContext().getDrawable(R$drawable.renew_check_icon_off));
        }
    }

    public void setCheckDialogRenewAgreementText(String str) {
        this.checkDialogRenewAgreementText = str;
    }

    public void setPackageCardRenewAgreementText(String str) {
        this.packageCardRenewAgreementText = str;
    }

    public void showRenewAgreement(Context context, RenewAgreementTextview.RenewAgreementTVCallback renewAgreementTVCallback) {
        if (C13452e.m80781L().m80803F0().booleanValue()) {
            if (C9733f.m60705z().m60763v("userSelectsAutoRenewal") == 0) {
                C1442a.m8290i(TAG, "showRecommendWorryRenewTV, switch is close.");
                return;
            }
            if (this.renewCheckViewArea == null) {
                C11839m.m70687e(TAG, "showRenewAgreement, renewCheckViewArea is null.");
                return;
            }
            if (TextUtils.isEmpty(this.packageCardRenewAgreementText)) {
                C11839m.m70687e(TAG, "showRenewAgreement, packageCardRenewAgreementText is null.");
                return;
            }
            if (TextUtils.isEmpty(this.checkDialogRenewAgreementText)) {
                C11839m.m70687e(TAG, "showRenewAgreement, checkDialogRenewAgreementText is null.");
                return;
            }
            this.renewCheckViewArea.setVisibility(0);
            if (this.checkStatus) {
                this.renewCheckboxView.setBackground(getContext().getDrawable(R$drawable.renew_check_icon_on));
            } else {
                this.renewCheckboxView.setBackground(getContext().getDrawable(R$drawable.renew_check_icon_off));
            }
            String string = getContext().getString(R$string.cloudpay_monthly_renew_agreement);
            String string2 = getContext().getString(R$string.cloudpay_user_agreement);
            String str = String.format(this.packageCardRenewAgreementText, string2, string);
            if (!(context instanceof Activity)) {
                C11839m.m70687e(TAG, "showRenewAgreement, context is null.");
            } else {
                this.renewAgreementTV.m25806w(str, string2, string, (Activity) context, renewAgreementTVCallback);
                this.renewAgreementTV.setTextColor(getResources().getColor(R$color.view_details_text_color));
            }
        }
    }
}
