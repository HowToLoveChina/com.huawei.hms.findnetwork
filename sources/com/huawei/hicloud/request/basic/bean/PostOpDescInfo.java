package com.huawei.hicloud.request.basic.bean;

/* loaded from: classes6.dex */
public class PostOpDescInfo {
    private int action;
    private String result;
    private String service;

    public int getAction() {
        return this.action;
    }

    public String getResult() {
        return this.result;
    }

    public String getService() {
        return this.service;
    }

    public void setAction(int i10) {
        this.action = i10;
    }

    public void setResult(String str) {
        this.result = str;
    }

    public void setService(String str) {
        this.service = str;
    }

    public String toString() {
        return "service:" + this.service + ",action:" + this.action + ",result:" + this.result;
    }
}
