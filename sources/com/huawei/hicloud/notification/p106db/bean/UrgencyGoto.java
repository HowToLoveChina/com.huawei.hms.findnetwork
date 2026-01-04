package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.android.backup.service.logic.C2126b;

/* loaded from: classes6.dex */
public class UrgencyGoto {

    @SerializedName("type")
    private String type;

    @SerializedName(C2126b.MODULE_INFO_URI)
    private String uri;

    public String getType() {
        return this.type;
    }

    public String getUri() {
        return this.uri;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUri(String str) {
        this.uri = str;
    }
}
