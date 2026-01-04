package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.constants.NotifyConstants;

/* loaded from: classes6.dex */
public class NotifyTypeAndUriGoto {

    @SerializedName(NotifyConstants.Keys.NOTIFY_TYPE)
    private String notifyType;

    @SerializedName(NotifyConstants.Keys.NOTIFY_URI)
    private String notifyUri;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NotifyTypeAndUriGoto)) {
            return false;
        }
        NotifyTypeAndUriGoto notifyTypeAndUriGoto = (NotifyTypeAndUriGoto) obj;
        if (RecommendCard.textEquals(this.notifyType, notifyTypeAndUriGoto.notifyType)) {
            return RecommendCard.textEquals(this.notifyUri, notifyTypeAndUriGoto.notifyUri);
        }
        return false;
    }

    public String getNotifyType() {
        return this.notifyType;
    }

    public String getNotifyUri() {
        return this.notifyUri;
    }

    public int hashCode() {
        String str = this.notifyType;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.notifyUri;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public void setNotifyType(String str) {
        this.notifyType = str;
    }

    public void setNotifyUri(String str) {
        this.notifyUri = str;
    }
}
