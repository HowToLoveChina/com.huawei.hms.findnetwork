package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: classes6.dex */
public class UrgencyDetail {

    @SerializedName("operButtons")
    private List<UrgencyButtons> buttons;

    @SerializedName("content")
    private String content;

    @SerializedName("detailLink")
    private String detailLink;

    @SerializedName("detailLinkName")
    private String detailLinkName;

    @SerializedName("picture")
    private UrgencyDetailPicture picture;

    @SerializedName("title")
    private String title;

    public List<UrgencyButtons> getButtons() {
        return this.buttons;
    }

    public String getContent() {
        return this.content;
    }

    public String getDetailLink() {
        return this.detailLink;
    }

    public String getDetailLinkName() {
        return this.detailLinkName;
    }

    public UrgencyDetailPicture getPicture() {
        return this.picture;
    }

    public String getTitle() {
        return this.title;
    }

    public void setButtons(List<UrgencyButtons> list) {
        this.buttons = list;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setDetailLink(String str) {
        this.detailLink = str;
    }

    public void setDetailLinkName(String str) {
        this.detailLinkName = str;
    }

    public void setPicture(UrgencyDetailPicture urgencyDetailPicture) {
        this.picture = urgencyDetailPicture;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
