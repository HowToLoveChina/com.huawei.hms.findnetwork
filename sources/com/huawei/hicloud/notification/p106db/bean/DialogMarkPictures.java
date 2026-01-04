package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class DialogMarkPictures {

    @SerializedName("mark_picture")
    private ConfigPictureParam picture;

    public ConfigPictureParam getPicture() {
        return this.picture;
    }

    public void setPicture(ConfigPictureParam configPictureParam) {
        this.picture = configPictureParam;
    }
}
