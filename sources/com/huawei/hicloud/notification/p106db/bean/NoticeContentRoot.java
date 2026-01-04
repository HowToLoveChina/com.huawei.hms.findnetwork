package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class NoticeContentRoot {
    private static final String TAG = "NoticeContentRoot";

    @SerializedName("notice_activity_popup")
    private NoticeActivityPopUp noticeActivityPopup;

    @SerializedName("notice_content")
    private NoticeContent noticeContent;

    @SerializedName("notice_coupon")
    private NoticeContent noticeCoupon;

    @SerializedName("notice_detail")
    private NoticeDetail noticeDetail;

    @SerializedName("notice_detail2")
    private NoticeDetail noticeDetail2;

    @SerializedName("notice_detail_member")
    private NoticeDetail noticeDetailMember;

    @SerializedName("notice_notification")
    private NoticeContent noticeNotification;

    @SerializedName("notice_popup")
    private NoticeContent noticePopup;

    public NoticeActivityPopUp getNoticeActivityPopup() {
        return this.noticeActivityPopup;
    }

    public NoticeContent getNoticeContent() {
        return this.noticeContent;
    }

    public NoticeContent getNoticeCoupon() {
        return this.noticeCoupon;
    }

    public NoticeDetail getNoticeDetail() {
        return this.noticeDetail;
    }

    public NoticeDetail getNoticeDetail2() {
        return this.noticeDetail2;
    }

    public NoticeDetail getNoticeDetailMember() {
        return this.noticeDetailMember;
    }

    public NoticeContent getNoticeNotification() {
        return this.noticeNotification;
    }

    public NoticeContent getNoticePopup() {
        return this.noticePopup;
    }

    public void setNoticeActivityPopup(NoticeActivityPopUp noticeActivityPopUp) {
        this.noticeActivityPopup = noticeActivityPopUp;
    }

    public void setNoticeContent(NoticeContent noticeContent) {
        this.noticeContent = noticeContent;
    }

    public void setNoticeCoupon(NoticeContent noticeContent) {
        this.noticeCoupon = noticeContent;
    }

    public void setNoticeDetail(NoticeDetail noticeDetail) {
        this.noticeDetail = noticeDetail;
    }

    public void setNoticeDetail2(NoticeDetail noticeDetail) {
        this.noticeDetail2 = noticeDetail;
    }

    public void setNoticeDetailMember(NoticeDetail noticeDetail) {
        this.noticeDetailMember = noticeDetail;
    }

    public void setNoticeNotification(NoticeContent noticeContent) {
        this.noticeNotification = noticeContent;
    }

    public void setNoticePopup(NoticeContent noticeContent) {
        this.noticePopup = noticeContent;
    }
}
