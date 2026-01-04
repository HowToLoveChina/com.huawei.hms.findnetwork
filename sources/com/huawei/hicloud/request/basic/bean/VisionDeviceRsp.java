package com.huawei.hicloud.request.basic.bean;

import com.huawei.hicloud.bean.BasicBaseResp;
import java.util.List;

/* loaded from: classes6.dex */
public class VisionDeviceRsp extends BasicBaseResp {
    private List<VisionDeviceInfo> deviceList;

    public List<VisionDeviceInfo> getDeviceList() {
        return this.deviceList;
    }

    public void setDeviceList(List<VisionDeviceInfo> list) {
        this.deviceList = list;
    }
}
