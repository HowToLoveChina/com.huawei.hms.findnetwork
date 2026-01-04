package com.huawei.cloud.pay.model.cardresourcebean;

import com.huawei.cloud.pay.R$color;
import com.huawei.cloud.pay.R$drawable;
import com.huawei.cloud.pay.R$style;

/* loaded from: classes5.dex */
public class GradeCardDefaultResourceBean extends GradeCardBaseResourceBean {
    public GradeCardDefaultResourceBean() {
        this.cardBgDrawable = R$drawable.upgrade_card_back_default;
        initCommonResource();
    }

    private void initCommonResource() {
        int i10 = R$color.text_color_user_card_default;
        this.cardGradeTitleTextColor = i10;
        this.cardPriceTextColor = i10;
        this.oldPriceTextColor = i10;
        this.cardSpaceInfoTextColor = i10;
        this.cardRightTitleColor = i10;
        this.cardRightDividerColor = R$color.right_divider_color_default;
        this.cardRightIconBgDrawable = R$drawable.grade_right_back_diamond;
        this.packageBgSelectedDrawable = R$drawable.package_card_selected_default;
        this.packageBgUnSelectedDrawable = R$drawable.package_card_unselected_default;
        this.packageCardSelectedIconDrawable = R$drawable.package_check_icon_default;
        this.packageTagBgDrawable = R$drawable.operation_tag_default_package;
        this.packageTagTextColor = R$color.text_color_operation_tag_default;
        int i11 = R$color.text_color_package_price_default;
        this.packageTitleTextColor = i11;
        this.packagePriceTextColor = i11;
        int i12 = R$color.text_color_package_origin_price_default;
        this.discountPriceTextColor = i12;
        this.packageInfoTextColor = i12;
        this.vipCardBgStyleId = R$style.default_vip_card_style;
        this.userNickNameTxColor = i10;
        this.userTotalValueTxColor = i10;
        this.userSpaceValueTxColor = i10;
        this.userGradeNameTxColor = i10;
        this.userNextPaymentTitleTxColor = i10;
        this.packagePaymentTextColor = R$color.text_color_payment_intro_default;
        this.packagePaymentLinkTextColor = R$color.text_color_payment_link_default;
        this.buyButtonTextColor = R$color.buy_button_text_color_default;
        this.buyButtonBgDrawable = R$drawable.buy_button_bg_default;
        this.cardFolderDownIconDrawable = R$drawable.grade_card_folder_down_diamond;
        this.cardFolderUpIconDrawable = R$drawable.grade_card_folder_up_diamond;
        this.cloudCardWatermarkAlpha = 0.24f;
        this.voucherArrowDrawable = R$drawable.voucher_default_arrow;
        this.voucherColumnTextColor = R$color.voucher_column_text_default_color;
        this.voucherNonClickableColumnTextColor = R$color.voucher_non_clickable_default_color;
        this.voucherColumnImg = R$drawable.silver_voucher_column_ic;
        this.deductColumnImg = R$drawable.silver_deduct_column_ic;
    }

    public GradeCardDefaultResourceBean(boolean z10) {
        if (z10) {
            this.cardBgDrawable = R$drawable.grade_card_back_default_small;
        } else {
            this.cardBgDrawable = R$drawable.grade_card_back_default;
        }
        initCommonResource();
    }
}
