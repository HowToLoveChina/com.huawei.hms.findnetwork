package com.huawei.hicloud.request.cbs.bean;

import java.util.List;

/* loaded from: classes6.dex */
public class CBSDeviceRecordsRsp extends CBSBaseResp {
    private List<CBSDeviceOperation> deviceOperations;

    public List<CBSDeviceOperation> getDeviceOperations() {
        return this.deviceOperations;
    }

    public void setDeviceOperations(List<CBSDeviceOperation> list) {
        this.deviceOperations = list;
    }
}
