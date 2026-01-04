package com.huawei.android.hicloud.cloudbackup.bean;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class BackupConfig {
    List<CompatibleRule> compatibleRule;
    RuleConfig ruleConfig;

    public List<CompatibleRule> getCompatibleRule() {
        List<CompatibleRule> list = this.compatibleRule;
        return list == null ? new ArrayList() : list;
    }

    public RuleConfig getRuleConfig() {
        return this.ruleConfig;
    }

    public void setCompatibleRule(List<CompatibleRule> list) {
        this.compatibleRule = list;
    }

    public void setRuleConfig(RuleConfig ruleConfig) {
        this.ruleConfig = ruleConfig;
    }

    public String toString() {
        return "BackupConfig{compatibleRule=" + this.compatibleRule + ", ruleConfig=" + this.ruleConfig + '}';
    }
}
