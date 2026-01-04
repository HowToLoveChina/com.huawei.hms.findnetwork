package com.huawei.cloud.pay.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public class GetClientUIConfigResp implements Serializable {
    private static final Map<Integer, String> DURATION_UNIT_MAP = new HashMap<Integer, String>() { // from class: com.huawei.cloud.pay.model.GetClientUIConfigResp.1
        {
            put(1, "day");
            put(2, "month");
            put(3, "year");
        }
    };
    private static final long serialVersionUID = 1;
    private Map<String, String> clientUIMap = new HashMap();

    public String getBannerEntranceTitle() {
        return getMapValue("banner_entrance_title");
    }

    public String getBigBuySmallDialogText() {
        return getMapValue("dialog_fixedduration_upgrade_confirmed").replace("\\n", "\n");
    }

    public String getBuyCardDesc() {
        return getMapValue("fixed_package_entrance_desc");
    }

    public String getBuyCardTitle() {
        return getMapValue("fixed_package_entrance_title");
    }

    public String getCheckDialogRenewAgreement() {
        return getMapValue("check_dialog_user_agreement");
    }

    public Map<String, String> getClientUIMap() {
        return this.clientUIMap;
    }

    public String getContinuousMonthlyPackageDesc() {
        return getMapValue("continuous_monthly_package_desc");
    }

    public String getConvertDialogTitle() {
        return getMapValue("conversion_dialog_title");
    }

    public String getConvertionDialogNewText(int i10) {
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? "" : getMapValue("conversion_dialog_content_5").replace("\\n", "\n") : getMapValue("conversion_dialog_content_4").replace("\\n", "\n") : getMapValue("conversion_dialog_content_3").replace("\\n", "\n") : getMapValue("conversion_dialog_content_2").replace("\\n", "\n") : getMapValue("conversion_dialog_content_1").replace("\\n", "\n");
    }

    public String getDeductionUpgradeDialogText() {
        return getMapValue("dialog_deduction_upgrade_confirmed").replace("\\n", "\n");
    }

    public String getFixedTimePackageDesc(int i10, int i11) {
        return getMapValue("package_desc_fix_" + i10 + "_" + DURATION_UNIT_MAP.get(Integer.valueOf(i11)));
    }

    public String getFixedTimeProductName(int i10, int i11) {
        return getMapValue("durationName_fix_" + i10 + "_" + DURATION_UNIT_MAP.get(Integer.valueOf(i11)));
    }

    public String getMapValue(String str) {
        String str2;
        return (str == null || (str2 = this.clientUIMap.get(str)) == null) ? "" : str2;
    }

    public String getMonthPayPackageDesc(int i10, int i11) {
        return getMapValue("package_desc_con_" + i10 + "_" + DURATION_UNIT_MAP.get(Integer.valueOf(i11)));
    }

    public String getMonthPayProductName(int i10, int i11) {
        return getMapValue("durationName_con_" + i10 + "_" + DURATION_UNIT_MAP.get(Integer.valueOf(i11)));
    }

    public String getNoDeductionUpgradeDialogText() {
        return getMapValue("dialog_nodeduction_upgrade_confirmed").replace("\\n", "\n");
    }

    public String getPackageCardAgreement() {
        return getMapValue("package_card_agree_renew_agreement_1500");
    }

    public String getPetalOneManageTips() {
        return getMapValue("manage_petal_one");
    }

    public String getPetalOneManageTitle() {
        return getMapValue("petal_one_manage_title");
    }

    public String getPetalOneTitle() {
        return getMapValue("petal_one_title");
    }

    public String getPlanChooseDesc() {
        return getMapValue("plan_choose_desc");
    }

    public String getPlanChooseTile() {
        return getMapValue("plan_choose_tile");
    }

    public String getPlanDetailFreeSpaceTile() {
        return getMapValue("plan_detail_free_space_tile");
    }

    public String getPlanDetailPaySpaceTile() {
        return getMapValue("plan_detail_pay_space_tile");
    }

    public String getPlanDetailTotalSpaceTile() {
        return getMapValue("plan_detail_total_space_tile");
    }

    public String getPlanDetailUesdSpaceTile() {
        return getMapValue("plan_detail_uesd_space_tile");
    }

    public String getPlanTitle() {
        return getMapValue("plan_title");
    }

    public String getPriceDescriptionContent() {
        return getMapValue("tariff_desc");
    }

    public String getPriceDescriptionTitle() {
        return getMapValue("tariff_desc_title");
    }

    public String getPromotionCardTitle() {
        return getMapValue("promotion_card_title");
    }

    public String getRecommendBasicPackageRemarak(int i10) {
        if (i10 == 1) {
            return getContinuousMonthlyPackageDesc();
        }
        return getMapValue("continuous_" + i10 + "_month_package_desc");
    }

    public String getRightTitle() {
        return getMapValue("rightTitle");
    }

    public String getTariffDeductionTitle() {
        return getMapValue("tariff_deduction_title");
    }

    public String getUnSubreservedExceed5GB() {
        return getMapValue("unsubreserved_usedspace_exceed5GB");
    }

    public String getUnSubreservedNotExceed5GB() {
        return getMapValue("unsubreserved_usedspace_not_exceed5GB");
    }

    public String getUpgradeDialogNewDefaultText() {
        return getMapValue("dialog_nodeduction_upgrade_confirmed_has_worry_free").replace("\\n", "\n");
    }

    public String getUpgradeDialogNewText(boolean z10) {
        return z10 ? getMapValue("dialog_nodeduction_upgrade_confirmed_only_one_package").replace("\\n", "\n") : getMapValue("dialog_nodeduction_upgrade_confirmed_more_package").replace("\\n", "\n");
    }

    public void setClientUIMap(Map<String, String> map) {
        this.clientUIMap = map;
    }
}
