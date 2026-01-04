package com.huawei.android.hicloud.agd.ads;

/* loaded from: classes2.dex */
public class MaterialMeta {
    private Integer adFlag;
    private AdAppInfo appInfo;
    private String clickUrl;
    private String showUrl;
    private Integer styleType;
    private EventTrack trackUrls;

    public Integer getAdFlag() {
        return this.adFlag;
    }

    public AdAppInfo getAppInfo() {
        return this.appInfo;
    }

    public String getClickUrl() {
        return this.clickUrl;
    }

    public String getShowUrl() {
        return this.showUrl;
    }

    public Integer getStyleType() {
        return this.styleType;
    }

    public EventTrack getTrackUrls() {
        return this.trackUrls;
    }

    public void setAdFlag(Integer num) {
        this.adFlag = num;
    }

    public void setAppInfo(AdAppInfo adAppInfo) {
        this.appInfo = adAppInfo;
    }

    public void setClickUrl(String str) {
        this.clickUrl = str;
    }

    public void setShowUrl(String str) {
        this.showUrl = str;
    }

    public void setStyleType(Integer num) {
        this.styleType = num;
    }

    public void setTrackUrls(EventTrack eventTrack) {
        this.trackUrls = eventTrack;
    }
}
