package com.huawei.hicloud.notification.config;

import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;

/* loaded from: classes6.dex */
public class CBPushRule {
    private static final String TAG = "CBPushRule";
    private String condition_operator = HNConstants.Operator.f22637OR;
    private CBPushRuleCondition[] notice_conditions;
    private String rule_type;

    private boolean checkThreshold(float f10, boolean z10) {
        if (f10 == -1.0f) {
            if (this.condition_operator.equals(HNConstants.Operator.AND)) {
                return true;
            }
            if (this.condition_operator.equals(HNConstants.Operator.f22637OR)) {
                return false;
            }
        }
        return z10;
    }

    private boolean compareSize(long j10, float f10) {
        float f11 = j10 / 1048576.0f;
        NotifyLogger.m29915i(TAG, "sizeMb=" + f11 + ", threshold=" + f10);
        return f11 >= f10;
    }

    private boolean useOperator(boolean z10, boolean z11) {
        if (this.condition_operator.equals(HNConstants.Operator.AND)) {
            return z10 && z11;
        }
        if (this.condition_operator.equals(HNConstants.Operator.f22637OR)) {
            return z10 || z11;
        }
        return false;
    }

    public boolean check(int i10, long j10) {
        CBPushRuleCondition ruleCondition = getRuleCondition("number");
        float moreThan = ruleCondition != null ? ruleCondition.getMoreThan() : -1.0f;
        boolean zCheckThreshold = checkThreshold(moreThan, ((float) i10) >= moreThan);
        CBPushRuleCondition ruleCondition2 = getRuleCondition(HNConstants.RuleType.CONDITION_TYPE_SIZE);
        float moreThan2 = ruleCondition2 != null ? ruleCondition2.getMoreThan() : -1.0f;
        NotifyLogger.m29915i(TAG, "amountThreshold=" + moreThan + ",sizeThreshold=" + moreThan2);
        return useOperator(zCheckThreshold, checkThreshold(moreThan2, compareSize(j10, moreThan2)));
    }

    public String getConditionOperator() {
        return this.condition_operator;
    }

    public CBPushRuleCondition[] getNoticeConditions() {
        CBPushRuleCondition[] cBPushRuleConditionArr = this.notice_conditions;
        return cBPushRuleConditionArr != null ? (CBPushRuleCondition[]) cBPushRuleConditionArr.clone() : new CBPushRuleCondition[0];
    }

    public CBPushRuleCondition getRuleCondition(String str) {
        CBPushRuleCondition[] cBPushRuleConditionArr = this.notice_conditions;
        if (cBPushRuleConditionArr == null) {
            return null;
        }
        for (CBPushRuleCondition cBPushRuleCondition : cBPushRuleConditionArr) {
            if (str.equals(cBPushRuleCondition.getConditionType())) {
                return cBPushRuleCondition;
            }
        }
        return null;
    }

    public String getRuleType() {
        return this.rule_type;
    }

    public void setConditionOperator(String str) {
        this.condition_operator = str;
    }

    public void setNoticeConditions(CBPushRuleCondition[] cBPushRuleConditionArr) {
        if (cBPushRuleConditionArr != null) {
            this.notice_conditions = (CBPushRuleCondition[]) cBPushRuleConditionArr.clone();
        } else {
            this.notice_conditions = null;
        }
    }

    public void setRuleType(String str) {
        this.rule_type = str;
    }
}
