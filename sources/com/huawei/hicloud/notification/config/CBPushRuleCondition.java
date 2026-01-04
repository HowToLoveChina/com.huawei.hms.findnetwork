package com.huawei.hicloud.notification.config;

/* loaded from: classes6.dex */
public class CBPushRuleCondition {
    private String condition_type;
    private float more_than = -1.0f;

    public String getConditionType() {
        return this.condition_type;
    }

    public float getMoreThan() {
        return this.more_than;
    }

    public void setConditionType(String str) {
        this.condition_type = str;
    }

    public void setMoreThan(float f10) {
        this.more_than = f10;
    }
}
