package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class UrgencyNotice {

    @SerializedName("AppConfig")
    private UrgencyAppConfig appConfig;

    public UrgencyAppConfig getAppConfig() {
        return this.appConfig;
    }

    public void setAppConfig(UrgencyAppConfig urgencyAppConfig) {
        this.appConfig = urgencyAppConfig;
    }
}
