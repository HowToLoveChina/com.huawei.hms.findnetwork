package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class ForwardIMReq extends Request {
    private String content;

    public ForwardIMReq(String str) {
        super("forwardIM");
        this.content = str;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }
}
