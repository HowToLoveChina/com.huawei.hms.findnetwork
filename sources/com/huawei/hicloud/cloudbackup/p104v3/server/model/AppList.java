package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import ni.C11707b;

/* loaded from: classes6.dex */
public class AppList extends C11707b {

    @InterfaceC4648p
    private List<App> apps;

    @InterfaceC4648p
    private String nextCursor;

    public List<App> getApps() {
        return this.apps;
    }

    public String getNextCursor() {
        return this.nextCursor;
    }

    public AppList setApps(List<App> list) {
        this.apps = list;
        return this;
    }

    public AppList setNextCursor(String str) {
        this.nextCursor = str;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public AppList set(String str, Object obj) {
        return (AppList) super.set(str, obj);
    }
}
