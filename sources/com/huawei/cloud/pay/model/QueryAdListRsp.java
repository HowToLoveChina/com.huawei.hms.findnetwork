package com.huawei.cloud.pay.model;

import com.huawei.android.hicloud.agd.ads.AdInfo;
import java.util.List;

/* loaded from: classes5.dex */
public class QueryAdListRsp extends Response {
    private Integer adRetCode;
    private List<AdInfo> adlist;
    private Integer hasNextPage;
    private String requestId;

    public Integer getAdRetCode() {
        return this.adRetCode;
    }

    public List<AdInfo> getAdlist() {
        return this.adlist;
    }

    public Integer getHasNextPage() {
        return this.hasNextPage;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setAdRetCode(Integer num) {
        this.adRetCode = num;
    }

    public void setAdlist(List<AdInfo> list) {
        this.adlist = list;
    }

    public void setHasNextPage(Integer num) {
        this.hasNextPage = num;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }
}
