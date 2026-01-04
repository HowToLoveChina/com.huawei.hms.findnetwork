package com.huawei.hicloud.router.data;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes.dex */
public class CloudSpaceUsageItemColor {
    private String color;

    @SerializedName("color_dark")
    private String darkColor;
    private String key;

    public CloudSpaceUsageItemColor(String str, String str2, String str3) {
        this.key = str;
        this.color = str2;
        this.darkColor = str3;
    }

    public String getColor() {
        return this.color;
    }

    public String getDarkColor() {
        return this.darkColor;
    }

    public String getKey() {
        return this.key;
    }

    public void setColor(String str) {
        this.color = str;
    }

    public void setDarkColor(String str) {
        this.darkColor = str;
    }

    public void setKey(String str) {
        this.key = str;
    }
}
