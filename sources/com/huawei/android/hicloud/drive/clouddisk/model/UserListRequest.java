package com.huawei.android.hicloud.drive.clouddisk.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes3.dex */
public class UserListRequest extends C11707b {

    @InterfaceC4648p
    private String queryParam;

    public String getQueryParam() {
        return this.queryParam;
    }

    public UserListRequest setQueryParam(String str) {
        this.queryParam = str;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public UserListRequest set(String str, Object obj) {
        return (UserListRequest) super.set(str, obj);
    }
}
