package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class NoticeActivityPopUp {
    private static final String TAG = "NoticeCoupon";

    @SerializedName("popup_main_text")
    private String mainText;

    @SerializedName("popup_button_first")
    private String popButtonFirst;

    @SerializedName("popup_button_second")
    private String popButtonSecond;

    @SerializedName("popup_title")
    private String popTitle;

    public String getMainText() {
        return this.mainText;
    }

    public String getPopButtonFirst() {
        return this.popButtonFirst;
    }

    public String getPopButtonSecond() {
        return this.popButtonSecond;
    }

    public String getPopTitle() {
        return this.popTitle;
    }

    public void setMainText(String str) {
        this.mainText = str;
    }

    public void setPopButtonFirst(String str) {
        this.popButtonFirst = str;
    }

    public void setPopButtonSecond(String str) {
        this.popButtonSecond = str;
    }

    public void setPopTitle(String str) {
        this.popTitle = str;
    }
}
