package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: classes6.dex */
public class HiCloudRiskRule {

    @SerializedName("dayonce")
    private float dayonce;

    @SerializedName("risk_control_content")
    private List<RiskControlContent> riskControlContents;

    @SerializedName("rules")
    private List<RiskRule> rules;

    public float getDayonce() {
        return this.dayonce;
    }

    public List<RiskControlContent> getRiskControlContents() {
        return this.riskControlContents;
    }

    public List<RiskRule> getRules() {
        return this.rules;
    }

    public void setDayonce(float f10) {
        this.dayonce = f10;
    }

    public void setRiskControlContents(List<RiskControlContent> list) {
        this.riskControlContents = list;
    }

    public void setRules(List<RiskRule> list) {
        this.rules = list;
    }
}
