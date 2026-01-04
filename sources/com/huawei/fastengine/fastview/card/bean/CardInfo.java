package com.huawei.fastengine.fastview.card.bean;

import java.io.File;

/* loaded from: classes5.dex */
public class CardInfo {
    public static final String COMMON_API_LEVEL = "__apiLevel__";
    public static final String COMMON_HW_SIGNATURE = "__hwsignature__";
    public static final String COMMON_PACKAGE_NAME = "__packagename__";
    private int apiLevel;
    private File cardJsFile;
    private String jsParam;
    private String originUrl;
    private String packageName;
    private String signature;

    public int getApiLevel() {
        return this.apiLevel;
    }

    public File getCardJsFile() {
        return this.cardJsFile;
    }

    public String getJsParam() {
        return this.jsParam;
    }

    public String getOriginUrl() {
        return this.originUrl;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getSignature() {
        return this.signature;
    }

    public void setApiLevel(int i10) {
        this.apiLevel = i10;
    }

    public void setCardJsFile(File file) {
        this.cardJsFile = file;
    }

    public void setJsParam(String str) {
        this.jsParam = str;
    }

    public void setOriginUrl(String str) {
        this.originUrl = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setSignature(String str) {
        this.signature = str;
    }

    public String toString() {
        return "CardInfo{originUrl='" + this.originUrl + "', packageName='" + this.packageName + "', signature='" + this.signature + "', apiLevel=" + this.apiLevel + ", jsParam='" + this.jsParam + "', cardJsFile=" + this.cardJsFile + '}';
    }
}
