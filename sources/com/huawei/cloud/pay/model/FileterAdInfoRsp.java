package com.huawei.cloud.pay.model;

import com.huawei.android.hicloud.agd.ads.RestoreAdAppInfo;
import java.util.List;

/* loaded from: classes5.dex */
public class FileterAdInfoRsp extends Response {
    private List<RestoreAdAppInfo> appInfoList;

    public List<RestoreAdAppInfo> getAppInfoList() {
        return this.appInfoList;
    }

    public void setAppInfoList(List<RestoreAdAppInfo> list) {
        this.appInfoList = list;
    }
}
