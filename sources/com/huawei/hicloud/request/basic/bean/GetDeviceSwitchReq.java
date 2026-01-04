package com.huawei.hicloud.request.basic.bean;

import java.util.List;

/* loaded from: classes6.dex */
public class GetDeviceSwitchReq extends BasicBaseReq {
    private DeviceSwitchInfo deviceInfo;
    private List<String> swNameList;

    public GetDeviceSwitchReq(DeviceSwitchInfo deviceSwitchInfo, List<String> list) {
        super("getDeviceSwitch");
        this.deviceInfo = deviceSwitchInfo;
        this.swNameList = list;
    }

    public DeviceSwitchInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    public List<String> getSwNameList() {
        return this.swNameList;
    }

    public void setDeviceInfo(DeviceSwitchInfo deviceSwitchInfo) {
        this.deviceInfo = deviceSwitchInfo;
    }

    public void setSwNameList(List<String> list) {
        this.swNameList = list;
    }
}
