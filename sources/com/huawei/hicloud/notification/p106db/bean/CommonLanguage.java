package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.manager.HicloudH5ConfigManager;
import java.io.Serializable;

/* loaded from: classes6.dex */
public class CommonLanguage implements Serializable {
    private static final long serialVersionUID = 7918101851386859050L;

    @SerializedName(HicloudH5ConfigManager.KEY_HASH)
    private String hash;

    @SerializedName("url")
    private String url;

    @SerializedName("version")
    private int version;

    public String getHash() {
        return this.hash;
    }

    public String getUrl() {
        return this.url;
    }

    public int getVersion() {
        return this.version;
    }

    public void setHash(String str) {
        this.hash = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setVersion(int i10) {
        this.version = i10;
    }
}
