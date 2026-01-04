package com.huawei.hicloud.notification.spacelanguage.bean;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.huawei.android.hicloud.clouddisk.logic.calllogs.CallLogCons;

/* loaded from: classes6.dex */
public class SpaceMultLanguageConfig {

    @SerializedName("configurations")
    private Configurations configurations;

    @SerializedName(CallLogCons.DATE)
    private String date;

    /* renamed from: id */
    @SerializedName("id")
    private String f22680id;

    @SerializedName("version")
    private String version;

    public Configurations getConfigurations() {
        return this.configurations;
    }

    public String getDate() {
        return this.date;
    }

    public String getId() {
        return this.f22680id;
    }

    public String getVersion() {
        return this.version;
    }

    public void setConfigurations(Configurations configurations) {
        this.configurations = configurations;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setId(String str) {
        this.f22680id = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
