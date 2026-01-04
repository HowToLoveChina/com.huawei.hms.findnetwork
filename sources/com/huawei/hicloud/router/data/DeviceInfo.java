package com.huawei.hicloud.router.data;

import java.io.Serializable;
import java.util.UUID;

/* loaded from: classes.dex */
public class DeviceInfo implements Serializable {
    private static final long serialVersionUID = 1;
    public String deviceAliasName;
    public UUID uuid;

    public String getDeviceAliasName() {
        return this.deviceAliasName;
    }

    public void setDeviceAliasName(String str) {
        this.deviceAliasName = str;
    }
}
