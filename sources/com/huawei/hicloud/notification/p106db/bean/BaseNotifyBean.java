package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.bean.NotifyWay;
import com.huawei.hicloud.bean.SilenceDurationBean;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import java.util.List;

/* loaded from: classes6.dex */
public class BaseNotifyBean {

    @SerializedName("detail_goto")
    protected List<NoticeDetailGoto> detailGoto;

    @SerializedName("dayonce")
    protected float frequency;

    /* renamed from: id */
    protected int f22640id;

    @SerializedName(NotifyConstants.NotificationReport.KEY_NOTICE_TYPE)
    protected String noticeType;
    protected int priority;
    protected NoticeRange range;

    @SerializedName("remind_purposes")
    protected List<String> remindPurposes;

    @SerializedName("remind_ways")
    protected List<NotifyWay> remindWays;

    @SerializedName("silence_period")
    protected List<SilenceDurationBean> silencePeriod;
    protected int topupPackage;

    @SerializedName("userGroupExtIDs")
    protected List<String> userGroupExtIDs;
    protected float percentage = -1.0f;

    @SerializedName("frequency_step")
    protected int frequencyStep = 10;

    @SerializedName("frequency_limit")
    protected int frequencyLimit = NotifyConstants.NegFeedback.DEFAULT_LIMIT;

    public List<NoticeDetailGoto> getDetailGoto() {
        return this.detailGoto;
    }

    public float getFrequency() {
        return this.frequency;
    }

    public int getFrequencyLimit() {
        return this.frequencyLimit;
    }

    public int getFrequencyStep() {
        return this.frequencyStep;
    }

    public int getId() {
        return this.f22640id;
    }

    public String getNoticeType() {
        return this.noticeType;
    }

    public float getPercentage() {
        return this.percentage;
    }

    public int getPriority() {
        return this.priority;
    }

    public NoticeRange getRange() {
        return this.range;
    }

    public List<String> getRemindPurposes() {
        return this.remindPurposes;
    }

    public List<NotifyWay> getRemindWays() {
        return this.remindWays;
    }

    public List<SilenceDurationBean> getSilencePeriod() {
        return this.silencePeriod;
    }

    public int getTopupPackage() {
        return this.topupPackage;
    }

    public List<String> getUserGroupExtIDs() {
        return this.userGroupExtIDs;
    }

    public void setDetailGoto(List<NoticeDetailGoto> list) {
        this.detailGoto = list;
    }

    public void setFrequency(float f10) {
        this.frequency = f10;
    }

    public void setFrequencyLimit(int i10) {
        this.frequencyLimit = i10;
    }

    public void setFrequencyStep(int i10) {
        this.frequencyStep = i10;
    }

    public void setId(int i10) {
        this.f22640id = i10;
    }

    public void setNoticeType(String str) {
        this.noticeType = str;
    }

    public void setPercentage(float f10) {
        this.percentage = f10;
    }

    public void setPriority(int i10) {
        this.priority = i10;
    }

    public void setRange(NoticeRange noticeRange) {
        this.range = noticeRange;
    }

    public void setRemindPurposes(List<String> list) {
        this.remindPurposes = list;
    }

    public void setRemindWays(List<NotifyWay> list) {
        this.remindWays = list;
    }

    public void setSilencePeriod(List<SilenceDurationBean> list) {
        this.silencePeriod = list;
    }

    public void setTopupPackage(int i10) {
        this.topupPackage = i10;
    }

    public void setUserGroupExtIDs(List<String> list) {
        this.userGroupExtIDs = list;
    }
}
