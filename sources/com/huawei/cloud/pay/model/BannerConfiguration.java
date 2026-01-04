package com.huawei.cloud.pay.model;

import java.util.List;

/* loaded from: classes5.dex */
public class BannerConfiguration {
    private List<BannerParams> configurations;
    private String date;

    /* renamed from: id */
    private String f21394id;
    private String version;

    public List<BannerParams> getConfigurations() {
        return this.configurations;
    }

    public String getDate() {
        return this.date;
    }

    public String getId() {
        return this.f21394id;
    }

    public String getVersion() {
        return this.version;
    }

    public void setConfigurations(List<BannerParams> list) {
        this.configurations = list;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setId(String str) {
        this.f21394id = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
