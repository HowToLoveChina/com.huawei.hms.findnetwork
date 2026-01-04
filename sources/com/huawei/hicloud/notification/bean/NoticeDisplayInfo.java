package com.huawei.hicloud.notification.bean;

/* loaded from: classes6.dex */
public class NoticeDisplayInfo {
    private String gradeCode;
    private boolean isVoucherNotice;
    private String noticeMainText;
    private String noticeTitle;
    private long packageCapacity;
    private String packageId;

    public String getGradeCode() {
        return this.gradeCode;
    }

    public String getNoticeMainText() {
        return this.noticeMainText;
    }

    public String getNoticeTitle() {
        return this.noticeTitle;
    }

    public long getPackageCapacity() {
        return this.packageCapacity;
    }

    public String getPackageId() {
        return this.packageId;
    }

    public boolean isVoucherNotice() {
        return this.isVoucherNotice;
    }

    public void setGradeCode(String str) {
        this.gradeCode = str;
    }

    public void setIsVoucherNotice(boolean z10) {
        this.isVoucherNotice = z10;
    }

    public void setNoticeMainText(String str) {
        this.noticeMainText = str;
    }

    public void setNoticeTitle(String str) {
        this.noticeTitle = str;
    }

    public void setPackageCapacity(long j10) {
        this.packageCapacity = j10;
    }

    public void setPackageId(String str) {
        this.packageId = str;
    }
}
