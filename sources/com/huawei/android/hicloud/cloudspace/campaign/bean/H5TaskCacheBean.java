package com.huawei.android.hicloud.cloudspace.campaign.bean;

import java.security.SecureRandom;

/* loaded from: classes2.dex */
public class H5TaskCacheBean {
    private String activityId;
    private String app;

    /* renamed from: id */
    private String f11831id = getRandomRequestId();
    private String modifyTime;
    private String questId;
    private String questType;
    private Integer service;
    private String sessionId;
    private long startTime;
    private String tag;

    public String getActivityId() {
        return this.activityId;
    }

    public String getApp() {
        return this.app;
    }

    public String getId() {
        return this.f11831id;
    }

    public String getModifyTime() {
        return this.modifyTime;
    }

    public String getQuestId() {
        return this.questId;
    }

    public String getQuestType() {
        return this.questType;
    }

    public String getRandomRequestId() {
        return System.currentTimeMillis() + "" + new SecureRandom().nextInt(10000);
    }

    public Integer getService() {
        return this.service;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public String getTag() {
        return this.tag;
    }

    public void setActivityId(String str) {
        this.activityId = str;
    }

    public void setApp(String str) {
        this.app = str;
    }

    public void setId(String str) {
        this.f11831id = str;
    }

    public void setModifyTime(String str) {
        this.modifyTime = str;
    }

    public void setQuestId(String str) {
        this.questId = str;
    }

    public void setQuestType(String str) {
        this.questType = str;
    }

    public void setService(Integer num) {
        this.service = num;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setStartTime(long j10) {
        this.startTime = j10;
    }

    public void setTag(String str) {
        this.tag = str;
    }
}
