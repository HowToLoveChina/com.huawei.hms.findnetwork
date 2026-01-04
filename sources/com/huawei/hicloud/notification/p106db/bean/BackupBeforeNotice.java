package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.bean.SilenceDurationBean;
import java.util.List;

/* loaded from: classes6.dex */
public class BackupBeforeNotice {

    @SerializedName("dayonce")
    private float dayOnce;

    @SerializedName("gradeCode")
    private List<String> gradeCode;

    /* renamed from: id */
    @SerializedName("id")
    private String f22639id;

    @SerializedName("goto")
    private BackupBeforeNoticeGoto noticeGoto;

    @SerializedName("percentage")
    private int percentage;

    @SerializedName("priority")
    private int priority;

    @SerializedName("remindPurposes")
    private List<String> remindPurposes;

    @SerializedName("remindWays")
    private List<String> remindWays;

    @SerializedName("silencePeriod")
    private List<SilenceDurationBean> silencePeriod;

    @SerializedName("spaceLess")
    private String spaceLess;

    @SerializedName("text")
    private String text;

    @SerializedName("title")
    private String title;

    @SerializedName("userGroupExtIDs")
    private List<String> userGroupExtIDs;

    public float getDayOnce() {
        return this.dayOnce;
    }

    public List<String> getGradeCode() {
        return this.gradeCode;
    }

    public String getId() {
        return this.f22639id;
    }

    public BackupBeforeNoticeGoto getNoticeGoto() {
        return this.noticeGoto;
    }

    public int getPercentage() {
        return this.percentage;
    }

    public int getPriority() {
        return this.priority;
    }

    public List<String> getRemindPurposes() {
        return this.remindPurposes;
    }

    public List<String> getRemindWays() {
        return this.remindWays;
    }

    public List<SilenceDurationBean> getSilencePeriod() {
        return this.silencePeriod;
    }

    public String getSpaceLess() {
        return this.spaceLess;
    }

    public String getText() {
        return this.text;
    }

    public String getTitle() {
        return this.title;
    }

    public List<String> getUserGroupExtIDs() {
        return this.userGroupExtIDs;
    }

    public void setDayOnce(float f10) {
        this.dayOnce = f10;
    }

    public void setGradeCode(List<String> list) {
        this.gradeCode = list;
    }

    public void setId(String str) {
        this.f22639id = str;
    }

    public void setNoticeGoto(BackupBeforeNoticeGoto backupBeforeNoticeGoto) {
        this.noticeGoto = backupBeforeNoticeGoto;
    }

    public void setPercentage(int i10) {
        this.percentage = i10;
    }

    public void setPriority(int i10) {
        this.priority = i10;
    }

    public void setRemindPurposes(List<String> list) {
        this.remindPurposes = list;
    }

    public void setRemindWays(List<String> list) {
        this.remindWays = list;
    }

    public void setSilencePeriod(List<SilenceDurationBean> list) {
        this.silencePeriod = list;
    }

    public void setSpaceLess(String str) {
        this.spaceLess = str;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUserGroupExtIDs(List<String> list) {
        this.userGroupExtIDs = list;
    }
}
