package com.huawei.android.hicloud.cloudbackup.bean;

import com.huawei.android.hicloud.agd.ads.DownloadParam;

/* loaded from: classes2.dex */
public class RestoreAdsInfo {
    private String adId;
    private String clickUrl;
    private DownloadParam downloadParam;
    private boolean isClick;
    private boolean isShow;
    private String packageName;
    private String showUrl;
    private String versionCode;

    public String getAdId() {
        return this.adId;
    }

    public String getClickUrl() {
        return this.clickUrl;
    }

    public DownloadParam getDownloadParam() {
        return this.downloadParam;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getShowUrl() {
        return this.showUrl;
    }

    public String getVersionCode() {
        return this.versionCode;
    }

    public boolean isClick() {
        return this.isClick;
    }

    public boolean isShow() {
        return this.isShow;
    }

    public void setAdId(String str) {
        this.adId = str;
    }

    public void setClick(boolean z10) {
        this.isClick = z10;
    }

    public void setClickUrl(String str) {
        this.clickUrl = str;
    }

    public void setDownloadParam(DownloadParam downloadParam) {
        this.downloadParam = downloadParam;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setShow(boolean z10) {
        this.isShow = z10;
    }

    public void setShowUrl(String str) {
        this.showUrl = str;
    }

    public void setVersionCode(String str) {
        this.versionCode = str;
    }
}
