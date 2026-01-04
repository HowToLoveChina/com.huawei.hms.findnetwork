package com.huawei.hicloud.notification.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.p106db.bean.ConfigPictureParam;
import java.util.List;

/* loaded from: classes6.dex */
public class BannerConfigObject {

    @SerializedName("banner_id")
    private String bannerID;

    @SerializedName("banner_name")
    private String bannerName;
    private String beginTime;
    private String endTime;
    private String localPicturePath;

    @SerializedName("goto")
    private BannerGoto mGoto;
    private float percentage = -1.0f;

    @SerializedName("banner_picture")
    private String picture;
    private String pictureId;

    @SerializedName("banner_pictures")
    private ConfigPictureParam[] pictures;
    private int priority;

    @SerializedName("userGroupExtIDs")
    private List<String> userGroupExtIDs;

    public String getBannerID() {
        return this.bannerID;
    }

    public String getBannerName() {
        return this.bannerName;
    }

    public String getBeginTime() {
        return this.beginTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public String getLocalPicturePath() {
        return this.localPicturePath;
    }

    public float getPercentage() {
        return this.percentage;
    }

    public String getPicture() {
        return this.picture;
    }

    public String getPictureId() {
        return this.pictureId;
    }

    public ConfigPictureParam[] getPictures() {
        ConfigPictureParam[] configPictureParamArr = this.pictures;
        return configPictureParamArr != null ? (ConfigPictureParam[]) configPictureParamArr.clone() : new ConfigPictureParam[0];
    }

    public int getPriority() {
        return this.priority;
    }

    public List<String> getUserGroupExtIDs() {
        return this.userGroupExtIDs;
    }

    public BannerGoto getmGoto() {
        return this.mGoto;
    }

    public void setBannerID(String str) {
        this.bannerID = str;
    }

    public void setBannerName(String str) {
        this.bannerName = str;
    }

    public void setBeginTime(String str) {
        this.beginTime = str;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setLocalPicturePath(String str) {
        this.localPicturePath = str;
    }

    public void setPercentage(float f10) {
        this.percentage = f10;
    }

    public void setPicture(String str) {
        this.picture = str;
    }

    public void setPictureId(String str) {
        this.pictureId = str;
    }

    public void setPictures(ConfigPictureParam[] configPictureParamArr) {
        if (configPictureParamArr != null) {
            this.pictures = (ConfigPictureParam[]) configPictureParamArr.clone();
        } else {
            this.pictures = null;
        }
    }

    public void setPriority(int i10) {
        this.priority = i10;
    }

    public void setUserGroupExtIDs(List<String> list) {
        this.userGroupExtIDs = list;
    }

    public void setmGoto(BannerGoto bannerGoto) {
        this.mGoto = bannerGoto;
    }
}
