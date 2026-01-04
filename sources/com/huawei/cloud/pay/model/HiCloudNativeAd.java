package com.huawei.cloud.pay.model;

import java.util.List;

/* loaded from: classes5.dex */
public class HiCloudNativeAd {
    public static final String CHANNEL_AGD = "AGD";
    public static final String CHANNEL_AGG = "AGG";
    public static final String CHANNEL_PPS = "PPS";
    public static final String CHANNEL_PRE = "PREAPP";
    public static final String CHANNEL_UNKONWN = "UNKONW";
    private List<String> adCloseKeyWords;
    private String adSign;
    private AdAppInfo appInfo;
    private int creativeType;
    private String description;
    private boolean expired;
    private AdImageInfo icon;
    private List<AdImageInfo> imageInfos;
    private boolean isClicked;
    private boolean isVideoAd;
    private String label;
    private String title;
    private String uniqueId;
    private boolean valid;
    private AdVideoInfo videoInfo;

    public List<String> getAdCloseKeyWords() {
        return this.adCloseKeyWords;
    }

    public String getAdSign() {
        return this.adSign;
    }

    public AdAppInfo getAppInfo() {
        return this.appInfo;
    }

    public int getCreativeType() {
        return this.creativeType;
    }

    public String getDescription() {
        return this.description;
    }

    public AdImageInfo getIcon() {
        return this.icon;
    }

    public List<AdImageInfo> getImageInfos() {
        return this.imageInfos;
    }

    public String getLabel() {
        return this.label;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUniqueId() {
        return this.uniqueId;
    }

    public AdVideoInfo getVideoInfo() {
        return this.videoInfo;
    }

    public boolean isClicked() {
        return this.isClicked;
    }

    public boolean isExpired() {
        return this.expired;
    }

    public boolean isValid() {
        return this.valid;
    }

    public boolean isVideoAd() {
        return this.isVideoAd;
    }

    public void setAdCloseKeyWords(List<String> list) {
        this.adCloseKeyWords = list;
    }

    public void setAdSign(String str) {
        this.adSign = str;
    }

    public void setAppInfo(AdAppInfo adAppInfo) {
        this.appInfo = adAppInfo;
    }

    public void setClicked(boolean z10) {
        this.isClicked = z10;
    }

    public void setCreativeType(int i10) {
        this.creativeType = i10;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setExpired(boolean z10) {
        this.expired = z10;
    }

    public void setIcon(AdImageInfo adImageInfo) {
        this.icon = adImageInfo;
    }

    public void setImageInfos(List<AdImageInfo> list) {
        this.imageInfos = list;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUniqueId(String str) {
        this.uniqueId = str;
    }

    public void setValid(boolean z10) {
        this.valid = z10;
    }

    public void setVideoAd(boolean z10) {
        this.isVideoAd = z10;
    }

    public void setVideoInfo(AdVideoInfo adVideoInfo) {
        this.videoInfo = adVideoInfo;
    }
}
