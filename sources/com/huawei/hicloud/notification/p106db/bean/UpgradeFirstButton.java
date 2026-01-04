package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes6.dex */
public class UpgradeFirstButton implements Serializable {
    private static final long serialVersionUID = 1;

    @SerializedName("name")
    private String btnName;

    public String getBtnName() {
        return this.btnName;
    }

    public void setBtnName(String str) {
        this.btnName = str;
    }
}
