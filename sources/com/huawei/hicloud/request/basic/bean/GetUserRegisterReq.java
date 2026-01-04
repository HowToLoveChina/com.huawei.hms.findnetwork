package com.huawei.hicloud.request.basic.bean;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class GetUserRegisterReq extends BasicBaseReq {
    private List<String> params;

    public GetUserRegisterReq() {
        super("GetUserRegisterReq");
        this.params = new ArrayList();
    }

    public void addParams(String str) {
        this.params.add(str);
    }

    public List<String> getParams() {
        return this.params;
    }

    @Override // com.huawei.hicloud.request.basic.bean.BasicBaseReq
    public String toString() {
        return new Gson().toJson(this);
    }
}
