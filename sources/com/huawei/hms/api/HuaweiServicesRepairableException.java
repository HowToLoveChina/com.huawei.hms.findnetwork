package com.huawei.hms.api;

import android.content.Intent;

/* loaded from: classes8.dex */
public class HuaweiServicesRepairableException extends UserRecoverableException {
    private final int statusCode;

    public HuaweiServicesRepairableException(int i10, String str, Intent intent) {
        super(str, intent);
        this.statusCode = i10;
    }

    public int getConnectionStatusCode() {
        return this.statusCode;
    }
}
