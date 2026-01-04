package com.huawei.phoneservice.faqcommon.webapi.request;

import com.google.gson.annotations.SerializedName;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;

/* loaded from: classes4.dex */
public class FaqSearchRequest {

    @SerializedName("applicable_region")
    private String applicableRegion;

    @SerializedName(JsbMapKeyNames.H5_BRAND)
    private String brand;

    @SerializedName("country")
    private String country;

    @SerializedName("external_model")
    private String external_model;

    @SerializedName("knowledge_type_id")
    private String knowledgeTypeId;

    @SerializedName("knowledge_type")
    private String knowledge_type;

    @SerializedName(FaqConstants.FAQ_EMUI_LANGUAGE)
    private String language;

    @SerializedName("pageNo")
    private String pageNo;

    @SerializedName("pageSize")
    private String pageSize;

    @SerializedName("produce_features")
    private String produce_f_features;

    /* renamed from: q */
    @SerializedName("q")
    private String f39389q;

    @SerializedName("qAppName")
    private String qAppName;

    @SerializedName("release_channel")
    private String releaseChannel;

    @SerializedName("site")
    private String site;

    @SerializedName("siteCode")
    private String siteCode;

    @SerializedName("sort")
    private String sort;

    public String getApplicableRegion() {
        return this.applicableRegion;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getCountry() {
        return this.country;
    }

    public String getExternal_model() {
        return this.external_model;
    }

    public String getKnowledgeTypeId() {
        return this.knowledgeTypeId;
    }

    public String getKnowledge_type() {
        return this.knowledge_type;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getPageNo() {
        return this.pageNo;
    }

    public String getPageSize() {
        return this.pageSize;
    }

    public String getProduce_f_features() {
        return this.produce_f_features;
    }

    public String getQ() {
        return this.f39389q;
    }

    public String getReleaseChannel() {
        return this.releaseChannel;
    }

    public String getSite() {
        return this.site;
    }

    public String getSiteCode() {
        return this.siteCode;
    }

    public String getSort() {
        return this.sort;
    }

    public String getqAppName() {
        return this.qAppName;
    }

    public void setApplicableRegion(String str) {
        this.applicableRegion = str;
    }

    public void setBrand(String str) {
        this.brand = str;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setExternal_model(String str) {
        this.external_model = str;
    }

    public void setKnowledgeTypeId(String str) {
        this.knowledgeTypeId = str;
    }

    public void setKnowledge_type(String str) {
        this.knowledge_type = str;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setPageNo(String str) {
        this.pageNo = str;
    }

    public void setPageSize(String str) {
        this.pageSize = str;
    }

    public void setProduce_f_features(String str) {
        this.produce_f_features = str;
    }

    public void setQ(String str) {
        this.f39389q = str;
    }

    public void setReleaseChannel(String str) {
        this.releaseChannel = str;
    }

    public void setSite(String str) {
        this.site = str;
    }

    public void setSiteCode(String str) {
        this.siteCode = str;
    }

    public void setSort(String str) {
        this.sort = str;
    }

    public void setqAppName(String str) {
        this.qAppName = str;
    }
}
