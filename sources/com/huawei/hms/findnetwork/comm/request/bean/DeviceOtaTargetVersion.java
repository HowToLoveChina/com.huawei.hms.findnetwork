package com.huawei.hms.findnetwork.comm.request.bean;

/* loaded from: classes8.dex */
public class DeviceOtaTargetVersion {
    private String description;
    private boolean needUpgrade;

    /* renamed from: sn */
    private String f24735sn;
    private String targetVersion;

    public String getDescription() {
        return this.description;
    }

    public String getSn() {
        return this.f24735sn;
    }

    public String getTargetVersion() {
        return this.targetVersion;
    }

    public boolean isNeedUpgrade() {
        return this.needUpgrade;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setNeedUpgrade(boolean z10) {
        this.needUpgrade = z10;
    }

    public void setSn(String str) {
        this.f24735sn = str;
    }

    public void setTargetVersion(String str) {
        this.targetVersion = str;
    }
}
