package com.huawei.fastengine.fastview.startfastappengine.bean;

import android.content.Intent;

/* loaded from: classes5.dex */
public class RpkInfo {
    public static final String APPID = "appid";
    public static final String DIGEST = "digest";
    public static final String DOWNLOAD_URL = "downloadUrl";
    public static final String PACKAGE_NAME = "packageName";
    public static final String VERSIONCODE = "versionCode";
    private String appid;
    private String digest;
    private String downloadUrl;
    private String packageName;
    private String versionCode;

    public String getAppid() {
        return this.appid;
    }

    public String getDigest() {
        return this.digest;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getVersionCode() {
        return this.versionCode;
    }

    public void parse(Intent intent) {
        if (intent == null) {
            return;
        }
        this.packageName = intent.getStringExtra("packageName");
        this.appid = intent.getStringExtra("appid");
        this.downloadUrl = intent.getStringExtra(DOWNLOAD_URL);
        this.versionCode = intent.getStringExtra("versionCode");
        this.digest = intent.getStringExtra(DIGEST);
    }

    public void setAppid(String str) {
        this.appid = str;
    }

    public void setDigest(String str) {
        this.digest = str;
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setVersionCode(String str) {
        this.versionCode = str;
    }
}
