package com.huawei.android.hicloud.cloudspace.campaign.bean;

import com.google.gson.JsonObject;
import java.util.List;

/* loaded from: classes2.dex */
public class H5ActivityEntery {
    private String activityId;
    private String beginTime;
    private JsonObject campaignConfig;
    private int channel;
    private List<Integer> channels;
    private List<String> checkedQuests;
    private String endTime;
    private JsonObject entryOriginJson;
    private boolean exceedRedemptionLimit;
    private List<String> quests;
    private int settingStatus;

    public String getActivityId() {
        return this.activityId;
    }

    public String getBeginTime() {
        return this.beginTime;
    }

    public JsonObject getCampaignConfig() {
        return this.campaignConfig;
    }

    public int getChannel() {
        return this.channel;
    }

    public List<Integer> getChannels() {
        return this.channels;
    }

    public List<String> getCheckedQuests() {
        return this.checkedQuests;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public JsonObject getEntryOriginJson() {
        return this.entryOriginJson;
    }

    public boolean getExceedRedemptionLimit() {
        return this.exceedRedemptionLimit;
    }

    public List<String> getQuests() {
        return this.quests;
    }

    public int getSettingStatus() {
        return this.settingStatus;
    }

    public void setActivityId(String str) {
        this.activityId = str;
    }

    public void setBeginTime(String str) {
        this.beginTime = str;
    }

    public void setCampaignConfig(JsonObject jsonObject) {
        this.campaignConfig = jsonObject;
    }

    public void setChannel(int i10) {
        this.channel = i10;
    }

    public void setChannels(List<Integer> list) {
        this.channels = list;
    }

    public void setCheckedQuests(List<String> list) {
        this.checkedQuests = list;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setEntryOriginJson(JsonObject jsonObject) {
        this.entryOriginJson = jsonObject;
    }

    public void setExceedRedemptionLimit(boolean z10) {
        this.exceedRedemptionLimit = z10;
    }

    public void setQuests(List<String> list) {
        this.quests = list;
    }

    public void setSettingStatus(int i10) {
        this.settingStatus = i10;
    }
}
