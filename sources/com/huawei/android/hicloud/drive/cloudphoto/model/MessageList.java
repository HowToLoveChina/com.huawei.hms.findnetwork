package com.huawei.android.hicloud.drive.cloudphoto.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import ni.C11707b;

/* loaded from: classes3.dex */
public class MessageList extends C11707b {

    @InterfaceC4648p
    private String category;

    @InterfaceC4648p
    private List<Message> messages;

    @InterfaceC4648p
    private String nextCursor;

    @InterfaceC4648p
    private String nextStartCursor;

    public String getCategory() {
        return this.category;
    }

    public List<Message> getMessages() {
        return this.messages;
    }

    public String getNextCursor() {
        return this.nextCursor;
    }

    public String getNextStartCursor() {
        return this.nextStartCursor;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setMessages(List<Message> list) {
        this.messages = list;
    }

    public void setNextCursor(String str) {
        this.nextCursor = str;
    }

    public void setNextStartCursor(String str) {
        this.nextStartCursor = str;
    }
}
