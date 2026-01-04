package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes6.dex */
public class DeviceCreate extends C11707b {

    @InterfaceC4648p
    private C4644l createTime;

    @InterfaceC4648p
    private String devicePathName;

    @InterfaceC4648p
    private Map<String, String> properties;

    public C4644l getCreateTime() {
        return this.createTime;
    }

    public String getDevicePathName() {
        return this.devicePathName;
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public DeviceCreate setCreateTime(C4644l c4644l) {
        this.createTime = c4644l;
        return this;
    }

    public DeviceCreate setDevicePathName(String str) {
        this.devicePathName = str;
        return this;
    }

    public DeviceCreate setProperties(Map<String, String> map) {
        this.properties = map;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public DeviceCreate set(String str, Object obj) {
        return (DeviceCreate) super.set(str, obj);
    }
}
