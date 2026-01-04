package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.huawei.android.hicloud.clouddisk.logic.calllogs.CallLogCons;

/* loaded from: classes6.dex */
public class HicloudPushGuideConfig {

    @SerializedName("configurations")
    private HicloudPushGuideConfigurations configurations;

    @SerializedName(CallLogCons.DATE)
    private String date;

    /* renamed from: id */
    @SerializedName("id")
    private String f22653id;

    @SerializedName("version")
    private String version;

    public HicloudPushGuideConfigurations getConfigurations() {
        return this.configurations;
    }

    public String getDate() {
        return this.date;
    }

    public String getId() {
        return this.f22653id;
    }

    public String getVersion() {
        return this.version;
    }

    public void setConfigurations(HicloudPushGuideConfigurations hicloudPushGuideConfigurations) {
        this.configurations = hicloudPushGuideConfigurations;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setId(String str) {
        this.f22653id = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
