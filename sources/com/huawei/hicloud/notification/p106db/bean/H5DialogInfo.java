package com.huawei.hicloud.notification.p106db.bean;

/* loaded from: classes6.dex */
public class H5DialogInfo {
    String activeUri;
    String expireTime;
    String gradeCode;
    boolean isEnableJs;
    int notifyAction;
    String notifyType;
    String notifyUri;
    String packageId;
    String url;

    public H5DialogInfo(String str, boolean z10, String str2, String str3, String str4, String str5, int i10, String str6, String str7) {
        this.url = str;
        this.isEnableJs = z10;
        this.notifyType = str2;
        this.notifyUri = str3;
        this.activeUri = str4;
        this.packageId = str5;
        this.notifyAction = i10;
        this.gradeCode = str6;
        this.expireTime = str7;
    }

    public String getActiveUri() {
        return this.activeUri;
    }

    public String getExpireTime() {
        return this.expireTime;
    }

    public String getGradeCode() {
        return this.gradeCode;
    }

    public int getNotifyAction() {
        return this.notifyAction;
    }

    public String getNotifyType() {
        return this.notifyType;
    }

    public String getNotifyUri() {
        return this.notifyUri;
    }

    public String getPackageId() {
        return this.packageId;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isEnableJs() {
        return this.isEnableJs;
    }

    public void setActiveUri(String str) {
        this.activeUri = str;
    }

    public void setEnableJs(boolean z10) {
        this.isEnableJs = z10;
    }

    public void setExpireTime(String str) {
        this.expireTime = str;
    }

    public void setGradeCode(String str) {
        this.gradeCode = str;
    }

    public void setNotifyAction(int i10) {
        this.notifyAction = i10;
    }

    public void setNotifyType(String str) {
        this.notifyType = str;
    }

    public void setNotifyUri(String str) {
        this.notifyUri = str;
    }

    public void setPackageId(String str) {
        this.packageId = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
