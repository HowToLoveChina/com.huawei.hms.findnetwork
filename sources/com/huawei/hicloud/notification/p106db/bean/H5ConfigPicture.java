package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.manager.HicloudH5ConfigManager;

/* loaded from: classes6.dex */
public class H5ConfigPicture {

    @SerializedName(HicloudH5ConfigManager.KEY_HASH)
    private String hash;

    @SerializedName("resolution")
    private String resolution;

    @SerializedName("url")
    private String url;

    public String getHash() {
        return this.hash;
    }

    public String getResolution() {
        return this.resolution;
    }

    public String getUrl() {
        return this.url;
    }

    public void setHash(String str) {
        this.hash = str;
    }

    public void setResolution(String str) {
        this.resolution = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
