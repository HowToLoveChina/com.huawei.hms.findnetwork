package com.huawei.hicloud.request.cbs.bean;

import java.util.List;

/* loaded from: classes6.dex */
public class CBSDevCountResp extends CBSBaseResp {
    List<CBSDevCount> countRet;
    List<CBSDevice> deviceList;

    public List<CBSDevCount> getCountRet() {
        return this.countRet;
    }

    public List<CBSDevice> getNotQuaryDeviceList() {
        return this.deviceList;
    }

    public void setCountRet(List<CBSDevCount> list) {
        this.countRet = list;
    }

    public void setNotQuaryDeviceList(List<CBSDevice> list) {
        this.deviceList = list;
    }
}
