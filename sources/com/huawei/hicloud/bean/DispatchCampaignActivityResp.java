package com.huawei.hicloud.bean;

import java.util.List;

/* loaded from: classes6.dex */
public class DispatchCampaignActivityResp {
    private String activityId;
    private List<DispatchAward> awards;
    private Integer counter;
    private List<DispatchQuest> quests;
    private String sessionId;
    private Integer taskAwards;

    public String getActivityId() {
        return this.activityId;
    }

    public List<DispatchAward> getAwards() {
        return this.awards;
    }

    public Integer getCounter() {
        return this.counter;
    }

    public List<DispatchQuest> getQuests() {
        return this.quests;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public Integer getTaskAwards() {
        return this.taskAwards;
    }

    public void setActivityId(String str) {
        this.activityId = str;
    }

    public void setAwards(List<DispatchAward> list) {
        this.awards = list;
    }

    public void setCounter(Integer num) {
        this.counter = num;
    }

    public void setQuests(List<DispatchQuest> list) {
        this.quests = list;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setTaskAwards(Integer num) {
        this.taskAwards = num;
    }
}
