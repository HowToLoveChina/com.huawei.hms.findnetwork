package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes6.dex */
public class UpgradeSecondButton implements Serializable {
    private static final long serialVersionUID = 1;

    @SerializedName("name")
    private String btnName;

    @SerializedName("goto")
    private UpgradeJumpObject upgradeJumpObject;

    public String getBtnName() {
        return this.btnName;
    }

    public UpgradeJumpObject getUpgradeJumpObject() {
        return this.upgradeJumpObject;
    }

    public void setBtnName(String str) {
        this.btnName = str;
    }

    public void setUpgradeJumpObject(UpgradeJumpObject upgradeJumpObject) {
        this.upgradeJumpObject = upgradeJumpObject;
    }
}
