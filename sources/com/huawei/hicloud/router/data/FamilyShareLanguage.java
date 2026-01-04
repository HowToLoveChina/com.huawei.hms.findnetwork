package com.huawei.hicloud.router.data;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.manager.HicloudH5ConfigManager;

/* loaded from: classes.dex */
public class FamilyShareLanguage {

    @SerializedName(HicloudH5ConfigManager.KEY_HASH)
    private String hash;

    @SerializedName("url")
    private String url;

    @SerializedName("version")
    private String version;

    public String getHash() {
        return this.hash;
    }

    public String getUrl() {
        return this.url;
    }

    public String getVersion() {
        return this.version;
    }

    public void setHash(String str) {
        this.hash = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
