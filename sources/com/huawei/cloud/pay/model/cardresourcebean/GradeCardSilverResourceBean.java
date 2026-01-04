package com.huawei.cloud.pay.model.cardresourcebean;

import com.huawei.cloud.pay.R$color;
import com.huawei.cloud.pay.R$drawable;
import com.huawei.cloud.pay.R$style;

/* loaded from: classes5.dex */
public class GradeCardSilverResourceBean extends GradeCardBaseResourceBean {
    public GradeCardSilverResourceBean() {
        this.cardBgDrawable = R$drawable.upgrade_card_back_silver;
        initCommonResource();
    }

    private void initCommonResource() {
        int i10 = R$color.text_color_user_card_silver;
        this.cardGradeTitleTextColor = i10;
        this.cardPriceTextColor = i10;
        this.oldPriceTextColor = i10;
        this.cardSpaceInfoTextColor = i10;
        this.cardRightTitleColor = i10;
        this.cardRightDividerColor = R$color.right_divider_color_silver;
        this.cardRightIconBgDrawable = R$drawable.grade_right_back_silver;
        this.packageBgSelectedDrawable = R$drawable.package_card_selected_silver;
        this.packageBgUnSelectedDrawable = R$drawable.package_card_unselected_silver;
        this.packageCardSelectedIconDrawable = R$drawable.package_check_icon_silver;
        this.packageTagBgDrawable = R$drawable.operation_tag_silver_background;
        this.packageTagTextColor = R$color.text_color_operation_tag_silver;
        int i11 = R$color.text_color_package_price_silver;
        this.packageTitleTextColor = i11;
        this.packagePriceTextColor = i11;
        int i12 = R$color.text_color_package_origin_price_silver;
        this.discountPriceTextColor = i12;
        this.packageInfoTextColor = i12;
        this.vipCardBgStyleId = R$style.silver_vip_card_style;
        this.userNickNameTxColor = i10;
        this.userTotalValueTxColor = i10;
        this.userSpaceValueTxColor = i10;
        this.userGradeNameTxColor = i10;
        this.userNextPaymentTitleTxColor = i10;
        this.packagePaymentTextColor = R$color.text_color_payment_intro_silver;
        this.packagePaymentLinkTextColor = R$color.text_color_payment_link_silver;
        this.buyButtonTextColor = R$color.buy_button_text_color_silver;
        this.buyButtonBgDrawable = R$drawable.buy_button_bg_silver;
        this.cardFolderDownIconDrawable = R$drawable.grade_card_folder_down_silver;
        this.cardFolderUpIconDrawable = R$drawable.grade_card_folder_up_silver;
        this.cloudCardWatermarkAlpha = 1.0f;
        this.voucherArrowDrawable = R$drawable.voucher_silver_arrow;
        this.voucherColumnTextColor = R$color.voucher_column_text_silver_color;
        this.voucherNonClickableColumnTextColor = R$color.voucher_non_clickable_silver_color;
        this.voucherColumnImg = R$drawable.silver_voucher_column_ic;
        this.deductColumnImg = R$drawable.silver_deduct_column_ic;
    }

    public GradeCardSilverResourceBean(boolean z10) {
        if (z10) {
            this.cardBgDrawable = R$drawable.grade_card_back_silver_small;
        } else {
            this.cardBgDrawable = R$drawable.grade_card_back_silver;
        }
        initCommonResource();
    }
}
