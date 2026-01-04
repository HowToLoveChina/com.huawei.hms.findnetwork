package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import ni.C11707b;

/* loaded from: classes6.dex */
public class AppSizeInfoList extends C11707b {

    @InterfaceC4648p
    private List<AppSizeInfo> appSizeInfo;

    @InterfaceC4648p
    private String nextCursor;

    public List<AppSizeInfo> getAppSizeInfo() {
        return this.appSizeInfo;
    }

    public String getNextCursor() {
        return this.nextCursor;
    }

    public AppSizeInfoList setAppSizeInfo(List<AppSizeInfo> list) {
        this.appSizeInfo = list;
        return this;
    }

    public AppSizeInfoList setNextCursor(String str) {
        this.nextCursor = str;
        return this;
    }
}
