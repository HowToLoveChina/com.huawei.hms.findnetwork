package com.huawei.hicloud.campaign.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguageDbString;
import com.huawei.hicloud.notification.p106db.bean.CommonPicture;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.List;

/* loaded from: classes6.dex */
public class ThirdAppJumpBean {

    @SerializedName("activityId")
    private String activityId;

    @SerializedName("bannerTitle")
    private List<CommonLanguageDbString> bannerTitle;

    @SerializedName("bannerTitleName")
    private String bannerTitleName;

    @SerializedName(FaqConstants.FAQ_CHANNEL)
    private int channel;

    @SerializedName("deepLink")
    private String deepLink;

    @SerializedName("effectTime")
    private long effectTime;

    @SerializedName("url")
    private List<CommonPicture> pictures;

    public String getActivityId() {
        return this.activityId;
    }

    public List<CommonLanguageDbString> getBannerTitle() {
        return this.bannerTitle;
    }

    public String getBannerTitleName() {
        return this.bannerTitleName;
    }

    public int getChannel() {
        return this.channel;
    }

    public String getDeepLink() {
        return this.deepLink;
    }

    public long getEffectTime() {
        return this.effectTime;
    }

    public List<CommonPicture> getPictures() {
        return this.pictures;
    }

    public void setActivityId(String str) {
        this.activityId = str;
    }

    public void setBannerTitle(List<CommonLanguageDbString> list) {
        this.bannerTitle = list;
    }

    public void setBannerTitleName(String str) {
        this.bannerTitleName = str;
    }

    public void setChannel(int i10) {
        this.channel = i10;
    }

    public void setDeepLink(String str) {
        this.deepLink = str;
    }

    public void setEffectTime(long j10) {
        this.effectTime = j10;
    }

    public void setPictures(List<CommonPicture> list) {
        this.pictures = list;
    }
}
