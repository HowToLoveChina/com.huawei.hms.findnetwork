package com.huawei.cloud.pay.model;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.feature.result.CommonConstant;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class CurPkgInfo implements Serializable {
    private static final long serialVersionUID = 1;

    @SerializedName("curIsAutoPay")
    private int curIsAutoPay;

    @SerializedName(CommonConstant.KEY_DISPLAY_NAME)
    private String displayName;

    @SerializedName("remainDays")
    private int remainDays;

    @SerializedName("scheme")
    private int scheme;

    public int getCurIsAutoPay() {
        return this.curIsAutoPay;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public int getRemainDays() {
        return this.remainDays;
    }

    public int getScheme() {
        return this.scheme;
    }

    public void setCurIsAutoPay(int i10) {
        this.curIsAutoPay = i10;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setRemainDays(int i10) {
        this.remainDays = i10;
    }

    public void setScheme(int i10) {
        this.scheme = i10;
    }
}
