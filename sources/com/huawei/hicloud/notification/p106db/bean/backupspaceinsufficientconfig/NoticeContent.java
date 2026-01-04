package com.huawei.hicloud.notification.p106db.bean.backupspaceinsufficientconfig;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class NoticeContent {

    @SerializedName("detailPage")
    private V5DetailPageText detailPage;

    @SerializedName("frontAppText")
    private FrontAppText frontAppText;

    @SerializedName("notice_notification")
    private NoticeContentNoticeNotification noticeNotification;

    @SerializedName("notice_popup")
    private NoticeContentNoticePopup noticePopup;

    @SerializedName("set_notify_popup")
    private NoticeContentSetNotifyPopup setNotifyPopup;

    public V5DetailPageText getDetailPage() {
        return this.detailPage;
    }

    public FrontAppText getFrontAppText() {
        return this.frontAppText;
    }

    public NoticeContentNoticeNotification getNoticeNotification() {
        return this.noticeNotification;
    }

    public NoticeContentNoticePopup getNoticePopup() {
        return this.noticePopup;
    }

    public NoticeContentSetNotifyPopup getSetNotifyPopup() {
        return this.setNotifyPopup;
    }

    public void setDetailPage(V5DetailPageText v5DetailPageText) {
        this.detailPage = v5DetailPageText;
    }

    public void setFrontAppText(FrontAppText frontAppText) {
        this.frontAppText = frontAppText;
    }

    public void setNoticeNotification(NoticeContentNoticeNotification noticeContentNoticeNotification) {
        this.noticeNotification = noticeContentNoticeNotification;
    }

    public void setNoticePopup(NoticeContentNoticePopup noticeContentNoticePopup) {
        this.noticePopup = noticeContentNoticePopup;
    }

    public void setSetNotifyPopup(NoticeContentSetNotifyPopup noticeContentSetNotifyPopup) {
        this.setNotifyPopup = noticeContentSetNotifyPopup;
    }
}
