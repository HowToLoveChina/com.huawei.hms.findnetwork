package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import java.util.List;

/* loaded from: classes6.dex */
public class RiskRule {

    @SerializedName("regulars")
    private List<Regular> regulars;

    @SerializedName("ruleId")
    private int ruleId;

    @SerializedName(NotifyConstants.NotificationReport.KEY_RULE_TYPE)
    private String ruleType;

    @SerializedName("rule_threshold")
    private int threshold;

    public List<Regular> getRegulars() {
        return this.regulars;
    }

    public int getRuleId() {
        return this.ruleId;
    }

    public String getRuleType() {
        return this.ruleType;
    }

    public int getThreshold() {
        return this.threshold;
    }

    public void setRegulars(List<Regular> list) {
        this.regulars = list;
    }

    public void setRuleId(int i10) {
        this.ruleId = i10;
    }

    public void setRuleType(String str) {
        this.ruleType = str;
    }

    public void setThreshold(int i10) {
        this.threshold = i10;
    }
}
