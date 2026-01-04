package com.huawei.hicloud.request.basic.bean;

import com.huawei.hicloud.bean.BasicBaseResp;
import java.util.List;

/* loaded from: classes6.dex */
public class CBSAllDevicesRsp extends BasicBaseResp {
    private List<CBSSyncRecordDeviceInfo> deviceList;

    public List<CBSSyncRecordDeviceInfo> getDeviceList() {
        return this.deviceList;
    }

    public void setDeviceList(List<CBSSyncRecordDeviceInfo> list) {
        this.deviceList = list;
    }
}
