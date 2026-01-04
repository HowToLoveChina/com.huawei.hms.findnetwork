package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.util.NotifyUtil;

/* loaded from: classes6.dex */
public class NoticeCoupon {
    private static final String TAG = "NoticeCoupon";

    @SerializedName(NotifyUtil.MAIN_TEXT_TYPE_DEFAULT)
    private String mainText;

    @SerializedName("sub_title")
    private String subTitle;

    @SerializedName("title")
    private String title;

    public String getMainText() {
        return this.mainText;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public String getTitle() {
        return this.title;
    }

    public void setMainText(String str) {
        this.mainText = str;
    }

    public void setSubTitle(String str) {
        this.subTitle = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
