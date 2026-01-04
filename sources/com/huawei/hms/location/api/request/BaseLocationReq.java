package com.huawei.hms.location.api.request;

import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes8.dex */
public class BaseLocationReq {

    @Packed
    private String locTransactionId;

    @Packed
    private String packageName;

    public String getLocTransactionId() {
        return this.locTransactionId;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setLocTransactionId(String str) {
        this.locTransactionId = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }
}
