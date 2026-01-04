package com.huawei.android.hicloud.p088ui.uiextend;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.views.RenewAgreementTextview;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.report.uba.UBAAnalyze;
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
public class V5PackageAreaLayout extends LinearLayout {
    private static final String TAG = "V5PackageAreaLayout";
    private String v5CheckDialogRenewAgreementText;
    private boolean v5CheckStatus;
    private String v5PackageCardRenewAgreementText;
    private TextView v5PackageRemarkTV;
    private RenewAgreementTextview v5RenewAgreementTV;
    private LinearLayout v5RenewCheckViewArea;
    private ImageView v5RenewCheckboxView;
    private TextView v5TitleTextView;

    public V5PackageAreaLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    private void initView(Context context) {
        if (C0209d.m1195O(C0213f.m1377a()) > 1.75f) {
            View.inflate(context, R$layout.v5_package_layout_big, this);
        } else {
            View.inflate(context, R$layout.v5_package_layout, this);
        }
        this.v5TitleTextView = (TextView) C12809f.m76831d(this, R$id.v5_package_tile);
        this.v5PackageRemarkTV = (TextView) C12809f.m76831d(this, R$id.v5_package_remark);
        this.v5RenewCheckViewArea = (LinearLayout) C12809f.m76831d(this, R$id.v5_renew_check_area);
        this.v5RenewAgreementTV = (RenewAgreementTextview) C12809f.m76831d(this, R$id.v5_renew_text);
        ImageView imageView = (ImageView) C12809f.m76831d(this, R$id.v5_renew_check_view);
        this.v5RenewCheckboxView = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.V5PackageAreaLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (V5PackageAreaLayout.this.v5CheckStatus) {
                    V5PackageAreaLayout.this.v5RenewCheckboxView.setBackground(V5PackageAreaLayout.this.getContext().getDrawable(R$drawable.renew_check_icon_off));
                    V5PackageAreaLayout.this.v5CheckStatus = false;
                } else {
                    V5PackageAreaLayout.this.v5RenewCheckboxView.setBackground(V5PackageAreaLayout.this.getContext().getDrawable(R$drawable.renew_check_icon_on));
                    V5PackageAreaLayout.this.v5CheckStatus = true;
                }
                LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
                linkedHashMapM79499C.put("renew_checkbox_status", String.valueOf(V5PackageAreaLayout.this.v5CheckStatus));
                linkedHashMapM79499C.put("way_of_purchase", "backup_dialog_purchase_v5");
                C13225d.m79490f1().m79591l0("UNIFORM_CLOUDPAY_CLICK_RENEW_CHECKBOX", linkedHashMapM79499C);
                UBAAnalyze.m29958S("PVC", "UNIFORM_CLOUDPAY_CLICK_RENEW_CHECKBOX", "4", "9", linkedHashMapM79499C);
            }
        });
    }

    public boolean isShowRenewAgreementArea() {
        LinearLayout linearLayout = this.v5RenewCheckViewArea;
        return linearLayout != null && linearLayout.getVisibility() == 0;
    }

    public boolean isV5CheckStatus() {
        return this.v5CheckStatus;
    }

    public void refreshCheckboxStatus(boolean z10) {
        this.v5CheckStatus = z10;
        ImageView imageView = this.v5RenewCheckboxView;
        if (imageView == null) {
            C11839m.m70687e(TAG, "refreshCheckboxStatus, renewCheckboxView is null.");
        } else if (z10) {
            imageView.setBackground(getContext().getDrawable(R$drawable.renew_check_icon_on));
        } else {
            imageView.setBackground(getContext().getDrawable(R$drawable.renew_check_icon_off));
        }
    }

    public void setV5CheckDialogRenewAgreementText(String str) {
        this.v5CheckDialogRenewAgreementText = str;
    }

    public void setV5PackageCardRenewAgreementText(String str) {
        this.v5PackageCardRenewAgreementText = str;
    }

    public void showRenewAgreement(Context context, RenewAgreementTextview.RenewAgreementTVCallback renewAgreementTVCallback) {
        if (C13452e.m80781L().m80803F0().booleanValue()) {
            if (C9733f.m60705z().m60763v("userSelectsAutoRenewal") == 0) {
                C1442a.m8290i(TAG, "showRecommendWorryRenewTV, switch is close.");
                return;
            }
            if (this.v5RenewCheckViewArea == null) {
                C11839m.m70687e(TAG, "showRenewAgreement, renewCheckViewArea is null.");
                return;
            }
            if (TextUtils.isEmpty(this.v5PackageCardRenewAgreementText)) {
                C11839m.m70687e(TAG, "showRenewAgreement, packageCardRenewAgreementText is null.");
                return;
            }
            if (TextUtils.isEmpty(this.v5CheckDialogRenewAgreementText)) {
                C11839m.m70687e(TAG, "showRenewAgreement, checkDialogRenewAgreementText is null.");
                return;
            }
            this.v5RenewCheckViewArea.setVisibility(0);
            if (this.v5CheckStatus) {
                this.v5RenewCheckboxView.setBackground(getContext().getDrawable(R$drawable.renew_check_icon_on));
            } else {
                this.v5RenewCheckboxView.setBackground(getContext().getDrawable(R$drawable.renew_check_icon_off));
            }
            String string = getContext().getString(R$string.cloudpay_monthly_renew_agreement);
            String string2 = getContext().getString(R$string.cloudpay_user_agreement);
            try {
                String str = String.format(this.v5PackageCardRenewAgreementText, string2, string);
                if (context instanceof Activity) {
                    this.v5RenewAgreementTV.m25806w(str, string2, string, (Activity) context, renewAgreementTVCallback);
                    this.v5RenewAgreementTV.setTextColor(getResources().getColor(R$color.view_details_text_color));
                } else {
                    C11839m.m70687e(TAG, "showRenewAgreement, context is null.");
                    this.v5RenewCheckViewArea.setVisibility(8);
                }
            } catch (Exception e10) {
                C11839m.m70687e(TAG, "showRenewAgreement err ：" + e10.getMessage());
            }
        }
    }

    public void showView(String str, String str2) {
        this.v5TitleTextView.setText(str);
        if (TextUtils.isEmpty(str2)) {
            C11839m.m70686d(TAG, "mRecommendDescTextView gone");
            this.v5PackageRemarkTV.setVisibility(8);
        } else {
            C11839m.m70686d(TAG, "mRecommendDescTextView show");
            this.v5PackageRemarkTV.setVisibility(0);
            this.v5PackageRemarkTV.setText(str2);
        }
    }
}
