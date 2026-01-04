package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.constants.BannerPictureType;
import com.huawei.hicloud.notification.constants.CardEntrance;

/* loaded from: classes6.dex */
public class BaseCardBean {

    @SerializedName(alternate = {"syncButton"}, value = "button")
    private String button;

    @SerializedName(alternate = {"syncButton1201"}, value = "button1201")
    private String button1201;

    @SerializedName(alternate = {"syncDescription"}, value = "description")
    private String description;

    @SerializedName(alternate = {"syncDescription1201"}, value = "description1201")
    private String description1201;

    @SerializedName(alternate = {"syncNotifyBarDescription"}, value = "notifyBarDescription")
    private String notifyBarDescription;

    @SerializedName(alternate = {"syncNotifyBarTitle"}, value = "notifyBarTitle")
    private String notifyBarTitle;

    @SerializedName(alternate = {"syncGoto"}, value = "goto")
    private NotifyTypeAndUriGoto notifyTypeAndUriGoto;

    @SerializedName(alternate = {"syncPictures"}, value = "pictures")
    private CommonPicture[] pictures;

    @SerializedName(alternate = {"syncPicturesSecond"}, value = "picturesSecond")
    private CommonPicture[] picturesSecond;

    @SerializedName(alternate = {"fmRVersions"}, value = "rVersions")
    private RomVersion[] rVersions;

    @SerializedName(alternate = {"syncRemark"}, value = "remark")
    private String remark;

    @SerializedName(alternate = {"syncRemark1201"}, value = "remark1201")
    private String remark1201;

    @SerializedName(alternate = {"syncTitle"}, value = "title")
    private String title;

    @SerializedName(alternate = {"syncTitle1201"}, value = "title1201")
    private String title1201;

    public String getButton() {
        return this.button;
    }

    public String getButton1201() {
        return this.button1201;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDescription1201() {
        return this.description1201;
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

    public CommonPicture getPicture(CardEntrance cardEntrance, BannerPictureType bannerPictureType) {
        CommonPicture[] commonPictureArr;
        if (CardEntrance.HOMEPAGE == cardEntrance && (commonPictureArr = this.picturesSecond) != null && commonPictureArr.length > 0) {
            return commonPictureArr[0];
        }
        CommonPicture[] commonPictureArr2 = this.pictures;
        if (commonPictureArr2 == null || commonPictureArr2.length < 2) {
            return null;
        }
        return BannerPictureType.PHONE_PORTRAIT == bannerPictureType ? commonPictureArr2[0] : commonPictureArr2[1];
    }

    public CommonPicture[] getPictures() {
        return this.pictures;
    }

    public CommonPicture[] getPicturesSecond() {
        return this.picturesSecond;
    }

    public String getRemark() {
        return this.remark;
    }

    public String getRemark1201() {
        return this.remark1201;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTitle1201() {
        return this.title1201;
    }

    public RomVersion[] getrVersions() {
        return this.rVersions;
    }

    public void setButton(String str) {
        this.button = str;
    }

    public void setButton1201(String str) {
        this.button1201 = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setDescription1201(String str) {
        this.description1201 = str;
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

    public void setPictures(CommonPicture[] commonPictureArr) {
        this.pictures = commonPictureArr;
    }

    public void setPicturesSecond(CommonPicture[] commonPictureArr) {
        this.picturesSecond = commonPictureArr;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setRemark1201(String str) {
        this.remark1201 = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTitle1201(String str) {
        this.title1201 = str;
    }

    public void setrVersions(RomVersion[] romVersionArr) {
        this.rVersions = romVersionArr;
    }
}
