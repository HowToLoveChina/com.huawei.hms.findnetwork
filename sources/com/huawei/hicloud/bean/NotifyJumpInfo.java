package com.huawei.hicloud.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import java.io.Serializable;

/* loaded from: classes6.dex */
public class NotifyJumpInfo implements Serializable {
    private static final long serialVersionUID = 1;

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
