package com.huawei.hicloud.bean;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class FeatureSwitchReq {
    private List<FeatureSwitchFact> facts = new ArrayList();
    private List<String> functionIds = new ArrayList();

    public List<FeatureSwitchFact> getFacts() {
        return this.facts;
    }

    public List<String> getFunctionIds() {
        return this.functionIds;
    }

    public void setFacts(List<FeatureSwitchFact> list) {
        this.facts = list;
    }

    public void setFunctionIds(List<String> list) {
        this.functionIds = list;
    }
}
