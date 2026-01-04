package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class ClearOverMonths {

    @SerializedName("activityId")
    private String activityId;

    @SerializedName("activityType")
    private String activityType;

    @SerializedName("basicConfig")
    private BasicConfig basicConfig;

    @SerializedName("button")
    private String button;

    @SerializedName("description")
    private String description;

    @SerializedName("gradePackages")
    private GradePackage[] gradePackages;

    @SerializedName("notifyBarDescription")
    private String notifyBarDescription;

    @SerializedName("notifyBarTitle")
    private String notifyBarTitle;

    @SerializedName("goto")
    private NotifyTypeAndUriGoto notifyTypeAndUriGoto;

    @SerializedName("pictures")
    private CommonPicture[] pictures;

    @SerializedName("picturesSecond")
    private CommonPicture[] picturesSecond;

    @SerializedName("remark")
    private String remark;

    @SerializedName("title")
    private String title;

    @SerializedName("unClearMonths")
    private int unClearMonths;

    public String getActivityId() {
        return this.activityId;
    }

    public String getActivityType() {
        return this.activityType;
    }

    public BasicConfig getBasicConfig() {
        return this.basicConfig;
    }

    public String getButton() {
        return this.button;
    }

    public String getDescription() {
        return this.description;
    }

    public GradePackage[] getGradePackages() {
        return this.gradePackages;
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

    public CommonPicture[] getPictures() {
        return this.pictures;
    }

    public CommonPicture[] getPicturesSecond() {
        return this.picturesSecond;
    }

    public String getRemark() {
        return this.remark;
    }

    public String getTitle() {
        return this.title;
    }

    public int getUnClearMonths() {
        return this.unClearMonths;
    }

    public void setActivityId(String str) {
        this.activityId = str;
    }

    public void setActivityType(String str) {
        this.activityType = str;
    }

    public void setBasicConfig(BasicConfig basicConfig) {
        this.basicConfig = basicConfig;
    }

    public void setButton(String str) {
        this.button = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setGradePackages(GradePackage[] gradePackageArr) {
        this.gradePackages = gradePackageArr;
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

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUnClearMonths(int i10) {
        this.unClearMonths = i10;
    }
}
