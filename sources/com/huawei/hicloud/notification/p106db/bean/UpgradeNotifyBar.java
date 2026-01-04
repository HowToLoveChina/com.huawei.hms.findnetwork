package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.bean.NotifyJumpInfo;

/* loaded from: classes6.dex */
public class UpgradeNotifyBar {

    @SerializedName("dayonce")
    private int dayonce;

    @SerializedName("notifyBarText")
    private String notifyBarText;

    @SerializedName("notifyBarTitle")
    private String notifyBarTitle;

    @SerializedName("goto")
    private NotifyJumpInfo notifyJumpInfo;

    @SerializedName("number")
    private int number;

    public int getDayonce() {
        return this.dayonce;
    }

    public String getNotifyBarText() {
        return this.notifyBarText;
    }

    public String getNotifyBarTitle() {
        return this.notifyBarTitle;
    }

    public NotifyJumpInfo getNotifyJumpInfo() {
        return this.notifyJumpInfo;
    }

    public int getNumber() {
        return this.number;
    }

    public void setDayonce(int i10) {
        this.dayonce = i10;
    }

    public void setNotifyBarText(String str) {
        this.notifyBarText = str;
    }

    public void setNotifyBarTitle(String str) {
        this.notifyBarTitle = str;
    }

    public void setNotifyJumpInfo(NotifyJumpInfo notifyJumpInfo) {
        this.notifyJumpInfo = notifyJumpInfo;
    }

    public void setNumber(int i10) {
        this.number = i10;
    }
}
