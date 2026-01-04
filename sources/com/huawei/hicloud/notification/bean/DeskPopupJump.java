package com.huawei.hicloud.notification.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import java.io.Serializable;

/* loaded from: classes6.dex */
public class DeskPopupJump implements Serializable {
    private static final long serialVersionUID = -6505354211916356501L;

    @SerializedName("notifyKey")
    private String notifyKey;

    @SerializedName(NotifyConstants.Keys.NOTIFY_TYPE)
    private String notifyType;

    @SerializedName(NotifyConstants.Keys.NOTIFY_URI)
    private String notifyUri;

    public String getNotifyKey() {
        return this.notifyKey;
    }

    public String getNotifyType() {
        return this.notifyType;
    }

    public String getNotifyUri() {
        return this.notifyUri;
    }

    public void setNotifyKey(String str) {
        this.notifyKey = str;
    }

    public void setNotifyType(String str) {
        this.notifyType = str;
    }

    public void setNotifyUri(String str) {
        this.notifyUri = str;
    }
}
