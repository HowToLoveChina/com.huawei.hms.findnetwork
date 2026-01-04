package com.huawei.cloud.pay.model;

import android.os.Build;

/* loaded from: classes5.dex */
public class GetPackagesBySpaceReq extends Request {
    private String clientVer;
    private String country;
    private String deviceCode;
    private long spaceNeeded;

    public GetPackagesBySpaceReq(String str, long j10) {
        super("getPackagesBySpace");
        this.country = str;
        this.spaceNeeded = j10;
        this.deviceCode = Build.MODEL;
        this.clientVer = "2";
    }

    public String getClientVer() {
        return this.clientVer;
    }

    public String getCountry() {
        return this.country;
    }

    public String getDeviceCode() {
        return this.deviceCode;
    }

    public long getSpaceNeeded() {
        return this.spaceNeeded;
    }

    public void setClientVer(String str) {
        this.clientVer = str;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setDeviceCode(String str) {
        this.deviceCode = str;
    }

    public void setSpaceNeeded(long j10) {
        this.spaceNeeded = j10;
    }
}
