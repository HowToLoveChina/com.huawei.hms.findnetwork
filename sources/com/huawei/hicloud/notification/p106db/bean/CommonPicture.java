package com.huawei.hicloud.notification.p106db.bean;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.HicloudH5ConfigManager;

/* loaded from: classes6.dex */
public class CommonPicture {
    private static final String TAG = "CommonPicture";

    @SerializedName(HicloudH5ConfigManager.KEY_HASH)
    private String hash;

    @SerializedName("resolution")
    private String resolution;

    @SerializedName("url")
    private String url;

    public boolean checkPictureParam() {
        if (!isValid()) {
            return false;
        }
        if (TextUtils.isEmpty(this.resolution)) {
            NotifyLogger.m29914e(TAG, "resolution is empty");
            return false;
        }
        if (this.resolution.equals(RecommendCardConstants.Resolution.PHONE_LANDSCAPE) || this.resolution.equals(RecommendCardConstants.Resolution.PHONE_PORTRAIT) || this.resolution.equals(RecommendCardConstants.Resolution.PICTURE_SECOND)) {
            return true;
        }
        NotifyLogger.m29914e(TAG, "resolution illegal");
        return false;
    }

    public String getHash() {
        return this.hash;
    }

    public String getResolution() {
        return this.resolution;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isValid() {
        if (TextUtils.isEmpty(this.url)) {
            NotifyLogger.m29914e(TAG, "url is empty");
            return false;
        }
        if (!URLUtil.isHttpsUrl(this.url)) {
            NotifyLogger.m29914e(TAG, "url is not https");
            return false;
        }
        if (!TextUtils.isEmpty(this.hash)) {
            return true;
        }
        NotifyLogger.m29914e(TAG, "hash is empty");
        return false;
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
