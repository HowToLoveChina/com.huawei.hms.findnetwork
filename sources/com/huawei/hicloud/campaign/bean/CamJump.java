package com.huawei.hicloud.campaign.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.constants.NotifyConstants;

/* loaded from: classes6.dex */
public class CamJump {

    @SerializedName(NotifyConstants.Keys.NOTIFY_TYPE)
    private String notifyType;

    @SerializedName(NotifyConstants.Keys.NOTIFY_URI)
    private String notifyUri;

    public String getNotifyType() {
        return this.notifyType;
    }

    public String getNotifyUri() {
        return this.notifyUri;
    }

    public void setNotifyType(String str) {
        this.notifyType = str;
    }

    public void setNotifyUri(String str) {
        this.notifyUri = str;
    }
}
