package com.huawei.cloud.pay.model.reward;

/* loaded from: classes5.dex */
public class Reward {
    private static final int RULE_EXPAND = 1;
    private static final int RULE_FOLD = 0;
    private String activityId;
    private String activityName;
    private String awardId;
    private String awardName;
    private long capacity;
    private long createdTime;
    private int duration;
    private int durationUnit;
    private int expandState = 0;
    private long expirationTime;

    /* renamed from: id */
    private String f21421id;
    private Picture picture;
    private String productId;
    private String promId;
    private String sessionId;
    private int state;
    private Integer supportSub;
    private int type;

    public String getActivityId() {
        return this.activityId;
    }

    public String getActivityName() {
        return this.activityName;
    }

    public String getAwardId() {
        return this.awardId;
    }

    public String getAwardName() {
        return this.awardName;
    }

    public long getCapacity() {
        return this.capacity;
    }

    public long getCreatedTime() {
        return this.createdTime;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getDurationUnit() {
        return this.durationUnit;
    }

    public int getExpandState() {
        return this.expandState;
    }

    public long getExpirationTime() {
        return this.expirationTime;
    }

    public String getId() {
        return this.f21421id;
    }

    public Picture getPicture() {
        return this.picture;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getPromId() {
        return this.promId;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public int getState() {
        return this.state;
    }

    public Integer getSupportSub() {
        return this.supportSub;
    }

    public int getType() {
        return this.type;
    }

    public boolean isSupportSub() {
        Integer num = this.supportSub;
        return num != null && num.intValue() == 1;
    }

    public void reverseExpandState() {
        if (this.expandState == 0) {
            setExpandState(1);
        } else {
            setExpandState(0);
        }
    }

    public void setActivityId(String str) {
        this.activityId = str;
    }

    public void setActivityName(String str) {
        this.activityName = str;
    }

    public void setAwardId(String str) {
        this.awardId = str;
    }

    public void setAwardName(String str) {
        this.awardName = str;
    }

    public void setCapacity(long j10) {
        this.capacity = j10;
    }

    public void setCreatedTime(long j10) {
        this.createdTime = j10;
    }

    public void setDuration(int i10) {
        this.duration = i10;
    }

    public void setDurationUnit(int i10) {
        this.durationUnit = i10;
    }

    public void setExpandState(int i10) {
        this.expandState = i10;
    }

    public void setExpirationTime(long j10) {
        this.expirationTime = j10;
    }

    public void setId(String str) {
        this.f21421id = str;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public void setPromId(String str) {
        this.promId = str;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setState(int i10) {
        this.state = i10;
    }

    public void setSupportSub(Integer num) {
        this.supportSub = num;
    }

    public void setType(int i10) {
        this.type = i10;
    }
}
