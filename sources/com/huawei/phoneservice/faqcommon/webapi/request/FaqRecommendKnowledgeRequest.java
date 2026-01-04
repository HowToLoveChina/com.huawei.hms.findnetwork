package com.huawei.phoneservice.faqcommon.webapi.request;

import com.google.gson.annotations.SerializedName;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.constants.TrackConstants$Events;

/* loaded from: classes4.dex */
public class FaqRecommendKnowledgeRequest {

    @SerializedName(JsbMapKeyNames.H5_BRAND)
    private String brand;

    @SerializedName("knowledgeId")
    private String knowledgeId;

    @SerializedName(FaqConstants.FAQ_EMUI_LANGUAGE)
    private String language;

    @SerializedName(TrackConstants$Events.PAGE)
    private String page;

    @SerializedName("pageCount")
    private String pageCount;

    @SerializedName("pageNum")
    private String pageNum;

    @SerializedName("pageSize")
    private String pageSize;

    @SerializedName("qAppName")
    private String qAppName;

    @SerializedName("site")
    private String site;

    @SerializedName("size")
    private String size;

    public String getBrand() {
        return this.brand;
    }

    public String getKnowledgeId() {
        return this.knowledgeId;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getPage() {
        return this.page;
    }

    public String getPageCount() {
        return this.pageCount;
    }

    public String getPageNum() {
        return this.pageNum;
    }

    public String getPageSize() {
        return this.pageSize;
    }

    public String getSite() {
        return this.site;
    }

    public String getSize() {
        return this.size;
    }

    public String getqAppName() {
        return this.qAppName;
    }

    public void setBrand(String str) {
        this.brand = str;
    }

    public void setKnowledgeId(String str) {
        this.knowledgeId = str;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setPage(String str) {
        this.page = str;
    }

    public void setPageCount(String str) {
        this.pageCount = str;
    }

    public void setPageNum(String str) {
        this.pageNum = str;
    }

    public void setPageSize(String str) {
        this.pageSize = str;
    }

    public void setSite(String str) {
        this.site = str;
    }

    public void setSize(String str) {
        this.size = str;
    }

    public void setqAppName(String str) {
        this.qAppName = str;
    }
}
