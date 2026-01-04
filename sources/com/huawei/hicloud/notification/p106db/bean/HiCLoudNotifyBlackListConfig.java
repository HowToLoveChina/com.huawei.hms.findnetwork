package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.android.hicloud.clouddisk.logic.calllogs.CallLogCons;

/* loaded from: classes6.dex */
public class HiCLoudNotifyBlackListConfig {

    @SerializedName("configurations")
    private NotifyBlackListConfig configurations;

    @SerializedName(CallLogCons.DATE)
    private String date;

    /* renamed from: id */
    @SerializedName("id")
    private String f22647id;

    @SerializedName("version")
    private long version;

    public NotifyBlackListConfig getConfigurations() {
        return this.configurations;
    }

    public String getDate() {
        return this.date;
    }

    public String getId() {
        return this.f22647id;
    }

    public long getVersion() {
        return this.version;
    }

    public void setConfigurations(NotifyBlackListConfig notifyBlackListConfig) {
        this.configurations = notifyBlackListConfig;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setId(String str) {
        this.f22647id = str;
    }

    public void setVersion(long j10) {
        this.version = j10;
    }
}
