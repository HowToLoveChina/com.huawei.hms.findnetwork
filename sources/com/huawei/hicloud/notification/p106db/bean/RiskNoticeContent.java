package com.huawei.hicloud.notification.p106db.bean;

/* loaded from: classes6.dex */
public class RiskNoticeContent {
    private String content;
    private String firstBtn;
    private String language;
    private String secondBtn;
    private String subTitle;
    private String title;

    public RiskNoticeContent() {
    }

    public String getContent() {
        return this.content;
    }

    public String getFirstBtn() {
        return this.firstBtn;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getSecondBtn() {
        return this.secondBtn;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public String getTitle() {
        return this.title;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setFirstBtn(String str) {
        this.firstBtn = str;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setSecondBtn(String str) {
        this.secondBtn = str;
    }

    public void setSubTitle(String str) {
        this.subTitle = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public RiskNoticeContent(String str, String str2, String str3, String str4, String str5, String str6) {
        this.language = str;
        this.title = str2;
        this.subTitle = str3;
        this.content = str4;
        this.firstBtn = str5;
        this.secondBtn = str6;
    }
}
