package com.huawei.hicloud.notification.p106db.bean;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.manager.HicloudH5ConfigManager;
import p015ak.C0241z;

/* loaded from: classes6.dex */
public class ConfigPictureParam {

    @SerializedName(HicloudH5ConfigManager.KEY_HASH)
    private String hash;
    private String resolution;
    private String url;

    public String getHash() {
        return this.hash;
    }

    public float getPicturePropertion() {
        int iM1685c;
        String str = this.resolution;
        if (str == null || TextUtils.isEmpty(str)) {
            return -1.0f;
        }
        String[] strArrSplit = this.resolution.split("\\*");
        if (strArrSplit.length != 2 || (iM1685c = C0241z.m1685c(strArrSplit[0])) == 0) {
            return -1.0f;
        }
        return C0241z.m1685c(strArrSplit[1]) / iM1685c;
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
