package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes6.dex */
public class ScanLost extends C11707b {

    @InterfaceC4648p
    private String targetDeviceId;

    @InterfaceC4648p
    private String type;

    public String getTargetDeviceId() {
        return this.targetDeviceId;
    }

    public String getType() {
        return this.type;
    }

    public ScanLost setTargetDeviceId(String str) {
        this.targetDeviceId = str;
        return this;
    }

    public ScanLost setType(String str) {
        this.type = str;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public ScanLost set(String str, Object obj) {
        return (ScanLost) super.set(str, obj);
    }
}
