package com.huawei.cloud.pay.model.cardresourcebean;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import com.huawei.cloud.pay.R$attr;
import com.huawei.cloud.pay.R$drawable;
import p015ak.C0213f;
import p723w.C13503b;

/* loaded from: classes5.dex */
public abstract class GradeCardBaseResourceBean {
    private static final int MAX_ALPHA = 255;
    protected int buyButtonBgDrawable;
    protected int buyButtonTextColor;
    protected int cardBgDrawable;
    protected int cardFolderDownIconDrawable;
    protected int cardFolderUpIconDrawable;
    protected int cardGradeTitleTextColor;
    protected int cardPriceTextColor;
    protected int cardRightDividerColor;
    protected int cardRightIconBgDrawable;
    protected int cardRightTitleColor;
    protected int cardSpaceInfoTextColor;
    protected float cloudCardWatermarkAlpha;
    protected int deductColumnImg;
    protected int discountPriceTextColor;
    protected int oldPriceTextColor;
    protected int packageBgSelectedDrawable;
    protected int packageBgUnSelectedDrawable;
    protected int packageCardSelectedIconDrawable;
    protected int packageInfoTextColor;
    protected int packagePaymentLinkTextColor;
    protected int packagePaymentTextColor;
    protected int packagePriceTextColor;
    protected int packageTagBgDrawable;
    protected int packageTagTextColor;
    protected int packageTitleTextColor;
    protected int userGradeNameTxColor;
    protected int userNextPaymentTitleTxColor;
    protected int userNickNameTxColor;
    protected int userSpaceValueTxColor;
    protected int userTotalValueTxColor;
    protected int vipCardBgStyleId;
    protected int voucherArrowDrawable;
    protected int voucherColumnImg;
    protected int voucherColumnTextColor;
    protected int voucherNonClickableColumnTextColor;

