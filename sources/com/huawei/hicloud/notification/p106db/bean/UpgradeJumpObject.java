package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes6.dex */
public class UpgradeJumpObject implements Serializable {
    private static final long serialVersionUID = 1;

    @SerializedName("type")
    private String type;

    @SerializedName("url")
    private String url;

    public String getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
