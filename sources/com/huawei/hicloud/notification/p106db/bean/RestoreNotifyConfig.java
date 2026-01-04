package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.bean.SyncConfigLanguage;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class RestoreNotifyConfig {
    private String endTime;
    private String firstTrigAfter;
    private String hoursAfterOOBE;

    /* renamed from: id */
    private String f22659id;

    @SerializedName("notice_content")
    RestoreNotifyContent noticeContent;

    @SerializedName(NotifyConstants.NotificationReport.KEY_NOTICE_TYPE)
    private String noticeType;
    private String priority;
    private String startTime;

    @SerializedName("login_state")
    private String state;
    private String timesInHours;
    private RestoreValidDuration validDuration = new RestoreValidDuration();
    private SyncConfigLanguage language = new SyncConfigLanguage();
    private List<String> relaseDevice = new ArrayList();

    public String getEndTime() {
        return this.endTime;
    }

    public String getEndTimeOfDruation() {
        return this.validDuration.getEndTime();
    }

    public String getFirstTrigAfter() {
        return this.firstTrigAfter;
    }

    public String getHoursAfterOOBE() {
        return this.hoursAfterOOBE;
    }

    public String getId() {
        return this.f22659id;
    }

    public SyncConfigLanguage getLanguage() {
        return this.language;
    }

    public String getLoginState() {
        return this.state;
    }

    public RestoreNotifyContent getNoticeContent() {
        return this.noticeContent;
    }

    public String getNoticeType() {
        return this.noticeType;
    }

    public String getPriority() {
        return this.priority;
    }

    public List<String> getRelaseDevice() {
        return this.relaseDevice;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public String getStartTimeOfDruation() {
        return this.validDuration.getStartTime();
    }

    public String getTimesInHours() {
        return this.timesInHours;
    }

    public RestoreValidDuration getvalidDuration() {
        return this.validDuration;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setFirstTrigAfter(String str) {
        this.firstTrigAfter = str;
    }

    public void setHoursAfterOOBE(String str) {
        this.hoursAfterOOBE = str;
    }

    public void setId(String str) {
        this.f22659id = str;
    }

    public void setNoticeType(String str) {
        this.noticeType = str;
    }

    public void setPriority(String str) {
        this.priority = str;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setTimesInHours(String str) {
        this.timesInHours = str;
    }
}
