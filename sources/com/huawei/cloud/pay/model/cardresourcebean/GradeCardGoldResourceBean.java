package com.huawei.cloud.pay.model.cardresourcebean;

import com.huawei.cloud.pay.R$color;
import com.huawei.cloud.pay.R$drawable;
import com.huawei.cloud.pay.R$style;

/* loaded from: classes5.dex */
public class GradeCardGoldResourceBean extends GradeCardBaseResourceBean {
    public GradeCardGoldResourceBean() {
        this.cardBgDrawable = R$drawable.upgrade_card_back_gold;
        initCommonResource();
    }

    private void initCommonResource() {
        int i10 = R$color.text_color_user_card_gold;
        this.cardGradeTitleTextColor = i10;
        this.cardPriceTextColor = i10;
        this.oldPriceTextColor = i10;
        this.cardSpaceInfoTextColor = i10;
        this.cardRightTitleColor = i10;
        this.cardRightDividerColor = R$color.right_divider_color_gold;
        this.cardRightIconBgDrawable = R$drawable.grade_right_back_gold;
        this.packageBgSelectedDrawable = R$drawable.package_card_selected_gold;
        this.packageBgUnSelectedDrawable = R$drawable.package_card_unselected_gold;
        this.packageCardSelectedIconDrawable = R$drawable.package_check_icon_gold;
        this.packageTagBgDrawable = R$drawable.operation_tag_gold_background;
        this.packageTagTextColor = R$color.text_color_operation_tag_gold;
        int i11 = R$color.text_color_package_price_gold;
        this.packageTitleTextColor = i11;
        this.packagePriceTextColor = i11;
        int i12 = R$color.text_color_package_origin_price_gold;
        this.discountPriceTextColor = i12;
        this.packageInfoTextColor = i12;
        this.vipCardBgStyleId = R$style.golden_vip_card_style;
        this.userNickNameTxColor = i10;
        this.userTotalValueTxColor = i10;
        this.userSpaceValueTxColor = i10;
        this.userGradeNameTxColor = i10;
        this.userNextPaymentTitleTxColor = i10;
        this.packagePaymentTextColor = R$color.text_color_payment_intro_gold;
        this.packagePaymentLinkTextColor = R$color.text_color_payment_link_gold;
        this.buyButtonTextColor = R$color.buy_button_text_color_gold;
        this.buyButtonBgDrawable = R$drawable.buy_button_bg_gold;
        this.cardFolderDownIconDrawable = R$drawable.grade_card_folder_down_gold;
        this.cardFolderUpIconDrawable = R$drawable.grade_card_folder_up_gold;
        this.cloudCardWatermarkAlpha = 1.0f;
        this.voucherArrowDrawable = R$drawable.voucher_gold_arrow;
        this.voucherColumnTextColor = R$color.voucher_column_text_gold_color;
        this.voucherNonClickableColumnTextColor = R$color.voucher_non_clickable_gold_color;
        this.voucherColumnImg = R$drawable.gold_voucher_column_ic;
        this.deductColumnImg = R$drawable.gold_deduct_column_ic;
    }

    public GradeCardGoldResourceBean(boolean z10) {
        if (z10) {
            this.cardBgDrawable = R$drawable.grade_card_back_gold_small;
        } else {
            this.cardBgDrawable = R$drawable.grade_card_back_gold;
        }
        initCommonResource();
    }
}
