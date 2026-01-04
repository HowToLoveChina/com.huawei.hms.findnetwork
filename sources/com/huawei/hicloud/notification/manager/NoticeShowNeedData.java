package com.huawei.hicloud.notification.manager;

import android.app.PendingIntent;
import android.text.TextUtils;

/* loaded from: classes6.dex */
public class NoticeShowNeedData {
    private PendingIntent cancelPendingIntent;
    private PendingIntent contentPendingIntent;
    private String mainText;
    private String titleText;

    public PendingIntent getCancelPendingIntent() {
        return this.cancelPendingIntent;
    }

    public PendingIntent getContentPendingIntent() {
        return this.contentPendingIntent;
    }

    public String getMainText() {
        return this.mainText;
    }

    public String getTitleText() {
        return this.titleText;
    }

    public boolean isAllMustDataExist() {
        return (TextUtils.isEmpty(this.titleText) || TextUtils.isEmpty(this.mainText) || this.contentPendingIntent == null || this.cancelPendingIntent == null) ? false : true;
    }

    public void setCancelPendingIntent(PendingIntent pendingIntent) {
        this.cancelPendingIntent = pendingIntent;
    }

    public void setContentPendingIntent(PendingIntent pendingIntent) {
        this.contentPendingIntent = pendingIntent;
    }

    public void setMainText(String str) {
        this.mainText = str;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }
}
