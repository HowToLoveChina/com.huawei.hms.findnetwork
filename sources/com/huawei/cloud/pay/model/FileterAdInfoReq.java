package com.huawei.cloud.pay.model;

import com.huawei.android.hicloud.agd.ads.RestoreAdAppInfo;
import java.util.List;

/* loaded from: classes5.dex */
public class FileterAdInfoReq extends Request {
    private List<RestoreAdAppInfo> appInfoList;
    private String requestId;

    public FileterAdInfoReq(String str) {
        super("filterAdInfo");
        this.requestId = str;
    }

    public List<RestoreAdAppInfo> getAppInfoList() {
        return this.appInfoList;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setAppInfoList(List<RestoreAdAppInfo> list) {
        this.appInfoList = list;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }
}
