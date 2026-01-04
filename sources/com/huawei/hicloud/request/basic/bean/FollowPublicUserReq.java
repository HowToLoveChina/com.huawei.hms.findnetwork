package com.huawei.hicloud.request.basic.bean;

import com.google.gson.Gson;

/* loaded from: classes6.dex */
public class FollowPublicUserReq extends BasicBaseReq {
    private String operation;

    public FollowPublicUserReq(String str) {
        super("postUserOperation");
        this.operation = str;
    }

    public String getOperation() {
        return this.operation;
    }

    public void setOperation(String str) {
        this.operation = str;
    }

    @Override // com.huawei.hicloud.request.basic.bean.BasicBaseReq
    public String toString() {
        return new Gson().toJson(this);
    }
}
