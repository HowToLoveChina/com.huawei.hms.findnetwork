package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.util.NotifyUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class NoticeContent {
    private static final String TAG = "NoticeContent";

    @SerializedName("autofree_main_text")
    private String autoFreeMainText;

    @SerializedName("autofree_title")
    private String autoFreeTitle;

    @SerializedName("autopay_main_text")
    private String autoPayMainText;

    @SerializedName("autopay_title")
    private String autoPayTitle;

    @SerializedName(NotifyConstants.H5BackupNotEnoughNoticeKey.BACKUP_COUPON_V4_MAIN_TEXT)
    private String backupCouponV4PopupMainText;

    @SerializedName(NotifyConstants.H5BackupNotEnoughNoticeKey.BACKUP_COUPON_V4_POPUP_TITLE)
    private String backupCouponV4PopupTitle;

    @SerializedName(NotifyConstants.H5BackupNotEnoughNoticeKey.BACKUP_V4_MAIN_TEXT)
    private String backupV4MainText;

    @SerializedName(NotifyConstants.H5BackupNotEnoughNoticeKey.BACKUP_V4_POP_TITLE)
    private String backupV4PopTitle;

    @SerializedName(NotifyConstants.H5BackupNotEnoughNoticeKey.BACKUP_V5_MAIN_TEXT)
    private String backupV5MainText;

    @SerializedName(NotifyConstants.H5BackupNotEnoughNoticeKey.BACKUP_V5_POP_TITLE)
    private String backupV5PopTitle;

    @SerializedName(NotifyConstants.POP_GOTO_BUTTON_FIRST)
    private String buttonFirst;

    @SerializedName(NotifyConstants.POP_GOTO_BUTTON_SECOND)
    private String buttonSecond;

    @SerializedName(NotifyConstants.POP_GOTO_BUTTON_THIRD)
    private String buttonThird;

    @SerializedName("closedata_main_text")
    private String closeDataMainText;
    private String description;

    @SerializedName("description_second")
    private String descriptionSecond;

    @SerializedName("detail_link")
    private LinkedHashMap<String, String> detailLink;

    @SerializedName("first_month_main_text")
    private String firstMonthMainText;

    @SerializedName("first_month_main_text_second")
    private String firstMonthMainTextSecond;

    @SerializedName("handfree_main_text")
    private String handFreeMainText;

    @SerializedName("handfree_title")
    private String handFreeTitle;

    @SerializedName("handpay_main_text")
    private String handPayMainText;

    @SerializedName("handpay_title")
    private String handPayTitle;
    private String language;

    @SerializedName(NotifyUtil.MAIN_TEXT_TYPE_DEFAULT)
    private String mainText;

    @SerializedName("main_text_second")
    private String mainTextSecond;

    @SerializedName("noti_description")
    private String notiDescription;

    @SerializedName(NotifyUtil.MAIN_TEXT_TYPE_NOTI)
    private String notiMainText;

    @SerializedName(NotifyUtil.TITLE_TYPE_NOTI)
    private String notiTitle;

    @SerializedName("opendata_main_text")
    private String openDataMainText;

    @SerializedName("package_upgarde2t_main_text")
    private String package2TButtonFirst;

    @SerializedName("package_2t_description")
    private String package2TDescription;

    @SerializedName("package_increment2t_main_text")
    private String package2TMainText;

    @SerializedName("package_2t_first_month_text")
    private String package2tFirstMonthText;

    @SerializedName("package_2t_title")
    private String package2tTitle;

    @SerializedName("package_2t_unfirst_month_text")
    private String package2tUnFirstMonthText;

    @SerializedName("package_button_first")
    private String packageButtonFirst;

    @SerializedName("package_description")
    private String packageDescription;

    @SerializedName("package_main_text")
    private String packageMainText;

    @SerializedName("package_un2t_first_month_text")
    private String packageUn2tFirstMonthText;

    @SerializedName("package_un2t_title")
    private String packageUn2tTitle;

    @SerializedName("package_un2t_unfirst_month_text")
    private String packageUn2tUnfirstMonthText;

    @SerializedName("package_50g_main_text_second")
    private String packageV1MainTextSecond;

    @SerializedName("package_200g_main_text_second")
    private String packageV2MainTextSecond;

    @SerializedName("package_2t_main_text_second")
    private String packageV3MainTextSecond;

    @SerializedName("pay_main_text")
    private String payMainText;

    @SerializedName("popup_button_first")
    private String popupButtonFirst;

    @SerializedName("popup_button_second")
    private String popupButtonSecond;

    @SerializedName("popup_main_text")
    private String popupMainText;

    @SerializedName("popup_title")
    private String popupTitle;

    @SerializedName("purchase_package_button_first")
    private String purchasePackageButtonFirst;

    @SerializedName("purchase_package_button_second")
    private String purchasePackageButtonSecond;

    @SerializedName("purchase_package_description")
    private String purchasePackageDescription;

    @SerializedName("purchase_package_description_second")
    private String purchasePackageDescriptionSecond;

    @SerializedName("purchase_package_main_text")
    private String purchasePackageMainText;

    @SerializedName("purchase_package_main_text_second")
    private String purchasePackageMainTextSecond;

    @SerializedName("remind_mode")
    private String remindMode;

    @SerializedName("sub_title")
    private String subTitle;
    private String title;

    @SerializedName("title2")
    private String title2;

    @SerializedName(NotifyUtil.MAIN_TEXT_TYPE_V3)
    private String v3MainText;

    @SerializedName(NotifyUtil.MAIN_TEXT_V4)
    private String v4MainText;

    @SerializedName(NotifyUtil.TITLE_V4)
    private String v4Title;

    public String getAutoFreeMainText() {
        return this.autoFreeMainText;
    }

    public String getAutoFreeTitle() {
        return this.autoFreeTitle;
    }

    public String getAutoPayMainText() {
        return this.autoPayMainText;
    }

    public String getAutoPayTitle() {
        return this.autoPayTitle;
    }

    public String getBackupCouponV4PopupMainText() {
        return this.backupCouponV4PopupMainText;
    }

    public String getBackupCouponV4PopupTitle() {
        return this.backupCouponV4PopupTitle;
    }

    public String getBackupV4MainText() {
        return this.backupV4MainText;
    }

    public String getBackupV4PopTitle() {
        return this.backupV4PopTitle;
    }

    public String getBackupV5MainText() {
        return this.backupV5MainText;
    }

    public String getBackupV5PopTitle() {
        return this.backupV5PopTitle;
    }

    public String getButtonFirst() {
        return this.buttonFirst;
    }

    public String getButtonSecond() {
        return this.buttonSecond;
    }

    public String getButtonThird() {
        return this.buttonThird;
    }

    public String getCloseDataMainText() {
        return this.closeDataMainText;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDescriptionSecond() {
        return this.descriptionSecond;
    }

    public LinkedHashMap<String, String> getDetailLink() {
        return this.detailLink;
    }

    public String getDetailLinkStr() throws JSONException {
        if (this.detailLink == null) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : this.detailLink.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            return jSONObject.toString();
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "getDetailLinkStr exception:" + e10.toString());
            return "";
        }
    }

    public String getFirstMonthMainText() {
        return this.firstMonthMainText;
    }

    public String getFirstMonthMainTextSecond() {
        return this.firstMonthMainTextSecond;
    }

    public String getHandFreeMainText() {
        return this.handFreeMainText;
    }

    public String getHandFreeTitle() {
        return this.handFreeTitle;
    }

    public String getHandPayMainText() {
        return this.handPayMainText;
    }

    public String getHandPayTitle() {
        return this.handPayTitle;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getMainText() {
        return this.mainText;
    }

    public String getMainTextSecond() {
        return this.mainTextSecond;
    }

    public String getNotiDescription() {
        return this.notiDescription;
    }

    public String getNotiMainText() {
        return this.notiMainText;
    }

    public String getNotiTitle() {
        return this.notiTitle;
    }

    public String getOpenDataMainText() {
        return this.openDataMainText;
    }

    public String getPackage2TButtonFirst() {
        return this.package2TButtonFirst;
    }

    public String getPackage2TDescription() {
        return this.package2TDescription;
    }

    public String getPackage2TMainText() {
        return this.package2TMainText;
    }

    public String getPackage2tFirstMonthText() {
        return this.package2tFirstMonthText;
    }

    public String getPackage2tTitle() {
        return this.package2tTitle;
    }

    public String getPackage2tUnFirstMonthText() {
        return this.package2tUnFirstMonthText;
    }

    public String getPackageButtonFirst() {
        return this.packageButtonFirst;
    }

    public String getPackageDescription() {
        return this.packageDescription;
    }

    public String getPackageMainText() {
        return this.packageMainText;
    }

    public String getPackageUn2tFirstMonthText() {
        return this.packageUn2tFirstMonthText;
    }

    public String getPackageUn2tTitle() {
        return this.packageUn2tTitle;
    }

    public String getPackageUn2tUnfirstMonthText() {
        return this.packageUn2tUnfirstMonthText;
    }

    public String getPackageV1MainTextSecond() {
        return this.packageV1MainTextSecond;
    }

    public String getPackageV2MainTextSecond() {
        return this.packageV2MainTextSecond;
    }

    public String getPackageV3MainTextSecond() {
        return this.packageV3MainTextSecond;
    }

    public String getPayMainText() {
        return this.payMainText;
    }

    public String getPopupButtonFirst() {
        return this.popupButtonFirst;
    }

    public String getPopupButtonSecond() {
        return this.popupButtonSecond;
    }

    public String getPopupMainText() {
        return this.popupMainText;
    }

    public String getPopupTitle() {
        return this.popupTitle;
    }

    public String getPurchasePackageButtonFirst() {
        return this.purchasePackageButtonFirst;
    }

    public String getPurchasePackageButtonSecond() {
        return this.purchasePackageButtonSecond;
    }

    public String getPurchasePackageDescription() {
        return this.purchasePackageDescription;
    }

    public String getPurchasePackageDescriptionSecond() {
        return this.purchasePackageDescriptionSecond;
    }

    public String getPurchasePackageMainText() {
        return this.purchasePackageMainText;
    }

    public String getPurchasePackageMainTextSecond() {
        return this.purchasePackageMainTextSecond;
    }

    public String getRemindMode() {
        return this.remindMode;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTitle2() {
        return this.title2;
    }

    public String getV3MainText() {
        return this.v3MainText;
    }

    public String getV4MainText() {
        return this.v4MainText;
    }

    public String getV4Title() {
        return this.v4Title;
    }

    public void setAutoFreeMainText(String str) {
        this.autoFreeMainText = str;
    }

    public void setAutoFreeTitle(String str) {
        this.autoFreeTitle = str;
    }

    public void setAutoPayMainText(String str) {
        this.autoPayMainText = str;
    }

    public void setAutoPayTitle(String str) {
        this.autoPayTitle = str;
    }

    public void setBackupCouponV4PopupMainText(String str) {
        this.backupCouponV4PopupMainText = str;
    }

    public void setBackupCouponV4PopupTitle(String str) {
        this.backupCouponV4PopupTitle = str;
    }

    public void setBackupV4MainText(String str) {
        this.backupV4MainText = str;
    }

    public void setBackupV4PopTitle(String str) {
        this.backupV4PopTitle = str;
    }

    public void setBackupV5MainText(String str) {
        this.backupV5MainText = str;
    }

    public void setBackupV5PopTitle(String str) {
        this.backupV5PopTitle = str;
    }

    public void setButtonFirst(String str) {
        this.buttonFirst = str;
    }

    public void setButtonSecond(String str) {
        this.buttonSecond = str;
    }

    public void setButtonThird(String str) {
        this.buttonThird = str;
    }

    public void setCloseDataMainText(String str) {
        this.closeDataMainText = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setDescriptionSecond(String str) {
        this.descriptionSecond = str;
    }

    public void setDetailLink(LinkedHashMap<String, String> linkedHashMap) {
        this.detailLink = linkedHashMap;
    }

    public void setFirstMonthMainText(String str) {
        this.firstMonthMainText = str;
    }

    public void setFirstMonthMainTextSecond(String str) {
        this.firstMonthMainTextSecond = str;
    }

    public void setHandFreeMainText(String str) {
        this.handFreeMainText = str;
    }

    public void setHandFreeTitle(String str) {
        this.handFreeTitle = str;
    }

    public void setHandPayMainText(String str) {
        this.handPayMainText = str;
    }

    public void setHandPayTitle(String str) {
        this.handPayTitle = str;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setMainText(String str) {
        this.mainText = str;
    }

    public void setMainTextSecond(String str) {
        this.mainTextSecond = str;
    }

    public void setNotiDescription(String str) {
        this.notiDescription = str;
    }

    public void setNotiMainText(String str) {
        this.notiMainText = str;
    }

    public void setNotiTitle(String str) {
        this.notiTitle = str;
    }

    public void setOpenDataMainText(String str) {
        this.openDataMainText = str;
    }

    public void setPackage2TButtonFirst(String str) {
        this.package2TButtonFirst = str;
    }

    public void setPackage2TDescription(String str) {
        this.package2TDescription = str;
    }

    public void setPackage2TMainText(String str) {
        this.package2TMainText = str;
    }

    public void setPackage2tFirstMonthText(String str) {
        this.package2tFirstMonthText = str;
    }

    public void setPackage2tTitle(String str) {
        this.package2tTitle = str;
    }

    public void setPackage2tUnFirstMonthText(String str) {
        this.package2tUnFirstMonthText = str;
    }

    public void setPackageButtonFirst(String str) {
        this.packageButtonFirst = str;
    }

    public void setPackageDescription(String str) {
        this.packageDescription = str;
    }

    public void setPackageMainText(String str) {
        this.packageMainText = str;
    }

    public void setPackageUn2tFirstMonthText(String str) {
        this.packageUn2tFirstMonthText = str;
    }

    public void setPackageUn2tTitle(String str) {
        this.packageUn2tTitle = str;
    }

    public void setPackageUn2tUnfirstMonthText(String str) {
        this.packageUn2tUnfirstMonthText = str;
    }

    public void setPackageV1MainTextSecond(String str) {
        this.packageV1MainTextSecond = str;
    }

    public void setPackageV2MainTextSecond(String str) {
        this.packageV2MainTextSecond = str;
    }

    public void setPackageV3MainTextSecond(String str) {
        this.packageV3MainTextSecond = str;
    }

    public void setPayMainText(String str) {
        this.payMainText = str;
    }

    public void setPopupButtonFirst(String str) {
        this.popupButtonFirst = str;
    }

    public void setPopupButtonSecond(String str) {
        this.popupButtonSecond = str;
    }

    public void setPopupMainText(String str) {
        this.popupMainText = str;
    }

    public void setPopupTitle(String str) {
        this.popupTitle = str;
    }

    public void setPurchasePackageButtonFirst(String str) {
        this.purchasePackageButtonFirst = str;
    }

    public void setPurchasePackageButtonSecond(String str) {
        this.purchasePackageButtonSecond = str;
    }

    public void setPurchasePackageDescription(String str) {
        this.purchasePackageDescription = str;
    }

    public void setPurchasePackageDescriptionSecond(String str) {
        this.purchasePackageDescriptionSecond = str;
    }

    public void setPurchasePackageMainText(String str) {
        this.purchasePackageMainText = str;
    }

    public void setPurchasePackageMainTextSecond(String str) {
        this.purchasePackageMainTextSecond = str;
    }

    public void setRemindMode(String str) {
        this.remindMode = str;
    }

    public void setSubTitle(String str) {
        this.subTitle = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTitle2(String str) {
        this.title2 = str;
    }

    public void setV3MainText(String str) {
        this.v3MainText = str;
    }

    public void setV4MainText(String str) {
        this.v4MainText = str;
    }

    public void setV4Title(String str) {
        this.v4Title = str;
    }
}
