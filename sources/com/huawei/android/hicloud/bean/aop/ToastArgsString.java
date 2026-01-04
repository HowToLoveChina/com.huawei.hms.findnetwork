package com.huawei.android.hicloud.bean.aop;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes2.dex */
public class ToastArgsString {

    @SerializedName("duration")
    private int duration;

    @SerializedName("message")
    private String message;

    public int getDuration() {
        return this.duration;
    }

    public String getMessage() {
        return this.message;
    }

    public void setDuration(int i10) {
        this.duration = i10;
    }

    public void setMessage(String str) {
        this.message = str;
    }
}
