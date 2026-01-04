package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import ni.C11707b;

/* loaded from: classes6.dex */
public class DeviceList extends C11707b {

    @InterfaceC4648p
    private List<Device> devices;

    @InterfaceC4648p
    private String nextCursor;

    public List<Device> getDevices() {
        return this.devices;
    }

    public String getNextCursor() {
        return this.nextCursor;
    }

    public DeviceList setDevices(List<Device> list) {
        this.devices = list;
        return this;
    }

    public DeviceList setNextCursor(String str) {
        this.nextCursor = str;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public DeviceList set(String str, Object obj) {
        return (DeviceList) super.set(str, obj);
    }
}
