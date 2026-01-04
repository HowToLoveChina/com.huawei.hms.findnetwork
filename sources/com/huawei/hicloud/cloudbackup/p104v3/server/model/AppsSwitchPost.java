package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes6.dex */
public class AppsSwitchPost extends C11707b {

    @InterfaceC4648p
    private Map<String, Object> deviceSwitch;

    public Map<String, Object> getDeviceSwitch() {
        return this.deviceSwitch;
    }

    public AppsSwitchPost setDeviceSwitch(Map<String, Object> map) {
        this.deviceSwitch = map;
        return this;
    }
}
