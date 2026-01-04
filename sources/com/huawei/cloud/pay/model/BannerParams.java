package com.huawei.cloud.pay.model;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes5.dex */
public class BannerParams {

    @SerializedName("banner_name")
    private String bannerName;

    @SerializedName("banner_picture")
    private String bannerPicture;
    private String beginTime;
    private String endTime;
    private String hash;
    private BannerLinkType link;
    private String priority;

    public String getBannerName() {
        return this.bannerName;
    }

    public String getBannerPicture() {
        return this.bannerPicture;
    }

    public String getBeginTime() {
        return this.beginTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public String getHash() {
        return this.hash;
    }

    public BannerLinkType getLink() {
        return this.link;
    }

    public String getPriority() {
        return this.priority;
    }

    public void setBannerName(String str) {
        this.bannerName = str;
    }

    public void setBannerPicture(String str) {
        this.bannerPicture = str;
    }

    public void setBeginTime(String str) {
        this.beginTime = str;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setHash(String str) {
        this.hash = str;
    }

    public void setLink(BannerLinkType bannerLinkType) {
        this.link = bannerLinkType;
    }

    public void setPriority(String str) {
        this.priority = str;
    }
}
