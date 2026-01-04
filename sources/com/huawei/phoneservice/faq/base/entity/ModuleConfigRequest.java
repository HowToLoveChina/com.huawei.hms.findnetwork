package com.huawei.phoneservice.faq.base.entity;

import com.google.gson.annotations.SerializedName;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;

/* loaded from: classes4.dex */
public class ModuleConfigRequest {

    @SerializedName("appId")
    private String appId;

    @SerializedName("appVersion")
    private String appVersion;

    @SerializedName("brandName")
    private String brand;

    @SerializedName("countryCode")
    private String countryCode;

    @SerializedName("emuiLangCode")
    private String emuiLanguageCode;

    @SerializedName(FaqConstants.FAQ_EMUIVERSION)
    private String emuiVersion;

    @SerializedName("machineType")
    private String machineType;

    @SerializedName(FaqConstants.FAQ_MODEL)
    private String model;

    /* renamed from: sn */
    @SerializedName("sn")
    private String f38632sn;

    public ModuleConfigRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.countryCode = str;
        this.emuiLanguageCode = str2;
        this.brand = str3;
        this.appId = str4;
        this.f38632sn = str5;
        this.emuiVersion = str6;
        this.appVersion = str7;
        this.model = str8;
        this.machineType = str9;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getEmuiLanguageCode() {
        return this.emuiLanguageCode;
    }

    public String getEmuiVersion() {
        return this.emuiVersion;
    }

    public String getModel() {
        return this.model;
    }

    public String getSn() {
        return this.f38632sn;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setBrand(String str) {
        this.brand = str;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public void setEmuiLanguageCode(String str) {
        this.emuiLanguageCode = str;
    }

    public void setEmuiVersion(String str) {
        this.emuiVersion = str;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public void setSn(String str) {
        this.f38632sn = str;
    }

    public String toString() {
        return "ModuleConfigRequest{cCode='" + this.countryCode + "', eCode='" + this.emuiLanguageCode + "', b='" + this.brand + "', a='" + this.appId + "', eVersion='" + this.emuiVersion + "', aVersion='" + this.appVersion + "', m='" + this.model + "', m='" + this.machineType + "'}";
    }
}
