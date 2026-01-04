package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.constants.HNConstants;
import java.util.List;

/* loaded from: classes6.dex */
public class BaseSpaceNotifyBean extends BaseNotifyBean {

    @SerializedName("activityEntry")
    protected NotifyActivityEntry activityEntry;

    @SerializedName("activity_goto")
    private List<NoticeDetailGoto> activityGoto;

    @SerializedName(HNConstants.C4906BI.KEY_OF_ACTIVITY_TYPE)
    private int activityType;

    @SerializedName("coupon_dayonce")
    protected float couponFrequency;

    @SerializedName("detail_text_goto")
    private List<NoticeDetailTextGoto> detailTextGoto;

    @SerializedName("enableActivityEntry2")
    protected int enableActivityEntry;

    @SerializedName("enableFrontApp")
    protected int enableFrontApp;
    protected int enableNewCard;

    @SerializedName("enableRecomPackages")
    protected int enableRecomPackages;

    @SerializedName("enableShowCoupon")
    protected int enableShowCoupon;

    @SerializedName("frontAppStyle")
    protected String frontAppStyle;

    @SerializedName("isDisplayBackedUpData")
    protected int isDisplayBackUpData;
    protected CommonLanguage language;

    @SerializedName("mark_content_detail")
    protected DialogMarkInfo markContentInfo;

    @SerializedName("noti_goto")
    private NoticeWithActivityGoto notiGoto;

    @SerializedName("notice_content_root")
    protected NoticeContentRoot noticeContent;

    @SerializedName("notice_content_default")
    protected NoticeContentRoot noticeContentDefault;

    @SerializedName("goto")
    private NoticeGoto noticeGoto;

    @SerializedName("popup_goto2")
    private List<PopUpWithActivityGoto> popupGoto;

    @SerializedName("popup_goto3")
    private List<PopUpWithActivityGoto> popupGoto3;

    @SerializedName("purchase_package_goto")
    private List<PopUpWithActivityGoto> purchasePackageGoto;

    @SerializedName("recommendation_detail")
    protected RecommendTipInfo recommendDetail;

    @SerializedName("recommendation_detail1")
    protected RecommendTipInfo recommendDetail1;

    @SerializedName("recommendation_detail2")
    protected RecommendTipInfo recommendDetail2;

    @SerializedName("recommendation_detail3")
    protected RecommendTipInfo recommendDetail3;

    @SerializedName("remind_modes")
    protected List<String> remindModes;

    @SerializedName("gradeCode")
    protected List<String> supportGradeCodes;

    public NotifyActivityEntry getActivityEntry() {
        return this.activityEntry;
    }

    public List<NoticeDetailGoto> getActivityGoto() {
        return this.activityGoto;
    }

    public int getActivityType() {
        return this.activityType;
    }

    public float getCouponFrequency() {
        return this.couponFrequency;
    }

    public List<NoticeDetailTextGoto> getDetailTextGoto() {
        return this.detailTextGoto;
    }

    public int getEnableActivityEntry() {
        return this.enableActivityEntry;
    }

    public int getEnableFrontApp() {
        return this.enableFrontApp;
    }

    public int getEnableNewCard() {
        return this.enableNewCard;
    }

    public int getEnableRecomPackages() {
        return this.enableRecomPackages;
    }

    public int getEnableShowCoupon() {
        return this.enableShowCoupon;
    }

    public String getFrontAppStyle() {
        return this.frontAppStyle;
    }

    public int getIsDisplayBackUpData() {
        return this.isDisplayBackUpData;
    }

    public CommonLanguage getLanguage() {
        return this.language;
    }

    public DialogMarkInfo getMarkContentInfo() {
        return this.markContentInfo;
    }

    public NoticeWithActivityGoto getNotiGoto() {
        return this.notiGoto;
    }

    public NoticeContentRoot getNoticeContent() {
        return this.noticeContent;
    }

    public NoticeContentRoot getNoticeContentDefault() {
        return this.noticeContentDefault;
    }

    public NoticeGoto getNoticeGoto() {
        return this.noticeGoto;
    }

    public List<PopUpWithActivityGoto> getPopupGoto() {
        return this.popupGoto;
    }

