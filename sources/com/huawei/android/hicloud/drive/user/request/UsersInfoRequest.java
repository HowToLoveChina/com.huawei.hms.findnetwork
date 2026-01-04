package com.huawei.android.hicloud.drive.user.request;

import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes3.dex */
public class UsersInfoRequest extends C11707b {

    @InterfaceC4648p
    private String queryParam;

    public String getQueryParam() {
        return this.queryParam;
    }

    public UsersInfoRequest setQueryParam(String str) {
        this.queryParam = str;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public UsersInfoRequest set(String str, Object obj) {
        return (UsersInfoRequest) super.set(str, obj);
    }
}
