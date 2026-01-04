package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import ni.C11707b;

/* loaded from: classes6.dex */
public class AppSwitchStatusInfoList extends C11707b {

    @InterfaceC4648p
    private List<AppSwitchStatusInfo> appSwitchStatusInfos;

    @InterfaceC4648p
    private String nextCursor;

    public List<AppSwitchStatusInfo> getAppSwitchStatusInfos() {
        return this.appSwitchStatusInfos;
    }

    public String getNextCursor() {
        return this.nextCursor;
    }

    public AppSwitchStatusInfoList setAppSwitchStatusInfos(List<AppSwitchStatusInfo> list) {
        this.appSwitchStatusInfos = list;
        return this;
    }

    public AppSwitchStatusInfoList setNextCursor(String str) {
        this.nextCursor = str;
        return this;
    }
}
