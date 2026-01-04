package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class RecommendTipInfo {

    @SerializedName("displayClearCard")
    private String displayClearCard;

    @SerializedName("displayHelp")
    private String displayHelp;

    @SerializedName("helpUrl")
    private String helpUrl;

    @SerializedName("popTimesThreshold")
    private String popTimesThreshold;

    public String getDisplayClearCard() {
        return this.displayClearCard;
    }

    public String getDisplayHelp() {
        return this.displayHelp;
    }

    public String getHelpUrl() {
        return this.helpUrl;
    }

    public String getPopTimesThreshold() {
        return this.popTimesThreshold;
    }

    public void setDisplayClearCard(String str) {
        this.displayClearCard = str;
    }

    public void setDisplayHelp(String str) {
        this.displayHelp = str;
    }

    public void setHelpUrl(String str) {
        this.helpUrl = str;
    }

    public void setPopTimesThreshold(String str) {
        this.popTimesThreshold = str;
    }
}
