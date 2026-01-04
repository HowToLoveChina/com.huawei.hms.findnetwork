package com.huawei.phoneservice.faqcommon.webapi.request;

import com.google.gson.annotations.SerializedName;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;

/* loaded from: classes4.dex */
public class FaqKnowledgeRequest {

    @SerializedName("brands")
    private String brands;

    @SerializedName(FaqConstants.FAQ_CHANNEL)
    private String channel;

    @SerializedName("countriesCode")
    private String countriesCode;

    @SerializedName("defaultCountryCode")
    private String defaultCountryCode;

    @SerializedName("defaultLanguageCode")
    private String defaultLanguageCode;

    @SerializedName(FaqConstants.FAQ_LANGUAGE)
    private String languageCode;

    @SerializedName("curPage")
    private String pageNum;

    @SerializedName("pageSize")
    private String pageSize;

    @SerializedName("productCategoryCode")
    private String productCode;

    @SerializedName("secretType")
    private String secretType;

    public String getBrands() {
        return this.brands;
    }

    public String getChannel() {
        return this.channel;
    }

    public String getCountriesCode() {
        return this.countriesCode;
    }

    public String getLanguageCode() {
        return this.languageCode;
    }

    public String getPageNum() {
        return this.pageNum;
    }

    public String getPageSize() {
        return this.pageSize;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public String getSecretType() {
        return this.secretType;
    }

    public void setBrands(String str) {
        this.brands = str;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public void setCountriesCode(String str) {
        this.countriesCode = str;
    }

    public void setDefaultCountry(String str) {
        this.defaultCountryCode = str;
    }

    public void setDefaultLanguage(String str) {
        this.defaultLanguageCode = str;
    }

    public void setLanguageCode(String str) {
        this.languageCode = str;
    }

    public void setPageNum(String str) {
        this.pageNum = str;
    }

    public void setPageSize(String str) {
        this.pageSize = str;
    }

    public void setProductCode(String str) {
        this.productCode = str;
    }

    public void setSecretType(String str) {
        this.secretType = str;
    }

    public String toString() {
        return "Knowledge{co='" + this.countriesCode + "', la='" + this.languageCode + "', pr='" + this.productCode + "', deCo='" + this.defaultCountryCode + "', deLa='" + this.defaultLanguageCode + "'}";
    }
}
