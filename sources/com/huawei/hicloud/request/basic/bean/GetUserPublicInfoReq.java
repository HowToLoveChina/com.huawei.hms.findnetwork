package com.huawei.hicloud.request.basic.bean;

import java.util.List;

/* loaded from: classes6.dex */
public class GetUserPublicInfoReq extends BasicBaseReq {
    private List<String> params;

    public GetUserPublicInfoReq(List<String> list) {
        super("getUserPublicInfo");
        this.params = list;
    }

    public List<String> getParams() {
        return this.params;
    }

    public void setParams(List<String> list) {
        this.params = list;
    }
}
