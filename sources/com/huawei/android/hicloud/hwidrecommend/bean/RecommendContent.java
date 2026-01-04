package com.huawei.android.hicloud.hwidrecommend.bean;

import java.util.List;

/* loaded from: classes3.dex */
public class RecommendContent {
    private String linkName;
    private String linkType;
    private List<RecommendLink> links;
    private String subTitle;
    private String title;

    public String getLinkName() {
        return this.linkName;
    }

    public String getLinkType() {
        return this.linkType;
    }

    public List<RecommendLink> getLinks() {
        return this.links;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public String getTitle() {
        return this.title;
    }

    public void setLinkName(String str) {
        this.linkName = str;
    }

    public void setLinkType(String str) {
        this.linkType = str;
    }

    public void setLinks(List<RecommendLink> list) {
        this.links = list;
    }

    public void setSubTitle(String str) {
        this.subTitle = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
