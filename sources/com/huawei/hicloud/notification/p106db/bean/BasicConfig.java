package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class BasicConfig {

    @SerializedName("cardRefresh")
    private int cardRefresh;

    @SerializedName("notifyBar")
    private int notifyBar;

    @SerializedName("rVersions")
    private RomVersion[] rVersions;

    @SerializedName("redDot")
    private int redDot;

    @SerializedName("userGroupExtIDs")
    private String[] userGroupExtIDs;

    public int getCardRefresh() {
        return this.cardRefresh;
    }

    public String[] getUserGroupExtIDs() {
        return this.userGroupExtIDs;
    }

    public RomVersion[] getrVersions() {
        return this.rVersions;
    }

    public boolean isNotifyBar() {
        return this.notifyBar != 0;
    }

    public boolean isRedDot() {
        return this.redDot != 0;
    }

    public void setCardRefresh(int i10) {
        this.cardRefresh = i10;
    }

    public void setNotifyBar(int i10) {
        this.notifyBar = i10;
    }

    public void setRedDot(int i10) {
        this.redDot = i10;
    }

    public void setUserGroupExtIDs(String[] strArr) {
        this.userGroupExtIDs = strArr;
    }

    public void setrVersions(RomVersion[] romVersionArr) {
        this.rVersions = romVersionArr;
    }
}
