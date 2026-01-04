package com.huawei.hicloud.messagecenter.bean;

import java.util.List;

/* loaded from: classes6.dex */
public class SnsAssistantMsg {
    private List<SnsAssistantMsgListItem> message;
    private String title;

    public List<SnsAssistantMsgListItem> getMessage() {
        return this.message;
    }

    public String getTitle() {
        return this.title;
    }

    public void setMessage(List<SnsAssistantMsgListItem> list) {
        this.message = list;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
