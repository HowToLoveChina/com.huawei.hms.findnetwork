package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.List;

/* loaded from: classes6.dex */
public class ForceUpgradeConfiguration {

    @SerializedName("expireTime")
    private String expireTime;

    @SerializedName("forceUpgrade")
    private int forceUpgrade;

    @SerializedName(RecommendCardConstants.Entrance.HOMEPAGE)
    private UpgradeHomePageBar homePage;

    /* renamed from: id */
    @SerializedName("id")
    private int f22644id;

    @SerializedName(FaqConstants.FAQ_EMUI_LANGUAGE)
    private CommonLanguage language;

    @SerializedName("newVerRange")
    private HiCloudVerRange newVerRange;

    @SerializedName("notifyBar")
    private UpgradeNotifyBar notifyBar;

    @SerializedName("oldVerRange")
    private HiCloudVerRange oldVerRange;

    @SerializedName("percentage")
    private int percentage;

    @SerializedName("publishTime")
    private String publishTime;

    @SerializedName("remindWays")
    private String[] remindWays;

    @SerializedName("serverErrorCode")
    private String serverErrorCode;

    @SerializedName("userGroupExtIDs")
    private List<String> userGroupExtIDs;

    public String getExpireTime() {
        return this.expireTime;
    }

    public int getForceUpgrade() {
        return this.forceUpgrade;
    }

    public UpgradeHomePageBar getHomePage() {
        return this.homePage;
    }

    public int getId() {
        return this.f22644id;
    }

    public CommonLanguage getLanguage() {
        return this.language;
    }

    public HiCloudVerRange getNewVerRange() {
        return this.newVerRange;
    }

    public UpgradeNotifyBar getNotifyBar() {
        return this.notifyBar;
    }

    public HiCloudVerRange getOldVerRange() {
        return this.oldVerRange;
    }

    public int getPercentage() {
        return this.percentage;
    }

    public String getPublishTime() {
        return this.publishTime;
    }

    public String[] getRemindWays() {
        return this.remindWays;
    }

    public String getServerErrorCode() {
        return this.serverErrorCode;
    }

    public List<String> getUserGroupExtIDs() {
        return this.userGroupExtIDs;
    }

    public void setExpireTime(String str) {
        this.expireTime = str;
    }

    public void setForceUpgrade(int i10) {
        this.forceUpgrade = i10;
    }

    public void setHomePage(UpgradeHomePageBar upgradeHomePageBar) {
        this.homePage = upgradeHomePageBar;
    }

    public void setId(int i10) {
        this.f22644id = i10;
    }

    public void setLanguage(CommonLanguage commonLanguage) {
        this.language = commonLanguage;
    }

    public void setNewVerRange(HiCloudVerRange hiCloudVerRange) {
        this.newVerRange = hiCloudVerRange;
    }

    public void setNotifyBar(UpgradeNotifyBar upgradeNotifyBar) {
        this.notifyBar = upgradeNotifyBar;
    }

    public void setOldVerRange(HiCloudVerRange hiCloudVerRange) {
        this.oldVerRange = hiCloudVerRange;
    }

    public void setPercentage(int i10) {
        this.percentage = i10;
    }

    public void setPublishTime(String str) {
        this.publishTime = str;
    }

    public void setRemindWays(String[] strArr) {
        this.remindWays = strArr;
    }

    public void setServerErrorCode(String str) {
        this.serverErrorCode = str;
    }

    public void setUserGroupExtIDs(List<String> list) {
        this.userGroupExtIDs = list;
    }
}
