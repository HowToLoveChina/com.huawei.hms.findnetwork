package com.huawei.android.hicloud.safeinfo.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes3.dex */
public class LinkContents {
    private String language;

    @SerializedName("link_text")
    private String linkText;

    @SerializedName("goto")
    private LinkJumpWay mGoto;

    public String getLanguage() {
        return this.language;
    }

    public String getLinkText() {
        if (this.linkText == null) {
            this.linkText = "";
        }
        return this.linkText;
    }

    public LinkJumpWay getmGoto() {
        return this.mGoto;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setLinkText(String str) {
        this.linkText = str;
    }

    public void setmGoto(LinkJumpWay linkJumpWay) {
        this.mGoto = linkJumpWay;
    }
}
