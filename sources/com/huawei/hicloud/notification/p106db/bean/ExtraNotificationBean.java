package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;

/* loaded from: classes6.dex */
public class ExtraNotificationBean extends BaseNotifyBean {

    @SerializedName(FaqConstants.FAQ_CHANNEL)
    private ChannelContent channelContent;

    @SerializedName("everymonth")
    private int monthFrequency;

    @SerializedName("notice_content")
    private NoticeContent noticeContent;

    @SerializedName("notice_content2")
    private NoticeContent noticeContent2;

    @SerializedName("notice_content_default")
    private NoticeContent noticeContentDefault;

    @SerializedName("notice_detail")
    private NoticeDetail noticeDetail;

    @SerializedName("notice_detail_member")
    private NoticeDetail noticeDetailMember;

    @SerializedName("noti_goto")
    private NoticeGoto noticeGoto;

    @SerializedName("unBackupDays")
    private int unBackupDays;

    public ChannelContent getChannelContent() {
        return this.channelContent;
    }

    public int getMonthFrequency() {
        return this.monthFrequency;
    }

    public NoticeContent getNoticeContent() {
        return this.noticeContent;
    }

    public NoticeContent getNoticeContent2() {
        return this.noticeContent2;
    }

    public NoticeContent getNoticeContentDefault() {
        return this.noticeContentDefault;
    }

    public NoticeDetail getNoticeDetail() {
        return this.noticeDetail;
    }

    public NoticeDetail getNoticeDetailMember() {
        return this.noticeDetailMember;
    }

    public NoticeGoto getNoticeGoto() {
        return this.noticeGoto;
    }

    public int getUnBackupDays() {
        return this.unBackupDays;
    }

    public void setChannelContent(ChannelContent channelContent) {
        this.channelContent = channelContent;
    }

    public void setMonthFrequency(int i10) {
        this.monthFrequency = i10;
    }

    public void setNoticeContent(NoticeContent noticeContent) {
        this.noticeContent = noticeContent;
    }

    public void setNoticeContent2(NoticeContent noticeContent) {
        this.noticeContent2 = noticeContent;
    }

    public void setNoticeContentDefault(NoticeContent noticeContent) {
        this.noticeContentDefault = noticeContent;
    }

    public void setNoticeDetail(NoticeDetail noticeDetail) {
        this.noticeDetail = noticeDetail;
    }

    public void setNoticeDetailMember(NoticeDetail noticeDetail) {
        this.noticeDetailMember = noticeDetail;
    }

    public void setNoticeGoto(NoticeGoto noticeGoto) {
        this.noticeGoto = noticeGoto;
    }

    public void setUnBackupDays(int i10) {
        this.unBackupDays = i10;
    }
}
