package com.huawei.cloud.pay.model;

import android.os.Build;

/* loaded from: classes5.dex */
public class GetPackageReq extends Request {
    private String country;
    private String deviceCode;

    public GetPackageReq() {
        super("getActivePackages");
        this.country = "CN";
        this.deviceCode = Build.MODEL;
        this.country = "CN";
    }

    public String getCountry() {
        return this.country;
    }

    public String getDeviceCode() {
        return this.deviceCode;
    }

    public GetPackageReq(String str) {
        super("getActivePackages");
        this.country = "CN";
        String str2 = Build.MODEL;
        this.deviceCode = str2;
        if (str != null && !str.isEmpty()) {
            this.country = str;
        }
        this.deviceCode = str2;
    }
}
