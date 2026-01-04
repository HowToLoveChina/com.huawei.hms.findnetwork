package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class DialogMarkInfo {

    @SerializedName("pictures")
    private DialogMarkPictures pictures;

    @SerializedName("popTimesThreshold")
    private String popTimesThreshold;

    public DialogMarkPictures getPictures() {
        return this.pictures;
    }

    public String getPopTimesThreshold() {
        return this.popTimesThreshold;
    }

    public void setPictures(DialogMarkPictures dialogMarkPictures) {
        this.pictures = dialogMarkPictures;
    }

    public void setPopTimesThreshold(String str) {
        this.popTimesThreshold = str;
    }
}
