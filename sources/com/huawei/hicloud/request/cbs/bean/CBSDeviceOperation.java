package com.huawei.hicloud.request.cbs.bean;

import java.util.List;

/* loaded from: classes6.dex */
public class CBSDeviceOperation extends CBSOperation {
    private CBSDevice device;
    private List<CBSOperation> oprations;

    public CBSDevice getDevice() {
        return this.device;
    }

    public List<CBSOperation> getOprations() {
        return this.oprations;
    }

    public void setDevice(CBSDevice cBSDevice) {
        this.device = cBSDevice;
    }

    public void setOprations(List<CBSOperation> list) {
        this.oprations = list;
    }
}
