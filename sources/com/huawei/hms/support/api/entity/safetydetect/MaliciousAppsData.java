package com.huawei.hms.support.api.entity.safetydetect;

import org.json.JSONObject;

/* loaded from: classes8.dex */
public class MaliciousAppsData {
    private int apkCategory;
    private String apkPackageName;
    private String apkSha256;

    public MaliciousAppsData(String str) {
        JSONObject jSONObject = new JSONObject(str);
        this.apkPackageName = jSONObject.optString("apkPackageName");
        this.apkCategory = jSONObject.optInt("apkCategory");
        this.apkSha256 = jSONObject.optString("apkSha256");
    }

    public int getApkCategory() {
        return this.apkCategory;
    }

    public String getApkPackageName() {
        return this.apkPackageName;
    }

    public String getApkSha256() {
        return this.apkSha256;
    }

    public void setApkCategory(int i10) {
        this.apkCategory = i10;
    }

    public void setApkPackageName(String str) {
        this.apkPackageName = str;
    }

    public void setApkSha256(String str) {
        this.apkSha256 = str;
    }

    public String toString() {
        return "MaliciousAppsData{apkPackageName='" + this.apkPackageName + "', apkCategory=" + this.apkCategory + ", apkSha256='" + this.apkSha256 + "'}";
    }
}
