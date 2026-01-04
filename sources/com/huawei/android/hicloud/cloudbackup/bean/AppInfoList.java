package com.huawei.android.hicloud.cloudbackup.bean;

import com.google.gson.Gson;
import p618rm.C12540b1;

/* loaded from: classes2.dex */
public class AppInfoList {
    private AppIcon appIcon;
    private String appId;
    private String appName;
    private int appType;
    private CloudBackup cloudBackup;

    /* renamed from: id */
    private String f11652id;
    private int minClientVersion;
    private int priority;
    private int skipWhenInsuff;

    public AppIcon getAppIcon() {
        AppIcon appIcon = this.appIcon;
        return appIcon == null ? new AppIcon() : appIcon;
    }

    public String getAppIconStr() {
        return new Gson().toJson(getAppIcon());
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppName() {
        String str = this.appName;
        return str == null ? "" : str;
    }

    public int getAppType() {
        return this.appType;
    }

    public CloudBackup getCloudBackup() {
        return this.cloudBackup;
    }

    public String getId() {
        return this.f11652id;
    }

    public boolean getIsSkipWhenInsuff() {
        return this.skipWhenInsuff == 1;
    }

    public int getMinClientVersion() {
        return this.minClientVersion;
    }

    public int getPriority() {
        return this.priority;
    }

    public int getSkipWhenInsuff() {
        return this.skipWhenInsuff;
    }

    public void setAppIcon(String str) {
        this.appIcon = (AppIcon) C12540b1.m75483a(str, AppIcon.class);
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setAppType(int i10) {
        this.appType = i10;
    }

    public void setCloudBackup(CloudBackup cloudBackup) {
        this.cloudBackup = cloudBackup;
    }

    public void setId(String str) {
        this.f11652id = str;
    }

    public void setMinClientVersion(int i10) {
        this.minClientVersion = i10;
    }

    public void setPriority(int i10) {
        this.priority = i10;
    }

    public void setSkipWhenInsuff(int i10) {
        this.skipWhenInsuff = i10;
    }

    public String toString() {
        return "AppInfoList{id='" + this.f11652id + "', appId='" + this.appId + "', cloudBackup=" + this.cloudBackup + "', skipWhenInsuff='" + this.skipWhenInsuff + "', minClientVersion='" + this.minClientVersion + "', priority='" + this.priority + '}';
    }
}
