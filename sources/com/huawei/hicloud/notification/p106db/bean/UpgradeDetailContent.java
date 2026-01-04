package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.util.NotifyUtil;
import java.io.Serializable;

/* loaded from: classes6.dex */
public class UpgradeDetailContent implements Serializable {
    private static final long serialVersionUID = 1;

    @SerializedName(NotifyUtil.MAIN_TEXT_TYPE_DEFAULT)
    private String upgradeDetailText;

    @SerializedName("title")
    private String upgradeDetailTitle;

    @SerializedName("button1")
    private UpgradeFirstButton upgradeFirstButton;

    @SerializedName("button2")
    private UpgradeSecondButton upgradeSecondButton;

    public String getUpgradeDetailText() {
        return this.upgradeDetailText;
    }

    public String getUpgradeDetailTitle() {
        return this.upgradeDetailTitle;
    }

    public UpgradeFirstButton getUpgradeFirstButton() {
        return this.upgradeFirstButton;
    }

    public UpgradeSecondButton getUpgradeSecondButton() {
        return this.upgradeSecondButton;
    }

    public void setUpgradeDetailFirstButton(UpgradeFirstButton upgradeFirstButton) {
        this.upgradeFirstButton = upgradeFirstButton;
    }

    public void setUpgradeDetailText(String str) {
        this.upgradeDetailText = str;
    }

    public void setUpgradeDetailTitle(String str) {
        this.upgradeDetailTitle = str;
    }

    public void setUpgradeSecondButton(UpgradeSecondButton upgradeSecondButton) {
        this.upgradeSecondButton = upgradeSecondButton;
    }
}
