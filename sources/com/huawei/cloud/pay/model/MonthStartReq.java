package com.huawei.cloud.pay.model;

import android.os.Build;

/* loaded from: classes5.dex */
public class MonthStartReq extends Request {
    private String country;
    private String deviceCode;

    public MonthStartReq(String str) {
        super("startMonthPay");
        this.country = str;
        this.deviceCode = Build.MODEL;
    }

    public String getCountry() {
        return this.country;
    }

    public String getDeviceCode() {
        return this.deviceCode;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setDeviceCode(String str) {
        this.deviceCode = str;
    }
}
