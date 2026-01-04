package com.huawei.hicloud.request.notify.bean;

import java.util.List;

/* loaded from: classes6.dex */
public class DynamicDataInfo {
    DynamicAction action;
    private List<DynamicLangList> langList;
    int type;

    public DynamicAction getAction() {
        return this.action;
    }

    public List<DynamicLangList> getLangList() {
        return this.langList;
    }

    public int getType() {
        return this.type;
    }

    public void setAction(DynamicAction dynamicAction) {
        this.action = dynamicAction;
    }

    public void setLangList(List<DynamicLangList> list) {
        this.langList = list;
    }

    public void setType(int i10) {
        this.type = i10;
    }
}
