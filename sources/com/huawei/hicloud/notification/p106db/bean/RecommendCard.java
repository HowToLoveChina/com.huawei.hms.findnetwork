package com.huawei.hicloud.notification.p106db.bean;

import android.text.TextUtils;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.RecommendCardManager;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes6.dex */
public class RecommendCard {
    public static final String TAG = "RecommendCard";
    private String activityId;
    private String activityType;

    /* renamed from: ad */
    private INativeAd f22657ad;
    private String advertId;
    private String button;
    private int cardRefresh;
    private int cardRefreshMod;
    private String description;
    private String descriptionEndLink;
    private String[] devConditions;
    private String entrance;
    private boolean fixed;
    private String galleryReleaseActivityType;
    private String landscapePicturePath;
    private boolean notifyBar;
    private String notifyBarDescription;
    private String notifyBarTitle;
    private NotifyTypeAndUriGoto notifyTypeAndUriGoto;
    private String pictureSecondPath;
    private String portraitPicturePath;
    private int priority;
    private String remark;
    private NotifyTypeAndUriGoto textLinkGoto;
    private String title;

    public static boolean textEquals(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return true;
        }
        return Objects.equals(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecommendCard)) {
            return false;
        }
        RecommendCard recommendCard = (RecommendCard) obj;
        if (this.priority == recommendCard.priority && this.fixed == recommendCard.fixed && this.notifyBar == recommendCard.notifyBar && this.cardRefresh == recommendCard.cardRefresh && this.cardRefreshMod == recommendCard.cardRefreshMod && textEquals(this.landscapePicturePath, recommendCard.landscapePicturePath) && textEquals(this.portraitPicturePath, recommendCard.portraitPicturePath) && textEquals(this.title, recommendCard.title) && textEquals(this.remark, recommendCard.remark) && textEquals(this.button, recommendCard.button) && Objects.equals(this.notifyTypeAndUriGoto, recommendCard.notifyTypeAndUriGoto) && textEquals(this.activityId, recommendCard.activityId) && textEquals(this.activityType, recommendCard.activityType) && textEquals(this.galleryReleaseActivityType, recommendCard.galleryReleaseActivityType) && textEquals(this.description, recommendCard.description) && textEquals(this.descriptionEndLink, recommendCard.descriptionEndLink) && textEquals(this.notifyBarTitle, recommendCard.notifyBarTitle) && textEquals(this.notifyBarDescription, recommendCard.notifyBarDescription) && textEquals(this.entrance, recommendCard.entrance) && textEquals(this.advertId, recommendCard.advertId) && Objects.equals(this.f22657ad, recommendCard.f22657ad) && textEquals(this.pictureSecondPath, recommendCard.pictureSecondPath) && Objects.equals(this.textLinkGoto, recommendCard.textLinkGoto)) {
            return Arrays.equals(this.devConditions, recommendCard.devConditions);
        }
        return false;
    }

    public String getActivityId() {
        return this.activityId;
    }

    public String getActivityType() {
        return this.activityType;
    }

    public INativeAd getAd() {
        return this.f22657ad;
    }

    public String getAdvertId() {
        return this.advertId;
    }

    public String getButton() {
        return this.button;
    }

    public int getCardRefresh() {
        return this.cardRefresh;
    }

    public int getCardRefreshMod() {
        return this.cardRefreshMod;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDescriptionEndLink() {
        return this.descriptionEndLink;
    }

    public String[] getDevConditions() {
        return this.devConditions;
    }

    public String getEntrance() {
        return this.entrance;
    }

    public String getGalleryReleaseActivityType() {
        return this.galleryReleaseActivityType;
    }

    public String getLandscapePicturePath() {
        return this.landscapePicturePath;
    }

    public String getNotifyBarDescription() {
        return this.notifyBarDescription;
    }

    public String getNotifyBarTitle() {
        return this.notifyBarTitle;
    }

    public NotifyTypeAndUriGoto getNotifyTypeAndUriGoto() {
        return this.notifyTypeAndUriGoto;
    }

    public String getPictureSecondPath() {
        return this.pictureSecondPath;
    }

    public String getPortraitPicturePath() {
        return this.portraitPicturePath;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getRemark() {
        return this.remark;
    }

    public NotifyTypeAndUriGoto getTextLinkGoto() {
        return this.textLinkGoto;
    }

    public String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.landscapePicturePath;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.portraitPicturePath;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.title;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.remark;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.button;
        int iHashCode5 = (iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        NotifyTypeAndUriGoto notifyTypeAndUriGoto = this.notifyTypeAndUriGoto;
        int iHashCode6 = (((((iHashCode5 + (notifyTypeAndUriGoto != null ? notifyTypeAndUriGoto.hashCode() : 0)) * 31) + this.priority) * 31) + (this.fixed ? 1 : 0)) * 31;
        String str6 = this.activityId;
        int iHashCode7 = (iHashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.activityType;
        int iHashCode8 = (iHashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.galleryReleaseActivityType;
        int iHashCode9 = (((((iHashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31) + (this.notifyBar ? 1 : 0)) * 31) + this.cardRefresh) * 31;
        String str9 = this.description;
        int iHashCode10 = (iHashCode9 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.descriptionEndLink;
        int iHashCode11 = (iHashCode10 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.notifyBarTitle;
        int iHashCode12 = (iHashCode11 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.notifyBarDescription;
        int iHashCode13 = (iHashCode12 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.entrance;
        int iHashCode14 = (iHashCode13 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.advertId;
        int iHashCode15 = (iHashCode14 + (str14 != null ? str14.hashCode() : 0)) * 31;
        INativeAd iNativeAd = this.f22657ad;
        int iHashCode16 = (((iHashCode15 + (iNativeAd != null ? iNativeAd.hashCode() : 0)) * 31) + this.cardRefreshMod) * 31;
        String str15 = this.pictureSecondPath;
        int iHashCode17 = (iHashCode16 + (str15 != null ? str15.hashCode() : 0)) * 31;
        NotifyTypeAndUriGoto notifyTypeAndUriGoto2 = this.textLinkGoto;
        return ((iHashCode17 + (notifyTypeAndUriGoto2 != null ? notifyTypeAndUriGoto2.hashCode() : 0)) * 31) + Arrays.hashCode(this.devConditions);
    }

    public boolean isFixed() {
        return this.fixed;
    }

    public boolean isNotifyBar() {
        return this.notifyBar;
    }

    public boolean isValid() {
        if (StringUtil.equals(this.entrance, RecommendCardConstants.Entrance.HOMEPAGE)) {
            if (TextUtils.isEmpty(this.pictureSecondPath) || TextUtils.isEmpty(this.remark)) {
                NotifyLogger.m29916w(TAG, "pictureSecondPath is empty: " + TextUtils.isEmpty(this.pictureSecondPath));
                return false;
            }
            if (!RecommendCardManager.getInstance().isPictureToBitmapSuccess(this.pictureSecondPath)) {
                return false;
            }
        }
        if (!StringUtil.equals(this.entrance, RecommendCardConstants.Entrance.BUY)) {
            return true;
        }
        if (!TextUtils.isEmpty(this.portraitPicturePath) && !TextUtils.isEmpty(this.landscapePicturePath)) {
            return RecommendCardManager.getInstance().isPictureToBitmapSuccess(this.portraitPicturePath) && RecommendCardManager.getInstance().isPictureToBitmapSuccess(this.landscapePicturePath);
        }
        NotifyLogger.m29916w(TAG, "portraitPicturePath is empty: " + TextUtils.isEmpty(this.portraitPicturePath));
        return false;
    }

    public void setActivityId(String str) {
        this.activityId = str;
    }

    public void setActivityType(String str) {
        this.activityType = str;
    }

    public void setAd(INativeAd iNativeAd) {
        this.f22657ad = iNativeAd;
    }

    public void setAdvertId(String str) {
        this.advertId = str;
    }

    public void setButton(String str) {
        this.button = str;
    }

    public void setCardRefresh(int i10) {
        this.cardRefresh = i10;
    }

    public void setCardRefreshMod(int i10) {
        this.cardRefreshMod = i10;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setDescriptionEndLink(String str) {
        this.descriptionEndLink = str;
    }

    public void setDevConditions(String[] strArr) {
        this.devConditions = strArr;
    }

    public void setEntrance(String str) {
        this.entrance = str;
    }

    public void setFixed(boolean z10) {
        this.fixed = z10;
    }

    public void setGalleryReleaseActivityType(String str) {
        this.galleryReleaseActivityType = str;
    }

    public void setLandscapePicturePath(String str) {
        this.landscapePicturePath = str;
    }

    public void setNotifyBar(boolean z10) {
        this.notifyBar = z10;
    }

    public void setNotifyBarDescription(String str) {
        this.notifyBarDescription = str;
    }

    public void setNotifyBarTitle(String str) {
        this.notifyBarTitle = str;
    }

    public void setNotifyTypeAndUriGoto(NotifyTypeAndUriGoto notifyTypeAndUriGoto) {
        this.notifyTypeAndUriGoto = notifyTypeAndUriGoto;
    }

    public void setPictureSecondPath(String str) {
        this.pictureSecondPath = str;
    }

    public void setPortraitPicturePath(String str) {
        this.portraitPicturePath = str;
    }

    public void setPriority(int i10) {
        this.priority = i10;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setTextLinkGoto(NotifyTypeAndUriGoto notifyTypeAndUriGoto) {
        this.textLinkGoto = notifyTypeAndUriGoto;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
