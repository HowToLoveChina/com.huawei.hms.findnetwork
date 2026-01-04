package com.huawei.hicloud.request.cbs.bean;

import java.util.List;

/* loaded from: classes6.dex */
public class CBSDeviceResp extends CBSBaseResp {
    List<CBSDevice> deviceList;

    public List<CBSDevice> getDeviceList() {
        return this.deviceList;
    }

    public void setDeviceList(List<CBSDevice> list) {
        this.deviceList = list;
    }
}
