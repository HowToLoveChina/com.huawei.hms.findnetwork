package com.huawei.android.hicloud.cbs.bean;

import com.google.gson.Gson;

/* loaded from: classes2.dex */
public class BasicDeviceSwitchInfo {
    private String appVersion;
    private String devDisplayName;
    private String deviceId;
    private int deviceType;
    private String displayLabel;
    private String displayLocation;
    private String emuiVersion;
    private String lastUpdataTime;
    private String swName;
    private String swStatus;
    private String terminalType;

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getDevDisplayName() {
        return this.devDisplayName;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public String getDeviceeId() {
        return this.deviceId;
    }

    public String getDisplayLabel() {
        return this.displayLabel;
    }

    public String getDisplayLocation() {
        return this.displayLocation;
    }

    public String getEmuiVersion() {
        return this.emuiVersion;
    }

    public String getLastUpdataTime() {
        return this.lastUpdataTime;
    }

    public String getSwName() {
        return this.swName;
    }

    public String getSwStatus() {
        return this.swStatus;
    }

    public String getTerminalType() {
        return this.terminalType;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setDevDisplayName(String str) {
        this.devDisplayName = str;
    }

    public void setDeviceType(int i10) {
        this.deviceType = i10;
    }

    public void setDeviceeId(String str) {
        this.deviceId = str;
    }

    public void setDisplayLabel(String str) {
        this.displayLabel = str;
    }

    public void setDisplayLocation(String str) {
        this.displayLocation = str;
    }

    public void setEmuiVersion(String str) {
        this.emuiVersion = str;
    }

    public void setLastUpdataTime(String str) {
        this.lastUpdataTime = str;
    }

    public void setSwName(String str) {
        this.swName = str;
    }

    public void setSwStatus(String str) {
        this.swStatus = str;
    }

    public void setTerminalType(String str) {
        this.terminalType = str;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
