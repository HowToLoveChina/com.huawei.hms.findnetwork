package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class UrgencyNotification {

    @SerializedName("content")
    private String content;

    @SerializedName("dayonce")
    private float dayonce;

    @SerializedName("times")
    private int times;

    @SerializedName("title")
    private String title;

    /* renamed from: to */
    @SerializedName("goto")
    private UrgencyGoto f22662to;

    public String getContent() {
        return this.content;
    }

    public float getDayonce() {
        return this.dayonce;
    }

    public int getTimes() {
        return this.times;
    }

    public String getTitle() {
        return this.title;
    }

    public UrgencyGoto getTo() {
        return this.f22662to;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setDayonce(float f10) {
        this.dayonce = f10;
    }

    public void setTimes(int i10) {
        this.times = i10;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTo(UrgencyGoto urgencyGoto) {
        this.f22662to = urgencyGoto;
    }
}
