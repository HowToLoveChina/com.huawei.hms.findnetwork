package com.huawei.hicloud.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: classes6.dex */
public class HonorAppUpgradeInfo {

    @SerializedName("checkInterval")
    private String checkInterval;

    @SerializedName("maxRemindingTimes")
    private int maxRemindingTimes;

    @SerializedName("versions")
    private List<HonorVersionInfo> versions;

    public String getCheckInterval() {
        return this.checkInterval;
    }

    public int getMaxRemindingTimes() {
        return this.maxRemindingTimes;
    }

    public List<HonorVersionInfo> getVersions() {
        return this.versions;
    }

    public void setCheckInterval(String str) {
        this.checkInterval = str;
    }

    public void setMaxRemindingTimes(int i10) {
        this.maxRemindingTimes = i10;
    }

    public void setVersions(List<HonorVersionInfo> list) {
        this.versions = list;
    }
}
