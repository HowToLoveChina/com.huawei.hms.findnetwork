package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class NotificationWithActivity extends BaseSpaceNotifyBean {
    private int spaceType = -1;

    @SerializedName("isThreeButtonPopup")
    private int isThreeButtonPopup = -1;

    public int getIsThreeButtonPopup() {
        return this.isThreeButtonPopup;
    }

    public int getSpaceType() {
        return this.spaceType;
    }

    public void setIsThreeButtonPopup(int i10) {
        this.isThreeButtonPopup = i10;
    }

    public void setSpaceType(int i10) {
        this.spaceType = i10;
    }
}
