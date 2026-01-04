package com.huawei.hms.findnetwork.comm.request.bean;

/* loaded from: classes8.dex */
public class UserOperationBean extends BaseRequestBean {
    private String data;
    private int operationCode;

    public UserOperationBean(int i10, String str) {
        this.operationCode = i10;
        this.data = str;
    }

    public String getData() {
        return this.data;
    }

    public int getOperationCode() {
        return this.operationCode;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setOperationCode(int i10) {
        this.operationCode = i10;
    }
}
