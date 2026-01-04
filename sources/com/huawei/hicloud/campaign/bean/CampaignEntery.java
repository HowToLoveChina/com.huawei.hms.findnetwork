package com.huawei.hicloud.campaign.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.p106db.bean.CommonPicture;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.List;

/* loaded from: classes6.dex */
public class CampaignEntery {

    @SerializedName(FaqConstants.FAQ_CHANNEL)
    private String channel;

    @SerializedName("homepageBannerButton")
    private String homepageBannerButton;

    @SerializedName("homepageBannerDescription")
    private String homepageBannerDescription;

    @SerializedName("homepageBannerRemark")
    private String homepageBannerRemark;

    @SerializedName("pictures")
    private List<CommonPicture> pictures;

    public String getChannel() {
        return this.channel;
    }

    public String getHomepageBannerButton() {
        return this.homepageBannerButton;
    }

    public String getHomepageBannerDescription() {
        return this.homepageBannerDescription;
    }

    public String getHomepageBannerRemark() {
        return this.homepageBannerRemark;
    }

    public List<CommonPicture> getPictures() {
        return this.pictures;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public void setHomepageBannerButton(String str) {
        this.homepageBannerButton = str;
    }

    public void setHomepageBannerDescription(String str) {
        this.homepageBannerDescription = str;
    }

    public void setHomepageBannerRemark(String str) {
        this.homepageBannerRemark = str;
    }

    public void setPictures(List<CommonPicture> list) {
        this.pictures = list;
    }
}
