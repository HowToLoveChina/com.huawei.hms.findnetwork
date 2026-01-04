package com.huawei.hicloud.bean;

import java.util.List;

/* loaded from: classes6.dex */
public class GetCampaignActivityEntryResp {
    private String activityId;
    private int awardsLimit;
    private List<String> channels;
    private int counter;
    private int displayEntryFlag;
    private String errorCode;
    private boolean exceedRedemptionLimit;
    private boolean noActivitiesAvailable;
    private List<EntryQuestBean> quests;
    private int resultCode;
    private int settingStatus;
    private int showSettingFlag;

    public String getActivityId() {
        return this.activityId;
    }

    public int getAwardsLimit() {
        return this.awardsLimit;
    }

    public List<String> getChannels() {
        return this.channels;
    }

    public int getCounter() {
        return this.counter;
    }

    public int getDisplayEntryFlag() {
        return this.displayEntryFlag;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public List<EntryQuestBean> getQuests() {
        return this.quests;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public int getSettingStatus() {
        return this.settingStatus;
    }

    public int getShowSettingFlag() {
        return this.showSettingFlag;
    }

    public boolean isExceedRedemptionLimit() {
        return this.exceedRedemptionLimit;
    }

    public boolean isNoActivitiesAvailable() {
        return this.noActivitiesAvailable;
    }

    public void setActivityId(String str) {
        this.activityId = str;
    }

    public void setAwardsLimit(int i10) {
        this.awardsLimit = i10;
    }

    public void setChannels(List<String> list) {
        this.channels = list;
    }

    public void setCounter(int i10) {
        this.counter = i10;
    }

    public void setDisplayEntryFlag(int i10) {
        this.displayEntryFlag = i10;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public void setExceedRedemptionLimit(boolean z10) {
        this.exceedRedemptionLimit = z10;
    }

    public void setNoActivitiesAvailable(boolean z10) {
        this.noActivitiesAvailable = z10;
    }

    public void setQuests(List<EntryQuestBean> list) {
        this.quests = list;
    }

    public void setResultCode(int i10) {
        this.resultCode = i10;
    }

    public void setSettingStatus(int i10) {
        this.settingStatus = i10;
    }

    public void setShowSettingFlag(int i10) {
        this.showSettingFlag = i10;
    }
}
