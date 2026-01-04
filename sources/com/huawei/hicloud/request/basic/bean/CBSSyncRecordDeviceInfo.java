package com.huawei.hicloud.request.basic.bean;

import com.google.gson.Gson;

/* loaded from: classes6.dex */
public class CBSSyncRecordDeviceInfo {
    private String aliasName;
    private String appVersion;
    private String devDisplayName;
    private String deviceAliasName;
    private String deviceId;
    private int deviceType;
    private String emuiVersion;
    private String logoutTime;
    private String pushToken;
    private String terminalType;

    public CBSSyncRecordDeviceInfo(String str, int i10) {
        this.deviceId = str;
        this.deviceType = i10;
    }

    public String getAliasName() {
        return this.aliasName;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getDevDisplayName() {
        return this.devDisplayName;
    }

    public String getDeviceAliasName() {
        return this.deviceAliasName;
    }

    public String getDeviceID() {
        return this.deviceId;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public String getEmuiVersion() {
        return this.emuiVersion;
    }

    public String getLogoutTime() {
        return this.logoutTime;
    }

    public String getPushToken() {
        return this.pushToken;
    }

    public String getTerminalType() {
        return this.terminalType;
    }

    public void setAliasName(String str) {
        this.aliasName = str;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setDevDisplayName(String str) {
        this.devDisplayName = str;
    }

    public void setDeviceAliasName(String str) {
        this.deviceAliasName = str;
    }

    public void setDeviceID(String str) {
        this.deviceId = str;
    }

    public void setDeviceType(int i10) {
        this.deviceType = i10;
    }

    public void setEmuiVersion(String str) {
        this.emuiVersion = str;
    }

    public void setLogoutTime(String str) {
        this.logoutTime = str;
    }

    public void setPushToken(String str) {
        this.pushToken = str;
    }

    public void setTerminalType(String str) {
        this.terminalType = str;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