    private int getColorFromStyle(int i10) {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            return -1;
        }
        return contextM1377a.obtainStyledAttributes(this.vipCardBgStyleId, new int[]{i10}).getColor(0, -1);
    }

    public int getBoldTextColor() {
        return getTextColor(1.0f);
    }

    public int getBuyButtonBgDrawable() {
        return this.buyButtonBgDrawable;
    }

    public int getBuyButtonTextColor() {
        return this.buyButtonTextColor;
    }

    public int getCardBgDrawable() {
        return this.cardBgDrawable;
    }

    public int getCardFolderDownIconDrawable() {
        return this.cardFolderDownIconDrawable;
    }

    public int getCardFolderUpIconDrawable() {
        return this.cardFolderUpIconDrawable;
    }

    public int getCardGradeTitleTextColor() {
        return this.cardGradeTitleTextColor;
    }

    public int getCardPriceTextColor() {
        return this.cardPriceTextColor;
    }

    public int getCardRightDividerColor() {
        return this.cardRightDividerColor;
    }

    public int getCardRightIconBgDrawable() {
        return this.cardRightIconBgDrawable;
    }

    public int getCardRightTitleColor() {
        return this.cardRightTitleColor;
    }

    public int getCardSpaceInfoTextColor() {
        return this.cardSpaceInfoTextColor;
    }

    public float getCloudCardWatermarkAlpha() {
        return this.cloudCardWatermarkAlpha;
    }

    public int getDeductColumnImg() {
        return this.deductColumnImg;
    }

    public int getDiscountPriceTextColor() {
        return this.discountPriceTextColor;
    }

    public Drawable getDrawable(int i10) {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            return new VectorDrawable();
        }
        Resources.Theme themeNewTheme = contextM1377a.getResources().newTheme();
        themeNewTheme.applyStyle(this.vipCardBgStyleId, false);
        return contextM1377a.getResources().getDrawable(i10, themeNewTheme);
    }

    public int getMediumTextColor() {
        return getTextColor(0.8f);
    }

    public int getNormalTextColor() {
        return getTextColor(0.6f);
    }

    public int getOldPriceTextColor() {
        return this.oldPriceTextColor;
    }

    public int getPackageBgSelectedDrawable() {
        return this.packageBgSelectedDrawable;
    }

    public int getPackageBgUnSelectedDrawable() {
        return this.packageBgUnSelectedDrawable;
    }

    public int getPackageCardSelectedIconDrawable() {
        return this.packageCardSelectedIconDrawable;
    }

    public int getPackageInfoTextColor() {
        return this.packageInfoTextColor;
    }

    public int getPackagePaymentLinkTextColor() {
        return this.packagePaymentLinkTextColor;
    }

    public int getPackagePaymentTextColor() {
        return this.packagePaymentTextColor;
    }

    public int getPackagePriceTextColor() {
        return this.packagePriceTextColor;
    }

    public int getPackageTagBgDrawable() {
        return this.packageTagBgDrawable;
    }

    public int getPackageTagTextColor() {
        return this.packageTagTextColor;
    }

    public int getPackageTitleTextColor() {
        return this.packageTitleTextColor;
    }

    public int getPetalOneTextColor() {
        return getColorFromStyle(R$attr.petalone_ic_fg_color);
    }

    public Drawable getProcessBarDrawable() {
        return getDrawable(R$drawable.space_usage_process_bar);
    }

    public int getTextColor(float f10) {
        return C13503b.m81226j(getColorFromStyle(R$attr.vip_card_text_color), (int) (f10 * 255.0f));
    }

    public int getUserGradeNameTxColor() {
        return this.userGradeNameTxColor;
    }

    public int getUserNextPaymentTitleTxColor() {
        return this.userNextPaymentTitleTxColor;
    }

    public int getUserNickNameTxColor() {
        return this.userNickNameTxColor;
    }

    public int getUserSpaceValueTxColor() {
        return this.userSpaceValueTxColor;
    }

    public int getUserTotalValueTxColor() {
        return this.userTotalValueTxColor;
    }

    public Drawable getVipCardBg() {
        return getDrawable(R$drawable.ic_vip_card);
    }

    public int getVoucherArrowDrawable() {
        return this.voucherArrowDrawable;
    }

    public int getVoucherColumnImg() {
        return this.voucherColumnImg;
    }

    public int getVoucherColumnTextColor() {
        return this.voucherColumnTextColor;
    }

    public int getVoucherNonClickableColumnTextColor() {
        return this.voucherNonClickableColumnTextColor;
    }

    public void setBuyButtonBgDrawable(int i10) {
        this.buyButtonBgDrawable = i10;
    }

    public void setBuyButtonTextColor(int i10) {
        this.buyButtonTextColor = i10;
    }

    public void setCardBgDrawable(int i10) {
        this.cardBgDrawable = i10;
    }

    public void setCardFolderDownIconDrawable(int i10) {
        this.cardFolderDownIconDrawable = i10;
    }

    public void setCardFolderUpIconDrawable(int i10) {
        this.cardFolderUpIconDrawable = i10;
    }

    public void setCardGradeTitleTextColor(int i10) {
        this.cardGradeTitleTextColor = i10;
    }

    public void setCardPriceTextColor(int i10) {
        this.cardPriceTextColor = i10;
    }

    public void setCardRightDividerColor(int i10) {
        this.cardRightDividerColor = i10;
    }

    public void setCardRightIconBgDrawable(int i10) {
        this.cardRightIconBgDrawable = i10;
    }

    public void setCardRightTitleColor(int i10) {
        this.cardRightTitleColor = i10;
    }

    public void setCardSpaceInfoTextColor(int i10) {
        this.cardSpaceInfoTextColor = i10;
    }

    public void setCloudCardWatermarkAlpha(float f10) {
        this.cloudCardWatermarkAlpha = f10;
    }

    public void setDeductColumnImg(int i10) {
        this.deductColumnImg = i10;
    }

    public void setDiscountPriceTextColor(int i10) {
        this.discountPriceTextColor = i10;
    }

    public void setOldPriceTextColor(int i10) {
        this.oldPriceTextColor = i10;
    }

    public void setPackageBgSelectedDrawable(int i10) {
        this.packageBgSelectedDrawable = i10;
    }

    public void setPackageBgUnSelectedDrawable(int i10) {
        this.packageBgUnSelectedDrawable = i10;
    }

    public void setPackageCardSelectedIconDrawable(int i10) {
        this.packageCardSelectedIconDrawable = i10;
    }

    public void setPackageInfoTextColor(int i10) {
        this.packageInfoTextColor = i10;
    }

    public void setPackagePaymentLinkTextColor(int i10) {
        this.packagePaymentLinkTextColor = i10;
    }

    public void setPackagePaymentTextColor(int i10) {
        this.packagePaymentTextColor = i10;
    }

    public void setPackagePriceTextColor(int i10) {
        this.packagePriceTextColor = i10;
    }

    public void setPackageTagBgDrawable(int i10) {
        this.packageTagBgDrawable = i10;
    }

    public void setPackageTagTextColor(int i10) {
        this.packageTagTextColor = i10;
    }

    public void setPackageTitleTextColor(int i10) {
        this.packageTitleTextColor = i10;
    }

    public void setUserGradeNameTxColor(int i10) {
        this.userGradeNameTxColor = i10;
    }

    public void setUserNextPaymentTitleTxColor(int i10) {
        this.userNextPaymentTitleTxColor = i10;
    }

    public void setUserNickNameTxColor(int i10) {
        this.userNickNameTxColor = i10;
    }

    public void setUserSpaceValueTxColor(int i10) {
        this.userSpaceValueTxColor = i10;
    }

    public void setUserTotalValueTxColor(int i10) {
        this.userTotalValueTxColor = i10;
    }

    public void setVipCardBgStyleId(int i10) {
        this.vipCardBgStyleId = i10;
    }

    public void setVoucherArrowDrawable(int i10) {
        this.voucherArrowDrawable = i10;
    }

    public void setVoucherColumnImg(int i10) {
        this.voucherColumnImg = i10;
    }

    public void setVoucherColumnTextColor(int i10) {
        this.voucherColumnTextColor = i10;
    }

    public void setVoucherNonClickableColumnTextColor(int i10) {
        this.voucherNonClickableColumnTextColor = i10;
    }
}
