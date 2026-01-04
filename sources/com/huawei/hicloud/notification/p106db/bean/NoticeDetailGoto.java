package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.config.BaseGoto;
import java.io.Serializable;

/* loaded from: classes6.dex */
public class NoticeDetailGoto extends BaseGoto implements Serializable {
    private static final long serialVersionUID = 8799533747895726775L;
    private String code;

    @SerializedName("deeplink_uri")
    private String deeplinkUri;

    @SerializedName("name")
    private String name;

    public String getCode() {
        return this.code;
    }

    public String getDeeplinkUri() {
        return this.deeplinkUri;
    }

    public String getName() {
        return this.name;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setDeeplinkUri(String str) {
        this.deeplinkUri = str;
    }

    public void setName(String str) {
        this.name = str;
    }
}
