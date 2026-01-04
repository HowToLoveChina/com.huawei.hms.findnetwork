package com.huawei.hicloud.campaign.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.frequency.FrequencyManager;

/* loaded from: classes6.dex */
public class CampaignActivityConfig {

    @SerializedName("awards")
    private Award[] awards;

    @SerializedName("bannerText")
    private String bannerText;

    @SerializedName(FrequencyManager.H5DialogConstant.BEGIN_TIME)
    private String beginTime;

    @SerializedName("goto")
    private CamJump camJump;

    @SerializedName("endTime")
    private String endTime;

    @SerializedName("enterys")
    private CampaignEntery[] enterys;

    /* renamed from: id */
    @SerializedName("id")
    private String f22237id;

    @SerializedName("msgNotices")
    private String[] msgNotices;

    @SerializedName("quests")
    private Quest[] quests;

    @SerializedName("rVersions")
    private RVersion rVersion;

    @SerializedName("type")
    private String type;

    public Award[] getAwards() {
        return this.awards;
    }

    public String getBannerText() {
        return this.bannerText;
    }

    public String getBeginTime() {
        return this.beginTime;
    }

    public CamJump getCamJump() {
        return this.camJump;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public CampaignEntery[] getEnterys() {
        return this.enterys;
    }

    public String getId() {
        return this.f22237id;
    }

    public String[] getMsgNotices() {
        return this.msgNotices;
    }

    public Quest[] getQuests() {
        return this.quests;
    }

    public String getType() {
        return this.type;
    }

    public RVersion getrVersion() {
        return this.rVersion;
    }

    public void setAwards(Award[] awardArr) {
        this.awards = awardArr;
    }

    public void setBannerText(String str) {
        this.bannerText = str;
    }

    public void setBeginTime(String str) {
        this.beginTime = str;
    }

    public void setCamJump(CamJump camJump) {
        this.camJump = camJump;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setEnterys(CampaignEntery[] campaignEnteryArr) {
        this.enterys = campaignEnteryArr;
    }

    public void setId(String str) {
        this.f22237id = str;
    }

    public void setMsgNotices(String[] strArr) {
        this.msgNotices = strArr;
    }

    public void setQuests(Quest[] questArr) {
        this.quests = questArr;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setrVersion(RVersion rVersion) {
        this.rVersion = rVersion;
    }
}
