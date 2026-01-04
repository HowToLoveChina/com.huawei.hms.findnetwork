package com.huawei.hms.support.hwid.bean;

/* loaded from: classes8.dex */
public class CheckPasswordByUserIdReq {
    private String accountType;
    private String appId;
    private String deviceId;
    private String deviceId2;
    private String deviceType;
    private String guardianUserID;
    private String packageName;
    private String password;
    private int siteId;
    private String userId;

    public CheckPasswordByUserIdReq(String str, String str2, String str3, String str4, int i10, String str5, String str6, String str7, String str8, String str9) {
        this.packageName = str;
        this.userId = str2;
        this.password = str3;
        this.accountType = str4;
        this.siteId = i10;
        this.appId = str5;
        this.guardianUserID = str6;
        this.deviceId = str7;
        this.deviceId2 = str8;
        this.deviceType = str9;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getDeviceId2() {
        return this.deviceId2;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public String getGuardianUserID() {
        return this.guardianUserID;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getPassword() {
        return this.password;
    }

    public int getSiteId() {
        return this.siteId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setAccountType(String str) {
        this.accountType = str;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setDeviceId2(String str) {
        this.deviceId2 = str;
    }

    public void setDeviceType(String str) {
        this.deviceType = str;
    }

    public void setGuardianUserID(String str) {
        this.guardianUserID = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setSiteId(int i10) {
        this.siteId = i10;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String toString() {
        return "CheckPasswordByUserIdReq{packageName='" + this.packageName + "', userId='" + this.userId + "', password='" + this.password + "', accountType='" + this.accountType + "', deviceId='" + this.deviceId + "', deviceId2='" + this.deviceId2 + "', deviceType='" + this.deviceType + "', appId='" + this.appId + "', guardianUserID='" + this.guardianUserID + "', siteId=" + this.siteId + '}';
    }

    public CheckPasswordByUserIdReq() {
        this.packageName = "";
        this.userId = "";
        this.password = "";
        this.accountType = "";
        this.appId = "";
        this.guardianUserID = "";
        this.deviceId = "";
        this.deviceId2 = "";
        this.deviceType = "";
    }
}
