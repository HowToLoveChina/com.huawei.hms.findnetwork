package com.huawei.hicloud.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class BackupErrorPopDefaultInfo {

    @SerializedName("default")
    private int defaultSelect;
    private int select;

    public int getDefaultSelect() {
        return this.defaultSelect;
    }

    public int getSelect() {
        return this.select;
    }

    public void setSelect(int i10) {
        this.select = i10;
    }
}
