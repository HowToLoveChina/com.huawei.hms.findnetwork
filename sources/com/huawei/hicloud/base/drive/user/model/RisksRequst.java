package com.huawei.hicloud.base.drive.user.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes6.dex */
public class RisksRequst extends C11707b {

    @InterfaceC4648p
    private String reason;

    @InterfaceC4648p
    private String type;

    public String getReason() {
        return this.reason;
    }

    public String getType() {
        return this.type;
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public RisksRequst set(String str, Object obj) {
        return (RisksRequst) super.set(str, obj);
    }
}
