package com.huawei.android.hicloud.cloudbackup.bean;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class RestoreConfig {
    private List<AppVer> appVer;
    private List<String> appVersRegex;
    private List<RestoreExclude> exclude;

    /* renamed from: id */
    private String f11659id = "";
    private String appId = "";
    private String data = "";

    public String getAppId() {
        return this.appId;
    }

    public List<AppVer> getAppVer() {
        List<AppVer> list = this.appVer;
        return list == null ? new ArrayList() : list;
    }

    public List<String> getAppVersRegex() {
        List<String> list = this.appVersRegex;
        return list == null ? new ArrayList() : list;
    }

    public String getData() {
        String str = this.data;
        return str == null ? "" : str;
    }

    public List<RestoreExclude> getExclude() {
        List<RestoreExclude> list = this.exclude;
        return list == null ? new ArrayList() : list;
    }

    public String getId() {
        return this.f11659id;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setAppVer(List<AppVer> list) {
        this.appVer = list;
    }

    public void setAppVersRegex(List<String> list) {
        this.appVersRegex = list;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setExclude(List<RestoreExclude> list) {
        this.exclude = list;
    }

    public void setId(String str) {
        this.f11659id = str;
    }

    public String toString() {
        return "RestoreConfig{id='" + this.f11659id + "', appId='" + this.appId + "', appVer=" + this.appVer + ", appVersRegex=" + this.appVersRegex + ", exclude=" + this.exclude + ", data='" + this.data + "'}";
    }
}
