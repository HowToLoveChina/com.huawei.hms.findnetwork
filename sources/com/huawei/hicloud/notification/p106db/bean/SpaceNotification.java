package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: classes6.dex */
public class SpaceNotification extends BaseSpaceNotifyBean {

    @SerializedName("backup_goto")
    private List<NoticeBackUpSuccessGoto> backupGoto;

    @SerializedName("checkMinutes")
    private int checkMinutes;

    @SerializedName("frequencyTimes")
    private int frequencyTimes;

    @SerializedName("gotoDeeplinkUri")
    private String gotoDeeplinkUri;

    @SerializedName("grade_package_detail")
    private JsonObject gradePackageDetail;

    @SerializedName("helpUrl")
    private String helpUrl;

    @SerializedName("notice_detail")
    private List<NoticeDetail> noticeDetail;

    @SerializedName("notice_detail_member")
    private List<NoticeDetail> noticeDetailMember;

    @SerializedName("spaceType")
    private int spaceType;

    @SerializedName("tipPeriod")
    private String tipPeriod;

    @SerializedName("unClearMonths")
    private int unClearMonths;

    public List<NoticeBackUpSuccessGoto> getBackupGoto() {
        return this.backupGoto;
    }

    public int getCheckMinutes() {
        return this.checkMinutes;
    }

    public int getFrequencyTimes() {
        return this.frequencyTimes;
    }

    public String getGotoDeeplinkUri() {
        return this.gotoDeeplinkUri;
    }

    public JsonObject getGradePackageDetail() {
        return this.gradePackageDetail;
    }

    public String getHelpUrl() {
        return this.helpUrl;
    }

    public List<NoticeDetail> getNoticeDetail() {
        return this.noticeDetail;
    }

    public List<NoticeDetail> getNoticeDetailMember() {
        return this.noticeDetailMember;
    }

    public int getSpaceType() {
        return this.spaceType;
    }

    public String getTipPeriod() {
        return this.tipPeriod;
    }

    public int getUnClearMonths() {
        return this.unClearMonths;
    }

    public void setBackupGoto(List<NoticeBackUpSuccessGoto> list) {
        this.backupGoto = list;
    }

    public void setCheckMinutes(int i10) {
        this.checkMinutes = i10;
    }

    public void setFrequencyTimes(int i10) {
        this.frequencyTimes = i10;
    }

    public void setGotoDeeplinkUri(String str) {
        this.gotoDeeplinkUri = str;
    }

    public void setGradePackageDetail(JsonObject jsonObject) {
        this.gradePackageDetail = jsonObject;
    }

    public void setHelpUrl(String str) {
        this.helpUrl = str;
    }

    public void setNoticeDetail(List<NoticeDetail> list) {
        this.noticeDetail = list;
    }

    public void setNoticeDetailMember(List<NoticeDetail> list) {
        this.noticeDetailMember = list;
    }

    public void setSpaceType(int i10) {
        this.spaceType = i10;
    }

    public void setTipPeriod(String str) {
        this.tipPeriod = str;
    }

    public void setUnClearMonths(int i10) {
        this.unClearMonths = i10;
    }
}
