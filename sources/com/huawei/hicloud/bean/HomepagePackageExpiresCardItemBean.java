package com.huawei.hicloud.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class HomepagePackageExpiresCardItemBean {

    @SerializedName("button")
    private String button;

    @SerializedName("button2")
    private String button2;

    @SerializedName("buttonLinkUrl")
    private String buttonLinkUrl;

    @SerializedName("buttonLinkUrl2")
    private String buttonLinkUrl2;

    @SerializedName("content")
    private String content;

    @SerializedName("recommendation")
    private String recommendation;

    @SerializedName("title")
    private String title;

    @SerializedName("button2IsShow")
    private boolean button2IsShow = false;

    @SerializedName("buttonIsShow")
    private boolean buttonIsShow = true;

    @SerializedName("contentIsShow")
    private boolean contentIsShow = true;

    @SerializedName("recommendationIsShow")
    private boolean recommendationIsShow = true;

    public String getButton() {
        return this.button;
    }

    public String getButton2() {
        return this.button2;
    }

    public String getButtonLinkUrl() {
        return this.buttonLinkUrl;
    }

    public String getButtonLinkUrl2() {
        return this.buttonLinkUrl2;
    }

    public String getContent() {
        return this.content;
    }

    public String getRecommendation() {
        return this.recommendation;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isButton2IsShow() {
        return this.button2IsShow;
    }

    public boolean isButtonIsShow() {
        return this.buttonIsShow;
    }

    public boolean isContentIsShow() {
        return this.contentIsShow;
    }

    public boolean isRecommendationIsShow() {
        return this.recommendationIsShow;
    }

    public void setButton(String str) {
        this.button = str;
    }

    public void setButton2(String str) {
        this.button2 = str;
    }

    public void setButton2IsShow(boolean z10) {
        this.button2IsShow = z10;
    }

    public void setButtonIsShow(boolean z10) {
        this.buttonIsShow = z10;
    }

    public void setButtonLinkUrl(String str) {
        this.buttonLinkUrl = str;
    }

    public void setButtonLinkUrl2(String str) {
        this.buttonLinkUrl2 = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setContentIsShow(boolean z10) {
        this.contentIsShow = z10;
    }

    public void setRecommendation(String str) {
        this.recommendation = str;
    }

    public void setRecommendationIsShow(boolean z10) {
        this.recommendationIsShow = z10;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
