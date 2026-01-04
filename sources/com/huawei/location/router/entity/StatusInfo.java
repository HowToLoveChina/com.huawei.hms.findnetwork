package com.huawei.location.router.entity;

/* loaded from: classes8.dex */
public class StatusInfo {
    private final int errorCode;
    private final String errorMessage;
    private final int statusCode;

    public StatusInfo(int i10, int i11, String str) {
        this.statusCode = i10;
        this.errorCode = i11;
        this.errorMessage = str;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}
