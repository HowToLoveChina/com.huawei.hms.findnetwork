package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.android.hicloud.clouddisk.logic.calllogs.CallLogCons;
import java.util.List;

/* loaded from: classes6.dex */
public class ForcedUpgradeConfig {

    @SerializedName("configurations")
    private List<ForceUpgradeConfiguration> configurations;

    @SerializedName(CallLogCons.DATE)
    private String date;

    /* renamed from: id */
    @SerializedName("id")
    private String f22645id;

    @SerializedName("version")
    private String version;

    public List<ForceUpgradeConfiguration> getConfigurations() {
        return this.configurations;
    }

    public String getDate() {
        return this.date;
    }

    public String getId() {
        return this.f22645id;
    }

    public String getVersion() {
        return this.version;
    }

    public void setConfigurations(List<ForceUpgradeConfiguration> list) {
        this.configurations = list;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setId(String str) {
        this.f22645id = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
