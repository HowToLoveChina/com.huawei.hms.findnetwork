package com.huawei.android.hicloud.cloudbackup.bean;

import java.util.List;

/* loaded from: classes2.dex */
public class ThermalDevices {
    public List<String> devices;
    public int policyId;

    public List<String> getDevices() {
        return this.devices;
    }

    public int getPolicyId() {
        return this.policyId;
    }

    public void setDevices(List<String> list) {
        this.devices = list;
    }

    public void setPolicyId(int i10) {
        this.policyId = i10;
    }
}
