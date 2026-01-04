package com.huawei.hicloud.notification.bean;

import android.app.PendingIntent;
import android.text.TextUtils;

/* loaded from: classes6.dex */
public class NotifyMessageButtonData {
    private PendingIntent firstBtnIntent;
    private String firstButtonText;
    private PendingIntent secondBtnIntent;
    private String secondButtonText;

    public boolean checkBtnIntegrity(String str, PendingIntent pendingIntent) {
        return (TextUtils.isEmpty(str) || pendingIntent == null) ? false : true;
    }

    public PendingIntent getFirstBtnIntent() {
        return this.firstBtnIntent;
    }

    public String getFirstButtonText() {
        return this.firstButtonText;
    }

    public PendingIntent getSecondBtnIntent() {
        return this.secondBtnIntent;
    }

    public String getSecondButtonText() {
        return this.secondButtonText;
    }

    public void setFirstBtnIntent(PendingIntent pendingIntent) {
        this.firstBtnIntent = pendingIntent;
    }

    public void setFirstButtonText(String str) {
        this.firstButtonText = str;
    }

    public void setSecondBtnIntent(PendingIntent pendingIntent) {
        this.secondBtnIntent = pendingIntent;
    }

    public void setSecondButtonText(String str) {
        this.secondButtonText = str;
    }
}
