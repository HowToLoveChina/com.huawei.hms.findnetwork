package com.huawei.cloud.pay.model.cardresourcebean;

import com.huawei.cloud.pay.R$color;
import com.huawei.cloud.pay.R$drawable;
import com.huawei.cloud.pay.R$style;

/* loaded from: classes5.dex */
public class GradeCardNormalResourceBean extends GradeCardBaseResourceBean {
    public GradeCardNormalResourceBean() {
        this.cardBgDrawable = R$drawable.upgrade_card_back_normal;
        initCommonResource();
    }

    private void initCommonResource() {
        int i10 = R$color.text_color_user_card_common;
        this.cardGradeTitleTextColor = i10;
        this.cardPriceTextColor = i10;
        this.oldPriceTextColor = i10;
        this.cardSpaceInfoTextColor = i10;
        this.cardRightTitleColor = i10;
        this.cardRightDividerColor = R$color.right_divider_color_common;
        this.cardRightIconBgDrawable = R$drawable.grade_right_back_normal;
        this.packageBgSelectedDrawable = R$drawable.package_card_selected_diamond;
        this.packageBgUnSelectedDrawable = R$drawable.package_card_unselected_diamond;
        this.packageCardSelectedIconDrawable = R$drawable.package_check_icon_diamond;
        this.packageTagBgDrawable = R$drawable.operation_tag_diamond_package;
        this.packageTagTextColor = R$color.text_color_operation_tag_common;
        int i11 = R$color.text_color_package_price_common;
        this.packageTitleTextColor = i11;
        this.packagePriceTextColor = i11;
        int i12 = R$color.text_color_package_origin_price_common;
        this.discountPriceTextColor = i12;
        this.packageInfoTextColor = i12;
        this.vipCardBgStyleId = R$style.default_vip_card_style;
        this.userNickNameTxColor = i10;
        this.userTotalValueTxColor = i10;
        int i13 = R$color.text_color_user_space_card_common;
        this.userSpaceValueTxColor = i13;
        this.userGradeNameTxColor = i10;
        this.userNextPaymentTitleTxColor = i13;
        this.packagePaymentTextColor = R$color.grade_card_text_color_6F6B6E;
        this.packagePaymentLinkTextColor = R$color.grade_card_text_color_E1DBF1;
        this.buyButtonTextColor = R$color.buy_button_text_color_diamond;
        this.buyButtonBgDrawable = R$drawable.buy_button_bg_diamond;
        this.cardFolderDownIconDrawable = R$drawable.grade_card_folder_down_normal;
        this.cardFolderUpIconDrawable = R$drawable.grade_card_folder_up_normal;
        this.cloudCardWatermarkAlpha = 1.0f;
        this.voucherArrowDrawable = R$drawable.voucher_normal_arrow;
        this.voucherColumnTextColor = R$color.voucher_column_text_normal_color;
        this.voucherNonClickableColumnTextColor = R$color.voucher_non_clickable_normal_color;
        this.voucherColumnImg = R$drawable.silver_voucher_column_ic;
        this.deductColumnImg = R$drawable.silver_deduct_column_ic;
    }

    public GradeCardNormalResourceBean(boolean z10) {
        if (z10) {
            this.cardBgDrawable = R$drawable.grade_card_back_normal_small;
        } else {
            this.cardBgDrawable = R$drawable.grade_card_back_normal;
        }
        initCommonResource();
    }
}
