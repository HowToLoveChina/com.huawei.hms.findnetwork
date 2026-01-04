package com.huawei.hicloud.base.drive.user.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes6.dex */
public final class UsersListRequest extends C11707b {

    @InterfaceC4648p
    private String queryParam;

    public String getQueryParam() {
        return this.queryParam;
    }

    public UsersListRequest setQueryParam(String str) {
        this.queryParam = str;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public UsersListRequest set(String str, Object obj) {
        return (UsersListRequest) super.set(str, obj);
    }
}