    public List<PopUpWithActivityGoto> getPopupGoto3() {
        return this.popupGoto3;
    }

    public List<PopUpWithActivityGoto> getPopupeGoto() {
        return this.popupGoto;
    }

    public List<PopUpWithActivityGoto> getPurchasePackageGoto() {
        return this.purchasePackageGoto;
    }

    public RecommendTipInfo getRecommendDetail() {
        return this.recommendDetail;
    }

    public RecommendTipInfo getRecommendDetail1() {
        return this.recommendDetail1;
    }

    public RecommendTipInfo getRecommendDetail2() {
        return this.recommendDetail2;
    }

    public RecommendTipInfo getRecommendDetail3() {
        return this.recommendDetail3;
    }

    public List<String> getRemindModes() {
        return this.remindModes;
    }

    public List<String> getSupportGradeCodes() {
        return this.supportGradeCodes;
    }

    public void setActivityEntry(NotifyActivityEntry notifyActivityEntry) {
        this.activityEntry = notifyActivityEntry;
    }

    public void setActivityGoto(List<NoticeDetailGoto> list) {
        this.activityGoto = list;
    }

    public void setActivityType(int i10) {
        this.activityType = i10;
    }

    public void setCouponFrequency(float f10) {
        this.couponFrequency = f10;
    }

    public void setDetailTextGoto(List<NoticeDetailTextGoto> list) {
        this.detailTextGoto = list;
    }

    public void setEnableActivityEntry(int i10) {
        this.enableActivityEntry = i10;
    }

    public void setEnableFrontApp(int i10) {
        this.enableFrontApp = i10;
    }

    public void setEnableNewCard(int i10) {
        this.enableNewCard = i10;
    }

    public void setEnableRecomPackages(int i10) {
        this.enableRecomPackages = i10;
    }

    public void setEnableShowCoupon(int i10) {
        this.enableShowCoupon = i10;
    }

    public void setFrontAppStyle(String str) {
        this.frontAppStyle = str;
    }

    public void setIsDisplayBackUpData(int i10) {
        this.isDisplayBackUpData = i10;
    }

    public void setLanguage(CommonLanguage commonLanguage) {
        this.language = commonLanguage;
    }

    public void setMarkContentInfo(DialogMarkInfo dialogMarkInfo) {
        this.markContentInfo = dialogMarkInfo;
    }

    public void setNotiGoto(NoticeWithActivityGoto noticeWithActivityGoto) {
        this.notiGoto = noticeWithActivityGoto;
    }

    public void setNoticeContent(NoticeContentRoot noticeContentRoot) {
        this.noticeContent = noticeContentRoot;
    }

    public void setNoticeContentDefault(NoticeContentRoot noticeContentRoot) {
        this.noticeContentDefault = noticeContentRoot;
    }

    public void setNoticeGoto(NoticeGoto noticeGoto) {
        this.noticeGoto = noticeGoto;
    }

    public void setPopupGoto(List<PopUpWithActivityGoto> list) {
        this.popupGoto = list;
    }

    public void setPopupGoto3(List<PopUpWithActivityGoto> list) {
        this.popupGoto3 = list;
    }

    public void setPopupeGoto(List<PopUpWithActivityGoto> list) {
        this.popupGoto = list;
    }

    public void setPurchasePackageGoto(List<PopUpWithActivityGoto> list) {
        this.purchasePackageGoto = list;
    }

    public void setRecommendDetail(RecommendTipInfo recommendTipInfo) {
        this.recommendDetail = recommendTipInfo;
    }

    public void setRecommendDetail1(RecommendTipInfo recommendTipInfo) {
        this.recommendDetail1 = recommendTipInfo;
    }

    public void setRecommendDetail2(RecommendTipInfo recommendTipInfo) {
        this.recommendDetail2 = recommendTipInfo;
    }

    public void setRecommendDetail3(RecommendTipInfo recommendTipInfo) {
        this.recommendDetail3 = recommendTipInfo;
    }

    public void setRemindModes(List<String> list) {
        this.remindModes = list;
    }

    public void setSupportGradeCodes(List<String> list) {
        this.supportGradeCodes = list;
    }
}
