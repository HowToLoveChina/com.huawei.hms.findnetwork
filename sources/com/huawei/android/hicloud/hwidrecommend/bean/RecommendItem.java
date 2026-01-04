package com.huawei.android.hicloud.hwidrecommend.bean;

/* loaded from: classes3.dex */
public class RecommendItem {
    private RecommendContent content;
    private String contentType;
    private String recommendId;

    public RecommendContent getContent() {
        return this.content;
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getRecommendId() {
        return this.recommendId;
    }

    public void setContent(RecommendContent recommendContent) {
        this.content = recommendContent;
    }

    public void setContentType(String str) {
        this.contentType = str;
    }

    public void setRecommendId(String str) {
        this.recommendId = str;
    }
}
