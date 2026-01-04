package com.huawei.hicloud.cloudbackup.server.model;

import com.huawei.hicloud.request.cbs.bean.CBSDevice;
import java.util.List;

/* loaded from: classes6.dex */
public class DeviceDeleteListResp extends BaseResponse {
    private List<CBSDevice> devices;

    public List<CBSDevice> getDevices() {
        return this.devices;
    }

    public void setDevices(List<CBSDevice> list) {
        this.devices = list;
    }
}
