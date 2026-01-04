package com.huawei.hicloud.request.basic.bean;

import java.util.List;

/* loaded from: classes6.dex */
public class GetDeviceSwitchReqNoSwParam extends BasicBaseReq {
    private DeviceSwitchInfo deviceInfo;

    public GetDeviceSwitchReqNoSwParam(DeviceSwitchInfo deviceSwitchInfo, List<String> list) {
        super("getDeviceSwitch");
        this.deviceInfo = deviceSwitchInfo;
    }

    public DeviceSwitchInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    public void setDeviceInfo(DeviceSwitchInfo deviceSwitchInfo) {
        this.deviceInfo = deviceSwitchInfo;
    }
}
