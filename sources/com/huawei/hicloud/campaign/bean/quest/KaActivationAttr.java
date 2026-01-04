package com.huawei.hicloud.campaign.bean.quest;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.campaign.bean.CamJump;

/* loaded from: classes6.dex */
public class KaActivationAttr {
    private String appPackage;

    @SerializedName("goto")
    private CamJump gotoX;
    private int operator;
    private String version;

    public String getAppPackage() {
        return this.appPackage;
    }

    public CamJump getGotoX() {
        return this.gotoX;
    }

    public int getOperator() {
        return this.operator;
    }

    public String getVersion() {
        return this.version;
    }

    public void setAppPackage(String str) {
        this.appPackage = str;
    }

    public void setGotoX(CamJump camJump) {
        this.gotoX = camJump;
    }

    public void setOperator(int i10) {
        this.operator = i10;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
