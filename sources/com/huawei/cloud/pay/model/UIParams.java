package com.huawei.cloud.pay.model;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class UIParams implements Serializable {
    private static final long serialVersionUID = 1;

    @SerializedName("continuous_monthly_package_desc")
    private String continuousMonthlyPackageDesc;

    @SerializedName("plan_choose_desc")
    private String planChooseDesc;

    @SerializedName("plan_choose_tile")
    private String planChooseTile;

    @SerializedName("plan_detail_free_space_tile")
    private String planDetailFreeSpaceTile;

    @SerializedName("plan_detail_pay_space_tile")
    private String planDetailPaySpaceTile;

    @SerializedName("plan_detail_total_space_tile")
    private String planDetailTotalSpaceTile;

    @SerializedName("plan_detail_uesd_space_tile")
    private String planDetailUesdSpaceTile;

    @SerializedName("plan_Title")
    private String planTitle;

    @SerializedName("promotion_card_title")
    private String promotionCardTitle;

    public String getContinuousMonthlyPackageDesc() {
        return this.continuousMonthlyPackageDesc;
    }

    public String getPlanChooseDesc() {
        return this.planChooseDesc;
    }

    public String getPlanChooseTile() {
        return this.planChooseTile;
    }

    public String getPlanDetailFreeSpaceTile() {
        return this.planDetailFreeSpaceTile;
    }

    public String getPlanDetailPaySpaceTile() {
        return this.planDetailPaySpaceTile;
    }

    public String getPlanDetailTotalSpaceTile() {
        return this.planDetailTotalSpaceTile;
    }

    public String getPlanDetailUesdSpaceTile() {
        return this.planDetailUesdSpaceTile;
    }

    public String getPlanTitle() {
        return this.planTitle;
    }

    public String getPromotionCardTitle() {
        return this.promotionCardTitle;
    }

    public boolean isAllFieldEmpty() {
        return TextUtils.isEmpty(this.planTitle) && TextUtils.isEmpty(this.planDetailTotalSpaceTile) && TextUtils.isEmpty(this.planDetailUesdSpaceTile) && TextUtils.isEmpty(this.planDetailFreeSpaceTile) && TextUtils.isEmpty(this.planDetailPaySpaceTile) && TextUtils.isEmpty(this.planChooseTile) && TextUtils.isEmpty(this.planChooseDesc) && TextUtils.isEmpty(this.promotionCardTitle) && TextUtils.isEmpty(this.continuousMonthlyPackageDesc);
    }

    public void setContinuousMonthlyPackageDesc(String str) {
        this.continuousMonthlyPackageDesc = str;
    }

    public void setPlanChooseDesc(String str) {
        this.planChooseDesc = str;
    }

    public void setPlanChooseTile(String str) {
        this.planChooseTile = str;
    }

    public void setPlanDetailFreeSpaceTile(String str) {
        this.planDetailFreeSpaceTile = str;
    }

    public void setPlanDetailPaySpaceTile(String str) {
        this.planDetailPaySpaceTile = str;
    }

    public void setPlanDetailTotalSpaceTile(String str) {
        this.planDetailTotalSpaceTile = str;
    }

    public void setPlanDetailUesdSpaceTile(String str) {
        this.planDetailUesdSpaceTile = str;
    }

    public void setPlanTitle(String str) {
        this.planTitle = str;
    }

    public void setPromotionCardTitle(String str) {
        this.promotionCardTitle = str;
    }
}
